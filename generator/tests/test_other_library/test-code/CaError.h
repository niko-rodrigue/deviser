/**
 * @file CaError.h
 * @brief Definition of the CaError class.
 * @author DEVISER
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


#ifndef CaError_h
#define CaError_h

#include <omex/common/extern.h>
#include <sbml/xml/XMLError.h>
#include <omex/CaNamespaces.h>


LIBCOMBINE_CPP_NAMESPACE_BEGIN
BEGIN_C_DECLS

/**
 * @enum CaErrorCode_t
 * Codes for all OMEX-level errors and warnings from the core specification.
 */
typedef enum
{
  CaUnknownError                      = 10000 /*!< Encountered unknown internal libCombine error. */
, NotUTF8                               = 10001 /*!< File does not use UTF-8 encoding. */
, UnrecognizedElement                   = 10002 /*!< Encountered unrecognized element. */
, NotSchemaConformant                   = 10003 /*!< Document does not conform to the OMEX XML schema. */
, InvalidMathElement                    = 10201
, MissingAnnotationNamespace            = 10401 /*!< Missing declaration of the XML namespace for the annotation. */
, DuplicateAnnotationNamespaces         = 10402 /*!< Multiple annotations using the same XML namespace. */
, CaNamespaceInAnnotation             = 10403 /*!< The OMEX XML namespace cannot be used in an Annotation object. */
, MultipleAnnotations                   = 10404 /*!< Only one Annotation object is permitted under a given OMEX object. */
, AnnotationNotElement                  = 10405
, NotesNotInXHTMLNamespace              = 10801 /*!< Notes must be placed in the XHTML XML namespace. */
, NotesContainsXMLDecl                  = 10802 /*!< XML declarations are not permitted in Notes objects. */
, NotesContainsDOCTYPE                  = 10803 /*!< XML DOCTYPE elements are not permitted in Notes objects. */
, InvalidNotesContent                   = 10804 /*!< Invalid notes content found. */
, OnlyOneNotesElementAllowed            = 10805 /*!< Only one Notes subobject is permitted on a given OMEX object. */
, SedmlNSUndeclared      = 10101
, SedmlElementNotInNs      = 10102
, SedmlDuplicateComponentId      = 10301
, SedmlIdSyntaxRule      = 10302
, InvalidMetaidSyntax      = 10303
, InvalidNamespaceOnSed      = 20101
, AllowedAttributes      = 20102
, EmptyListElement      = 20103
, SedmlSedDocumentAllowedCoreAttributes      = 20201
, SedmlSedDocumentAllowedCoreElements      = 20202
, SedmlSedDocumentAllowedAttributes      = 20203
, SedmlSedDocumentAllowedElements      = 20204
, SedmlSedDocumentLevelMustBeInteger      = 20205
, SedmlSedDocumentVersionMustBeInteger      = 20206
, SedmlSedDocumentEmptyLOElements      = 20207
, SedmlSedDocumentLOSedModelsAllowedCoreElements      = 20208
, SedmlSedDocumentLOSedModelsAllowedCoreAttributes      = 20209
, SedmlSedModelAllowedCoreAttributes      = 20301
, SedmlSedModelAllowedCoreElements      = 20302
, SedmlSedModelAllowedAttributes      = 20303
, SedmlSedModelAllowedElements      = 20304
, SedmlSedModelSourceMustBeString      = 20305
, SedmlSedModelNameMustBeString      = 20306
, SedmlSedModelLanguageMustBeString      = 20307
, SedmlSedModelEmptyLOElements      = 20308
, SedmlSedModelLOSedChangesAllowedCoreElements      = 20309
, SedmlSedModelLOSedChangesAllowedCoreAttributes      = 20310
, SedmlSedChangeAllowedCoreAttributes      = 20401
, SedmlSedChangeAllowedCoreElements      = 20402
, SedmlSedAddXMLAllowedCoreAttributes      = 20501
, SedmlSedAddXMLAllowedCoreElements      = 20502
, SedmlSedAddXMLAllowedElements      = 20503
, SedmlSedSetValueAllowedCoreAttributes      = 20601
, SedmlSedSetValueAllowedCoreElements      = 20602
, SedmlSedSetValueAllowedAttributes      = 20603
, SedmlSedSetValueAllowedElements      = 20604
, SedmlSedSetValueModelReferenceMustBeModel      = 20605
, SedmlSedSetValueSymbolMustBeString      = 20606
, SedmlSedSetValueTargetMustBeString      = 20607
, SedmlSedSetValueRangeMustBeRange      = 20608
, SedmlSedDataGeneratorAllowedCoreAttributes      = 20701
, SedmlSedDataGeneratorAllowedCoreElements      = 20702
, SedmlSedDataGeneratorAllowedAttributes      = 20703
, SedmlSedDataGeneratorAllowedElements      = 20704
, SedmlSedDataGeneratorNameMustBeString      = 20705
, SedmlSedDataGeneratorEmptyLOElements      = 20706
, SedmlSedDataGeneratorLOSedVariablesAllowedCoreElements      = 20707
, SedmlSedDataGeneratorLOSedParametersAllowedCoreElements      = 20708
, SedmlSedDataGeneratorLOSedVariablesAllowedCoreAttributes      = 20709
, SedmlSedDataGeneratorLOSedParametersAllowedCoreAttributes      = 20710
, SedmlSedRepeatedTaskAllowedCoreAttributes      = 20801
, SedmlSedRepeatedTaskAllowedCoreElements      = 20802
, SedmlSedRepeatedTaskAllowedAttributes      = 20803
, SedmlSedRepeatedTaskRangeIdMustBeRange      = 20804
, SedmlSedRepeatedTaskResetModelMustBeBoolean      = 20805
, SedmlSedSimulationAllowedCoreAttributes      = 20901
, SedmlSedSimulationAllowedCoreElements      = 20902
, SedmlSedSimulationAllowedAttributes      = 20903
, SedmlSedSimulationAllowedElements      = 20904
, SedmlSedSimulationNameMustBeString      = 20905
, SedmlSedVectorRangeAllowedCoreAttributes      = 21001
, SedmlSedVectorRangeAllowedCoreElements      = 21002
, SedmlSedVectorRangeAllowedAttributes      = 21003
, SedmlSedVectorRangeValueMustBeString      = 21004
, UnknownCoreAttribute                  = 99994 /*!< Encountered an unknown attribute in the OMEX Core namespace. */
, CaCodesUpperBound                   = 99999 /*!< Upper boundary of libCombine-specific diagnostic codes. */
} CaErrorCode_t;


