/**
 * @file Fred.cpp
 * @brief Implementation of the Fred class.
 * @author SBMLTeam
 *
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML. Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2013-2018 jointly by the following organizations:
 * 1. California Institute of Technology, Pasadena, CA, USA
 * 2. EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK
 * 3. University of Heidelberg, Heidelberg, Germany
 *
 * Copyright (C) 2009-2013 jointly by the following organizations:
 * 1. California Institute of Technology, Pasadena, CA, USA
 * 2. EMBL European Bioinformatics Institute (EMBL-EBI), Hinxton, UK
 *
 * Copyright (C) 2006-2008 by the California Institute of Technology,
 * Pasadena, CA, USA
 *
 * Copyright (C) 2002-2005 jointly by the following organizations:
 * 1. California Institute of Technology, Pasadena, CA, USA
 * 2. Japan Science and Technology Agency, Japan
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation. A copy of the license agreement is provided in the
 * file named "LICENSE.txt" included with this software distribution and also
 * available online as http://sbml.org/software/libsbml/license.html
 * ------------------------------------------------------------------------ -->
 */
#include <sbml/packages/x/sbml/Fred.h>
#include <sbml/packages/x/validator/XSBMLError.h>
#include <sbml/util/ElementFilter.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new Fred using the given SBML Level, Version and &ldquo;x&rdquo;
 * package version.
 */
Fred::Fred(unsigned int level, unsigned int version, unsigned int pkgVersion)
  : SBase(level, version)
  , mBol (false)
  , mIsSetBol (false)
  , mNum (SBML_INT_MAX)
  , mIsSetNum (false)
  , mStr ("")
  , mKind (KIND_INVALID)
  , mOther (NULL)
  , mOther1 (NULL)
  , mOther2 (NULL)
{
  setSBMLNamespacesAndOwn(new XPkgNamespaces(level, version, pkgVersion));
  connectToChild();
}


/*
 * Creates a new Fred using the given XPkgNamespaces object.
 */
Fred::Fred(XPkgNamespaces *xns)
  : SBase(xns)
  , mBol (false)
  , mIsSetBol (false)
  , mNum (SBML_INT_MAX)
  , mIsSetNum (false)
  , mStr ("")
  , mKind (KIND_INVALID)
  , mOther (NULL)
  , mOther1 (NULL)
  , mOther2 (NULL)
{
  setElementNamespace(xns->getURI());
  connectToChild();
  loadPlugins(xns);
}


/*
 * Copy constructor for Fred.
 */
Fred::Fred(const Fred& orig)
  : SBase( orig )
  , mBol ( orig.mBol )
  , mIsSetBol ( orig.mIsSetBol )
  , mNum ( orig.mNum )
  , mIsSetNum ( orig.mIsSetNum )
  , mStr ( orig.mStr )
  , mKind ( orig.mKind )
  , mOther ( NULL )
  , mOther1 ( NULL )
  , mOther2 ( NULL )
{
  if (orig.mOther != NULL)
  {
    mOther = orig.mOther->clone();
  }

  if (orig.mOther1 != NULL)
  {
    mOther1 = orig.mOther1->clone();
  }

  if (orig.mOther2 != NULL)
  {
    mOther2 = orig.mOther2->clone();
  }

  connectToChild();
}


/*
 * Assignment operator for Fred.
 */
Fred&
Fred::operator=(const Fred& rhs)
{
  if (&rhs != this)
  {
    SBase::operator=(rhs);
    mBol = rhs.mBol;
    mIsSetBol = rhs.mIsSetBol;
    mNum = rhs.mNum;
    mIsSetNum = rhs.mIsSetNum;
    mStr = rhs.mStr;
    mKind = rhs.mKind;
    delete mOther;
    if (rhs.mOther != NULL)
    {
      mOther = rhs.mOther->clone();
    }
    else
    {
      mOther = NULL;
    }

    delete mOther1;
    if (rhs.mOther1 != NULL)
    {
      mOther1 = rhs.mOther1->clone();
    }
    else
    {
      mOther1 = NULL;
    }

    delete mOther2;
    if (rhs.mOther2 != NULL)
    {
      mOther2 = rhs.mOther2->clone();
    }
    else
    {
      mOther2 = NULL;
    }

    connectToChild();
  }

  return *this;
}


/*
 * Creates and returns a deep copy of this Fred object.
 */
Fred*
Fred::clone() const
{
  return new Fred(*this);
}


/*
 * Destructor for Fred.
 */
Fred::~Fred()
{
  delete mOther;
  mOther = NULL;
  delete mOther1;
  mOther1 = NULL;
  delete mOther2;
  mOther2 = NULL;
}


/*
 * Returns the value of the "id" attribute of this Fred.
 */
const std::string&
Fred::getId() const
{
  return mId;
}


