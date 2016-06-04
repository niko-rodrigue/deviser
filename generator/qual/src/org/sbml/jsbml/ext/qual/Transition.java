/*
 * $Id: Transition.java 2465 2016-06-04 23:07:05Z deviser $
 * $URL:
 * /home/john1990/Dropbox/GitHub/SBML/deviser/generator/qual/src/org/sbml/jsbml/ext/qualTransition.java
 * $
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
 * @date $Date: 2016-06-04 23:07:05 +0400 (Sat, 04 Jun 2016) $
 */
public class Transition {
  /**
   * @return the value of the "id" attribute of this Transition.
   */
  public String getId() {
    return isSetId() ? id : "";
  }

  /**
   * @return the value of the "name" attribute of this Transition.
   */
  public String getName() {
    return isSetName() ? name : "";
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
      return true;
    } else {
      return false;
    }
  }

}