/**
 * @enum CaErrorCategory_t
 * Category codes for CaError diagnostics.
 *
 * Note that these are distinct from XMLError's category codes.  User
 * programs receiving an CaError object can use this distinction to
 * check whether the error represents a low-level XML problem or an
 * OMEX problem.
 *
 * @see #XMLErrorCategory_t
 */
typedef enum
{
    LIBCOMBINE_CAT_INTERNAL = LIBSBML_CAT_INTERNAL,
    LIBCOMBINE_CAT_SYSTEM = LIBSBML_CAT_SYSTEM,
    LIBCOMBINE_CAT_XML = LIBSBML_CAT_XML,

    LIBCOMBINE_CAT_OMEX = (LIBCOMBINE_CAT_XML + 1)
    /*!< General OMEX error  not falling into another category below. */

  , LIBCOMBINE_CAT_GENERAL_CONSISTENCY
    /*!< Category of errors that can occur while validating general OMEX
     * constructs. */

  , LIBCOMBINE_CAT_IDENTIFIER_CONSISTENCY
    /*!< Category of errors that can occur while validating symbol
     * identifiers in a model. */

  , LIBCOMBINE_CAT_MATHML_CONSISTENCY
    /*!< Category of errors that can occur while validating MathML formulas
     * in a model.  With respect to the OMEX specification, these concern
     * failures in applying the validation rules numbered 102xx in the
     * Level&nbsp;2 Versions&nbsp;2&ndash;4
     * and Level&nbsp;3 Version&nbsp;1 specifications. */

  , LIBCOMBINE_CAT_INTERNAL_CONSISTENCY
    /*!< Category of errors that can occur while validating libCombine's
     * internal representation of OMEX constructs. (These are tests
     * performed by libCombine and do not have equivalent OMEX validation
     * rules.)  */

} CaErrorCategory_t;


