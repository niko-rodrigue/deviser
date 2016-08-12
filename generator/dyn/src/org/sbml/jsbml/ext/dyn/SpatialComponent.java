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
package org.sbml.jsbml.ext.dyn;

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
public class SpatialComponent extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 2094032791819041L;
  /**
   *
   */
  private SpatialKind spatialIndex;
  /**
   *
   */
  private String variable;

  /**
   *  
   */
  public SpatialComponent() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public SpatialComponent(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public SpatialComponent(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public SpatialComponent(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public SpatialComponent(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the SpatialComponent instance to copy.
   */
  public SpatialComponent(SpatialComponent orig) {
    super(orig);

    if (orig.isSetSpatialIndex()) {
      setSpatialIndex(orig.getSpatialIndex());
    }
    if (orig.isSetVariable()) {
      setVariable(orig.getVariable());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = DynConstants.shortLabel;
    spatialIndex = null;
    variable = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      SpatialComponent obj = (SpatialComponent) object;

      equals &= obj.isSetSpatialIndex() == isSetSpatialIndex();
      if (equals && isSetSpatialIndex()) {
        equals &= (obj.getSpatialIndex() == getSpatialIndex());
      }
      equals &= obj.isSetVariable() == isSetVariable();
      if (equals && isSetVariable()) {
        equals &= (obj.getVariable() == getVariable());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public SpatialComponent clone() {
    return new SpatialComponent(this);
  }

  /**
   * Returns the value of {@link spatialIndex}.
   *  
   * @return the value of {@link spatialIndex}.
   */
  public SpatialKind getSpatialIndex() {
    if (isSetSpatialIndex()) {
      return spatialIndex;
    }
    throw new PropertyUndefinedError(DynConstants.spatialIndex, this);
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
   * Returns whether {@link spatialIndex} is set.
   *  
   * @return whether {@link spatialIndex} is set.
   */
  public boolean isSetSpatialIndex() {
    return this.spatialIndex != null;
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
   * Sets the value of spatialIndex
   *  
   * @param spatialIndex the value of spatialIndex to be set.
   */
  public boolean setSpatialIndex(SpatialKind spatialIndex) {
    if (isSetSpatialIndex()) {
      SpatialKind oldSpatialIndex = spatialIndex;
      spatialIndex = null;
      firePropertyChange(DynConstants.spatialIndex, oldSpatialIndex,
        spatialIndex);
      return true;
    }
    return false;
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
      firePropertyChange(DynConstants.variable, oldVariable, this.variable);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable spatialIndex.
   *  
   * @return {@code true} if spatialIndex was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSpatialIndex() {
    if (isSetSpatialIndex()) {
      SpatialKind oldSpatialIndex = spatialIndex;
      spatialIndex = null;
      firePropertyChange(DynConstants.spatialIndex, oldSpatialIndex,
        spatialIndex);
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
      firePropertyChange(DynConstants.variable, oldVariable, variable);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return false;
  }

  /**
   * @return true
   */
  public boolean isSpatialIndexMandatory() {
    return true;
  }

  /**
   * @return true
   */
  public boolean isVariableMandatory() {
    return true;
  }

  /* hashcode method for SpatialComponent.
   */
  @Override
  public int hashCode() {
    final int prime = 7639831;

    int hashCode = super.hashCode();

    if (isSetSpatialIndex()) {
      hashCode += prime;
    }
    if (isSetVariable()) {
      hashCode += prime * getVariable().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SpatialComponent [");
    builder.append("spatialIndex = ");
    builder.append(spatialIndex);
    builder.append(", ");
    builder.append("variable = ");
    builder.append(variable);
    builder.append(", id = ");
    builder.append(getId());
    builder.append(", name = ");
    builder.append(getName());
    builder.append("]");
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

      if (attributeName.equals(DynConstants.spatialIndex)) {
        setSpatialIndex(SpatialKind.valueOf(value));
      }      else if (attributeName.equals(DynConstants.variable)) {
        setVariable(value);
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
      attributes.put(DynConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(DynConstants.shortLabel + ":name", getName());
    }
    if (isSetSpatialIndex()) {
      attributes.remove("spatialIndex");
      attributes.put(DynConstants.shortLabel + ":" + DynConstants.spatialIndex,
        spatialIndex.toString());
    }
    if (isSetVariable()) {
      attributes.put(DynConstants.shortLabel + ":" + DynConstants.variable,
        getVariable());
    }
    return attributes;
  }

}
