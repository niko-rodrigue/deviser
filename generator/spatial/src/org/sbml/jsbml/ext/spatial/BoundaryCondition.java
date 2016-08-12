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
public class BoundaryCondition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 64235742627688667L;
  /**
   *
   */
  private String variable;
  /**
   *
   */
  private BoundaryConditionKind type;
  /**
   *
   */
  private String coordinateBoundary;
  /**
   *
   */
  private String boundaryDomainType;

  /**
   *  
   */
  public BoundaryCondition() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public BoundaryCondition(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public BoundaryCondition(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public BoundaryCondition(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public BoundaryCondition(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the BoundaryCondition instance to copy.
   */
  public BoundaryCondition(BoundaryCondition orig) {
    super(orig);

    if (orig.isSetVariable()) {
      setVariable(orig.getVariable());
    }
    if (orig.isSetType()) {
      setType(orig.getType());
    }
    if (orig.isSetCoordinateBoundary()) {
      setCoordinateBoundary(orig.getCoordinateBoundary());
    }
    if (orig.isSetBoundaryDomainType()) {
      setBoundaryDomainType(orig.getBoundaryDomainType());
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
    coordinateBoundary = null;
    boundaryDomainType = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      BoundaryCondition obj = (BoundaryCondition) object;

      equals &= obj.isSetVariable() == isSetVariable();
      if (equals && isSetVariable()) {
        equals &= (obj.getVariable() == getVariable());
      }
      equals &= obj.isSetType() == isSetType();
      if (equals && isSetType()) {
        equals &= (obj.getType() == getType());
      }
      equals &= obj.isSetCoordinateBoundary() == isSetCoordinateBoundary();
      if (equals && isSetCoordinateBoundary()) {
        equals &= (obj.getCoordinateBoundary() == getCoordinateBoundary());
      }
      equals &= obj.isSetBoundaryDomainType() == isSetBoundaryDomainType();
      if (equals && isSetBoundaryDomainType()) {
        equals &= (obj.getBoundaryDomainType() == getBoundaryDomainType());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public BoundaryCondition clone() {
    return new BoundaryCondition(this);
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
  public BoundaryConditionKind getType() {
    if (isSetType()) {
      return type;
    }
    throw new PropertyUndefinedError(SpatialConstants.type, this);
  }

  /**
   * Returns the value of {@link coordinateBoundary}.
   *  
   * @return the value of {@link coordinateBoundary}.
   */
  public String getCoordinateBoundary() {
    return isSetCoordinateBoundary() ? coordinateBoundary : "";
  }

  /**
   * Returns the value of {@link boundaryDomainType}.
   *  
   * @return the value of {@link boundaryDomainType}.
   */
  public String getBoundaryDomainType() {
    return isSetBoundaryDomainType() ? boundaryDomainType : "";
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
   * Returns whether {@link coordinateBoundary} is set.
   *  
   * @return whether {@link coordinateBoundary} is set.
   */
  public boolean isSetCoordinateBoundary() {
    return this.coordinateBoundary != null;
  }

  /**
   * Returns whether {@link boundaryDomainType} is set.
   *  
   * @return whether {@link boundaryDomainType} is set.
   */
  public boolean isSetBoundaryDomainType() {
    return this.boundaryDomainType != null;
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
  public boolean setType(BoundaryConditionKind type) {
    if (type != this.type) {
      BoundaryConditionKind oldType = this.type;
      this.type = type;
      firePropertyChange(SpatialConstants.type, oldType, this.type);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of coordinateBoundary
   *  
   * @param coordinateBoundary the value of coordinateBoundary to be set.
   */
  public boolean setCoordinateBoundary(String coordinateBoundary) {
    if (coordinateBoundary != this.coordinateBoundary) {
      String oldCoordinateBoundary = this.coordinateBoundary;
      this.coordinateBoundary = coordinateBoundary;
      firePropertyChange(SpatialConstants.coordinateBoundary,
        oldCoordinateBoundary, this.coordinateBoundary);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of boundaryDomainType
   *  
   * @param boundaryDomainType the value of boundaryDomainType to be set.
   */
  public boolean setBoundaryDomainType(String boundaryDomainType) {
    if (boundaryDomainType != this.boundaryDomainType) {
      String oldBoundaryDomainType = this.boundaryDomainType;
      this.boundaryDomainType = boundaryDomainType;
      firePropertyChange(SpatialConstants.boundaryDomainType,
        oldBoundaryDomainType, this.boundaryDomainType);
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
      BoundaryConditionKind oldType = type;
      type = null;
      firePropertyChange(SpatialConstants.type, oldType, type);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coordinateBoundary.
   *  
   * @return {@code true} if coordinateBoundary was set before, otherwise
   * {@code false}.
   */
  public boolean unsetCoordinateBoundary() {
    if (isSetCoordinateBoundary()) {
      String oldCoordinateBoundary = coordinateBoundary;
      coordinateBoundary = null;
      firePropertyChange(SpatialConstants.coordinateBoundary,
        oldCoordinateBoundary, coordinateBoundary);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable boundaryDomainType.
   *  
   * @return {@code true} if boundaryDomainType was set before, otherwise
   * {@code false}.
   */
  public boolean unsetBoundaryDomainType() {
    if (isSetBoundaryDomainType()) {
      String oldBoundaryDomainType = boundaryDomainType;
      boundaryDomainType = null;
      firePropertyChange(SpatialConstants.boundaryDomainType,
        oldBoundaryDomainType, boundaryDomainType);
      return true;
    }
    return false;
  }

  /* hashcode method for BoundaryCondition.
   */
  @Override
  public int hashCode() {
    final int prime = 2371099;

    int hashCode = super.hashCode();

    if (isSetVariable()) {
      hashCode += prime * getVariable().hashCode();
    }
    if (isSetType()) {
      hashCode += prime * getType().hashCode();
    }
    if (isSetCoordinateBoundary()) {
      hashCode += prime * getCoordinateBoundary().hashCode();
    }
    if (isSetBoundaryDomainType()) {
      hashCode += prime * getBoundaryDomainType().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BoundaryCondition [");
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
          setType(BoundaryConditionKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.type + " on the 'BoundaryCondition' element.");
        }
      }      else if (attributeName.equals(SpatialConstants.coordinateBoundary)) {
        setCoordinateBoundary(value);
      }      else if (attributeName.equals(SpatialConstants.boundaryDomainType)) {
        setBoundaryDomainType(value);
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
    if (isSetCoordinateBoundary()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.coordinateBoundary, getCoordinateBoundary());
    }
    if (isSetBoundaryDomainType()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.boundaryDomainType, getBoundaryDomainType());
    }
    return attributes;
  }

}
