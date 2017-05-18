/**
 * @file CaNamespaces.h
 * @brief Definition of the CaNamespaces class.
 * @author DEVISER
 *
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML. Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2013-2017 jointly by the following organizations:
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
 * @class 
 * @sbmlbrief{} TODO:Definition of the CaNamespaces class.
 */


#ifndef CaNamespaces_h
#define CaNamespaces_h

#include <sbml/xml/XMLNamespaces.h>
#include <sbml/util/List.h>

#include <omex/common/common.h>
#include <omex/common/combinefwd.h>

#ifdef __cplusplus
namespace LIBCOMBINE_CPP_NAMESPACE 
{
  const unsigned int OMEX_DEFAULT_LEVEL   = 1;
  const unsigned int OMEX_DEFAULT_VERSION = 1;
  const char* const OMEX_XMLNS_L1V1   = "http://identifiers.org/combine.specifications/omex-manifest";
}
#else
static const unsigned int OMEX_DEFAULT_LEVEL   = 1;
static const unsigned int OMEX_DEFAULT_VERSION = 1;
static const char* const OMEX_XMLNS_L1V1   = "http://identifiers.org/combine.specifications/omex-manifest";
#endif

#ifdef __cplusplus

#include <string>
#include <stdexcept>

LIBCOMBINE_CPP_NAMESPACE_BEGIN

class LIBCOMBINE_EXTERN CaNamespaces
{
public:

  /**
   * Creates a new CaNamespaces object corresponding to the given OMEX
   * @p level and @p version.
   *
   * @param level the OMEX level
   * @param version the OMEX version
   * 
   */
  CaNamespaces(unsigned int level = OMEX_DEFAULT_LEVEL, 
                 unsigned int version = OMEX_DEFAULT_VERSION);


  /**
   * Destroys this CaNamespaces object.
   */
  virtual ~CaNamespaces();

  
  /**
   * Copy constructor; creates a copy of a CaNamespaces.
   * 
   * @param orig the CaNamespaces instance to copy.
   */
  CaNamespaces(const CaNamespaces& orig);


  /**
   * Assignment operator for CaNamespaces.
   */
  CaNamespaces& operator=(const CaNamespaces& rhs);


  /**
   * Creates and returns a deep copy of this CaNamespaces object.
   *
   * @return the (deep) copy of this CaNamespaces object.
   */
  virtual CaNamespaces* clone () const;


  /**
   * Returns a string representing the OMEX XML namespace for the 
   * given @p level and @p version of OMEX.
   *
   * @param level the OMEX level
   * @param version the OMEX version
   *
   * @return a string representing the OMEX namespace that reflects the
   * OMEX Level and Version specified.
   */
  static std::string getCaNamespaceURI(unsigned int level,
                                         unsigned int version);

  
  /**
   * Returns a list of all supported CaNamespaces in this version of 
   * libcombine. 
   * 
   * @return a list with supported OMEX namespaces. 
   */
  static const List* getSupportedNamespaces();


  /**
   * Frees the list of supported namespaces as generated by
   * getSupportedNamespaces().
   *
   * @param supportedNS the list to be freed.
   *
   * @copydetails doc_note_static_methods
   */
  static void freeCaNamespaces(List * supportedNS);


  /**
   * Returns a string representing the OMEX XML namespace of this
   * object.
   *
   * @return a string representing the OMEX namespace that reflects the
   * OMEX Level and Version of this object.
   */
  virtual std::string getURI() const;


  /**
   * Get the OMEX Level of this CaNamespaces object.
   *
   * @return the OMEX Level of this CaNamespaces object.
   */
  unsigned int getLevel();


  /**
   * Get the OMEX Level of this CaNamespaces object.
   *
   * @return the OMEX Level of this CaNamespaces object.
   */
  unsigned int getLevel() const;


  /**
   * Get the OMEX Version of this CaNamespaces object.
   *
   * @return the OMEX Version of this CaNamespaces object.
   */
  unsigned int getVersion();


  /**
   * Get the OMEX Version of this CaNamespaces object.
   *
   * @return the OMEX Version of this CaNamespaces object.
   */
  unsigned int getVersion() const;


  /**
   * Get the XML namespaces list for this CaNamespaces object.
   *
   * @return the XML namespaces of this CaNamespaces object.
   */
  XMLNamespaces * getNamespaces();


  /**
   * Get the XML namespaces list for this CaNamespaces object.
   * 
   * @return the XML namespaces of this CaNamespaces object.
   */
  const XMLNamespaces * getNamespaces() const;


  /**
   * Add the given XML namespaces list to the set of namespaces within this
   * CaNamespaces object.
   *
   * @param xmlns the XML namespaces to be added.
   *
   * @copydetails doc_returns_success_code
   * @li @omexconstant{LIBCOMBINE_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @omexconstant{LIBCOMBINE_OPERATION_FAILED, OperationReturnValues_t}
   * @li @omexconstant{LIBCOMBINE_INVALID_OBJECT, OperationReturnValues_t}
   */
  int addNamespaces(const XMLNamespaces * xmlns);


  /**
   * Add an XML namespace (a pair of URI and prefix) to the set of namespaces
   * within this CaNamespaces object.
   * 
   * @param uri    the XML namespace to be added.
   * @param prefix the prefix of the namespace to be added.
   *
   * @copydetails doc_returns_success_code
   * @li @omexconstant{LIBCOMBINE_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @omexconstant{LIBCOMBINE_OPERATION_FAILED, OperationReturnValues_t}
   * @li @omexconstant{LIBCOMBINE_INVALID_OBJECT, OperationReturnValues_t}
   */
  int addNamespace(const std::string& uri, const std::string &prefix);


