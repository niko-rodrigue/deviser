/*
 * $Id: ListOfTransitions.java 2465 2016-06-02 13:40:03Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualListOfTransitions.java
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

#include <jsbml/packages/qual/jsbml/ListOfTransitions.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;

  /**
   * Creates a new ListOfTransitions using the given JSBML Level, Version and
   * &ldquo;qual&rdquo; package version.
   */
  public ListOfTransitions(unsigned int level,
                            unsigned int version,
                            unsigned int pkgVersion)
    : ListOf(level, version)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
  }


  /**
   * Creates a new ListOfTransitions using the given QualPkgNamespaces object.
   */
  public ListOfTransitions(QualPkgNamespaces *qualns)
    : ListOf(qualns)
  {
    setElementNamespace(qualns->getURI());
  }


  /**
   * Copy constructor for ListOfTransitions.
   */
  public ListOfTransitions(const ListOfTransitions& orig)
    : ListOf( orig )
  {
  }


  /**
   * Assignment operator for ListOfTransitions.
   */
  public ListOfTransitions& operator=(const ListOfTransitions& rhs)
  {
    if (&rhs != this)
    {
      ListOf::operator=(rhs);
    }

    return *this;
  }


  /**
   * Creates and returns a deep copy of this ListOfTransitions object.
   */
  public ListOfTransitions* clone()
  {
    return new ListOfTransitions(*this);
  }


  /**
   * Destructor for ListOfTransitions.
   */
  public ~ListOfTransitions()
  {
  }


  /**
   * Get a Transition from the ListOfTransitions.
   */
  public Transition* get(unsigned int n)
  {
    return static_cast<Transition*>(ListOf::get(n));
  }


  /**
   * Get a Transition from the ListOfTransitions.
   */
  public const Transition* get(unsigned int n)
  {
    return static_cast<const Transition*>(ListOf::get(n));
  }


  /**
   * Get a Transition from the ListOfTransitions based on its identifier.
   */
  public Transition* get(const std::string& sid)
  {
    return const_cast<Transition*>(static_cast<const
      ListOfTransitions&>(*this).get(sid));
  }


  /**
   * Get a Transition from the ListOfTransitions based on its identifier.
   */
  public const Transition* get(const std::string& sid)
  {
    vector<SBase*>::const_iterator result;
    result = find_if(mItems.begin(), mItems.end(), IdEq<Transition>(sid));
    return (result == mItems.end()) ? 0 : static_cast <const Transition*>
      (*result);
  }


  /**
   * Removes the nth Transition from this ListOfTransitions and returns a
   * pointer to it.
   */
  public Transition* remove(unsigned int n)
  {
    return static_cast<Transition*>(ListOf::remove(n));
  }


  /**
   * Removes the Transition from this ListOfTransitions based on its identifier
   * and returns a pointer to it.
   */
  public Transition* remove(const std::string& sid)
  {
    SBase* item = NULL;
    vector<SBase*>::iterator result;

    result = find_if(mItems.begin(), mItems.end(), IdEq<Transition>(sid));

    if (result != mItems.end())
    {
      item = *result;
      mItems.erase(result);
    }

    return static_cast <Transition*> (item);
  }


  /**
   * Adds a copy of the given Transition to this ListOfTransitions.
   */
  public int addTransition(const Transition* t)
  {
    if (t == NULL)
    {
      return LIBSBML_OPERATION_FAILED;
    }
    else if (t->hasRequiredAttributes() == false)
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else if (getLevel() != t->getLevel())
    {
      return LIBSBML_LEVEL_MISMATCH;
    }
    else if (getVersion() != t->getVersion())
    {
      return LIBSBML_VERSION_MISMATCH;
    }
    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
      SBase*>(t)) == false)
    {
      return LIBSBML_NAMESPACES_MISMATCH;
    }
    else
    {
      append(t);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Get the number of Transition objects in this ListOfTransitions.
   */
  public unsigned int getNumTransitions()
  {
    return size();
  }


  /**
   * Creates a new Transition object, adds it to this ListOfTransitions object
   * and returns the Transition object created.
   */
  public Transition* createTransition()
  {
    Transition* t = NULL;

    try
    {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      t = new Transition(qualns);
      delete qualns;
    }
    catch (...)
    {
    }

    if (t != NULL)
    {
      appendAndOwn(t);
    }

    return t;
  }


  /**
   * Returns the XML element name of this ListOfTransitions object.
   */
  public const std::string& getElementName()
  {
    static const string name = "listOfTransitions";
    return name;
  }


  /**
   * Returns the libJSBML type code for this ListOfTransitions object.
   */
  public int getTypeCode()
  {
    return JSBML_LIST_OF;
  }


  /**
   * Returns the libJSBML type code for the JSBML objects contained in this
   * ListOfTransitions object.
   */
  public int getItemTypeCode()
  {
    return SBML_QUAL_TRANSITION;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * ListOfTransitions object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = ListOf::hasRequiredAttributes();

    return allPresent;
  }



  /** @cond doxygenJSBMLInternal */

  /**
   * Creates a new Transition in this ListOfTransitions
   */
  public SBase* createObject(XMLInputStream& stream)
  {
    const std::string& name = stream.peek().getName();
    SBase* object = NULL;
    QUAL_CREATE_NS(qualns, getSBMLNamespaces());

    if (name == "transition")
    {
      object = new Transition(qualns);
      appendAndOwn(object);
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


