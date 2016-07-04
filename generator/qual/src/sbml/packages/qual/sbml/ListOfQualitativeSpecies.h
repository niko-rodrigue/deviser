/**
 * @file ListOfQualitativeSpecies.h
 * @brief Definition of the ListOfQualitativeSpecies class.
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
 * @class ListOfQualitativeSpecies
 * @sbmlbrief{qual} TODO:Definition of the ListOfQualitativeSpecies class.
 */


#ifndef ListOfQualitativeSpecies_H__
#define ListOfQualitativeSpecies_H__


#include <sbml/common/extern.h>
#include <sbml/common/sbmlfwd.h>
#include <sbml/packages/qual/common/qualfwd.h>


#ifdef __cplusplus


#include <string>


#include <sbml/ListOf.h>
#include <sbml/packages/qual/extension/QualExtension.h>
#include <sbml/packages/qual/sbml/QualitativeSpecies.h>


LIBSBML_CPP_NAMESPACE_BEGIN


class LIBSBML_EXTERN ListOfQualitativeSpecies : public ListOf
{

public:

  /**
   * Creates a new ListOfQualitativeSpecies using the given SBML Level, Version
   * and &ldquo;qual&rdquo; package version.
   *
   * @param level an unsigned int, the SBML Level to assign to this
   * ListOfQualitativeSpecies.
   *
   * @param version an unsigned int, the SBML Version to assign to this
   * ListOfQualitativeSpecies.
   *
   * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
   * ListOfQualitativeSpecies.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  ListOfQualitativeSpecies(unsigned int level =
    QualExtension::getDefaultLevel(),
                           unsigned int version =
                             QualExtension::getDefaultVersion(),
                           unsigned int pkgVersion =
                             QualExtension::getDefaultPackageVersion());


  /**
   * Creates a new ListOfQualitativeSpecies using the given QualPkgNamespaces
   * object.
   *
   * @param qualns the QualPkgNamespaces object.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  ListOfQualitativeSpecies(QualPkgNamespaces *qualns);


  /**
   * Copy constructor for ListOfQualitativeSpecies.
   *
   * @param orig the ListOfQualitativeSpecies instance to copy.
   */
  ListOfQualitativeSpecies(const ListOfQualitativeSpecies& orig);


  /**
   * Assignment operator for ListOfQualitativeSpecies.
   *
   * @param rhs the ListOfQualitativeSpecies object whose values are to be used
   * as the basis of the assignment.
   */
  ListOfQualitativeSpecies& operator=(const ListOfQualitativeSpecies& rhs);


  /**
   * Creates and returns a deep copy of this ListOfQualitativeSpecies object.
   *
   * @return a (deep) copy of this ListOfQualitativeSpecies object.
   */
  virtual ListOfQualitativeSpecies* clone() const;


  /**
   * Destructor for ListOfQualitativeSpecies.
   */
  virtual ~ListOfQualitativeSpecies();


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
   *
   * @param n an unsigned int representing the index of the QualitativeSpecies
   * to retrieve.
   *
   * @return the nth QualitativeSpecies in this ListOfQualitativeSpecies.
   *
   * @see size()
   */
  virtual QualitativeSpecies* get(unsigned int n);


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
   *
   * @param n an unsigned int representing the index of the QualitativeSpecies
   * to retrieve.
   *
   * @return the nth QualitativeSpecies in this ListOfQualitativeSpecies.
   *
   * @see size()
   */
  virtual const QualitativeSpecies* get(unsigned int n) const;


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
   * identifier.
   *
   * @param sid a string representing the identifier of the QualitativeSpecies
   * to retrieve.
   *
   * @return the QualitativeSpecies in this ListOfQualitativeSpecies with the
   * given id or NULL if no such QualitativeSpecies exists.
   *
   * @see size()
   */
  virtual QualitativeSpecies* get(const std::string& sid);


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
   * identifier.
   *
   * @param sid a string representing the identifier of the QualitativeSpecies
   * to retrieve.
   *
   * @return the QualitativeSpecies in this ListOfQualitativeSpecies with the
   * given id or NULL if no such QualitativeSpecies exists.
   *
   * @see size()
   */
  virtual const QualitativeSpecies* get(const std::string& sid) const;


  /**
   * Removes the nth QualitativeSpecies from this ListOfQualitativeSpecies and
   * returns a pointer to it.
   *
   * @param n an unsigned int representing the index of the QualitativeSpecies
   * to remove.
   *
   * @return a pointer to the nth QualitativeSpecies in this
   * ListOfQualitativeSpecies.
   *
   * @see size()
   *
   * @note the caller owns the returned object and is responsible for deleting
   * it.
   */
  virtual QualitativeSpecies* remove(unsigned int n);


  /**
   * Removes the QualitativeSpecies from this ListOfQualitativeSpecies based on
   * its identifier and returns a pointer to it.
   *
   * @param sid a string representing the identifier of the QualitativeSpecies
   * to remove.
   *
   * @return the QualitativeSpecies in this ListOfQualitativeSpecies based on
   * the identifier or NULL if no such QualitativeSpecies exists.
   *
   * @note the caller owns the returned object and is responsible for deleting
   * it.
   */
  virtual QualitativeSpecies* remove(const std::string& sid);


  /**
   * Adds a copy of the given QualitativeSpecies to this
   * ListOfQualitativeSpecies.
   *
   * @param qs the QualitativeSpecies object to add.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   *
   * @copydetails doc_note_object_is_copied
   *
   * @see createQualitativeSpecies()
   */
  int addQualitativeSpecies(const QualitativeSpecies* qs);


