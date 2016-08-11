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
public class CSGTransformation extends CSGNode {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 22565516191266158L;
  /**
   *
   */
  private XMLNode csgNode;

  /**
   *  
   */
  public CSGTransformation() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGTransformation(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the CSGTransformation instance to copy.
   */
  public CSGTransformation(CSGTransformation orig) {
    super(orig);

    if (orig.isSetCsgNode()) {
      setCsgNode(orig.getCsgNode().clone());
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
      CSGTransformation obj = (CSGTransformation) object;

      equals &= obj.isSetCsgNode() == isSetCsgNode();
      if (equals && isSetCsgNode()) {
        equals &= (obj.getCsgNode() == getCsgNode());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGTransformation clone() {
    return new CSGTransformation(this);
  }

  /**
   * Returns the value of {@link csgNode}.
   *  
   * @return the value of {@link csgNode}.
   */
  public XMLNode getCsgNode() {
    if (isSetCsgNode()) {
      return csgNode;
    }
    throw new PropertyUndefinedError(SpatialConstants.csgNode, this);
  }

  /**
   * Returns whether {@link csgNode} is set.
   *  
   * @return whether {@link csgNode} is set.
   */
  public boolean isSetCsgNode() {
    return csgNode != null;
  }

  /**
   * Sets the value of csgNode
   *  
   * @param csgNode the value of csgNode to be set.
   */
  public boolean setCsgNode(XMLNode csgNode) {
    if (csgNode != this.csgNode) {
      XMLNode oldCsgNode = this.csgNode;
      this.csgNode = csgNode;
      firePropertyChange(SpatialConstants.csgNode, oldCsgNode, this.csgNode);
      return true;
    }
    return false;
  }

  /**
   * Creates a new CSGPrimitive object, adds it to this CSGTransformation
   * object and returns the CSGPrimitive object created.
   */
  public CSGPrimitive createCSGPrimitive() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGPrimitive(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGPrimitive*>(mCsgNode);
  }

  /**
   * Creates a new CSGTranslation object, adds it to this CSGTransformation
   * object and returns the CSGTranslation object created.
   */
  public CSGTranslation createCSGTranslation() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGTranslation(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGTranslation*>(mCsgNode);
  }

  /**
   * Creates a new CSGRotation object, adds it to this CSGTransformation object
   * and returns the CSGRotation object created.
   */
  public CSGRotation createCSGRotation() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGRotation(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGRotation*>(mCsgNode);
  }

  /**
   * Creates a new CSGScale object, adds it to this CSGTransformation object
   * and returns the CSGScale object created.
   */
  public CSGScale createCSGScale() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGScale(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGScale*>(mCsgNode);
  }

  /**
   * Creates a new CSGHomogeneousTransformation object, adds it to this
   * CSGTransformation object and returns the CSGHomogeneousTransformation
   * object created.
   */
  public CSGHomogeneousTransformation createCSGHomogeneousTransformation() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGHomogeneousTransformation(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGHomogeneousTransformation*>(mCsgNode);
  }

  /**
   * Creates a new CSGPseudoPrimitive object, adds it to this CSGTransformation
   * object and returns the CSGPseudoPrimitive object created.
   */
  public CSGPseudoPrimitive createCSGPseudoPrimitive() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGPseudoPrimitive(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGPseudoPrimitive*>(mCsgNode);
  }

  /**
   * Creates a new CSGSetOperator object, adds it to this CSGTransformation
   * object and returns the CSGSetOperator object created.
   */
  public CSGSetOperator createCSGSetOperator() {
    if (mCsgNode != NULL) {
      delete mCsgNode;
    }
    SPATIAL_CREATE_NS(spatialns, getSBMLNamespaces());
    mCsgNode = new CSGSetOperator(spatialns);

    delete spatialns;

    connectToChild();

    return static_cast<CSGSetOperator*>(mCsgNode);
  }

  /**
   * Unsets the variable csgNode.
   *  
   * @return {@code true} if csgNode was set before, otherwise {@code false}.
   */
  public boolean unsetCsgNode() {
    if (isSetCsgNode()) {
      XMLNode oldCsgNode = csgNode;
      csgNode = null;
      firePropertyChange(SpatialConstants.csgNode, oldCsgNode, csgNode);
      return true;
    }
    return false;
  }

  /**
   * Predicate returning @c true if this abstract "CSGTransformation" is of
   * type CSGTranslation
   */
  public bool isCSGTranslation() {
    return dynamic_cast<const CSGTranslation*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGTransformation" is of
   * type CSGRotation
   */
  public bool isCSGRotation() {
    return dynamic_cast<const CSGRotation*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGTransformation" is of
   * type CSGScale
   */
  public bool isCSGScale() {
    return dynamic_cast<const CSGScale*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGTransformation" is of
   * type CSGHomogeneousTransformation
   */
  public bool isCSGHomogeneousTransformation() {
    return dynamic_cast<const CSGHomogeneousTransformation*>(this) != NULL;
  }

  /* hashcode method for CSGTransformation.
   */
  @Override
  public int hashCode() {
    final int prime = 6863581;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGTransformation [");
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
