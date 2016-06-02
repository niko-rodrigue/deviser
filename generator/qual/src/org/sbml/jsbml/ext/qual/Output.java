/*
 * $Id: Output.java 2465 2016-06-02 14:29:07Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualOutput.java
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

#include <jsbml/packages/qual/jsbml/Output.h>
#include <jsbml/packages/qual/jsbml/ListOfOutputs.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>



/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: 2016-06-02 14:29:07 +0400 (Thu, 02 Jun 2016) $
 */
  /**
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


  /**
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


  /**
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


  /**
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


  /**
   * Creates and returns a deep copy of this Output object.
   */
  public Output* clone()
  {
    return new Output(*this);
  }


  /**
   * Destructor for Output.
   */
  public ~Output()
  {
  }


  /**
   * @return the value of the "id" attribute of this Output.
   */
  public String getId()
  {
    return isSetId() ? id : "";
  }


  /**
   * @return the value of the "qualitativeSpecies" attribute of this Output.
   */
  public String getQualitativeSpecies()
  {
    return isSetQualitativeSpecies() ? qualitativeSpecies : "";
  }


  /**
   * @return the value of the "transitionEffect" attribute of this Output.
   */
  public TransitionOutputEffect getTransitionEffect()
  {
    if (isSetTransitionEffect())
    {
      return mTransitionEffect;
    }

    throw new PropertyUndefinedError(QualConstants.mTransitionEffect, this);
  }


  /**
   * @return the value of the "name" attribute of this Output.
   */
  public String getName()
  {
    return isSetName() ? name : "";
  }


  /**
   * @return the value of the "outputLevel" attribute of this Output.
   */
  public int getOutputLevel()
  {
    if (isSetOutputLevel())
    {
      return mOutputLevel.intValue();
    }

    throw new PropertyUndefinedError(QualConstants.mOutputLevel, this);
  }


  /**
   * Predicate returning {@code true} if this Output's "id" attribute is set.
   */
  public boolean isSetId()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Output's "qualitativeSpecies"
   * attribute is set.
   */
  public boolean isSetQualitativeSpecies()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Output's "transitionEffect"
   * attribute is set.
   */
  public boolean isSetTransitionEffect()
  {
    return (mTransitionEffect != TRANSITION_OUTPUT_EFFECT_INVALID);
  }


  /**
   * Predicate returning {@code true} if this Output's "name" attribute is set.
   */
  public boolean isSetName()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Output's "outputLevel" attribute
   * is set.
   */
  public boolean isSetOutputLevel()
  {
    return mOutputLevel != null;
  }


  /**
   * Sets the value of the "id" attribute of this Output.
   */
  public void setId(String id)
  {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }


  /**
   * Sets the value of the "qualitativeSpecies" attribute of this Output.
   */
  public boolean setQualitativeSpecies(String qualitativeSpecies)
  {
    if (qualitativeSpecies != this.mQualitativeSpecies)
    {
      String oldmQualitativeSpecies = this.mQualitativeSpecies;
      if ((qualitativeSpecies == null) || (qualitativeSpecies.length() == 0)
      {
        this.mQualitativeSpecies = null;
      }
      else
      {
        this.mQualitativeSpecies = qualitativeSpecies;
      }

      firePropertyChange(QualConstants.mQualitativeSpecies,
        oldmQualitativeSpecies, this.oldmQualitativeSpecies);
      return true;
    }

    return false;
  }


  /**
   * Sets the value of the "transitionEffect" attribute of this Output.
   */
  public void setTransitionEffect(TransitionOutputEffect transitionEffect)
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


  /**
   * Sets the value of the "name" attribute of this Output.
   */
  public void setName(String name)
  {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Sets the value of the "outputLevel" attribute of this Output.
   */
  public void setOutputLevel(int outputLevel)
  {
    Integer oldmOutputLevel = this.mOutputLevel;

    this.oldmOutputLevel = outputLevel;

    firePropertyChange(QualConstants.mOutputLevel, oldmOutputLevel,
      this.oldmOutputLevel);
  }


  /**
   * Unsets the value of the "id" attribute of this Output.
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
   * Unsets the value of the "qualitativeSpecies" attribute of this Output.
   */
  public boolean unsetQualitativeSpecies()
  {
    if (isSetQualitativeSpecies())
    {
      mQualitativeSpecies = null;
      return true;
    }
    else
    {
      return false;
    }
  }


  /**
   * Unsets the value of the "transitionEffect" attribute of this Output.
   */
  public boolean unsetTransitionEffect()
  {
    mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Unsets the value of the "name" attribute of this Output.
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
   * Unsets the value of the "outputLevel" attribute of this Output.
   */
  public boolean unsetOutputLevel()
  {
    if (isSetOutputLevel())
    {
      Integer oldmOutputLevel = mOutputLevel;
      mOutputLevel = null;
      firePropertyChange(QualConstants.mOutputLevel, oldmOutputLevel,
        mOutputLevel);
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
   * Returns the XML element name of this Output object.
   */
  public const std::string& getElementName()
  {
    static const string name = "output";
    return name;
  }


  /**
   * Returns the libJSBML type code for this Output object.
   */
  public int getTypeCode()
  {
    return SBML_QUAL_OUTPUT;
  }


  /**
   * Predicate returning @c true if all the required attributes for this Output
   * object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = SBase::hasRequiredAttributes();

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

    attributes.add("qualitativeSpecies");

    attributes.add("transitionEffect");

    attributes.add("name");

    attributes.add("outputLevel");
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
        logError(QualIdSyntaxRule, level, version, "The id '" + mId + "' does "
          "not conform to the syntax.");
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
          version, "The attribute qualitativeSpecies='" + mQualitativeSpecies +
            "' does not conform to the syntax.");
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


