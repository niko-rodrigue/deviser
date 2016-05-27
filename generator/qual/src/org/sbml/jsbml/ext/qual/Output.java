/**
 * @file Output.java
 * @brief Implementation of the Output class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/Output.h>
#include <jsbml/packages/qual/jsbml/ListOfOutputs.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new Output using the given JSBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
public Output(unsigned int level,
               unsigned int version,
               unsigned int pkgVersion)
  : SBase(level, version)
  , mId ("")
  , mQualitativeSpecies ("")
  , mTransitionEffect (TRANSITION_OUTPUT_EFFECT_INVALID)
  , mName ("")
  , mOutputLevel (JSBML_INT_MAX)
  , mIsSetOutputLevel (false)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new Output using the given QualPkgNamespaces object.
 */
public Output(QualPkgNamespaces *qualns)
  : SBase(qualns)
  , mId ("")
  , mQualitativeSpecies ("")
  , mTransitionEffect (TRANSITION_OUTPUT_EFFECT_INVALID)
  , mName ("")
  , mOutputLevel (JSBML_INT_MAX)
  , mIsSetOutputLevel (false)
{
  setElementNamespace(qualns->getURI());
  loadPlugins(qualns);
}


/*
 * Copy constructor for Output.
 */
public Output(const Output& orig)
  : SBase( orig )
  , mId ( orig.mId )
  , mQualitativeSpecies ( orig.mQualitativeSpecies )
  , mTransitionEffect ( orig.mTransitionEffect )
  , mName ( orig.mName )
  , mOutputLevel ( orig.mOutputLevel )
  , mIsSetOutputLevel ( orig.mIsSetOutputLevel )
{
}


/*
 * Assignment operator for Output.
 */
