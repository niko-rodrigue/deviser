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
public class CSGRotation extends CSGTransformation {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 1943208282851150L;
  /**
   *
   */
  private Double rotateX;
  /**
   *
   */
  private Double rotateY;
  /**
   *
   */
  private Double rotateZ;
  /**
   *
   */
  private Double rotateAngleInRadians;

  /**
   *  
   */
  public CSGRotation() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGRotation(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGRotation(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGRotation(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGRotation(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGRotation instance to copy.
   */
  public CSGRotation(CSGRotation orig) {
    super(orig);

    if (orig.isSetRotateX()) {
      setRotateX(orig.getRotateX());
    }
    if (orig.isSetRotateY()) {
      setRotateY(orig.getRotateY());
    }
    if (orig.isSetRotateZ()) {
      setRotateZ(orig.getRotateZ());
    }
    if (orig.isSetRotateAngleInRadians()) {
      setRotateAngleInRadians(orig.getRotateAngleInRadians());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    rotateX = null;
    rotateY = null;
    rotateZ = null;
    rotateAngleInRadians = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGRotation obj = (CSGRotation) object;

      equals &= obj.isSetRotateX() == isSetRotateX();
      if (equals && isSetRotateX()) {
        equals &= (obj.getRotateX() == getRotateX());
      }
      equals &= obj.isSetRotateY() == isSetRotateY();
      if (equals && isSetRotateY()) {
        equals &= (obj.getRotateY() == getRotateY());
      }
      equals &= obj.isSetRotateZ() == isSetRotateZ();
      if (equals && isSetRotateZ()) {
        equals &= (obj.getRotateZ() == getRotateZ());
      }
      equals &= obj.isSetRotateAngleInRadians() == isSetRotateAngleInRadians();
      if (equals && isSetRotateAngleInRadians()) {
        equals &= (obj.getRotateAngleInRadians() == getRotateAngleInRadians());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGRotation clone() {
    return new CSGRotation(this);
  }

  /**
   * Returns the value of {@link rotateX}.
   *  
   * @return the value of {@link rotateX}.
   */
  public double getRotateX() {
    if (isSetRotateX()) {
      return rotateX.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.rotateX, this);
  }

  /**
   * Returns the value of {@link rotateY}.
   *  
   * @return the value of {@link rotateY}.
   */
  public double getRotateY() {
    if (isSetRotateY()) {
      return rotateY.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.rotateY, this);
  }

  /**
   * Returns the value of {@link rotateZ}.
   *  
   * @return the value of {@link rotateZ}.
   */
  public double getRotateZ() {
    if (isSetRotateZ()) {
      return rotateZ.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.rotateZ, this);
  }

  /**
   * Returns the value of {@link rotateAngleInRadians}.
   *  
   * @return the value of {@link rotateAngleInRadians}.
   */
  public double getRotateAngleInRadians() {
    if (isSetRotateAngleInRadians()) {
      return rotateAngleInRadians.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.rotateAngleInRadians,
      this);
  }

  /**
   * Returns whether {@link rotateX} is set.
   *  
   * @return whether {@link rotateX} is set.
   */
  public boolean isSetRotateX() {
    return this.rotateX != null;
  }

  /**
   * Returns whether {@link rotateY} is set.
   *  
   * @return whether {@link rotateY} is set.
   */
  public boolean isSetRotateY() {
    return this.rotateY != null;
  }

  /**
   * Returns whether {@link rotateZ} is set.
   *  
   * @return whether {@link rotateZ} is set.
   */
  public boolean isSetRotateZ() {
    return this.rotateZ != null;
  }

  /**
   * Returns whether {@link rotateAngleInRadians} is set.
   *  
   * @return whether {@link rotateAngleInRadians} is set.
   */
  public boolean isSetRotateAngleInRadians() {
    return this.rotateAngleInRadians != null;
  }

  /**
   * Sets the value of rotateX
   *  
   * @param rotateX the value of rotateX to be set.
   */
  public boolean setRotateX(double rotateX) {
    if (rotateX != this.rotateX) {
      Double oldRotateX = this.rotateX;
      this.rotateX = rotateX;
      firePropertyChange(SpatialConstants.rotateX, oldRotateX, this.rotateX);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of rotateY
   *  
   * @param rotateY the value of rotateY to be set.
   */
  public boolean setRotateY(double rotateY) {
    if (rotateY != this.rotateY) {
      Double oldRotateY = this.rotateY;
      this.rotateY = rotateY;
      firePropertyChange(SpatialConstants.rotateY, oldRotateY, this.rotateY);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of rotateZ
   *  
   * @param rotateZ the value of rotateZ to be set.
   */
  public boolean setRotateZ(double rotateZ) {
    if (rotateZ != this.rotateZ) {
      Double oldRotateZ = this.rotateZ;
      this.rotateZ = rotateZ;
      firePropertyChange(SpatialConstants.rotateZ, oldRotateZ, this.rotateZ);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of rotateAngleInRadians
   *  
   * @param rotateAngleInRadians the value of rotateAngleInRadians to be set.
   */
  public boolean setRotateAngleInRadians(double rotateAngleInRadians) {
    if (rotateAngleInRadians != this.rotateAngleInRadians) {
      Double oldRotateAngleInRadians = this.rotateAngleInRadians;
      this.rotateAngleInRadians = rotateAngleInRadians;
      firePropertyChange(SpatialConstants.rotateAngleInRadians,
        oldRotateAngleInRadians, this.rotateAngleInRadians);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable rotateX.
   *  
   * @return {@code true} if rotateX was set before, otherwise {@code false}.
   */
  public boolean unsetRotateX() {
    if (isSetRotateX()) {
      Double oldRotateX = rotateX;
      rotateX = null;
      firePropertyChange(SpatialConstants.rotateX, oldRotateX, rotateX);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable rotateY.
   *  
   * @return {@code true} if rotateY was set before, otherwise {@code false}.
   */
  public boolean unsetRotateY() {
    if (isSetRotateY()) {
      Double oldRotateY = rotateY;
      rotateY = null;
      firePropertyChange(SpatialConstants.rotateY, oldRotateY, rotateY);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable rotateZ.
   *  
   * @return {@code true} if rotateZ was set before, otherwise {@code false}.
   */
  public boolean unsetRotateZ() {
    if (isSetRotateZ()) {
      Double oldRotateZ = rotateZ;
      rotateZ = null;
      firePropertyChange(SpatialConstants.rotateZ, oldRotateZ, rotateZ);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable rotateAngleInRadians.
   *  
   * @return {@code true} if rotateAngleInRadians was set before, otherwise
   * {@code false}.
   */
  public boolean unsetRotateAngleInRadians() {
    if (isSetRotateAngleInRadians()) {
      Double oldRotateAngleInRadians = rotateAngleInRadians;
      rotateAngleInRadians = null;
      firePropertyChange(SpatialConstants.rotateAngleInRadians,
        oldRotateAngleInRadians, rotateAngleInRadians);
      return true;
    }
    return false;
  }

  /* hashcode method for CSGRotation.
   */
  @Override
  public int hashCode() {
    final int prime = 2164193;

    int hashCode = super.hashCode();

    if (isSetRotateX()) {
      hashCode += prime * getRotateX();
    }
    if (isSetRotateY()) {
      hashCode += prime * getRotateY();
    }
    if (isSetRotateZ()) {
      hashCode += prime * getRotateZ();
    }
    if (isSetRotateAngleInRadians()) {
      hashCode += prime * getRotateAngleInRadians();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGRotation [");
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

      if (attributeName.equals(SpatialConstants.rotateX)) {
        setRotateX(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.rotateY)) {
        setRotateY(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.rotateZ)) {
        setRotateZ(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.rotateAngleInRadians)) {
        setRotateAngleInRadians(StringTools.parseSBMLDouble(value));
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

    if (isSetRotateX()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.rotateX,
        StringTools.toString(Locale.ENGLISH, getRotateX()));
    }
    if (isSetRotateY()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.rotateY,
        StringTools.toString(Locale.ENGLISH, getRotateY()));
    }
    if (isSetRotateZ()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.rotateZ,
        StringTools.toString(Locale.ENGLISH, getRotateZ()));
    }
    if (isSetRotateAngleInRadians()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.rotateAngleInRadians, StringTools.toString(Locale.ENGLISH,
          getRotateAngleInRadians()));
    }
    return attributes;
  }

}
