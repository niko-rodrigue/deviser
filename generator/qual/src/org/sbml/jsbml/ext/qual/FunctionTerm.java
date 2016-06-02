/*
 * $Id: FunctionTerm.java 2465 2016-06-02 14:29:07Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualFunctionTerm.java
 * $
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2016 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 5. The Babraham Institute, Cambridge, UK
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published b
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.ext.qual

#include <jsbml/packages/qual/jsbml/FunctionTerm.h>
#include <jsbml/packages/qual/jsbml/ListOfFunctionTerms.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>
#include <sbml/math/MathML.h>



/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: 2016-06-02 14:29:07 +0400 (Thu, 02 Jun 2016) $
 */
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
  public boolean unsetMath()
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


