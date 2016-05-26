/**
 * @file QualitativeSpecies.java
 * @brief Implementation of the QualitativeSpecies class.
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
#include <sbml/packages/qual/sbml/QualitativeSpecies.h>
#include <sbml/packages/qual/sbml/ListOfQualitativeSpecies.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new QualitativeSpecies using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
QualitativeSpecies QualitativeSpecies(unsigned int level,
                                      unsigned int version,
                                      unsigned int pkgVersion)
  : SBase(level, version)
  , mId ("")
  , mName ("")
  , mCompartment ("")
  , mConstant (False)
  , mIsSetConstant (false)
  , mInitialLevel (SBML_INT_MAX)
  , mIsSetInitialLevel (false)
  , mMaxLevel (SBML_INT_MAX)
  , mIsSetMaxLevel (false)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new QualitativeSpecies using the given QualPkgNamespaces object.
 */
QualitativeSpecies QualitativeSpecies(QualPkgNamespaces *qualns)
  : SBase(qualns)
  , mId ("")
  , mName ("")
  , mCompartment ("")
  , mConstant (False)
  , mIsSetConstant (false)
  , mInitialLevel (SBML_INT_MAX)
  , mIsSetInitialLevel (false)
  , mMaxLevel (SBML_INT_MAX)
  , mIsSetMaxLevel (false)
{
  setElementNamespace(qualns->getURI());
  loadPlugins(qualns);
}


/*
 * Copy constructor for QualitativeSpecies.
 */
QualitativeSpecies QualitativeSpecies(const QualitativeSpecies& orig)
  : SBase( orig )
  , mId ( orig.mId )
  , mName ( orig.mName )
  , mCompartment ( orig.mCompartment )
  , mConstant ( orig.mConstant )
  , mIsSetConstant ( orig.mIsSetConstant )
  , mInitialLevel ( orig.mInitialLevel )
  , mIsSetInitialLevel ( orig.mIsSetInitialLevel )
  , mMaxLevel ( orig.mMaxLevel )
  , mIsSetMaxLevel ( orig.mIsSetMaxLevel )
{
}


/*
 * Assignment operator for QualitativeSpecies.
 */
