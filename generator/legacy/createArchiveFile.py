#!/usr/bin/env python
#
# @file    createArchive File.py
# @brief   creates the windows batch file to zip the code
# @author  Frank Bergmann
# @author  Sarah Keating
#
# <!--------------------------------------------------------------------------
#
# Copyright (c) 2013-2014 by the California Institute of Technology
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

import sys
import os
import fileHeaders
import strFunctions

	
def main(name):
	capName = name.upper()
	uname = strFunctions.cap(name)
	codeName = 'create-zip-{0}.bat'.format(name)
	fileOut = open(codeName, 'w')
	fileOut.write('@ echo off\n')
	fileOut.write('REM \n')
	fileOut.write('REM This script creates a source archive for the {0} package\n'.format(uname))
	fileOut.write('REM \n\n')
	fileOut.write('SET THIS_DIR=%~dp0\n')
	fileOut.write('SET PACKAGE_NAME={0}\n'.format(name))
	fileOut.write('set VERSION=%PACKAGE_NAME%-5.8.0-beta-1\n')
	fileOut.write('SET DIST_DIR=%~dp0\%VERSION%\n')
	fileOut.write('SET PACKAGE_DIR=%~dp0\%PACKAGE_NAME%\n\n')
	fileOut.write('SET ZIP=%THIS_DIR%\\bin\zip --out "..\%VERSION%.zip" -9 -r \n\n')
	fileOut.write('IF NOT EXIST "%PACKAGE_DIR%" goto NO_DIR\n\n')
	fileOut.write('IF EXIST "%THIS_DIR%\\temp" goto TEMP_CREATED\n')
	fileOut.write('mkdir "%THIS_DIR%\\temp"\n')
	fileOut.write(':TEMP_CREATED\n\n')
	fileOut.write('IF EXIST "%DIST_DIR%" goto CREATED\n')
	fileOut.write('mkdir "%DIST_DIR%"\n')
	fileOut.write(':CREATED\n\n')
	fileOut.write('cd /d %DIST_DIR%\n')
	fileOut.write('mkdir src\n')
	fileOut.write('mkdir src\sbml\n')
	fileOut.write('mkdir src\sbml\packages\n')
	fileOut.write('mkdir src\sbml\packages\%PACKAGE_NAME%\n')
	fileOut.write('mkdir src\sbml\packages\%PACKAGE_NAME%\common\n')
	fileOut.write('mkdir src\sbml\packages\%PACKAGE_NAME%\extension\n')
	fileOut.write('mkdir src\sbml\packages\%PACKAGE_NAME%\sbml\n\n')
	fileOut.write('copy /y %PACKAGE_DIR%\%PACKAGE_NAME%-package.cmake .\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\%PACKAGE_NAME%-package.cmake src\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\sbml\\packages\\%PACKAGE_NAME%-register* src\sbml\packages\n\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\sbml\\packages\\%PACKAGE_NAME%\\common\*.h      src\sbml\packages\%PACKAGE_NAME%\common\\\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\sbml\\packages\\%PACKAGE_NAME%\\extension\*.h   src\sbml\packages\%PACKAGE_NAME%\extension\\\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\sbml\\packages\\%PACKAGE_NAME%\\extension\*.cpp src\sbml\packages\%PACKAGE_NAME%\extension\\\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\sbml\\packages\\%PACKAGE_NAME%\\sbml\*.h        src\sbml\packages\%PACKAGE_NAME%\sbml\\\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\sbml\\packages\\%PACKAGE_NAME%\\sbml\*.cpp      src\sbml\packages\%PACKAGE_NAME%\sbml\\\n\n')
	fileOut.write('mkdir src\\bindings\n')
	fileOut.write('mkdir src\\bindings\\csharp\n')
	fileOut.write('mkdir src\\bindings\\java\n')
	fileOut.write('mkdir src\\bindings\\javascript\n')
	fileOut.write('mkdir src\\bindings\\perl\n')
	fileOut.write('mkdir src\\bindings\\php\n')
	fileOut.write('mkdir src\\bindings\\python\n')
	fileOut.write('mkdir src\\bindings\\r\n')
	fileOut.write('mkdir src\\bindings\\ruby\n')
	fileOut.write('mkdir src\\bindings\\swig\n\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\csharp\*.i    src\\bindings\\csharp\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\java\*.i      src\\bindings\\java\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\javascript\*.cpp    src\\bindings\\javascript\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\javascript\*.i      src\\bindings\\javascript\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\perl\*.cpp    src\\bindings\\perl\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\perl\*.i      src\\bindings\\perl\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\php\*.cpp    src\\bindings\\php\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\php\*.i      src\\bindings\\php\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\python\*.cpp  src\\bindings\\python\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\python\*.i    src\\bindings\\python\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\r\*.cpp       src\\bindings\\r\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\r\*.i         src\\bindings\\r\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\ruby\*.cpp    src\\bindings\\ruby\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\ruby\*.i      src\\bindings\\ruby\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\swig\*.i      src\\bindings\\swig\n')
	fileOut.write('copy /y %PACKAGE_DIR%\src\\bindings\\swig\*.h      src\\bindings\\swig\n\n')
	fileOut.write(':COPY_COMPLETE\n\n')
	fileOut.write('cd /d %DIST_DIR%\n')
	fileOut.write('echo. \n')
	fileOut.write('echo creating archive with: %ZIP% *.cmake src\n')
	fileOut.write('echo.\n')
	fileOut.write('%ZIP% *.cmake src\n\n')
	fileOut.write('goto DONE\n\n')
	fileOut.write(':NO_DIR\n')
	fileOut.write('echo. \n')
	fileOut.write('echo The package directory %PACKAGE_DIR% could not be found. \n') 
	fileOut.write('echo.\n\n')
	fileOut.write(':DONE\n')
	fileOut.write('cd /d %THIS_DIR%\n')
	fileOut.write('rd /s /q %DIST_DIR%\n\n')
	fileOut.write('REM UNSET VARIABLES\n')
	fileOut.write('SET THIS_DIR=\n')
	fileOut.write('SET PACKAGE_NAME=\n')
	fileOut.write('set VERSION=\n')
	fileOut.write('SET DIST_DIR=\n')
	fileOut.write('SET PACKAGE_DIR=\n')
	fileOut.write('SET ZIP=\n\n')