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
public class CSGObject {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 51225790433910559L;
  /**
   *
   */
  private String domainType;
  /**
   *
   */
  private Integer ordinal;
  /**
   *
   */
  private XMLNode csgNode;

  /**
   *  
   */
  public CSGObject() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGObject(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the CSGObject instance to copy.
   */
  public CSGObject(CSGObject orig) {
    super(orig);

    if (orig.isSetDomainType()) {
      setDomainType(orig.getDomainType());
    }
    if (orig.isSetOrdinal()) {
      setOrdinal(orig.getOrdinal());
    }
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
    domainType = null;
    ordinal = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGObject obj = (CSGObject) object;

      equals &= obj.isSetDomainType() == isSetDomainType();
      if (equals && isSetDomainType()) {
        equals &= (obj.getDomainType() == getDomainType());
      }
      equals &= obj.isSetOrdinal() == isSetOrdinal();
      if (equals && isSetOrdinal()) {
        equals &= (obj.getOrdinal() == getOrdinal());
      }
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
  public CSGObject clone() {
    return new CSGObject(this);
  }

  /**
   * Returns the value of {@link domainType}.
   *  
   * @return the value of {@link domainType}.
   */
  public String getDomainType() {
    return isSetDomainType() ? domainType : "";
  }

  /**
   * Returns the value of {@link ordinal}.
   *  
   * @return the value of {@link ordinal}.
   */
  public int getOrdinal() {
    if (isSetOrdinal()) {
      return ordinal.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.ordinal, this);
  }

  /**
   * Returns whether {@link domainType} is set.
   *  
   * @return whether {@link domainType} is set.
   */
  public boolean isSetDomainType() {
    return this.domainType != null;
  }

  /**
   * Returns whether {@link ordinal} is set.
   *  
   * @return whether {@link ordinal} is set.
   */
  public boolean isSetOrdinal() {
    return this.ordinal != null;
  }

  /**
   * Sets the value of domainType
   *  
   * @param domainType the value of domainType to be set.
   */
  public boolean setDomainType(String domainType) {
    if (domainType != this.domainType) {
      String oldDomainType = this.domainType;
      this.domainType = domainType;
      firePropertyChange(SpatialConstants.domainType, oldDomainType,
        this.domainType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of ordinal
   *  
   * @param ordinal the value of ordinal to be set.
   */
  public boolean setOrdinal(int ordinal) {
    if (ordinal != this.ordinal) {
      Integer oldOrdinal = this.ordinal;
      this.ordinal = ordinal;
      firePropertyChange(SpatialConstants.ordinal, oldOrdinal, this.ordinal);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable domainType.
   *  
   * @return {@code true} if domainType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetDomainType() {
    if (isSetDomainType()) {
      String oldDomainType = domainType;
      domainType = null;
      firePropertyChange(SpatialConstants.domainType, oldDomainType,
        domainType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable ordinal.
   *  
   * @return {@code true} if ordinal was set before, otherwise {@code false}.
   */
  public boolean unsetOrdinal() {
    if (isSetOrdinal()) {
      Integer oldOrdinal = ordinal;
      ordinal = null;
      firePropertyChange(SpatialConstants.ordinal, oldOrdinal, ordinal);
      return true;
    }
    return false;
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
   * Creates a new CSGPrimitive object, adds it to this CSGObject object and
   * returns the CSGPrimitive object created.
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
   * Creates a new CSGTranslation object, adds it to this CSGObject object and
   * returns the CSGTranslation object created.
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
   * Creates a new CSGRotation object, adds it to this CSGObject object and
   * returns the CSGRotation object created.
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
   * Creates a new CSGScale object, adds it to this CSGObject object and
   * returns the CSGScale object created.
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
   * CSGObject object and returns the CSGHomogeneousTransformation object
   * created.
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
   * Creates a new CSGPseudoPrimitive object, adds it to this CSGObject object
   * and returns the CSGPseudoPrimitive object created.
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
   * Creates a new CSGSetOperator object, adds it to this CSGObject object and
   * returns the CSGSetOperator object created.
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

  /* hashcode method for CSGObject.
   */
  @Override
  public int hashCode() {
    final int prime = 5438099;

    int hashCode = super.hashCode();

    if (isSetDomainType()) {
      hashCode += prime * getDomainType().hashCode();
    }
    if (isSetOrdinal()) {
      hashCode += prime;
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGObject [");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    if (!isAttributeRead) {
      isAttributeRead = true;

      if (attributeName.equals(SpatialConstants.domainType)) {
        setDomainType(value);
      }      else if (attributeName.equals(SpatialConstants.ordinal)) {
        setOrdinal(StringTools.parseSBMLInt(value));
      } else {
        isAttributeRead = false;
      }
    }
    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(SpatialConstants.shortLabel + ":id", getId());
    }
    if (isSetDomainType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domainType,
        getDomainType());
    }
    if (isSetOrdinal()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.ordinal,
        Integer.toString(getOrdinal()));
    }
    return attributes;
  }

}
