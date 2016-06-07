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
jsbml_classes['Compartment']['parentNode'] = 'Symbol' # TODO fill
jsbml_classes['Compartment']['hasChildren'] = False
jsbml_classes['Compartment']['childrenNode'] = None
jsbml_classes['Compartment']['isInterface'] = False
jsbml_classes['Compartment']['parentInterfaces'] = None
jsbml_classes['Compartment']['childrenInterfaces'] = None
jsbml_classes['Compartment']['isUniqueJSBML'] = False
jsbml_classes['Compartment']['level'] = 0
jsbml_classes['Compartment']['libSBML_analogue'] = None

print(jsbml_classes['Compartment']['parentNode'])
print('-----------------------------------------')
# 'Parameter' Class
jsbml_classes['Parameter']['name'] = 'Parameter'
jsbml_classes['Parameter']['hasParent'] = True
jsbml_classes['Parameter']['parentNode'] = 'Symbol' # TODO fill
jsbml_classes['Parameter']['hasChildren'] = False
jsbml_classes['Parameter']['childrenNodes'] = None
jsbml_classes['Parameter']['isInterface'] = False
jsbml_classes['Parameter']['parentInterfaces'] = None
jsbml_classes['Parameter']['childrenInterfaces'] = None
jsbml_classes['Parameter']['isUniqueJSBML'] = False
jsbml_classes['Parameter']['level'] = 0
jsbml_classes['Parameter']['libSBML_analogue'] = None

# 'Species' Class
jsbml_classes['Species']['name'] = 'Species'
jsbml_classes['Species']['hasParent'] = True
jsbml_classes['Species']['parentNode'] = 'Symbol' # TODO fill
jsbml_classes['Species']['hasChildren'] = False
jsbml_classes['Species']['childrenNodes'] = None
jsbml_classes['Species']['isInterface'] = False
jsbml_classes['Species']['parentInterfaces'] = 'CompartmentilizedSBase'
jsbml_classes['Species']['childrenInterfaces'] = None
jsbml_classes['Species']['isUniqueJSBML'] = False
jsbml_classes['Species']['level'] = 0
jsbml_classes['Species']['libSBML_analogue'] = None

######################################################################

#Level 1

# 'Symbol' Class
jsbml_classes['Symbol']['name'] = 'Symbol'
jsbml_classes['Symbol']['hasParent'] = True
jsbml_classes['Symbol']['parentNode'] = 'QuantityWithUnit'  # TODO fill
jsbml_classes['Symbol']['hasChildren'] = True
jsbml_classes['Symbol']['childrenNodes'] = ['Species', 'Compartment', 'Parameter']
jsbml_classes['Symbol']['isInterface'] = False
jsbml_classes['Symbol']['parentInterfaces'] = None
jsbml_classes['Symbol']['childrenInterfaces'] = None
jsbml_classes['Symbol']['isUniqueJSBML'] = True
jsbml_classes['Symbol']['level'] = 1
jsbml_classes['Symbol']['libSBML_analogue'] = None

# 'LocalParameter' Class
jsbml_classes['LocalParameter']['name'] = 'LocalParameter'
jsbml_classes['LocalParameter']['hasParent'] = True
jsbml_classes['LocalParameter']['parentNode'] = 'QuantityWithUnit'  # TODO fill
jsbml_classes['LocalParameter']['hasChildren'] = False
jsbml_classes['LocalParameter']['childrenNodes'] = None
jsbml_classes['LocalParameter']['isInterface'] = False
jsbml_classes['LocalParameter']['parentInterfaces'] = None
jsbml_classes['LocalParameter']['childrenInterfaces'] = None
jsbml_classes['LocalParameter']['isUniqueJSBML'] = False
jsbml_classes['LocalParameter']['level'] = 1
jsbml_classes['LocalParameter']['libSBML_analogue'] = None


# 'SpeciesReference' Class
jsbml_classes['SpeciesReference']['name'] = 'SpeciesReference'
jsbml_classes['SpeciesReference']['hasParent'] = True
jsbml_classes['SpeciesReference']['parentNode'] = 'SimpleSpeciesReference'  # TODO fill
jsbml_classes['SpeciesReference']['hasChildren'] = True
jsbml_classes['SpeciesReference']['childrenNodes'] = ['SpeciesReference']
jsbml_classes['SpeciesReference']['isInterface'] = False
jsbml_classes['SpeciesReference']['parentInterfaces'] = 'Variable'
jsbml_classes['SpeciesReference']['childrenInterfaces'] = None
jsbml_classes['SpeciesReference']['isUniqueJSBML'] = False
jsbml_classes['SpeciesReference']['level'] = 1
jsbml_classes['SpeciesReference']['libSBML_analogue'] = None


# 'AssignmentRule' Class
jsbml_classes['AssignmentRule']['name'] = 'AssignmentRule'
jsbml_classes['AssignmentRule']['hasParent'] = True
jsbml_classes['AssignmentRule']['parentNode'] = 'ExplicitRule'  # TODO fill
jsbml_classes['AssignmentRule']['hasChildren'] = False
jsbml_classes['AssignmentRule']['childrenNodes'] = None
jsbml_classes['AssignmentRule']['isInterface'] = False
jsbml_classes['AssignmentRule']['parentInterfaces'] = None
jsbml_classes['AssignmentRule']['childrenInterfaces'] = None
jsbml_classes['AssignmentRule']['isUniqueJSBML'] = False
jsbml_classes['AssignmentRule']['level'] = 1
jsbml_classes['AssignmentRule']['libSBML_analogue'] = None


