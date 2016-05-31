/**
 * @file DefaultTerm.java
 * @brief Implementation of the DefaultTerm class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/DefaultTerm.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


  /**
   * Creates a new DefaultTerm using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public DefaultTerm(unsigned int level,
                      unsigned int version,
                      unsigned int pkgVersion)
    : SBase(level, version)
    , mResultLevel (JSBML_INT_MAX)
    , mIsSetResultLevel (false)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
  }


  /**
   * Creates a new DefaultTerm using the given QualPkgNamespaces object.
   */
  public DefaultTerm(QualPkgNamespaces *qualns)
    : SBase(qualns)
    , mResultLevel (JSBML_INT_MAX)
    , mIsSetResultLevel (false)
  {
    setElementNamespace(qualns->getURI());
    loadPlugins(qualns);
  }


  /**
   * Copy constructor for DefaultTerm.
   */
  public DefaultTerm(const DefaultTerm& orig)
    : SBase( orig )
    , mResultLevel ( orig.mResultLevel )
    , mIsSetResultLevel ( orig.mIsSetResultLevel )
  {
  }


  /**
   * Assignment operator for DefaultTerm.
   */
  public DefaultTerm& operator=(const DefaultTerm& rhs)
  {
    if (&rhs != this)
    {
      SBase::operator=(rhs);
      mResultLevel = rhs.mResultLevel;
      mIsSetResultLevel = rhs.mIsSetResultLevel;
    }

    return *this;
  }


  /**
   * Creates and returns a deep copy of this DefaultTerm object.
   */
  public DefaultTerm* clone()
  {
    return new DefaultTerm(*this);
  }


  /**
   * Destructor for DefaultTerm.
   */
  public ~DefaultTerm()
  {
  }


  /**
   * @return the value of the "resultLevel" attribute of this DefaultTerm.
   */
  public int getResultLevel()
  {
    if (isSetResultLevel())
    {
      return mResultLevel.intValue();
    }

    throw new PropertyUndefinedError(QualConstants.mResultLevel, this);
  }


  /**
   * Predicate returning {@code true} if this DefaultTerm's "resultLevel"
   * attribute is set.
   */
  public boolean isSetResultLevel()
  {
    return mResultLevel != null;
  }


  /**
   * Sets the value of the "resultLevel" attribute of this DefaultTerm.
   */
  public void setResultLevel(int resultLevel)
  {
    Integer oldmResultLevel = this.mResultLevel;

    this.oldmResultLevel = resultLevel;

    firePropertyChange(QualConstants.mResultLevel, oldmResultLevel,
      this.oldmResultLevel);
  }


  /**
   * Unsets the value of the "resultLevel" attribute of this DefaultTerm.
   */
  public boolean unsetResultLevel()
  {
    if (isSetResultLevel())
    {
      Integer oldmResultLevel = mResultLevel;
      mResultLevel = null;
      firePropertyChange(QualConstants.mResultLevel, oldmResultLevel,
        mResultLevel);
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Returns the XML element name of this DefaultTerm object.
   */
  public const std::string& getElementName()
  {
    static const string name = "defaultTerm";
    return name;
  }


  /**
   * Returns the libJSBML type code for this DefaultTerm object.
   */
  public int getTypeCode()
  {
    return SBML_QUAL_DEFAULT_TERM;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * DefaultTerm object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = SBase::hasRequiredAttributes();

    if (isSetResultLevel() == false)
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

    attributes.add("resultLevel");
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



  /** @cond doxygenJSBMLInternal */

  /**
   * Writes the attributes to the stream
   */
  public void writeAttributes(XMLOutputStream& stream)
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


  /**
   * Creates a new DefaultTerm_t using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  JSBML_EXTERN
  public DefaultTerm_t * DefaultTerm_create(unsigned int level,
                                            unsigned int version,
                                            unsigned int pkgVersion)
  {
    return new DefaultTerm(level, version, pkgVersion);
  }


  /**
   * Creates and returns a deep copy of this DefaultTerm_t object.
   */
  JSBML_EXTERN
  public DefaultTerm_t* DefaultTerm_clone(const DefaultTerm_t* dt)
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


  /**
   * Frees this DefaultTerm_t object.
   */
  JSBML_EXTERN
  public void DefaultTerm_free(DefaultTerm_t* dt)
  {
    if (dt != NULL)
    {
      delete dt;
    }
  }


  /**
   * @return the value of the "resultLevel" attribute of this DefaultTerm.
   */
  JSBML_EXTERN
  public int DefaultTerm_getResultLevel(const DefaultTerm * dt)
  {
    return (dt != NULL) ? dt->getResultLevel() : JSBML_INT_MAX;
  }


  /**
   * Predicate returning @c 1 if this DefaultTerm's "resultLevel" attribute is
   * set.
   */
  JSBML_EXTERN
  public int DefaultTerm_isSetResultLevel(const DefaultTerm * dt)
  {
    return (dt != NULL) ? static_cast<int>(dt->isSetResultLevel()) : 0;
  }


  /**
   * Sets the value of the "resultLevel" attribute of this DefaultTerm.
   */
  JSBML_EXTERN
  public void DefaultTerm_setResultLevel(DefaultTerm * dt, int resultLevel)
  {
    return (dt != NULL) ? dt->setResultLevel(resultLevel) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "resultLevel" attribute of this DefaultTerm.
   */
  JSBML_EXTERN
  public boolean DefaultTerm_unsetResultLevel(DefaultTerm * dt)
  {
    return (dt != NULL) ? dt->unsetResultLevel() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Predicate returning @c 1 if all the required attributes for this
   * DefaultTerm_t object have been set.
   */
  JSBML_EXTERN
  public int DefaultTerm_hasRequiredAttributes(const DefaultTerm_t * dt)
  {
    return (dt != NULL) ? static_cast<int>(dt->hasRequiredAttributes()) : 0;
  }




JSBML_CPP_NAMESPACE_END


