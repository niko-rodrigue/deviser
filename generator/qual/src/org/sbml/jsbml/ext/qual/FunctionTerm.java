/**
 * @file FunctionTerm.java
 * @brief Implementation of the FunctionTerm class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/FunctionTerm.h>
#include <jsbml/packages/qual/jsbml/ListOfFunctionTerms.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>
#include <sbml/math/MathML.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


  /**
   * Creates a new FunctionTerm using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public FunctionTerm(unsigned int level,
                       unsigned int version,
                       unsigned int pkgVersion)
    : SBase(level, version)
    , mResultLevel (JSBML_INT_MAX)
    , mIsSetResultLevel (false)
    , mMath (NULL)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
    connectToChild();
  }


  /**
   * Creates a new FunctionTerm using the given QualPkgNamespaces object.
   */
  public FunctionTerm(QualPkgNamespaces *qualns)
    : SBase(qualns)
    , mResultLevel (JSBML_INT_MAX)
    , mIsSetResultLevel (false)
    , mMath (NULL)
  {
    setElementNamespace(qualns->getURI());
    connectToChild();
    loadPlugins(qualns);
  }


  /**
   * Copy constructor for FunctionTerm.
   */
  public FunctionTerm(const FunctionTerm& orig)
    : SBase( orig )
    , mResultLevel ( orig.mResultLevel )
    , mIsSetResultLevel ( orig.mIsSetResultLevel )
    , mMath ( NULL )
  {
    if (orig.mMath != NULL)
    {
      mMath = orig.mMath->deepCopy();
    }

    connectToChild();
  }


  /**
   * Assignment operator for FunctionTerm.
   */
  public FunctionTerm& operator=(const FunctionTerm& rhs)
  {
    if (&rhs != this)
    {
      SBase::operator=(rhs);
      mResultLevel = rhs.mResultLevel;
      mIsSetResultLevel = rhs.mIsSetResultLevel;
      delete mMath;
      if (rhs.mMath != NULL)
      {
        mMath = rhs.mMath->deepCopy();
      }
      else
      {
        mMath = NULL;
      }

      connectToChild();
    }

    return *this;
  }


  /**
   * Creates and returns a deep copy of this FunctionTerm object.
   */
  public FunctionTerm* clone()
  {
    return new FunctionTerm(*this);
  }


  /**
   * Destructor for FunctionTerm.
   */
  public ~FunctionTerm()
  {
    delete mMath;
    mMath = NULL;
  }


  /**
   * @return the value of the "resultLevel" attribute of this FunctionTerm.
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
   * Predicate returning {@code true} if this FunctionTerm's "resultLevel"
   * attribute is set.
   */
  public boolean isSetResultLevel()
  {
    return mResultLevel != null;
  }


  /**
   * Sets the value of the "resultLevel" attribute of this FunctionTerm.
   */
  public void setResultLevel(int resultLevel)
  {
    Integer oldmResultLevel = this.mResultLevel;

    this.oldmResultLevel = resultLevel;

    firePropertyChange(QualConstants.mResultLevel, oldmResultLevel,
      this.oldmResultLevel);
  }


  /**
   * Unsets the value of the "resultLevel" attribute of this FunctionTerm.
   */
  public int unsetResultLevel()
  {
    mResultLevel = JSBML_INT_MAX;
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


  /**
   * @return the value of the "math" element of this FunctionTerm.
   */
  public ASTNode getMath()
  {
    if (isSetMath())
    {
      return mMath;
    }

    throw new PropertyUndefinedError(QualConstants.mMath, this);
  }


  /**
   * @return the value of the "math" element of this FunctionTerm.
   */
  public ASTNode getMath()
  {
    if (isSetMath())
    {
      return mMath;
    }

    throw new PropertyUndefinedError(QualConstants.mMath, this);
  }


  /**
   * Predicate returning {@code true} if this FunctionTerm's "math" element is
   * set.
   */
  public boolean isSetMath()
  {
    return (mMath != NULL);
  }


  /**
   * Sets the value of the "math" element of this FunctionTerm.
   */
  public void setMath(ASTNode math)
  {
    if (mMath == math)
    {
      return LIBSBML_OPERATION_SUCCESS;
    }
    else if (math == NULL)
    {
      delete mMath;
      mMath = NULL;
      return LIBSBML_OPERATION_SUCCESS;
    }
    else if (!(math->isWellFormedASTNode()))
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else
    {
      delete mMath;
      mMath = (math != NULL) ? math->deepCopy() : NULL;
      if (mMath != NULL)
      {
        mMath->setParentJSBMLObject(this);
      }

      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Unsets the value of the "math" element of this FunctionTerm.
   */
  public int unsetMath()
  {
    delete mMath;
    mMath = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * @copydoc doc_renamesidref_common
   */
  public void renameSIdRefs(const std::string& oldid, const std::string& newid)
  {
    if (isSetMath())
    {
      mMath->renameSIdRefs(oldid, newid);
    }
  }


  /**
   * Returns the XML element name of this FunctionTerm object.
   */
  public const std::string& getElementName()
  {
    static const string name = "functionTerm";
    return name;
  }


  /**
   * Returns the libJSBML type code for this FunctionTerm object.
   */
  public int getTypeCode()
  {
    return SBML_QUAL_FUNCTION_TERM;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * FunctionTerm object have been set.
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


  /**
   * Predicate returning @c true if all the required elements for this
   * FunctionTerm object have been set.
   */
  public bool hasRequiredElements()
  {
    bool allPresent = SBase::hasRequiredElements();

    if (isSetMath() == false)
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

    if (isSetMath() == true)
    {
      writeMathML(getMath(), stream, getSBMLNamespaces());
    }

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
   * Connects to child elements
   */
  public void connectToChild()
  {
    SBase::connectToChild();
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

    if (static_cast<ListOfFunctionTerms*>(getParentJSBMLObject())->size() < 2)
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
          "<FunctionTerm> element must be an integer.";
        log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
          message);
      }
      else
      {
        std::string message = "Qual attribute 'resultLevel' is missing from the "
          "<FunctionTerm> element.";
        log->logPackageError("qual", QualUnknown, pkgVersion, level, version,
          message);
      }
    }
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Reads other XML such as math/notes etc.
   */
  public bool readOtherXML(XMLInputStream& stream)
  {
    bool read = false;
    const string& name = stream.peek().getName();

    if (name == "math")
    {
      const XMLToken elem = stream.peek();
      const std::string prefix = checkMathMLNamespace(elem);
      if (stream.getSBMLNamespaces() == NULL)
      {
        stream.setSBMLNamespaces(new SBMLNamespaces(getLevel(), getVersion()));
      }

      delete mMath;
      mMath = readMathML(stream, prefix);
      read = true;
    }

    if (SBase::readOtherXML(stream))
    {
      read = true;
    }

    return read;
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
   * Creates a new FunctionTerm_t using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  JSBML_EXTERN
  public FunctionTerm_t * FunctionTerm_create(unsigned int level,
                                              unsigned int version,
                                              unsigned int pkgVersion)
  {
    return new FunctionTerm(level, version, pkgVersion);
  }


  /**
   * Creates and returns a deep copy of this FunctionTerm_t object.
   */
  JSBML_EXTERN
  public FunctionTerm_t* FunctionTerm_clone(const FunctionTerm_t* ft)
  {
    if (ft != NULL)
    {
      return static_cast<FunctionTerm_t*>(ft->clone());
    }
    else
    {
      return NULL;
    }
  }


  /**
   * Frees this FunctionTerm_t object.
   */
  JSBML_EXTERN
  public void FunctionTerm_free(FunctionTerm_t* ft)
  {
    if (ft != NULL)
    {
      delete ft;
    }
  }


  /**
   * @return the value of the "resultLevel" attribute of this FunctionTerm.
   */
  JSBML_EXTERN
  public int FunctionTerm_getResultLevel(const FunctionTerm * ft)
  {
    return (ft != NULL) ? ft->getResultLevel() : JSBML_INT_MAX;
  }


  /**
   * Predicate returning @c 1 if this FunctionTerm's "resultLevel" attribute is
   * set.
   */
  JSBML_EXTERN
  public int FunctionTerm_isSetResultLevel(const FunctionTerm * ft)
  {
    return (ft != NULL) ? static_cast<int>(ft->isSetResultLevel()) : 0;
  }


  /**
   * Sets the value of the "resultLevel" attribute of this FunctionTerm.
   */
  JSBML_EXTERN
  public void FunctionTerm_setResultLevel(FunctionTerm * ft, int resultLevel)
  {
    return (ft != NULL) ? ft->setResultLevel(resultLevel) :
      LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "resultLevel" attribute of this FunctionTerm.
   */
  JSBML_EXTERN
  public int FunctionTerm_unsetResultLevel(FunctionTerm * ft)
  {
    return (ft != NULL) ? ft->unsetResultLevel() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * @return the value of the "math" element of this FunctionTerm.
   */
  JSBML_EXTERN
  public const ASTNode FunctionTerm_getMath(const FunctionTerm * ft)
  {
    if (ft == NULL)
    {
      return NULL;
    }

    return (ASTNode)(ft->getMath());
  }


  /**
   * Predicate returning @c 1 if this FunctionTerm's "math" element is set.
   */
  JSBML_EXTERN
  public int FunctionTerm_isSetMath(const FunctionTerm * ft)
  {
    return (ft != NULL) ? static_cast<int>(ft->isSetMath()) : 0;
  }


  /**
   * Sets the value of the "math" element of this FunctionTerm.
   */
  JSBML_EXTERN
  public void FunctionTerm_setMath(FunctionTerm * ft, ASTNode math)
  {
    return (ft != NULL) ? ft->setMath(math) : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Unsets the value of the "math" element of this FunctionTerm.
   */
  JSBML_EXTERN
  public int FunctionTerm_unsetMath(FunctionTerm * ft)
  {
    return (ft != NULL) ? ft->unsetMath() : LIBJSBML_INVALID_OBJECT;
  }


  /**
   * Predicate returning @c 1 if all the required attributes for this
   * FunctionTerm_t object have been set.
   */
  JSBML_EXTERN
  public int FunctionTerm_hasRequiredAttributes(const FunctionTerm_t * ft)
  {
    return (ft != NULL) ? static_cast<int>(ft->hasRequiredAttributes()) : 0;
  }


  /**
   * Predicate returning @c 1 if all the required elements for this
   * FunctionTerm_t object have been set.
   */
  JSBML_EXTERN
  public int FunctionTerm_hasRequiredElements(const FunctionTerm_t * ft)
  {
    return (ft != NULL) ? static_cast<int>(ft->hasRequiredElements()) : 0;
  }




JSBML_CPP_NAMESPACE_END