# 'RateRule' Class
jsbml_classes['RateRule']['name'] = 'AssignmentRule'
jsbml_classes['RateRule']['hasParent'] = True
jsbml_classes['RateRule']['parentNode'] = 'ExplicitRule'  # TODO fill
jsbml_classes['RateRule']['hasChildren'] = False
jsbml_classes['RateRule']['childrenNodes'] = None
jsbml_classes['RateRule']['isInterface'] = False
jsbml_classes['RateRule']['parentInterfaces'] = None
jsbml_classes['RateRule']['childrenInterfaces'] = None
jsbml_classes['RateRule']['isUniqueJSBML'] = False
jsbml_classes['RateRule']['level'] = 1
jsbml_classes['RateRule']['libSBML_analogue'] = None

########################################################################

# Level 2

# 'Variable' Interface Class
jsbml_classes['Variable']['name'] = 'Variable'
jsbml_classes['Variable']['hasParent'] = False
jsbml_classes['Variable']['parentNode'] = None  # TODO fill
jsbml_classes['Variable']['hasChildren'] = True
jsbml_classes['Variable']['childrenNodes'] = ['SpeciesReference', 'Symbol']
jsbml_classes['Variable']['isInterface'] = True
jsbml_classes['Variable']['parentInterfaces'] = ['Quantity', 'UniqueNamedSBase']
jsbml_classes['Variable']['childrenInterfaces'] = None
jsbml_classes['Variable']['isUniqueJSBML'] = True
jsbml_classes['Variable']['level'] = 2
jsbml_classes['Variable']['libSBML_analogue'] = None


# 'QuantityWithUnit' Interface Class
jsbml_classes['QuantityWithUnit']['name'] = 'QuantityWithUnit'
jsbml_classes['QuantityWithUnit']['hasParent'] = True
jsbml_classes['QuantityWithUnit']['parentNode'] = 'AbstractNamedSBaseWithUnit'  # TODO fill
jsbml_classes['QuantityWithUnit']['hasChildren'] = True
jsbml_classes['QuantityWithUnit']['childrenNodes'] = ['Symbol', 'LocalParameter']
jsbml_classes['QuantityWithUnit']['isInterface'] = False
jsbml_classes['QuantityWithUnit']['parentInterfaces'] = ['Quantity']
jsbml_classes['QuantityWithUnit']['childrenInterfaces'] = None
jsbml_classes['QuantityWithUnit']['isUniqueJSBML'] = True
jsbml_classes['QuantityWithUnit']['level'] = 2
jsbml_classes['QuantityWithUnit']['libSBML_analogue'] = None

# 'ModifierSpeciesReference' Interface Class
jsbml_classes['ModifierSpeciesReference']['name'] = 'ModifierSpeciesReference'
jsbml_classes['ModifierSpeciesReference']['hasParent'] = True
jsbml_classes['ModifierSpeciesReference']['parentNode'] = 'SimpleSpeciesReference' # TODO fill
jsbml_classes['ModifierSpeciesReference']['hasChildren'] = False
jsbml_classes['ModifierSpeciesReference']['childrenNodes'] = None
jsbml_classes['ModifierSpeciesReference']['isInterface'] = False
jsbml_classes['ModifierSpeciesReference']['parentInterfaces'] = None
jsbml_classes['ModifierSpeciesReference']['childrenInterfaces'] = None
jsbml_classes['ModifierSpeciesReference']['isUniqueJSBML'] = False
jsbml_classes['ModifierSpeciesReference']['level'] = 2
jsbml_classes['ModifierSpeciesReference']['libSBML_analogue'] = None


# 'Event' Interface Class
jsbml_classes['Event']['name'] = 'Event'
jsbml_classes['Event']['hasParent'] = True
jsbml_classes['Event']['parentNode'] = 'AbsractNamedSBaseWithUnit' # TODO fill
jsbml_classes['Event']['hasChildren'] = False
jsbml_classes['Event']['childrenNodes'] = None
jsbml_classes['Event']['isInterface'] = False
jsbml_classes['Event']['parentInterfaces'] = ['UniqueNamedSBase']
jsbml_classes['Event']['childrenInterfaces'] = None
jsbml_classes['Event']['isUniqueJSBML'] = False
jsbml_classes['Event']['level'] = 2
jsbml_classes['Event']['libSBML_analogue'] = None


# 'ExplicitRule' Interface Class
jsbml_classes['ExplicitRule']['name'] = 'ExplicitRule'
jsbml_classes['ExplicitRule']['hasParent'] = True
jsbml_classes['ExplicitRule']['parentNode'] = 'Rule' # TODO fill
jsbml_classes['ExplicitRule']['hasChildren'] = True
jsbml_classes['ExplicitRule']['childrenNodes'] = ['AssignmentRule', 'RateRule']
jsbml_classes['ExplicitRule']['isInterface'] = False
jsbml_classes['ExplicitRule']['parentInterfaces'] = 'SBaseWithUnit'
jsbml_classes['ExplicitRule']['childrenInterfaces'] = None
jsbml_classes['ExplicitRule']['isUniqueJSBML'] = True
jsbml_classes['ExplicitRule']['level'] = 2
jsbml_classes['ExplicitRule']['libSBML_analogue'] = None

# 'AlgebraicRule' Interface Class
jsbml_classes['AlgebraicRule']['name'] = 'AlgebraicRule'
jsbml_classes['AlgebraicRule']['hasParent'] = True
jsbml_classes['AlgebraicRule']['parentNode'] = 'Rule'  # TODO fill
jsbml_classes['AlgebraicRule']['hasChildren'] = False
jsbml_classes['AlgebraicRule']['childrenNodes'] = None
jsbml_classes['AlgebraicRule']['isInterface'] = False
jsbml_classes['AlgebraicRule']['parentInterfaces'] = None
jsbml_classes['AlgebraicRule']['childrenInterfaces'] = None
jsbml_classes['AlgebraicRule']['isUniqueJSBML'] = False
jsbml_classes['AlgebraicRule']['level'] = 2
jsbml_classes['AlgebraicRule']['libSBML_analogue'] = None

