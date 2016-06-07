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
package org.sbml.jsbml.ext.qual

import org.sbml.jsbml.Reaction;
import org.sbml.jsbml.FunctionDefinition;
import org.sbml.jsbml.SimpleSpeciesReference;
import org.sbml.jsbml.Model;
import org.sbml.jsbml.SpeciesType;
import org.sbml.jsbml.CompartmentType;
import org.sbml.jsbml.UnitDefintion;
import org.sbml.jsbml.AbstractNamedSBaseWithUnit;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class Input {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
  /**
   *
   */
  private String mId;
  /**
   *
   */
  private String mName;
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
   * @return the value of the "id" attribute of this Input.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "name" attribute of this Input.
   */
  public String getName() {
    return isSetName() ? mName : "";
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
   * Predicate returning {@code true} if this Input's "id" attribute is set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this Input's "name" attribute is set.
   */
  public boolean isSetName() {
    ;
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
    ;
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
   * Sets the value of the "id" attribute of this Input.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "name" attribute of this Input.
   */
  public void setName(String name) {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of the "sign" attribute of this Input.
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
   * Sets the value of the "qualitativeSpecies" attribute of this Input.
   */
  public boolean setQualitativeSpecies(String qualitativeSpecies) {
    if (qualitativeSpecies != this.mQualitativeSpecies) {
      String oldmQualitativeSpecies = this.mQualitativeSpecies;
      if ((qualitativeSpecies == null) || (qualitativeSpecies.length() == 0) {
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
   * Sets the value of the "transitionEffect" attribute of this Input.
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
   * Sets the value of the "thresholdLevel" attribute of this Input.
   */
  public void setThresholdLevel(int thresholdLevel) {
    Integer oldmThresholdLevel = this.mThresholdLevel;

    this.oldmThresholdLevel = thresholdLevel;

    firePropertyChange(QualConstants.mThresholdLevel, oldmThresholdLevel,
      this.oldmThresholdLevel);
  }

  /**
   * Unsets the value of the "id" attribute of this Input.
   */
  public boolean unsetId() {
    if (isSetId()) {
      mId = null;
      firePropertyChange(QualConstants.mId, oldmId, mId);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "name" attribute of this Input.
   */
  public boolean unsetName() {
    if (isSetName()) {
      mName = null;
      firePropertyChange(QualConstants.mName, oldmName, mName);
      return true;
    } else {
      return false;
    }
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
