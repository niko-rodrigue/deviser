#!/usr/bin/env python
#
# @file    Constructors.py
# @brief   class for constructors for c++ and c
# @author  GSOC 2016 Hovakim Grabski
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

from util import strFunctions, query, global_variables, jsbmlHelperFunctions


class Constructors():
    """Class for all constructors"""

    def __init__(self, language, is_java_api, class_object,
                 jsbml_data_tree=None, jsbml_methods=None, import_modules=None):
        self.language = language
        self.cap_language = language.upper()
        self.package = class_object['package']
        self.class_name = class_object['name']
        self.is_java_api = is_java_api
        if is_java_api:
            self.object_name = class_object['name']
        else:
            self.object_name = class_object['name'] # + '_t'

        self.concretes = class_object['concretes']
        self.base_class = class_object['baseClass']
        self.attributes = query.get_unique_attributes(class_object['attribs'])
        self.is_list_of = False
        if class_object['name'].startswith('ListOf'):
            self.is_list_of = True

        self.has_children = class_object['has_children']
        self.child_elements = class_object['child_elements']
        self.overwrites_children = class_object['overwrites_children']
        if 'elementName' in class_object and class_object['elementName'] != '':
            self.xml_name = \
                strFunctions.lower_first(class_object['elementName'])
        else:
            self.xml_name = strFunctions.lower_first(class_object['name'])
        self.is_plugin = False
        if 'is_plugin' in class_object:
            self.is_plugin = class_object['is_plugin']
        self.is_doc_plugin = False
        if 'is_doc_plugin' in class_object:
            self.is_doc_plugin = class_object['is_doc_plugin']
        self.document = False
        if 'document' in class_object:
            self.document = class_object['document']

        # TODO GSOC 2016
        if jsbml_data_tree is not None:
            self.jsbml_data_tree = jsbml_data_tree
        if jsbml_methods is not None:
            self.jsbml_methods = jsbml_methods
        if import_modules is not None:
            self.import_modules = import_modules

        self.copy_name = 'orig'
        self.equals_name = 'object'
        self.equals_short = 'obj'


        # TODO GSOC 2016 robot constructor
        # if self.is_java_api:
        #     self.expand_constructors()


        self.duplicate_methods = []
    ########################################################################


    # TODO still need to think is it required or not
    def expand_constructors(self):
        # print(self.jsbml_methods)
        # print(self.import_modules)

        for import_module in self.import_modules:
            data = self.jsbml_methods[import_module]
            for single_elem in data:
                func = single_elem['functionName'].split('.')[-1]
                if str(func)[:] == str(import_module)[:]:
                    print('import module ', import_module)
                    print(single_elem['functionName'])
                    print(single_elem['originalData'])
            # print(data)


    # Functions for writing constructors


    # function to simple  constructor
    def write_simple_constructor(self, index=0):
        if (len(self.concretes) == 0 and index == 0) or index == -1:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        title_line = ' '
        params = ''

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        arguments = []
        arguments_no_defaults = []
        constructor_args = []
        if global_variables.is_package:
            if self.is_java_api:
                implementation = ['super()','initDefaults()']
                #implementation.append('initDefaults()')
                # if self.has_children:
                #     implementation.append('connectToChild()')
            # else:
            #     if index == 0 or index == -1:
            #         name = self.class_name
            #     else:
            #         name = self.concretes[index - 1]['element']
            #     implementation = ['return new {0}(level, version, '
            #                       'pkgVersion)'.format(name)]
        else:
            if self.is_java_api:
                implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
                                  'level, '
                                  'version))'.format(global_variables.prefix)]
                if self.document:
                    implementation.append('setLevel(level)')
                    implementation.append('setVersion(version)')
                    implementation.append('set{0}Document(this)'.format(global_variables.prefix))
                if self.has_children:
                    implementation.append('connectToChild()')
            else:
                implementation = ['return new {0}(level, '
                                  'version)'.format(self.class_name)]

        code = [dict({'code_type': 'line', 'code': implementation})]

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
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})



    # function to write level version constructor
    def write_level_version_constructor(self, index=0):
        if (len(self.concretes) == 0 and index == 0) or index == -1:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        # title_line = 'Creates a new {0} using the given {1} Level' \
        #     .format(ob_name, self.cap_language)
        if global_variables.is_package:
            title_line = '@param level\n' #.format(strFunctions.lower_first(self.package))
        else:
            title_line = ' and @ p version values.'

        params = ['@param level',
                  '@param version']




        # if global_variables.is_package:
        #     params.append('@param pkgVersion an unsigned int, the {0} {1} '
        #                   'Version to assign to this {2}.'
        #                   .format(self.cap_language, self.package,
        #                           self.object_name))

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        if global_variables.is_package:
            arguments = [
                'int level = '
                '{0}Extension::getDefaultLevel()'.format(self.package),
                'nt version = '
                '{0}Extension::getDefaultVersion()'.format(self.package),
                'int pkgVersion = '
                '{0}Extension::getDefaultPackageVersion()'.format(self.package)]
            arguments_no_defaults = ['int level',
                                     'int version']
        else:
            if self.is_java_api:
                arguments = ['int level = {0}_DEFAULT_'
                             'LEVEL'.format(global_variables.language.upper()),
                             'int version = {0}_DEFAULT_VERSI'
                             'ON'.format(global_variables.language.upper())]
                arguments_no_defaults = ['int level',
                                         'unsigned int version']
            else:
                arguments = ['int level', 'int version']
                arguments_no_defaults = ['int level',
                                         'int version']

        # create the function implementation
        constructor_args = [] #self.write_constructor_args(None)

        if global_variables.is_package:
            if self.is_java_api:
                implementation = ['this(null, null, level, version)']

                import_module = self.import_modules[0]
                if 'id' in self.jsbml_data_tree[import_module]['ignore']:
                    try:
                        implementation = ['super(level, version)']
                        implementation.append('initDefaults()')
                    except:
                        return

                # implementation = ['set{0}NamespacesAndOwn(new {1}PkgNamespaces'
                #                   '(level, version, '
                #                   'pkgVersion))'.format(global_variables.prefix,
                #                                         self.package)]
                # if self.has_children:
                #     implementation.append('connectToChild()')
            # else:
            #     if index == 0 or index == -1:
            #         name = self.class_name
            #     else:
            #         name = self.concretes[index-1]['element']
            #     implementation = ['return new {0}(level, version, '
            #                       'pkgVersion)'.format(name)]
        else:
            if self.is_java_api:
                implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
                                  'level, '
                                  'version))'.format(global_variables.prefix)]
                # if self.document:
                #     implementation.append('setLevel(level)')
                #     implementation.append('setVersion(version)')
                #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
                # if self.has_children:
                #     implementation.append('connectToChild()')
            else:
                implementation = ['return new {0}(level, '
                                  'version)'.format(self.class_name)]

        code = [dict({'code_type': 'line', 'code': implementation})]

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
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})

    # function to write id constructor
    def write_id_constructor(self, index=0):
        if (len(self.concretes) == 0 and index == 0) or index == -1:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        # title_line = 'Creates a new {0} using the given {1} Level' \
        #     .format(ob_name, self.cap_language)
        if global_variables.is_package:
            title_line = '@param level\n'  # .format(strFunctions.lower_first(self.package))
        else:
            title_line = ' and @ p version values.'

        #Stop generating this constructor
        import_module = self.import_modules[0]
        if 'id' in self.jsbml_data_tree[import_module]['ignore']:
            return

        params = ['@param id']

        # if global_variables.is_package:
        #     params.append('@param pkgVersion an unsigned int, the {0} {1} '
        #                   'Version to assign to this {2}.'
        #                   .format(self.cap_language, self.package,
        #                           self.object_name))

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        if global_variables.is_package:
            arguments = [
                'int level = '
                '{0}Extension::getDefaultLevel()'.format(self.package),
                'nt version = '
                '{0}Extension::getDefaultVersion()'.format(self.package),
                'int pkgVersion = '
                '{0}Extension::getDefaultPackageVersion()'.format(self.package)]
            arguments_no_defaults = ['String id']
        else:
            if self.is_java_api:
                arguments = ['int level = {0}_DEFAULT_'
                             'LEVEL'.format(global_variables.language.upper()),
                             'int version = {0}_DEFAULT_VERSI'
                             'ON'.format(global_variables.language.upper())]
                arguments_no_defaults = ['int level',
                                         'unsigned int version']
            else:
                arguments = ['String id']
                arguments_no_defaults = ['String id']

        # create the function implementation
        constructor_args = []  # self.write_constructor_args(None)

        if global_variables.is_package:
            if self.is_java_api:
                implementation = ['super(id)', 'initDefaults()']

                # implementation = ['set{0}NamespacesAndOwn(new {1}PkgNamespaces'
                #                   '(level, version, '
                #                   'pkgVersion))'.format(global_variables.prefix,
                #                                         self.package)]
                # if self.has_children:
                #     implementation.append('connectToChild()')
                # else:
                #     if index == 0 or index == -1:
                #         name = self.class_name
                #     else:
                #         name = self.concretes[index-1]['element']
                #     implementation = ['return new {0}(level, version, '
                #                       'pkgVersion)'.format(name)]
        else:
            if self.is_java_api:
                implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
                                  'level, '
                                  'version))'.format(global_variables.prefix)]
                # if self.document:
                #     implementation.append('setLevel(level)')
                #     implementation.append('setVersion(version)')
                #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
                # if self.has_children:
                #     implementation.append('connectToChild()')
            else:
                implementation = ['return new {0}(level, '
                                  'version)'.format(self.class_name)]

        code = [dict({'code_type': 'line', 'code': implementation})]

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
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})

    # function to write id level  version constructor
    def write_id_level_version_constructor(self, index=0):
        if (len(self.concretes) == 0 and index == 0) or index == -1:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        # title_line = 'Creates a new {0} using the given {1} Level' \
        #     .format(ob_name, self.cap_language)
        if global_variables.is_package:
            title_line = '@param level\n' #.format(strFunctions.lower_first(self.package))
        else:
            title_line = ' and @ p version values.'

        params = ['@param id',
                  '@param level',
                  '@param version']


        # if global_variables.is_package:
        #     params.append('@param pkgVersion an unsigned int, the {0} {1} '
        #                   'Version to assign to this {2}.'
        #                   .format(self.cap_language, self.package,
        #                           self.object_name))

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        if global_variables.is_package:
            arguments = [
                'int level = '
                '{0}Extension::getDefaultLevel()'.format(self.package),
                'nt version = '
                '{0}Extension::getDefaultVersion()'.format(self.package),
                'int pkgVersion = '
                '{0}Extension::getDefaultPackageVersion()'.format(self.package)]
            arguments_no_defaults = ['String id', 'int level',
                                     'int version']
        else:
            if self.is_java_api:
                arguments = ['int level = {0}_DEFAULT_'
                             'LEVEL'.format(global_variables.language.upper()),
                             'int version = {0}_DEFAULT_VERSI'
                             'ON'.format(global_variables.language.upper())]
                arguments_no_defaults = ['int level',
                                         'unsigned int version']
            else:
                arguments = ['String id', 'int level', 'int version']
                arguments_no_defaults = ['String id','int level',
                                         'int version']

        # Stop generating this constructor




        # create the function implementation
        constructor_args = [] #self.write_constructor_args(None)

        if global_variables.is_package:
            if self.is_java_api:
                implementation = ['this(id, null, level, version)']

                import_module = self.import_modules[0]
                if 'id' in self.jsbml_data_tree[import_module]['ignore']:
                    try:
                        if len(self.jsbml_data_tree[import_module]['include']) > 0:
                            type_obj = self.jsbml_data_tree[import_module]['include'][0]
                            arguments = ['{0} math'.format(type_obj), 'int level', 'int version']
                            arguments_no_defaults = ['{0} math'.format(type_obj), 'int level', 'int version']
                            implementation = ['super(math, level, version)']
                            implementation.append('initDefaults()')
                    except:
                        return


                # implementation = ['set{0}NamespacesAndOwn(new {1}PkgNamespaces'
                #                   '(level, version, '
                #                   'pkgVersion))'.format(global_variables.prefix,
                #                                         self.package)]
                # if self.has_children:
                #     implementation.append('connectToChild()')
            # else:
            #     if index == 0 or index == -1:
            #         name = self.class_name
            #     else:
            #         name = self.concretes[index-1]['element']
            #     implementation = ['return new {0}(level, version, '
            #                       'pkgVersion)'.format(name)]
        else:
            if self.is_java_api:
                implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
                                  'level, '
                                  'version))'.format(global_variables.prefix)]
                # if self.document:
                #     implementation.append('setLevel(level)')
                #     implementation.append('setVersion(version)')
                #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
                # if self.has_children:
                #     implementation.append('connectToChild()')
            else:
                implementation = ['return new {0}(level, '
                                  'version)'.format(self.class_name)]

        code = [dict({'code_type': 'line', 'code': implementation})]

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
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})

    def write_id_name_level_version_constructor(self, index=0):
        if (len(self.concretes) == 0 and index == 0) or index == -1:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        # title_line = 'Creates a new {0} using the given {1} Level' \
        #     .format(ob_name, self.cap_language)
        if global_variables.is_package:
            title_line = '@param level\n'  # .format(strFunctions.lower_first(self.package))
        else:
            title_line = ' and @ p version values.'

        params = ['@param id',
                  '@param name',
                  '@param level',
                  '@param version']

        #Stop generating this constructor
        import_module = self.import_modules[0]
        if 'id' in self.jsbml_data_tree[import_module]['ignore'] or \
                        'name' in self.jsbml_data_tree[import_module]['ignore']:
            return

        # if global_variables.is_package:
        #     params.append('@param pkgVersion an unsigned int, the {0} {1} '
        #                   'Version to assign to this {2}.'
        #                   .format(self.cap_language, self.package,
        #                           self.object_name))

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        if global_variables.is_package:
            arguments = [
                'int level = '
                '{0}Extension::getDefaultLevel()'.format(self.package),
                'nt version = '
                '{0}Extension::getDefaultVersion()'.format(self.package),
                'int pkgVersion = '
                '{0}Extension::getDefaultPackageVersion()'.format(self.package)]
            arguments_no_defaults = ['String id', 'String name', 'int level',
                                     'int version']
        else:
            if self.is_java_api:
                arguments = ['int level = {0}_DEFAULT_'
                             'LEVEL'.format(global_variables.language.upper()),
                             'int version = {0}_DEFAULT_VERSI'
                             'ON'.format(global_variables.language.upper())]
                arguments_no_defaults = ['int level',
                                         'unsigned int version']
            else:
                arguments = ['String id', 'int level', 'int version']
                arguments_no_defaults = ['String id', 'String name', 'int level',
                                         'int version']

        # create the function implementation
        constructor_args = []  # self.write_constructor_args(None)

        if global_variables.is_package:
            if self.is_java_api:
                implementation = ['super(id, name, level, version)']
                # TODO spacing wrong
                # if curr_att_type in global_variables.javaTypeAttributes:
                implement_part2 = 'throw new LevelVersionError(getElementName(), level, version)'
                # else:
                #     implement_part2 = 'return {0}'.format(attribute['memberName'])
                implementation2 = ['getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0',
                                   implement_part2]
                # implementation = ['throw new PropertyUndefinedError({0}Constants.{1}, this)'.format(self.package,
                #                                                                                     attribute[
                #                                                                                         'memberName'])]
                # code = [dict({'code_type': 'if', 'code': implementation2}),
                #         dict({'code_type': 'line', 'code': implementation})]


                implementation3 = ['initDefaults()']

                # implementation = ['set{0}NamespacesAndOwn(new {1}PkgNamespaces'
                #                   '(level, version, '
                #                   'pkgVersion))'.format(global_variables.prefix,
                #                                         self.package)]
                # if self.has_children:
                #     implementation.append('connectToChild()')
                # else:
                #     if index == 0 or index == -1:
                #         name = self.class_name
                #     else:
                #         name = self.concretes[index-1]['element']
                #     implementation = ['return new {0}(level, version, '
                #                       'pkgVersion)'.format(name)]
        else:
            if self.is_java_api:
                implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
                                  'level, '
                                  'version))'.format(global_variables.prefix)]
                # if self.document:
                #     implementation.append('setLevel(level)')
                #     implementation.append('setVersion(version)')
                #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
                # if self.has_children:
                #     implementation.append('connectToChild()')
            else:
                implementation = ['return new {0}(level, '
                                  'version)'.format(self.class_name)]

        # code = [dict({'code_type': 'line', 'code': implementation})]

        code = [dict({'code_type': 'line', 'code': implementation}),
                dict({'code_type': 'if', 'code': implementation2}),
                dict({'code_type': 'line', 'code': implementation3})]

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
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})

    def write_init_defaults_constructor(self, index=0):
        if (len(self.concretes) == 0 and index == 0) or index == -1:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        # title_line = 'Creates a new {0} using the given {1} Level' \
        #     .format(ob_name, self.cap_language)
        if global_variables.is_package:
            title_line = '@param level\n'  # .format(strFunctions.lower_first(self.package))
        else:
            title_line = ' and @ p version values.'

        params = [' ']

        # if global_variables.is_package:
        #     params.append('@param pkgVersion an unsigned int, the {0} {1} '
        #                   'Version to assign to this {2}.'
        #                   .format(self.cap_language, self.package,
        #                           self.object_name))

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = 'void initDefaults'#self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        if global_variables.is_package:
            arguments = [
                'int level = '
                '{0}Extension::getDefaultLevel()'.format(self.package),
                'nt version = '
                '{0}Extension::getDefaultVersion()'.format(self.package),
                'int pkgVersion = '
                '{0}Extension::getDefaultPackageVersion()'.format(self.package)]
            arguments_no_defaults = ['']
        else:
            if self.is_java_api:
                arguments = ['int level = {0}_DEFAULT_'
                             'LEVEL'.format(global_variables.language.upper()),
                             'int version = {0}_DEFAULT_VERSI'
                             'ON'.format(global_variables.language.upper())]
                arguments_no_defaults = ['int level',
                                         'unsigned int version']
            else:
                arguments = ['String id', 'int level', 'int version']
                arguments_no_defaults = ['']

        # create the function implementation
        constructor_args = []  # self.write_constructor_args(None)

        if global_variables.is_package:
            if self.is_java_api:
                implementation = []
                # TODO JSBML template start Error for qualitativeSpecies
                # implementation.append('addNamespace({0}Constants.namespaceURI)'.format(self.package))
                # JSBML template end


                implementation.append('setPackageVersion(-1)')
                # # TODO spacing wrong
                implementation.append('packageName = {0}Constants.shortLabel'.format(self.package))

                attributes = self.attributes
                for attribute in attributes:
                    # print(attribute['memberName'])
                    cap_att_name = attribute['capAttName']
                    if str(cap_att_name) != 'Id' and str(cap_att_name) != 'Name':
                        member_name = attribute['name']
                        # # TODO changed to as jsbml example
                        reqd = str(attribute['reqd'])[:]
                        # if reqd == 'True':
                        attType = attribute['attType']
                        if attType == 'lo_element':
                            line = '{0} = null'.format(attribute['jsbmlName'])
                        # TODO math element
                        elif attType == 'element':
                            break
                        else:
                            line = '{0} = null'.format(member_name)
                        # reqd = str(attribute['reqd'])[:]
                        # if reqd == 'True':
                        #     line = '{0} = null'.format(member_name)
                        implementation.append(line)


                # implementation = ['throw new PropertyUndefinedError({0}Constants.{1}, this)'.format(self.package,
                #                                                                                     attribute[
                #                                                                                         'memberName'])]
                # code = [dict({'code_type': 'if', 'code': implementation2}),
                #         dict({'code_type': 'line', 'code': implementation})]


                implementation3 = ['initDefaults()']

                # implementation = ['set{0}NamespacesAndOwn(new {1}PkgNamespaces'
                #                   '(level, version, '
                #                   'pkgVersion))'.format(global_variables.prefix,
                #                                         self.package)]
                # if self.has_children:
                #     implementation.append('connectToChild()')
                # else:
                #     if index == 0 or index == -1:
                #         name = self.class_name
                #     else:
                #         name = self.concretes[index-1]['element']
                #     implementation = ['return new {0}(level, version, '
                #                       'pkgVersion)'.format(name)]
        else:
            if self.is_java_api:
                implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
                                  'level, '
                                  'version))'.format(global_variables.prefix)]
                # if self.document:
                #     implementation.append('setLevel(level)')
                #     implementation.append('setVersion(version)')
                #     implementation.append('set{0}Document(this)'.format(global_variables.prefix))
                # if self.has_children:
                #     implementation.append('connectToChild()')
            else:
                implementation = ['return new {0}(level, '
                                  'version)'.format(self.class_name)]

        code = [dict({'code_type': 'line', 'code': implementation})]

        # code = [dict({'code_type': 'line', 'code': implementation}),
        #         dict({'code_type': 'if', 'code': implementation2}),
        #         dict({'code_type': 'line', 'code': implementation3})]

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
                     'args_no_defaults': arguments_no_defaults,
                     'constructor_args': constructor_args})


    # TODO BACKUP
    #     # function to write level version constructor
    #
    # def write_level_version_constructor(self, index=0):
    #     if (len(self.concretes) == 0 and index == 0) or index == -1:
    #         ob_name = self.object_name
    #         create = 'create'
    #     elif self.is_java_api:
    #         ob_name = self.object_name
    #         create = 'create'
    #     else:
    #         if index == 0:
    #             return
    #         else:
    #             i = index - 1
    #         ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
    #                                      self.object_name)
    #         create = 'create{0}'.format(self.concretes[i]['element'])
    #     # create doc string header
    #     # title_line = 'Creates a new {0} using the given {1} Level' \
    #     #     .format(ob_name, self.cap_language)
    #     if global_variables.is_package:
    #         title_line = '@param level\n @param version'  # .format(strFunctions.lower_first(self.package))
    #     else:
    #         title_line = ' and @ p version values.'
    #
    #     params = ['@param level an unsigned int, the {0} Level to '
    #               'assign to this {1}.'.format(self.cap_language,
    #                                            self.object_name),
    #               '@param version an unsigned int, the {0} Version to '
    #               'assign to this {1}.'.format(self.cap_language,
    #                                            self.object_name)]
    #     if global_variables.is_package:
    #         params.append('@param pkgVersion an unsigned int, the {0} {1} '
    #                       'Version to assign to this {2}.'
    #                       .format(self.cap_language, self.package,
    #                               self.object_name))
    #
    #     return_lines = ['@throws {0}Constructor'
    #                     'Exception'.format(self.cap_language),
    #                     'Thrown if the given @p level and @p version '
    #                     'combination, or this kind of {0} object, are either '
    #                     'invalid or mismatched with respect to the parent '
    #                     '{1} object.'.format(self.cap_language,
    #                                          global_variables.document_class),
    #                     '@copydetails doc_note_setting_lv']
    #     additional = ''
    #
    #     # create the function declaration
    #     if self.is_java_api:
    #         function = self.class_name
    #         return_type = ''
    #     else:
    #         function = '{0}_{1}'.format(self.class_name, create)
    #         return_type = '{0} *'.format(self.object_name)
    #
    #     if global_variables.is_package:
    #         arguments = [
    #             'int level = '
    #             '{0}Extension::getDefaultLevel()'.format(self.package),
    #             'nt version = '
    #             '{0}Extension::getDefaultVersion()'.format(self.package),
    #             'int pkgVersion = '
    #             '{0}Extension::getDefaultPackageVersion()'.format(self.package)]
    #         arguments_no_defaults = ['int level',
    #                                  'int version',
    #                                  'int pkgVersion']
    #     else:
    #         if self.is_java_api:
    #             arguments = ['int level = {0}_DEFAULT_'
    #                          'LEVEL'.format(global_variables.language.upper()),
    #                          'int version = {0}_DEFAULT_VERSI'
    #                          'ON'.format(global_variables.language.upper())]
    #             arguments_no_defaults = ['int level',
    #                                      'unsigned int version']
    #         else:
    #             arguments = ['int level', 'int version']
    #             arguments_no_defaults = ['int level',
    #                                      'int version']
    #
    #     # create the function implementation
    #     constructor_args = self.write_constructor_args(None)
    #     if global_variables.is_package:
    #         if self.is_java_api:
    #             implementation = ['set{0}NamespacesAndOwn(new {1}PkgNamespaces'
    #                               '(level, version, '
    #                               'pkgVersion))'.format(global_variables.prefix,
    #                                                     self.package)]
    #             if self.has_children:
    #                 implementation.append('connectToChild()')
    #         else:
    #             if index == 0 or index == -1:
    #                 name = self.class_name
    #             else:
    #                 name = self.concretes[index - 1]['element']
    #             implementation = ['return new {0}(level, version, '
    #                               'pkgVersion)'.format(name)]
    #     else:
    #         if self.is_java_api:
    #             implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces('
    #                               'level, '
    #                               'version))'.format(global_variables.prefix)]
    #             if self.document:
    #                 implementation.append('setLevel(level)')
    #                 implementation.append('setVersion(version)')
    #                 implementation.append('set{0}Document(this)'.format(global_variables.prefix))
    #             if self.has_children:
    #                 implementation.append('connectToChild()')
    #         else:
    #             implementation = ['return new {0}(level, '
    #                               'version)'.format(self.class_name)]
    #
    #     code = [dict({'code_type': 'line', 'code': implementation})]
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
    #                  'implementation': code,
    #                  'args_no_defaults': arguments_no_defaults,
    #                  'constructor_args': constructor_args})

    # function to write namespace constructor
    def write_namespace_constructor(self, index=0):
        if len(self.concretes) == 0 and index == 0:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                         self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        title_line = 'Creates a new {0} using the given'\
            .format(ob_name)
        if global_variables.is_package:
            title_line = title_line + ' {0}PkgNamespaces object.' \
                .format(self.package)
        else:
            title_line = title_line + ' {0}Namespaces object @p {1}ns.' \
                .format(global_variables.prefix, self.language)

        params = []
        if global_variables.is_package:
            params.append('@param {0}ns the {1}PkgNamespaces object.'
                          .format(self.package.lower(), self.package))
        else:
            params.append('@param {0}ns the {1}Namespaces object.'
                          .format(self.language, global_variables.prefix))

        return_lines = ['@throws {0}Constructor'
                        'Exception'.format(self.cap_language),
                        'Thrown if the given @p level and @p version '
                        'combination, or this kind of {0} object, are either '
                        'invalid or mismatched with respect to the parent '
                        '{1} object.'.format(self.cap_language,
                                             global_variables.document_class),
                        '@copydetails doc_note_setting_lv']
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}WithNS'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        arguments = []

        if global_variables.is_package:
            if self.is_java_api:
                arguments.append('{0}PkgNamespaces *{1}ns'
                                 .format(self.package, self.package.lower()))
            else:
                arguments.append('{0}PkgNamespaces_t *{1}ns'
                                 .format(self.package, self.package.lower()))
            ns = '{0}ns'.format(self.package.lower())
        else:
            if self.is_java_api:
                arguments.append('{0}Namespaces *{1}ns'
                                 .format(global_variables.prefix,
                                         self.language))
            else:
                arguments.append('{0}Namespaces_t *{1}ns'
                                 .format(global_variables.prefix,
                                         self.language))
            ns = '{0}ns'.format(self.language)

        # create the function implementation
        constructor_args = self.write_constructor_args(ns)
