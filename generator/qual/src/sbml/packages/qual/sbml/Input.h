/**
 * @file Input.h
 * @brief Definition of the Input class.
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
 *
 * @class Input
 * @sbmlbrief{qual} TODO:Definition of the Input class.
 */


#ifndef Input_H__
#define Input_H__


#include <sbml/common/extern.h>
#include <sbml/common/sbmlfwd.h>
#include <sbml/packages/qual/common/qualfwd.h>


#ifdef __cplusplus


#include <string>


#include <sbml/SBase.h>
#include <sbml/packages/qual/extension/QualExtension.h>


LIBSBML_CPP_NAMESPACE_BEGIN


class LIBSBML_EXTERN Input : public SBase
{
protected:

  /** @cond doxygenLibsbmlInternal */

  std::string mId;
  std::string mName;
  Sign_t mSign;
  std::string mQualitativeSpecies;
  TransitionInputEffect_t mTransitionEffect;
  unsigned int mThresholdLevel;
  bool mIsSetThresholdLevel;

  /** @endcond */

public:

  /**
   * Creates a new Input using the given SBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   *
   * @param level an unsigned int, the SBML Level to assign to this Input.
   *
   * @param version an unsigned int, the SBML Version to assign to this Input.
   *
   * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
   * Input.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  Input(unsigned int level = QualExtension::getDefaultLevel(),
        unsigned int version = QualExtension::getDefaultVersion(),
        unsigned int pkgVersion = QualExtension::getDefaultPackageVersion());


  /**
   * Creates a new Input using the given QualPkgNamespaces object.
   *
   * @param qualns the QualPkgNamespaces object.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  Input(QualPkgNamespaces *qualns);


  /**
   * Copy constructor for Input.
   *
   * @param orig the Input instance to copy.
   */
  Input(const Input& orig);


  /**
   * Assignment operator for Input.
   *
   * @param rhs the Input object whose values are to be used as the basis of
   * the assignment.
   */
  Input& operator=(const Input& rhs);


  /**
   * Creates and returns a deep copy of this Input object.
   *
   * @return a (deep) copy of this Input object.
   */
  virtual Input* clone() const;


  /**
   * Destructor for Input.
   */
  virtual ~Input();


  /**
   * Returns the value of the "id" attribute of this Input.
   *
   * @return the value of the "id" attribute of this Input as a string.
   */
  const std::string& getId() const;


  /**
   * Returns the value of the "name" attribute of this Input.
   *
   * @return the value of the "name" attribute of this Input as a string.
   */
  const std::string& getName() const;


  /**
   * Returns the value of the "sign" attribute of this Input.
   *
   * @return the value of the "sign" attribute of this Input as a Sign_t.
   */
  Sign_t getSign() const;


  /**
   * Returns the value of the "sign" attribute of this Input.
   *
   * @return the value of the "sign" attribute of this Input as a string.
   */
  const std::string& getSignAsString() const;


  /**
   * Returns the value of the "qualitativeSpecies" attribute of this Input.
   *
   * @return the value of the "qualitativeSpecies" attribute of this Input as a
   * string.
   */
  const std::string& getQualitativeSpecies() const;


  /**
   * Returns the value of the "transitionEffect" attribute of this Input.
   *
   * @return the value of the "transitionEffect" attribute of this Input as a
   * TransitionInputEffect_t.
   */
  TransitionInputEffect_t getTransitionEffect() const;


  /**
   * Returns the value of the "transitionEffect" attribute of this Input.
   *
   * @return the value of the "transitionEffect" attribute of this Input as a
   * string.
   */
  const std::string& getTransitionEffectAsString() const;


  /**
   * Returns the value of the "thresholdLevel" attribute of this Input.
   *
   * @return the value of the "thresholdLevel" attribute of this Input as a
   * unsigned integer.
   */
  unsigned int getThresholdLevel() const;


  /**
   * Predicate returning @c true if this Input's "id" attribute is set.
   *
   * @return @c true if this Input's "id" attribute has been set, otherwise @c
   * false is returned.
   */
  bool isSetId() const;


  /**
   * Predicate returning @c true if this Input's "name" attribute is set.
   *
   * @return @c true if this Input's "name" attribute has been set, otherwise
   * @c false is returned.
   */
  bool isSetName() const;


  /**
   * Predicate returning @c true if this Input's "sign" attribute is set.
   *
   * @return @c true if this Input's "sign" attribute has been set, otherwise
   * @c false is returned.
   */
  bool isSetSign() const;


