#!/usr/bin/env python

import os
import sys
sys.path.append(os.path.dirname(os.path.abspath(__file__)) + '/../')
sys.path.append(os.path.dirname(os.path.abspath(__file__)) + '/../../')
# print(sys.path)

from java_code_files import JavaFiles,  JavaEnumFiles,  JavaExtensionFiles
from parseXML import ParseXML
import difflib


import test_functions



##############################################################################
# Set up variables
os_sep = os.sep
fails = []
not_tested = []


##############################################################################
# Specific generation functions


# def generate_new_cpp_header(filename, num):
#     parser = ParseXML.ParseXML(filename)
#     ob = parser.parse_deviser_xml()
#     working_class = ob['baseElements'][num]
#     os.chdir('./temp')
#     all_files = CppFiles.CppFiles(working_class, True)
#     all_files.write_files()
#     os.chdir('../.')

def generate_new_java_files(filename, num):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    working_class = ob['baseElements'][num]
    os.chdir('./temp')
    all_files = JavaFiles.JavaFiles(working_class, True)
    all_files.write_files()
    os.chdir('../.')

def generate_new_enum_java_files(filename, num):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    working_enum = ob['enums'][num]
    os.chdir('./temp')
    all_files = JavaEnumFiles.JavaEnumFiles(working_enum, ob,  True)
    all_files.write_files()
    os.chdir('../.')


def generate_new_constant_java_files(filename):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    os.chdir('./temp')
    all_files = JavaExtensionFiles.JavaExtensionFiles(ob, '', True)
    all_files.write_constants()
    os.chdir('../.')


def generate_extension_header(filename):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    os.chdir('./temp')
    all_files = JavaExtensionFiles.JavaExtensionFiles(ob, '', True)
    all_files.write_files()
    os.chdir('../.')


def generate_types_header(filename):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    os.chdir('./temp')
    all_files = JavaExtensionFiles.JavaExtensionFiles(ob, 'types', True)
    all_files.write_files()
    os.chdir('../.')


def generate_fwd_header(filename):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    os.chdir('./temp')
    all_files = JavaExtensionFiles.JavaExtensionFiles(ob, 'fwd', True)
    all_files.write_files()
    os.chdir('../.')


# def generate_plugin_header(filename, num):
#     parser = ParseXML.ParseXML(filename)
#     ob = parser.parse_deviser_xml()
#     os.chdir('./temp')
#     all_files = ExtensionFiles.ExtensionFiles(ob, '', True)
#     all_files.write_plugin_files(num)
#     os.chdir('../.')


def generate_plugin_header(filename, num):
    parser = ParseXML.ParseXML(filename)
    ob = parser.parse_deviser_xml()
    os.chdir('./temp')
    all_files = JavaExtensionFiles.JavaExtensionFiles(ob, '', True)
    all_files.write_plugin_files(num)
    os.chdir('../.')


# def generate_error_header(filename):
#     parser = ParseXML.ParseXML(filename)
#     ob = parser.parse_deviser_xml()
#     os.chdir('./temp')
#     all_files = ValidationFiles.ValidationFiles(ob, True)
#     all_files.write_error_header()
#     all_files.write_error_table_header()
#     os.chdir('../.')


# def generate_validator(filename):
#     parser = ParseXML.ParseXML(filename)
#     ob = parser.parse_deviser_xml()
#     os.chdir('./temp')
#     all_files = ValidationFiles.ValidationFiles(ob, True)
#     all_files.write_validator_files()
#     os.chdir('../.')


# def generate_constraints(filename):
#     parser = ParseXML.ParseXML(filename)
#     ob = parser.parse_deviser_xml()
#     os.chdir('./temp')
#     all_files = ValidationFiles.ValidationFiles(ob, True)
#     all_files.write_constraints()
#     os.chdir('../.')


#############################################################################
# Specific compare functions

def compare_files(correct_file, temp_file):
    return test_functions.compare_files(correct_file, temp_file, fails,
                                        not_tested)


