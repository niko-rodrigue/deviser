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
public class CoordinateReference {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 60542051990578659L;
  /**
   *
   */
  private CoordinateKind coordinate;

  /**
   *  
   */
  public CoordinateReference() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CoordinateReference(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CoordinateReference(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CoordinateReference(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CoordinateReference(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CoordinateReference instance to copy.
   */
  public CoordinateReference(CoordinateReference orig) {
    super(orig);

    if (orig.isSetCoordinate()) {
      setCoordinate(orig.getCoordinate());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    coordinate = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CoordinateReference obj = (CoordinateReference) object;

      equals &= obj.isSetCoordinate() == isSetCoordinate();
      if (equals && isSetCoordinate()) {
        equals &= (obj.getCoordinate() == getCoordinate());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CoordinateReference clone() {
    return new CoordinateReference(this);
  }

  /**
   * Returns the value of {@link coordinate}.
   *  
   * @return the value of {@link coordinate}.
   */
  public CoordinateKind getCoordinate() {
    if (isSetCoordinate()) {
      return coordinate;
    }
    throw new PropertyUndefinedError(SpatialConstants.coordinate, this);
  }

  /**
   * Returns whether {@link coordinate} is set.
   *  
   * @return whether {@link coordinate} is set.
   */
  public boolean isSetCoordinate() {
    return this.coordinate != null;
  }

  /**
   * Sets the value of coordinate
   *  
   * @param coordinate the value of coordinate to be set.
   */
  public boolean setCoordinate(CoordinateKind coordinate) {
    if (coordinate != this.coordinate) {
      CoordinateKind oldCoordinate = this.coordinate;
      this.coordinate = coordinate;
      firePropertyChange(SpatialConstants.coordinate, oldCoordinate,
        this.coordinate);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coordinate.
   *  
   * @return {@code true} if coordinate was set before, otherwise {@code
   * false}.
   */
  public boolean unsetCoordinate() {
    if (isSetCoordinate()) {
      CoordinateKind oldCoordinate = coordinate;
      coordinate = null;
      firePropertyChange(SpatialConstants.coordinate, oldCoordinate,
        coordinate);
      return true;
    }
    return false;
  }

  /* hashcode method for CoordinateReference.
   */
  @Override
  public int hashCode() {
    final int prime = 5663101;

    int hashCode = super.hashCode();

    if (isSetCoordinate()) {
      hashCode += prime * getCoordinate().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CoordinateReference [");
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

    if (isSetCoordinate()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.coordinate,
        getCoordinate().toString());
    }
    return attributes;
  }

}
