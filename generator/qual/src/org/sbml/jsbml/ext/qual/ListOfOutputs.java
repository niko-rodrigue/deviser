/**
 * @file ListOfOutputs.java
 * @brief Implementation of the ListOfOutputs class.
 * @author SBMLTeam
 */
#include <jsbml/packages/qual/jsbml/ListOfOutputs.h>
#include <jsbml/packages/qual/validator/QualJSBMLError.h>


using namespace std;



JSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new ListOfOutputs using the given JSBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
public ListOfOutputs(unsigned int level,
                      unsigned int version,
                      unsigned int pkgVersion)
  : ListOf(level, version)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new ListOfOutputs using the given QualPkgNamespaces object.
 */
public ListOfOutputs(QualPkgNamespaces *qualns)
  : ListOf(qualns)
{
  setElementNamespace(qualns->getURI());
}


/*
 * Copy constructor for ListOfOutputs.
 */
public ListOfOutputs(const ListOfOutputs& orig)
  : ListOf( orig )
{
}


/*
 * Assignment operator for ListOfOutputs.
 */
public ListOfOutputs& operator=(const ListOfOutputs& rhs)
{
  if (&rhs != this)
  {
    ListOf::operator=(rhs);
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this ListOfOutputs object.
 */
public ListOfOutputs* clone()
{
  return new ListOfOutputs(*this);
}


/*
 * Destructor for ListOfOutputs.
 */
public ~ListOfOutputs()
{
}


/*
 * Get an Output from the ListOfOutputs.
 */
public Output* get(unsigned int n)
{
  return static_cast<Output*>(ListOf::get(n));
}


/*
 * Get an Output from the ListOfOutputs.
 */
public const Output* get(unsigned int n)
{
  return static_cast<const Output*>(ListOf::get(n));
}


/*
 * Get an Output from the ListOfOutputs based on its identifier.
 */
public Output* get(const std::string& sid)
{
  return const_cast<Output*>(static_cast<const
    ListOfOutputs&>(*this).get(sid));
}


/*
 * Get an Output from the ListOfOutputs based on its identifier.
 */
public const Output* get(const std::string& sid)
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEq<Output>(sid));
  return (result == mItems.end()) ? 0 : static_cast <const Output*> (*result);
}


/*
 * Removes the nth Output from this ListOfOutputs and returns a pointer to it.
 */
public Output* remove(unsigned int n)
{
  return static_cast<Output*>(ListOf::remove(n));
}


/*
 * Removes the Output from this ListOfOutputs based on its identifier and
 * returns a pointer to it.
 */
public Output* remove(const std::string& sid)
{
  SBase* item = NULL;
  vector<SBase*>::iterator result;

  result = find_if(mItems.begin(), mItems.end(), IdEq<Output>(sid));

  if (result != mItems.end())
  {
    item = *result;
    mItems.erase(result);
  }

  return static_cast <Output*> (item);
}


/*
 * Adds a copy of the given Output to this ListOfOutputs.
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
  else
  {
    append(o);
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Get the number of Output objects in this ListOfOutputs.
 */
public unsigned int getNumOutputs()
{
  return size();
}


/*
 * Creates a new Output object, adds it to this ListOfOutputs object and
 * returns the Output object created.
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
    appendAndOwn(o);
  }

  return o;
}


/*
 * Used by ListOfOutputs::get() to lookup an Output based on its
 * QualitativeSpecies.
 */
struct IdEqQS : public std::unary_function<SBase*, bool>
{
  const string& id;
   
  IdEqQS (const string& id) : id(id) { }
  bool operator() (SBase* sb)
  {
  return (static_cast<Output*>(sb)->getQualitativeSpecies() == id);
  }
};


/*
 * Get an Output from the ListOfOutputs based on the QualitativeSpecies to
 * which it refers.
 */
public const Output* getByQualitativeSpecies(const std::string& sid)
{
  vector<SBase*>::const_iterator result;
  result = find_if(mItems.begin(), mItems.end(), IdEqQS(sid));
  return (result == mItems.end()) ? 0 : static_cast <const Output*> (*result);
}


/*
 * Get an Output from the ListOfOutputs based on the QualitativeSpecies to
 * which it refers.
 */
public Output* getByQualitativeSpecies(const std::string& sid)
{
  return const_cast<Output*>(static_cast<const
    ListOfOutputs&>(*this).getByQualitativeSpecies(sid));
}


/*
 * Returns the XML element name of this ListOfOutputs object.
 */
public const std::string& getElementName()
{
  static const string name = "listOfOutputs";
  return name;
}


/*
 * Returns the libJSBML type code for this ListOfOutputs object.
 */
public int getTypeCode()
{
  return JSBML_LIST_OF;
}


/*
 * Returns the libJSBML type code for the JSBML objects contained in this
 * ListOfOutputs object.
 */
public int getItemTypeCode()
{
  return SBML_QUAL_OUTPUT;
}


/*
 * Predicate returning @c true if all the required attributes for this
 * ListOfOutputs object have been set.
 */
public bool hasRequiredAttributes()
{
  bool allPresent = ListOf::hasRequiredAttributes();

  return allPresent;
}



/** @cond doxygenJSBMLInternal */

/*
 * Creates a new Output in this ListOfOutputs
 */
public SBase* createObject(XMLInputStream& stream)
{
  const std::string& name = stream.peek().getName();
  SBase* object = NULL;
  QUAL_CREATE_NS(qualns, getSBMLNamespaces());

  if (name == "output")
  {
    object = new Output(qualns);
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
 * Get an Output_t from the ListOf_t.
 */
JSBML_EXTERN
public const Output_t* ListOfOutputs_getOutput(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfOutputs*>(lo)->get(n);
}


/*
 * Get an Output_t from the ListOf_t based on its identifier.
 */
JSBML_EXTERN
public const Output_t* ListOfOutputs_getById(ListOf_t* lo, const char *sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfOutputs*>(lo)->get(sid) : NULL;
}


/*
 * Removes the nth Output_t from this ListOf_t and returns a pointer to it.
 */
JSBML_EXTERN
public Output_t* ListOfOutputs_remove(ListOf_t* lo, unsigned int n)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return static_cast <ListOfOutputs*>(lo)->remove(n);
}


/*
 * Removes the Output_t from this ListOf_t based on its identifier and returns
 * a pointer to it.
 */
JSBML_EXTERN
public Output_t* ListOfOutputs_removeById(ListOf_t* lo, const char* sid)
{
  if (lo == NULL)
  {
    return NULL;
  }

  return (sid != NULL) ? static_cast <ListOfOutputs*>(lo)->remove(sid) : NULL;
}




JSBML_CPP_NAMESPACE_END