  /**
   * Predicate returning @c true if this Input's "qualitativeSpecies" attribute
   * is set.
   *
   * @return @c true if this Input's "qualitativeSpecies" attribute has been
   * set, otherwise @c false is returned.
   */
  bool isSetQualitativeSpecies() const;


  /**
   * Predicate returning @c true if this Input's "transitionEffect" attribute
   * is set.
   *
   * @return @c true if this Input's "transitionEffect" attribute has been set,
   * otherwise @c false is returned.
   */
  bool isSetTransitionEffect() const;


  /**
   * Predicate returning @c true if this Input's "thresholdLevel" attribute is
   * set.
   *
   * @return @c true if this Input's "thresholdLevel" attribute has been set,
   * otherwise @c false is returned.
   */
  bool isSetThresholdLevel() const;


  /**
   * Sets the value of the "id" attribute of this Input.
   *
   * @param id std::string& value of the "id" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setId(const std::string& id);


  /**
   * Sets the value of the "name" attribute of this Input.
   *
   * @param name std::string& value of the "name" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setName(const std::string& name);


  /**
   * Sets the value of the "sign" attribute of this Input.
   *
   * @param sign Sign_t value of the "sign" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setSign(const Sign_t sign);


  /**
   * Sets the value of the "sign" attribute of this Input.
   *
   * @param sign std::string& of the "sign" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setSign(const std::string& sign);


  /**
   * Sets the value of the "qualitativeSpecies" attribute of this Input.
   *
   * @param qualitativeSpecies std::string& value of the "qualitativeSpecies"
   * attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setQualitativeSpecies(const std::string& qualitativeSpecies);


  /**
   * Sets the value of the "transitionEffect" attribute of this Input.
   *
   * @param transitionEffect TransitionInputEffect_t value of the
   * "transitionEffect" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setTransitionEffect(const TransitionInputEffect_t transitionEffect);


  /**
   * Sets the value of the "transitionEffect" attribute of this Input.
   *
   * @param transitionEffect std::string& of the "transitionEffect" attribute
   * to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setTransitionEffect(const std::string& transitionEffect);


  /**
   * Sets the value of the "thresholdLevel" attribute of this Input.
   *
   * @param thresholdLevel unsigned int value of the "thresholdLevel" attribute
   * to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setThresholdLevel(unsigned int thresholdLevel);


  /**
   * Unsets the value of the "id" attribute of this Input.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetId();


  /**
   * Unsets the value of the "name" attribute of this Input.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetName();


  /**
   * Unsets the value of the "sign" attribute of this Input.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetSign();


  /**
   * Unsets the value of the "qualitativeSpecies" attribute of this Input.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetQualitativeSpecies();


  /**
   * Unsets the value of the "transitionEffect" attribute of this Input.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetTransitionEffect();


  /**
   * Unsets the value of the "thresholdLevel" attribute of this Input.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetThresholdLevel();


  /**
   * @copydoc doc_renamesidref_common
   */
  virtual void renameSIdRefs(const std::string& oldid,
                             const std::string& newid);


  /**
   * Returns the XML element name of this Input object.
   *
   * For Input, the XML element name is always @c "input".
   *
   * @return the name of this element, i.e. @c "input".
   */
  virtual const std::string& getElementName() const;


  /**
   * Returns the libSBML type code for this Input object.
   *
   * @copydetails doc_what_are_typecodes
   *
   * @return the SBML type code for this object:
   *
   * @sbmlconstant{SBML_QUAL_INPUT, SBMLQualTypeCode_t}
   *
   * @copydetails doc_warning_typecodes_not_unique
   *
   * @see getElementName()
   * @see getPackageName()
   */
  virtual int getTypeCode() const;


  /**
   * Predicate returning @c true if all the required attributes for this Input
   * object have been set.
   *
   * @return @c true to indicate that all the required attributes of this Input
   * have been set, otherwise @c false is returned.
   *
   *
   * @note The required attributes for the Input object are:
   * @li "qualitativeSpecies"
   */
  virtual bool hasRequiredAttributes() const;



  /** @cond doxygenLibsbmlInternal */

  /**
   * Write any contained elements
   */
  virtual void writeElements(XMLOutputStream& stream) const;

  /** @endcond */



  /** @cond doxygenLibsbmlInternal */

  /**
   * Accepts the given SBMLVisitor
   */
  virtual bool accept(SBMLVisitor& v) const;

