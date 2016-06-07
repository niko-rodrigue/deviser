#!/usr/bin/env python
#
# @file    jsbml_class_tree.py
# @brief   tree structure for JSBML classes
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
from  collections import defaultdict


def tree():
    return defaultdict(tree)


jsbml_classes = tree()
#Level 0 is the bottom of the Figure 2.1 from JSBML Manual

#Level 0

# 'Compartment' Class
jsbml_classes['Compartment']['name'] = 'Compartment'
jsbml_classes['Compartment']['hasParent'] = True
jsbml_classes['Compartment']['parentNode'] = jsbml_classes['Symbol'] # TODO fill
jsbml_classes['Compartment']['hasChildren'] = False
jsbml_classes['Compartment']['childrenNode'] = None
jsbml_classes['Compartment']['isInterface'] = False
jsbml_classes['Compartment']['hasParentInterface'] = False
jsbml_classes['Compartment']['hasChildrenInterface'] = False
jsbml_classes['Compartment']['isUniqueJSBML'] = False
jsbml_classes['Compartment']['level'] = 0
jsbml_classes['Compartment']['libSBML_analogue'] = None

print(jsbml_classes['Compartment']['parentNode'])
print('-----------------------------------------')
# 'Parameter' Class
jsbml_classes['Parameter']['name'] = 'Parameter'
jsbml_classes['Parameter']['hasParent'] = True
jsbml_classes['Parameter']['parentNode'] = None # TODO fill
jsbml_classes['Parameter']['hasChildren'] = False
jsbml_classes['Parameter']['childrenNodes'] = None
jsbml_classes['Parameter']['isInterface'] = False
jsbml_classes['Parameter']['hasParentInterface'] = False
jsbml_classes['Parameter']['hasChildrenInterface'] = False
jsbml_classes['Parameter']['isUniqueJSBML'] = False
jsbml_classes['Parameter']['level'] = 0
jsbml_classes['Parameter']['libSBML_analogue'] = None

# 'Species' Class
jsbml_classes['Species']['name'] = 'Species'
jsbml_classes['Species']['hasParent'] = True
jsbml_classes['Species']['parentNode'] = None # TODO fill
jsbml_classes['Species']['hasChildren'] = False
jsbml_classes['Species']['childrenNodes'] = None
jsbml_classes['Species']['isInterface'] = False
jsbml_classes['Species']['hasParentInterface'] = True
jsbml_classes['Species']['hasChildrenInterface'] = False
jsbml_classes['Species']['isUniqueJSBML'] = False
jsbml_classes['Species']['level'] = 0
jsbml_classes['Species']['libSBML_analogue'] = None

######################################################################

#Level 1

# 'Symbol' Class
jsbml_classes['Symbol']['name'] = 'Symbol'
jsbml_classes['Symbol']['hasParent'] = True
jsbml_classes['Symbol']['parentNode'] = None # TODO fill
jsbml_classes['Symbol']['hasChildren'] = True
jsbml_classes['Symbol']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter'],
                                            jsbml_classes['Compartment']]
jsbml_classes['Symbol']['isInterface'] = False
jsbml_classes['Symbol']['hasParentInterface'] = True
jsbml_classes['Symbol']['hasChildrenInterface'] = False
jsbml_classes['Symbol']['isUniqueJSBML'] = True
jsbml_classes['Symbol']['level'] = 1
jsbml_classes['Symbol']['libSBML_analogue'] = None

# 'LocalParameter' Class
jsbml_classes['LocalParameter']['name'] = 'LocalParameter'
jsbml_classes['LocalParameter']['hasParent'] = True
jsbml_classes['LocalParameter']['parentNode'] = None # TODO fill
jsbml_classes['LocalParameter']['hasChildren'] = False
jsbml_classes['LocalParameter']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter'],
                                                     jsbml_classes['Compartment']]
jsbml_classes['LocalParameter']['isInterface'] = False
jsbml_classes['LocalParameter']['hasParentInterface'] = True
jsbml_classes['LocalParameter']['hasChildrenInterface'] = False
jsbml_classes['LocalParameter']['isUniqueJSBML'] = False
jsbml_classes['LocalParameter']['level'] = 1
jsbml_classes['LocalParameter']['libSBML_analogue'] = None


