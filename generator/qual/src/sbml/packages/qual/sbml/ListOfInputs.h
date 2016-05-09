/**
 * @file ListOfInputs.h
 * @brief Definition of the ListOfInputs class.
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
 * @class ListOfInputs
 * @sbmlbrief{qual} TODO:Definition of the ListOfInputs class.
 */


#ifndef ListOfInputs_H__
#define ListOfInputs_H__


#include <sbml/common/extern.h>
#include <sbml/common/sbmlfwd.h>
#include <sbml/packages/qual/common/qualfwd.h>


#ifdef __cplusplus


#include <string>


#include <sbml/ListOf.h>
#include <sbml/packages/qual/extension/QualExtension.h>
#include <sbml/packages/qual/sbml/Input.h>


LIBSBML_CPP_NAMESPACE_BEGIN


class LIBSBML_EXTERN ListOfInputs : public ListOf
{

public:

  /**
   * Creates a new ListOfInputs using the given SBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   *
   * @param level an unsigned int, the SBML Level to assign to this
   * ListOfInputs.
   *
   * @param version an unsigned int, the SBML Version to assign to this
   * ListOfInputs.
   *
   * @param pkgVersion an unsigned int, the SBML Qual Version to assign to this
   * ListOfInputs.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  ListOfInputs(unsigned int level = QualExtension::getDefaultLevel(),
               unsigned int version = QualExtension::getDefaultVersion(),
               unsigned int pkgVersion =
                 QualExtension::getDefaultPackageVersion());


  /**
   * Creates a new ListOfInputs using the given QualPkgNamespaces object.
   *
   * @param qualns the QualPkgNamespaces object.
   *
   * @throws SBMLConstructorException
   * Thrown if the given @p level and @p version combination, or this kind of
   * SBML object, are either invalid or mismatched with respect to the parent
   * SBMLDocument object.
   * @copydetails doc_note_setting_lv
   */
  ListOfInputs(QualPkgNamespaces *qualns);


  /**
   * Copy constructor for ListOfInputs.
   *
   * @param orig the ListOfInputs instance to copy.
   */
  ListOfInputs(const ListOfInputs& orig);


  /**
   * Assignment operator for ListOfInputs.
   *
   * @param rhs the ListOfInputs object whose values are to be used as the
   * basis of the assignment.
   */
  ListOfInputs& operator=(const ListOfInputs& rhs);


  /**
   * Creates and returns a deep copy of this ListOfInputs object.
   *
   * @return a (deep) copy of this ListOfInputs object.
   */
  virtual ListOfInputs* clone() const;


  /**
   * Destructor for ListOfInputs.
   */
  virtual ~ListOfInputs();


  /**
   * Get an Input from the ListOfInputs.
   *
   * @param n an unsigned int representing the index of the Input to retrieve.
   *
   * @return the nth Input in this ListOfInputs.
   *
   * @see size()
   */
  virtual Input* get(unsigned int n);


  /**
   * Get an Input from the ListOfInputs.
   *
   * @param n an unsigned int representing the index of the Input to retrieve.
   *
   * @return the nth Input in this ListOfInputs.
   *
   * @see size()
   */
  virtual const Input* get(unsigned int n) const;


  /**
   * Get an Input from the ListOfInputs based on its identifier.
   *
   * @param sid a string representing the identifier of the Input to retrieve.
   *
   * @return the Input in this ListOfInputs with the given id or NULL if no
   * such Input exists.
   *
   * @see size()
   */
  virtual Input* get(const std::string& sid);


  /**
   * Get an Input from the ListOfInputs based on its identifier.
   *
   * @param sid a string representing the identifier of the Input to retrieve.
   *
   * @return the Input in this ListOfInputs with the given id or NULL if no
   * such Input exists.
   *
   * @see size()
   */
  virtual const Input* get(const std::string& sid) const;


  /**
   * Removes the nth Input from this ListOfInputs and returns a pointer to it.
   *
   * @param n an unsigned int representing the index of the Input to remove.
   *
   * @return a pointer to the nth Input in this ListOfInputs.
   *
   * @see size()
   *
   * @note the caller owns the returned object and is responsible for deleting
   * it.
   */
  virtual Input* remove(unsigned int n);


