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
package org.sbml.jsbml.ext.fbc

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class FluxObjective {

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
  private String mReaction;
  /**
   *
   */
  private Double mCoefficient;
  /**
   * @return the value of the "id" attribute of this FluxObjective.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "name" attribute of this FluxObjective.
   */
  public String getName() {
    return isSetName() ? mName : "";
  }

  /**
   * @return the value of the "reaction" attribute of this FluxObjective.
   */
  public String getReaction() {
    return isSetReaction() ? mReaction : "";
  }

  /**
   * @return the value of the "coefficient" attribute of this FluxObjective.
   */
  public double getCoefficient() {
    if (isSetCoefficient()) {
      return mCoefficient.doubleValue();
    }
    throw new PropertyUndefinedError(FbcConstants.mCoefficient, this);
  }

  /**
   * Predicate returning {@code true} if this FluxObjective's "id" attribute is
   * set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this FluxObjective's "name" attribute
   * is set.
   */
  public boolean isSetName() {
    ;
  }

  /**
   * Predicate returning {@code true} if this FluxObjective's "reaction"
   * attribute is set.
   */
  public boolean isSetReaction() {
    ;
  }

  /**
   * Predicate returning {@code true} if this FluxObjective's "coefficient"
   * attribute is set.
   */
  public boolean isSetCoefficient() {
    return mCoefficient != null;
  }

  /**
   * Sets the value of the "id" attribute of this FluxObjective.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "name" attribute of this FluxObjective.
   */
  public void setName(String name) {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of the "reaction" attribute of this FluxObjective.
   */
  public boolean setReaction(String reaction) {
    if (reaction != this.mReaction) {
      String oldmReaction = this.mReaction;
      if ((reaction == null) || (reaction.length() == 0) {
        this.mReaction = null;
      } else {
        this.mReaction = reaction;
      }

      firePropertyChange(FbcConstants.mReaction, oldmReaction,
        this.oldmReaction);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of the "coefficient" attribute of this FluxObjective.
   */
  public void setCoefficient(double coefficient) {
    Double oldmCoefficient = this.mCoefficient;

    this.oldmCoefficient = coefficient;

    firePropertyChange(FbcConstants.mCoefficient, oldmCoefficient,
      this.oldmCoefficient);
  }

  /**
   * Unsets the value of the "id" attribute of this FluxObjective.
   */
  public boolean unsetId() {
    if (isSetId()) {
      mId = null;
      firePropertyChange(FbcConstants.mId, oldmId, mId);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "name" attribute of this FluxObjective.
   */
  public boolean unsetName() {
    if (isSetName()) {
      mName = null;
      firePropertyChange(FbcConstants.mName, oldmName, mName);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "reaction" attribute of this FluxObjective.
   */
  public boolean unsetReaction() {
    if (isSetReaction()) {
      mReaction = null;
      firePropertyChange(FbcConstants.mReaction, oldmReaction, mReaction);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "coefficient" attribute of this FluxObjective.
   */
  public boolean unsetCoefficient() {
    if (isSetCoefficient()) {
      Double oldmCoefficient = mCoefficient;
      mCoefficient = null;
      firePropertyChange(FbcConstants.mCoefficient, oldmCoefficient,
        mCoefficient);
      return true;
    } else {
      return false;
    }
  }

}
