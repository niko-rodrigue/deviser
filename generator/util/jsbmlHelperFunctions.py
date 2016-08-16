#!/usr/bin/env python
#
# @file    JavaCodeFile.py
# @brief   class for generating code file for the given class
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

try:
    from . import query, strFunctions, global_variables, insideJSBML_parser
except:
    import query, strFunctions, global_variables, insideJSBML_parser

import itertools
import random
import uuid


#########################################################################

# Generate javadoc comment line
def get_javadoc_comments_and_state(additional_add, class_key, function, function_args, duplicate_attribute=None):
    if additional_add is not None:
        title_line = '(non-Javadoc)--'
        if function_args is not None and function_args != [] and duplicate_attribute is None:
            if len(function_args) == 1:
                arguments = function_args[0]
            elif len(function_args) > 1:
                arguments = function_args[0]
                for i in range(1, len(function_args)):
                    arguments += ', {0}'.format(function_args[1])
        elif duplicate_attribute is not None:
            # arguments = '{0}'.format(functionArgs[1])
            function_args = duplicate_attribute['functionArgs']
            if len(function_args) == 1:
                arguments = function_args[0]
            elif len(function_args) > 1:
                arguments = function_args[0]
                for i in range(1, len(function_args)):
                    arguments += ', {0}'.format(function_args[1])
        else:
            arguments = ''
        title_line += '@see org.sbml.jsbml.{0}#{1}({2})'.format(class_key, function, arguments)
    return title_line


#########################################################################


# Determine override # or deprecate(not implemented yet)
def determine_override_or_deprecated(jsbml_methods, function, attribute=None, return_type=None):
    # This is problematic
    add = None
    class_key = None
    functionArgs = None

    attribute = attribute
    if attribute is not None:
        att_type = attribute['JClassType']
    else:
        att_type = None

    keys_list = sorted(list(jsbml_methods.keys()))
    found_object = False
    for key in keys_list:
        # if found_object is True:
        #     break
        for method in jsbml_methods[key]:
            if function == method['functionName']:
                class_key = key
                # found_object = True
                if method['isAbstract'] is True:
                    functionArgs = []
                    if att_type is not None:
                        for argument in method['functionArgs']:
                            if att_type in argument:
                                functionArgs.append(argument)

                    add = 'Override'

    return add, class_key, functionArgs


#########################################################################


# Detect is ASTNode or XMLNode in attributes
def detect_ast_or_xml(attributes):
    for attribute in attributes:
        if attribute['JClassType'] == 'ASTNode' or attribute['JClassType'] == 'XMLNode':
            return True
    return False


#########################################################################



# Find if there is an instance version  of the method with same name
def find_instance_method(abstract_jsbml_methods, method_name):
    for interface_class in abstract_jsbml_methods:
        methods = abstract_jsbml_methods[interface_class]
        # if method_name in list(methods):
        #     return True
        for method in methods:
            try:
                if method_name == method['functionName']:
                    return True
            except:
                continue
                # print(interface_class)
                # if method_name ==
    return False


#########################################################################



# For the detection of abstract methods from jsbml_methods
def detect_abstract_methods(jsbml_data_tree, jsbml_methods):
    abstract_methods = {}
    for method_name in jsbml_methods:
        module = jsbml_data_tree[method_name]
        is_interface = module['isInterface']

        if is_interface == True:
            try:
                length = len(jsbml_methods[method_name])
            except Exception as e:
                length = 0
            if length == 0:
                # print('method name ', method_name)
                temp = insideJSBML_parser.get_class_information(method_name)
                # print(temp)
                new_length = len(temp['modules'])
                while new_length == 0:
                    new_method = temp['extends']['extendsShort']
                    temp = insideJSBML_parser.get_class_information(new_method)
                    new_length = len(temp['modules'])
                    if new_length > 0:
                        # print(temp)
                        abstract_methods.update({method_name: temp})
            else:
                abstract_methods.update({method_name: jsbml_methods[method_name]})

    return abstract_methods


########################################################################################################################

# Helper function for find_function_with_diff_args
# get argument type
# E.g. 'org.sbml.jsbml.Compartment' -> Compartment
def javap_arg_parser(argument):
    arg = argument
    arg_type = None
    if len(arg) > 1:
        pass
    else:
        arg_type = arg[0].split('.')[-1]
    return arg_type


# For finding functions with same name,but take different arguments
def find_function_with_diff_args(jsbml_methods, attribute, function):
    orginal_attType = str(attribute['attTypeCode'])[:]
    function_name = str(function)[:]
    curr_attribute = attribute
    jsbml_methods = jsbml_methods

    method_to_write = None

    for key in list(jsbml_methods.keys()):
        for method in jsbml_methods[key]:
            if function_name == method['functionName']:

                arg_type = javap_arg_parser(method['functionArgs'])[:]
                if arg_type is not None:
                    if arg_type != orginal_attType:
                        method_to_write = [arg_type, method]


    return method_to_write


#########################################################################


# Function for prime number generator
def erat2():
    d = {}
    yield 2
    for q in itertools.islice(itertools.count(3), 0, None, 2):
        p = d.pop(q, None)
        if p is None:
            d[q * q] = q
            yield q
        else:
            x = p + q
            while x in d or not (x & 1):
                x += p
            d[x] = p


# Generate prime number using sieve algorithm
# param n - generate numbers of prime numbers,
def generate_prime_numbers(n):
    """ Input n>=6, Returns a list of primes, 2 <= p < n """
    return list(itertools.takewhile(lambda p: p < n, erat2()))


# Select a prime number from generated list of prime numbers
def select_prime_number(prime_numbers, run_tests=False):
    # if run_tests is True then set seed to 0
    if run_tests is True:
        random.seed(0)
    return random.choice(prime_numbers)


#########################################################################

# Generate random UUID using uuid4 from Pythons' library
def generate_uuid(run_tests=False):
    if run_tests is True:
        # random.seed(0)
        value = '9891207272440019'
    else:
        # Possible solution
        # http://stackoverflow.com/questions/24796654/python-uuid4-how-to-limit-the-length-of-unique-chars
        # value = uuid.uuid4().int & 0xFFFFFFFFFFFFFFFF # 64bit
        value = uuid.uuid4().int & 0xFFFFFFFFFFFFFF  # 56 bit
    return value

# uid = generate_uuid()
# print(uid)

# tada = generate_prime_numbers(3000000)
# print(tada)
