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
public class TransformationComponents {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 3110320089347290L;
  /**
   *
   */
  private double components;
  /**
   *
   */
  private Integer componentsLength;

  /**
   *  
   */
  public TransformationComponents() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public TransformationComponents(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public TransformationComponents(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public TransformationComponents(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public TransformationComponents(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the TransformationComponents instance to copy.
   */
  public TransformationComponents(TransformationComponents orig) {
    super(orig);

    if (orig.isSetComponents()) {
      setComponents(orig.getComponents());
    }
    if (orig.isSetComponentsLength()) {
      setComponentsLength(orig.getComponentsLength());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    components = null;
    componentsLength = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      TransformationComponents obj = (TransformationComponents) object;

      equals &= obj.isSetComponents() == isSetComponents();
      if (equals && isSetComponents()) {
        equals &= (obj.getComponents() == getComponents());
      }
      equals &= obj.isSetComponentsLength() == isSetComponentsLength();
      if (equals && isSetComponentsLength()) {
        equals &= (obj.getComponentsLength() == getComponentsLength());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public TransformationComponents clone() {
    return new TransformationComponents(this);
  }

  public void getComponents(double outArray) {
    if (outArray == NULL || components == NULL) {
      return;
    }
    memcpy(outArray, components, sizeof(double)*componentsLength);
  }

  public void getComponents(double outArray) {
    if (outArray == NULL || components == NULL) {
      return;
    }
    memcpy(outArray, components, sizeof(double)*componentsLength);
  }

  /**
   * Returns the value of {@link componentsLength}.
   *  
   * @return the value of {@link componentsLength}.
   */
  public int getComponentsLength() {
    if (isSetComponentsLength()) {
      return componentsLength.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.componentsLength, this);
  }

  /**
   * Returns whether {@link components} is set.
   *  
   * @return whether {@link components} is set.
   */
  public boolean isSetComponents() {
    return this.components != null;
  }

  /**
   * Returns whether {@link componentsLength} is set.
   *  
   * @return whether {@link componentsLength} is set.
   */
  public boolean isSetComponentsLength() {
    return this.componentsLength != null;
  }

  /**
   * @param inArray double array value of the "components" attribute to be set.
   * @param arrayLength int value for the length of the "components" attribute
   * to be set.
   */
  public int setComponents(double inArray, int arrayLength) {
    if (inArray == NULL) {
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    }
    if (components != NULL) {
      delete[] components;
    }
    components = new double[arrayLength];
    memcpy(components, inArray, sizeof(double)*arrayLength);
    mIsSetComponentsLength = true;
    componentsLength = arrayLength;

    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of componentsLength
   *  
   * @param componentsLength the value of componentsLength to be set.
   */
  public boolean setComponentsLength(int componentsLength) {
    if (componentsLength != this.componentsLength) {
      Integer oldComponentsLength = this.componentsLength;
      this.componentsLength = componentsLength;
      firePropertyChange(SpatialConstants.componentsLength,
        oldComponentsLength, this.componentsLength);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable components.
   *  
   * @return {@code true} if components was set before, otherwise {@code
   * false}.
   */
  public boolean unsetComponents() {
    if (components != NULL) {
      delete[] components;
    }
    components = NULL;

    return unsetComponentsLength();
  }

  /**
   * Unsets the variable componentsLength.
   *  
   * @return {@code true} if componentsLength was set before, otherwise {@code
   * false}.
   */
  public boolean unsetComponentsLength() {
    if (isSetComponentsLength()) {
      Integer oldComponentsLength = componentsLength;
      componentsLength = null;
      firePropertyChange(SpatialConstants.componentsLength,
        oldComponentsLength, componentsLength);
      return true;
    }
    return false;
  }

  /* hashcode method for TransformationComponents.
   */
  @Override
  public int hashCode() {
    final int prime = 1318193;

    int hashCode = super.hashCode();

    if (isSetComponents()) {
      hashCode += prime;
    }
    if (isSetComponentsLength()) {
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
    builder.append("TransformationComponents [");
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

    if (isSetComponents()) {
      hashCode += prime;
    }
    if (isSetComponentsLength()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.componentsLength, Integer.toString(getComponentsLength()));
    }
    return attributes;
  }

}
