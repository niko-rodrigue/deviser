/*
 * $Id: ListOfQualitativeSpecies.java 2465 2016-06-02 14:29:07Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualListOfQualitativeSpecies.java
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

#include <jsbml/packages/qual/jsbml/ListOfQualitativeSpecies.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>



/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: 2016-06-02 14:29:07 +0400 (Thu, 02 Jun 2016) $
 */
  /**
   * Creates a new ListOfQualitativeSpecies using the given JSBML Level,
   * Version and &ldquo;qual&rdquo; package version.
   */
  public ListOfQualitativeSpecies(unsigned int level,
                                   unsigned int version,
                                   unsigned int pkgVersion)
    : ListOf(level, version)
  {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
  }


  /**
   * Creates a new ListOfQualitativeSpecies using the given QualPkgNamespaces
   * object.
   */
  public ListOfQualitativeSpecies(QualPkgNamespaces *qualns)
    : ListOf(qualns)
  {
    setElementNamespace(qualns->getURI());
  }


  /**
   * Copy constructor for ListOfQualitativeSpecies.
   */
  public ListOfQualitativeSpecies(const ListOfQualitativeSpecies& orig)
    : ListOf( orig )
  {
  }


  /**
   * Assignment operator for ListOfQualitativeSpecies.
   */
  public ListOfQualitativeSpecies& operator=(const ListOfQualitativeSpecies&
    rhs)
  {
    if (&rhs != this)
    {
      ListOf::operator=(rhs);
    }

    return *this;
  }


  /**
   * Creates and returns a deep copy of this ListOfQualitativeSpecies object.
   */
  public ListOfQualitativeSpecies* clone()
  {
    return new ListOfQualitativeSpecies(*this);
  }


  /**
   * Destructor for ListOfQualitativeSpecies.
   */
  public ~ListOfQualitativeSpecies()
  {
  }


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
   */
  public QualitativeSpecies* get(unsigned int n)
  {
    return static_cast<QualitativeSpecies*>(ListOf::get(n));
  }


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
   */
  public const QualitativeSpecies* get(unsigned int n)
  {
    return static_cast<const QualitativeSpecies*>(ListOf::get(n));
  }


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
   * identifier.
   */
  public QualitativeSpecies* get(const std::string& sid)
  {
    return const_cast<QualitativeSpecies*>(static_cast<const
      ListOfQualitativeSpecies&>(*this).get(sid));
  }


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
   * identifier.
   */
  public const QualitativeSpecies* get(const std::string& sid)
  {
    vector<SBase*>::const_iterator result;
    result = find_if(mItems.begin(), mItems.end(),
      IdEq<QualitativeSpecies>(sid));
    return (result == mItems.end()) ? 0 : static_cast <const
      QualitativeSpecies*> (*result);
  }


  /**
   * Removes the nth QualitativeSpecies from this ListOfQualitativeSpecies and
   * returns a pointer to it.
   */
  public QualitativeSpecies* remove(unsigned int n)
  {
    return static_cast<QualitativeSpecies*>(ListOf::remove(n));
  }


  /**
   * Removes the QualitativeSpecies from this ListOfQualitativeSpecies based on
   * its identifier and returns a pointer to it.
   */
  public QualitativeSpecies* remove(const std::string& sid)
  {
    SBase* item = NULL;
    vector<SBase*>::iterator result;

    result = find_if(mItems.begin(), mItems.end(),
      IdEq<QualitativeSpecies>(sid));

    if (result != mItems.end())
    {
      item = *result;
      mItems.erase(result);
    }

    return static_cast <QualitativeSpecies*> (item);
  }


  /**
   * Adds a copy of the given QualitativeSpecies to this
   * ListOfQualitativeSpecies.
   */
  public int addQualitativeSpecies(const QualitativeSpecies* qs)
  {
    if (qs == NULL)
    {
      return LIBSBML_OPERATION_FAILED;
    }
    else if (qs->hasRequiredAttributes() == false)
    {
      return LIBSBML_INVALID_OBJECT;
    }
    else if (getLevel() != qs->getLevel())
    {
      return LIBSBML_LEVEL_MISMATCH;
    }
    else if (getVersion() != qs->getVersion())
    {
      return LIBSBML_VERSION_MISMATCH;
    }
    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const
      SBase*>(qs)) == false)
    {
      return LIBSBML_NAMESPACES_MISMATCH;
    }
    else
    {
      append(qs);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }


  /**
   * Get the number of QualitativeSpecies objects in this
   * ListOfQualitativeSpecies.
   */
  public unsigned int getNumQualitativeSpecies()
  {
    return size();
  }


  /**
   * Creates a new QualitativeSpecies object, adds it to this
   * ListOfQualitativeSpecies object and returns the QualitativeSpecies object
   * created.
   */
  public QualitativeSpecies* createQualitativeSpecies()
  {
    QualitativeSpecies* qs = NULL;

    try
    {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      qs = new QualitativeSpecies(qualns);
      delete qualns;
    }
    catch (...)
    {
    }

    if (qs != NULL)
    {
      appendAndOwn(qs);
    }

    return qs;
  }


/**
 * Used by ListOfQualitativeSpecies::get() to lookup a QualitativeSpecies based
 * on its Compartment.
 */
struct IdEqC : public std::unary_function<SBase*, bool>
{
  const string& id;
   
  IdEqC (const string& id) : id(id) { }
  bool operator() (SBase* sb)
  {
  return (static_cast<QualitativeSpecies*>(sb)->getCompartment() == id);
  }
};


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
   * Compartment to which it refers.
   */
  public const QualitativeSpecies* getByCompartment(const std::string& sid)
  {
    vector<SBase*>::const_iterator result;
    result = find_if(mItems.begin(), mItems.end(), IdEqC(sid));
    return (result == mItems.end()) ? 0 : static_cast <const
      QualitativeSpecies*> (*result);
  }


  /**
   * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
   * Compartment to which it refers.
   */
  public QualitativeSpecies* getByCompartment(const std::string& sid)
  {
    return const_cast<QualitativeSpecies*>(static_cast<const
      ListOfQualitativeSpecies&>(*this).getByCompartment(sid));
  }


  /**
   * Returns the XML element name of this ListOfQualitativeSpecies object.
   */
  public const std::string& getElementName()
  {
    static const string name = "listOfQualitativeSpecies";
    return name;
  }


  /**
   * Returns the libJSBML type code for this ListOfQualitativeSpecies object.
   */
  public int getTypeCode()
  {
    return JSBML_LIST_OF;
  }


  /**
   * Returns the libJSBML type code for the JSBML objects contained in this
   * ListOfQualitativeSpecies object.
   */
  public int getItemTypeCode()
  {
    return SBML_QUAL_QUALITATIVE_SPECIES;
  }


  /**
   * Predicate returning @c true if all the required attributes for this
   * ListOfQualitativeSpecies object have been set.
   */
  public bool hasRequiredAttributes()
  {
    bool allPresent = ListOf::hasRequiredAttributes();

    return allPresent;
  }



  /** @cond doxygenJSBMLInternal */

  /**
   * Creates a new QualitativeSpecies in this ListOfQualitativeSpecies
   */
  public SBase* createObject(XMLInputStream& stream)
  {
    const std::string& name = stream.peek().getName();
    SBase* object = NULL;
    QUAL_CREATE_NS(qualns, getSBMLNamespaces());

    if (name == "qualitativeSpecies")
    {
      object = new QualitativeSpecies(qualns);
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


