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
import time
import subprocess as sub



file_path = os.path.dirname(os.path.abspath(__file__))
jsbml_jar = 'jsbml-1.1-with-dependencies.jar'

curr_dir = os.getcwd()




def get_class_information(class_name=None, individual_run=False):
    if class_name == 'AbstractSBasePlugin':
        # class_name = 'org.sbml.jsbml.ext.{0}'.format(class_name)
        return
    else:
        class_name = 'org.sbml.jsbml.{0}'.format(class_name)

    # Old version
    # command = 'javap -cp {0}{1}{2} -package {3}'.format(file_path, os.sep, jsbml_jar, class_name)

    # TODO inside JSBML parser debugging test
    # comm1 = 'javap_wrong'

    comm1 = 'javap'
    comm2 = '-cp'
    comm3 = '{0}{1}{2}'.format(file_path, os.sep, jsbml_jar)
    comm4 = '-package'
    comm5 = '{0}'.format(class_name)
    total_command = [comm1, comm2, comm3, comm4, comm5]

    try:
        class_info = sub.Popen(total_command, stdout=sub.PIPE, stderr=sub.PIPE)
        stdout, stderr = class_info.communicate()

        if stdout:
            # For debugging purposes
            # print(stdout)
            stdout_value = stdout.decode()  # decode("utf-8")
            class_output = stdout_value.split('\n')
            dict_data = parse_output(class_output)
            return dict_data
        elif stderr:
            error_txt = stderr.decode()
            # print('ERROR is', error_txt)
            if 'Error: class not found:' in error_txt:
                return
            else:
                print('Check if Java SDK is installed, deviser requires javap')
                sys.exit(0)
    except Exception as error:
        print('Error is ', error)
        print('Check if Java SDK is installed, deviser requires javap')
        sys.exit(0)

# For testing purposes

# class_name = 'org.sbml.jsbml.AbstractNamedSBase'

# class_name = 'CompartmentalizedSBase'

# class_name = 'Compartment'
# class_name = 'SBaseWithDerivedUnit'
# class_name = 'NamedSBaseWithDerivedUnit'

# class_name = 'UniqueNamedSBase'


# TODO for individual tests of javap parser
# #Exist but no data
# class_name = 'AbstractSBasePlugin'
# data = get_class_information(class_name, individual_run=True)
# print(data)

# data = get_class_information(class_name, individual_run=True)
# print(data)
