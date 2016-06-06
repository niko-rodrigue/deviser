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
package org.sbml.jsbml.ext.spatial

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class GeometryDefinition {

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
  private Boolean mIsActive;
  /**
   * @return the value of the "id" attribute of this GeometryDefinition.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "isActive" attribute of this GeometryDefinition.
   */
  public boolean getIsActive() {
    if (isSetIsActive()) {
      return mIsActive.booleanValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.mIsActive, this);
  }

  /**
   * Predicate returning {@code true} if this GeometryDefinition's "id"
   * attribute is set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this GeometryDefinition's "isActive"
   * attribute is set.
   */
  public boolean isSetIsActive() {
    return mIsActive != null;
  }

  /**
   * Sets the value of the "id" attribute of this GeometryDefinition.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "isActive" attribute of this GeometryDefinition.
   */
  public void setIsActive(boolean isActive) {
    Boolean oldmIsActive = this.mIsActive;

    this.oldmIsActive = isActive;

    firePropertyChange(SpatialConstants.mIsActive, oldmIsActive,
      this.oldmIsActive);
  }

  /**
   * Unsets the value of the "id" attribute of this GeometryDefinition.
   */
  public boolean unsetId() {
    if (isSetId()) {
      mId = null;
      firePropertyChange(SpatialConstants.mId, oldmId, mId);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "isActive" attribute of this GeometryDefinition.
   */
  public boolean unsetIsActive() {
    if (isSetIsActive()) {
      Boolean oldmIsActive = mIsActive;
      mIsActive = null;
      firePropertyChange(SpatialConstants.mIsActive, oldmIsActive, mIsActive);
      return true;
    } else {
      return false;
    }
  }

}
