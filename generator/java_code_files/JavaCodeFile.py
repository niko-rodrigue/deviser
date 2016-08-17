#!/usr/bin/env python
#
# @file    JavaCodeFile.py
# @brief   class for generating code file for the given class for Google Summer of Code 2016
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

from base_files import BaseJavaFile
from .java_functions import *
from util import query, strFunctions, global_variables


class JavaCodeFile(BaseJavaFile.BaseJavaFile):
    """Class for all Java Code files"""

    def __init__(self, class_object, represents_class=True):

        self.is_parser = class_object['is_parser']

        # Initialize whether jsbml parser o bjectis generated or class object
        if self.is_parser:
            self.initialize_parser(class_object)
        else:
            self.initialize_class(class_object, represents_class)

    def initialize_parser(self, class_object):
        self.brief_description = \
            'Implementation  of the {0} parser.'.format(class_object['name'])
        BaseJavaFile.BaseJavaFile.__init__(self, class_object['name'], 'java',
                                           class_object, self.is_parser)

        self.expand_parser_import_modules(class_object)

    def initialize_class(self, class_object, represents_class=True):
        # members from object
        self.brief_description = \
            'Implementation  of the {0} class.'.format(class_object['name'])
        BaseJavaFile.BaseJavaFile.__init__(self, class_object['name'], 'java',
                                           class_object['attribs'])

        # members from object
        if represents_class:
            self.expand_class(class_object)
            self.expand_import_modules(class_object)
            self.expand_jsbml_methods()

    ########################################################################

    # Functions for writing the class
    def write_class(self):
        # self.write_forward_class()
        # TODO for now only generate attribute functions
        self.write_constructors()

        self.write_attribute_functions()

        # Write mandatory funtions
        self.write_mandatory_functions()

        # write child element functions
        self.write_child_element_functions()

        # write listOf functions
        self.write_listof_functions()

        # write child_lo_element functions
        self.write_child_lo_element_functions()

        # TODO concrete functions haven't been modified
        self.write_concrete_functions()

        # This is used for writing hashCode, readAttributes, writeXMLAttributes as
        # well as missing function that have to be generated based on imports
        self.write_general_functions()

    ########################################################################

    # function to write the constructors
    def write_constructors(self):
        constructor = Constructors.Constructors(self.language,
                                                self.is_java_api,
                                                self.class_object,
                                                self.jsbml_data_tree,
                                                self.jsbml_methods,
                                                self.extends_modules)

        self.skip_line()
        if self.is_java_api and not self.is_plugin:
            code = constructor.write_simple_constructor()
            self.write_function_implementation(code)

            code = constructor.write_level_version_constructor()
            self.write_function_implementation(code)

            code = constructor.write_id_constructor()
            self.write_function_implementation(code)

            code = constructor.write_id_level_version_constructor()
            self.write_function_implementation(code)

            self.line_length = 90
            code = constructor.write_id_name_level_version_constructor()
            self.write_function_implementation(code)
            self.line_length = 79

            code = constructor.write_copy_constructor()
            self.write_function_implementation(code)

            code = constructor.write_init_defaults_constructor()
            self.write_function_implementation(code)

            code = constructor.write_equals()
            self.write_function_implementation(code)

        elif self.is_java_api and self.is_plugin:
            # This creates with the 'element' serving as argument
            # E.g. (Compartment compartment)
            code = constructor.write_basic_plugin_copy_constructor()
            self.write_function_implementation(code)

            code = constructor.write_copy_constructor()
            self.write_function_implementation(code)

        elif self.has_std_base:
            for i in range(0, len(self.concretes) + 1):
                code = constructor.write_level_version_constructor(i)
                self.write_function_implementation(code)

        #
        self.line_length = 150
        code = constructor.write_clone()
        self.write_function_implementation(code)
        self.line_length = 79

    ########################################################################

    # Functions for writing the attribute manipulation functions
    # these are for attributes and elements that occur as a single child

    # This is for writing java code and gives another layer for control
    def write_function_java(self, code):
        if code is not None:
            self.write_function_implementation(code)

    def write_mandatory_functions(self):
        attrib_functions = MandatoryFunctions.MandatoryFunctions(self.language,
                                                                 self.is_java_api,
                                                                 self.is_list_of,
                                                                 self.class_object,
                                                                 self.jsbml_data_tree,
                                                                 self.jsbml_methods)

        num_attributes = attrib_functions.get_num_attributes()

        # Most of the time comments length is more than 79
        self.line_length = 140
        for i in range(0, num_attributes):
            code = attrib_functions.write_mandatory(True, i)
            self.write_function_java(code)
        self.line_length = 79

    # function to write the get/set/isSet/unset functions for attributes
    def write_attribute_functions(self):
        attrib_functions = SetGetFunctions.SetGetFunctions(self.language,
                                                           self.is_java_api,
                                                           self.is_list_of,
                                                           self.class_object,
                                                           self.jsbml_data_tree,
                                                           self.jsbml_methods,
                                                           self.abstract_jsbml_methods)
        num_attributes = len(self.class_attributes)

        self.line_length = 140
        for i in range(0, num_attributes):
            code = attrib_functions.write_get(True, i)
            # self.write_function_implementation(code)
            self.write_function_java(code)

            code = attrib_functions.write_get_instance(True, i)
            self.write_function_java(code)

        for i in range(0, num_attributes):
            code = attrib_functions.write_is_set(True, i)

            self.write_function_java(code)

            code = attrib_functions.write_is_set_instance(True, i)
            self.write_function_java(code)

        for i in range(0, num_attributes):

            # curr_attribute = attrib_functions.get_attribute(True, i)

            self.line_length = 160
            code = attrib_functions.write_set(True, i)
            self.write_function_java(code)

            self.line_length = 180
            # Get number of function with identical names,but that take different arguments
            similar_num_attributes = attrib_functions.get_similar_num_attributes()
            for y in range(0, similar_num_attributes):
                code = attrib_functions.write_similar_functions(True, i, y)
                self.write_function_java(code)
            self.line_length = 79

        self.line_length = 160
        for i in range(0, num_attributes):
            code = attrib_functions.write_unset(True, i)
            self.write_function_java(code)

        self.line_length = 79

    # function to write the get/set/isSet/unset functions for single
    # child elements
    def write_child_element_functions(self, override=None):
        if override is None:
            if not self.has_children:
                return

            attrib_functions = SetGetFunctions. \
                SetGetFunctions(self.language, self.is_java_api,
                                self.is_list_of, self.class_object, self.jsbml_data_tree, self.jsbml_methods)

            num_elements = len(self.child_elements)
        else:
            attrib_functions = SetGetFunctions.SetGetFunctions(self.language,
                                                               self.is_java_api,
                                                               self.is_list_of,
                                                               override,
                                                               self.jsbml_data_tree, self.jsbml_methods)
            num_elements = 1

        for i in range(0, num_elements):
            code = attrib_functions.write_get(False, i)
            self.write_function_implementation(code)

        for i in range(0, num_elements):
            code = attrib_functions.write_is_set(False, i)
            self.write_function_implementation(code)

        for i in range(0, num_elements):
            self.line_length = 150
            code = attrib_functions.write_set(False, i)
            self.write_function_implementation(code)
            self.line_length = 79

        for i in range(0, num_elements):
            code = attrib_functions.write_create(False, i)
            if override is None and code is None \
                    and 'concrete' in self.child_elements[i]:
                # need to write creates for the concrete
                member = self.child_elements[i]['memberName']
                concrete = self.child_elements[i]['concrete']
                concretes = query.get_concretes(self.class_object['root'],
                                                concrete)
                for j in range(0, len(concretes)):
                    code = attrib_functions \
                        .write_create_concrete_child(concretes[j], member)
                    self.write_function_implementation(code)
            else:
                self.write_function_implementation(code)

        for i in range(0, num_elements):
            code = attrib_functions.write_unset(False, i)
            self.write_function_implementation(code)

    ########################################################################

    # Functions for writing general functions

    def write_general_functions(self):
        gen_functions = GeneralFunctions.GeneralFunctions(self.language,
                                                          self.is_java_api,
                                                          self.is_list_of,
                                                          self.class_object,
                                                          self.jsbml_data_tree,
                                                          self.jsbml_methods,
                                                          self.prime_numbers,
                                                          self.abstract_jsbml_methods,
                                                          self.extends_modules)

        # Write AbstractSBase override Methods
        if self.is_plugin is True:
            code = gen_functions.write_get_package_name()
            self.write_function_implementation(code)

            code = gen_functions.write_get_prefix()
            self.write_function_implementation(code)

            code = gen_functions.write_get_uri()
            self.write_function_implementation(code)

            code = gen_functions.write_get_parent()
            self.write_function_implementation(code)

            code = gen_functions.write_get_parent_sbml_object()
            self.write_function_implementation(code)

        # Write abstract methods from the interfaces
        # Obtain abstract methods that need to be overriden
        num_abstract = gen_functions.obtain_interface_abstract_methods()
        self.line_length = 150
        for i in range(0, num_abstract):
            code = gen_functions.write_interface_abstract_methods(i)
            self.write_function_implementation(code)

        self.line_length = 79
        code = gen_functions.write_get_child_at()
        self.write_function_implementation(code)
        self.line_length = 79

        code = gen_functions.write_get_allows_children()
        self.write_function_implementation(code)

        code = gen_functions.write_get_child_count()
        self.write_function_implementation(code)

        code = gen_functions.write_hashcode()
        self.write_function_implementation(code)

        self.line_length = 81
        code = gen_functions.write_to_string()
        self.write_function_implementation(code)
        self.line_length = 79

        self.line_length = 122
        code = gen_functions.write_read_attribute()
        self.write_function_implementation(code)
        self.line_length = 79

        # TODO Need to change this
        self.line_length = 90
        code = gen_functions.write_write_xml_attribute()
        self.write_function_implementation(code)
        self.line_length = 79


    ####################################################################################################################

    # concrete class functions

    def write_concrete_functions(self):
        conc_functions = \
            ConcreteClassFunctions.ConcreteClassFunctions(self.language,
                                                          self.is_java_api,
                                                          self.is_list_of,
                                                          self.class_object)
        for i in range(0, len(self.concretes)):
            code = conc_functions.write_is_foo(i)
            self.write_function_implementation(code)

    ########################################################################

    # Functions for writing functions for the main ListOf class

    def write_listof_functions(self):
        if not self.is_list_of:
            return

        lo_functions = ListOfQueryFunctions \
            .ListOfQueryFunctions(self.language, self.is_java_api,
                                  self.is_list_of,
                                  self.class_object)

        code = lo_functions.write_get_element_by_index(is_const=False)
        self.write_function_implementation(code)

        code = lo_functions.write_get_element_by_index(is_const=True)
        self.write_function_implementation(code)

        code = lo_functions.write_get_element_by_id(is_const=False)
        self.write_function_implementation(code)

        code = lo_functions.write_get_element_by_id(is_const=True)
        self.write_function_implementation(code)

        code = lo_functions.write_remove_element_by_index()
        self.write_function_implementation(code)

        code = lo_functions.write_remove_element_by_id()
        self.write_function_implementation(code)

        if self.is_java_api:
            code = lo_functions.write_add_element_function()
            self.write_function_implementation(code)

            code = lo_functions.write_get_num_element_function()
            self.write_function_implementation(code)

            for i in range(0, len(self.concretes) + 1):
                code = lo_functions.write_create_element_function(i)
                self.write_function_implementation(code)

            for i in range(0, len(self.sid_refs)):
                code = lo_functions.write_lookup(self.sid_refs[i])
                self.write_function_verbatim(code)

                code = \
                    lo_functions.write_get_element_by_sidref(self.sid_refs[i],
                                                             const=True)
                self.write_function_implementation(code)

                code = \
                    lo_functions.write_get_element_by_sidref(self.sid_refs[i],
                                                             const=False)
                self.write_function_implementation(code)

    # This is for writing child_lo_elements functions in a group
    def write_child_lo_element_functions_by_groups(self, function_to_write):
        num_elements = len(self.child_lo_elements)
        for i in range(0, num_elements):
            element = self.child_lo_elements[i]
            element['std_base'] = self.std_base
            element['package'] = self.package
            element['is_header'] = self.is_header
            element['is_plugin'] = self.is_plugin
            if self.is_plugin:
                element['plugin'] = self.class_name
            if 'concrete' in element:
                element['concretes'] = query.get_concretes(
                    self.class_object['root'], element['concrete'])
            lo_functions = ListOfQueryFunctions \
                .ListOfQueryFunctions(self.language, self.is_java_api,
                                      self.is_list_of,
                                      element)

            if function_to_write == 'isSetListOf':
                code = lo_functions.write_is_set_list_of_function()
                self.write_function_implementation(code)

            if function_to_write == 'setListOf':
                code = lo_functions.write_set_list_of_function()
                self.write_function_implementation(code)

            if function_to_write == 'unsetListOf':
                code = lo_functions.write_unset_list_of_function()
                self.write_function_implementation(code)

            if function_to_write == 'addElement':
                code = lo_functions.write_add_element_function()
                self.write_function_implementation(code)

            # removeInput
            if function_to_write == 'removeElement':
                code = lo_functions.write_remove_element()
                self.write_function_implementation(code)

            if function_to_write == 'removeElementByIndex':
                code = lo_functions.write_remove_element_by_index()
                self.write_function_implementation(code)

            if function_to_write == 'removeElementById':
                code = lo_functions.write_remove_element_by_id()
                self.write_function_implementation(code)

            if function_to_write == 'getListOf':
                code = lo_functions.write_get_list_of_function()
                self.write_function_implementation(code)

            if function_to_write == 'getNum':
                code = lo_functions.write_get_num_element_function()
                self.write_function_implementation(code)

            if function_to_write == 'getCount':
                code = lo_functions.write_get_element_function_count()
                self.write_function_implementation(code)

            if function_to_write == 'createElement':
                if 'concretes' in element:
                    for n in range(0, len(element['concretes'])):
                        code = lo_functions.write_create_element_function(n + 1)
                        self.write_function_implementation(code)
                else:
                    # createInput
                    code = lo_functions.write_create_element_function()
                    self.write_function_implementation(code)

            if function_to_write == 'createElementID':
                if 'concretes' in element:
                    for n in range(0, len(element['concretes'])):
                        code = lo_functions.write_create_element_id_function(n + 1)
                        self.write_function_implementation(code)
                else:
                    # createInput
                    code = lo_functions.write_create_element_id_function()
                    self.write_function_implementation(code)

    # main function to write the functions dealing with a child listOf element
    def write_child_lo_element_functions(self):
        function_to_write = 'addElement'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'removeElement'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'removeElementByIndex'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'removeElementById'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'getListOf'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'createElement'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        # TODO not necessary for deviser right now for child_lo_elements functions
        # function_to_write = 'createElementID'
        # self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'getNum'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'getCount'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'isSetListOf'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'setListOf'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        function_to_write = 'unsetListOf'
        self.write_child_lo_element_functions_by_groups(function_to_write)

        num_elements = len(self.child_lo_elements)
        for i in range(0, num_elements):
            element = self.child_lo_elements[i]
            element['std_base'] = self.std_base
            element['package'] = self.package
            element['is_header'] = self.is_header
            element['is_plugin'] = self.is_plugin
            if self.is_plugin:
                element['plugin'] = self.class_name
            if 'concrete' in element:
                element['concretes'] = query.get_concretes(
                    self.class_object['root'], element['concrete'])
            lo_functions = ListOfQueryFunctions \
                .ListOfQueryFunctions(self.language, self.is_java_api,
                                      self.is_list_of,
                                      element)

            sid_ref = query.get_sid_refs_for_class(element)
            for j in range(0, len(sid_ref)):
                if self.is_list_of:
                    code = lo_functions.write_lookup(sid_ref[j])
                    self.write_function_verbatim(code)

    ########################################################################

    # Write  class file
    def write_file(self):
        if self.is_package_info_plugin:
            BaseJavaFile.BaseJavaFile.write_file(self)
            BaseJavaFile.BaseJavaFile.write_jsbml_types_doc(self)
            self.write_package_include()
        else:
            BaseJavaFile.BaseJavaFile.write_file(self)
            self.write_package_include()
            self.write_java_imports()
            # self.write_general_includes()
            BaseJavaFile.BaseJavaFile.write_jsbml_types_doc(self)
            self.write_jsbml_class_header()
            self.write_jsbml_class_variables()
            self.write_class()
            self.close_jsbml_class_header()

    def write_parser_functions(self):
        parser_functions = ParserFunctions.ParserFunctions(self.language,
                                                           self.is_java_api,
                                                           self.expanded_package,
                                                           self.jsbml_data_tree,
                                                           self.extends_modules)

        self.line_length = 150
        code = parser_functions.write_get_namespace_uri()
        self.write_function_implementation(code)

        code = parser_functions.write_get_short_label()
        self.write_function_implementation(code)

        code = parser_functions.write_is_required()
        self.write_function_implementation(code)

        code = parser_functions.write_get_package_name()
        self.write_function_implementation(code)

        code = parser_functions.write_get_package_namespaces()
        self.write_function_implementation(code)

        code = parser_functions.write_get_namespaces()
        self.write_function_implementation(code)

        code = parser_functions.write_get_namespace_for()
        self.write_function_implementation(code)

        code = parser_functions.write_create_plugin_for_sbase()
        self.write_function_implementation(code)

        # TODO ASTNodePlugin createPluginFor is for newer versions of JSBML
        # So for the moment it has been turned off
        # code = parser_functions.write_create_plugin_for_astnode()
        # self.write_function_implementation(code)

        code = parser_functions.write_get_list_of_sbml_elements_to_write()
        self.write_function_implementation(code)

        code = parser_functions.write_process_attribute()
        self.write_function_implementation(code)
        #
        code = parser_functions.write_process_end_element()
        self.write_function_implementation(code)
        #
        code = parser_functions.write_process_start_element()
        self.write_function_implementation(code)
        #
        code = parser_functions.write_write_element_parser()
        self.write_function_implementation(code)
        #
        self.line_length = 79

    def write_parser_class(self):
        # self.write_forward_class()
        # TODO for now only generate attribute functions
        self.write_parser_functions()

    def write_parser_file(self):
        BaseJavaFile.BaseJavaFile.write_file(self)
        self.write_package_include()
        self.write_java_imports()
        BaseJavaFile.BaseJavaFile.write_jsbml_types_doc(self)

        curr_include_line = '@ProviderFor(ReadingParser.class)'
        self.write_line_verbatim(curr_include_line)

        self.write_jsbml_class_header()
        self.write_jsbml_parser_variables()
        self.skip_line(1)

        self.write_parser_class()
        self.skip_line(1)
        self.close_jsbml_class_header()
