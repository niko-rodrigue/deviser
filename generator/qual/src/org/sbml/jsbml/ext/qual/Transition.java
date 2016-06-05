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

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class Transition {

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
   * @return the value of the "id" attribute of this Transition.
   */
  public String getId() {
    return isSetId() ? mId : "";
  }

  /**
   * @return the value of the "name" attribute of this Transition.
   */
  public String getName() {
    return isSetName() ? mName : "";
  }

  /**
   * Predicate returning {@code true} if this Transition's "id" attribute is
   * set.
   */
  public boolean isSetId() {
    ;
  }

  /**
   * Predicate returning {@code true} if this Transition's "name" attribute is
   * set.
   */
  public boolean isSetName() {
    ;
  }

  /**
   * Sets the value of the "id" attribute of this Transition.
   */
  public void setId(String id) {
    return SyntaxChecker::checkAndSetSId(id, mId);
  }

  /**
   * Sets the value of the "name" attribute of this Transition.
   */
  public void setName(String name) {
    mName = name;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Unsets the value of the "id" attribute of this Transition.
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
   * Unsets the value of the "name" attribute of this Transition.
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

}
