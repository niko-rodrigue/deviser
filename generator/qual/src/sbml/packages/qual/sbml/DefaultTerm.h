/**
 * @file DefaultTerm.h
 * @brief Definition of the DefaultTerm class.
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
 * @class DefaultTerm
 * @sbmlbrief{qual} TODO:Definition of the DefaultTerm class.
 */


#ifndef DefaultTerm_H__
#define DefaultTerm_H__


#include <sbml/common/extern.h>
#include <sbml/common/sbmlfwd.h>
#include <sbml/packages/qual/common/qualfwd.h>


#ifdef __cplusplus


#include <string>


#include <sbml/SBase.h>
#include <sbml/packages/qual/extension/QualExtension.h>


LIBSBML_CPP_NAMESPACE_BEGIN


class LIBSBML_EXTERN DefaultTerm : public SBase
{
protected:

  /** @cond doxygenLibsbmlInternal */

  unsigned int mResultLevel;
  bool mIsSetResultLevel;

  /** @endcond */

public:

  /**
   * Creates a new DefaultTerm using the given SBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   *
   * @param level an unsigned int, the SBML Level to assign to this
   * DefaultTerm.
   *
   * @param version an unsigned int, the SBML Version to assign to this
   * DefaultTerm.
   *
   * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
   * DefaultTerm.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  DefaultTerm(unsigned int level = QualExtension::getDefaultLevel(),
              unsigned int version = QualExtension::getDefaultVersion(),
              unsigned int pkgVersion =
                QualExtension::getDefaultPackageVersion());


  /**
   * Creates a new DefaultTerm using the given QualPkgNamespaces object.
   *
   * @param qualns the QualPkgNamespaces object.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  DefaultTerm(QualPkgNamespaces *qualns);


  /**
   * Copy constructor for DefaultTerm.
   *
   * @param orig the DefaultTerm instance to copy.
   */
  DefaultTerm(const DefaultTerm& orig);


  /**
   * Assignment operator for DefaultTerm.
   *
   * @param rhs the DefaultTerm object whose values are to be used as the basis
   * of the assignment.
   */
  DefaultTerm& operator=(const DefaultTerm& rhs);


  /**
   * Creates and returns a deep copy of this DefaultTerm object.
   *
   * @return a (deep) copy of this DefaultTerm object.
   */
  virtual DefaultTerm* clone() const;


  /**
   * Destructor for DefaultTerm.
   */
  virtual ~DefaultTerm();


  /**
   * Returns the value of the "resultLevel" attribute of this DefaultTerm.
   *
   * @return the value of the "resultLevel" attribute of this DefaultTerm as a
   * unsigned integer.
   */
  unsigned int getResultLevel() const;


  /**
   * Predicate returning @c true if this DefaultTerm's "resultLevel" attribute
   * is set.
   *
   * @return @c true if this DefaultTerm's "resultLevel" attribute has been
   * set, otherwise @c false is returned.
   */
  bool isSetResultLevel() const;


  /**
   * Sets the value of the "resultLevel" attribute of this DefaultTerm.
   *
   * @param resultLevel unsigned int value of the "resultLevel" attribute to be
   * set.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE,
   * OperationReturnValues_t}
   */
  int setResultLevel(unsigned int resultLevel);


  /**
   * Unsets the value of the "resultLevel" attribute of this DefaultTerm.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   */
  int unsetResultLevel();


  /**
   * Returns the XML element name of this DefaultTerm object.
   *
   * For DefaultTerm, the XML element name is always @c "defaultTerm".
   *
   * @return the name of this element, i.e. @c "defaultTerm".
   */
  virtual const std::string& getElementName() const;


  /**
   * Returns the libSBML type code for this DefaultTerm object.
   *
   * @copydetails doc_what_are_typecodes
   *
   * @return the SBML type code for this object:
   *
   * @sbmlconstant{SBML_QUAL_DEFAULT_TERM, SBMLQualTypeCode_t}
   *
   * @copydetails doc_warning_typecodes_not_unique
   *
   * @see getElementName()
   * @see getPackageName()
   */
  virtual int getTypeCode() const;


