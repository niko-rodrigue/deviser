#!/usr/bin/env python
#
# @file    jsbml_data_tree.py
# @brief   tree structure for JSBML classes for GSoC 2016
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


# Custom dict for support of older Python versions
class MyDefaultDict(dict):
    def __init__(self, default_factory=None, *a, **kw):
        if (default_factory is not None and
                not hasattr(default_factory, '__call__')):
            raise TypeError('first argument must be callable')
        dict.__init__(self, *a, **kw)
        self.default_factory = default_factory

    def __getitem__(self, key):
        try:
            return dict.__getitem__(self, key)
        except KeyError:
            return self.__missing__(key)

    def __missing__(self, key):
        if self.default_factory is None:
            raise KeyError(key)
        self[key] = value = self.default_factory()
        return value

    def __reduce__(self):
        if self.default_factory is None:
            args = tuple()
        else:
            args = self.default_factory,
        return type(self), args, None, None, self.items()

    def copy(self):
        return self.__copy__()

    def __copy__(self):
        return type(self)(self.default_factory, self)

    def __deepcopy__(self, memo):
        import copy
        return type(self)(self.default_factory,
                          copy.deepcopy(self.items()))

    def __repr__(self):
        return 'defaultdict(%s, %s)' % (self.default_factory,
                                        dict.__repr__(self))


# Custom tree that facilitates the assignment with JSON-esque way, but
# the minus is  with no assignment at all, since merely referencing an entry creates an entry
# That's why at the end the tree is converted to a dictionary
# Here's link for more info: https://gist.github.com/hrldcpr/2012250
def tree():
    return MyDefaultDict(tree)


jsbml_data_tree = tree()

# Level 0 is the bottom of the Figure 2.1 from JSBML Manual
# LEVEL is used for commodity of typing class names

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

# Level 2
variable = 'Variable'
quantity_with_unit = 'QuantityWithUnit'
modifier_species_reference = 'ModifierSpeciesReference'
event = 'Event'
explicit_rule = 'ExplicitRule'
algebraic_rule = 'AlgrebraicRule'

# Level 3
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

# Level 0

# species Class
jsbml_data_tree[species]['name'] = species
jsbml_data_tree[species]['hasParent'] = True
jsbml_data_tree[species]['parentNode'] = symbol
jsbml_data_tree[species]['hasChildren'] = False
jsbml_data_tree[species]['childrenNodes'] = None
jsbml_data_tree[species]['isInterface'] = False
jsbml_data_tree[species]['parentInterfaces'] = [compartmentalized_sbase]
jsbml_data_tree[species]['childrenInterfaces'] = None
jsbml_data_tree[species]['isUniqueJSBML'] = False
jsbml_data_tree[species]['level'] = 0
jsbml_data_tree[species]['libSBML_analogue'] = None

# compartment Class
jsbml_data_tree[compartment]['name'] = compartment
jsbml_data_tree[compartment]['hasParent'] = True
jsbml_data_tree[compartment]['parentNode'] = symbol
jsbml_data_tree[compartment]['hasChildren'] = False
jsbml_data_tree[compartment]['childrenNode'] = None
jsbml_data_tree[compartment]['isInterface'] = False
jsbml_data_tree[compartment]['parentInterfaces'] = None
jsbml_data_tree[compartment]['childrenInterfaces'] = None
jsbml_data_tree[compartment]['isUniqueJSBML'] = False
jsbml_data_tree[compartment]['level'] = 0
jsbml_data_tree[compartment]['libSBML_analogue'] = None
# A prototype idea E.g. working with Compartment you need to import CompartmentalizedSBase
jsbml_data_tree[compartment]['requiredModules'] = [compartmentalized_sbase]

# print('-----------------------------------------')
# parameter Class
jsbml_data_tree[parameter]['name'] = parameter
jsbml_data_tree[parameter]['hasParent'] = True
jsbml_data_tree[parameter]['parentNode'] = symbol
jsbml_data_tree[parameter]['hasChildren'] = False
jsbml_data_tree[parameter]['childrenNodes'] = None
jsbml_data_tree[parameter]['isInterface'] = False
jsbml_data_tree[parameter]['parentInterfaces'] = None
jsbml_data_tree[parameter]['childrenInterfaces'] = None
jsbml_data_tree[parameter]['isUniqueJSBML'] = False
jsbml_data_tree[parameter]['level'] = 0
jsbml_data_tree[parameter]['libSBML_analogue'] = None

######################################################################

# Level 1

# symbol Class
jsbml_data_tree[symbol]['name'] = symbol
jsbml_data_tree[symbol]['hasParent'] = True
jsbml_data_tree[symbol]['parentNode'] = quantity_with_unit
jsbml_data_tree[symbol]['hasChildren'] = True
jsbml_data_tree[symbol]['childrenNodes'] = [species, compartment, parameter]
jsbml_data_tree[symbol]['isInterface'] = False
jsbml_data_tree[symbol]['parentInterfaces'] = None
jsbml_data_tree[symbol]['childrenInterfaces'] = None
jsbml_data_tree[symbol]['isUniqueJSBML'] = True
jsbml_data_tree[symbol]['level'] = 1
jsbml_data_tree[symbol]['libSBML_analogue'] = None

# local_parameter Class
jsbml_data_tree[local_parameter]['name'] = local_parameter
jsbml_data_tree[local_parameter]['hasParent'] = True
jsbml_data_tree[local_parameter]['parentNode'] = quantity_with_unit
jsbml_data_tree[local_parameter]['hasChildren'] = False
jsbml_data_tree[local_parameter]['childrenNodes'] = None
jsbml_data_tree[local_parameter]['isInterface'] = False
jsbml_data_tree[local_parameter]['parentInterfaces'] = None
jsbml_data_tree[local_parameter]['childrenInterfaces'] = None
jsbml_data_tree[local_parameter]['isUniqueJSBML'] = False
jsbml_data_tree[local_parameter]['level'] = 1
jsbml_data_tree[local_parameter]['libSBML_analogue'] = None

# species_reference Class
jsbml_data_tree[species_reference]['name'] = species_reference
jsbml_data_tree[species_reference]['hasParent'] = True
jsbml_data_tree[species_reference]['parentNode'] = simple_species_reference
jsbml_data_tree[species_reference]['hasChildren'] = True
jsbml_data_tree[species_reference]['childrenNodes'] = [species_reference]
jsbml_data_tree[species_reference]['isInterface'] = False
jsbml_data_tree[species_reference]['parentInterfaces'] = [variable]
jsbml_data_tree[species_reference]['childrenInterfaces'] = None
jsbml_data_tree[species_reference]['isUniqueJSBML'] = False
jsbml_data_tree[species_reference]['level'] = 1
jsbml_data_tree[species_reference]['libSBML_analogue'] = None

# assignment_rule Class
jsbml_data_tree[assignment_rule]['name'] = assignment_rule
jsbml_data_tree[assignment_rule]['hasParent'] = True
jsbml_data_tree[assignment_rule]['parentNode'] = explicit_rule
jsbml_data_tree[assignment_rule]['hasChildren'] = False
jsbml_data_tree[assignment_rule]['childrenNodes'] = None
jsbml_data_tree[assignment_rule]['isInterface'] = False
jsbml_data_tree[assignment_rule]['parentInterfaces'] = None
jsbml_data_tree[assignment_rule]['childrenInterfaces'] = None
jsbml_data_tree[assignment_rule]['isUniqueJSBML'] = False
jsbml_data_tree[assignment_rule]['level'] = 1
jsbml_data_tree[assignment_rule]['libSBML_analogue'] = None