  /**
   * Removes the Input from this ListOfInputs based on its identifier and
   * returns a pointer to it.
   *
   * @param sid a string representing the identifier of the Input to remove.
   *
   * @return the Input in this ListOfInputs based on the identifier or NULL if
   * no such Input exists.
   *
   * @note the caller owns the returned object and is responsible for deleting
   * it.
   */
  virtual Input* remove(const std::string& sid);


  /**
   * Adds a copy of the given Input to this ListOfInputs.
   *
   * @param i the Input object to add.
   *
   * @copydetails doc_returns_success_code
   * @li @sbmlconstant{LIBSBML_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @sbmlconstant{LIBSBML_OPERATION_FAILED, OperationReturnValues_t}
   *
   * @copydetails doc_note_object_is_copied
   *
   * @see createInput()
   */
  int addInput(const Input* i);


  /**
   * Get the number of Input objects in this ListOfInputs.
   *
   * @return the number of Input objects in this ListOfInputs.
   */
  unsigned int getNumInputs() const;


  /**
   * Creates a new Input object, adds it to this ListOfInputs object and
   * returns the Input object created.
   *
   * @return a new Input object instance.
   *
   * @see addInput(const Input* i)
   */
  Input* createInput();


  /**
   * Get an Input from the ListOfInputs based on the QualitativeSpecies to
   * which it refers.
   *
   * @param sid a string representing the qualitativeSpecies attribute of the
   * Input object to retrieve.
   *
   * @return the first Input in this ListOfInputs based on the given
   * qualitativeSpecies attribute or NULL if no such Input exists.
   */
  const Input* getByQualitativeSpecies(const std::string& sid) const;


  /**
   * Get an Input from the ListOfInputs based on the QualitativeSpecies to
   * which it refers.
   *
   * @param sid a string representing the qualitativeSpecies attribute of the
   * Input object to retrieve.
   *
   * @return the first Input in this ListOfInputs based on the given
   * qualitativeSpecies attribute or NULL if no such Input exists.
   */
  Input* getByQualitativeSpecies(const std::string& sid);


  /**
   * Returns the XML element name of this ListOfInputs object.
   *
   * For ListOfInputs, the XML element name is always @c "listOfInputs".
   *
   * @return the name of this element, i.e. @c "listOfInputs".
   */
  virtual const std::string& getElementName() const;


  /**
   * Returns the libSBML type code for this ListOfInputs object.
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
   * ListOfInputs object.
   *
   * @copydetails doc_what_are_typecodes
   *
   * @return the SBML typecode for the objects contained in this ListOfInputs:
   *
   * @sbmlconstant{SBML_QUAL_INPUT, SBMLQualTypeCode_t}
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
   * Creates a new Input in this ListOfInputs
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
 * Get an Input_t from the ListOf_t.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param n an unsigned int representing the index of the Input_t to retrieve.
 *
 * @return the nth Input_t in this ListOf_t.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const Input_t*
ListOfInputs_getInput(ListOf_t* lo, unsigned int n);


/**
 * Get an Input_t from the ListOf_t based on its identifier.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param sid a string representing the identifier of the Input_t to retrieve.
 *
 * @return the Input_t in this ListOf_t with the given id or NULL if no such
 * Input_t exists.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
const Input_t*
ListOfInputs_getById(ListOf_t* lo, const char *sid);


/**
 * Removes the nth Input_t from this ListOf_t and returns a pointer to it.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param n an unsigned int representing the index of the Input_t to remove.
 *
 * @return a pointer to the nth Input_t in this ListOf_t.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
Input_t*
ListOfInputs_remove(ListOf_t* lo, unsigned int n);


/**
 * Removes the Input_t from this ListOf_t based on its identifier and returns a
 * pointer to it.
 *
 * @param lo the ListOf_t structure to search.
 *
 * @param sid a string representing the identifier of the Input_t to remove.
 *
 * @return the Input_t in this ListOf_t based on the identifier or NULL if no
 * such Input_t exists.
 *
 * @memberof Input_t
 */
LIBSBML_EXTERN
Input_t*
ListOfInputs_removeById(ListOf_t* lo, const char* sid);




END_C_DECLS




LIBSBML_CPP_NAMESPACE_END




#endif /* !SWIG */




#endif /* !ListOfInputs_H__ */


