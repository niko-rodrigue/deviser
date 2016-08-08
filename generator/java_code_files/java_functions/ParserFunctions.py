#!/usr/bin/env python
#
# @file    ParserFunctions.py
# @brief   class to create general functions
# @author  Frank Bergmann
# @author  Sarah Keating
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
                 jsbml_methods=None, prime_numbers = None, abstract_jsbml_methods = None, import_modules=None):
        self.language = language
        self.cap_language = language.upper()
        self.expanded_package = expanded_package_object
        self.package =  expanded_package_object['original_name']
        self.parser_name = expanded_package_object['name']
        self.original_name =  expanded_package_object['original_name']
        self.is_parser = True
        self.is_java_api = is_java_api


        # For tests
        self.run_tests = global_variables.running_tests

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


        # self.has_std_base = expanded_package_object['has_std_base']
        # self.base_class = expanded_package_object['baseClass']
        # self.is_java_api = is_java_api
        # self.is_list_of = is_list_of
        # self.is_plugin = False
        # if 'is_plugin' in expanded_package_object:
        #     self.is_plugin = expanded_package_object['is_plugin']
        # self.is_doc_plugin = False
        # if 'is_doc_plugin' in expanded_package_object:
        #     self.is_doc_plugin = expanded_package_object['is_doc_plugin']
        # self.ext_class = ''
        # if self.is_plugin:
        #     self.ext_class = expanded_package_object['sbase']
        # if is_list_of:
        #     self.child_name = expanded_package_object['lo_child']
        # else:
        #     self.child_name = ''
        if is_java_api:
            self.object_name = self.parser_name
            # self.object_child_name = self.child_name
        # else:
        #     if is_list_of:
        #         self.object_name = 'ListOf_t'
        #     else:
        #         self.object_name = self.class_name + '_t'
        #     self.object_child_name = self.child_name + '_t'
        # self.element_name = ''
        # self.override_name = False
        # if 'elementName' in expanded_package_object and not is_list_of:
        #     self.element_name = expanded_package_object['elementName']
        #     if self.element_name == '':
        #         self.override_name = False
        #     else:
        #         self.override_name = not \
        #             strFunctions.compare_no_case(self.element_name,
        #                                          self.class_name)
        # if not global_variables.is_package:
        #     self.override_name = True
        #     if is_list_of:
        #         self.element_name = \
        #             strFunctions.lower_list_of_name_no_prefix(expanded_package_object['elementName'])
        #     else:
        #         self.element_name = expanded_package_object['elementName']
        #
        #
        # self.typecode = expanded_package_object['typecode']
        # self.attributes = expanded_package_object['class_attributes']
        # self.sid_refs = expanded_package_object['sid_refs']
        # self.unit_sid_refs = expanded_package_object['unit_sid_refs']
        # self.child_lo_elements = expanded_package_object['child_lo_elements']
        # self.child_elements = expanded_package_object['child_elements']
        # self.has_math = expanded_package_object['has_math']
        # self.has_array = expanded_package_object['has_array']
        # self.overwrites_children = expanded_package_object['overwrites_children']
        # self.has_children = expanded_package_object['has_children']
        # self.has_only_math = expanded_package_object['has_only_math']
        # self.num_non_std_children = expanded_package_object['num_non_std_children']
        # self.num_children = expanded_package_object['num_children']
        # self.std_base = expanded_package_object['std_base']
        #
        # self.required = 'false'
        # if 'is_doc_plugin' in expanded_package_object:
        #     if expanded_package_object['reqd']:
        #         self.required = 'true'
        #
        # self.document = False
        # if 'document' in expanded_package_object:
        #     self.document = expanded_package_object['document']
        #
        # # useful variables
        # if not self.is_java_api and self.is_list_of:
        #     self.struct_name = self.object_child_name
        # else:
        #     self.struct_name = self.object_name
        # self.abbrev_parent = strFunctions.abbrev_name(self.object_name)
        # if self.is_java_api is False:
        #     self.true = '@c 1'
        #     self.false = '@c 0'
        # else:
        #     self.true = '@c true'
        #     self.false = '@c false'
        #
        # # status
        # if self.is_java_api:
        #     if self.is_list_of:
        #         self.status = 'cpp_list'
        #     else:
        #         self.status = 'cpp_not_list'
        # else:
        #     if self.is_list_of:
        #         self.status = 'c_list'
        #     else:
        #         self.status = 'c_not_list'
        #
        # # TODO GSOC 2016
        #


        self.attributeName = 'attributeName'
        self.prefix = 'prefix'
        self.value = 'value'


        self.duplicate_methods = []


        # self.methods_to_write = ['readAttribute', 'toString', 'writeXMLAttributes', 'hashCode']

        # if self.is_java_api == True:
        #     self.expand_methods_to_write()

    ########################################################################

        # TODO JSBML PLUGIN FUNCTION

    def write_get_short_label(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getShortLabel'

        title_line = '(non-Javadoc)-- @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()'
        params = ['@param None']
        return_lines = []
        additional = []
        additional.append('Override')

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
        additional = []
        additional.append('Override')

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
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'boolean'
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
        additional = []
        additional.append('Override')

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


    def write_get_package_namespaces(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getPackageNamespaces'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.xml.parsers.PackageParser#getPackageNamespaces()'
        params = ['@param None']
        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'List<String>'
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
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'List<String> '
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
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'String'
        arguments = ['int level', 'int version', 'int packageVersion']
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




        base_level =  self.expanded_package['base_level']
        base_version =  self.expanded_package['base_version']
        package_version =  self.expanded_package['pkg_version']
        package_name = self.expanded_package['original_name']

        implementation = ['level == {0} && version == {1} && packageVersion == {2}'.format(base_level, base_version,\
                                                                                           package_version)]

        self.namespace_uri = 'namespaceURI_L{0}V{1}V{2}'.format(base_level, base_version, package_version)
        implementation.append('return {0}Constants.{1}'.format(strFunctions.upper_first(self.package), self.namespace_uri))
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
        type = self.attributes[index]['attType']

        # implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, name, name)

        implement = ['{0}.equals({1}Constants.{2}'.format(self.attributeName, self.package, member_name),
                     'set{0}(StringTools.parseSBML{1}({2}))'.format(name, java_type, self.value)]  # 3rd line

        # temp_code1 = self.create_code_block('line', implement1)
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
            # if java_type_data in self.jsbml_data_tree['Difference']:
            #     data = self.jsbml_data_tree['Difference'][java_type_data]
            # else:
            #     data = None
            # if data is not None:
            #     java_type = data
            # else:
            java_type = java_type_data
        else:  # TODO needs to be modified
            java_type = java_type_data

        # implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, name, name)

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
            # temp_implementation.append('''throw new SBMLException("Could not recognized the value\'" + value + "\'for the attribute " + {0}Constants.{1} + " on the 'input' element.")'''.format(self.package, member_name))
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
            # print('Yolo ', e)
            pass
        # implementation.append('else if')



        # temp_code1 = self.create_code_block('line', implement1)
        # temp_code = self.create_code_block('else_if', implementation)
        # return temp_code
        return implementation

    def create_read_attribute_else(self):
        # name = self.attributes[index]['capAttName']
        # member_name = self.attributes[index]['name']
        # java_type = self.attributes[index]['JClassType']

        # implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, name, name)

        implementation = ['else', 'isAttributeRead = false']  # 3rd line

        # temp_code1 = self.create_code_block('line', implement1)
        # temp_code = self.create_code_block('else_if', implementation)
        # return temp_code
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
        # print('wahaha ', self.class_name)
        # print('len ', len(self.attributes))

        # line = self.create_code_block('empty_line', '')
        # code.append(line)

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
            temp = '{0} {1}Plugin = ({0}) (({2}) sbase).getExtension({3}Constants.namespaceURI)'.format(\
                package_name, lower_sbase, upper_sbase, upper_original_name)
            implementation.append(temp)
            code.append(self.create_code_block('if',implementation))


        # # TODO here is the bug what to do?
        # implementation_else_if = []
        # # each atribute has id and name, which are not a must for jsbml
        # if len(self.attributes) > 2:
        #     # if zone stuff
        #     implementation = ['!isAttributeRead']
        #
        #     implement_inside = ['isAttributeRead = true']
        #     line = self.create_code_block('line', implement_inside)
        #     implementation.append(line)
        #
        #     for i in range(0, len(self.attributes)):
        #         # print('i is ',i)s
        #         attribute = self.attributes[i]
        #         if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
        #             continue
        #         else:  # Here lies a bug
        #             temp_code = self.create_read_attribute_else_if(i)
        #             implementation_else_if += temp_code
        #             # else_if_index = i
        #             # break
        #             # code.append(temp_code[-1])
        #
        #     temp_code = self.create_read_attribute_else()
        #     implementation_else_if += temp_code
        #
        #     if len(implementation_else_if) == 4:
        #         temp_code = self.create_code_block('if_else', implementation_else_if)
        #     else:
        #         temp_code = self.create_code_block('else_if', implementation_else_if)
        #
        #     implementation.append(temp_code)
        #     code.append(self.create_code_block('if', implementation))
        #
        #
        #     # else:
        #     #     temp = ['return isAttributeRead']
        #     #     code.append(self.create_code_block('line', temp))
        #
        #     # print('yahoo ',implementation_else_if)
        #
        #     # try:
        #     #     if len(self.attributes) > 1:
        #     #         temp_code = self.create_read_attribute_else()
        #     #         implementation_else_if += temp_code
        #     #
        #     #         temp_code = self.create_code_block('else_if', implementation_else_if)
        #     #         implementation.append(temp_code)
        #     #         code.append(self.create_code_block('if', implementation))
        #     # except:
        #     #     pass
        #     # temp_code = self.create_code_block('else_if', implementation_else_if)
        #     # implementation.append(temp_code)
        #     # code.append(self.create_code_block('if', implementation))
        # #         #code.append(temp_code)
        # #         implementation.append(temp_code)
        # #     # implementation.append('')
        # #         code.append(self.create_code_block('if', implementation))
        # # except Exception as e:
        # #     print('Yolo test ', e)
        #
        #
        temp = ['return listOfElementsToWrite']
        code.append(self.create_code_block('line', temp))

        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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
        additional = []
        additional.append('Override')

        return_type = 'SBasePlugin'

        arguments = ['SBase sbase']
        arguments_no_defaults = ['SBase sbase']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]

        # print('wahaha ', self.class_name)
        # print('len ', len(self.attributes))

        # line = self.create_code_block('empty_line', '')
        # code.append(line)



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
        # temp = [
        #     'super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject)']
        # code.append(self.create_code_block('line', temp))

        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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


        plugins = self.expanded_package['plugins']



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
                     'boolean isLastAttribute',  'Object contextObject']  # , 'String prefix', 'String value']
        arguments_no_defaults =  ['String elementName', 'String attributeName',
                                  'String value', 'String uri', 'String prefix',
                                  'boolean isLastAttribute',  'Object contextObject']

        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]




        implementation = ['logger.debug("processAttribute -> " + prefix + ":" + attributeName \
        + " = " + value + " (" + contextObject.getClass().getName() + ")")']
        line = self.create_code_block('line', implementation)
        code.append(line)
        # print('wahaha ', self.class_name)
        # print('len ', len(self.attributes))

        # line = self.create_code_block('empty_line', '')
        # code.append(line)



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


            temp = '{0} {1}{2} = ({0}) {3}.getPlugin({4}Constants.shortLabel)'.format(\
                package_name, lower_original_name, upper_sbase,lower_sbase, upper_original_name)
            implementation.append(temp)

            temp = 'contextObject = {0}{1}'.format(lower_original_name, upper_sbase)
            implementation.append(temp)

            code.append(self.create_code_block('if', implementation))

        code.append(self.create_code_block('empty_line'))
        temp = ['super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject)']
        code.append(self.create_code_block('line', temp))

        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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

        # print('wahaha ', self.class_name)
        # print('len ', len(self.attributes))

        # line = self.create_code_block('empty_line', '')
        # code.append(line)



        baseElements = self.expanded_package['baseElements']
        #
        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        # lower_original_name = strFunctions.lower_first(self.expanded_package['original_name'])
        data_to_write = []
        for element in baseElements:
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
                            info_dict['data'].append({'listName':element_name, 'type': element_type,
                                                      'original':child_lo_element})
                data_to_write.append(info_dict)


        none_values = []
        elements = self.expanded_package['elements']
        add = True
        for element in elements:
            if element['listOfClassName'] != '':
                for data in data_to_write:
                    if strFunctions.lower_first(element['listOfClassName']) in data['data']:
                        add = False
                if add == True:
                    temp = {}
                    list_of_name = strFunctions.lower_first(element['listOfClassName'])
                    temp.update({'listOfName': list_of_name})
                    temp.update({'name': element['name']})
                    none_values.append(temp)
                else:
                    add = True


        self.none_values = none_values
        self.data_to_write = data_to_write

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

        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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
        arguments_no_defaults =['String elementName', 'String uri', 'String prefix',
                                'boolean hasAttributes', 'boolean hasNamespaces', 'Object contextObject']


        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = [self.create_code_block('empty_line')]
        plugins = self.expanded_package['plugins']

        upper_original_name = strFunctions.upper_first(self.expanded_package['original_name'])
        lower_original_name = strFunctions.lower_first(self.expanded_package['original_name'])
        implementation = []

        # for plugin_index in range(0, len(plugins)):
        #     try:
        #         if plugin_index > 0 and plugin_index < len(plugins):
        #             implementation.append('else if')
        #     except Exception as e:
        #         print('Yolo ', e)
        #         pass
        #
        #
        #     temp = 'contextObject  instanceof {0}'.format(plugins[plugin_index]['sbase'])
        #     implementation.append(temp)
        #
        #     package_name = '{0}'.format(plugins[plugin_index]['package'])
        #     lower_sbase = strFunctions.lower_first(plugins[plugin_index]['sbase'])
        #     upper_sbase = strFunctions.upper_first(plugins[plugin_index]['sbase'])
        #
        #     temp = '{0} {1} = ({0}) contextObject'.format(upper_sbase, lower_sbase)
        #     implementation.append(temp)
        #
        #     temp = '{0} {1}{2} = ({0}) {3}.getPlugin({4}Constants.shortLabel)'.format( \
        #         package_name, lower_original_name, upper_sbase, lower_sbase, upper_original_name)
        #     implementation.append(temp)

            # implementation.append(self.create_code_block('empty_line'))


            # # TODO Here is a problem
            # #TODO this solution works
            # lo_extensions = plugins[plugin_index]['lo_extension']
            # lo_impl = []
            # for list_of_index in range(0, len(lo_extensions)):
            #     temp_impl = []
            #     if lo_extensions[list_of_index]['isListOf'] is True:
            #         # if list_of_index >= 1 and list_of_index < len(lo_extensions):
            #         #     temp_impl.append('else if')
            #
            #
            #         list_of_name = strFunctions.lower_first(lo_extensions[list_of_index]['listOfClassName'])
            #         type = lo_extensions[list_of_index]['name']
            #         # temp_impl.append('else if')
            #
            #         temp0 = 'elementName.equals({0}List.{1}.name())'.format(upper_original_name, list_of_name)
            #         temp_impl.append(temp0)
            #         # temp_impl.append(self.create_code_block('empty_line'))
            #
            #         temp1 = 'ListOf<{0}> {1} = {2}{3}.get{4}()'.format(type, list_of_name,
            #                                                            lower_original_name, upper_sbase,
            #                                                            strFunctions.upper_first(list_of_name))
            #
            #         temp_impl.append(temp1)
            #
            #         temp2 = 'groupList = {0}List.{1}'.format(upper_original_name, list_of_name)
            #         temp_impl.append(temp2)
            #
            #         temp3 = 'return {0}'.format(list_of_name)
            #         temp_impl.append(temp3)
            #         #This part was giving a problem
            #
            #         # lo_impl += temp_impl
            #         implementation.append(self.create_code_block('empty_line'))
            #         implementation.append(self.create_code_block('if', temp_impl))

            # temp_impl.append(self.create_code_block('empty_line'))
            # implementation.append(self.create_code_block('else_if', lo_impl))
            # implementation.append(self.create_code_block('empty_line'))


            # # # #TODO there is a problem here
            # for data in self.data_to_write:
            #     for attrib in plugins[plugin_index]['attribs']:
            #         if data['parent'] == attrib['element']:
            #             implementation_temp = ['else if']
            #             temp = 'contextObject instanceof {0}'.format(data['parent'])
            #             implementation_temp.append(temp)
            #
            #
            #             object_name = strFunctions.lower_first(data['parent'])
            #             temp = '{0} {1} = ({0}) contextObject'.format(data['parent'],
            #                                                           object_name)
            #             implementation_temp.append(temp)
            #             implementation_temp.append(self.create_code_block('empty_line'))
            #
            #             actual_data = data['data']
            #             temp_impl = []


                        # TODO here's the error
                        # for actual_index in range(0, len(actual_data)):
                        #     if actual_index > 0 and actual_index < len(actual_data)-1:
                        #         temp_impl.append('else if')
                        #
                        #     list_of_name = strFunctions.lower_first(actual_data[actual_index]['listName'])
                        #     type = actual_data[actual_index]['type']
                        #     # temp_impl.append('else if')
                        #
                        #     temp0 = 'elementName.equals({0}List.{1}.name())'.format(upper_original_name,
                        #                                                             list_of_name)
                        #     temp_impl.append(temp0)
                        #     temp_impl.append(self.create_code_block('empty_line'))
                        #
                        #     temp1 = 'ListOf<{0}> {1} = {2}.get{3}()'.format(type, list_of_name,
                        #                                                        object_name,
                        #                                                        strFunctions.upper_first(
                        #                                                            list_of_name))
                        #
                        #     temp_impl.append(temp1)
                        #
                        #     temp2 = 'groupList = {0}List.{1}'.format(upper_original_name, list_of_name)
                        #     temp_impl.append(temp2)
                        #
                        #     temp3 = 'return {0}'.format(list_of_name)
                        #     temp_impl.append(temp3)
                        #     # This part was giving a problem
                        #
                        # implementation_temp.append(self.create_code_block('else_if', temp_impl))
                        # implementation_temp.append(self.create_code_block('empty_line'))
                        #
                        # # temp_code = self.create_code_block('else_if', implementation_temp)
                        # temp_code = implementation_temp
                        # implementation += temp_code

            #TODO


            # implementation.append(self.create_code_block('empty_line'))
        # if plugin_index < len(plugins):
        #     code.append(self.create_code_block('if', implementation))
        # else:
        # test = 1


        # For the first if statement
        # code.append(self.create_code_block('else_if', implementation))
        # code.append(self.create_code_block('empty_line'))
        # temp = [
        #     'super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject)']
        # code.append(self.create_code_block('line', temp))


        temp = ['return contextObject']
        code.append(self.create_code_block('line', temp))


        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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
        additional = []
        additional.append('Override')

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




        #Start of level 1
        implementation = []
        implementation.append('sbmlElementToWrite instanceof SBase')
        implementation.append('SBase sbase = (SBase) sbmlElementToWrite')
        implementation.append(self.create_code_block('empty_line'))


        #Level 2
        nested_if_level2 = []
        nested_if_level2.append('!xmlObject.isSetName()')
        nested_if_level2.append(self.create_code_block('empty_line'))
        # nested_if_level2.append('SBase sbase = (SBase) sbmlElementToWrite')

        #Level 3
        nested_if_level3 = []
        nested_if_level3.append('sbase instanceof ListOf<?>')
        nested_if_level3.append('ListOf<?> listOf = (ListOf<?>) sbase')
        nested_if_level3.append(self.create_code_block('empty_line'))


        # TODO level4?



        nested_if_level3.append('else')
        nested_if_level3.append('xmlObject.setName(sbase.getElementName())')
        nested_if_level3.append(self.create_code_block('empty_line'))



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




    def write_get_prefix(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getPrefix'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.ext.SBasePlugin#getPrefix()'
        params = ['@param None']
        return_lines = []
        additional = []
        additional.append('Override')

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



        temp = ['return {0}Constants.shortLabel'.format(self.package)]
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



    def write_get_parent(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getParent'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.ext.SBasePlugin#getParent()'
        params = ['@param None']
        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'SBMLDocument'
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

        implem = ['isSetExtendedSBase()', 'return (SBMLDocument) getExtendedSBase().getParent()']
        code.append(self.create_code_block('if', implem))

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

    def write_get_parent_sbml_object(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getParentSBMLObject'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.ext.SBasePlugin#getParentSBMLObject()'
        params = ['@param None']
        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'SBMLDocument'
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

        temp = ['return getParent()']
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


















    # This look like it is not required
    def expand_methods_to_write(self):
        for class_name in self.jsbml_methods:
            for method in self.jsbml_methods[class_name]:
                # print('method is ', method['functionName'])
                function_name = method['functionName']
                if function_name in ['readAttribute', 'toString', 'writeXMLAttributes', 'hashCode']:
                    if function_name not in self.methods_to_write:
                        self.methods_to_write.append(function_name)

        print('self write ', self.methods_to_write)


    ########################################################################


    #Function for writing get_child_at
    def create_nested_if_for_get_child_at(self, lo_element):
        name = lo_element['name']
        cap_name = lo_element['capAttName']
        # print('lo name ',name)
        # print('lo capname ', cap_name)
        # name = self.attributes[index]['capAttName']
        # member_name = self.attributes[index]['name']
        # type = self.attributes[index]['type']
        #
        # curr_att_type = attribute['JClassType']
        # oldValue = 'old{0}'.format(strFunctions.upper_first(attribute['name']))
        # currValue = 'this.{0}'.format(attribute['name'])
        #
        # implement_part1 = '{0} {1}  = this.{2}'.format(curr_att_type, oldValue, attribute['name'])
        # implement_part2 = '{0} = {1}'.format(currValue, attribute['name'])
        # implement_part3 = 'firePropertyChange({0}Constants.{1}, {2}, {3})'.format(self.package,
        #                                                                           attribute['name'],
        #                                                                           oldValue,
        #                                                                           currValue)
        #
        # # code = [dict({'code_type': 'line', 'code': 'TADA'})]


        if self.is_plugin is True:
            implementation = ['pos == index',
                              'return get{0}()'.format(cap_name)]  # 3rd line
            #
            nested_if = self.create_code_block('if', implementation)
            implementation = ['isSet{0}()'.format(cap_name),
                              nested_if, 'pos++']  # 2nd line
            # # print('implementation ',implementation)
            # # code.append(self.create_code_block('if', implementation))
            # code = [self.create_code_block('if', implementation)]
            #
            # implementationNext = ['return false']  # 1st line
            # code.append(self.create_code_block('line', implementationNext))
            #
            temp_code = self.create_code_block('if', implementation)
        else:
            implementation = ['pos == index',
                              'return getListOf{0}s()'.format(cap_name)]  # 3rd line
            #
            nested_if = self.create_code_block('if', implementation)
            implementation = ['isSetListOf{0}s()'.format(cap_name),
                              nested_if, 'pos++']  # 2nd line
            # # print('implementation ',implementation)
            # # code.append(self.create_code_block('if', implementation))
            # code = [self.create_code_block('if', implementation)]
            #
            # implementationNext = ['return false']  # 1st line
            # code.append(self.create_code_block('line', implementationNext))
            #
            temp_code = self.create_code_block('if', implementation)
        return temp_code


    def obtain_interface_abstract_methods(self):
        self.abstract_methods_to_write = []
        for interface_name in self.abstract_jsbml_methods:
            if self.jsbml_data_tree[interface_name]['writeAbstractMethods'] == True:
                # print(self.jsbml_data_tree[interface_name])
                self.abstract_methods_to_write = self.abstract_jsbml_methods[interface_name]
        try:
            return_val = len(self.abstract_methods_to_write['modules'])
        except:
            return_val = 0
        return return_val




    def write_interface_abstract_methods(self, index):
        if self.is_java_api is False:
            return

        code = []

        curr_method_original = self.abstract_methods_to_write['extends']['extendsOriginal']

        curr_method = self.abstract_methods_to_write['modules'][index]
        print(curr_method)


        access_type = curr_method['accessType']
        return_type = curr_method['returnType']
        is_abstract = curr_method['isAbstract']
        function = curr_method['functionName']
        title_line = '(non-Javadoc)--@see {0}#{1}()'.format(curr_method_original, function)
        params = []
        arguments = []
        constructor_args = []

        return_lines = []
        additional = []
        if is_abstract == True:
            additional.append('Override')

        if return_type != 'boolean':
            return_type = return_type.split('.')[-1]
            return_statement = 'null'
        else:
            return_statement = 'false'

        implementation = []
        implementation.append('return {0}'.format(return_statement))
        code.append(self.create_code_block('line', implementation))

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

    def write_get_child_at_special(self):
        function = 'getChildAt'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.AbstractSBase#getChildAt(int)'
        params = []

        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'TreeNode'
        arguments = ['int index']
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'

        implementation = []


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



    def write_get_child_at(self):
        if len(self.child_lo_elements) == 0:
            if self.is_plugin:
                return self.write_get_child_at_special()
            else:
                return
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getChildAt'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.AbstractSBase#getChildAt(int)'
        params = []

        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'TreeNode'
        arguments = ['int index']
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'


        implementation = []
        implementation.append('index < 0')
        implementation.append('throw new IndexOutOfBoundsException(MessageFormat.format('\
                              'resourceBundle.getString("IndexSurpassesBoundsException"), index, 0))')
        code.append(self.create_code_block('if', implementation))


        implementation = []
        if self.is_plugin is False:
            implementation.append('int count = super.getChildCount(), pos = 0')
            code.append(self.create_code_block('line', implementation))


            implementation = ['index < count']
            implementation.append('return super.getChildAt(index)')
            implementation.append('else')
            implementation.append('index -= count')
            code.append(self.create_code_block('if_else', implementation))
        else:
            implementation.append('int pos = 0')
            code.append(self.create_code_block('line', implementation))

        # additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
        #     self.jsbml_methods,
        #     function=function,
        #     return_type=return_type)
        #
        # if additional_add is not None:
        #     additional.append(additional_add)
        # title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
        #                                                                      function, function_args)


        for i in range(0, len(self.child_lo_elements)):
            lo_element = self.child_lo_elements[i]
            temp_code = self.create_nested_if_for_get_child_at(lo_element)
            code.append(temp_code)

        # temp = ['return hashCode']
        # code.append(self.create_code_block('line', temp))

        implementation= ['throw new IndexOutOfBoundsException(MessageFormat.format(\
                        resourceBundle.getString("IndexExceedsBoundsException"),\
                         index, Math.min(pos, 0)))']

        code.append(self.create_code_block('line', implementation))

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

    ########################################################################


    # Function for writing getChildCount

    def create_if_for_get_child_count(self, lo_element, type = 'element'):
        name = lo_element['name']
        cap_name = lo_element['capAttName']
        implementation = []
        if type == 'lo_element':
            if self.is_plugin is True:
                implementation.append('isSet{0}()'.format(cap_name))
            else:
                implementation.append('isSetListOf{0}s()'.format(cap_name))
        else:
            implementation.append('isSet{0}()'.format(cap_name))
        implementation.append('count++')


        temp_code = self.create_code_block('if', implementation)
        return temp_code


    def write_get_child_count_special(self):
        function = 'getChildCount'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.AbstractSBase#getChildAt(int)'
        params = []

        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'int'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'

        implementation = []


        temp = ['return 0']
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




    def write_get_child_count(self):
        if len(self.child_lo_elements) == 0:
            if self.is_plugin:
                return self.write_get_child_count_special()
            else:
                return
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getChildCount'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.AbstractSBase#getChildCount()'
        params = []

        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'int'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'



        implementation = []

        if self.is_plugin is True:
            implementation.append('int count = 0')
            code.append(self.create_code_block('line', implementation))
        else:
            implementation.append('int count = super.getChildCount()')
            code.append(self.create_code_block('line', implementation))




        # additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
        #     self.jsbml_methods,
        #     function=function,
        #     return_type=return_type)
        #
        # if additional_add is not None:
        #     additional.append(additional_add)
        # title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
        #                                                                      function, function_args)
        for i in range(0, len(self.child_elements)):
            element = self.child_elements[i]
            type = 'element'
            temp_code = self.create_if_for_get_child_count(element, type)
            code.append(temp_code)

        for i in range(0, len(self.child_lo_elements)):
            lo_element = self.child_lo_elements[i]
            type = 'lo_element'
            temp_code = self.create_if_for_get_child_count(lo_element, type)
            code.append(temp_code)

        # temp = ['return hashCode']
        # code.append(self.create_code_block('line', temp))

        implementation = ['return count']

        code.append(self.create_code_block('line', implementation))

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





    ########################################################################

    def write_get_allows_children_special(self):
        function = 'getAllowsChildren'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.AbstractSBase#getChildAt(int)'
        params = []

        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'boolean'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'

        implementation = []


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


    # function for writing get allows children
    def write_get_allows_children(self):
        if len(self.child_lo_elements) == 0:
            if self.is_plugin:
                return self.write_get_allows_children_special()
            else:
                return
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getAllowsChildren'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml#getAllowsChildren()'
        params = []

        return_lines = []
        additional = []
        additional.append('Override')

        # create function decl

        return_type = 'boolean'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'


        if self.has_children == True:
            code_to_add = 'true'
        else:
            code_to_add = 'false'
        implementation = []
        implementation.append('return {0}'.format(code_to_add))
        code.append(self.create_code_block('line', implementation))

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



    ########################################################################

    # Functions for writing hashCode
    def create_hashcode_if(self, attribute):
        name = attribute['capAttName']
        member_name = attribute['name']
        type = attribute['type']

        # TODO hashCode for enum and vectors
        if type == 'lo_element':
            implementation = ['hashCode = prime * hashCode\
        + (({0} == null) ? 0 : {1}.hashCode())'.format(attribute['jsbmlName'],attribute['jsbmlName'])]
            return self.create_code_block('line', implementation)

        implementation = ['isSet{0}()'.format(name)]
        if str(type)[:] == 'bool':
            implementation.append('hashCode += prime + (get{0}() ? 1 : -1)'.format(name))
        elif str(type)[:] == 'SIdRef':
            implementation.append('hashCode += prime * get{0}().hashCode()'.format(name))
        elif str(type)[:] == 'enum':
            implementation.append('hashCode += prime * get{0}().hashCode()'.format(name))
        elif str(type)[:] == 'uint':
            implementation.append('hashCode += prime * get{0}()'.format(name))
        elif str(type)[:] == 'double':
            implementation.append('hashCode += prime * get{0}()'.format(name))
        else:
            implementation.append('hashCode += prime')

        temp_code = self.create_code_block('if', implementation)
        return temp_code




    def write_hashcode(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'hashCode'
        if function not in self.methods_to_write:
            return

        title_line = 'hashcode method for {0}.'.format(self.object_name)
        params = ['@param None']
        return_lines = []
        additional = []
        additional.append('Override')


        # create function decl

        return_type = 'int'
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



        hash_num = jsbmlHelperFunctions.select_prime_number(self.prime_numbers, self.run_tests)

        implementation = ['final int prime = {0}'.format(hash_num)]
        line = self.create_code_block('line', implementation)
        code.append(line)

        implementation = ['int hashCode = super.hashCode()']
        line = self.create_code_block('line', implementation)
        code.append(line)

        for i in range(0, len(self.attributes)):
            attribute = self.attributes[i]
            if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                continue
            else:
                temp_code = self.create_hashcode_if(attribute)
                code.append(temp_code)

        if self.has_children == True:
            for i in range(0, len(self.child_lo_elements)):
                attribute = self.child_lo_elements[i]
                if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                    continue
                else:
                    temp_code = self.create_hashcode_if(attribute)
                    code.append(temp_code)

        temp = ['return hashCode']
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


    # Functions for writing hashCode
    def create_read_attribute_if(self, index):
        name = self.attributes[index]['capAttName']
        member_name = self.attributes[index]['name']
        java_type = self.attributes[index]['JClassType']
        type = self.attributes[index]['attType']

        # implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, name, name)

        implement = ['{0}.equals({1}Constants.{2}'.format(self.attributeName, self.package, member_name),
                          'set{0}(StringTools.parseSBML{1}({2}))'.format(name, java_type, self.value)]  # 3rd line

        # temp_code1 = self.create_code_block('line', implement1)
        temp_code = self.create_code_block('if', implement)
        return  temp_code


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
            # if java_type_data in self.jsbml_data_tree['Difference']:
            #     data = self.jsbml_data_tree['Difference'][java_type_data]
            # else:
            #     data = None
            # if data is not None:
            #     java_type = data
            # else:
            java_type = java_type_data
        else: #TODO needs to be modified
            java_type = java_type_data


        # implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, name, name)

        implementation = ['{0}.equals({1}Constants.{2})'.format(self.attributeName, self.package, member_name)]





        if str(type)[:] == 'SIdRef':
            implementation.append('set{0}({1})'.format(name, self.value))
        elif str(type)[:] == 'IDREF':
            implementation.append('set{0}({1})'.format(name, self.value))
        elif type == 'enum':
            temp_implementation = []

            temp_implementation.append('set{0}({1}.valueOf(value))'.format(name,java_type))
            temp_implementation.append('catch')
            temp_implementation.append('Exception e')
            # temp_implementation.append('''throw new SBMLException("Could not recognized the value\'" + value + "\'for the attribute " + {0}Constants.{1} + " on the 'input' element.")'''.format(self.package, member_name))
            temp_implementation.append('throw new SBMLException("Could not recognized '
                                       'the value \'" +\
                                        value + "\' for the attribute " + \
                                        {0}Constants.{1} + " on the \'{2}\' element.")'.format(self.package, member_name, self.class_name))

            implementation.append(self.create_code_block('try', temp_implementation))
        elif type == 'SpatialKind':
            implementation.append('set{0}({1}.valueOf(value))'.format(name, java_type))
        else:
            implementation.append('set{0}(StringTools.parseSBML{1}({2}))'.format(name, java_type, self.value))


        try:
            if index < len(self.attributes)-1:
                implementation.append('else if')
        except Exception as e:
            # print('Yolo ', e)
            pass
        # implementation.append('else if')



        # temp_code1 = self.create_code_block('line', implement1)
        # temp_code = self.create_code_block('else_if', implementation)
        # return temp_code
        return implementation

    def create_read_attribute_else(self):
        # name = self.attributes[index]['capAttName']
        # member_name = self.attributes[index]['name']
        # java_type = self.attributes[index]['JClassType']

        # implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, name, name)

        implementation = ['else', 'isAttributeRead = false']  # 3rd line

        # temp_code1 = self.create_code_block('line', implement1)
        # temp_code = self.create_code_block('else_if', implementation)
        # return temp_code
        return implementation


    # Functions for writing readAttributes
    def write_read_attribute(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'readAttribute'
        if function not in self.methods_to_write:
            return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String, java.lang.String, java.lang.String)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'boolean'
        arguments = ['String attributeName'] #, 'String prefix', 'String value']
        arguments_no_defaults = ['String {0}'.format(self.attributeName),
                                 'String {0}'.format(self.prefix), 'String {0}'.format(self.value)]
        # create the function implementation
        args = [] # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = []

        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function=function,
            return_type=return_type)

        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
                                                                             function, function_args)


        if self.is_plugin is True:
            implementation = ['boolean isAttributeRead = false']
            line = self.create_code_block('line', implementation)
            code.append(line)
        else:
            implementation = ['boolean isAttributeRead = super.readAttribute({0}, {1}, {2})'.format(self.attributeName,
                                                                                                    self.prefix,
                                                                                                    self.value)]
            line = self.create_code_block('line', implementation)
            code.append(line)
        # print('wahaha ', self.class_name)
        # print('len ', len(self.attributes))



        # TODO here is the bug what to do?
        implementation_else_if = []
        #each atribute has id and name, which are not a must for jsbml
        if len(self.attributes) > 2:
            # if zone stuff
            implementation = ['!isAttributeRead']

            implement_inside = ['isAttributeRead = true']
            line = self.create_code_block('line', implement_inside)
            implementation.append(line)



            for i in range(0, len(self.attributes)):
                #print('i is ',i)s
                attribute = self.attributes[i]
                if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                    continue
                else: #Here lies a bug
                    temp_code = self.create_read_attribute_else_if(i)
                    implementation_else_if += temp_code
                    # else_if_index = i
                    # break
                    # code.append(temp_code[-1])

            temp_code = self.create_read_attribute_else()
            implementation_else_if += temp_code

            if len(implementation_else_if) == 4:
                temp_code = self.create_code_block('if_else', implementation_else_if)
            else:
                temp_code = self.create_code_block('else_if', implementation_else_if)


            implementation.append(temp_code)
            code.append(self.create_code_block('if', implementation))


        # else:
        #     temp = ['return isAttributeRead']
        #     code.append(self.create_code_block('line', temp))

        # print('yahoo ',implementation_else_if)

        # try:
        #     if len(self.attributes) > 1:
        #         temp_code = self.create_read_attribute_else()
        #         implementation_else_if += temp_code
        #
        #         temp_code = self.create_code_block('else_if', implementation_else_if)
        #         implementation.append(temp_code)
        #         code.append(self.create_code_block('if', implementation))
        # except:
        #     pass
            # temp_code = self.create_code_block('else_if', implementation_else_if)
            # implementation.append(temp_code)
            # code.append(self.create_code_block('if', implementation))
        #         #code.append(temp_code)
        #         implementation.append(temp_code)
        #     # implementation.append('')
        #         code.append(self.create_code_block('if', implementation))
        # except Exception as e:
        #     print('Yolo test ', e)


        temp = ['return isAttributeRead']
        code.append(self.create_code_block('line', temp))

        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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


    # Functions for writing hashCode
    def create_xml_attributes_if(self, index):
        name = self.attributes[index]['capAttName']
        member_name = self.attributes[index]['name']
        type = self.attributes[index]['type']
        jclass_type = self.attributes[index]['JClassType']

        implementation = ['isSet{0}()'.format(name)]
        if str(type)[:] == 'SId' or str(type)[:] == 'string':
            implementation.append('attributes.remove("{0}")'.format(member_name))
            implementation.append('attributes.put({0}Constants.shortLabel + ":{1}",  get{2}())'.format(
                                                                        self.package,  member_name, name))
        elif str(type)[:] == 'bool':
            implementation.append('attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, {3}.toString(get{4}()))'.format(
                                                                        self.package, self.package, member_name, jclass_type,  name))
        elif str(type)[:] == 'SIdRef':
            implementation.append('attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2},  get{3}())'.format(
                                                                        self.package, self.package, member_name, name))
        elif str(type)[:] == 'IDREF':
            implementation.append('attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2},  get{3}())'.format(
                self.package, self.package, member_name, name))
        elif str(type)[:] == 'uint':
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, {3}.toString(get{4}()))'.format(
                    self.package, self.package, member_name, jclass_type, name))
        elif str(type)[:] == 'enum':
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, get{3}().toString())'.format(
                    self.package, self.package, member_name, strFunctions.upper_first(member_name)))
        elif str(type)[:] == 'int':
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, Integer.toString(get{3}()))'.format(
                    self.package, self.package, member_name, strFunctions.upper_first(member_name)))
        elif str(type)[:] == 'double':
            # TODO yay
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, StringTools.toString(Locale.ENGLISH, \
                get{3}()))'.format(self.package, self.package, member_name, strFunctions.upper_first(member_name)))
        elif str(type)[:] == 'SpatialKind':
            implementation.append('attributes.remove("{0}")'.format(member_name))
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, {3}.toString())'.format(
                    self.package, self.package, member_name, member_name))
        elif str(jclass_type)[:] == 'Term':
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, {3}.getId())'.format(
                    self.package, self.package, member_name, member_name))
        else:
            implementation.append('hashCode += prime')

        temp_code = self.create_code_block('if', implementation)
        return temp_code






    # GSOC 2016 Function for writing  xml attributes
    def write_write_xml_attribute(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        # Check if method is required
        function = 'writeXMLAttributes'
        if function not in self.methods_to_write:
            return

        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'Map <String, String>'
        arguments = []
        arguments_no_defaults = []
        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = []

        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function=function,
            return_type=return_type)

        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
                                                                             function, function_args)

        implementation = ['{0} attributes = super.writeXMLAttributes()'.format(return_type)]
        line = self.create_code_block('line', implementation)
        code.append(line)
        # print('wahaha ', self.class_name)
        # print('len ', len(self.attributes))



        # TODO here is the bug what to do?
        implementation_else_if = []
        # each atribute has id and name, which are not a must for jsbml
        # if len(self.attributes) > 2:
        for i in range(0, len(self.attributes)):
            # print('i is ',i)s
            temp_code = self.create_xml_attributes_if(i)
            code.append(temp_code)


        temp = ['return attributes']
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

    # StringBuilder Approach
    def create_to_string(self):

        text = ''

        implementation_create = []
        if len(self.attributes) >= 1:
            for index in range(0, len(self.attributes)):
                # print('i is ',i)s
                attribute = self.attributes[index]
                name = self.attributes[index]['capAttName']
                member_name = self.attributes[index]['name']
                type = self.attributes[index]['type']
                if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                    continue
                else:
                    # Stop generating for math elements
                    if index == len(self.attributes) - 1 and len(self.child_elements) == 0 \
                            and len(self.child_lo_elements) == 0:
                        text += '{0} = " + {1} '.format(member_name, member_name)
                        implementation_create.append('builder.append("{0} = ")'.format(member_name))
                        implementation_create.append('builder.append({0})'.format(member_name))
                    else:
                        text += '{0} = " + {1} + ", '.format(member_name, member_name)
                        implementation_create.append('builder.append("{0} = ")'.format(member_name))
                        implementation_create.append('builder.append({0})'.format(member_name))
                        implementation_create.append('builder.append(", ")')
                        # else_if_index = i
                        # break
                        # code.append(temp_code[-1])

        if len(self.child_elements) >= 1:
            for index in range(0, len(self.child_elements)):
                # print('i is ',i)s
                attribute = self.child_elements[index]
                name = self.child_elements[index]['capAttName']
                member_name = self.child_elements[index]['name']
                type = self.child_elements[index]['type']
                if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                    continue
                else:
                    # Stop generating for math elements
                    if index == len(self.child_elements) - 1 and len(self.child_lo_elements) == 0:
                        text += '{0} = " + {1}'.format(member_name, member_name)
                        implementation_create.append('builder.append("{0} = ")'.format(member_name))
                        implementation_create.append('builder.append({0})'.format(member_name))
                    else:
                        text += '{0} = " + {1} + ", '.format(member_name, member_name)
                        implementation_create.append('builder.append("{0} = ")'.format(member_name))
                        implementation_create.append('builder.append({0})'.format(member_name))
                        implementation_create.append('builder.append(", ")')

                        # else_if_index = i
                        # break
                        # code.append(temp_code[-1])

        if len(self.child_lo_elements) >= 1:
            for index in range(0, len(self.child_lo_elements)):
                # print('i is ',i)s
                attribute = self.child_lo_elements[index]
                name = self.child_lo_elements[index]['capAttName']
                member_name = self.child_lo_elements[index]['name']
                jsbml_name = self.child_lo_elements[index]['jsbmlName']
                type = self.child_lo_elements[index]['type']
                if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                    continue
                else:
                    # Stop generating for math elements
                    if index == len(self.child_lo_elements) - 1:
                        text += '{0} = " + {1}'.format(jsbml_name, jsbml_name)
                        implementation_create.append('builder.append("{0} = ")'.format(jsbml_name))
                        implementation_create.append('builder.append({0})'.format(jsbml_name))
                    else:
                        text += '{0} = " + {1} + ", '.format(jsbml_name, jsbml_name)
                        implementation_create.append('builder.append("{0} = ")'.format(jsbml_name))
                        implementation_create.append('builder.append({0})'.format(jsbml_name))
                        implementation_create.append('builder.append(", ")')
                        # else_if_index = i
                        # break
                        # code.append(temp_code[-1])

        return implementation_create #text

    def write_to_string(self):
        # do not write for C API
        if self.is_java_api is False:
            return

        # Check if method is required
        function = 'toString'
        if function not in self.methods_to_write:
            return

        # create doc string header
        title_line = '(non-Javadoc)--see java.lang.Object#toString()'.format(self.object_name)
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'String'
        arguments = ['']  # , 'String prefix', 'String value']
        arguments_no_defaults = ['']
        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = []

        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function=function,
            return_type=return_type)

        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
                                                                             function, function_args)

        text = 'return "{0} ['.format(self.class_name)

        #text_rest = self.create_to_string()
        implementation_rest = self.create_to_string()

        implementation = ['StringBuilder builder = new StringBuilder()']
        implementation.append('builder.append("{0} [")'.format(self.class_name))

        # implementation += implementation_rest


        # TODO here are the biggest problems
        # For math element
        try:
            import_module = self.import_modules[0]
        except:
            import_module = None

        if import_module in self.jsbml_data_tree:
            if 'id' in self.jsbml_data_tree[import_module]['ignore'] or \
                            'name' in self.jsbml_data_tree[import_module]['ignore']:
                # text += text_rest
                implementation += implementation_rest
                text += '+ "isSetMath = " + isSetMath() + "]"'
                implementation.append('builder.append("isSetMath = ")')
                implementation.append('builder.append(isSetMath())')
                implementation.append('builder.append("]")')
            else:
                # text += text_rest
                implementation += implementation_rest
                result = jsbmlHelperFunctions.detect_ast_or_xml(self.child_elements)
                if result == False:
                    if self.is_plugin is False:
                        # text += '+ "id = " + getId() + ", name = " + getName() + "]"'
                        implementation.append('builder.append(", id = ")')
                        implementation.append('builder.append(getId())')
                        implementation.append('builder.append(", name = ")')
                        implementation.append('builder.append(getName())')
                        implementation.append('builder.append("]")')
                else:
                    # text += '"]"'
                    implementation.append('builder.append("]")')
        # temp = [text]


        # final return statement
        text = 'return builder.toString()'
        implementation.append(text)

        # code.append(self.create_code_block('line', temp))
        code.append(self.create_code_block('line', implementation))

        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     args += ['delete {0}'.format(member)]
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['rhs.{0} != NULL'.format(member),
        #                       '{0} = rhs.{0}->{1}()'.format(member,
        #                                                     clone),
        #                       'else', '{0} = NULL'.format(member)]
        #     args += [self.create_code_block('if_else', implementation)]
        # implementation = args
        # if self.has_children:
        #     implementation.append('connectToChild()')
        # if self.document:
        #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
        #
        # implementation2 = ['return *this']
        # code = [dict({'code_type': 'if', 'code': implementation}),
        #         dict({'code_type': 'line', 'code': implementation2})]

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

    ############################################################################


    #############################################################################




    # Functions for writing renamesidref
    # not StringBuilderApproach
    # def  create_to_string(self):
    #
    #     text = ''
    #     if len(self.attributes) >= 1:
    #         for index in range(0, len(self.attributes)):
    #             # print('i is ',i)s
    #             attribute = self.attributes[index]
    #             name = self.attributes[index]['capAttName']
    #             member_name = self.attributes[index]['name']
    #             type = self.attributes[index]['type']
    #             if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
    #                 continue
    #             else:
    #                 # Stop generating for math elements
    #                 if index == len(self.attributes)-1 and len(self.child_elements) == 0\
    #                         and len(self.child_lo_elements) == 0:
    #                     text += '{0} = " + {1} '.format(member_name, member_name)
    #                 else:
    #                     text += '{0} = " + {1} + ", '.format(member_name, member_name)
    #                 # else_if_index = i
    #                 # break
    #                 # code.append(temp_code[-1])
    #
    #
    #     if len(self.child_elements) >= 1:
    #         for index in range(0, len(self.child_elements)):
    #             # print('i is ',i)s
    #             attribute = self.child_elements[index]
    #             name = self.child_elements[index]['capAttName']
    #             member_name = self.child_elements[index]['name']
    #             type = self.child_elements[index]['type']
    #             if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
    #                 continue
    #             else:
    #                 # Stop generating for math elements
    #                 if index == len(self.child_elements)-1 and len(self.child_lo_elements) == 0:
    #                     text += '{0} = " + {1}'.format(member_name, member_name)
    #                 else:
    #                     text += '{0} = " + {1} + ", '.format(member_name, member_name)
    #
    #                 # else_if_index = i
    #                 # break
    #                 # code.append(temp_code[-1])
    #
    #     if len(self.child_lo_elements) >= 1:
    #         for index in range(0, len(self.child_lo_elements)):
    #             # print('i is ',i)s
    #             attribute = self.child_lo_elements[index]
    #             name = self.child_lo_elements[index]['capAttName']
    #             member_name = self.child_lo_elements[index]['name']
    #             jsbml_name = self.child_lo_elements[index]['jsbmlName']
    #             type = self.child_lo_elements[index]['type']
    #             if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
    #                 continue
    #             else:
    #                 # Stop generating for math elements
    #                 if index == len(self.child_lo_elements)-1 :
    #                     text += '{0} = " + {1}'.format(jsbml_name, jsbml_name)
    #                 else:
    #                     text += '{0} = " + {1} + ", '.format(jsbml_name, jsbml_name)
    #                 # else_if_index = i
    #                 # break
    #                 # code.append(temp_code[-1])
    #
    #     return text
    #
    #
    #
    # def write_to_string(self):
    #     # do not write for C API
    #     if self.is_java_api is False:
    #         return
    #
    #     # Check if method is required
    #     function = 'toString'
    #     if function not in self.methods_to_write:
    #         return
    #
    #
    #     # create doc string header
    #     title_line = '(non-Javadoc)--see java.lang.Object#toString()'.format(self.object_name)
    #     params = ['@param rhs the {0} object whose values are to be used '
    #               'as the basis of the assignment.'.format(self.object_name)]
    #     return_lines = []
    #     additional = []
    #     additional.append('Override')
    #
    #     return_type = 'String'
    #     arguments = ['']  # , 'String prefix', 'String value']
    #     arguments_no_defaults = ['']
    #     # create the function implementation
    #     args = []  # ['&rhs != this'] + self.write_assignment_args(self)
    #     clone = 'clone'
    #
    #     code = []
    #
    #     additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
    #         self.jsbml_methods,
    #         function=function,
    #         return_type=return_type)
    #
    #     if additional_add is not None:
    #         additional.append(additional_add)
    #         title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
    #                                                                          function, function_args)
    #
    #
    #     text = 'return "{0} ['.format(self.class_name)
    #
    #     text_rest = self.create_to_string()
    #
    #     # TODO here are the biggest problems
    #     #For math element
    #     try:
    #         import_module = self.import_modules[0]
    #     except:
    #         import_module = None
    #
    #     if import_module in self.jsbml_data_tree:
    #         if 'id' in self.jsbml_data_tree[import_module]['ignore'] or \
    #                         'name' in self.jsbml_data_tree[import_module]['ignore']:
    #             text += text_rest
    #             text += '+ "isSetMath = " + isSetMath() + "]"'
    #         else:
    #             text += text_rest
    #             result = jsbmlHelperFunctions.detect_ast_or_xml(self.child_elements)
    #             if result == False:
    #                 text += '+ "id = " + getId() + ", name = " + getName() + "]"'
    #             else:
    #                 text += '"]"'
    #
    #     temp = [text]
    #     code.append(self.create_code_block('line', temp))
    #
    #     # for i in range(0, len(self.child_elements)):
    #     #     element = self.child_elements[i]
    #     #     member = element['memberName']
    #     #     args += ['delete {0}'.format(member)]
    #     #     if element['element'] == 'ASTNode':
    #     #         clone = 'deepCopy'
    #     #     implementation = ['rhs.{0} != NULL'.format(member),
    #     #                       '{0} = rhs.{0}->{1}()'.format(member,
    #     #                                                     clone),
    #     #                       'else', '{0} = NULL'.format(member)]
    #     #     args += [self.create_code_block('if_else', implementation)]
    #     # implementation = args
    #     # if self.has_children:
    #     #     implementation.append('connectToChild()')
    #     # if self.document:
    #     #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
    #     #
    #     # implementation2 = ['return *this']
    #     # code = [dict({'code_type': 'if', 'code': implementation}),
    #     #         dict({'code_type': 'line', 'code': implementation2})]
    #
    #     return dict({'title_line': title_line,
    #                  'params': params,
    #                  'return_lines': return_lines,
    #                  'additional': additional,
    #                  'function': function,
    #                  'return_type': return_type,
    #                  'arguments': arguments,
    #                  'constant': False,
    #                  'virtual': False,
    #                  'object_name': self.object_name,
    #                  'args_no_defaults': arguments_no_defaults,
    #                  'implementation': code})


    # function to write rename_sid_ref
    def write_rename_sidrefs(self):
        # only write is not list of and has sidrefs
        if not self.status == 'cpp_not_list':
            return
        elif len(self.sid_refs) == 0 and len(self.unit_sid_refs) == 0\
                and not self.has_math:
            return

        # create comment parts
        title_line = '@copydoc doc_renamesidref_common'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'renameSIdRefs'
        return_type = 'void'
        arguments = ['const std::string& oldid', 'const std::string& newid']

        # create the function implementation
        code = []
        for i in range(0, len(self.sid_refs)):
            ref = self.sid_refs[i]
            implementation = ['isSet{0}() && {1} == '
                              'oldid'.format(ref['capAttName'],
                                             ref['memberName']),
                              'set{0}(newid)'.format(ref['capAttName'])]
            code.append(dict({'code_type': 'if', 'code': implementation}))
        for i in range(0, len(self.unit_sid_refs)):
            ref = self.unit_sid_refs[i]
            implementation = ['isSet{0}() && {1} == '
                              'oldid'.format(ref['capAttName'],
                                             ref['memberName']),
                              'set{0}(newid)'.format(ref['capAttName'])]
            code.append(dict({'code_type': 'if', 'code': implementation}))
        if self.has_math:
            implementation = ['isSetMath()',
                              'mMath->renameSIdRefs(oldid, newid)']
            code.append(self.create_code_block('if', implementation))

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing get element/typecode functionss

    # function to write getElement
    def write_get_element_name(self):
        if not self.is_java_api:
            return
        # create comment parts
        if self.override_name:
            name = self.element_name
        else:
            name = strFunctions.lower_first(self.object_name)
        title_line = 'Returns the XML element name of this {0} object.'\
            .format(self.object_name,)
        params = ['For {0}, the XML element name is always @c '
                  '\"{1}\".'.format(self.object_name, name)]
        return_lines = ['@return the name of this element, i.e. @c \"{0}\"'
                        '.'.format(name)]
        additional = []

        # create the function declaration
        arguments = []
        function = 'getElementName'
        return_type = 'const std::string&'

        # create the function implementation
        if self.overwrites_children:
            implementation = ['return mElementName']
        else:
            implementation = ['static const string name = \"{0}\"'.format(name),
                              'return name']
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
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write getTypeCode
    def write_get_typecode(self):
        if not self.is_java_api:
            return

        # create comment
        title_line = 'Returns the lib{0} type code for this {1} object.'\
            .format(self.cap_language, self.object_name)
        params = ['@copydetails doc_what_are_typecodes']
        return_lines = ['@return the {0} type code for this '
                        'object:'.format(self.cap_language)]
        additional = []
        if self.is_list_of:
            line = '@{0}constant{2}{1}_LIST_OF, ' \
                   '{1}TypeCode_t{3}'.format(self.language, self.cap_language,
                                             '{', '}')
        else:
            line = '@{0}constant{1}{2}, {3}{4}' \
                   'TypeCode_t{5}'.format(self.language, '{', self.typecode,
                                          self.cap_language, self.package, '}')
        additional.append(line)
        additional.append(' ')
        additional.append('@copydetails doc_warning_typecodes_not_unique')
        if not self.is_list_of:
            additional.append(' ')
            additional.append('@see getElementName()')
            if global_variables.is_package:
                additional.append('@see getPackageName()')

        # create function declaration
        function = 'getTypeCode'
        arguments = []
        return_type = 'int'

        # create the function implementation
        if self.is_list_of:
            implementation = ['return {0}_LIST_OF'.format(self.cap_language)]
        else:
            implementation = ['return {0}'.format(self.typecode)]
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
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write getTypeCode
    def write_get_item_typecode(self):
        # only needed for cpp list of class
        if not self.status == 'cpp_list':
            return
        # create comment
        title_line = 'Returns the lib{0} type code for the {0} objects ' \
                     'contained in this {1} object.'.format(self.cap_language,
                                                            self.object_name)
        params = ['@copydetails doc_what_are_typecodes']
        return_lines = ['@return the {0} typecode for the '
                        'objects contained in this '
                        '{1}:'.format(self.cap_language, self.object_name)]
        additional = []
        line = '@{0}constant{1}{2}, {3}{4}TypeCode_t{5}' \
               ''.format(self.language, '{', self.typecode, self.cap_language,
                         self.package, '}')
        additional.append(line)
        additional.append(' ')
        additional.append('@copydetails doc_warning_typecodes_not_unique')
        additional.append(' ')
        additional.append('@see getElementName()')
        if global_variables.is_package:
            additional.append('@see getPackageName()')

        # create function declaration
        function = 'getItemTypeCode'
        arguments = []
        return_type = 'int'

        # create the function implementation
        implementation = ['return {0}'.format(self.typecode)]
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
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing checking necessary children status

    # function to write hasRequiredAttributes
    def write_has_required_attributes(self):
        if self.has_std_base and len(self.attributes) == 0:
            return

        # create comment parts
        title_line = 'Predicate returning {0} if all the required ' \
                     'attributes for this {1} object have been set.'\
            .format(self.true, self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))

        return_lines = ['@return {0} to indicate that all the required '
                        'attributes of this {1} have been set, otherwise '
                        '{2} is returned.'.format(self.true, self.object_name,
                                                  self.false)]
        additional = [' ', '@note The required attributes for the {0} object'
                           ' are:'.format(self.object_name)]
        for i in range(0, len(self.attributes)):
            if self.attributes[i]['reqd']:
                att_name = self.attributes[i]['xml_name']
                additional.append('@li \"{0}\"'.format(att_name))

        # create the function declaration
        if self.is_java_api:
            function = 'hasRequiredAttributes'
            return_type = 'bool'
        else:
            function = '{0}_hasRequiredAttributes'.format(self.class_name)
            return_type = 'int'

        arguments = []
        if not self.is_java_api:
            arguments.append('const {0} * {1}'
                             .format(self.object_name, self.abbrev_parent))

        # create the function implementation
        if self.is_java_api:
            if self.has_std_base:
                all_present = 'true'
            else:
                all_present = '{0}::hasRequired' \
                              'Attributes()'.format(self.base_class)
            code = [dict({'code_type': 'line',
                          'code': ['bool all'
                                   'Present = {0}'.format(all_present)]})]
            for i in range(0, len(self.attributes)):
                att = self.attributes[i]
                if att['reqd']:
                    implementation = ['isSet{0}() == '
                                      'false'.format(att['capAttName']),
                                      'allPresent = false']
                    code.append(dict({'code_type': 'if',
                                      'code': implementation}))
            code.append(dict({'code_type': 'line',
                              'code': ['return allPresent']}))
        else:
            line = ['return ({0} != NULL) ? static_cast<int>({0}->'
                    'hasRequiredAttributes()) : 0'.format(self.abbrev_parent)]
            code = [dict({'code_type': 'line', 'code': line})]

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write hasRequiredElements
    def write_has_required_elements(self):
        if not self.has_children:
            return

        # create comment parts
        title_line = 'Predicate returning {0} if all the required ' \
                     'elements for this {1} object have been set.'\
            .format(self.true, self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(self.abbrev_parent, self.object_name))

        return_lines = ['@return {0} to indicate that all the required '
                        'elements of this {1} have been set, otherwise '
                        '{2} is returned.'.format(self.true, self.object_name,
                                                  self.false)]
        additional = [' ', '@note The required elements for the {0} object'
                           ' are:'.format(self.object_name)]
        for i in range(0, len(self.child_elements)):
            if self.child_elements[i]['reqd']:
                additional.append('@li \"{0}\"'
                                  .format(self.child_elements[i]['name']))
        for i in range(0, len(self.child_lo_elements)):
            if self.child_lo_elements[i]['reqd']:
                additional.append('@li \"{0}\"'
                                  .format(self.child_lo_elements[i]['name']))

        # create the function declaration
        if self.is_java_api:
            function = 'hasRequiredElements'
            return_type = 'bool'
        else:
            function = '{0}_hasRequiredElements'.format(self.class_name)
            return_type = 'int'

        arguments = []
        if not self.is_java_api:
            arguments.append('const {0} * {1}'
                             .format(self.object_name, self.abbrev_parent))
        # create the function implementation
        if self.is_java_api:
            if self.has_std_base:
                all_present = 'true'
            else:
                all_present = '{0}::hasRequired' \
                              'Elements()'.format(self.base_class)
            code = [dict({'code_type': 'line',
                          'code': ['bool allPresent '
                                   '= {0}'.format(all_present)]})]
            for i in range(0, len(self.child_elements)):
                att = self.child_elements[i]
                if att['reqd']:
                    implementation = ['isSet{0}() == '
                                      'false'.format(att['capAttName']),
                                      'allPresent = false']
                    code.append(dict({'code_type': 'if',
                                      'code': implementation}))
            for i in range(0, len(self.child_lo_elements)):
                att = self.child_lo_elements[i]
                if att['reqd']:
                    name = strFunctions.upper_first(att['pluralName'])
                    implementation = ['getNum{0}() == '
                                      '0'.format(name),
                                      'allPresent = false']
                    code.append(dict({'code_type': 'if',
                                      'code': implementation}))
            code.append(dict({'code_type': 'line',
                              'code': ['return allPresent']}))
        else:
            line = ['return ({0} != NULL) ? static_cast<int>({0}->'
                    'hasRequiredElements()) : 0'.format(self.abbrev_parent)]
            code = [dict({'code_type': 'line', 'code': line})]

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing general functions: writeElement, accept
    #                                setDocument, write (if we have an array)

    # function to write writeElement
    def write_write_elements(self):
        if not self.status == 'cpp_not_list':
            if not(self.status == 'cpp_list' and len(self.child_elements) > 0):
                return
        elif self.is_doc_plugin:
            return

        # create comment parts
        title_line = 'Write any contained elements'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'writeElements'
        return_type = 'void'
        if global_variables.is_package:
            arguments = ['XMLOutputStream& stream']
        else:
            arguments = ['LIBSBML_CPP_NAMESPACE_QUALIFIER XMLOutputStream& stream']

        # create the function implementation
        base = self.base_class
        if not self.is_plugin:
            code = [dict({'code_type': 'line',
                          'code': ['{0}::writeElements(stream)'.format(base)]})]
        else:
            code = []
        for i in range(0, len(self.child_elements)):
            att = self.child_elements[i]
            if att['element'] == 'ASTNode':
                if global_variables.is_package:
                    line = ['writeMathML(getMath(), stream, get{0}'
                            'Namespaces())'.format(global_variables.prefix)]
                else:
                    line = ['writeMathML(getMath(), stream, NULL)']
            elif att['element'] == 'XMLNode':
                line = ['stream.startElement(\"{0}\")'.format(att['name']),
                        'stream << *{0}'.format(att['memberName']),
                        'stream.endElement(\"{0}\")'.format(att['name'])]
            else:
                line = ['{0}->write(stream)'.format(att['memberName'])]
            implementation = ['isSet{0}() == true'.format(att['capAttName'])]
            implementation += line
            code.append(dict({'code_type': 'if',
                              'code': implementation}))
        for i in range(0, len(self.child_lo_elements)):
            att = self.child_lo_elements[i]
            if self.is_plugin:
                name = att['pluralName'][6:]
            else:
                # hack for spatial csg elements
                if self.package == 'Spatial' and \
                        att['pluralName'].startswith('csg'):
                    name = 'CSG' + att['pluralName'][3:]
                else:
                    name = strFunctions.remove_prefix(strFunctions.upper_first(att['pluralName']))
            implementation = ['getNum{0}() > '
                              '0'.format(name),
                              '{0}.write(stream)'.format(att['memberName'])]
            code.append(dict({'code_type': 'if',
                              'code': implementation}))
        if not self.is_plugin and global_variables.is_package:
            code.append(dict({'code_type': 'line',
                              'code': ['{0}::writeExtension'
                                       'Elements'
                                       '(stream)'.format(self.std_base)]}))
        # look and see if we have a vector attribute which would need
        # to be written here
        for attrib in self.attributes:
            if 'isVector' in attrib and attrib['isVector']:
                code.append(self.write_write_vector(attrib))
        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    def write_write_vector(self, attrib):
        implementation = ['std::vector<{0}>::const_iterator it = {1}.begin(); '
                          'it != {1}.end(); ++it'.format(attrib['element'], attrib['memberName']),
                          'stream.startElement(\"{0}\")'.format(attrib['name']),
                          'stream.setAutoIndent(false)',
                          'stream << \" \" << *it << \"  \"',
                          'stream.endElement(\"{0}\")'.format(attrib['name']),
                          'stream.setAutoIndent(true)']
        nested_for = self.create_code_block('for', implementation)
        implementation = ['has{0}()'.format(strFunctions.plural(attrib['capAttName'])),
                          nested_for]
        code = self.create_code_block('if', implementation)
        return code

    # function to write accept
    def write_accept(self):
        if not self.status == 'cpp_not_list':
            return

        # create comment parts
        title_line = 'Accepts the given ' \
                     '{0}Visitor'.format(global_variables.prefix)
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'accept'
        return_type = 'bool'
        arguments = ['{0}Visitor& v'.format(global_variables.prefix)]

        # create the function implementation
        simple = False
        # cover cases where a doc plugin is used (no children but not simple)
        # or there are children but they are non std based children (simple)
        if self.has_children:
            if self.num_children == self.num_non_std_children:
                simple = True
        else:
            if not self.is_plugin:
                simple = True
        if not global_variables.is_package:
            implementation = ['return false']
            code = [dict({'code_type': 'line', 'code': implementation})]
        elif simple:
            implementation = ['return v.visit(*this)']
            code = [dict({'code_type': 'line', 'code': implementation})]
        else:
            if not self.is_plugin:
                code = [dict({'code_type': 'line',
                              'code': ['v.visit(*this)']})]
            else:
                obj = strFunctions.abbrev_name(self.ext_class)
                implementation = ['const {0}* {1} = static_cast<const {0}*>'
                                  '(this->getParent{2}Object()'
                                  ')'.format(self.ext_class, obj,
                                             self.cap_language),
                                  'v.visit(*{0})'.format(obj),
                                  'v.leave(*{0})'.format(obj)]
                code = [self.create_code_block('line', implementation)]
            for i in range(0, len(self.child_elements)):
                elem = self.child_elements[i]
                implementation = ['{0} != NULL'.format(elem['memberName']),
                                  '{0}->accept(v)'.format(elem['memberName'])]
                code.append(dict({'code_type': 'if',
                                  'code': implementation}))
            for i in range(0, len(self.child_lo_elements)):
                att = self.child_lo_elements[i]
                implementation = ['{0}.accept(v)'.format(att['memberName'])]
                code.append(dict({'code_type': 'line',
                                  'code': implementation}))
            if not self.is_plugin:
                code.append(dict({'code_type': 'line',
                                  'code': ['v.leave(*this)', 'return true']}))
            else:
                code.append(self.create_code_block('line', ['return true']))

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write setDocument
    def write_set_document(self):
        if not self.status == 'cpp_not_list':
            return
        elif self.is_doc_plugin:
            return

        # create comment parts
        title_line = 'Sets the parent ' \
                     '{0}'.format(global_variables.document_class)
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'set{0}'.format(global_variables.document_class)
        return_type = 'void'
        arguments = ['{0}* d'.format(global_variables.document_class)]

        # create the function implementation
        if self.base_class:
            line = '{0}::set{1}(d)'.format(self.base_class,
                                           global_variables.document_class)
            implementation = [line]
            code = [dict({'code_type': 'line', 'code': implementation})]
        else:
            code = []
        if self.has_children and not self.has_only_math:
            for i in range(0, len(self.child_elements)):
                att = self.child_elements[i]
                if 'is_ml' in att and att['is_ml']:
                    continue
                else:
                    implementation = ['{0} != NULL'.format(att['memberName']),
                                      '{0}->{1}'
                                      '(d)'.format(att['memberName'], function)]
                    code.append(self.create_code_block('if', implementation))
            for i in range(0, len(self.child_lo_elements)):
                att = self.child_lo_elements[i]
                implementation = ['{0}.{1}'
                                  '(d)'.format(att['memberName'], function)]
                code.append(dict({'code_type': 'line',
                                  'code': implementation}))

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write_write if there is an array
    def write_write(self):
        if not self.has_array:
            return
        elif not self.status == 'cpp_not_list':
            return

        # create comment parts
        title_line = 'used to write arrays'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'write'
        return_type = 'void'
        if global_variables.is_package:
            arguments = ['XMLOutputStream& stream']
        else:
            arguments = ['LIBSBML_CPP_NAMESPACE_QUALIFIER XMLOutputStream& stream']

        # create the function implementation
        # find the array attribute
        name = ''
        member = ''
        array_type = ''
        for attrib in self.attributes:
            if attrib['isArray']:
                name = attrib['capAttName']
                member = attrib['memberName']
                array_type = attrib['element']
            if array_type == 'int':
                array_type = 'long'
        code = [self.create_code_block('line',
                                       ['stream.startElement(getElementName(), '
                                        'getPrefix())',
                                        'writeAttributes(stream)'])]
        nested_for = self.create_code_block(
            'for', ['int i = 0; i < m{0}Length; ++i'.format(name),
                    'stream << ({0}){1}[i] << \" \"'
                    ''.format(array_type, member)])
        implementation = ['isSet{0}()'.format(name), nested_for]
        code.append(self.create_code_block('if', implementation))
        code.append(self.create_code_block(
            'line', ['stream.endElement(getElementName(), getPrefix())']))

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for dealing with packages: enablePackage, connectToChild

    # function to write enable_package
    def write_enable_package(self):
        if not self.status == 'cpp_not_list':
            return
        elif self.is_doc_plugin:
            return

        # create comment parts
        title_line = 'Enables/disables the given package with this element'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'enablePackageInternal'
        return_type = 'void'
        arguments = ['const std::string& pkgURI',
                     'const std::string& pkgPrefix', 'bool flag']

        # create the function implementation
        code = []
        if not self.is_plugin and self.base_class:
            implementation = ['{0}::enablePackageInternal(pkgURI, pkgPrefix, '
                              'flag)'.format(self.base_class)]
            code = [dict({'code_type': 'line', 'code': implementation})]
        if self.has_children and not self.has_only_math:
            for i in range(0, len(self.child_elements)):
                att = self.child_elements[i]
                if 'is_ml' in att and att['is_ml']:
                    continue
                else:
                    implementation = ['isSet{0}()'.format(att['capAttName']),
                                      '{0}->enablePackageInternal'
                                      '(pkgURI, pkgPrefix, '
                                      'flag)'.format(att['memberName'])]
                    code.append(dict({'code_type': 'if',
                                      'code': implementation}))
            for i in range(0, len(self.child_lo_elements)):
                att = self.child_lo_elements[i]
                implementation = ['{0}.enablePackageInternal'
                                  '(pkgURI, pkgPrefix, '
                                  'flag)'.format(att['memberName'])]
                code.append(dict({'code_type': 'line',
                                  'code': implementation}))

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write connectToChild
    def write_connect_to_child(self):
        if not self.is_java_api:
            return
        elif not self.has_children:
            return

        # create comment parts
        title_line = 'Connects to child elements'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'connectToChild'
        return_type = 'void'
        arguments = []

        # create the function implementation
        if not self.is_plugin:
            implementation = ['{0}::connectToChild()'.format(self.base_class)]
            code = [dict({'code_type': 'line', 'code': implementation})]
            for i in range(0, len(self.child_elements)):
                att = self.child_elements[i]
                if 'is_ml' in att and att['is_ml']:
                    continue
                else:
                    implementation = ['{0} != NULL'.format(att['memberName']),
                                      '{0}->connectToParent'
                                      '(this)'.format(att['memberName'])]
                    code.append(self.create_code_block('if', implementation))
            for i in range(0, len(self.child_lo_elements)):
                att = self.child_lo_elements[i]
                implementation = ['{0}.connectToParent'
                                  '(this)'.format(att['memberName'])]
                code.append(dict({'code_type': 'line',
                                  'code': implementation}))
        else:
            code = [self.create_code_block('line',
                                           ['connectToParent(getParent'
                                            '{0}Object()'
                                            ')'.format(self.cap_language)])]
        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write connectToParent
    def write_connect_to_parent(self):
        if not self.is_java_api:
            return
        elif not self.has_children:
            return

        # create comment parts
        title_line = 'Connects to parent element'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'connectToParent'
        return_type = 'void'
        arguments = ['{0}* base'.format(self.std_base)]

        # create the function implementation
        implementation = ['{0}::connectToParent(base)'.format(self.base_class)]
        code = [dict({'code_type': 'line', 'code': implementation})]
        for i in range(0, len(self.child_elements)):
            att = self.child_elements[i]
            if 'is_ml' in att and att['is_ml']:
                continue
            else:
                implementation = ['{0} != NULL'.format(att['memberName']),
                                  '{0}->connectToParent'
                                  '(base)'.format(att['memberName'])]
                code.append(self.create_code_block('if', implementation))
        for i in range(0, len(self.child_lo_elements)):
            att = self.child_lo_elements[i]
            implementation = ['{0}.connectToParent'
                              '(base)'.format(att['memberName'])]
            code.append(dict({'code_type': 'line',
                              'code': implementation}))

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for when an element has a different XML name

    # function to write setElementName
    def write_set_element_name(self):
        if not self.is_java_api:
            return
        if not self.overwrites_children:
            return
        # create comment parts
        title_line = 'Sets the XML name of this {0} object.'\
            .format(self.object_name,)
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        arguments = ['const std::string& name']
        function = 'setElementName'
        return_type = 'void'

        # create the function implementation
        implementation = ['mElementName = name']
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
                     'virtual': True,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################





    ########################################################################

    # HELPER FUNCTIONS


    @staticmethod
    def create_code_block(code_type, lines = ''):
        code = dict({'code_type': code_type, 'code': lines})
        return code
