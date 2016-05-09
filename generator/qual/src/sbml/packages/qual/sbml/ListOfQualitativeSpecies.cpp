/**
 * @file ListOfQualitativeSpecies.cpp
 * @brief Implementation of the ListOfQualitativeSpecies class.
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
#include <sbml/packages/qual/sbml/ListOfQualitativeSpecies.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new ListOfQualitativeSpecies using the given SBML Level, Version
 * and &ldquo;qual&rdquo; package version.
 */
ListOfQualitativeSpecies::ListOfQualitativeSpecies(unsigned int level,
                                                   unsigned int version,
                                                   unsigned int pkgVersion)
  : ListOf(level, version)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new ListOfQualitativeSpecies using the given QualPkgNamespaces
 * object.
 */
ListOfQualitativeSpecies::ListOfQualitativeSpecies(QualPkgNamespaces *qualns)
  : ListOf(qualns)
{
  setElementNamespace(qualns->getURI());
}


/*
 * Copy constructor for ListOfQualitativeSpecies.
 */
ListOfQualitativeSpecies::ListOfQualitativeSpecies(const
  ListOfQualitativeSpecies& orig)
  : ListOf( orig )
{
}


/*
 * Assignment operator for ListOfQualitativeSpecies.
 */
ListOfQualitativeSpecies&
ListOfQualitativeSpecies::operator=(const ListOfQualitativeSpecies& rhs)
{
  if (&rhs != this)
  {
    ListOf::operator=(rhs);
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this ListOfQualitativeSpecies object.
 */
ListOfQualitativeSpecies*
ListOfQualitativeSpecies::clone() const
{
  return new ListOfQualitativeSpecies(*this);
}


/*
 * Destructor for ListOfQualitativeSpecies.
 */
ListOfQualitativeSpecies::~ListOfQualitativeSpecies()
{
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
 */
QualitativeSpecies*
ListOfQualitativeSpecies::get(unsigned int n)
{
  return static_cast<QualitativeSpecies*>(ListOf::get(n));
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
 */
const QualitativeSpecies*
ListOfQualitativeSpecies::get(unsigned int n) const
{
  return static_cast<const QualitativeSpecies*>(ListOf::get(n));
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
 * identifier.
 */
QualitativeSpecies*
ListOfQualitativeSpecies::get(const std::string& sid)
{
  return const_cast<QualitativeSpecies*>(static_cast<const
    ListOfQualitativeSpecies&>(*this).get(sid));
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
 * identifier.
 */
const QualitativeSpecies*
ListOfQualitativeSpecies::get(const std::string& sid) const
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(),
    IdEq<QualitativeSpecies>(sid));
  return (result == mItems.end()) ? 0 : static_cast <const QualitativeSpecies*>
    (*result);
}


/*
 * Removes the nth QualitativeSpecies from this ListOfQualitativeSpecies and
 * returns a pointer to it.
 */
QualitativeSpecies*
ListOfQualitativeSpecies::remove(unsigned int n)
{
  return static_cast<QualitativeSpecies*>(ListOf::remove(n));
}


/*
 * Removes the QualitativeSpecies from this ListOfQualitativeSpecies based on
 * its identifier and returns a pointer to it.
 */
QualitativeSpecies*
ListOfQualitativeSpecies::remove(const std::string& sid)
{
  SBase* item = NULL;
  vector<SBase*>::iterator result;

  result = find_if(mItems.begin(), mItems.end(),
    IdEq<QualitativeSpecies>(sid));

  if (result != mItems.end())
  {
    item = *result;
    mItems.erase(result);
  }

  return static_cast <QualitativeSpecies*> (item);
}


/*
 * Adds a copy of the given QualitativeSpecies to this
 * ListOfQualitativeSpecies.
 */
int
ListOfQualitativeSpecies::addQualitativeSpecies(const QualitativeSpecies* qs)
{
  if (qs == NULL)
  {
    return LIBSBML_OPERATION_FAILED;
  }
  else if (qs->hasRequiredAttributes() == false)
  {
    return LIBSBML_INVALID_OBJECT;
  }
  else if (getLevel() != qs->getLevel())
  {
    return LIBSBML_LEVEL_MISMATCH;
  }
  else if (getVersion() != qs->getVersion())
  {
    return LIBSBML_VERSION_MISMATCH;
  }
  else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
    SBase*>(qs)) == false)
  {
    return LIBSBML_NAMESPACES_MISMATCH;
  }
  else
  {
    append(qs);
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Get the number of QualitativeSpecies objects in this
 * ListOfQualitativeSpecies.
 */
unsigned int
ListOfQualitativeSpecies::getNumQualitativeSpecies() const
{
  return size();
}


/*
 * Creates a new QualitativeSpecies object, adds it to this
 * ListOfQualitativeSpecies object and returns the QualitativeSpecies object
 * created.
 */
QualitativeSpecies*
ListOfQualitativeSpecies::createQualitativeSpecies()
{
  QualitativeSpecies* qs = NULL;

  try
  {
    QUAL_CREATE_NS(qualns, getSBMLNamespaces());
    qs = new QualitativeSpecies(qualns);
    delete qualns;
  }
  catch (...)
  {
  }

  if (qs != NULL)
  {
    appendAndOwn(qs);
  }

  return qs;
}


/*
 * Used by ListOfQualitativeSpecies::get() to lookup a QualitativeSpecies based
 * on its Compartment.
 */
struct IdEqC : public std::unary_function<SBase*, bool>
{
  const string& id;
   
  IdEqC (const string& id) : id(id) { }
  bool operator() (SBase* sb)
  {
  return (static_cast<QualitativeSpecies*>(sb)->getCompartment() == id);
  }
};


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
 * Compartment to which it refers.
 */
const QualitativeSpecies*
ListOfQualitativeSpecies::getByCompartment(const std::string& sid) const
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEqC(sid));
  return (result == mItems.end()) ? 0 : static_cast <const QualitativeSpecies*>
    (*result);
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
 * Compartment to which it refers.
 */
QualitativeSpecies*
ListOfQualitativeSpecies::getByCompartment(const std::string& sid)
{
  return const_cast<QualitativeSpecies*>(static_cast<const
    ListOfQualitativeSpecies&>(*this).getByCompartment(sid));
}


/*
 * Returns the XML element name of this ListOfQualitativeSpecies object.
 */
const std::string&
ListOfQualitativeSpecies::getElementName() const
{
  static const string name = "listOfQualitativeSpecies";
  return name;
}


/*
 * Returns the libSBML type code for this ListOfQualitativeSpecies object.
 */
int
ListOfQualitativeSpecies::getTypeCode() const
{
  return SBML_LIST_OF;
}


/*
 * Returns the libSBML type code for the SBML objects contained in this
 * ListOfQualitativeSpecies object.
 */
int
ListOfQualitativeSpecies::getItemTypeCode() const
{
  return SBML_QUAL_QUALITATIVE_SPECIES;
}



/** @cond doxygenLibsbmlInternal */

/*
 * Creates a new QualitativeSpecies in this ListOfQualitativeSpecies
 */
SBase*
ListOfQualitativeSpecies::createObject(XMLInputStream& stream)
{
  const std::string& name = stream.peek().getName();
  SBase* object = NULL;
  QUAL_CREATE_NS(qualns, getSBMLNamespaces());

  if (name == "qualitativeSpecies")
  {
    object = new QualitativeSpecies(qualns);
    appendAndOwn(object);
  }

  delete qualns;
  return object;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Writes the namespace for the Qual package
 */
void
ListOfQualitativeSpecies::writeXMLNS(XMLOutputStream& stream) const
{
  XMLNamespaces xmlns;
  std::string prefix = getPrefix();

  if (prefix.empty())
  {
    const XMLNamespaces* thisxmlns = getNamespaces();
    if (thisxmlns && thisxmlns->hasURI(QualExtension::getXmlnsL3V1V1()))
    {
      xmlns.add(QualExtension::getXmlnsL3V1V1(), prefix);
    }
  }

  stream << xmlns;
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Get a QualitativeSpecies_t from the ListOf_t.
 */
LIBSBML_EXTERN
const QualitativeSpecies_t*
ListOfQualitativeSpecies_getQualitativeSpecies(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfQualitativeSpecies*>(lo)->get(n);
}


/*
 * Get a QualitativeSpecies_t from the ListOf_t based on its identifier.
 */
LIBSBML_EXTERN
const QualitativeSpecies_t*
ListOfQualitativeSpecies_getById(ListOf_t* lo, const char *sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfQualitativeSpecies*>(lo)->get(sid)
    : NULL;
}


/*
 * Removes the nth QualitativeSpecies_t from this ListOf_t and returns a
 * pointer to it.
 */
LIBSBML_EXTERN
QualitativeSpecies_t*
ListOfQualitativeSpecies_remove(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfQualitativeSpecies*>(lo)->remove(n);
}


/*
 * Removes the QualitativeSpecies_t from this ListOf_t based on its identifier
 * and returns a pointer to it.
 */
LIBSBML_EXTERN
QualitativeSpecies_t*
ListOfQualitativeSpecies_removeById(ListOf_t* lo, const char* sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast
    <ListOfQualitativeSpecies*>(lo)->remove(sid) : NULL;
}




LIBSBML_CPP_NAMESPACE_END


