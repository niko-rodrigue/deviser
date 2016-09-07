#!/usr/bin/env python
#
# @file    getJSBML_data.py
# @brief   extract JSBML classes and store with pickle
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

import os
import sys

try:
    import cPickle as pickle
except:
    import pickle

import json

file_path = os.path.dirname(os.path.abspath(__file__))

py2_pickle = 'jsbml_parsed_data_py2.pickle'
py3_pickle = 'jsbml_parsed_data_py3.pickle'

json_file = 'jsbml_parsed_data.json'


def extract_json_data():
    open_file = json_file

    file_to_open = file_path + os.sep + open_file
    jsbml_parsed_data = json.load(open(file_to_open, "r"))
    return jsbml_parsed_data


def extract_pickle_data():
    python_version = sys.version_info
    if python_version[0] == 3:
        open_file = py3_pickle
    elif python_version[0] == 2:
        open_file = py2_pickle

    file_to_open = file_path + os.sep + open_file
    jsbml_parsed_data = pickle.load(open(file_to_open, "rb"))
    return jsbml_parsed_data
