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
public class Input extends AbstractNamedSBase implements UniqueNamedSBase, CallableSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
  /**
   *
   */
  private Sign mSign;
  /**
   *
   */
  private String mQualitativeSpecies;
  /**
   *
   */
  private TransitionInputEffect mTransitionEffect;
  /**
   *
   */
  private Integer mThresholdLevel;

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
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    mSign = null;
    mQualitativeSpecies = null;
    mTransitionEffect = null;
    mThresholdLevel = null;
  }

  /**
   * @return the value of the "sign" attribute of this Input.
   */
  public Sign getSign() {
    if (isSetSign()) {
      return mSign;
    }
    throw new PropertyUndefinedError(QualConstants.mSign, this);
  }

  /**
   * @return the value of the "qualitativeSpecies" attribute of this Input.
   */
  public String getQualitativeSpecies() {
    return isSetQualitativeSpecies() ? mQualitativeSpecies : "";
  }

  /**
   * @return the value of the "transitionEffect" attribute of this Input.
   */
  public TransitionInputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return mTransitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.mTransitionEffect, this);
  }

  /**
   * @return the value of the "thresholdLevel" attribute of this Input.
   */
  public int getThresholdLevel() {
    if (isSetThresholdLevel()) {
      return mThresholdLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.mThresholdLevel, this);
  }

  /**
   * Predicate returning {@code true} if this Input's "sign" attribute is set.
   */
  public boolean isSetSign() {
    return (mSign != SIGN_INVALID);
  }

  /**
   * Predicate returning {@code true} if this Input's "qualitativeSpecies"
   * attribute is set.
   */
  public boolean isSetQualitativeSpecies() {
    return mQualitativeSpecies != null;
  }

  /**
   * Predicate returning {@code true} if this Input's "transitionEffect"
   * attribute is set.
   */
  public boolean isSetTransitionEffect() {
    return (mTransitionEffect != TRANSITION_INPUT_EFFECT_INVALID);
  }

  /**
   * Predicate returning {@code true} if this Input's "thresholdLevel"
   * attribute is set.
   */
  public boolean isSetThresholdLevel() {
    return mThresholdLevel != null;
  }

  /**
   * @param sign Sign value of the "sign" attribute to be set.
   */
  public void setSign(Sign sign) {
    if (Sign_isValid(sign) == 0) {
      mSign = SIGN_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      mSign = sign;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * @param qualitativeSpecies String value of the "qualitativeSpecies"
   * attribute to be set.
   */
  public boolean setQualitativeSpecies(String qualitativeSpecies) {
    if (qualitativeSpecies != this.mQualitativeSpecies) {
      String oldmQualitativeSpecies = this.mQualitativeSpecies;
      if ((qualitativeSpecies == null) || (qualitativeSpecies.isEmpty())) {
        this.mQualitativeSpecies = null;
      } else {
        this.mQualitativeSpecies = qualitativeSpecies;
      }

      firePropertyChange(QualConstants.mQualitativeSpecies,
        oldmQualitativeSpecies, this.oldmQualitativeSpecies);
      return true;
    }
    return false;
  }

  /**
   * @param transitionEffect TransitionInputEffect value of the
   * "transitionEffect" attribute to be set.
   */
  public void setTransitionEffect(TransitionInputEffect transitionEffect) {
    if (TransitionInputEffect_isValid(transitionEffect) == 0) {
      mTransitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      mTransitionEffect = transitionEffect;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * @param thresholdLevel int value of the "thresholdLevel" attribute to be
   * set.
   */
  public void setThresholdLevel(int thresholdLevel) {
    Integer oldmThresholdLevel = this.mThresholdLevel;

    this.oldmThresholdLevel = thresholdLevel;

    firePropertyChange(QualConstants.mThresholdLevel, oldmThresholdLevel,
      this.oldmThresholdLevel);
  }

  /**
   * Unsets the value of the "sign" attribute of this Input.
   */
  public boolean unsetSign() {
    mSign = SIGN_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Unsets the value of the "qualitativeSpecies" attribute of this Input.
   */
  public boolean unsetQualitativeSpecies() {
    if (isSetQualitativeSpecies()) {
      mQualitativeSpecies = null;
      firePropertyChange(QualConstants.mQualitativeSpecies,
        oldmQualitativeSpecies, mQualitativeSpecies);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "transitionEffect" attribute of this Input.
   */
  public boolean unsetTransitionEffect() {
    mTransitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Unsets the value of the "thresholdLevel" attribute of this Input.
   */
  public boolean unsetThresholdLevel() {
    if (isSetThresholdLevel()) {
      Integer oldmThresholdLevel = mThresholdLevel;
      mThresholdLevel = null;
      firePropertyChange(QualConstants.mThresholdLevel, oldmThresholdLevel,
        mThresholdLevel);
      return true;
    } else {
      return false;
    }
  }

}