  /**
   * Removes an XML namespace from the set of namespaces within this 
   * CaNamespaces object.
   * 
   * @param uri    the XML namespace to be added.
   *
   * @copydetails doc_returns_success_code
   * @li @omexconstant{LIBCOMBINE_OPERATION_SUCCESS, OperationReturnValues_t}
   * @li @omexconstant{LIBCOMBINE_INDEX_EXCEEDS_SIZE, OperationReturnValues_t}
   */
  int removeNamespace(const std::string& uri);


  /**
   * Predicate returning @c true if the given URL is one of OMEX XML
   * namespaces.
   *
   * @param uri the URI of namespace
   *
   * @return @c true if the "uri" is one of OMEX namespaces, @c false otherwise.
   */
  static bool isCaNamespace(const std::string& uri);


  /**
   * Predicate returning @c true if the given set of namespaces represent a
   * valid set
   *
   * @return @c true if the set of namespaces is valid, @c false otherwise.
   */
  bool isValidCombination();


  /** @cond doxygenLibomexInternal */
  void setLevel(unsigned int level);


  void setVersion(unsigned int version);


  void setNamespaces(XMLNamespaces * xmlns);
  /** @endcond */

protected:  
  /** @cond doxygenLibomexInternal */
  void initCaNamespace();

  unsigned int    mLevel;
  unsigned int    mVersion;
  XMLNamespaces * mNamespaces;

  /** @endcond */
};

LIBCOMBINE_CPP_NAMESPACE_END

#endif  /* __cplusplus */


#ifndef SWIG

LIBCOMBINE_CPP_NAMESPACE_BEGIN
BEGIN_C_DECLS

/**
 * Creates a new CaNamespaces_t structure corresponding to the given OMEX
 * @p level and @p version.
 *
 * CaNamespaces_t structures are used in libCombine to communicate OMEX Level
 * and Version data between constructors and other methods.  The
 * CaNamespaces_t structure class tracks 3-tuples (triples) consisting of
 * OMEX Level, Version, and the corresponding OMEX XML namespace.  Most
 * constructors for OMEX structures in libCombine take a CaNamespaces_t structure
 * as an argument, thereby allowing the constructor to produce the proper
 * combination of attributes and other internal data structures for the
 * given OMEX Level and Version.
 *
 * The plural name "CaNamespaces" is not a mistake, because in OMEX
 * Level&nbsp;3, structures may have extensions added by Level&nbsp;3
 * packages used by a given model; however, until the introduction of
 * OMEX Level&nbsp;3, the CaNamespaces_t structure only records one OMEX
 * Level/Version/namespace combination at a time.
 *
 * @param level the OMEX level
 * @param version the OMEX version
 *
 * @return CaNamespaces_t structure created
 *
 * @ifnot hasDefaultArgs @htmlinclude warn-default-args-in-docs.html @endif@~
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
CaNamespaces_t *
CaNamespaces_create(unsigned int level, unsigned int version);


/**
 * Destroys this CaNamespaces_t structure.
 *
 * @param ns CaNamespaces_t structure to be freed.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
void
CaNamespaces_free (CaNamespaces_t *ns);


/**
 * Get the OMEX Level of this CaNamespaces_t structure.
 *
 * @param omexns the CaNamespaces_t structure to query
 *
 * @return the OMEX Level of this CaNamespaces_t structure.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
unsigned int
CaNamespaces_getLevel(CaNamespaces_t *omexns);


/**
 * Get the OMEX Version of this CaNamespaces_t structure.
 *
 * @param omexns the CaNamespaces_t structure to query
 *
 * @return the OMEX Version of this CaNamespaces_t structure.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
unsigned int
CaNamespaces_getVersion(CaNamespaces_t *omexns);


/**
 * Get the OMEX Version of this CaNamespaces_t structure.
 *
 * @param omexns the CaNamespaces_t structure to query
 *
 * @return the XMLNamespaces_t structure of this CaNamespaces_t structure.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
XMLNamespaces_t *
CaNamespaces_getNamespaces(CaNamespaces_t *omexns);


/**
 * Returns a string representing the OMEX XML namespace for the 
 * given @p level and @p version of OMEX.
 *
 * @param level the OMEX level
 * @param version the OMEX version
 *
 * @return a string representing the OMEX namespace that reflects the
 * OMEX Level and Version specified.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
char *
CaNamespaces_getCaNamespaceURI(unsigned int level, unsigned int version);


/**
 * Add the XML namespaces list to the set of namespaces
 * within this CaNamespaces_t structure.
 * 
 * @param omexns the CaNamespaces_t structure to add to
 * @param xmlns the XML namespaces to be added.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
int
CaNamespaces_addNamespaces(CaNamespaces_t *omexns,
                             const XMLNamespaces_t * xmlns);


/**
 * Returns an array of OMEX Namespaces supported by this version of 
 * LibCombine. 
 *
 * @param length an integer holding the length of the array
 * @return an array of OMEX namespaces, or @c NULL if length is @c NULL. The array 
 *         has to be freed by the caller.
 *
 * @memberof CaNamespaces_t
 */
LIBCOMBINE_EXTERN
CaNamespaces_t **
CaNamespaces_getSupportedNamespaces(int *length);

END_C_DECLS
LIBCOMBINE_CPP_NAMESPACE_END

#endif  /* !SWIG */
#endif  /* CaNamespaces_h */
