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

# Class Names

# Level 0

species = 'Species'
compartment = 'Compartment'
parameter = 'Parameter'

# Level 1
species_reference = 'SpeciesReference'
symbol = 'Symbol'
local_parameter = 'LocalParameter'
assignment_rule = 'AssignmentRule'
rate_rule = 'RateRule'

#Level 2
#TODO classes stuff
variable = 'Variable'
quantity_with_unit = 'QuantityWithUnit'
modifier_species_reference = 'ModifierSpeciesReference'
event = 'Event'
explicit_rule = 'ExplicitRule'
algebraic_rule = 'AlgrebraicRule'

#Level 3
quantity = 'Quantity'
reaction = 'Reaction'
function_definition = 'FunctionDefinition'
simple_species_reference = 'SimpleSpeciesReference'
model = 'Model'
species_type = 'SpeciesType'
compartment_type = 'CompartmentType'
unit_definition = 'UnitDefintion'
abstract_named_sbase_with_unit = 'AbstractNamedSBaseWithUnit'
kinetic_law = 'KineticLaw'
event_assignment = 'EventAssignment'
initial_assignment = 'InitialAssignment'
rule = 'Rule'
priority = 'Priority'
stoichiometry_math = 'StoichiometryMath'
trigger = 'Trigger'
constraint = 'Constraint'
delay = 'Delay'

# Level 4
compartmentalized_sbase = 'CompartmentalizedSBase'
callable_sbase = 'CallableSBase'
unique_named_sbase = 'UniqueNamedSBase'
abstract_named_sbase = 'AbstractNamedSBase'
sbase_with_unit = 'SBaseWithUnit'
assignment = 'Assignment'
abstract_math_container = 'AbstractMathContainer'

# Level 5
named_sbase_with_derived_unit = 'NamedSBaseWithDerivedUnit'
math_container = 'MathContainer'
sbml_document = 'SBMLDocument'
unit = 'Unit'
list_of = 'ListOf'
xml_node = 'XMLNode'
annotation = 'Annotation'
creator = 'Creator'
cv_term = 'CVTerm'
history = 'History'

# Level 6
named_sbase = 'NamedSBase'
sbase_with_derived_unit = 'SBaseWithDerivedUnit'
abstract_sbase = 'AbstractSBase'
abstract_sbase_plugin = 'AbstractSBasePlugin'
tree_node_adapter = 'TreeNodeAdapter'
ast_node = 'ASTNode'
xml_token = 'XMLToken'
annotation_element = 'AnnotationElement'

# Level 7
sbase = 'SBase'
sbase_plugin = 'SBasePlugin'
abstract_tree_node = 'AbstractTreeNode'
simple_tree_node_change_listener = 'SimpleTreeNodeChangeListener'

# Level 8
tree_node_with_change_support = 'TreeNodeWithChangeSupport'
tree_node_change_listener = 'TreeNodeChangeListener'
tree_node_change_event = 'TreeNodeChangeEvent'



######################################################################



#Level 0

# species Class
jsbml_classes[species]['name'] = species
jsbml_classes[species]['hasParent'] = True
jsbml_classes[species]['parentNode'] = symbol # TODO fill
jsbml_classes[species]['hasChildren'] = False
jsbml_classes[species]['childrenNodes'] = None
jsbml_classes[species]['isInterface'] = False
jsbml_classes[species]['parentInterfaces'] = ['CompartmentilizedSBase']
jsbml_classes[species]['childrenInterfaces'] = None
jsbml_classes[species]['isUniqueJSBML'] = False
jsbml_classes[species]['level'] = 0
jsbml_classes[species]['libSBML_analogue'] = None

# compartment Class
jsbml_classes[compartment]['name'] = compartment
jsbml_classes[compartment]['hasParent'] = True
jsbml_classes[compartment]['parentNode'] = symbol # TODO fill
jsbml_classes[compartment]['hasChildren'] = False
jsbml_classes[compartment]['childrenNode'] = None
jsbml_classes[compartment]['isInterface'] = False
jsbml_classes[compartment]['parentInterfaces'] = None
jsbml_classes[compartment]['childrenInterfaces'] = None
jsbml_classes[compartment]['isUniqueJSBML'] = False
jsbml_classes[compartment]['level'] = 0
jsbml_classes[compartment]['libSBML_analogue'] = None


print('-----------------------------------------')
# parameter Class
jsbml_classes[parameter]['name'] = parameter
jsbml_classes[parameter]['hasParent'] = True
jsbml_classes[parameter]['parentNode'] = symbol # TODO fill
jsbml_classes[parameter]['hasChildren'] = False
jsbml_classes[parameter]['childrenNodes'] = None
jsbml_classes[parameter]['isInterface'] = False
jsbml_classes[parameter]['parentInterfaces'] = None
jsbml_classes[parameter]['childrenInterfaces'] = None
jsbml_classes[parameter]['isUniqueJSBML'] = False
jsbml_classes[parameter]['level'] = 0
jsbml_classes[parameter]['libSBML_analogue'] = None



######################################################################

#Level 1

# symbol Class
jsbml_classes[symbol]['name'] = symbol
jsbml_classes[symbol]['hasParent'] = True
jsbml_classes[symbol]['parentNode'] = quantity_with_unit  # TODO fill
jsbml_classes[symbol]['hasChildren'] = True
jsbml_classes[symbol]['childrenNodes'] = [species, compartment, parameter]
jsbml_classes[symbol]['isInterface'] = False
jsbml_classes[symbol]['parentInterfaces'] = None
jsbml_classes[symbol]['childrenInterfaces'] = None
jsbml_classes[symbol]['isUniqueJSBML'] = True
jsbml_classes[symbol]['level'] = 1
jsbml_classes[symbol]['libSBML_analogue'] = None

# local_parameter Class
jsbml_classes[local_parameter]['name'] = local_parameter
jsbml_classes[local_parameter]['hasParent'] = True
jsbml_classes[local_parameter]['parentNode'] = quantity_with_unit  # TODO fill
jsbml_classes[local_parameter]['hasChildren'] = False
jsbml_classes[local_parameter]['childrenNodes'] = None
jsbml_classes[local_parameter]['isInterface'] = False
jsbml_classes[local_parameter]['parentInterfaces'] = None
jsbml_classes[local_parameter]['childrenInterfaces'] = None
jsbml_classes[local_parameter]['isUniqueJSBML'] = False
jsbml_classes[local_parameter]['level'] = 1
jsbml_classes[local_parameter]['libSBML_analogue'] = None


