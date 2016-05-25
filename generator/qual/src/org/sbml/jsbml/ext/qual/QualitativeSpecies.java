/**
 * @file QualitativeSpecies.java
 * @brief Implementation of the QualitativeSpecies class.
 * @author SBMLTeam
 *
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML. Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2013-2016 jointly by the following organizations:
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
#include <sbml/packages/qual/sbml/QualitativeSpecies.h>
#include <sbml/packages/qual/sbml/ListOfQualitativeSpecies.h>
#include <sbml/packages/qual/validator/QualSBMLError.h>


using namespace std;



LIBSBML_CPP_NAMESPACE_BEGIN




#ifdef __cplusplus


/*
 * Creates a new QualitativeSpecies using the given SBML Level, Version and
 * &ldquo;qual&rdquo; package version.
 */
QualitativeSpecies::QualitativeSpecies(unsigned int level,
                                       unsigned int version,
                                       unsigned int pkgVersion)
  : SBase(level, version)
  , mId ("")
  , mName ("")
  , mCompartment ("")
  , mConstant (false)
  , mIsSetConstant (false)
  , mInitialLevel (SBML_INT_MAX)
  , mIsSetInitialLevel (false)
  , mMaxLevel (SBML_INT_MAX)
  , mIsSetMaxLevel (false)
{
  setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
}


/*
 * Creates a new QualitativeSpecies using the given QualPkgNamespaces object.
 */
QualitativeSpecies::QualitativeSpecies(QualPkgNamespaces *qualns)
  : SBase(qualns)
  , mId ("")
  , mName ("")
  , mCompartment ("")
  , mConstant (false)
  , mIsSetConstant (false)
  , mInitialLevel (SBML_INT_MAX)
  , mIsSetInitialLevel (false)
  , mMaxLevel (SBML_INT_MAX)
  , mIsSetMaxLevel (false)
{
  setElementNamespace(qualns->getURI());
  loadPlugins(qualns);
}


/*
 * Copy constructor for QualitativeSpecies.
 */
QualitativeSpecies::QualitativeSpecies(const QualitativeSpecies& orig)
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


/*
 * Assignment operator for QualitativeSpecies.
 */
QualitativeSpecies&
QualitativeSpecies::operator=(const QualitativeSpecies& rhs)
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


/*
 * Creates and returns a deep copy of this QualitativeSpecies object.
 */
QualitativeSpecies*
QualitativeSpecies::clone() const
{
  return new QualitativeSpecies(*this);
}


/*
 * Destructor for QualitativeSpecies.
 */
QualitativeSpecies::~QualitativeSpecies()
{
}


/*
 * Returns the value of the "id" attribute of this QualitativeSpecies.
 */
const std::string&
QualitativeSpecies::getId() const
{
  return mId;
}


/*
 * Returns the value of the "name" attribute of this QualitativeSpecies.
 */
const std::string&
QualitativeSpecies::getName() const
{
  return mName;
}


/*
 * Returns the value of the "compartment" attribute of this QualitativeSpecies.
 */
const std::string&
QualitativeSpecies::getCompartment() const
{
  return mCompartment;
}


/*
 * Returns the value of the "constant" attribute of this QualitativeSpecies.
 */
