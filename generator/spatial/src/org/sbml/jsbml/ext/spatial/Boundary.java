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
public class Boundary {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 17489141322594322L;
  /**
   *
   */
  private Double value;

  /**
   *  
   */
  public Boundary() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Boundary(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Boundary(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Boundary(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Boundary(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Boundary instance to copy.
   */
  public Boundary(Boundary orig) {
    super(orig);

    if (orig.isSetValue()) {
      setValue(orig.getValue());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    value = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Boundary obj = (Boundary) object;

      equals &= obj.isSetValue() == isSetValue();
      if (equals && isSetValue()) {
        equals &= (obj.getValue() == getValue());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Boundary clone() {
    return new Boundary(this);
  }

  /**
   * Returns the value of {@link value}.
   *  
   * @return the value of {@link value}.
   */
  public double getValue() {
    if (isSetValue()) {
      return value.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.value, this);
  }

  /**
   * Returns whether {@link value} is set.
   *  
   * @return whether {@link value} is set.
   */
  public boolean isSetValue() {
    return this.value != null;
  }

  /**
   * Sets the value of value
   *  
   * @param value the value of value to be set.
   */
  public boolean setValue(double value) {
    if (value != this.value) {
      Double oldValue = this.value;
      this.value = value;
      firePropertyChange(SpatialConstants.value, oldValue, this.value);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable value.
   *  
   * @return {@code true} if value was set before, otherwise {@code false}.
   */
  public boolean unsetValue() {
    if (isSetValue()) {
      Double oldValue = value;
      value = null;
      firePropertyChange(SpatialConstants.value, oldValue, value);
      return true;
    }
    return false;
  }

  /* hashcode method for Boundary.
   */
  @Override
  public int hashCode() {
    final int prime = 7222549;

    int hashCode = super.hashCode();

    if (isSetValue()) {
      hashCode += prime * getValue();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Boundary [");
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
    if (isSetValue()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.value,
        StringTools.toString(Locale.ENGLISH, getValue()));
    }
    return attributes;
  }

}