  /**
   * Get the number of QualitativeSpecies objects in this
   * ListOfQualitativeSpecies.
   *
   * @return the number of QualitativeSpecies objects in this
   * ListOfQualitativeSpecies.
   */
  unsigned int getNumQualitativeSpecies() const;


  /**
   * Creates a new QualitativeSpecies object, adds it to this
   * ListOfQualitativeSpecies object and returns the QualitativeSpecies object
   * created.
   *
   * @return a new QualitativeSpecies object instance.
   *
   * @see addQualitativeSpecies(const QualitativeSpecies* qs)
   */
  QualitativeSpecies* createQualitativeSpecies();


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
   * Compartment to which it refers.
   *
   * @param sid a string representing the compartment attribute of the
   * QualitativeSpecies object to retrieve.
   *
   * @return the first QualitativeSpecies in this ListOfQualitativeSpecies
   * based on the given compartment attribute or NULL if no such
   * QualitativeSpecies exists.
   */
  const QualitativeSpecies* getByCompartment(const std::string& sid) const;


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
   * Compartment to which it refers.
   *
   * @param sid a string representing the compartment attribute of the
   * QualitativeSpecies object to retrieve.
   *
   * @return the first QualitativeSpecies in this ListOfQualitativeSpecies
   * based on the given compartment attribute or NULL if no such
   * QualitativeSpecies exists.
   */
  QualitativeSpecies* getByCompartment(const std::string& sid);


  /**
   * Returns the XML element name of this ListOfQualitativeSpecies object.
   *
   * For ListOfQualitativeSpecies, the XML element name is always @c
   * "listOfQualitativeSpecies".
   *
   * @return the name of this element, i.e. @c "listOfQualitativeSpecies".
   */
  virtual const std::string& getElementName() const;


  /**
   * Returns the libSBML type code for this ListOfQualitativeSpecies object.
   *
   * @copydetails doc_what_are_typecodes
   *
   * @return the SBML type code for this object:
   *
   * @sbmlconstant{SBML_LIST_OF, SBMLTypeCode_t}
   *
   * @copydetails doc_warning_typecodes_not_unique
   */
  virtual int getTypeCode() const;


  /**
   * Returns the libSBML type code for the SBML objects contained in this
   * ListOfQualitativeSpecies object.
   *
   * @copydetails doc_what_are_typecodes
   *
   * @return the SBML typecode for the objects contained in this
   * ListOfQualitativeSpecies:
   *
   * @sbmlconstant{SBML_QUAL_QUALITATIVE_SPECIES, SBMLQualTypeCode_t}
   *
   * @copydetails doc_warning_typecodes_not_unique
   *
   * @see getElementName()
   * @see getPackageName()
   */
  virtual int getItemTypeCode() const;


protected:


  /** @cond doxygenLibsbmlInternal */

  /**
   * Creates a new QualitativeSpecies in this ListOfQualitativeSpecies
   */
  virtual SBase* createObject(XMLInputStream& stream);

  /** @endcond */



  /** @cond doxygenLibsbmlInternal */

  /**
   * Writes the namespace for the Qual package
   */
  virtual void writeXMLNS(XMLOutputStream& stream) const;

  /** @endcond */


};



LIBSBML_CPP_NAMESPACE_END




#endif /* __cplusplus */




#ifndef SWIG




LIBSBML_CPP_NAMESPACE_BEGIN




BEGIN_C_DECLS


/**
 * Get a QualitativeSpecies_t from the ListOf_t.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param n an unsigned int representing the index of the QualitativeSpecies_t
 * to retrieve.
 *
 * @return the nth QualitativeSpecies_t in this ListOf_t.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
const QualitativeSpecies_t*
ListOfQualitativeSpecies_getQualitativeSpecies(ListOf_t* lo, unsigned int n);


/**
 * Get a QualitativeSpecies_t from the ListOf_t based on its identifier.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param sid a string representing the identifier of the QualitativeSpecies_t
 * to retrieve.
 *
 * @return the QualitativeSpecies_t in this ListOf_t with the given id or NULL
 * if no such QualitativeSpecies_t exists.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
const QualitativeSpecies_t*
ListOfQualitativeSpecies_getById(ListOf_t* lo, const char *sid);


/**
 * Removes the nth QualitativeSpecies_t from this ListOf_t and returns a
 * pointer to it.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param n an unsigned int representing the index of the QualitativeSpecies_t
 * to remove.
 *
 * @return a pointer to the nth QualitativeSpecies_t in this ListOf_t.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
QualitativeSpecies_t*
ListOfQualitativeSpecies_remove(ListOf_t* lo, unsigned int n);


/**
 * Removes the QualitativeSpecies_t from this ListOf_t based on its identifier
 * and returns a pointer to it.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param sid a string representing the identifier of the QualitativeSpecies_t
 * to remove.
 *
 * @return the QualitativeSpecies_t in this ListOf_t based on the identifier or
 * NULL if no such QualitativeSpecies_t exists.
 *
 * @memberof QualitativeSpecies_t
 */
LIBSBML_EXTERN
QualitativeSpecies_t*
ListOfQualitativeSpecies_removeById(ListOf_t* lo, const char* sid);




END_C_DECLS




LIBSBML_CPP_NAMESPACE_END




#endif /* !SWIG */




#endif /* !ListOfQualitativeSpecies_H__ */