# 'SpeciesReference' Class
jsbml_classes['SpeciesReference']['name'] = 'SpeciesReference'
jsbml_classes['SpeciesReference']['hasParent'] = True
jsbml_classes['SpeciesReference']['parentNode'] = None # TODO fill
jsbml_classes['SpeciesReference']['hasChildren'] = False
jsbml_classes['SpeciesReference']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SpeciesReference']['isInterface'] = False
jsbml_classes['SpeciesReference']['hasParentInterface'] = True
jsbml_classes['SpeciesReference']['hasChildrenInterface'] = False
jsbml_classes['SpeciesReference']['isUniqueJSBML'] = False
jsbml_classes['SpeciesReference']['level'] = 1
jsbml_classes['SpeciesReference']['libSBML_analogue'] = None


# 'AssignmentRule' Class
jsbml_classes['AssignmentRule']['name'] = 'AssignmentRule'
jsbml_classes['AssignmentRule']['hasParent'] = True
jsbml_classes['AssignmentRule']['parentNode'] = None # TODO fill
jsbml_classes['AssignmentRule']['hasChildren'] = False
jsbml_classes['AssignmentRule']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AssignmentRule']['isInterface'] = False
jsbml_classes['AssignmentRule']['hasParentInterface'] = True
jsbml_classes['AssignmentRule']['hasChildrenInterface'] = False
jsbml_classes['AssignmentRule']['isUniqueJSBML'] = False
jsbml_classes['AssignmentRule']['level'] = 1
jsbml_classes['AssignmentRule']['libSBML_analogue'] = None


# 'RateRule' Class
jsbml_classes['RateRule']['name'] = 'AssignmentRule'
jsbml_classes['RateRule']['hasParent'] = True
jsbml_classes['RateRule']['parentNode'] = None # TODO fill
jsbml_classes['RateRule']['hasChildren'] = False
jsbml_classes['RateRule']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['RateRule']['isInterface'] = False
jsbml_classes['RateRule']['hasParentInterface'] = True
jsbml_classes['RateRule']['hasChildrenInterface'] = False
jsbml_classes['RateRule']['isUniqueJSBML'] = False
jsbml_classes['RateRule']['level'] = 1
jsbml_classes['RateRule']['libSBML_analogue'] = None

########################################################################

# Level 2

# 'Variable' Interface Class
jsbml_classes['Variable']['name'] = 'Variable'
jsbml_classes['Variable']['hasParent'] = True
jsbml_classes['Variable']['parentNode'] = None # TODO fill
jsbml_classes['Variable']['hasChildren'] = False
jsbml_classes['Variable']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Variable']['isInterface'] = False
jsbml_classes['Variable']['hasParentInterface'] = True
jsbml_classes['Variable']['hasChildrenInterface'] = False
jsbml_classes['Variable']['isUniqueJSBML'] = False
jsbml_classes['Variable']['level'] = 2
jsbml_classes['Variable']['libSBML_analogue'] = None


# 'QuantityWithUnit' Interface Class
jsbml_classes['QuantityWithUnit']['name'] = 'QuantityWithUnit'
jsbml_classes['QuantityWithUnit']['hasParent'] = True
jsbml_classes['QuantityWithUnit']['parentNode'] = None # TODO fill
jsbml_classes['QuantityWithUnit']['hasChildren'] = False
jsbml_classes['QuantityWithUnit']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['QuantityWithUnit']['isInterface'] = False
jsbml_classes['QuantityWithUnit']['hasParentInterface'] = True
jsbml_classes['QuantityWithUnit']['hasChildrenInterface'] = False
jsbml_classes['QuantityWithUnit']['isUniqueJSBML'] = False
jsbml_classes['QuantityWithUnit']['level'] = 2
jsbml_classes['QuantityWithUnit']['libSBML_analogue'] = None

