/*
 * $Id: QualitativeSpecies.java 2465 2016-06-03 00:41:22Z deviser $
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

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: 2016-06-03 00:41:22 +0400 (Fri, 03 Jun 2016) $
 */
  /**
   * @return the value of the "id" attribute of this QualitativeSpecies.
   */
  public String getId() {
    return isSetId() ? id : "";
  }


  /**
   * @return the value of the "name" attribute of this QualitativeSpecies.
   */
  public String getName() {
    return isSetName() ? name : "";
  }


  /**
   * @return the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public String getCompartment() {
    return isSetCompartment() ? compartment : "";
  }


  /**
   * @return the value of the "constant" attribute of this QualitativeSpecies.
   */
  public boolean getConstant() {
    if (isSetConstant()) {
      return mConstant.booleanValue();
    }
    throw new PropertyUndefinedError(QualConstants.mConstant, this);
  }


  /**
   * @return the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  public int getInitialLevel() {
    if (isSetInitialLevel()) {
      return mInitialLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.mInitialLevel, this);
  }


  /**
   * @return the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public int getMaxLevel() {
    if (isSetMaxLevel()) {
      return mMaxLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.mMaxLevel, this);
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "id"
   * attribute is set.
   */
  public boolean isSetId() {
    ;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "name"
   * attribute is set.
   */
  public boolean isSetName() {
    ;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "compartment" attribute is set.
   */
  public boolean isSetCompartment() {
    ;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "constant"
   * attribute is set.
   */
  public boolean isSetConstant() {
    return mConstant != null;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "initialLevel" attribute is set.
   */
  public boolean isSetInitialLevel() {
    return mInitialLevel != null;
  }


  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "maxLevel"
   * attribute is set.
   */
  public boolean isSetMaxLevel() {
    return mMaxLevel != null;
  }


  /**
   * Sets the value of the "id" attribute of this QualitativeSpecies.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }


  /**
   * Sets the value of the "name" attribute of this QualitativeSpecies.
   */
  public void setName(String name) {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }


  /**
   * Sets the value of the "compartment" attribute of this QualitativeSpecies.
   */
  public boolean setCompartment(String compartment) {
    if (compartment != this.mCompartment) {
      String oldmCompartment = this.mCompartment;
      if ((compartment == null) || (compartment.length() == 0) {
        this.mCompartment = null;
      } else {
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
  public void setConstant(boolean constant) {
    Boolean oldmConstant = this.mConstant;

    this.oldmConstant = constant;

    firePropertyChange(QualConstants.mConstant, oldmConstant,
      this.oldmConstant);
  }


  /**
   * Sets the value of the "initialLevel" attribute of this QualitativeSpecies.
   */
  public void setInitialLevel(int initialLevel) {
    Integer oldmInitialLevel = this.mInitialLevel;

    this.oldmInitialLevel = initialLevel;

    firePropertyChange(QualConstants.mInitialLevel, oldmInitialLevel,
      this.oldmInitialLevel);
  }


  /**
   * Sets the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public void setMaxLevel(int maxLevel) {
    Integer oldmMaxLevel = this.mMaxLevel;

    this.oldmMaxLevel = maxLevel;

    firePropertyChange(QualConstants.mMaxLevel, oldmMaxLevel,
      this.oldmMaxLevel);
  }


  /**
   * Unsets the value of the "id" attribute of this QualitativeSpecies.
   */
  public boolean unsetId() {
    if (isSetId()) {
      mId = null;
      return true;
    } else {
      return false;
    }
  }


  /**
   * Unsets the value of the "name" attribute of this QualitativeSpecies.
   */
  public boolean unsetName() {
    if (isSetName()) {
      mName = null;
      return true;
    } else {
      return false;
    }
  }


  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetCompartment() {
    if (isSetCompartment()) {
      mCompartment = null;
      return true;
    } else {
      return false;
    }
  }


  /**
   * Unsets the value of the "constant" attribute of this QualitativeSpecies.
   */
  public boolean unsetConstant() {
    if (isSetConstant()) {
      Boolean oldmConstant = mConstant;
      mConstant = null;
      firePropertyChange(QualConstants.mConstant, oldmConstant, mConstant);
      return true;
    } else {
      return false;
    }
  }


  /**
   * Unsets the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetInitialLevel() {
    if (isSetInitialLevel()) {
      Integer oldmInitialLevel = mInitialLevel;
      mInitialLevel = null;
      firePropertyChange(QualConstants.mInitialLevel, oldmInitialLevel,
        mInitialLevel);
      return true;
    } else {
      return false;
    }
  }


  /**
   * Unsets the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public boolean unsetMaxLevel() {
    if (isSetMaxLevel()) {
      Integer oldmMaxLevel = mMaxLevel;
      mMaxLevel = null;
      firePropertyChange(QualConstants.mMaxLevel, oldmMaxLevel, mMaxLevel);
      return true;
    } else {
      return false;
    }
  }


