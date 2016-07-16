#!/usr/bin/env python
#
# @file    BaseCppFile.py
# @brief   base class for cpp files to be generated
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

import time
import os

from util.jsbml_data_tree import jsbml_data_tree
from . import BaseFile
from util import strFunctions, query, global_variables, jsbml_data_tree, insideJSBML_parser, jsbmlHelperFunctions


class BaseJavaFile(BaseFile.BaseFile):
    """Common base class for all java files"""

    def __init__(self, name, extension, attributes):
        BaseFile.BaseFile.__init__(self, name, extension)

        # members that might get overridden if creating another library
        self.baseClass = global_variables.javaBaseClass

        # GSOC 2016 modifications


        # derived members for comments
        self.comment_start = '/**'
        self.comment = ' *'
        self.comment_end = '*/'
        self.license_comment_start = '/*'


        # TODO GSOC license variables Almost Done
        self.file_version = 2465
        self.file_creation_time = ''
        self.file_creation_time_jsbml_types = ''
        self.file_link = ''
        self.folder_and_filename = os.getcwd() + self.filename
        self.jsbml_version = 1.2
        # TODO GSOC 2016 prime numbers
        # n = 10000000
        # self.prime_numbers = jsbmlHelperFunctions.generate_prime_numbers(n)
        # print('prime ', len(self.prime_numbers))
        self.prime_numbers = global_variables.prime_numbers


        # members that might get overridden if creating another library
        self.language = global_variables.javaLanguage
        self.library_name = global_variables.java_library_name
        self.cap_language = self.language.upper()

        # TODO GSOC 2016 jsbml_data_tree
        self.run_tests = global_variables.running_tests
        self.serialVersionUID = jsbmlHelperFunctions.generate_uuid(self.run_tests) #-6048861420699176889

        self.jsbml_data_tree = jsbml_data_tree.jsbml_data_tree
        # TODO will need something similar for importing modules, but how?
        self.class_is_abstract = False
        # expand the information for the attributes
        if attributes:
            self.attributes = self.expand_attributes(attributes)
            self.child_elements = self.get_children()
            self.child_lo_elements = self.get_lo_children()
        else:
            self.attributes = []
            self.child_elements = []
            self.child_lo_elements = []

        self.num_children = \
            len(self.child_lo_elements) + len(self.child_elements)

        self.concretes = []

        # default values
        self.is_java_api = True

        self.class_object = {}

        # declare variables that will populate by the class object
        if not self.name:
            self.name = ''
        self.is_list_of = ''
        self.class_name = ''
        self.package = ''
        self.typecode = ''
        self.list_of_name = ''
        self.list_of_child = ''
        self.has_std_base = True
        self.std_base = global_variables.std_base
        self.sid_refs = ''
        self.unit_sid_refs = ''
        self.add_decls = None
        self.add_impl = None
        self.overwrites_children = False
        self.has_math = False
        self.has_children = False
        self.has_only_math = False
        self.has_non_std_children = False
        self.num_non_std_children = 0
        self.class_attributes = []
        self.has_parent_list_of = False
        self.is_plugin = False
        self.is_doc_plugin = False


    ########################################################################

    # TODO will be needed for interfaces create a modified copy of it
    def expand_class(self, class_object):
        self.class_object = class_object
        self.is_list_of = class_object['is_list_of']
        self.has_parent_list_of = class_object['hasListOf']
        self.name = class_object['name']
        self.class_name = class_object['name']
        self.package = class_object['package']
        self.typecode = class_object['typecode']
        if class_object['is_list_of']:
            self.list_of_name = class_object['list_of_name']
            self.list_of_child = class_object['lo_child']
        else:
            self.list_of_name = ''
            self.list_of_child = ''
        # check case of things where we assume upper/lower
        if self.package[0].islower():
            self.package = strFunctions.upper_first(class_object['package'])

        # are we a plugin
        if 'is_plugin' in class_object:
            self.is_plugin = class_object['is_plugin']
        if 'is_doc_plugin' in class_object:
            self.is_doc_plugin = class_object['is_doc_plugin']

        # information about the base class
        self.baseClass = class_object['baseClass']
        if self.language != 'jsbml':
            if not self.is_list_of:
                base = '{0}Base'.format(global_variables.prefix)
            else:
                base = '{0}ListOf'.format(global_variables.prefix)
            if base != self.baseClass:
                self.has_std_base = False

        elif not self.is_list_of and not self.is_plugin \
                and self.baseClass != 'SBase':
            self.has_std_base = False
        elif self.is_list_of and not self.is_plugin \
                and self.baseClass != 'ListOf':
            self.has_std_base = False
        elif self.is_plugin and not self.is_doc_plugin \
                and self.baseClass != 'SBasePlugin':
            self.has_std_base = False
        elif self.is_doc_plugin:
            self.has_std_base = True
            self.std_base = '{0}DocumentPlugin'.format(self.cap_language)
        self.class_object['has_std_base'] = self.has_std_base
        self.class_object['std_base'] = self.std_base

        # references
        self.sid_refs = class_object['sid_refs']
        self.unit_sid_refs = class_object['unit_sid_refs']
        if 'addDecls' in class_object:
            self.add_decls = class_object['addDecls']
        if 'addDefs' in class_object:
            self.add_impl = class_object['addDefs']
        # if 'childrenOverwriteElementName' in class_object:
        #     self.overwrites_children = \
        #         class_object['childrenOverwriteElementName']
        if 'root' in class_object:
            self.overwrites_children = \
                query.overwrites_name(class_object['root'],
                                      class_object['name'])
        self.class_object['overwrites_children'] = self.overwrites_children

        # child elements
        self.has_math = class_object['hasMath']
        self.has_children = query.has_children(class_object['attribs'])
        if self.has_math and \
                not query.has_children_not_math(class_object['attribs']):
            self.has_only_math = True

        # mark child elements as ML nodes
        for i in range(0, len(self.child_elements)):
            element = self.child_elements[i]
            if element['element'].endswith('Node') \
                    and not element['element'].endswith('CSGNode'):
                self.child_elements[i]['is_ml'] = True
                self.has_non_std_children = True
                self.num_non_std_children += 1
            else:
                self.child_elements[i]['is_ml'] = False

        if 'concrete' in class_object:
            self.concretes = query.get_concretes(class_object['root'],
                                                 class_object['concrete'])
        # TODO I think it will be critical for import statements
        self.class_attributes = query.separate_attributes(self.attributes)

        # document class for other libraries
        self.document = False
        if 'document' in class_object:
            self.document = class_object['document']
        # add info back to the class_object so we can pass it on
        self.class_object['package'] = self.package
        self.class_object['class_attributes'] = self.class_attributes
        self.class_object['child_lo_elements'] = self.child_lo_elements
        self.class_object['child_elements'] = self.child_elements
        self.class_object['concretes'] = self.concretes
        self.class_object['has_array'] = query.has_array(self.class_attributes)
        self.class_object['has_vector'] = query.has_vector(self.class_attributes)
        self.class_object['has_math'] = self.has_math
        self.class_object['has_children'] = self.has_children
        self.class_object['has_only_math'] = self.has_only_math
        self.class_object['has_parent_list_of'] = self.has_parent_list_of
        self.class_object['num_children'] = self.num_children
        self.class_object['has_non_std_chilren'] = self.has_non_std_children
        self.class_object['num_non_std_children'] = self.num_non_std_children
        self.class_object['is_header'] = self.is_header
        self.class_object['document'] = self.document

        # TODO GSOC 2016
        self.pack = str(self.package).lower()

    ########################################################################

    def get_general_includes(self):
        lo_name = ''
        if self.has_parent_list_of:
            if 'lo_class_name' in self.class_object:
                lo_name = self.class_object['lo_class_name']
            if len(lo_name) == 0:
                lo_name = strFunctions.list_of_name(self.class_name)
        if global_variables.is_package:
            folder = self.language if not self.is_plugin else 'extension'
            print('folder', folder)
            try:
                curr_include_line = '#include <{0}/packages/{1}/{2}/{3}.h>'.format(self.language,
                                                                                   self.package.lower(),
                                                                                   folder, self.class_name)
                print('curr_include_line is ', curr_include_line)
                # self.write_line_verbatim(curr_include_line)
            except Exception as error:
                print("Error is ", error)
            if self.has_parent_list_of and not self.is_list_of:
                try:
                    curr_include_line = '#include <{0}/packages/{1}/{0}/{2}.h>'.format(self.language,
                                                                                       self.package.lower(),
                                                                                       lo_name)
                    print('curr_include_line Parent ', curr_include_line)
                    # self.write_line_verbatim(curr_include_line)
                except Exception as error:
                    print("error in ", error)



            line = '#include <{0}/packages/{1}/validator/'\
                                     '{2}{3}Error'\
                                     '.h>'.format(self.language,
                                                  self.package.lower(),
                                                  self.package,
                                                  self.cap_language)
            print(line)
        else:
            line = '#include <{0}/{1}'\
                                     '.h>'.format(self.language,
                                                  self.class_name)
            if self.has_parent_list_of and not self.is_list_of:
                line = '#include <{0}/{1}'\
                                         '.h>'.format(self.language,
                                                      lo_name)

            line = '#include <sbml/xml/XMLInputStream.h>'

        # determine whether we need to write other headers
        write_element_filter = False
        concrete_classes = []
        write_model = False
        write_validators = False
        write_math = False

        if len(self.child_lo_elements) > 0 and global_variables.is_package:
            write_element_filter = True
        elif global_variables.is_package:
            for element in self.child_elements:
                if 'concrete' in element:
                    write_element_filter = True

        if self.is_plugin and not self.is_doc_plugin \
                and self.language == 'sbml':
            write_model = True

        if self.is_doc_plugin:
            write_validators = True

        if self.has_math:
            write_math = True

        for lo in self.child_lo_elements:
            if 'concrete' in lo:
                child_concretes = query.get_concretes(lo['root'],
                                                      lo['concrete'])
                for j in range(0, len(child_concretes)):
                    element = child_concretes[j]['element']
                    if element not in concrete_classes:
                        concrete_classes.append(element)

        for i in range(0, len(self.concretes)):
            element = self.concretes[i]['element']
            if element not in concrete_classes:
                concrete_classes.append(element)

        for child in self.child_elements:
            if 'concrete' in child:
                child_concretes = query.get_concretes(child['root'],
                                                      child['concrete'])
                for j in range(0, len(child_concretes)):
                    element = child_concretes[j]['element']
                    if element not in concrete_classes:
                        concrete_classes.append(element)

        if write_element_filter:
            line = '#include <{0}/util/ElementFilter.'\
                                     'h>'.format(self.language)
        if write_model:
            line = '#include <{0}/Model'\
                                     '.h>'.format(self.language)

        if write_validators:
            line = '#include <{0}/packages/{1}/validator/{2}'\
                                     'ConsistencyValidator'\
                                     '.h>'.format(self.language,
                                                  self.package.lower(),
                                                  self.package)

            line = '#include <{0}/packages/{1}/validator/{2}'\
                                     'IdentifierConsistencyValidator.'\
                                     'h>'.format(self.language,
                                                 self.package.lower(),
                                                 self.package)


        if write_math:
            line = '#include <sbml/math/MathML.h>'

        if len(concrete_classes) > 0:
            pass
            #self.skip_line()
        for element in concrete_classes:
            if global_variables.is_package:
                line = '#include <{0}/packages/{1}/{0}/{2}'\
                                         '.h>'.format(self.language,
                                                      self.package.lower(),
                                                      element)
            else:
                line = '#include <{0}/{1}.h>'\
                                         ''.format(self.language, element)

        # # TODO for skipping lines
        # self.skip_line(2)
        # # self.write_line('using namespace std;')
        # self.skip_line()


        # #print(self.class_object)
        # print(self.is_list_of)
        # print(self.has_parent_list_of)
        # print(self.name)
        # print(self.class_name)
        # print(self.package)
        # print(self.typecode)
        # print(self.baseClass)
        # # print(self.list_of_name)
        # # print(self.list_of_child)
        # # print(self.baseClass)
        # print(self.has_std_base)
        # # print(self.sid_refs)
        # # print(self.unit_sid_refs)
        # print(self.add_decls)
        # print(self.add_impl)
        # print(self.has_math)
        # print(self.has_children)
        # # print(self.concretes)
        # print(self.document)


        # for attribute in self.attributes:
        #     print('BADA ', attribute['name'])
        #     print('YOLO ', attribute['type'])
        #     #print(attribute)
        #     if attribute['type'] == 'SIdRef':
        #         key = 'AbstractNamedSBase'
        #         children = self.jsbml_data_tree[key]['childrenNodes']
        #         self.import_from_jsbml_modules += children
        #         print(children)
        #         for child in children:
        #             interface = self.jsbml_data_tree[child]['parentInterfaces']
        #             print(interface)
        #             print('--------')
        # print('----------------------------')

    ########################################################################



    # Function to expand import modules and extension
    def expand_import_modules(self):


        self.extends_modules = []
        self.implements_modules = []
        self.import_from_java_modules = []
        self.import_from_jsbml_modules = []

        #THis is the tricky part
        # self.get_general_includes()

        self.import_from_jsbml_modules.append('*')
        self.import_from_jsbml_modules.append('util.*')
        self.import_from_jsbml_modules.append('util.filters.*')

        #self.import_from_jsbml_utils_modules = []
        if str(self.package).lower() == 'qual':
            if self.name in ['QualitativeSpecies', 'Input', 'Output', 'FunctionTerm', 'DefaultTerm', 'Transition']:
                self.class_is_abstract = False
                self.import_from_java_modules.append('java.util.Map')
            if self.name in ['Transition']:
                self.import_from_java_modules.append('java.text.MessageFormat')
        if len(self.jsbml_data_tree[self.pack][self.name]) > 0:
            self.extends_modules = [self.jsbml_data_tree[self.pack][self.name][0]]
        if len(self.jsbml_data_tree[self.pack][self.name]) > 1:
            self.implements_modules = self.jsbml_data_tree[self.pack][self.name][1:]

        self.jsbml_class_header_and_import = dict({'className': self.name,
                                                   'abstract': self.class_is_abstract,
                                                   'extends': self.extends_modules,
                                                   'implements': self.implements_modules,
                                                   'javaModules': sorted(self.import_from_java_modules),
                                                   'jsbmlModules': self.import_from_jsbml_modules})

    def expand_jsbml_methods(self):
        self.jsbml_methods = {}
        for module in self.extends_modules:
            data = insideJSBML_parser.get_class_information(module)
            self.jsbml_methods.update({module: data})

            if len(self.jsbml_data_tree[module]['parentInterfaces']) > 0:
                for interface_class in self.jsbml_data_tree[module]['parentInterfaces']:
                    interface = insideJSBML_parser.get_class_information(interface_class)
                    self.jsbml_methods.update({interface_class: interface})

        for module in self.implements_modules:
            data = insideJSBML_parser.get_class_information(module)
            self.jsbml_methods.update({module: data})

        for i in range(0, len(self.attributes)):
            capname = strFunctions.upper_first(self.attributes[i]['name'])
            # print('capname is ',capname)
            if capname not in list(self.jsbml_data_tree.keys()):
                continue
            else:
                data = insideJSBML_parser.get_class_information(capname)
                # print('yahoo ',data)
                self.jsbml_methods.update({capname: data})


        # print('YOLO ',self.jsbml_methods)




    def expand_mandatory(self):
        # print(self.name)
        # print(self.pack)
        self.mandatory_data = []

        keys = self.jsbml_data_tree[self.pack][self.name]
        #print(keys)

        for import_key in keys:
            data = self.jsbml_data_tree[import_key]['Mandatory']
            #print(data)
            if len(data) > 0:
                self.mandatory_data.append(data)

        attributes = self.attributes
        for attribute in attributes:
            att_key = strFunctions.upper_first(attribute['name'])
            data = self.jsbml_data_tree[att_key]['Mandatory']
            #print(data)
            if len(data) > 0:
                self.mandatory_data.append(data)

        # print(self.mandatory_data)
        # print('----------->>>>>>>-------')




    # Function to expand the attribute information
    def expand_attributes(self, attributes):
        for i in range(0, len(attributes)):
            capname = strFunctions.upper_first(attributes[i]['name'])
            attributes[i]['name'] = strFunctions.lower_first(capname)
            attributes[i]['capAttName'] = capname
            attributes[i]['memberName'] = 'm' + capname
            attributes[i]['pluralName'] = \
                strFunctions.plural(attributes[i]['name'])
            attributes[i]['isEnum'] = False
            attributes[i]['isArray'] = False
            attributes[i]['isVector'] = False
            attributes[i]['children_overwrite'] = False
            att_type = attributes[i]['type']
            if att_type == 'SId' or att_type == 'SIdRef' or att_type == 'IDREF':
                attributes[i]['attType'] = 'String'
                attributes[i]['attTypeCode'] = 'String'
                attributes[i]['CType'] = 'String'
                attributes[i]["JClassType"] = 'String'
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = '""'
            elif att_type == 'UnitSId' or att_type == 'UnitSIdRef':
                attributes[i]['attType'] = 'String'
                attributes[i]['attTypeCode'] = 'String'
                attributes[i]['CType'] = 'String'
                attributes[i]["JClassType"] = 'String'
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = '""'
            elif att_type == 'string':
                attributes[i]['attType'] = 'String'
                attributes[i]['attTypeCode'] = 'String'
                attributes[i]['CType'] = 'String'
                attributes[i]["JClassType"] = 'String'
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = '""'
            elif att_type == 'double':
                attributes[i]['attType'] = 'double'
                attributes[i]['attTypeCode'] = 'double'
                attributes[i]['CType'] = 'double'
                attributes[i]["JClassType"] = 'Double'
                attributes[i]['isNumber'] = True
                attributes[i]['default'] = 'util_NaN()' #?
            elif att_type == 'int':
                attributes[i]['attType'] = 'integer'
                attributes[i]['attTypeCode'] = 'int'
                attributes[i]['CType'] = 'int'
                attributes[i]["JClassType"] = 'Integer'
                attributes[i]['isNumber'] = True
                attributes[i]['default'] = '{0}_INT_' \
                                           'MAX'.format(self.cap_language) #?
            elif att_type == 'uint':
                attributes[i]['attType'] = 'unsigned integer'
                attributes[i]['attTypeCode'] = 'int'
                attributes[i]['CType'] = 'int'
                attributes[i]["JClassType"] = 'Integer'
                attributes[i]['isNumber'] = True
                attributes[i]['default'] = '{0}_INT_' \
                                           'MAX'.format(self.cap_language)
            elif att_type == 'bool' or att_type == 'boolean':
                attributes[i]['attType'] = 'boolean'
                attributes[i]['attTypeCode'] = 'boolean'
                attributes[i]['CType'] = 'boolean'
                attributes[i]["JClassType"] = 'Boolean'
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = 'False'
            elif att_type == 'enum': #This is tricky
                attributes[i]['isEnum'] = True
                attributes[i]['attType'] = 'enum'
                attributes[i]['attTypeCode'] = attributes[i]['element'] #+ '_t'
                attributes[i]['CType'] = attributes[i]['element'] # + '_t'
                attributes[i]["JClassType"] = attributes[i]['element']
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = \
                    query.get_default_enum_value(attributes[i])
            elif att_type == 'element':
                el_name = attributes[i]['element']
                at_name = attributes[i]['name']
                attributes[i]['attType'] = 'element'
                if attributes[i]['name'] == 'math':
                    if global_variables.is_package:
                        attributes[i]['attTypeCode'] = 'ASTNode' # 'ASTNode*'
                        attributes[i]['CType'] = 'ASTNode'  #'ASTNode_t*'
                        attributes[i]["JClassType"] = 'ASTNode'
                    # else:
                    #     attributes[i]['attTypeCode'] = 'LIBSBML_CPP_NAMESPACE_QUALIFIER ASTNode*'
                    #     attributes[i]['CType'] = 'LIBSBML_CPP_NAMESPACE_QUALIFIER ASTNode_t*'
                else:
                    attributes[i]['attTypeCode'] = attributes[i]['element']+'*'
                    attributes[i]['CType'] = attributes[i]['element']+'_t*'
                    attributes[i]["JClassType"] = attributes[i]['element']
                if attributes[i]['attTypeCode'] == 'XMLNode*' and not global_variables.is_package:
                    attributes[i]['attTypeCode'] = 'LIBSBML_CPP_NAMESPACE_QUALIFIER {0}*'.format(attributes[i]['element'])
                    attributes[i]['CType'] = 'LIBSBML_CPP_NAMESPACE_QUALIFIER {0}_t*'.format(attributes[i]['element'])
                    attributes[i]['JClassType'] = 'LIBSBML_CPP_NAMESPACE_QUALIFIER {0}_t*'.format(attributes[i]['element'])

                attributes[i]['isNumber'] = False
                attributes[i]['default'] = 'NULL'
                if strFunctions.compare_no_case(strFunctions.remove_prefix(el_name), at_name):
                    attributes[i]['children_overwrite'] = False
                else:
                    attributes[i]['children_overwrite'] = True
            elif att_type == 'lo_element' or att_type == 'inline_lo_element':
                name = strFunctions.list_of_name(attributes[i]['element'])
                plural = strFunctions.plural_no_prefix(attributes[i]['element'])
                attributes[i]['attType'] = 'lo_element'
                attributes[i]['attTypeCode'] = name
                attributes[i]['CType'] = 'ListOf'# _t'
                attributes[i]['JClassType'] = 'ListOf'  # _t'
                attributes[i]['memberName'] = 'm' + plural
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = 'NULL'
            elif att_type == 'array':
                attributes[i]['isArray'] = True
                attributes[i]['element'] = \
                    strFunctions.lower_first(attributes[i]['element'])
                attributes[i]['attType'] = 'array'
                attributes[i]['attTypeCode'] = attributes[i]['element'] # + '*'
                attributes[i]['CType'] = attributes[i]['attTypeCode']
                attributes[i]['JClassType'] = attributes[i]['attTypeCode']
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = 'NULL'
            elif att_type == 'vector':
                attributes[i]['isVector'] = True
                attributes[i]['element'] = \
                    strFunctions.lower_first(attributes[i]['element'])
                attributes[i]['attType'] = 'vector'
                attributes[i]['attTypeCode'] = 'ArrayList<{0}>'.format(attributes[i]['element'])
                # print("YOLUS ",attributes[i]['attTypeCode'])
                attributes[i]['CType'] = attributes[i]['attTypeCode']
                attributes[i]['JClassType'] = attributes[i]['attTypeCode']
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = 'NULL'
            else:
                global_variables.code_returned \
                    = global_variables.return_codes['unknown type used']
                attributes[i]['attType'] = 'FIXME_{0}'.format(att_type)
                attributes[i]['attTypeCode'] = 'FIXME_{0}'.format(att_type)
                attributes[i]['CType'] = 'FIXME_{0}'.format(att_type)
                attributes[i]['JClassType'] = 'FIXME_{0}'.format(att_type)
                attributes[i]['isNumber'] = False
                attributes[i]['default'] = 'FIXME_{0}'.format(att_type)
        return attributes

    def create_lo_other_child_element_class(self, name, parent): #Critical becareful with it
        capname = strFunctions.upper_first(name)
        print('Yolo capname ',capname)
        element = dict({'isArray': False,
                        'name': strFunctions.lower_first(capname),
                        'attTypeCode': capname,
                        'CType': capname ,
                        'capAttName': capname,
                        'attType': 'element',
                        'memberName': 'm' + capname,
                        'isNumber': False,
                        'type': 'element',
                        'default': 'NULL',
                        'element': capname,
                        'is_ml': False,
                        'children_overwrite': False,
                        'abstract': False})
        child_class = dict({'name': parent,
                            'package': self.package,
                            'class_attributes': [],
                            'child_elements': [element]})
        return child_class

    def get_children(self):
        elements = []
        listed_elements = []
        for i in range(0, len(self.attributes)):
            att_type = self.attributes[i]['attType']
            name = self.attributes[i]['name']
            if att_type == 'element' and name not in listed_elements:
                elements.append(self.attributes[i])
                listed_elements.append(name)
        return elements

    def get_lo_children(self):
        elements = []
        listed_elements = []
        for i in range(0, len(self.attributes)):
            attribute = self.attributes[i]
            att_type = attribute['attType']
            name = attribute['name']
            if att_type == 'lo_element' and name not in listed_elements:
                # check for concrete instances
                if attribute['type'] == 'inline_lo_element':
                    capname = strFunctions.upper_first(name)
                    attrib_class = query.get_class(capname, attribute['root'])
                    if attrib_class and 'concrete' in attrib_class:
                        attribute['concrete'] = attrib_class['concrete']
                elements.append(attribute)
                listed_elements.append(name)
        return elements

    ########################################################################

    # Functions to overwrite base class settings
    def set_base_class(self, base):
        self.baseClass = base

    def set_std_base_class(self, base):
        self.std_base = base

    ########################################################################

    #   FUNCTIONS FOR WRITING STANDARD OPENING CLOSING ELEMENTS

    # functions cpp ns
    def write_cppns_begin(self):
        self.skip_line(2)
        self.write_line('{0}_CPP_NAMESPACE_BEGIN'
                        .format(self.library_name.upper()))
        self.skip_line(2)

    def write_cppns_end(self):
        self.skip_line(2)
        self.write_line('{0}_CPP_NAMESPACE_END'
                        .format(self.library_name.upper()))
        self.skip_line(2)

    def write_cppns_use(self):
        self.skip_line(2)
        self.write_line('{0}_CPP_NAMESPACE_USE'
                        .format(self.library_name.upper()))
        self.skip_line(2)

    # functions c declaration
    def write_cdecl_begin(self):
        self.skip_line(2)
        self.write_line('BEGIN_C_DECLS')
        self.skip_line(2)

    def write_cdecl_end(self):
        self.skip_line(2)
        self.write_line('END_C_DECLS')
        self.skip_line(2)

    # functions swig directive
    def write_swig_begin(self):
        self.skip_line(2)
        self.write_line('#ifndef SWIG')
        self.skip_line(2)

    def write_swig_end(self):
        self.skip_line(2)
        self.write_line('#endif  /*  !SWIG  */')
        self.skip_line(2)

    # functions cplusplus directive
    def write_cpp_begin(self):
        self.skip_line(2)
        self.write_line('#ifdef __cplusplus')
        self.skip_line(2)

    def write_cpp_end(self):
        self.skip_line(2)
        self.write_line('#endif  /*  __cplusplus  */')
        self.skip_line(2)