/**
 * @enum CaErrorSeverity_t
 * Severity codes for CaError diagnostics.
 *
 * The only publicly-reported values of this type are the four from #XMLErrorSeverity_t.
 * All other values are used internally only, with translation of those
 * codes done in CaError.cpp
 *
 * @see XMLErrorSeverity_t
 */
typedef enum
{
  /** @cond doxygenLibomexInternal **/

  /* The following are used internally in CaErrorTable, but publicly,
   * we only report one of the 4 XMLError_Severity values.  Translation
   * of the codes is done in CaError.cpp.
   */
    LIBCOMBINE_SEV_WARNING = LIBSBML_SEV_WARNING,
    LIBCOMBINE_SEV_ERROR = LIBSBML_SEV_ERROR,
    LIBCOMBINE_SEV_FATAL = LIBSBML_SEV_FATAL,

    LIBCOMBINE_SEV_SCHEMA_ERROR    = (LIBCOMBINE_SEV_FATAL + 1)
    /*!< The XML content does not conform to
     * the relevant version of the OMEX XML
     * Schema.  The content is not valid OMEX. */

  , LIBCOMBINE_SEV_GENERAL_WARNING
    /*!< The XML content is invalid for some
     * levels/versions of OMEX, and while it
     * may be valid in others, it is something
     * that is best avoided anyway.  LibCombine
     * will issue warnings in those cases it
     * can recognize. */

  , LIBCOMBINE_SEV_NOT_APPLICABLE
    /*!< This error code is only a placeholder
     * for errors that have relevance to some
     * versions of OMEX but not others. */

  /** @endcond **/
} CaErrorSeverity_t;

END_C_DECLS
LIBCOMBINE_CPP_NAMESPACE_END

#ifdef __cplusplus

LIBCOMBINE_CPP_NAMESPACE_BEGIN

class LIBCOMBINE_EXTERN CaError : public XMLError
{
public:

