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
public class InteriorPoint {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 53967637197096673L;
  /**
   *
   */
  private Double coord1;
  /**
   *
   */
  private Double coord2;
  /**
   *
   */
  private Double coord3;

  /**
   *  
   */
  public InteriorPoint() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public InteriorPoint(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public InteriorPoint(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public InteriorPoint(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public InteriorPoint(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the InteriorPoint instance to copy.
   */
  public InteriorPoint(InteriorPoint orig) {
    super(orig);

    if (orig.isSetCoord1()) {
      setCoord1(orig.getCoord1());
    }
    if (orig.isSetCoord2()) {
      setCoord2(orig.getCoord2());
    }
    if (orig.isSetCoord3()) {
      setCoord3(orig.getCoord3());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    coord1 = null;
    coord2 = null;
    coord3 = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      InteriorPoint obj = (InteriorPoint) object;

      equals &= obj.isSetCoord1() == isSetCoord1();
      if (equals && isSetCoord1()) {
        equals &= (obj.getCoord1() == getCoord1());
      }
      equals &= obj.isSetCoord2() == isSetCoord2();
      if (equals && isSetCoord2()) {
        equals &= (obj.getCoord2() == getCoord2());
      }
      equals &= obj.isSetCoord3() == isSetCoord3();
      if (equals && isSetCoord3()) {
        equals &= (obj.getCoord3() == getCoord3());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public InteriorPoint clone() {
    return new InteriorPoint(this);
  }

  /**
   * Returns the value of {@link coord1}.
   *  
   * @return the value of {@link coord1}.
   */
  public double getCoord1() {
    if (isSetCoord1()) {
      return coord1.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.coord1, this);
  }

  /**
   * Returns the value of {@link coord2}.
   *  
   * @return the value of {@link coord2}.
   */
  public double getCoord2() {
    if (isSetCoord2()) {
      return coord2.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.coord2, this);
  }

  /**
   * Returns the value of {@link coord3}.
   *  
   * @return the value of {@link coord3}.
   */
  public double getCoord3() {
    if (isSetCoord3()) {
      return coord3.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.coord3, this);
  }

  /**
   * Returns whether {@link coord1} is set.
   *  
   * @return whether {@link coord1} is set.
   */
  public boolean isSetCoord1() {
    return this.coord1 != null;
  }

  /**
   * Returns whether {@link coord2} is set.
   *  
   * @return whether {@link coord2} is set.
   */
  public boolean isSetCoord2() {
    return this.coord2 != null;
  }

  /**
   * Returns whether {@link coord3} is set.
   *  
   * @return whether {@link coord3} is set.
   */
  public boolean isSetCoord3() {
    return this.coord3 != null;
  }

  /**
   * Sets the value of coord1
   *  
   * @param coord1 the value of coord1 to be set.
   */
  public boolean setCoord1(double coord1) {
    if (coord1 != this.coord1) {
      Double oldCoord1 = this.coord1;
      this.coord1 = coord1;
      firePropertyChange(SpatialConstants.coord1, oldCoord1, this.coord1);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of coord2
   *  
   * @param coord2 the value of coord2 to be set.
   */
  public boolean setCoord2(double coord2) {
    if (coord2 != this.coord2) {
      Double oldCoord2 = this.coord2;
      this.coord2 = coord2;
      firePropertyChange(SpatialConstants.coord2, oldCoord2, this.coord2);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of coord3
   *  
   * @param coord3 the value of coord3 to be set.
   */
  public boolean setCoord3(double coord3) {
    if (coord3 != this.coord3) {
      Double oldCoord3 = this.coord3;
      this.coord3 = coord3;
      firePropertyChange(SpatialConstants.coord3, oldCoord3, this.coord3);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coord1.
   *  
   * @return {@code true} if coord1 was set before, otherwise {@code false}.
   */
  public boolean unsetCoord1() {
    if (isSetCoord1()) {
      Double oldCoord1 = coord1;
      coord1 = null;
      firePropertyChange(SpatialConstants.coord1, oldCoord1, coord1);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coord2.
   *  
   * @return {@code true} if coord2 was set before, otherwise {@code false}.
   */
  public boolean unsetCoord2() {
    if (isSetCoord2()) {
      Double oldCoord2 = coord2;
      coord2 = null;
      firePropertyChange(SpatialConstants.coord2, oldCoord2, coord2);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coord3.
   *  
   * @return {@code true} if coord3 was set before, otherwise {@code false}.
   */
  public boolean unsetCoord3() {
    if (isSetCoord3()) {
      Double oldCoord3 = coord3;
      coord3 = null;
      firePropertyChange(SpatialConstants.coord3, oldCoord3, coord3);
      return true;
    }
    return false;
  }

  /* hashcode method for InteriorPoint.
   */
  @Override
  public int hashCode() {
    final int prime = 3923993;

    int hashCode = super.hashCode();

    if (isSetCoord1()) {
      hashCode += prime * getCoord1();
    }
    if (isSetCoord2()) {
      hashCode += prime * getCoord2();
    }
    if (isSetCoord3()) {
      hashCode += prime * getCoord3();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("InteriorPoint [");
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

      if (attributeName.equals(SpatialConstants.coord1)) {
        setCoord1(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.coord2)) {
        setCoord2(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.coord3)) {
        setCoord3(StringTools.parseSBMLDouble(value));
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

    if (isSetCoord1()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.coord1,
        StringTools.toString(Locale.ENGLISH, getCoord1()));
    }
    if (isSetCoord2()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.coord2,
        StringTools.toString(Locale.ENGLISH, getCoord2()));
    }
    if (isSetCoord3()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.coord3,
        StringTools.toString(Locale.ENGLISH, getCoord3()));
    }
    return attributes;
  }

}
