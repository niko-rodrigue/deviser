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
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;
import org.sbml.jsbml.xml.XMLNode;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class CoordinateComponent {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 27285434930917975L;
  /**
   *
   */
  private CoordinateKind type;
  /**
   *
   */
  private String unit;
  /**
   *
   */
  private XMLNode boundaryMin;
  /**
   *
   */
  private XMLNode boundaryMax;

  /**
   *  
   */
  public CoordinateComponent() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CoordinateComponent(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the CoordinateComponent instance to copy.
   */
  public CoordinateComponent(CoordinateComponent orig) {
    super(orig);

    if (orig.isSetType()) {
      setType(orig.getType());
    }
    if (orig.isSetUnit()) {
      setUnit(orig.getUnit());
    }
    if (orig.isSetBoundaryMin()) {
      setBoundaryMin(orig.getBoundaryMin().clone());
    }
    if (orig.isSetBoundaryMax()) {
      setBoundaryMax(orig.getBoundaryMax().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    type = null;
    unit = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CoordinateComponent obj = (CoordinateComponent) object;

      equals &= obj.isSetType() == isSetType();
      if (equals && isSetType()) {
        equals &= (obj.getType() == getType());
      }
      equals &= obj.isSetUnit() == isSetUnit();
      if (equals && isSetUnit()) {
        equals &= (obj.getUnit() == getUnit());
      }
      equals &= obj.isSetBoundaryMin() == isSetBoundaryMin();
      if (equals && isSetBoundaryMin()) {
        equals &= (obj.getBoundaryMin() == getBoundaryMin());
      }
      equals &= obj.isSetBoundaryMax() == isSetBoundaryMax();
      if (equals && isSetBoundaryMax()) {
        equals &= (obj.getBoundaryMax() == getBoundaryMax());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CoordinateComponent clone() {
    return new CoordinateComponent(this);
  }

  /**
   * Returns the value of {@link type}.
   *  
   * @return the value of {@link type}.
   */
  public CoordinateKind getType() {
    if (isSetType()) {
      return type;
    }
    throw new PropertyUndefinedError(SpatialConstants.type, this);
  }

  /**
   * Returns the value of {@link unit}.
   *  
   * @return the value of {@link unit}.
   */
  public String getUnit() {
    return isSetUnit() ? unit : "";
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
   * Returns whether {@link unit} is set.
   *  
   * @return whether {@link unit} is set.
   */
  public boolean isSetUnit() {
    return this.unit != null;
  }

  /**
   * Sets the value of type
   *  
   * @param type the value of type to be set.
   */
  public boolean setType(CoordinateKind type) {
    if (type != this.type) {
      CoordinateKind oldType = this.type;
      this.type = type;
      firePropertyChange(SpatialConstants.type, oldType, this.type);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of unit
   *  
   * @param unit the value of unit to be set.
   */
  public boolean setUnit(String unit) {
    if (unit != this.unit) {
      String oldUnit = this.unit;
      this.unit = unit;
      firePropertyChange(SpatialConstants.unit, oldUnit, this.unit);
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
      CoordinateKind oldType = type;
      type = null;
      firePropertyChange(SpatialConstants.type, oldType, type);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable unit.
   *  
   * @return {@code true} if unit was set before, otherwise {@code false}.
   */
  public boolean unsetUnit() {
    if (isSetUnit()) {
      String oldUnit = unit;
      unit = null;
      firePropertyChange(SpatialConstants.unit, oldUnit, unit);
      return true;
    }
    return false;
  }

  /**
   * Returns the value of {@link boundaryMin}.
   *  
   * @return the value of {@link boundaryMin}.
   */
  public XMLNode getBoundaryMin() {
    if (isSetBoundaryMin()) {
      return boundaryMin;
    }
    throw new PropertyUndefinedError(SpatialConstants.boundaryMin, this);
  }

  /**
   * Returns the value of {@link boundaryMax}.
   *  
   * @return the value of {@link boundaryMax}.
   */
  public XMLNode getBoundaryMax() {
    if (isSetBoundaryMax()) {
      return boundaryMax;
    }
    throw new PropertyUndefinedError(SpatialConstants.boundaryMax, this);
  }

  /**
   * Returns whether {@link boundaryMin} is set.
   *  
   * @return whether {@link boundaryMin} is set.
   */
  public boolean isSetBoundaryMin() {
    return boundaryMin != null;
  }

  /**
   * Returns whether {@link boundaryMax} is set.
   *  
   * @return whether {@link boundaryMax} is set.
   */
  public boolean isSetBoundaryMax() {
    return boundaryMax != null;
  }

  /**
   * Sets the value of boundaryMin
   *  
   * @param boundaryMin the value of boundaryMin to be set.
   */
  public boolean setBoundaryMin(XMLNode boundaryMin) {
    if (boundaryMin != this.boundaryMin) {
      XMLNode oldBoundaryMin = this.boundaryMin;
      this.boundaryMin = boundaryMin;
      firePropertyChange(SpatialConstants.boundaryMin, oldBoundaryMin,
        this.boundaryMin);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of boundaryMax
   *  
   * @param boundaryMax the value of boundaryMax to be set.
   */
  public boolean setBoundaryMax(XMLNode boundaryMax) {
    if (boundaryMax != this.boundaryMax) {
      XMLNode oldBoundaryMax = this.boundaryMax;
      this.boundaryMax = boundaryMax;
      firePropertyChange(SpatialConstants.boundaryMax, oldBoundaryMax,
        this.boundaryMax);
      return true;
    }
    return false;
  }

  /**
   * Creates a new Boundary object, adds it to this CoordinateComponent object
   * and returns the Boundary object created.
   */
  public XMLNode createBoundaryMin() {
    XMLNode boundaryMin = new XMLNode(getLevel(), getVersion());
    return boundaryMin;
  }

  /**
   * Creates a new Boundary object, adds it to this CoordinateComponent object
   * and returns the Boundary object created.
   */
  public XMLNode createBoundaryMax() {
    XMLNode boundaryMax = new XMLNode(getLevel(), getVersion());
    return boundaryMax;
  }

  /**
   * Unsets the variable boundaryMin.
   *  
   * @return {@code true} if boundaryMin was set before, otherwise {@code
   * false}.
   */
  public boolean unsetBoundaryMin() {
    if (isSetBoundaryMin()) {
      XMLNode oldBoundaryMin = boundaryMin;
      boundaryMin = null;
      firePropertyChange(SpatialConstants.boundaryMin, oldBoundaryMin,
        boundaryMin);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable boundaryMax.
   *  
   * @return {@code true} if boundaryMax was set before, otherwise {@code
   * false}.
   */
  public boolean unsetBoundaryMax() {
    if (isSetBoundaryMax()) {
      XMLNode oldBoundaryMax = boundaryMax;
      boundaryMax = null;
      firePropertyChange(SpatialConstants.boundaryMax, oldBoundaryMax,
        boundaryMax);
      return true;
    }
    return false;
  }

  /* hashcode method for CoordinateComponent.
   */
  @Override
  public int hashCode() {
    final int prime = 5126959;

    int hashCode = super.hashCode();

    if (isSetType()) {
      hashCode += prime * getType().hashCode();
    }
    if (isSetUnit()) {
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
    builder.append("CoordinateComponent [");
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

      if (attributeName.equals(SpatialConstants.type)) {
        try {
          setType(CoordinateKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.type + " on the 'CoordinateComponent'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.unit)) {
        setUnit(StringTools.parseSBMLString(value));
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

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(SpatialConstants.shortLabel + ":id", getId());
    }
    if (isSetType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.type,
        getType().toString());
    }
    if (isSetUnit()) {
      hashCode += prime;
    }
    return attributes;
  }

}
