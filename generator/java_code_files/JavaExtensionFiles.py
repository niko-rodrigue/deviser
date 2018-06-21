#!/usr/bin/env python
#
# @file    JavaExtensionFiles.py
# @brief   class for generating the plugin files
# @author  Hovakim Grabski GSOC 2016
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

from . import JavaExtensionCodeFile
# from . import JavaExtensionHeaderFile
from . import JavaCodeFile, JavaEnumFiles
# from . import JavaHeaderFile
from util import strFunctions, global_variables


class JavaExtensionFiles():
    """Class for all Extension files"""

    def __init__(self, package, filetype='', verbose=False):
        # # members from object
        self.package = package
        self.verbose = verbose
        self.file_type = filetype
        self.language = global_variables.javaLanguage

    def write_files(self):
        # self.write_header()
        if self.file_type == '':
            self.write_code()

    def write_plugin_files(self, num):
        class_descrip = self.create_class_description(num)
        # self.write_plugin_header(class_descrip)
        self.write_plugin_code(class_descrip)

        # What is the purpose of remove
        self.remove_class_description(num)

    def create_element_list_enum(self):
        up_package = strFunctions.upper_first(self.package['name'])
        name = up_package + 'List'
        list_info = dict({'name': name,
                          'values': self.package['elements']})
        return list_info

    # Write Java Enum
    def write_enums(self, num):
        if num >= len(self.package['enums']):
            # Write java list enums
            working_enum = self.create_element_list_enum()
            all_files = JavaEnumFiles.JavaEnumFiles(working_enum, self.package, True)
            all_files.write_list_enum_files()
        else:
            working_enum = self.package['enums'][num]
            all_files = JavaEnumFiles.JavaEnumFiles(working_enum, self.package, True)
            all_files.write_files()

    def write_parser_file(self):
        # class_descrip = self.create_class_description(num)
        class_descrip = self.package
        self.write_parser_code(class_descrip)

    # Write Parser code
    def write_parser_code(self, class_descrip):
        class_descrip['original_name'] = class_descrip['name']
        class_descrip['name'] = strFunctions.upper_first(class_descrip['name']) + 'Parser'
        class_descrip.update({'is_parser': True})
        class_descrip.update({'is_plugin': False})
        class_descrip.update({'is_constantFile': False})
        class_descrip.update({'is_classFile': False})
        fileout = JavaCodeFile.JavaCodeFile(class_descrip)
        if self.verbose:
            print('Writing file {0}'.format(fileout.filename))
        fileout.write_parser_file()
        fileout.close_file()

    # Write Plugin Code
    def write_plugin_code(self, class_descrip):
        class_descrip.update({'is_parser': False})
        class_descrip.update({'is_plugin': True})
        class_descrip.update({'is_constantFile': False})
        class_descrip.update({'is_classFile': False})
        fileout = JavaCodeFile.JavaCodeFile(class_descrip)
        if self.verbose:
            print('Writing file {0}'.format(fileout.filename))
            print('---' * 10)
        fileout.write_file()
        fileout.close_file()

    # Write Constants File
    def write_constants(self):
        custom_name = 'Constants'

        # Add extra information for differentiation of file types
        self.package['is_plugin'] = False
        self.package['is_parser'] = False
        self.package['is_constantFile'] = True
        self.package['is_classFile'] = False
        fileout = JavaExtensionCodeFile.JavaExtensionCodeFile(self.package, custom_name)
        if self.verbose:
            print('Writing file {0}'.format(fileout.filename))
            print('---' * 10)
        fileout.write_constants_file()
        fileout.close_file()

    def write_code(self):
        self.package['is_parser'] = False
        self.package['is_plugin'] = False
        self.package['is_constantFile'] = False
        self.package['is_classFile'] = True
        fileout = JavaExtensionCodeFile.JavaExtensionCodeFile(self.package)
        if self.verbose:
            print('Writing file {0}'.format(fileout.filename))
        fileout.write_file()
        fileout.close_file()

    # Create class description for JSBML plugin
    def create_class_description(self, num):
        if num >= len(self.package['plugins']):
            class_object = self.create_package_info_plugin_desc()
        else:
            class_object = self.package['plugins'][num]
            up_package = strFunctions.upper_first(self.package['name'])
            class_object['name'] = '{0}{1}Plugin'.format(up_package,
                                                         class_object['sbase'])
            class_object['is_plugin'] = True
            class_object['is_list_of'] = False
            class_object['hasListOf'] = False
            class_object['package'] = self.package['name']
            class_object['typecode'] = ''
            # class_object['baseClass'] = 'SBasePlugin'
            class_object['baseClass'] = 'AbstractSBasePlugin'
            class_object['sid_refs'] = []
            class_object['unit_sid_refs'] = []
            class_object['hasMath'] = False
            for i in range(0, len(class_object['extension'])):
                class_object['attribs'].append(self.get_attrib_descrip
                                               (class_object['extension'][i]))

            for elem in class_object['lo_extension']:
                class_object['attribs'].append(self.get_attrib_descrip(elem))

        return class_object

    def remove_class_description(self, num):
        if num >= len(self.package['plugins']):
            class_object = self.create_document_plugin_desc()
        else:
            class_object = self.package['plugins'][num]
            class_object['attribs'] = []

        return class_object

    def create_package_info_plugin_desc(self):
        up_package = strFunctions.upper_first(self.package['name'])
        up_language = self.language.upper()
        parser_info = dict({'attribs': [],
                            'extension': [],
                            'lo_extension': [],
                            'sbase': '{0}Document'.format(up_language),
                            'name': 'package-info',
                            'is_plugin': True,
                            'is_list_of': False,
                            'hasListOf': False,
                            'package': self.package['name'],
                            'typecode': '',
                            'baseClass': 'package-info',
                            'sid_refs': [],
                            'unit_sid_refs': [],
                            'hasMath': False,
                            'is_doc_plugin': False,
                            'is_package_info_plugin': True,
                            'reqd': self.package['required']})
        return parser_info

    # This is not used for java code generation
    def create_document_plugin_desc(self):
        up_package = strFunctions.upper_first(self.package['name'])
        up_language = self.language.upper()
        doc_plug = dict({'attribs': [],
                         'extension': [],
                         'lo_extension': [],
                         'sbase': '{0}Document'.format(up_language),
                         'name': '{0}{1}DocumentPlugin'.format(up_package,
                                                               up_language),
                         'is_plugin': True,
                         'is_list_of': False,
                         'hasListOf': False,
                         'package': self.package['name'],
                         'typecode': '',
                         'baseClass': '{0}DocumentPlugin'.format(up_language),
                         'sid_refs': [],
                         'unit_sid_refs': [],
                         'hasMath': False,
                         'is_doc_plugin': True,
                         'reqd': self.package['required']})
        return doc_plug

    @staticmethod
    def get_attrib_descrip(element):
        if element['isListOf']:
            attr_name = strFunctions.list_of_name(element['name'])
            attr_type = 'lo_element'
            attr_element = element['name']
        else:
            attr_name = element['name']
            attr_type = 'element'
            attr_element = element['name']
        attribute_dict = dict({'type': attr_type,
                               'reqd': False,
                               'name': attr_name,
                               'element': attr_element,
                               'abstract': False,
                               'num_versions': 1,
                               'version': 1,
                               'version_info': [True],
                               'parent': element,
                               'root': element['root']
                               })
        return attribute_dict