########################################################################

# FUNCTIONS FOR WRITING STANDARD FUNCTION DECLARATIONS

    def write_function_header(self,
                              function_name, arguments, return_type,
                              is_const=False, is_virtual=False,
                              is_abstract=False):
        is_java = self.is_java_api
        num_arguments = len(arguments)
        if not is_java:
            self.write_extern_decl()
            self.write_line(return_type)
            line = function_name + '('
        else:
            if return_type != '':
                if is_virtual:
                    line = 'virtual ' + return_type + ' ' + function_name + '('
                else:
                    line = return_type + ' ' + function_name + '('
            else:
                if is_virtual:
                    line = 'virtual ' + function_name + '('
                else:
                    line = function_name + '('

        if num_arguments == 0:
            if is_java and is_const:
                line += ') const;'
            elif is_abstract:
                line += ') = 0;'
            else:
                line += ');'
            self.write_line(line)
        elif num_arguments == 1:
            if is_java and is_const:
                line = line + arguments[0] # + ') const;'
            elif is_abstract:
                line = line + arguments[0] # + ') = 0;'
            else:
                line = line + arguments[0] + ');'
            self.write_line(line)
        else:
            saved_line = line
            line = line + arguments[0] + ', '
            # create the full line
            for n in range(1, num_arguments-1):
                line = line + arguments[n] + ', '
            if is_java and is_const:
                line = line + arguments[num_arguments-1] + ');' #  const'
            else:
                line = line + arguments[num_arguments-1] + ');'
            # look at length and adjust
            if len(line) >= self.line_length:
                # do something else
                line = saved_line
                att_start = len(line)
                line += arguments[0]
                line += ','
                if len(line) > self.line_length:
                    self.write_line(saved_line)
                    line = '' + arguments[0] + ','
                    self.write_line(line, att_start)
                else:
                    self.write_line(line)
                for i in range(1, num_arguments - 1):
                    line = arguments[i] + ','
                    self.write_line(line, att_start)
                if is_java and is_const:
                    line = arguments[num_arguments - 1] + ');' # const
                else:
                    line = arguments[num_arguments - 1] + ');'
                self.write_line(line, att_start)
            else:
                self.write_line(line)


    # TODO write open braces Done
    def write_class_function_header(self, function_name, arguments,
                                    return_type, is_const=False,
                                    constructor_args=None):
        is_java = self.is_java_api
        num_arguments = len(arguments)
        if not is_java:
            self.write_extern_decl()
        #self.write_line(return_type) #Need to remove this part

        # TODO GSOC 2016 change modified brackets
        line = 'public' + ' ' + return_type + ' ' + function_name + '('
        if num_arguments == 0:
            if is_java and is_const:
                line += ')' # const
            else:
                line += ')'
            self.write_line_jsbml(line)
        elif num_arguments == 1:
            if is_java and is_const:
                line = line + arguments[0] + ')' # const
            else:
                line = line + arguments[0] + ')'
            self.write_line_jsbml(line)
        else:
            saved_line = line
            line = line + arguments[0] + ', '
            # create the full line
            for n in range(1, num_arguments-1):
                line = line + arguments[n] + ', '
            if is_java and is_const:
                line = line + arguments[num_arguments-1] + ')' # const
            else:
                line = line + arguments[num_arguments-1] + ')'
            # look at length and adjust
            if len(line) >= self.line_length:
                # do something else
                line = saved_line
                att_start = len(line)
                line += arguments[0]
                line += ','
                if len(line) > self.line_length:
                    self.write_line_jsbml(saved_line)
                    line = '' + arguments[0] + ','
                    self.write_line_jsbml(line, att_start)
                else:
                    self.write_line_jsbml(line)
                for i in range(1, num_arguments - 1):
                    line = arguments[i] + ','
                    self.write_line_jsbml(line, att_start)
                if is_java and is_const:
                    line = arguments[num_arguments - 1] + ')' # const
                else:
                    line = arguments[num_arguments - 1] + ')'
                self.write_line_jsbml(line, att_start)
            else:
                self.write_line_jsbml(line)
        if constructor_args is not None:
            self.up_indent()
            for i in range(0, len(constructor_args)):
                self.write_line_jsbml(constructor_args[i])
            self.down_indent()


