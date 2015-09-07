#!/usr/bin/env python
#
# @file    ValidatorClassFunctions.py
# @brief   class to create functions for validator classes
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

from util import strFunctions


class ValidatorClassFunctions():
    """Class for all protected functions"""

    def __init__(self, language, class_name, is_header, elements=None,
                 package='', std_base=''):
        self.language = language
        self.up_language = strFunctions.upper_first(language)
        self.cap_language = language.upper()

        self.class_name = class_name
        self.std_base = std_base

        self.is_header = is_header
        self.elements = elements
        self.package = package
        self.up_package = strFunctions.upper_first(package)
    ########################################################################

    # Function for writing constructor/destructor functions

    def write_constructor(self, name=''):
        # create comment parts
        if name == 'visitor':
            title_line = ''
            params = []
        else:
            title_line = 'Creates a new {} object for the given category of ' \
                         'validation.'.format(self.class_name)
            params = ['@param category code indicating the type of validation '
                      'that this validator will perform']
        return_lines = []
        additional = []

        # create the function declaration
        function = '{}'.format(self.class_name)
        return_type = ''
        if name == 'visitor':
            arguments = ['{}Validator& v'.format(self.up_package),
                         'const Model& m']
            constructor_args = [': v(v)', ', m(m)']
            arguments_no_defaults = arguments
        else:
            arguments = ['{0}ErrorCategory_t category = '
                         'LIB{0}_CAT_{0}'.format(self.cap_language)]
            arguments_no_defaults = ['{}ErrorCategory_t '
                                     'category'.format(self.cap_language)]
            constructor_args = [': Validator(category)']
        code = []
        if not self.is_header:
            if name == 'visitor':
                code = [self.create_code_block('blank', [])]
            else:
                line = ['m{0}Constraints = new {0}Validator'
                        'Constraints()'.format(self.up_package)]
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
                     'virtual': False,
                     'object_name': self.class_name,
                     'implementation': code,
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})

    def write_destructor(self, constraints=False):
        # create comment parts
        title_line = 'Destroys this {} object.'.format(self.class_name)
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = '~{}'.format(self.class_name)
        return_type = ''
        arguments = []
        code = []
        if not self.is_header:
            if constraints:
                line = 'map<VConstraint*, bool>::iterator it = ptrMap.begin()'
                code.append(self.create_code_block('line', [line]))
                nested_if = self.create_code_block('if', ['it->second',
                                                          'delete it->first'])
                code.append(self.create_code_block('while',
                                                   ['it != ptrMap.end()',
                                                    nested_if, '++it']))
            else:
                line = ['delete m{}Constraints'.format(self.up_package)]
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code})

    ########################################################################

    # Function for writing init/addConstraints functions

    def write_init_function(self):
        # create comment parts
        title_line = 'Initializes this {} object.'.format(self.class_name)
        params = []
        return_lines = []
        additional = ['When creating a subclass of {}, override this method '
                      'to add your own validation '
                      'code.'.format(self.class_name)]

        # create the function declaration
        function = 'init'
        return_type = 'void'
        arguments = []
        code = []
        if not self.is_header:
            line = ['To DO'.format()]
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code,
                     'pure_abstract': True})

    def write_add_constraint_function(self):
        # create comment parts
        title_line = 'Adds the given VConstraint object to this ' \
                     '{}.'.format(self.class_name)
        params = ['@param c the VConstraint (\"validator constraint\") object '
                  'to add.']
        return_lines = []
        additional = []

        # create the function declaration
        function = 'addConstraint'
        return_type = 'void'
        arguments = ['VConstraint* c']
        code = []
        if not self.is_header:
            line = ['m{}Constraints->add(c)'.format(self.up_package)]
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code})

    ########################################################################

    # Function for writing init/addConstraints functions

    def write_validate_function(self, object_type):
        # create comment parts
        if object_type == 'doc':
            title_line = 'Validates the given ' \
                         '{}Document'.format(self.cap_language)
            params = ['@param d the {}Document object to be '
                      'validated.'.format(self.cap_language)]
        else:
            title_line = 'Validates the {}Document located at the given ' \
                         'filename'.format(self.cap_language)
            params = ['@param filename, the path to the file to be read '
                      'and validated']
        return_lines = [' @return the number of validation failures that '
                        'occurred.  The objects describing the actual failures '
                        'can be retrieved using getFailures().']
        additional = []

        # create the function declaration
        function = 'validate'
        return_type = 'unsigned int'
        if object_type == 'doc':
            arguments = ['const {}Document& d'.format(self.cap_language)]
        else:
            arguments = ['const std::string& filename']
        code = []
        if not self.is_header and object_type == 'doc':
            code.append(self.create_code_block('line', ['const Model* m = '
                                                        'd.getModel()']))
            nested_if = self.create_code_block('if', ['plugin != NULL',
                                                      'plugin->accept(vv)'])
            lines = ['m != NULL',
                     '{}ValidatingVisitor vv(*this, '
                     '*m)'.format(self.up_package),
                     'const {0}ModelPlugin* plugin = static_cast<const '
                     '{0}ModelPlugin*>(m->getPlugin(\"{1}\")'
                     ')'.format(self.up_package, self.package),
                     nested_if]
            code.append(self.create_code_block('if', lines))
            code.append(self.create_code_block('comment',
                                               ['ADD ANY OTHER OBJECTS '
                                                'THAT HAS PLUGINS']))
            code.append(self.create_code_block('line',
                                               ['return (unsigned int)'
                                                '(mFailures.size())']))
        elif not self.is_header and object_type != 'doc':
            line = ['{}Reader  reader'.format(self.cap_language),
                    '{0}Document* d = reader.read{0}'
                    '(filename)'.format(self.cap_language)]
            code = [self.create_code_block('line', line),
                    self.create_code_block('blank', []),
                    self.create_code_block('line',
                                           ['unsigned int numErrors = '
                                            'd->getNumErrors()']),
                    self.create_code_block('blank', [])]

            lines = ['unsigned int n=0; n < numErrors; ++n',
                     'logFailure(*d->getError(n))']
            code.append(self.create_code_block('for', lines))
            lines = ['numErrors += validate(*d)', 'delete d',
                     'return numErrors']
            code.append(self.create_code_block('line', lines))

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
                     'object_name': self.class_name,
                     'implementation': code})

    ########################################################################

    # Function for writing the validator structure functions

    def write_apply_function(self):
        # create comment parts
        title_line = ''
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'Apply'
        return_type = ''
        arguments = ['const Model& m, const T& o']
        constructor_args = [': model(m)', ', object(o)']
        code = []
        if not self.is_header:
            line = []
            code = [self.create_code_block('blank', line)]

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
                     'object_name': self.class_name,
                     'implementation': code,
                     'constructor_args': constructor_args})

    def write_operator_function(self):
        # create comment parts
        title_line = ''
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'operator()'
        return_type = 'void'
        arguments = ['TConstraint<T>* constraint']
        line = ['constraint->check(model, object)']
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code})

    def write_constraint_add_function(self):
        # create comment parts
        title_line = 'Adds a Constraint to this ConstraintSet'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'add'
        return_type = 'void'
        arguments = ['TConstraint<T>* c']
        line = ['constraints.push_back(c)']
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code})

    def write_apply_to_function(self):
        # create comment parts
        title_line = 'Applies all Constraints in this ConstraintSet to the ' \
                     'given {} object of type T. Constraint violations are ' \
                     'logged to Validator.'.format(self.cap_language)
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'applyTo'
        return_type = 'void'
        arguments = ['const Model& model', 'const T& object']
        line = ['for_each(constraints.begin(), constraints.end(), '
                'Apply<T>(model, object))']
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code})

    def write_empty_function(self):
        # create comment parts
        title_line = 'Returns true if the ConstraintSet is empty, ' \
                     'false otherwise'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'empty'
        return_type = 'bool'
        arguments = []
        line = ['return constraints.empty()']
        code = [self.create_code_block('line', line)]

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
                     'object_name': self.class_name,
                     'implementation': code})

    def write_v_constraint_add_function(self):
        # create comment parts
        title_line = 'Adds the given Constraint to the appropriate ' \
                     'ConstraintSet'
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'add'
        return_type = 'void'
        arguments = ['VConstraint* c']
        line = ['if (c == NULL) return']
        code = [self.create_code_block('line', line)]
        line = 'ptrMap.insert(pair<VConstraint*, bool>(c, true))'
        code.append(self.create_code_block('line', [line]))
        name = '{}Document'.format(self.cap_language)
        block = self.create_if_add_constraint_block(name)
        code.append(block)
        block = self.create_if_add_constraint_block('Model')
        code.append(block)
        for element in self.elements:
            block = self.create_if_add_constraint_block(element['name'])
            code.append(block)

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
                     'object_name': self.class_name,
                     'implementation': code})

    def create_if_add_constraint_block(self, name):
        lines = ['dynamic_cast< TConstraint<{}>* >(c) != NULL'.format(name),
                 'm{0}.add(static_cast< TConstraint<{0}>* >(c) )'.format(name),
                 'return']
        return self.create_code_block('if', lines)

    ######################################################################

    # Functions to write the visit functions

    def write_visit_function(self, name):
        # create comment parts
        title_line = ''
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'visit'
        return_type = 'bool'
        arguments = ['const {}& x'.format(name)]
        line = ['v.m{}Constraints->m{}.applyTo(m, x)'.format(self.up_package,
                                                             name),
                'return !v.m{}Constraints->m{}.empty()'.format(self.up_package,
                                                               name)]
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
                     'virtual': True,
                     'object_name': self.class_name,
                     'implementation': code})

    def write_visit_base_function(self):
        # create comment parts
        title_line = ''
        params = []
        return_lines = []
        additional = []

        # create the function declaration
        function = 'visit'
        return_type = 'virtual bool'
        arguments = ['const {}& x'.format(self.std_base)]
        std_return = 'return {}Visitor::visit(x)'.format(self.cap_language)
        line = ['x.getPackageName() != \"{}\"'.format(self.package),
                std_return]
        code = [self.create_code_block('if', line),
                self.create_code_block('line',
                                       ['int code = x.getTypeCode()']),
                self.create_code_block('line',
                                       ['const ListOf* list = dynamic_cast'
                                        '<const ListOf*>(&x)'])]
        no_elements = len(self.elements)
        element = self.elements[0]
        lines = ['code == {}'.format(element['typecode']),
                 'return visit((const {}&)x)'.format(element['name'])]
        index = 1
        while index < no_elements:
            element = self.elements[index]
            lines.append('else if')
            lines.append('code == {}'.format(element['typecode']))
            lines.append('return visit((const {}&)x)'.format(element['name']))
            index += 1
        lines.append('else')
        lines.append(std_return)
        nested_if = self.create_code_block('else_if', lines)

        code.append(self.create_code_block('if_else', ['list != NULL',
                                                       std_return, 'else',
                                                       nested_if]))

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
                     'object_name': self.class_name,
                     'implementation': code})

    @staticmethod
    def create_code_block(code_type, lines):
        code = dict({'code_type': code_type, 'code': lines})
        return code