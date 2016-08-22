##Deviser


## Google Summer of Code 2016


*Fork Author*:      [Hovakim Grabski](https://github.com/hovo1990)

*Fork Repository*:   [https://github.com/hovo1990/deviser](https://github.com/hovo1990/deviser)

## Fork Background ##

Computation modeling has become a crucial aspect of biological research, and [SBML](http://sbml.org) (the Systems Biology Markup Language) has become the de facto standard open format for exchanging models between software tools in systems biology.

Since SBML Level 3 is being developed as a modular format with optional SBML Level 3 packages are available to extend the focus of the core SBML representation. Deviser is a new code generation system developed to facilitate the development of SBML L3 packages by helping to automate the generation of specifications, UML diagrams and library code.

The current fork extends Deviser's code generator to produce Java code that can be integrated into JSBML, the pure Java API library for SBML. This allows Deviser to target both libSBML and JSBML.At the current it generates the foundation of the packages, which facilitates the implementation of the packages.  The work was done for Google Summer of Code 2016.


## Using Deviser for Java Code Generation ##

There is command line version of the function that can be used to invoke the deviser functionality for generating Java/JSBML code from the XML file. This is the deviser.py file found in the generator directory.

    deviser.py [--generatejsbml][--latex] input-file.xml  



## Requirement for the fork
Deviser requires javap for the java code generation at the current phase.
Javap is available with the JDK and the following is required for Devisers' java code functionality. 

[Java JDK is required for javap](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

Also set up JAVA_HOME environment variable for your operating system, if you are working under Windows, here is a [good tutorial](https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/) on how to set up. And for Linux: [Ubuntu/Debian](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04).

## Current State ##

At the current state Deviser generates compilable templates, which serve as a foundation and facilitates the implementation of the following packages :


1.	Qualitative Models package (qual, for short) allows species in a model to have non-quantitative or non-continuous levels.
([Chaouiya et al., 2013](http://bmcsystbiol.biomedcentral.com/articles/10.1186/1752-0509-7-135))
2.	Groups ([groups, Hucka and Smith, 2013](http://sbml.org/Documents/Specifications/SBML_Level_3/Packages/groups)) agglomerates SBML model elements and can be linked to annotations and SBO terms (Courtot et al., 2011) to contextualize sets of objects for other
programmers and modelers.
3.	Distributions ([distrib, Moodie and Smith, 2013](http://sbml.org/Documents/Specifications/SBML_Level_3/Packages/distrib)) encodes statistical distributions and their sampling.
4.	Dynamic Structures ([dyn, Gomez et al., 2014](http://sbml.org/Documents/Specifications/SBML_Level_3/Packages/dyn)), which supports the definition of dynamical behaviors for model entities.



## Future Plans ##

Specific parts of the packages are left to be implemented.

1.	Flux Balance Constraints ([fbc, Olivier and Bergmann, 2013](http://sbml.org/Documents/Specifications/SBML_Level_3/Packages/fbc)) encodes components for constraints based modeling (Lewis et al., 2012), which employs a class of models
in which the canonical stoichiometric relations between reactions and metabolites are specified as constraints for mathematical optimization.
2.	Spatial Processes ([spatial, Schaff et al., 2014](http://sbml.org/Documents/Specifications/SBML_Level_3/Packages/spatial))  specifies geometric descriptions of biochemical models’ components using a cellular coordinate system that can describe non-uniform molecular distributions, diffusive transport and spatially localized
reactions.


I would also like to optimize imports part, as well as find an alternative to javap, which is used extensively, so deviser
does not have any dependency for Java/JSBML code generation.


## Java Tests ##


For running Java code generation tests, please head to  generator/tests/test_java_code and run

    run_java_tests.py


If there are any errors, it will also show the code differences.



## Acknowledgments ##

I am very grateful to my mentors Dr. Bergmann, Dr. Keating, Dr. Dräger and Dr. Rodriguez for the invaluable help and patience.



## Original Information ##


*Deviser* stands for *"Design Explorer and
Viewer for Iterative SBML Enhancement of Representations"*. 


*Authors*:      [Sarah Keating](http://www.ebi.ac.uk/about/people/sarah-keating), and [Frank Bergmann](http://www.cos.uni-heidelberg.de/index.php/f.bergmann?l=_e)
with contributions from [Mike Hucka](http://www.cds.caltech.edu/~mhucka).

*License*:      This code is licensed under the LGPL version 2.1.  Please see the file [LICENSE.txt](https://raw.githubusercontent.com/sbmlteam/moccasin/master/LICENSE.txt) for details.

*Repository*:   [https://github.com/sbmlteam/deviser](https://github.com/sbmlteam/deviser)


*Pivotal tracker*: [https://www.pivotaltracker.com/n/projects/977192](https://www.pivotaltracker.com/n/projects/977192)





## Background ##


Computation modeling has become a crucial aspect of biological research, and [SBML](http://sbml.org) (the Systems Biology Markup Language) has become the de facto standard open format for exchanging models between software tools in systems biology.

[LibSBML](http://sbml.org/Software/libSBML) is a free, open-source programming library to help you read, write, manipulate, translate, and validate SBML files and data streams. Support for SBML Level 3 packages can be added by integrating 
the package specific code and building with the package enabled.

 SBML Level 3 is being developed as a core with additional optional packages. Deviser facilitates the development of these packages by providing a means of creating a basic specification, UML diagrams and code for integration with libSBML.


Deviser is written in Python and is compatible with Python version 2.6 onwards.



## Using Deviser ##

The Deviser Edit tool allows you to quickly define an SBML L3 package. It then provides the  following functionality

1.	Create and view a UML diagram.
2.	Generate the necessary libSBML code for the package.
3.	Generate TeX files and generate a pdf of a basic specification document for the package.
4.	Integrate and test the package with libSBML.

The Deviser Edit tool creates an XML description of the package that is used by the deviser code to generate the requested files. This XML description is exemplified in the [samples](deviser/samples) directory.


There is command line version of the function that can be used to invoke the deviser functionality on the XML file. This is the deviser.py file found in the generator directory.

    deviser.py [--generate][--latex] input-file.xml    

This program will use a Deviser xml file, and generate either a C++ 
libSBML extension for it, or generate a LaTeX scaffold for its 
specification. 

Full documentation is available in the [docs](deviser\docs) directory.


## Installation ##

##### Microsoft Windows OS

The deviser release includes a windows installation executable. When installed this provides the user with the Deviser Edit tool (CsDeviser.exe) and additionally includes a python interpreter and the sbmlpkgspec files for generating SBML L3 Package specifications.

##### Linux OS

The deviser release includes a tarball suitable for Linux. This includes the Deviser Edit tool which can be used is mono is installed.


#####Mac OS X

The Deviser Edit tool does not (yet) work on Mac OS X systems.  However the command line version can be used. Thus downloading the release src code will provide this functionality.



## Other resources ##

Not all of the following are necessary as what is necessary depends on which operating system is being used and which Deviser functionality is required. These links are given as a quick reference.

[libSBML source code](https://sourceforge.net/projects/sbml/files/libsbml/5.11.4/stable/libSBML-5.11.4-core-src.tar.gz/download) 

[libSBML dependency libraries for Windows users](https://github.com/sbmlteam/libSBML-dependencies)

[SBML package specification template files](https://sourceforge.net/projects/sbml/files/specifications/tex/sbmlpkgspec-1.6.0.tar.gz/download)

[Mono install scripts for Linux](https://github.com/nathanb/iws-snippets/tree/master/mono-install-scripts)





## Acknowledgments ##

We achnowledge funding for Deviser from the National Institutes of Health (USA) under
grant R01 GM070923.


## Copyright and license ##


Copyright (C) 2014-2015 jointly by the California Institute of Technology, Pasadena, CA, USA, EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK and the University of Heidelberg, Heidelberg, Germany

This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or any later version.

This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  The software and documentation provided hereunder is on an "as is" basis, and the California Institute of Technology has no obligations to provide maintenance, support, updates, enhancements or modifications.  In no event shall the California Institute of Technology be liable to any party for direct, indirect, special, incidental or consequential damages, including lost profits, arising out of the use of this software and its documentation, even if the California Institute of Technology has been advised of the possibility of such damage.  See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with this library in the file named "LICENCE.txt" included with the software distribution.
