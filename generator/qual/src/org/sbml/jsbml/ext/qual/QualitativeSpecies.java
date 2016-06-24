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
  private String compartment;
  /**
   *
   */
  private Boolean constant;
  /**
   *
   */
  private Integer initialLevel;
  /**
   *
   */
  private Integer maxLevel;

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
    compartment = null;
    constant = null;
    initialLevel = null;
    maxLevel = null;
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
    return isSetCompartment() ? compartment : "";
  }

  /**
   * @return the value of the "constant" attribute of this QualitativeSpecies.
   */
  public boolean getConstant() {
    if (isSetConstant()) {
      return constant.booleanValue();
    }
    throw new PropertyUndefinedError(QualConstants.constant, this);
  }

  /**
   * @return the value of the "initialLevel" attribute of this
   * QualitativeSpecies.
   */
  public int getInitialLevel() {
    if (isSetInitialLevel()) {
      return initialLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.initialLevel, this);
  }

  /**
   * @return the value of the "maxLevel" attribute of this QualitativeSpecies.
   */
  public int getMaxLevel() {
    if (isSetMaxLevel()) {
      return maxLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.maxLevel, this);
  }

  /**
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "compartment" attribute is set.
   */
  public boolean isSetCompartment() {
    return compartment != null;
  }

  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "constant"
   * attribute is set.
   */
  public boolean isSetConstant() {
    return constant != null;
  }

  /**
   * Predicate returning {@code true} if this QualitativeSpecies's
   * "initialLevel" attribute is set.
   */
  public boolean isSetInitialLevel() {
    return initialLevel != null;
  }

  /**
   * Predicate returning {@code true} if this QualitativeSpecies's "maxLevel"
   * attribute is set.
   */
  public boolean isSetMaxLevel() {
    return maxLevel != null;
  }

  /**
   * @param compartment String value of the "compartment" attribute to be set.
   */
  public boolean setCompartment(String compartment) {
    if (compartment != this.compartment) {
      String oldCompartment = this.compartment;
      if ((compartment == null) || (compartment.isEmpty())) {
        this.compartment = null;
      } else {
        this.compartment = compartment;
      }

      firePropertyChange(QualConstants.compartment, oldCompartment,
        this.oldCompartment);
      return true;
    }
    return false;
  }

  /**
   * @param constant boolean value of the "constant" attribute to be set.
   */
  public void setConstant(boolean constant) {
    Boolean oldConstant = this.constant;
    this.constant = constant;
    firePropertyChange(QualConstants.constant, oldConstant, this.constant);
  }

  /**
   * @param initialLevel int value of the "initialLevel" attribute to be set.
   */
  public void setInitialLevel(int initialLevel) {
    Integer oldInitialLevel = this.initialLevel;
    this.initialLevel = initialLevel;
    firePropertyChange(QualConstants.initialLevel, oldInitialLevel,
      this.initialLevel);
  }

  /**
   * @param maxLevel int value of the "maxLevel" attribute to be set.
   */
  public void setMaxLevel(int maxLevel) {
    Integer oldMaxLevel = this.maxLevel;
    this.maxLevel = maxLevel;
    firePropertyChange(QualConstants.maxLevel, oldMaxLevel, this.maxLevel);
  }

  /**
   * Unsets the value of the "compartment" attribute of this
   * QualitativeSpecies.
   */
  public boolean unsetCompartment() {
    if (isSetCompartment()) {
      compartment = null;
      firePropertyChange(QualConstants.compartment, oldCompartment,
        compartment);
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
      Boolean oldConstant = constant;
      constant = null;
      firePropertyChange(QualConstants.constant, oldConstant, constant);
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
      Integer oldInitialLevel = initialLevel;
      initialLevel = null;
      firePropertyChange(QualConstants.initialLevel, oldInitialLevel,
        initialLevel);
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
      Integer oldMaxLevel = maxLevel;
      maxLevel = null;
      firePropertyChange(QualConstants.maxLevel, oldMaxLevel, maxLevel);
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
