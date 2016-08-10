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
public class CompartmentMapping {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 10634900229803997L;
  /**
   *
   */
  private String domainType;
  /**
   *
   */
  private Double unitSize;

  /**
   *  
   */
  public CompartmentMapping() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CompartmentMapping(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CompartmentMapping(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CompartmentMapping(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CompartmentMapping(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CompartmentMapping instance to copy.
   */
  public CompartmentMapping(CompartmentMapping orig) {
    super(orig);

    if (orig.isSetDomainType()) {
      setDomainType(orig.getDomainType());
    }
    if (orig.isSetUnitSize()) {
      setUnitSize(orig.getUnitSize());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    domainType = null;
    unitSize = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CompartmentMapping obj = (CompartmentMapping) object;

      equals &= obj.isSetDomainType() == isSetDomainType();
      if (equals && isSetDomainType()) {
        equals &= (obj.getDomainType() == getDomainType());
      }
      equals &= obj.isSetUnitSize() == isSetUnitSize();
      if (equals && isSetUnitSize()) {
        equals &= (obj.getUnitSize() == getUnitSize());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CompartmentMapping clone() {
    return new CompartmentMapping(this);
  }

  /**
   * Returns the value of {@link domainType}.
   *  
   * @return the value of {@link domainType}.
   */
  public String getDomainType() {
    return isSetDomainType() ? domainType : "";
  }

  /**
   * Returns the value of {@link unitSize}.
   *  
   * @return the value of {@link unitSize}.
   */
  public double getUnitSize() {
    if (isSetUnitSize()) {
      return unitSize.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.unitSize, this);
  }

  /**
   * Returns whether {@link domainType} is set.
   *  
   * @return whether {@link domainType} is set.
   */
  public boolean isSetDomainType() {
    return this.domainType != null;
  }

  /**
   * Returns whether {@link unitSize} is set.
   *  
   * @return whether {@link unitSize} is set.
   */
  public boolean isSetUnitSize() {
    return this.unitSize != null;
  }

  /**
   * Sets the value of domainType
   *  
   * @param domainType the value of domainType to be set.
   */
  public boolean setDomainType(String domainType) {
    if (domainType != this.domainType) {
      String oldDomainType = this.domainType;
      this.domainType = domainType;
      firePropertyChange(SpatialConstants.domainType, oldDomainType,
        this.domainType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of unitSize
   *  
   * @param unitSize the value of unitSize to be set.
   */
  public boolean setUnitSize(double unitSize) {
    if (unitSize != this.unitSize) {
      Double oldUnitSize = this.unitSize;
      this.unitSize = unitSize;
      firePropertyChange(SpatialConstants.unitSize, oldUnitSize,
        this.unitSize);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable domainType.
   *  
   * @return {@code true} if domainType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetDomainType() {
    if (isSetDomainType()) {
      String oldDomainType = domainType;
      domainType = null;
      firePropertyChange(SpatialConstants.domainType, oldDomainType,
        domainType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable unitSize.
   *  
   * @return {@code true} if unitSize was set before, otherwise {@code false}.
   */
  public boolean unsetUnitSize() {
    if (isSetUnitSize()) {
      Double oldUnitSize = unitSize;
      unitSize = null;
      firePropertyChange(SpatialConstants.unitSize, oldUnitSize, unitSize);
      return true;
    }
    return false;
  }

  /* hashcode method for CompartmentMapping.
   */
  @Override
  public int hashCode() {
    final int prime = 5698523;

    int hashCode = super.hashCode();

    if (isSetDomainType()) {
      hashCode += prime * getDomainType().hashCode();
    }
    if (isSetUnitSize()) {
      hashCode += prime * getUnitSize();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CompartmentMapping [");
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

      if (attributeName.equals(SpatialConstants.domainType)) {
        setDomainType(value);
      }      else if (attributeName.equals(SpatialConstants.unitSize)) {
        setUnitSize(StringTools.parseSBMLDouble(value));
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
    if (isSetDomainType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domainType,
        getDomainType());
    }
    if (isSetUnitSize()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.unitSize,
        StringTools.toString(Locale.ENGLISH, getUnitSize()));
    }
    return attributes;
  }

}
