/**
 * @file local-packages-qual.i
 * @brief Casting to most specific packages object for java
 * @author SBMLTeam
 *
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML. Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2013-2016 jointly by the following organizations:
 * 1. California Institute of Technology, Pasadena, CA, USA
 * 2. EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK
 * 3. University of Heidelberg, Heidelberg, Germany
 *
 * Copyright (C) 2009-2013 jointly by the following organizations:
 * 1. California Institute of Technology, Pasadena, CA, USA
 * 2. EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK
 *
 * Copyright (C) 2006-2008 by the California Institute of Technology,
 * Pasadena, CA, USA
 *
 * Copyright (C) 2002-2005 jointly by the following organizations:
 * 1. California Institute of Technology, Pasadena, CA, USA
 * 2. Japan Science and Technology Agency, Japan
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation. A copy of the license agreement is provided in the
 * file named "LICENSE.txt" included with this software distribution and also
 * available online as http://sbml.org/software/libsbml/license.html
 * ------------------------------------------------------------------------ -->
 */


#ifdef USE_QUAL
%typemap(javacode) QualExtension
%{
  public SBasePlugin DowncastSBasePlugin(long cPtr, boolean owner)
  {
    if (cPtr == 0) return null;

    SBasePlugin sbp = new SBasePlugin(cPtr, false);
    SBase sb = sbp.getParentSBMLObject();

    switch ( sb.getTypeCode() )
    {
      case (int) libsbml.SBML_MODEL:
        return new QualModelPlugin(cPtr, owner);

      default:
        return new SBasePlugin(cPtr, owner);
    }
  }

  public SBase DowncastSBase(long cPtr, boolean owner)
  {
    if (cPtr == 0) return null;

    SBase sb = new SBase(cPtr, false);
    switch ( sb.getTypeCode() )
    {
      case (int) libsbml.SBML_LIST_OF:
        String name = sb.getElementName();
        if (name.equals("listOfQualitativeSpecies"))
        {
          return new ListOfQualitativeSpecies(cPtr, owner);
        }
        else if (name.equals("listOfTransitions"))
        {
          return new ListOfTransitions(cPtr, owner);
        }
        else if (name.equals("listOfInputs"))
        {
          return new ListOfInputs(cPtr, owner);
        }
        else if (name.equals("listOfOutputs"))
        {
          return new ListOfOutputs(cPtr, owner);
        }
        else if (name.equals("listOfFunctionTerms"))
        {
          return new ListOfFunctionTerms(cPtr, owner);
        }

        return new ListOf(cPtr, owner);

      case (int) libsbml.SBML_QUAL_QUALITATIVE_SPECIES:
        return new QualitativeSpecies(cPtr, owner);

      case (int) libsbml.SBML_QUAL_TRANSITION:
        return new Transition(cPtr, owner);

      case (int) libsbml.SBML_QUAL_INPUT:
        return new Input(cPtr, owner);

      case (int) libsbml.SBML_QUAL_OUTPUT:
        return new Output(cPtr, owner);

      case (int) libsbml.SBML_QUAL_DEFAULT_TERM:
        return new DefaultTerm(cPtr, owner);

      case (int) libsbml.SBML_QUAL_FUNCTION_TERM:
        return new FunctionTerm(cPtr, owner);

      default:
        return new SBase(cPtr, owner);
    }
  }

%}

COVARIANT_RTYPE_CLONE(QualExtension)
COVARIANT_RTYPE_CLONE(QualitativeSpecies)
COVARIANT_RTYPE_CLONE(Transition)
COVARIANT_RTYPE_CLONE(Input)
COVARIANT_RTYPE_CLONE(Output)
COVARIANT_RTYPE_CLONE(DefaultTerm)
COVARIANT_RTYPE_CLONE(FunctionTerm)
COVARIANT_RTYPE_CLONE(ListOfQualitativeSpecies)
COVARIANT_RTYPE_CLONE(ListOfTransitions)
COVARIANT_RTYPE_CLONE(ListOfInputs)
COVARIANT_RTYPE_CLONE(ListOfOutputs)
COVARIANT_RTYPE_CLONE(ListOfFunctionTerms)

COVARIANT_RTYPE_LISTOF_GET_REMOVE(QualitativeSpecies)
COVARIANT_RTYPE_LISTOF_GET_REMOVE(Transition)
COVARIANT_RTYPE_LISTOF_GET_REMOVE(Input)
COVARIANT_RTYPE_LISTOF_GET_REMOVE(Output)
COVARIANT_RTYPE_LISTOF_GET_REMOVE(FunctionTerm)

SBMLCONSTRUCTOR_EXCEPTION(QualPkgNamespaces)
SBMLCONSTRUCTOR_EXCEPTION(QualitativeSpecies)
SBMLCONSTRUCTOR_EXCEPTION(Transition)
SBMLCONSTRUCTOR_EXCEPTION(Input)
SBMLCONSTRUCTOR_EXCEPTION(Output)
SBMLCONSTRUCTOR_EXCEPTION(DefaultTerm)
SBMLCONSTRUCTOR_EXCEPTION(FunctionTerm)
SBMLCONSTRUCTOR_EXCEPTION(ListOfQualitativeSpecies)
SBMLCONSTRUCTOR_EXCEPTION(ListOfTransitions)
SBMLCONSTRUCTOR_EXCEPTION(ListOfInputs)
SBMLCONSTRUCTOR_EXCEPTION(ListOfOutputs)
SBMLCONSTRUCTOR_EXCEPTION(ListOfFunctionTerms)


#endif // USE_QUAL

