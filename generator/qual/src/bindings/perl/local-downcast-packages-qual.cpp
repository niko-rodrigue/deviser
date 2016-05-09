/**
 * @file local-downcast-packages-qual.cpp
 * @brief Casting to most specific packages object for perl
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
else if (pkgName == "qual")
{
  switch ( sb->getTypeCode() )
  {
    case SBML_LIST_OF:
      name = sb->getElementName();
      if (name == "listOfQualitativeSpecies")
      {
        return SWIGTYPE_p_ListOfQualitativeSpecies;
      }
      else if (name == "listOfTransitions")
      {
        return SWIGTYPE_p_ListOfTransitions;
      }
      else if (name == "listOfInputs")
      {
        return SWIGTYPE_p_ListOfInputs;
      }
      else if (name == "listOfOutputs")
      {
        return SWIGTYPE_p_ListOfOutputs;
      }
      else if (name == "listOfFunctionTerms")
      {
        return SWIGTYPE_p_ListOfFunctionTerms;
      }

      return SWIGTYPE_p_ListOf;

    case SBML_QUAL_QUALITATIVE_SPECIES:
      return SWIGTYPE_p_QualitativeSpecies;

    case SBML_QUAL_TRANSITION:
      return SWIGTYPE_p_Transition;

    case SBML_QUAL_INPUT:
      return SWIGTYPE_p_Input;

    case SBML_QUAL_OUTPUT:
      return SWIGTYPE_p_Output;

    case SBML_QUAL_DEFAULT_TERM:
      return SWIGTYPE_p_DefaultTerm;

    case SBML_QUAL_FUNCTION_TERM:
      return SWIGTYPE_p_FunctionTerm;

    default:
      return SWIGTYPE_p_SBase;
    }
  }

  #endif // USE_QUAL

