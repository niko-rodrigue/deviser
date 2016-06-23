/*
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
package org.sbml.jsbml.ext.qual;

import java.util.Map;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class QualitativeSpecies extends AbstractNamedSBase implements CompartmentalizedSBase, UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
  /**
   *
   */
  private String mCompartment;
  /**
   *
   */
  private Boolean mConstant;
  /**
   *
   */
  private Integer mInitialLevel;
  /**
   *
   */
  private Integer mMaxLevel;

  /**
   *  
   */
  public QualitativeSpecies() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public QualitativeSpecies(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public QualitativeSpecies(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public QualitativeSpecies(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public QualitativeSpecies(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    mCompartment = null;
    mConstant = null;
    mInitialLevel = null;
    mMaxLevel = null;
  }

  /**
   * (non-Javadoc)
   */
  @Override
  public QualitativeSpecies clone() {
    return new QualitativeSpecies(this);
  }

  /**
   * @return the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public String getCompartment() {
    return isSetCompartment() ? mCompartment : "";
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
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "compartment" attribute is set.
   */
  public boolean isSetCompartment() {
    return mCompartment != null;
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
   * @param compartment String value of the "compartment" attribute to be set.
   */
  public boolean setCompartment(String compartment) {
    if (compartment != this.mCompartment) {
      String oldmCompartment = this.mCompartment;
      if ((compartment == null) || (compartment.isEmpty())) {
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
   * @param constant boolean value of the "constant" attribute to be set.
   */
  public void setConstant(boolean constant) {
    Boolean oldmConstant = this.mConstant;
    this.mConstant = constant;
    firePropertyChange(QualConstants.mConstant, oldmConstant, this.mConstant);
  }

  /**
   * @param initialLevel int value of the "initialLevel" attribute to be set.
   */
  public void setInitialLevel(int initialLevel) {
    Integer oldmInitialLevel = this.mInitialLevel;
    this.mInitialLevel = initialLevel;
    firePropertyChange(QualConstants.mInitialLevel, oldmInitialLevel,
      this.mInitialLevel);
  }

  /**
   * @param maxLevel int value of the "maxLevel" attribute to be set.
   */
  public void setMaxLevel(int maxLevel) {
    Integer oldmMaxLevel = this.mMaxLevel;
    this.mMaxLevel = maxLevel;
    firePropertyChange(QualConstants.mMaxLevel, oldmMaxLevel, this.mMaxLevel);
  }

  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetCompartment() {
    if (isSetCompartment()) {
      mCompartment = null;
      firePropertyChange(QualConstants.mCompartment, oldmCompartment,
        mCompartment);
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

  /**
   * (non-Javadoc)
   */
  @Override
  public boolean isIdMandatory() {
    return true;
  }

  /**
   * (non-Javadoc)
   */
  @Override
  public boolean isCompartmentMandatory() {
    return true;
  }

  /**
   * @return false
   */
  public boolean isInitialLevelMandatory() {
    return false;
  }

}
