#!/usr/bin/env python
#
# @file    MandatoryFunctions.py
# @brief   class to create functions to get/set attributes/elements
# @author  GSOC 2016 Hovakim Grabski
#
# <!--------------------------------------------------------------------------
#
# Copyright (c) 2013-2015 by the California Institute of Technology
# (California, USA), the European Bioinformatics Institute (EMBL-EBI, UK)
# and the University of Heidelberg (Germany), with support from the National
# Institutes of Health (USA) under grant R01GM070923.  All rights reserved.
#
# Permission is hereby granted, free of charge, to any person obtaining a
# copy of this software and associated documentation files (the "Software"),
# to deal in the Software without restriction, including without limitation
# the rights to use, copy, modify, merge, publish, distribute, sublicense,
# and/or sell copies of the Software, and to permit persons to whom the
# Software is furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
# THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
# FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
# DEALINGS IN THE SOFTWARE.
#
# Neither the name of the California Institute of Technology (Caltech), nor
# of the European Bioinformatics Institute (EMBL-EBI), nor of the University
# of Heidelberg, nor the names of any contributors, may be used to endorse
# or promote products derived from this software without specific prior
# written permission.
# ------------------------------------------------------------------------ -->

from util import strFunctions, query, global_variables
import sys


class MandatoryFunctions():
    """Class for all java  functions for mandatory functions"""

    def __init__(self, language, is_java_api, is_list_of, class_object,  jsbml_data_tree=None, jsbml_methods=None):
        self.language = language
        self.cap_language = language.upper()
        self.package = class_object['package']
        self.class_name = class_object['name']
        self.is_java_api = is_java_api
        self.is_list_of = is_list_of
        if is_list_of:
            self.child_name = class_object['lo_child']
        else:
            self.child_name = ''
        if is_java_api:
            self.object_name = self.class_name
            self.object_child_name = self.child_name
        else:
            if is_list_of:
                self.object_name = 'ListOf'  #_t'
            else:
                self.object_name = self.class_name  #+ '_t'
            self.object_child_name = self.child_name  # + '_t'

        self.attributes = class_object['class_attributes']
        self.child_elements = class_object['child_elements']
        if 'num_versions' in class_object and class_object['num_versions'] > 1:
            self.has_multiple_versions = True
        else:
            self.has_multiple_versions = False

        self.document = False
        if 'document' in class_object:
            self.document = class_object['document']

        # useful variables
        if not self.is_java_api and self.is_list_of:
            self.struct_name = self.object_child_name
        else:
            self.struct_name = self.object_name
        if self.is_java_api is False:
            self.true = '@c 1'
            self.false = '@c 0'
        else:
            self.true = '{@code true}'  #For comments
            self.false = '{@code false}'
        self.plural = strFunctions.plural(self.child_name)
        self.indef_name = strFunctions.get_indefinite(self.object_child_name)
        self.abbrev_parent = strFunctions.abbrev_name(self.object_name)
        self.abbrev_child = strFunctions.abbrev_name(self.child_name)
        self.is_header = True
        if 'is_header' in class_object:
            self.is_header = class_object['is_header']
        self.is_plugin = False
        if 'is_plugin' in class_object:
            self.is_plugin = class_object['is_plugin']

        self.open_br = '{'
        self.close_br = '}'

        self.success = global_variables.ret_success
        self.failed = global_variables.ret_failed
        self.invalid_att = global_variables.ret_invalid_att
        self.invalid_obj = global_variables.ret_invalid_obj

        # TODO GSOC 2016 mandatory functions
        if jsbml_data_tree is not None:
            self.jsbml_data_tree = jsbml_data_tree
        if jsbml_methods is not None:
            self.jsbml_methods = jsbml_methods


        self.mandatory_data = {}

        self.determine_mandatory_methods()

    ########################################################################


    # TODO GSOC 2016 determine mandatory methods to write
    def determine_mandatory_methods(self, function='Mandatory'):
        for key in list(self.jsbml_methods.keys()):
            for method in self.jsbml_methods[key]:
                if function in method['functionName']:
                    self.mandatory_data.update({method['functionName']: method})


        # TODO fix bug no need isCompartment
        for attribute in self.attributes:
            att_name = strFunctions.upper_first(attribute['name'])
            method_name = 'is{0}'.format(att_name)
            if method_name not in self.mandatory_data:
                for key in list(self.mandatory_data.keys()):
                    if method_name not in key:
                        if att_name != 'Id' and att_name != 'Name':
                            self.mandatory_data.update({method_name: attribute})

        print('Mandatory Data ', list(self.mandatory_data.keys()))



    # Functions for writing mandatory

    def determine_override_or_deprecated(self, attribute, function, return_type=None,att_type=None):
        # TODO write_set  implementation of return_type definition DONE
        add = None
        class_key = None
        functionArgs = None
        for key in list(self.jsbml_methods.keys()):
            for method in self.jsbml_methods[key]:
                if function == method['functionName']:
                    class_key = key
                    if method['isAbstract'] is True:
                        if att_type is not None and att_type in method['functionArgs']:
                            functionArgs = method['functionArgs']

                        add = 'Override'
        # if attribute['type'] == 'SIdRef':
        #     add = 'Override'
        # else:
        #     add = None
        return add, class_key, functionArgs



    # GSOC 2016 write_mandatory prototype v0.1
    # function to write mandatory functions
    def write_mandatory(self, is_attribute, index, const=True, virtual=False):
        if not self.is_java_api and not const:
            return
        if is_attribute:
            if index < len(self.mandatory_data):
                attribute = self.mandatory_data[index]
                print(attribute.keys())
            else:
                return

        key = list(attribute.keys())[0]
        # # TODO GSOC 2016 JSBML change

        params = []
        arguments = []
        return_lines = []
        additional = []

        if attribute[key]['Override'] is True:
            title_line = '(non-Javadoc)'
        else:
            title_line = '@return {0} '.format(attribute[key]['return'])
            # .format(attribute['name'],
            #         ('attribute' if is_attribute else 'element'),
            #         (self.class_name if self.is_java_api else self.object_name))

        if self.is_java_api:
            return_lines.append('@return {0} '.format(attribute[key]['return']))
                                # .format(attribute['name'],
                                #         ('attribute' if is_attribute
                                #          else 'element'),
                                #         self.class_name,
                                #         (attribute['attType']
                                #          if (is_attribute
                                #              and attribute['isEnum'] is False)
                                #          else attribute['attTypeCode'])))


        # TODO detect if override or not
        additional_add, class_key, functionArgs= self.determine_override_or_deprecated(attribute,function)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = '(non-Javadoc)--'
            title_line += '@see org.sbml.jsbml.{0}#{1}'.format(class_key, function)


        # create the function declaration
        if self.is_java_api:
            function = '{0}'.format(key)
            return_type = attribute[key]['returnType']


        if self.is_java_api:
            if attribute[key]['Override'] is True:
                additional.append('Override')
            implement_string = ['return {0}'.format(attribute[key]['return'])]
            code = [self.create_code_block('line', implement_string)]
        #         else:
        #             if curr_att_type in global_variables.javaTypeAttributes:
        #                 implement_part2 = 'return {0}.{1}Value()'.format(attribute['memberName'], curr_att_type)
        #             else:
        #                 implement_part2 = 'return {0}'.format(attribute['memberName'])
        #             implementation2 = ['isSet{0}()'.format(attribute['capAttName']), implement_part2]
        #             implementation = [
        #                 'throw new PropertyUndefinedError({0}Constants.{1}, this)'.format(self.package,
        #                                                                                   attribute['memberName'])]
        #             code = [dict({'code_type': 'if', 'code': implementation2}),
        #                     dict({'code_type': 'line', 'code': implementation})]
        #     else:
        #         implementation = self.write_get_for_doc_functions(attribute)
        #         code = [self.create_code_block('line', implementation)]  # tricky
        # else:
        #     code = self.get_c_attribute(attribute)


        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': const,
                     'virtual': virtual,
                     'object_name': self.struct_name,
                     'implementation': code})

    # Functions for writing get functions




    @staticmethod
    def create_code_block(code_type, lines):
        code = dict({'code_type': code_type, 'code': lines})
        return code
