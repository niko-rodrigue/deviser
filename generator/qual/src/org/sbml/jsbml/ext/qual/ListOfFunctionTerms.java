/*
 * $Id: ListOfFunctionTerms.java 2465 2016-06-02 14:29:07Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualListOfFunctionTerms.java
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
   * Creates a new ListOfFunctionTerms using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public ListOfFunctionTerms(unsigned int level,
                              unsigned int version,
                              unsigned int pkgVersion)
    : ListOf(level, version)
    , mDefaultTerm (NULL)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
    connectToChild();
  }


  /**
   * Creates a new ListOfFunctionTerms using the given QualPkgNamespaces
   * object.
   */
  public ListOfFunctionTerms(QualPkgNamespaces *qualns)
    : ListOf(qualns)
    , mDefaultTerm (NULL)
  {
    setElementNamespace(qualns->getURI());
    connectToChild();
  }


  /**
   * Copy constructor for ListOfFunctionTerms.
   */
  public ListOfFunctionTerms(const ListOfFunctionTerms& orig)
    : ListOf( orig )
    , mDefaultTerm ( NULL )
  {
    if (orig.mDefaultTerm != NULL)
    {
      mDefaultTerm = orig.mDefaultTerm->clone();
    }

    connectToChild();
  }


  /**
   * Assignment operator for ListOfFunctionTerms.
   */
  public ListOfFunctionTerms& operator=(const ListOfFunctionTerms& rhs)
  {
    if (&rhs != this)
    {
      ListOf::operator=(rhs);
      delete mDefaultTerm;
      if (rhs.mDefaultTerm != NULL)
      {
        mDefaultTerm = rhs.mDefaultTerm->clone();
      }
      else
      {
        mDefaultTerm = NULL;
      }

      connectToChild();
    }

    return *this;
  }


  /**
   * Creates and returns a deep copy of this ListOfFunctionTerms object.
   */
  public ListOfFunctionTerms* clone()
  {
    return new ListOfFunctionTerms(*this);
  }


  /**
   * Destructor for ListOfFunctionTerms.
   */
  public ~ListOfFunctionTerms()
  {
    delete mDefaultTerm;
    mDefaultTerm = NULL;
  }


  /**
   * @return the value of the "defaultTerm" element of this
   * ListOfFunctionTerms.
   */
  public DefaultTerm* getDefaultTerm()
  {
    if (isSetDefaultTerm())
    {
      return mDefaultTerm;
    }

    throw new PropertyUndefinedError(QualConstants.mDefaultTerm, this);
  }


  /**
   * @return the value of the "defaultTerm" element of this
   * ListOfFunctionTerms.
   */
  public DefaultTerm* getDefaultTerm()
  {
    if (isSetDefaultTerm())
    {
      return mDefaultTerm;
    }

    throw new PropertyUndefinedError(QualConstants.mDefaultTerm, this);
  }


  /**
   * Predicate returning {@code true} if this ListOfFunctionTerms's
   * "defaultTerm" element is set.
   */
  public boolean isSetDefaultTerm()
  {
    return (mDefaultTerm != NULL);
  }


  /**
   * Sets the value of the "defaultTerm" element of this ListOfFunctionTerms.
   */
  public void setDefaultTerm(DefaultTerm* defaultTerm)
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
   * Creates a new DefaultTerm object, adds it to this ListOfFunctionTerms
   * object and returns the DefaultTerm object created.
   */
  public DefaultTerm* createDefaultTerm()
  {
    if (mDefaultTerm != NULL)
    {
      delete mDefaultTerm;
    }

    QUAL_CREATE_NS(qualns, getSBMLNamespaces());
    mDefaultTerm = new DefaultTerm(qualns);

    delete qualns;

    connectToChild();

    return mDefaultTerm;
  }


  /**
   * Unsets the value of the "defaultTerm" element of this ListOfFunctionTerms.
   */
  public boolean unsetDefaultTerm()
  {
    delete mDefaultTerm;
    mDefaultTerm = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Get a FunctionTerm from the ListOfFunctionTerms.
   */
  public FunctionTerm* get(unsigned int n)
  {
    return static_cast<FunctionTerm*>(ListOf::get(n));
  }


  /**
   * Get a FunctionTerm from the ListOfFunctionTerms.
   */
  public const FunctionTerm* get(unsigned int n)
  {
    return static_cast<const FunctionTerm*>(ListOf::get(n));
  }


  /**
   * Get a FunctionTerm from the ListOfFunctionTerms based on its identifier.
   */
  public FunctionTerm* get(const std::string& sid)
  {
    return const_cast<FunctionTerm*>(static_cast<const
      ListOfFunctionTerms&>(*this).get(sid));
  }


  /**
   * Get a FunctionTerm from the ListOfFunctionTerms based on its identifier.
   */
  public const FunctionTerm* get(const std::string& sid)
  {
    vector<SBase*>::const_iterator result;
    result = find_if(mItems.begin(), mItems.end(), IdEq<FunctionTerm>(sid));
    return (result == mItems.end()) ? 0 : static_cast <const FunctionTerm*>
      (*result);
  }


  /**
   * Removes the nth FunctionTerm from this ListOfFunctionTerms and returns a
   * pointer to it.
   */
  public FunctionTerm* remove(unsigned int n)
  {
    return static_cast<FunctionTerm*>(ListOf::remove(n));
  }


  /**
   * Removes the FunctionTerm from this ListOfFunctionTerms based on its
   * identifier and returns a pointer to it.
   */
  public FunctionTerm* remove(const std::string& sid)
  {
    SBase* item = NULL;
    vector<SBase*>::iterator result;

    result = find_if(mItems.begin(), mItems.end(), IdEq<FunctionTerm>(sid));

    if (result != mItems.end())
    {
      item = *result;
      mItems.erase(result);
    }

    return static_cast <FunctionTerm*> (item);
  }


  /**
   * Adds a copy of the given FunctionTerm to this ListOfFunctionTerms.
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
      append(ft);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Get the number of FunctionTerm objects in this ListOfFunctionTerms.
   */
  public unsigned int getNumFunctionTerms()
  {
    return size();
  }


  /**
   * Creates a new FunctionTerm object, adds it to this ListOfFunctionTerms
   * object and returns the FunctionTerm object created.
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
      appendAndOwn(ft);
    }

    return ft;
  }


  /**
   * Returns the XML element name of this ListOfFunctionTerms object.
   */
  public const std::string& getElementName()
  {
    static const string name = "listOfFunctionTerms";
    return name;
  }


  /**
   * Returns the libJSBML type code for this ListOfFunctionTerms object.
   */
  public int getTypeCode()
  {
    return JSBML_LIST_OF;
  }


  /**
   * Returns the libJSBML type code for the JSBML objects contained in this
   * ListOfFunctionTerms object.
   */
  public int getItemTypeCode()
  {
    return SBML_QUAL_FUNCTION_TERM;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * ListOfFunctionTerms object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = ListOf::hasRequiredAttributes();

    return allPresent;
  }


  /**
   * Predicate returning @c true if all the required elements for this
   * ListOfFunctionTerms object have been set.
   */
  public bool hasRequiredElements()
  {
    bool allPresent = ListOf::hasRequiredElements();

    if (isSetDefaultTerm() == false)
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
    ListOf::writeElements(stream);

    if (isSetDefaultTerm() == true)
    {
      mDefaultTerm->write(stream);
    }

    SBase::writeExtensionElements(stream);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Connects to child elements
   */
  public void connectToChild()
  {
    ListOf::connectToChild();

    if (mDefaultTerm != NULL)
    {
      mDefaultTerm->connectToParent(this);
    }
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

    if (mDefaultTerm != NULL)
    {
      if (mDefaultTerm->getId() == id)
      {
        return mDefaultTerm;
      }

      obj = mDefaultTerm->getElementBySId(id);
      if (obj != NULL)
      {
        return obj;
      }
    }

    return ListOf::getElementBySId(id);
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

    if (mDefaultTerm != NULL)
    {
      if (mDefaultTerm->getMetaId() == metaid)
      {
        return mDefaultTerm;
      }

      obj = mDefaultTerm->getElementByMetaId(metaid);
      if (obj != NULL)
      {
        return obj;
      }
    }

    return ListOf::getElementByMetaId(metaid);
  }


  /**
   * Returns a List of all child SBase objects, including those nested to an
   * arbitrary depth.
   */
  public List* getAllElements(ElementFilter* filter)
  {
    List* ret = new List();
    List* sublist = ListOf::getAllElements(filter);

    ADD_FILTERED_POINTER(ret, sublist, mDefaultTerm, filter);


    ADD_FILTERED_FROM_PLUGIN(ret, sublist, filter);

    return ret;
  }



  /** @cond doxygenJSBMLInternal */

  /**
   * Creates a new FunctionTerm in this ListOfFunctionTerms
   */
  public SBase* createObject(XMLInputStream& stream)
  {
    const std::string& name = stream.peek().getName();
    SBase* object = NULL;
    QUAL_CREATE_NS(qualns, getSBMLNamespaces());

    if (name == "functionTerm")
    {
      object = new FunctionTerm(qualns);
      appendAndOwn(object);
    }

    if (name == "defaultTerm")
    {
      DefaultTerm newDT(qualns);
      setDefaultTerm(&newDT);
      object = getDefaultTerm();
    }

    delete qualns;
    return object;
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Adds the expected attributes for this element
   */
  public void addExpectedAttributes(ExpectedAttributes& attributes)
  {
    ListOf::addExpectedAttributes(attributes);
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

    ListOf::readAttributes(attributes, expectedAttributes);
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
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Writes the attributes to the stream
   */
  public void writeAttributes(XMLOutputStream& stream)
  {
    ListOf::writeAttributes(stream);

    SBase::writeExtensionAttributes(stream);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Writes the namespace for the Qual package
   */
  public void writeXMLNS(XMLOutputStream& stream)
  {
    XMLNamespaces xmlns;
    std::string prefix = getPrefix();

    if (prefix.empty())
    {
      const XMLNamespaces* thisxmlns = getNamespaces();
      if (thisxmlns && thisxmlns->hasURI(QualExtension::getXmlnsL3V1V1()))
      {
        xmlns.add(QualExtension::getXmlnsL3V1V1(), prefix);
      }
    }

    stream << xmlns;
  }

  /** @endcond */


