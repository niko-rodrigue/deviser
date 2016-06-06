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
public class InteriorPoint {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
  /**
   *
   */
  private Double mCoord1;
  /**
   *
   */
  private Double mCoord2;
  /**
   *
   */
  private Double mCoord3;
  /**
   * @return the value of the "coord1" attribute of this InteriorPoint.
   */
  public double getCoord1() {
    if (isSetCoord1()) {
      return mCoord1.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.mCoord1, this);
  }

  /**
   * @return the value of the "coord2" attribute of this InteriorPoint.
   */
  public double getCoord2() {
    if (isSetCoord2()) {
      return mCoord2.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.mCoord2, this);
  }

  /**
   * @return the value of the "coord3" attribute of this InteriorPoint.
   */
  public double getCoord3() {
    if (isSetCoord3()) {
      return mCoord3.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.mCoord3, this);
  }

  /**
   * Predicate returning {@code true} if this InteriorPoint's "coord1"
   * attribute is set.
   */
  public boolean isSetCoord1() {
    return mCoord1 != null;
  }

  /**
   * Predicate returning {@code true} if this InteriorPoint's "coord2"
   * attribute is set.
   */
  public boolean isSetCoord2() {
    return mCoord2 != null;
  }

  /**
   * Predicate returning {@code true} if this InteriorPoint's "coord3"
   * attribute is set.
   */
  public boolean isSetCoord3() {
    return mCoord3 != null;
  }

  /**
   * Sets the value of the "coord1" attribute of this InteriorPoint.
   */
  public void setCoord1(double coord1) {
    Double oldmCoord1 = this.mCoord1;

    this.oldmCoord1 = coord1;

    firePropertyChange(SpatialConstants.mCoord1, oldmCoord1, this.oldmCoord1);
  }

  /**
   * Sets the value of the "coord2" attribute of this InteriorPoint.
   */
  public void setCoord2(double coord2) {
    Double oldmCoord2 = this.mCoord2;

    this.oldmCoord2 = coord2;

    firePropertyChange(SpatialConstants.mCoord2, oldmCoord2, this.oldmCoord2);
  }

  /**
   * Sets the value of the "coord3" attribute of this InteriorPoint.
   */
  public void setCoord3(double coord3) {
    Double oldmCoord3 = this.mCoord3;

    this.oldmCoord3 = coord3;

    firePropertyChange(SpatialConstants.mCoord3, oldmCoord3, this.oldmCoord3);
  }

  /**
   * Unsets the value of the "coord1" attribute of this InteriorPoint.
   */
  public boolean unsetCoord1() {
    if (isSetCoord1()) {
      Double oldmCoord1 = mCoord1;
      mCoord1 = null;
      firePropertyChange(SpatialConstants.mCoord1, oldmCoord1, mCoord1);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "coord2" attribute of this InteriorPoint.
   */
  public boolean unsetCoord2() {
    if (isSetCoord2()) {
      Double oldmCoord2 = mCoord2;
      mCoord2 = null;
      firePropertyChange(SpatialConstants.mCoord2, oldmCoord2, mCoord2);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "coord3" attribute of this InteriorPoint.
   */
  public boolean unsetCoord3() {
    if (isSetCoord3()) {
      Double oldmCoord3 = mCoord3;
      mCoord3 = null;
      firePropertyChange(SpatialConstants.mCoord3, oldmCoord3, mCoord3);
      return true;
    } else {
      return false;
    }
  }

}