########################################################################

# FUNCTIONS FOR WRITING STANDARD DOC COMMENTS

    def write_comment_header(self, title_line, params, return_line,
                             object_name, additional=None):
        if additional is None:
            additional = []
        self.open_comment()
        self.write_comment_line(title_line)
        for i in range(0, len(params)):
            self.write_blank_comment_line()
            self.write_comment_line(params[i])
        if len(return_line) > 0:
            self.write_blank_comment_line()
        for i in range(0, len(return_line)):
            self.write_comment_line((return_line[i]))
        if len(additional) > 0:
            self.write_blank_comment_line()
        # TODO maybe this part could be used for writing @Overrides?
        for i in range(0, len(additional)):
            if additional[i] == ' ':
                self.write_blank_comment_line()
            else:
                self.write_comment_line(additional[i])
        if object_name.endswith('_t'):
            self.write_blank_comment_line()
            self.write_comment_line('@memberof {0}'.format(object_name))
        self.close_comment()


    # functions for writing Javadoc comments
    def write_non_javadoc_comment_line(self, line):
        #print('line is ',line)
        tabs = ''
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        lines = self.create_lines(line, len(tabs), True)
        #print('lines ',lines)
        lines = lines[0].split('--')
        self.file_out.write(' {1}\n'
                            .format(tabs, lines[0]))
        for i in range(1, len(lines)):
            self.file_out.write('{0}{1} {2}\n'
                                .format(tabs, self.comment, lines[i]))


    # Need to add tabs
    def write_brief_header(self, title_line):
        self.open_double_comment(self)
        self.write_comment_line(title_line)
        self.close_comment()

    def write_non_javadoc_header(self, title_line):
        self.open_non_javadoc_comment(self)
        self.write_non_javadoc_comment_line(title_line)
        self.close_comment()


    def write_class_params_header(self, params):
        self.open_double_comment(self)
        for param in params:
            #print('param ', param)
            self.write_comment_line(param)
        self.close_comment()

    def write_override_statement(self):
        self.write_line_verbatim('@Override')

    # TODO GSOC variable comment line
    def write_variable_comment(self):
        self.open_double_comment(self)
        self.write_blank_comment_line()
        self.close_comment()

    # TODO GSOC variable comment line
    def write_serial_version_comment(self):
        self.open_double_comment(self)
        line = 'Generated serial version identifier.'
        self.write_comment_line(line)
        self.close_comment()
