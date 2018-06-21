#!/usr/bin/env python
#
# @file    ListOfQueryFunctions.py
# @brief   class to create functions to query a ListOf element for JAVA.
# @author  Hovakim Grabski GSoC 2016
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


class ListOfQueryFunctions():
    """Class for all functions for ListOf classes"""

    def __init__(self, language, is_java_api, is_list_of, class_object, jsbml_data_tree=None, jsbml_methods=None):
        self.language = language
        self.cap_language = language.upper()
        self.is_java_api = is_java_api
        self.is_list_of = is_list_of
        self.is_plugin = False
        self.attTypeCode = class_object['attTypeCode']
        if 'is_plugin' in class_object:
            self.is_plugin = class_object['is_plugin']
        self.class_object = class_object
        self.package = class_object['package']
        if is_list_of:
            self.child_name = class_object['lo_child']
            self.child_name_lower = class_object['name']
            self.child_type = strFunctions.upper_first(class_object['element'])
            self.class_name = class_object['name']
        elif self.is_plugin:
            self.child_name = strFunctions.upper_first(class_object['element'])
            self.child_type = strFunctions.upper_first(class_object['element'])
            self.child_name_lower = class_object['name']
            self.class_name = class_object['plugin']
        else:
            self.child_name = strFunctions.upper_first(class_object['element'])
            self.child_type = strFunctions.upper_first(class_object['element'])
            self.child_name_lower = class_object['name']
            self.class_name = class_object['parent']['name']
        if is_java_api:
            self.object_name = self.class_name
            self.child_type = strFunctions.upper_first(class_object['element'])
            self.object_child_name = self.child_name
            self.object_child_type = self.child_type
            self.object_name_lower = self.child_name_lower
        else:
            if is_list_of:
                if global_variables.is_package:
                    self.object_name = 'ListOf'
                else:
                    self.object_name = strFunctions.prefix_name('ListOf')
            else:
                self.object_name = self.class_name
            self.object_child_name = self.child_name
            self.object_child_type = self.child_type
            self.object_name_lower = self.child_name_lower
        self.std_base = class_object['std_base']
        self.concretes = []
        if 'concretes' in class_object and len(class_object['concretes']) > 0:
            self.concretes = class_object['concretes']
        elif 'concrete' in class_object:
            self.concretes = query.get_concretes(class_object['root'],
                                                 class_object['concrete'])

        self.document = False
        if 'document' in class_object:
            self.document = class_object['document']

        self.has_id = True
        if not self.is_list_of:
            self.has_id = query.has_attribute(
                query.get_class(self.child_name, self.class_object['root']),
                'id')

        self.used_sidrefs = []
        self.used_eq_names = []

        # useful variables
        if not self.is_java_api and self.is_list_of:
            self.struct_name = self.object_child_name
        else:
            self.struct_name = self.object_name
        self.plural = strFunctions.plural(self.child_name)
        self.indef_name = strFunctions.get_indefinite(self.object_child_name)
        self.abbrev_parent = strFunctions.abbrev_name(self.object_name)
        self.abbrev_child = strFunctions.abbrev_name(self.child_name)
        self.ideq = 'IdEq'
        if not global_variables.is_package:
            self.ideq = strFunctions.prefix_name('IdEq')

        # status
        if self.is_java_api:
            if self.is_list_of:
                self.status = 'java_list'
            elif self.is_plugin:
                self.status = 'plugin'
            else:
                self.status = 'java_not_list'
        else:
            if self.is_list_of:
                self.status = 'c_list'
            else:
                self.status = 'c_not_list'
        self.is_header = class_object['is_header']
        self.open_br = '{'
        self.close_br = '}'

        # Additional java helper data for JSBML
        if jsbml_data_tree is not None:
            self.jsbml_data_tree = jsbml_data_tree
        if jsbml_methods is not None:
            self.jsbml_methods = jsbml_methods

        self.duplicate_methods = []

    ########################################################################

    # Functions for writing get element functions

    # function to write get by index from a listOf
    # TODO work to be done for write_get_element_by_index in ListOfQueryFunctions
    def write_get_element_by_index(self, is_const):
        # c api does not need a non constant version
        if not self.is_java_api and not is_const:
            return

        if self.is_list_of:
            return_string = 'in this {0}'.format(self.object_name)
        else:
            return_string = 'in the {0} within this ' \
                            '{1}'.format(strFunctions.
                                         cap_list_of_name(self.child_name),
                                         self.class_name)

        # useful variables
        virtual = True if self.is_list_of else False
        # create comment parts
        title_line = 'Get {0} {1} from the {2}.'.format(self.indef_name,
                                                        self.object_child_name,
                                                        self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param n an unsigned int representing the index '
                      'of the {0} to retrieve.'.format(self.object_child_name))
        return_lines = ['@return the nth {0} {1}.'.format(
            self.object_child_name, return_string)]
        additional = ['Deprecated']
        if self.is_java_api:
            additional = ['@see size()'] if self.is_list_of \
                else ['@see getNum{0}()'.format(strFunctions.remove_prefix(self.plural))]

        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(self.child_name)
        if self.is_java_api:
            function = 'get' if self.is_list_of else 'get{0}' \
                .format(strFunctions.remove_prefix(self.object_child_name))
        else:
            function = '{0}_get{1}'.format(self.class_name, used_c_name)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
        arguments.append('int n')

        if is_const:
            return_type = '{0}'.format(self.object_child_name)
        else:
            return_type = '{0}'.format(self.object_child_name)
        # if appropriate write the code
        code = []
        implementation = []
        if not self.is_header:
            if self.status == 'java_list':
                list_type = 'ListOf'
                if not global_variables.is_package:
                    list_type = strFunctions.prefix_name('ListOf')
                comment_line = \
                    self.create_code_block('comment',
                                           ['TODO  write_get_element_by_index --java_list-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)
            elif self.status == 'cpp_not_list':
                if not self.document:
                    comment_line = \
                        self.create_code_block('comment',
                                               ['TODO  write_get_element_by_index --not self.document-- in deviser'])
                    implementation.append(comment_line)

                    throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                    throw_exception_line = self.create_code_block('line', throw_exception_temp)
                    implementation.append(throw_exception_line)
                else:
                    comment_line = \
                        self.create_code_block('comment',
                                               ['TODO write_get_element_by_index cpp_not_list --else--in deviser'])
                    implementation.append(comment_line)

                    throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                    throw_exception_line = self.create_code_block('line', throw_exception_temp)
                    implementation.append(throw_exception_line)

                code = implementation
            elif self.status == 'plugin':
                comment_line = \
                    self.create_code_block('comment', ['TODO adapt write_get_element_by_index --plugin--in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)
            else:
                comment_line = \
                    self.create_code_block('comment', ['TODO adapt write_get_element_by_index --else-- in deviser'])
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
                     'constant': is_const,
                     'virtual': virtual,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write get by id from a listOf
    # TODO needs to be adapted
    def write_get_element_by_id(self, is_const):
        # c api does not need a non constant version
        if not self.is_java_api and not is_const:
            return
        elif not self.has_id:
            return

        # useful variables
        virtual = True if self.is_list_of else False
        used_c_name = strFunctions.remove_prefix(self.child_name)
        used_cpp_name = strFunctions.remove_prefix(self.object_child_name)

        if self.is_list_of:
            return_string = 'in this {0}'.format(self.object_name)
        else:
            return_string = 'in the {0} within this ' \
                            '{1}'.format(strFunctions.
                                         cap_list_of_name(self.child_name),
                                         self.class_name)
        # create comment
        title_line = 'Get {0} {1} from the {2} based on its identifier.' \
            .format(self.indef_name, self.object_child_name, self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param sid a string representing the identifier '
                      'of the {0} to retrieve.'.format(self.object_child_name))
        return_lines = ['@return the {0} {1} with the given id'
                        ' or NULL if no such {0} exists.'.format(self.object_child_name, return_string)]
        additional = []
        if self.is_java_api:
            if self.is_list_of:
                additional = ['@see size()']
            else:
                additional.append('@see get{0}(unsigned int '
                                  'n)'.format(used_cpp_name))
                additional.append('@see getNum{0}()'.format(strFunctions.remove_prefix(self.plural)))

        # create function declaration
        if self.is_java_api:
            function = 'get' if self.is_list_of \
                else 'get{0}'.format(used_cpp_name)
            arguments = ['const std::string& sid']
        else:
            function = '{0}_getById'.format(self.class_name) if self.is_list_of \
                else '{0}_get{1}ById'.format(self.class_name, used_c_name)
            arguments = ['{0}* {1}'.format(self.object_name,
                                           self.abbrev_parent),
                         'const char *sid']
        if is_const:
            return_type = 'const {0}*'.format(self.object_child_name)
        else:
            return_type = '{0}*'.format(self.object_child_name)
        # if appropriate write the code
        code = []
        if not self.is_header:
            if self.status == 'cpp_list':
                code = self.java_list_write_get_element_by_id(is_const)
            elif self.status == 'cpp_not_list':
                code = self.java_not_list_write_get_element_by_id()
            elif self.status == 'plugin':
                const = 'const ' if is_const else ''
                name = self.class_object['memberName']
                implementation = ['return static_cast<{0} {1}*>({2}.get'
                                  '(sid))'.format(const, self.child_name, name)]
                code = [self.create_code_block('line', implementation)]
        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': is_const,
                     'virtual': virtual,
                     'object_name': self.struct_name,
                     'implementation': code})

    def java_list_write_get_element_by_id(self, const):
        implementation = []
        if const:
            comment_line = \
                self.create_code_block('comment', ['TODO java_list_write_get_element_by_id --const-- in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)
        else:
            comment_line = \
                self.create_code_block('comment', ['TODO java_list_write_get_element_by_id --else- in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)
        code = implementation
        return code

    def java_not_list_write_get_element_by_id(self):
        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO java_not_list_write_get_element_by_id in deviser'])
        implementation.append(comment_line)

        throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
        throw_exception_line = self.create_code_block('line', throw_exception_temp)
        implementation.append(throw_exception_line)
        code = implementation
        return code

    # function to write get by sidref from a listOf
    # TODO write_get_element_by_sidref hasn't been modified
    def write_get_element_by_sidref(self, sid_ref, const):
        # c api does not need a non constant version
        if not self.is_java_api and not const:
            return

        # useful variables
        element = strFunctions.upper_first(sid_ref['name'])
        att_name = sid_ref['name']
        match = [element, const]
        if match in self.used_sidrefs:
            return
        else:
            self.used_sidrefs.append(match)

        # create comment
        title_line = 'Get {0} {1} from the {2} based on the {3} to which ' \
                     'it refers.'.format(self.indef_name,
                                         self.object_child_name,
                                         self.object_name,
                                         element)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param sid a string representing the {0} attribute '
                      'of the {1} object to '
                      'retrieve.'.format(att_name, self.object_child_name))
        return_lines = ['@return the first {0} in this {1} based on the '
                        'given {2} attribute or NULL if no such {0} exists.'
                            .format(self.object_child_name, self.object_name,
                                    att_name)]
        additional = []

        # create function declaration
        used_c_name = strFunctions.remove_prefix(self.child_name)
        used_cpp_name = strFunctions.remove_prefix(self.object_child_name)

        implementation = []
        if self.is_java_api:
            if self.is_list_of:
                function = 'getBy{0}'.format(element)
            else:
                function = 'get{0}By{1}'.format(used_cpp_name, element)
            arguments = ['const std::string& sid']

        if const:
            return_type = 'const {0}'.format(self.object_child_name)
        up_name = strFunctions.abbrev_name(element).upper()
        if const and self.is_java_api and self.is_list_of:
            comment_line = \
                self.create_code_block('comment', ['TODO write_get_element_by_sidref --const is_list_of-- in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)

        elif self.is_java_api and not self.is_list_of:
            comment_line = \
                self.create_code_block('comment', ['TODO write_get_element_by_sidref --not is_list_of-- in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)
        elif not const and self.is_java_api and self.is_list_of:
            comment_line = \
                self.create_code_block('comment',
                                       ['TODO write_get_element_by_sidref --not const & is_list_of-- in deviser'])
            implementation.append(comment_line)

            throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
            throw_exception_line = self.create_code_block('line', throw_exception_temp)
            implementation.append(throw_exception_line)
        else:
            comment_line = \
                self.create_code_block('comment', ['TODO write_get_element_by_sidref --else-- in deviser'])
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

    # function to write lookup by sidref from a listOf
    # TODO is it required for java, needs to be adapted
    def write_lookup(self, sid_ref):
        # c api does not need it
        if not self.is_java_api:
            return

        # useful variables
        if 'capAttName' in sid_ref:
            element = sid_ref['capAttName']
        else:
            element = sid_ref['element']
        eq_name = '{1}{0}'.format(strFunctions.abbrev_name(element).upper(),
                                  self.ideq)
        match = [element]
        if match in self.used_sidrefs:
            return
        else:
            self.used_sidrefs.append(match)
        if eq_name in self.used_eq_names:
            eq_name += '_A'
        self.used_eq_names.append(eq_name)
        open_b = '{'
        close_b = '}'
        # create comment
        title_line = 'Used by {0}::get() to lookup {1} {2} ' \
                     'based on its {3}.'.format(self.class_name,
                                                self.indef_name,
                                                self.child_name, element)
        params = []
        return_lines = []
        additional = []

        # create function declaration
        function = 'struct {0} : public std::unary_function' \
                   '<{1}*, bool>'.format(eq_name, self.std_base)
        arguments = []
        return_type = ''
        implementation = []
        comment_line = \
            self.create_code_block('comment', ['TODO write_lookup in deviser'])
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

    # Functions for writing remove element functions

    # function to write remove  from a listOf
    def write_remove_element(self):
        # useful variables
        virtual = True if self.is_list_of else False

        # create comment parts
        title_line = 'Removes the nth {0} from this {1} and returns a ' \
                     'pointer to it.'.format(self.object_child_name,
                                             self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        # params.append('@param n an unsigned int representing the index of '
        #               'the {0} to remove.'.format(self.object_child_name))
        return_lines = ['@return a pointer to the nth {0} in this {1}.'.format(
            self.object_child_name, self.object_name)]
        additional = []
        # if self.is_java_api:
        #     additional = ['@see size()'] if self.is_list_of \
        #         else ['@see getNum{0}'.format(strFunctions.remove_prefix(self.plural))]
        #     additional.append(' ')
        #     additional.append('@note the caller owns the returned object and '
        #                       'is responsible for deleting it.')
        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(self.child_name)
        used_java_name = strFunctions.remove_prefix(self.object_child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)
        used_java_name_plural = strFunctions.plural(self.object_child_name)

        # Old version
        # used_java_name_lower = strFunctions.remove_prefix(self.object_name_lower)
        used_java_name_lower = strFunctions.lower_first(used_java_name)

        params.append('Removes an element from the {{@link listOf{0}s}}'.format(used_java_name))
        params.append(' ')
        params.append('@param {0} the element to be removed from the list.'.format(used_java_name))
        params.append('@return {@code true} if the list contained the specified element and it was removed.')
        params.append('@see java.util.List#remove(Object)')
        if self.is_java_api:
            function = 'remove' if self.is_list_of \
                else 'remove{0}'.format(used_java_name)
        else:
            if self.is_list_of:
                function = '{0}_remove'.format(self.class_name)
            else:
                function = '{0}_remove{1}'.format(self.class_name,
                                                  used_c_name)

            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
        # arguments.append('{0} {1}'.format(used_java_name, used_java_name_lower))
        # # return_type = '{0}*'.format(self.object_child_name)
        #
        if self.is_plugin is True:
            arguments.append('{0} {1}'.format(used_java_type,
                                              used_java_name_lower))
        else:
            arguments.append('{0} {1}'.format(used_java_name,
                                              used_java_name_lower))

        return_type = 'boolean'

        code = []
        if not self.is_header:
            if self.status == 'java_list':
                list_type = 'ListOf'
                if not global_variables.is_package:
                    list_type = strFunctions.prefix_name('ListOf')
                implementation = ['return static_cast<{0}*>({1}::'
                                  'remove(n))'.format(self.object_child_name,
                                                      list_type)]
                code = [self.create_code_block('line', implementation)]

            # TODO this is problematic when self.status java_not_list for Transition.java
            # elif self.status == 'java_not_list':
            #     member = self.class_object['memberName']
            #     implementation = ['return {0}.remove(n)'.format(member)]
            #     code = [self.create_code_block('line', implementation)]

            elif self.status == 'plugin':
                implementation = ['isSetListOf{0}()'.format(used_java_name_plural)]
                implementation.append(
                    'return getListOf{0}().remove({1})'.format(used_java_name_plural, used_java_name_lower))
                code.append(self.create_code_block('if', implementation))
            else:
                implementation = ['isSetListOf{0}()'.format(used_java_name_plural)]
                implementation.append(
                    'return getListOf{0}().remove({1})'.format(used_java_name_plural, used_java_name_lower))
                code.append(self.create_code_block('if', implementation))

        line = 'return false'
        line_code = line
        code.append(line_code)
        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': virtual,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write remove by index from a listOf
    def write_remove_element_by_index(self):
        # useful variables
        virtual = True if self.is_list_of else False

        # create comment parts
        title_line = 'Removes the nth {0} from this {1} and returns a ' \
                     'pointer to it.'.format(self.object_child_name,
                                             self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        # params.append('@param n an unsigned int representing the index of '
        #               'the {0} to remove.'.format(self.object_child_name))
        return_lines = ['@return a pointer to the nth {0} in this {1}.'.format(
            self.object_child_name, self.object_name)]
        additional = []
        # if self.is_java_api:
        #     additional = ['@see size()'] if self.is_list_of \
        #         else ['@see getNum{0}'.format(strFunctions.remove_prefix(self.plural))]
        #     additional.append(' ')
        #     additional.append('@note the caller owns the returned object and '
        #                       'is responsible for deleting it.')
        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(self.child_name)
        used_java_name = strFunctions.remove_prefix(self.object_child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)

        #
        # if self.is_plugin is True:
        #     return

        params.append('Removes an element from the {{@link #listOf{0}s}}'.format(used_java_name))
        params.append(' ')
        params.append('@param i the index where to remove the {{@link {0}}}.'.format(used_java_name))
        params.append('@return the specified element if it was successfully found and removed.')
        params.append('@throws IndexOutOfBoundsException if the listOf is not set or if the index \
                        is out of bound ({{@code (i < 0) || (i > listOf{0}s)}})'.format(used_java_name))
        if self.is_java_api:
            function = 'remove' if self.is_list_of \
                else 'remove{0}'.format(used_java_name)
        else:
            if self.is_list_of:
                function = '{0}_remove'.format(self.class_name)
            else:
                function = '{0}_remove{1}'.format(self.class_name,
                                                  used_c_name)

            arguments.append('{0} {1}'.format(self.object_name,
                                              self.abbrev_parent))

        # argument for java
        arguments.append('int i')

        if self.is_plugin is True:
            return_type = '{0}'.format(used_java_type)
        else:
            return_type = '{0}'.format(used_java_name)

        code = []
        if not self.is_header:
            if self.status == 'java_list':
                list_type = 'ListOf'
                if not global_variables.is_package:
                    list_type = strFunctions.prefix_name('ListOf')
                implementation = ['return static_cast<{0}*>({1}::'
                                  'remove(n))'.format(self.object_child_name,
                                                      list_type)]
                code = [self.create_code_block('line', implementation)]

                # TODO should this be used or else is enough
                # elif self.status == 'java_not_list':
                #     member = self.class_object['memberName']
                #     implementation = ['return {0}.remove(n)'.format(member)]
                code = [self.create_code_block('line', implementation)]
            elif self.status == 'plugin':
                implementation = ['isSetListOf{0}()'.format(strFunctions.plural(used_java_type))]
                implementation.append('throw new IndexOutOfBoundsException(Integer.toString(i))')
                code.append(self.create_code_block('if', implementation))
            else:
                implementation = ['isSetListOf{0}s()'.format(used_java_name)]
                implementation.append('throw new IndexOutOfBoundsException(Integer.toString(i))')

                code.append(self.create_code_block('if', implementation))

        if self.is_plugin is True:
            line = 'return getListOf{0}().remove(i)'.format(strFunctions.plural(used_java_type))
        else:
            line = 'return getListOf{0}s().remove(i)'.format(used_java_name)
        line_code = line  # self.create_code_block('line', line)
        code.append(line_code)
        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': virtual,
                     'object_name': self.struct_name,
                     'implementation': code})

    # function to write remove by id from a listOf
    # TODO write_remove_element_by_id  needs tuning
    def write_remove_element_by_id(self):
        if not self.is_list_of:
            child = query.get_class(self.child_name,
                                    self.class_object['root'])
            has_id = False
            if child:
                has_id = query.has_attribute(child, 'id')
            if not has_id:
                return
        # useful variables
        virtual = True if self.is_list_of else False

        # create comment parts
        title_line = 'Removes the {0} from this {1} based on its identifier and ' \
                     'returns a pointer to it.'.format(self.object_child_name,
                                                       self.object_name)
        params = []
        # if not self.is_java_api:
        #     params.append('@param {0} the {1} structure to search.'
        #                   .format(self.abbrev_parent, self.object_name))
        # params.append('@param sid a string representing the identifier of '
        #               'the {0} to remove.'.format(self.object_child_name))
        return_lines = ['@return the {0} in this {1} based on the identifier '
                        'or NULL if no such {0} '
                        'exists.'.format(self.object_child_name,
                                         self.object_name)]

        additional = []
        # if self.is_java_api:
        #     additional.append('@note the caller owns the returned object and '
        #                       'is responsible for deleting it.')
        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(self.child_name)
        used_java_name = strFunctions.remove_prefix(self.object_child_name)
        used_java_name_lower = strFunctions.remove_prefix(self.object_name_lower)
        used_java_name_plural = strFunctions.plural(self.object_child_name)

        # used_plugin_name = self.class_object['capAttName']


        params.append('Removes an element from the {{@link listOf{0}s}}.'.format(used_java_name))
        params.append(' ')
        params.append('@param {0}Id the id of the element to be removed from the list.'.format(used_java_name_lower))
        params.append('@return the removed element, if it was successfully found and removed or {@code null}.')

        if self.is_java_api:
            function = 'remove' if self.is_list_of \
                else 'remove{0}'.format(used_java_name)
            arguments = ['String {0}Id'.format(used_java_name_lower)]
        else:
            if self.is_list_of:
                function = '{0}_removeById'.format(self.class_name)
            else:
                function = '{0}_remove{1}ById'.format(self.class_name,
                                                      used_c_name)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
            arguments.append('const char* sid')
        return_type = '{0}'.format(used_java_name)
        # return_type  = 'void's

        code = []
        if not self.is_header:
            if self.status == 'java_list':
                implementation = []
                comment_line = \
                    self.create_code_block('comment', ['TODO write_remove_element_by_id status=java_list in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)
                code.append(implementation)
            # TODO needs fixing should this used or not
            # elif self.status == 'java_not_list':
            #     member = self.class_object['memberName']
            #     implementation = ['return {0}.remove(sid)'.format(member)]
            #     code = [self.create_code_block('line', implementation)]
            elif self.status == 'plugin':
                implementation = ['isSetListOf{0}()'.format(used_java_name_plural)]
                implementation.append('return getListOf{0}().remove({1}Id)'.format(used_java_name_plural,
                                                                                   used_java_name_lower))
                code.append(self.create_code_block('if', implementation))
            else:
                implementation = ['isSetListOf{0}()'.format(used_java_name_plural)]
                implementation.append('return getListOf{0}().remove({1}Id)'.format(used_java_name_plural,
                                                                                   used_java_name_lower))
                code.append(self.create_code_block('if', implementation))

            line = 'return null'.format(used_java_name)
            line_code = line  # self.create_code_block('line', line)
            code.append(line_code)

        # return the parts
        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': False,
                     'virtual': virtual,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing add and create element functions

    # function to write add element
    def write_add_element_function(self):
        # create comment parts
        title_line = 'Adds a copy of the given {0} to this {1}.'.format(
            self.object_child_name, self.object_name)
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure to which the {2} '
                          'should be added.'.format(self.abbrev_parent,
                                                    self.object_name,
                                                    self.object_child_name))
        params.append('@param {0} the {1} object to '
                      'add.'.format(self.abbrev_child, self.object_child_name))
        success = global_variables.ret_success
        failed = global_variables.ret_failed
        return_lines = ['@copydetails doc_returns_success_code',
                        '@li @{0}constant{1}{2}, '
                        'OperationReturnValues_t{3}'.format(self.language,
                                                            self.open_br,
                                                            success,
                                                            self.close_br),
                        '@li @{0}constant{1}{2},'
                        ' OperationReturnValues_t{3}'.format(self.language,
                                                             self.open_br,
                                                             failed,
                                                             self.close_br)]

        # if self.is_java_api:
        #     additional.append('@copydetails doc_note_object_is_copied')
        #     additional.append(' ')
        #     additional.append('@see create{0}()'
        #                       ''.format(strFunctions.remove_prefix(self.object_child_name)))

        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(self.child_name)
        used_java_name = strFunctions.remove_prefix(self.object_child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)
        # used_java_argument_name = strFunctions.remove_prefix(self.object_name_lower)
        used_java_argument_name = strFunctions.lower_first(used_java_name)
        if self.is_java_api:
            if self.is_plugin is True:
                function = 'add{0}'.format(used_java_name)
            else:
                function = 'add{0}'.format(used_java_name)
        else:
            function = '{0}_add{1}'.format(self.class_name, used_c_name)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))

        if self.is_plugin is True:
            arguments.append('{0} {1}'.format(used_java_type,
                                              used_java_argument_name))
        else:
            arguments.append('{0} {1}'.format(used_java_name,
                                              used_java_argument_name))

        additional = []
        params = ['@param {0}'.format(used_java_argument_name),
                  '       the {0} to add'.format(used_java_argument_name),
                  '@return']

        return_type = 'boolean'
        member = ''
        if not self.is_list_of:
            member = self.class_object['memberName']
            else_lines = ['{0}.append({1})'.format(member, self.abbrev_child),
                          'return {0}'.format(global_variables.ret_success)]
        else:
            else_lines = ['append({0})'.format(self.abbrev_child),
                          'return {0}'.format(global_variables.ret_success)]
        this_object = query.get_class(self.object_child_name,
                                      self.class_object['root'])
        if self.is_java_api:
            if self.is_plugin is True:
                implementation = ['return get{0}().add({1})'.format(self.attTypeCode, used_java_argument_name)]
                code = [self.create_code_block('line', implementation)]
            else:
                implementation = ['return get{0}().add({1})'.format(self.attTypeCode, used_java_argument_name)]
                code = [self.create_code_block('line', implementation)]

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

    # function to write create element
    def write_create_element_function(self, index=0):
        is_concrete = False
        if len(self.concretes) == 0 and index == 0:
            child = self.object_child_name
            abbrev_child = self.abbrev_child
            child_name = self.child_name
        else:
            if index == 0:
                return
            else:
                i = index - 1
            child_name = self.concretes[i]['element']
            child = child_name
            if not self.is_java_api:
                child += '_t'
            is_concrete = True
            abbrev_child = strFunctions.abbrev_name(child)
        # create comment parts
        title_line = 'Creates a new {0} object, adds it to this {1} object ' \
                     'and returns the {0} object ' \
                     'created.'.format(child, self.object_name)
        params = []
        return_lines = ['@return a new {0} object '
                        'instance.'.format(child)]
        additional = []

        params.append('Creates a new {0} element and adds it to the'.format(child))
        params.append('{{@link listOf{0}s}} list.'.format(child))
        params.append(' ')
        params.append('@return the newly created element, i.e., the last item in the')
        params.append('{{@link listOf{0}s}}'.format(child))

        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(child_name)

        used_java_name = strFunctions.upper_first(self.child_name)
        used_java_name_lower = strFunctions.lower_first(self.child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)

        if self.is_java_api:
            function = 'create{0}'.format(strFunctions.remove_prefix(child))
        else:
            function = '{0}_create{1}'.format(self.class_name, used_c_name)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
        if self.is_plugin is True:
            return_type = '{0}'.format(used_java_type)
        else:
            return_type = '{0}'.format(child)

        code = []
        # Input, Output, FunctionTerm
        if self.is_java_api and not is_concrete:
            pack_up = self.package.upper()
            pack_low = self.package.lower()
            if self.is_plugin is True:
                implementation = ['{0} {1} = new {0}(getLevel(), getVersion())'.format(used_java_type,
                                                                                       strFunctions.lower_first(child),
                                                                                       used_java_type)]
                implementation.append('return add{0}({1}) ? {1} : null'.format(child, strFunctions.lower_first(child)))
                code = [self.create_code_block('line', implementation)]
            else:
                implementation = ['{0} {1} = new {0}(getLevel(), getVersion())'.format(child,
                                                                                       strFunctions.lower_first(child),
                                                                                       child)]
                implementation.append('return add{0}({1}) ? {1} : null'.format(child, strFunctions.lower_first(child)))
                code = [self.create_code_block('line', implementation)]

        elif self.is_java_api and is_concrete:
            pack_up = self.package.upper()
            pack_low = self.package.lower()
            implementation = ['{0} {1} = new {0}(getLevel(), getVersion())'.format(used_java_type,
                                                                                   strFunctions.lower_first(child),
                                                                                   used_java_type)]
            implementation.append('return add{0}({1}) ? {1} : null'.format(child, strFunctions.lower_first(child)))

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


    # function to write create element by id

    def write_create_element_id_function(self, index=0):
        is_concrete = False
        if len(self.concretes) == 0 and index == 0:
            child = self.object_child_name
            abbrev_child = self.abbrev_child
            child_name = self.child_name
        else:
            if index == 0:
                return
            else:
                i = index - 1
            child_name = self.concretes[i]['element']
            child = child_name
            if not self.is_java_api:
                child += '_t'
            is_concrete = True
            abbrev_child = strFunctions.abbrev_name(child)
        # create comment parts
        title_line = 'Creates a new {0} object, adds it to this {1} object ' \
                     'and returns the {0} object ' \
                     'created.'.format(child, self.object_name)
        params = []
        # if not self.is_java_api:
        #     params.append('@param {0} the {1} structure '
        #                   'to which the {2} should be '
        #                   'added.'.format(self.abbrev_parent, self.object_name,
        #                                   child))
        return_lines = ['@return a new {0} object '
                        'instance.'.format(child)]
        additional = []
        # if self.is_java_api:
        #     additional.append('@see add{0}(const {2}* {1})'
        #                       .format(strFunctions.remove_prefix(self.object_child_name),
        #                               self.abbrev_child,
        #                               self.object_child_name))


        params.append('Creates a new {0} element and adds it to the'.format(child))
        params.append('{{@link listOf{0}s}} list.'.format(child))
        params.append(' ')
        params.append('@param id the identifier that is to be applied to the new element.')
        params.append('@return the newly created element, which is the last item in the')
        params.append('{{@link listOf{0}s}}'.format(child))

        # create the function declaration
        arguments = []
        used_c_name = strFunctions.remove_prefix(child_name)

        used_java_name_lower = strFunctions.lower_first(strFunctions.remove_prefix(child_name))
        if self.is_java_api:
            function = 'create{0}'.format(strFunctions.remove_prefix(child))
            arguments.append('String id')
        else:
            function = '{0}_create{1}'.format(self.class_name, used_c_name)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
        return_type = '{0}'.format(child)

        # code = []
        # Input, Output, FunctionTerm
        if self.is_java_api and not is_concrete:
            pack_up = self.package.upper()
            pack_low = self.package.lower()

            implementation = ['{0} {1} = new {2}(id)'.format(child, used_java_name_lower, child)]
            implementation.append('add{0}({1})'.format(child, used_java_name_lower))
            implementation.append('return {0}'.format(used_java_name_lower))
            code = [self.create_code_block('line', implementation)]

        elif self.is_java_api and is_concrete:
            pack_up = self.package.upper()
            pack_low = self.package.lower()

            implementation = ['{0} {1} = new {2}(id)'.format(child, used_java_name_lower, child)]
            implementation.append('add{0}({1})'.format(child, used_java_name_lower))
            implementation.append('return {0}'.format(used_java_name_lower))
            code = [self.create_code_block('line', implementation)]

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

    ####################################################################################################################


    # Functions for writing get num element functions

    # function to write get num
    def write_get_num_element_function(self, parameter=None):
        # create comment parts
        if parameter:
            title_line = 'Get the number of {0} objects in ' \
                         'this {1} with the given {2}' \
                         '.'.format(self.object_child_name,
                                    self.object_name,
                                    parameter['name'])
        else:
            title_line = 'Get the number of {0} objects in ' \
                         'this {1}.'.format(self.object_child_name,
                                            self.object_name)
        params = []

        return_lines = ['@return the number of {0} objects in '
                        'this {1}.'.format(self.object_child_name,
                                           self.object_name)]
        additional = ['Deprecated']

        # create the function declaration
        arguments = []
        if parameter:
            arguments.append('{0} {1}'.format(parameter['type'], parameter['name']))
        used_java_name_plural = strFunctions.remove_prefix(self.plural)
        used_java_name = strFunctions.remove_prefix(self.child_name)
        if self.is_java_api:
            function = 'getNum{0}'.format(used_java_name_plural)
        else:
            function = '{0}_getNum{1}'.format(self.class_name, used_java_name_plural)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
        return_type = 'int'

        params.append('Returns the number of {{@link {0}}}s in this'.format(used_java_name))
        params.append('{{@link {0}}}.'.format(self.package))
        params.append(' ')
        params.append('@return the number of {{@link {0}}}s in this  {{@link {0}}}.'.format(used_java_name,
                                                                                            self.package))
        params.append('@libsbml.deprecated same as {{@link #get{0}Count()}}'.format(used_java_name))

        # TODO write_get_num_element_function works need to be done if parameter is True
        if self.is_java_api and self.is_list_of:
            implementation = ['return get{0}Count()'.format(used_java_name)]
        elif self.is_java_api and not self.is_list_of:
            if not self.document:
                implementation = ['return get{0}Count()'.format(used_java_name)]
                # implementation = ['return {0}.'
                #                   'size()'.format(self.class_object['memberName'])]
            elif parameter:
                implementation = []
                comment_line = \
                    self.create_code_block('comment', ['TODO write_get_num_element_function --parameter-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)

            else:
                implementation = []
                comment_line = \
                    self.create_code_block('comment', ['TODO write_get_num_element_function --else-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)

        code = [self.create_code_block('line', implementation)]
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

    # function to write get Count
    def write_get_element_function_count(self, parameter=None):
        # create comment parts
        if parameter:
            title_line = 'Get the number of {0} objects in ' \
                         'this {1} with the given {2}' \
                         '.'.format(self.object_child_name,
                                    self.object_name,
                                    parameter['name'])
        else:
            title_line = 'Get the number of {0} objects in ' \
                         'this {1}.'.format(self.object_child_name,
                                            self.object_name)
        params = []

        return_lines = ['@return the number of {0} objects in '
                        'this {1}.'.format(self.object_child_name,
                                           self.object_name)]
        additional = []

        # create the function declaration
        arguments = []
        if parameter:
            arguments.append('{0} {1}'.format(parameter['type'], parameter['name']))
        # used_java_name_plural = strFunctions.remove_prefix(self.plural)

        used_java_name = strFunctions.remove_prefix(self.child_name)
        used_java_name_plural = strFunctions.plural(self.object_child_name)

        if self.is_java_api:
            function = 'get{0}Count'.format(used_java_name)
        else:
            function = '{0}_getNum{1}'.format(self.class_name, used_java_name_plural)
            arguments.append('{0}* {1}'.format(self.object_name,
                                               self.abbrev_parent))
        return_type = 'int'

        params.append(
            'Returns the number of {{@link {0}}}s in this {{@link {1}}}.'.format(used_java_name, self.package))
        params.append(' ')
        params.append('@return the number of {{@link {0}}}s in this  {{@link {0}}}.'.format(used_java_name,
                                                                                            self.package))
        params.append('@libsbml.deprecated same as {{@link #get{0}Count()}}'.format(used_java_name))
        if self.is_java_api and self.is_list_of:
            if self.is_plugin is True:
                implementation = ['return isSetListOf{0}() ? getListOf{1}().size() : 0'.format(used_java_name_plural,
                                                                                               used_java_name_plural)]
            else:
                implementation = ['return isSetListOf{0}() ? getListOf{1}().size() : 0'.format(used_java_name_plural,
                                                                                               used_java_name_plural)]
        elif self.is_java_api and not self.is_list_of:
            if not self.document:
                if self.is_plugin is True:
                    implementation = [
                        'return isSetListOf{0}() ? getListOf{1}().size() : 0'.format(used_java_name_plural,
                                                                                     used_java_name_plural)]
                else:
                    implementation = [
                        'return isSetListOf{0}() ? getListOf{1}().size() : 0'.format(used_java_name_plural,
                                                                                     used_java_name_plural)]
            # TODO in case of parameter
            elif parameter:
                implementation = []
                comment_line = \
                    self.create_code_block('comment',
                                           ['TODO write_get_element_function_count --parameter-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)
            else:
                implementation = []
                comment_line = \
                    self.create_code_block('comment',
                                           ['TODO write_get_element_function_count --else-- in deviser'])
                implementation.append(comment_line)

                throw_exception_temp = ['throw new UnsupportedOperationException("Invalid operation")']
                throw_exception_line = self.create_code_block('line', throw_exception_temp)
                implementation.append(throw_exception_line)

        code = [self.create_code_block('line', implementation)]
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



    # Functions for writing getListOf

    # function to write get num
    def write_get_list_of_function(self, is_const=False):
        if not self.is_java_api and not is_const:
            return

        loname = strFunctions.list_of_name(self.child_name)
        loname_lower = strFunctions.jsbml_list_of_name(self.child_name)
        # create comment parts
        params = []
        if self.is_java_api:
            title_line = 'Returns the {0} from this {1}.' \
                         ''.format(loname, self.object_name)
            return_lines = ['@return the {0} '
                            'from this {1}.'.format(loname, self.object_name)]
        else:
            title_line = 'Returns a ListOf_t* containing {0} objects ' \
                         'from this {1}.'.format(self.object_child_name,
                                                 self.object_name)
            params.append('@param {0} the {1} structure whose \"{2}\" is sought'
                          '.'.format(self.abbrev_parent, self.object_name,
                                     loname))
            return_lines = ['@return the \"{0}\" from this {1} as a '
                            'ListOf_t *.'.format(loname, self.object_name)]
        additional = []

        # create the function declaration
        lo_name = strFunctions.remove_prefix(loname)
        lo_name_lower = strFunctions.remove_prefix(loname_lower)
        used_java_name = strFunctions.upper_first(self.child_name)
        used_java_name_lower = strFunctions.lower_first(self.child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)

        params.append('Returns the {{@link {0}}}'.format(loname_lower))
        params.append('Creates it if it does not already exist.')
        params.append(' ')
        params.append('@return the {{@link {0}}}.'.format(loname_lower))

        code = []
        # used_java_name = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name))
        # used_java_name_lower = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name_lower))
        if self.is_java_api:
            function = 'get{0}'.format(lo_name)
            arguments = []  # ['{0}s'.format(used_java_name)]

            if self.is_plugin is True:
                return_type = 'ListOf<{0}>'.format(used_java_type)
            else:
                return_type = 'ListOf<{0}>'.format(used_java_name)
        if self.is_java_api:
            implementation = ['{0} == null'.format(loname_lower)]

            if self.is_plugin is True:
                implementation.append('{0} = new ListOf<{1}>()'.format(loname_lower, used_java_type))
            else:
                implementation.append('{0} = new ListOf<{1}>()'.format(loname_lower, used_java_name))

            implementation.append('{0}.setNamespace({1}Constants.namespaceURI)'.format(loname_lower, self.package))
            implementation.append('{0}.setSBaseListType(ListOf.Type.other)'.format(loname_lower))

            if self.status != 'plugin':
                implementation.append('registerChild({0})'.format(loname_lower))

            temp_code = self.create_code_block('if', implementation)
            code.append(temp_code)

        if self.status == 'plugin':
            implementation = ['isSetExtendedSBase()']
            implementation.append('extendedSBase.registerChild({0})'.format(loname_lower))

            temp_code = self.create_code_block('if', implementation)
            code.append(temp_code)
            code.append(' ')

        line = 'return {0}'.format(loname_lower)
        line_code = line  # self.create_code_block('line', line)
        code.append(line_code)

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': is_const,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing isSetListOf

    # function to write isSet

    def write_is_set_list_of_function(self, is_const=False):
        if not self.is_java_api and not is_const:
            return

        loname = strFunctions.list_of_name(self.child_name)
        loname_lower = strFunctions.jsbml_list_of_name(self.child_name)
        # create comment parts
        params = []
        if self.is_java_api:
            title_line = 'Returns the {0} from this {1}.' \
                         ''.format(loname, self.object_name)
            return_lines = ['@return the {0} '
                            'from this {1}.'.format(loname, self.object_name)]
        else:
            title_line = 'Returns a ListOf_t* containing {0} objects ' \
                         'from this {1}.'.format(self.object_child_name,
                                                 self.object_name)
            params.append('@param {0} the {1} structure whose \"{2}\" is sought'
                          '.'.format(self.abbrev_parent, self.object_name,
                                     loname))
            return_lines = ['@return the \"{0}\" from this {1} as a '
                            'ListOf_t *.'.format(loname, self.object_name)]
        additional = []

        # create the function declaration
        lo_name = strFunctions.remove_prefix(loname)
        lo_name_lower = strFunctions.remove_prefix(loname_lower)
        used_java_name = strFunctions.upper_first(self.child_name)
        used_java_name_lower = strFunctions.lower_first(self.child_name)

        params.append('Returns {{@code true}} if {{@link {0}}} contains at least one element.'.format(loname_lower))
        params.append(' ')
        params.append('@return {{@code true}} if {{@link {0}}} contains at least one element, \
                    otherwise {{@code false}}.'.format(loname_lower))

        code = []
        # used_java_name = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name))
        # used_java_name_lower = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name_lower))
        if self.is_java_api:
            function = 'isSet{0}'.format(lo_name)
            arguments = []  # ['{0}s'.format(used_java_name)]
            return_type = 'boolean'

        if self.is_java_api:
            implementation = ['({0} == null) || {1}.isEmpty()'.format(loname_lower, loname_lower)]
            implementation.append('return false'.format(loname_lower, used_java_name))

            temp_code = self.create_code_block('if', implementation)
            code.append(temp_code)
        # return the parts

        line = 'return true'.format(loname_lower)
        line_code = line  # self.create_code_block('line', line)
        code.append(line_code)

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': is_const,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing setListOf

    # function to write set

    def write_set_list_of_function(self, is_const=False):
        if not self.is_java_api and not is_const:
            return

        loname = strFunctions.list_of_name(self.child_name)
        loname_lower = strFunctions.jsbml_list_of_name(self.child_name)
        # create comment parts
        params = []
        if self.is_java_api:
            title_line = 'Returns the {0} from this {1}.' \
                         ''.format(loname, self.object_name)
            return_lines = ['@return the {0} '
                            'from this {1}.'.format(loname, self.object_name)]
        else:
            title_line = 'Returns a ListOf_t* containing {0} objects ' \
                         'from this {1}.'.format(self.object_child_name,
                                                 self.object_name)
            params.append('@param {0} the {1} structure whose \"{2}\" is sought'
                          '.'.format(self.abbrev_parent, self.object_name,
                                     loname))
            return_lines = ['@return the \"{0}\" from this {1} as a '
                            'ListOf_t *.'.format(loname, self.object_name)]
        additional = []

        # create the function declaration
        lo_name = strFunctions.remove_prefix(loname)
        lo_name_lower = strFunctions.remove_prefix(loname_lower)
        used_java_name = strFunctions.upper_first(self.child_name)
        used_java_name_lower = strFunctions.lower_first(self.child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)

        params.append('Sets the given {{@code ListOf<{0}>}}.'.format(used_java_name))
        params.append('If {{@link {0}}} was defined before \
                      and contains some elements, they are all unset.'.format(loname_lower))
        params.append(' ')
        params.append('@param {0}'.format(loname_lower))

        code = []
        # used_java_name = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name))
        # used_java_name_lower = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name_lower))
        if self.is_java_api:
            function = 'set{0}'.format(lo_name)

            if self.is_plugin is True:
                arguments = ['ListOf<{0}> {1}'.format(used_java_type, loname_lower)]  # ['{0}s'.format(used_java_name)]
            else:
                arguments = ['ListOf<{0}> {1}'.format(used_java_name, loname_lower)]  # ['{0}s'.format(used_java_name)]
            return_type = 'void'

        if self.is_java_api:
            implementation = ['unset{0}()'.format(loname)]
            implementation.append('this.{0} = {1}'.format(loname_lower, loname_lower))
            implementation.append('this.{0}.setSBaseListType(ListOf.Type.other)'.format(loname_lower))

            #  not in template,but yes in transition,etc
            if self.status != 'plugin':
                implementation.append('registerChild(this.{0})'.format(loname_lower))

            temp_code = self.create_code_block('line', implementation)
            code.append(temp_code)
        # return the parts


        if self.status == 'plugin':
            implementation = ['isSetExtendedSBase()']
            implementation.append('extendedSBase.registerChild({0})'.format(loname_lower))

            temp_code = self.create_code_block('if', implementation)
            code.append(temp_code)
            code.append('')

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': is_const,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # Functions for writing unsetListOf

    # function to write unset

    def write_unset_list_of_function(self, is_const=False):
        if not self.is_java_api and not is_const:
            return

        loname = strFunctions.list_of_name(self.child_name)
        loname_lower = strFunctions.jsbml_list_of_name(self.child_name)
        # create comment parts
        params = []
        if self.is_java_api:
            title_line = 'Returns the {0} from this {1}.' \
                         ''.format(loname, self.object_name)
            return_lines = ['@return the {0} '
                            'from this {1}.'.format(loname, self.object_name)]
        else:
            title_line = 'Returns a ListOf_t* containing {0} objects ' \
                         'from this {1}.'.format(self.object_child_name,
                                                 self.object_name)
            params.append('@param {0} the {1} structure whose \"{2}\" is sought'
                          '.'.format(self.abbrev_parent, self.object_name,
                                     loname))
            return_lines = ['@return the \"{0}\" from this {1} as a '
                            'ListOf_t *.'.format(loname, self.object_name)]
        additional = []

        # create the function declaration
        lo_name = strFunctions.remove_prefix(loname)
        lo_name_lower = strFunctions.remove_prefix(loname_lower)
        used_java_name = strFunctions.upper_first(self.child_name)
        used_java_name_lower = strFunctions.lower_first(self.child_name)
        used_java_type = strFunctions.remove_prefix(self.object_child_type)

        params.append('Returns {{@code true}} if {{@link {0}}} \
                      contains at least one element, otherwise {{@code false}}.'.format(loname_lower))
        params.append(' ')
        params.append('@return {{@code true}} if {{@link {0}}} contains at least \
                         one element, otherwise {{@code false}}.'.format(loname_lower))

        code = []
        # used_java_name = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name))
        # used_java_name_lower = strFunctions.upper_first(strFunctions.remove_prefix(self.object_name_lower))
        if self.is_java_api:
            function = 'unset{0}'.format(lo_name)
            arguments = []  # ['{0}s'.format(used_java_name)]
            return_type = 'boolean'

        if self.is_java_api:
            implementation = ['isSet{0}()'.format(loname)]

            if self.is_plugin is True:
                implementation.append(
                    'ListOf<{0}> old{1} = this.{2}'.format(used_java_type, used_java_name, loname_lower))
            else:
                implementation.append(
                    'ListOf<{0}> old{1} = this.{2}'.format(used_java_name, used_java_name, loname_lower))

            implementation.append('this.{0} = null'.format(loname_lower))
            implementation.append('old{0}.fireNodeRemovedEvent()'.format(used_java_name))
            implementation.append('return true')

            temp_code = self.create_code_block('if', implementation)
            code.append(temp_code)

        line = 'return false'.format(loname_lower)
        line_code = line  # self.create_code_block('line', line)
        code.append(line_code)

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': is_const,
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # HELPER FUNCTIONS

    @staticmethod
    def create_code_block(code_type, lines):
        code = dict({'code_type': code_type, 'code': lines})
        return code