# 'ModifierSpeciesReference' Interface Class
jsbml_classes['ModifierSpeciesReference']['name'] = 'ModifierSpeciesReference'
jsbml_classes['ModifierSpeciesReference']['hasParent'] = True
jsbml_classes['ModifierSpeciesReference']['parentNode'] = None # TODO fill
jsbml_classes['ModifierSpeciesReference']['hasChildren'] = False
jsbml_classes['ModifierSpeciesReference']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['ModifierSpeciesReference']['isInterface'] = False
jsbml_classes['ModifierSpeciesReference']['hasParentInterface'] = True
jsbml_classes['ModifierSpeciesReference']['hasChildrenInterface'] = False
jsbml_classes['ModifierSpeciesReference']['isUniqueJSBML'] = False
jsbml_classes['ModifierSpeciesReference']['level'] = 2
jsbml_classes['ModifierSpeciesReference']['libSBML_analogue'] = None


# 'Event' Interface Class
jsbml_classes['Event']['name'] = 'Event'
jsbml_classes['Event']['hasParent'] = True
jsbml_classes['Event']['parentNode'] = None # TODO fill
jsbml_classes['Event']['hasChildren'] = False
jsbml_classes['Event']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Event']['isInterface'] = False
jsbml_classes['Event']['hasParentInterface'] = True
jsbml_classes['Event']['hasChildrenInterface'] = False
jsbml_classes['Event']['isUniqueJSBML'] = False
jsbml_classes['Event']['level'] = 2
jsbml_classes['Event']['libSBML_analogue'] = None


# 'ExplicitRule' Interface Class
jsbml_classes['ExplicitRule']['name'] = 'ExplicitRule'
jsbml_classes['ExplicitRule']['hasParent'] = True
jsbml_classes['ExplicitRule']['parentNode'] = None # TODO fill
jsbml_classes['ExplicitRule']['hasChildren'] = False
jsbml_classes['ExplicitRule']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['ExplicitRule']['isInterface'] = False
jsbml_classes['ExplicitRule']['hasParentInterface'] = True
jsbml_classes['ExplicitRule']['hasChildrenInterface'] = False
jsbml_classes['ExplicitRule']['isUniqueJSBML'] = False
jsbml_classes['ExplicitRule']['level'] = 2
jsbml_classes['ExplicitRule']['libSBML_analogue'] = None

# 'AlgebraicRule' Interface Class
jsbml_classes['AlgebraicRule']['name'] = 'AlgebraicRule'
jsbml_classes['AlgebraicRule']['hasParent'] = True
jsbml_classes['AlgebraicRule']['parentNode'] = None # TODO fill
jsbml_classes['AlgebraicRule']['hasChildren'] = False
jsbml_classes['AlgebraicRule']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AlgebraicRule']['isInterface'] = False
jsbml_classes['AlgebraicRule']['hasParentInterface'] = True
jsbml_classes['AlgebraicRule']['hasChildrenInterface'] = False
jsbml_classes['AlgebraicRule']['isUniqueJSBML'] = False
jsbml_classes['AlgebraicRule']['level'] = 2
jsbml_classes['AlgebraicRule']['libSBML_analogue'] = None

######################################################################

#Level 3

# 'Quantity' Interface Class
jsbml_classes['Quantity']['name'] = 'Quantity'
jsbml_classes['Quantity']['hasParent'] = True
jsbml_classes['Quantity']['parentNode'] = None # TODO fill
jsbml_classes['Quantity']['hasChildren'] = False
jsbml_classes['Quantity']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Quantity']['isInterface'] = False
jsbml_classes['Quantity']['hasParentInterface'] = True
jsbml_classes['Quantity']['hasChildrenInterface'] = False
jsbml_classes['Quantity']['isUniqueJSBML'] = False
jsbml_classes['Quantity']['level'] = 3
jsbml_classes['Quantity']['libSBML_analogue'] = None

# 'Reaction' Interface Class
jsbml_classes['Reaction']['name'] = 'Reaction'
jsbml_classes['Reaction']['hasParent'] = True
jsbml_classes['Reaction']['parentNode'] = None # TODO fill
jsbml_classes['Reaction']['hasChildren'] = False
jsbml_classes['Reaction']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Reaction']['isInterface'] = False
jsbml_classes['Reaction']['hasParentInterface'] = True
jsbml_classes['Reaction']['hasChildrenInterface'] = False
jsbml_classes['Reaction']['isUniqueJSBML'] = False
jsbml_classes['Reaction']['level'] = 3
jsbml_classes['Reaction']['libSBML_analogue'] = None

