/**
 * @file Output.cpp
 * @brief Implementation of the Output class.
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
#include <sbml/packages/qual/sbml/Output.h>
#include <sbml/packages/qual/sbml/ListOfOutputs.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new Output using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
Output::Output(unsigned int level,
               unsigned int version,
               unsigned int pkgVersion)
  : SBase(level, version)
  , mQualitativeSpecies ("")
  , mTransitionEffect (TRANSITION_OUTPUT_EFFECT_INVALID)
  , mOutputLevel (SBML_INT_MAX)
  , mIsSetOutputLevel (false)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new Output using the given QualPkgNamespaces object.
 */
Output::Output(QualPkgNamespaces *qualns)
  : SBase(qualns)
  , mQualitativeSpecies ("")
  , mTransitionEffect (TRANSITION_OUTPUT_EFFECT_INVALID)
  , mOutputLevel (SBML_INT_MAX)
  , mIsSetOutputLevel (false)
{
  setElementNamespace(qualns->getURI());
  loadPlugins(qualns);
}


/*
 * Copy constructor for Output.
 */
Output::Output(const Output& orig)
  : SBase( orig )
  , mQualitativeSpecies ( orig.mQualitativeSpecies )
  , mTransitionEffect ( orig.mTransitionEffect )
  , mOutputLevel ( orig.mOutputLevel )
  , mIsSetOutputLevel ( orig.mIsSetOutputLevel )
{
}


/*
 * Assignment operator for Output.
 */
