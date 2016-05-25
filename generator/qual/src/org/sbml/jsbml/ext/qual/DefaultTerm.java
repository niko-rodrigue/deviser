/**
 * @file DefaultTerm.java
 * @brief Implementation of the DefaultTerm class.
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
#include <sbml/packages/qual/sbml/DefaultTerm.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new DefaultTerm using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
DefaultTerm::DefaultTerm(unsigned int level,
                         unsigned int version,
                         unsigned int pkgVersion)
  : SBase(level, version)
  , mResultLevel (SBML_INT_MAX)
  , mIsSetResultLevel (false)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new DefaultTerm using the given QualPkgNamespaces object.
 */
DefaultTerm::DefaultTerm(QualPkgNamespaces *qualns)
  : SBase(qualns)
  , mResultLevel (SBML_INT_MAX)
  , mIsSetResultLevel (false)
{
  setElementNamespace(qualns->getURI());
  loadPlugins(qualns);
}


/*
 * Copy constructor for DefaultTerm.
 */
DefaultTerm::DefaultTerm(const DefaultTerm& orig)
  : SBase( orig )
  , mResultLevel ( orig.mResultLevel )
  , mIsSetResultLevel ( orig.mIsSetResultLevel )
{
}


/*
 * Assignment operator for DefaultTerm.
 */
DefaultTerm&
DefaultTerm::operator=(const DefaultTerm& rhs)
{
  if (&rhs != this)
  {
    SBase::operator=(rhs);
    mResultLevel = rhs.mResultLevel;
    mIsSetResultLevel = rhs.mIsSetResultLevel;
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this DefaultTerm object.
 */
DefaultTerm*
DefaultTerm::clone() const
{
  return new DefaultTerm(*this);
}


/*
 * Destructor for DefaultTerm.
 */
DefaultTerm::~DefaultTerm()
{
}


/*
 * Returns the value of the "resultLevel" attribute of this DefaultTerm.
 */
unsigned int
DefaultTerm::getResultLevel() const
{
  return mResultLevel;
}


/*
 * Predicate returning @c true if this DefaultTerm's "resultLevel" attribute is
 * set.
 */
bool
DefaultTerm::isSetResultLevel() const
{
  return mIsSetResultLevel;
}


/*
 * Sets the value of the "resultLevel" attribute of this DefaultTerm.
 */
int
DefaultTerm::setResultLevel(unsigned int resultLevel)
{
  mResultLevel = resultLevel;
  mIsSetResultLevel = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "resultLevel" attribute of this DefaultTerm.
 */
int
DefaultTerm::unsetResultLevel()
{
  mResultLevel = SBML_INT_MAX;
  mIsSetResultLevel = false;

  if (isSetResultLevel() == false)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Returns the XML element name of this DefaultTerm object.
 */
const std::string&
DefaultTerm::getElementName() const
{
  static const string name = "defaultTerm";
  return name;
}


/*
 * Returns the libSBML type code for this DefaultTerm object.
 */
int
DefaultTerm::getTypeCode() const
{
  return SBML_QUAL_DEFAULT_TERM;
}


/*
 * Predicate returning @c true if all the required attributes for this
 * DefaultTerm object have been set.
 */
bool
DefaultTerm::hasRequiredAttributes() const
{
  bool allPresent = true;

  if (isSetResultLevel() == false)
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
DefaultTerm::writeElements(XMLOutputStream& stream) const
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
DefaultTerm::accept(SBMLVisitor& v) const
{
  return v.visit(*this);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the parent SBMLDocument
 */
void
DefaultTerm::setSBMLDocument(SBMLDocument* d)
{
  SBase::setSBMLDocument(d);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Enables/disables the given package with this element
 */
void
DefaultTerm::enablePackageInternal(const std::string& pkgURI,
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
DefaultTerm::addExpectedAttributes(ExpectedAttributes& attributes)
{
  SBase::addExpectedAttributes(attributes);

  attributes.add("resultLevel");
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Reads the expected attributes into the member data variables
 */
void
DefaultTerm::readAttributes(const XMLAttributes& attributes,
                            const ExpectedAttributes& expectedAttributes)
{
  unsigned int level = getLevel();
  unsigned int version = getVersion();
  unsigned int pkgVersion = getPackageVersion();
  unsigned int numErrs;
  bool assigned = false;
  SBMLErrorLog* log = getErrorLog();

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
  // resultLevel uint (use = "required" )
  // 

  numErrs = log->getNumErrors();
  mIsSetResultLevel = attributes.readInto("resultLevel", mResultLevel);

  if ( mIsSetResultLevel == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      std::string message = "Qual attribute 'resultLevel' from the "
        "<DefaultTerm> element must be an integer.";
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        message);
    }
    else
    {
      std::string message = "Qual attribute 'resultLevel' is missing from the "
        "<DefaultTerm> element.";
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
DefaultTerm::writeAttributes(XMLOutputStream& stream) const
{
  SBase::writeAttributes(stream);

  if (isSetResultLevel() == true)
  {
    stream.writeAttribute("resultLevel", getPrefix(), mResultLevel);
  }

  SBase::writeExtensionAttributes(stream);
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Creates a new DefaultTerm_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
LIBSBML_EXTERN
DefaultTerm_t *
DefaultTerm_create(unsigned int level,
                   unsigned int version,
                   unsigned int pkgVersion)
{
  return new DefaultTerm(level, version, pkgVersion);
}


/*
 * Creates and returns a deep copy of this DefaultTerm_t object.
 */
LIBSBML_EXTERN
DefaultTerm_t*
DefaultTerm_clone(const DefaultTerm_t* dt)
{
  if (dt != NULL)
  {
    return static_cast<DefaultTerm_t*>(dt->clone());
  }
  else
  {
    return NULL;
  }
}


/*
 * Frees this DefaultTerm_t object.
 */
LIBSBML_EXTERN
void
DefaultTerm_free(DefaultTerm_t* dt)
{
  if (dt != NULL)
  {
    delete dt;
  }
}


/*
 * Returns the value of the "resultLevel" attribute of this DefaultTerm_t.
 */
LIBSBML_EXTERN
unsigned int
DefaultTerm_getResultLevel(const DefaultTerm_t * dt)
{
  return (dt != NULL) ? dt->getResultLevel() : SBML_INT_MAX;
}


/*
 * Predicate returning @c 1 if this DefaultTerm_t's "resultLevel" attribute is
 * set.
 */
LIBSBML_EXTERN
int
DefaultTerm_isSetResultLevel(const DefaultTerm_t * dt)
{
  return (dt != NULL) ? static_cast<int>(dt->isSetResultLevel()) : 0;
}


/*
 * Sets the value of the "resultLevel" attribute of this DefaultTerm_t.
 */
LIBSBML_EXTERN
int
DefaultTerm_setResultLevel(DefaultTerm_t * dt, unsigned int resultLevel)
{
  return (dt != NULL) ? dt->setResultLevel(resultLevel) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "resultLevel" attribute of this DefaultTerm_t.
 */
LIBSBML_EXTERN
int
DefaultTerm_unsetResultLevel(DefaultTerm_t * dt)
{
  return (dt != NULL) ? dt->unsetResultLevel() : LIBSBML_INVALID_OBJECT;
}


/*
 * Predicate returning @c 1 if all the required attributes for this
 * DefaultTerm_t object have been set.
 */
LIBSBML_EXTERN
int
DefaultTerm_hasRequiredAttributes(const DefaultTerm_t * dt)
{
  return (dt != NULL) ? static_cast<int>(dt->hasRequiredAttributes()) : 0;
}




LIBSBML_CPP_NAMESPACE_END


