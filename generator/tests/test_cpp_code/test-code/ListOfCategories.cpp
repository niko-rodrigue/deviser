/**
 * @file ListOfCategories.cpp
 * @brief Implementation of the ListOfCategories class.
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
#include <sbml/packages/distrib/sbml/ListOfCategories.h>
#include <sbml/packages/distrib/validator/DistribSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new ListOfCategories using the given SBML Level, Version and
 * &ldquo;distrib&rdquo; package version.
 */
ListOfCategories::ListOfCategories(unsigned int level,
                                   unsigned int version,
                                   unsigned int pkgVersion)
  : ListOf(level, version)
{
  setSBMLNamespacesAndOwn(new DistribPkgNamespaces(level, version,
    pkgVersion));
}


/*
 * Creates a new ListOfCategories using the given DistribPkgNamespaces object.
 */
ListOfCategories::ListOfCategories(DistribPkgNamespaces *distribns)
  : ListOf(distribns)
{
  setElementNamespace(distribns->getURI());
}


/*
 * Copy constructor for ListOfCategories.
 */
ListOfCategories::ListOfCategories(const ListOfCategories& orig)
  : ListOf( orig )
{
}


/*
 * Assignment operator for ListOfCategories.
 */
ListOfCategories&
ListOfCategories::operator=(const ListOfCategories& rhs)
{
  if (&rhs != this)
  {
    ListOf::operator=(rhs);
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this ListOfCategories object.
 */
ListOfCategories*
ListOfCategories::clone() const
{
  return new ListOfCategories(*this);
}


/*
 * Destructor for ListOfCategories.
 */
ListOfCategories::~ListOfCategories()
{
}


/*
 * Get a Category from the ListOfCategories.
 */
Category*
ListOfCategories::get(unsigned int n)
{
  return static_cast<Category*>(ListOf::get(n));
}


/*
 * Get a Category from the ListOfCategories.
 */
const Category*
ListOfCategories::get(unsigned int n) const
{
  return static_cast<const Category*>(ListOf::get(n));
}


/*
 * Get a Category from the ListOfCategories based on its identifier.
 */
Category*
ListOfCategories::get(const std::string& sid)
{
  return const_cast<Category*>(static_cast<const
    ListOfCategories&>(*this).get(sid));
}


/*
 * Get a Category from the ListOfCategories based on its identifier.
 */
const Category*
ListOfCategories::get(const std::string& sid) const
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEq<Category>(sid));
  return (result == mItems.end()) ? 0 : static_cast <const Category*>
    (*result);
}


/*
 * Removes the nth Category from this ListOfCategories and returns a pointer to
 * it.
 */
Category*
ListOfCategories::remove(unsigned int n)
{
  return static_cast<Category*>(ListOf::remove(n));
}


/*
 * Removes the Category from this ListOfCategories based on its identifier and
 * returns a pointer to it.
 */
Category*
ListOfCategories::remove(const std::string& sid)
{
  SBase* item = NULL;
  vector<SBase*>::iterator result;

  result = find_if(mItems.begin(), mItems.end(), IdEq<Category>(sid));

  if (result != mItems.end())
  {
    item = *result;
    mItems.erase(result);
  }

  return static_cast <Category*> (item);
}


/*
 * Adds a copy of the given Category to this ListOfCategories.
 */
int
ListOfCategories::addCategory(const Category* c)
{
  if (c == NULL)
  {
    return LIBSBML_OPERATION_FAILED;
  }
  else if (c->hasRequiredAttributes() == false)
  {
    return LIBSBML_INVALID_OBJECT;
  }
  else if (getLevel() != c->getLevel())
  {
    return LIBSBML_LEVEL_MISMATCH;
  }
  else if (getVersion() != c->getVersion())
  {
    return LIBSBML_VERSION_MISMATCH;
  }
  else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
    SBase*>(c)) == false)
  {
    return LIBSBML_NAMESPACES_MISMATCH;
  }
  else
  {
    return append(c);
  }
}


/*
 * Get the number of Category objects in this ListOfCategories.
 */
unsigned int
ListOfCategories::getNumCategories() const
{
  return size();
}


/*
 * Creates a new Category object, adds it to this ListOfCategories object and
 * returns the Category object created.
 */
Category*
ListOfCategories::createCategory()
{
  Category* c = NULL;

  try
  {
    DISTRIB_CREATE_NS(distribns, getSBMLNamespaces());
    c = new Category(distribns);
    delete distribns;
  }
  catch (...)
  {
  }

  if (c != NULL)
  {
    appendAndOwn(c);
  }

  return c;
}


/*
 * Returns the XML element name of this ListOfCategories object.
 */
const std::string&
ListOfCategories::getElementName() const
{
  static const string name = "listOfCategories";
  return name;
}


/*
 * Returns the libSBML type code for this ListOfCategories object.
 */
int
ListOfCategories::getTypeCode() const
{
  return SBML_LIST_OF;
}


/*
 * Returns the libSBML type code for the SBML objects contained in this
 * ListOfCategories object.
 */
int
ListOfCategories::getItemTypeCode() const
{
  return SBML_DISTRIB_CATEGORY;
}



/** @cond doxygenLibsbmlInternal */

/*
 * Creates a new Category in this ListOfCategories
 */
SBase*
ListOfCategories::createObject(XMLInputStream& stream)
{
  const std::string& name = stream.peek().getName();
  SBase* object = NULL;
  DISTRIB_CREATE_NS(distribns, getSBMLNamespaces());

  if (name == "category")
  {
    object = new Category(distribns);
    appendAndOwn(object);
  }

  delete distribns;
  return object;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Writes the namespace for the Distrib package
 */
void
ListOfCategories::writeXMLNS(XMLOutputStream& stream) const
{
  XMLNamespaces xmlns;
  std::string prefix = getPrefix();

  if (prefix.empty())
  {
    const XMLNamespaces* thisxmlns = getNamespaces();
    if (thisxmlns && thisxmlns->hasURI(DistribExtension::getXmlnsL3V2V1()))
    {
      xmlns.add(DistribExtension::getXmlnsL3V2V1(), prefix);
    }
  }

  stream << xmlns;
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Get a Category_t from the ListOf_t.
 */
LIBSBML_EXTERN
Category_t*
ListOfCategories_getCategory(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfCategories*>(lo)->get(n);
}


/*
 * Get a Category_t from the ListOf_t based on its identifier.
 */
LIBSBML_EXTERN
Category_t*
ListOfCategories_getById(ListOf_t* lo, const char *sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfCategories*>(lo)->get(sid) : NULL;
}


/*
 * Removes the nth Category_t from this ListOf_t and returns a pointer to it.
 */
LIBSBML_EXTERN
Category_t*
ListOfCategories_remove(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfCategories*>(lo)->remove(n);
}


/*
 * Removes the Category_t from this ListOf_t based on its identifier and
 * returns a pointer to it.
 */
LIBSBML_EXTERN
Category_t*
ListOfCategories_removeById(ListOf_t* lo, const char* sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfCategories*>(lo)->remove(sid) :
    NULL;
}




LIBSBML_CPP_NAMESPACE_END