######################################################################

#Level 3

# 'Quantity' Interface Class
jsbml_classes['Quantity']['name'] = 'Quantity'
jsbml_classes['Quantity']['hasParent'] = False
jsbml_classes['Quantity']['parentNode'] = None # TODO fill
jsbml_classes['Quantity']['hasChildren'] = False
jsbml_classes['Quantity']['childrenNodes'] = ['QuantityWithUnit']
jsbml_classes['Quantity']['isInterface'] = True
jsbml_classes['Quantity']['parentInterfaces'] = ['CallableSBase']
jsbml_classes['Quantity']['childrenInterfaces'] = ['Variable']
jsbml_classes['Quantity']['isUniqueJSBML'] = True
jsbml_classes['Quantity']['level'] = 3
jsbml_classes['Quantity']['libSBML_analogue'] = None

# 'Reaction' Interface Class
jsbml_classes['Reaction']['name'] = 'Reaction'
jsbml_classes['Reaction']['hasParent'] = True
jsbml_classes['Reaction']['parentNode'] = 'AbstractNamedSBase' # TODO fill
jsbml_classes['Reaction']['hasChildren'] = False
jsbml_classes['Reaction']['childrenNodes'] = None
jsbml_classes['Reaction']['isInterface'] = False
jsbml_classes['Reaction']['parentInterfaces'] = ['CompartmentilizedSBase', 'CallableSBase', 'UniqueNamedSBase']
jsbml_classes['Reaction']['childrenInterfaces'] = None
jsbml_classes['Reaction']['isUniqueJSBML'] = False
jsbml_classes['Reaction']['level'] = 3
jsbml_classes['Reaction']['libSBML_analogue'] = None

# 'FunctionDefinition' Interface Class
jsbml_classes['FunctionDefinition']['name'] = 'FunctionDefinition'
jsbml_classes['FunctionDefinition']['hasParent'] = True
jsbml_classes['FunctionDefinition']['parentNode'] = 'AbstractMathContainer'  # TODO fill
jsbml_classes['FunctionDefinition']['hasChildren'] = False
jsbml_classes['FunctionDefinition']['childrenNodes'] = None
jsbml_classes['FunctionDefinition']['isInterface'] = False
jsbml_classes['FunctionDefinition']['parentInterfaces'] = ['CallableSBase', 'UniqueNamedSBase']
jsbml_classes['FunctionDefinition']['childrenInterfaces'] = None
jsbml_classes['FunctionDefinition']['isUniqueJSBML'] = False
jsbml_classes['FunctionDefinition']['level'] = 3
jsbml_classes['FunctionDefinition']['libSBML_analogue'] = None


# 'SimpleSpeciesReference' Interface Class
jsbml_classes['SimpleSpeciesReference']['name'] = 'SimpleSpeciesReference'
jsbml_classes['SimpleSpeciesReference']['hasParent'] = True
jsbml_classes['SimpleSpeciesReference']['parentNode'] = 'AbstractNamedSBase' # TODO fill
jsbml_classes['SimpleSpeciesReference']['hasChildren'] = True
jsbml_classes['SimpleSpeciesReference']['childrenNodes'] = ['ModifierSpeciesReference']
jsbml_classes['SimpleSpeciesReference']['isInterface'] = False
jsbml_classes['SimpleSpeciesReference']['parentInterfaces'] = ['UniqueNamedSBase']
jsbml_classes['SimpleSpeciesReference']['childrenInterfaces'] = None
jsbml_classes['SimpleSpeciesReference']['isUniqueJSBML'] = False
jsbml_classes['SimpleSpeciesReference']['level'] = 3
jsbml_classes['SimpleSpeciesReference']['libSBML_analogue'] = None

# 'Model' Interface Class
jsbml_classes['Model']['name'] = 'Model'
jsbml_classes['Model']['hasParent'] = True
jsbml_classes['Model']['parentNode'] = 'AbstractNamedSBase'  # TODO fill
jsbml_classes['Model']['hasChildren'] = False
jsbml_classes['Model']['childrenNodes'] = None
jsbml_classes['Model']['isInterface'] = False
jsbml_classes['Model']['parentInterfaces'] = ['UniqueNamedSBase']
jsbml_classes['Model']['childrenInterfaces'] = None
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

# 'Rule' Interface Class
jsbml_classes['Rule']['name'] = 'Rule'
jsbml_classes['Rule']['hasParent'] = True
jsbml_classes['Rule']['parentNode'] = None # TODO fill
jsbml_classes['Rule']['hasChildren'] = False
jsbml_classes['Rule']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Rule']['isInterface'] = False
jsbml_classes['Rule']['hasParentInterface'] = True
jsbml_classes['Rule']['hasChildrenInterface'] = False
jsbml_classes['Rule']['isUniqueJSBML'] = False
jsbml_classes['Rule']['level'] = 3
jsbml_classes['Rule']['libSBML_analogue'] = None

# 'Priority' Interface Class
jsbml_classes['Priority']['name'] = 'Priority'
jsbml_classes['Priority']['hasParent'] = True
jsbml_classes['Priority']['parentNode'] = None # TODO fill
jsbml_classes['Priority']['hasChildren'] = False
jsbml_classes['Priority']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Priority']['isInterface'] = False
jsbml_classes['Priority']['hasParentInterface'] = True
jsbml_classes['Priority']['hasChildrenInterface'] = False
jsbml_classes['Priority']['isUniqueJSBML'] = False
jsbml_classes['Priority']['level'] = 3
jsbml_classes['Priority']['libSBML_analogue'] = None

