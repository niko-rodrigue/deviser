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
public class Output extends AbstractNamedSBase implements UniqueNamedSBase, CallableSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
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
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    qualitativeSpecies = null;
    transitionEffect = null;
    outputLevel = null;
  }

  /**
   * (non-Javadoc)
   */
  @Override
  public Output clone() {
    return new Output(this);
  }

  /**
   * @return the value of the "qualitativeSpecies" attribute of this Output.
   */
  public String getQualitativeSpecies() {
    return isSetQualitativeSpecies() ? qualitativeSpecies : "";
  }

  /**
   * @return the value of the "transitionEffect" attribute of this Output.
   */
  public TransitionOutputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return transitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.transitionEffect, this);
  }

  /**
   * @return the value of the "outputLevel" attribute of this Output.
   */
  public int getOutputLevel() {
    if (isSetOutputLevel()) {
      return outputLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.outputLevel, this);
  }

  /**
   * Predicate returning {@code true} if this Output's "qualitativeSpecies"
   * attribute is set.
   */
  public boolean isSetQualitativeSpecies() {
    return qualitativeSpecies != null;
  }

  /**
   * Predicate returning {@code true} if this Output's "transitionEffect"
   * attribute is set.
   */
  public boolean isSetTransitionEffect() {
    return (transitionEffect != TRANSITION_OUTPUT_EFFECT_INVALID);
  }

  /**
   * Predicate returning {@code true} if this Output's "outputLevel" attribute
   * is set.
   */
  public boolean isSetOutputLevel() {
    return outputLevel != null;
  }

  /**
   * @param qualitativeSpecies String value of the "qualitativeSpecies"
   * attribute to be set.
   */
  public boolean setQualitativeSpecies(String qualitativeSpecies) {
    if (qualitativeSpecies != this.qualitativeSpecies) {
      String oldQualitativeSpecies = this.qualitativeSpecies;
      if ((qualitativeSpecies == null) || (qualitativeSpecies.isEmpty())) {
        this.qualitativeSpecies = null;
      } else {
        this.qualitativeSpecies = qualitativeSpecies;
      }

      firePropertyChange(QualConstants.qualitativeSpecies,
        oldQualitativeSpecies, this.oldQualitativeSpecies);
      return true;
    }
    return false;
  }

  /**
   * @param transitionEffect TransitionOutputEffect value of the
   * "transitionEffect" attribute to be set.
   */
  public void setTransitionEffect(TransitionOutputEffect transitionEffect) {
    if (TransitionOutputEffect_isValid(transitionEffect) == 0) {
      transitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      transitionEffect = transitionEffect;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * @param outputLevel int value of the "outputLevel" attribute to be set.
   */
  public void setOutputLevel(int outputLevel) {
    Integer oldOutputLevel = this.outputLevel;
    this.outputLevel = outputLevel;
    firePropertyChange(QualConstants.outputLevel, oldOutputLevel,
      this.outputLevel);
  }

  /**
   * Unsets the value of the "qualitativeSpecies" attribute of this Output.
   */
  public boolean unsetQualitativeSpecies() {
    if (isSetQualitativeSpecies()) {
      qualitativeSpecies = null;
      firePropertyChange(QualConstants.qualitativeSpecies,
        oldQualitativeSpecies, qualitativeSpecies);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "transitionEffect" attribute of this Output.
   */
  public boolean unsetTransitionEffect() {
    transitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Unsets the value of the "outputLevel" attribute of this Output.
   */
  public boolean unsetOutputLevel() {
    if (isSetOutputLevel()) {
      Integer oldOutputLevel = outputLevel;
      outputLevel = null;
      firePropertyChange(QualConstants.outputLevel, oldOutputLevel,
        outputLevel);
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

}
