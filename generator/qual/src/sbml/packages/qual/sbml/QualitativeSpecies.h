/**
 * @file QualitativeSpecies.h
 * @brief Definition of the QualitativeSpecies class.
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
 * @class QualitativeSpecies
 * @sbmlbrief{qual} TODO:Definition of the QualitativeSpecies class.
 */


#ifndef QualitativeSpecies_H__
#define QualitativeSpecies_H__


#include <sbml/common/extern.h>
#include <sbml/common/sbmlfwd.h>
#include <sbml/packages/qual/common/qualfwd.h>


#ifdef __cplusplus


#include <string>


#include <sbml/SBase.h>
#include <sbml/packages/qual/extension/QualExtension.h>


LIBSBML_CPP_NAMESPACE_BEGIN


class LIBSBML_EXTERN QualitativeSpecies : public SBase
{
protected:

  /** @cond doxygenLibsbmlInternal */

  std::string mId;
  std::string mName;
  std::string mCompartment;
  bool mConstant;
  bool mIsSetConstant;
  unsigned int mInitialLevel;
  bool mIsSetInitialLevel;
  unsigned int mMaxLevel;
  bool mIsSetMaxLevel;

  /** @endcond */

public:

  /**
   * Creates a new QualitativeSpecies using the given SBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   *
   * @param level an unsigned int, the SBML Level to assign to this
   * QualitativeSpecies.
   *
   * @param version an unsigned int, the SBML Version to assign to this
   * QualitativeSpecies.
   *
   * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
   * QualitativeSpecies.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  QualitativeSpecies(unsigned int level = QualExtension::getDefaultLevel(),
                     unsigned int version = QualExtension::getDefaultVersion(),
                     unsigned int pkgVersion =
                       QualExtension::getDefaultPackageVersion());


  /**
   * Creates a new QualitativeSpecies using the given QualPkgNamespaces object.
   *
   * @param qualns the QualPkgNamespaces object.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  QualitativeSpecies(QualPkgNamespaces *qualns);


  /**
   * Copy constructor for QualitativeSpecies.
   *
   * @param orig the QualitativeSpecies instance to copy.
   */
  QualitativeSpecies(const QualitativeSpecies& orig);


  /**
   * Assignment operator for QualitativeSpecies.
   *
   * @param rhs the QualitativeSpecies object whose values are to be used as
   * the basis of the assignment.
   */
  QualitativeSpecies& operator=(const QualitativeSpecies& rhs);


  /**
   * Creates and returns a deep copy of this QualitativeSpecies object.
   *
   * @return a (deep) copy of this QualitativeSpecies object.
   */
  virtual QualitativeSpecies* clone() const;


  /**
   * Destructor for QualitativeSpecies.
   */
  virtual ~QualitativeSpecies();


  /**
   * Returns the value of the "id" attribute of this QualitativeSpecies.
   *
   * @return the value of the "id" attribute of this QualitativeSpecies as a
   * string.
   */
  const std::string& getId() const;


  /**
   * Returns the value of the "name" attribute of this QualitativeSpecies.
   *
   * @return the value of the "name" attribute of this QualitativeSpecies as a
   * string.
   */
  const std::string& getName() const;


  /**
   * Returns the value of the "compartment" attribute of this
   * QualitativeSpecies.
   *
   * @return the value of the "compartment" attribute of this
   * QualitativeSpecies as a string.
   */
  const std::string& getCompartment() const;


  /**
   * Returns the value of the "constant" attribute of this QualitativeSpecies.
   *
   * @return the value of the "constant" attribute of this QualitativeSpecies
   * as a boolean.
   */
  bool getConstant() const;


  /**
   * Returns the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   *
   * @return the value of the "initialLevel" attribute of this
   * QualitativeSpecies as a unsigned integer.
   */
  unsigned int getInitialLevel() const;


  /**
   * Returns the value of the "maxLevel" attribute of this QualitativeSpecies.
   *
   * @return the value of the "maxLevel" attribute of this QualitativeSpecies
   * as a unsigned integer.
   */
  unsigned int getMaxLevel() const;


  /**
   * Predicate returning @c true if this QualitativeSpecies's "id" attribute is
   * set.
   *
   * @return @c true if this QualitativeSpecies's "id" attribute has been set,
   * otherwise @c false is returned.
   */
  bool isSetId() const;


  /**
   * Predicate returning @c true if this QualitativeSpecies's "name" attribute
   * is set.
   *
   * @return @c true if this QualitativeSpecies's "name" attribute has been
   * set, otherwise @c false is returned.
   */
  bool isSetName() const;


  /**
   * Predicate returning @c true if this QualitativeSpecies's "compartment"
   * attribute is set.
   *
   * @return @c true if this QualitativeSpecies's "compartment" attribute has
   * been set, otherwise @c false is returned.
   */
  bool isSetCompartment() const;


  /**
   * Predicate returning @c true if this QualitativeSpecies's "constant"
   * attribute is set.
   *
   * @return @c true if this QualitativeSpecies's "constant" attribute has been
   * set, otherwise @c false is returned.
   */
  bool isSetConstant() const;


