/**
 * @file ListOfQualitativeSpecies.java
 * @brief Implementation of the ListOfQualitativeSpecies class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/ListOfQualitativeSpecies.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new ListOfQualitativeSpecies using the given JSBML Level, Version
 * and &ldquo;qual&rdquo; package version.
 */
public ListOfQualitativeSpecies(unsigned int level,
                                 unsigned int version,
                                 unsigned int pkgVersion)
  : ListOf(level, version)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new ListOfQualitativeSpecies using the given QualPkgNamespaces
 * object.
 */
public ListOfQualitativeSpecies(QualPkgNamespaces *qualns)
  : ListOf(qualns)
{
  setElementNamespace(qualns->getURI());
}


/*
 * Copy constructor for ListOfQualitativeSpecies.
 */
public ListOfQualitativeSpecies(const ListOfQualitativeSpecies& orig)
  : ListOf( orig )
{
}


/*
 * Assignment operator for ListOfQualitativeSpecies.
 */
public ListOfQualitativeSpecies& operator=(const ListOfQualitativeSpecies& rhs)
{
  if (&rhs != this)
  {
    ListOf::operator=(rhs);
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this ListOfQualitativeSpecies object.
 */
public ListOfQualitativeSpecies* clone()
{
  return new ListOfQualitativeSpecies(*this);
}


/*
 * Destructor for ListOfQualitativeSpecies.
 */
public ~ListOfQualitativeSpecies()
{
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
 */
public QualitativeSpecies* get(unsigned int n)
{
  return static_cast<QualitativeSpecies*>(ListOf::get(n));
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies.
 */
public const QualitativeSpecies* get(unsigned int n)
{
  return static_cast<const QualitativeSpecies*>(ListOf::get(n));
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
 * identifier.
 */
public QualitativeSpecies* get(const std::string& sid)
{
  return const_cast<QualitativeSpecies*>(static_cast<const
    ListOfQualitativeSpecies&>(*this).get(sid));
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on its
 * identifier.
 */
public const QualitativeSpecies* get(const std::string& sid)
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(),
    IdEq<QualitativeSpecies>(sid));
  return (result == mItems.end()) ? 0 : static_cast <const QualitativeSpecies*>
    (*result);
}


/*
 * Removes the nth QualitativeSpecies from this ListOfQualitativeSpecies and
 * returns a pointer to it.
 */
public QualitativeSpecies* remove(unsigned int n)
{
  return static_cast<QualitativeSpecies*>(ListOf::remove(n));
}


/*
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


/*
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


/*
 * Get the number of QualitativeSpecies objects in this
 * ListOfQualitativeSpecies.
 */
public unsigned int getNumQualitativeSpecies()
{
  return size();
}


/*
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


/*
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


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
 * Compartment to which it refers.
 */
public const QualitativeSpecies* getByCompartment(const std::string& sid)
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEqC(sid));
  return (result == mItems.end()) ? 0 : static_cast <const QualitativeSpecies*>
    (*result);
}


/*
 * Get a QualitativeSpecies from the ListOfQualitativeSpecies based on the
 * Compartment to which it refers.
 */
public QualitativeSpecies* getByCompartment(const std::string& sid)
{
  return const_cast<QualitativeSpecies*>(static_cast<const
    ListOfQualitativeSpecies&>(*this).getByCompartment(sid));
}


/*
 * Returns the XML element name of this ListOfQualitativeSpecies object.
 */
public const std::string& getElementName()
{
  static const string name = "listOfQualitativeSpecies";
  return name;
}


/*
 * Returns the libJSBML type code for this ListOfQualitativeSpecies object.
 */
public int getTypeCode()
{
  return JSBML_LIST_OF;
}


/*
 * Returns the libJSBML type code for the JSBML objects contained in this
 * ListOfQualitativeSpecies object.
 */
public int getItemTypeCode()
{
  return SBML_QUAL_QUALITATIVE_SPECIES;
}


/*
 * Predicate returning @c true if all the required attributes for this
 * ListOfQualitativeSpecies object have been set.
 */
public bool hasRequiredAttributes()
{
  bool allPresent = ListOf::hasRequiredAttributes();

  return allPresent;
}



/** @cond doxygenJSBMLInternal */

/*
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

/*
 * Adds the expected attributes for this element
 */
public void addExpectedAttributes(ExpectedAttributes& attributes)
{
  ListOf::addExpectedAttributes(attributes);
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
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

/*
 * Writes the attributes to the stream
 */
public void writeAttributes(XMLOutputStream& stream)
{
  ListOf::writeAttributes(stream);

  SBase::writeExtensionAttributes(stream);
}

/** @endcond */



/** @cond doxygenJSBMLInternal */

/*
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




#endif /* __cplusplus */


/*
 * Get a QualitativeSpecies_t from the ListOf_t.
 */
JSBML_EXTERN
public const QualitativeSpecies_t*
  ListOfQualitativeSpecies_getQualitativeSpecies(
                                                                                  ListOf_t* lo,
                                                                                  unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfQualitativeSpecies*>(lo)->get(n);
}


/*
 * Get a QualitativeSpecies_t from the ListOf_t based on its identifier.
 */
JSBML_EXTERN
public const QualitativeSpecies_t* ListOfQualitativeSpecies_getById(
                                                                    ListOf_t*
                                                                      lo,
                                                                    const char
                                                                      *sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfQualitativeSpecies*>(lo)->get(sid)
    : NULL;
}


/*
 * Removes the nth QualitativeSpecies_t from this ListOf_t and returns a
 * pointer to it.
 */
JSBML_EXTERN
public QualitativeSpecies_t* ListOfQualitativeSpecies_remove(ListOf_t* lo,
                                                             unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfQualitativeSpecies*>(lo)->remove(n);
}


/*
 * Removes the QualitativeSpecies_t from this ListOf_t based on its identifier
 * and returns a pointer to it.
 */
JSBML_EXTERN
public QualitativeSpecies_t* ListOfQualitativeSpecies_removeById(ListOf_t* lo,
                                                                 const char*
                                                                   sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast
    <ListOfQualitativeSpecies*>(lo)->remove(sid) : NULL;
}




JSBML_CPP_NAMESPACE_END