# rate_rule Class
jsbml_data_tree[rate_rule]['name'] = assignment_rule
jsbml_data_tree[rate_rule]['hasParent'] = True
jsbml_data_tree[rate_rule]['parentNode'] = explicit_rule
jsbml_data_tree[rate_rule]['hasChildren'] = False
jsbml_data_tree[rate_rule]['childrenNodes'] = None
jsbml_data_tree[rate_rule]['isInterface'] = False
jsbml_data_tree[rate_rule]['parentInterfaces'] = None
jsbml_data_tree[rate_rule]['childrenInterfaces'] = None
jsbml_data_tree[rate_rule]['isUniqueJSBML'] = False
jsbml_data_tree[rate_rule]['level'] = 1
jsbml_data_tree[rate_rule]['libSBML_analogue'] = None

########################################################################

# Level 2

# variable Interface Class
jsbml_data_tree[variable]['name'] = variable
jsbml_data_tree[variable]['hasParent'] = False
jsbml_data_tree[variable]['parentNode'] = None
jsbml_data_tree[variable]['hasChildren'] = True
jsbml_data_tree[variable]['childrenNodes'] = [species_reference, symbol]
jsbml_data_tree[variable]['isInterface'] = True
jsbml_data_tree[variable]['parentInterfaces'] = [quantity, unique_named_sbase]
jsbml_data_tree[variable]['childrenInterfaces'] = None
jsbml_data_tree[variable]['isUniqueJSBML'] = True
jsbml_data_tree[variable]['level'] = 2
jsbml_data_tree[variable]['libSBML_analogue'] = None

# quantity_with_unit Interface Class
jsbml_data_tree[quantity_with_unit]['name'] = quantity_with_unit
jsbml_data_tree[quantity_with_unit]['hasParent'] = True
jsbml_data_tree[quantity_with_unit]['parentNode'] = abstract_named_sbase_with_unit
jsbml_data_tree[quantity_with_unit]['hasChildren'] = True
jsbml_data_tree[quantity_with_unit]['childrenNodes'] = [symbol, local_parameter]
jsbml_data_tree[quantity_with_unit]['isInterface'] = False
jsbml_data_tree[quantity_with_unit]['parentInterfaces'] = [quantity]
jsbml_data_tree[quantity_with_unit]['childrenInterfaces'] = None
jsbml_data_tree[quantity_with_unit]['isUniqueJSBML'] = True
jsbml_data_tree[quantity_with_unit]['level'] = 2
jsbml_data_tree[quantity_with_unit]['libSBML_analogue'] = None

# modifier_species_reference Interface Class
jsbml_data_tree[modifier_species_reference]['name'] = modifier_species_reference
jsbml_data_tree[modifier_species_reference]['hasParent'] = True
jsbml_data_tree[modifier_species_reference]['parentNode'] = simple_species_reference
jsbml_data_tree[modifier_species_reference]['hasChildren'] = False
jsbml_data_tree[modifier_species_reference]['childrenNodes'] = None
jsbml_data_tree[modifier_species_reference]['isInterface'] = False
jsbml_data_tree[modifier_species_reference]['parentInterfaces'] = None
jsbml_data_tree[modifier_species_reference]['childrenInterfaces'] = None
jsbml_data_tree[modifier_species_reference]['isUniqueJSBML'] = False
jsbml_data_tree[modifier_species_reference]['level'] = 2
jsbml_data_tree[modifier_species_reference]['libSBML_analogue'] = None

# event Interface Class
jsbml_data_tree[event]['name'] = event
jsbml_data_tree[event]['hasParent'] = True
jsbml_data_tree[event]['parentNode'] = abstract_named_sbase_with_unit
jsbml_data_tree[event]['hasChildren'] = False
jsbml_data_tree[event]['childrenNodes'] = None
jsbml_data_tree[event]['isInterface'] = False
jsbml_data_tree[event]['parentInterfaces'] = [unique_named_sbase]
jsbml_data_tree[event]['childrenInterfaces'] = None
jsbml_data_tree[event]['isUniqueJSBML'] = False
jsbml_data_tree[event]['level'] = 2
jsbml_data_tree[event]['libSBML_analogue'] = None

# explicit_rule Interface Class
jsbml_data_tree[explicit_rule]['name'] = explicit_rule
jsbml_data_tree[explicit_rule]['hasParent'] = True
jsbml_data_tree[explicit_rule]['parentNode'] = rule
jsbml_data_tree[explicit_rule]['hasChildren'] = True
jsbml_data_tree[explicit_rule]['childrenNodes'] = [assignment_rule, rate_rule]
jsbml_data_tree[explicit_rule]['isInterface'] = False
jsbml_data_tree[explicit_rule]['parentInterfaces'] = [sbase_with_unit, assignment]
jsbml_data_tree[explicit_rule]['childrenInterfaces'] = None
jsbml_data_tree[explicit_rule]['isUniqueJSBML'] = True
jsbml_data_tree[explicit_rule]['level'] = 2
jsbml_data_tree[explicit_rule]['libSBML_analogue'] = None

# 'AlgebraicRule' Interface Class
jsbml_data_tree['AlgebraicRule']['name'] = algebraic_rule
jsbml_data_tree['AlgebraicRule']['hasParent'] = True
jsbml_data_tree['AlgebraicRule']['parentNode'] = rule
jsbml_data_tree['AlgebraicRule']['hasChildren'] = False
jsbml_data_tree['AlgebraicRule']['childrenNodes'] = None
jsbml_data_tree['AlgebraicRule']['isInterface'] = False
jsbml_data_tree['AlgebraicRule']['parentInterfaces'] = None
jsbml_data_tree['AlgebraicRule']['childrenInterfaces'] = None
jsbml_data_tree['AlgebraicRule']['isUniqueJSBML'] = False
jsbml_data_tree['AlgebraicRule']['level'] = 2
jsbml_data_tree['AlgebraicRule']['libSBML_analogue'] = None

######################################################################

# Level 3

# quantity Interface Class
jsbml_data_tree[quantity]['name'] = quantity
jsbml_data_tree[quantity]['hasParent'] = False
jsbml_data_tree[quantity]['parentNode'] = None
jsbml_data_tree[quantity]['hasChildren'] = False
jsbml_data_tree[quantity]['childrenNodes'] = [quantity_with_unit]
jsbml_data_tree[quantity]['isInterface'] = True
jsbml_data_tree[quantity]['parentInterfaces'] = [callable_sbase]
jsbml_data_tree[quantity]['childrenInterfaces'] = [variable]
jsbml_data_tree[quantity]['isUniqueJSBML'] = True
jsbml_data_tree[quantity]['level'] = 3
jsbml_data_tree[quantity]['libSBML_analogue'] = None

# reaction Class
jsbml_data_tree[reaction]['name'] = reaction
jsbml_data_tree[reaction]['hasParent'] = True
jsbml_data_tree[reaction]['parentNode'] = abstract_named_sbase
jsbml_data_tree[reaction]['hasChildren'] = False
jsbml_data_tree[reaction]['childrenNodes'] = None
jsbml_data_tree[reaction]['isInterface'] = False
jsbml_data_tree[reaction]['parentInterfaces'] = [compartmentalized_sbase, callable_sbase, unique_named_sbase]
jsbml_data_tree[reaction]['childrenInterfaces'] = None
jsbml_data_tree[reaction]['isUniqueJSBML'] = False
jsbml_data_tree[reaction]['level'] = 3
jsbml_data_tree[reaction]['libSBML_analogue'] = None