# 'FunctionDefinition' Interface Class
jsbml_classes['FunctionDefinition']['name'] = 'FunctionDefinition'
jsbml_classes['FunctionDefinition']['hasParent'] = True
jsbml_classes['FunctionDefinition']['parentNode'] = None # TODO fill
jsbml_classes['FunctionDefinition']['hasChildren'] = False
jsbml_classes['FunctionDefinition']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['FunctionDefinition']['isInterface'] = False
jsbml_classes['FunctionDefinition']['hasParentInterface'] = True
jsbml_classes['FunctionDefinition']['hasChildrenInterface'] = False
jsbml_classes['FunctionDefinition']['isUniqueJSBML'] = False
jsbml_classes['FunctionDefinition']['level'] = 3
jsbml_classes['FunctionDefinition']['libSBML_analogue'] = None


# 'SimpleSpeciesReference' Interface Class
jsbml_classes['SimpleSpeciesReference']['name'] = 'SimpleSpeciesReference'
jsbml_classes['SimpleSpeciesReference']['hasParent'] = True
jsbml_classes['SimpleSpeciesReference']['parentNode'] = None # TODO fill
jsbml_classes['SimpleSpeciesReference']['hasChildren'] = False
jsbml_classes['SimpleSpeciesReference']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SimpleSpeciesReference']['isInterface'] = False
jsbml_classes['SimpleSpeciesReference']['hasParentInterface'] = True
jsbml_classes['SimpleSpeciesReference']['hasChildrenInterface'] = False
jsbml_classes['SimpleSpeciesReference']['isUniqueJSBML'] = False
jsbml_classes['SimpleSpeciesReference']['level'] = 3
jsbml_classes['SimpleSpeciesReference']['libSBML_analogue'] = None

# 'Model' Interface Class
jsbml_classes['Model']['name'] = 'Model'
jsbml_classes['Model']['hasParent'] = True
jsbml_classes['Model']['parentNode'] = None # TODO fill
jsbml_classes['Model']['hasChildren'] = False
jsbml_classes['Model']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Model']['isInterface'] = False
jsbml_classes['Model']['hasParentInterface'] = True
jsbml_classes['Model']['hasChildrenInterface'] = False
jsbml_classes['Model']['isUniqueJSBML'] = False
jsbml_classes['Model']['level'] = 3
jsbml_classes['Model']['libSBML_analogue'] = None

# 'SpeciesType' Interface Class
jsbml_classes['SpeciesType']['name'] = 'SpeciesType'
jsbml_classes['SpeciesType']['hasParent'] = True
jsbml_classes['SpeciesType']['parentNode'] = None # TODO fill
jsbml_classes['SpeciesType']['hasChildren'] = False
jsbml_classes['SpeciesType']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SpeciesType']['isInterface'] = False
jsbml_classes['SpeciesType']['hasParentInterface'] = True
jsbml_classes['SpeciesType']['hasChildrenInterface'] = False
jsbml_classes['SpeciesType']['isUniqueJSBML'] = False
jsbml_classes['SpeciesType']['level'] = 3
jsbml_classes['SpeciesType']['libSBML_analogue'] = None

# 'CompartmentType' Interface Class
jsbml_classes['CompartmentType']['name'] = 'CompartmentType'
jsbml_classes['CompartmentType']['hasParent'] = True
jsbml_classes['CompartmentType']['parentNode'] = None # TODO fill
jsbml_classes['CompartmentType']['hasChildren'] = False
jsbml_classes['CompartmentType']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['CompartmentType']['isInterface'] = False
jsbml_classes['CompartmentType']['hasParentInterface'] = True
jsbml_classes['CompartmentType']['hasChildrenInterface'] = False
jsbml_classes['CompartmentType']['isUniqueJSBML'] = False
jsbml_classes['CompartmentType']['level'] = 3
jsbml_classes['CompartmentType']['libSBML_analogue'] = None