# species_reference Class
jsbml_classes[species_reference]['name'] = species_reference
jsbml_classes[species_reference]['hasParent'] = True
jsbml_classes[species_reference]['parentNode'] = simple_species_reference  # TODO fill
jsbml_classes[species_reference]['hasChildren'] = True
jsbml_classes[species_reference]['childrenNodes'] = [species_reference]
jsbml_classes[species_reference]['isInterface'] = False
jsbml_classes[species_reference]['parentInterfaces'] = [variable]
jsbml_classes[species_reference]['childrenInterfaces'] = None
jsbml_classes[species_reference]['isUniqueJSBML'] = False
jsbml_classes[species_reference]['level'] = 1
jsbml_classes[species_reference]['libSBML_analogue'] = None


# assignment_rule Class
jsbml_classes[assignment_rule]['name'] = assignment_rule
jsbml_classes[assignment_rule]['hasParent'] = True
jsbml_classes[assignment_rule]['parentNode'] = explicit_rule  # TODO fill
jsbml_classes[assignment_rule]['hasChildren'] = False
jsbml_classes[assignment_rule]['childrenNodes'] = None
jsbml_classes[assignment_rule]['isInterface'] = False
jsbml_classes[assignment_rule]['parentInterfaces'] = None
jsbml_classes[assignment_rule]['childrenInterfaces'] = None
jsbml_classes[assignment_rule]['isUniqueJSBML'] = False
jsbml_classes[assignment_rule]['level'] = 1
jsbml_classes[assignment_rule]['libSBML_analogue'] = None


# rate_rule Class
jsbml_classes[rate_rule]['name'] = assignment_rule
jsbml_classes[rate_rule]['hasParent'] = True
jsbml_classes[rate_rule]['parentNode'] = explicit_rule  # TODO fill
jsbml_classes[rate_rule]['hasChildren'] = False
jsbml_classes[rate_rule]['childrenNodes'] = None
jsbml_classes[rate_rule]['isInterface'] = False
jsbml_classes[rate_rule]['parentInterfaces'] = None
jsbml_classes[rate_rule]['childrenInterfaces'] = None
jsbml_classes[rate_rule]['isUniqueJSBML'] = False
jsbml_classes[rate_rule]['level'] = 1
jsbml_classes[rate_rule]['libSBML_analogue'] = None

########################################################################

# Level 2

# variable Interface Class
jsbml_classes[variable]['name'] = variable
jsbml_classes[variable]['hasParent'] = False
jsbml_classes[variable]['parentNode'] = None  # TODO fill
jsbml_classes[variable]['hasChildren'] = True
jsbml_classes[variable]['childrenNodes'] = [species_reference, symbol]
jsbml_classes[variable]['isInterface'] = True
jsbml_classes[variable]['parentInterfaces'] = [quantity, unique_named_sbase]
jsbml_classes[variable]['childrenInterfaces'] = None
jsbml_classes[variable]['isUniqueJSBML'] = True
jsbml_classes[variable]['level'] = 2
jsbml_classes[variable]['libSBML_analogue'] = None


# quantity_with_unit Interface Class
jsbml_classes[quantity_with_unit]['name'] = quantity_with_unit
jsbml_classes[quantity_with_unit]['hasParent'] = True
jsbml_classes[quantity_with_unit]['parentNode'] = abstract_named_sbase_with_unit  # TODO fill
jsbml_classes[quantity_with_unit]['hasChildren'] = True
jsbml_classes[quantity_with_unit]['childrenNodes'] = [symbol, local_parameter]
jsbml_classes[quantity_with_unit]['isInterface'] = False
jsbml_classes[quantity_with_unit]['parentInterfaces'] = [quantity]
jsbml_classes[quantity_with_unit]['childrenInterfaces'] = None
jsbml_classes[quantity_with_unit]['isUniqueJSBML'] = True
jsbml_classes[quantity_with_unit]['level'] = 2
jsbml_classes[quantity_with_unit]['libSBML_analogue'] = None

# modifier_species_reference Interface Class
jsbml_classes[modifier_species_reference]['name'] = modifier_species_reference
jsbml_classes[modifier_species_reference]['hasParent'] = True
jsbml_classes[modifier_species_reference]['parentNode'] = simple_species_reference # TODO fill
jsbml_classes[modifier_species_reference]['hasChildren'] = False
jsbml_classes[modifier_species_reference]['childrenNodes'] = None
jsbml_classes[modifier_species_reference]['isInterface'] = False
jsbml_classes[modifier_species_reference]['parentInterfaces'] = None
jsbml_classes[modifier_species_reference]['childrenInterfaces'] = None
jsbml_classes[modifier_species_reference]['isUniqueJSBML'] = False
jsbml_classes[modifier_species_reference]['level'] = 2
jsbml_classes[modifier_species_reference]['libSBML_analogue'] = None


# event Interface Class
jsbml_classes[event]['name'] = event
jsbml_classes[event]['hasParent'] = True
jsbml_classes[event]['parentNode'] = abstract_named_sbase_with_unit # TODO fill
jsbml_classes[event]['hasChildren'] = False
jsbml_classes[event]['childrenNodes'] = None
jsbml_classes[event]['isInterface'] = False
jsbml_classes[event]['parentInterfaces'] = [unique_named_sbase]
jsbml_classes[event]['childrenInterfaces'] = None
jsbml_classes[event]['isUniqueJSBML'] = False
jsbml_classes[event]['level'] = 2
jsbml_classes[event]['libSBML_analogue'] = None


# explicit_rule Interface Class
jsbml_classes[explicit_rule]['name'] = explicit_rule
jsbml_classes[explicit_rule]['hasParent'] = True
jsbml_classes[explicit_rule]['parentNode'] = rule # TODO fill
jsbml_classes[explicit_rule]['hasChildren'] = True
jsbml_classes[explicit_rule]['childrenNodes'] = [assignment_rule, rate_rule]
jsbml_classes[explicit_rule]['isInterface'] = False
jsbml_classes[explicit_rule]['parentInterfaces'] = [sbase_with_unit, assignment]
jsbml_classes[explicit_rule]['childrenInterfaces'] = None
jsbml_classes[explicit_rule]['isUniqueJSBML'] = True
jsbml_classes[explicit_rule]['level'] = 2
jsbml_classes[explicit_rule]['libSBML_analogue'] = None

# 'AlgebraicRule' Interface Class
jsbml_classes['AlgebraicRule']['name'] = algebraic_rule
jsbml_classes['AlgebraicRule']['hasParent'] = True
jsbml_classes['AlgebraicRule']['parentNode'] = rule  # TODO fill
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

# quantity Interface Class
jsbml_classes[quantity]['name'] = quantity
jsbml_classes[quantity]['hasParent'] = False
jsbml_classes[quantity]['parentNode'] = None # TODO fill
jsbml_classes[quantity]['hasChildren'] = False
jsbml_classes[quantity]['childrenNodes'] = [quantity_with_unit]
jsbml_classes[quantity]['isInterface'] = True
jsbml_classes[quantity]['parentInterfaces'] = [callable_sbase]
jsbml_classes[quantity]['childrenInterfaces'] = [variable]
jsbml_classes[quantity]['isUniqueJSBML'] = True
jsbml_classes[quantity]['level'] = 3
jsbml_classes[quantity]['libSBML_analogue'] = None

