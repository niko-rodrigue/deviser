/**
 * @file TwoatonceSBMLError.h
 * @brief Definition of the TwoatonceSBMLError class.
 * @author SBMLTeam
 *
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML. Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2013-2018 jointly by the following organizations:
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


#ifndef TwoatonceSBMLError_H__
#define TwoatonceSBMLError_H__




LIBSBML_CPP_NAMESPACE_BEGIN




BEGIN_C_DECLS


/**
 * @enum TwoatonceSBMLErrorCode_t
 * Codes for all SBML-level errors and warnings from the 'twoatonce' package.
 *
 * These are distinguished from other SBML error codes by having a number
 * between 2000000 and 2099999.
 *
 * @copydetails doc_sbml_error_code_ranges
 */
typedef enum
{
  TwoatonceUnknown                                            = 2010100
, TwoatonceNSUndeclared                                       = 2010101
, TwoatonceElementNotInNs                                     = 2010102
, TwoatonceDuplicateComponentId                               = 2010301
, TwoatonceIdSyntaxRule                                       = 2010302
, TwoatonceAttributeRequiredMissing                           = 2020101
, TwoatonceAttributeRequiredMustBeBoolean                     = 2020102
, TwoatonceAttributeRequiredMustHaveValue                     = 2020103
, TwoatonceSBaseAllowedElements                               = 2020201
, TwoatonceNormalClassAllowedCoreAttributes                   = 2020301
, TwoatonceNormalClassAllowedCoreElements                     = 2020302
, TwoatonceNormalClassAllowedAttributes                       = 2020303
, TwoatonceNormalClassAttributeMustBeString                   = 2020304
, TwoatonceClassWithRequiredIDAllowedCoreAttributes           = 2020401
, TwoatonceClassWithRequiredIDAllowedCoreElements             = 2020402
, TwoatonceClassWithRequiredIDAllowedAttributes               = 2020403
} TwoatonceSBMLErrorCode_t;


END_C_DECLS




LIBSBML_CPP_NAMESPACE_END




#endif /* !TwoatonceSBMLError_H__ */


