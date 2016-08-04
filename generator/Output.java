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
public class Output extends AbstractNamedSBase implements UniqueNamedSBase, CallableSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 31713216476078760L;
  /**
   *
   */
  private String qualitativeSpecies;
  /**
   *
   */
  private TransitionOutputEffect transitionEffect;
  /**
   *
   */
  private Integer outputLevel;

  /**
   *  
   */
  public Output() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Output(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Output(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Output(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Output(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Output instance to copy.
   */
  public Output(Output orig) {
    super(orig);

    if (orig.isSetQualitativeSpecies()) {
      setQualitativeSpecies(orig.getQualitativeSpecies());
    }
    if (orig.isSetTransitionEffect()) {
      setTransitionEffect(orig.getTransitionEffect());
    }
    if (orig.isSetOutputLevel()) {
      setOutputLevel(orig.getOutputLevel());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    qualitativeSpecies = null;
    transitionEffect = null;
    outputLevel = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Output obj = (Output) object;

      equals &= obj.isSetQualitativeSpecies() == isSetQualitativeSpecies();
      if (equals && isSetQualitativeSpecies()) {
        equals &= (obj.getQualitativeSpecies() == getQualitativeSpecies());
      }
      equals &= obj.isSetTransitionEffect() == isSetTransitionEffect();
      if (equals && isSetTransitionEffect()) {
        equals &= (obj.getTransitionEffect() == getTransitionEffect());
      }
      equals &= obj.isSetOutputLevel() == isSetOutputLevel();
      if (equals && isSetOutputLevel()) {
        equals &= (obj.getOutputLevel() == getOutputLevel());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Output clone() {
    return new Output(this);
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
  public TransitionOutputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return transitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.transitionEffect, this);
  }

  /**
   * Returns the value of {@link outputLevel}.
   *  
   * @return the value of {@link outputLevel}.
   */
  public int getOutputLevel() {
    if (isSetOutputLevel()) {
      return outputLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.outputLevel, this);
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
   * Returns whether {@link outputLevel} is set.
   *  
   * @return whether {@link outputLevel} is set.
   */
  public boolean isSetOutputLevel() {
    return this.outputLevel != null;
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
  public boolean setTransitionEffect(TransitionOutputEffect transitionEffect) {
    if (transitionEffect != this.transitionEffect) {
      TransitionOutputEffect oldTransitionEffect = this.transitionEffect;
      this.transitionEffect = transitionEffect;
      firePropertyChange(QualConstants.transitionEffect, oldTransitionEffect,
        this.transitionEffect);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of outputLevel
   *  
   * @param outputLevel the value of outputLevel to be set.
   */
  public boolean setOutputLevel(int outputLevel) {
    if (outputLevel != this.outputLevel) {
      Integer oldOutputLevel = this.outputLevel;
      this.outputLevel = outputLevel;
      firePropertyChange(QualConstants.outputLevel, oldOutputLevel,
        this.outputLevel);
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
      TransitionOutputEffect oldTransitionEffect = transitionEffect;
      transitionEffect = null;
      firePropertyChange(QualConstants.transitionEffect, oldTransitionEffect,
        transitionEffect);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable outputLevel.
   *  
   * @return {@code true} if outputLevel was set before, otherwise {@code
   * false}.
   */
  public boolean unsetOutputLevel() {
    if (isSetOutputLevel()) {
      Integer oldOutputLevel = outputLevel;
      outputLevel = null;
      firePropertyChange(QualConstants.outputLevel, oldOutputLevel,
        outputLevel);
      return true;
    }
    return false;
  }

  /* hashcode method for Output.
   */
  @Override
  public int hashCode() {
    final int prime = 7067513;

    int hashCode = super.hashCode();

    if (isSetQualitativeSpecies()) {
      hashCode += prime * getQualitativeSpecies().hashCode();
    }
    if (isSetTransitionEffect()) {
      hashCode += prime * getTransitionEffect().hashCode();
    }
    if (isSetOutputLevel()) {
      hashCode += prime;
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Output [");
    builder.append("qualitativeSpecies = ");
    builder.append(qualitativeSpecies);
    builder.append(", ");
    builder.append("transitionEffect = ");
    builder.append(transitionEffect);
    builder.append(", ");
    builder.append("outputLevel = ");
    builder.append(outputLevel);
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

      if (attributeName.equals(QualConstants.qualitativeSpecies)) {
        setQualitativeSpecies(value);
      }      else if (attributeName.equals(QualConstants.transitionEffect)) {
        try {
          setTransitionEffect(TransitionOutputEffect.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + QualConstants.transitionEffect + " on the 'Output' element.");
        }
      }      else if (attributeName.equals(QualConstants.outputLevel)) {
        setOutputLevel(StringTools.parseSBMLInt(value));
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
    if (isSetQualitativeSpecies()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.qualitativeSpecies,
        getQualitativeSpecies());
    }
    if (isSetTransitionEffect()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.transitionEffect,
        getTransitionEffect().toString());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(QualConstants.shortLabel + ":name", getName());
    }
    if (isSetOutputLevel()) {
      attributes.put(QualConstants.shortLabel + ":" + QualConstants.outputLevel,
        Integer.toString(getOutputLevel()));
    }
    return attributes;
  }

}
