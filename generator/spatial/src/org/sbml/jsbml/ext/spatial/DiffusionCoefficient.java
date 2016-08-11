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
public class DiffusionCoefficient {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 39455205089611999L;
  /**
   *
   */
  private String variable;
  /**
   *
   */
  private DiffusionKind type;
  /**
   *
   */
  private CoordinateKind coordinateReference1;
  /**
   *
   */
  private CoordinateKind coordinateReference2;

  /**
   *  
   */
  public DiffusionCoefficient() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public DiffusionCoefficient(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public DiffusionCoefficient(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public DiffusionCoefficient(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public DiffusionCoefficient(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the DiffusionCoefficient instance to copy.
   */
  public DiffusionCoefficient(DiffusionCoefficient orig) {
    super(orig);

    if (orig.isSetVariable()) {
      setVariable(orig.getVariable());
    }
    if (orig.isSetType()) {
      setType(orig.getType());
    }
    if (orig.isSetCoordinateReference1()) {
      setCoordinateReference1(orig.getCoordinateReference1());
    }
    if (orig.isSetCoordinateReference2()) {
      setCoordinateReference2(orig.getCoordinateReference2());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    variable = null;
    type = null;
    coordinateReference1 = null;
    coordinateReference2 = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      DiffusionCoefficient obj = (DiffusionCoefficient) object;

      equals &= obj.isSetVariable() == isSetVariable();
      if (equals && isSetVariable()) {
        equals &= (obj.getVariable() == getVariable());
      }
      equals &= obj.isSetType() == isSetType();
      if (equals && isSetType()) {
        equals &= (obj.getType() == getType());
      }
      equals &= obj.isSetCoordinateReference1() == isSetCoordinateReference1();
      if (equals && isSetCoordinateReference1()) {
        equals &= (obj.getCoordinateReference1() == getCoordinateReference1());
      }
      equals &= obj.isSetCoordinateReference2() == isSetCoordinateReference2();
      if (equals && isSetCoordinateReference2()) {
        equals &= (obj.getCoordinateReference2() == getCoordinateReference2());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public DiffusionCoefficient clone() {
    return new DiffusionCoefficient(this);
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
   * Returns the value of {@link type}.
   *  
   * @return the value of {@link type}.
   */
  public DiffusionKind getType() {
    if (isSetType()) {
      return type;
    }
    throw new PropertyUndefinedError(SpatialConstants.type, this);
  }

  /**
   * Returns the value of {@link coordinateReference1}.
   *  
   * @return the value of {@link coordinateReference1}.
   */
  public CoordinateKind getCoordinateReference1() {
    if (isSetCoordinateReference1()) {
      return coordinateReference1;
    }
    throw new PropertyUndefinedError(SpatialConstants.coordinateReference1,
      this);
  }

  /**
   * Returns the value of {@link coordinateReference2}.
   *  
   * @return the value of {@link coordinateReference2}.
   */
  public CoordinateKind getCoordinateReference2() {
    if (isSetCoordinateReference2()) {
      return coordinateReference2;
    }
    throw new PropertyUndefinedError(SpatialConstants.coordinateReference2,
      this);
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
   * Returns whether {@link type} is set.
   *  
   * @return whether {@link type} is set.
   */
  public boolean isSetType() {
    return this.type != null;
  }

  /**
   * Returns whether {@link coordinateReference1} is set.
   *  
   * @return whether {@link coordinateReference1} is set.
   */
  public boolean isSetCoordinateReference1() {
    return this.coordinateReference1 != null;
  }

  /**
   * Returns whether {@link coordinateReference2} is set.
   *  
   * @return whether {@link coordinateReference2} is set.
   */
  public boolean isSetCoordinateReference2() {
    return this.coordinateReference2 != null;
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
   * Sets the value of type
   *  
   * @param type the value of type to be set.
   */
  public boolean setType(DiffusionKind type) {
    if (type != this.type) {
      DiffusionKind oldType = this.type;
      this.type = type;
      firePropertyChange(SpatialConstants.type, oldType, this.type);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of coordinateReference1
   *  
   * @param coordinateReference1 the value of coordinateReference1 to be set.
   */
  public boolean setCoordinateReference1(CoordinateKind coordinateReference1) {
    if (coordinateReference1 != this.coordinateReference1) {
      CoordinateKind oldCoordinateReference1 = this.coordinateReference1;
      this.coordinateReference1 = coordinateReference1;
      firePropertyChange(SpatialConstants.coordinateReference1,
        oldCoordinateReference1, this.coordinateReference1);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of coordinateReference2
   *  
   * @param coordinateReference2 the value of coordinateReference2 to be set.
   */
  public boolean setCoordinateReference2(CoordinateKind coordinateReference2) {
    if (coordinateReference2 != this.coordinateReference2) {
      CoordinateKind oldCoordinateReference2 = this.coordinateReference2;
      this.coordinateReference2 = coordinateReference2;
      firePropertyChange(SpatialConstants.coordinateReference2,
        oldCoordinateReference2, this.coordinateReference2);
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
   * Unsets the variable type.
   *  
   * @return {@code true} if type was set before, otherwise {@code false}.
   */
  public boolean unsetType() {
    if (isSetType()) {
      DiffusionKind oldType = type;
      type = null;
      firePropertyChange(SpatialConstants.type, oldType, type);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coordinateReference1.
   *  
   * @return {@code true} if coordinateReference1 was set before, otherwise
   * {@code false}.
   */
  public boolean unsetCoordinateReference1() {
    if (isSetCoordinateReference1()) {
      CoordinateKind oldCoordinateReference1 = coordinateReference1;
      coordinateReference1 = null;
      firePropertyChange(SpatialConstants.coordinateReference1,
        oldCoordinateReference1, coordinateReference1);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coordinateReference2.
   *  
   * @return {@code true} if coordinateReference2 was set before, otherwise
   * {@code false}.
   */
  public boolean unsetCoordinateReference2() {
    if (isSetCoordinateReference2()) {
      CoordinateKind oldCoordinateReference2 = coordinateReference2;
      coordinateReference2 = null;
      firePropertyChange(SpatialConstants.coordinateReference2,
        oldCoordinateReference2, coordinateReference2);
      return true;
    }
    return false;
  }

  /* hashcode method for DiffusionCoefficient.
   */
  @Override
  public int hashCode() {
    final int prime = 5616011;

    int hashCode = super.hashCode();

    if (isSetVariable()) {
      hashCode += prime * getVariable().hashCode();
    }
    if (isSetType()) {
      hashCode += prime * getType().hashCode();
    }
    if (isSetCoordinateReference1()) {
      hashCode += prime * getCoordinateReference1().hashCode();
    }
    if (isSetCoordinateReference2()) {
      hashCode += prime * getCoordinateReference2().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DiffusionCoefficient [");
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

      if (attributeName.equals(SpatialConstants.variable)) {
        setVariable(value);
      }      else if (attributeName.equals(SpatialConstants.type)) {
        try {
          setType(DiffusionKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.type + " on the 'DiffusionCoefficient'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.coordinateReference1)) {
        try {
          setCoordinateReference1(CoordinateKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.coordinateReference1 + " on the
              'DiffusionCoefficient' element.");
        }
      }      else if (attributeName.equals(SpatialConstants.coordinateReference2)) {
        try {
          setCoordinateReference2(CoordinateKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.coordinateReference2 + " on the
              'DiffusionCoefficient' element.");
        }
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

    if (isSetVariable()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.variable,
        getVariable());
    }
    if (isSetType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.type,
        getType().toString());
    }
    if (isSetCoordinateReference1()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.coordinateReference1, getCoordinateReference1().toString());
    }
    if (isSetCoordinateReference2()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.coordinateReference2, getCoordinateReference2().toString());
    }
    return attributes;
  }

}