# 'StoichiometryMath' Interface Class
jsbml_classes['StoichiometryMath']['name'] = 'StoichiometryMath'
jsbml_classes['StoichiometryMath']['hasParent'] = True
jsbml_classes['StoichiometryMath']['parentNode'] = None # TODO fill
jsbml_classes['StoichiometryMath']['hasChildren'] = False
jsbml_classes['StoichiometryMath']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['StoichiometryMath']['isInterface'] = False
jsbml_classes['StoichiometryMath']['hasParentInterface'] = True
jsbml_classes['StoichiometryMath']['hasChildrenInterface'] = False
jsbml_classes['StoichiometryMath']['isUniqueJSBML'] = False
jsbml_classes['StoichiometryMath']['level'] = 3
jsbml_classes['StoichiometryMath']['libSBML_analogue'] = None

# 'Trigger' Interface Class
jsbml_classes['Trigger']['name'] = 'Trigger'
jsbml_classes['Trigger']['hasParent'] = True
jsbml_classes['Trigger']['parentNode'] = None # TODO fill
jsbml_classes['Trigger']['hasChildren'] = False
jsbml_classes['Trigger']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Trigger']['isInterface'] = False
jsbml_classes['Trigger']['hasParentInterface'] = True
jsbml_classes['Trigger']['hasChildrenInterface'] = False
jsbml_classes['Trigger']['isUniqueJSBML'] = False
jsbml_classes['Trigger']['level'] = 3
jsbml_classes['Trigger']['libSBML_analogue'] = None

# 'Constraint' Interface Class
jsbml_classes['Constraint']['name'] = 'Constraint'
jsbml_classes['Constraint']['hasParent'] = True
jsbml_classes['Constraint']['parentNode'] = None # TODO fill
jsbml_classes['Constraint']['hasChildren'] = False
jsbml_classes['Constraint']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Constraint']['isInterface'] = False
jsbml_classes['Constraint']['hasParentInterface'] = True
jsbml_classes['Constraint']['hasChildrenInterface'] = False
jsbml_classes['Constraint']['isUniqueJSBML'] = False
jsbml_classes['Constraint']['level'] = 3
jsbml_classes['Constraint']['libSBML_analogue'] = None

# 'Delay' Interface Class
jsbml_classes['Delay']['name'] = 'Delay'
jsbml_classes['Delay']['hasParent'] = True
jsbml_classes['Delay']['parentNode'] = None # TODO fill
jsbml_classes['Delay']['hasChildren'] = False
jsbml_classes['Delay']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Delay']['isInterface'] = False
jsbml_classes['Delay']['hasParentInterface'] = True
jsbml_classes['Delay']['hasChildrenInterface'] = False
jsbml_classes['Delay']['isUniqueJSBML'] = False
jsbml_classes['Delay']['level'] = 3
jsbml_classes['Delay']['libSBML_analogue'] = None


########################################################################

# Level 4

