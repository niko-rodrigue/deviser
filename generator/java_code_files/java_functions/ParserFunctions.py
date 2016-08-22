#!/usr/bin/env python
#
# @file    ParserFunctions.py
# @brief   class to create parser functions for Google Summer of Code 2016
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

from util import strFunctions, global_variables, jsbmlHelperFunctions
import random


class ParserFunctions():
    """Class for general functions"""

    def __init__(self, language, is_java_api, expanded_package_object, jsbml_data_tree=None,
                 jsbml_methods=None, prime_numbers=None, abstract_jsbml_methods=None, import_modules=None):
        self.language = language
        self.cap_language = language.upper()
        self.expanded_package = expanded_package_object
        self.package = expanded_package_object['original_name']
        self.parser_name = expanded_package_object['name']
        self.original_name = expanded_package_object['original_name']
        self.is_parser = True
        self.is_java_api = is_java_api

        # For tests
        self.run_tests = global_variables.running_tests

        # Additional information for java code generation
        if jsbml_data_tree is not None:
            self.jsbml_data_tree = jsbml_data_tree
        if jsbml_methods is not None:
            self.jsbml_methods = jsbml_methods
        if abstract_jsbml_methods is not None:
            self.abstract_jsbml_methods = abstract_jsbml_methods
        if prime_numbers is not None:
            self.prime_numbers = prime_numbers
        if import_modules is not None:
            self.import_modules = import_modules

        if is_java_api:
            self.object_name = self.parser_name
            # self.object_child_name = self.child_name

        self.attributeName = 'attributeName'
        self.prefix = 'prefix'
        self.value = 'value'

        self.duplicate_methods = []

        # get parent-child elements
        self.data_to_write = self.expand_get_parent_child_elements()
        self.none_values = self.expand_get_sbase_type_parent_elements_from_object()

        self.lo_elements = self.get_all_lo_elements()

    ########################################################################

    # Get Parent lo_element with childs
    def expand_get_parent_child_elements(self):
        base_elements = self.expanded_package['baseElements']
        data_to_write = []
        for element in base_elements:
            implementation = []
            info_dict = {}
            info_dict['data'] = []
            if len(element['child_lo_elements']) > 0:
                for child_lo_element in element['child_lo_elements']:

                    if 'parent' in child_lo_element:
                        parent = child_lo_element['parent']
                        parent_name = parent['name']
                        if parent_name not in info_dict:
                            info_dict['parent'] = parent_name

                        element_name = child_lo_element['jsbmlName']
                        element_type = child_lo_element['capAttName']
                        if element_name not in info_dict['data']:
                            # info_dict['data'].append([element_name, element_type])
                            info_dict['data'].append({'listName': element_name, 'type': element_type,
                                                      'original': child_lo_element})
                data_to_write.append(info_dict)

        return data_to_write

    # Get lo_elements of type SBase
    def expand_get_sbase_type_parent_elements_from_object(self):
        none_values = []
        elements = self.expanded_package['elements']
        add = True
        for element in elements:
            if element['listOfClassName'] != '':
                for data in self.data_to_write:
                    if strFunctions.lower_first(element['listOfClassName']) in data['data']:
                        add = False
                if add is True:
                    temp = {}
                    list_of_name = strFunctions.lower_first(element['listOfClassName'])
                    temp.update({'listOfName': list_of_name})
                    temp.update({'name': element['name']})
                    none_values.append(temp)
                else:
                    add = True
        return none_values

    # Get all list of elements
    def get_all_lo_elements(self):
        list_of_elements = []

        elements = self.expanded_package['elements']
        for element in elements:
            if element['isListOf'] is True:
                list_of_elements.append(element)

        return list_of_elements

    def write_get_short_label(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getShortLabel'

        title_line = '(non-Javadoc)-- @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        # create function decl
        return_type = 'String'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'

        # additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
        #     self.jsbml_methods,
        #     function=function,
        #     return_type=return_type)
        #
        # if additional_add is not None:
        #     additional.append(additional_add)
        # title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
        #                                                                      function, function_args)

        temp = ['return {0}Constants.shortLabel'.format(strFunctions.upper_first(self.package))]
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_get_namespace_uri(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getNamespaceURI'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        # create function decl

        return_type = 'String'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []

        temp = ['return {0}Constants.namespaceURI'.format(strFunctions.upper_first(self.package))]
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_is_required(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'isRequired'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.PackageParser#isRequired()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        return_type = 'boolean'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []

        temp = ['return false']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_get_package_name(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getPackageName'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.PackageParser#getPackageName()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        # create function decl

        return_type = 'String'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []

        temp = ['return {0}Constants.shortLabel'.format(strFunctions.upper_first(self.package))]
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_get_package_namespaces(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getPackageNamespaces'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.PackageParser#getPackageNamespaces()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        return_type = 'List<String>'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []

        temp = ['return getNamespaces()']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_get_namespaces(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getNamespaces'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.ReadingParser#getNamespaces()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        return_type = 'List<String> '
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []

        temp = ['return {0}Constants.namespaces'.format(strFunctions.upper_first(self.package))]
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_get_namespace_for(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getNamespaceFor'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.PackageParser#getNamespaceFor\
        (java.lang.String, java.lang.String, java.lang.String)'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        return_type = 'String'
        arguments = ['int level', 'int version', 'int packageVersion']
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []

        base_level = self.expanded_package['base_level']
        base_version = self.expanded_package['base_version']
        package_version = self.expanded_package['pkg_version']

        implementation = ['level == {0} && version == {1} && packageVersion == {2}'.format(base_level, base_version, \
                                                                                           package_version)]

        namespace_uri = 'namespaceURI_L{0}V{1}V{2}'.format(base_level, base_version, package_version)
        implementation.append(
            'return {0}Constants.{1}'.format(strFunctions.upper_first(self.package), namespace_uri))
        code.append(self.create_code_block('if', implementation))

        temp = ['return null']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def create_read_attribute_if(self, index):
        name = self.attributes[index]['capAttName']
        member_name = self.attributes[index]['name']
        java_type = self.attributes[index]['JClassType']

        implement = ['{0}.equals({1}Constants.{2}'.format(self.attributeName, self.package, member_name),
                     'set{0}(StringTools.parseSBML{1}({2}))'.format(name, java_type, self.value)]  # 3rd line

        temp_code = self.create_code_block('if', implement)
        return temp_code

    def create_read_attribute_else_if(self, index):
        name = self.attributes[index]['capAttName']
        member_name = self.attributes[index]['name']
        java_type_data = self.attributes[index]['JClassType']
        type = self.attributes[index]['type']

        if java_type_data == 'Boolean':
            java_type = 'Boolean'
        elif java_type_data == 'Integer':
            java_type = 'Int'
        elif type == 'enum':
            java_type = java_type_data
        else:
            java_type = java_type_data

        implementation = ['{0}.equals({1}Constants.{2})'.format(self.attributeName, self.package, member_name)]

        if str(type)[:] == 'SIdRef':
            implementation.append('set{0}({1})'.format(name, self.value))
        elif str(type)[:] == 'IDREF':
            implementation.append('set{0}({1})'.format(name, self.value))
        elif type == 'enum':
            temp_implementation = []

            temp_implementation.append('set{0}({1}.valueOf(value))'.format(name, java_type))
            temp_implementation.append('catch')
            temp_implementation.append('Exception e')
            temp_implementation.append('throw new SBMLException("Could not recognized '
                                       'the value \'" +\
                                        value + "\' for the attribute " + \
                                        {0}Constants.{1} + " on the \'{2}\' element.")'.format(self.package,
                                                                                               member_name,
                                                                                               self.class_name))

            implementation.append(self.create_code_block('try', temp_implementation))
        elif type == 'SpatialKind':
            implementation.append('set{0}({1}.valueOf(value))'.format(name, java_type))
        else:
            implementation.append('set{0}(StringTools.parseSBML{1}({2}))'.format(name, java_type, self.value))

        try:
            if index < len(self.attributes) - 1:
                implementation.append('else if')
        except Exception as e:
            pass

        return implementation

    def create_read_attribute_else(self):
        implementation = ['else', 'isAttributeRead = false']  # 3rd line
        return implementation

        # Functions for writing readAttributes

    def write_get_list_of_sbml_elements_to_write(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'getListOfSBMLElementsToWrite'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.WritingParser#getListOfSBMLElementsToWrite(Object sbase)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'List<Object>'
        arguments = ['Object sbase']  # , 'String prefix', 'String value']
        arguments_no_defaults = ['Object sbase']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = []

        implementation = ['logger.isDebugEnabled()',
                          '      logger.debug("getListOfSBMLElementsToWrite: " + sbase.getClass().getCanonicalName())']
        line = self.create_code_block('if', implementation)
        code.append(line)

        implementation = [' List<Object> listOfElementsToWrite = new ArrayList<Object>()']
        line = self.create_code_block('line', implementation)
        code.append(line)

        plugins = self.expanded_package['plugins']

        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        for plugin in plugins:
            implementation = []
            temp = 'sbase instanceof {0}'.format(plugin['sbase'])
            implementation.append(temp)

            package_name = '{0}'.format(plugin['package'])
            lower_sbase = plugin['sbase']
            upper_sbase = strFunctions.upper_first(plugin['sbase'])
            temp = '{0} {1}Plugin = ({0}) (({2}) sbase).getExtension({3}Constants.namespaceURI)'.format( \
                package_name, lower_sbase, upper_sbase, upper_original_name)
            implementation.append(temp)
            code.append(self.create_code_block('if', implementation))

        temp = ['return listOfElementsToWrite']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    def write_create_plugin_for_sbase(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'createPluginFor'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.parsers.PackageParser#createPluginFor(org.sbml.jsbml.SBase)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = ['Override']

        return_type = 'SBasePlugin'

        arguments = ['SBase sbase']
        arguments_no_defaults = ['SBase sbase']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]

        plugins = self.expanded_package['plugins']

        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        lower_original_name = strFunctions.lower_first(self.expanded_package['original_name'])

        implementation = ['sbase != null']
        for plugin in plugins:
            implementation_temp = []
            temp = 'sbase instanceof {0}'.format(plugin['sbase'])
            implementation_temp.append(temp)

            package_name = '{0}'.format(plugin['package'])
            lower_sbase = strFunctions.lower_first(plugin['sbase'])
            upper_sbase = strFunctions.upper_first(plugin['sbase'])

            temp = 'return new {0}(({1}) sbase)'.format(package_name, upper_sbase)
            implementation_temp.append(temp)

            implementation.append(self.create_code_block('if', implementation_temp))

        implementation.append(self.create_code_block('empty_line'))

        code.append(self.create_code_block('if', implementation))

        code.append(self.create_code_block('empty_line'))

        temp = ['return null']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    def write_create_plugin_for_astnode(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'createPluginFor'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.parsers.PackageParser#createPluginFor()'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'ASTNodePlugin'

        arguments = ['ASTNode astNode']
        arguments_no_defaults = ['ASTNode astNode']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = []

        temp = ['This package does not extend ASTNode']
        code.append(self.create_code_block('comment', temp))

        temp = ['return null']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    def write_process_attribute(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'processAttribute'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.parsers.ReadingParser#processAttribute(String elementName, String \
        attributeName, String value, String prefix, boolean isLastAttribute, Object contextObject)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'void'
        arguments = ['String elementName', 'String attributeName',
                     'String value', 'String uri', 'String prefix',
                     'boolean isLastAttribute', 'Object contextObject']  # , 'String prefix', 'String value']
        arguments_no_defaults = ['String elementName', 'String attributeName',
                                 'String value', 'String uri', 'String prefix',
                                 'boolean isLastAttribute', 'Object contextObject']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]

        implementation = ['logger.debug("processAttribute -> " + prefix + ":" + attributeName \
        + " = " + value + " (" + contextObject.getClass().getName() + ")")']
        line = self.create_code_block('line', implementation)
        code.append(line)

        plugins = self.expanded_package['plugins']

        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        lower_original_name = strFunctions.lower_first(self.expanded_package['original_name'])
        for plugin in plugins:
            implementation = []
            temp = 'contextObject  instanceof {0}'.format(plugin['sbase'])
            implementation.append(temp)

            package_name = '{0}'.format(plugin['package'])
            lower_sbase = strFunctions.lower_first(plugin['sbase'])
            upper_sbase = strFunctions.upper_first(plugin['sbase'])

            temp = '{0} {1} = ({0}) contextObject'.format(upper_sbase, lower_sbase)
            implementation.append(temp)

            temp = '{0} {1}{2} = ({0}) {3}.getPlugin({4}Constants.shortLabel)'.format( \
                package_name, lower_original_name, upper_sbase, lower_sbase, upper_original_name)
            implementation.append(temp)

            temp = 'contextObject = {0}{1}'.format(lower_original_name, upper_sbase)
            implementation.append(temp)

            code.append(self.create_code_block('if', implementation))

        code.append(self.create_code_block('empty_line'))
        temp = [
            'super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject)']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    def write_process_end_element(self):
        # do not write for C API
        if len(self.lo_elements) < 1:
            return

        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'processEndElement'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.parsers.ReadingParser#processEndElement(java.lang.String, \
        java.lang.String, boolean, java.lang.Object)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'boolean'
        arguments = ['String elementName', 'String prefix',
                     'boolean isNested', 'Object contextObject']
        arguments_no_defaults = ['String elementName', 'String prefix',
                                 'boolean isNested', 'Object contextObject']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]

        baseElements = self.expanded_package['baseElements']
        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])

        none_values = self.none_values
        data_to_write = self.data_to_write

        implementation = []
        text = ''
        for none_values_index in range(len(none_values)):
            if none_values_index >= 1 and none_values_index < len(none_values):
                text += ' || '
            text += 'elementName.equals("{0}")'.format(none_values[none_values_index]['listOfName'])

        implementation.append(text)
        temp = 'groupList = {0}List.none'.format(upper_original_name)
        implementation.append(temp)
        code.append(self.create_code_block('if', implementation))
        code.append(self.create_code_block('empty_line'))

        for data in data_to_write:
            implementation = []
            text = ''
            for values_index in range(len(data['data'])):
                if values_index >= 1 and values_index < len(data['data']):
                    text += ' || '
                text += 'elementName.equals("{0}")'.format(data['data'][values_index]['listName'])
            implementation.append(text)
            data_parent = 'listOf' + strFunctions.plural(data['parent'])
            temp = 'groupList = {0}List.{1}'.format(upper_original_name, data_parent)
            implementation.append(temp)
            code.append(self.create_code_block('if', implementation))
            code.append(self.create_code_block('empty_line'))

        temp = ['return true']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    def write_process_start_element(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'processStartElement'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.parsers.ReadingParser#processStartElement(java.lang.String, java.lang.String, \
        boolean, boolean, java.lang.Object)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'Object'

        arguments = ['String elementName', 'String uri', 'String prefix',
                     'boolean hasAttributes', 'boolean hasNamespaces', 'Object contextObject']
        arguments_no_defaults = ['String elementName', 'String uri', 'String prefix',
                                 'boolean hasAttributes', 'boolean hasNamespaces', 'Object contextObject']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]
        plugins = self.expanded_package['plugins']

        code = [self.create_code_block('empty_line')]
        plugins = self.expanded_package['plugins']

        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        lower_original_name = strFunctions.lower_first(self.expanded_package['original_name'])

        code.append(self.create_code_block('empty_line'))

        # TODO level1, good example for else_if statement
        nested_if_level1 = []

        plugin_length = len(plugins)
        for plugin_index in range(0, len(plugins)):
            try:
                if plugin_index > 0 and plugin_index < len(plugins):
                    nested_if_level1.append('else if')
            except Exception as e:
                print('Error is  ', e)

            temp = 'contextObject  instanceof {0}'.format(plugins[plugin_index]['sbase'])
            nested_if_level1.append(temp)

            package_name = '{0}'.format(plugins[plugin_index]['package'])
            lower_sbase = strFunctions.lower_first(plugins[plugin_index]['sbase'])
            upper_sbase = strFunctions.upper_first(plugins[plugin_index]['sbase'])

            temp = '{0} {1} = ({0}) contextObject'.format(upper_sbase, lower_sbase)
            nested_if_level1.append(temp)

            temp = '{0} {1}{2} = ({0}) {3}.getPlugin({4}Constants.shortLabel)'.format( \
                package_name, lower_original_name, upper_sbase, lower_sbase, upper_original_name)

            nested_if_level1.append(temp)

            nested_if_level1.append(self.create_code_block('empty_line'))

            # # # TODO level2
            lo_extensions = plugins[plugin_index]['lo_extension']
            #
            # Check if plugin has lo_children
            if len(lo_extensions) > 0:
                nested_if_level2 = []
                for list_of_index in range(0, len(lo_extensions)):
                    temp_impl = []
                    if lo_extensions[list_of_index]['isListOf'] is True:
                        if list_of_index > 0 and list_of_index < len(lo_extensions):
                            temp_impl.append('else if')

                        # In some cases this is not useful
                        # list_of_name = strFunctions.lower_first(lo_extensions[list_of_index]['listOfClassName'])


                        list_of_name = 'listOf' + strFunctions.plural(lo_extensions[list_of_index]['name'])
                        type = lo_extensions[list_of_index]['name']
                        # temp_impl.append('else if')

                        temp0 = 'elementName.equals({0}List.{1}.name())'.format(upper_original_name, list_of_name)
                        temp_impl.append(temp0)
                        # temp_impl.append(self.create_code_block('empty_line'))

                        temp1 = 'ListOf<{0}> {1} = {2}{3}.get{4}()'.format(type, list_of_name,
                                                                           lower_original_name, upper_sbase,
                                                                           strFunctions.upper_first(list_of_name))

                        temp_impl.append(temp1)

                        temp2 = 'groupList = {0}List.{1}'.format(upper_original_name, list_of_name)
                        temp_impl.append(temp2)

                        temp3 = 'return {0}'.format(list_of_name)
                        temp_impl.append(temp3)
                        # This part was giving a problem

                        nested_if_level2 += temp_impl

                # Level 2 End
                # if else if in nested_level2 than create else_if block
                if 'else if' in nested_if_level2:
                    nested_if_level1.append(self.create_code_block('else_if', nested_if_level2))
                else:
                    nested_if_level1.append(self.create_code_block('if', nested_if_level2))
                # nested_if_level4.append(self.create_code_block('else_if', nested_if_level5))
                nested_if_level1.append(self.create_code_block('empty_line'))

            # # TODO level 1 continuation
            # Write parent lo_element for the plugin
            for data in self.data_to_write:
                for attrib in plugins[plugin_index]['attribs']:
                    if data['parent'] == attrib['element']:
                        nested_if_level1.append('else if')
                        temp = 'contextObject instanceof {0}'.format(data['parent'])
                        nested_if_level1.append(temp)

                        object_name = strFunctions.lower_first(data['parent'])
                        temp = '{0} {1} = ({0}) contextObject'.format(data['parent'],
                                                                      object_name)
                        nested_if_level1.append(temp)
                        nested_if_level1.append(self.create_code_block('empty_line'))

                        actual_list_of_data = data['data']
                        temp_impl = []

                        # # # TODO level2 inside of level 1
                        #
                        # #
                        # Check if plugin has lo_children
                        if len(actual_list_of_data) > 0:
                            nested_if_level2 = []
                            for list_of_index in range(0, len(actual_list_of_data)):
                                if actual_list_of_data[list_of_index]['original']['JClassType'] == 'ListOf':
                                    if list_of_index > 0 and list_of_index < len(actual_list_of_data):
                                        nested_if_level2.append('else if')

                                    list_of_name = strFunctions.lower_first(
                                        actual_list_of_data[list_of_index]['listName'])
                                    type = actual_list_of_data[list_of_index]['type']
                                    # temp_impl.append('else if')

                                    temp0 = 'elementName.equals({0}List.{1}.name())'.format(upper_original_name,
                                                                                            list_of_name)
                                    nested_if_level2.append(temp0)
                                    nested_if_level2.append(self.create_code_block('empty_line'))

                                    temp1 = 'ListOf<{0}> {1} = {2}.get{3}()'.format(type, list_of_name,
                                                                                    object_name,
                                                                                    strFunctions.upper_first(
                                                                                        list_of_name))

                                    nested_if_level2.append(temp1)

                                    temp2 = 'groupList = {0}List.{1}'.format(upper_original_name, list_of_name)
                                    nested_if_level2.append(temp2)

                                    temp3 = 'return {0}'.format(list_of_name)
                                    nested_if_level2.append(temp3)
                                    # This part was giving a problem

                            # Level 2 End
                            # if else if in nested_level2 than create else_if block
                            if 'else if' in nested_if_level2:
                                nested_if_level1.append(self.create_code_block('else_if', nested_if_level2))
                            else:
                                nested_if_level1.append(self.create_code_block('if', nested_if_level2))
                            # nested_if_level4.append(self.create_code_block('else_if', nested_if_level5))
                            nested_if_level1.append(self.create_code_block('empty_line'))

        # Continue level1 nested_if for ListOf<?>
        nested_if_level1.append('else if')
        temp = 'contextObject instanceof ListOf<?>'
        nested_if_level1.append(temp)

        temp = 'ListOf<SBase> listOf = (ListOf<SBase>) contextObject'
        nested_if_level1.append(temp)
        nested_if_level1.append(self.create_code_block('empty_line'))

        nested_if_level2 = []
        # Write plugin return list_of elements
        for plugin_index in range(0, len(plugins)):

            # If plugin is not of type Model break
            if 'Model' not in plugins[plugin_index]['name']:
                break

            plugin_name = plugins[plugin_index]['name']
            plugin_attribs = plugins[plugin_index]['attribs']
            # In some cases attribs has more than of type lo_elements
            add_else_index = 0

            for plugin_attribs_index in range(0, len(plugin_attribs)):

                if plugin_attribs[plugin_attribs_index]['type'] == 'lo_element':
                    try:
                        if plugin_attribs_index > add_else_index and plugin_attribs_index < len(plugin_attribs):
                            nested_if_level2.append('else if')
                    except Exception as e:
                        break

                    name = strFunctions.lower_first(plugin_attribs[plugin_attribs_index]['element'])
                    list_of_name = strFunctions.lower_first(plugin_attribs[plugin_attribs_index]['name'])

                    temp1 = 'elementName.equals({0}Constants.{1})'.format(upper_original_name, name)
                    temp2 = ' && '
                    temp3 = 'groupList.equals({0}List.{1})'.format(upper_original_name, list_of_name)
                    temp_final = temp1 + temp2 + temp3
                    nested_if_level2.append(temp_final)

                    temp = ' Model model = (Model) listOf.getParentSBMLObject()'
                    nested_if_level2.append(temp)
                    temp = '{0} extendedModel = ({0}) model.getExtension\
                            ({1}Constants.shortLabel)'.format(plugin_name, upper_original_name)
                    nested_if_level2.append(temp)
                    nested_if_level2.append(self.create_code_block('empty_line'))

                    temp = '{0} {1} = new {0}()'.format(plugin_attribs[plugin_attribs_index]['element'],
                                                        strFunctions.lower_first(
                                                            plugin_attribs[plugin_attribs_index]['element']))
                    nested_if_level2.append(temp)

                    # TODO  change this part in Plugin generator so it's not plural
                    add_method_name = plugin_attribs[plugin_attribs_index]['element']
                    temp = 'extendedModel.add{0}({1})'.format(add_method_name,
                                                              strFunctions.lower_first(
                                                                  plugin_attribs[plugin_attribs_index]['element']))
                    nested_if_level2.append(temp)
                    nested_if_level2.append(self.create_code_block('empty_line'))

                    temp = 'return {0}'.format(
                        strFunctions.lower_first(plugin_attribs[plugin_attribs_index]['element']))
                    nested_if_level2.append(temp)

                    # # #TODO continue level2 write parent child
                    # # #Write parent lo_element for the plugin parent lo_element
                    for data in self.data_to_write:
                        if data['parent'] == plugin_attribs[plugin_attribs_index]['element']:

                            actual_list_of_data = data['data']
                            # Check if plugin has lo_children
                            if len(actual_list_of_data) > 0:
                                for list_of_index in range(0, len(actual_list_of_data)):
                                    if actual_list_of_data[list_of_index]['original']['JClassType'] == 'ListOf':
                                        # if list_of_index > 0 and list_of_index < len(actual_list_of_data):
                                        nested_if_level2.append('else if')

                                        list_of_name = strFunctions.lower_first(
                                            actual_list_of_data[list_of_index]['listName'])
                                        type = actual_list_of_data[list_of_index]['type']
                                        lower_name = strFunctions.lower_first(
                                            actual_list_of_data[list_of_index]['type'])
                                        name = actual_list_of_data[list_of_index]['type']
                                        parent_name = data['parent']
                                        lower_parent_name = strFunctions.lower_first(data['parent'])

                                        temp1 = 'elementName.equals({0}Constants.{1})'.format(upper_original_name,
                                                                                              lower_name)
                                        temp2 = ' && '
                                        temp3 = 'groupList.equals({0}List.{1})'.format(upper_original_name,
                                                                                       list_of_name)
                                        temp_final = temp1 + temp2 + temp3
                                        nested_if_level2.append(temp_final)

                                        temp = '{0} {1} = ({0}) listOf.getParentSBMLObject()'.format(parent_name,
                                                                                                     lower_parent_name)
                                        nested_if_level2.append(temp)

                                        nested_if_level2.append(self.create_code_block('empty_line'))

                                        temp = '{0} {1} = new {0}()'.format(name, lower_name)
                                        nested_if_level2.append(temp)

                                        temp = '{0}.add{1}({2})'.format(lower_parent_name, name, lower_name)
                                        nested_if_level2.append(temp)

                                        nested_if_level2.append(self.create_code_block('empty_line'))

                                        temp3 = 'return {0}'.format(lower_name)
                                        nested_if_level2.append(temp3)




                else:
                    add_else_index += 1

        # Level 2 End
        # if else if in nested_level2 than create else_if block
        if 'else if' in nested_if_level2:
            nested_if_level1.append(self.create_code_block('else_if', nested_if_level2))
        # This is not a good state checker
        elif len(nested_if_level2) > 0:
            nested_if_level1.append(self.create_code_block('if', nested_if_level2))
        nested_if_level1.append(self.create_code_block('empty_line'))

        # if else if in nested list then create else_if block
        if 'else if' in nested_if_level1:
            code.append(self.create_code_block('else_if', nested_if_level1))
        else:
            code.append(self.create_code_block('if', nested_if_level1))

        code.append(self.create_code_block('empty_line'))

        # Write last return statement
        temp = ['return contextObject']
        code.append(self.create_code_block('line', temp))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    def write_write_element_parser(self):
        # do not write for C API
        if len(self.lo_elements) < 1:
            return
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'writeElement'
        # if function not in self.methods_to_write:
        #     return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.xml.parsers.WritingParser#writeElement(org.sbml.jsbml.xml.stax.SBMLObjectForXML, java.lang.Object)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = ['Override']

        return_type = 'void'

        arguments = ['SBMLObjectForXML xmlObject', 'Object sbmlElementToWrite']
        arguments_no_defaults = ['SBMLObjectForXML xmlObject', 'Object sbmlElementToWrite']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]
        plugins = self.expanded_package['plugins']

        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        lower_original_name = strFunctions.lower_first(self.expanded_package['original_name'])

        implementation = []
        implementation.append('logger.isDebugEnabled()')
        implementation.append('logger.debug("{0}Parser: writeElement")'.format(upper_original_name))

        code.append(self.create_code_block('if', implementation))
        code.append(self.create_code_block('empty_line'))

        # Start of level 1
        implementation = []
        implementation.append('sbmlElementToWrite instanceof SBase')
        implementation.append('SBase sbase = (SBase) sbmlElementToWrite')
        implementation.append(self.create_code_block('empty_line'))

        # Level 2
        nested_if_level2 = []
        nested_if_level2.append('!xmlObject.isSetName()')
        nested_if_level2.append(self.create_code_block('empty_line'))
        # nested_if_level2.append('SBase sbase = (SBase) sbmlElementToWrite')

        # Level 3
        nested_if_level3 = []
        nested_if_level3.append('sbase instanceof ListOf<?>')
        nested_if_level3.append('ListOf<?> listOf = (ListOf<?>) sbase')
        nested_if_level3.append(self.create_code_block('empty_line'))

        # Level4
        nested_if_level4 = []
        nested_if_level4.append('listOf.size() > 0')
        nested_if_level4.append(self.create_code_block('empty_line'))
        #
        # Level5
        if len(self.lo_elements) > 0:
            nested_if_level5 = []

            # Add lo_element for xmlObject
            for lo_element_index in range(0, len(self.lo_elements)):
                if lo_element_index > 0 and lo_element_index < len(self.lo_elements):
                    nested_if_level5.append('else if')

                name = self.lo_elements[lo_element_index]['name']

                # In some cases doesn't work
                # list_of_name = strFunctions.lower_first(self.lo_elements[lo_element_index]['listOfClassName'])
                list_of_name = 'listOf' + strFunctions.plural(self.lo_elements[lo_element_index]['name'])

                nested_if_level5.append('listOf.get(0) instanceof {0}'.format(name))
                nested_if_level5.append('xmlObject.setName({0}List.{1}.toString())'.format(upper_original_name,
                                                                                           list_of_name))

            # Level 4 End
            # If else if not in nested list don't create block of else_if
            if 'else if' in nested_if_level5:
                nested_if_level4.append(self.create_code_block('else_if', nested_if_level5))
            else:
                nested_if_level4.append(self.create_code_block('if', nested_if_level5))

            # nested_if_level4.append(self.create_code_block('else_if', nested_if_level5))
            nested_if_level4.append(self.create_code_block('empty_line'))

        # Level 3 End
        nested_if_level3.append(self.create_code_block('if', nested_if_level4))
        nested_if_level3.append(self.create_code_block('empty_line'))
        nested_if_level3.append('else')
        nested_if_level3.append('xmlObject.setName(sbase.getElementName())')
        nested_if_level3.append(self.create_code_block('empty_line'))

        # Level 2 End
        # nested_if_level2.append(self.create_code_block('empty_line'))
        nested_if_level2.append(self.create_code_block('if_else', nested_if_level3))

        # End of level 1
        implementation.append(self.create_code_block('empty_line'))
        implementation.append(self.create_code_block('if', nested_if_level2))
        implementation.append(self.create_code_block('empty_line'))

        code.append(self.create_code_block('if', implementation))
        code.append(self.create_code_block('empty_line'))

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': False,
                     'object_name': self.object_name,
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    ########################################################################

    # HELPER FUNCTIONS

    @staticmethod
    def create_code_block(code_type, lines=''):
        code = dict({'code_type': code_type, 'code': lines})
        return code