# reaction Class
jsbml_classes[reaction]['name'] = reaction
jsbml_classes[reaction]['hasParent'] = True
jsbml_classes[reaction]['parentNode'] = abstract_named_sbase # TODO fill
jsbml_classes[reaction]['hasChildren'] = False
jsbml_classes[reaction]['childrenNodes'] = None
jsbml_classes[reaction]['isInterface'] = False
jsbml_classes[reaction]['parentInterfaces'] = [compartmentalized_sbase, callable_sbase, unique_named_sbase]
jsbml_classes[reaction]['childrenInterfaces'] = None
jsbml_classes[reaction]['isUniqueJSBML'] = False
jsbml_classes[reaction]['level'] = 3
jsbml_classes[reaction]['libSBML_analogue'] = None

# function_definition  Class
jsbml_classes[function_definition]['name'] = function_definition
jsbml_classes[function_definition]['hasParent'] = True
jsbml_classes[function_definition]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[function_definition]['hasChildren'] = False
jsbml_classes[function_definition]['childrenNodes'] = None
jsbml_classes[function_definition]['isInterface'] = False
jsbml_classes[function_definition]['parentInterfaces'] = [callable_sbase, unique_named_sbase]
jsbml_classes[function_definition]['childrenInterfaces'] = None
jsbml_classes[function_definition]['isUniqueJSBML'] = False
jsbml_classes[function_definition]['level'] = 3
jsbml_classes[function_definition]['libSBML_analogue'] = None


# simple_species_reference  Class
jsbml_classes[simple_species_reference]['name'] = simple_species_reference
jsbml_classes[simple_species_reference]['hasParent'] = True
jsbml_classes[simple_species_reference]['parentNode'] = abstract_named_sbase # TODO fill
jsbml_classes[simple_species_reference]['hasChildren'] = True
jsbml_classes[simple_species_reference]['childrenNodes'] = [modifier_species_reference]
jsbml_classes[simple_species_reference]['isInterface'] = False
jsbml_classes[simple_species_reference]['parentInterfaces'] = [unique_named_sbase]
jsbml_classes[simple_species_reference]['childrenInterfaces'] = None
jsbml_classes[simple_species_reference]['isUniqueJSBML'] = False
jsbml_classes[simple_species_reference]['level'] = 3
jsbml_classes[simple_species_reference]['libSBML_analogue'] = None

# model Class
jsbml_classes[model]['name'] = model
jsbml_classes[model]['hasParent'] = True
jsbml_classes[model]['parentNode'] = abstract_named_sbase  # TODO fill
jsbml_classes[model]['hasChildren'] = False
jsbml_classes[model]['childrenNodes'] = None
jsbml_classes[model]['isInterface'] = False
jsbml_classes[model]['parentInterfaces'] = [unique_named_sbase]
jsbml_classes[model]['childrenInterfaces'] = None
jsbml_classes[model]['isUniqueJSBML'] = False
jsbml_classes[model]['level'] = 3
jsbml_classes[model]['libSBML_analogue'] = None

# species_type Interface Class
jsbml_classes[species_type]['name'] = species_type
jsbml_classes[species_type]['hasParent'] = True
jsbml_classes[species_type]['parentNode'] = abstract_named_sbase  # TODO fill
jsbml_classes[species_type]['hasChildren'] = False
jsbml_classes[species_type]['childrenNodes'] = None
jsbml_classes[species_type]['isInterface'] = False
jsbml_classes[species_type]['parentInterfaces'] = [unique_named_sbase]
jsbml_classes[species_type]['childrenInterfaces'] = False
jsbml_classes[species_type]['isUniqueJSBML'] = False
jsbml_classes[species_type]['level'] = 3
jsbml_classes[species_type]['libSBML_analogue'] = None

# compartment_type Interface Class
jsbml_classes[compartment_type]['name'] = compartment_type
jsbml_classes[compartment_type]['hasParent'] = True
jsbml_classes[compartment_type]['parentNode'] = abstract_named_sbase # TODO fill
jsbml_classes[compartment_type]['hasChildren'] = False
jsbml_classes[compartment_type]['childrenNodes'] = None
jsbml_classes[compartment_type]['isInterface'] = False
jsbml_classes[compartment_type]['parentInterfaces'] = [unique_named_sbase]
jsbml_classes[compartment_type]['childrenInterfaces'] = None
jsbml_classes[compartment_type]['isUniqueJSBML'] = False
jsbml_classes[compartment_type]['level'] = 3
jsbml_classes[compartment_type]['libSBML_analogue'] = None

# unit_definition Interface Class
jsbml_classes[unit_definition]['name'] = unit_definition
jsbml_classes[unit_definition]['hasParent'] = True
jsbml_classes[unit_definition]['parentNode'] = abstract_named_sbase  # TODO fill
jsbml_classes[unit_definition]['hasChildren'] = False
jsbml_classes[unit_definition]['childrenNodes'] = None
jsbml_classes[unit_definition]['isInterface'] = False
jsbml_classes[unit_definition]['parentInterfaces'] = None
jsbml_classes[unit_definition]['childrenInterfaces'] = None
jsbml_classes[unit_definition]['isUniqueJSBML'] = False
jsbml_classes[unit_definition]['level'] = 3
jsbml_classes[unit_definition]['libSBML_analogue'] = None

# abstract_named_sbase_with_unit  Class
jsbml_classes[abstract_named_sbase_with_unit]['name'] = abstract_named_sbase_with_unit
jsbml_classes[abstract_named_sbase_with_unit]['hasParent'] = True
jsbml_classes[abstract_named_sbase_with_unit]['parentNode'] = abstract_named_sbase  # TODO fill
jsbml_classes[abstract_named_sbase_with_unit]['hasChildren'] = True
jsbml_classes[abstract_named_sbase_with_unit]['childrenNodes'] = [event]
jsbml_classes[abstract_named_sbase_with_unit]['isInterface'] = False
jsbml_classes[abstract_named_sbase_with_unit]['parentInterfaces'] = [named_sbase_with_derived_unit, sbase_with_unit]
jsbml_classes[abstract_named_sbase_with_unit]['childrenInterfaces'] = None
jsbml_classes[abstract_named_sbase_with_unit]['isUniqueJSBML'] = True
jsbml_classes[abstract_named_sbase_with_unit]['level'] = 3
jsbml_classes[abstract_named_sbase_with_unit]['libSBML_analogue'] = None

