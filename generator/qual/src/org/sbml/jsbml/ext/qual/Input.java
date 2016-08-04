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
public class Input extends AbstractNamedSBase implements UniqueNamedSBase, CallableSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 66615169375032193L;
  /**
   *
   */
  private Sign sign;
  /**
   *
   */
  private String qualitativeSpecies;
  /**
   *
   */
  private TransitionInputEffect transitionEffect;
  /**
   *
   */
  private Integer thresholdLevel;

  /**
   *  
   */
  public Input() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Input(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Input(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Input(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Input(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Input instance to copy.
   */
  public Input(Input orig) {
    super(orig);

    if (orig.isSetSign()) {
      setSign(orig.getSign());
    }
    if (orig.isSetQualitativeSpecies()) {
      setQualitativeSpecies(orig.getQualitativeSpecies());
    }
    if (orig.isSetTransitionEffect()) {
      setTransitionEffect(orig.getTransitionEffect());
    }
    if (orig.isSetThresholdLevel()) {
      setThresholdLevel(orig.getThresholdLevel());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    sign = null;
    qualitativeSpecies = null;
    transitionEffect = null;
    thresholdLevel = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Input obj = (Input) object;

      equals &= obj.isSetSign() == isSetSign();
      if (equals && isSetSign()) {
        equals &= (obj.getSign() == getSign());
      }
      equals &= obj.isSetQualitativeSpecies() == isSetQualitativeSpecies();
      if (equals && isSetQualitativeSpecies()) {
        equals &= (obj.getQualitativeSpecies() == getQualitativeSpecies());
      }
      equals &= obj.isSetTransitionEffect() == isSetTransitionEffect();
      if (equals && isSetTransitionEffect()) {
        equals &= (obj.getTransitionEffect() == getTransitionEffect());
      }
      equals &= obj.isSetThresholdLevel() == isSetThresholdLevel();
      if (equals && isSetThresholdLevel()) {
        equals &= (obj.getThresholdLevel() == getThresholdLevel());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Input clone() {
    return new Input(this);
  }

  /**
   * Returns the value of {@link sign}.
   *  
   * @return the value of {@link sign}.
   */
  public Sign getSign() {
    if (isSetSign()) {
      return sign;
    }
    throw new PropertyUndefinedError(QualConstants.sign, this);
  }

  /**
   * Returns the value of {@link qualitativeSpecies}.
   *  
   * @return the value of {@link qualitativeSpecies}.
   */
  public String getQualitativeSpecies() {
    return isSetQualitativeSpecies() ? qualitativeSpecies : "";
  }

  /**
   * Returns the value of {@link transitionEffect}.
   *  
   * @return the value of {@link transitionEffect}.
   */
  public TransitionInputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return transitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.transitionEffect, this);
  }

  /**
   * Returns the value of {@link thresholdLevel}.
   *  
   * @return the value of {@link thresholdLevel}.
   */
  public int getThresholdLevel() {
    if (isSetThresholdLevel()) {
      return thresholdLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.thresholdLevel, this);
  }

  /**
   * Returns whether {@link sign} is set.
   *  
   * @return whether {@link sign} is set.
   */
  public boolean isSetSign() {
    return this.sign != null;
  }

  /**
   * Returns whether {@link qualitativeSpecies} is set.
   *  
   * @return whether {@link qualitativeSpecies} is set.
   */
  public boolean isSetQualitativeSpecies() {
    return this.qualitativeSpecies != null;
  }

  /**
   * Returns whether {@link transitionEffect} is set.
   *  
   * @return whether {@link transitionEffect} is set.
   */
  public boolean isSetTransitionEffect() {
    return this.transitionEffect != null;
  }

  /**
   * Returns whether {@link thresholdLevel} is set.
   *  
   * @return whether {@link thresholdLevel} is set.
   */
  public boolean isSetThresholdLevel() {
    return this.thresholdLevel != null;
  }

  /**
   * Sets the value of sign
   *  
   * @param sign the value of sign to be set.
   */
  public boolean setSign(Sign sign) {
    if (sign != this.sign) {
      Sign oldSign = this.sign;
      this.sign = sign;
      firePropertyChange(QualConstants.sign, oldSign, this.sign);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of qualitativeSpecies
   *  
   * @param qualitativeSpecies the value of qualitativeSpecies to be set.
   */
  public boolean setQualitativeSpecies(String qualitativeSpecies) {
    if (qualitativeSpecies != this.qualitativeSpecies) {
      String oldQualitativeSpecies = this.qualitativeSpecies;
      this.qualitativeSpecies = qualitativeSpecies;
      firePropertyChange(QualConstants.qualitativeSpecies,
        oldQualitativeSpecies, this.qualitativeSpecies);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of transitionEffect
   *  
   * @param transitionEffect the value of transitionEffect to be set.
   */
  public boolean setTransitionEffect(TransitionInputEffect transitionEffect) {
    if (transitionEffect != this.transitionEffect) {
      TransitionInputEffect oldTransitionEffect = this.transitionEffect;
      this.transitionEffect = transitionEffect;
      firePropertyChange(QualConstants.transitionEffect, oldTransitionEffect,
        this.transitionEffect);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of thresholdLevel
   *  
   * @param thresholdLevel the value of thresholdLevel to be set.
   */
  public boolean setThresholdLevel(int thresholdLevel) {
    if (thresholdLevel != this.thresholdLevel) {
      Integer oldThresholdLevel = this.thresholdLevel;
      this.thresholdLevel = thresholdLevel;
      firePropertyChange(QualConstants.thresholdLevel, oldThresholdLevel,
        this.thresholdLevel);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable sign.
   *  
   * @return {@code true} if sign was set before, otherwise {@code false}.
   */
  public boolean unsetSign() {
    if (isSetSign()) {
      Sign oldSign = sign;
      sign = null;
      firePropertyChange(QualConstants.sign, oldSign, sign);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable qualitativeSpecies.
   *  
   * @return {@code true} if qualitativeSpecies was set before, otherwise
   * {@code false}.
   */
  public boolean unsetQualitativeSpecies() {
    if (isSetQualitativeSpecies()) {
      String oldQualitativeSpecies = qualitativeSpecies;
      qualitativeSpecies = null;
      firePropertyChange(QualConstants.qualitativeSpecies,
        oldQualitativeSpecies, qualitativeSpecies);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable transitionEffect.
   *  
   * @return {@code true} if transitionEffect was set before, otherwise {@code
   * false}.
   */
  public boolean unsetTransitionEffect() {
    if (isSetTransitionEffect()) {
      TransitionInputEffect oldTransitionEffect = transitionEffect;
      transitionEffect = null;
      firePropertyChange(QualConstants.transitionEffect, oldTransitionEffect,
        transitionEffect);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable thresholdLevel.
   *  
   * @return {@code true} if thresholdLevel was set before, otherwise {@code
   * false}.
   */
  public boolean unsetThresholdLevel() {
    if (isSetThresholdLevel()) {
      Integer oldThresholdLevel = thresholdLevel;
      thresholdLevel = null;
      firePropertyChange(QualConstants.thresholdLevel, oldThresholdLevel,
        thresholdLevel);
      return true;
    }
    return false;
  }

  /* hashcode method for Input.
   */
  @Override
  public int hashCode() {
    final int prime = 3252779;

    int hashCode = super.hashCode();

    if (isSetSign()) {
      hashCode += prime * getSign().hashCode();
    }
    if (isSetQualitativeSpecies()) {
      hashCode += prime * getQualitativeSpecies().hashCode();
    }
    if (isSetTransitionEffect()) {
      hashCode += prime * getTransitionEffect().hashCode();
    }
    if (isSetThresholdLevel()) {
      hashCode += prime * getThresholdLevel();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Input [");
    builder.append("sign = ");
    builder.append(sign);
    builder.append(", ");
    builder.append("qualitativeSpecies = ");
    builder.append(qualitativeSpecies);
    builder.append(", ");
    builder.append("transitionEffect = ");
    builder.append(transitionEffect);
    builder.append(", ");
    builder.append("thresholdLevel = ");
    builder.append(thresholdLevel);
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

      if (attributeName.equals(QualConstants.sign)) {
        try {
          setSign(Sign.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + QualConstants.sign + " on the 'Input' element.");
        }
      }      else if (attributeName.equals(QualConstants.qualitativeSpecies)) {
        setQualitativeSpecies(value);
      }      else if (attributeName.equals(QualConstants.transitionEffect)) {
        try {
          setTransitionEffect(TransitionInputEffect.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + QualConstants.transitionEffect + " on the 'Input' element.");
        }
      }      else if (attributeName.equals(QualConstants.thresholdLevel)) {
        setThresholdLevel(StringTools.parseSBMLInt(value));
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
    if (isSetSign()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.sign,
        getSign().toString());
    }
    if (isSetQualitativeSpecies()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.qualitativeSpecies,
        getQualitativeSpecies());
    }
    if (isSetTransitionEffect()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.transitionEffect,
        getTransitionEffect().toString());
    }
    if (isSetThresholdLevel()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.thresholdLevel,
        Integer.toString(getThresholdLevel()));
    }
    return attributes;
  }

}