  /** @endcond */



  /** @cond doxygenLibsbmlInternal */

  /**
   * Sets the parent SBMLDocument
   */
  virtual void setSBMLDocument(SBMLDocument* d);

  /** @endcond */



  /** @cond doxygenLibsbmlInternal */

  /**
   * Enables/disables the given package with this element
   */
  virtual void enablePackageInternal(const std::string& pkgURI,
                                     const std::string& pkgPrefix,
                                     bool flag);

  /** @endcond */


protected:


  /** @cond doxygenLibsbmlInternal */

  /**
   * Adds the expected attributes for this element
   */
  virtual void addExpectedAttributes(ExpectedAttributes& attributes);

  /** @endcond */



  /** @cond doxygenLibsbmlInternal */

  /**
   * Reads the expected attributes into the member data variables
   */
  virtual void readAttributes(const XMLAttributes& attributes,
                              const ExpectedAttributes& expectedAttributes);

  /** @endcond */



  /** @cond doxygenLibsbmlInternal */

  /**
   * Writes the attributes to the stream
   */
  virtual void writeAttributes(XMLOutputStream& stream) const;

  /** @endcond */


};



LIBSBML_CPP_NAMESPACE_END




#endif /* __cplusplus */




#ifndef SWIG




LIBSBML_CPP_NAMESPACE_BEGIN




BEGIN_C_DECLS


