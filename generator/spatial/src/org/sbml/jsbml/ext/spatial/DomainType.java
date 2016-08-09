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
public class DomainType {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 65487732246070197L;
  /**
   *
   */
  private Integer spatialDimensions;

  /**
   *  
   */
  public DomainType() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public DomainType(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public DomainType(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public DomainType(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public DomainType(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the DomainType instance to copy.
   */
  public DomainType(DomainType orig) {
    super(orig);

    if (orig.isSetSpatialDimensions()) {
      setSpatialDimensions(orig.getSpatialDimensions());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    spatialDimensions = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      DomainType obj = (DomainType) object;

      equals &= obj.isSetSpatialDimensions() == isSetSpatialDimensions();
      if (equals && isSetSpatialDimensions()) {
        equals &= (obj.getSpatialDimensions() == getSpatialDimensions());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public DomainType clone() {
    return new DomainType(this);
  }

  /**
   * Returns the value of {@link spatialDimensions}.
   *  
   * @return the value of {@link spatialDimensions}.
   */
  public int getSpatialDimensions() {
    if (isSetSpatialDimensions()) {
      return spatialDimensions.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.spatialDimensions, this);
  }

  /**
   * Returns whether {@link spatialDimensions} is set.
   *  
   * @return whether {@link spatialDimensions} is set.
   */
  public boolean isSetSpatialDimensions() {
    return this.spatialDimensions != null;
  }

  /**
   * Sets the value of spatialDimensions
   *  
   * @param spatialDimensions the value of spatialDimensions to be set.
   */
  public boolean setSpatialDimensions(int spatialDimensions) {
    if (spatialDimensions != this.spatialDimensions) {
      Integer oldSpatialDimensions = this.spatialDimensions;
      this.spatialDimensions = spatialDimensions;
      firePropertyChange(SpatialConstants.spatialDimensions,
        oldSpatialDimensions, this.spatialDimensions);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable spatialDimensions.
   *  
   * @return {@code true} if spatialDimensions was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSpatialDimensions() {
    if (isSetSpatialDimensions()) {
      Integer oldSpatialDimensions = spatialDimensions;
      spatialDimensions = null;
      firePropertyChange(SpatialConstants.spatialDimensions,
        oldSpatialDimensions, spatialDimensions);
      return true;
    }
    return false;
  }

  /* hashcode method for DomainType.
   */
  @Override
  public int hashCode() {
    final int prime = 8501497;

    int hashCode = super.hashCode();

    if (isSetSpatialDimensions()) {
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
    builder.append("DomainType [");
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
    if (isSetSpatialDimensions()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.spatialDimensions, Integer.toString(getSpatialDimensions()));
    }
    return attributes;
  }

}
