/**
 * @file Input.cpp
 * @brief Implementation of the Input class.
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
#include <sbml/packages/qual/sbml/Input.h>
#include <sbml/packages/qual/sbml/ListOfInputs.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new Input using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
Input::Input(unsigned int level,
             unsigned int version,
             unsigned int pkgVersion)
  : SBase(level, version)
  , mId ("")
  , mName ("")
  , mSign (SIGN_INVALID)
  , mQualitativeSpecies ("")
  , mTransitionEffect (TRANSITION_INPUT_EFFECT_INVALID)
  , mThresholdLevel (SBML_INT_MAX)
  , mIsSetThresholdLevel (false)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new Input using the given QualPkgNamespaces object.
 */
Input::Input(QualPkgNamespaces *qualns)
  : SBase(qualns)
  , mId ("")
  , mName ("")
  , mSign (SIGN_INVALID)
  , mQualitativeSpecies ("")
  , mTransitionEffect (TRANSITION_INPUT_EFFECT_INVALID)
  , mThresholdLevel (SBML_INT_MAX)
  , mIsSetThresholdLevel (false)
{
  setElementNamespace(qualns->getURI());
  loadPlugins(qualns);
}


/*
 * Copy constructor for Input.
 */
Input::Input(const Input& orig)
  : SBase( orig )
  , mId ( orig.mId )
  , mName ( orig.mName )
  , mSign ( orig.mSign )
  , mQualitativeSpecies ( orig.mQualitativeSpecies )
  , mTransitionEffect ( orig.mTransitionEffect )
  , mThresholdLevel ( orig.mThresholdLevel )
  , mIsSetThresholdLevel ( orig.mIsSetThresholdLevel )
{
}


/*
 * Assignment operator for Input.
 */