  /**
   * Predicate returning @c true if this QualitativeSpecies's "initialLevel"
   * attribute is set.
   *
   * @return @c true if this QualitativeSpecies's "initialLevel" attribute has
   * been set, otherwise @c false is returned.
   */
  bool isSetInitialLevel() const;


  /**
   * Predicate returning @c true if this QualitativeSpecies's "maxLevel"
   * attribute is set.
   *
   * @return @c true if this QualitativeSpecies's "maxLevel" attribute has been
   * set, otherwise @c false is returned.
   */
  bool isSetMaxLevel() const;


  /**
   * Sets the value of the "id" attribute of this QualitativeSpecies.
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
   * Sets the value of the "name" attribute of this QualitativeSpecies.
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
   * Sets the value of the "compartment" attribute of this QualitativeSpecies.
   *
   * @param compartment std::string& value of the "compartment" attribute to be
   * set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setCompartment(const std::string& compartment);


  /**
   * Sets the value of the "constant" attribute of this QualitativeSpecies.
   *
   * @param constant bool value of the "constant" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setConstant(bool constant);


  /**
   * Sets the value of the "initialLevel" attribute of this QualitativeSpecies.
   *
   * @param initialLevel unsigned int value of the "initialLevel" attribute to
   * be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setInitialLevel(unsigned int initialLevel);


  /**
   * Sets the value of the "maxLevel" attribute of this QualitativeSpecies.
   *
   * @param maxLevel unsigned int value of the "maxLevel" attribute to be set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setMaxLevel(unsigned int maxLevel);


  /**
   * Unsets the value of the "id" attribute of this QualitativeSpecies.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetId();


  /**
   * Unsets the value of the "name" attribute of this QualitativeSpecies.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetName();


  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetCompartment();


  /**
   * Unsets the value of the "constant" attribute of this QualitativeSpecies.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetConstant();


  /**
   * Unsets the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetInitialLevel();


  /**
   * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetMaxLevel();


  /**
   * @copydoc doc_renamesidref_common
   */
  virtual void renameSIdRefs(const std::string& oldid,
                             const std::string& newid);


  /**
   * Returns the XML element name of this QualitativeSpecies object.
   *
   * For QualitativeSpecies, the XML element name is always @c
   * "qualitativeSpecies".
   *
   * @return the name of this element, i.e. @c "qualitativeSpecies".
   */
  virtual const std::string& getElementName() const;


  /**
   * Returns the libSBML type code for this QualitativeSpecies object.
   *
   * @copydetails doc_what_are_typecodes
   *
   * @return the SBML type code for this object:
   *
   * @sbmlconstant{SBML_QUAL_QUALITATIVE_SPECIES, SBMLQualTypeCode_t}
   *
   * @copydetails doc_warning_typecodes_not_unique
   *
   * @see getElementName()
   * @see getPackageName()
   */
  virtual int getTypeCode() const;


