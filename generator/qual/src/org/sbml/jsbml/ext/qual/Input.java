/**
 * @file Input.java
 * @brief Implementation of the Input class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/Input.h>
#include <jsbml/packages/qual/jsbml/ListOfInputs.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


  /**
   * Creates a new Input using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public Input(unsigned int level,
                unsigned int version,
                unsigned int pkgVersion)
    : SBase(level, version)
    , mId ("")
    , mName ("")
    , mSign (SIGN_INVALID)
    , mQualitativeSpecies ("")
    , mTransitionEffect (TRANSITION_INPUT_EFFECT_INVALID)
    , mThresholdLevel (JSBML_INT_MAX)
    , mIsSetThresholdLevel (false)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
  }


  /**
   * Creates a new Input using the given QualPkgNamespaces object.
   */
  public Input(QualPkgNamespaces *qualns)
    : SBase(qualns)
    , mId ("")
    , mName ("")
    , mSign (SIGN_INVALID)
    , mQualitativeSpecies ("")
    , mTransitionEffect (TRANSITION_INPUT_EFFECT_INVALID)
    , mThresholdLevel (JSBML_INT_MAX)
    , mIsSetThresholdLevel (false)
  {
    setElementNamespace(qualns->getURI());
    loadPlugins(qualns);
  }


  /**
   * Copy constructor for Input.
   */
  public Input(const Input& orig)
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


  /**
   * Assignment operator for Input.
   */
  public Input& operator=(const Input& rhs)
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


  /**
   * Creates and returns a deep copy of this Input object.
   */
  public Input* clone()
  {
    return new Input(*this);
  }


  /**
   * Destructor for Input.
   */
  public ~Input()
  {
  }


  /**
   * @return the value of the "id" attribute of this Input.
   */
  public String getId()
  {
    return isSetId() ? id : "";
  }


  /**
   * @return the value of the "name" attribute of this Input.
   */
  public String getName()
  {
    return isSetName() ? name : "";
  }


  /**
   * @return the value of the "sign" attribute of this Input.
   */
  public Sign getSign()
  {
    if (isSetSign())
    {
      return mSign;
    }

    throw new PropertyUndefinedError(QualConstants.mSign, this);
  }


  /**
   * @return the value of the "qualitativeSpecies" attribute of this Input.
   */
  public String getQualitativeSpecies()
  {
    return isSetQualitativeSpecies() ? qualitativeSpecies : "";
  }


  /**
   * @return the value of the "transitionEffect" attribute of this Input.
   */
  public TransitionInputEffect getTransitionEffect()
  {
    if (isSetTransitionEffect())
    {
      return mTransitionEffect;
    }

    throw new PropertyUndefinedError(QualConstants.mTransitionEffect, this);
  }


  /**
   * @return the value of the "thresholdLevel" attribute of this Input.
   */
  public int getThresholdLevel()
  {
    if (isSetThresholdLevel())
    {
      return mThresholdLevel.intValue();
    }

    throw new PropertyUndefinedError(QualConstants.mThresholdLevel, this);
  }


  /**
   * Predicate returning {@code true} if this Input's "id" attribute is set.
   */
  public boolean isSetId()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Input's "name" attribute is set.
   */
  public boolean isSetName()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Input's "sign" attribute is set.
   */
  public boolean isSetSign()
  {
    return (mSign != SIGN_INVALID);
  }


  /**
   * Predicate returning {@code true} if this Input's "qualitativeSpecies"
   * attribute is set.
   */
  public boolean isSetQualitativeSpecies()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Input's "transitionEffect"
   * attribute is set.
   */
  public boolean isSetTransitionEffect()
  {
    return (mTransitionEffect != TRANSITION_INPUT_EFFECT_INVALID);
  }


  /**
   * Predicate returning {@code true} if this Input's "thresholdLevel"
   * attribute is set.
   */
  public boolean isSetThresholdLevel()
  {
    return mThresholdLevel != null;
  }


  /**
   * Sets the value of the "id" attribute of this Input.
   */
  public void setId(String id)
  {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }


  /**
   * Sets the value of the "name" attribute of this Input.
   */
  public void setName(String name)
  {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Sets the value of the "sign" attribute of this Input.
   */
  public void setSign(Sign sign)
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


  /**
   * Sets the value of the "qualitativeSpecies" attribute of this Input.
   */
  public void setQualitativeSpecies(String qualitativeSpecies)
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


  /**
   * Sets the value of the "transitionEffect" attribute of this Input.
   */
  public void setTransitionEffect(TransitionInputEffect transitionEffect)
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


  /**
   * Sets the value of the "thresholdLevel" attribute of this Input.
   */
  public void setThresholdLevel(int thresholdLevel)
  {
    Integer oldmThresholdLevel = this.mThresholdLevel;

    this.oldmThresholdLevel = thresholdLevel;

    firePropertyChange(QualConstants.mThresholdLevel, oldmThresholdLevel,
      this.oldmThresholdLevel);
  }


  /**
   * Unsets the value of the "id" attribute of this Input.
   */
  public boolean unsetId()
  {
    TO DO;
  }


  /**
   * Unsets the value of the "name" attribute of this Input.
   */
  public boolean unsetName()
  {
    TO DO;
  }


  /**
   * Unsets the value of the "sign" attribute of this Input.
   */
  public boolean unsetSign()
  {
    mSign = SIGN_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Unsets the value of the "qualitativeSpecies" attribute of this Input.
   */
  public boolean unsetQualitativeSpecies()
  {
    TO DO;
  }


  /**
   * Unsets the value of the "transitionEffect" attribute of this Input.
   */
  public boolean unsetTransitionEffect()
  {
    mTransitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Unsets the value of the "thresholdLevel" attribute of this Input.
   */
  public boolean unsetThresholdLevel()
  {
    if ((isSetThresholdLevel()))
    {
      Integer oldmThresholdLevel = mThresholdLevel;
      thresholdLevel = null;
      firePropertyChange(QualConstants.mThresholdLevel, oldmThresholdLevel,
        mThresholdLevel);
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * @copydoc doc_renamesidref_common
   */
  public void renameSIdRefs(const std::string& oldid, const std::string& newid)
  {
    if (isSetQualitativeSpecies() && mQualitativeSpecies == oldid)
    {
      setQualitativeSpecies(newid);
    }
  }


  /**
   * Returns the XML element name of this Input object.
   */
  public const std::string& getElementName()
  {
    static const string name = "input";
    return name;
  }


  /**
   * Returns the libJSBML type code for this Input object.
   */
  public int getTypeCode()
  {
    return SBML_QUAL_INPUT;
  }


  /**
   * Predicate returning @c true if all the required attributes for this Input
   * object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = SBase::hasRequiredAttributes();

    if (isSetQualitativeSpecies() == false)
    {
      allPresent = false;
    }

    return allPresent;
  }



  /** @cond doxygenJSBMLInternal */

  /**
   * Write any contained elements
   */
  public void writeElements(XMLOutputStream& stream)
  {
    SBase::writeElements(stream);

    SBase::writeExtensionElements(stream);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Accepts the given SBMLVisitor
   */
  public bool accept(SBMLVisitor& v)
  {
    return v.visit(*this);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Sets the parent SBMLDocument
   */
  public void setSBMLDocument(SBMLDocument* d)
  {
    SBase::setSBMLDocument(d);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
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

  /**
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

  /**
   * Adds the expected attributes for this element
   */
  public void addExpectedAttributes(ExpectedAttributes& attributes)
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



  /** @cond doxygenJSBMLInternal */

  /**
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

    if (static_cast<ListOfInputs*>(getParentJSBMLObject())->size() < 2)
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
        logEmptyString(mId, level, version, "<Input>");
      }
      else if (SyntaxChecker::isValidSBMLSId(mId) == false)
      {
        logError(QualIdSyntaxRule, level, version, "The id '" + mId + "' does "
          "not conform to the syntax.");
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

          log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
            msg);
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
          version, "The attribute qualitativeSpecies='" + mQualitativeSpecies +
            "' does not conform to the syntax.");
      }
    }
    else
    {
      std::string message = "Qual attribute 'qualitativeSpecies' is missing "
        "from the <Input> element.";
      log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
        message);
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

          log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
            msg);
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
        log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
          message);
      }
    }
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Writes the attributes to the stream
   */
  public void writeAttributes(XMLOutputStream& stream)
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


  /**
   * Creates a new Input_t using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  JSBML_EXTERN
  public Input_t * Input_create(unsigned int level,
                                unsigned int version,
                                unsigned int pkgVersion)
  {
    return new Input(level, version, pkgVersion);
  }


  /**
   * Creates and returns a deep copy of this Input_t object.
   */
  JSBML_EXTERN
  public Input_t* Input_clone(const Input_t* i)
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


  /**
   * Frees this Input_t object.
   */
  JSBML_EXTERN
  public void Input_free(Input_t* i)
  {
    if (i != NULL)
    {
      delete i;
    }
  }


  /**
   * @return the value of the "id" attribute of this Input.
   */
  JSBML_EXTERN
  public String Input_getId(const Input * i)
  {
    if (i == NULL)
    {
      return NULL;
    }

    return i->getId().empty() ? NULL : safe_strdup(i->getId().c_str());
  }


  /**
   * @return the value of the "name" attribute of this Input.
   */
  JSBML_EXTERN
  public String Input_getName(const Input * i)
  {
    if (i == NULL)
    {
      return NULL;
    }

    return i->getName().empty() ? NULL : safe_strdup(i->getName().c_str());
  }


  /**
   * @return the value of the "sign" attribute of this Input.
   */
  JSBML_EXTERN
  public Sign Input_getSign(const Input * i)
  {
    if (i == NULL)
    {
      return SIGN_INVALID;
    }

    return i->getSign();
  }


  /**
   * @return the value of the "qualitativeSpecies" attribute of this Input.
   */
  JSBML_EXTERN
  public String Input_getQualitativeSpecies(const Input * i)
  {
    if (i == NULL)
    {
      return NULL;
    }

    return i->getQualitativeSpecies().empty() ? NULL :
      safe_strdup(i->getQualitativeSpecies().c_str());
  }


  /**
   * @return the value of the "transitionEffect" attribute of this Input.
   */
  JSBML_EXTERN
  public TransitionInputEffect Input_getTransitionEffect(const Input * i)
  {
    if (i == NULL)
    {
      return TRANSITION_INPUT_EFFECT_INVALID;
    }

    return i->getTransitionEffect();
  }


  /**
   * @return the value of the "thresholdLevel" attribute of this Input.
   */
  JSBML_EXTERN
  public int Input_getThresholdLevel(const Input * i)
  {
    return (i != NULL) ? i->getThresholdLevel() : JSBML_INT_MAX;
  }


  /**
   * Predicate returning @c 1 if this Input's "id" attribute is set.
   */
  JSBML_EXTERN
  public int Input_isSetId(const Input * i)
  {
    return (i != NULL) ? static_cast<int>(i->isSetId()) : 0;
  }


  /**
   * Predicate returning @c 1 if this Input's "name" attribute is set.
   */
  JSBML_EXTERN
  public int Input_isSetName(const Input * i)
  {
    return (i != NULL) ? static_cast<int>(i->isSetName()) : 0;
  }


  /**
   * Predicate returning @c 1 if this Input's "sign" attribute is set.
   */
  JSBML_EXTERN
  public int Input_isSetSign(const Input * i)
  {
    return (i != NULL) ? static_cast<int>(i->isSetSign()) : 0;
  }


  /**
   * Predicate returning @c 1 if this Input's "qualitativeSpecies" attribute is
   * set.
   */
  JSBML_EXTERN
  public int Input_isSetQualitativeSpecies(const Input * i)
  {
    return (i != NULL) ? static_cast<int>(i->isSetQualitativeSpecies()) : 0;
  }


  /**
   * Predicate returning @c 1 if this Input's "transitionEffect" attribute is
   * set.
   */
  JSBML_EXTERN
  public int Input_isSetTransitionEffect(const Input * i)
  {
    return (i != NULL) ? static_cast<int>(i->isSetTransitionEffect()) : 0;
  }


  /**
   * Predicate returning @c 1 if this Input's "thresholdLevel" attribute is
   * set.
   */
  JSBML_EXTERN
  public int Input_isSetThresholdLevel(const Input * i)
  {
    return (i != NULL) ? static_cast<int>(i->isSetThresholdLevel()) : 0;
  }


  /**
   * Sets the value of the "id" attribute of this Input.
   */
  JSBML_EXTERN
  public void Input_setId(Input * i, String id)
  {
    return (i != NULL) ? i->setId(id) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "name" attribute of this Input.
   */
  JSBML_EXTERN
  public void Input_setName(Input * i, String name)
  {
    return (i != NULL) ? i->setName(name) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "sign" attribute of this Input.
   */
  JSBML_EXTERN
  public void Input_setSign(Input * i, Sign sign)
  {
    return (i != NULL) ? i->setSign(sign) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "qualitativeSpecies" attribute of this Input.
   */
  JSBML_EXTERN
  public void Input_setQualitativeSpecies(Input * i, String qualitativeSpecies)
  {
    return (i != NULL) ? i->setQualitativeSpecies(qualitativeSpecies) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "transitionEffect" attribute of this Input.
   */
  JSBML_EXTERN
  public void Input_setTransitionEffect(Input * i,
                                        TransitionInputEffect transitionEffect)
  {
    return (i != NULL) ? i->setTransitionEffect(transitionEffect) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "thresholdLevel" attribute of this Input.
   */
  JSBML_EXTERN
  public void Input_setThresholdLevel(Input * i, int thresholdLevel)
  {
    return (i != NULL) ? i->setThresholdLevel(thresholdLevel) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "id" attribute of this Input.
   */
  JSBML_EXTERN
  public boolean Input_unsetId(Input * i)
  {
    return (i != NULL) ? i->unsetId() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "name" attribute of this Input.
   */
  JSBML_EXTERN
  public boolean Input_unsetName(Input * i)
  {
    return (i != NULL) ? i->unsetName() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "sign" attribute of this Input.
   */
  JSBML_EXTERN
  public boolean Input_unsetSign(Input * i)
  {
    return (i != NULL) ? i->unsetSign() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "qualitativeSpecies" attribute of this Input.
   */
  JSBML_EXTERN
  public boolean Input_unsetQualitativeSpecies(Input * i)
  {
    return (i != NULL) ? i->unsetQualitativeSpecies() :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "transitionEffect" attribute of this Input.
   */
  JSBML_EXTERN
  public boolean Input_unsetTransitionEffect(Input * i)
  {
    return (i != NULL) ? i->unsetTransitionEffect() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "thresholdLevel" attribute of this Input.
   */
  JSBML_EXTERN
  public boolean Input_unsetThresholdLevel(Input * i)
  {
    return (i != NULL) ? i->unsetThresholdLevel() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Predicate returning @c 1 if all the required attributes for this Input_t
   * object have been set.
   */
  JSBML_EXTERN
  public int Input_hasRequiredAttributes(const Input_t * i)
  {
    return (i != NULL) ? static_cast<int>(i->hasRequiredAttributes()) : 0;
  }




JSBML_CPP_NAMESPACE_END