Output&
Output::operator=(const Output& rhs)
{
  if (&rhs != this)
  {
    SBase::operator=(rhs);
    mQualitativeSpecies = rhs.mQualitativeSpecies;
    mTransitionEffect = rhs.mTransitionEffect;
    mOutputLevel = rhs.mOutputLevel;
    mIsSetOutputLevel = rhs.mIsSetOutputLevel;
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this Output object.
 */
Output*
Output::clone() const
{
  return new Output(*this);
}


/*
 * Destructor for Output.
 */
Output::~Output()
{
}


/*
 * Returns the value of the "id" attribute of this Output.
 */
const std::string&
Output::getId() const
{
  return mId;
}


/*
 * Returns the value of the "qualitativeSpecies" attribute of this Output.
 */
const std::string&
Output::getQualitativeSpecies() const
{
  return mQualitativeSpecies;
}


/*
 * Returns the value of the "transitionEffect" attribute of this Output.
 */
TransitionOutputEffect_t
Output::getTransitionEffect() const
{
  return mTransitionEffect;
}


/*
 * Returns the value of the "transitionEffect" attribute of this Output.
 */
std::string
Output::getTransitionEffectAsString() const
{
  std::string code_str = TransitionOutputEffect_toString(mTransitionEffect);
  return code_str;
}


/*
 * Returns the value of the "name" attribute of this Output.
 */
const std::string&
Output::getName() const
{
  return mName;
}


/*
 * Returns the value of the "outputLevel" attribute of this Output.
 */
int
Output::getOutputLevel() const
{
  return mOutputLevel;
}


/*
 * Predicate returning @c true if this Output's "id" attribute is set.
 */
bool
Output::isSetId() const
{
  return (mId.empty() == false);
}


/*
 * Predicate returning @c true if this Output's "qualitativeSpecies" attribute
 * is set.
 */
bool
Output::isSetQualitativeSpecies() const
{
  return (mQualitativeSpecies.empty() == false);
}


/*
 * Predicate returning @c true if this Output's "transitionEffect" attribute is
 * set.
 */
bool
Output::isSetTransitionEffect() const
{
  return (mTransitionEffect != TRANSITION_OUTPUT_EFFECT_INVALID);
}


/*
 * Predicate returning @c true if this Output's "name" attribute is set.
 */
bool
Output::isSetName() const
{
  return (mName.empty() == false);
}


/*
 * Predicate returning @c true if this Output's "outputLevel" attribute is set.
 */
bool
Output::isSetOutputLevel() const
{
  return mIsSetOutputLevel;
}


/*
 * Sets the value of the "id" attribute of this Output.
 */
int
Output::setId(const std::string& id)
{
  return SyntaxChecker::checkAndSetSId(id, mId);
}


/*
 * Sets the value of the "qualitativeSpecies" attribute of this Output.
 */
int
Output::setQualitativeSpecies(const std::string& qualitativeSpecies)
{
  if (!(SyntaxChecker::isValidInternalSId(qualitativeSpecies)))
  {
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mQualitativeSpecies = qualitativeSpecies;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "transitionEffect" attribute of this Output.
 */
int
Output::setTransitionEffect(const TransitionOutputEffect_t transitionEffect)
{
  if (TransitionOutputEffect_isValid(transitionEffect) == 0)
  {
    mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mTransitionEffect = transitionEffect;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "transitionEffect" attribute of this Output.
 */
int
Output::setTransitionEffect(const std::string& transitionEffect)
{
  mTransitionEffect =
    TransitionOutputEffect_fromString(transitionEffect.c_str());

  if (mTransitionEffect == TRANSITION_OUTPUT_EFFECT_INVALID)
  {
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }

  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "name" attribute of this Output.
 */
int
Output::setName(const std::string& name)
{
  mName = name;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "outputLevel" attribute of this Output.
 */
int
Output::setOutputLevel(int outputLevel)
{
  mOutputLevel = outputLevel;
  mIsSetOutputLevel = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "id" attribute of this Output.
 */
int
Output::unsetId()
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
 * Unsets the value of the "qualitativeSpecies" attribute of this Output.
 */
int
Output::unsetQualitativeSpecies()
{
  mQualitativeSpecies.erase();

  if (mQualitativeSpecies.empty() == true)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "transitionEffect" attribute of this Output.
 */
int
Output::unsetTransitionEffect()
{
  mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "name" attribute of this Output.
 */
int
Output::unsetName()
{
  mName.erase();

  if (mName.empty() == true)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "outputLevel" attribute of this Output.
 */
int
Output::unsetOutputLevel()
{
  mOutputLevel = SBML_INT_MAX;
  mIsSetOutputLevel = false;

  if (isSetOutputLevel() == false)
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
Output::renameSIdRefs(const std::string& oldid, const std::string& newid)
{
  if (isSetQualitativeSpecies() && mQualitativeSpecies == oldid)
  {
    setQualitativeSpecies(newid);
  }
}


/*
 * Returns the XML element name of this Output object.
 */
const std::string&
Output::getElementName() const
{
  static const string name = "output";
  return name;
}


/*
 * Returns the libSBML type code for this Output object.
 */
int
Output::getTypeCode() const
{
  return SBML_QUAL_OUTPUT;
}


/*
 * Predicate returning @c true if all the required attributes for this Output
 * object have been set.
 */
bool
Output::hasRequiredAttributes() const
{
  bool allPresent = true;

  if (isSetQualitativeSpecies() == false)
  {
    allPresent = false;
  }

  if (isSetTransitionEffect() == false)
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
Output::writeElements(XMLOutputStream& stream) const
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
Output::accept(SBMLVisitor& v) const
{
  return v.visit(*this);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the parent SBMLDocument
 */
void
Output::setSBMLDocument(SBMLDocument* d)
{
  SBase::setSBMLDocument(d);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Enables/disables the given package with this element
 */
void
Output::enablePackageInternal(const std::string& pkgURI,
                              const std::string& pkgPrefix,
                              bool flag)
{
  SBase::enablePackageInternal(pkgURI, pkgPrefix, flag);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Output.
 */
int
Output::getAttribute(const std::string& attributeName, bool& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Output.
 */
int
Output::getAttribute(const std::string& attributeName, int& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  if (return_value == LIBSBML_OPERATION_SUCCESS)
  {
    return return_value;
  }

  if (attributeName == "outputLevel")
  {
    value = getOutputLevel();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Output.
 */
int
Output::getAttribute(const std::string& attributeName, double& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Output.
 */
int
Output::getAttribute(const std::string& attributeName,
                     unsigned int& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Output.
 */
int
Output::getAttribute(const std::string& attributeName,
                     std::string& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  if (return_value == LIBSBML_OPERATION_SUCCESS)
  {
    return return_value;
  }

  if (attributeName == "id")
  {
    value = getId();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }
  else if (attributeName == "qualitativeSpecies")
  {
    value = getQualitativeSpecies();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }
  else if (attributeName == "transitionEffect")
  {
    value = getTransitionEffectAsString();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }
  else if (attributeName == "name")
  {
    value = getName();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Predicate returning @c true if this Output's attribute "attributeName" is
 * set.
 */
bool
Output::isSetAttribute(const std::string& attributeName) const
{
  bool value = SBase::isSetAttribute(attributeName);

  if (attributeName == "id")
  {
    value = isSetId();
  }
  else if (attributeName == "qualitativeSpecies")
  {
    value = isSetQualitativeSpecies();
  }
  else if (attributeName == "transitionEffect")
  {
    value = isSetTransitionEffect();
  }
  else if (attributeName == "name")
  {
    value = isSetName();
  }
  else if (attributeName == "outputLevel")
  {
    value = isSetOutputLevel();
  }

  return value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Output.
 */
int
Output::setAttribute(const std::string& attributeName, bool value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Output.
 */
int
Output::setAttribute(const std::string& attributeName, int value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  if (attributeName == "outputLevel")
  {
    return_value = setOutputLevel(value);
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Output.
 */
int
Output::setAttribute(const std::string& attributeName, double value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Output.
 */
int
Output::setAttribute(const std::string& attributeName, unsigned int value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Output.
 */
int
Output::setAttribute(const std::string& attributeName,
                     const std::string& value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  if (attributeName == "id")
  {
    return_value = setId(value);
  }
  else if (attributeName == "qualitativeSpecies")
  {
    return_value = setQualitativeSpecies(value);
  }
  else if (attributeName == "transitionEffect")
  {
    return_value = setTransitionEffect(value);
  }
  else if (attributeName == "name")
  {
    return_value = setName(value);
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Unsets the value of the "attributeName" attribute of this Output.
 */
int
Output::unsetAttribute(const std::string& attributeName)
{
  int value = SBase::unsetAttribute(attributeName);

  if (attributeName == "id")
  {
    value = unsetId();
  }
  else if (attributeName == "qualitativeSpecies")
  {
    value = unsetQualitativeSpecies();
  }
  else if (attributeName == "transitionEffect")
  {
    value = unsetTransitionEffect();
  }
  else if (attributeName == "name")
  {
    value = unsetName();
  }
  else if (attributeName == "outputLevel")
  {
    value = unsetOutputLevel();
  }

  return value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Adds the expected attributes for this element
 */
void
Output::addExpectedAttributes(ExpectedAttributes& attributes)
{
  SBase::addExpectedAttributes(attributes);

  attributes.add("id");

  attributes.add("qualitativeSpecies");

  attributes.add("transitionEffect");

  attributes.add("name");

  attributes.add("outputLevel");
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Reads the expected attributes into the member data variables
 */
void
Output::readAttributes(const XMLAttributes& attributes,
                       const ExpectedAttributes& expectedAttributes)
{
  unsigned int level = getLevel();
  unsigned int version = getVersion();
  unsigned int pkgVersion = getPackageVersion();
  unsigned int numErrs;
  bool assigned = false;
  SBMLErrorLog* log = getErrorLog();

  if (log && getParentSBMLObject() &&
    static_cast<ListOfOutputs*>(getParentSBMLObject())->size() < 2)
  {
    numErrs = log->getNumErrors();
    for (int n = numErrs-1; n >= 0; n--)
    {
      if (log->getError(n)->getErrorId() == UnknownPackageAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownPackageAttribute);
        log->logPackageError("qual", QualTransitionLOOutputsAllowedAttributes,
          pkgVersion, level, version, details);
      }
      else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownCoreAttribute);
        log->logPackageError("qual",
          QualTransitionLOOutputsAllowedCoreAttributes, pkgVersion, level,
            version, details);
      }
    }
  }

  SBase::readAttributes(attributes, expectedAttributes);

  if (log)
  {
    numErrs = log->getNumErrors();

    for (int n = numErrs-1; n >= 0; n--)
    {
      if (log->getError(n)->getErrorId() == UnknownPackageAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownPackageAttribute);
        log->logPackageError("qual", QualOutputAllowedAttributes, pkgVersion,
          level, version, details);
      }
      else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownCoreAttribute);
        log->logPackageError("qual", QualOutputAllowedCoreAttributes,
          pkgVersion, level, version, details);
      }
    }
  }

  // 
  // id SId (use = "optional" )
  // 

  assigned = attributes.readInto("id", mId);

  if (assigned == true)
  {
    if (mId.empty() == true)
    {
      logEmptyString(mId, level, version, "<Output>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mId) == false)
    {
      log->logPackageError("qual", QualIdSyntaxRule, pkgVersion, level,
        version, "The id on the <" + getElementName() + "> is '" + mId + "', "
          "which does not conform to the syntax.", getLine(), getColumn());
    }
  }

  // 
  // qualitativeSpecies SIdRef (use = "required" )
  // 

  assigned = attributes.readInto("qualitativeSpecies", mQualitativeSpecies);

  if (assigned == true)
  {
    if (mQualitativeSpecies.empty() == true)
    {
      logEmptyString(mQualitativeSpecies, level, version, "<Output>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mQualitativeSpecies) == false)
    {
      std::string msg = "The qualitativeSpecies attribute on the <" +
        getElementName() + ">";
      if (isSetId())
      {
        msg += " with id '" + getId() + "'";
      }

      msg += " is '" + mQualitativeSpecies + "', which does not conform to the "
        "syntax.";
      log->logPackageError("qual",
        QualOutputQualitativeSpeciesMustBeQualitativeSpecies, pkgVersion, level,
          version, msg, getLine(), getColumn());
    }
  }
  else
  {
    std::string message = "Qual attribute 'qualitativeSpecies' is missing from "
      "the <Output> element.";
    log->logPackageError("qual", QualOutputAllowedAttributes, pkgVersion,
      level, version, message);
  }

  // 
  // transitionEffect enum (use = "required" )
  // 

  std::string transitionEffect;
  assigned = attributes.readInto("transitionEffect", transitionEffect);

  if (assigned == true)
  {
    if (transitionEffect.empty() == true)
    {
      logEmptyString(transitionEffect, level, version, "<Output>");
    }
    else
    {
      mTransitionEffect =
        TransitionOutputEffect_fromString(transitionEffect.c_str());

      if (TransitionOutputEffect_isValid(mTransitionEffect) == 0)
      {
        std::string msg = "The transitionEffect on the <Output> ";

        if (isSetId())
        {
          msg += "with id '" + getId() + "'";
        }

        msg += "is '" + transitionEffect + "', which is not a valid option.";

        log->logPackageError("qual",
          QualOutputTransitionEffectMustBeTransitionOutputEffectEnum, pkgVersion,
            level, version, msg);
      }
    }
  }
  else
  {
    std::string message = "Qual attribute 'transitionEffect' is missing.";
    log->logPackageError("qual", QualOutputAllowedAttributes, pkgVersion,
      level, version, message);
  }

  // 
  // name string (use = "optional" )
  // 

  assigned = attributes.readInto("name", mName);

  if (assigned == true)
  {
    if (mName.empty() == true)
    {
      logEmptyString(mName, level, version, "<Output>");
    }
  }

  // 
  // outputLevel int (use = "optional" )
  // 

  numErrs = log->getNumErrors();
  mIsSetOutputLevel = attributes.readInto("outputLevel", mOutputLevel);

  if ( mIsSetOutputLevel == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      std::string message = "Qual attribute 'outputLevel' from the <Output> "
        "element must be an integer.";
      log->logPackageError("qual", QualOutputOutputLevelMustBeInteger,
        pkgVersion, level, version, message);
    }
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Writes the attributes to the stream
 */
void
Output::writeAttributes(XMLOutputStream& stream) const
{
  SBase::writeAttributes(stream);

  if (isSetId() == true)
  {
    stream.writeAttribute("id", getPrefix(), mId);
  }

  if (isSetQualitativeSpecies() == true)
  {
    stream.writeAttribute("qualitativeSpecies", getPrefix(),
      mQualitativeSpecies);
  }

  if (isSetTransitionEffect() == true)
  {
    stream.writeAttribute("transitionEffect", getPrefix(),
      TransitionOutputEffect_toString(mTransitionEffect));
  }

  if (isSetName() == true)
  {
    stream.writeAttribute("name", getPrefix(), mName);
  }

  if (isSetOutputLevel() == true)
  {
    stream.writeAttribute("outputLevel", getPrefix(), mOutputLevel);
  }

  SBase::writeExtensionAttributes(stream);
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Creates a new Output_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
LIBSBML_EXTERN
Output_t *
Output_create(unsigned int level,
              unsigned int version,
              unsigned int pkgVersion)
{
  return new Output(level, version, pkgVersion);
}


/*
 * Creates and returns a deep copy of this Output_t object.
 */
LIBSBML_EXTERN
Output_t*
Output_clone(const Output_t* o)
{
  if (o != NULL)
  {
    return static_cast<Output_t*>(o->clone());
  }
  else
  {
    return NULL;
  }
}


/*
 * Frees this Output_t object.
 */
LIBSBML_EXTERN
void
Output_free(Output_t* o)
{
  if (o != NULL)
  {
    delete o;
  }
}


/*
 * Returns the value of the "id" attribute of this Output_t.
 */
LIBSBML_EXTERN
char *
Output_getId(const Output_t * o)
{
  if (o == NULL)
  {
    return NULL;
  }

  return o->getId().empty() ? NULL : safe_strdup(o->getId().c_str());
}


/*
 * Returns the value of the "qualitativeSpecies" attribute of this Output_t.
 */
LIBSBML_EXTERN
char *
Output_getQualitativeSpecies(const Output_t * o)
{
  if (o == NULL)
  {
    return NULL;
  }

  return o->getQualitativeSpecies().empty() ? NULL :
    safe_strdup(o->getQualitativeSpecies().c_str());
}


/*
 * Returns the value of the "transitionEffect" attribute of this Output_t.
 */
LIBSBML_EXTERN
TransitionOutputEffect_t
Output_getTransitionEffect(const Output_t * o)
{
  if (o == NULL)
  {
    return TRANSITION_OUTPUT_EFFECT_INVALID;
  }

  return o->getTransitionEffect();
}


/*
 * Returns the value of the "transitionEffect" attribute of this Output_t.
 */
LIBSBML_EXTERN
char *
Output_getTransitionEffectAsString(const Output_t * o)
{
  return (char*)(TransitionOutputEffect_toString(o->getTransitionEffect()));
}


/*
 * Returns the value of the "name" attribute of this Output_t.
 */
LIBSBML_EXTERN
char *
Output_getName(const Output_t * o)
{
  if (o == NULL)
  {
    return NULL;
  }

  return o->getName().empty() ? NULL : safe_strdup(o->getName().c_str());
}


/*
 * Returns the value of the "outputLevel" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_getOutputLevel(const Output_t * o)
{
  return (o != NULL) ? o->getOutputLevel() : SBML_INT_MAX;
}


/*
 * Predicate returning @c 1 (true) if this Output_t's "id" attribute is set.
 */
LIBSBML_EXTERN
int
Output_isSetId(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetId()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Output_t's "qualitativeSpecies"
 * attribute is set.
 */
LIBSBML_EXTERN
int
Output_isSetQualitativeSpecies(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetQualitativeSpecies()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Output_t's "transitionEffect"
 * attribute is set.
 */
LIBSBML_EXTERN
int
Output_isSetTransitionEffect(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetTransitionEffect()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Output_t's "name" attribute is set.
 */
LIBSBML_EXTERN
int
Output_isSetName(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetName()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Output_t's "outputLevel" attribute
 * is set.
 */
LIBSBML_EXTERN
int
Output_isSetOutputLevel(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetOutputLevel()) : 0;
}


/*
 * Sets the value of the "id" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_setId(Output_t * o, const char * id)
{
  return (o != NULL) ? o->setId(id) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "qualitativeSpecies" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_setQualitativeSpecies(Output_t * o, const char * qualitativeSpecies)
{
  return (o != NULL) ? o->setQualitativeSpecies(qualitativeSpecies) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "transitionEffect" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_setTransitionEffect(Output_t * o,
                           TransitionOutputEffect_t transitionEffect)
{
  return (o != NULL) ? o->setTransitionEffect(transitionEffect) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "transitionEffect" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_setTransitionEffectAsString(Output_t * o,
                                   const char * transitionEffect)
{
  return (o != NULL) ? o->setTransitionEffect(transitionEffect):
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "name" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_setName(Output_t * o, const char * name)
{
  return (o != NULL) ? o->setName(name) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "outputLevel" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_setOutputLevel(Output_t * o, int outputLevel)
{
  return (o != NULL) ? o->setOutputLevel(outputLevel) : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "id" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_unsetId(Output_t * o)
{
  return (o != NULL) ? o->unsetId() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "qualitativeSpecies" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_unsetQualitativeSpecies(Output_t * o)
{
  return (o != NULL) ? o->unsetQualitativeSpecies() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "transitionEffect" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_unsetTransitionEffect(Output_t * o)
{
  return (o != NULL) ? o->unsetTransitionEffect() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "name" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_unsetName(Output_t * o)
{
  return (o != NULL) ? o->unsetName() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "outputLevel" attribute of this Output_t.
 */
LIBSBML_EXTERN
int
Output_unsetOutputLevel(Output_t * o)
{
  return (o != NULL) ? o->unsetOutputLevel() : LIBSBML_INVALID_OBJECT;
}


/*
 * Predicate returning @c 1 (true) if all the required attributes for this
 * Output_t object have been set.
 */
LIBSBML_EXTERN
int
Output_hasRequiredAttributes(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->hasRequiredAttributes()) : 0;
}




LIBSBML_CPP_NAMESPACE_END


