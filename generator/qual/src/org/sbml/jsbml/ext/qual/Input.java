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
    }  }

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

  /* Assignment operator for Input.
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
      return equals;
    }  }

  /**
   * (non-Javadoc)
   */
  public Input clone() {
    return new Input(this);
  }

  /**
   * @return the sign
   */
  public Sign getSign() {
    if (isSetSign()) {
      return sign;
    }
    throw new PropertyUndefinedError(QualConstants.sign, this);
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
  public TransitionInputEffect getTransitionEffect() {
    if (isSetTransitionEffect()) {
      return transitionEffect;
    }
    throw new PropertyUndefinedError(QualConstants.transitionEffect, this);
  }

  /**
   * @return the thresholdLevel
   */
  public int getThresholdLevel() {
    if (isSetThresholdLevel()) {
      return thresholdLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.thresholdLevel, this);
  }

  /**
   * @return 
   */
  public boolean isSetSign() {
    return (sign != SIGN_INVALID);
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
    return (transitionEffect != TRANSITION_INPUT_EFFECT_INVALID);
  }

  /**
   * @return 
   */
  public boolean isSetThresholdLevel() {
    return thresholdLevel != null;
  }

  /**
   * @param sign
   */
  public void setSign(Sign sign) {
    if (Sign_isValid(sign) == 0) {
      sign = SIGN_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      sign = sign;
      return LIBSBML_OPERATION_SUCCESS;
    }
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
  public void setTransitionEffect(TransitionInputEffect transitionEffect) {
    if (TransitionInputEffect_isValid(transitionEffect) == 0) {
      transitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      transitionEffect = transitionEffect;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * @param thresholdLevel
   */
  public void setThresholdLevel(int thresholdLevel) {
    Integer oldThresholdLevel = this.thresholdLevel;
    this.thresholdLevel = thresholdLevel;
    firePropertyChange(QualConstants.thresholdLevel, oldThresholdLevel,
      this.thresholdLevel);
  }

  /**
   * @return {@code true} if the unset of the sign attribute was successful
   */
  public boolean unsetSign() {
    sign = SIGN_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
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
    transitionEffect = TRANSITION_INPUT_EFFECT_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * @return {@code true} if the unset of the thresholdLevel attribute was
   * successful
   */
  public boolean unsetThresholdLevel() {
    if (isSetThresholdLevel()) {
      Integer oldThresholdLevel = thresholdLevel;
      thresholdLevel = null;
      firePropertyChange(QualConstants.thresholdLevel, oldThresholdLevel,
        thresholdLevel);
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
   * @return true
   */
  public boolean isQualitativeSpeciesMandatory() {
    return true;
  }

  /**
   * @return false
   */
  public boolean isSignMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isThresholdLevelMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isTransitionEffectMandatory() {
    return false;
  }

  /**
   * @copydoc doc_renamesidref_common
   */
  public void renameSIdRefs(const std::string& oldid, const std::string& newid) {
    if (isSetQualitativeSpecies() && mQualitativeSpecies == oldid) {
      setQualitativeSpecies(newid);
    }  }

  /**
   * For Input, the XML element name is always @c "input".
   */
  public const std::string& getElementName() {
    static const string name = "input";
    return name;
  }

  public int getTypeCode() {
    return SBML_QUAL_INPUT;
  }

  public bool hasRequiredAttributes() {
    bool allPresent = true;

    if (isSetQualitativeSpecies() == false) {
      allPresent = false;
    }
    return allPresent;
  }


  /** @cond doxygenJSBMLInternal */

  /**
   * Write any contained elements
   */
  public void writeElements(XMLOutputStream& stream) {
    SBase::writeElements(stream);

    SBase::writeExtensionElements(stream);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Accepts the given SBMLVisitor
   */
  public bool accept(SBMLVisitor& v) {
    return v.visit(*this);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Sets the parent SBMLDocument
   */
  public void setSBMLDocument(SBMLDocument* d) {
    SBase::setSBMLDocument(d);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Enables/disables the given package with this element
   */
  public void enablePackageInternal(const std::string& pkgURI, {
                                    const std::string& pkgPrefix, {
                                    bool flag) {
    SBase::enablePackageInternal(pkgURI, pkgPrefix, flag);
  }

  /** @endcond */


}