# 'UnitDefinition' Interface Class
jsbml_classes['UnitDefinition']['name'] = 'UnitDefinition'
jsbml_classes['UnitDefinition']['hasParent'] = True
jsbml_classes['UnitDefinition']['parentNode'] = None # TODO fill
jsbml_classes['UnitDefinition']['hasChildren'] = False
jsbml_classes['UnitDefinition']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['UnitDefinition']['isInterface'] = False
jsbml_classes['UnitDefinition']['hasParentInterface'] = True
jsbml_classes['UnitDefinition']['hasChildrenInterface'] = False
jsbml_classes['UnitDefinition']['isUniqueJSBML'] = False
jsbml_classes['UnitDefinition']['level'] = 3
jsbml_classes['UnitDefinition']['libSBML_analogue'] = None

# 'AbstractNamedSBaseWithUnit' Interface Class
jsbml_classes['AbstractNamedSBaseWithUnit']['name'] = 'AbstractNamedSBaseWithUnit'
jsbml_classes['AbstractNamedSBaseWithUnit']['hasParent'] = True
jsbml_classes['AbstractNamedSBaseWithUnit']['parentNode'] = None # TODO fill
jsbml_classes['AbstractNamedSBaseWithUnit']['hasChildren'] = False
jsbml_classes['AbstractNamedSBaseWithUnit']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AbstractNamedSBaseWithUnit']['isInterface'] = False
jsbml_classes['AbstractNamedSBaseWithUnit']['hasParentInterface'] = True
jsbml_classes['AbstractNamedSBaseWithUnit']['hasChildrenInterface'] = False
jsbml_classes['AbstractNamedSBaseWithUnit']['isUniqueJSBML'] = False
jsbml_classes['AbstractNamedSBaseWithUnit']['level'] = 3
jsbml_classes['AbstractNamedSBaseWithUnit']['libSBML_analogue'] = None

# 'KineticLaw' Interface Class
jsbml_classes['KineticLaw']['name'] = 'KineticLaw'
jsbml_classes['KineticLaw']['hasParent'] = True
jsbml_classes['KineticLaw']['parentNode'] = None # TODO fill
jsbml_classes['KineticLaw']['hasChildren'] = False
jsbml_classes['KineticLaw']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['KineticLaw']['isInterface'] = False
jsbml_classes['KineticLaw']['hasParentInterface'] = True
jsbml_classes['KineticLaw']['hasChildrenInterface'] = False
jsbml_classes['KineticLaw']['isUniqueJSBML'] = False
jsbml_classes['KineticLaw']['level'] = 3
jsbml_classes['KineticLaw']['libSBML_analogue'] = None

# 'EventAssignment' Interface Class
jsbml_classes['EventAssignment']['name'] = 'EventAssignment'
jsbml_classes['EventAssignment']['hasParent'] = True
jsbml_classes['EventAssignment']['parentNode'] = None # TODO fill
jsbml_classes['EventAssignment']['hasChildren'] = False
jsbml_classes['EventAssignment']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['EventAssignment']['isInterface'] = False
jsbml_classes['EventAssignment']['hasParentInterface'] = True
jsbml_classes['EventAssignment']['hasChildrenInterface'] = False
jsbml_classes['EventAssignment']['isUniqueJSBML'] = False
jsbml_classes['EventAssignment']['level'] = 3
jsbml_classes['EventAssignment']['libSBML_analogue'] = None


# 'InitialAssignment' Interface Class
jsbml_classes['InitialAssignment']['name'] = 'InitialAssignment'
jsbml_classes['InitialAssignment']['hasParent'] = True
jsbml_classes['InitialAssignment']['parentNode'] = None # TODO fill
jsbml_classes['InitialAssignment']['hasChildren'] = False
jsbml_classes['InitialAssignment']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['InitialAssignment']['isInterface'] = False
jsbml_classes['InitialAssignment']['hasParentInterface'] = True
jsbml_classes['InitialAssignment']['hasChildrenInterface'] = False
jsbml_classes['InitialAssignment']['isUniqueJSBML'] = False
jsbml_classes['InitialAssignment']['level'] = 3
jsbml_classes['InitialAssignment']['libSBML_analogue'] = None



print(jsbml_classes['Symbol']['childrenNodes'][0])
print('--------------------------------------------')
print(jsbml_classes)