# kinetic_law  Class
jsbml_classes[kinetic_law]['name'] = kinetic_law
jsbml_classes[kinetic_law]['hasParent'] = True
jsbml_classes[kinetic_law]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[kinetic_law]['hasChildren'] = False
jsbml_classes[kinetic_law]['childrenNodes'] = None
jsbml_classes[kinetic_law]['isInterface'] = False
jsbml_classes[kinetic_law]['parentInterfaces'] = [sbase_with_unit]
jsbml_classes[kinetic_law]['childrenInterfaces'] = None
jsbml_classes[kinetic_law]['isUniqueJSBML'] = False
jsbml_classes[kinetic_law]['level'] = 3
jsbml_classes[kinetic_law]['libSBML_analogue'] = None

# event_assignment  Class
jsbml_classes[event_assignment]['name'] = event_assignment
jsbml_classes[event_assignment]['hasParent'] = True
jsbml_classes[event_assignment]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[event_assignment]['hasChildren'] = False
jsbml_classes[event_assignment]['childrenNodes'] = None
jsbml_classes[event_assignment]['isInterface'] = False
jsbml_classes[event_assignment]['parentInterfaces'] = [assignment]
jsbml_classes[event_assignment]['childrenInterfaces'] = None
jsbml_classes[event_assignment]['isUniqueJSBML'] = False
jsbml_classes[event_assignment]['level'] = 3
jsbml_classes[event_assignment]['libSBML_analogue'] = None


# initial_assignment Class
jsbml_classes[initial_assignment]['name'] = initial_assignment
jsbml_classes[initial_assignment]['hasParent'] = True
jsbml_classes[initial_assignment]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[initial_assignment]['hasChildren'] = False
jsbml_classes[initial_assignment]['childrenNodes'] = None
jsbml_classes[initial_assignment]['isInterface'] = False
jsbml_classes[initial_assignment]['parentInterfaces'] = [assignment]
jsbml_classes[initial_assignment]['childrenInterfaces'] = None
jsbml_classes[initial_assignment]['isUniqueJSBML'] = False
jsbml_classes[initial_assignment]['level'] = 3
jsbml_classes[initial_assignment]['libSBML_analogue'] = None

# rule  Class
jsbml_classes[rule]['name'] = rule
jsbml_classes[rule]['hasParent'] = True
jsbml_classes[rule]['parentNode'] = abstract_math_container # TODO fill
jsbml_classes[rule]['hasChildren'] = True
jsbml_classes[rule]['childrenNodes'] = [explicit_rule, algebraic_rule]
jsbml_classes[rule]['isInterface'] = False
jsbml_classes[rule]['parentInterfaces'] = None
jsbml_classes[rule]['childrenInterfaces'] = None
jsbml_classes[rule]['isUniqueJSBML'] = False
jsbml_classes[rule]['level'] = 3
jsbml_classes[rule]['libSBML_analogue'] = None

# priority Interface Class
jsbml_classes[priority]['name'] = priority
jsbml_classes[priority]['hasParent'] = True
jsbml_classes[priority]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[priority]['hasChildren'] = False
jsbml_classes[priority]['childrenNodes'] = None
jsbml_classes[priority]['isInterface'] = False
jsbml_classes[priority]['parentInterfaces'] = None
jsbml_classes[priority]['childrenInterfaces'] = None
jsbml_classes[priority]['isUniqueJSBML'] = False
jsbml_classes[priority]['level'] = 3
jsbml_classes[priority]['libSBML_analogue'] = None

# stoichiometry_math Interface Class
jsbml_classes[stoichiometry_math]['name'] = stoichiometry_math
jsbml_classes[stoichiometry_math]['hasParent'] = True
jsbml_classes[stoichiometry_math]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[stoichiometry_math]['hasChildren'] = False
jsbml_classes[stoichiometry_math]['childrenNodes'] = None
jsbml_classes[stoichiometry_math]['isInterface'] = False
jsbml_classes[stoichiometry_math]['parentInterfaces'] = None
jsbml_classes[stoichiometry_math]['childrenInterfaces'] = None
jsbml_classes[stoichiometry_math]['isUniqueJSBML'] = False
jsbml_classes[stoichiometry_math]['level'] = 3
jsbml_classes[stoichiometry_math]['libSBML_analogue'] = None

# trigger Interface Class
jsbml_classes[trigger]['name'] = trigger
jsbml_classes[trigger]['hasParent'] = True
jsbml_classes[trigger]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[trigger]['hasChildren'] = False
jsbml_classes[trigger]['childrenNodes'] = None
jsbml_classes[trigger]['isInterface'] = False
jsbml_classes[trigger]['parentInterfaces'] = None
jsbml_classes[trigger]['childrenInterfaces'] = None
jsbml_classes[trigger]['isUniqueJSBML'] = False
jsbml_classes[trigger]['level'] = 3
jsbml_classes[trigger]['libSBML_analogue'] = None

# constraint Interface Class
jsbml_classes[constraint]['name'] = constraint
jsbml_classes[constraint]['hasParent'] = True
jsbml_classes[constraint]['parentNode'] = abstract_math_container # TODO fill
jsbml_classes[constraint]['hasChildren'] = False
jsbml_classes[constraint]['childrenNodes'] = None
jsbml_classes[constraint]['isInterface'] = False
jsbml_classes[constraint]['parentInterfaces'] = None
jsbml_classes[constraint]['childrenInterfaces'] = None
jsbml_classes[constraint]['isUniqueJSBML'] = False
jsbml_classes[constraint]['level'] = 3
jsbml_classes[constraint]['libSBML_analogue'] = None

# delay Interface Class
jsbml_classes[delay]['name'] = delay
jsbml_classes[delay]['hasParent'] = True
jsbml_classes[delay]['parentNode'] = abstract_math_container  # TODO fill
jsbml_classes[delay]['hasChildren'] = False
jsbml_classes[delay]['childrenNodes'] = None
jsbml_classes[delay]['isInterface'] = False
jsbml_classes[delay]['parentInterfaces'] = None
jsbml_classes[delay]['childrenInterfaces'] = None
jsbml_classes[delay]['isUniqueJSBML'] = False
jsbml_classes[delay]['level'] = 3
jsbml_classes[delay]['libSBML_analogue'] = None


########################################################################

# Level 4