/*
 * Returns the value of the "bol" attribute of this Fred.
 */
bool
Fred::getBol() const
{
  return mBol;
}


/*
 * Returns the value of the "num" attribute of this Fred.
 */
int
Fred::getNum() const
{
  return mNum;
}


/*
 * Returns the value of the "str" attribute of this Fred.
 */
const std::string&
Fred::getStr() const
{
  return mStr;
}


/*
 * Returns the value of the "kind" attribute of this Fred.
 */
Kind_t
Fred::getKind() const
{
  return mKind;
}


/*
 * Returns the value of the "kind" attribute of this Fred.
 */
std::string
Fred::getKindAsString() const
{
  std::string code_str = Kind_toString(mKind);
  return code_str;
}


/*
 * Predicate returning @c true if this Fred's "id" attribute is set.
 */
bool
Fred::isSetId() const
{
  return (mId.empty() == false);
}


/*
 * Predicate returning @c true if this Fred's "bol" attribute is set.
 */
bool
Fred::isSetBol() const
{
  return mIsSetBol;
}


/*
 * Predicate returning @c true if this Fred's "num" attribute is set.
 */
bool
Fred::isSetNum() const
{
  return mIsSetNum;
}


/*
 * Predicate returning @c true if this Fred's "str" attribute is set.
 */
bool
Fred::isSetStr() const
{
  return (mStr.empty() == false);
}


/*
 * Predicate returning @c true if this Fred's "kind" attribute is set.
 */
bool
Fred::isSetKind() const
{
  return (mKind != KIND_INVALID);
}


/*
 * Sets the value of the "id" attribute of this Fred.
 */
int
Fred::setId(const std::string& id)
{
  return SyntaxChecker::checkAndSetSId(id, mId);
}


/*
 * Sets the value of the "bol" attribute of this Fred.
 */