public Output& operator=(const Output& rhs)
{
  if (&rhs != this)
  {
    SBase::operator=(rhs);
    mId = rhs.mId;
    mQualitativeSpecies = rhs.mQualitativeSpecies;
    mTransitionEffect = rhs.mTransitionEffect;
    mName = rhs.mName;
    mOutputLevel = rhs.mOutputLevel;
    mIsSetOutputLevel = rhs.mIsSetOutputLevel;
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this Output object.
 */
public Output* clone()
{
  return new Output(*this);
}


/*
 * Destructor for Output.
 */
public ~Output()
{
}


/*
 * @returns the value of the "id" attribute of this Output.
 */
public const String getId()
{
  if (isSetId())
  {
    return mId.StringValue();
  }

  throw new PropertyUndefinedError(QualConstants.mId, this);
}


/*
 * @returns the value of the "qualitativeSpecies" attribute of this Output.
 */
public const String getQualitativeSpecies()
{
  if (isSetQualitativeSpecies())
  {
    return mQualitativeSpecies.StringValue();
  }

  throw new PropertyUndefinedError(QualConstants.mQualitativeSpecies, this);
}


/*
 * @returns the value of the "transitionEffect" attribute of this Output.
 */
public TransitionOutputEffect getTransitionEffect()
{
  if (isSetTransitionEffect())
  {
    return mTransitionEffect;
  }

  throw new PropertyUndefinedError(QualConstants.mTransitionEffect, this);
}


/*
 * Returns the value of the "transitionEffect" attribute of this Output.
 */
public const std::string& getTransitionEffectAsString()
{
  static const std::string code_str =
    TransitionOutputEffect_toString(mTransitionEffect);
  return code_str;
}


/*
 * @returns the value of the "name" attribute of this Output.
 */
public String getName()
{
  if (isSetName())
  {
    return mName.StringValue();
  }

  throw new PropertyUndefinedError(QualConstants.mName, this);
}


/*
 * @returns the value of the "outputLevel" attribute of this Output.
 */
public int getOutputLevel()
{
  if (isSetOutputLevel())
  {
    return mOutputLevel.intValue();
  }

  throw new PropertyUndefinedError(QualConstants.mOutputLevel, this);
}


/*
 * Predicate returning @c true if this Output's "id" attribute is set.
 */
public bool isSetId()
{
  return (mId.empty() == false);
}


/*
 * Predicate returning @c true if this Output's "qualitativeSpecies" attribute
 * is set.
 */
public bool isSetQualitativeSpecies()
{
  return (mQualitativeSpecies.empty() == false);
}


/*
 * Predicate returning @c true if this Output's "transitionEffect" attribute is
 * set.
 */
public bool isSetTransitionEffect()
{
  return (mTransitionEffect != TRANSITION_OUTPUT_EFFECT_INVALID);
}


/*
 * Predicate returning @c true if this Output's "name" attribute is set.
 */
public bool isSetName()
{
  ;
}


/*
 * Predicate returning @c true if this Output's "outputLevel" attribute is set.
 */
public bool isSetOutputLevel()
{
  return mIsSetOutputLevel;
}


/*
 * Sets the value of the "id" attribute of this Output.
 */
public int setId(const String id)
{
  mId = id;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "qualitativeSpecies" attribute of this Output.
 */
public int setQualitativeSpecies(const String qualitativeSpecies)
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
public int setTransitionEffect(const TransitionOutputEffect transitionEffect)
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
public int setTransitionEffect(const std::string& transitionEffect)
{
  if (TransitionOutputEffect_isValidString(transitionEffect.c_str()) == 0)
  {
    mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mTransitionEffect =
      TransitionOutputEffect_fromString(transitionEffect.c_str());
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "name" attribute of this Output.
 */
public int setName(String name)
{
  mName = name;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "outputLevel" attribute of this Output.
 */
public int setOutputLevel(int outputLevel)
{
  mOutputLevel = outputLevel;
  mIsSetOutputLevel = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "id" attribute of this Output.
 */
public int unsetId()
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
public int unsetQualitativeSpecies()
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
public int unsetTransitionEffect()
{
  mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "name" attribute of this Output.
 */
public int unsetName()
{
  TO DO;
}


/*
 * Unsets the value of the "outputLevel" attribute of this Output.
 */
public int unsetOutputLevel()
{
  mOutputLevel = JSBML_INT_MAX;
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
public void renameSIdRefs(const std::string& oldid, const std::string& newid)
{
  if (isSetQualitativeSpecies() && mQualitativeSpecies == oldid)
  {
    setQualitativeSpecies(newid);
  }
}


/*
 * Returns the XML element name of this Output object.
 */
public const std::string& getElementName()
{
  static const string name = "output";
  return name;
}


/*
 * Returns the libJSBML type code for this Output object.
 */
public int getTypeCode()
{
  return SBML_QUAL_OUTPUT;
}


/*
 * Predicate returning @c true if all the required attributes for this Output
 * object have been set.
 */
public bool hasRequiredAttributes()
{
  bool allPresent = SBase::hasRequiredAttributes();

  return allPresent;
}



/** @cond doxygenJSBMLInternal */

/*
 * Write any contained elements
 */
public void writeElements(XMLOutputStream& stream)
{
  SBase::writeElements(stream);

  SBase::writeExtensionElements(stream);
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Accepts the given SBMLVisitor
 */
public bool accept(SBMLVisitor& v)
{
  return v.visit(*this);
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Sets the parent SBMLDocument
 */
public void setSBMLDocument(SBMLDocument* d)
{
  SBase::setSBMLDocument(d);
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Enables/disables the given package with this element
 */
public void enablePackageInternal(const std::string& pkgURI,
                                  const std::string& pkgPrefix,
                                  bool flag)
{
  SBase::enablePackageInternal(pkgURI, pkgPrefix, flag);
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Creates a new object from the next XMLToken on the XMLInputStream
 */
public SBase* createObject(XMLInputStream& stream)
{
  SBase* obj = SBase::createObject(stream);

  connectToChild();

  return obj;
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Adds the expected attributes for this element
 */
public void addExpectedAttributes(ExpectedAttributes& attributes)
{
  SBase::addExpectedAttributes(attributes);

  attributes.add("id");

  attributes.add("qualitativeSpecies");

  attributes.add("transitionEffect");

  attributes.add("name");

  attributes.add("outputLevel");
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Reads the expected attributes into the member data variables
 */
public void readAttributes(const XMLAttributes& attributes,
                           const ExpectedAttributes& expectedAttributes)
{
  unsigned int level = getLevel();
  unsigned int version = getVersion();
  unsigned int pkgVersion = getPackageVersion();
  unsigned int numErrs;
  bool assigned = false;
  SBMLErrorLog* log = getErrorLog();

  if (static_cast<ListOfOutputs*>(getParentJSBMLObject())->size() < 2)
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
      logError(QualIdSyntaxRule, level, version, "The id '" + mId + "' does not "
        "conform to the syntax.");
    }
  }

  // 
  // qualitativeSpecies SIdRef (use = "optional" )
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
      logError(QualOutputQualitativeSpeciesMustBeQualitativeSpecies, level,
        version, "The attribute qualitativeSpecies='" + mQualitativeSpecies + "' "
          "does not conform to the syntax.");
    }
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
      logEmptyString(transitioneffect, level, version, "<Output>");
    }
    else
    {
      mTransitionEffect =
        TransitionOutputEffect_fromString(transitioneffect.c_str());

      if (TransitionOutputEffect_isValid(mTransitionEffect) == 0)
      {
        std::string msg = "The transitionEffect on the <Output> ";

        if (isSetId())
        {
          msg += "with id '" + getId() + "'";
        }

        msg += "is '" + transitioneffect + "', which is not a valid option.";

        log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
          msg);
      }
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
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        message);
    }
  }
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
 * Writes the attributes to the stream
 */
public void writeAttributes(XMLOutputStream& stream)
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
 * Creates a new Output_t using the given JSBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
JSBML_EXTERN
public Output_t * Output_create(unsigned int level,
                                unsigned int version,
                                unsigned int pkgVersion)
{
  return new Output(level, version, pkgVersion);
}


/*
 * Creates and returns a deep copy of this Output_t object.
 */
JSBML_EXTERN
public Output_t* Output_clone(const Output_t* o)
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
JSBML_EXTERN
public void Output_free(Output_t* o)
{
  if (o != NULL)
  {
    delete o;
  }
}


/*
 * @returns the value of the "id" attribute of this Output.
 */
JSBML_EXTERN
public String Output_getId(const Output * o)
{
  if (o == NULL)
  {
    return NULL;
  }

  return o->getId().empty() ? NULL : safe_strdup(o->getId().c_str());
}


/*
 * @returns the value of the "qualitativeSpecies" attribute of this Output.
 */
JSBML_EXTERN
public String Output_getQualitativeSpecies(const Output * o)
{
  if (o == NULL)
  {
    return NULL;
  }

  return o->getQualitativeSpecies().empty() ? NULL :
    safe_strdup(o->getQualitativeSpecies().c_str());
}


/*
 * @returns the value of the "transitionEffect" attribute of this Output.
 */
JSBML_EXTERN
public TransitionOutputEffect Output_getTransitionEffect(const Output * o)
{
  if (o == NULL)
  {
    return TRANSITION_OUTPUT_EFFECT_INVALID;
  }

  return o->getTransitionEffect();
}


/*
 * Returns the value of the "transitionEffect" attribute of this Output.
 */
JSBML_EXTERN
public const char * Output_getTransitionEffectAsString(const Output * o)
{
  return TransitionOutputEffect_toString(o->getTransitionEffect());
}


/*
 * @returns the value of the "name" attribute of this Output.
 */
JSBML_EXTERN
public String Output_getName(const Output * o)
{
  if (o == NULL)
  {
    return NULL;
  }

  return o->getName().empty() ? NULL : safe_strdup(o->getName().c_str());
}


/*
 * @returns the value of the "outputLevel" attribute of this Output.
 */
JSBML_EXTERN
public int Output_getOutputLevel(const Output * o)
{
  return (o != NULL) ? o->getOutputLevel() : JSBML_INT_MAX;
}


/*
 * Predicate returning @c 1 if this Output's "id" attribute is set.
 */
JSBML_EXTERN
public int Output_isSetId(const Output * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetId()) : 0;
}


/*
 * Predicate returning @c 1 if this Output's "qualitativeSpecies" attribute is
 * set.
 */
JSBML_EXTERN
public int Output_isSetQualitativeSpecies(const Output * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetQualitativeSpecies()) : 0;
}


/*
 * Predicate returning @c 1 if this Output's "transitionEffect" attribute is
 * set.
 */
JSBML_EXTERN
public int Output_isSetTransitionEffect(const Output * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetTransitionEffect()) : 0;
}


/*
 * Predicate returning @c 1 if this Output's "name" attribute is set.
 */
JSBML_EXTERN
public int Output_isSetName(const Output * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetName()) : 0;
}


/*
 * Predicate returning @c 1 if this Output's "outputLevel" attribute is set.
 */
JSBML_EXTERN
public int Output_isSetOutputLevel(const Output * o)
{
  return (o != NULL) ? static_cast<int>(o->isSetOutputLevel()) : 0;
}


/*
 * Sets the value of the "id" attribute of this Output.
 */
JSBML_EXTERN
public int Output_setId(Output * o, String id)
{
  return (o != NULL) ? o->setId(id) : LIBJSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "qualitativeSpecies" attribute of this Output.
 */
JSBML_EXTERN
public int Output_setQualitativeSpecies(Output * o, String qualitativeSpecies)
{
  return (o != NULL) ? o->setQualitativeSpecies(qualitativeSpecies) :
    LIBJSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "transitionEffect" attribute of this Output.
 */
JSBML_EXTERN
public int Output_setTransitionEffect(Output * o,
                                      TransitionOutputEffect transitionEffect)
{
  return (o != NULL) ? o->setTransitionEffect(transitionEffect) :
    LIBJSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "transitionEffect" attribute of this Output.
 */
JSBML_EXTERN
public int Output_setTransitionEffectAsString(Output * o,
                                              const char * transitionEffect)
{
  return (o != NULL) ? o->setTransitionEffect(transitionEffect):
    LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "name" attribute of this Output.
 */
JSBML_EXTERN
public int Output_setName(Output * o, String name)
{
  return (o != NULL) ? o->setName(name) : LIBJSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "outputLevel" attribute of this Output.
 */
JSBML_EXTERN
public int Output_setOutputLevel(Output * o, int outputLevel)
{
  return (o != NULL) ? o->setOutputLevel(outputLevel) :
    LIBJSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "id" attribute of this Output.
 */
JSBML_EXTERN
public int Output_unsetId(Output * o)
{
  return (o != NULL) ? o->unsetId() : LIBJSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "qualitativeSpecies" attribute of this Output.
 */
JSBML_EXTERN
public int Output_unsetQualitativeSpecies(Output * o)
{
  return (o != NULL) ? o->unsetQualitativeSpecies() : LIBJSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "transitionEffect" attribute of this Output.
 */
JSBML_EXTERN
public int Output_unsetTransitionEffect(Output * o)
{
  return (o != NULL) ? o->unsetTransitionEffect() : LIBJSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "name" attribute of this Output.
 */
JSBML_EXTERN
public int Output_unsetName(Output * o)
{
  return (o != NULL) ? o->unsetName() : LIBJSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "outputLevel" attribute of this Output.
 */
JSBML_EXTERN
public int Output_unsetOutputLevel(Output * o)
{
  return (o != NULL) ? o->unsetOutputLevel() : LIBJSBML_INVALID_OBJECT;
}


/*
 * Predicate returning @c 1 if all the required attributes for this Output_t
 * object have been set.
 */
JSBML_EXTERN
public int Output_hasRequiredAttributes(const Output_t * o)
{
  return (o != NULL) ? static_cast<int>(o->hasRequiredAttributes()) : 0;
}




JSBML_CPP_NAMESPACE_END


