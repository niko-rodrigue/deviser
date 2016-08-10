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
public class SampledVolume {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 26160166477975607L;
  /**
   *
   */
  private String domainType;
  /**
   *
   */
  private Double sampledValue;
  /**
   *
   */
  private Double minValue;
  /**
   *
   */
  private Double maxValue;

  /**
   *  
   */
  public SampledVolume() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public SampledVolume(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public SampledVolume(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public SampledVolume(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public SampledVolume(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the SampledVolume instance to copy.
   */
  public SampledVolume(SampledVolume orig) {
    super(orig);

    if (orig.isSetDomainType()) {
      setDomainType(orig.getDomainType());
    }
    if (orig.isSetSampledValue()) {
      setSampledValue(orig.getSampledValue());
    }
    if (orig.isSetMinValue()) {
      setMinValue(orig.getMinValue());
    }
    if (orig.isSetMaxValue()) {
      setMaxValue(orig.getMaxValue());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    domainType = null;
    sampledValue = null;
    minValue = null;
    maxValue = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      SampledVolume obj = (SampledVolume) object;

      equals &= obj.isSetDomainType() == isSetDomainType();
      if (equals && isSetDomainType()) {
        equals &= (obj.getDomainType() == getDomainType());
      }
      equals &= obj.isSetSampledValue() == isSetSampledValue();
      if (equals && isSetSampledValue()) {
        equals &= (obj.getSampledValue() == getSampledValue());
      }
      equals &= obj.isSetMinValue() == isSetMinValue();
      if (equals && isSetMinValue()) {
        equals &= (obj.getMinValue() == getMinValue());
      }
      equals &= obj.isSetMaxValue() == isSetMaxValue();
      if (equals && isSetMaxValue()) {
        equals &= (obj.getMaxValue() == getMaxValue());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public SampledVolume clone() {
    return new SampledVolume(this);
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
   * Returns the value of {@link sampledValue}.
   *  
   * @return the value of {@link sampledValue}.
   */
  public double getSampledValue() {
    if (isSetSampledValue()) {
      return sampledValue.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.sampledValue, this);
  }

  /**
   * Returns the value of {@link minValue}.
   *  
   * @return the value of {@link minValue}.
   */
  public double getMinValue() {
    if (isSetMinValue()) {
      return minValue.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.minValue, this);
  }

  /**
   * Returns the value of {@link maxValue}.
   *  
   * @return the value of {@link maxValue}.
   */
  public double getMaxValue() {
    if (isSetMaxValue()) {
      return maxValue.doubleValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.maxValue, this);
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
   * Returns whether {@link sampledValue} is set.
   *  
   * @return whether {@link sampledValue} is set.
   */
  public boolean isSetSampledValue() {
    return this.sampledValue != null;
  }

  /**
   * Returns whether {@link minValue} is set.
   *  
   * @return whether {@link minValue} is set.
   */
  public boolean isSetMinValue() {
    return this.minValue != null;
  }

  /**
   * Returns whether {@link maxValue} is set.
   *  
   * @return whether {@link maxValue} is set.
   */
  public boolean isSetMaxValue() {
    return this.maxValue != null;
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
   * Sets the value of sampledValue
   *  
   * @param sampledValue the value of sampledValue to be set.
   */
  public boolean setSampledValue(double sampledValue) {
    if (sampledValue != this.sampledValue) {
      Double oldSampledValue = this.sampledValue;
      this.sampledValue = sampledValue;
      firePropertyChange(SpatialConstants.sampledValue, oldSampledValue,
        this.sampledValue);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of minValue
   *  
   * @param minValue the value of minValue to be set.
   */
  public boolean setMinValue(double minValue) {
    if (minValue != this.minValue) {
      Double oldMinValue = this.minValue;
      this.minValue = minValue;
      firePropertyChange(SpatialConstants.minValue, oldMinValue,
        this.minValue);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of maxValue
   *  
   * @param maxValue the value of maxValue to be set.
   */
  public boolean setMaxValue(double maxValue) {
    if (maxValue != this.maxValue) {
      Double oldMaxValue = this.maxValue;
      this.maxValue = maxValue;
      firePropertyChange(SpatialConstants.maxValue, oldMaxValue,
        this.maxValue);
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
   * Unsets the variable sampledValue.
   *  
   * @return {@code true} if sampledValue was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSampledValue() {
    if (isSetSampledValue()) {
      Double oldSampledValue = sampledValue;
      sampledValue = null;
      firePropertyChange(SpatialConstants.sampledValue, oldSampledValue,
        sampledValue);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable minValue.
   *  
   * @return {@code true} if minValue was set before, otherwise {@code false}.
   */
  public boolean unsetMinValue() {
    if (isSetMinValue()) {
      Double oldMinValue = minValue;
      minValue = null;
      firePropertyChange(SpatialConstants.minValue, oldMinValue, minValue);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable maxValue.
   *  
   * @return {@code true} if maxValue was set before, otherwise {@code false}.
   */
  public boolean unsetMaxValue() {
    if (isSetMaxValue()) {
      Double oldMaxValue = maxValue;
      maxValue = null;
      firePropertyChange(SpatialConstants.maxValue, oldMaxValue, maxValue);
      return true;
    }
    return false;
  }

  /* hashcode method for SampledVolume.
   */
  @Override
  public int hashCode() {
    final int prime = 779531;

    int hashCode = super.hashCode();

    if (isSetDomainType()) {
      hashCode += prime * getDomainType().hashCode();
    }
    if (isSetSampledValue()) {
      hashCode += prime * getSampledValue();
    }
    if (isSetMinValue()) {
      hashCode += prime * getMinValue();
    }
    if (isSetMaxValue()) {
      hashCode += prime * getMaxValue();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SampledVolume [");
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
      }      else if (attributeName.equals(SpatialConstants.sampledValue)) {
        setSampledValue(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.minValue)) {
        setMinValue(StringTools.parseSBMLDouble(value));
      }      else if (attributeName.equals(SpatialConstants.maxValue)) {
        setMaxValue(StringTools.parseSBMLDouble(value));
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
    if (isSetSampledValue()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.sampledValue,
        StringTools.toString(Locale.ENGLISH, getSampledValue()));
    }
    if (isSetMinValue()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.minValue,
        StringTools.toString(Locale.ENGLISH, getMinValue()));
    }
    if (isSetMaxValue()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.maxValue,
        StringTools.toString(Locale.ENGLISH, getMaxValue()));
    }
    return attributes;
  }

}
