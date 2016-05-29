/**
 * @file QualitativeSpecies.java
 * @brief Implementation of the QualitativeSpecies class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/QualitativeSpecies.h>
#include <jsbml/packages/qual/jsbml/ListOfQualitativeSpecies.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


  /**
   * Creates a new QualitativeSpecies using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public QualitativeSpecies(unsigned int level,
                             unsigned int version,
                             unsigned int pkgVersion)
    : SBase(level, version)
    , mId ("")
    , mName ("")
    , mCompartment ("")
    , mConstant (False)
    , mIsSetConstant (false)
    , mInitialLevel (JSBML_INT_MAX)
    , mIsSetInitialLevel (false)
    , mMaxLevel (JSBML_INT_MAX)
    , mIsSetMaxLevel (false)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
  }


  /**
   * Creates a new QualitativeSpecies using the given QualPkgNamespaces object.
   */
  public QualitativeSpecies(QualPkgNamespaces *qualns)
    : SBase(qualns)
    , mId ("")
    , mName ("")
    , mCompartment ("")
    , mConstant (False)
    , mIsSetConstant (false)
    , mInitialLevel (JSBML_INT_MAX)
    , mIsSetInitialLevel (false)
    , mMaxLevel (JSBML_INT_MAX)
    , mIsSetMaxLevel (false)
  {
    setElementNamespace(qualns->getURI());
    loadPlugins(qualns);
  }


  /**
   * Copy constructor for QualitativeSpecies.
   */
  public QualitativeSpecies(const QualitativeSpecies& orig)
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


  /**
   * Assignment operator for QualitativeSpecies.
   */
  public QualitativeSpecies& operator=(const QualitativeSpecies& rhs)
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


  /**
   * Creates and returns a deep copy of this QualitativeSpecies object.
   */
  public QualitativeSpecies* clone()
  {
    return new QualitativeSpecies(*this);
  }


  /**
   * Destructor for QualitativeSpecies.
   */
  public ~QualitativeSpecies()
  {
  }


  /**
   * @return the value of the "id" attribute of this QualitativeSpecies.
   */
  public String getId()
  {
    return isSetId() ? id : "";
  }


  /**
   * @return the value of the "name" attribute of this QualitativeSpecies.
   */
  public String getName()
  {
    return isSetName() ? name : "";
  }


  /**
   * @return the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public String getCompartment()
  {
    return isSetCompartment() ? compartment : "";
  }


  /**
   * @return the value of the "constant" attribute of this QualitativeSpecies.
   */
  public boolean getConstant()
  {
    if (isSetConstant())
    {
      return mConstant.booleanValue();
    }

    throw new PropertyUndefinedError(QualConstants.mConstant, this);
  }


  /**
   * @return the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  public int getInitialLevel()
  {
    if (isSetInitialLevel())
    {
      return mInitialLevel.intValue();
    }

    throw new PropertyUndefinedError(QualConstants.mInitialLevel, this);
  }


  /**
   * @return the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public int getMaxLevel()
  {
    if (isSetMaxLevel())
    {
      return mMaxLevel.intValue();
    }

    throw new PropertyUndefinedError(QualConstants.mMaxLevel, this);
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "id"
   * attribute is set.
   */
  public boolean isSetId()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "name"
   * attribute is set.
   */
  public boolean isSetName()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "compartment" attribute is set.
   */
  public boolean isSetCompartment()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "constant"
   * attribute is set.
   */
  public boolean isSetConstant()
  {
    return mConstant != null;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "initialLevel" attribute is set.
   */
  public boolean isSetInitialLevel()
  {
    return mInitialLevel != null;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "maxLevel"
   * attribute is set.
   */
  public boolean isSetMaxLevel()
  {
    return mMaxLevel != null;
  }


  /**
   * Sets the value of the "id" attribute of this QualitativeSpecies.
   */
  public void setId(String id)
  {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }


  /**
   * Sets the value of the "name" attribute of this QualitativeSpecies.
   */
  public void setName(String name)
  {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Sets the value of the "compartment" attribute of this QualitativeSpecies.
   */
  public void setCompartment(String compartment)
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


  /**
   * Sets the value of the "constant" attribute of this QualitativeSpecies.
   */
  public void setConstant(boolean constant)
  {
    Boolean oldmConstant = this.mConstant;

    this.oldmConstant = constant;

    firePropertyChange(QualConstants.mConstant, oldmConstant,
      this.oldmConstant);
  }


  /**
   * Sets the value of the "initialLevel" attribute of this QualitativeSpecies.
   */
  public void setInitialLevel(int initialLevel)
  {
    Integer oldmInitialLevel = this.mInitialLevel;

    this.oldmInitialLevel = initialLevel;

    firePropertyChange(QualConstants.mInitialLevel, oldmInitialLevel,
      this.oldmInitialLevel);
  }


  /**
   * Sets the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public void setMaxLevel(int maxLevel)
  {
    Integer oldmMaxLevel = this.mMaxLevel;

    this.oldmMaxLevel = maxLevel;

    firePropertyChange(QualConstants.mMaxLevel, oldmMaxLevel,
      this.oldmMaxLevel);
  }


  /**
   * Unsets the value of the "id" attribute of this QualitativeSpecies.
   */
  public boolean unsetId()
  {
    TO DO;
  }


  /**
   * Unsets the value of the "name" attribute of this QualitativeSpecies.
   */
  public boolean unsetName()
  {
    TO DO;
  }


  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetCompartment()
  {
    TO DO;
  }


  /**
   * Unsets the value of the "constant" attribute of this QualitativeSpecies.
   */
  public boolean unsetConstant()
  {
    if ((isSetConstant()))
    {
      Boolean oldmConstant = mConstant;
      constant = null;
      firePropertyChange(QualConstants.mConstant, oldmConstant, mConstant);
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Unsets the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetInitialLevel()
  {
    if ((isSetInitialLevel()))
    {
      Integer oldmInitialLevel = mInitialLevel;
      initialLevel = null;
      firePropertyChange(QualConstants.mInitialLevel, oldmInitialLevel,
        mInitialLevel);
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public boolean unsetMaxLevel()
  {
    if ((isSetMaxLevel()))
    {
      Integer oldmMaxLevel = mMaxLevel;
      maxLevel = null;
      firePropertyChange(QualConstants.mMaxLevel, oldmMaxLevel, mMaxLevel);
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
    if (isSetCompartment() && mCompartment == oldid)
    {
      setCompartment(newid);
    }
  }


  /**
   * Returns the XML element name of this QualitativeSpecies object.
   */
  public const std::string& getElementName()
  {
    static const string name = "qualitativeSpecies";
    return name;
  }


  /**
   * Returns the libJSBML type code for this QualitativeSpecies object.
   */
  public int getTypeCode()
  {
    return SBML_QUAL_QUALITATIVE_SPECIES;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * QualitativeSpecies object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = SBase::hasRequiredAttributes();

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

    attributes.add("compartment");

    attributes.add("constant");

    attributes.add("initialLevel");

    attributes.add("maxLevel");
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

    if (static_cast<ListOfQualitativeSpecies*>(getParentJSBMLObject())->size()
      < 2)
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
        logError(QualIdSyntaxRule, level, version, "The id '" + mId + "' does "
          "not conform to the syntax.");
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


  /**
   * Creates a new QualitativeSpecies_t using the given JSBML Level, Version
   * and &ldquo;qual&rdquo; package version.
   */
  JSBML_EXTERN
  public QualitativeSpecies_t * QualitativeSpecies_create(unsigned int level,
                                                          unsigned int version,
                                                          unsigned int
                                                            pkgVersion)
  {
    return new QualitativeSpecies(level, version, pkgVersion);
  }


  /**
   * Creates and returns a deep copy of this QualitativeSpecies_t object.
   */
  JSBML_EXTERN
  public QualitativeSpecies_t* QualitativeSpecies_clone(const
    QualitativeSpecies_t* qs)
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


  /**
   * Frees this QualitativeSpecies_t object.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_free(QualitativeSpecies_t* qs)
  {
    if (qs != NULL)
    {
      delete qs;
    }
  }


  /**
   * @return the value of the "id" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public String QualitativeSpecies_getId(const QualitativeSpecies * qs)
  {
    if (qs == NULL)
    {
      return NULL;
    }

    return qs->getId().empty() ? NULL : safe_strdup(qs->getId().c_str());
  }


  /**
   * @return the value of the "name" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public String QualitativeSpecies_getName(const QualitativeSpecies * qs)
  {
    if (qs == NULL)
    {
      return NULL;
    }

    return qs->getName().empty() ? NULL : safe_strdup(qs->getName().c_str());
  }


  /**
   * @return the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  JSBML_EXTERN
  public String QualitativeSpecies_getCompartment(const QualitativeSpecies *
    qs)
  {
    if (qs == NULL)
    {
      return NULL;
    }

    return qs->getCompartment().empty() ? NULL :
      safe_strdup(qs->getCompartment().c_str());
  }


  /**
   * @return the value of the "constant" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_getConstant(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->getConstant()) : 0;
  }


  /**
   * @return the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_getInitialLevel(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->getInitialLevel() : JSBML_INT_MAX;
  }


  /**
   * @return the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_getMaxLevel(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->getMaxLevel() : JSBML_INT_MAX;
  }


  /**
   * Predicate returning @c 1 if this QualitativeSpecies's "id" attribute is
   * set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_isSetId(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->isSetId()) : 0;
  }


  /**
   * Predicate returning @c 1 if this QualitativeSpecies's "name" attribute is
   * set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_isSetName(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->isSetName()) : 0;
  }


  /**
   * Predicate returning @c 1 if this QualitativeSpecies's "compartment"
   * attribute is set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_isSetCompartment(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->isSetCompartment()) : 0;
  }


  /**
   * Predicate returning @c 1 if this QualitativeSpecies's "constant" attribute
   * is set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_isSetConstant(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->isSetConstant()) : 0;
  }


  /**
   * Predicate returning @c 1 if this QualitativeSpecies's "initialLevel"
   * attribute is set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_isSetInitialLevel(const QualitativeSpecies *
    qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->isSetInitialLevel()) : 0;
  }


  /**
   * Predicate returning @c 1 if this QualitativeSpecies's "maxLevel" attribute
   * is set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_isSetMaxLevel(const QualitativeSpecies * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->isSetMaxLevel()) : 0;
  }


  /**
   * Sets the value of the "id" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_setId(QualitativeSpecies * qs, String id)
  {
    return (qs != NULL) ? qs->setId(id) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "name" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_setName(QualitativeSpecies * qs, String name)
  {
    return (qs != NULL) ? qs->setName(name) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "compartment" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_setCompartment(QualitativeSpecies * qs,
                                                String compartment)
  {
    return (qs != NULL) ? qs->setCompartment(compartment) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "constant" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_setConstant(QualitativeSpecies * qs,
                                             boolean constant)
  {
    return (qs != NULL) ? qs->setConstant(constant) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "initialLevel" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_setInitialLevel(QualitativeSpecies * qs,
                                                 int initialLevel)
  {
    return (qs != NULL) ? qs->setInitialLevel(initialLevel) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Sets the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public void QualitativeSpecies_setMaxLevel(QualitativeSpecies * qs,
                                             int maxLevel)
  {
    return (qs != NULL) ? qs->setMaxLevel(maxLevel) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "id" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_unsetId(QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->unsetId() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "name" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_unsetName(QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->unsetName() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_unsetCompartment(QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->unsetCompartment() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "constant" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_unsetConstant(QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->unsetConstant() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_unsetInitialLevel(QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->unsetInitialLevel() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  JSBML_EXTERN
  public boolean QualitativeSpecies_unsetMaxLevel(QualitativeSpecies * qs)
  {
    return (qs != NULL) ? qs->unsetMaxLevel() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Predicate returning @c 1 if all the required attributes for this
   * QualitativeSpecies_t object have been set.
   */
  JSBML_EXTERN
  public int QualitativeSpecies_hasRequiredAttributes(const
    QualitativeSpecies_t * qs)
  {
    return (qs != NULL) ? static_cast<int>(qs->hasRequiredAttributes()) : 0;
  }




JSBML_CPP_NAMESPACE_END