# compartmentalized_sbase Interface
jsbml_classes[compartmentalized_sbase]['name'] = compartmentalized_sbase
jsbml_classes[compartmentalized_sbase]['hasParent'] = None
jsbml_classes[compartmentalized_sbase]['parentNode'] = None # TODO fill
jsbml_classes[compartmentalized_sbase]['hasChildren'] = True
jsbml_classes[compartmentalized_sbase]['childrenNodes'] = [species, reaction]
jsbml_classes[compartmentalized_sbase]['isInterface'] = True
jsbml_classes[compartmentalized_sbase]['parentInterfaces'] = [named_sbase]
jsbml_classes[compartmentalized_sbase]['childrenInterfaces'] = None
jsbml_classes[compartmentalized_sbase]['isUniqueJSBML'] = True
jsbml_classes[compartmentalized_sbase]['level'] = 4
jsbml_classes[compartmentalized_sbase]['libSBML_analogue'] = None

# callable_sbase Interface
jsbml_classes[callable_sbase]['name'] = callable_sbase
jsbml_classes[callable_sbase]['hasParent'] = False
jsbml_classes[callable_sbase]['parentNode'] = None # TODO fill
jsbml_classes[callable_sbase]['hasChildren'] = True
jsbml_classes[callable_sbase]['childrenNodes'] = [reaction, function_definition]
jsbml_classes[callable_sbase]['isInterface'] = True
jsbml_classes[callable_sbase]['parentInterfaces'] = [named_sbase_with_derived_unit]
jsbml_classes[callable_sbase]['childrenInterfaces'] = [quantity]
jsbml_classes[callable_sbase]['isUniqueJSBML'] = True
jsbml_classes[callable_sbase]['level'] = 4
jsbml_classes[callable_sbase]['libSBML_analogue'] = None

# unique_named_sbase Interface
jsbml_classes[unique_named_sbase]['name'] = unique_named_sbase
jsbml_classes[unique_named_sbase]['hasParent'] = False
jsbml_classes[unique_named_sbase]['parentNode'] = None # TODO fill
jsbml_classes[unique_named_sbase]['hasChildren'] = True
jsbml_classes[unique_named_sbase]['childrenNodes'] = [reaction, function_definition, simple_species_reference, model,
                                                      species_type, compartment_type]
jsbml_classes[unique_named_sbase]['isInterface'] = True
jsbml_classes[unique_named_sbase]['parentInterfaces'] = [named_sbase]
jsbml_classes[unique_named_sbase]['childrenInterfaces'] = [variable]
jsbml_classes[unique_named_sbase]['isUniqueJSBML'] = True
jsbml_classes[unique_named_sbase]['level'] = 4
jsbml_classes[unique_named_sbase]['libSBML_analogue'] = None

# abstract_named_sbase  Class
jsbml_classes[abstract_named_sbase]['name'] = abstract_named_sbase
jsbml_classes[abstract_named_sbase]['hasParent'] = True
jsbml_classes[abstract_named_sbase]['parentNode'] = abstract_sbase # TODO fill
jsbml_classes[abstract_named_sbase]['hasChildren'] = True
jsbml_classes[abstract_named_sbase]['childrenNodes'] = [reaction, function_definition, simple_species_reference,
                                                        model, species_type, compartment_type, unit_definition,
                                                        abstract_named_sbase_with_unit]
jsbml_classes[abstract_named_sbase]['isInterface'] = False
jsbml_classes[abstract_named_sbase]['parentInterfaces'] = [named_sbase]
jsbml_classes[abstract_named_sbase]['childrenInterfaces'] = None
jsbml_classes[abstract_named_sbase]['isUniqueJSBML'] = True
jsbml_classes[abstract_named_sbase]['level'] = 4
jsbml_classes[abstract_named_sbase]['libSBML_analogue'] = None

# sbase_with_unit Interface
jsbml_classes[sbase_with_unit]['name'] = sbase_with_unit
jsbml_classes[sbase_with_unit]['hasParent'] = False
jsbml_classes[sbase_with_unit]['parentNode'] = None # TODO fill
jsbml_classes[sbase_with_unit]['hasChildren'] = True
jsbml_classes[sbase_with_unit]['childrenNodes'] = [abstract_named_sbase_with_unit, explicit_rule,
                                                  kinetic_law]
jsbml_classes[sbase_with_unit]['isInterface'] = True
jsbml_classes[sbase_with_unit]['parentInterfaces'] = [sbase_with_derived_unit]
jsbml_classes[sbase_with_unit]['childrenInterfaces'] = None
jsbml_classes[sbase_with_unit]['isUniqueJSBML'] = True
jsbml_classes[sbase_with_unit]['level'] = 4
jsbml_classes[sbase_with_unit]['libSBML_analogue'] = None

# assignment Interface
jsbml_classes[assignment]['name'] = assignment
jsbml_classes[assignment]['hasParent'] = False
jsbml_classes[assignment]['parentNode'] = None # TODO fill
jsbml_classes[assignment]['hasChildren'] = True
jsbml_classes[assignment]['childrenNodes'] = [explicit_rule, event_assignment, initial_assignment]
jsbml_classes[assignment]['isInterface'] = True
jsbml_classes[assignment]['parentInterfaces'] = [math_container]
jsbml_classes[assignment]['childrenInterfaces'] = None
jsbml_classes[assignment]['isUniqueJSBML'] = True
jsbml_classes[assignment]['level'] = 4
jsbml_classes[assignment]['libSBML_analogue'] = None

# abstract_math_container Class
jsbml_classes[abstract_math_container]['name'] = abstract_math_container
jsbml_classes[abstract_math_container]['hasParent'] = True
jsbml_classes[abstract_math_container]['parentNode'] = abstract_sbase # TODO fill
jsbml_classes[abstract_math_container]['hasChildren'] = True
jsbml_classes[abstract_math_container]['childrenNodes'] = [function_definition, kinetic_law, event_assignment,
                                                           initial_assignment, rule, priority, stoichiometry_math,
                                                           trigger, constraint, delay]
jsbml_classes[abstract_math_container]['isInterface'] = False
jsbml_classes[abstract_math_container]['parentInterfaces'] = [math_container]
jsbml_classes[abstract_math_container]['childrenInterfaces'] = None
jsbml_classes[abstract_math_container]['isUniqueJSBML'] = True
jsbml_classes[abstract_math_container]['level'] = 4
jsbml_classes[abstract_math_container]['libSBML_analogue'] = None

########################################################################

# Level 5

# named_sbase_with_derived_unit Interface
jsbml_classes[named_sbase_with_derived_unit]['name'] = named_sbase_with_derived_unit
jsbml_classes[named_sbase_with_derived_unit]['hasParent'] = False
jsbml_classes[named_sbase_with_derived_unit]['parentNode'] = None # TODO fill
jsbml_classes[named_sbase_with_derived_unit]['hasChildren'] = True
jsbml_classes[named_sbase_with_derived_unit]['childrenNodes'] = [callable_sbase]
jsbml_classes[named_sbase_with_derived_unit]['isInterface'] = True
jsbml_classes[named_sbase_with_derived_unit]['parentInterfaces'] = [named_sbase]
jsbml_classes[named_sbase_with_derived_unit]['childrenInterfaces'] = [abstract_named_sbase_with_unit]
jsbml_classes[named_sbase_with_derived_unit]['isUniqueJSBML'] = True
jsbml_classes[named_sbase_with_derived_unit]['level'] = 5
jsbml_classes[named_sbase_with_derived_unit]['libSBML_analogue'] = None

