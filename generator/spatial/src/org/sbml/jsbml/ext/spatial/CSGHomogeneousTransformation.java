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
package org.sbml.jsbml.ext.spatial;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;
import org.sbml.jsbml.xml.XMLNode;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class CSGHomogeneousTransformation extends CSGTransformation {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 24839668728976274L;
  /**
   *
   */
  private XMLNode forwardTransformation;
  /**
   *
   */
  private XMLNode reverseTransformation;

  /**
   *  
   */
  public CSGHomogeneousTransformation() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGHomogeneousTransformation(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the CSGHomogeneousTransformation instance to copy.
   */
  public CSGHomogeneousTransformation(CSGHomogeneousTransformation orig) {
    super(orig);

    if (orig.isSetForwardTransformation()) {
      setForwardTransformation(orig.getForwardTransformation().clone());
    }
    if (orig.isSetReverseTransformation()) {
      setReverseTransformation(orig.getReverseTransformation().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGHomogeneousTransformation obj = (CSGHomogeneousTransformation) object;

      equals &= obj.isSetForwardTransformation() ==
        isSetForwardTransformation();
      if (equals && isSetForwardTransformation()) {
        equals &= (obj.getForwardTransformation() ==
          getForwardTransformation());
      }
      equals &= obj.isSetReverseTransformation() ==
        isSetReverseTransformation();
      if (equals && isSetReverseTransformation()) {
        equals &= (obj.getReverseTransformation() ==
          getReverseTransformation());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGHomogeneousTransformation clone() {
    return new CSGHomogeneousTransformation(this);
  }

  /**
   * Returns the value of {@link forwardTransformation}.
   *  
   * @return the value of {@link forwardTransformation}.
   */
  public XMLNode getForwardTransformation() {
    if (isSetForwardTransformation()) {
      return forwardTransformation;
    }
    throw new PropertyUndefinedError(SpatialConstants.forwardTransformation,
      this);
  }

  /**
   * Returns the value of {@link reverseTransformation}.
   *  
   * @return the value of {@link reverseTransformation}.
   */
  public XMLNode getReverseTransformation() {
    if (isSetReverseTransformation()) {
      return reverseTransformation;
    }
    throw new PropertyUndefinedError(SpatialConstants.reverseTransformation,
      this);
  }

  /**
   * Returns whether {@link forwardTransformation} is set.
   *  
   * @return whether {@link forwardTransformation} is set.
   */
  public boolean isSetForwardTransformation() {
    return forwardTransformation != null;
  }

  /**
   * Returns whether {@link reverseTransformation} is set.
   *  
   * @return whether {@link reverseTransformation} is set.
   */
  public boolean isSetReverseTransformation() {
    return reverseTransformation != null;
  }

  /**
   * Sets the value of forwardTransformation
   *  
   * @param forwardTransformation the value of forwardTransformation to be set.
   */
  public boolean setForwardTransformation(XMLNode forwardTransformation) {
    if (forwardTransformation != this.forwardTransformation) {
      XMLNode oldForwardTransformation = this.forwardTransformation;
      this.forwardTransformation = forwardTransformation;
      firePropertyChange(SpatialConstants.forwardTransformation,
        oldForwardTransformation, this.forwardTransformation);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of reverseTransformation
   *  
   * @param reverseTransformation the value of reverseTransformation to be set.
   */
  public boolean setReverseTransformation(XMLNode reverseTransformation) {
    if (reverseTransformation != this.reverseTransformation) {
      XMLNode oldReverseTransformation = this.reverseTransformation;
      this.reverseTransformation = reverseTransformation;
      firePropertyChange(SpatialConstants.reverseTransformation,
        oldReverseTransformation, this.reverseTransformation);
      return true;
    }
    return false;
  }

  /**
   * Creates a new TransformationComponents object, adds it to this
   * CSGHomogeneousTransformation object and returns the
   * TransformationComponents object created.
   */
  public XMLNode createForwardTransformation() {
    XMLNode forwardTransformation = new XMLNode(getLevel(), getVersion());
    return forwardTransformation;
  }

  /**
   * Creates a new TransformationComponents object, adds it to this
   * CSGHomogeneousTransformation object and returns the
   * TransformationComponents object created.
   */
  public XMLNode createReverseTransformation() {
    XMLNode reverseTransformation = new XMLNode(getLevel(), getVersion());
    return reverseTransformation;
  }

  /**
   * Unsets the variable forwardTransformation.
   *  
   * @return {@code true} if forwardTransformation was set before, otherwise
   * {@code false}.
   */
  public boolean unsetForwardTransformation() {
    if (isSetForwardTransformation()) {
      XMLNode oldForwardTransformation = forwardTransformation;
      forwardTransformation = null;
      firePropertyChange(SpatialConstants.forwardTransformation,
        oldForwardTransformation, forwardTransformation);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable reverseTransformation.
   *  
   * @return {@code true} if reverseTransformation was set before, otherwise
   * {@code false}.
   */
  public boolean unsetReverseTransformation() {
    if (isSetReverseTransformation()) {
      XMLNode oldReverseTransformation = reverseTransformation;
      reverseTransformation = null;
      firePropertyChange(SpatialConstants.reverseTransformation,
        oldReverseTransformation, reverseTransformation);
      return true;
    }
    return false;
  }

  /* hashcode method for CSGHomogeneousTransformation.
   */
  @Override
  public int hashCode() {
    final int prime = 9176911;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGHomogeneousTransformation [");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    return attributes;
  }

}
