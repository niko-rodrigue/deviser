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
public class CompartmentMapping {

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
  private String mDomainType;
  /**
   *
   */
  private Double mUnitSize;
  /**
   * @return the value of the "id" attribute of this CompartmentMapping.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "domainType" attribute of this
   * CompartmentMapping.
   */
  public String getDomainType() {
    return isSetDomainType() ? mDomainType : "";
  }

  /**
   * @return the value of the "unitSize" attribute of this CompartmentMapping.
   */
  public double getUnitSize() {
    if (isSetUnitSize()) {
      return mUnitSize.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.mUnitSize, this);
  }

  /**
   * Predicate returning {@code true} if this CompartmentMapping's "id"
   * attribute is set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this CompartmentMapping's "domainType"
   * attribute is set.
   */
  public boolean isSetDomainType() {
    ;
  }

  /**
   * Predicate returning {@code true} if this CompartmentMapping's "unitSize"
   * attribute is set.
   */
  public boolean isSetUnitSize() {
    return mUnitSize != null;
  }

  /**
   * Sets the value of the "id" attribute of this CompartmentMapping.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "domainType" attribute of this CompartmentMapping.
   */
  public boolean setDomainType(String domainType) {
    if (domainType != this.mDomainType) {
      String oldmDomainType = this.mDomainType;
      if ((domainType == null) || (domainType.length() == 0) {
        this.mDomainType = null;
      } else {
        this.mDomainType = domainType;
      }

      firePropertyChange(SpatialConstants.mDomainType, oldmDomainType,
        this.oldmDomainType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of the "unitSize" attribute of this CompartmentMapping.
   */
  public void setUnitSize(double unitSize) {
    Double oldmUnitSize = this.mUnitSize;

    this.oldmUnitSize = unitSize;

    firePropertyChange(SpatialConstants.mUnitSize, oldmUnitSize,
      this.oldmUnitSize);
  }

  /**
   * Unsets the value of the "id" attribute of this CompartmentMapping.
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
   * Unsets the value of the "domainType" attribute of this CompartmentMapping.
   */
  public boolean unsetDomainType() {
    if (isSetDomainType()) {
      mDomainType = null;
      firePropertyChange(SpatialConstants.mDomainType, oldmDomainType,
        mDomainType);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "unitSize" attribute of this CompartmentMapping.
   */
  public boolean unsetUnitSize() {
    if (isSetUnitSize()) {
      Double oldmUnitSize = mUnitSize;
      mUnitSize = null;
      firePropertyChange(SpatialConstants.mUnitSize, oldmUnitSize, mUnitSize);
      return true;
    } else {
      return false;
    }
  }

}