# math_container Interface
jsbml_classes[math_container]['name'] = math_container
jsbml_classes[math_container]['hasParent'] = False
jsbml_classes[math_container]['parentNode'] = None # TODO fill
jsbml_classes[math_container]['hasChildren'] = True
jsbml_classes[math_container]['childrenNodes'] = [abstract_math_container]
jsbml_classes[math_container]['isInterface'] = True
jsbml_classes[math_container]['parentInterfaces'] = [sbase_with_derived_unit]
jsbml_classes[math_container]['childrenInterfaces'] = [assignment]
jsbml_classes[math_container]['isUniqueJSBML'] = True
jsbml_classes[math_container]['level'] = 5
jsbml_classes[math_container]['libSBML_analogue'] = None


# sbml_document  Class
jsbml_classes[sbml_document]['name'] = sbml_document
jsbml_classes[sbml_document]['hasParent'] = True
jsbml_classes[sbml_document]['parentNode'] = abstract_sbase # TODO fill
jsbml_classes[sbml_document]['hasChildren'] = False
jsbml_classes[sbml_document]['childrenNodes'] = None
jsbml_classes[sbml_document]['isInterface'] = False
jsbml_classes[sbml_document]['parentInterfaces'] = None
jsbml_classes[sbml_document]['childrenInterfaces'] = None
jsbml_classes[sbml_document]['isUniqueJSBML'] = False
jsbml_classes[sbml_document]['level'] = 5
jsbml_classes[sbml_document]['libSBML_analogue'] = None

# unit Interface Class
jsbml_classes[unit]['name'] = unit
jsbml_classes[unit]['hasParent'] = True
jsbml_classes[unit]['parentNode'] = abstract_sbase  # TODO fill
jsbml_classes[unit]['hasChildren'] = False
jsbml_classes[unit]['childrenNodes'] = None
jsbml_classes[unit]['isInterface'] = False
jsbml_classes[unit]['parentInterfaces'] = None
jsbml_classes[unit]['childrenInterfaces'] = None
jsbml_classes[unit]['isUniqueJSBML'] = False
jsbml_classes[unit]['level'] = 5
jsbml_classes[unit]['libSBML_analogue'] = None

# list_of Class
jsbml_classes[list_of]['name'] = list_of
jsbml_classes[list_of]['hasParent'] = True
jsbml_classes[list_of]['parentNode'] = abstract_sbase # TODO fill
jsbml_classes[list_of]['hasChildren'] = False
jsbml_classes[list_of]['childrenNodes'] = None
jsbml_classes[list_of]['isInterface'] = False
jsbml_classes[list_of]['parentInterfaces'] = ['List'] # TODO with java types
jsbml_classes[list_of]['childrenInterfaces'] = None
jsbml_classes[list_of]['isUniqueJSBML'] = False
jsbml_classes[list_of]['level'] = 5
jsbml_classes[list_of]['libSBML_analogue'] = None

# xml_node Interface Class
jsbml_classes[xml_node]['name'] = xml_node
jsbml_classes[xml_node]['hasParent'] = True
jsbml_classes[xml_node]['parentNode'] = xml_token # TODO fill
jsbml_classes[xml_node]['hasChildren'] = False
jsbml_classes[xml_node]['childrenNodes'] = None
jsbml_classes[xml_node]['isInterface'] = False
jsbml_classes[xml_node]['parentInterfaces'] = None
jsbml_classes[xml_node]['childrenInterfaces'] = None
jsbml_classes[xml_node]['isUniqueJSBML'] = False
jsbml_classes[xml_node]['level'] = 5
jsbml_classes[xml_node]['libSBML_analogue'] = None

# annotation  Class
jsbml_classes[annotation]['name'] = annotation
jsbml_classes[annotation]['hasParent'] = True
jsbml_classes[annotation]['parentNode'] = annotation_element # TODO fill
jsbml_classes[annotation]['hasChildren'] = False
jsbml_classes[annotation]['childrenNodes'] = None
jsbml_classes[annotation]['isInterface'] = False
jsbml_classes[annotation]['parentInterfaces'] = None
jsbml_classes[annotation]['childrenInterfaces'] = None
jsbml_classes[annotation]['isUniqueJSBML'] = True
jsbml_classes[annotation]['level'] = 5
jsbml_classes[annotation]['libSBML_analogue'] = None

# creator Class
jsbml_classes[creator]['name'] = creator
jsbml_classes[creator]['hasParent'] = True
jsbml_classes[creator]['parentNode'] = annotation_element # TODO fill
jsbml_classes[creator]['hasChildren'] = False
jsbml_classes[creator]['childrenNodes'] = None
jsbml_classes[creator]['isInterface'] = False
jsbml_classes[creator]['parentInterfaces'] = None
jsbml_classes[creator]['childrenInterfaces'] = None
jsbml_classes[creator]['isUniqueJSBML'] = False
jsbml_classes[creator]['level'] = 5
jsbml_classes[creator]['libSBML_analogue'] = 'ModelCreator'

# cv_term  Class
jsbml_classes[cv_term]['name'] = cv_term
jsbml_classes[cv_term]['hasParent'] = True
jsbml_classes[cv_term]['parentNode'] = annotation_element # TODO fill
jsbml_classes[cv_term]['hasChildren'] = False
jsbml_classes[cv_term]['childrenNodes'] = None
jsbml_classes[cv_term]['isInterface'] = False
jsbml_classes[cv_term]['parentInterfaces'] = None
jsbml_classes[cv_term]['childrenInterfaces'] = None
jsbml_classes[cv_term]['isUniqueJSBML'] = False
jsbml_classes[cv_term]['level'] = 5
jsbml_classes[cv_term]['libSBML_analogue'] = None

# history Interface Class
jsbml_classes[history]['name'] = history
jsbml_classes[history]['hasParent'] = True
jsbml_classes[history]['parentNode'] = annotation_element  # TODO fill
jsbml_classes[history]['hasChildren'] = False
jsbml_classes[history]['childrenNodes'] = None
jsbml_classes[history]['isInterface'] = False
jsbml_classes[history]['parentInterfaces'] = None
jsbml_classes[history]['childrenInterfaces'] = None
jsbml_classes[history]['isUniqueJSBML'] = False
jsbml_classes[history]['level'] = 5
jsbml_classes[history]['libSBML_analogue'] = 'ModelHistory'

########################################################################

# Level 6

