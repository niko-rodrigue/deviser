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
    }  }

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

  /* Assignment operator for Output.
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
      return equals;
    }  }

  /**
   * (non-Javadoc)
   */
  public Output clone() {
    return new Output(this);
  }

  /**
   * @return the qualitativeSpecies
   */
  public String getQualitativeSpecies() {
    return isSetQualitativeSpecies() ? qualitativeSpecies : "";
  }

  /**
   * @return the qualitativeSpecies
   */
  public QualitativeSpecies getQualitativeSpeciesInstance() {
    if (isSetQualitativeSpecies()) {
      Model model = getModel();
      if (model != null) {
        return model.getQualitativeSpecies(getQualitativeSpecies());
      }
    }
    return null;
  }

  /**
   * @return the transitionEffect
   */
  public TransitionOutputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return transitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.transitionEffect, this);
  }

  /**
   * @return the outputLevel
   */
  public int getOutputLevel() {
    if (isSetOutputLevel()) {
      return outputLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.outputLevel, this);
  }

  /**
   * @return 
   */
  public boolean isSetQualitativeSpecies() {
    return qualitativeSpecies != null;
  }

  /**
   * @return 
   */
  public boolean isSetQualitativeSpeciesInstance() {
    return getQualitativeSpeciesInstance() != null;
  }

  /**
   * @return 
   */
  public boolean isSetTransitionEffect() {
    return (transitionEffect != TRANSITION_OUTPUT_EFFECT_INVALID);
  }

  /**
   * @return 
   */
  public boolean isSetOutputLevel() {
    return outputLevel != null;
  }

  /**
   * @param qualitativeSpecies
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
        oldQualitativeSpecies, this.qualitativeSpecies);
      return true;
    }
    return false;
  }

  /**
   * @param transitionEffect
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
   * @param outputLevel
   */
  public void setOutputLevel(int outputLevel) {
    Integer oldOutputLevel = this.outputLevel;
    this.outputLevel = outputLevel;
    firePropertyChange(QualConstants.outputLevel, oldOutputLevel,
      this.outputLevel);
  }

  /**
   * @return {@code true} if the unset of the qualitativeSpecies attribute was
   * successful
   */
  public boolean unsetQualitativeSpecies() {
    return setQualitativeSpecies((String) null);
  }

  /**
   * @return {@code true} if the unset of the transitionEffect attribute was
   * successful
   */
  public boolean unsetTransitionEffect() {
    transitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * @return {@code true} if the unset of the outputLevel attribute was
   * successful
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

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isOutputLevelMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isQualitativeSpeciesMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isTransitionEffectMandatory() {
    return false;
  }

}