/**
 * Creates a new Input_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 *
 * @param level an unsigned int, the SBML Level to assign to this Input_t.
 *
 * @param version an unsigned int, the SBML Version to assign to this Input_t.
 *
 * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
 * Input_t.
 *
 * @throws SBMLConstructorException
 * Thrown if the given @p level and @p version combination, or this kind of
 * SBML object, are either invalid or mismatched with respect to the parent
 * SBMLDocument object.
 * @copydetails doc_note_setting_lv
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
Input_t *
Input_create(unsigned int level = QualExtension::getDefaultLevel(),
             unsigned int version = QualExtension::getDefaultVersion(),
             unsigned int pkgVersion =
               QualExtension::getDefaultPackageVersion());


/**
 * Creates and returns a deep copy of this Input_t object.
 *
 * @param i the Input_t structure.
 *
 * @return a (deep) copy of this Input_t object.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
Input_t*
Input_clone(const Input_t* i);


/**
 * Frees this Input_t object.
 *
 * @param i the Input_t structure.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
void
Input_free(Input_t* i);


/**
 * Returns the value of the "id" attribute of this Input_t.
 *
 * @param i the Input_t structure whose id is sought.
 *
 * @return the value of the "id" attribute of this Input_t as a pointer to a
 * string.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const char *
Input_getId(const Input_t * i);


/**
 * Returns the value of the "name" attribute of this Input_t.
 *
 * @param i the Input_t structure whose name is sought.
 *
 * @return the value of the "name" attribute of this Input_t as a pointer to a
 * string.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const char *
Input_getName(const Input_t * i);


/**
 * Returns the value of the "sign" attribute of this Input_t.
 *
 * @param i the Input_t structure whose sign is sought.
 *
 * @return the value of the "sign" attribute of this Input_t as a Sign_t.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
Sign_t
Input_getSign(const Input_t * i);


/**
 * Returns the value of the "sign" attribute of this Input_t.
 *
 * @param i the Input_t structure whose sign is sought.
 *
 * @return the value of the "sign" attribute of this Input_t as a const char *.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const char *
Input_getSignAsString(const Input_t * i);


/**
 * Returns the value of the "qualitativeSpecies" attribute of this Input_t.
 *
 * @param i the Input_t structure whose qualitativeSpecies is sought.
 *
 * @return the value of the "qualitativeSpecies" attribute of this Input_t as a
 * pointer to a string.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const char *
Input_getQualitativeSpecies(const Input_t * i);


/**
 * Returns the value of the "transitionEffect" attribute of this Input_t.
 *
 * @param i the Input_t structure whose transitionEffect is sought.
 *
 * @return the value of the "transitionEffect" attribute of this Input_t as a
 * TransitionInputEffect_t.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
TransitionInputEffect_t
Input_getTransitionEffect(const Input_t * i);


/**
 * Returns the value of the "transitionEffect" attribute of this Input_t.
 *
 * @param i the Input_t structure whose transitionEffect is sought.
 *
 * @return the value of the "transitionEffect" attribute of this Input_t as a
 * const char *.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const char *
Input_getTransitionEffectAsString(const Input_t * i);


/**
 * Returns the value of the "thresholdLevel" attribute of this Input_t.
 *
 * @param i the Input_t structure whose thresholdLevel is sought.
 *
 * @return the value of the "thresholdLevel" attribute of this Input_t as a
 * unsigned integer.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
unsigned int
Input_getThresholdLevel(const Input_t * i);


/**
 * Predicate returning @c 1 if this Input_t's "id" attribute is set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 if this Input_t's "id" attribute has been set, otherwise @c 0
 * is returned.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_isSetId(const Input_t * i);


/**
 * Predicate returning @c 1 if this Input_t's "name" attribute is set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 if this Input_t's "name" attribute has been set, otherwise @c 0
 * is returned.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_isSetName(const Input_t * i);


/**
 * Predicate returning @c 1 if this Input_t's "sign" attribute is set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 if this Input_t's "sign" attribute has been set, otherwise @c 0
 * is returned.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_isSetSign(const Input_t * i);


/**
 * Predicate returning @c 1 if this Input_t's "qualitativeSpecies" attribute is
 * set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 if this Input_t's "qualitativeSpecies" attribute has been set,
 * otherwise @c 0 is returned.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_isSetQualitativeSpecies(const Input_t * i);


/**
 * Predicate returning @c 1 if this Input_t's "transitionEffect" attribute is
 * set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 if this Input_t's "transitionEffect" attribute has been set,
 * otherwise @c 0 is returned.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_isSetTransitionEffect(const Input_t * i);


/**
 * Predicate returning @c 1 if this Input_t's "thresholdLevel" attribute is
 * set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 if this Input_t's "thresholdLevel" attribute has been set,
 * otherwise @c 0 is returned.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_isSetThresholdLevel(const Input_t * i);


/**
 * Sets the value of the "id" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param id const char * value of the "id" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setId(Input_t * i, const char * id);


/**
 * Sets the value of the "name" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param name const char * value of the "name" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setName(Input_t * i, const char * name);


/**
 * Sets the value of the "sign" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param sign Sign_t value of the "sign" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setSign(Input_t * i, Sign_t sign);


/**
 * Sets the value of the "sign" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param sign const char * of the "sign" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setSignAsString(Input_t * i, const char * sign);


/**
 * Sets the value of the "qualitativeSpecies" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param qualitativeSpecies const char * value of the "qualitativeSpecies"
 * attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setQualitativeSpecies(Input_t * i, const char * qualitativeSpecies);


/**
 * Sets the value of the "transitionEffect" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param transitionEffect TransitionInputEffect_t value of the
 * "transitionEffect" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setTransitionEffect(Input_t * i,
                          TransitionInputEffect_t transitionEffect);


/**
 * Sets the value of the "transitionEffect" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param transitionEffect const char * of the "transitionEffect" attribute to
 * be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setTransitionEffectAsString(Input_t * i, const char * transitionEffect);


/**
 * Sets the value of the "thresholdLevel" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @param thresholdLevel unsigned int value of the "thresholdLevel" attribute
 * to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_setThresholdLevel(Input_t * i, unsigned int thresholdLevel);


/**
 * Unsets the value of the "id" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_unsetId(Input_t * i);


/**
 * Unsets the value of the "name" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_unsetName(Input_t * i);


/**
 * Unsets the value of the "sign" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_unsetSign(Input_t * i);


/**
 * Unsets the value of the "qualitativeSpecies" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_unsetQualitativeSpecies(Input_t * i);


/**
 * Unsets the value of the "transitionEffect" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_unsetTransitionEffect(Input_t * i);


/**
 * Unsets the value of the "thresholdLevel" attribute of this Input_t.
 *
 * @param i the Input_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_unsetThresholdLevel(Input_t * i);


/**
 * Predicate returning @c 1 if all the required attributes for this Input_t
 * object have been set.
 *
 * @param i the Input_t structure.
 *
 * @return @c 1 to indicate that all the required attributes of this Input_t
 * have been set, otherwise @c 0 is returned.
 *
 *
 * @note The required attributes for the Input_t object are:
 * @li "qualitativeSpecies"
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
int
Input_hasRequiredAttributes(const Input_t * i);




END_C_DECLS




LIBSBML_CPP_NAMESPACE_END




#endif /* !SWIG */




#endif /* !Input_H__ */