# named_sbase Interface
jsbml_classes[named_sbase]['name'] = named_sbase
jsbml_classes[named_sbase]['hasParent'] = False
jsbml_classes[named_sbase]['parentNode'] = None # TODO fill
jsbml_classes[named_sbase]['hasChildren'] = False
jsbml_classes[named_sbase]['childrenNodes'] = None
jsbml_classes[named_sbase]['isInterface'] = True
jsbml_classes[named_sbase]['parentInterfaces'] = [sbase]
jsbml_classes[named_sbase]['childrenInterfaces'] = [compartmentalized_sbase, unique_named_sbase,
                                                    named_sbase_with_derived_unit]
jsbml_classes[named_sbase]['isUniqueJSBML'] = True
jsbml_classes[named_sbase]['level'] = 6
jsbml_classes[named_sbase]['libSBML_analogue'] = None

# sbase_with_derived_unit Interface
jsbml_classes[sbase_with_derived_unit]['name'] = sbase_with_derived_unit
jsbml_classes[sbase_with_derived_unit]['hasParent'] = False
jsbml_classes[sbase_with_derived_unit]['parentNode'] = None # TODO fill
jsbml_classes[sbase_with_derived_unit]['hasChildren'] = False
jsbml_classes[sbase_with_derived_unit]['childrenNodes'] = None
jsbml_classes[sbase_with_derived_unit]['isInterface'] = True
jsbml_classes[sbase_with_derived_unit]['parentInterfaces'] = [sbase]
jsbml_classes[sbase_with_derived_unit]['childrenInterfaces'] = [named_sbase_with_derived_unit, sbase_with_unit,
                                                                math_container]
jsbml_classes[sbase_with_derived_unit]['isUniqueJSBML'] = True
jsbml_classes[sbase_with_derived_unit]['level'] = 6
jsbml_classes[sbase_with_derived_unit]['libSBML_analogue'] = None

# abstract_sbase  Class
jsbml_classes[abstract_sbase]['name'] = abstract_sbase
jsbml_classes[abstract_sbase]['hasParent'] = True
jsbml_classes[abstract_sbase]['parentNode'] = abstract_tree_node # TODO fill
jsbml_classes[abstract_sbase]['hasChildren'] = True
jsbml_classes[abstract_sbase]['childrenNodes'] = [abstract_named_sbase, abstract_math_container, sbml_document,
                                                  unit, list_of]
jsbml_classes[abstract_sbase]['isInterface'] = False
jsbml_classes[abstract_sbase]['parentInterfaces'] = [sbase]
jsbml_classes[abstract_sbase]['childrenInterfaces'] = None
jsbml_classes[abstract_sbase]['isUniqueJSBML'] = True
jsbml_classes[abstract_sbase]['level'] = 6
jsbml_classes[abstract_sbase]['libSBML_analogue'] = None

# abstract_sbase_plugin  Class # TODO special case
jsbml_classes[abstract_sbase_plugin]['name'] = abstract_sbase_plugin
jsbml_classes[abstract_sbase_plugin]['hasParent'] = True
jsbml_classes[abstract_sbase_plugin]['parentNode'] = abstract_tree_node # TODO fill
jsbml_classes[abstract_sbase_plugin]['hasChildren'] = False
jsbml_classes[abstract_sbase_plugin]['childrenNodes'] = None
jsbml_classes[abstract_sbase_plugin]['isInterface'] = False
jsbml_classes[abstract_sbase_plugin]['parentInterfaces'] = None
jsbml_classes[abstract_sbase_plugin]['childrenInterfaces'] = None
jsbml_classes[abstract_sbase_plugin]['isUniqueJSBML'] = True
jsbml_classes[abstract_sbase_plugin]['level'] = 6
jsbml_classes[abstract_sbase_plugin]['libSBML_analogue'] = None

# tree_node_adapter  Class
jsbml_classes[tree_node_adapter]['name'] = tree_node_adapter
jsbml_classes[tree_node_adapter]['hasParent'] = True
jsbml_classes[tree_node_adapter]['parentNode'] = abstract_tree_node # TODO fill
jsbml_classes[tree_node_adapter]['hasChildren'] = False
jsbml_classes[tree_node_adapter]['childrenNodes'] = None
jsbml_classes[tree_node_adapter]['isInterface'] = False
jsbml_classes[tree_node_adapter]['parentInterfaces'] = None
jsbml_classes[tree_node_adapter]['childrenInterfaces'] = None
jsbml_classes[tree_node_adapter]['isUniqueJSBML'] = True
jsbml_classes[tree_node_adapter]['level'] = 6
jsbml_classes[tree_node_adapter]['libSBML_analogue'] = None

# ast_node Class
jsbml_classes[ast_node]['name'] = ast_node
jsbml_classes[ast_node]['hasParent'] = True
jsbml_classes[ast_node]['parentNode'] = abstract_tree_node # TODO fill
jsbml_classes[ast_node]['hasChildren'] = False
jsbml_classes[ast_node]['childrenNodes'] = None
jsbml_classes[ast_node]['isInterface'] = False
jsbml_classes[ast_node]['parentInterfaces'] = None
jsbml_classes[ast_node]['childrenInterfaces'] = None
jsbml_classes[ast_node]['isUniqueJSBML'] = False
jsbml_classes[ast_node]['level'] = 6
jsbml_classes[ast_node]['libSBML_analogue'] = None

# xml_token Class
jsbml_classes[xml_token]['name'] = xml_token
jsbml_classes[xml_token]['hasParent'] = True
jsbml_classes[xml_token]['parentNode'] = abstract_tree_node # TODO fill
jsbml_classes[xml_token]['hasChildren'] = True
jsbml_classes[xml_token]['childrenNodes'] = [xml_node]
jsbml_classes[xml_token]['isInterface'] = False
jsbml_classes[xml_token]['parentInterfaces'] = None
jsbml_classes[xml_token]['childrenInterfaces'] = None
jsbml_classes[xml_token]['isUniqueJSBML'] = False
jsbml_classes[xml_token]['level'] = 6
jsbml_classes[xml_token]['libSBML_analogue'] = None

# annotation_element  Class
jsbml_classes[annotation_element]['name'] = annotation_element
jsbml_classes[annotation_element]['hasParent'] = True
jsbml_classes[annotation_element]['parentNode'] = abstract_tree_node # TODO fill
jsbml_classes[annotation_element]['hasChildren'] = True
jsbml_classes[annotation_element]['childrenNodes'] = [annotation, creator, cv_term, history]
jsbml_classes[annotation_element]['isInterface'] = False
jsbml_classes[annotation_element]['parentInterfaces'] = None
jsbml_classes[annotation_element]['childrenInterfaces'] = None
jsbml_classes[annotation_element]['isUniqueJSBML'] = True
jsbml_classes[annotation_element]['level'] = 6
jsbml_classes[annotation_element]['libSBML_analogue'] = None