# function_definition  Class
jsbml_data_tree[function_definition]['name'] = function_definition
jsbml_data_tree[function_definition]['hasParent'] = True
jsbml_data_tree[function_definition]['parentNode'] = abstract_math_container
jsbml_data_tree[function_definition]['hasChildren'] = False
jsbml_data_tree[function_definition]['childrenNodes'] = None
jsbml_data_tree[function_definition]['isInterface'] = False
jsbml_data_tree[function_definition]['parentInterfaces'] = [callable_sbase, unique_named_sbase]
jsbml_data_tree[function_definition]['childrenInterfaces'] = None
jsbml_data_tree[function_definition]['isUniqueJSBML'] = False
jsbml_data_tree[function_definition]['level'] = 3
jsbml_data_tree[function_definition]['libSBML_analogue'] = None

# simple_species_reference  Class
jsbml_data_tree[simple_species_reference]['name'] = simple_species_reference
jsbml_data_tree[simple_species_reference]['hasParent'] = True
jsbml_data_tree[simple_species_reference]['parentNode'] = abstract_named_sbase
jsbml_data_tree[simple_species_reference]['hasChildren'] = True
jsbml_data_tree[simple_species_reference]['childrenNodes'] = [modifier_species_reference]
jsbml_data_tree[simple_species_reference]['isInterface'] = False
jsbml_data_tree[simple_species_reference]['parentInterfaces'] = [unique_named_sbase]
jsbml_data_tree[simple_species_reference]['childrenInterfaces'] = None
jsbml_data_tree[simple_species_reference]['isUniqueJSBML'] = False
jsbml_data_tree[simple_species_reference]['level'] = 3
jsbml_data_tree[simple_species_reference]['libSBML_analogue'] = None

# model Class
jsbml_data_tree[model]['name'] = model
jsbml_data_tree[model]['hasParent'] = True
jsbml_data_tree[model]['parentNode'] = abstract_named_sbase
jsbml_data_tree[model]['hasChildren'] = False
jsbml_data_tree[model]['childrenNodes'] = None
jsbml_data_tree[model]['isInterface'] = False
jsbml_data_tree[model]['parentInterfaces'] = [unique_named_sbase]
jsbml_data_tree[model]['childrenInterfaces'] = None
jsbml_data_tree[model]['isUniqueJSBML'] = False
jsbml_data_tree[model]['level'] = 3
jsbml_data_tree[model]['libSBML_analogue'] = None

# species_type Interface Class
jsbml_data_tree[species_type]['name'] = species_type
jsbml_data_tree[species_type]['hasParent'] = True
jsbml_data_tree[species_type]['parentNode'] = abstract_named_sbase
jsbml_data_tree[species_type]['hasChildren'] = False
jsbml_data_tree[species_type]['childrenNodes'] = None
jsbml_data_tree[species_type]['isInterface'] = False
jsbml_data_tree[species_type]['parentInterfaces'] = [unique_named_sbase]
jsbml_data_tree[species_type]['childrenInterfaces'] = False
jsbml_data_tree[species_type]['isUniqueJSBML'] = False
jsbml_data_tree[species_type]['level'] = 3
jsbml_data_tree[species_type]['libSBML_analogue'] = None

# compartment_type Interface Class
jsbml_data_tree[compartment_type]['name'] = compartment_type
jsbml_data_tree[compartment_type]['hasParent'] = True
jsbml_data_tree[compartment_type]['parentNode'] = abstract_named_sbase
jsbml_data_tree[compartment_type]['hasChildren'] = False
jsbml_data_tree[compartment_type]['childrenNodes'] = None
jsbml_data_tree[compartment_type]['isInterface'] = False
jsbml_data_tree[compartment_type]['parentInterfaces'] = [unique_named_sbase]
jsbml_data_tree[compartment_type]['childrenInterfaces'] = None
jsbml_data_tree[compartment_type]['isUniqueJSBML'] = False
jsbml_data_tree[compartment_type]['level'] = 3
jsbml_data_tree[compartment_type]['libSBML_analogue'] = None

# unit_definition Interface Class
jsbml_data_tree[unit_definition]['name'] = unit_definition
jsbml_data_tree[unit_definition]['hasParent'] = True
jsbml_data_tree[unit_definition]['parentNode'] = abstract_named_sbase
jsbml_data_tree[unit_definition]['hasChildren'] = False
jsbml_data_tree[unit_definition]['childrenNodes'] = None
jsbml_data_tree[unit_definition]['isInterface'] = False
jsbml_data_tree[unit_definition]['parentInterfaces'] = None
jsbml_data_tree[unit_definition]['childrenInterfaces'] = None
jsbml_data_tree[unit_definition]['isUniqueJSBML'] = False
jsbml_data_tree[unit_definition]['level'] = 3
jsbml_data_tree[unit_definition]['libSBML_analogue'] = None

# abstract_named_sbase_with_unit  Class
jsbml_data_tree[abstract_named_sbase_with_unit]['name'] = abstract_named_sbase_with_unit
jsbml_data_tree[abstract_named_sbase_with_unit]['hasParent'] = True
jsbml_data_tree[abstract_named_sbase_with_unit]['parentNode'] = abstract_named_sbase
jsbml_data_tree[abstract_named_sbase_with_unit]['hasChildren'] = True
jsbml_data_tree[abstract_named_sbase_with_unit]['childrenNodes'] = [event]
jsbml_data_tree[abstract_named_sbase_with_unit]['isInterface'] = False
jsbml_data_tree[abstract_named_sbase_with_unit]['parentInterfaces'] = [named_sbase_with_derived_unit, sbase_with_unit]
jsbml_data_tree[abstract_named_sbase_with_unit]['childrenInterfaces'] = None
jsbml_data_tree[abstract_named_sbase_with_unit]['isUniqueJSBML'] = True
jsbml_data_tree[abstract_named_sbase_with_unit]['level'] = 3
jsbml_data_tree[abstract_named_sbase_with_unit]['libSBML_analogue'] = None

# kinetic_law  Class
jsbml_data_tree[kinetic_law]['name'] = kinetic_law
jsbml_data_tree[kinetic_law]['hasParent'] = True
jsbml_data_tree[kinetic_law]['parentNode'] = abstract_math_container
jsbml_data_tree[kinetic_law]['hasChildren'] = False
jsbml_data_tree[kinetic_law]['childrenNodes'] = None
jsbml_data_tree[kinetic_law]['isInterface'] = False
jsbml_data_tree[kinetic_law]['parentInterfaces'] = [sbase_with_unit]
jsbml_data_tree[kinetic_law]['childrenInterfaces'] = None
jsbml_data_tree[kinetic_law]['isUniqueJSBML'] = False
jsbml_data_tree[kinetic_law]['level'] = 3
jsbml_data_tree[kinetic_law]['libSBML_analogue'] = None

# event_assignment  Class
jsbml_data_tree[event_assignment]['name'] = event_assignment
jsbml_data_tree[event_assignment]['hasParent'] = True
jsbml_data_tree[event_assignment]['parentNode'] = abstract_math_container
jsbml_data_tree[event_assignment]['hasChildren'] = False
jsbml_data_tree[event_assignment]['childrenNodes'] = None
jsbml_data_tree[event_assignment]['isInterface'] = False
jsbml_data_tree[event_assignment]['parentInterfaces'] = [assignment]
jsbml_data_tree[event_assignment]['childrenInterfaces'] = None
jsbml_data_tree[event_assignment]['isUniqueJSBML'] = False
jsbml_data_tree[event_assignment]['level'] = 3
jsbml_data_tree[event_assignment]['libSBML_analogue'] = None