def compare_code_headers(class_name):
    correct_file = '.\\test-code\\{0}.h'.format(class_name)
    temp_file = '.\\temp\\{0}.h'.format(class_name)
    return compare_files(correct_file, temp_file)


def compare_ext_headers(class_name):
    correct_file = '.\\test-extension\\{0}.h'.format(class_name)
    temp_file = '.\\temp\\{0}.h'.format(class_name)
    return compare_files(correct_file, temp_file)


# What if folder slash wrong?
# def compare_code_impl(class_name):
#     correct_file = '.\\test-code\\{0}.java'.format(class_name)
#     temp_file = '.\\temp\\{0}.java'.format(class_name)
#     return compare_files(correct_file, temp_file)

def compare_code_impl(class_name):
    correct_file = '.{0}test-code{1}{2}.java'.format(os_sep, os_sep, class_name)
    temp_file = '.{0}temp{1}{2}.java'.format(os_sep, os_sep, class_name)
    return compare_files(correct_file, temp_file)


def compare_ext_impl(class_name, declared=False):
    if declared:
        correct_file = '.\\test-extension\\{0}Declared.cxx'.format(class_name)
        temp_file = '.\\temp\\{0}Declared.cxx'.format(class_name)
    else:
        correct_file = '.\\test-extension\\{0}.cpp'.format(class_name)
        temp_file = '.\\temp\\{0}.cpp'.format(class_name)
    return compare_files(correct_file, temp_file)


#############################################################################
# Specific test functions

#old
# def run_test(name, num, class_name, test_case, list_of):
#     filename = test_functions.set_up_test(name, class_name, test_case)
#     generate_new_java_files(filename, num)
#     # fail = compare_code_headers(class_name)
#     fail = compare_code_impl(class_name)
#     if len(list_of) > 0:
#         class_name = list_of
#         # fail += compare_code_headers(class_name)
#         fail += compare_code_impl(class_name)
#     print('')
#     return fail


def run_test(name, num, class_name, test_case):
    filename = test_functions.set_up_test(name, class_name, test_case)
    generate_new_java_files(filename, num)
    # fail = compare_code_headers(class_name)
    fail = compare_code_impl(class_name)
    print('')
    return fail


def run_ext_test(name, class_name, test_case, test):
    filename = test_functions.set_up_test(name, class_name, test_case)
    if test == 0:
        generate_extension_header(filename)
    elif test == 1:
        generate_types_header(filename)
    else:
        generate_fwd_header(filename)
    fail = compare_ext_headers(class_name)
    if test == 0:
        fail += compare_ext_impl(class_name)
    print('')
    return fail


def run_constant_test(name, constant_name, test_case):
    filename = test_functions.set_up_test(name, constant_name, test_case)
    generate_new_constant_java_files(filename)
    # fail = compare_code_headers(class_name)
    fail = compare_code_impl(constant_name)
    print('')
    return fail


def run_enum_test(name, num, enum_name, test_case):
    filename = test_functions.set_up_test(name, enum_name, test_case)
    generate_new_enum_java_files(filename, num)
    # fail = compare_code_headers(class_name)
    fail = compare_code_impl(enum_name)
    print('')
    return fail


def run_plug_test(name, class_name, test_case, num):
    filename = test_functions.set_up_test(name, class_name, test_case)
    generate_plugin_header(filename, num)
    # fail = compare_ext_headers(class_name)
    fail = compare_ext_impl(class_name)
    print('')
    return fail


def run_valid_test(name, class_name, test_case, is_ext=True):
    filename = test_functions.set_up_test(name, class_name, test_case)
    if is_ext:
        # generate_error_header(filename)
        fail = compare_ext_headers(class_name)
        fail += compare_ext_headers('{0}Table'.format(class_name))
    else:
        # generate_validator(filename)
        fail = compare_ext_headers(class_name)
        fail += compare_ext_impl(class_name)
    print('')
    return fail


def run_constraints_test(name, class_name, test_case):
    filename = test_functions.set_up_test(name, class_name, test_case)
    # generate_constraints(filename)
    fail = compare_ext_impl(class_name)
    fail += compare_ext_impl(class_name, declared=True)
    print('')
    return fail


