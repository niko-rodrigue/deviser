#!/usr/bin/env python
#
# @file    JavaExtensionCodeFile.py
# @brief   class for generating code file for the given extension
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

from base_files import BaseJavaFile
from . java_functions import *
from util import query, strFunctions, global_variables


class JavaExtensionCodeFile(BaseJavaFile.BaseJavaFile):
    """Class for all Java Code files"""

    def __init__(self, package, custom_file=None):

        self.up_package = strFunctions.upper_first(package['name'])

        # TODO GSOC 2016
        self.original_package = package
        self.custom_file = custom_file
        if self.custom_file is not None:
            self.filename = '{0}{1}'.format(self.up_package, self.custom_file)
            self.name = '{0}{1}'.format(self.up_package, self.custom_file)
        else:
            self.name = '{0}Extension'.format(self.up_package)

        self.brief_description = \
            'Implementation  of {0}.'.format(self.name)
        BaseJavaFile.BaseJavaFile.__init__(self, self.name, 'java',
                                           None)

        # members from object
        self.package = package['name']
        self.cap_package = package['name'].upper()


        # TODO not useful for jsbml
        # self.baseClass = '{0}Extension'.format(self.cap_language)





        self.elements = package['elements']
        self.number = package['number']
        self.enums = package['enums']
        self.plugins = package['plugins']
        self.offset = package['offset']

        self.num_versions = 1
        if 'num_versions' in package:
            self.num_versions = package['num_versions']

        # create a class object so we can just reuse code
        self.class_object['package'] = self.package
        self.class_object['name'] = self.name
        self.class_object['concretes'] = []
        self.class_object['baseClass'] = self.baseClass
        self.class_object['attribs'] = []
        self.class_object['has_children'] = False
        self.class_object['child_elements'] = []
        self.class_object['overwrites_children'] = False

        # TODO GSOC 2016 JSBML
        # TODO GSOC 2016
        self.pack = self.package
        self.expand_import_modules(self.original_package)
        self.expand_jsbml_methods()


    ########################################################################

    # Functions for writing the class
    def write_class(self):
        # self.write_forward_class()
        self.write_attribute_functions()
        # self.write_extension_instance()
        # self.write_constructors()
        # self.write_virtual_functions()
        # self.write_init_function()

    ########################################################################
    # Functions for writing specific includes and forward implementations

    def write_general_includes(self):

        self.write_line_verbatim('#include <{0}/extension/{1}'
                                 'ExtensionRegister.h>'
                                 ''.format(self.language,
                                           self.cap_language))
        self.write_line_verbatim('#include <{0}/extension/{1}'
                                 'ExtensionRegistry.h>'
                                 ''.format(self.language,
                                           self.cap_language))
        self.write_line_verbatim('#include <{0}/extension/{1}'
                                 'PluginCreator.h>'.format(self.language,
                                                           self.std_base))
        self.write_line_verbatim('#include <{0}/extension/{1}'
                                 'DocumentPlugin.h>'
                                 ''.format(self.language,
                                           self.cap_language))
        self.skip_line()
        self.write_line_verbatim('#include <{0}/packages/{1}/extension/{2}'
                                 'Extension.h>'.format(self.language,
                                                       self.package,
                                                       self.up_package))
        self.write_line_verbatim('#include <{0}/packages/{1}/extension/{2}'
                                 '{3}DocumentPlugin.h>'
                                 ''.format(self.language, self.package,
                                           self.up_package, self.cap_language))
        self.write_line_verbatim('#include <{0}/packages/{1}/validator/{2}'
                                 '{3}ErrorTable.h>'
                                 ''.format(self.language, self.package,
                                           self.up_package,
                                           self.cap_language))
        for i in range(0, len(self.plugins)):
            self.write_line_verbatim('#include <{0}/packages/{1}/extension/{2}'
                                     '{3}Plugin.h>'
                                     ''.format(self.language,
                                               self.package,
                                               self.up_package,
                                               self.plugins[i]['sbase']))

        self.skip_line(2)
        self.write_line('using namespace std;')
        self.skip_line()

    ########################################################################

    # function to write the constructors
    def write_constructors(self):
        constructor = Constructors.Constructors(self.language,
                                                self.is_java_api,
                                                self.class_object)
        code = constructor.write_constructor()
        self.write_function_implementation(code)

        code = constructor.write_copy_constructor()
        self.write_function_implementation(code)

        code = constructor.write_assignment_operator()
        self.write_function_implementation(code)

        code = constructor.write_clone()
        self.write_function_implementation(code)

        code = constructor.write_destructor()
        self.write_function_implementation(code)

    ########################################################################

    # function to write the static get functions
    def write_attribute_functions(self):
        self.class_object['class_attributes'] \
            = query.get_static_extension_attribs(self.num_versions)
        attrib_functions = SetGetFunctions.SetGetFunctions(self.language,
                                                           self.is_java_api,
                                                           self.is_list_of,
                                                           self.class_object)
        num_attributes = len(self.class_object['class_attributes'])
        for i in range(0, num_attributes):
            code = attrib_functions.write_static_extension_get(i, True, False)
            self.write_function_implementation(code)

    ########################################################################

    # Functions for writing virtual functions

    def write_virtual_functions(self):
        ext_functions = ExtensionFunctions.ExtensionFunctions(self.language,
                                                              self.package,
                                                              self.elements,
                                                              self.offset,
                                                              self.num_versions)

        code = ext_functions.write_get_name()
        self.write_function_implementation(code)

        code = ext_functions.write_get_uri()
        self.write_function_implementation(code)

        code = ext_functions.write_get_other('Level')
        self.write_function_implementation(code)

        code = ext_functions.write_get_other('Version')
        self.write_function_implementation(code)

        code = ext_functions.write_get_other('PackageVersion')
        self.write_function_implementation(code)

        code = ext_functions.write_get_namespaces()
        self.write_function_implementation(code)

        code = ext_functions.write_get_string_typecode()
        self.write_function_implementation(code)

        code = ext_functions.write_get_error_table()
        self.write_function_implementation(code, exclude=True)

        code = ext_functions.write_get_error_table_index()
        self.write_function_implementation(code, exclude=True)

        code = ext_functions.write_get_error_offset()
        self.write_function_implementation(code, exclude=True)

        if self.num_versions > 1:
            code = ext_functions.write_has_multiple_versions()
            self.write_function_implementation(code, True)

    ########################################################################

    # write the init function
    def write_init_function(self):
        init_functions = \
            ExtensionInitFunctions.ExtensionInitFunctions(self.language,
                                                          self.package,
                                                          self.std_base,
                                                          self.enums,
                                                          self.plugins)
        code = init_functions.write_init_function(False)
        self.write_function_implementation(code, True)

    ########################################################################

    # write the instantiation
    def write_extension_instance(self):
        # this is a bit different from the header file
        up_package = strFunctions.upper_first(self.package)
        self.open_comment()
        self.write_blank_comment_line()
        self.write_comment_line('Adds this {0}Extension to the {1}'
                                'ExtensionRegistry '
                                'class'.format(up_package, self.cap_language))
        self.write_blank_comment_line()
        self.close_comment()
        self.write_line('static {0}ExtensionRegister<{1}Extension> '
                        '{2}ExtensionRegistry;'.format(self.cap_language,
                                                       up_package,
                                                       self.package))
        self.skip_line()
        self.write_line('static')
        self.write_line('const char* {0}_{1}_TYPECODE_STRINGS[] ='
                        ''.format(self.cap_language, self.cap_package))
        self.write_line('{')
        self.up_indent()
        self.write_line('  \"{0}\"'.format(self.elements[0]['name']))
        for i in range(1, len(self.elements)):
            self.write_line('  , \"{0}\"'.format(self.elements[i]['name']))
        self.down_indent()
        self.write_line('};')
        self.skip_line(2)
        self.open_comment()
        self.write_blank_comment_line()
        self.write_comment_line('Instantiate {0}ExtensionNamespaces<{1}'
                                'Extension> for DLL'.format(self.cap_language,
                                                            up_package))
        self.write_blank_comment_line()
        self.close_comment()
        self.write_line('template class LIB{0}_EXTERN {0}ExtensionNamespaces<'
                        '{1}Extension>;'.format(self.cap_language,
                                                up_package))
        self.skip_line()

    ########################################################################

    # write the type defs

    def write_type_defs(self):
        # write the enum for typecodes
        # self.write_type_code_enum_header(self.package)
        # values = query.get_typecode_enum(self.elements)
        # name = '{}{}TypeCode_t'.format(self.cap_language, self.up_package)
        # self.write_enum(name, self.number, values[0], values[1], values[2]+5)
        # self.skip_line(2)
        #
        num_enums = len(self.enums)
        if num_enums == 0:
            return
        init_functions = \
            ExtensionInitFunctions.ExtensionInitFunctions(self.language,
                                                          self.package,
                                                          self.std_base,
                                                          self.enums,
                                                          [])
        self.is_java_api = False
        for i in range(0, len(self.enums)):
            name = query.get_typecode_format(self.enums[i]['name'],
                                             self.language) + '_STRINGS'
            values = query.get_enum(self.enums[i])
            self.write_enum_strings(name, values[1])
            self.skip_line(2)
            code = init_functions.write_enum_to_string_function(i,
                                                                values[0],
                                                                name)
            self.write_function_implementation(code)
            code = init_functions.write_enum_from_string_function(i, values[0],
                                                                  name)
            self.write_function_implementation(code)
            code = init_functions.write_is_valid_enum_function(i, values[0])
            self.write_function_implementation(code)
            code = init_functions.write_is_valid_enum_string_function(i)
            self.write_function_implementation(code)

    ########################################################################

        # Write file

    # TODO add variable whether extension or parser
    def write_package_include(self):
        if global_variables.is_package:
            curr_include_line = 'package org.sbml.{0}.ext.{1};'.format(self.language, self.package.lower())
            # print('curr_include_line is ', curr_include_line)
            self.write_line_verbatim(curr_include_line)

    def close_jsbml_class_header(self):
        self.down_indent()
        self.file_out.write('}\n')

    def write_jsbml_class_variables(self):
        self.up_indent()


        self.write_serial_version_comment()
        # TODO need to change serialVersionUID
        line = 'private static final long     serialVersionUID = {0}L;'.format(self.serialVersionUID)
        self.write_line(line)

        elements_attributes = self.original_package['baseElements']
        for attributes in elements_attributes:
            for attribute in attributes['attribs']:
                # print(attribute['memberName'])
                cap_att_name = attribute['capAttName']
                if str(cap_att_name) != 'Id' and str(cap_att_name) != 'Name':
                    self.write_variable_comment()
                    return_type = attribute['JClassType']
                    member_name = attribute['memberName']
                    line = 'public static final {0} {1};'.format(return_type, member_name)
                    self.write_line(line)
        self.down_indent()

        # TODO for writing imports

    def write_java_imports(self):
        # TODO mockup function
        # self.expand_import_modules()
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

    # Write file

    def write_file(self):
        BaseJavaFile.BaseJavaFile.write_file(self)
        # self.write_general_includes()
        # self.write_cppns_begin()
        # self.write_cpp_begin()
        self.write_class()
    #           self.write_extension_instance()
    #         self.write_cpp_end()
    #         self.write_type_defs()
    #         self.write_cppns_end()

    def write_constants_file(self):
        BaseJavaFile.BaseJavaFile.write_file(self)

        self.write_package_include()
        self.write_java_imports()
        #self.write_general_includes()

        BaseJavaFile.BaseJavaFile.write_jsbml_types_doc(self)
        self.write_jsbml_class_header()
        self.write_jsbml_constants()
        # self.write_class()
        self.close_jsbml_class_header()







    def write_jsbml_constants(self):
        self.up_indent()

        base_level = self.original_package['base_level']
        base_version = self.original_package['base_version']
        package_version = self.original_package['pkg_version']
        package_name = self.original_package['name']

        title_line = 'The namespace URI of this parser for SBML level {0}, version {1} \
        and package version {2}.'.format(base_level, base_version, package_version)
        self.write_brief_header(title_line)
        self.namespace_uri = 'namespaceURI_L{0}V{1}V{2}'.format(base_level, base_version, package_version)
        line = 'public static final String {0} = "http://www.sbml.org/sbml/level{1}/version{2}/{4}/version{3}"'.\
            format(self.namespace_uri, base_level, base_version, package_version, package_name)
        self.write_jsbml_line_verbatim(line)


        title_line = 'The latest namespace URI of this parser, this value can change between releases.'
        self.write_brief_header(title_line)
        line = 'public static final String namespaceURI = {0}'.format(self.namespace_uri)
        self.write_jsbml_line_verbatim(line)

        self.write_variable_comment()
        line = 'public static final String shortLabel = "{0}"'.format(package_name)
        # self.write_line(line)
        self.write_jsbml_line_verbatim(line)


        self.write_variable_comment()
        line = 'public static final List<String> namespaces'
        self.write_jsbml_line_verbatim(line)


        self.write_variable_comment()
        full_name = self.original_package['fullname']
        line = 'public static final String packageName = "{0}"'.format(full_name)
        # self.write_line(line)
        self.write_jsbml_line_verbatim(line)

        #Write static
        self.write_static(self.namespace_uri)


        # Attributes part
        self.write_serial_version_comment()
        # TODO need to change serialVersionUID
        line = 'private static final long     serialVersionUID = {0}L'.format(self.serialVersionUID)
        # self.write_line(line)
        self.write_jsbml_line_verbatim(line)


        attribs_to_write = []
        attribs_name_to_write = []
        base_elements = self.original_package['baseElements']
        for element in base_elements:
            attributes = element['attribs']
            for attribute in attributes:
                # print(attribute['memberName'])
                name = attribute['name']
                if str(name) != 'id' and str(name) != 'name':
                    if name not in attribs_name_to_write:
                        attribs_to_write.append(attribute)
                        attribs_name_to_write.append(name)

        for attribute in attribs_to_write:
            self.write_variable_comment()
            # return_type = attribute['JClassType']
            # member_name = attribute['memberName']
            name = attribute['name']
            write_name = strFunctions.lower_first(name)
            line = 'public static final String {0} = "{1}"'.format(write_name, name)
            # self.write_line(line)
            self.write_jsbml_line_verbatim(line)
            if attribute['type'] == 'lo_element':
                self.write_variable_comment()
                write_name = strFunctions.upper_first(name)
                line = 'public static final String listOf{0}s = "listOf{0}s"'.format(write_name)
                # self.write_line(line)
                self.write_jsbml_line_verbatim(line)

        self.down_indent()
        get_namespace_uri_func = self.get_namespace_uri()
        self.write_function_implementation(get_namespace_uri_func)
        self.up_indent()


        self.down_indent()