# initial_assignment Class
jsbml_data_tree[initial_assignment]['name'] = initial_assignment
jsbml_data_tree[initial_assignment]['hasParent'] = True
jsbml_data_tree[initial_assignment]['parentNode'] = abstract_math_container
jsbml_data_tree[initial_assignment]['hasChildren'] = False
jsbml_data_tree[initial_assignment]['childrenNodes'] = None
jsbml_data_tree[initial_assignment]['isInterface'] = False
jsbml_data_tree[initial_assignment]['parentInterfaces'] = [assignment]
jsbml_data_tree[initial_assignment]['childrenInterfaces'] = None
jsbml_data_tree[initial_assignment]['isUniqueJSBML'] = False
jsbml_data_tree[initial_assignment]['level'] = 3
jsbml_data_tree[initial_assignment]['libSBML_analogue'] = None

# rule  Class
jsbml_data_tree[rule]['name'] = rule
jsbml_data_tree[rule]['hasParent'] = True
jsbml_data_tree[rule]['parentNode'] = abstract_math_container
jsbml_data_tree[rule]['hasChildren'] = True
jsbml_data_tree[rule]['childrenNodes'] = [explicit_rule, algebraic_rule]
jsbml_data_tree[rule]['isInterface'] = False
jsbml_data_tree[rule]['parentInterfaces'] = None
jsbml_data_tree[rule]['childrenInterfaces'] = None
jsbml_data_tree[rule]['isUniqueJSBML'] = False
jsbml_data_tree[rule]['level'] = 3
jsbml_data_tree[rule]['libSBML_analogue'] = None

# priority Interface Class
jsbml_data_tree[priority]['name'] = priority
jsbml_data_tree[priority]['hasParent'] = True
jsbml_data_tree[priority]['parentNode'] = abstract_math_container
jsbml_data_tree[priority]['hasChildren'] = False
jsbml_data_tree[priority]['childrenNodes'] = None
jsbml_data_tree[priority]['isInterface'] = False
jsbml_data_tree[priority]['parentInterfaces'] = None
jsbml_data_tree[priority]['childrenInterfaces'] = None
jsbml_data_tree[priority]['isUniqueJSBML'] = False
jsbml_data_tree[priority]['level'] = 3
jsbml_data_tree[priority]['libSBML_analogue'] = None

# stoichiometry_math Interface Class
jsbml_data_tree[stoichiometry_math]['name'] = stoichiometry_math
jsbml_data_tree[stoichiometry_math]['hasParent'] = True
jsbml_data_tree[stoichiometry_math]['parentNode'] = abstract_math_container
jsbml_data_tree[stoichiometry_math]['hasChildren'] = False
jsbml_data_tree[stoichiometry_math]['childrenNodes'] = None
jsbml_data_tree[stoichiometry_math]['isInterface'] = False
jsbml_data_tree[stoichiometry_math]['parentInterfaces'] = None
jsbml_data_tree[stoichiometry_math]['childrenInterfaces'] = None
jsbml_data_tree[stoichiometry_math]['isUniqueJSBML'] = False
jsbml_data_tree[stoichiometry_math]['level'] = 3
jsbml_data_tree[stoichiometry_math]['libSBML_analogue'] = None

# trigger Interface Class
jsbml_data_tree[trigger]['name'] = trigger
jsbml_data_tree[trigger]['hasParent'] = True
jsbml_data_tree[trigger]['parentNode'] = abstract_math_container
jsbml_data_tree[trigger]['hasChildren'] = False
jsbml_data_tree[trigger]['childrenNodes'] = None
jsbml_data_tree[trigger]['isInterface'] = False
jsbml_data_tree[trigger]['parentInterfaces'] = None
jsbml_data_tree[trigger]['childrenInterfaces'] = None
jsbml_data_tree[trigger]['isUniqueJSBML'] = False
jsbml_data_tree[trigger]['level'] = 3
jsbml_data_tree[trigger]['libSBML_analogue'] = None

# constraint Interface Class
jsbml_data_tree[constraint]['name'] = constraint
jsbml_data_tree[constraint]['hasParent'] = True
jsbml_data_tree[constraint]['parentNode'] = abstract_math_container
jsbml_data_tree[constraint]['hasChildren'] = False
jsbml_data_tree[constraint]['childrenNodes'] = None
jsbml_data_tree[constraint]['isInterface'] = False
jsbml_data_tree[constraint]['parentInterfaces'] = None
jsbml_data_tree[constraint]['childrenInterfaces'] = None
jsbml_data_tree[constraint]['isUniqueJSBML'] = False
jsbml_data_tree[constraint]['level'] = 3
jsbml_data_tree[constraint]['libSBML_analogue'] = None

# delay Interface Class
jsbml_data_tree[delay]['name'] = delay
jsbml_data_tree[delay]['hasParent'] = True
jsbml_data_tree[delay]['parentNode'] = abstract_math_container
jsbml_data_tree[delay]['hasChildren'] = False
jsbml_data_tree[delay]['childrenNodes'] = None
jsbml_data_tree[delay]['isInterface'] = False
jsbml_data_tree[delay]['parentInterfaces'] = None
jsbml_data_tree[delay]['childrenInterfaces'] = None
jsbml_data_tree[delay]['isUniqueJSBML'] = False
jsbml_data_tree[delay]['level'] = 3
jsbml_data_tree[delay]['libSBML_analogue'] = None

########################################################################

# Level 4

# compartmentalized_sbase Interface
jsbml_data_tree[compartmentalized_sbase]['name'] = compartmentalized_sbase
jsbml_data_tree[compartmentalized_sbase]['hasParent'] = None
jsbml_data_tree[compartmentalized_sbase]['parentNode'] = None
jsbml_data_tree[compartmentalized_sbase]['hasChildren'] = True
jsbml_data_tree[compartmentalized_sbase]['childrenNodes'] = [species, reaction]
jsbml_data_tree[compartmentalized_sbase]['isInterface'] = True
jsbml_data_tree[compartmentalized_sbase]['parentInterfaces'] = [named_sbase]
jsbml_data_tree[compartmentalized_sbase]['childrenInterfaces'] = None
jsbml_data_tree[compartmentalized_sbase]['isUniqueJSBML'] = True
jsbml_data_tree[compartmentalized_sbase]['level'] = 4
jsbml_data_tree[compartmentalized_sbase]['libSBML_analogue'] = None

# callable_sbase Interface
jsbml_data_tree[callable_sbase]['name'] = callable_sbase
jsbml_data_tree[callable_sbase]['hasParent'] = False
jsbml_data_tree[callable_sbase]['parentNode'] = None
jsbml_data_tree[callable_sbase]['hasChildren'] = True
jsbml_data_tree[callable_sbase]['childrenNodes'] = [reaction, function_definition]
jsbml_data_tree[callable_sbase]['isInterface'] = True
jsbml_data_tree[callable_sbase]['parentInterfaces'] = [named_sbase_with_derived_unit]
jsbml_data_tree[callable_sbase]['childrenInterfaces'] = [quantity]
jsbml_data_tree[callable_sbase]['isUniqueJSBML'] = True
jsbml_data_tree[callable_sbase]['level'] = 4
jsbml_data_tree[callable_sbase]['libSBML_analogue'] = None
jsbml_data_tree[callable_sbase]['writeAbstractMethods'] = True

# unique_named_sbase Interface
jsbml_data_tree[unique_named_sbase]['name'] = unique_named_sbase
jsbml_data_tree[unique_named_sbase]['hasParent'] = False
jsbml_data_tree[unique_named_sbase]['parentNode'] = None
jsbml_data_tree[unique_named_sbase]['hasChildren'] = True
jsbml_data_tree[unique_named_sbase]['childrenNodes'] = [reaction, function_definition, simple_species_reference, model,
                                                        species_type, compartment_type]
