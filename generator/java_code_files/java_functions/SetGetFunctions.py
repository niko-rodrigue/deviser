#!/usr/bin/env python
#
# @file    SetGetFunctions.py
# @brief   class to create functions to get/set attributes/elements for java code
# @brief   for Google Summer of Code 2016
# @author  Hovakim Grabski
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

import sys

from util import strFunctions, query, global_variables
from java_utils import jsbmlHelperFunctions


class SetGetFunctions():
    """Class for all java  functions for set/get/isset/unset"""

    def __init__(self, language, is_java_api, is_list_of, class_object,
                 jsbml_data_tree=None, jsbml_methods=None, abstract_jsbml_methods=None):
        self.original_class_object = class_object
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
                self.object_name = 'ListOf'
            else:
                self.object_name = self.class_name
            self.object_child_name = self.child_name

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
            self.true = '{@code true}'  # For comments
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

        # Additional information for java code generation
        if jsbml_data_tree is not None:
            self.jsbml_data_tree = jsbml_data_tree
        if jsbml_methods is not None:
            self.jsbml_methods = jsbml_methods
        if abstract_jsbml_methods is not None:
            self.abstract_jsbml_methods = abstract_jsbml_methods

        # It is for same methods but take different arguments
        # Example QualitativeSpecies has setCompartment(String) and setCompartment(Compartment)
        # from CompartmentalizedSBase
        self.duplicate_methods = []

    ########################################################################

    # Functions for writing get functions


    # function to write get functions
    def write_get(self, is_attribute, index, const=True, virtual=False):
        if not self.is_java_api and not const:
            return
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
            # dont write a get for c
            if not self.is_java_api and (attribute['isArray'] or attribute['isVector']):
                return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return
        if attribute['isArray'] and self.is_java_api:
            return self.write_get_array(index, const)
        # create comment parts

        # if Id and Name then return None
        if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
            return

        code = []
        params = []
        return_lines = []
        additional = []
        title_line = ''  # '@return the {0}'.format(attribute['name'])

        if not self.is_java_api:
            params.append('@param {0} the {1} structure whose {2} is sought.'
                          .format(self.abbrev_parent, self.object_name,
                                  attribute['name']))

        if self.is_java_api:
            return_lines.append('@return the value of the \"{0}\" {1} of '
                                'this {2} as a {3}.'
                                .format(attribute['name'],
                                        ('attribute' if is_attribute
                                         else 'element'),
                                        self.class_name,
                                        (attribute['attType']
                                         if (is_attribute
                                             and attribute['isEnum'] is False)
                                         else attribute['attTypeCode'])))
        else:
            return_lines.append('@return the value of the \"{0}\" {1} of '
                                'this {2} as a {3} {4}.'
                                .format(attribute['name'],
                                        ('attribute' if is_attribute
                                         else 'element'),
                                        self.object_name,
                                        ('pointer to a'
                                         if (is_attribute and
                                             attribute['attType'] == 'string')
                                         else ''),
                                        (attribute['attType']
                                         if (is_attribute
                                             and attribute['isEnum'] is False)
                                         else attribute['attTypeCode'])))

        params = []
        params.append('Returns the value of {{@link {0}}}.'.format(attribute['name']))
        params.append(' ')
        params.append('@return the value of {{@link {0}}}.'.format(attribute['name']))

        # create the function declaration
        if self.is_java_api:
            function = 'get{0}'.format(attribute['capAttName'])
            if attribute['attType'] == 'string' \
                    or attribute['attType'] == 'element':

                return_type = attribute['attTypeCode']
            elif attribute['attType'] == 'enum':

                return_type = attribute['JClassType']
            elif attribute['attType'] == 'vector':
                return_type = 'const {0}&'.format(attribute['attTypeCode'])
            else:
                return_type = attribute['attTypeCode']
        else:
            function = '{0}_get{1}'.format(self.class_name,
                                           attribute['capAttName'])
            if attribute['attType'] == 'element':
                return_type = 'const {0}'.format(attribute['CType'])
            else:
                return_type = '{0}'.format(attribute['CType'])

        # detect if needs to  override
        additional_add, class_key, function_args = jsbmlHelperFunctions. \
            determine_override_or_deprecated(self.jsbml_methods, function, attribute)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add,
                                                                             class_key, function, function_args)

        arguments = []

        # GSOC 2016 modification
        # Need PackageName for Constants, such as QualConstants.initialLevel
        # Also need to add info about the type of Data (boolean or int, or etc)
        # need to use this self.package

        # implementation2 wrong example Output.java -> return transitionEffect;
        # cap_att_name = attribute['capAttName']
        curr_att_type = attribute['attTypeCode']

        # code = [dict({'code_type': 'line', 'code': implementation})]

        # print('type ',curr_att_type)
        # create the function implementation
        if self.is_java_api:
            if not self.document:
                if attribute['name'] == 'math':
                    implement_string = ['return {0}'.format(attribute['name'])]
                    code = [self.create_code_block('line', implement_string)]
                    return_type = 'ASTNode'
                elif curr_att_type == 'String':
                    implement_string = ['return isSet{0}() ? {1} : ""'.format(attribute['capAttName'],
                                                                              attribute['name'])]
                    code = [self.create_code_block('line', implement_string)]
                else:
                    if curr_att_type in global_variables.javaTypeAttributes:
                        implement_part2 = 'return {0}.{1}Value()'.format(attribute['name'], curr_att_type)
                    else:
                        implement_part2 = 'return {0}'.format(attribute['name'])
                    implementation2 = ['isSet{0}()'.format(attribute['capAttName']), implement_part2]
                    implementation = ['throw new PropertyUndefinedError({0}Constants.{1}, this)'.format(self.package,
                                                                                                        attribute[
                                                                                                            'name'])]
                    code = [dict({'code_type': 'if', 'code': implementation2}),
                            dict({'code_type': 'line', 'code': implementation})]
            else:
                implementation = self.write_get_for_doc_functions(attribute)
                code = [self.create_code_block('line', implementation)]  # tricky

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

    def write_get_instance(self, is_attribute, index, const=True, virtual=False):
        if not self.is_java_api and not const:
            return
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
            # dont write a get for c
            if not self.is_java_api and (attribute['isArray'] or attribute['isVector']):
                return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return

        # create comment parts

        # If attribute is ID or Name return None
        if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
            return None

        if attribute['type'] != 'SIdRef':
            return None

        params = []
        return_lines = []
        additional = []
        title_line = '@return the {0}'.format(attribute['name'])

        if not self.is_java_api:
            params.append('@param {0} the {1} structure whose {2} is sought.'
                          .format(self.abbrev_parent, self.object_name,
                                  attribute['name']))

        if self.is_java_api:
            return_lines.append('@return the value of the \"{0}\" {1} of '
                                'this {2} as a {3}.'
                                .format(attribute['name'],
                                        ('attribute' if is_attribute
                                         else 'element'),
                                        self.class_name,
                                        (attribute['attType']
                                         if (is_attribute
                                             and attribute['isEnum'] is False)
                                         else attribute['attTypeCode'])))
        else:
            return_lines.append('@return the value of the \"{0}\" {1} of '
                                'this {2} as a {3} {4}.'
                                .format(attribute['name'],
                                        ('attribute' if is_attribute
                                         else 'element'),
                                        self.object_name,
                                        ('pointer to a'
                                         if (is_attribute and
                                             attribute['attType'] == 'string')
                                         else ''),
                                        (attribute['attType']
                                         if (is_attribute
                                             and attribute['isEnum'] is False)
                                         else attribute['attTypeCode'])))

        # create the function declaration
        if self.is_java_api:
            function = 'get{0}Instance'.format(attribute['capAttName'])
        return_type = attribute['capAttName']

        # check if it needs to be overriden
        additional_add, class_key, functionArgs = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods, function, attribute)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add,
                                                                             class_key, function, functionArgs)

        write_status = jsbmlHelperFunctions.find_instance_method(self.abstract_jsbml_methods, function)
        if write_status == False:
            return

        arguments = []
        if not self.is_java_api:
            arguments.append('const {0} * {1}'
                             .format(self.object_name, self.abbrev_parent))

        # GSOC 2016 modification
        # Need PackageName for Constants, such as QualConstants.initialLevel
        # Also need to add info about the type of Data (boolean or int, or etc)
        # need to use this self.package

        # implementation2 wrong example Output.java -> return transitionEffect;
        # cap_att_name = attribute['capAttName']
        curr_att_type = attribute['attTypeCode']

        curr_att_type = attribute['JClassType']
        old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
        curr_value = 'this.old{0}'.format(strFunctions.upper_first(attribute['name']))

        object = strFunctions.upper_first(attribute['name'])

        implement_part1 = 'Model model = getModel()'.format(curr_att_type, old_value, attribute['name'])

        implementation = ['model != null'.format(attribute['name'], attribute['name']),
                          'return model.get{0}(get{1}())'.format(object, object)]  # 3rd line

        nested_if = self.create_code_block('if', implementation)
        implementation = ['isSet{0}()'.format(object),
                          implement_part1,
                          nested_if, '']  # 2nd line

        code = [self.create_code_block('if', implementation)]

        implementation_next = ['return null']  # 1st line
        code.append(self.create_code_block('line', implementation_next))

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

    # function to write the correct get for doc elements in other libraries, not necessary for JSBML?
    def write_get_for_doc_functions(self, attribute):
        if attribute['name'] == 'mErrorLog':
            implementation = ['return &{0}'.format(attribute['name'])]
        elif attribute['name'] == 'Namespaces':
            implementation = ['return {0}->getNamespaces()'
                              ''.format(attribute['name'])]
        else:
            implementation = ['return {0}'.format(attribute['name'])]

        return implementation

    # function to write get function for an array
    # specialised c++ function to use an array pointer
    # as an argument to be read into
    # TODO needs to be implemented, specially for spatial package
    def write_get_array(self, index, const):
        if index < len(self.attributes):
            attribute = self.attributes[index]
        else:
            return None
        # create comment parts
        title_line = 'Returns the value of the \"{0}\" attribute of this {1}.' \
            .format(attribute['name'], self.class_name)
        params = ['@param outArray {0} array that will be used to return the '
                  'value of the \"{1}\" attribute of this '
                  '{2}.'.format(attribute['attTypeCode'], attribute['name'],
                                self.class_name)]
        return_lines = []
        additional = ['@note the value of the \"{0}\" attribute of this '
                      '{1} is returned in the argument '
                      'array.'.format(attribute['name'], self.class_name)]

        # create the function declaration
        function = 'get{0}'.format(attribute['capAttName'])
        return_type = 'void'
        arguments = ['{0} outArray'.format(attribute['attTypeCode'])]

        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO adapt write_get_array in deviser'])
        implementation.append(comment_line)

        throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
        throw_exception_line = self.create_code_block('line', throw_exception_temp)
        implementation.append(throw_exception_line)

        code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': const,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write get functions for extension
    # TODO is it really necessary?
    def write_static_extension_get(self, index, const=True, static=True):
        if index < len(self.attributes):
            attribute = self.attributes[index]
        else:
            return
        name = attribute['name']
        if name == 'packageName':
            title_name = 'nickname of the {0} Level&nbsp;3 ' \
                         'package'.format(self.cap_language)
            ret_name = 'package nickname'
        elif name == 'defaultLevel':
            title_name = 'default {0} Level'.format(self.cap_language)
            ret_name = '{0} Level'.format(self.cap_language)
        elif name == 'defaultVersion':
            title_name = 'default {0} Version'.format(self.cap_language)
            ret_name = 'Version within the default {0} ' \
                       'Level'.format(self.cap_language)
        elif name == 'defaultPackageVersion':
            title_name = 'default version of the {0} Level&nbsp;3 ' \
                         'package'.format(self.cap_language)
            ret_name = 'default version number of the {0} Level&nbsp;3 ' \
                       'package definition'.format(self.cap_language)
        elif name == 'xmlnsL3V1V1' or name == 'xmlnsL3V1V2':
            title_name = 'XML namespace URI of the {0} Level&nbsp;3 ' \
                         'package'.format(self.cap_language)
            ret_name = 'XML namespace'
        else:
            title_name = ''
            ret_name = ''

        # create comment parts
        params = []
        return_lines = []
        additional = []
        title_line = 'Returns the {0} implemented by this lib{1} extension.' \
            .format(title_name, self.cap_language)

        return_lines.append('@return the {0}, as {1} {2}.'
                            .format(ret_name,
                                    strFunctions.get_indefinite(
                                        attribute['attType']),
                                    attribute['attType']))
        if self.cap_language == 'SBML':
            additional.append('@copydetails doc_note_static_methods')
        # create the function declaration
        function = 'get{0}'.format(attribute['capAttName'])
        if attribute['attType'] == 'string' \
                or attribute['attType'] == 'element':
            if const:
                return_type = 'static const ' + attribute['attTypeCode']
            else:
                return_type = 'static ' + attribute['attTypeCode']
        else:
            return_type = 'static ' + attribute['attTypeCode']
        if not static:
            temp = return_type[7:]
            return_type = temp

        arguments = []

        # create the function implementation
        if attribute['attType'] == 'string':
            if attribute['name'] == 'packageName':
                name = 'pkgName'
                value = '{0}'.format(self.package)
            else:
                name = 'xmlns'
                if attribute['name'].endswith('1'):
                    value = 'http://www.{0}.org/{0}/level3/version1/{1}/' \
                            'version1'.format(self.language, self.package)
                else:
                    value = 'http://www.{0}.org/{0}/level3/version1/{1}/' \
                            'version2'.format(self.language, self.package)

            implementation = ['static const std::string {0} '
                              '= \"{1}\"'.format(name, value),
                              'return {0}'.format(name)]
        else:
            implementation = ['return {0}'.format(attribute['name'])]

        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO write_static_extension_get in deviser'])
        implementation.append(comment_line)

        throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
        throw_exception_line = self.create_code_block('line', throw_exception_temp)
        implementation.append(throw_exception_line)

        code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing is set functions

    # function to write is set functions
    def write_is_set(self, is_attribute, index):
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return
        if not self.is_java_api and ('isVector' in attribute and attribute['isVector']):
            return
        if is_attribute:
            ob_type = 'attribute'
        else:
            ob_type = 'element'

        # GSOC 2016 JSBML change
        # generally in jsbml Id and Name are ignored
        if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
            return None

        # create comment parts
        code = []
        params = []
        return_lines = []
        additional = []
        # title_line = 'Predicate returning {0} if ' \
        #              'this {1}\'s \"{2}\" {3} is set.' \
        #     .format(self.true, self.object_name, attribute['name'],
        #             ob_type)
        # title_line = '@return '
        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))

        return_lines.append('@return {0} if this {1}\'s \"{2}\" {3} has been '
                            'set, otherwise {4} is returned.'
                            .format(self.true, self.object_name,
                                    attribute['name'],
                                    ob_type, self.false))
        title_line = ''
        params.append('Returns whether {{@link {0}}} is set.'.format(attribute['name']))
        params.append(' ')
        params.append('@return whether {{@link {0}}} is set.'.format(attribute['name']))
        # create the function declaration
        if self.is_java_api:
            if 'isVector' in attribute and attribute['isVector']:
                function = 'has{0}'.format(strFunctions.plural(attribute['capAttName']))
            else:
                function = 'isSet{0}'.format(attribute['capAttName'])
            return_type = 'boolean'
        else:
            function = '{0}_isSet{1}'.format(self.class_name,
                                             attribute['capAttName'])
            return_type = 'int'

        # detect if needs to  override
        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods, function, attribute)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add,
                                                                             class_key, function, function_args)

        arguments = []
        if not self.is_java_api:
            arguments.append('const {0} * {1}'
                             .format(self.object_name, self.abbrev_parent))

        # GSOC 2016 modification
        # create the function implementation
        if self.is_java_api:
            if query.is_string(attribute):
                implementation = ['return this.{0} != null'.format(
                    attribute['name'])]  # USED
                code = [dict({'code_type': 'line', 'code': implementation})]
            elif attribute['attType'] == 'enum' or attribute['isArray']:
                implementation = ['return this.{0} != null'.format(
                    attribute['name'])]  # Used
                code = [dict({'code_type': 'line', 'code': implementation})]
            elif query.has_is_set_member(attribute):
                implementation = ['return this.{0} != null'.format(
                    attribute['name'])]  # Used
                code = [dict({'code_type': 'line', 'code': implementation})]
            elif attribute['type'] == 'element':
                implementation = ['return {0} != '
                                  '{1}'.format(attribute['name'],
                                               attribute['default'])]
                code = [dict({'code_type': 'line', 'code': implementation})]
            # TODO  write_is_set needs to be adapted for isVector case
            elif 'isVector' in attribute and attribute['isVector']:
                implementation = []
                comment_line = \
                    self.create_code_block('comment', ['TODO adapt  write_is_set --isVector-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)

                code = implementation

            else:
                implementation = ['return this.{0} != null'.format(
                    attribute['name'])]  # USED
                code = [dict({'code_type': 'line', 'code': implementation})]

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    def write_is_set_instance(self, is_attribute, index, const=True, virtual=False):
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return
        if not self.is_java_api and ('isVector' in attribute and attribute['isVector']):
            return
        if is_attribute:
            ob_type = 'attribute'
        else:
            ob_type = 'element'

        # For JSBML generally Id and Name are not used
        if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
            return None

        # create comment parts
        if attribute['type'] != 'SIdRef':
            return None

        params = []
        return_lines = []
        additional = []
        # title_line = 'Predicate returning {0} if ' \
        #              'this {1}\'s \"{2}\" {3} is set.' \
        #     .format(self.true, self.object_name, attribute['name'],
        #             ob_type)
        title_line = '@return '
        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))

        return_lines.append('@return {0} if this {1}\'s \"{2}\" {3} has been '
                            'set, otherwise {4} is returned.'
                            .format(self.true, self.object_name,
                                    attribute['name'],
                                    ob_type, self.false))

        # create the function declaration
        if self.is_java_api:
            if 'isVector' in attribute and attribute['isVector']:
                function = 'has{0}'.format(strFunctions.plural(attribute['capAttName']))
            else:
                function = 'isSet{0}Instance'.format(attribute['capAttName'])
            return_type = 'boolean'
        else:
            function = '{0}_isSet{1}'.format(self.class_name,
                                             attribute['capAttName'])
            return_type = 'int'


        # Check if Instance methods needs to be written
        write_status = jsbmlHelperFunctions.find_instance_method(self.abstract_jsbml_methods, function)
        if write_status is False:
            return

        # detect if needs to  override
        additional_add, class_key, functionArgs = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods, function, attribute)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add,
                                                                             class_key, function, functionArgs)

        arguments = []
        if not self.is_java_api:
            arguments.append('const {0} * {1}'
                             .format(self.object_name, self.abbrev_parent))

        # GSOC 2016 modification
        # create the function implementation
        if self.is_java_api:
            if query.is_string(attribute):
                implementation = ['return {0} != null'.format(
                    attribute['name'])]  # USED
            elif attribute['attType'] == 'enum' or attribute['isArray']:
                implementation = ['return ({0} != '
                                  '{1})'.format(attribute['name'],
                                                attribute['default'])]
                code = [dict({'code_type': 'line', 'code': implementation})]
            elif query.has_is_set_member(attribute):

                implementation = ['return {0} != null'.format(
                    attribute['name'])]  # Used
                code = [dict({'code_type': 'line', 'code': implementation})]
            elif attribute['type'] == 'element':
                implementation = ['return ({0} != '
                                  '{1})'.format(attribute['name'],
                                                attribute['default'])]
                code = [dict({'code_type': 'line', 'code': implementation})]
            # TODO write_is_set_instance for isVector case is not implemented
            elif 'isVector' in attribute and attribute['isVector']:
                implementation = []
                comment_line = \
                    self.create_code_block('comment', ['TODO adapt  write_is_set_instance --isVector-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)

                code = implementation
            else:
                implementation = ['return get{0}Instance() != null'.format(attribute['capAttName'])]  # USED
                code = [dict({'code_type': 'line', 'code': implementation})]

        code = [dict({'code_type': 'line', 'code': implementation})]

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function for writing getNum for a vector type attribute
    # So far it has  not been used for jsbml
    def write_get_num_for_vector(self, is_attribute, index):
        if not self.is_java_api:
            return
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
        else:
            return
        if not attribute['isVector']:
            return
        # create comment parts
        params = []
        return_lines = []
        additional = []
        title_line = 'Return the number of elements in this {0}\'s \"{1}\" attribute.' \
            .format(self.object_name, attribute['name'])

        return_lines.append('@return the number of elements in the {0}\'s \"{1}\" attribute.'
                            .format(self.object_name,
                                    attribute['name']))

        # create the function declaration
        function = 'getNum{0}'.format(strFunctions.plural(attribute['capAttName']))
        return_type = 'int'

        arguments = []

        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO adapt  write_get_num_for_vector in deviser'])
        implementation.append(comment_line)

        throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
        throw_exception_line = self.create_code_block('line', throw_exception_temp)
        implementation.append(throw_exception_line)

        code = implementation
        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing is set/unset functions

    def get_attribute(self, is_attribute, index):
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
                return attribute
            else:
                return

    # function to write set functions
    def write_set(self, is_attribute, index, write_for="String"):
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return
        if attribute['isArray']:
            if self.is_java_api:
                return self.write_java_set_array(index)
        if is_attribute:
            ob_type = 'attribute'
        else:
            ob_type = 'element'
        if self.is_java_api:
            att_type = attribute['attTypeCode']
        else:
            if 'isVector' in attribute and attribute['isVector']:
                return
            att_type = attribute['CType']

        # Ignore 'Id' and 'Name' for JSBML
        if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
            return None

        # create comment parts
        params = []
        return_lines = []

        additional = []
        title_line = 'Sets the value of the \"{0}\" {1} of this {2}.' \
            .format(attribute['name'], ob_type, self.object_name)

        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param {0} {1} value of the \"{0}\" {2} to be set.'
                      .format(attribute['name'], att_type,
                              ob_type))

        return_lines.append("@copydetails doc_returns_success_code")
        return_lines.append('@li @{0}constant{1}{2}, '
                            'OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.success, self.close_br))

        return_lines.append('@li @{0}constant{1}{2},'
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.invalid_att, self.close_br))

        # TODO JSBML return_type = 'void'
        # create the function declaration
        if self.is_java_api:
            function = 'set{0}'.format(attribute['capAttName'])
            return_type = 'boolean'
        else:
            function = '{0}_set{1}'.format(self.class_name,
                                           attribute['capAttName'])
            return_type = 'boolean'

        params = ['Sets the value of {0}'.format(attribute['name'])]
        params.append(' ')
        params.append('@param {0} the value of {1} to be set.'.format(attribute['name'], attribute['name']))

        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function, attribute,
            return_type)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
                                                                             function, function_args)

        arguments = []
        if self.is_java_api:
            if 'isVector' in attribute and attribute['isVector']:
                arguments.append('{0}& {1}'
                                 .format(attribute['attTypeCode'],
                                         attribute['name']))
            elif attribute['attType'] == 'enum':
                arg_type = attribute['JClassType']
                arguments.append('{0} {1}'.format(arg_type, attribute['name']))
            else:
                arguments.append('{0} {1}'
                                 .format((attribute['attTypeCode']
                                          if (attribute['attType'] == 'String' or
                                              attribute['attType'] == 'enum' or
                                              attribute['attType'] == 'element')
                                          else attribute['attTypeCode']),
                                         attribute['name']))

        # create the function implementation
        if self.is_java_api:
            code, return_type = self.set_java_attribute(attribute)

        # Check if there is another function with same name but different argument
        # E.g. SetCompartment(String) and SetCompartment(Compartment)
        similar_function = jsbmlHelperFunctions.find_function_with_diff_args(self.jsbml_methods,
                                                                             attribute, function)
        if similar_function is not None:
            self.duplicate_methods.append(similar_function)

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    #  Get Number of similar attributes
    def get_similar_num_attributes(self):
        try:
            return len(self.duplicate_methods)
        except Exception as error:
            return 0

    def write_similar_functions(self, is_attribute, att_index, duplic_index):
        if is_attribute:
            if att_index < len(self.attributes):
                attribute = self.attributes[att_index]
            else:
                return
            if duplic_index < len(self.duplicate_methods):
                dup_attribute = self.duplicate_methods[duplic_index]
            else:
                return
        if is_attribute:
            ob_type = 'attribute'
        else:
            ob_type = 'element'

        # create comment parts
        params = []
        return_lines = []

        additional = []
        arguments = []
        title_line = 'Sets the value of the \"{0}\" {1} of this {2}.' \
            .format(attribute['name'], ob_type, self.object_name)

        if self.is_java_api:
            function = 'set{0}'.format(attribute['capAttName'])
            arg_name = attribute['name']

        # get return type of the duplicate method
        return_type = dup_attribute[1]['returnType']

        # Get duplicate name function for non-javadoc documentation
        duplicate_attribute = dup_attribute[1]

        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function, attribute,
            return_type)

        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
                                                                             function, function_args,
                                                                             duplicate_attribute)

        arguments.append('{0} {1}'
                         .format(dup_attribute[0], arg_name))

        implementation = ['{0} != null'.format(attribute['name'])]

        if_temp = ['return set{0}({1}.getId())'.format(attribute['capAttName'], attribute['name'])]

        if_code = self.create_code_block('line', if_temp)

        implementation.append(if_code)
        code = [self.create_code_block('if', implementation)]  # [self.create_code_block('line', implementation)]

        rest_code = ['return unset{}()'.format(attribute['capAttName'])]
        code.append(self.create_code_block('line', rest_code))

        # It is for same methods but take different arguments
        # Example QualitativeSpecies has setCompartment(String) and setCompartment(Compartment)
        # from CompartmentalizedSBase
        # Remove so doesn't get generated again
        self.duplicate_methods = []
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write set functions
    # It has not been used for java code generation
    def write_set_string_for_enum(self, is_attribute, index):
        if is_attribute and index < len(self.attributes):
            attribute = self.attributes[index]
        else:
            return
        if not attribute['isEnum']:
            return
        if self.is_java_api:
            att_type = 'String'

        # create comment parts
        params = []
        return_lines = []
        additional = []
        title_line = 'Sets the value of the \"{0}\" attribute of this {1}.' \
            .format(attribute['name'], self.object_name)

        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param {0} {1} of the \"{0}\" attribute to be set.'
                      .format(attribute['name'], att_type))

        return_lines.append("@copydetails doc_returns_success_code")
        return_lines.append('@li @{0}constant{1}{2}, '
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.success, self.close_br))
        return_lines.append('@li @{0}constant{1}{2},'
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.invalid_att, self.close_br))

        # create the function declaration
        if self.is_java_api:
            function = 'set{0}'.format(attribute['capAttName'])
            return_type = 'int'
        else:
            function = '{0}_set{1}AsString'.format(self.class_name,
                                                   attribute['capAttName'])
            return_type = 'int'

        arguments = []
        if self.is_java_api:
            arguments.append('{0} {1}'.format('const std::string&',
                                              attribute['name']))
        else:
            arguments.append('{0} * {1}'
                             .format(self.object_name, self.abbrev_parent))
            arguments.append('const char * {0}'.format(attribute['name']))

        if self.is_java_api:
            implementation = []
            comment_line = \
                self.create_code_block('comment', ['TODO write_set_string_for_enum in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)

            code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write set function for an array
    # TODO write_java_set_array needs to be adapted for java
    def write_java_set_array(self, index):
        if index < len(self.attributes):
            attribute = self.attributes[index]
        else:
            return None
        # create comment parts
        title_line = 'Sets the value of the \"{0}\" attribute of this {1}.' \
            .format(attribute['name'], self.class_name)
        params = ['@param inArray {0} array value of the \"{1}\" attribute '
                  'to be set.'.format(attribute['attTypeCode'],
                                      attribute['name']),
                  '@param arrayLength int value for the length of '
                  'the \"{0}\" attribute to be '
                  'set.'.format(attribute['name'])]
        return_lines = ["@copydetails doc_returns_success_code",
                        '@li @{0}constant{1}{2}, '
                        'OperationReturnValues_t{3}'.format(self.language,
                                                            self.open_br,
                                                            self.success,
                                                            self.close_br),
                        '@li @{0}constant{1}{2},'
                        ' OperationReturnValues_t{3}'.format(self.language,
                                                             self.open_br,
                                                             self.invalid_att,
                                                             self.close_br)]
        additional = []

        # create the function declaration
        function = 'set{0}'.format(attribute['capAttName'])
        return_type = 'int'
        arguments = ['{0} inArray'.format(attribute['attTypeCode']),
                     'int arrayLength']
        member = attribute['name']
        length = member + 'Length'
        ar_type = attribute['element']
        is_set_l = 'mIsSet' + strFunctions.upper_first(attribute['name']) \
                   + 'Length'

        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO adapt   write_java_set_array in deviser'])
        implementation.append(comment_line)

        throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
        throw_exception_line = self.create_code_block('line', throw_exception_temp)
        implementation.append(throw_exception_line)

        code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write set functions
    # So it has not been used for java code generation
    def write_add_element_for_vector(self, is_attribute, index):
        if not self.is_java_api:
            return
        if is_attribute and index < len(self.attributes):
            attribute = self.attributes[index]
        else:
            return
        if not ('isVector' in attribute and attribute['isVector']):
            return
        att_type = attribute['element']

        # create comment parts
        params = []
        return_lines = []
        additional = []
        title_line = 'Adds another value to the \"{0}\" attribute of this {1}.' \
            .format(attribute['name'], self.object_name)

        params.append('@param {0} {1} of the \"{0}\" attribute to be added.'
                      .format(attribute['name'], att_type))

        return_lines.append("@copydetails doc_returns_success_code")
        return_lines.append('@li @{0}constant{1}{2}, '
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.success, self.close_br))
        return_lines.append('@li @{0}constant{1}{2},'
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.invalid_att, self.close_br))

        # create the function declaration
        function = 'add{0}'.format(attribute['capAttName'])
        return_type = 'int'

        arguments = []
        arguments.append('{0} {1}'.format(att_type,
                                          attribute['name']))

        implementation = ['{0}.push_back({1})'.format(attribute['name'], attribute['name']),
                          'return {0}'.format(self.success)]
        code = [dict({'code_type': 'line', 'code': implementation})]

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    #########################################################################
    # function to write unset functions
    def write_unset(self, is_attribute, index):
        if is_attribute:
            if index < len(self.attributes):
                attribute = self.attributes[index]
            else:
                return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return
        if is_attribute:
            ob_type = 'attribute'
        else:
            ob_type = 'element'

        # ignore Id and Name unset methods
        if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
            return None

        # If unset 'isVector' needs to be adapted
        if 'isVector' in attribute and attribute['isVector']:
            code = self.write_clear(attribute)
        else:
            code = self.write_unset_general(attribute, ob_type)
        return code

    def write_unset_general(self, attribute, ob_type):
        # create comment parts
        params = []
        return_lines = []
        additional = []
        title_line = '@return {{@code true}} if the unset of the {0} attribute was successful' \
            .format(attribute['name'])

        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))

        return_lines.append('@copydetails doc_returns_success_code')
        return_lines.append('@li @{0}constant{1}{2}, '
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.success, self.close_br))
        return_lines.append('@li @{0}constant{1}{2},'
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.failed, self.close_br))

        # create the function declaration
        if self.is_java_api:
            function = 'unset{0}'.format(attribute['capAttName'])
            return_type = 'int'
            return_type = 'boolean'

        # detect if needs to  override
        additional_add, class_key, functionArgs = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function, attribute)
        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key, function,
                                                                             functionArgs)

        params = []
        params.append('Unsets the variable {0}.'.format(attribute['name']))
        params.append(' ')
        params.append(
            '@return {{@code true}} if {0} was set before, otherwise {{@code false}}.'.format(attribute['name']))
        # TODO GSOC 2016 write_unset return type definition

        arguments = []
        if not self.is_java_api:
            arguments.append('{0} * {1}'
                             .format(self.object_name, self.abbrev_parent))

        # create the function implementation
        if self.is_java_api:
            code, return_type = self.unset_java_attribute(attribute)

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # TODO write_clear needs to be adapted for JSBML if required
    def write_clear(self, attribute):
        if not self.is_java_api:
            return None
        # create comment parts
        params = []
        return_lines = []
        additional = []
        title_line = 'Clears the \"{0}\" element of this {1}.' \
            .format(attribute['name'], self.object_name)

        return_lines.append('@copydetails doc_returns_success_code')
        return_lines.append('@li @{0}constant{1}{2}, '
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.success, self.close_br))
        return_lines.append('@li @{0}constant{1}{2},'
                            ' OperationReturnValues_'
                            't{3}'.format(self.language, self.open_br,
                                          self.failed, self.close_br))

        # create the function declaration
        function = 'clear{0}'.format(strFunctions.plural(attribute['capAttName']))
        return_type = 'int'

        arguments = []

        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO adapt write_clear in deviser'])
        implementation.append(comment_line)

        throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
        throw_exception_line = self.create_code_block('line', throw_exception_temp)
        implementation.append(throw_exception_line)

        code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing create for a child element

    # function to write create functions
    def write_create(self, is_attribute, index):
        if is_attribute:
            return
        else:
            if index < len(self.child_elements):
                attribute = self.child_elements[index]
            else:
                return
        # not if element is Math or is abstract
        if attribute['attTypeCode'] == 'ASTNode*':
            return
        elif 'is_ml' in attribute and attribute['is_ml']:
            return
        elif attribute['abstract']:
            return

        # useful variables
        name = strFunctions.upper_first(attribute['name'])
        if self.is_java_api:
            att_type = attribute['attTypeCode']
            att_name = attribute['element']
        else:
            att_type = attribute['CType']
            att_name = attribute['element']  # + '_t'

        # create comment parts
        title_line = 'Creates a new {0} object, adds it to this {1} object ' \
                     'and returns the {0} object ' \
                     'created.'.format(att_name, self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure '
                          'to which the {2} should be '
                          'added.'.format(self.abbrev_parent, self.object_name,
                                          att_name))
        return_lines = ['@return a new {0} object '
                        'instance.'.format(att_name)]
        additional = []

        used_java_name = strFunctions.upper_first(name)
        used_java_name_lower = strFunctions.lower_first(name)
        used_java_type = strFunctions.remove_prefix(attribute['JClassType'])
        child = name

        # create the function declaration
        arguments = []
        if self.is_java_api:
            function = 'create{0}'.format(name)

        return_type = '{0}'.format(att_type)

        code = []
        if not self.is_header and self.is_java_api:
            member = attribute['name']
            up_pack = self.package.upper()
            low_pack = self.package.lower()

            implementation = ['{0} {1} = new {0}(getLevel(), getVersion())'.format(used_java_type,
                                                                                   strFunctions.lower_first(child),
                                                                                   used_java_type)]
            implementation.append('return {0}'.format(strFunctions.lower_first(child)))
            code = [self.create_code_block('line', implementation)]

        elif not self.is_header:
            # TODO write_create --if not is_header needs to be adapted
            implementation = []
            comment_line = \
                self.create_code_block('comment', ['TODO write_create --not is_header-- in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)

            code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write create functions
    # TODO write_create_concrete_child has not been adapted for JSBML
    def write_create_concrete_child(self, attribute, member=''):
        # useful variables
        name = strFunctions.upper_first(attribute['element'])
        if self.is_java_api:
            att_type = attribute['element']
            att_name = attribute['element']

        # create comment parts
        title_line = 'Creates a new {0} object, adds it to this {1} object ' \
                     'and returns the {0} object ' \
                     'created.'.format(att_name, self.object_name)

        code = []
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure '
                          'to which the {2} should be '
                          'added.'.format(self.abbrev_parent, self.object_name,
                                          att_name))
        return_lines = ['@return a new {0} object '
                        'instance.'.format(att_name)]
        additional = []

        # create the function declaration
        arguments = []
        if self.is_java_api:
            function = 'create{0}'.format(name)

        return_type = '{0}'.format(att_type)

        up_pack = self.package.upper()
        low_pack = self.package.lower()
        if self.is_java_api:
            implementation = []
            comment_line = \
                self.create_code_block('comment', ['TODO adapt  write_create_concrete_child in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)

            code = implementation

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # HELPER FUNCTIONS

    # TODO for write_set  absolutely important
    def set_java_attribute(self, attribute, write_for='String'):
        member = attribute['name']
        name = attribute['name']
        return_type = 'boolean'
        if 'version_info' in attribute and False in attribute['version_info']:
            code = [self.create_code_block('line',
                                           ['unsigned int pkgVersion = '
                                            'getPackageVersion()'])]
            deal_with_versions = True
        else:
            code = []
            deal_with_versions = False

        if attribute['type'] == 'SId':
            curr_att_type = attribute['JClassType']
            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.{0}'.format(attribute['name'])

            implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
            implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
            implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                      attribute['name'],
                                                                                      old_value,
                                                                                      curr_value)

            impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
            implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                              implement_part1,
                              impl2, implement_part3, 'return true']  # 2nd line
            code = [self.create_code_block('if', implementation)]

            implementation_next = ['return false']  # 1st line
            code.append(self.create_code_block('line', implementation_next))
            return_type = 'boolean'

        elif attribute['type'] == 'SIdRef':
            curr_att_type = attribute['JClassType']
            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.{0}'.format(attribute['name'])

            implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
            implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
            implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                      attribute['name'],
                                                                                      old_value,
                                                                                      curr_value)

            impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
            implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                              implement_part1,
                              impl2, implement_part3, 'return true']  # 2nd line
            code = [self.create_code_block('if', implementation)]

            implementation_next = ['return false']  # 1st line
            code.append(self.create_code_block('line', implementation_next))
            return_type = 'boolean'
        elif attribute['type'] == 'UnitSId' \
                or attribute['type'] == 'UnitSIdRef':  # TODO Spatial coordinatecomponent setUnit
            curr_att_type = attribute['JClassType']
            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.{0}'.format(attribute['name'])

            implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
            implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
            implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                      attribute['name'],
                                                                                      old_value,
                                                                                      curr_value)

            impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
            implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                              implement_part1,
                              impl2, implement_part3, 'return true']  # 2nd line
            code = [self.create_code_block('if', implementation)]

            implementation_next = ['return false']  # 1st line
            code.append(self.create_code_block('line', implementation_next))
            return_type = 'boolean'
            # implementation = ['!(SyntaxChecker::isValidInternalUnitSId({0})'
            #                   ')'.format(name),
            #                   'return {0}'.format(self.invalid_att), 'else',
            #                   '{0} = {1}'.format(member, name),
            #                   'return {0}'.format(self.success)]
            # code = [dict({'code_type': 'if_else', 'code': implementation})]
        elif attribute['type'] == 'string' or attribute['type'] == 'IDREF':
            curr_att_type = attribute['JClassType']
            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.{0}'.format(attribute['name'])

            implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
            implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
            implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                      attribute['name'],
                                                                                      old_value,
                                                                                      curr_value)

            impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
            implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                              implement_part1,
                              impl2, implement_part3, 'return true']  # 2nd line
            code = [self.create_code_block('if', implementation)]

            implementation_next = ['return false']  # 1st line
            code.append(self.create_code_block('line', implementation_next))
            return_type = 'boolean'
            # implementation = ['{0} = {1}'.format(member, name),
            #                   'return {0}'.format(self.success)]
            # code = [dict({'code_type': 'line', 'code': implementation})]
        elif attribute['type'] == 'enum':  # TODO setType setOperation setSig
            curr_att_type = attribute['JClassType']
            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.{0}'.format(attribute['name'])

            implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
            implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
            implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                      attribute['name'],
                                                                                      old_value,
                                                                                      curr_value)

            impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
            implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                              implement_part1,
                              impl2, implement_part3, 'return true']  # 2nd line
            code = [self.create_code_block('if', implementation)]

            implementation_next = ['return false']  # 1st line
            code.append(self.create_code_block('line', implementation_next))
            return_type = 'boolean'
        elif query.has_is_set_member(attribute):
            code = self.write_set_att_with_member(attribute, True)

        # TODO here's some work that needs to be done element and vector
        elif 'isVector' in attribute and attribute['isVector']:
            implementation = ['{0} = {1}'.format(member, name),
                              'return {0}'.format(self.success)]
            code = [self.create_code_block('line', implementation)]
        elif attribute['type'] == 'element':
            if not self.is_plugin:
                clone = 'clone'
                nested_if = []
                # TODO set_java_attribute adapt for type element
                implementation = []
                comment_line = \
                    self.create_code_block('comment', ['TODO adapt  write_is_set --isVector-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)
                if attribute['element'] == 'ASTNode':
                    # clone = 'deepCopy'

                    curr_att_type = attribute['JClassType']
                    old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
                    curr_value = 'this.{0}'.format(attribute['name'])

                    implement_part1 = ['{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])]
                    implement_part2 = ['{0} = {1}'.format(curr_value, attribute['name'])]

                    code.append(self.create_code_block('line', implement_part1))
                    code.append(self.create_code_block('line', implement_part2))

                    implementation = ['old{0} != null'.format(attribute['capAttName']),
                                      'old{0}.fireNodeRemovedEvent()'.format(attribute['capAttName'])]  # 2nd line
                    code.append(self.create_code_block('if', implementation))

                    implementation = ['this.{0} != null'.format(attribute['name'])]
                    # implementation.append(['ASTNode.setParentSBMLObject({0}, this)'.format(attribute['name'])])
                    implementation.append('firePropertyChange(TreeNodeChangeEvent.{0}, {1}, {0})'. \
                                          format(attribute['name'], old_value, curr_value))  # 2nd line

                    code.append(self.create_code_block('if', implementation))
                    code.append(self.create_code_block('blank', ''))
                    return_type = 'void'
                else:
                    curr_att_type = attribute['JClassType']
                    old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
                    curr_value = 'this.{0}'.format(attribute['name'])

                    implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
                    implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
                    implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                              attribute['name'],
                                                                                              old_value,
                                                                                              curr_value)

                    impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
                    implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                                      implement_part1,
                                      impl2, implement_part3, 'return true']  # 2nd line
                    code = [self.create_code_block('if', implementation)]

                    implementation_next = ['return false']  # 1st line
                    code.append(self.create_code_block('line', implementation_next))
                    return_type = 'boolean'
            else:
                curr_att_type = attribute['JClassType']
                old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
                curr_value = 'this.{0}'.format(attribute['name'])

                implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, old_value, attribute['name'])
                implement_part2 = '{0} = {1}'.format(curr_value, attribute['name'])
                implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                          attribute['name'],
                                                                                          old_value,
                                                                                          curr_value)

                impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
                implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                                  implement_part1,
                                  impl2, implement_part3, 'return true']  # 2nd line
                code = [self.create_code_block('if', implementation)]

                implementation_next = ['return false']  # 1st line
                code.append(self.create_code_block('line', implementation_next))
                return_type = 'boolean'
        else:
            curr_att_type = attribute['JClassType']

            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.old{0}'.format(attribute['name'])
            part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
            part2 = '{0} = null'.format(attribute['name'])
            part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                            attribute['name'],
                                                                            old_value,
                                                                            attribute['name'])
            implementation = ['isSet{0}()'.format(attribute['capAttName']),
                              part1, part2, part3,
                              'return true']
            # code = [dict({'code_type': 'if', 'code': implementation})]
            code = [self.create_code_block('if', implementation)]

            temp = 'return false'
            code.append(temp)
            return_type = 'boolean'
            # code = [dict({'code_type': 'blank', 'code': []})]
        return code, return_type

    # write_set controller
    def write_set_att_with_member(self, attribute, in_version):
        # Here's the problem

        try:
            curr_att_type = attribute['JClassType']
            oldValue = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            currValue = 'this.{0}'.format(attribute['name'])

            implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, oldValue, attribute['name'])
            implement_part2 = '{0} = {1}'.format(currValue, attribute['name'])
            implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                      attribute['name'],
                                                                                      oldValue,
                                                                                      currValue)

            impl2 = 'this.{0} = {1}'.format(attribute['name'], attribute['name'])  # 3rd line
            implementation = ['{0} != this.{1}'.format(attribute['name'], attribute['name']),
                              implement_part1,
                              impl2, implement_part3, 'return true']  # 2nd line
            code = [self.create_code_block('if', implementation)]

            implementationNext = ['return false']  # 1st line
            code.append(self.create_code_block('line', implementationNext))
            return_type = 'boolean'
            return code

        except Exception as error:
            print("write_set_att_with_member ", error)
            sys.exit(0)

    def unset_java_attribute(self, attribute):
        code = []
        if attribute['attType'] == 'string':
            curr_att_type = attribute['JClassType']

            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.old{0}'.format(attribute['name'])
            part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
            part2 = '{0} = null'.format(attribute['name'])
            part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                            attribute['name'],
                                                                            old_value,
                                                                            attribute['name'])
            implementation = ['isSet{0}()'.format(attribute['capAttName']),
                              part1, part2, part3,
                              'return true']
            # code = [dict({'code_type': 'if', 'code': implementation})]
            code = [self.create_code_block('if', implementation)]

            temp = 'return false'
            code.append(temp)
            return_type = 'boolean'

        elif attribute['attType'] == 'enum':

            curr_att_type = attribute['JClassType']

            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.old{0}'.format(attribute['name'])
            part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
            part2 = '{0} = null'.format(attribute['name'])
            part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                            attribute['name'],
                                                                            old_value,
                                                                            attribute['name'])
            implementation = ['isSet{0}()'.format(attribute['capAttName']),
                              part1, part2, part3,
                              'return true']
            # code = [dict({'code_type': 'if', 'code': implementation})]
            code = [self.create_code_block('if', implementation)]

            temp = 'return false'
            code.append(temp)
            return_type = 'boolean'

        elif attribute['type'] == 'SIdRef':
            curr_att_type = attribute['JClassType']

            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            curr_value = 'this.old{0}'.format(attribute['name'])
            part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
            part2 = '{0} = null'.format(attribute['name'])
            part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                            attribute['name'],
                                                                            old_value,
                                                                            attribute['name'])
            implementation = ['isSet{0}()'.format(attribute['capAttName']),
                              part1, part2, part3,
                              'return true']
            # code = [dict({'code_type': 'if', 'code': implementation})]
            code = [self.create_code_block('if', implementation)]

            temp = 'return false'
            code.append(temp)
            return_type = 'boolean'
        elif query.has_is_set_member(attribute):
            curr_att_type = attribute['JClassType']

            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
            part2 = '{0} = null'.format(attribute['name'])
            part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                            attribute['name'],
                                                                            old_value,
                                                                            attribute['name'])
            implementation = ['isSet{0}()'.format(attribute['capAttName']),
                              part1, part2, part3,
                              'return true']
            # code = [dict({'code_type': 'if', 'code': implementation})]
            code = [self.create_code_block('if', implementation)]

            temp = 'return false'
            code.append(temp)
            return_type = 'boolean'

        elif attribute['type'] == 'element':
            if attribute['name'] == 'math':

                implementation = ['set{0}(null)'.format(attribute['capAttName'])]
                code = [self.create_code_block('line', implementation)]
                return_type = 'void'
            else:
                curr_att_type = attribute['JClassType']

                old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
                curr_value = 'this.old{0}'.format(attribute['name'])
                part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
                part2 = '{0} = null'.format(attribute['name'])
                part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                                attribute['name'],
                                                                                old_value,
                                                                                attribute['name'])
                implementation = ['isSet{0}()'.format(attribute['capAttName']),
                                  part1, part2, part3,
                                  'return true']
                # code = [dict({'code_type': 'if', 'code': implementation})]
                code = [self.create_code_block('if', implementation)]

                temp = 'return false'
                code.append(temp)
                return_type = 'boolean'

        elif attribute['isArray']:
            code = [self.create_code_block(
                'if', ['{0} != NULL'.format(attribute['name']),
                       'delete[] {0}'.format(attribute['name'])]),
                self.create_code_block('line', [
                    '{0} = NULL'.format(attribute['name'])]),
                self.create_code_block('line', [
                    'return unset{0}Length()'.format(
                        strFunctions.upper_first(attribute['name']))])]
            return_type = 'boolean'
        else:

            curr_att_type = attribute['JClassType']

            old_value = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
            part1 = '{0} {1}  = {2}'.format(curr_att_type, old_value, attribute['name'])
            part2 = '{0} = null'.format(attribute['name'])
            part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
                                                                            attribute['name'],
                                                                            old_value,
                                                                            attribute['name'])
            implementation = ['isSet{0}()'.format(attribute['capAttName']),
                              part1, part2, part3,
                              'return true']
            # code = [dict({'code_type': 'if', 'code': implementation})]
            code = [self.create_code_block('if', implementation)]

            temp = 'return false'
            code.append(temp)
            return_type = 'boolean'

        return code, return_type

    @staticmethod
    def create_code_block(code_type, lines):
        code = dict({'code_type': code_type, 'code': lines})
        return code
