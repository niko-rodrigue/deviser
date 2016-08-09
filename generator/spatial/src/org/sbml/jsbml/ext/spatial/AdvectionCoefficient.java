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
public class AdvectionCoefficient {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 34567402330742755L;
  /**
   *
   */
  private String variable;
  /**
   *
   */
  private CoordinateKind coordinate;

  /**
   *  
   */
  public AdvectionCoefficient() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public AdvectionCoefficient(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public AdvectionCoefficient(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public AdvectionCoefficient(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public AdvectionCoefficient(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the AdvectionCoefficient instance to copy.
   */
  public AdvectionCoefficient(AdvectionCoefficient orig) {
    super(orig);

    if (orig.isSetVariable()) {
      setVariable(orig.getVariable());
    }
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
    variable = null;
    coordinate = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      AdvectionCoefficient obj = (AdvectionCoefficient) object;

      equals &= obj.isSetVariable() == isSetVariable();
      if (equals && isSetVariable()) {
        equals &= (obj.getVariable() == getVariable());
      }
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
  public AdvectionCoefficient clone() {
    return new AdvectionCoefficient(this);
  }

  /**
   * Returns the value of {@link variable}.
   *  
   * @return the value of {@link variable}.
   */
  public String getVariable() {
    return isSetVariable() ? variable : "";
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
   * Returns whether {@link variable} is set.
   *  
   * @return whether {@link variable} is set.
   */
  public boolean isSetVariable() {
    return this.variable != null;
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
   * Sets the value of variable
   *  
   * @param variable the value of variable to be set.
   */
  public boolean setVariable(String variable) {
    if (variable != this.variable) {
      String oldVariable = this.variable;
      this.variable = variable;
      firePropertyChange(SpatialConstants.variable, oldVariable,
        this.variable);
      return true;
    }
    return false;
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
   * Unsets the variable variable.
   *  
   * @return {@code true} if variable was set before, otherwise {@code false}.
   */
  public boolean unsetVariable() {
    if (isSetVariable()) {
      String oldVariable = variable;
      variable = null;
      firePropertyChange(SpatialConstants.variable, oldVariable, variable);
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

  /* hashcode method for AdvectionCoefficient.
   */
  @Override
  public int hashCode() {
    final int prime = 4633259;

    int hashCode = super.hashCode();

    if (isSetVariable()) {
      hashCode += prime * getVariable().hashCode();
    }
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
    builder.append("AdvectionCoefficient [");
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

    if (isSetVariable()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.variable,
        getVariable());
    }
    if (isSetCoordinate()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.coordinate,
        getCoordinate().toString());
    }
    return attributes;
  }

}
