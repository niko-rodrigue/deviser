#!/usr/bin/env python
#
# @file    JavaEnumFiles.py
# @brief   class for generating java enum files.
# @author  Hovakim Grabski  Google Summer of Code 2016
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

import copy
from . import JavaEnumCodeFile
from util import strFunctions, query, global_variables


class JavaEnumFiles():
    """Class for all Java files"""

    def __init__(self, enum_object, original_package, verbose=False):
        # members from object
        self.enum_object = enum_object
        self.original_package = original_package

        self.verbose = verbose

    def write_files(self):
        # self.write_header(self.class_object)
        self.write_code(self.enum_object, self.original_package)

    # Write list enum files
    def write_list_enum_files(self):
        self.write_list_enum_code(self.enum_object, self.original_package)

    # Write java enum files
    def write_code(self, enum_object, original_object):
        fileout = JavaEnumCodeFile.JavaEnumCodeFile(enum_object, original_object)
        if self.verbose:
            print('Writing file {0}'.format(fileout.filename))
            print('---' * 10)
        fileout.write_file()
        fileout.close_file()

    # Write java list enum files
    def write_list_enum_code(self, enum_object, original_object):
        fileout = JavaEnumCodeFile.JavaEnumCodeFile(enum_object, original_object)
        if self.verbose:
            print('Writing file {0}'.format(fileout.filename))
            print('---' * 10)
        fileout.write_list_enum_file()
        fileout.close_file()
