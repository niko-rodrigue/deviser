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

import java.text.MessageFormat;
import java.util.Locale;
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
  private static final long serialVersionUID = 42373637913717001L;
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
   * @param orig the QualitativeSpecies instance to copy.
   */
  public QualitativeSpecies(QualitativeSpecies orig) {
    super(orig);

    if (orig.isSetCompartment()) {
      setCompartment(orig.getCompartment());
    }
    if (orig.isSetConstant()) {
      setConstant(orig.getConstant());
    }
    if (orig.isSetInitialLevel()) {
      setInitialLevel(orig.getInitialLevel());
    }
    if (orig.isSetMaxLevel()) {
      setMaxLevel(orig.getMaxLevel());
    }
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

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      QualitativeSpecies obj = (QualitativeSpecies) object;

      equals &= obj.isSetCompartment() == isSetCompartment();
      if (equals && isSetCompartment()) {
        equals &= (obj.getCompartment() == getCompartment());
      }
      equals &= obj.isSetConstant() == isSetConstant();
      if (equals && isSetConstant()) {
        equals &= (obj.getConstant() == getConstant());
      }
      equals &= obj.isSetInitialLevel() == isSetInitialLevel();
      if (equals && isSetInitialLevel()) {
        equals &= (obj.getInitialLevel() == getInitialLevel());
      }
      equals &= obj.isSetMaxLevel() == isSetMaxLevel();
      if (equals && isSetMaxLevel()) {
        equals &= (obj.getMaxLevel() == getMaxLevel());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public QualitativeSpecies clone() {
    return new QualitativeSpecies(this);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.CompartmentalizedSBase#getCompartment
   */
  @Override
  public String getCompartment() {
    return isSetCompartment() ? compartment : "";
  }

  /* (non-Javadoc)
   * @see
   */
  @Override
  public Compartment getCompartmentInstance() {
    if (isSetCompartment()) {
      Model model = getModel();
      if (model != null) {
        return model.getCompartment(getCompartment());
      }
    }
    return null;
  }

  /**
   * Returns the value of {@link constant}.
   *  
   * @return the value of {@link constant}.
   */
  public boolean getConstant() {
    if (isSetConstant()) {
      return constant.booleanValue();
    }
    throw new PropertyUndefinedError(QualConstants.constant, this);
  }

  /**
   * Returns the value of {@link initialLevel}.
   *  
   * @return the value of {@link initialLevel}.
   */
  public int getInitialLevel() {
    if (isSetInitialLevel()) {
      return initialLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.initialLevel, this);
  }

  /**
   * Returns the value of {@link maxLevel}.
   *  
   * @return the value of {@link maxLevel}.
   */
  public int getMaxLevel() {
    if (isSetMaxLevel()) {
      return maxLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.maxLevel, this);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.CompartmentalizedSBase#isSetCompartment
   */
  @Override
  public boolean isSetCompartment() {
    return this.compartment != null;
  }

  /* (non-Javadoc)
   * @see
   */
  @Override
  public boolean isSetCompartmentInstance() {
    return getCompartmentInstance() != null;
  }

  /**
   * Returns whether {@link constant} is set.
   *  
   * @return whether {@link constant} is set.
   */
  public boolean isSetConstant() {
    return this.constant != null;
  }

  /**
   * Returns whether {@link initialLevel} is set.
   *  
   * @return whether {@link initialLevel} is set.
   */
  public boolean isSetInitialLevel() {
    return this.initialLevel != null;
  }

  /**
   * Returns whether {@link maxLevel} is set.
   *  
   * @return whether {@link maxLevel} is set.
   */
  public boolean isSetMaxLevel() {
    return this.maxLevel != null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.CompartmentalizedSBase#setCompartment
   */
  @Override
  public boolean setCompartment(String compartment) {
    if (compartment != this.compartment) {
      String oldCompartment = this.compartment;
      this.compartment = compartment;
      firePropertyChange(QualConstants.compartment, oldCompartment,
        this.compartment);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.CompartmentalizedSBase#setCompartment
   */
  @Override
  public boolean setCompartment(Compartment compartment) {
    if (compartment != null) {
      return setCompartment(compartment.getId());
    }
    return unsetCompartment();
  }

  /**
   * Sets the value of constant
   *  
   * @param constant the value of constant to be set.
   */
  public boolean setConstant(boolean constant) {
    if (constant != this.constant) {
      Boolean oldConstant = this.constant;
      this.constant = constant;
      firePropertyChange(QualConstants.constant, oldConstant, this.constant);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of initialLevel
   *  
   * @param initialLevel the value of initialLevel to be set.
   */
  public boolean setInitialLevel(int initialLevel) {
    if (initialLevel != this.initialLevel) {
      Integer oldInitialLevel = this.initialLevel;
      this.initialLevel = initialLevel;
      firePropertyChange(QualConstants.initialLevel, oldInitialLevel,
        this.initialLevel);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of maxLevel
   *  
   * @param maxLevel the value of maxLevel to be set.
   */
  public boolean setMaxLevel(int maxLevel) {
    if (maxLevel != this.maxLevel) {
      Integer oldMaxLevel = this.maxLevel;
      this.maxLevel = maxLevel;
      firePropertyChange(QualConstants.maxLevel, oldMaxLevel, this.maxLevel);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.CompartmentalizedSBase#unsetCompartment
   */
  @Override
  public boolean unsetCompartment() {
    if (isSetCompartment()) {
      String oldCompartment = compartment;
      compartment = null;
      firePropertyChange(QualConstants.compartment, oldCompartment,
        compartment);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable constant.
   *  
   * @return {@code true} if constant was set before, otherwise {@code false}.
   */
  public boolean unsetConstant() {
    if (isSetConstant()) {
      Boolean oldConstant = constant;
      constant = null;
      firePropertyChange(QualConstants.constant, oldConstant, constant);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable initialLevel.
   *  
   * @return {@code true} if initialLevel was set before, otherwise {@code
   * false}.
   */
  public boolean unsetInitialLevel() {
    if (isSetInitialLevel()) {
      Integer oldInitialLevel = initialLevel;
      initialLevel = null;
      firePropertyChange(QualConstants.initialLevel, oldInitialLevel,
        initialLevel);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable maxLevel.
   *  
   * @return {@code true} if maxLevel was set before, otherwise {@code false}.
   */
  public boolean unsetMaxLevel() {
    if (isSetMaxLevel()) {
      Integer oldMaxLevel = maxLevel;
      maxLevel = null;
      firePropertyChange(QualConstants.maxLevel, oldMaxLevel, maxLevel);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see
   */
  @Override
  public boolean isCompartmentMandatory() {
    return true;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return true;
  }

  /**
   * @return false
   */
  public boolean isInitialLevelMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isMaxLevelMandatory() {
    return false;
  }

  /**
   * @return true
   */
  public boolean isSetConstantMandatory() {
    return true;
  }

  /* hashcode method for QualitativeSpecies.
   */
  @Override
  public int hashCode() {
    final int prime = 3934033;

    int hashCode = super.hashCode();

    if (isSetCompartment()) {
      hashCode += prime * getCompartment().hashCode();
    }
    if (isSetConstant()) {
      hashCode += prime + (getConstant() ? 1 : -1);
    }
    if (isSetInitialLevel()) {
      hashCode += prime * getInitialLevel();
    }
    if (isSetMaxLevel()) {
      hashCode += prime * getMaxLevel();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("QualitativeSpecies [");
    builder.append("compartment = ");
    builder.append(compartment);
    builder.append(", ");
    builder.append("constant = ");
    builder.append(constant);
    builder.append(", ");
    builder.append("initialLevel = ");
    builder.append(initialLevel);
    builder.append(", ");
    builder.append("maxLevel = ");
    builder.append(maxLevel);
    builder.append(", id = ");
    builder.append(getId());
    builder.append(", name = ");
    builder.append(getName());
    builder.append("]");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    if (!isAttributeRead) {
      isAttributeRead = true;

      if (attributeName.equals(QualConstants.compartment)) {
        setCompartment(value);
      }      else if (attributeName.equals(QualConstants.constant)) {
        setConstant(StringTools.parseSBMLBoolean(value));
      }      else if (attributeName.equals(QualConstants.initialLevel)) {
        setInitialLevel(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(QualConstants.maxLevel)) {
        setMaxLevel(StringTools.parseSBMLInt(value));
      } else {
        isAttributeRead = false;
      }
    }
    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(QualConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(QualConstants.shortLabel + ":name", getName());
    }
    if (isSetCompartment()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.compartment,
        getCompartment());
    }
    if (isSetConstant()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.constant,
        Boolean.toString(getConstant()));
    }
    if (isSetInitialLevel()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.initialLevel,
        Integer.toString(getInitialLevel()));
    }
    if (isSetMaxLevel()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.maxLevel,
        Integer.toString(getMaxLevel()));
    }
    return attributes;
  }

}
