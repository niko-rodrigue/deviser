#!/usr/bin/env python
#
# @file    BaseTexFile.py
# @brief   base class for all tex files to be generated
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


from . import BaseFile
from util import strFunctions


class BaseTexFile(BaseFile.BaseFile):
    """Common base class for all LaTeX files"""

    def __init__(self, name, extension, object_desc):
        BaseFile.BaseFile.__init__(self, name, extension)

        # change the comment delimiter and line length
        self.comment = '%'
        self.line_length = 72

        self.package = object_desc['name']
        self.fullname = object_desc['fullname']
        self.sbml_classes = object_desc['baseElements']
        self.offset = object_desc['offset']
        self.plugins = object_desc['plugins']
        self.enums = object_desc['enums']
        self.level = object_desc['base_level']
        self.version = object_desc['base_version']
        self.pkg_version = object_desc['pkg_version']
        if object_desc['required']:
            self.reqd_status = 'true'
        else:
            self.reqd_status = 'false'

        self.prim_class = []

        self.start_b = '{'
        self.end_b = '}'

        # expand the information for the classes
        self.fulltexname = strFunctions.texify(self.fullname)
        self.upper_package = strFunctions.upper_first(self.package)
        self.sort_class_names(self.sbml_classes)
        self.sort_attribute_names(self.sbml_classes)
        self.sort_enum_names(self.enums)

        self.full_pkg_command = '\\{0}Package'.format(self.fulltexname)
        self.brief_pkg_command = '\\{0}'.format(self.upper_package)

    ########################################################################

    # function to create texnames for classes
    def sort_class_names(self, classes):
        if classes is not None:
            for i in range(0, len(classes)):
                name = classes[i]['name']
                texname = strFunctions.texify(name)
                classes[i]['texname'] = texname
                # hack for render
                if name == 'Ellipse' or name == 'Rectangle':
                    texname = 'Render' + name
                    classes[i]['texname'] = texname
                if name == 'RelAbsVector':
                    self.prim_class.append(classes[i])

    # function to create texnames for attributes
    @staticmethod
    def sort_attribute_names(classes):
        if classes is not None:
            for i in range(0, len(classes)):
                attribs = classes[i]['attribs']
                for j in range(0, len(attribs)):
                    if attribs[j]['type'] == 'lo_element' or attribs[j]['type'] == 'element':
                        name = attribs[j]['element']
                    else:
                        name = attribs[j]['name']
                    texname = strFunctions.texify(name)
                    attribs[j]['texname'] = texname
            for i in range(0, len(classes)):
                if 'lo_attribs' in classes[i]:
                    lo_attribs = classes[i]['lo_attribs']
                    for j in range(0, len(lo_attribs)):
                        if lo_attribs[j]['type'] == 'lo_element' or lo_attribs[j]['type'] == 'element':
                            name = lo_attribs[j]['element']
                        else:
                            name = lo_attribs[j]['name']
                        texname = strFunctions.texify(name)
                        lo_attribs[j]['texname'] = texname

    # function to create texnames for enums
    @staticmethod
    def sort_enum_names(enums):
        if enums is not None:
            for i in range(0, len(enums)):
                name = enums[i]['name']
                texname = strFunctions.texify(name)
                enums[i]['texname'] = texname

    # function to write a to do into text
    def write_to_do(self, text):
        self.write_line('\\TODO{0}{1}{2}'.format(self.start_b, text,
                                                 self.end_b))
        self.skip_line()

    # need to overwrite the write_line function to not add indents
    def write_line(self, line, space=0):
        self.write_line_no_indent(line)