jsbml_data_tree[unique_named_sbase]['isInterface'] = True
jsbml_data_tree[unique_named_sbase]['parentInterfaces'] = [named_sbase]
jsbml_data_tree[unique_named_sbase]['childrenInterfaces'] = [variable]
jsbml_data_tree[unique_named_sbase]['isUniqueJSBML'] = True
jsbml_data_tree[unique_named_sbase]['level'] = 4
jsbml_data_tree[unique_named_sbase]['libSBML_analogue'] = None

# abstract_named_sbase  Class
jsbml_data_tree[abstract_named_sbase]['name'] = abstract_named_sbase
jsbml_data_tree[abstract_named_sbase]['hasParent'] = True
jsbml_data_tree[abstract_named_sbase]['parentNode'] = abstract_sbase
jsbml_data_tree[abstract_named_sbase]['hasChildren'] = True
jsbml_data_tree[abstract_named_sbase]['childrenNodes'] = [reaction, function_definition, simple_species_reference,
                                                          model, species_type, compartment_type, unit_definition,
                                                          abstract_named_sbase_with_unit]
jsbml_data_tree[abstract_named_sbase]['isInterface'] = False
jsbml_data_tree[abstract_named_sbase]['parentInterfaces'] = [named_sbase]
jsbml_data_tree[abstract_named_sbase]['childrenInterfaces'] = None
jsbml_data_tree[abstract_named_sbase]['isUniqueJSBML'] = True
jsbml_data_tree[abstract_named_sbase]['level'] = 4
jsbml_data_tree[abstract_named_sbase]['libSBML_analogue'] = None

# sbase_with_unit Interface
jsbml_data_tree[sbase_with_unit]['name'] = sbase_with_unit
jsbml_data_tree[sbase_with_unit]['hasParent'] = False
jsbml_data_tree[sbase_with_unit]['parentNode'] = None
jsbml_data_tree[sbase_with_unit]['hasChildren'] = True
jsbml_data_tree[sbase_with_unit]['childrenNodes'] = [abstract_named_sbase_with_unit, explicit_rule,
                                                     kinetic_law]
jsbml_data_tree[sbase_with_unit]['isInterface'] = True
jsbml_data_tree[sbase_with_unit]['parentInterfaces'] = [sbase_with_derived_unit]
jsbml_data_tree[sbase_with_unit]['childrenInterfaces'] = None
jsbml_data_tree[sbase_with_unit]['isUniqueJSBML'] = True
jsbml_data_tree[sbase_with_unit]['level'] = 4
jsbml_data_tree[sbase_with_unit]['libSBML_analogue'] = None

# assignment Interface
jsbml_data_tree[assignment]['name'] = assignment
jsbml_data_tree[assignment]['hasParent'] = False
jsbml_data_tree[assignment]['parentNode'] = None
jsbml_data_tree[assignment]['hasChildren'] = True
jsbml_data_tree[assignment]['childrenNodes'] = [explicit_rule, event_assignment, initial_assignment]
jsbml_data_tree[assignment]['isInterface'] = True
jsbml_data_tree[assignment]['parentInterfaces'] = [math_container]
jsbml_data_tree[assignment]['childrenInterfaces'] = None
jsbml_data_tree[assignment]['isUniqueJSBML'] = True
jsbml_data_tree[assignment]['level'] = 4
jsbml_data_tree[assignment]['libSBML_analogue'] = None

# abstract_math_container Class
jsbml_data_tree[abstract_math_container]['name'] = abstract_math_container
jsbml_data_tree[abstract_math_container]['hasParent'] = True
jsbml_data_tree[abstract_math_container]['parentNode'] = abstract_sbase
jsbml_data_tree[abstract_math_container]['hasChildren'] = True
jsbml_data_tree[abstract_math_container]['childrenNodes'] = [function_definition, kinetic_law, event_assignment,
                                                             initial_assignment, rule, priority, stoichiometry_math,
                                                             trigger, constraint, delay]
jsbml_data_tree[abstract_math_container]['isInterface'] = False
jsbml_data_tree[abstract_math_container]['parentInterfaces'] = [math_container]
jsbml_data_tree[abstract_math_container]['childrenInterfaces'] = None
jsbml_data_tree[abstract_math_container]['isUniqueJSBML'] = True
jsbml_data_tree[abstract_math_container]['level'] = 4
jsbml_data_tree[abstract_math_container]['libSBML_analogue'] = None
jsbml_data_tree[abstract_math_container]['ignore'] = ['id', 'name']
jsbml_data_tree[abstract_math_container]['include'] = ['ASTNode']
########################################################################

# Level 5

# named_sbase_with_derived_unit Interface
jsbml_data_tree[named_sbase_with_derived_unit]['name'] = named_sbase_with_derived_unit
jsbml_data_tree[named_sbase_with_derived_unit]['hasParent'] = False
jsbml_data_tree[named_sbase_with_derived_unit]['parentNode'] = None
jsbml_data_tree[named_sbase_with_derived_unit]['hasChildren'] = True
jsbml_data_tree[named_sbase_with_derived_unit]['childrenNodes'] = [callable_sbase]
jsbml_data_tree[named_sbase_with_derived_unit]['isInterface'] = True
jsbml_data_tree[named_sbase_with_derived_unit]['parentInterfaces'] = [named_sbase]
jsbml_data_tree[named_sbase_with_derived_unit]['childrenInterfaces'] = [abstract_named_sbase_with_unit]
jsbml_data_tree[named_sbase_with_derived_unit]['isUniqueJSBML'] = True
jsbml_data_tree[named_sbase_with_derived_unit]['level'] = 5
jsbml_data_tree[named_sbase_with_derived_unit]['libSBML_analogue'] = None

# math_container Interface
jsbml_data_tree[math_container]['name'] = math_container
jsbml_data_tree[math_container]['hasParent'] = False
jsbml_data_tree[math_container]['parentNode'] = None
jsbml_data_tree[math_container]['hasChildren'] = True
jsbml_data_tree[math_container]['childrenNodes'] = [abstract_math_container]
jsbml_data_tree[math_container]['isInterface'] = True
jsbml_data_tree[math_container]['parentInterfaces'] = [sbase_with_derived_unit]
jsbml_data_tree[math_container]['childrenInterfaces'] = [assignment]
jsbml_data_tree[math_container]['isUniqueJSBML'] = True
jsbml_data_tree[math_container]['level'] = 5
jsbml_data_tree[math_container]['libSBML_analogue'] = None

# sbml_document  Class
jsbml_data_tree[sbml_document]['name'] = sbml_document
jsbml_data_tree[sbml_document]['hasParent'] = True
jsbml_data_tree[sbml_document]['parentNode'] = abstract_sbase
jsbml_data_tree[sbml_document]['hasChildren'] = False
jsbml_data_tree[sbml_document]['childrenNodes'] = None
jsbml_data_tree[sbml_document]['isInterface'] = False
jsbml_data_tree[sbml_document]['parentInterfaces'] = None
jsbml_data_tree[sbml_document]['childrenInterfaces'] = None
jsbml_data_tree[sbml_document]['isUniqueJSBML'] = False
jsbml_data_tree[sbml_document]['level'] = 5
jsbml_data_tree[sbml_document]['libSBML_analogue'] = None

# unit Interface Class
jsbml_data_tree[unit]['name'] = unit
jsbml_data_tree[unit]['hasParent'] = True
jsbml_data_tree[unit]['parentNode'] = abstract_sbase
jsbml_data_tree[unit]['hasChildren'] = False
jsbml_data_tree[unit]['childrenNodes'] = None
jsbml_data_tree[unit]['isInterface'] = False
jsbml_data_tree[unit]['parentInterfaces'] = None
jsbml_data_tree[unit]['childrenInterfaces'] = None
jsbml_data_tree[unit]['isUniqueJSBML'] = False
jsbml_data_tree[unit]['level'] = 5
jsbml_data_tree[unit]['libSBML_analogue'] = None