#        if global_variables.is_package:
        implementation = ['setElementNamespace({0}'
                          '->getURI())'.format(ns)]
        if self.document:
            implementation.append('setLevel({0}->getLevel())'.format(ns))
            implementation.append('setVersion({0}->getVersion())'.format(ns))
            implementation.append('set{0}Document(this)'.format(global_variables.prefix))

        if self.has_children:
            implementation.append('connectToChild()')
        if global_variables.is_package and not self.is_list_of:
            implementation.append('loadPlugins({0}ns)'
                                  .format(self.package.lower()))
        # else:
        #     implementation = ['set{0}NamespacesAndOwn(new {0}Namespaces'
        #                       '(level, '
        #                       'version))'.format(global_variables.prefix)]
        code = [dict({'code_type': 'line', 'code': implementation})]

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

    # function to write general constructor
    def write_constructor(self, index=0):
        if len(self.concretes) == 0 and index == 0:
            ob_name = self.object_name
            create = 'create'
        elif self.is_java_api:
            ob_name = self.object_name
            create = 'create'
        else:
            if index == 0:
                return
            else:
                i = index - 1
            ob_name = '{0} ({1})'.format(self.concretes[i]['element'],
                                       self.object_name)
            create = 'create{0}'.format(self.concretes[i]['element'])
        # create doc string header
        title_line = 'Creates a new {0} instance.'.format(ob_name)
        params = []

        return_lines = []
        additional = ''

        # create the function declaration
        if self.is_java_api:
            function = self.class_name
            return_type = ''
        else:
            function = '{0}_{1}'.format(self.class_name, create)
            return_type = '{0} *'.format(self.object_name)

        arguments = []

        # create the function implementation
        code = [dict({'code_type': 'blank', 'code': []})]

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
                     'implementation': code})

    # function to write uri constructor for plugins
    def write_uri_constructor(self):
        ob_name = self.object_name
        package = self.package.lower()
        up_package = strFunctions.upper_first(self.package)
        # create doc string header
        title_line = 'Creates a new {0} using the given uri, prefix and ' \
                     'package namespace.'.format(ob_name)
        params = ['@param uri a string, representing the uri of the package.',
                  '@param prefix a string, the prefix to be used.',
                  '@param {0}ns a pointer to the {1}PkgNamespaces object to '
                  'be used.'.format(package, up_package)]

        return_lines = []
        additional = ''

        # create the function declaration
        function = self.class_name
        return_type = ''

        arguments = ['const std::string& uri', 'const std::string& prefix',
                     '{0}PkgNamespaces* '
                     '{1}ns'.format(up_package, package)]

        ns = '{0}ns'.format(package)
        constructor_args = self.write_constructor_args(ns)
        # create the function implementation
        if self.is_doc_plugin or not self.has_children:
            code = []
        else:
            code = [dict({'code_type': 'line', 'code': ['connectToChild()']})]

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

    ##############################################################################################
    #TODO GSOC 2016

    # function to write copy constructor
    def write_copy_constructor(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        title_line = 'Copy constructor for {0}.'.format(self.object_name)
        params = ['@param {0} the {1} instance to copy.'.format(self.copy_name,
            self.object_name)]
        return_lines = []
        additional = []
        # create function decl
        function = '{0}'.format(self.object_name)
        return_type = ''
        arguments = ['{0} {1}'.format(self.object_name, self.copy_name)]
        # create the function implementation

        constructor_args = [] #arguments #self.write_copy_constructor_args(self)
        code = []
        clone = 'clone'

        implementation = ['super({0})'.format(self.copy_name)]
        line = self.create_code_block('line', implementation)
        code.append(line)


        for i in range(0, len(self.attributes)):
            attribute = self.attributes[i]
            if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                continue
            else:
                temp_code = self.create_copy_if(i)
                code.append(temp_code)


        # TODO temporary fix
        line = self.create_code_block('line', '')
        code.append(line)

        # implementation = ['']
        # line = self.create_code_block('line', implementation)
        # code.append(line)

        # for i in range(0, len(self.attributes)):
        #     if self.attributes[i]['isArray']:
        #         line = self.write_set_array(i)
        #         code.append(self.create_code_block('line', line))
        # for i in range(0, len(self.child_elements)):
        #     element = self.child_elements[i]
        #     member = element['memberName']
        #     if element['element'] == 'ASTNode':
        #         clone = 'deepCopy'
        #     implementation = ['orig.{0} != NULL'.format(member),
        #                       '{0} = orig.{0}->{1}()'.format(member,
        #                                                      clone)]
        #     code.append(self.create_code_block('if', implementation))
        # if self.document:
        #     implementation = ['set{0}Document(this)'.format(global_variables.prefix)]
        #     code.append(dict({'code_type': 'line', 'code': implementation}))
        # if self.has_children:
        #     implementation = ['connectToChild()']
        #     code.append(dict({'code_type': 'line', 'code': implementation}))
        # else:
        #     implementation = ['']
        #     code.append(dict({'code_type': 'blank', 'code': implementation}))

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

    def create_copy_if(self, index):
        attribute = self.attributes[index]
        name = attribute['capAttName']
        member_name = attribute['name']

        att_type = attribute['attType']

        if att_type == 'lo_element':
            implementation = ['{0}.isSet{1}()'.format(self.copy_name, attribute['attTypeCode'] ),
                              'set{0}({1}.get{2}().clone())'.format(attribute['attTypeCode'],
                                                            self.copy_name, attribute['attTypeCode'])]
        else:
            implementation = ['{0}.isSet{1}()'.format(self.copy_name, name),
                          'set{0}({1}.get{2}())'.format(name, self.copy_name, name)]  # 3rd line

        temp_code = self.create_code_block('if', implementation)
        return temp_code

    def create_equals_if(self, index):
        attribute = self.attributes[index]
        name = attribute['capAttName']
        member_name = attribute['name']

        att_type = attribute['attType']

        # TODO GSOC 2016 changes
        if att_type == 'lo_element':
            to_write = attribute['attTypeCode']
            implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, to_write, to_write)

            implement2 = ['equals && isSet{0}()'.format(to_write),
                          'equals &= {0}.get{1}().equals(get{2}())'.format(self.equals_short, to_write, to_write)]
        else:
            to_write = name

            implement1 = 'equals &= {0}.isSet{1}() == isSet{2}()'.format(self.equals_short, to_write, to_write)

            implement2 = ['equals && isSet{0}()'.format(to_write),
                              'equals &= ({0}.get{1}() == get{2}())'.format(self.equals_short, to_write, to_write)]  # 3rd line

        # temp_code1 = self.create_code_block('line', implement1)
        temp_code2 = self.create_code_block('if', implement2)
        return [implement1, temp_code2]



    # function to write assignment equals method
    def write_equals(self):
        # do not write for C API
        if self.is_java_api is False:
            return
        # create doc string header
        title_line = '(non-Javadoc)--@see java.lang.Object#equals(java.lang.Object)'.format(self.object_name)
        params = ['@param rhs the {0} object whose values are to be used '
                  'as the basis of the assignment.'.format(self.object_name)]
        return_lines = []
        additional = []
        additional.append('Override')
        function = 'equals'.format(self.object_name)
        return_type = 'boolean'.format(self.object_name)
        arguments = ['{0} {1}'.format(strFunctions.upper_first(self.equals_name), self.equals_name)]
        # create the function implementation
        args = ['&rhs != this'] + self.write_assignment_args(self)
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

        implementation = ['boolean equals = super.equals({0})'.format(self.equals_name)]
        line = self.create_code_block('line', implementation)
        code.append(line)

        implementation = ['equals']



        implement_inside = ['{0} {1} = ({2}) {3}'.format(self.class_name,
                                                       self.equals_short,
                                                       self.class_name,
                                                       self.equals_name)]
        line = self.create_code_block('line', implement_inside)
        implementation.append(line)

        for i in range(0, len(self.attributes)):
            attribute = self.attributes[i]
            if attribute['capAttName'] == 'Id' or attribute['capAttName'] == 'Name':
                continue
            else:
                temp_code = self.create_equals_if(i)
                # code.append(temp_code[-1])
                for y_code in temp_code:
                    implementation.append(y_code)

        # TODO  temporary fix

        line = self.create_code_block('line', '')
        implementation.append(line)

        code.append(self.create_code_block('if', implementation))

        equals_return = ['return equals']
        # implementation.append('')

        code.append(self.create_code_block('line', equals_return))


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
                     'implementation': code})

    # function to write clone
    def write_clone(self):
        abbrev_object = strFunctions.abbrev_name(self.class_name)
        # create doc string header
        title_line = '(non-Javadoc)'
        params = []
        if not self.is_java_api:
            params.append('@param {0} the {1} structure.'
                          .format(abbrev_object, self.object_name))
        return_lines = ['@return a (deep) copy of this {0} object.'.format(
            self.object_name)]
        additional = []
        if self.is_java_api:
            function = 'clone'
            # additional.append('Override')
        else:
            function = '{0}_clone'.format(self.class_name)
        return_type = '{0}'.format(self.object_name)
        arguments = []


        # TODO part  not clear
        additional_add, class_key, function_args = jsbmlHelperFunctions.determine_override_or_deprecated(
            self.jsbml_methods,
            function=function,
            return_type=return_type)

        if additional_add is not None:
            additional.append(additional_add)
            title_line = jsbmlHelperFunctions.get_javadoc_comments_and_state(additional_add, class_key,
                                                                             function, function_args)


        if not self.is_java_api:
            arguments.append('const {0}* {1}'.format(self.object_name,
                                                   abbrev_object))
        # create the function implementation
        if self.is_java_api:
            implementation = ['return new {0}(this)'.format(self.object_name)]
            code_type = 'line'
        else:
            implementation = ['{0} != NULL'.format(abbrev_object),
                              'return static_cast<{0}*>({1}->'
                              'clone())'.format(self.object_name,
                                                abbrev_object),
                              'else', 'return NULL']
            code_type = 'if_else'
        code = [self.create_code_block(code_type, implementation)]

        return dict({'title_line': title_line,
                     'params': params,
                     'return_lines': return_lines,
                     'additional': additional,
                     'function': function,
                     'return_type': return_type,
                     'arguments': arguments,
                     'constant': True,
                     'virtual': True,
                     'object_name': self.object_name,
                     'implementation': code})

    ########################################################################

    # HELPER FUNCTIONS

    def write_constructor_args(self, ns):
        if ns is None:
            constructor_args = [': {0}(level, version)'.format(self.base_class)]
            if global_variables.is_package:
                parameters = 'level, version, pkgVersion'
            else:
                parameters = 'level, version'
        elif ns is not None and self.is_plugin:
            constructor_args = [': {0}(uri, prefix, '
                                '{1})'.format(self.base_class, ns)]
            parameters = '{0}'.format(ns)
        else:
            if global_variables.is_package:
                constructor_args = [': {0}({1})'.format(self.base_class, ns)]
                parameters = '{0}ns'.format(self.package.lower())
            else:
                constructor_args = [': {0}({1})'.format(self.base_class, ns)]
                parameters = '{0}'.format(ns)
        if not self.base_class:
            constructor_args = []
            sep = ':'
        else:
            sep = ','
        for attrib in self.attributes:
            if attrib['attType'] == 'lo_element':
                constructor_args.append('{0} {1} '
                                        '({2})'.format(sep,
                                                      attrib['memberName'],
                                                      parameters))
                sep = ','
            elif 'isVector' in attrib and attrib['isVector']:
                constructor_args.append('{0} {1} '
                                        '()'.format(sep, attrib['memberName']))
                sep = ','
            else:
                constructor_args.append('{0} {1} '
                                        '({2})'.format(sep, attrib['memberName'],
                                                      attrib['default']))
                sep = ','
            if attrib['isNumber'] or attrib['attType'] == 'boolean':
                constructor_args.append(', mIsSet{0} (false)'
                                        .format(attrib['capAttName']))
        if self.overwrites_children:
            constructor_args.append('{0} mElementName(\"'
                                    '{1}\")'.format(sep, self.xml_name))
        return constructor_args

    @staticmethod
    def write_copy_constructor_args(self):
        sep = ':'
        if self.base_class:
            constructor_args = ['{0} {1}( orig )'.format(sep, self.base_class)]
            sep = ','
        else:
            constructor_args = []
        for attrib in self.attributes:
            if attrib['isArray']:
                constructor_args.append('{0} {1} ( NULL )'
                                        .format(sep, attrib['memberName']))
                sep = ','
            elif attrib['type'] != 'element' and attrib['element'] != 'ASTNode':
                constructor_args.append('{1} {0} ( orig.{0} )'
                                        .format(attrib['memberName'], sep))
                sep = ','
                if attrib['isNumber'] or attrib['attType'] == 'boolean':
                    constructor_args.append('{1} mIsSet{0} ( orig.mIsSet{0} )'
                                            .format(attrib['capAttName'], sep))
                    sep = ','
            else:
                constructor_args.append('{0} {1} ( NULL )'
                                        .format(sep, attrib['memberName']))
                sep = ','
        if self.overwrites_children:
            constructor_args.append('{0} mElementName '
                                    '( orig.mElementName )'.format(sep))

        return constructor_args

    @staticmethod
    def write_assignment_args(self):
        if self.base_class:
            constructor_args = ['{0}::operator=(rhs)'.format(self.base_class)]
        else:
            constructor_args = []
        for attrib in self.attributes:
            if attrib['isArray']:
                member = attrib['memberName']
                length = strFunctions.upper_first(attrib['name'])
                constructor_args.append('{0} = NULL'.format(member))
                constructor_args.append('set{0}(rhs.{1}, '
                                        'rhs.{1}Length)'.format(length, member))
            elif attrib['type'] != 'element':
                constructor_args.append('{0} = rhs.{0}'
                                        .format(attrib['memberName']))
                if attrib['isNumber'] or attrib['attType'] == 'boolean':
                    constructor_args.append('mIsSet{0} = rhs.mIsSet{0}'
                                            .format(attrib['capAttName']))
        if self.overwrites_children:
            constructor_args.append('mElementName = rhs.mElementName')
        return constructor_args

    def write_set_array(self, index):
        name = self.attributes[index]['capAttName']
        member = self.attributes[index]['memberName']
        length = member + 'Length'
        line = ['set{0}(orig.{1}, orig.{2})'.format(name, member, length)]
        return line

    @staticmethod
    def create_code_block(code_type, lines):
        code = dict({'code_type': code_type, 'code': lines})
        return code