QualitativeSpecies&
QualitativeSpecies operator=(const QualitativeSpecies& rhs)
{
  if (&rhs != this)
  {
    SBase::operator=(rhs);
    mId = rhs.mId;
    mName = rhs.mName;
    mCompartment = rhs.mCompartment;
    mConstant = rhs.mConstant;
    mIsSetConstant = rhs.mIsSetConstant;
    mInitialLevel = rhs.mInitialLevel;
    mIsSetInitialLevel = rhs.mIsSetInitialLevel;
    mMaxLevel = rhs.mMaxLevel;
    mIsSetMaxLevel = rhs.mIsSetMaxLevel;
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this QualitativeSpecies object.
 */
QualitativeSpecies*
QualitativeSpecies clone() const
{
  return new QualitativeSpecies(*this);
}


/*
 * Destructor for QualitativeSpecies.
 */
QualitativeSpecies ~QualitativeSpecies()
{
}


/*
 * Returns the value of the "id" attribute of this QualitativeSpecies.
 */
const String
QualitativeSpecies getId() const
{
  return mId;
}


/*
 * Returns the value of the "name" attribute of this QualitativeSpecies.
 */
String
QualitativeSpecies getName() const
{
  return mName;
}


/*
 * Returns the value of the "compartment" attribute of this QualitativeSpecies.
 */
const String
QualitativeSpecies getCompartment() const
{
  return mCompartment;
}


/*
 * Returns the value of the "constant" attribute of this QualitativeSpecies.
 */
boolean
QualitativeSpecies getConstant() const
{
  return mConstant;
}


/*
 * Returns the value of the "initialLevel" attribute of this
 * QualitativeSpecies.
 */
int
QualitativeSpecies getInitialLevel() const
{
  return mInitialLevel;
}


/*
 * Returns the value of the "maxLevel" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies getMaxLevel() const
{
  return mMaxLevel;
}


/*
 * Predicate returning @c true if this QualitativeSpecies's "id" attribute is
 * set.
 */
bool
QualitativeSpecies isSetId() const
{
  return (mId.empty() == false);
}


/*
 * Predicate returning @c true if this QualitativeSpecies's "name" attribute is
 * set.
 */
bool
QualitativeSpecies isSetName() const
{
  ;
}


/*
 * Predicate returning @c true if this QualitativeSpecies's "compartment"
 * attribute is set.
 */
bool
QualitativeSpecies isSetCompartment() const
{
  return (mCompartment.empty() == false);
}


/*
 * Predicate returning @c true if this QualitativeSpecies's "constant"
 * attribute is set.
 */
bool
QualitativeSpecies isSetConstant() const
{
  return mIsSetConstant;
}


/*
 * Predicate returning @c true if this QualitativeSpecies's "initialLevel"
 * attribute is set.
 */
bool
QualitativeSpecies isSetInitialLevel() const
{
  return mIsSetInitialLevel;
}


/*
 * Predicate returning @c true if this QualitativeSpecies's "maxLevel"
 * attribute is set.
 */
bool
QualitativeSpecies isSetMaxLevel() const
{
  return mIsSetMaxLevel;
}


/*
 * Sets the value of the "id" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies setId(const String id)
{
  return SyntaxChecker::checkAndSetSId(id, mId);
}


/*
 * Sets the value of the "name" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies setName(String name)
{
  mName = name;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "compartment" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies setCompartment(const String compartment)
{
  if (!(SyntaxChecker::isValidInternalSId(compartment)))
  {
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mCompartment = compartment;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "constant" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies setConstant(boolean constant)
{
  mConstant = constant;
  mIsSetConstant = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "initialLevel" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies setInitialLevel(int initialLevel)
{
  mInitialLevel = initialLevel;
  mIsSetInitialLevel = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "maxLevel" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies setMaxLevel(int maxLevel)
{
  mMaxLevel = maxLevel;
  mIsSetMaxLevel = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "id" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies unsetId()
{
  mId.erase();

  if (mId.empty() == true)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "name" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies unsetName()
{
  TO DO;
}


/*
 * Unsets the value of the "compartment" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies unsetCompartment()
{
  mCompartment.erase();

  if (mCompartment.empty() == true)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "constant" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies unsetConstant()
{
  mConstant = False;
  mIsSetConstant = false;

  if (isSetConstant() == false)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "initialLevel" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies unsetInitialLevel()
{
  mInitialLevel = SBML_INT_MAX;
  mIsSetInitialLevel = false;

  if (isSetInitialLevel() == false)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies.
 */
int
QualitativeSpecies unsetMaxLevel()
{
  mMaxLevel = SBML_INT_MAX;
  mIsSetMaxLevel = false;

  if (isSetMaxLevel() == false)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * @copydoc doc_renamesidref_common
 */
void
QualitativeSpecies renameSIdRefs(const std::string& oldid,
                                 const std::string& newid)
{
  if (isSetCompartment() && mCompartment == oldid)
  {
    setCompartment(newid);
  }
}


/*
 * Returns the XML element name of this QualitativeSpecies object.
 */
const std::string&
QualitativeSpecies getElementName() const
{
  static const string name = "qualitativeSpecies";
  return name;
}


/*
 * Returns the libSBML type code for this QualitativeSpecies object.
 */
int
QualitativeSpecies getTypeCode() const
{
  return SBML_QUAL_QUALITATIVE_SPECIES;
}


/*
 * Predicate returning @c true if all the required attributes for this
 * QualitativeSpecies object have been set.
 */
bool
QualitativeSpecies hasRequiredAttributes() const
{
  bool allPresent = true;

  if (isSetId() == false)
  {
    allPresent = false;
  }

  if (isSetCompartment() == false)
  {
    allPresent = false;
  }

  if (isSetConstant() == false)
  {
    allPresent = false;
  }

  return allPresent;
}



/** @cond doxygenLibsbmlInternal */

/*
 * Write any contained elements
 */
void
QualitativeSpecies writeElements(XMLOutputStream& stream) const
{
  SBase::writeElements(stream);

  SBase::writeExtensionElements(stream);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Accepts the given SBMLVisitor
 */
bool
QualitativeSpecies accept(SBMLVisitor& v) const
{
  return v.visit(*this);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the parent SBMLDocument
 */
void
QualitativeSpecies setSBMLDocument(SBMLDocument* d)
{
  SBase::setSBMLDocument(d);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Enables/disables the given package with this element
 */
void
QualitativeSpecies enablePackageInternal(const std::string& pkgURI,
                                         const std::string& pkgPrefix,
                                         bool flag)
{
  SBase::enablePackageInternal(pkgURI, pkgPrefix, flag);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Adds the expected attributes for this element
 */
void
QualitativeSpecies addExpectedAttributes(ExpectedAttributes& attributes)
{
  SBase::addExpectedAttributes(attributes);

  attributes.add("id");

  attributes.add("name");

  attributes.add("compartment");

  attributes.add("constant");

  attributes.add("initialLevel");

  attributes.add("maxLevel");
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Reads the expected attributes into the member data variables
 */
void
QualitativeSpecies readAttributes(const XMLAttributes& attributes,
                                  const ExpectedAttributes& expectedAttributes)
{
  unsigned int level = getLevel();
  unsigned int version = getVersion();
  unsigned int pkgVersion = getPackageVersion();
  unsigned int numErrs;
  bool assigned = false;
  SBMLErrorLog* log = getErrorLog();

  if (static_cast<ListOfQualitativeSpecies*>(getParentSBMLObject())->size() <
    2)
  {
    numErrs = log->getNumErrors();
    for (int n = numErrs-1; n >= 0; n--)
    {
      if (log->getError(n)->getErrorId() == UnknownPackageAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownPackageAttribute);
        log->logPackageError("qual", QualUnknownError, pkgVersion, level,
          version, details);
      }
      else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownCoreAttribute);
        log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
          details);
      }
    }
  }

  SBase::readAttributes(attributes, expectedAttributes);
  numErrs = log->getNumErrors();

  for (int n = numErrs-1; n >= 0; n--)
  {
    if (log->getError(n)->getErrorId() == UnknownPackageAttribute)
    {
      const std::string details = log->getError(n)->getMessage();
      log->remove(UnknownPackageAttribute);
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        details);
    }
    else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
    {
      const std::string details = log->getError(n)->getMessage();
      log->remove(UnknownCoreAttribute);
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        details);
    }
  }

  // 
  // id SId (use = "required" )
  // 

  assigned = attributes.readInto("id", mId);

  if (assigned == true)
  {
    if (mId.empty() == true)
    {
      logEmptyString(mId, level, version, "<QualitativeSpecies>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mId) == false)
    {
      logError(QualIdSyntaxRule, level, version, "The id '" + mId + "' does not "
        "conform to the syntax.");
    }
  }
  else
  {
    std::string message = "Qual attribute 'id' is missing from the "
      "<QualitativeSpecies> element.";
    log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
      message);
  }

  // 
  // name string (use = "optional" )
  // 

  assigned = attributes.readInto("name", mName);

  if (assigned == true)
  {
    if (mName.empty() == true)
    {
      logEmptyString(mName, level, version, "<QualitativeSpecies>");
    }
  }

  // 
  // compartment SIdRef (use = "required" )
  // 

  assigned = attributes.readInto("compartment", mCompartment);

  if (assigned == true)
  {
    if (mCompartment.empty() == true)
    {
      logEmptyString(mCompartment, level, version, "<QualitativeSpecies>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mCompartment) == false)
    {
      logError(QualQualitativeSpeciesCompartmentMustBeCompartment, level,
        version, "The attribute compartment='" + mCompartment + "' does not "
          "conform to the syntax.");
    }
  }
  else
  {
    std::string message = "Qual attribute 'compartment' is missing from the "
      "<QualitativeSpecies> element.";
    log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
      message);
  }

  // 
  // constant bool (use = "required" )
  // 

  mIsSetConstant = attributes.readInto("constant", mConstant);

  if (!mIsSetConstant)
  {
    std::string message = "Qual attribute 'constant' is missing from the "
      "<QualitativeSpecies> element.";
    log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
      message);
  }

  // 
  // initialLevel uint (use = "optional" )
  // 

  numErrs = log->getNumErrors();
  mIsSetInitialLevel = attributes.readInto("initialLevel", mInitialLevel);

  if ( mIsSetInitialLevel == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      std::string message = "Qual attribute 'initialLevel' from the "
        "<QualitativeSpecies> element must be an integer.";
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        message);
    }
  }

  // 
  // maxLevel uint (use = "optional" )
  // 

  numErrs = log->getNumErrors();
  mIsSetMaxLevel = attributes.readInto("maxLevel", mMaxLevel);

  if ( mIsSetMaxLevel == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      std::string message = "Qual attribute 'maxLevel' from the "
        "<QualitativeSpecies> element must be an integer.";
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        message);
    }
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Writes the attributes to the stream
 */
void
QualitativeSpecies writeAttributes(XMLOutputStream& stream) const
{
  SBase::writeAttributes(stream);

  if (isSetId() == true)
  {
    stream.writeAttribute("id", getPrefix(), mId);
  }

  if (isSetName() == true)
  {
    stream.writeAttribute("name", getPrefix(), mName);
  }

  if (isSetCompartment() == true)
  {
    stream.writeAttribute("compartment", getPrefix(), mCompartment);
  }

  if (isSetConstant() == true)
  {
    stream.writeAttribute("constant", getPrefix(), mConstant);
  }

  if (isSetInitialLevel() == true)
  {
    stream.writeAttribute("initialLevel", getPrefix(), mInitialLevel);
  }

  if (isSetMaxLevel() == true)
  {
    stream.writeAttribute("maxLevel", getPrefix(), mMaxLevel);
  }

  SBase::writeExtensionAttributes(stream);
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Creates a new QualitativeSpecies_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
LIBSBML_EXTERN
QualitativeSpecies_t *
QualitativeSpecies_create(unsigned int level,
                          unsigned int version,
                          unsigned int pkgVersion)
{
  return new QualitativeSpecies(level, version, pkgVersion);
}


/*
 * Creates and returns a deep copy of this QualitativeSpecies_t object.
 */
LIBSBML_EXTERN
QualitativeSpecies_t*
QualitativeSpecies_clone(const QualitativeSpecies_t* qs)
{
  if (qs != NULL)
  {
    return static_cast<QualitativeSpecies_t*>(qs->clone());
  }
  else
  {
    return NULL;
  }
}


/*
 * Frees this QualitativeSpecies_t object.
 */
LIBSBML_EXTERN
void
QualitativeSpecies_free(QualitativeSpecies_t* qs)
{
  if (qs != NULL)
  {
    delete qs;
  }
}


/*
 * Returns the value of the "id" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
String
QualitativeSpecies_getId(const QualitativeSpecies * qs)
{
  if (qs == NULL)
  {
    return NULL;
  }

  return qs->getId().empty() ? NULL : safe_strdup(qs->getId().c_str());
}


/*
 * Returns the value of the "name" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
String
QualitativeSpecies_getName(const QualitativeSpecies * qs)
{
  if (qs == NULL)
  {
    return NULL;
  }

  return qs->getName().empty() ? NULL : safe_strdup(qs->getName().c_str());
}


/*
 * Returns the value of the "compartment" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
String
QualitativeSpecies_getCompartment(const QualitativeSpecies * qs)
{
  if (qs == NULL)
  {
    return NULL;
  }

  return qs->getCompartment().empty() ? NULL :
    safe_strdup(qs->getCompartment().c_str());
}


/*
 * Returns the value of the "constant" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
boolean
QualitativeSpecies_getConstant(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->getConstant()) : 0;
}


/*
 * Returns the value of the "initialLevel" attribute of this
 * QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_getInitialLevel(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->getInitialLevel() : SBML_INT_MAX;
}


/*
 * Returns the value of the "maxLevel" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_getMaxLevel(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->getMaxLevel() : SBML_INT_MAX;
}


/*
 * Predicate returning @c 1 if this QualitativeSpecies's "id" attribute is set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetId(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->isSetId()) : 0;
}


/*
 * Predicate returning @c 1 if this QualitativeSpecies's "name" attribute is
 * set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetName(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->isSetName()) : 0;
}


/*
 * Predicate returning @c 1 if this QualitativeSpecies's "compartment"
 * attribute is set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetCompartment(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->isSetCompartment()) : 0;
}


/*
 * Predicate returning @c 1 if this QualitativeSpecies's "constant" attribute
 * is set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetConstant(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->isSetConstant()) : 0;
}


/*
 * Predicate returning @c 1 if this QualitativeSpecies's "initialLevel"
 * attribute is set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetInitialLevel(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->isSetInitialLevel()) : 0;
}


/*
 * Predicate returning @c 1 if this QualitativeSpecies's "maxLevel" attribute
 * is set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_isSetMaxLevel(const QualitativeSpecies * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->isSetMaxLevel()) : 0;
}


/*
 * Sets the value of the "id" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setId(QualitativeSpecies * qs, String id)
{
  return (qs != NULL) ? qs->setId(id) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "name" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setName(QualitativeSpecies * qs, String name)
{
  return (qs != NULL) ? qs->setName(name) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "compartment" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setCompartment(QualitativeSpecies * qs, String compartment)
{
  return (qs != NULL) ? qs->setCompartment(compartment) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "constant" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setConstant(QualitativeSpecies * qs, boolean constant)
{
  return (qs != NULL) ? qs->setConstant(constant) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "initialLevel" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setInitialLevel(QualitativeSpecies * qs, int initialLevel)
{
  return (qs != NULL) ? qs->setInitialLevel(initialLevel) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "maxLevel" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_setMaxLevel(QualitativeSpecies * qs, int maxLevel)
{
  return (qs != NULL) ? qs->setMaxLevel(maxLevel) : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "id" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetId(QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->unsetId() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "name" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetName(QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->unsetName() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "compartment" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetCompartment(QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->unsetCompartment() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "constant" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetConstant(QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->unsetConstant() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "initialLevel" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetInitialLevel(QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->unsetInitialLevel() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_unsetMaxLevel(QualitativeSpecies * qs)
{
  return (qs != NULL) ? qs->unsetMaxLevel() : LIBSBML_INVALID_OBJECT;
}


/*
 * Predicate returning @c 1 if all the required attributes for this
 * QualitativeSpecies_t object have been set.
 */
LIBSBML_EXTERN
int
QualitativeSpecies_hasRequiredAttributes(const QualitativeSpecies_t * qs)
{
  return (qs != NULL) ? static_cast<int>(qs->hasRequiredAttributes()) : 0;
}




LIBSBML_CPP_NAMESPACE_END


