/*
 * $Id: QualitativeSpecies.java 2465 2016-06-02 14:29:07Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualQualitativeSpecies.java
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

#include <jsbml/packages/qual/jsbml/QualitativeSpecies.h>
#include <jsbml/packages/qual/jsbml/ListOfQualitativeSpecies.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>



/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: 2016-06-02 14:29:07 +0400 (Thu, 02 Jun 2016) $
 */
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
  public boolean setCompartment(String compartment)
  {
    if (compartment != this.mCompartment)
    {
      String oldmCompartment = this.mCompartment;
      if ((compartment == null) || (compartment.length() == 0)
      {
        this.mCompartment = null;
      }
      else
      {
        this.mCompartment = compartment;
      }

      firePropertyChange(QualConstants.mCompartment, oldmCompartment,
        this.oldmCompartment);
      return true;
    }

    return false;
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
    if (isSetId())
    {
      mId = null;
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Unsets the value of the "name" attribute of this QualitativeSpecies.
   */
  public boolean unsetName()
  {
    if (isSetName())
    {
      mName = null;
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetCompartment()
  {
    if (isSetCompartment())
    {
      mCompartment = null;
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Unsets the value of the "constant" attribute of this QualitativeSpecies.
   */
  public boolean unsetConstant()
  {
    if (isSetConstant())
    {
      Boolean oldmConstant = mConstant;
      mConstant = null;
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
    if (isSetInitialLevel())
    {
      Integer oldmInitialLevel = mInitialLevel;
      mInitialLevel = null;
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
    if (isSetMaxLevel())
    {
      Integer oldmMaxLevel = mMaxLevel;
      mMaxLevel = null;
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


