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
public class Objective {

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
  private FbcType mType;
  /**
   * @return the value of the "id" attribute of this Objective.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "name" attribute of this Objective.
   */
  public String getName() {
    return isSetName() ? mName : "";
  }

  /**
   * @return the value of the "type" attribute of this Objective.
   */
  public FbcType getType() {
    if (isSetType()) {
      return mType;
    }
    throw new PropertyUndefinedError(FbcConstants.mType, this);
  }

  /**
   * Predicate returning {@code true} if this Objective's "id" attribute is
   * set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this Objective's "name" attribute is
   * set.
   */
  public boolean isSetName() {
    ;
  }

  /**
   * Predicate returning {@code true} if this Objective's "type" attribute is
   * set.
   */
  public boolean isSetType() {
    return (mType != FBC_TYPE_INVALID);
  }

  /**
   * Sets the value of the "id" attribute of this Objective.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "name" attribute of this Objective.
   */
  public void setName(String name) {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of the "type" attribute of this Objective.
   */
  public void setType(FbcType type) {
    if (FbcType_isValid(type) == 0) {
      mType = FBC_TYPE_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      mType = type;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * Unsets the value of the "id" attribute of this Objective.
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
   * Unsets the value of the "name" attribute of this Objective.
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
   * Unsets the value of the "type" attribute of this Objective.
   */
  public boolean unsetType() {
    mType = FBC_TYPE_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

}
