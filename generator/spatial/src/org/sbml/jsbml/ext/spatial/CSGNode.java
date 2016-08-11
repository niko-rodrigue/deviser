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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class CSGNode {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 47504367021433472L;

  /**
   *  
   */
  public CSGNode() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGNode(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGNode(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGNode(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGNode(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGNode instance to copy.
   */
  public CSGNode(CSGNode orig) {
    super(orig);

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
      CSGNode obj = (CSGNode) object;

    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGNode clone() {
    return new CSGNode(this);
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type
   * CSGPrimitive
   */
  public bool isCSGPrimitive() {
    return dynamic_cast<const CSGPrimitive*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type
   * CSGTranslation
   */
  public bool isCSGTranslation() {
    return dynamic_cast<const CSGTranslation*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type
   * CSGRotation
   */
  public bool isCSGRotation() {
    return dynamic_cast<const CSGRotation*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type CSGScale
   */
  public bool isCSGScale() {
    return dynamic_cast<const CSGScale*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type
   * CSGHomogeneousTransformation
   */
  public bool isCSGHomogeneousTransformation() {
    return dynamic_cast<const CSGHomogeneousTransformation*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type
   * CSGPseudoPrimitive
   */
  public bool isCSGPseudoPrimitive() {
    return dynamic_cast<const CSGPseudoPrimitive*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "CSGNode" is of type
   * CSGSetOperator
   */
  public bool isCSGSetOperator() {
    return dynamic_cast<const CSGSetOperator*>(this) != NULL;
  }

  /* hashcode method for CSGNode.
   */
  @Override
  public int hashCode() {
    final int prime = 462937;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGNode [");
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

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(SpatialConstants.shortLabel + ":id", getId());
    }
    return attributes;
  }

}
