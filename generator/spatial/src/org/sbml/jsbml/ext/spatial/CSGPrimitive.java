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
public class CSGPrimitive extends CSGNode {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 54424824751073013L;
  /**
   *
   */
  private PrimitiveKind primitiveType;

  /**
   *  
   */
  public CSGPrimitive() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGPrimitive(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGPrimitive(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGPrimitive(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGPrimitive(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGPrimitive instance to copy.
   */
  public CSGPrimitive(CSGPrimitive orig) {
    super(orig);

    if (orig.isSetPrimitiveType()) {
      setPrimitiveType(orig.getPrimitiveType());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    primitiveType = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGPrimitive obj = (CSGPrimitive) object;

      equals &= obj.isSetPrimitiveType() == isSetPrimitiveType();
      if (equals && isSetPrimitiveType()) {
        equals &= (obj.getPrimitiveType() == getPrimitiveType());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGPrimitive clone() {
    return new CSGPrimitive(this);
  }

  /**
   * Returns the value of {@link primitiveType}.
   *  
   * @return the value of {@link primitiveType}.
   */
  public PrimitiveKind getPrimitiveType() {
    if (isSetPrimitiveType()) {
      return primitiveType;
    }
    throw new PropertyUndefinedError(SpatialConstants.primitiveType, this);
  }

  /**
   * Returns whether {@link primitiveType} is set.
   *  
   * @return whether {@link primitiveType} is set.
   */
  public boolean isSetPrimitiveType() {
    return this.primitiveType != null;
  }

  /**
   * Sets the value of primitiveType
   *  
   * @param primitiveType the value of primitiveType to be set.
   */
  public boolean setPrimitiveType(PrimitiveKind primitiveType) {
    if (primitiveType != this.primitiveType) {
      PrimitiveKind oldPrimitiveType = this.primitiveType;
      this.primitiveType = primitiveType;
      firePropertyChange(SpatialConstants.primitiveType, oldPrimitiveType,
        this.primitiveType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable primitiveType.
   *  
   * @return {@code true} if primitiveType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetPrimitiveType() {
    if (isSetPrimitiveType()) {
      PrimitiveKind oldPrimitiveType = primitiveType;
      primitiveType = null;
      firePropertyChange(SpatialConstants.primitiveType, oldPrimitiveType,
        primitiveType);
      return true;
    }
    return false;
  }

  /* hashcode method for CSGPrimitive.
   */
  @Override
  public int hashCode() {
    final int prime = 7579349;

    int hashCode = super.hashCode();

    if (isSetPrimitiveType()) {
      hashCode += prime * getPrimitiveType().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGPrimitive [");
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

    if (isSetPrimitiveType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.primitiveType,
        getPrimitiveType().toString());
    }
    return attributes;
  }

}
