#!/usr/bin/env python
#
# @file    JavaEnumCodeFile.py
# @brief   class for generating java enum code file for the given extension
# @author  Hovakim Grabski. Google Summer of Code 2016
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


class JavaEnumCodeFile(BaseJavaFile.BaseJavaFile):
    """Class for all Java Code files"""

    def __init__(self, enum_package, original_package, custom_file=None):

        self.up_enum_package = strFunctions.upper_first(enum_package['name'])

        # Get enums data
        self.enums_data = enum_package['values']

        self.original_enum_package = original_package
        self.custom_file = custom_file
        if self.custom_file is None:
            self.filename = '{0}'.format(self.up_enum_package)
            self.name = '{0}'.format(self.up_enum_package)

        self.brief_description = \
            'Implementation  of {0} Enum.'.format(self.name)
        BaseJavaFile.BaseJavaFile.__init__(self, self.name, 'java',
                                           None)

        # members from object
        self.package = original_package['name']
        self.cap_package = strFunctions.upper_first(original_package['name'])

    def write_enum_header(self):
        line_to_write = 'public enum {0} '.format(self.up_enum_package)
        self.write_line_jsbml(line_to_write)
        self.file_out.write('\n')  # TODO not a good solution for writing enum header
        self.line_length = 79

    ###################################################################################################################

    # Functions for writing the attribute manipulation functions
    # these are for attributes and elements that occur as a single child

    def write_function_java(self, code):
        # print('Ylo friend')
        if code is not None:
            self.write_function_implementation(code)

            # function to write the get/set/isSet/unset functions for attributes

    ########################################################################

    # Write file
    # TODO add variable whether extension or parser
    def write_package_include(self):
        if global_variables.is_package:
            curr_include_line = 'package org.sbml.{0}.ext.{1};'.format(self.language, self.package.lower())
            # print('curr_include_line is ', curr_include_line)
            self.write_line_verbatim(curr_include_line)
            self.file_out.write('\n')

    def close_enum_header(self):
        self.down_indent()
        self.file_out.write('}\n')

    def write_jsbml_enums(self):
        self.up_indent()

        enums = self.enums_data
        # attributes = self.class_attributes
        for i in range(0, len(enums)):
            enum = enums[i]
            self.write_variable_comment()
            if i == len(enums) - 1:
                line = '{0}'.format(enum['value'])
            else:
                line = '{0},'.format(enum['value'])
            self.write_line(line)

        self.down_indent()

        # TODO for writing imports

    def write_java_imports(self):
        self.skip_line()
        java_modules = self.jsbml_class_header_and_import['javaModules']
        if len(java_modules) > 0:
            for module in java_modules:
                javaModuleLine = 'import {0}'.format(module)
                self.write_jsbml_line_verbatim(javaModuleLine)
            self.skip_line()

        jsbml_modules = self.jsbml_class_header_and_import['jsbmlModules']
        if len(jsbml_modules) > 0:
            for module in jsbml_modules:
                jsbmlModuleLine = 'import org.sbml.jsbml.{0}'.format(module)
                self.write_jsbml_line_verbatim(jsbmlModuleLine)
            self.skip_line()

    def write_file(self):
        BaseJavaFile.BaseJavaFile.write_file(self)
        self.write_package_include()
        # self.write_java_imports()
        BaseJavaFile.BaseJavaFile.write_jsbml_types_doc(self)
        self.write_enum_header()
        self.write_jsbml_enums()
        self.close_enum_header()


    def write_jsbml_list_enums(self):
        self.up_indent()

        # Still many things to do
        enums = self.enums_data
        for i in range(0, len(enums)):
            enum = enums[i]
            self.write_variable_comment()
            line = 'listOf{0},'.format(strFunctions.plural(enum['name']))
            self.write_line(line)

        self.write_variable_comment()
        self.write_line('none;')

        self.down_indent()

    def write_list_enum_file(self):
        BaseJavaFile.BaseJavaFile.write_file(self)
        self.write_package_include()

        BaseJavaFile.BaseJavaFile.write_jsbml_types_doc(self)
        self.write_enum_header()
        self.write_jsbml_list_enums()
        self.close_enum_header()
