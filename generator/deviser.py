#!/usr/bin/env python
#
# @file    deviser.py
# @brief   command line tool for invoking the deviser scripts
# @author  Frank Bergmann
# @author  Sarah Keating
#
# <!--------------------------------------------------------------------------
#
# Copyright (c) 2013-2018 by the California Institute of Technology
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
#


import sys

try:
    from util import generateLatex, generateCode, global_variables
except Exception as e:
    print('Error is ', e)
    from util import global_variables
    global_variables.code_returned = global_variables.return_codes['unknown error - please report']
#from legacy import run


def generatePackageFor(filename, language = 'sbml'):
    """This function generates a libSBML extension for the given filename"""
    generateCode.generate_code_for(filename, language,True)


#def generateLegacyPackageFor(filename):
#    """This function generates a libSBML extension for the given filename
#       using the legacy code"""
#    run.generatePackageForFile(filename)


def generateLaTeXFor(filename):
    """This function generates a LaTeX scaffold for the given filename"""
    generateLatex.generateLatexFor(filename)


def main(args):
    """Usage: deviser  [--generate | --latex ] input-filename
       This program will use a Deviser xml file, and generate either a C++
       libSBML extionsion for it, or generate a LaTeX scaffold for its
       specification.
    """

    # reset the global return code as this is a new call to deviser
    global_variables.code_returned = global_variables.return_codes['success']

    if len(args) != 3:
        global_variables.code_returned = \
            global_variables.return_codes['missing function argument']
        print(main.__doc__)

    if global_variables.code_returned == \
            global_variables.return_codes['success']:

        operation = args[1].lower()
        filename = args[2]

#        if operation == '--legacy' or operation == '-gl':
#            generateLegacyPackageFor(filename)
        if operation == '--generate' or operation == '-g':
            language = 'sbml'
            generatePackageFor(filename,language)
        elif operation == '--generatejsbml' or operation == '-gj':
            language = 'jsbml'
            generatePackageFor(filename,language)
        elif operation == '--latex' or operation == '-l':
            generateLaTeXFor(filename)
        else:
            global_variables.code_returned = \
                global_variables.return_codes['invalid function arguments']
            print(main.__doc__)

    return global_variables.code_returned

if __name__ == '__main__':
    if global_variables.code_returned == \
            global_variables.return_codes['success']:
        try:
            main(sys.argv)
            sys.exit(global_variables.code_returned)
        except Exception as ex:
            print('\nAn exception was raised while running deviser: \"{}\"'.format(ex))
            sys.exit(global_variables.code_returned)
    else:
        sys.exit(global_variables.code_returned)
