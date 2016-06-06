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
public class AdjacentDomains {

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
  private String mDomain1;
  /**
   *
   */
  private String mDomain2;
  /**
   * @return the value of the "id" attribute of this AdjacentDomains.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "domain1" attribute of this AdjacentDomains.
   */
  public String getDomain1() {
    return isSetDomain1() ? mDomain1 : "";
  }

  /**
   * @return the value of the "domain2" attribute of this AdjacentDomains.
   */
  public String getDomain2() {
    return isSetDomain2() ? mDomain2 : "";
  }

  /**
   * Predicate returning {@code true} if this AdjacentDomains's "id" attribute
   * is set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this AdjacentDomains's "domain1"
   * attribute is set.
   */
  public boolean isSetDomain1() {
    ;
  }

  /**
   * Predicate returning {@code true} if this AdjacentDomains's "domain2"
   * attribute is set.
   */
  public boolean isSetDomain2() {
    ;
  }

  /**
   * Sets the value of the "id" attribute of this AdjacentDomains.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "domain1" attribute of this AdjacentDomains.
   */
  public boolean setDomain1(String domain1) {
    if (domain1 != this.mDomain1) {
      String oldmDomain1 = this.mDomain1;
      if ((domain1 == null) || (domain1.length() == 0) {
        this.mDomain1 = null;
      } else {
        this.mDomain1 = domain1;
      }

      firePropertyChange(SpatialConstants.mDomain1, oldmDomain1,
        this.oldmDomain1);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of the "domain2" attribute of this AdjacentDomains.
   */
  public boolean setDomain2(String domain2) {
    if (domain2 != this.mDomain2) {
      String oldmDomain2 = this.mDomain2;
      if ((domain2 == null) || (domain2.length() == 0) {
        this.mDomain2 = null;
      } else {
        this.mDomain2 = domain2;
      }

      firePropertyChange(SpatialConstants.mDomain2, oldmDomain2,
        this.oldmDomain2);
      return true;
    }
    return false;
  }

  /**
   * Unsets the value of the "id" attribute of this AdjacentDomains.
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
   * Unsets the value of the "domain1" attribute of this AdjacentDomains.
   */
  public boolean unsetDomain1() {
    if (isSetDomain1()) {
      mDomain1 = null;
      firePropertyChange(SpatialConstants.mDomain1, oldmDomain1, mDomain1);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Unsets the value of the "domain2" attribute of this AdjacentDomains.
   */
  public boolean unsetDomain2() {
    if (isSetDomain2()) {
      mDomain2 = null;
      firePropertyChange(SpatialConstants.mDomain2, oldmDomain2, mDomain2);
      return true;
    } else {
      return false;
    }
  }

}