# list_of Class
jsbml_data_tree[list_of]['name'] = list_of
jsbml_data_tree[list_of]['hasParent'] = True
jsbml_data_tree[list_of]['parentNode'] = abstract_sbase
jsbml_data_tree[list_of]['hasChildren'] = False
jsbml_data_tree[list_of]['childrenNodes'] = None
jsbml_data_tree[list_of]['isInterface'] = False
jsbml_data_tree[list_of]['parentInterfaces'] = ['List']  # TODO with java types
jsbml_data_tree[list_of]['childrenInterfaces'] = None
jsbml_data_tree[list_of]['isUniqueJSBML'] = False
jsbml_data_tree[list_of]['level'] = 5
jsbml_data_tree[list_of]['libSBML_analogue'] = None

# xml_node Interface Class
jsbml_data_tree[xml_node]['name'] = xml_node
jsbml_data_tree[xml_node]['hasParent'] = True
jsbml_data_tree[xml_node]['parentNode'] = xml_token
jsbml_data_tree[xml_node]['hasChildren'] = False
jsbml_data_tree[xml_node]['childrenNodes'] = None
jsbml_data_tree[xml_node]['isInterface'] = False
jsbml_data_tree[xml_node]['parentInterfaces'] = None
jsbml_data_tree[xml_node]['childrenInterfaces'] = None
jsbml_data_tree[xml_node]['isUniqueJSBML'] = False
jsbml_data_tree[xml_node]['level'] = 5
jsbml_data_tree[xml_node]['libSBML_analogue'] = None

# annotation  Class
jsbml_data_tree[annotation]['name'] = annotation
jsbml_data_tree[annotation]['hasParent'] = True
jsbml_data_tree[annotation]['parentNode'] = annotation_element
jsbml_data_tree[annotation]['hasChildren'] = False
jsbml_data_tree[annotation]['childrenNodes'] = None
jsbml_data_tree[annotation]['isInterface'] = False
jsbml_data_tree[annotation]['parentInterfaces'] = None
jsbml_data_tree[annotation]['childrenInterfaces'] = None
jsbml_data_tree[annotation]['isUniqueJSBML'] = True
jsbml_data_tree[annotation]['level'] = 5
jsbml_data_tree[annotation]['libSBML_analogue'] = None

# creator Class
jsbml_data_tree[creator]['name'] = creator
jsbml_data_tree[creator]['hasParent'] = True
jsbml_data_tree[creator]['parentNode'] = annotation_element
jsbml_data_tree[creator]['hasChildren'] = False
jsbml_data_tree[creator]['childrenNodes'] = None
jsbml_data_tree[creator]['isInterface'] = False
jsbml_data_tree[creator]['parentInterfaces'] = None
jsbml_data_tree[creator]['childrenInterfaces'] = None
jsbml_data_tree[creator]['isUniqueJSBML'] = False
jsbml_data_tree[creator]['level'] = 5
jsbml_data_tree[creator]['libSBML_analogue'] = 'ModelCreator'

# cv_term  Class
jsbml_data_tree[cv_term]['name'] = cv_term
jsbml_data_tree[cv_term]['hasParent'] = True
jsbml_data_tree[cv_term]['parentNode'] = annotation_element
jsbml_data_tree[cv_term]['hasChildren'] = False
jsbml_data_tree[cv_term]['childrenNodes'] = None
jsbml_data_tree[cv_term]['isInterface'] = False
jsbml_data_tree[cv_term]['parentInterfaces'] = None
jsbml_data_tree[cv_term]['childrenInterfaces'] = None
jsbml_data_tree[cv_term]['isUniqueJSBML'] = False
jsbml_data_tree[cv_term]['level'] = 5
jsbml_data_tree[cv_term]['libSBML_analogue'] = None

# history Interface Class
jsbml_data_tree[history]['name'] = history
jsbml_data_tree[history]['hasParent'] = True
jsbml_data_tree[history]['parentNode'] = annotation_element
jsbml_data_tree[history]['hasChildren'] = False
jsbml_data_tree[history]['childrenNodes'] = None
jsbml_data_tree[history]['isInterface'] = False
jsbml_data_tree[history]['parentInterfaces'] = None
jsbml_data_tree[history]['childrenInterfaces'] = None
jsbml_data_tree[history]['isUniqueJSBML'] = False
jsbml_data_tree[history]['level'] = 5
jsbml_data_tree[history]['libSBML_analogue'] = 'ModelHistory'

########################################################################

# Level 6

# named_sbase Interface
jsbml_data_tree[named_sbase]['name'] = named_sbase
jsbml_data_tree[named_sbase]['hasParent'] = False
jsbml_data_tree[named_sbase]['parentNode'] = None
jsbml_data_tree[named_sbase]['hasChildren'] = False
jsbml_data_tree[named_sbase]['childrenNodes'] = None
jsbml_data_tree[named_sbase]['isInterface'] = True
jsbml_data_tree[named_sbase]['parentInterfaces'] = [sbase]
jsbml_data_tree[named_sbase]['childrenInterfaces'] = [compartmentalized_sbase, unique_named_sbase,
                                                      named_sbase_with_derived_unit]
jsbml_data_tree[named_sbase]['isUniqueJSBML'] = True
jsbml_data_tree[named_sbase]['level'] = 6
jsbml_data_tree[named_sbase]['libSBML_analogue'] = None

# sbase_with_derived_unit Interface
jsbml_data_tree[sbase_with_derived_unit]['name'] = sbase_with_derived_unit
jsbml_data_tree[sbase_with_derived_unit]['hasParent'] = False
jsbml_data_tree[sbase_with_derived_unit]['parentNode'] = None
jsbml_data_tree[sbase_with_derived_unit]['hasChildren'] = False
jsbml_data_tree[sbase_with_derived_unit]['childrenNodes'] = None
jsbml_data_tree[sbase_with_derived_unit]['isInterface'] = True
jsbml_data_tree[sbase_with_derived_unit]['parentInterfaces'] = [sbase]
jsbml_data_tree[sbase_with_derived_unit]['childrenInterfaces'] = [named_sbase_with_derived_unit, sbase_with_unit,
                                                                  math_container]
jsbml_data_tree[sbase_with_derived_unit]['isUniqueJSBML'] = True
jsbml_data_tree[sbase_with_derived_unit]['level'] = 6
jsbml_data_tree[sbase_with_derived_unit]['libSBML_analogue'] = None

# abstract_sbase  Class
jsbml_data_tree[abstract_sbase]['name'] = abstract_sbase
jsbml_data_tree[abstract_sbase]['hasParent'] = True
jsbml_data_tree[abstract_sbase]['parentNode'] = abstract_tree_node
jsbml_data_tree[abstract_sbase]['hasChildren'] = True
jsbml_data_tree[abstract_sbase]['childrenNodes'] = [abstract_named_sbase, abstract_math_container, sbml_document,
                                                    unit, list_of]
jsbml_data_tree[abstract_sbase]['isInterface'] = False
jsbml_data_tree[abstract_sbase]['parentInterfaces'] = [sbase]
jsbml_data_tree[abstract_sbase]['childrenInterfaces'] = None
jsbml_data_tree[abstract_sbase]['isUniqueJSBML'] = True
jsbml_data_tree[abstract_sbase]['level'] = 6
jsbml_data_tree[abstract_sbase]['libSBML_analogue'] = None

