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
public class DefaultTerm {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;
  /**
   *
   */
  private Integer mResultLevel;
  /**
   * @return the value of the "resultLevel" attribute of this DefaultTerm.
   */
  public int getResultLevel() {
    if (isSetResultLevel()) {
      return mResultLevel.intValue();
    }
    throw new PropertyUndefinedError(QualConstants.mResultLevel, this);
  }

  /**
   * Predicate returning {@code true} if this DefaultTerm's "resultLevel"
   * attribute is set.
   */
  public boolean isSetResultLevel() {
    return mResultLevel != null;
  }

  /**
   * Sets the value of the "resultLevel" attribute of this DefaultTerm.
   */
  public void setResultLevel(int resultLevel) {
    Integer oldmResultLevel = this.mResultLevel;

    this.oldmResultLevel = resultLevel;

    firePropertyChange(QualConstants.mResultLevel, oldmResultLevel,
      this.oldmResultLevel);
  }

  /**
   * Unsets the value of the "resultLevel" attribute of this DefaultTerm.
   */
  public boolean unsetResultLevel() {
    if (isSetResultLevel()) {
      Integer oldmResultLevel = mResultLevel;
      mResultLevel = null;
      firePropertyChange(QualConstants.mResultLevel, oldmResultLevel,
        mResultLevel);
      return true;
    } else {
      return false;
    }
  }

}
