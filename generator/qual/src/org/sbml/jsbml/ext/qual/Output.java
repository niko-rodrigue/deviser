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
public class Output {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
  /**
   *
   */
  private String mQualitativeSpecies;
  /**
   *
   */
  private TransitionOutputEffect mTransitionEffect;
  /**
   *
   */
  private Integer mOutputLevel;
  /**
   * @return the value of the "qualitativeSpecies" attribute of this Output.
   */
  public String getQualitativeSpecies() {
    return isSetQualitativeSpecies() ? mQualitativeSpecies : "";
  }

  /**
   * @return the value of the "transitionEffect" attribute of this Output.
   */
  public TransitionOutputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return mTransitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.mTransitionEffect, this);
  }

  /**
   * @return the value of the "outputLevel" attribute of this Output.
   */
  public int getOutputLevel() {
    if (isSetOutputLevel()) {
      return mOutputLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.mOutputLevel, this);
  }

  /**
   * Predicate returning {@code true} if this Output's "qualitativeSpecies"
   * attribute is set.
   */
  public boolean isSetQualitativeSpecies() {
    return mQualitativeSpecies != null;
  }

  /**
   * Predicate returning {@code true} if this Output's "transitionEffect"
   * attribute is set.
   */
  public boolean isSetTransitionEffect() {
    return (mTransitionEffect != TRANSITION_OUTPUT_EFFECT_INVALID);
  }

  /**
   * Predicate returning {@code true} if this Output's "outputLevel" attribute
   * is set.
   */
  public boolean isSetOutputLevel() {
    return mOutputLevel != null;
  }

  /**
   * Sets the value of the "qualitativeSpecies" attribute of this Output.
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
   * Sets the value of the "transitionEffect" attribute of this Output.
   */
  public void setTransitionEffect(TransitionOutputEffect transitionEffect) {
    if (TransitionOutputEffect_isValid(transitionEffect) == 0) {
      mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      mTransitionEffect = transitionEffect;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * Sets the value of the "outputLevel" attribute of this Output.
   */
  public void setOutputLevel(int outputLevel) {
    Integer oldmOutputLevel = this.mOutputLevel;

    this.oldmOutputLevel = outputLevel;

    firePropertyChange(QualConstants.mOutputLevel, oldmOutputLevel,
      this.oldmOutputLevel);
  }

  /**
   * Unsets the value of the "qualitativeSpecies" attribute of this Output.
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
   * Unsets the value of the "transitionEffect" attribute of this Output.
   */
  public boolean unsetTransitionEffect() {
    mTransitionEffect = TRANSITION_OUTPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Unsets the value of the "outputLevel" attribute of this Output.
   */
  public boolean unsetOutputLevel() {
    if (isSetOutputLevel()) {
      Integer oldmOutputLevel = mOutputLevel;
      mOutputLevel = null;
      firePropertyChange(QualConstants.mOutputLevel, oldmOutputLevel,
        mOutputLevel);
      return true;
    } else {
      return false;
    }
  }

}