# abstract_sbase_plugin  Class # TODO special case
jsbml_data_tree[abstract_sbase_plugin]['name'] = abstract_sbase_plugin
jsbml_data_tree[abstract_sbase_plugin]['hasParent'] = True
jsbml_data_tree[abstract_sbase_plugin]['parentNode'] = abstract_tree_node
jsbml_data_tree[abstract_sbase_plugin]['hasChildren'] = False
jsbml_data_tree[abstract_sbase_plugin]['childrenNodes'] = None
jsbml_data_tree[abstract_sbase_plugin]['isInterface'] = False
jsbml_data_tree[abstract_sbase_plugin]['parentInterfaces'] = None
jsbml_data_tree[abstract_sbase_plugin]['childrenInterfaces'] = None
jsbml_data_tree[abstract_sbase_plugin]['isUniqueJSBML'] = True
jsbml_data_tree[abstract_sbase_plugin]['level'] = 6
jsbml_data_tree[abstract_sbase_plugin]['libSBML_analogue'] = None

# tree_node_adapter  Class
jsbml_data_tree[tree_node_adapter]['name'] = tree_node_adapter
jsbml_data_tree[tree_node_adapter]['hasParent'] = True
jsbml_data_tree[tree_node_adapter]['parentNode'] = abstract_tree_node
jsbml_data_tree[tree_node_adapter]['hasChildren'] = False
jsbml_data_tree[tree_node_adapter]['childrenNodes'] = None
jsbml_data_tree[tree_node_adapter]['isInterface'] = False
jsbml_data_tree[tree_node_adapter]['parentInterfaces'] = None
jsbml_data_tree[tree_node_adapter]['childrenInterfaces'] = None
jsbml_data_tree[tree_node_adapter]['isUniqueJSBML'] = True
jsbml_data_tree[tree_node_adapter]['level'] = 6
jsbml_data_tree[tree_node_adapter]['libSBML_analogue'] = None

# ast_node Class
jsbml_data_tree[ast_node]['name'] = ast_node
jsbml_data_tree[ast_node]['hasParent'] = True
jsbml_data_tree[ast_node]['parentNode'] = abstract_tree_node
jsbml_data_tree[ast_node]['hasChildren'] = False
jsbml_data_tree[ast_node]['childrenNodes'] = None
jsbml_data_tree[ast_node]['isInterface'] = False
jsbml_data_tree[ast_node]['parentInterfaces'] = None
jsbml_data_tree[ast_node]['childrenInterfaces'] = None
jsbml_data_tree[ast_node]['isUniqueJSBML'] = False
jsbml_data_tree[ast_node]['level'] = 6
jsbml_data_tree[ast_node]['libSBML_analogue'] = None

# xml_token Class
jsbml_data_tree[xml_token]['name'] = xml_token
jsbml_data_tree[xml_token]['hasParent'] = True
jsbml_data_tree[xml_token]['parentNode'] = abstract_tree_node
jsbml_data_tree[xml_token]['hasChildren'] = True
jsbml_data_tree[xml_token]['childrenNodes'] = [xml_node]
jsbml_data_tree[xml_token]['isInterface'] = False
jsbml_data_tree[xml_token]['parentInterfaces'] = None
jsbml_data_tree[xml_token]['childrenInterfaces'] = None
jsbml_data_tree[xml_token]['isUniqueJSBML'] = False
jsbml_data_tree[xml_token]['level'] = 6
jsbml_data_tree[xml_token]['libSBML_analogue'] = None

# annotation_element  Class
jsbml_data_tree[annotation_element]['name'] = annotation_element
jsbml_data_tree[annotation_element]['hasParent'] = True
jsbml_data_tree[annotation_element]['parentNode'] = abstract_tree_node
jsbml_data_tree[annotation_element]['hasChildren'] = True
jsbml_data_tree[annotation_element]['childrenNodes'] = [annotation, creator, cv_term, history]
jsbml_data_tree[annotation_element]['isInterface'] = False
jsbml_data_tree[annotation_element]['parentInterfaces'] = None
jsbml_data_tree[annotation_element]['childrenInterfaces'] = None
jsbml_data_tree[annotation_element]['isUniqueJSBML'] = True
jsbml_data_tree[annotation_element]['level'] = 6
jsbml_data_tree[annotation_element]['libSBML_analogue'] = None

########################################################################

# Level 7

# sbase Interface
jsbml_data_tree[sbase]['name'] = sbase
jsbml_data_tree[sbase]['hasParent'] = False
jsbml_data_tree[sbase]['parentNode'] = None
jsbml_data_tree[sbase]['hasChildren'] = False
jsbml_data_tree[sbase]['childrenNodes'] = None
jsbml_data_tree[sbase]['isInterface'] = True
jsbml_data_tree[sbase]['parentInterfaces'] = [tree_node_with_change_support]
jsbml_data_tree[sbase]['childrenInterfaces'] = [named_sbase, sbase_with_derived_unit, abstract_sbase]
jsbml_data_tree[sbase]['isUniqueJSBML'] = False
jsbml_data_tree[sbase]['level'] = 7
jsbml_data_tree[sbase]['libSBML_analogue'] = None

# sbase_plugin Interface
jsbml_data_tree[sbase_plugin]['name'] = sbase_plugin
jsbml_data_tree[sbase_plugin]['hasParent'] = False
jsbml_data_tree[sbase_plugin]['parentNode'] = None
jsbml_data_tree[sbase_plugin]['hasChildren'] = False
jsbml_data_tree[sbase_plugin]['childrenNodes'] = [abstract_sbase_plugin]
jsbml_data_tree[sbase_plugin]['isInterface'] = True
jsbml_data_tree[sbase_plugin]['parentInterfaces'] = [tree_node_with_change_support]
jsbml_data_tree[sbase_plugin]['childrenInterfaces'] = None
jsbml_data_tree[sbase_plugin]['isUniqueJSBML'] = False
jsbml_data_tree[sbase_plugin]['level'] = 7
jsbml_data_tree[sbase_plugin]['libSBML_analogue'] = None

# abstract_tree_node  Class
jsbml_data_tree[abstract_tree_node]['name'] = abstract_tree_node
jsbml_data_tree[abstract_tree_node]['hasParent'] = True
jsbml_data_tree[abstract_tree_node]['parentNode'] = 'Object'
jsbml_data_tree[abstract_tree_node]['hasChildren'] = True
jsbml_data_tree[abstract_tree_node]['childrenNodes'] = [abstract_sbase, abstract_sbase_plugin, tree_node_adapter,
                                                        ast_node, xml_token, annotation_element]
jsbml_data_tree[abstract_tree_node]['isInterface'] = False
jsbml_data_tree[abstract_tree_node]['parentInterfaces'] = [tree_node_with_change_support]
jsbml_data_tree[abstract_tree_node]['childrenInterfaces'] = None
jsbml_data_tree[abstract_tree_node]['isUniqueJSBML'] = True
jsbml_data_tree[abstract_tree_node]['level'] = 7
jsbml_data_tree[abstract_tree_node]['libSBML_analogue'] = None

# simple_tree_node_change_listener  Class
jsbml_data_tree[simple_tree_node_change_listener]['name'] = simple_tree_node_change_listener
jsbml_data_tree[simple_tree_node_change_listener]['hasParent'] = True
jsbml_data_tree[simple_tree_node_change_listener]['parentNode'] = 'Object'
jsbml_data_tree[simple_tree_node_change_listener]['hasChildren'] = False
jsbml_data_tree[simple_tree_node_change_listener]['childrenNodes'] = None
jsbml_data_tree[simple_tree_node_change_listener]['isInterface'] = False
jsbml_data_tree[simple_tree_node_change_listener]['parentInterfaces'] = [tree_node_change_listener]
jsbml_data_tree[simple_tree_node_change_listener]['childrenInterfaces'] = None
jsbml_data_tree[simple_tree_node_change_listener]['isUniqueJSBML'] = True
jsbml_data_tree[simple_tree_node_change_listener]['level'] = 7
jsbml_data_tree[simple_tree_node_change_listener]['libSBML_analogue'] = None

