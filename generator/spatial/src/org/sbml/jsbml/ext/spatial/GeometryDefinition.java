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
public class GeometryDefinition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 51079254348363622L;
  /**
   *
   */
  private Boolean isActive;

  /**
   *  
   */
  public GeometryDefinition() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public GeometryDefinition(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public GeometryDefinition(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public GeometryDefinition(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public GeometryDefinition(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the GeometryDefinition instance to copy.
   */
  public GeometryDefinition(GeometryDefinition orig) {
    super(orig);

    if (orig.isSetIsActive()) {
      setIsActive(orig.getIsActive());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    isActive = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      GeometryDefinition obj = (GeometryDefinition) object;

      equals &= obj.isSetIsActive() == isSetIsActive();
      if (equals && isSetIsActive()) {
        equals &= (obj.getIsActive() == getIsActive());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public GeometryDefinition clone() {
    return new GeometryDefinition(this);
  }

  /**
   * Returns the value of {@link isActive}.
   *  
   * @return the value of {@link isActive}.
   */
  public boolean getIsActive() {
    if (isSetIsActive()) {
      return isActive.booleanValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.isActive, this);
  }

  /**
   * Returns whether {@link isActive} is set.
   *  
   * @return whether {@link isActive} is set.
   */
  public boolean isSetIsActive() {
    return this.isActive != null;
  }

  /**
   * Sets the value of isActive
   *  
   * @param isActive the value of isActive to be set.
   */
  public boolean setIsActive(boolean isActive) {
    if (isActive != this.isActive) {
      Boolean oldIsActive = this.isActive;
      this.isActive = isActive;
      firePropertyChange(SpatialConstants.isActive, oldIsActive,
        this.isActive);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable isActive.
   *  
   * @return {@code true} if isActive was set before, otherwise {@code false}.
   */
  public boolean unsetIsActive() {
    if (isSetIsActive()) {
      Boolean oldIsActive = isActive;
      isActive = null;
      firePropertyChange(SpatialConstants.isActive, oldIsActive, isActive);
      return true;
    }
    return false;
  }

  /**
   * Predicate returning @c true if this abstract "GeometryDefinition" is of
   * type AnalyticGeometry
   */
  public bool isAnalyticGeometry() {
    return dynamic_cast<const AnalyticGeometry*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "GeometryDefinition" is of
   * type SampledFieldGeometry
   */
  public bool isSampledFieldGeometry() {
    return dynamic_cast<const SampledFieldGeometry*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "GeometryDefinition" is of
   * type CSGeometry
   */
  public bool isCSGeometry() {
    return dynamic_cast<const CSGeometry*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "GeometryDefinition" is of
   * type ParametricGeometry
   */
  public bool isParametricGeometry() {
    return dynamic_cast<const ParametricGeometry*>(this) != NULL;
  }

  /**
   * Predicate returning @c true if this abstract "GeometryDefinition" is of
   * type MixedGeometry
   */
  public bool isMixedGeometry() {
    return dynamic_cast<const MixedGeometry*>(this) != NULL;
  }

  /* hashcode method for GeometryDefinition.
   */
  @Override
  public int hashCode() {
    final int prime = 2658899;

    int hashCode = super.hashCode();

    if (isSetIsActive()) {
      hashCode += prime + (getIsActive() ? 1 : -1);
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("GeometryDefinition [");
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
    if (isSetIsActive()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.isActive,
        Boolean.toString(getIsActive()));
    }
    return attributes;
  }

}
