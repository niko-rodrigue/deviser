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
public class CSGScale extends CSGTransformation {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 34967763767790994L;
  /**
   *
   */
  private Double scaleX;
  /**
   *
   */
  private Double scaleY;
  /**
   *
   */
  private Double scaleZ;

  /**
   *  
   */
  public CSGScale() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGScale(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGScale(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGScale(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGScale(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGScale instance to copy.
   */
  public CSGScale(CSGScale orig) {
    super(orig);

    if (orig.isSetScaleX()) {
      setScaleX(orig.getScaleX());
    }
    if (orig.isSetScaleY()) {
      setScaleY(orig.getScaleY());
    }
    if (orig.isSetScaleZ()) {
      setScaleZ(orig.getScaleZ());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    scaleX = null;
    scaleY = null;
    scaleZ = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGScale obj = (CSGScale) object;

      equals &= obj.isSetScaleX() == isSetScaleX();
      if (equals && isSetScaleX()) {
        equals &= (obj.getScaleX() == getScaleX());
      }
      equals &= obj.isSetScaleY() == isSetScaleY();
      if (equals && isSetScaleY()) {
        equals &= (obj.getScaleY() == getScaleY());
      }
      equals &= obj.isSetScaleZ() == isSetScaleZ();
      if (equals && isSetScaleZ()) {
        equals &= (obj.getScaleZ() == getScaleZ());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGScale clone() {
    return new CSGScale(this);
  }

  /**
   * Returns the value of {@link scaleX}.
   *  
   * @return the value of {@link scaleX}.
   */
  public double getScaleX() {
    if (isSetScaleX()) {
      return scaleX.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.scaleX, this);
  }

  /**
   * Returns the value of {@link scaleY}.
   *  
   * @return the value of {@link scaleY}.
   */
  public double getScaleY() {
    if (isSetScaleY()) {
      return scaleY.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.scaleY, this);
  }

  /**
   * Returns the value of {@link scaleZ}.
   *  
   * @return the value of {@link scaleZ}.
   */
  public double getScaleZ() {
    if (isSetScaleZ()) {
      return scaleZ.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.scaleZ, this);
  }

  /**
   * Returns whether {@link scaleX} is set.
   *  
   * @return whether {@link scaleX} is set.
   */
  public boolean isSetScaleX() {
    return this.scaleX != null;
  }

  /**
   * Returns whether {@link scaleY} is set.
   *  
   * @return whether {@link scaleY} is set.
   */
  public boolean isSetScaleY() {
    return this.scaleY != null;
  }

  /**
   * Returns whether {@link scaleZ} is set.
   *  
   * @return whether {@link scaleZ} is set.
   */
  public boolean isSetScaleZ() {
    return this.scaleZ != null;
  }

  /**
   * Sets the value of scaleX
   *  
   * @param scaleX the value of scaleX to be set.
   */
  public boolean setScaleX(double scaleX) {
    if (scaleX != this.scaleX) {
      Double oldScaleX = this.scaleX;
      this.scaleX = scaleX;
      firePropertyChange(SpatialConstants.scaleX, oldScaleX, this.scaleX);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of scaleY
   *  
   * @param scaleY the value of scaleY to be set.
   */
  public boolean setScaleY(double scaleY) {
    if (scaleY != this.scaleY) {
      Double oldScaleY = this.scaleY;
      this.scaleY = scaleY;
      firePropertyChange(SpatialConstants.scaleY, oldScaleY, this.scaleY);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of scaleZ
   *  
   * @param scaleZ the value of scaleZ to be set.
   */
  public boolean setScaleZ(double scaleZ) {
    if (scaleZ != this.scaleZ) {
      Double oldScaleZ = this.scaleZ;
      this.scaleZ = scaleZ;
      firePropertyChange(SpatialConstants.scaleZ, oldScaleZ, this.scaleZ);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable scaleX.
   *  
   * @return {@code true} if scaleX was set before, otherwise {@code false}.
   */
  public boolean unsetScaleX() {
    if (isSetScaleX()) {
      Double oldScaleX = scaleX;
      scaleX = null;
      firePropertyChange(SpatialConstants.scaleX, oldScaleX, scaleX);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable scaleY.
   *  
   * @return {@code true} if scaleY was set before, otherwise {@code false}.
   */
  public boolean unsetScaleY() {
    if (isSetScaleY()) {
      Double oldScaleY = scaleY;
      scaleY = null;
      firePropertyChange(SpatialConstants.scaleY, oldScaleY, scaleY);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable scaleZ.
   *  
   * @return {@code true} if scaleZ was set before, otherwise {@code false}.
   */
  public boolean unsetScaleZ() {
    if (isSetScaleZ()) {
      Double oldScaleZ = scaleZ;
      scaleZ = null;
      firePropertyChange(SpatialConstants.scaleZ, oldScaleZ, scaleZ);
      return true;
    }
    return false;
  }

  /* hashcode method for CSGScale.
   */
  @Override
  public int hashCode() {
    final int prime = 6399209;

    int hashCode = super.hashCode();

    if (isSetScaleX()) {
      hashCode += prime * getScaleX();
    }
    if (isSetScaleY()) {
      hashCode += prime * getScaleY();
    }
    if (isSetScaleZ()) {
      hashCode += prime * getScaleZ();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGScale [");
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

      if (attributeName.equals(SpatialConstants.scaleX)) {
        setScaleX(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.scaleY)) {
        setScaleY(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.scaleZ)) {
        setScaleZ(StringTools.parseSBMLDouble(value));
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

    if (isSetScaleX()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.scaleX,
        StringTools.toString(Locale.ENGLISH, getScaleX()));
    }
    if (isSetScaleY()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.scaleY,
        StringTools.toString(Locale.ENGLISH, getScaleY()));
    }
    if (isSetScaleZ()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.scaleZ,
        StringTools.toString(Locale.ENGLISH, getScaleZ()));
    }
    return attributes;
  }

}