########################################################################

# Level 8

# tree_node_with_change_support Interface
jsbml_data_tree[tree_node_with_change_support]['name'] = tree_node_with_change_support
jsbml_data_tree[tree_node_with_change_support]['hasParent'] = False
jsbml_data_tree[tree_node_with_change_support]['parentNode'] = None
jsbml_data_tree[tree_node_with_change_support]['hasChildren'] = True
jsbml_data_tree[tree_node_with_change_support]['childrenNodes'] = abstract_tree_node
jsbml_data_tree[tree_node_with_change_support]['isInterface'] = True
jsbml_data_tree[tree_node_with_change_support]['parentInterfaces'] = ['TreeNode', 'Serializable', 'Cloneable']
jsbml_data_tree[tree_node_with_change_support]['childrenInterfaces'] = [sbase, sbase_plugin]
jsbml_data_tree[tree_node_with_change_support]['isUniqueJSBML'] = True
jsbml_data_tree[tree_node_with_change_support]['level'] = 8
jsbml_data_tree[tree_node_with_change_support]['libSBML_analogue'] = None

# tree_node_change_listener Interface Class
jsbml_data_tree[tree_node_change_listener]['name'] = tree_node_change_listener
jsbml_data_tree[tree_node_change_listener]['hasParent'] = False
jsbml_data_tree[tree_node_change_listener]['parentNode'] = None
jsbml_data_tree[tree_node_change_listener]['hasChildren'] = False
jsbml_data_tree[tree_node_change_listener]['childrenNodes'] = None
jsbml_data_tree[tree_node_change_listener]['isInterface'] = True
jsbml_data_tree[tree_node_change_listener]['parentInterfaces'] = ['PropertyChangeListener']
jsbml_data_tree[tree_node_change_listener]['childrenInterfaces'] = simple_tree_node_change_listener
jsbml_data_tree[tree_node_change_listener]['isUniqueJSBML'] = True
jsbml_data_tree[tree_node_change_listener]['level'] = 8
jsbml_data_tree[tree_node_change_listener]['libSBML_analogue'] = None

# tree_node_change_event  Class
jsbml_data_tree[tree_node_change_event]['name'] = tree_node_change_listener
jsbml_data_tree[tree_node_change_event]['hasParent'] = True
jsbml_data_tree[tree_node_change_event]['parentNode'] = 'PropertyChangeEvent'
jsbml_data_tree[tree_node_change_event]['hasChildren'] = False
jsbml_data_tree[tree_node_change_event]['childrenNodes'] = None
jsbml_data_tree[tree_node_change_event]['isInterface'] = False
jsbml_data_tree[tree_node_change_event]['parentInterfaces'] = None
jsbml_data_tree[tree_node_change_event]['childrenInterfaces'] = None
jsbml_data_tree[tree_node_change_event]['isUniqueJSBML'] = True
jsbml_data_tree[tree_node_change_event]['level'] = 8
jsbml_data_tree[tree_node_change_event]['libSBML_analogue'] = None

########################################################################

# print('--------------------------------------------')
# print(jsbml_data_tree)

#  TODO new dictionary for modules
java_mods = 'java'
jsbml_mods = 'jsbml'

# SBML packages
pack_qual = 'qual'
pack_fbc = 'fbc'
pack_dyn = 'dyn'
pack_distrib = 'distrib'
pack_groups = 'groups'
pack_spatial = 'spatial'

############################################################################################


# This part is responsible for the packages "extends" and "implements" information
# at index [0] is the "extends" information, after index [1] is the "implements" information

# qual package
jsbml_data_tree[pack_qual]['Input'] = ['AbstractNamedSBase', 'UniqueNamedSBase',
                                       'CallableSBase']

jsbml_data_tree[pack_qual]['Output'] = ['AbstractNamedSBase', 'UniqueNamedSBase',
                                        'CallableSBase']
jsbml_data_tree[pack_qual]['Transition'] = ['AbstractNamedSBase', 'UniqueNamedSBase']

jsbml_data_tree[pack_qual]['QualitativeSpecies'] = ['AbstractNamedSBase', 'CompartmentalizedSBase', 'UniqueNamedSBase']

jsbml_data_tree[pack_qual]['FunctionTerm'] = ['AbstractMathContainer']

jsbml_data_tree[pack_qual]['DefaultTerm'] = ['AbstractMathContainer']

# fbc package
jsbml_data_tree[pack_fbc]['FluxBound'] = [abstract_named_sbase, unique_named_sbase]
jsbml_data_tree[pack_fbc]['FluxObjective'] = [abstract_named_sbase, unique_named_sbase]
jsbml_data_tree[pack_fbc]['GeneProduct'] = [abstract_named_sbase, unique_named_sbase]
jsbml_data_tree[pack_fbc]['Objective'] = [abstract_named_sbase, unique_named_sbase]

# dyn package
jsbml_data_tree[pack_dyn]['DynElement'] = [abstract_named_sbase, unique_named_sbase]
jsbml_data_tree[pack_dyn]['SpatialComponent'] = [abstract_named_sbase, unique_named_sbase]

# distrib package
jsbml_data_tree[pack_distrib]['DrawFromDistribution'] = [abstract_sbase]  # , 'IdManager'] # TODO IdManager tricky
jsbml_data_tree[pack_distrib]['DistribInput'] = [abstract_named_sbase]
jsbml_data_tree[pack_distrib]['Uncertainty'] = [abstract_named_sbase]

# groups package
jsbml_data_tree[pack_groups]['Group'] = [abstract_named_sbase, unique_named_sbase]
jsbml_data_tree[pack_groups]['Member'] = [abstract_named_sbase, unique_named_sbase]

# spatial package
abstract_spatial_named_sbase = 'AbstractSpatialNamedSBase'
geometry_definition = 'GeometryDefinition'

# TODO spatial is a special case for imports
# jsbml_data_tree[pack_spatial]['Geometry'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['Domain'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['InteriorPoint'] = [abstract_sbase]
# jsbml_data_tree[pack_spatial]['Boundary'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['AdjacentDomains'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial][geometry_definition] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['CompartmentMapping'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['CoordinateComponent'] = [abstract_spatial_named_sbase, sbase_with_unit]
# jsbml_data_tree[pack_spatial]['SampledFieldGeometry'] = [geometry_definition]
# jsbml_data_tree[pack_spatial]['SampledField'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['SampledVolume'] = [abstract_spatial_named_sbase]
# jsbml_data_tree[pack_spatial]['AnalyticGeometry'] = [geometry_definition]
# jsbml_data_tree[pack_spatial]['AnalyticVolume'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['ParametricGeometry'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['ParametricObject'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGeometry'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGObject'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGNode'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGTransformation'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGTranslation'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGRotation'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGScale'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGHomogeneousTransformation'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['TransformationComponents'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGPrimitive'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGPseudoPrimitive'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CSGSetOperator'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['SpatialSymbolReference'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['DiffusionCoefficient'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['AdvectionCoefficient'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['BoundaryCondition'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['Geometry'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['CoordinateReference'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['MixedGeometry'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['OrdinalMapping'] = [abstract_named_sbase, unique_named_sbase]
# jsbml_data_tree[pack_spatial]['SpatialPoints'] = [abstract_named_sbase, unique_named_sbase]

# To make sure dictionary does not get modified, because of custom dict structure
jsbml_data_tree = dict(jsbml_data_tree)
