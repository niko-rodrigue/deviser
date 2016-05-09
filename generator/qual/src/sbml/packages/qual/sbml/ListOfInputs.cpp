/**
 * @file ListOfInputs.cpp
 * @brief Implementation of the ListOfInputs class.
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
#include <sbml/packages/qual/sbml/ListOfInputs.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new ListOfInputs using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
ListOfInputs::ListOfInputs(unsigned int level,
                           unsigned int version,
                           unsigned int pkgVersion)
  : ListOf(level, version)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new ListOfInputs using the given QualPkgNamespaces object.
 */
ListOfInputs::ListOfInputs(QualPkgNamespaces *qualns)
  : ListOf(qualns)
{
  setElementNamespace(qualns->getURI());
}


/*
 * Copy constructor for ListOfInputs.
 */
ListOfInputs::ListOfInputs(const ListOfInputs& orig)
  : ListOf( orig )
{
}


/*
 * Assignment operator for ListOfInputs.
 */
ListOfInputs&
ListOfInputs::operator=(const ListOfInputs& rhs)
{
  if (&rhs != this)
  {
    ListOf::operator=(rhs);
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this ListOfInputs object.
 */
ListOfInputs*
ListOfInputs::clone() const
{
  return new ListOfInputs(*this);
}


/*
 * Destructor for ListOfInputs.
 */
ListOfInputs::~ListOfInputs()
{
}


/*
 * Get an Input from the ListOfInputs.
 */
Input*
ListOfInputs::get(unsigned int n)
{
  return static_cast<Input*>(ListOf::get(n));
}


/*
 * Get an Input from the ListOfInputs.
 */
const Input*
ListOfInputs::get(unsigned int n) const
{
  return static_cast<const Input*>(ListOf::get(n));
}


/*
 * Get an Input from the ListOfInputs based on its identifier.
 */
Input*
ListOfInputs::get(const std::string& sid)
{
  return const_cast<Input*>(static_cast<const ListOfInputs&>(*this).get(sid));
}


/*
 * Get an Input from the ListOfInputs based on its identifier.
 */
const Input*
ListOfInputs::get(const std::string& sid) const
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEq<Input>(sid));
  return (result == mItems.end()) ? 0 : static_cast <const Input*> (*result);
}


/*
 * Removes the nth Input from this ListOfInputs and returns a pointer to it.
 */
Input*
ListOfInputs::remove(unsigned int n)
{
  return static_cast<Input*>(ListOf::remove(n));
}


/*
 * Removes the Input from this ListOfInputs based on its identifier and returns
 * a pointer to it.
 */
Input*
ListOfInputs::remove(const std::string& sid)
{
  SBase* item = NULL;
  vector<SBase*>::iterator result;

  result = find_if(mItems.begin(), mItems.end(), IdEq<Input>(sid));

  if (result != mItems.end())
  {
    item = *result;
    mItems.erase(result);
  }

  return static_cast <Input*> (item);
}


/*
 * Adds a copy of the given Input to this ListOfInputs.
 */
int
ListOfInputs::addInput(const Input* i)
{
  if (i == NULL)
  {
    return LIBSBML_OPERATION_FAILED;
  }
  else if (i->hasRequiredAttributes() == false)
  {
    return LIBSBML_INVALID_OBJECT;
  }
  else if (getLevel() != i->getLevel())
  {
    return LIBSBML_LEVEL_MISMATCH;
  }
  else if (getVersion() != i->getVersion())
  {
    return LIBSBML_VERSION_MISMATCH;
  }
  else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
    SBase*>(i)) == false)
  {
    return LIBSBML_NAMESPACES_MISMATCH;
  }
  else
  {
    append(i);
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Get the number of Input objects in this ListOfInputs.
 */
unsigned int
ListOfInputs::getNumInputs() const
{
  return size();
}


/*
 * Creates a new Input object, adds it to this ListOfInputs object and returns
 * the Input object created.
 */
Input*
ListOfInputs::createInput()
{
  Input* i = NULL;

  try
  {
    QUAL_CREATE_NS(qualns, getSBMLNamespaces());
    i = new Input(qualns);
    delete qualns;
  }
  catch (...)
  {
  }

  if (i != NULL)
  {
    appendAndOwn(i);
  }

  return i;
}


/*
 * Used by ListOfInputs::get() to lookup an Input based on its
 * QualitativeSpecies.
 */
struct IdEqQS : public std::unary_function<SBase*, bool>
{
  const string& id;
   
  IdEqQS (const string& id) : id(id) { }
  bool operator() (SBase* sb)
  {
  return (static_cast<Input*>(sb)->getQualitativeSpecies() == id);
  }
};


/*
 * Get an Input from the ListOfInputs based on the QualitativeSpecies to which
 * it refers.
 */
const Input*
ListOfInputs::getByQualitativeSpecies(const std::string& sid) const
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEqQS(sid));
  return (result == mItems.end()) ? 0 : static_cast <const Input*> (*result);
}


/*
 * Get an Input from the ListOfInputs based on the QualitativeSpecies to which
 * it refers.
 */
Input*
ListOfInputs::getByQualitativeSpecies(const std::string& sid)
{
  return const_cast<Input*>(static_cast<const
    ListOfInputs&>(*this).getByQualitativeSpecies(sid));
}


/*
 * Returns the XML element name of this ListOfInputs object.
 */
const std::string&
ListOfInputs::getElementName() const
{
  static const string name = "listOfInputs";
  return name;
}


/*
 * Returns the libSBML type code for this ListOfInputs object.
 */
int
ListOfInputs::getTypeCode() const
{
  return SBML_LIST_OF;
}


/*
 * Returns the libSBML type code for the SBML objects contained in this
 * ListOfInputs object.
 */
int
ListOfInputs::getItemTypeCode() const
{
  return SBML_QUAL_INPUT;
}



/** @cond doxygenLibsbmlInternal */

/*
 * Creates a new Input in this ListOfInputs
 */
SBase*
ListOfInputs::createObject(XMLInputStream& stream)
{
  const std::string& name = stream.peek().getName();
  SBase* object = NULL;
  QUAL_CREATE_NS(qualns, getSBMLNamespaces());

  if (name == "input")
  {
    object = new Input(qualns);
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
ListOfInputs::writeXMLNS(XMLOutputStream& stream) const
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
 * Get an Input_t from the ListOf_t.
 */
LIBSBML_EXTERN
const Input_t*
ListOfInputs_getInput(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfInputs*>(lo)->get(n);
}


/*
 * Get an Input_t from the ListOf_t based on its identifier.
 */
LIBSBML_EXTERN
const Input_t*
ListOfInputs_getById(ListOf_t* lo, const char *sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfInputs*>(lo)->get(sid) : NULL;
}


/*
 * Removes the nth Input_t from this ListOf_t and returns a pointer to it.
 */
LIBSBML_EXTERN
Input_t*
ListOfInputs_remove(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfInputs*>(lo)->remove(n);
}


/*
 * Removes the Input_t from this ListOf_t based on its identifier and returns a
 * pointer to it.
 */
LIBSBML_EXTERN
Input_t*
ListOfInputs_removeById(ListOf_t* lo, const char* sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfInputs*>(lo)->remove(sid) : NULL;
}




LIBSBML_CPP_NAMESPACE_END


