#!/usr/bin/env python
#
# @file    GeneralFunctions.py
# @brief   class to create general functions for java code. Work done for Google Summer of Code 2016
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

from java_utils import jsbmlHelperFunctions
from util import strFunctions, global_variables


class GeneralFunctions():
    """Class for general functions"""

    def __init__(self, language, is_java_api, is_list_of, class_object, jsbml_data_tree=None,
                 jsbml_methods=None, prime_numbers=None, abstract_jsbml_methods=None, import_modules=None):
        self.language = language
        self.cap_language = language.upper()
        self.package = class_object['package']
        self.class_name = class_object['name']
        self.has_std_base = class_object['has_std_base']
        self.base_class = class_object['baseClass']
        self.is_java_api = is_java_api
        self.is_list_of = is_list_of
        self.is_plugin = False
        if 'is_plugin' in class_object:
            self.is_plugin = class_object['is_plugin']
        self.is_doc_plugin = False
        if 'is_doc_plugin' in class_object:
            self.is_doc_plugin = class_object['is_doc_plugin']
        self.ext_class = ''
        if self.is_plugin:
            self.ext_class = class_object['sbase']
        if is_list_of:
            self.child_name = class_object['lo_child']
        else:
            self.child_name = ''
        if is_java_api:
            self.object_name = self.class_name
            self.object_child_name = self.child_name
        else:
            if is_list_of:
                self.object_name = 'ListOf_t'
            else:
                self.object_name = self.class_name + '_t'
            self.object_child_name = self.child_name + '_t'
        self.element_name = ''
        self.override_name = False
        if 'elementName' in class_object and not is_list_of:
            self.element_name = class_object['elementName']
            if self.element_name == '':
                self.override_name = False
            else:
                self.override_name = not \
                    strFunctions.compare_no_case(self.element_name,
                                                 self.class_name)
        if not global_variables.is_package:
            self.override_name = True
            if is_list_of:
                self.element_name = \
                    strFunctions.lower_list_of_name_no_prefix(class_object['elementName'])
            else:
                self.element_name = class_object['elementName']

        self.typecode = class_object['typecode']
        self.attributes = class_object['class_attributes']
        self.sid_refs = class_object['sid_refs']
        self.unit_sid_refs = class_object['unit_sid_refs']
        self.child_lo_elements = class_object['child_lo_elements']
        self.child_elements = class_object['child_elements']
        self.has_math = class_object['has_math']
        self.has_array = class_object['has_array']
        self.overwrites_children = class_object['overwrites_children']
        self.has_children = class_object['has_children']
        self.has_only_math = class_object['has_only_math']
        self.num_non_std_children = class_object['num_non_std_children']
        self.num_children = class_object['num_children']
        self.std_base = class_object['std_base']

        self.required = 'false'
        if 'is_doc_plugin' in class_object:
            if class_object['reqd']:
                self.required = 'true'

        self.document = False
        if 'document' in class_object:
            self.document = class_object['document']

        # useful variables
        if not self.is_java_api and self.is_list_of:
            self.struct_name = self.object_child_name
        else:
            self.struct_name = self.object_name
        self.abbrev_parent = strFunctions.abbrev_name(self.object_name)
        if self.is_java_api is False:
            self.true = '@c 1'
            self.false = '@c 0'
        else:
            self.true = '@c true'
            self.false = '@c false'

        # status
        if self.is_java_api:
            if self.is_list_of:
                self.status = 'java_list'
            else:
                self.status = 'java_not_list'
        else:
            self.status = 'needs work to be done'

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

        self.attributeName = 'attributeName'
        self.prefix = 'prefix'
        self.value = 'value'

        # This is for methods with same name
        self.duplicate_methods = []

        # What methods to write
        self.methods_to_write = ['readAttribute', 'toString', 'writeXMLAttributes', 'hashCode']

        # Get class attributes without id and name attributes
        self.attributes_excluding_id_name = self.get_attributes_excluding_id_name()

    ########################################################################

    # This useful for readAttributes where name and id are not required
    # It simply create a list without the Id and Name attributes
    def get_attributes_excluding_id_name(self):
        modified_attributes = []
        for i in range(0, len(self.attributes)):
            attribute = self.attributes[i]
            if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                continue
            else:
                modified_attributes.append(attribute)
        return modified_attributes

    # This looks like it is not required
    def expand_methods_to_write(self):
        for class_name in self.jsbml_methods:
            for method in self.jsbml_methods[class_name]:
                # print('method is ', method['functionName'])
                function_name = method['functionName']
                if function_name in ['readAttribute', 'toString', 'writeXMLAttributes', 'hashCode']:
                    if function_name not in self.methods_to_write:
                        self.methods_to_write.append(function_name)

    ########################################################################

    # Function for writing  nested if statements for get_child_at
    def create_nested_if_for_get_child_at(self, lo_element):
        name = lo_element['name']
        cap_name = lo_element['capAttName']

        if self.is_plugin is True:
            implementation = ['pos == index',
                              'return get{0}()'.format(cap_name)]  # 3rd line
            nested_if = self.create_code_block('if', implementation)
            implementation = ['isSet{0}()'.format(cap_name),
                              nested_if, 'pos++']  # 2nd line

            temp_code = self.create_code_block('if', implementation)
        else:
            implementation = ['pos == index',
                              'return getListOf{0}s()'.format(cap_name)]  # 3rd line
            #
            nested_if = self.create_code_block('if', implementation)
            implementation = ['isSetListOf{0}s()'.format(cap_name),
                              nested_if, 'pos++']  # 2nd line

            temp_code = self.create_code_block('if', implementation)
        return temp_code

    # Obtain abstract methods that have to be generated based on Imports
    # E.g. getDerivedUnitDefinition, containsUndeclaredUnits
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

    # Write interface abstract methods
    def write_interface_abstract_methods(self, index):
        if self.is_java_api is False:
            return

        code = []

        curr_method_original = self.abstract_methods_to_write['extends']['extendsOriginal']

        curr_method = self.abstract_methods_to_write['modules'][index]

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

        # Based on type modify return statement
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

    # a prototype that is not used anymore
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

    # write getChildAt method
    def write_get_child_at(self):
        if self.is_plugin is False and len(self.child_lo_elements) == 0:
            return
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
        implementation.append('throw new IndexOutOfBoundsException(MessageFormat.format(' \
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

        for i in range(0, len(self.child_lo_elements)):
            lo_element = self.child_lo_elements[i]
            temp_code = self.create_nested_if_for_get_child_at(lo_element)
            code.append(temp_code)

        implementation = ['throw new IndexOutOfBoundsException(MessageFormat.format(\
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

    def create_if_for_get_child_count(self, lo_element, type='element'):
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

        for i in range(0, len(self.child_elements)):
            element = self.child_elements[i]
            element_type = 'element'
            temp_code = self.create_if_for_get_child_count(element, element_type)
            code.append(temp_code)

        for i in range(0, len(self.child_lo_elements)):
            lo_element = self.child_lo_elements[i]
            element_type = 'lo_element'
            temp_code = self.create_if_for_get_child_count(lo_element, element_type)
            code.append(temp_code)

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

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.AbstractSBase#getAllowsChildren()'
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

    # Functions for writing hashCode  inside if statement
    def create_hashcode_if(self, attribute):
        name = attribute['capAttName']
        member_name = attribute['name']
        type = attribute['type']

        # hashCode if lo_element create line and return
        if type == 'lo_element':
            implementation = ['hashCode = prime * hashCode\
        + (({0} == null) ? 0 : {1}.hashCode())'.format(attribute['jsbmlName'], attribute['jsbmlName'])]
            return self.create_code_block('line', implementation)

        # TODO for hashcode_if maybe required for additional types
        implementation = ['isSet{0}()'.format(name)]
        if str(type)[:] == 'bool':
            implementation.append('hashCode += prime + (get{0}() ? 1 : -1)'.format(name))
        elif str(type)[:] == 'SIdRef':
            implementation.append('hashCode += prime * get{0}().hashCode()'.format(name))
        elif str(type)[:] == 'IDREF':
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

        title_line = '(non-Javadoc)--@see java.lang.Object#hashCode()'
        params = ['@param None']
        return_lines = []
        additional = ['Override']

        return_type = 'int'
        arguments = []
        # create the function implementation

        constructor_args = []  # arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'

        # get hash number
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

    # Function for writing hashCode else if statements
    def create_read_attribute_else_if(self, index, create_else=True):
        name = self.attributes_excluding_id_name[index]['capAttName']
        member_name = self.attributes_excluding_id_name[index]['name']
        java_type_data = self.attributes_excluding_id_name[index]['JClassType']
        type = self.attributes_excluding_id_name[index]['type']

        if java_type_data == 'Boolean':
            java_type = 'Boolean'
        elif java_type_data == 'Integer':
            java_type = 'Int'
        elif type == 'enum':
            java_type = java_type_data
        else:
            java_type = java_type_data

        implementation = ['{0}.equals({1}Constants.{2})'.format(self.attributeName, self.package, member_name)]

        # TODO for additonal data types, work may be required
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
        elif type == 'CBOTerm':
            # TODO Here works needs to be done fo CBO term
            implementation.append('set{0}(CBO.getTerm(value))'.format(name))
        else:
            implementation.append('set{0}(StringTools.parseSBML{1}({2}))'.format(name, java_type, self.value))

        try:
            if 1 < index < len(self.attributes_excluding_id_name) - 1:
                implementation.append('else if')
        except Exception as e:
            print('error in create create_read_attribute_else_if', e)

        return implementation

    # Create the else statement for readAttribute method
    def create_read_attribute_else(self):
        implementation = ['else', 'isAttributeRead = false']  # 3rd line
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
        title_line += '@see org.sbml.jsbml.element.SBase#readAttribute(String attributeName,\
         String prefix, String value)'
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')

        return_type = 'boolean'
        arguments = ['String attributeName']  # , 'String prefix', 'String value']
        arguments_no_defaults = ['String {0}'.format(self.attributeName),
                                 'String {0}'.format(self.prefix), 'String {0}'.format(self.value)]
        # create the function implementation
        args = []  # ['&rhs != this'] + self.write_assignment_args(self)
        clone = 'clone'

        code = []

        # get if method needs to be overriden
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

        implementation_else_if = []
        # each atribute has id and name, which are not a must for jsbml
        # so use modified attributes without id and name
        if len(self.attributes_excluding_id_name) > 0:

            implementation = ['!isAttributeRead']

            implement_inside = ['isAttributeRead = true']
            line = self.create_code_block('line', implement_inside)
            implementation.append(line)

            for i in range(0, len(self.attributes_excluding_id_name)):
                temp_code = self.create_read_attribute_else_if(i)
                implementation_else_if += temp_code

            if len(implementation_else_if) > 0:
                temp_code = self.create_read_attribute_else()
                implementation_else_if += temp_code

            if 'else if' in implementation_else_if:
                temp_code = self.create_code_block('else_if', implementation_else_if)
            elif 'else' in implementation_else_if:
                temp_code = self.create_code_block('if_else', implementation_else_if)
            elif len(implementation_else_if) == 2:
                temp_code = self.create_code_block('if', implementation_else_if)
            else:
                temp_code = self.create_code_block('empty_line')

            implementation.append(temp_code)

            # This is for fixing '}   }'
            implementation.append(self.create_code_block('empty_line'))
            code.append(self.create_code_block('if', implementation))

        # Final  return statement
        temp = ['return isAttributeRead']
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

    # Functions for creating if statements for writeXMLAttributes
    def create_xml_attributes_if(self, index):
        name = self.attributes[index]['capAttName']
        member_name = self.attributes[index]['name']
        type = self.attributes[index]['type']
        jclass_type = self.attributes[index]['JClassType']


        # TODO work for additional types may be required for writeXMLAttributes if
        implementation = ['isSet{0}()'.format(name)]
        if str(type)[:] == 'SId' or str(type)[:] == 'string':
            implementation.append('attributes.remove("{0}")'.format(member_name))
            implementation.append('attributes.put({0}Constants.shortLabel + ":{1}",  get{2}())'.format(
                self.package, member_name, name))
        elif str(type)[:] == 'bool':
            implementation.append(
                'attributes.put({0}Constants.shortLabel + ":" + {1}Constants.{2}, {3}.toString(get{4}()))'.format(
                    self.package, self.package, member_name, jclass_type, name))
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
            # TODO this part is responsible for data types
            comment_line = self.create_code_block('comment', 'TODO adapt writeXMLAttributes in deviser')
            implementation.append(comment_line)

            throw_exception_temo = 'throw new UnsupportedOperationException("Invalid operation: please adapt devisers\
             writeXMLAttributes generator")'
            throw_exception_line = self.create_code_block('line', 'TODO adapt writeXMLAttributes in deviser')
            implementation.append(comment_line)

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
        title_line += '@see org.sbml.jsbml.element.SBase#writeXMLAttributes()'
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

        return implementation_create  # text

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

        # text_rest = self.create_to_string()
        implementation_rest = self.create_to_string()

        implementation = ['StringBuilder builder = new StringBuilder()']
        implementation.append('builder.append("{0} [")'.format(self.class_name))

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


        # Check one more time if it't not available then append ']'
        if 'builder.append("]")' not in implementation and len(implementation) > 1:
            implementation.append('builder.append("]")')

        # final return statement
        text = 'return builder.toString()'
        implementation.append(text)

        # code.append(self.create_code_block('line', temp))
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
                     'args_no_defaults': arguments_no_defaults,
                     'implementation': code})

    ############################################################################
    # TODO JSBML PLUGIN FUNCTIONS

    def write_get_package_name(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getPackageName'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.ext.SBasePlugin#getPackageName()'
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

    def write_get_uri(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        function = 'getURI'

        title_line = '(non-Javadoc)--@see org.sbml.jsbml.ext.SBasePlugin#getURI()'
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

        temp = ['return getElementNamespace()']
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

        # For future case when needs to be detected override or not
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

    ####################################################################################################################

    @staticmethod
    def create_code_block(code_type, lines=''):
        code = dict({'code_type': code_type, 'code': lines})
        return code