  /**
   * Predicate returning @c true if all the required attributes for this
   * DefaultTerm object have been set.
   *
   * @return @c true to indicate that all the required attributes of this
   * DefaultTerm have been set, otherwise @c false is returned.
   *
   *
   * @note The required attributes for the DefaultTerm object are:
   * @li "resultLevel"
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
 * Creates a new DefaultTerm_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 *
 * @param level an unsigned int, the SBML Level to assign to this
 * DefaultTerm_t.
 *
 * @param version an unsigned int, the SBML Version to assign to this
 * DefaultTerm_t.
 *
 * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
 * DefaultTerm_t.
 *
 * @throws SBMLConstructorException
 * Thrown if the given @p level and @p version combination, or this kind of
 * SBML object, are either invalid or mismatched with respect to the parent
 * SBMLDocument object.
 * @copydetails doc_note_setting_lv
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
DefaultTerm_t *
DefaultTerm_create(unsigned int level = QualExtension::getDefaultLevel(),
                   unsigned int version = QualExtension::getDefaultVersion(),
                   unsigned int pkgVersion =
                     QualExtension::getDefaultPackageVersion());


/**
 * Creates and returns a deep copy of this DefaultTerm_t object.
 *
 * @param dt the DefaultTerm_t structure.
 *
 * @return a (deep) copy of this DefaultTerm_t object.
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
DefaultTerm_t*
DefaultTerm_clone(const DefaultTerm_t* dt);


/**
 * Frees this DefaultTerm_t object.
 *
 * @param dt the DefaultTerm_t structure.
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
void
DefaultTerm_free(DefaultTerm_t* dt);


/**
 * Returns the value of the "resultLevel" attribute of this DefaultTerm_t.
 *
 * @param dt the DefaultTerm_t structure whose resultLevel is sought.
 *
 * @return the value of the "resultLevel" attribute of this DefaultTerm_t as a
 * unsigned integer.
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
unsigned int
DefaultTerm_getResultLevel(const DefaultTerm_t * dt);


/**
 * Predicate returning @c 1 if this DefaultTerm_t's "resultLevel" attribute is
 * set.
 *
 * @param dt the DefaultTerm_t structure.
 *
 * @return @c 1 if this DefaultTerm_t's "resultLevel" attribute has been set,
 * otherwise @c 0 is returned.
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
int
DefaultTerm_isSetResultLevel(const DefaultTerm_t * dt);


/**
 * Sets the value of the "resultLevel" attribute of this DefaultTerm_t.
 *
 * @param dt the DefaultTerm_t structure.
 *
 * @param resultLevel unsigned int value of the "resultLevel" attribute to be
 * set.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_INVALID_ATTRIBUTE_VALUE, OperationReturnValues_t}
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
int
DefaultTerm_setResultLevel(DefaultTerm_t * dt, unsigned int resultLevel);


/**
 * Unsets the value of the "resultLevel" attribute of this DefaultTerm_t.
 *
 * @param dt the DefaultTerm_t structure.
 *
 * @copydetails doc_returns_success_code
 * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
 * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
int
DefaultTerm_unsetResultLevel(DefaultTerm_t * dt);


/**
 * Predicate returning @c 1 if all the required attributes for this
 * DefaultTerm_t object have been set.
 *
 * @param dt the DefaultTerm_t structure.
 *
 * @return @c 1 to indicate that all the required attributes of this
 * DefaultTerm_t have been set, otherwise @c 0 is returned.
 *
 *
 * @note The required attributes for the DefaultTerm_t object are:
 * @li "resultLevel"
 *
 * @memberof DefaultTerm_t
 */
LIBSBML_EXTERN
int
DefaultTerm_hasRequiredAttributes(const DefaultTerm_t * dt);




END_C_DECLS




LIBSBML_CPP_NAMESPACE_END




#endif /* !SWIG */




#endif /* !DefaultTerm_H__ */


