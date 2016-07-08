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


from util import query, strFunctions, global_variables, insideJSBML_parser
import itertools
import random

# Determine override or or deprecated
def determine_override_or_deprecated(jsbml_methods, function, attribute= None, return_type=None, att_type=None):
    # TODO write_set  implementation of return_type definition DONE
    add = None
    class_key = None
    functionArgs = None
    for key in list(jsbml_methods.keys()):
        for method in jsbml_methods[key]:
            if function == method['functionName']:
                class_key = key
                if method['isAbstract'] is True:
                    if att_type is not None and att_type in method['functionArgs']:
                        functionArgs = method['functionArgs']

                    add = 'Override'
    # if attribute['type'] == 'SIdRef':
    #     add = 'Override'
    # else:
    #     add = None
    return add, class_key, functionArgs


def get_javadoc_comments_and_state(additional_add, class_key, function, functionArgs):
    if additional_add is not None:
        title_line = '(non-Javadoc)--'
        title_line += '@see org.sbml.jsbml.{0}#{1}'.format(class_key, function)
    return title_line



def javap_arg_parser(argument):
    arg = argument
    # print('argus ',arg)
    arg_type = None
    if len(arg)>1:
        pass
    else:
        arg_type = arg[0].split('.')[-1]
        # print('arg_type ', arg_type)
    return arg_type

def find_function_with_diff_args(jsbml_methods, attribute, function ):
    # print('function ', function)
    # print('arguments ', attribute['attTypeCode'])
    orginal_attType = str(attribute['attTypeCode'])[:]
    function_name = str(function)[:]
    curr_attribute = attribute
    jsbml_methods = jsbml_methods

    method_to_write = None

    for key in list(jsbml_methods.keys()):
        for method in jsbml_methods[key]:
            if function_name == method['functionName']:
                # print("YAHSHDASD", method)
                arg_type = javap_arg_parser(method['functionArgs'])[:]
                if arg_type is not None:
                    if arg_type != orginal_attType:
                        method_to_write = [arg_type, method]

    # print('tada ',method_to_write)
    return method_to_write



# Function for prime number generator
def erat2( ):
    D = {  }
    yield 2
    for q in itertools.islice(itertools.count(3), 0, None, 2):
        p = D.pop(q, None)
        if p is None:
            D[q*q] = q
            yield q
        else:
            x = p + q
            while x in D or not (x&1):
                x += p
            D[x] = p


# Generate prime number using sieve algorithm
# param n - generate numbers of prime numbers,
def generate_prime_numbers(n):
    """ Input n>=6, Returns a list of primes, 2 <= p < n """
    return list(itertools.takewhile(lambda p: p<n, erat2()))


def select_prime_number(prime_numbers):
    return random.choice(prime_numbers)

# tada = generate_prime_numbers(3000000)
# print(tada)