int
Fred::setBol(bool bol)
{
  mBol = bol;
  mIsSetBol = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "num" attribute of this Fred.
 */
int
Fred::setNum(int num)
{
  mNum = num;
  mIsSetNum = true;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "str" attribute of this Fred.
 */
int
Fred::setStr(const std::string& str)
{
  mStr = str;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Sets the value of the "kind" attribute of this Fred.
 */
int
Fred::setKind(const Kind_t kind)
{
  if (Kind_isValid(kind) == 0)
  {
    mKind = KIND_INVALID;
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }
  else
  {
    mKind = kind;
    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "kind" attribute of this Fred.
 */
int
Fred::setKind(const std::string& kind)
{
  mKind = Kind_fromString(kind.c_str());

  if (mKind == KIND_INVALID)
  {
    return LIBSBML_INVALID_ATTRIBUTE_VALUE;
  }

  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "id" attribute of this Fred.
 */
int
Fred::unsetId()
{
  mId.erase();

  if (mId.empty() == true)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "bol" attribute of this Fred.
 */
int
Fred::unsetBol()
{
  mBol = false;
  mIsSetBol = false;

  if (isSetBol() == false)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "num" attribute of this Fred.
 */
int
Fred::unsetNum()
{
  mNum = SBML_INT_MAX;
  mIsSetNum = false;

  if (isSetNum() == false)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "str" attribute of this Fred.
 */
int
Fred::unsetStr()
{
  mStr.erase();

  if (mStr.empty() == true)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    return LIBSBML_OPERATION_FAILED;
  }
}


/*
 * Unsets the value of the "kind" attribute of this Fred.
 */
int
Fred::unsetKind()
{
  mKind = KIND_INVALID;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Returns the value of the "other" element of this Fred.
 */
const Other*
Fred::getOther() const
{
  return mOther;
}


/*
 * Returns the value of the "other" element of this Fred.
 */
Other*
Fred::getOther()
{
  return mOther;
}


/*
 * Returns the value of the "other1" element of this Fred.
 */
const Other*
Fred::getOther1() const
{
  return mOther1;
}


/*
 * Returns the value of the "other1" element of this Fred.
 */
Other*
Fred::getOther1()
{
  return mOther1;
}


/*
 * Returns the value of the "other2" element of this Fred.
 */
const Other*
Fred::getOther2() const
{
  return mOther2;
}


/*
 * Returns the value of the "other2" element of this Fred.
 */
Other*
Fred::getOther2()
{
  return mOther2;
}


/*
 * Predicate returning @c true if this Fred's "other" element is set.
 */
bool
Fred::isSetOther() const
{
  return (mOther != NULL);
}


/*
 * Predicate returning @c true if this Fred's "other1" element is set.
 */
bool
Fred::isSetOther1() const
{
  return (mOther1 != NULL);
}


/*
 * Predicate returning @c true if this Fred's "other2" element is set.
 */
bool
Fred::isSetOther2() const
{
  return (mOther2 != NULL);
}


/*
 * Sets the value of the "other" element of this Fred.
 */
int
Fred::setOther(const Other* other)
{
  if (mOther == other)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else if (other == NULL)
  {
    delete mOther;
    mOther = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    delete mOther;
    mOther = (other != NULL) ? other->clone() : NULL;
    if (mOther != NULL)
    {
      mOther->connectToParent(this);
    }

    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "other1" element of this Fred.
 */
int
Fred::setOther1(const Other* other1)
{
  if (mOther1 == other1)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else if (other1 == NULL)
  {
    delete mOther1;
    mOther1 = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    delete mOther1;
    mOther1 = (other1 != NULL) ? other1->clone() : NULL;
    if (mOther1 != NULL)
    {
      mOther1->setElementName("other1");
      mOther1->connectToParent(this);
    }

    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Sets the value of the "other2" element of this Fred.
 */
int
Fred::setOther2(const Other* other2)
{
  if (mOther2 == other2)
  {
    return LIBSBML_OPERATION_SUCCESS;
  }
  else if (other2 == NULL)
  {
    delete mOther2;
    mOther2 = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }
  else
  {
    delete mOther2;
    mOther2 = (other2 != NULL) ? other2->clone() : NULL;
    if (mOther2 != NULL)
    {
      mOther2->setElementName("other2");
      mOther2->connectToParent(this);
    }

    return LIBSBML_OPERATION_SUCCESS;
  }
}


/*
 * Creates a new Other object, adds it to this Fred object and returns the
 * Other object created.
 */
Other*
Fred::createOther()
{
  if (mOther != NULL)
  {
    delete mOther;
  }

  X_CREATE_NS(xns, getSBMLNamespaces());
  mOther = new Other(xns);

  delete xns;

  connectToChild();

  return mOther;
}


/*
 * Creates a new Other object, adds it to this Fred object and returns the
 * Other object created.
 */
Other*
Fred::createOther1()
{
  if (mOther1 != NULL)
  {
    delete mOther1;
  }

  X_CREATE_NS(xns, getSBMLNamespaces());
  mOther1 = new Other(xns);

  mOther1->setElementName("other1");

  delete xns;

  connectToChild();

  return mOther1;
}


/*
 * Creates a new Other object, adds it to this Fred object and returns the
 * Other object created.
 */
Other*
Fred::createOther2()
{
  if (mOther2 != NULL)
  {
    delete mOther2;
  }

  X_CREATE_NS(xns, getSBMLNamespaces());
  mOther2 = new Other(xns);

  mOther2->setElementName("myOther");

  delete xns;

  connectToChild();

  return mOther2;
}


/*
 * Unsets the value of the "other" element of this Fred.
 */
int
Fred::unsetOther()
{
  delete mOther;
  mOther = NULL;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "other1" element of this Fred.
 */
int
Fred::unsetOther1()
{
  delete mOther1;
  mOther1 = NULL;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Unsets the value of the "other2" element of this Fred.
 */
int
Fred::unsetOther2()
{
  delete mOther2;
  mOther2 = NULL;
  return LIBSBML_OPERATION_SUCCESS;
}


/*
 * Returns the XML element name of this Fred object.
 */
const std::string&
Fred::getElementName() const
{
  static const string name = "fred";
  return name;
}


/*
 * Returns the libSBML type code for this Fred object.
 */
int
Fred::getTypeCode() const
{
  return SBML_X_FRED;
}


/*
 * Predicate returning @c true if all the required attributes for this Fred
 * object have been set.
 */
bool
Fred::hasRequiredAttributes() const
{
  bool allPresent = true;

  if (isSetId() == false)
  {
    allPresent = false;
  }

  if (isSetNum() == false)
  {
    allPresent = false;
  }

  return allPresent;
}



/** @cond doxygenLibsbmlInternal */

/*
 * Write any contained elements
 */
void
Fred::writeElements(XMLOutputStream& stream) const
{
  SBase::writeElements(stream);

  if (isSetOther() == true)
  {
    mOther->write(stream);
  }

  if (isSetOther1() == true)
  {
    mOther1->write(stream);
  }

  if (isSetOther2() == true)
  {
    mOther2->write(stream);
  }

  SBase::writeExtensionElements(stream);
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Accepts the given SBMLVisitor
 */
bool
Fred::accept(SBMLVisitor& v) const
{
  v.visit(*this);

  if (mOther != NULL)
  {
    mOther->accept(v);
  }

  if (mOther1 != NULL)
  {
    mOther1->accept(v);
  }

  if (mOther2 != NULL)
  {
    mOther2->accept(v);
  }

  v.leave(*this);
  return true;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the parent SBMLDocument
 */
void
Fred::setSBMLDocument(SBMLDocument* d)
{
  SBase::setSBMLDocument(d);

  if (mOther != NULL)
  {
    mOther->setSBMLDocument(d);
  }

  if (mOther1 != NULL)
  {
    mOther1->setSBMLDocument(d);
  }

  if (mOther2 != NULL)
  {
    mOther2->setSBMLDocument(d);
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Connects to child elements
 */
void
Fred::connectToChild()
{
  SBase::connectToChild();

  if (mOther != NULL)
  {
    mOther->connectToParent(this);
  }

  if (mOther1 != NULL)
  {
    mOther1->connectToParent(this);
  }

  if (mOther2 != NULL)
  {
    mOther2->connectToParent(this);
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Enables/disables the given package with this element
 */
void
Fred::enablePackageInternal(const std::string& pkgURI,
                            const std::string& pkgPrefix,
                            bool flag)
{
  SBase::enablePackageInternal(pkgURI, pkgPrefix, flag);

  if (isSetOther())
  {
    mOther->enablePackageInternal(pkgURI, pkgPrefix, flag);
  }

  if (isSetOther1())
  {
    mOther1->enablePackageInternal(pkgURI, pkgPrefix, flag);
  }

  if (isSetOther2())
  {
    mOther2->enablePackageInternal(pkgURI, pkgPrefix, flag);
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Updates the namespaces when setLevelVersion is used
 */
void
Fred::updateSBMLNamespace(const std::string& package,
                          unsigned int level,
                          unsigned int version)
{
  SBase::updateSBMLNamespace(package, level, version);

  if (mOther != NULL)
  {
    mOther->updateSBMLNamespace(package, level, version);
  }

  if (mOther1 != NULL)
  {
    mOther1->updateSBMLNamespace(package, level, version);
  }

  if (mOther2 != NULL)
  {
    mOther2->updateSBMLNamespace(package, level, version);
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::getAttribute(const std::string& attributeName, bool& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  if (return_value == LIBSBML_OPERATION_SUCCESS)
  {
    return return_value;
  }

  if (attributeName == "bol")
  {
    value = getBol();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::getAttribute(const std::string& attributeName, int& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  if (return_value == LIBSBML_OPERATION_SUCCESS)
  {
    return return_value;
  }

  if (attributeName == "num")
  {
    value = getNum();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::getAttribute(const std::string& attributeName, double& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::getAttribute(const std::string& attributeName,
                   unsigned int& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Gets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::getAttribute(const std::string& attributeName, std::string& value) const
{
  int return_value = SBase::getAttribute(attributeName, value);

  if (return_value == LIBSBML_OPERATION_SUCCESS)
  {
    return return_value;
  }

  if (attributeName == "id")
  {
    value = getId();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }
  else if (attributeName == "str")
  {
    value = getStr();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }
  else if (attributeName == "kind")
  {
    value = getKindAsString();
    return_value = LIBSBML_OPERATION_SUCCESS;
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Predicate returning @c true if this Fred's attribute "attributeName" is set.
 */
bool
Fred::isSetAttribute(const std::string& attributeName) const
{
  bool value = SBase::isSetAttribute(attributeName);

  if (attributeName == "id")
  {
    value = isSetId();
  }
  else if (attributeName == "bol")
  {
    value = isSetBol();
  }
  else if (attributeName == "num")
  {
    value = isSetNum();
  }
  else if (attributeName == "str")
  {
    value = isSetStr();
  }
  else if (attributeName == "kind")
  {
    value = isSetKind();
  }

  return value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::setAttribute(const std::string& attributeName, bool value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  if (attributeName == "bol")
  {
    return_value = setBol(value);
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::setAttribute(const std::string& attributeName, int value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  if (attributeName == "num")
  {
    return_value = setNum(value);
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::setAttribute(const std::string& attributeName, double value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::setAttribute(const std::string& attributeName, unsigned int value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Sets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::setAttribute(const std::string& attributeName, const std::string& value)
{
  int return_value = SBase::setAttribute(attributeName, value);

  if (attributeName == "id")
  {
    return_value = setId(value);
  }
  else if (attributeName == "str")
  {
    return_value = setStr(value);
  }
  else if (attributeName == "kind")
  {
    return_value = setKind(value);
  }

  return return_value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Unsets the value of the "attributeName" attribute of this Fred.
 */
int
Fred::unsetAttribute(const std::string& attributeName)
{
  int value = SBase::unsetAttribute(attributeName);

  if (attributeName == "id")
  {
    value = unsetId();
  }
  else if (attributeName == "bol")
  {
    value = unsetBol();
  }
  else if (attributeName == "num")
  {
    value = unsetNum();
  }
  else if (attributeName == "str")
  {
    value = unsetStr();
  }
  else if (attributeName == "kind")
  {
    value = unsetKind();
  }

  return value;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Creates and returns an new "elementName" object in this Fred.
 */
SBase*
Fred::createChildObject(const std::string& elementName)
{
  SBase* obj = NULL;

  if (elementName == "other")
  {
    return createOther();
  }
  else if (elementName == "other1")
  {
    return createOther1();
  }
  else if (elementName == "other2")
  {
    return createOther2();
  }

  return obj;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Adds a new "elementName" object to this Fred.
 */
int
Fred::addChildObject(const std::string& elementName, const SBase* element)
{
  if (elementName == "other" && element->getTypeCode() == SBML_X_OTHER)
  {
    return setOther((const Other*)(element));
  }
  else if (elementName == "other1" && element->getTypeCode() == SBML_X_OTHER)
  {
    return setOther1((const Other*)(element));
  }
  else if (elementName == "other2" && element->getTypeCode() == SBML_X_OTHER)
  {
    return setOther2((const Other*)(element));
  }

  return LIBSBML_OPERATION_FAILED;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Removes and returns the new "elementName" object with the given id in this
 * Fred.
 */
SBase*
Fred::removeChildObject(const std::string& elementName, const std::string& id)
{
  if (elementName == "other")
  {
    Other * obj = getOther();
    if (unsetOther() == LIBSBML_OPERATION_SUCCESS) return obj;
  }
  else if (elementName == "other1")
  {
    Other * obj = getOther1();
    if (unsetOther1() == LIBSBML_OPERATION_SUCCESS) return obj;
  }
  else if (elementName == "other2")
  {
    Other * obj = getOther2();
    if (unsetOther2() == LIBSBML_OPERATION_SUCCESS) return obj;
  }

  return NULL;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Returns the number of "elementName" in this Fred.
 */
unsigned int
Fred::getNumObjects(const std::string& elementName)
{
  unsigned int n = 0;

  if (elementName == "other")
  {
    if (isSetOther())
    {
      return 1;
    }
  }
  else if (elementName == "other1")
  {
    if (isSetOther1())
    {
      return 1;
    }
  }
  else if (elementName == "other2")
  {
    if (isSetOther2())
    {
      return 1;
    }
  }

  return n;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Returns the nth object of "objectName" in this Fred.
 */
SBase*
Fred::getObject(const std::string& elementName, unsigned int index)
{
  SBase* obj = NULL;

  if (elementName == "other")
  {
    return getOther();
  }
  else if (elementName == "other1")
  {
    return getOther1();
  }
  else if (elementName == "other2")
  {
    return getOther2();
  }

  return obj;
}

/** @endcond */


/*
 * Returns the first child element that has the given @p id in the model-wide
 * SId namespace, or @c NULL if no such object is found.
 */
SBase*
Fred::getElementBySId(const std::string& id)
{
  if (id.empty())
  {
    return NULL;
  }

  SBase* obj = NULL;

  if (mOther != NULL)
  {
    if (mOther->getId() == id)
    {
      return mOther;
    }

    obj = mOther->getElementBySId(id);
    if (obj != NULL)
    {
      return obj;
    }
  }

  if (mOther1 != NULL)
  {
    if (mOther1->getId() == id)
    {
      return mOther1;
    }

    obj = mOther1->getElementBySId(id);
    if (obj != NULL)
    {
      return obj;
    }
  }

  if (mOther2 != NULL)
  {
    if (mOther2->getId() == id)
    {
      return mOther2;
    }

    obj = mOther2->getElementBySId(id);
    if (obj != NULL)
    {
      return obj;
    }
  }

  return obj;
}


/*
 * Returns the first child element that has the given @p metaid, or @c NULL if
 * no such object is found.
 */
SBase*
Fred::getElementByMetaId(const std::string& metaid)
{
  if (metaid.empty())
  {
    return NULL;
  }

  SBase* obj = NULL;

  if (mOther != NULL)
  {
    if (mOther->getMetaId() == metaid)
    {
      return mOther;
    }

    obj = mOther->getElementByMetaId(metaid);
    if (obj != NULL)
    {
      return obj;
    }
  }

  if (mOther1 != NULL)
  {
    if (mOther1->getMetaId() == metaid)
    {
      return mOther1;
    }

    obj = mOther1->getElementByMetaId(metaid);
    if (obj != NULL)
    {
      return obj;
    }
  }

  if (mOther2 != NULL)
  {
    if (mOther2->getMetaId() == metaid)
    {
      return mOther2;
    }

    obj = mOther2->getElementByMetaId(metaid);
    if (obj != NULL)
    {
      return obj;
    }
  }

  return obj;
}


/*
 * Returns a List of all child SBase objects, including those nested to an
 * arbitrary depth.
 */
List*
Fred::getAllElements(ElementFilter* filter)
{
  List* ret = new List();
  List* sublist = NULL;

  ADD_FILTERED_POINTER(ret, sublist, mOther, filter);
  ADD_FILTERED_POINTER(ret, sublist, mOther1, filter);
  ADD_FILTERED_POINTER(ret, sublist, mOther2, filter);


  ADD_FILTERED_FROM_PLUGIN(ret, sublist, filter);

  return ret;
}



/** @cond doxygenLibsbmlInternal */

/*
 * Creates a new object from the next XMLToken on the XMLInputStream
 */
SBase*
Fred::createObject(XMLInputStream& stream)
{
  SBase* obj = NULL;

  const std::string& name = stream.peek().getName();

  X_CREATE_NS(xns, getSBMLNamespaces());

  if (name == "other")
  {
    if (isSetOther())
    {
      getErrorLog()->logPackageError("x", XFredAllowedElements,
        getPackageVersion(), getLevel(), getVersion());
    }

    delete mOther;
    mOther = new Other(xns);
    obj = mOther;
  }
  else if (name == "other1")
  {
    if (isSetOther1())
    {
      getErrorLog()->logPackageError("x", XFredAllowedElements,
        getPackageVersion(), getLevel(), getVersion());
    }

    delete mOther1;
    mOther1 = new Other(xns);
    mOther1->setElementName(name);
    obj = mOther1;
  }
  else if (name == "myOther")
  {
    if (isSetMyOther())
    {
      getErrorLog()->logPackageError("x", XFredAllowedElements,
        getPackageVersion(), getLevel(), getVersion());
    }

    delete mOther2;
    mOther2 = new Other(xns);
    mOther2->setElementName(name);
    obj = mOther2;
  }

  delete xns;

  connectToChild();

  return obj;
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Adds the expected attributes for this element
 */
void
Fred::addExpectedAttributes(ExpectedAttributes& attributes)
{
  SBase::addExpectedAttributes(attributes);

  attributes.add("identifier");

  attributes.add("myBoolean");

  attributes.add("myNumber");

  attributes.add("myString");

  attributes.add("myEnum");
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Reads the expected attributes into the member data variables
 */
void
Fred::readAttributes(const XMLAttributes& attributes,
                     const ExpectedAttributes& expectedAttributes)
{
  unsigned int level = getLevel();
  unsigned int version = getVersion();
  unsigned int pkgVersion = getPackageVersion();
  unsigned int numErrs;
  bool assigned = false;
  SBMLErrorLog* log = getErrorLog();

  SBase::readAttributes(attributes, expectedAttributes);

  if (log)
  {
    numErrs = log->getNumErrors();

    for (int n = numErrs-1; n >= 0; n--)
    {
      if (log->getError(n)->getErrorId() == UnknownPackageAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownPackageAttribute);
        log->logPackageError("x", XFredAllowedAttributes, pkgVersion, level,
          version, details);
      }
      else if (log->getError(n)->getErrorId() == UnknownCoreAttribute)
      {
        const std::string details = log->getError(n)->getMessage();
        log->remove(UnknownCoreAttribute);
        log->logPackageError("x", XFredAllowedCoreAttributes, pkgVersion,
          level, version, details);
      }
    }
  }

  // 
  // identifier SId (use = "required" )
  // 

  assigned = attributes.readInto("identifier", mId);

  if (assigned == true)
  {
    if (mId.empty() == true)
    {
      logEmptyString(mId, level, version, "<Fred>");
    }
    else if (SyntaxChecker::isValidSBMLSId(mId) == false)
    {
      log->logPackageError("x", XIdSyntaxRule, pkgVersion, level, version, "The "
        "id on the <" + getElementName() + "> is '" + mId + "', which does not "
          "conform to the syntax.", getLine(), getColumn());
    }
  }
  else
  {
    std::string message = "X attribute 'identifier' is missing from the <Fred> "
      "element.";
    log->logPackageError("x", XFredAllowedAttributes, pkgVersion, level,
      version, message);
  }

  // 
  // myBoolean bool (use = "optional" )
  // 

  numErrs = log->getNumErrors();
  mIsSetBol = attributes.readInto("myBoolean", mBol);

  if (mIsSetBol == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      log->logPackageError("x", XFredBolMustBeBoolean, pkgVersion, level,
        version);
    }
  }

  // 
  // myNumber int (use = "required" )
  // 

  numErrs = log->getNumErrors();
  mIsSetNum = attributes.readInto("myNumber", mNum);

  if ( mIsSetNum == false)
  {
    if (log->getNumErrors() == numErrs + 1 &&
      log->contains(XMLAttributeTypeMismatch))
    {
      log->remove(XMLAttributeTypeMismatch);
      std::string message = "X attribute 'myNumber' from the <Fred> element "
        "must be an integer.";
      log->logPackageError("x", XFredNumMustBeInteger, pkgVersion, level,
        version, message);
    }
    else
    {
      std::string message = "X attribute 'myNumber' is missing from the <Fred> "
        "element.";
      log->logPackageError("x", XFredAllowedAttributes, pkgVersion, level,
        version, message);
    }
  }

  // 
  // myString string (use = "optional" )
  // 

  assigned = attributes.readInto("myString", mStr);

  if (assigned == true)
  {
    if (mStr.empty() == true)
    {
      logEmptyString(mStr, level, version, "<Fred>");
    }
  }

  // 
  // myEnum enum (use = "optional" )
  // 

  std::string kind;
  assigned = attributes.readInto("myEnum", kind);

  if (assigned == true)
  {
    if (kind.empty() == true)
    {
      logEmptyString(kind, level, version, "<Fred>");
    }
    else
    {
      mKind = Kind_fromString(kind.c_str());

      if (Kind_isValid(mKind) == 0)
      {
        std::string msg = "The myEnum on the <Fred> ";

        if (isSetId())
        {
          msg += "with id '" + getId() + "'";
        }

        msg += "is '" + kind + "', which is not a valid option.";

        log->logPackageError("x", XFredKindMustBeKindEnum, pkgVersion, level,
          version, msg);
      }
    }
  }
}

/** @endcond */



/** @cond doxygenLibsbmlInternal */

/*
 * Writes the attributes to the stream
 */
void
Fred::writeAttributes(XMLOutputStream& stream) const
{
  SBase::writeAttributes(stream);

  if (isSetId() == true)
  {
    stream.writeAttribute("identifier", getPrefix(), mId);
  }

  if (isSetBol() == true)
  {
    stream.writeAttribute("myBoolean", getPrefix(), mBol);
  }

  if (isSetNum() == true)
  {
    stream.writeAttribute("myNumber", getPrefix(), mNum);
  }

  if (isSetStr() == true)
  {
    stream.writeAttribute("myString", getPrefix(), mStr);
  }

  if (isSetKind() == true)
  {
    stream.writeAttribute("myEnum", getPrefix(), Kind_toString(mKind));
  }

  SBase::writeExtensionAttributes(stream);
}

/** @endcond */




#endif /* __cplusplus */


/*
 * Creates a new Fred_t using the given SBML Level, Version and &ldquo;x&rdquo;
 * package version.
 */
LIBSBML_EXTERN
Fred_t *
Fred_create(unsigned int level, unsigned int version, unsigned int pkgVersion)
{
  return new Fred(level, version, pkgVersion);
}


/*
 * Creates and returns a deep copy of this Fred_t object.
 */
LIBSBML_EXTERN
Fred_t*
Fred_clone(const Fred_t* f)
{
  if (f != NULL)
  {
    return static_cast<Fred_t*>(f->clone());
  }
  else
  {
    return NULL;
  }
}


/*
 * Frees this Fred_t object.
 */
LIBSBML_EXTERN
void
Fred_free(Fred_t* f)
{
  if (f != NULL)
  {
    delete f;
  }
}


/*
 * Returns the value of the "id" attribute of this Fred_t.
 */
LIBSBML_EXTERN
char *
Fred_getId(const Fred_t * f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return f->getId().empty() ? NULL : safe_strdup(f->getId().c_str());
}


/*
 * Returns the value of the "bol" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_getBol(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->getBol()) : 0;
}


/*
 * Returns the value of the "num" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_getNum(const Fred_t * f)
{
  return (f != NULL) ? f->getNum() : SBML_INT_MAX;
}


/*
 * Returns the value of the "str" attribute of this Fred_t.
 */
LIBSBML_EXTERN
char *
Fred_getStr(const Fred_t * f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return f->getStr().empty() ? NULL : safe_strdup(f->getStr().c_str());
}


/*
 * Returns the value of the "kind" attribute of this Fred_t.
 */
LIBSBML_EXTERN
Kind_t
Fred_getKind(const Fred_t * f)
{
  if (f == NULL)
  {
    return KIND_INVALID;
  }

  return f->getKind();
}


/*
 * Returns the value of the "kind" attribute of this Fred_t.
 */
LIBSBML_EXTERN
char *
Fred_getKindAsString(const Fred_t * f)
{
  return (char*)(Kind_toString(f->getKind()));
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "id" attribute is set.
 */
LIBSBML_EXTERN
int
Fred_isSetId(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetId()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "bol" attribute is set.
 */
LIBSBML_EXTERN
int
Fred_isSetBol(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetBol()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "num" attribute is set.
 */
LIBSBML_EXTERN
int
Fred_isSetNum(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetNum()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "str" attribute is set.
 */
LIBSBML_EXTERN
int
Fred_isSetStr(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetStr()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "kind" attribute is set.
 */
LIBSBML_EXTERN
int
Fred_isSetKind(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetKind()) : 0;
}


/*
 * Sets the value of the "id" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setId(Fred_t * f, const char * id)
{
  return (f != NULL) ? f->setId(id) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "bol" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setBol(Fred_t * f, int bol)
{
  return (f != NULL) ? f->setBol(bol) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "num" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setNum(Fred_t * f, int num)
{
  return (f != NULL) ? f->setNum(num) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "str" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setStr(Fred_t * f, const char * str)
{
  return (f != NULL) ? f->setStr(str) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "kind" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setKind(Fred_t * f, Kind_t kind)
{
  return (f != NULL) ? f->setKind(kind) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "kind" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setKindAsString(Fred_t * f, const char * kind)
{
  return (f != NULL) ? f->setKind(kind): LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "id" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetId(Fred_t * f)
{
  return (f != NULL) ? f->unsetId() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "bol" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetBol(Fred_t * f)
{
  return (f != NULL) ? f->unsetBol() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "num" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetNum(Fred_t * f)
{
  return (f != NULL) ? f->unsetNum() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "str" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetStr(Fred_t * f)
{
  return (f != NULL) ? f->unsetStr() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "kind" attribute of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetKind(Fred_t * f)
{
  return (f != NULL) ? f->unsetKind() : LIBSBML_INVALID_OBJECT;
}


/*
 * Returns the value of the "other" element of this Fred_t.
 */
LIBSBML_EXTERN
const Other_t*
Fred_getOther(const Fred_t * f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return (Other_t*)(f->getOther());
}


/*
 * Returns the value of the "other1" element of this Fred_t.
 */
LIBSBML_EXTERN
const Other_t*
Fred_getOther1(const Fred_t * f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return (Other_t*)(f->getOther1());
}


/*
 * Returns the value of the "other2" element of this Fred_t.
 */
LIBSBML_EXTERN
const Other_t*
Fred_getOther2(const Fred_t * f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return (Other_t*)(f->getOther2());
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "other" element is set.
 */
LIBSBML_EXTERN
int
Fred_isSetOther(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetOther()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "other1" element is set.
 */
LIBSBML_EXTERN
int
Fred_isSetOther1(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetOther1()) : 0;
}


/*
 * Predicate returning @c 1 (true) if this Fred_t's "other2" element is set.
 */
LIBSBML_EXTERN
int
Fred_isSetOther2(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->isSetOther2()) : 0;
}


/*
 * Sets the value of the "other" element of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setOther(Fred_t * f, const Other_t* other)
{
  return (f != NULL) ? f->setOther(other) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "other1" element of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setOther1(Fred_t * f, const Other_t* other1)
{
  return (f != NULL) ? f->setOther1(other1) : LIBSBML_INVALID_OBJECT;
}


/*
 * Sets the value of the "other2" element of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_setOther2(Fred_t * f, const Other_t* other2)
{
  return (f != NULL) ? f->setOther2(other2) : LIBSBML_INVALID_OBJECT;
}


/*
 * Creates a new Other_t object, adds it to this Fred_t object and returns the
 * Other_t object created.
 */
LIBSBML_EXTERN
Other_t*
Fred_createOther(Fred_t* f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return (Other_t*)(f->createOther());
}


/*
 * Creates a new Other_t object, adds it to this Fred_t object and returns the
 * Other_t object created.
 */
LIBSBML_EXTERN
Other_t*
Fred_createOther1(Fred_t* f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return (Other_t*)(f->createOther1());
}


/*
 * Creates a new Other_t object, adds it to this Fred_t object and returns the
 * Other_t object created.
 */
LIBSBML_EXTERN
Other_t*
Fred_createOther2(Fred_t* f)
{
  if (f == NULL)
  {
    return NULL;
  }

  return (Other_t*)(f->createOther2());
}


/*
 * Unsets the value of the "other" element of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetOther(Fred_t * f)
{
  return (f != NULL) ? f->unsetOther() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "other1" element of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetOther1(Fred_t * f)
{
  return (f != NULL) ? f->unsetOther1() : LIBSBML_INVALID_OBJECT;
}


/*
 * Unsets the value of the "other2" element of this Fred_t.
 */
LIBSBML_EXTERN
int
Fred_unsetOther2(Fred_t * f)
{
  return (f != NULL) ? f->unsetOther2() : LIBSBML_INVALID_OBJECT;
}


/*
 * Predicate returning @c 1 (true) if all the required attributes for this
 * Fred_t object have been set.
 */
LIBSBML_EXTERN
int
Fred_hasRequiredAttributes(const Fred_t * f)
{
  return (f != NULL) ? static_cast<int>(f->hasRequiredAttributes()) : 0;
}




LIBSBML_CPP_NAMESPACE_END