  /**
   * Predicate returning @c true if all the required attributes for this
   * QualitativeSpecies object have been set.
   *
   * @return @c true to indicate that all the required attributes of this
   * QualitativeSpecies have been set, otherwise @c false is returned.
   *
   *
   * @note The required attributes for the QualitativeSpecies object are:
   * @li "id"
   * @li "compartment"
   * @li "constant"
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
 * Creates a new QualitativeSpecies_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 *
 * @param level an unsigned int, the SBML Level to assign to this
 * QualitativeSpecies_t.
 *
 * @param version an unsigned int, the SBML Version to assign to this
 * QualitativeSpecies_t.
 *
 * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
 * QualitativeSpecies_t.
 *
 * @throws SBMLConstructorException
 * Thrown if the given @p level and @p version combination, or this kind of
 * SBML object, are either invalid or mismatched with respect to the parent
 * SBMLDocument object.
 * @copydetails doc_note_setting_lv
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
QualitativeSpecies_t *
QualitativeSpecies_create(
                          unsigned int level =
                            QualExtension::getDefaultLevel(),
                          unsigned int version =
                            QualExtension::getDefaultVersion(),
                          unsigned int pkgVersion =
                            QualExtension::getDefaultPackageVersion());


/**
 * Creates and returns a deep copy of this QualitativeSpecies_t object.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return a (deep) copy of this QualitativeSpecies_t object.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
QualitativeSpecies_t*
QualitativeSpecies_clone(const QualitativeSpecies_t* qs);


/**
 * Frees this QualitativeSpecies_t object.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
void
QualitativeSpecies_free(QualitativeSpecies_t* qs);


/**
 * Returns the value of the "id" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure whose id is sought.
 *
 * @return the value of the "id" attribute of this QualitativeSpecies_t as a
 * pointer to a string.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
const char *
QualitativeSpecies_getId(const QualitativeSpecies_t * qs);


/**
 * Returns the value of the "name" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure whose name is sought.
 *
 * @return the value of the "name" attribute of this QualitativeSpecies_t as a
 * pointer to a string.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
const char *
QualitativeSpecies_getName(const QualitativeSpecies_t * qs);


/**
 * Returns the value of the "compartment" attribute of this
 * QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure whose compartment is sought.
 *
 * @return the value of the "compartment" attribute of this
 * QualitativeSpecies_t as a pointer to a string.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
const char *
QualitativeSpecies_getCompartment(const QualitativeSpecies_t * qs);


/**
 * Returns the value of the "constant" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure whose constant is sought.
 *
 * @return the value of the "constant" attribute of this QualitativeSpecies_t
 * as a boolean.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_getConstant(const QualitativeSpecies_t * qs);


/**
 * Returns the value of the "initialLevel" attribute of this
 * QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure whose initialLevel is sought.
 *
 * @return the value of the "initialLevel" attribute of this
 * QualitativeSpecies_t as a unsigned integer.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
unsigned int
QualitativeSpecies_getInitialLevel(const QualitativeSpecies_t * qs);


/**
 * Returns the value of the "maxLevel" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure whose maxLevel is sought.
 *
 * @return the value of the "maxLevel" attribute of this QualitativeSpecies_t
 * as a unsigned integer.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
unsigned int
QualitativeSpecies_getMaxLevel(const QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if this QualitativeSpecies_t's "id" attribute is
 * set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 if this QualitativeSpecies_t's "id" attribute has been set,
 * otherwise @c 0 is returned.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetId(const QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if this QualitativeSpecies_t's "name" attribute is
 * set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 if this QualitativeSpecies_t's "name" attribute has been set,
 * otherwise @c 0 is returned.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetName(const QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if this QualitativeSpecies_t's "compartment"
 * attribute is set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 if this QualitativeSpecies_t's "compartment" attribute has been
 * set, otherwise @c 0 is returned.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetCompartment(const QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if this QualitativeSpecies_t's "constant" attribute
 * is set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 if this QualitativeSpecies_t's "constant" attribute has been
 * set, otherwise @c 0 is returned.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetConstant(const QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if this QualitativeSpecies_t's "initialLevel"
 * attribute is set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 if this QualitativeSpecies_t's "initialLevel" attribute has
 * been set, otherwise @c 0 is returned.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetInitialLevel(const QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if this QualitativeSpecies_t's "maxLevel" attribute
 * is set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 if this QualitativeSpecies_t's "maxLevel" attribute has been
 * set, otherwise @c 0 is returned.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetMaxLevel(const QualitativeSpecies_t * qs);


/**
 * Sets the value of the "id" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @param id const char * value of the "id" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setId(QualitativeSpecies_t * qs, const char * id);


/**
 * Sets the value of the "name" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @param name const char * value of the "name" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setName(QualitativeSpecies_t * qs, const char * name);


/**
 * Sets the value of the "compartment" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @param compartment const char * value of the "compartment" attribute to be
 * set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setCompartment(QualitativeSpecies_t * qs,
                                  const char * compartment);


/**
 * Sets the value of the "constant" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @param constant int value of the "constant" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setConstant(QualitativeSpecies_t * qs, int constant);


/**
 * Sets the value of the "initialLevel" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @param initialLevel unsigned int value of the "initialLevel" attribute to be
 * set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setInitialLevel(QualitativeSpecies_t * qs,
                                   unsigned int initialLevel);


/**
 * Sets the value of the "maxLevel" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @param maxLevel unsigned int value of the "maxLevel" attribute to be set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setMaxLevel(QualitativeSpecies_t * qs,
                               unsigned int maxLevel);


/**
 * Unsets the value of the "id" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetId(QualitativeSpecies_t * qs);


/**
 * Unsets the value of the "name" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetName(QualitativeSpecies_t * qs);


/**
 * Unsets the value of the "compartment" attribute of this
 * QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetCompartment(QualitativeSpecies_t * qs);


/**
 * Unsets the value of the "constant" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetConstant(QualitativeSpecies_t * qs);


/**
 * Unsets the value of the "initialLevel" attribute of this
 * QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetInitialLevel(QualitativeSpecies_t * qs);


/**
 * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies_t.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetMaxLevel(QualitativeSpecies_t * qs);


/**
 * Predicate returning @c 1 if all the required attributes for this
 * QualitativeSpecies_t object have been set.
 *
 * @param qs the QualitativeSpecies_t structure.
 *
 * @return @c 1 to indicate that all the required attributes of this
 * QualitativeSpecies_t have been set, otherwise @c 0 is returned.
 *
 *
 * @note The required attributes for the QualitativeSpecies_t object are:
 * @li "id"
 * @li "compartment"
 * @li "constant"
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
int
QualitativeSpecies_hasRequiredAttributes(const QualitativeSpecies_t * qs);




END_C_DECLS




LIBSBML_CPP_NAMESPACE_END




#endif /* !SWIG */




#endif /* !QualitativeSpecies_H__ */