  /**
   * Creates a new CaError to report that something occurred during OMEX
   * processing.
   *
   * When a libCombine operation on OMEX content results in a warning, error
   * or other diagnostic, the issue is reported as an CaError object.
   * CaError objects have identification numbers to indicate the nature
   * of the exception.  @if clike These numbers are drawn from
   * the enumeration <a class="el"
   * href="#CaErrorCode_t">
   * CaErrorCode_t</a>.  @endif@if java These numbers are
   * defined as unsigned integer constants in the file
   * "libcombineConstants.html".  See the <a class="el"
   * href="#CaErrorCode_t">top of this documentation page</a> for a table
   * listing the possible values and their meanings. @endif@if python These
   * numbers are defined as unsigned integer constants in the interface
   * class @link libcombine libcombine@endlink.  See the <a class="el"
   * href="#CaErrorCode_t">top of this documentation page</a> for a table
   * listing the possible values and their meanings. @endif@~ The argument
   * @p errorId to this constructor @em can be (but does not have to be) a
   * value from this @if clike enumeration. If it @em is a value
   * from <a class="el" href="#CaErrorCode_t">CaErrorCode_t</a>, the
   * CaError class assumes the error is a low-level system or OMEX layer
   * error and <em>prepends</em> a built-in, predefined error message to
   * any string passed in the argument @p details to this constructor.  In
   * addition, all <a class="el"
   * href="#CaErrorCode_t">CaErrorCode_t</a> errors have associated
   * values for the @p severity and @p category codes, and these fields are
   * filled-in as well from the enumerations <a class="el"
   * href="#CaErrorSeverity_t">CaErrorSeverity_t</a> and <a class="el"
   * href="#CaErrorCategory_t">CaErrorCategory_t</a>,
   * respectively. @else set of constants.  If it @em
   * is one of the predefined error identifiers, the CaError class
   * assumes the error is a low-level system or OMEX layer error and
   * <em>prepends</em> a built-in, predefined error message to any string
   * passed in the argument @p details to this constructor.  In addition,
   * all the predefined error identifiers have associated values for the
   * @p severity and @p category codes, and these fields are filled-in using
   * the libCombine defaults for each different error identifier. @endif@~
   *
   * If the error identifier @p errorId is a number greater than 99999, the
   * CaError class assumes the error was generated from another part of
   * the software and does not do additional filling in of values beyond
   * the default in the constructor itself.  This allows CaError to serve
   * as a base class for other errors, such as for user-defined validation
   * rules (see Validator).  Callers should fill in all the parameters with
   * suitable values if generating errors with codes greater than 99999 to
   * make maximum use of the CaError facilities.
   *
   * @if clike As mentioned above, there are two other
   * enumerations, <a class="el"
   * href="#CaErrorSeverity_t">CaErrorSeverity_t</a> and <a class="el"
   * href="#CaErrorCategory_t">CaErrorCategory_t</a>, used for indicating
   * the severity and category of error for the predefined CaError codes.
   * The values passed in @p severity and @p category override the defaults
   * assigned based on the error code.  If the value of @p errorId is a
   * value from <a class="el" href="#CaErrorCode_t">CaErrorCode_t</a>,
   * callers do not need to fill in @p severity and @p category.
   * Conversely, if @p errorId is not a value from <a class="el"
   * href="#CaErrorCode_t">CaErrorCode_t</a>, callers can use other
   * values (not just those from <a class="el"
   * href="#CaErrorSeverity_t">CaErrorSeverity_t</a> and <a class="el"
   * href="#CaErrorCategory_t">CaErrorCategory_t</a>, but their own
   * special values) for @p severity and
   * @p category. @else As mentioned above,
   * there are additional constants defined for <a class="el"
   * href="#CaErrorSeverity_t">standard severity</a> and <a class="el"
   * href="#CaErrorCategory_t">standard category</a> codes, and every predefined
   * error in libCombine has an associated value for severity and category taken
   * from these predefined sets.  These constants have symbol names
   * prefixed with <code>LIBCOMBINE_SEV_</code> and <code>LIBCOMBINE_CAT_</code>,
   * respectively.  If the value of @p errorId is one of the standard error
   * codes, callers do not need to fill in @p severity and @p category in a
   * call to this constructor.  Conversely, if @p errorId is not an existing
   * OMEX-level error code, callers can use other values for @p severity and
   * @p category. @endif@~
   *
   * Please see the top of the documentation for CaError for a longer
   * discussion of the possible error codes, their meanings, and their
   * applicability to different combinations of Level+Version of OMEX.
   *
   * @param errorId an unsigned int, the identification number of the error.
   *
   * @param level the OMEX Level of the OMEX model
   *
   * @param version the OMEX Version within the Level of the OMEX model
   *
   * @param details a string containing additional details about the error.
   * If the error code in @p errorId is one that is recognized by CaError,
   * the given message is @em appended to a predefined message associated
   * with the given code.  If the error code is not recognized, the message
   * is stored as-is as the text of the error.
   *
   * @param line an unsigned int, the line number at which the error occured.
   *
   * @param column an unsigned int, the column number at which the error occured.
   *
   * @param severity an integer indicating severity of the error.
   *
   * @param category an integer indicating the category to which the error
   * belongs.
   */
  CaError
  (
     const unsigned int errorId  = 0
   , const unsigned int level    = OMEX_DEFAULT_LEVEL
   , const unsigned int version  = OMEX_DEFAULT_VERSION
   , const std::string& details  = ""
   , const unsigned int line     = 0
   , const unsigned int column   = 0
   , const unsigned int severity = LIBCOMBINE_SEV_ERROR
   , const unsigned int category = LIBCOMBINE_CAT_OMEX
  );


  /**
   * Copy constructor; creates a copy of this CaError.
   */
  CaError(const CaError& orig);

  /**
   * Destroys this CaError.
   */
  virtual ~CaError();


#ifndef SWIG

  /** @cond doxygenLibomexInternal **/

  /**
   * Creates and returns a deep copy of this CaError object.
   *
   * @return the (deep) copy of this CaError object.
   */
  virtual CaError* clone() const;

  /**
   * Outputs this CaError to stream in the following format (and followed
   * by a newline):
   *
   *   line: (error id) message
   *
   * @param stream the output stream to write to.
   */
  virtual void print(std::ostream& stream) const;

  /** @endcond **/

#endif  /* !SWIG */

protected:
  /** @cond doxygenLibomexInternal **/

  virtual std::string stringForSeverity(unsigned int code) const;
  virtual std::string stringForCategory(unsigned int code) const;

  /** @endcond **/
};

LIBCOMBINE_CPP_NAMESPACE_END

#endif  /* __cplusplus */
#endif /* CaError_h */