#########################################################################
# Main function

def main():

    # set up the enivornment
    this_dir = os.path.dirname(os.path.abspath(__file__))
    (path_to_tests, other) = os.path.split(this_dir)
    test_functions.set_path_to_tests(path_to_tests)
    if not os.path.isdir('temp'):
        os.mkdir('temp')
    fail = 0

    # # run the individual tests
    # name = 'test_att'
    # num = 1
    # class_name = 'Unit'
    # list_of = ''
    # test_case = 'unit sid ref'
    # fail += run_test(name, num, class_name, test_case, list_of)
    #
    # name = 'test_att'
    # num = 2
    # class_name = 'MyLoTest'
    # list_of = 'ListOfMyLoTests'
    # test_case = 'attribute on ListOf'
    # fail += run_test(name, num, class_name, test_case, list_of)
    #
    # name = 'test_att'
    # num = 0
    # class_name = 'MyTestClass'
    # list_of = ''
    # test_case = 'all types of attributes'
    # fail += run_test(name, num, class_name, test_case, list_of)
    #
    # name = 'test_att'
    # num = 3
    # class_name = 'MyRequiredClass'
    # list_of = ''
    # test_case = 'all types attributes required'
    # fail += run_test(name, num, class_name, test_case, list_of)
    #
    # name = 'test_att'
    # num = 4
    # class_name = 'ArrayChild'
    # list_of = ''
    # test_case = 'child elements and arrays'
    # fail += run_test(name, num, class_name, test_case, list_of)
    #
    # name = 'test_att'
    # num = 5
    # class_name = 'Container'
    # list_of = ''
    # test_case = 'a listOf child that uses listOfFoo as the name'
    # fail += run_test(name, num, class_name, test_case, list_of)


    # TODO xml base elements



    # # TODO qual tests

    #TODO now there's a problem with this


    # # # # #All qual compile
    # # #Compiles
    # name = 'qual'
    # num = 0
    # class_name = 'QualitativeSpecies'
    # list_of = 'ListOfQualitativeSpecies'
    # test_case = 'an element on QualitativeSpecies'
    # fail += run_test(name, num, class_name, test_case)
    # #
    # # #
    #
    # #Compiles
    # name = 'qual'
    # num = 1
    # class_name = 'Transition'
    # list_of = 'ListOfTransition'
    # test_case = 'an element on Transition'
    # fail += run_test(name, num, class_name, test_case)
    # # # #
    # # # #
    # #Compiles
    # name = 'qual'
    # num = 2
    # class_name = 'Input'
    # list_of = 'ListOfInput'
    # test_case = 'an element on Input'
    # fail += run_test(name, num, class_name, test_case)
    # # # #
    # # # #
    # #Compiles
    # name = 'qual'
    # num = 3
    # class_name = 'Output'
    # list_of = 'ListOfOutput'
    # test_case = 'an element on Output'
    # fail += run_test(name, num, class_name, test_case)
    # #
    # #
    # #
    # # Compiles
    # name = 'qual'
    # num = 4
    # class_name = 'DefaultTerm'
    # list_of = 'ListOfDefaultTerm'
    # test_case = 'an element on DefaultTerm'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # # Compiles
    # name = 'qual'
    # num = 5
    # class_name = 'FunctionTerm'
    # list_of = 'ListOfFunctionTerm'
    # test_case = 'an element on FunctionTerm'
    # fail += run_test(name, num, class_name, test_case)
    # # #
    #
    #
    #
    # # Qual Enum Types
    # name = 'qual'
    # num = 0
    # enum_name = 'Sign'
    # test_case = 'an element on Sign Enum'
    # fail += run_enum_test(name, num, enum_name, test_case)
    #
    # name = 'qual'
    # num = 1
    # enum_name = 'TransitionOutputEffect'
    # test_case = 'an element on TransitionOutputEffect Enum'
    # fail += run_enum_test(name, num, enum_name, test_case)
    #
    # name = 'qual'
    # num = 2
    # enum_name = 'TransitionInputEffect'
    # test_case = 'an element on TransitionInputEffect Enum'
    # fail += run_enum_test(name, num, enum_name, test_case)
    #
    # # Qual Constants
    # name = 'qual'
    # constants_name = 'QualConstant'
    # test_case = 'Qual Constants'
    # fail += run_constant_test(name, constants_name, test_case)


    # #TESTING PhaSE
    name = 'qual'
    class_name = 'QualExtension'
    test_case = 'default typecodes extension file'
    fail += run_ext_test(name, class_name, test_case, 0)

    name = 'qual'
    num = 0
    class_name = 'QualModelPlugin'
    test_case = 'basic plugin'
    fail += run_plug_test(name, class_name, test_case, num)

    name = 'qual'
    num = 1
    class_name = 'QualSBMLDocumentPlugin'
    test_case = 'document plugin'
    fail += run_plug_test(name, class_name, test_case, num)



    #
    # # #
    # # # all pass
    # name = 'fbc_v2'
    # num = 0
    # class_name = 'FluxBound'
    # list_of = 'ListOfFluxBound'
    # test_case = 'an element on FluxBound'
    # fail += run_test(name, num, class_name, test_case)
    # #
    #
    # name = 'fbc_v2'
    # num = 1
    # class_name = 'Objective'
    # list_of = 'ListOfObjective'
    # test_case = 'an element on Objective'
    # fail += run_test(name, num, class_name, test_case)
    #
    # name = 'fbc_v2'
    # num = 2
    # class_name = 'FluxObjective'
    # list_of = 'ListOfFluxObjective'
    # test_case = 'an element on FluxObjective'
    # fail += run_test(name, num, class_name, test_case)
    #
    # # FBC Enum Types
    # name = 'fbc_v2'
    # num = 0
    # enum_name = 'FbcType'
    # test_case = 'an element on FbcType Enum'
    # fail += run_enum_test(name, num, enum_name, test_case)
    #
    # name = 'fbc_v2'
    # num = 1
    # enum_name = 'FbcOperation'
    # test_case = 'an element on FbcOperation Enum'
    # fail += run_enum_test(name, num, enum_name, test_case)
    #
    # # Qual Constants
    # name = 'fbc_v2'
    # constants_name = 'FbcConstants'
    # test_case = 'Fbc Constants'
    # fail += run_constant_test(name, constants_name, test_case)


    # # #
    # # # TODO dyn tests
    # # #Compilable
    # name = 'dyn'
    # num = 0
    # class_name = 'DynElement'
    # list_of = 'ListOfDynElement'
    # test_case = 'an element on DynElement'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # # TODO setSpatialIndex Error
    # name = 'dyn'
    # num = 1
    # class_name = 'SpatialComponent'
    # list_of = 'ListOfSpatialComponent'
    # test_case = 'an element on SpatialComponent'
    # fail += run_test(name, num, class_name, test_case)
    #
    # # Dyn Constants
    # name = 'dyn'
    # constants_name = 'DynConstants'
    # test_case = 'DynConstants'
    # fail += run_constant_test(name, constants_name, test_case)



    # #
    # # # # TODO distrib tests


    # # #Uncert unsetUncertML error
    # name = 'distrib'
    # num = 0
    # class_name = 'DrawFromDistribution'
    # list_of = 'ListOfDrawFromDistribution'
    # test_case = 'an element on DrawFromDistribution'
    # fail += run_test(name, num, class_name, test_case)
    #
    # # Compilable
    # name = 'distrib'
    # num = 1
    # class_name = 'DistribInput'
    # list_of = 'ListOfDistribInput'
    # test_case = 'an element on DistribInput'
    # fail += run_test(name, num, class_name, test_case)
    #
    # # #Uncert unsetUncertML error
    # name = 'distrib'
    # num = 2
    # class_name = 'Uncertainty'
    # list_of = 'ListOfUncertainty'
    # test_case = 'an element on Uncertainty'
    # fail += run_test(name, num, class_name, test_case)
    #
    # #Distrib constants
    # name = 'distrib'
    # constants_name = 'DistribConstants'
    # test_case = 'DistribConstants'
    # fail += run_constant_test(name, constants_name, test_case)



    # # # # TODO groups tests
    # # #
    # # Compilable
    # name = 'groups'
    # num = 0
    # class_name = 'Group'
    # list_of = 'ListOfGroup'
    # test_case = 'an element on Group'
    # fail += run_test(name, num, class_name, test_case)
    # #
    #
    # # Compilable
    # name = 'groups'
    # num = 1
    # class_name = 'Member'
    # list_of = 'ListOfMembern'
    # test_case = 'an element on Member'
    # fail += run_test(name, num, class_name, test_case)
    #
    # # Groups Enum Types
    # name = 'groups'
    # num = 0
    # enum_name = 'GroupKind'
    # test_case = 'an element on GroupKind Enum'
    # fail += run_enum_test(name, num, enum_name, test_case)
    #
    # #Groups constants
    # name = 'groups'
    # constants_name = 'GroupsConstants'
    # test_case = 'GroupsConstants'
    # fail += run_constant_test(name, constants_name, test_case)


    #
    #
    # TODO spatial tests
    # #Groups constants
    # name = 'spatial'
    # constants_name = 'SpatialConstants'
    # test_case = 'SpatialConstants'
    # fail += run_constant_test(name, constants_name, test_case)

    # name = 'spatial'
    # num = 0
    # class_name = 'DomainType'
    # list_of = 'ListOfDomainType'
    # test_case = 'an element on DomainType'
    # fail += run_test(name, num, class_name, test_case)



    # name = 'spatial'
    # num = 1
    # class_name = 'Domain'
    # list_of = 'ListOfDomain'
    # test_case = 'an element on Domain'
    # fail += run_test(name, num, class_name, test_case)
    # #
    # #
    # name = 'spatial'
    # num = 2
    # class_name = 'InteriorPoint'
    # list_of = 'ListOfInteriorPoint'
    # test_case = 'an element on InteriorPoint'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 3
    # class_name = 'Boundary'
    # list_of = 'ListOfBoundary'
    # test_case = 'an element on Boundary'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 4
    # class_name = 'AdjacentDomains'
    # list_of = 'ListOfAdjacentDomains'
    # test_case = 'an element on AdjacentDomains'
    # fail += run_test(name, num, class_name, test_case)
    # #
    # #
    # name = 'spatial'
    # num = 5
    # class_name = 'GeometryDefinition'
    # list_of = 'ListOfGeometryDefinition'
    # test_case = 'an element on GeometryDefinition'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 6
    # class_name = 'CompartmentMapping'
    # list_of = 'ListOfCompartmentMapping'
    # test_case = 'an element on CompartmentMapping'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 7
    # class_name = 'CoordinateComponent'
    # list_of = 'ListOfCoordinateComponent'
    # test_case = 'an element on CoordinateComponent'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 8
    # class_name = 'SampledFieldGeometry'
    # list_of = 'ListOfSampledFieldGeometry'
    # test_case = 'an element on SampledFieldGeometry'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    #
    # name = 'spatial'
    # num = 9
    # class_name = 'SampledField'
    # list_of = 'ListOfSampledField'
    # test_case = 'an element on SampledField'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    #
    # name = 'spatial'
    # num = 10
    # class_name = 'SampledVolume'
    # list_of = 'ListOfSampledVolume'
    # test_case = 'an element on SampledVolume'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    #
    # name = 'spatial'
    # num = 11
    # class_name = 'AnalyticGeometry'
    # list_of = 'ListOfAnalyticGeometry'
    # test_case = 'an element on AnalyticGeometry'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    #
    # name = 'spatial'
    # num = 12
    # class_name = 'AnalyticVolume'
    # list_of = 'ListOfAnalyticVolume'
    # test_case = 'an element on AnalyticVolume'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 13
    # class_name = 'ParametricGeometry'
    # list_of = 'ListOfParametricGeometry'
    # test_case = 'an element on ParametricGeometry'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 14
    # class_name = 'ParametricObject'
    # list_of = 'ListOfParametricObject'
    # test_case = 'an element on ParametricObject'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 15
    # class_name = 'CSGeometry'
    # list_of = 'ListOfCSGeometry'
    # test_case = 'an element on CSGeometry'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 16
    # class_name = 'CSGObject'
    # list_of = 'ListOfCSGObject'
    # test_case = 'an element on CSGObject'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 17
    # class_name = 'CSGNode'
    # list_of = 'ListOfCSGNode'
    # test_case = 'an element on CSGNode'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 18
    # class_name = 'CSGTransformation'
    # list_of = 'ListOfCSGTransformation'
    # test_case = 'an element on CSGTransformation'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 19
    # class_name = 'CSGTranslation'
    # list_of = 'ListOfCSGTranslation'
    # test_case = 'an element on CSGTranslation'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 20
    # class_name = 'CSGRotation'
    # list_of = 'ListOfCSGRotation'
    # test_case = 'an element on CSGRotation'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 21
    # class_name = 'CSGScale'
    # list_of = 'ListOfCSGScale'
    # test_case = 'an element on CSGScale'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 22
    # class_name = 'CSGHomogeneousTransformation'
    # list_of = 'ListOfCSGHomogeneousTransformation'
    # test_case = 'an element on CSGHomogeneousTransformation'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 23
    # class_name = 'TransformationComponents'
    # list_of = 'ListOfTransformationComponents'
    # test_case = 'an element on Transition'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 24
    # class_name = 'CSGPrimitive'
    # list_of = 'ListOfCSGPrimitive'
    # test_case = 'an element on CSGPrimitive'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 25
    # class_name = 'CSGPseudoPrimitive'
    # list_of = 'ListOfCSGPseudoPrimitive'
    # test_case = 'an element on CSGPseudoPrimitive'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 26
    # class_name = 'CSGSetOperator'
    # list_of = 'ListOfCSGSetOperator'
    # test_case = 'an element on CSGSetOperator'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 27
    # class_name = 'SpatialSymbolReference'
    # list_of = 'ListOfSpatialSymbolReference'
    # test_case = 'an element on SpatialSymbolReference'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 28
    # class_name = 'DiffusionCoefficient'
    # list_of = 'ListOfDiffusionCoefficient'
    # test_case = 'an element on DiffusionCoefficient'
    # fail += run_test(name, num, class_name, test_case)
    #
    # name = 'spatial'
    # num = 29
    # class_name = 'AdvectionCoefficient'
    # list_of = 'ListOfAdvectionCoefficient'
    # test_case = 'an element on AdvectionCoefficient'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 30
    # class_name = 'BoundaryCondition'
    # list_of = 'ListOfBoundaryCondition'
    # test_case = 'an element on BoundaryCondition'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 31
    # class_name = 'Geometry'
    # list_of = 'ListOfGeometry'
    # test_case = 'an element on Geometry'
    # fail += run_test(name, num, class_name, test_case)
    #
    #
    # name = 'spatial'
    # num = 32
    # class_name = 'CoordinateReference'
    # list_of = 'ListOfCoordinateReference'
    # test_case = 'an element on CoordinateReference'
    # fail += run_test(name, num, class_name, test_case)
    #
    # name = 'spatial'
    # num = 33
    # class_name = 'MixedGeometry'
    # list_of = 'ListOfMixedGeometry'
    # test_case = 'an element on MixedGeometry'
    # fail += run_test(name, num, class_name, test_case)
    #
    # name = 'spatial'
    # num = 34
    # class_name = 'OrdinalMapping'
    # list_of = 'ListOfOrdinalMapping'
    # test_case = 'an element on OrdinalMapping'
    # fail += run_test(name, num, class_name, test_case)
    #
    # name = 'spatial'
    # num = 35
    # class_name = 'SpatialPoints'
    # list_of = 'ListOfSpatialPoints'
    # test_case = 'an element on SpatialPoints'
    # fail += run_test(name, num, class_name, test_case)

    #
    #
    #
    #
    # # TODO original Tests
    # # name = 'qual'
    # # num = 5
    # # class_name = 'FunctionTerm'
    # # list_of = 'ListOfFunctionTerms'
    # # test_case = 'an element on ListOf'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    #
    # # name = 'qual'
    # # num = 3
    # # class_name = 'Output'
    # # list_of = 'ListOfOutputs'
    # # test_case = 'simple class'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'qual'
    # # num = 1
    # # class_name = 'Transition'
    # # list_of = 'ListOfTransitions'
    # # test_case = 'class with child list of elements'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'qual'
    # # class_name = 'QualExtension'
    # # test_case = 'basic extension file'
    # # fail += run_ext_test(name, class_name, test_case, 0)
    # #

    # #
    # # name = 'qual'
    # # class_name = 'QualExtensionTypes'
    # # test_case = 'the types '
    # # fail += run_ext_test(name, class_name, test_case, 1)
    # #
    # # name = 'qual'
    # # class_name = 'qualfwd'
    # # test_case = 'forward declarations '
    # # fail += run_ext_test(name, class_name, test_case, 2)
    # #


    # #
    # # name = 'qual'
    # # class_name = 'QualSBMLError'
    # # test_case = 'error enumeration '
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'qual'
    # # class_name = 'QualConsistencyValidator'
    # # test_case = 'validator'
    # # fail += run_valid_test(name, class_name, test_case, False)
    #
    #
    #
    #
    #
    #
    # # name = 'distrib'
    # # num = 2
    # # class_name = 'Uncertainty'
    # # list_of = ''
    # # test_case = 'class with other child'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 7
    # # class_name = 'CoordinateComponent'
    # # list_of = 'ListOfCoordinateComponents'
    # # test_case = 'class with same child element diff name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 17
    # # class_name = 'CSGNode'
    # # list_of = 'ListOfCSGNodes'
    # # test_case = 'abstract'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 35
    # # class_name = 'SpatialPoints'
    # # list_of = ''
    # # test_case = 'array type'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 8
    # # class_name = 'SampledFieldGeometry'
    # # list_of = ''
    # # test_case = 'non sbase base class'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 9
    # # class_name = 'SampledField'
    # # list_of = ''
    # # test_case = 'additional code files'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 18
    # # class_name = 'CSGTransformation'
    # # list_of = ''
    # # test_case = 'abstract non base class'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 3
    # # class_name = 'Boundary'
    # # list_of = ''
    # # test_case = 'overwrites element name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 13
    # # class_name = 'ParametricGeometry'
    # # list_of = ''
    # # test_case = 'child element and child lo_element'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 12
    # # class_name = 'AnalyticVolume'
    # # list_of = 'ListOfAnalyticVolumes'
    # # test_case = 'class with math child'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 33
    # # class_name = 'MixedGeometry'
    # # list_of = ''
    # # test_case = 'class with math child'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 26
    # # class_name = 'CSGSetOperator'
    # # list_of = ''
    # # test_case = 'contains list of that has abstracts that are abstract'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'spatial'
    # # num = 1
    # # class_name = 'SpatialCompartmentPlugin'
    # # test_case = 'plugin with child element'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'spatial'
    # # num = 3
    # # class_name = 'SpatialParameterPlugin'
    # # test_case = 'plugin with additional code'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'spatial'
    # # num = 4
    # # class_name = 'SpatialReactionPlugin'
    # # test_case = 'plugin only attributes'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'spatial'
    # # num = 5
    # # class_name = 'SpatialSBMLDocumentPlugin'
    # # test_case = 'include line over extends'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'spatial'
    # # class_name = 'SpatialConsistencyConstraints'
    # # test_case = 'constraints'
    # # fail += run_constraints_test(name, class_name, test_case)
    # #
    # # name = 'spatial'
    # # class_name = 'SpatialValidator'
    # # test_case = 'validator'
    # # fail += run_valid_test(name, class_name, test_case, False)
    # #
    # # name = 'groups'
    # # num = 1
    # # class_name = 'Member'
    # # list_of = 'ListOfMembers'
    # # test_case = 'list of with attribute'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'groups'
    # # num = 0
    # # class_name = 'GroupsModelPlugin'
    # # test_case = 'plugin with additional code'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'test_vers'
    # # num = 0
    # # class_name = 'ClassOne'
    # # list_of = ''
    # # test_case = 'multiple versions'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'test_vers'
    # # num = 2
    # # class_name = 'BBB'
    # # list_of = ''
    # # test_case = 'multiple versions same child lo'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'test_vers'
    # # num = 0
    # # class_name = 'VersModelPlugin'
    # # test_case = 'versions of plugins - attributes'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'test_vers'
    # # num = 1
    # # class_name = 'VersSpeciesPlugin'
    # # test_case = 'versions of plugins - elements'
    # # fail += run_plug_test(name, class_name, test_case, num)
    # #
    # # name = 'test_vers'
    # # class_name = 'VersExtension'
    # # test_case = 'multi version extension file'
    # # fail += run_ext_test(name, class_name, test_case, 0)
    # #
    # # name = 'fbc_v2'
    # # num = 5
    # # class_name = 'FbcAnd'
    # # list_of = ''
    # # test_case = 'inline_lo_element'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'test_child'
    # # num = 0
    # # class_name = 'MySEDClass'
    # # list_of = ''
    # # test_case = 'different language'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'base_class'
    # # num = 0
    # # class_name = 'MyBase'
    # # list_of = ''
    # # test_case = 'class with no given base class'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'base_class'
    # # num = 1
    # # class_name = 'ClassTwo'
    # # list_of = 'ListOfClassTwos'
    # # test_case = 'class with lower case name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'base_class'
    # # num = 2
    # # class_name = 'ClassThree'
    # # list_of = ''
    # # test_case = 'class with enum lower case name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'base_class'
    # # class_name = 'TestExtension'
    # # test_case = 'default typecodes extension file'
    # # fail += run_ext_test(name, class_name, test_case, 0)
    # #
    # # name = 'unknown_type'
    # # num = 0
    # # class_name = 'UnknownType'
    # # list_of = ''
    # # test_case = 'class using an unknown attribute type'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'test_sidrefs'
    # # class_name = 'RefsSBMLError'
    # # test_case = 'sidref with multiple targets '
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'test_sidrefs_1'
    # # class_name = 'RefsSBMLError'
    # # test_case = 'sidref with multiple targets - diff spacing'
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'test_sidrefs_2'
    # # class_name = 'RefsSBMLError'
    # # test_case = 'sidref with multiple targets - diff spacing'
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'test_sidrefs_3'
    # # class_name = 'RefsSBMLError'
    # # test_case = 'sidref with multiple targets - diff spacing'
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'test_sidrefs_4'
    # # class_name = 'RefsSBMLError'
    # # test_case = 'sidref with multiple targets - diff spacing'
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'test_lists'
    # # class_name = 'FooSBMLError'
    # # test_case = 'error enumeration '
    # # fail += run_valid_test(name, class_name, test_case)
    # #
    # # name = 'nasty_lists'
    # # num = 0
    # # class_name = 'Child'
    # # list_of = ''
    # # test_case = 'non uniform listOf name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'nasty_lists'
    # # num = 2
    # # class_name = 'Parent'
    # # list_of = ''
    # # test_case = 'non uniform listOf name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'nasty_lists_alt1'
    # # num = 2
    # # class_name = 'Parent'
    # # list_of = ''
    # # test_case = 'non uniform listOf name'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'lo_children'
    # # num = 1
    # # class_name = 'ContainerX'
    # # list_of = ''
    # # test_case = 'variants of lo child elements and differing api/xml names'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #sbml
    # # name = 'xml_names'
    # # num = 0
    # # class_name = 'Fred'
    # # list_of = ''
    # # test_case = 'attribute xml names differ'
    # # fail += run_test(name, num, class_name, test_case, list_of)
    # #
    # # name = 'xml_names'
    # # num = 1
    # # class_name = 'Other'
    # # list_of = ''
    # # test_case = 'element xml names differ'
    # # fail += run_test(name, num, class_name, test_case, list_of)

    test_functions.report('JAVA', fail, fails, not_tested)
    return fail

if __name__ == '__main__':
    main()
