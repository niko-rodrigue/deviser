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

from util import strFunctions, query, global_variables, jsbmlHelperFunctions
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


        # class_attributes not suitable
        # self.attributes = class_object['class_attributes']
        self.attributes = class_object['attribs']

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

        self.write_order = self.determine_mandatory_methods()


    ########################################################################


    # TODO GSOC 2016 determine mandatory methods to write
    def determine_mandatory_methods(self, function='Mandatory'):
        for key in list(self.jsbml_methods.keys()):
            for method in self.jsbml_methods[key]:
                if function in method['functionName']:
                    function_name = str(method['functionName'])[:]
                    if 'Id' in function_name or 'Name' in function_name:
                        self.mandatory_data.update({method['functionName']: [method]})

        #
        # # TODO fix bug no need isCompartment
        for attribute in self.attributes:

            att_type = attribute['attType']
            if att_type == 'lo_element':
                att_name = attribute['attTypeCode']
            else:
                att_name = strFunctions.upper_first(attribute['name'])
            method_name_one = str('is{0}Mandatory'.format(att_name))
            method_name_two= str('isSet{0}Mandatory'.format(att_name))
            for key in list(self.mandatory_data.keys()):
                # TODO isSetConstantMandatory
                type = str(attribute['type'])[:]
                if type == 'bool':
                    method_name = method_name_two
                else:
                    method_name = method_name_one
                test_key = str(key)[:]
                test_method = str(method_name)[:]
                att = str(att_name)[:]

                if (test_method == test_key):
                    self.mandatory_data[method_name].append(attribute)
                # here is  the problem but how to fix it
                else: #(test_method != test_key):
                    if test_method not in self.mandatory_data:
                        if att not in ['Id', 'Name']:
                            self.mandatory_data.update({method_name: attribute})

        # #
        # # print('Mandatory Data ', list(self.mandatory_data.keys()))
        return sorted(list(self.mandatory_data.keys()))

    def get_num_attributes(self):
        try:
            #print(self.write_order)
            return len(self.write_order)
        except:
            return 0

    # Functions for writing mandatory




    # GSOC 2016 write_mandatory prototype v0.1
    # function to write mandatory functions
    def write_mandatory(self, is_attribute, index, const=True, virtual=False):
        if not self.is_java_api and not const:
            return
        if is_attribute:
            if index < len(self.write_order):
                attribute_key = self.write_order[index]
            else:
                return

        # # TODO GSOC 2016 JSBML change


        # attribute = self.mandatory_data[attribute_key]

        params = []
        arguments = []
        return_lines = []
        additional = []



        # create the function declaration
        if self.is_java_api:
            function = '{0}'.format(attribute_key)
            return_type = 'boolean'

        # TODO GSOC 2016 FBC bug
        if len(self.mandatory_data[attribute_key]) > 2:
            curr_attribute = self.mandatory_data[attribute_key]
        elif len(self.mandatory_data[attribute_key]) == 2:
            curr_attribute = self.mandatory_data[attribute_key][1]
        else:
            curr_attribute = self.mandatory_data[attribute_key][0]



        try:
            return_value = str(curr_attribute['reqd'])[:]
            if return_value == 'False':
                return_value = 'false'
            else:
                return_value = 'true'
        except Exception as e:
            print('error ',e)
            return_value = 'true'



        title_line = '@return {0}'.format(return_value)

        additional_add = []
        # TODO detect if override or not
        additional_add, class_key, functionArgs= jsbmlHelperFunctions.determine_override_or_deprecated(self.jsbml_methods, attribute_key)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = '(non-Javadoc)--'
            title_line += '@see org.sbml.jsbml.{0}#{1}'.format(class_key, function)


        if self.is_java_api:
            implement_string = ['return {0}'.format(return_value)]
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