Input&
Input::operator=(const Input& rhs)
{
  if (&rhs != this)
  {
    SBase::operator=(rhs);
    mId = rhs.mId;
    mName = rhs.mName;
    mSign = rhs.mSign;
    mQualitativeSpecies = rhs.mQualitativeSpecies;
    mTransitionEffect = rhs.mTransitionEffect;
    mThresholdLevel = rhs.mThresholdLevel;
    mIsSetThresholdLevel = rhs.mIsSetThresholdLevel;
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this Input object.
 */
Input*
Input::clone() const
{
  return new Input(*this);
}


/*
 * Destructor for Input.
 */
Input::~Input()
{
}


/*
 * Returns the value of the "id" attribute of this Input.
 */
const std::string&
Input::getId() const
{
  return mId;
}


/*
 * Returns the value of the "name" attribute of this Input.
 */
const std::string&
Input::getName() const
{
  return mName;
}


/*
 * Returns the value of the "sign" attribute of this Input.
 */
Sign_t
Input::getSign() const
{
  return mSign;
}


/*
 * Returns the value of the "sign" attribute of this Input.
 */
const std::string&
Input::getSignAsString() const
{
  static const std::string code_str = Sign_toString(mSign);
  return code_str;
}


/*
 * Returns the value of the "qualitativeSpecies" attribute of this Input.
 */
const std::string&
Input::getQualitativeSpecies() const
{
  return mQualitativeSpecies;
}


/*
 * Returns the value of the "transitionEffect" attribute of this Input.
 */
TransitionInputEffect_t
Input::getTransitionEffect() const
{
  return mTransitionEffect;
}


/*
 * Returns the value of the "transitionEffect" attribute of this Input.
 */
const std::string&
Input::getTransitionEffectAsString() const
{
  static const std::string code_str =
    TransitionInputEffect_toString(mTransitionEffect);
  return code_str;
}


/*
 * Returns the value of the "thresholdLevel" attribute of this Input.
 */
unsigned int
Input::getThresholdLevel() const
{
  return mThresholdLevel;
}


/*
 * Predicate returning @c true if this Input's "id" attribute is set.
 */
bool
Input::isSetId() const
{
  return (mId.empty() == false);
}


/*
 * Predicate returning @c true if this Input's "name" attribute is set.
 */
bool
Input::isSetName() const
{
  return (mName.empty() == false);
}


/*
 * Predicate returning @c true if this Input's "sign" attribute is set.
 */
bool
Input::isSetSign() const
{
  return (mSign != SIGN_INVALID);
}


/*
 * Predicate returning @c true if this Input's "qualitativeSpecies" attribute
 * is set.
 */
bool
Input::isSetQualitativeSpecies() const
{
  return (mQualitativeSpecies.empty() == false);
}


/*
 * Predicate returning @c true if this Input's "transitionEffect" attribute is
 * set.
 */
bool
Input::isSetTransitionEffect() const
{
  return (mTransitionEffect != TRANSITION_INPUT_EFFECT_INVALID);
}


/*
 * Predicate returning @c true if this Input's "thresholdLevel" attribute is
 * set.
 */
bool
Input::isSetThresholdLevel() const
{
  return mIsSetThresholdLevel;
}


/*
 * Sets the value of the "id" attribute of this Input.
 */
int
Input::setId(const std::string& id)
{
  return SyntaxChecker::checkAndSetSId(id, mId);
}


/*
 * Sets the value of the "name" attribute of this Input.
 */
int
Input::setName(const std::string& name)
{
  mName = name;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "sign" attribute of this Input.
 */
int
Input::setSign(const Sign_t sign)
{
  if (Sign_isValid(sign) == 0)
  {
    mSign = SIGN_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mSign = sign;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "sign" attribute of this Input.
 */
int
Input::setSign(const std::string& sign)
{
  if (Sign_isValidString(sign.c_str()) == 0)
  {
    mSign = SIGN_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mSign = Sign_fromString(sign.c_str());
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "qualitativeSpecies" attribute of this Input.
 */
int
Input::setQualitativeSpecies(const std::string& qualitativeSpecies)
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
 * Sets the value of the "transitionEffect" attribute of this Input.
 */
int
Input::setTransitionEffect(const TransitionInputEffect_t transitionEffect)
{
  if (TransitionInputEffect_isValid(transitionEffect) == 0)
  {
    mTransitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mTransitionEffect = transitionEffect;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "transitionEffect" attribute of this Input.
 */
int
Input::setTransitionEffect(const std::string& transitionEffect)
{
  if (TransitionInputEffect_isValidString(transitionEffect.c_str()) == 0)
  {
    mTransitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mTransitionEffect =
      TransitionInputEffect_fromString(transitionEffect.c_str());
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "thresholdLevel" attribute of this Input.
 */
int
Input::setThresholdLevel(unsigned int thresholdLevel)
{
  mThresholdLevel = thresholdLevel;
  mIsSetThresholdLevel = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "id" attribute of this Input.
 */
int
Input::unsetId()
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
 * Unsets the value of the "name" attribute of this Input.
 */
int
Input::unsetName()
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
 * Unsets the value of the "sign" attribute of this Input.
 */
int
Input::unsetSign()
{
  mSign = SIGN_INVALID;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "qualitativeSpecies" attribute of this Input.
 */
int
Input::unsetQualitativeSpecies()
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
 * Unsets the value of the "transitionEffect" attribute of this Input.
 */
int
Input::unsetTransitionEffect()
{
  mTransitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "thresholdLevel" attribute of this Input.
 */
int
Input::unsetThresholdLevel()
{
  mThresholdLevel = SBML_INT_MAX;
  mIsSetThresholdLevel = false;

  if (isSetThresholdLevel() == false)
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
Input::renameSIdRefs(const std::string& oldid, const std::string& newid)
{
  if (isSetQualitativeSpecies() && mQualitativeSpecies == oldid)
  {
    setQualitativeSpecies(newid);
  }
}


/*
 * Returns the XML element name of this Input object.
 */
const std::string&
Input::getElementName() const
{
  static const string name = "input";
  return name;
}


/*
 * Returns the libSBML type code for this Input object.
 */
int
Input::getTypeCode() const
{
  return SBML_QUAL_INPUT;
}


/*
 * Predicate returning @c true if all the required attributes for this Input
 * object have been set.
 */
bool
Input::hasRequiredAttributes() const
{
  bool allPresent = true;

  if (isSetQualitativeSpecies() == false)
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
Input::writeElements(XMLOutputStream& stream) const
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
Input::accept(SBMLVisitor& v) const
{
  return v.visit(*this);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the parent SBMLDocument
 */
void
Input::setSBMLDocument(SBMLDocument* d)
{
  SBase::setSBMLDocument(d);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Enables/disables the given package with this element
 */
void
Input::enablePackageInternal(const std::string& pkgURI,
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
Input::addExpectedAttributes(ExpectedAttributes& attributes)
{
  SBase::addExpectedAttributes(attributes);

  attributes.add("id");

  attributes.add("name");

  attributes.add("sign");

  attributes.add("qualitativeSpecies");

  attributes.add("transitionEffect");

  attributes.add("thresholdLevel");
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Reads the expected attributes into the member data variables
 */
void
Input::readAttributes(const XMLAttributes& attributes,
                      const ExpectedAttributes& expectedAttributes)
{
  unsigned int level = getLevel();
  unsigned int version = getVersion();
  unsigned int pkgVersion = getPackageVersion();
  unsigned int numErrs;
  bool assigned = false;
  SBMLErrorLog* log = getErrorLog();

  if (static_cast<ListOfInputs*>(getParentSBMLObject())->size() < 2)
  {
    numErrs = log->getNumErrors();
    for (int n = numErrs-1; n >= 0; n--)
    {
      if (log->getError(n)->getErrorId() == UnknownPackageAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownPackageAttribute);
        log->logPackageError("qual", QualInputAllowedAttributes, pkgVersion,
          level, version, details);
      }
      else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownCoreAttribute);
        log->logPackageError("qual",
          QualTransitionLOInputsAllowedCoreAttributes, pkgVersion, level,
            version, details);
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
      log->logPackageError("qual", QualInputAllowedAttributes, pkgVersion,
        level, version, details);
    }
    else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
    {
      const std::string details = log->getError(n)->getMessage();
      log->remove(UnknownCoreAttribute);
      log->logPackageError("qual", QualInputAllowedCoreAttributes, pkgVersion,
        level, version, details);
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
      logEmptyString(mId, level, version, "<Input>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mId) == false)
    {
      logError(QualIdSyntaxRule, level, version, "The id '" + mId + "' does not "
        "conform to the syntax.");
    }
  }

  // 
  // name string (use = "optional" )
  // 

  assigned = attributes.readInto("name", mName);

  if (assigned == true)
  {
    if (mName.empty() == true)
    {
      logEmptyString(mName, level, version, "<Input>");
    }
  }

  // 
  // sign enum (use = "optional" )
  // 

  std::string sign;
  assigned = attributes.readInto("sign", sign);

  if (assigned == true)
  {
    if (sign.empty() == true)
    {
      logEmptyString(sign, level, version, "<Input>");
    }
    else
    {
      mSign = Sign_fromString(sign.c_str());

      if (Sign_isValid(mSign) == 0)
      {
        std::string msg = "The sign on the <Input> ";

        if (isSetId())
        {
          msg += "with id '" + getId() + "'";
        }

        msg += "is '" + sign + "', which is not a valid option.";

        log->logPackageError("qual", QualInputSignMustBeSignEnum, pkgVersion,
          level, version, msg);
      }
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
      logEmptyString(mQualitativeSpecies, level, version, "<Input>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mQualitativeSpecies) == false)
    {
      logError(QualInputQualitativeSpeciesMustBeQualitativeSpecies, level,
        version, "The attribute qualitativeSpecies='" + mQualitativeSpecies + "' "
          "does not conform to the syntax.");
    }
  }
  else
  {
    std::string message = "Qual attribute 'qualitativeSpecies' is missing from "
      "the <Input> element.";
    log->logPackageError("qual", QualInputAllowedAttributes, pkgVersion, level,
      version, message);
  }

  // 
  // transitionEffect enum (use = "optional" )
  // 

  std::string transitioneffect;
  assigned = attributes.readInto("transitionEffect", transitioneffect);

  if (assigned == true)
  {
    if (transitioneffect.empty() == true)
    {
      logEmptyString(transitioneffect, level, version, "<Input>");
    }
    else
    {
      mTransitionEffect =
        TransitionInputEffect_fromString(transitioneffect.c_str());

      if (TransitionInputEffect_isValid(mTransitionEffect) == 0)
      {
        std::string msg = "The transitionEffect on the <Input> ";

        if (isSetId())
        {
          msg += "with id '" + getId() + "'";
        }

        msg += "is '" + transitioneffect + "', which is not a valid option.";

        log->logPackageError("qual",
          QualInputTransitionEffectMustBeTransitionInputEffectEnum, pkgVersion,
            level, version, msg);
      }
    }
  }

  // 
  // thresholdLevel uint (use = "optional" )
  // 

  numErrs = log->getNumErrors();
  mIsSetThresholdLevel = attributes.readInto("thresholdLevel",
    mThresholdLevel);

  if ( mIsSetThresholdLevel == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      std::string message = "Qual attribute 'thresholdLevel' from the <Input> "
        "element must be an integer.";
      log->logPackageError("qual", QualInputThresholdLevelMustBeUnInteger,
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
Input::writeAttributes(XMLOutputStream& stream) const
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

  if (isSetSign() == true)
  {
    stream.writeAttribute("sign", getPrefix(), Sign_toString(mSign));
  }

  if (isSetQualitativeSpecies() == true)
  {
    stream.writeAttribute("qualitativeSpecies", getPrefix(),
      mQualitativeSpecies);
  }

  if (isSetTransitionEffect() == true)
  {
    stream.writeAttribute("transitionEffect", getPrefix(),
      TransitionInputEffect_toString(mTransitionEffect));
  }

  if (isSetThresholdLevel() == true)
  {
    stream.writeAttribute("thresholdLevel", getPrefix(), mThresholdLevel);
  }

  SBase::writeExtensionAttributes(stream);
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Creates a new Input_t using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
LIBSBML_EXTERN
Input_t *
Input_create(unsigned int level,
             unsigned int version,
             unsigned int pkgVersion)
{
  return new Input(level, version, pkgVersion);
}


/*
 * Creates and returns a deep copy of this Input_t object.
 */
LIBSBML_EXTERN
Input_t*
Input_clone(const Input_t* i)
{
  if (i != NULL)
  {
    return static_cast<Input_t*>(i->clone());
  }
  else
  {
    return NULL;
  }
}


/*
 * Frees this Input_t object.
 */
LIBSBML_EXTERN
void
Input_free(Input_t* i)
{
  if (i != NULL)
  {
    delete i;
  }
}


/*
 * Returns the value of the "id" attribute of this Input_t.
 */
LIBSBML_EXTERN
const char *
Input_getId(const Input_t * i)
{
  if (i == NULL)
  {
    return NULL;
  }

  return i->getId().empty() ? NULL : safe_strdup(i->getId().c_str());
}


/*
 * Returns the value of the "name" attribute of this Input_t.
 */
LIBSBML_EXTERN
const char *
Input_getName(const Input_t * i)
{
  if (i == NULL)
  {
    return NULL;
  }

  return i->getName().empty() ? NULL : safe_strdup(i->getName().c_str());
}


/*
 * Returns the value of the "sign" attribute of this Input_t.
 */
LIBSBML_EXTERN
Sign_t
Input_getSign(const Input_t * i)
{
  if (i == NULL)
  {
    return SIGN_INVALID;
  }

  return i->getSign();
}


/*
 * Returns the value of the "sign" attribute of this Input_t.
 */
LIBSBML_EXTERN
const char *
Input_getSignAsString(const Input_t * i)
{
  return Sign_toString(i->getSign());
}


/*
 * Returns the value of the "qualitativeSpecies" attribute of this Input_t.
 */
LIBSBML_EXTERN
const char *
Input_getQualitativeSpecies(const Input_t * i)
{
  if (i == NULL)
  {
    return NULL;
  }

  return i->getQualitativeSpecies().empty() ? NULL :
    safe_strdup(i->getQualitativeSpecies().c_str());
}


/*
 * Returns the value of the "transitionEffect" attribute of this Input_t.
 */
LIBSBML_EXTERN
TransitionInputEffect_t
Input_getTransitionEffect(const Input_t * i)
{
  if (i == NULL)
  {
    return TRANSITION_INPUT_EFFECT_INVALID;
  }

  return i->getTransitionEffect();
}


/*
 * Returns the value of the "transitionEffect" attribute of this Input_t.
 */
LIBSBML_EXTERN
const char *
Input_getTransitionEffectAsString(const Input_t * i)
{
  return TransitionInputEffect_toString(i->getTransitionEffect());
}


/*
 * Returns the value of the "thresholdLevel" attribute of this Input_t.
 */
LIBSBML_EXTERN
unsigned int
Input_getThresholdLevel(const Input_t * i)
{
  return (i != NULL) ? i->getThresholdLevel() : SBML_INT_MAX;
}


/*
 * Predicate returning @c 1 if this Input_t's "id" attribute is set.
 */
LIBSBML_EXTERN
int
Input_isSetId(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->isSetId()) : 0;
}


/*
 * Predicate returning @c 1 if this Input_t's "name" attribute is set.
 */
LIBSBML_EXTERN
int
Input_isSetName(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->isSetName()) : 0;
}


/*
 * Predicate returning @c 1 if this Input_t's "sign" attribute is set.
 */
LIBSBML_EXTERN
int
Input_isSetSign(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->isSetSign()) : 0;
}


/*
 * Predicate returning @c 1 if this Input_t's "qualitativeSpecies" attribute is
 * set.
 */
LIBSBML_EXTERN
int
Input_isSetQualitativeSpecies(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->isSetQualitativeSpecies()) : 0;
}


/*
 * Predicate returning @c 1 if this Input_t's "transitionEffect" attribute is
 * set.
 */
LIBSBML_EXTERN
int
Input_isSetTransitionEffect(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->isSetTransitionEffect()) : 0;
}


/*
 * Predicate returning @c 1 if this Input_t's "thresholdLevel" attribute is
 * set.
 */
LIBSBML_EXTERN
int
Input_isSetThresholdLevel(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->isSetThresholdLevel()) : 0;
}


/*
 * Sets the value of the "id" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setId(Input_t * i, const char * id)
{
  return (i != NULL) ? i->setId(id) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "name" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setName(Input_t * i, const char * name)
{
  return (i != NULL) ? i->setName(name) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "sign" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setSign(Input_t * i, Sign_t sign)
{
  return (i != NULL) ? i->setSign(sign) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "sign" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setSignAsString(Input_t * i, const char * sign)
{
  return (i != NULL) ? i->setSign(sign): LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "qualitativeSpecies" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setQualitativeSpecies(Input_t * i, const char * qualitativeSpecies)
{
  return (i != NULL) ? i->setQualitativeSpecies(qualitativeSpecies) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "transitionEffect" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setTransitionEffect(Input_t * i,
                          TransitionInputEffect_t transitionEffect)
{
  return (i != NULL) ? i->setTransitionEffect(transitionEffect) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "transitionEffect" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setTransitionEffectAsString(Input_t * i, const char * transitionEffect)
{
  return (i != NULL) ? i->setTransitionEffect(transitionEffect):
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "thresholdLevel" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_setThresholdLevel(Input_t * i, unsigned int thresholdLevel)
{
  return (i != NULL) ? i->setThresholdLevel(thresholdLevel) :
    LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "id" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_unsetId(Input_t * i)
{
  return (i != NULL) ? i->unsetId() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "name" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_unsetName(Input_t * i)
{
  return (i != NULL) ? i->unsetName() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "sign" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_unsetSign(Input_t * i)
{
  return (i != NULL) ? i->unsetSign() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "qualitativeSpecies" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_unsetQualitativeSpecies(Input_t * i)
{
  return (i != NULL) ? i->unsetQualitativeSpecies() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "transitionEffect" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_unsetTransitionEffect(Input_t * i)
{
  return (i != NULL) ? i->unsetTransitionEffect() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "thresholdLevel" attribute of this Input_t.
 */
LIBSBML_EXTERN
int
Input_unsetThresholdLevel(Input_t * i)
{
  return (i != NULL) ? i->unsetThresholdLevel() : LIBSBML_INVALID_OBJECT;
}


/*
 * Predicate returning @c 1 if all the required attributes for this Input_t
 * object have been set.
 */
LIBSBML_EXTERN
int
Input_hasRequiredAttributes(const Input_t * i)
{
  return (i != NULL) ? static_cast<int>(i->hasRequiredAttributes()) : 0;
}




LIBSBML_CPP_NAMESPACE_END


