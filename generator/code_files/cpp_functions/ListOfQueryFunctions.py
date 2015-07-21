#!/usr/bin/env python
#
# @file    ListOfQueryFunctions.py
# @brief   class to create functions to query a ListOf element
# @author  Frank Bergmann
# @author  Sarah Keating
#
# <!--------------------------------------------------------------------------
#
# Copyright (c) 2013-2014 by the California Institute of Technology
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

from util import strFunctions, query


class ListOfQueryFunctions():
    """Class for all functions for ListOf classes"""

    def __init__(self, language, is_cpp_api, is_list_of, class_object):
        self.language = language
        self.is_cpp_api = is_cpp_api
        self.is_list_of = is_list_of
        self.class_object = class_object
        self.package = class_object['package']
        if is_list_of:
            self.child_name = class_object['lo_child']
            self.class_name = class_object['name']
        else:
            self.child_name = strFunctions.upper_first(class_object['element'])
            self.class_name = class_object['parent']['name']
        if is_cpp_api:
            self.object_name = self.class_name
            self.object_child_name = self.child_name
        else:
            if is_list_of:
                self.object_name = 'ListOf_t'
            else:
                self.object_name = self.class_name + '_t'
            self.object_child_name = self.child_name + '_t'
        self.std_base = class_object['std_base']
        self.concretes = []
        if 'concretes' in class_object:
            self.concretes = class_object['concretes']

        self.has_id = True
        if not self.is_list_of:
            self.has_id = query.has_attribute(
                query.get_class(self.child_name, self.class_object['root']),
                'id')

        self.used_sidrefs = []

        # useful variables
        if not self.is_cpp_api and self.is_list_of:
            self.struct_name = self.object_child_name
        else:
            self.struct_name = self.object_name
        self.plural = strFunctions.plural(self.child_name)
        self.indef_name = strFunctions.get_indefinite(self.object_child_name)
        self.abbrev_parent = strFunctions.abbrev_name(self.object_name)
        self.abbrev_child = strFunctions.abbrev_name(self.child_name)

        # status
        if self.is_cpp_api:
            if self.is_list_of:
                self.status = 'cpp_list'
            else:
                self.status = 'cpp_not_list'
        else:
            if self.is_list_of:
                self.status = 'c_list'
            else:
                self.status = 'c_not_list'
        self.is_header = class_object['is_header']

    ########################################################################

    # Functions for writing get element functions

    # function to write get by index from a listOf
    def write_get_element_by_index(self, is_const):
        # c api does not need a non constant version
        if not self.is_cpp_api and not is_const:
            return

        # useful variables
        virtual = True if self.is_list_of else False
        # create comment parts
        title_line = 'Get {} {} from the {}.'.format(self.indef_name,
                                                     self.object_child_name,
                                                     self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param n, an unsigned int representing the index '
                      'of the {} to retrieve.'.format(self.object_child_name))
        return_lines = ['@return the nth {} in this {}.'.format(
            self.object_child_name, self.object_name)]
        additional = []
        if self.is_cpp_api:
            additional = ['@see size()'] if self.is_list_of \
                else ['@see getNum{}'.format(self.plural)]

        # create the function declaration
        arguments = []
        if self.is_cpp_api:
            function = 'get' if self.is_list_of else 'get{}'\
                .format(self.object_child_name)
        else:
            function = '{}_get{}'.format(self.class_name, self.child_name)
            arguments.append('{}* {}'.format(self.object_name,
                                             self.abbrev_parent))
        arguments.append('unsigned int n')
        if is_const:
            return_type = 'const {}*'.format(self.object_child_name)
        else:
            return_type = '{}*'.format(self.object_child_name)
        # if appropriate write the code
        code = []
        if not self.is_header:
            if self.status == 'cpp_list':
                const = 'const ' if is_const else ''
                implementation = ['return static_cast<{}{}*>(ListOf::'
                                  'get(n))'.format(const, self.child_name)]
                code = [self.create_code_block('line', implementation)]
            elif self.status == 'cpp_not_list':
                implementation = ['return {}.get'
                                  '(n)'.format(self.class_object['memberName'])]
                code = [self.create_code_block('line', implementation)]
            elif self.status == 'c_list':
                line = ['lo == NULL', 'return NULL']
                code = [self.create_code_block('if', line)]
                line = ['return static_cast <{}*>(lo)->get'
                        '(n)'.format(self.class_name)]
                code.append(self.create_code_block('line', line))
            else:
                line = ['return ({0} != NULL) ? {0}->get{1}(n) : '
                        'NULL'.format(self.abbrev_parent, self.child_name)]
                code = [self.create_code_block('line', line)]
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
    def write_get_element_by_id(self, is_const):
        # c api does not need a non constant version
        if not self.is_cpp_api and not is_const:
            return
        elif not self.has_id:
            return

        # useful variables
        virtual = True if self.is_list_of else False

        # create comment
        title_line = 'Get {} {} from the {} based on its identifier.'\
            .format(self.indef_name, self.object_child_name, self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param sid a string representing the identifier '
                      'of the {} to retrieve.'.format(self.object_child_name))
        return_lines = ['@return the {0} in this {1} based on the '
                        'identifier or NULL if no such {0} exists.'
                        .format(self.object_child_name, self.object_name)]
        additional = []
        if self.is_cpp_api:
            additional = ['@see size()'] if self.is_list_of \
                else ['@see getNum{}'.format(self.plural)]

        # create function declaration
        if self.is_cpp_api:
            function = 'get' if self.is_list_of \
                else 'get{}'.format(self.object_child_name)
            arguments = ['const std::string& sid']
        else:
            function = '{}_getById'.format(self.class_name) if self.is_list_of \
                else '{}_get{}ById'.format(self.class_name, self.child_name)
            arguments = ['{}* {}'.format(self.object_name, self.abbrev_parent),
                         'const char *sid']
        if is_const:
            return_type = 'const {}*'.format(self.object_child_name)
        else:
            return_type = '{}*'.format(self.object_child_name)
        # if appropriate write the code
        code = []
        if not self.is_header:
            if self.status == 'cpp_list':
                code = self.cpp_list_write_get_element_by_id(is_const)
            elif self.status == 'cpp_not_list':
                code = self.cpp_not_list_write_get_element_by_id()
            elif self.status == 'c_list':
                code = self.c_list_write_get_element_by_id()
            else:
                code = self.c_not_list_write_get_element_by_id()
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

    def cpp_list_write_get_element_by_id(self, const):
        if const:
            implementation = ['vector<{}*>::const_iterator '
                              'result'.format(self.std_base),
                              'result = find_if(mItems.begin(), mItems.end(), '
                              'IdEq<{}>(sid))'.format(self.object_child_name),
                              'return (result == mItems.end()) ? 0 : '
                              'static_cast  <const {}*> '
                              '(*result)'.format(self.object_child_name)]
        else:
            implementation = ['return const_cast<{}*>(static_cast<const {}&>'
                              '(*this).get(sid))'.format(self.object_child_name,
                                                         self.object_name)]
        code = [self.create_code_block('line', implementation)]
        return code

    def cpp_not_list_write_get_element_by_id(self):
        implementation = ['return {}.'
                          'get(sid)'.format(self.class_object['memberName'])]
        code = [self.create_code_block('line', implementation)]
        return code

    def c_list_write_get_element_by_id(self):
        code = []
        line = ['lo == NULL', 'return NULL']
        code.append(self.create_code_block('if', line))
        implementation = ['return (sid != NULL) ? static_cast <{}*>(lo)'
                              '->get(sid) : NULL'.format(self.class_name)]
        code.append(self.create_code_block('line', implementation))
        return code

    def c_not_list_write_get_element_by_id(self):
        implementation = ['return ({0} != NULL && '
                          'sid != NULL) ? {0}->get{1}'
                          '(sid) : NULL'.format(self.abbrev_parent,
                                                self.child_name)]
        code = [self.create_code_block('line', implementation)]
        return code

    # function to write get by sidref from a listOf
    def write_get_element_by_sidref(self, sid_ref, const):
        # c api does not need a non constant version
        if not self.is_cpp_api and not const:
            return

        # useful variables
        element = sid_ref['element']
        att_name = sid_ref['name']
        match = [element, const]
        if match in self.used_sidrefs:
            return
        else:
            self.used_sidrefs.append(match)

        # create comment
        title_line = 'Get {} {} from the {} based on the {} to which ' \
                     'it refers.'.format(self.indef_name,
                                         self.object_child_name,
                                         self.object_name,
                                         element)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param sid a string representing the {} attribute '
                      'of the {} object to '
                      'retrieve.'.format(att_name, self.object_child_name))
        return_lines = ['@return the first {0} in this {1} based on the '
                        'given {2} attribute or NULL if no such {0} exists.'
                        .format(self.object_child_name, self.object_name,
                                att_name)]
        additional = []

        # create function declaration
        if self.is_cpp_api:
            if self.is_list_of:
                function = 'getBy{}'.format(element)
            else:
                function = 'get{}By{}'.format(self.object_child_name, element)
            arguments = ['const std::string& sid']
        else:
            function = '{}_get{}By{}'.format(self.class_name,
                                             self.child_name, element)
            arguments = ['{}* {}'.format(self.object_name, self.abbrev_parent),
                         'const char *sid']
        if const:
            return_type = 'const {}*'.format(self.object_child_name)
        else:
            return_type = '{}*'.format(self.object_child_name)
        up_name = strFunctions.abbrev_name(element).upper()
        if const and self.is_cpp_api and self.is_list_of:
            implementation = ['vector<{}*>::const_iterator '
                              'result'.format(self.std_base),
                              'result = find_if(mItems.begin(), mItems.end(), '
                              'IdEq{}<>(sid))'.format(up_name),
                              'return (result == mItems.end()) ? 0 : '
                              'static_cast  <const {}*> '
                              '(*result)'.format(self.object_child_name)]
        elif self.is_cpp_api and not self.is_list_of:
            implementation = ['return {}.getBy{}'
                              '(sid)'.format(self.class_object['memberName'],
                                             element)]
        elif not const and self.is_cpp_api and self.is_list_of:
            implementation = ['return const_cast<{}*>(static_cast<const {}'
                              '&>(*this).getBy{}(sid))'.format(self.child_name,
                                                               self.class_name,
                                                               element)]
        else:
            implementation = ['return ({0} != NULL && '
                              'sid != NULL) ? {0}->get{1}By{2}'
                              '(sid) : NULL'.format(self.abbrev_parent,
                                                    self.child_name,
                                                    element)]
        code = [self.create_code_block('line', implementation)]
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
    def write_lookup(self, sid_ref):
        # c api does not need it
        if not self.is_cpp_api:
            return

        # useful variables
        element = sid_ref['element']
        eq_name = 'IdEq{}'.format(strFunctions.abbrev_name(element).upper())
        match = [element]
        if match in self.used_sidrefs:
            return
        else:
            self.used_sidrefs.append(match)
        open_b = '{'
        close_b = '}'
        # create comment
        title_line = 'Used by {}::get() to lookup {} {} ' \
                     'based on its {}.'.format(self.class_name, self.indef_name,
                                               self.child_name, element)
        params = []
        return_lines = []
        additional = []

        # create function declaration
        function = 'struct {} : public std::unary_function' \
                   '<SBase*, bool>'.format(eq_name)
        arguments = []
        return_type = ''
        code = ['const string& id;', ' ',
                '{} (const string& id) : id(id) {}  '
                '{}'.format(eq_name, open_b, close_b),
                'bool operator() (SBase* sb)', '{',
                '        return (static_cast<{}*>(sb)'
                '->get{}() == id);'.format(self.child_name, element), '}']
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

    # function to write remove by index from a listOf
    def write_remove_element_by_index(self):
        # useful variables
        virtual = True if self.is_list_of else False

        # create comment parts
        title_line = 'Removes the nth {} from this {} and returns a ' \
                     'pointer to it.'.format(self.object_child_name,
                                             self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param n, an unsigned int representing the index of '
                      'the {} to remove.'.format(self.object_child_name))
        return_lines = ['@return a pointer to the nth {} in this {}.'.format(
            self.object_child_name, self.object_name)]
        additional = []
        if self.is_cpp_api:
            additional = ['@see size()'] if self.is_list_of \
                else ['@see getNum{}'.format(self.plural)]
            additional.append(' ')
            additional.append('@note the caller owns the returned object and '
                              'is responsible for deleting it.')
        # create the function declaration
        arguments = []
        if self.is_cpp_api:
            function = 'remove' if self.is_list_of \
                else 'remove{}'.format(self.object_child_name)
        else:
            if self.is_list_of:
                function = '{}_remove'.format(self.class_name)
            else:
                function = '{}_remove{}'.format(self.class_name,
                                                self.child_name)

            arguments.append('{}* {}'.format(self.object_name,
                                             self.abbrev_parent))
        arguments.append('unsigned int n')
        return_type = '{}*'.format(self.object_child_name)

        if self.is_cpp_api and self.is_list_of:
            implementation = ['return static_cast<{}*>(ListOf::'
                              'remove(n))'.format(self.object_child_name)]
            code = [self.create_code_block('line', implementation)]
        elif self.is_cpp_api and not self.is_list_of:
            member = self.class_object['memberName']
            implementation = ['return {}.remove(n)'.format(member)]
            code = [self.create_code_block('line', implementation)]
        elif not self.is_cpp_api and self.is_list_of:
            line = ['lo == NULL', 'return NULL']
            code = [self.create_code_block('if', line)]
            line = ['return static_cast <{}*>(lo)->remove'
                    '(n)'.format(self.class_name)]
            code.append(self.create_code_block('line', line))
        else:
            line = ['return ({0} != NULL) ? '
                    '{0}->remove{1}(n) : '
                    'NULL'.format(self.abbrev_parent, self.child_name)]
            code = [self.create_code_block('line', line)]
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
    def write_remove_element_by_id(self):
        if not self.has_id:
            return
        # useful variables
        virtual = True if self.is_list_of else False

        # create comment parts
        title_line = 'Removes the {} from this {} based on its identifier and ' \
                     'returns a pointer to it.'.format(self.object_child_name,
                                                       self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to search.'
                          .format(self.abbrev_parent, self.object_name))
        params.append('@param sid, a string representing the identifier of '
                      'the {} to remove.'.format(self.object_child_name))
        return_lines = ['@return the {0} in this {1} based on the identifier '
                        'or NULL if no such {0} '
                        'exists.'.format(self.object_child_name,
                                         self.object_name)]
        additional = []
        if self.is_cpp_api:
            additional.append('@note the caller owns the returned object and '
                              'is responsible for deleting it.')
        # create the function declaration
        arguments = []
        if self.is_cpp_api:
            function = 'remove' if self.is_list_of \
                else 'remove{}'.format(self.object_child_name)
            arguments = ['const std::string& sid']
        else:
            if self.is_list_of:
                function = '{}_removeById'.format(self.class_name)
            else:
                function = '{}_remove{}ById'.format(self.class_name,
                                                    self.child_name)
            arguments.append('{}* {}'.format(self.object_name,
                                             self.abbrev_parent))
            arguments.append('const char* sid')
        return_type = '{}*'.format(self.object_child_name)

        if self.is_cpp_api and self.is_list_of:
            implementation = ['{}* item = NULL'.format(self.std_base),
                              'vector<{}*>::iterator '
                              'result'.format(self.std_base)]
            code = [self.create_code_block('line', implementation),
                    self.create_code_block('line',
                                           ['result = find_if(mItems.begin(), '
                                            'mItems.end(), IdEq<{}>(sid)'
                                            ')'.format(self.
                                                       object_child_name)])]
            implementation = ['result != mItems.end()', 'item = *result',
                              'mItems.erase(result)']
            code.append(self.create_code_block('if', implementation))
            code.append(
                self.create_code_block(
                    'line',
                    ['return static_cast <{}*> '
                     '(item)'.format(self.object_child_name)]))
        elif self.is_cpp_api and not self.is_list_of:
            member = self.class_object['memberName']
            implementation = ['return {}.remove(sid)'.format(member)]
            code = [self.create_code_block('line', implementation)]
        elif not self.is_cpp_api and self.is_list_of:
            line = ['lo == NULL', 'return NULL']
            code = [self.create_code_block('if', line)]
            line = ['return (sid != NULL) ? static_cast <{}*>(lo)->remove'
                    '(sid) : NULL'.format(self.class_name)]
            code.append(self.create_code_block('line', line))
        else:
            line = ['return ({0} != NULL && sid != NULL) ? '
                    '{0}->remove{1}(sid) : '
                    'NULL'.format(self.abbrev_parent, self.child_name)]
            code = [self.create_code_block('line', line)]

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
    @property
    def write_add_element_function(self):
        # create comment parts
        title_line = 'Adds a copy of the given {} to this {}.'.format(
            self.object_child_name, self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to which the {} '
                          'should be added.'.format(self.abbrev_parent,
                                                    self.object_name,
                                                    self.object_child_name))
        params.append('@param {}, the {} object to '
                      'add.'.format(self.abbrev_child, self.object_child_name))
        return_lines = ['@copydetails doc_returns_success_code',
                        '@li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, '
                        'OperationReturnValues_t}',
                        '@li @sbmlconstant{LIBSBML_OPERATION_FAILED,'
                        ' OperationReturnValues_t}']
        additional = []
        if self.is_cpp_api:
            additional.append('@copydetails doc_note_object_is_copied')
            additional.append(' ')
            additional.append('@see create{}()'.format(self.object_child_name))
        # create the function declaration
        arguments = []
        if self.is_cpp_api:
            function = 'add{}'.format(self.object_child_name)
        else:
            function = '{}_add{}'.format(self.class_name, self.child_name)
            arguments.append('{}* {}'.format(self.object_name,
                                             self.abbrev_parent))
        arguments.append('const {}* {}'.format(self.object_child_name,
                                               self.abbrev_child))
        return_type = 'int'
        member = ''
        if not self.is_list_of:
            member = self.class_object['memberName']
            else_lines = ['{}.append({})'.format(member, self.abbrev_child),
                          'return LIBSBML_OPERATION_SUCCESS']
        else:
            else_lines = ['append({})'.format(self.abbrev_child),
                          'return LIBSBML_OPERATION_SUCCESS']
        if self.is_cpp_api:
            implementation = ['{} == NULL'.format(self.abbrev_child),
                              'return LIBSBML_OPERATION_FAILED', 'else if',
                              '{}->hasRequiredAttributes() == '
                              'false'.format(self.abbrev_child),
                              'return LIBSBML_INVALID_OBJECT', 'else if',
                              'getLevel() != {}->'
                              'getLevel()'.format(self.abbrev_child),
                              'return LIBSBML_LEVEL_MISMATCH', 'else if',
                              'getVersion() != {}->'
                              'getVersion()'.format(self.abbrev_child),
                              'return LIBSBML_VERSION_MISMATCH', 'else if',
                              'matchesRequiredSBMLNamespacesForAddition'
                              '(static_cast<const {}*>({})) == '
                              'false'.format(self.std_base, self.abbrev_child),
                              'return LIBSBML_NAMESPACES_MISMATCH']
            if not self.is_list_of and self.has_id:
                implementation.append('else if')
                implementation.append('{0}->isSetId() '
                                      '&& ({1}->get({0}->getId())) '
                                      '!= NULL'.format(self.abbrev_child,
                                                       member))
                implementation.append('return LIBSBML_DUPLICATE_OBJECT_ID')
            implementation.append('else')
            implementation.append(self.create_code_block('line', else_lines))
            code = [self.create_code_block('else_if', implementation)]
        else:
            implementation = ['return ({0} != NULL) ? {0}->add{1}({2}) : '
                              'LIBSBML_INVALID'
                              '_OBJECT'.format(self.abbrev_parent,
                                               self.child_name,
                                               self.abbrev_child)]
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
        if len(self.concretes) == 0 and index == 0:
            child = self.object_child_name
        else:
            if index == 0:
                return
            else:
                i = index - 1
            child = self.concretes[i]['element']
        # create comment parts
        title_line = 'Creates a new {0} object, adds it to this {1} object ' \
                     'and returns the {0} object ' \
                     'created.'.format(child, self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure '
                          'to which the {} should be '
                          'added.'.format(self.abbrev_parent, self.object_name,
                                          self.object_child_name))
        return_lines = ['@return a new {} object '
                        'instance.'.format(child)]
        additional = []
        if self.is_cpp_api:
            additional.append('@see add{0}(const {0}* {1})'
                              .format(self.object_child_name,
                                      self.abbrev_child))
        # create the function declaration
        arguments = []
        if self.is_cpp_api:
            function = 'create{}'.format(child)
        else:
            function = '{}_create{}'.format(self.class_name, self.child_name)
            arguments.append('{}* {}'.format(self.object_name,
                                             self.abbrev_parent))
        return_type = '{}*'.format(child)

        if self.is_cpp_api:
            pack_up = self.package.upper()
            pack_low = self.package.lower()
            implementation = ['{}* {} = NULL'.format(self.child_name,
                                                     self.abbrev_child)]
            code = [self.create_code_block('line', implementation)]
            implementation = ['{}_CREATE_NS({}ns, '
                              'getSBMLNamespaces())'.format(pack_up, pack_low),
                              '{} = new {}({}ns)'.format(self.abbrev_child,
                                                         self.child_name,
                                                         pack_low),
                              'delete {}ns'.format(pack_low),
                              'catch', '...', '']
            code.append(self.create_code_block('try', implementation))
            implementation = ['{} != NULL'.format(self.abbrev_child)]
            if self.is_list_of:
                implementation.append('appendAndOwn'
                                      '({})'.format(self.abbrev_child))
            else:
                member = self.class_object['memberName']
                implementation.append('{}.appendAndOwn'
                                      '({})'.format(member, self.abbrev_child))
            code.append(self.create_code_block('if', implementation))
            implementation = ['return {}'.format(self.abbrev_child)]
            code.append(self.create_code_block('line', implementation))
        else:
            implementation = ['return ({0} != NULL) ? {0}->create{1}() : '
                              'NULL'.format(self.abbrev_parent,
                                            self.child_name)]
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

    ########################################################################

    # Functions for writing get num element functions

    # function to write get num
    def write_get_num_element_function(self):
        # create comment parts
        title_line = 'Get the number of {} objects in ' \
                     'this {}.'.format(self.object_child_name, self.object_name)
        params = []
        if not self.is_cpp_api:
            params.append('@param {}, the {} structure to query.'
                          .format(self.abbrev_parent, self.object_name))
        return_lines = ['@return the number of {} objects in '
                        'this {}.'.format(self.object_child_name,
                                          self.object_name)]
        additional = []

        # create the function declaration
        arguments = []
        if self.is_cpp_api:
            function = 'getNum{}'.format(self.plural)
        else:
            function = '{}_getNum{}'.format(self.class_name, self.plural)
            arguments.append('{}* {}'.format(self.object_name,
                                             self.abbrev_parent))
        return_type = 'unsigned int'

        if self.is_cpp_api and self.is_list_of:
            implementation = ['return size()']
        elif self.is_cpp_api and not self.is_list_of:
            implementation = ['return {}.'
                              'size()'.format(self.class_object['memberName'])]
        else:
            implementation = ['return ({0} != NULL) ? {0}->getNum{1}() : '
                              'SBML_INT_MAX'.format(self.abbrev_parent,
                                                    self.plural)]
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
        if not self.is_cpp_api and not is_const:
            return

        loname = strFunctions.list_of_name(self.child_name)
        # create comment parts
        params = []
        if self.is_cpp_api:
            title_line = 'Returns the {} from this {}.'.format(loname,
                                                               self.object_name)
            return_lines = ['@return the {} '
                            'from this {}.'.format(loname, self.object_name)]
        else:
            title_line = 'Returns a ListOf_t* containing {} objects ' \
                         'from this {}.'.format(self.object_child_name,
                                                self.object_name)
            params.append('@param {} the {} structure whose \"{}\" is sought.'
                          .format(self.abbrev_parent, self.object_name, loname))
            return_lines = ['@return the \"{}\" from this {} as a '
                            'ListOf_t *.'.format(loname, self.object_name)]
        additional = []

        # create the function declaration
        if self.is_cpp_api:
            function = 'get{}'.format(loname)
            arguments = []
            if is_const:
                return_type = 'const {}*'.format(loname)
            else:
                return_type = '{}*'.format(loname)
        else:
            function = '{}_get{}'.format(self.class_name, loname)
            arguments = ['const {}* {}'.format(self.object_name,
                                               self.abbrev_parent)]
            return_type = 'ListOf_t*'
        if self.is_cpp_api:
            implementation = ['return '
                              '&{}'.format(self.class_object['memberName'])]
            code = [self.create_code_block('line', implementation)]
        else:
            implementation = ['return ({0} != NULL) ? {0}->get{1}() : '
                              'NULL'.format(self.abbrev_parent, loname)]
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
                     'virtual': False,
                     'object_name': self.struct_name,
                     'implementation': code})

    ########################################################################

    # HELPER FUNCTIONS

    @staticmethod
    def create_code_block(code_type, lines):
        code = dict({'code_type': code_type, 'code': lines})
        return code
