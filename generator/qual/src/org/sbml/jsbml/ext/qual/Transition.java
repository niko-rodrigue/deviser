/*
 * $Id: Transition.java 2465 2016-06-02 14:29:07Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualTransition.java
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

#include <jsbml/packages/qual/jsbml/Transition.h>
#include <jsbml/packages/qual/jsbml/ListOfTransitions.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>
#include <jsbml/util/ElementFilter.h>



/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: 2016-06-02 14:29:07 +0400 (Thu, 02 Jun 2016) $
 */
  /**
   * Creates a new Transition using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public Transition(unsigned int level,
                     unsigned int version,
                     unsigned int pkgVersion)
    : SBase(level, version)
    , mId ("")
    , mName ("")
    , mInputs (level, version, pkgVersion)
    , mOutputs (level, version, pkgVersion)
    , mFunctionTerms (level, version, pkgVersion)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
    connectToChild();
  }


  /**
   * Creates a new Transition using the given QualPkgNamespaces object.
   */
  public Transition(QualPkgNamespaces *qualns)
    : SBase(qualns)
    , mId ("")
    , mName ("")
    , mInputs (qualns)
    , mOutputs (qualns)
    , mFunctionTerms (qualns)
  {
    setElementNamespace(qualns->getURI());
    connectToChild();
    loadPlugins(qualns);
  }


  /**
   * Copy constructor for Transition.
   */
  public Transition(const Transition& orig)
    : SBase( orig )
    , mId ( orig.mId )
    , mName ( orig.mName )
    , mInputs ( orig.mInputs )
    , mOutputs ( orig.mOutputs )
    , mFunctionTerms ( orig.mFunctionTerms )
  {
    connectToChild();
  }


  /**
   * Assignment operator for Transition.
   */
  public Transition& operator=(const Transition& rhs)
  {
    if (&rhs != this)
    {
      SBase::operator=(rhs);
      mId = rhs.mId;
      mName = rhs.mName;
      mInputs = rhs.mInputs;
      mOutputs = rhs.mOutputs;
      mFunctionTerms = rhs.mFunctionTerms;
      connectToChild();
    }

    return *this;
  }


  /**
   * Creates and returns a deep copy of this Transition object.
   */
  public Transition* clone()
  {
    return new Transition(*this);
  }


  /**
   * Destructor for Transition.
   */
  public ~Transition()
  {
  }


  /**
   * @return the value of the "id" attribute of this Transition.
   */
  public String getId()
  {
    return isSetId() ? id : "";
  }


  /**
   * @return the value of the "name" attribute of this Transition.
   */
  public String getName()
  {
    return isSetName() ? name : "";
  }


  /**
   * Predicate returning {@code true} if this Transition's "id" attribute is
   * set.
   */
  public boolean isSetId()
  {
    ;
  }


  /**
   * Predicate returning {@code true} if this Transition's "name" attribute is
   * set.
   */
  public boolean isSetName()
  {
    ;
  }


  /**
   * Sets the value of the "id" attribute of this Transition.
   */
  public void setId(String id)
  {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }


  /**
   * Sets the value of the "name" attribute of this Transition.
   */
  public void setName(String name)
  {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Unsets the value of the "id" attribute of this Transition.
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
   * Unsets the value of the "name" attribute of this Transition.
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
   * Returns the ListOfInputs from this Transition.
   */
  public const ListOfInputs* getListOfInputs()
  {
    return &mInputs;
  }


  /**
   * Returns the ListOfInputs from this Transition.
   */
  public ListOfInputs* getListOfInputs()
  {
    return &mInputs;
  }


  /**
   * Get an Input from the Transition.
   */
  public Input* getInput(unsigned int n)
  {
    return mInputs.get(n);
  }


  /**
   * Get an Input from the Transition.
   */
  public const Input* getInput(unsigned int n)
  {
    return mInputs.get(n);
  }


  /**
   * Get an Input from the Transition based on its identifier.
   */
  public Input* getInput(const std::string& sid)
  {
    return mInputs.get(sid);
  }


  /**
   * Get an Input from the Transition based on its identifier.
   */
  public const Input* getInput(const std::string& sid)
  {
    return mInputs.get(sid);
  }


  /**
   * Get an Input from the Transition based on the QualitativeSpecies to which
   * it refers.
   */
  public const Input* getInputByQualitativeSpecies(const std::string& sid)
  {
    return mInputs.getByQualitativeSpecies(sid);
  }


  /**
   * Get an Input from the Transition based on the QualitativeSpecies to which
   * it refers.
   */
  public Input* getInputByQualitativeSpecies(const std::string& sid)
  {
    return mInputs.getByQualitativeSpecies(sid);
  }


  /**
   * Adds a copy of the given Input to this Transition.
   */
  public int addInput(const Input* i)
  {
    if (i == NULL)
    {
      return LIBSBML_OPERATION_FAILED;
    }
    else if (i->hasRequiredAttributes() == false)
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else if (getLevel() != i->getLevel())
    {
      return LIBSBML_LEVEL_MISMATCH;
    }
    else if (getVersion() != i->getVersion())
    {
      return LIBSBML_VERSION_MISMATCH;
    }
    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
      SBase*>(i)) == false)
    {
      return LIBSBML_NAMESPACES_MISMATCH;
    }
    else if (i->isSetId() && (mInputs.get(i->getId())) != NULL)
    {
      return LIBSBML_DUPLICATE_OBJECT_ID;
    }
    else
    {
      mInputs.append(i);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Get the number of Input objects in this Transition.
   */
  public unsigned int getNumInputs()
  {
    return mInputs.size();
  }


  /**
   * Creates a new Input object, adds it to this Transition object and returns
   * the Input object created.
   */
  public Input* createInput()
  {
    Input* i = NULL;

    try
    {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      i = new Input(qualns);
      delete qualns;
    }
    catch (...)
    {
    }

    if (i != NULL)
    {
      mInputs.appendAndOwn(i);
    }

    return i;
  }


  /**
   * Removes the nth Input from this Transition and returns a pointer to it.
   */
  public Input* removeInput(unsigned int n)
  {
    return mInputs.remove(n);
  }


  /**
   * Removes the Input from this Transition based on its identifier and returns
   * a pointer to it.
   */
  public Input* removeInput(const std::string& sid)
  {
    return mInputs.remove(sid);
  }


  /**
   * Returns the ListOfOutputs from this Transition.
   */
  public const ListOfOutputs* getListOfOutputs()
  {
    return &mOutputs;
  }


  /**
   * Returns the ListOfOutputs from this Transition.
   */
  public ListOfOutputs* getListOfOutputs()
  {
    return &mOutputs;
  }


  /**
   * Get an Output from the Transition.
   */
  public Output* getOutput(unsigned int n)
  {
    return mOutputs.get(n);
  }


  /**
   * Get an Output from the Transition.
   */
  public const Output* getOutput(unsigned int n)
  {
    return mOutputs.get(n);
  }


  /**
   * Get an Output from the Transition based on its identifier.
   */
  public Output* getOutput(const std::string& sid)
  {
    return mOutputs.get(sid);
  }


  /**
   * Get an Output from the Transition based on its identifier.
   */
  public const Output* getOutput(const std::string& sid)
  {
    return mOutputs.get(sid);
  }


  /**
   * Get an Output from the Transition based on the QualitativeSpecies to which
   * it refers.
   */
  public const Output* getOutputByQualitativeSpecies(const std::string& sid)
  {
    return mOutputs.getByQualitativeSpecies(sid);
  }


  /**
   * Get an Output from the Transition based on the QualitativeSpecies to which
   * it refers.
   */
  public Output* getOutputByQualitativeSpecies(const std::string& sid)
  {
    return mOutputs.getByQualitativeSpecies(sid);
  }


  /**
   * Adds a copy of the given Output to this Transition.
   */
  public int addOutput(const Output* o)
  {
    if (o == NULL)
    {
      return LIBSBML_OPERATION_FAILED;
    }
    else if (o->hasRequiredAttributes() == false)
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else if (getLevel() != o->getLevel())
    {
      return LIBSBML_LEVEL_MISMATCH;
    }
    else if (getVersion() != o->getVersion())
    {
      return LIBSBML_VERSION_MISMATCH;
    }
    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
      SBase*>(o)) == false)
    {
      return LIBSBML_NAMESPACES_MISMATCH;
    }
    else if (o->isSetId() && (mOutputs.get(o->getId())) != NULL)
    {
      return LIBSBML_DUPLICATE_OBJECT_ID;
    }
    else
    {
      mOutputs.append(o);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Get the number of Output objects in this Transition.
   */
  public unsigned int getNumOutputs()
  {
    return mOutputs.size();
  }


  /**
   * Creates a new Output object, adds it to this Transition object and returns
   * the Output object created.
   */
  public Output* createOutput()
  {
    Output* o = NULL;

    try
    {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      o = new Output(qualns);
      delete qualns;
    }
    catch (...)
    {
    }

    if (o != NULL)
    {
      mOutputs.appendAndOwn(o);
    }

    return o;
  }


  /**
   * Removes the nth Output from this Transition and returns a pointer to it.
   */
  public Output* removeOutput(unsigned int n)
  {
    return mOutputs.remove(n);
  }


  /**
   * Removes the Output from this Transition based on its identifier and
   * returns a pointer to it.
   */
  public Output* removeOutput(const std::string& sid)
  {
    return mOutputs.remove(sid);
  }


  /**
   * Returns the ListOfFunctionTerms from this Transition.
   */
  public const ListOfFunctionTerms* getListOfFunctionTerms()
  {
    return &mFunctionTerms;
  }


  /**
   * Returns the ListOfFunctionTerms from this Transition.
   */
  public ListOfFunctionTerms* getListOfFunctionTerms()
  {
    return &mFunctionTerms;
  }


  /**
   * Get a FunctionTerm from the Transition.
   */
  public FunctionTerm* getFunctionTerm(unsigned int n)
  {
    return mFunctionTerms.get(n);
  }


  /**
   * Get a FunctionTerm from the Transition.
   */
  public const FunctionTerm* getFunctionTerm(unsigned int n)
  {
    return mFunctionTerms.get(n);
  }


  /**
   * Adds a copy of the given FunctionTerm to this Transition.
   */
  public int addFunctionTerm(const FunctionTerm* ft)
  {
    if (ft == NULL)
    {
      return LIBSBML_OPERATION_FAILED;
    }
    else if (ft->hasRequiredAttributes() == false)
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else if (ft->hasRequiredElements() == false)
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else if (getLevel() != ft->getLevel())
    {
      return LIBSBML_LEVEL_MISMATCH;
    }
    else if (getVersion() != ft->getVersion())
    {
      return LIBSBML_VERSION_MISMATCH;
    }
    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
      SBase*>(ft)) == false)
    {
      return LIBSBML_NAMESPACES_MISMATCH;
    }
    else
    {
      mFunctionTerms.append(ft);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Get the number of FunctionTerm objects in this Transition.
   */
  public unsigned int getNumFunctionTerms()
  {
    return mFunctionTerms.size();
  }


  /**
   * Creates a new FunctionTerm object, adds it to this Transition object and
   * returns the FunctionTerm object created.
   */
  public FunctionTerm* createFunctionTerm()
  {
    FunctionTerm* ft = NULL;

    try
    {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      ft = new FunctionTerm(qualns);
      delete qualns;
    }
    catch (...)
    {
    }

    if (ft != NULL)
    {
      mFunctionTerms.appendAndOwn(ft);
    }

    return ft;
  }


  /**
   * Removes the nth FunctionTerm from this Transition and returns a pointer to
   * it.
   */
  public FunctionTerm* removeFunctionTerm(unsigned int n)
  {
    return mFunctionTerms.remove(n);
  }


  /**
   * @return the value of the "defaultTerm" element of this Transition.
   */
  public DefaultTerm getDefaultTerm()
  {
    if (isSetDefaultTerm())
    {
      return mDefaultTerm;
    }

    throw new PropertyUndefinedError(QualConstants.mDefaultTerm, this);
  }


  /**
   * @return the value of the "defaultTerm" element of this Transition.
   */
  public DefaultTerm getDefaultTerm()
  {
    if (isSetDefaultTerm())
    {
      return mDefaultTerm;
    }

    throw new PropertyUndefinedError(QualConstants.mDefaultTerm, this);
  }


  /**
   * Predicate returning {@code true} if this Transition's "defaultTerm"
   * element is set.
   */
  public boolean isSetDefaultTerm()
  {
    return (mDefaultTerm != NULL);
  }


  /**
   * Sets the value of the "defaultTerm" element of this Transition.
   */
  public void setDefaultTerm(DefaultTerm defaultTerm)
  {
    if (mDefaultTerm == defaultTerm)
    {
      return LIBSBML_OPERATION_SUCCESS;
    }
    else if (defaultTerm == NULL)
    {
      delete mDefaultTerm;
      mDefaultTerm = NULL;
      return LIBSBML_OPERATION_SUCCESS;
    }
    else
    {
      delete mDefaultTerm;
      mDefaultTerm = (defaultTerm != NULL) ? defaultTerm->clone() : NULL;
      if (mDefaultTerm != NULL)
      {
        mDefaultTerm->connectToParent(this);
      }

      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Creates a new DefaultTerm object, adds it to this Transition object and
   * returns the DefaultTerm object created.
   */
  public DefaultTerm createDefaultTerm()
  {
  }


  /**
   * Unsets the value of the "defaultTerm" element of this Transition.
   */
  public boolean unsetDefaultTerm()
  {
    delete mDefaultTerm;
    mDefaultTerm = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Returns the XML element name of this Transition object.
   */
  public const std::string& getElementName()
  {
    static const string name = "transition";
    return name;
  }


  /**
   * Returns the libJSBML type code for this Transition object.
   */
  public int getTypeCode()
  {
    return SBML_QUAL_TRANSITION;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * Transition object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = SBase::hasRequiredAttributes();

    return allPresent;
  }


  /**
   * Predicate returning @c true if all the required elements for this
   * Transition object have been set.
   */
  public bool hasRequiredElements()
  {
    bool allPresent = SBase::hasRequiredElements();

    if (getNumFunctionTerms() == 0)
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

    if (getNumInputs() > 0)
    {
      mInputs.write(stream);
    }

    if (getNumOutputs() > 0)
    {
      mOutputs.write(stream);
    }

    if (getNumFunctionTerms() > 0)
    {
      mFunctionTerms.write(stream);
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
    v.visit(*this);

    mInputs.accept(v);

    mOutputs.accept(v);

    mFunctionTerms.accept(v);

    v.leave(*this);
    return true;
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Sets the parent SBMLDocument
   */
  public void setSBMLDocument(SBMLDocument* d)
  {
    SBase::setSBMLDocument(d);

    mInputs.setSBMLDocument(d);

    mOutputs.setSBMLDocument(d);

    mFunctionTerms.setSBMLDocument(d);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Connects to child elements
   */
  public void connectToChild()
  {
    SBase::connectToChild();

    mInputs.connectToParent(this);

    mOutputs.connectToParent(this);

    mFunctionTerms.connectToParent(this);
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

    mInputs.enablePackageInternal(pkgURI, pkgPrefix, flag);

    mOutputs.enablePackageInternal(pkgURI, pkgPrefix, flag);

    mFunctionTerms.enablePackageInternal(pkgURI, pkgPrefix, flag);
  }

  /** @endcond */


  /**
   * Returns the first child element that has the given @p id in the model-wide
   * SId namespace, or @c NULL if no such object is found.
   */
  public SBase* getElementBySId(const std::string& id)
  {
    if (id.empty())
    {
      return NULL;
    }

    SBase* obj = NULL;

    obj = mInputs.getElementBySId(id);

    if (obj != NULL)
    {
      return obj;
    }

    obj = mOutputs.getElementBySId(id);

    if (obj != NULL)
    {
      return obj;
    }

    obj = mFunctionTerms.getElementBySId(id);

    if (obj != NULL)
    {
      return obj;
    }

    return obj;
  }


  /**
   * Returns the first child element that has the given @p metaid, or @c NULL
   * if no such object is found.
   */
  public SBase* getElementByMetaId(const std::string& metaid)
  {
    if (metaid.empty())
    {
      return NULL;
    }

    SBase* obj = NULL;

    if (mInputs.getMetaId() == metaid)
    {
      return &mInputs;
    }

    if (mOutputs.getMetaId() == metaid)
    {
      return &mOutputs;
    }

    if (mFunctionTerms.getMetaId() == metaid)
    {
      return &mFunctionTerms;
    }

    obj = mInputs.getElementByMetaId(metaid);

    if (obj != NULL)
    {
      return obj;
    }

    obj = mOutputs.getElementByMetaId(metaid);

    if (obj != NULL)
    {
      return obj;
    }

    obj = mFunctionTerms.getElementByMetaId(metaid);

    if (obj != NULL)
    {
      return obj;
    }

    return obj;
  }


  /**
   * Returns a List of all child SBase objects, including those nested to an
   * arbitrary depth.
   */
  public List* getAllElements(ElementFilter* filter)
  {
    List* ret = new List();
    List* sublist = NULL;


    ADD_FILTERED_LIST(ret, sublist, mInputs, filter);
    ADD_FILTERED_LIST(ret, sublist, mOutputs, filter);
    ADD_FILTERED_LIST(ret, sublist, mFunctionTerms, filter);

    ADD_FILTERED_FROM_PLUGIN(ret, sublist, filter);

    return ret;
  }



  /** @cond doxygenJSBMLInternal */

  /**
   * Creates a new object from the next XMLToken on the XMLInputStream
   */
  public SBase* createObject(XMLInputStream& stream)
  {
    SBase* obj = SBase::createObject(stream);

    const std::string& name = stream.peek().getName();

    if (name == "listOfInputs")
    {
      if (mInputs.size() != 0)
      {
        getErrorLog()->logPackageError("qual", QualUnknownError,
          getPackageVersion(), getLevel(), getVersion());
      }

      obj = &mInputs;
    }
    else if (name == "listOfOutputs")
    {
      if (mOutputs.size() != 0)
      {
        getErrorLog()->logPackageError("qual", QualUnknownError,
          getPackageVersion(), getLevel(), getVersion());
      }

      obj = &mOutputs;
    }
    else if (name == "listOfFunctionTerms")
    {
      if (mFunctionTerms.size() != 0)
      {
        getErrorLog()->logPackageError("qual", QualUnknownError,
          getPackageVersion(), getLevel(), getVersion());
      }

      obj = &mFunctionTerms;
    }

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

    if (static_cast<ListOfTransitions*>(getParentJSBMLObject())->size() < 2)
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
        logEmptyString(mId, level, version, "<Transition>");
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
        logEmptyString(mName, level, version, "<Transition>");
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

    SBase::writeExtensionAttributes(stream);
  }

  /** @endcond */