#########################################################################

# Function for writing a function definition with comment
    def write_function_declaration(self, code, exclude=False):
        if code is not None:
            if exclude:
                self.write_doxygen_start()
            self.write_comment_header(code['title_line'], code['params'],
                                      code['return_lines'], code['object_name'],
                                      code['additional'])
            if 'pure_abstract' in code and code['pure_abstract']:
                self.write_function_header(code['function'], code['arguments'],
                                           code['return_type'],
                                           code['constant'], code['virtual'],
                                           True)
            else:
                self.write_function_header(code['function'], code['arguments'],
                                           code['return_type'],
                                           code['constant'], code['virtual'])
            if exclude:
                self.write_doxygen_end()
                self.skip_line()
            else:
                self.skip_line(2)

    # Function for writing a function implementation
    def write_function_implementation(self, code, exclude=False):
        if code is not None:
            self.up_indent() #This is a problem

            if exclude:
                self.write_doxygen_start()
            if len(code['additional']) > 0:
                if code['additional'][0] is'Override':
                    self.write_non_javadoc_header(code['title_line'])
                    self.write_override_statement()
            if len(code['params']) > 0 and len(code['additional']) == 0:
                self.write_class_params_header(code['params'])
            else:
                if len(code['additional']) == 0:
                    self.write_brief_header(code['title_line'])
            function_name = code['function']


            #GSOC 2016 function name changes necessary -> u'QualitativeSpecies getId' Wrong
            # TODO GSOC write param
            if self.is_java_api:
                if not code['object_name']:
                    function_name = code['function']
                else:
                    function_name = code['function'] #code['object_name'] + ' ' \  +
            if 'args_no_defaults' in code:
                arguments = code['args_no_defaults']
            else:
                arguments = code['arguments']
            constructor_args = None
            # print('function_name ', function_name) #both for constructors and functions, not suitable for JSBML
            # print('->-')
            if self.is_java_api:
                if 'constructor_args' in code:
                    constructor_args = code['constructor_args']
            self.write_class_function_header(function_name, arguments,
                                             code['return_type'],
                                             code['constant'],
                                             constructor_args)

            if 'implementation' in code and code['implementation'] is not None:
                self.write_implementation(code['implementation'])
                # print("code implementation ",code['implementation'])
                # print('---------------->')
            # TODO this part ok
            else:
                self.write_line('}')



            if exclude:
                self.write_doxygen_end()
                self.skip_line()
            else:
                self.skip_line()
            self.down_indent()

    # Function for writing a function implementation
    def write_inline_function_implementation(self, code, exclude=False):
        if code is not None:
            if exclude:
                self.write_doxygen_start()
            if len(code['title_line']) > 0:
                self.write_brief_header(code['title_line'])
            function_name = code['function']
            if self.is_java_api:
                function_name = code['function']
            if 'args_no_defaults' in code:
                arguments = code['args_no_defaults']
            else:
                arguments = code['arguments']
            constructor_args = None
            if self.is_java_api:
                if 'constructor_args' in code:
                    constructor_args = code['constructor_args']
            self.write_class_function_header(function_name, arguments,
                                             code['return_type'],
                                             code['constant'],
                                             constructor_args)

            if 'implementation' in code and code['implementation'] is not None:
                self.write_implementation(code['implementation'])
            # if exclude:
            #     self.write_doxygen_end()
            #     self.skip_line()
            # else:
            #     self.skip_line(2)

    # Function for writing a function implementation
    def write_function_verbatim(self, code):
        if code is not None:
            self.write_brief_header(code['title_line'])
            self.write_line(code['function'])

            if 'implementation' in code and code['implementation'] is not None:
                self.write_line('{')
                self.up_indent()
                for i in range(0, len(code['implementation'])):
                    self.write_line(code['implementation'][i])
                self.down_indent()
                self.write_line('};')
                self.skip_line(2)

    # Function to write the header about the typecode enumeration
    def write_type_code_enum_header(self, package):
        up_package = strFunctions.upper_first(package)
        self.open_comment()
        self.write_comment_line('@enum {0}{1}'
                                'TypeCode_t'.format(self.cap_language,
                                                    up_package))
        self.write_comment_line('@brief {0}{1}TypeCode_t Enumeration '
                                'of possible types in the lib{0} '
                                '&ldquo;{2}&rdquo; package '
                                'implementation.'.format(self.cap_language,
                                                         up_package,
                                                         package))
        self.write_blank_comment_line()
        self.write_comment_line('@copydetails doc_what_are_typecodes')
        self.write_blank_comment_line()
        self.write_comment_line('@copydetails doc_additional_typecode_details')
        self.close_comment()

    # Function to write the header about the typecode enumeration
    def write_enum(self, name, enum_no, enum_val, enum_str, length):
        number = len(enum_val)
        if len(enum_str) != number:
            return
        self.write_line('typedef enum')
        self.write_line('{')
        self.file_out.write('  {0:{width}}'.format(enum_val[0], width=length))
        if enum_no != 0:
            self.file_out.write('= {0:{width}}'.format(enum_no, width=5))
            enum_no += 1
        self.file_out.write('  /*!<{0} */\n'.format(enum_str[0]))
        for i in range(1, number):
            self.file_out.write(', {0:{width}}'.format(enum_val[i],
                                                      width=length))
            if enum_no != 0:
                self.file_out.write('= {0:{width}}'.format(enum_no, width=5))
                enum_no += 1
            self.file_out.write('  /*!<{0} */\n'.format(enum_str[i]))
        self.write_line('{0} {1};'.format('}', name))

    # Function to write the header about the typecode enumeration
    def write_enum_strings(self, name, enum_str):
        number = len(enum_str)
        self.write_line('static')
        self.write_line('const char* {0}[] ='.format(name))
        self.write_line('{')
        self.file_out.write('  \"{0}\"\n'.format(enum_str[0]))
        for i in range(1, number):
            self.file_out.write(', \"{0}\"\n'.format(enum_str[i]))
        self.write_line('};')

    ########################################################################

    # FUNCTIONS FOR WRITING STANDARD FUNCTION Implementation

    def write_implementation(self, implementation):
        #self.write_line('{') #TODO this one has to be moved
        self.write_nested_implementation(implementation)
        self.write_line('}')

    def write_implementation_block(self, code_type, code):
        if code_type == 'line':
            self.write_lines(code)
        elif code_type == 'comment':
            self.write_comments(code)
        elif code_type == 'if':
            self.write_block('if', code, True)
        elif code_type == 'if_else':
            self.write_if_else_block(code)
        elif code_type == 'else_if':
            self.write_else_if_block(code)
        elif code_type == 'for':
            self.write_block('for', code, True)
        elif code_type == 'while':
            self.write_block('while', code, True)
        elif code_type == 'try':
            self.write_try_block(code)

    def write_nested_implementation(self, implementation):
        num = len(implementation)
        self.up_indent()
        for i in range(0, num):
            this_impl = implementation[i]
            if len(this_impl) == 0:
                self.down_indent()
                return
            else:
                if 'code_type' in this_impl:
                    self.write_implementation_block(this_impl['code_type'],
                                                    this_impl['code'])
                    if i < num - 1:
                        self.skip_line()
                else:
                    self.write_line('{0};'.format(this_impl))
        self.down_indent()

    def write_lines(self, code):
        for i in range(0, len(code)):
            self.write_line('{0};'.format(code[i]))

    def write_comments(self, code):
        for i in range(0, len(code)):
            self.write_line('// {0}'.format(code[i]))

    def write_if_else_block(self, code):
        if_code = [code[0]]
        i = 1
        while i < len(code) and code[i] != 'else':
            if_code.append(code[i])
            i += 1
        self.write_block('if', if_code, True)
        self.write_block('else', code[i+1:len(code)], False)

    def write_else_if_block(self, code):
        if_code = [code[0]]
        i = 1
        while i < len(code) and code[i] != 'else if':
            if_code.append(code[i])
            i += 1
        self.write_block('if', if_code, True)
        try:
            i += 1
            else_if_code = [code[i]]
            i += 1
            while i < len(code):
                while i < len(code) and \
                        (code[i] != 'else if' and code[i] != "else"):
                    else_if_code.append(code[i])
                    i += 1
                self.write_block('else if', else_if_code, True)
                if i < len(code):
                    flag_else = (code[i] == 'else')
                    if not flag_else:
                        if i < len(code):
                            i += 1
                            else_if_code = [code[i]]
                            i += 1
                    else:
                        self.write_block('else', code[i+1:len(code)], False)
                        break
        except Exception as e:
            print('error ', e)


    def write_try_block(self, code):
        try_code = [code[0]]
        i = 1
        while i < len(code) and code[i] != 'catch':
            try_code.append(code[i])
            i += 1
        self.write_block('try', try_code, False)
        self.write_block('catch', code[i+1:len(code)], True)

    def write_block(self, block_start, code, condition):
        if condition:
            self.write_line_jsbml('{0} ({1})'.format(block_start, code[0]))
            #self.write_line('{')
            self.write_nested_implementation(code[1:len(code)])
            self.write_line_jsbml_block_end('}')
            #self.write_line('}') # TODO almost but not yet there, crap!!!
        else:
            self.write_line_jsbml_else(block_start)
            #self.write_line('{')
            self.write_nested_implementation(code)
            self.write_line('}')

    def write_line_jsbml_else(self, line, space = 0):
        self.file_out.write(' {0} '.format(line))
        self.file_out.write('{\n')


    def write_line_jsbml_block_end(self, line = '}', space=0):
        tabs = ''
        # self.num_tabs -= 1 Dont use this it works fine
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        for i in range(0, space):
            tabs += ' '
        # TODO Looks like here's the bracket? '{0}{1}\n'.format(tabs, lines[i]) -> public String getName()
        lines = self.create_lines(line, len(tabs))
        for i in range(0, len(lines)):
            self.file_out.write('{0}{1}'.format(tabs, lines[i]))
            #tabs += '  '
        #self.file_out.write('} ')

    def write_line_jsbml(self, line, space=0):
        tabs = ''
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        for i in range(0, space):
            tabs += ' '
        # TODO Looks like here's the bracket? '{0}{1}\n'.format(tabs, lines[i]) -> public String getName()
        lines = self.create_lines(line, len(tabs))
        # print('tada' ,lines)
        for i in range(0, len(lines)):
            self.file_out.write('{0}{1}'.format(tabs, lines[i]))
            tabs += '  '
        self.file_out.write(' {\n')


    def write_file(self):
        self.add_file_header()

    def write_jsbml_licence(self):
        # self.write_blank_comment_line()
        # self.write_comment_line('<!-----------------------------------------'
        #                         '---------------------------------')
        self.write_comment_line('----------------------------------------------------------------------------')
        #self.write_blank_comment_line()
        self.write_comment_line('This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>')
        self.write_comment_line('for the latest version of JSBML and more information about SBML.')
        self.write_blank_comment_line()
        self.write_comment_line('Copyright (C) 2009-2016 jointly by the following organizations:')
        self.write_comment_line('1. The University of Tuebingen, Germany')
        self.write_comment_line('2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK')
        self.write_comment_line('3. The California Institute of Technology, Pasadena, CA, USA')
        self.write_comment_line('4. The University of California, San Diego, La Jolla, CA, USA')
        self.write_comment_line('5. The Babraham Institute, Cambridge, UK')
        self.write_blank_comment_line()
        self.write_comment_line('This library is free software; you can redistribute it and/or modify it')
        self.write_comment_line('under the terms of the GNU Lesser General Public License as published b')
        self.write_comment_line('the Free Software Foundation. A copy of the license agreement is provided')
        self.write_comment_line('in the file named "LICENSE.txt" included with this software distribution')
        self.write_comment_line('and also available online as <http://sbml.org/Software/JSBML/License>.')
        self.write_comment_line('----------------------------------------------------------------------------')

    def open_license_comment(self):
        tabs = ''
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        self.file_out.write('{0}{1}\n'.format(tabs, self.license_comment_start))

    def get_time_and_date(self):
        self.file_creation_time = time.strftime('%Y-%m-%d %H:%M:%S')
        self.file_creation_time_jsbml_types = time.strftime('%Y-%m-%d %H:%M:%S %z (%a, %d %b %Y)')

    def write_file_header_information(self):
        self.get_time_and_date()
        self.write_comment_line('$Id: {0} {1} {2}Z deviser $'.format(self.filename, self.file_version,
                                                          self.file_creation_time))
        # TODO need to ask on Slack about URL
        self.write_comment_line('$URL: {0} $'.format(self.folder_and_filename))

    def add_file_header(self):
        self.open_license_comment()
        #self.write_file_header_information() # TODO wait till SBML AND JSBML team decide
        # self.write_comment_line('@file   {0}'.format(self.filename))
        # self.write_comment_line('@brief  {0}'.format(self.brief_description))
        # if global_variables.is_package:
        #     self.write_comment_line('@author JSBMLTeam')
        # else:
        #     self.write_comment_line('@author DEVISER')
        if self.library_name == 'JSBML' and (self.extension != 'xml'
                                               and self.extension != 'rng'):
            self.write_jsbml_licence()
        if self.is_header and not self.is_excluded(self.name):
            if self.name.endswith('Extension'):
                self.write_class_comments(True, False, False)
            elif self.name.endswith('Plugin'):
                self.write_class_comments(False, True, False)
            elif self.name.endswith('Validator'):
                self.write_class_comments(False, False, True)
            else:
                self.write_class_comments(False, False, False)

        self.close_comment()


    # TODO how to deal with deprecated methods @deprecated use {@link QualModelPlugin} instead.
    def write_jsbml_types_doc(self):
        self.open_comment()
        self.write_comment_line('@author Deviser')
        self.write_comment_line('@version $Rev: {0} $'.format(self.file_version))
        self.write_comment_line('@since {0}'.format(self.jsbml_version))
        self.write_comment_line('@date $Date: {0} $'.format(self.file_creation_time_jsbml_types))
        self.close_comment()

    def write_class_comments(self, extension, plugin, validator):
        fullname = global_variables.package_full_name
        up_package = strFunctions.upper_first(self.package)
        validator_class_comment = 'The {0} class extends the ' \
                                  'Validator class from core libSBML to ' \
                                  'apply validation to the constructs ' \
                                  'introduced by the SBML Level&nbsp;3 ' \
                                  '{1} package. This class then acts as a ' \
                                  'base class for any validators that ' \
                                  'apply rules to the &ldquo;{2}&rdquo; ' \
                                  'package specification constructs or to ' \
                                  'entire models that use the &ldquo;{2}' \
                                  '&rdquo; package, and may therefore be ' \
                                  'subject to other global restrictions ' \
                                  'introduced.'.format(self.name,
                                                       fullname,
                                                       self.package.lower())
        self.write_blank_comment_line()
        self.write_comment_line('@class {0}'.format(self.class_name))
        if extension:
            self.write_comment_line('@sbmlbrief{0}{1}{2} Base extension class'
                                    '.'.format(self.open_br,
                                               self.package.lower(),
                                               self.close_br))
            self.write_blank_comment_line()
            self.write_comment_line('@class {0}PkgNamespaces'
                                    ''.format(up_package))
            self.write_comment_line('@sbmlbrief{0}{1}{2} SBMLNamespaces '
                                    'extension.'
                                    ''.format(self.open_br,
                                              self.package.lower(),
                                              self.close_br))
        elif plugin:
            self.write_comment_line('@sbmlbrief{0}{1}{2} Extension of '
                                    '{3}.'.format(self.open_br,
                                                  self.package.lower(),
                                                  self.close_br,
                                                  self.class_object['sbase']))
        elif validator:
            self.write_comment_line('@sbmlbrief{0}{1}{2} Entry point for '
                                    '&ldquo;{1}&rdquo package validation'
                                    '.'.format(self.open_br,
                                               self.package.lower(),
                                               self.close_br))
            self.write_blank_comment_line()
            self.write_comment_line('@htmlinclude not-sbml-warning.html')
            self.write_blank_comment_line()
            self.write_comment_line('@copydetails doc_common_intro_'
                                    'package_validators')
            self.write_blank_comment_line()
            self.write_comment_line('{0}'.format(validator_class_comment))
            self.write_blank_comment_line()
            self.write_comment_line('@copydetails doc_section_package_'
                                    'validators_general_info')
        else:
            self.write_comment_line('@sbmlbrief{0}{1}{2} TODO:'
                                    '{3}'.format(self.open_br,
                                                 self.package.lower(),
                                                 self.close_br,
                                                 self.brief_description))




    ######################################################################

    # HELPER FUNCTIONS

    @staticmethod
    def open_single_comment(self):
        tabs = ''
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        self.file_out.write('{0}{1}\n'.format(tabs, '/*'))


    @staticmethod
    def open_double_comment(self):
        tabs = ''
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        self.file_out.write('{0}{1}\n'.format(tabs, '/**'))

    @staticmethod
    def open_non_javadoc_comment(self):
        tabs = ''
        for i in range(0, int(self.num_tabs)):
            tabs += '  '
        self.file_out.write('{0}{1}'.format(tabs, '/*'))