# 'CompartmentalizedSBase' Interface Class
jsbml_classes['CompartmentalizedSBase']['name'] = 'CompartmentalizedSBase'
jsbml_classes['CompartmentalizedSBase']['hasParent'] = True
jsbml_classes['CompartmentalizedSBase']['parentNode'] = None # TODO fill
jsbml_classes['CompartmentalizedSBase']['hasChildren'] = False
jsbml_classes['CompartmentalizedSBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['CompartmentalizedSBase']['isInterface'] = False
jsbml_classes['CompartmentalizedSBase']['hasParentInterface'] = True
jsbml_classes['CompartmentalizedSBase']['hasChildrenInterface'] = False
jsbml_classes['CompartmentalizedSBase']['isUniqueJSBML'] = False
jsbml_classes['CompartmentalizedSBase']['level'] = 4
jsbml_classes['CompartmentalizedSBase']['libSBML_analogue'] = None

# 'CallableSBase' Interface Class
jsbml_classes['CallableSBase']['name'] = 'CallableSBase'
jsbml_classes['CallableSBase']['hasParent'] = True
jsbml_classes['CallableSBase']['parentNode'] = None # TODO fill
jsbml_classes['CallableSBase']['hasChildren'] = False
jsbml_classes['CallableSBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['CallableSBase']['isInterface'] = False
jsbml_classes['CallableSBase']['hasParentInterface'] = True
jsbml_classes['CallableSBase']['hasChildrenInterface'] = False
jsbml_classes['CallableSBase']['isUniqueJSBML'] = False
jsbml_classes['CallableSBase']['level'] = 4
jsbml_classes['CallableSBase']['libSBML_analogue'] = None

# 'UniqueNamedSBase' Interface Class
jsbml_classes['UniqueNamedSBase']['name'] = 'UniqueNamedSBase'
jsbml_classes['UniqueNamedSBase']['hasParent'] = True
jsbml_classes['UniqueNamedSBase']['parentNode'] = None # TODO fill
jsbml_classes['UniqueNamedSBase']['hasChildren'] = False
jsbml_classes['UniqueNamedSBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['UniqueNamedSBase']['isInterface'] = False
jsbml_classes['UniqueNamedSBase']['hasParentInterface'] = True
jsbml_classes['UniqueNamedSBase']['hasChildrenInterface'] = False
jsbml_classes['UniqueNamedSBase']['isUniqueJSBML'] = False
jsbml_classes['UniqueNamedSBase']['level'] = 4
jsbml_classes['UniqueNamedSBase']['libSBML_analogue'] = None

# 'AbstractNamedSBase' Interface Class
jsbml_classes['AbstractNamedSBase']['name'] = 'AbstractNamedSBase'
jsbml_classes['AbstractNamedSBase']['hasParent'] = True
jsbml_classes['AbstractNamedSBase']['parentNode'] = None # TODO fill
jsbml_classes['AbstractNamedSBase']['hasChildren'] = False
jsbml_classes['AbstractNamedSBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AbstractNamedSBase']['isInterface'] = False
jsbml_classes['AbstractNamedSBase']['hasParentInterface'] = True
jsbml_classes['AbstractNamedSBase']['hasChildrenInterface'] = False
jsbml_classes['AbstractNamedSBase']['isUniqueJSBML'] = False
jsbml_classes['AbstractNamedSBase']['level'] = 4
jsbml_classes['AbstractNamedSBase']['libSBML_analogue'] = None

# 'SBaseWithUnit' Interface Class
jsbml_classes['SBaseWithUnit']['name'] = 'SBaseWithUnit'
jsbml_classes['SBaseWithUnit']['hasParent'] = True
jsbml_classes['SBaseWithUnit']['parentNode'] = None # TODO fill
jsbml_classes['SBaseWithUnit']['hasChildren'] = False
jsbml_classes['SBaseWithUnit']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SBaseWithUnit']['isInterface'] = False
jsbml_classes['SBaseWithUnit']['hasParentInterface'] = True
jsbml_classes['SBaseWithUnit']['hasChildrenInterface'] = False
jsbml_classes['SBaseWithUnit']['isUniqueJSBML'] = False
jsbml_classes['SBaseWithUnit']['level'] = 4
jsbml_classes['SBaseWithUnit']['libSBML_analogue'] = None

# 'Assignment' Interface Class
jsbml_classes['Assignment']['name'] = 'Assignment'
jsbml_classes['Assignment']['hasParent'] = True
jsbml_classes['Assignment']['parentNode'] = None # TODO fill
jsbml_classes['Assignment']['hasChildren'] = False
jsbml_classes['Assignment']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Assignment']['isInterface'] = False
jsbml_classes['Assignment']['hasParentInterface'] = True
jsbml_classes['Assignment']['hasChildrenInterface'] = False
jsbml_classes['Assignment']['isUniqueJSBML'] = False
jsbml_classes['Assignment']['level'] = 4
jsbml_classes['Assignment']['libSBML_analogue'] = None

# 'AbstractMathContainer' Interface Class
jsbml_classes['AbstractMathContainer']['name'] = 'AbstractMathContainer'
jsbml_classes['AbstractMathContainer']['hasParent'] = True
jsbml_classes['AbstractMathContainer']['parentNode'] = None # TODO fill
jsbml_classes['AbstractMathContainer']['hasChildren'] = False
jsbml_classes['AbstractMathContainer']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AbstractMathContainer']['isInterface'] = False
jsbml_classes['AbstractMathContainer']['hasParentInterface'] = True
jsbml_classes['AbstractMathContainer']['hasChildrenInterface'] = False
jsbml_classes['AbstractMathContainer']['isUniqueJSBML'] = False
jsbml_classes['AbstractMathContainer']['level'] = 4
jsbml_classes['AbstractMathContainer']['libSBML_analogue'] = None

########################################################################

# Level 5

# 'NamedSBaseWithDerivedUnit' Interface Class
jsbml_classes['NamedSBaseWithDerivedUnit']['name'] = 'NamedSBaseWithDerivedUnit'
jsbml_classes['NamedSBaseWithDerivedUnit']['hasParent'] = True
jsbml_classes['NamedSBaseWithDerivedUnit']['parentNode'] = None # TODO fill
jsbml_classes['NamedSBaseWithDerivedUnit']['hasChildren'] = False
jsbml_classes['NamedSBaseWithDerivedUnit']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['NamedSBaseWithDerivedUnit']['isInterface'] = False
jsbml_classes['NamedSBaseWithDerivedUnit']['hasParentInterface'] = True
jsbml_classes['NamedSBaseWithDerivedUnit']['hasChildrenInterface'] = False
jsbml_classes['NamedSBaseWithDerivedUnit']['isUniqueJSBML'] = False
jsbml_classes['NamedSBaseWithDerivedUnit']['level'] = 5
jsbml_classes['NamedSBaseWithDerivedUnit']['libSBML_analogue'] = None

# 'MathContainer' Interface Class
jsbml_classes['MathContainer']['name'] = 'MathContainer'
jsbml_classes['MathContainer']['hasParent'] = True
jsbml_classes['MathContainer']['parentNode'] = None # TODO fill
jsbml_classes['MathContainer']['hasChildren'] = False
jsbml_classes['MathContainer']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['MathContainer']['isInterface'] = False
jsbml_classes['MathContainer']['hasParentInterface'] = True
jsbml_classes['MathContainer']['hasChildrenInterface'] = False
jsbml_classes['MathContainer']['isUniqueJSBML'] = False
jsbml_classes['MathContainer']['level'] = 5
jsbml_classes['MathContainer']['libSBML_analogue'] = None


# 'SBMLDocument' Interface Class
jsbml_classes['SBMLDocument']['name'] = 'SBMLDocument'
jsbml_classes['SBMLDocument']['hasParent'] = True
jsbml_classes['SBMLDocument']['parentNode'] = None # TODO fill
jsbml_classes['SBMLDocument']['hasChildren'] = False
jsbml_classes['SBMLDocument']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SBMLDocument']['isInterface'] = False
jsbml_classes['SBMLDocument']['hasParentInterface'] = True
jsbml_classes['SBMLDocument']['hasChildrenInterface'] = False
jsbml_classes['SBMLDocument']['isUniqueJSBML'] = False
jsbml_classes['SBMLDocument']['level'] = 5
jsbml_classes['SBMLDocument']['libSBML_analogue'] = None

# 'Unit' Interface Class
jsbml_classes['Unit']['name'] = 'Unit'
jsbml_classes['Unit']['hasParent'] = True
jsbml_classes['Unit']['parentNode'] = None # TODO fill
jsbml_classes['Unit']['hasChildren'] = False
jsbml_classes['Unit']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Unit']['isInterface'] = False
jsbml_classes['Unit']['hasParentInterface'] = True
jsbml_classes['Unit']['hasChildrenInterface'] = False
jsbml_classes['Unit']['isUniqueJSBML'] = False
jsbml_classes['Unit']['level'] = 5
jsbml_classes['Unit']['libSBML_analogue'] = None

# 'ListOf' Interface Class
jsbml_classes['ListOf']['name'] = 'ListOf'
jsbml_classes['ListOf']['hasParent'] = True
jsbml_classes['ListOf']['parentNode'] = None # TODO fill
jsbml_classes['ListOf']['hasChildren'] = False
jsbml_classes['ListOf']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['ListOf']['isInterface'] = False
jsbml_classes['ListOf']['hasParentInterface'] = True
jsbml_classes['ListOf']['hasChildrenInterface'] = False
jsbml_classes['ListOf']['isUniqueJSBML'] = False
jsbml_classes['ListOf']['level'] = 5
jsbml_classes['ListOf']['libSBML_analogue'] = None

# 'XMLNode' Interface Class
jsbml_classes['XMLNode']['name'] = 'XMLNode'
jsbml_classes['XMLNode']['hasParent'] = True
jsbml_classes['XMLNode']['parentNode'] = None # TODO fill
jsbml_classes['XMLNode']['hasChildren'] = False
jsbml_classes['XMLNode']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['XMLNode']['isInterface'] = False
jsbml_classes['XMLNode']['hasParentInterface'] = True
jsbml_classes['XMLNode']['hasChildrenInterface'] = False
jsbml_classes['XMLNode']['isUniqueJSBML'] = False
jsbml_classes['XMLNode']['level'] = 5
jsbml_classes['XMLNode']['libSBML_analogue'] = None

# 'Annotation' Interface Class
jsbml_classes['Annotation']['name'] = 'Annotation'
jsbml_classes['Annotation']['hasParent'] = True
jsbml_classes['Annotation']['parentNode'] = None # TODO fill
jsbml_classes['Annotation']['hasChildren'] = False
jsbml_classes['Annotation']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Annotation']['isInterface'] = False
jsbml_classes['Annotation']['hasParentInterface'] = True
jsbml_classes['Annotation']['hasChildrenInterface'] = False
jsbml_classes['Annotation']['isUniqueJSBML'] = False
jsbml_classes['Annotation']['level'] = 5
jsbml_classes['Annotation']['libSBML_analogue'] = None

# 'Creator' Interface Class
jsbml_classes['Creator']['name'] = 'Creator'
jsbml_classes['Creator']['hasParent'] = True
jsbml_classes['Creator']['parentNode'] = None # TODO fill
jsbml_classes['Creator']['hasChildren'] = False
jsbml_classes['Creator']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['Creator']['isInterface'] = False
jsbml_classes['Creator']['hasParentInterface'] = True
jsbml_classes['Creator']['hasChildrenInterface'] = False
jsbml_classes['Creator']['isUniqueJSBML'] = False
jsbml_classes['Creator']['level'] = 5
jsbml_classes['Creator']['libSBML_analogue'] = None

# 'CVTerm' Interface Class
jsbml_classes['CVTerm']['name'] = 'CVTerm'
jsbml_classes['CVTerm']['hasParent'] = True
jsbml_classes['CVTerm']['parentNode'] = None # TODO fill
jsbml_classes['CVTerm']['hasChildren'] = False
jsbml_classes['CVTerm']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['CVTerm']['isInterface'] = False
jsbml_classes['CVTerm']['hasParentInterface'] = True
jsbml_classes['CVTerm']['hasChildrenInterface'] = False
jsbml_classes['CVTerm']['isUniqueJSBML'] = False
jsbml_classes['CVTerm']['level'] = 5
jsbml_classes['CVTerm']['libSBML_analogue'] = None

# 'History' Interface Class
jsbml_classes['History']['name'] = 'History'
jsbml_classes['History']['hasParent'] = True
jsbml_classes['History']['parentNode'] = None # TODO fill
jsbml_classes['History']['hasChildren'] = False
jsbml_classes['History']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['History']['isInterface'] = False
jsbml_classes['History']['hasParentInterface'] = True
jsbml_classes['History']['hasChildrenInterface'] = False
jsbml_classes['History']['isUniqueJSBML'] = False
jsbml_classes['History']['level'] = 5
jsbml_classes['History']['libSBML_analogue'] = None

########################################################################

# Level 6

# 'NamedSBase' Interface Class
jsbml_classes['NamedSBase']['name'] = 'NamedSBase'
jsbml_classes['NamedSBase']['hasParent'] = True
jsbml_classes['NamedSBase']['parentNode'] = None # TODO fill
jsbml_classes['NamedSBase']['hasChildren'] = False
jsbml_classes['NamedSBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['NamedSBase']['isInterface'] = False
jsbml_classes['NamedSBase']['hasParentInterface'] = True
jsbml_classes['NamedSBase']['hasChildrenInterface'] = False
jsbml_classes['NamedSBase']['isUniqueJSBML'] = False
jsbml_classes['NamedSBase']['level'] = 6
jsbml_classes['NamedSBase']['libSBML_analogue'] = None

# 'SBaseWithDerivedUnit' Interface Class
jsbml_classes['SBaseWithDerivedUnit']['name'] = 'SBaseWithDerivedUnit'
jsbml_classes['SBaseWithDerivedUnit']['hasParent'] = True
jsbml_classes['SBaseWithDerivedUnit']['parentNode'] = None # TODO fill
jsbml_classes['SBaseWithDerivedUnit']['hasChildren'] = False
jsbml_classes['SBaseWithDerivedUnit']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SBaseWithDerivedUnit']['isInterface'] = False
jsbml_classes['SBaseWithDerivedUnit']['hasParentInterface'] = True
jsbml_classes['SBaseWithDerivedUnit']['hasChildrenInterface'] = False
jsbml_classes['SBaseWithDerivedUnit']['isUniqueJSBML'] = False
jsbml_classes['SBaseWithDerivedUnit']['level'] = 6
jsbml_classes['SBaseWithDerivedUnit']['libSBML_analogue'] = None

# 'AbstractSBase' Interface Class
jsbml_classes['AbstractSBase']['name'] = 'AbstractSBase'
jsbml_classes['AbstractSBase']['hasParent'] = True
jsbml_classes['AbstractSBase']['parentNode'] = None # TODO fill
jsbml_classes['AbstractSBase']['hasChildren'] = False
jsbml_classes['AbstractSBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AbstractSBase']['isInterface'] = False
jsbml_classes['AbstractSBase']['hasParentInterface'] = True
jsbml_classes['AbstractSBase']['hasChildrenInterface'] = False
jsbml_classes['AbstractSBase']['isUniqueJSBML'] = False
jsbml_classes['AbstractSBase']['level'] = 6
jsbml_classes['AbstractSBase']['libSBML_analogue'] = None

# 'AbstractSBasePlugin' Interface Class
jsbml_classes['AbstractSBasePlugin']['name'] = 'AbstractSBasePlugin'
jsbml_classes['AbstractSBasePlugin']['hasParent'] = True
jsbml_classes['AbstractSBasePlugin']['parentNode'] = None # TODO fill
jsbml_classes['AbstractSBasePlugin']['hasChildren'] = False
jsbml_classes['AbstractSBasePlugin']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AbstractSBasePlugin']['isInterface'] = False
jsbml_classes['AbstractSBasePlugin']['hasParentInterface'] = True
jsbml_classes['AbstractSBasePlugin']['hasChildrenInterface'] = False
jsbml_classes['AbstractSBasePlugin']['isUniqueJSBML'] = False
jsbml_classes['AbstractSBasePlugin']['level'] = 6
jsbml_classes['AbstractSBasePlugin']['libSBML_analogue'] = None

# 'TreeNodeAdapter' Interface Class
jsbml_classes['TreeNodeAdapter']['name'] = 'TreeNodeAdapter'
jsbml_classes['TreeNodeAdapter']['hasParent'] = True
jsbml_classes['TreeNodeAdapter']['parentNode'] = None # TODO fill
jsbml_classes['TreeNodeAdapter']['hasChildren'] = False
jsbml_classes['TreeNodeAdapter']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['TreeNodeAdapter']['isInterface'] = False
jsbml_classes['TreeNodeAdapter']['hasParentInterface'] = True
jsbml_classes['TreeNodeAdapter']['hasChildrenInterface'] = False
jsbml_classes['TreeNodeAdapter']['isUniqueJSBML'] = False
jsbml_classes['TreeNodeAdapter']['level'] = 6
jsbml_classes['TreeNodeAdapter']['libSBML_analogue'] = None

# 'ASTNode' Interface Class
jsbml_classes['ASTNode']['name'] = 'ASTNode'
jsbml_classes['ASTNode']['hasParent'] = True
jsbml_classes['ASTNode']['parentNode'] = None # TODO fill
jsbml_classes['ASTNode']['hasChildren'] = False
jsbml_classes['ASTNode']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['ASTNode']['isInterface'] = False
jsbml_classes['ASTNode']['hasParentInterface'] = True
jsbml_classes['ASTNode']['hasChildrenInterface'] = False
jsbml_classes['ASTNode']['isUniqueJSBML'] = False
jsbml_classes['ASTNode']['level'] = 6
jsbml_classes['ASTNode']['libSBML_analogue'] = None

# 'XMLToken' Interface Class
jsbml_classes['XMLToken']['name'] = 'XMLToken'
jsbml_classes['XMLToken']['hasParent'] = True
jsbml_classes['XMLToken']['parentNode'] = None # TODO fill
jsbml_classes['XMLToken']['hasChildren'] = False
jsbml_classes['XMLToken']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['XMLToken']['isInterface'] = False
jsbml_classes['XMLToken']['hasParentInterface'] = True
jsbml_classes['XMLToken']['hasChildrenInterface'] = False
jsbml_classes['XMLToken']['isUniqueJSBML'] = False
jsbml_classes['XMLToken']['level'] = 6
jsbml_classes['XMLToken']['libSBML_analogue'] = None

# 'AnnotationElement' Interface Class
jsbml_classes['AnnotationElement']['name'] = 'AnnotationElement'
jsbml_classes['AnnotationElement']['hasParent'] = True
jsbml_classes['AnnotationElement']['parentNode'] = None # TODO fill
jsbml_classes['AnnotationElement']['hasChildren'] = False
jsbml_classes['AnnotationElement']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AnnotationElement']['isInterface'] = False
jsbml_classes['AnnotationElement']['hasParentInterface'] = True
jsbml_classes['AnnotationElement']['hasChildrenInterface'] = False
jsbml_classes['AnnotationElement']['isUniqueJSBML'] = False
jsbml_classes['AnnotationElement']['level'] = 6
jsbml_classes['AnnotationElement']['libSBML_analogue'] = None

########################################################################

# Level 7

# 'SBase' Interface Class
jsbml_classes['SBase']['name'] = 'SBase'
jsbml_classes['SBase']['hasParent'] = True
jsbml_classes['SBase']['parentNode'] = None # TODO fill
jsbml_classes['SBase']['hasChildren'] = False
jsbml_classes['SBase']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SBase']['isInterface'] = False
jsbml_classes['SBase']['hasParentInterface'] = True
jsbml_classes['SBase']['hasChildrenInterface'] = False
jsbml_classes['SBase']['isUniqueJSBML'] = False
jsbml_classes['SBase']['level'] = 7
jsbml_classes['SBase']['libSBML_analogue'] = None

# 'SBasePlugin' Interface Class
jsbml_classes['SBasePlugin']['name'] = 'SBasePlugin'
jsbml_classes['SBasePlugin']['hasParent'] = True
jsbml_classes['SBasePlugin']['parentNode'] = None # TODO fill
jsbml_classes['SBasePlugin']['hasChildren'] = False
jsbml_classes['SBasePlugin']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SBasePlugin']['isInterface'] = False
jsbml_classes['SBasePlugin']['hasParentInterface'] = True
jsbml_classes['SBasePlugin']['hasChildrenInterface'] = False
jsbml_classes['SBasePlugin']['isUniqueJSBML'] = False
jsbml_classes['SBasePlugin']['level'] = 7
jsbml_classes['SBasePlugin']['libSBML_analogue'] = None

# 'AbstractTreeNode' Interface Class
jsbml_classes['AbstractTreeNode']['name'] = 'AbstractTreeNode'
jsbml_classes['AbstractTreeNode']['hasParent'] = True
jsbml_classes['AbstractTreeNode']['parentNode'] = None # TODO fill
jsbml_classes['AbstractTreeNode']['hasChildren'] = False
jsbml_classes['AbstractTreeNode']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['AbstractTreeNode']['isInterface'] = False
jsbml_classes['AbstractTreeNode']['hasParentInterface'] = True
jsbml_classes['AbstractTreeNode']['hasChildrenInterface'] = False
jsbml_classes['AbstractTreeNode']['isUniqueJSBML'] = False
jsbml_classes['AbstractTreeNode']['level'] = 7
jsbml_classes['AbstractTreeNode']['libSBML_analogue'] = None

# 'SimpleTreeNodeChangeListener' Interface Class
jsbml_classes['SimpleTreeNodeChangeListener']['name'] = 'SimpleTreeNodeChangeListener'
jsbml_classes['SimpleTreeNodeChangeListener']['hasParent'] = True
jsbml_classes['SimpleTreeNodeChangeListener']['parentNode'] = None # TODO fill
jsbml_classes['SimpleTreeNodeChangeListener']['hasChildren'] = False
jsbml_classes['SimpleTreeNodeChangeListener']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['SimpleTreeNodeChangeListener']['isInterface'] = False
jsbml_classes['SimpleTreeNodeChangeListener']['hasParentInterface'] = True
jsbml_classes['SimpleTreeNodeChangeListener']['hasChildrenInterface'] = False
jsbml_classes['SimpleTreeNodeChangeListener']['isUniqueJSBML'] = False
jsbml_classes['SimpleTreeNodeChangeListener']['level'] = 7
jsbml_classes['SimpleTreeNodeChangeListener']['libSBML_analogue'] = None

########################################################################

# Level 8

# 'TreeNodeWithChangeSupport' Interface Class
jsbml_classes['TreeNodeWithChangeSupport']['name'] = 'TreeNodeWithChangeSupport'
jsbml_classes['TreeNodeWithChangeSupport']['hasParent'] = True
jsbml_classes['TreeNodeWithChangeSupport']['parentNode'] = None # TODO fill
jsbml_classes['TreeNodeWithChangeSupport']['hasChildren'] = False
jsbml_classes['TreeNodeWithChangeSupport']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['TreeNodeWithChangeSupport']['isInterface'] = False
jsbml_classes['TreeNodeWithChangeSupport']['hasParentInterface'] = True
jsbml_classes['TreeNodeWithChangeSupport']['hasChildrenInterface'] = False
jsbml_classes['TreeNodeWithChangeSupport']['isUniqueJSBML'] = False
jsbml_classes['TreeNodeWithChangeSupport']['level'] = 8
jsbml_classes['TreeNodeWithChangeSupport']['libSBML_analogue'] = None

# 'TreeNodeChangeListener' Interface Class
jsbml_classes['TreeNodeChangeListener']['name'] = 'TreeNodeChangeListener'
jsbml_classes['TreeNodeChangeListener']['hasParent'] = True
jsbml_classes['TreeNodeChangeListener']['parentNode'] = None # TODO fill
jsbml_classes['TreeNodeChangeListener']['hasChildren'] = False
jsbml_classes['TreeNodeChangeListener']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['TreeNodeChangeListener']['isInterface'] = False
jsbml_classes['TreeNodeChangeListener']['hasParentInterface'] = True
jsbml_classes['TreeNodeChangeListener']['hasChildrenInterface'] = False
jsbml_classes['TreeNodeChangeListener']['isUniqueJSBML'] = False
jsbml_classes['TreeNodeChangeListener']['level'] = 8
jsbml_classes['TreeNodeChangeListener']['libSBML_analogue'] = None

# 'TreeNodeChangeEvent' Interface Class
jsbml_classes['TreeNodeChangeEvent']['name'] = 'TreeNodeChangeListener'
jsbml_classes['TreeNodeChangeEvent']['hasParent'] = True
jsbml_classes['TreeNodeChangeEvent']['parentNode'] = None # TODO fill
jsbml_classes['TreeNodeChangeEvent']['hasChildren'] = False
jsbml_classes['TreeNodeChangeEvent']['childrenNodes'] = [jsbml_classes['Species'], jsbml_classes['Parameter']]
jsbml_classes['TreeNodeChangeEvent']['isInterface'] = False
jsbml_classes['TreeNodeChangeEvent']['hasParentInterface'] = True
jsbml_classes['TreeNodeChangeEvent']['hasChildrenInterface'] = False
jsbml_classes['TreeNodeChangeEvent']['isUniqueJSBML'] = False
jsbml_classes['TreeNodeChangeEvent']['level'] = 8
jsbml_classes['TreeNodeChangeEvent']['libSBML_analogue'] = None

########################################################################

print(jsbml_classes['Symbol']['childrenNodes'][0])
print('--------------------------------------------')
print(jsbml_classes)