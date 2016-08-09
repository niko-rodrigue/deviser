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
public class CSGTranslation extends CSGTransformation {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 64031669196026314L;
  /**
   *
   */
  private Double translateX;
  /**
   *
   */
  private Double translateY;
  /**
   *
   */
  private Double translateZ;

  /**
   *  
   */
  public CSGTranslation() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGTranslation(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGTranslation(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGTranslation(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGTranslation(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGTranslation instance to copy.
   */
  public CSGTranslation(CSGTranslation orig) {
    super(orig);

    if (orig.isSetTranslateX()) {
      setTranslateX(orig.getTranslateX());
    }
    if (orig.isSetTranslateY()) {
      setTranslateY(orig.getTranslateY());
    }
    if (orig.isSetTranslateZ()) {
      setTranslateZ(orig.getTranslateZ());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    translateX = null;
    translateY = null;
    translateZ = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGTranslation obj = (CSGTranslation) object;

      equals &= obj.isSetTranslateX() == isSetTranslateX();
      if (equals && isSetTranslateX()) {
        equals &= (obj.getTranslateX() == getTranslateX());
      }
      equals &= obj.isSetTranslateY() == isSetTranslateY();
      if (equals && isSetTranslateY()) {
        equals &= (obj.getTranslateY() == getTranslateY());
      }
      equals &= obj.isSetTranslateZ() == isSetTranslateZ();
      if (equals && isSetTranslateZ()) {
        equals &= (obj.getTranslateZ() == getTranslateZ());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGTranslation clone() {
    return new CSGTranslation(this);
  }

  /**
   * Returns the value of {@link translateX}.
   *  
   * @return the value of {@link translateX}.
   */
  public double getTranslateX() {
    if (isSetTranslateX()) {
      return translateX.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.translateX, this);
  }

  /**
   * Returns the value of {@link translateY}.
   *  
   * @return the value of {@link translateY}.
   */
  public double getTranslateY() {
    if (isSetTranslateY()) {
      return translateY.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.translateY, this);
  }

  /**
   * Returns the value of {@link translateZ}.
   *  
   * @return the value of {@link translateZ}.
   */
  public double getTranslateZ() {
    if (isSetTranslateZ()) {
      return translateZ.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.translateZ, this);
  }

  /**
   * Returns whether {@link translateX} is set.
   *  
   * @return whether {@link translateX} is set.
   */
  public boolean isSetTranslateX() {
    return this.translateX != null;
  }

  /**
   * Returns whether {@link translateY} is set.
   *  
   * @return whether {@link translateY} is set.
   */
  public boolean isSetTranslateY() {
    return this.translateY != null;
  }

  /**
   * Returns whether {@link translateZ} is set.
   *  
   * @return whether {@link translateZ} is set.
   */
  public boolean isSetTranslateZ() {
    return this.translateZ != null;
  }

  /**
   * Sets the value of translateX
   *  
   * @param translateX the value of translateX to be set.
   */
  public boolean setTranslateX(double translateX) {
    if (translateX != this.translateX) {
      Double oldTranslateX = this.translateX;
      this.translateX = translateX;
      firePropertyChange(SpatialConstants.translateX, oldTranslateX,
        this.translateX);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of translateY
   *  
   * @param translateY the value of translateY to be set.
   */
  public boolean setTranslateY(double translateY) {
    if (translateY != this.translateY) {
      Double oldTranslateY = this.translateY;
      this.translateY = translateY;
      firePropertyChange(SpatialConstants.translateY, oldTranslateY,
        this.translateY);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of translateZ
   *  
   * @param translateZ the value of translateZ to be set.
   */
  public boolean setTranslateZ(double translateZ) {
    if (translateZ != this.translateZ) {
      Double oldTranslateZ = this.translateZ;
      this.translateZ = translateZ;
      firePropertyChange(SpatialConstants.translateZ, oldTranslateZ,
        this.translateZ);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable translateX.
   *  
   * @return {@code true} if translateX was set before, otherwise {@code
   * false}.
   */
  public boolean unsetTranslateX() {
    if (isSetTranslateX()) {
      Double oldTranslateX = translateX;
      translateX = null;
      firePropertyChange(SpatialConstants.translateX, oldTranslateX,
        translateX);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable translateY.
   *  
   * @return {@code true} if translateY was set before, otherwise {@code
   * false}.
   */
  public boolean unsetTranslateY() {
    if (isSetTranslateY()) {
      Double oldTranslateY = translateY;
      translateY = null;
      firePropertyChange(SpatialConstants.translateY, oldTranslateY,
        translateY);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable translateZ.
   *  
   * @return {@code true} if translateZ was set before, otherwise {@code
   * false}.
   */
  public boolean unsetTranslateZ() {
    if (isSetTranslateZ()) {
      Double oldTranslateZ = translateZ;
      translateZ = null;
      firePropertyChange(SpatialConstants.translateZ, oldTranslateZ,
        translateZ);
      return true;
    }
    return false;
  }

  /* hashcode method for CSGTranslation.
   */
  @Override
  public int hashCode() {
    final int prime = 1040959;

    int hashCode = super.hashCode();

    if (isSetTranslateX()) {
      hashCode += prime * getTranslateX();
    }
    if (isSetTranslateY()) {
      hashCode += prime * getTranslateY();
    }
    if (isSetTranslateZ()) {
      hashCode += prime * getTranslateZ();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGTranslation [");
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

      if (attributeName.equals(SpatialConstants.translateX)) {
        setTranslateX(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.translateY)) {
        setTranslateY(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.translateZ)) {
        setTranslateZ(StringTools.parseSBMLDouble(value));
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

    if (isSetTranslateX()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.translateX,
        StringTools.toString(Locale.ENGLISH, getTranslateX()));
    }
    if (isSetTranslateY()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.translateY,
        StringTools.toString(Locale.ENGLISH, getTranslateY()));
    }
    if (isSetTranslateZ()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.translateZ,
        StringTools.toString(Locale.ENGLISH, getTranslateZ()));
    }
    return attributes;
  }

}