########################################################################

# Level 7

# sbase Interface
jsbml_classes[sbase]['name'] = sbase
jsbml_classes[sbase]['hasParent'] = False
jsbml_classes[sbase]['parentNode'] = None # TODO fill
jsbml_classes[sbase]['hasChildren'] = False
jsbml_classes[sbase]['childrenNodes'] = None
jsbml_classes[sbase]['isInterface'] = True
jsbml_classes[sbase]['parentInterfaces'] = [tree_node_with_change_support]
jsbml_classes[sbase]['childrenInterfaces'] = [named_sbase, sbase_with_derived_unit, abstract_sbase]
jsbml_classes[sbase]['isUniqueJSBML'] = False
jsbml_classes[sbase]['level'] = 7
jsbml_classes[sbase]['libSBML_analogue'] = None

# sbase_plugin Interface
jsbml_classes[sbase_plugin]['name'] = sbase_plugin
jsbml_classes[sbase_plugin]['hasParent'] = False
jsbml_classes[sbase_plugin]['parentNode'] = None # TODO fill
jsbml_classes[sbase_plugin]['hasChildren'] = False
jsbml_classes[sbase_plugin]['childrenNodes'] = [abstract_sbase_plugin]
jsbml_classes[sbase_plugin]['isInterface'] = True
jsbml_classes[sbase_plugin]['parentInterfaces'] = [tree_node_with_change_support]
jsbml_classes[sbase_plugin]['childrenInterfaces'] = None
jsbml_classes[sbase_plugin]['isUniqueJSBML'] = False
jsbml_classes[sbase_plugin]['level'] = 7
jsbml_classes[sbase_plugin]['libSBML_analogue'] = None

# abstract_tree_node  Class
jsbml_classes[abstract_tree_node]['name'] = abstract_tree_node
jsbml_classes[abstract_tree_node]['hasParent'] = True
jsbml_classes[abstract_tree_node]['parentNode'] = 'Object' # TODO java type fill
jsbml_classes[abstract_tree_node]['hasChildren'] = True
jsbml_classes[abstract_tree_node]['childrenNodes'] = [abstract_sbase, abstract_sbase_plugin, tree_node_adapter,
                                                      ast_node, xml_token, annotation_element]
jsbml_classes[abstract_tree_node]['isInterface'] = False
jsbml_classes[abstract_tree_node]['parentInterfaces'] = [tree_node_with_change_support]
jsbml_classes[abstract_tree_node]['childrenInterfaces'] = None
jsbml_classes[abstract_tree_node]['isUniqueJSBML'] = True
jsbml_classes[abstract_tree_node]['level'] = 7
jsbml_classes[abstract_tree_node]['libSBML_analogue'] = None

# simple_tree_node_change_listener  Class
jsbml_classes[simple_tree_node_change_listener]['name'] = simple_tree_node_change_listener
jsbml_classes[simple_tree_node_change_listener]['hasParent'] = True
jsbml_classes[simple_tree_node_change_listener]['parentNode'] = 'Object' # TODO  Java type fill
jsbml_classes[simple_tree_node_change_listener]['hasChildren'] = False
jsbml_classes[simple_tree_node_change_listener]['childrenNodes'] = None
jsbml_classes[simple_tree_node_change_listener]['isInterface'] = False
jsbml_classes[simple_tree_node_change_listener]['parentInterfaces'] = [tree_node_change_listener]
jsbml_classes[simple_tree_node_change_listener]['childrenInterfaces'] = None
jsbml_classes[simple_tree_node_change_listener]['isUniqueJSBML'] = True
jsbml_classes[simple_tree_node_change_listener]['level'] = 7
jsbml_classes[simple_tree_node_change_listener]['libSBML_analogue'] = None

########################################################################

# Level 8

# tree_node_with_change_support Interface
jsbml_classes[tree_node_with_change_support]['name'] = tree_node_with_change_support
jsbml_classes[tree_node_with_change_support]['hasParent'] = False
jsbml_classes[tree_node_with_change_support]['parentNode'] = None # TODO fill
jsbml_classes[tree_node_with_change_support]['hasChildren'] = True
jsbml_classes[tree_node_with_change_support]['childrenNodes'] = abstract_tree_node
jsbml_classes[tree_node_with_change_support]['isInterface'] = True
jsbml_classes[tree_node_with_change_support]['parentInterfaces'] = ['TreeNode', 'Serializable','Cloneable']
jsbml_classes[tree_node_with_change_support]['childrenInterfaces'] =  [sbase, sbase_plugin]
jsbml_classes[tree_node_with_change_support]['isUniqueJSBML'] = True
jsbml_classes[tree_node_with_change_support]['level'] = 8
jsbml_classes[tree_node_with_change_support]['libSBML_analogue'] = None

# tree_node_change_listener Interface Class
jsbml_classes[tree_node_change_listener]['name'] = tree_node_change_listener
jsbml_classes[tree_node_change_listener]['hasParent'] = False
jsbml_classes[tree_node_change_listener]['parentNode'] = None # TODO fill
jsbml_classes[tree_node_change_listener]['hasChildren'] = False
jsbml_classes[tree_node_change_listener]['childrenNodes'] = None
jsbml_classes[tree_node_change_listener]['isInterface'] = True
jsbml_classes[tree_node_change_listener]['parentInterfaces'] = ['PropertyChangeListener']
jsbml_classes[tree_node_change_listener]['childrenInterfaces'] = simple_tree_node_change_listener
jsbml_classes[tree_node_change_listener]['isUniqueJSBML'] = True
jsbml_classes[tree_node_change_listener]['level'] = 8
jsbml_classes[tree_node_change_listener]['libSBML_analogue'] = None

# tree_node_change_event  Class
jsbml_classes[tree_node_change_event]['name'] = tree_node_change_listener
jsbml_classes[tree_node_change_event]['hasParent'] = True
jsbml_classes[tree_node_change_event]['parentNode'] = 'PropertyChangeEvent'# TODO fill
jsbml_classes[tree_node_change_event]['hasChildren'] = False
jsbml_classes[tree_node_change_event]['childrenNodes'] = None
jsbml_classes[tree_node_change_event]['isInterface'] = False
jsbml_classes[tree_node_change_event]['parentInterfaces'] = None
jsbml_classes[tree_node_change_event]['childrenInterfaces'] = None
jsbml_classes[tree_node_change_event]['isUniqueJSBML'] = True
jsbml_classes[tree_node_change_event]['level'] = 8
jsbml_classes[tree_node_change_event]['libSBML_analogue'] = None

########################################################################

print('--------------------------------------------')
print(jsbml_classes)