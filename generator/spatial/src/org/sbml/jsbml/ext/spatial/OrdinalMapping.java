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
public class OrdinalMapping {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 50526006640107951L;
  /**
   *
   */
  private String geometryDefinition;
  /**
   *
   */
  private Integer ordinal;

  /**
   *  
   */
  public OrdinalMapping() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public OrdinalMapping(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public OrdinalMapping(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public OrdinalMapping(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public OrdinalMapping(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the OrdinalMapping instance to copy.
   */
  public OrdinalMapping(OrdinalMapping orig) {
    super(orig);

    if (orig.isSetGeometryDefinition()) {
      setGeometryDefinition(orig.getGeometryDefinition());
    }
    if (orig.isSetOrdinal()) {
      setOrdinal(orig.getOrdinal());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    geometryDefinition = null;
    ordinal = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      OrdinalMapping obj = (OrdinalMapping) object;

      equals &= obj.isSetGeometryDefinition() == isSetGeometryDefinition();
      if (equals && isSetGeometryDefinition()) {
        equals &= (obj.getGeometryDefinition() == getGeometryDefinition());
      }
      equals &= obj.isSetOrdinal() == isSetOrdinal();
      if (equals && isSetOrdinal()) {
        equals &= (obj.getOrdinal() == getOrdinal());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public OrdinalMapping clone() {
    return new OrdinalMapping(this);
  }

  /**
   * Returns the value of {@link geometryDefinition}.
   *  
   * @return the value of {@link geometryDefinition}.
   */
  public String getGeometryDefinition() {
    return isSetGeometryDefinition() ? geometryDefinition : "";
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
   * Returns whether {@link geometryDefinition} is set.
   *  
   * @return whether {@link geometryDefinition} is set.
   */
  public boolean isSetGeometryDefinition() {
    return this.geometryDefinition != null;
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
   * Sets the value of geometryDefinition
   *  
   * @param geometryDefinition the value of geometryDefinition to be set.
   */
  public boolean setGeometryDefinition(String geometryDefinition) {
    if (geometryDefinition != this.geometryDefinition) {
      String oldGeometryDefinition = this.geometryDefinition;
      this.geometryDefinition = geometryDefinition;
      firePropertyChange(SpatialConstants.geometryDefinition,
        oldGeometryDefinition, this.geometryDefinition);
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
   * Unsets the variable geometryDefinition.
   *  
   * @return {@code true} if geometryDefinition was set before, otherwise
   * {@code false}.
   */
  public boolean unsetGeometryDefinition() {
    if (isSetGeometryDefinition()) {
      String oldGeometryDefinition = geometryDefinition;
      geometryDefinition = null;
      firePropertyChange(SpatialConstants.geometryDefinition,
        oldGeometryDefinition, geometryDefinition);
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

  /* hashcode method for OrdinalMapping.
   */
  @Override
  public int hashCode() {
    final int prime = 4548029;

    int hashCode = super.hashCode();

    if (isSetGeometryDefinition()) {
      hashCode += prime * getGeometryDefinition().hashCode();
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
    builder.append("OrdinalMapping [");
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

    if (isSetGeometryDefinition()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.geometryDefinition, getGeometryDefinition());
    }
    if (isSetOrdinal()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.ordinal,
        Integer.toString(getOrdinal()));
    }
    return attributes;
  }

}
