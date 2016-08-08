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
public class SampledField {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 16335737461784003L;
  /**
   *
   */
  private DataKind dataType;
  /**
   *
   */
  private Integer numSamples1;
  /**
   *
   */
  private Integer numSamples2;
  /**
   *
   */
  private Integer numSamples3;
  /**
   *
   */
  private InterpolationKind interpolationType;
  /**
   *
   */
  private CompressionKind compression;
  /**
   *
   */
  private int samples;
  /**
   *
   */
  private Integer samplesLength;

  /**
   *  
   */
  public SampledField() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public SampledField(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public SampledField(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public SampledField(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public SampledField(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the SampledField instance to copy.
   */
  public SampledField(SampledField orig) {
    super(orig);

    if (orig.isSetDataType()) {
      setDataType(orig.getDataType());
    }
    if (orig.isSetNumSamples1()) {
      setNumSamples1(orig.getNumSamples1());
    }
    if (orig.isSetNumSamples2()) {
      setNumSamples2(orig.getNumSamples2());
    }
    if (orig.isSetNumSamples3()) {
      setNumSamples3(orig.getNumSamples3());
    }
    if (orig.isSetInterpolationType()) {
      setInterpolationType(orig.getInterpolationType());
    }
    if (orig.isSetCompression()) {
      setCompression(orig.getCompression());
    }
    if (orig.isSetSamples()) {
      setSamples(orig.getSamples());
    }
    if (orig.isSetSamplesLength()) {
      setSamplesLength(orig.getSamplesLength());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    dataType = null;
    numSamples1 = null;
    numSamples2 = null;
    numSamples3 = null;
    interpolationType = null;
    compression = null;
    samples = null;
    samplesLength = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      SampledField obj = (SampledField) object;

      equals &= obj.isSetDataType() == isSetDataType();
      if (equals && isSetDataType()) {
        equals &= (obj.getDataType() == getDataType());
      }
      equals &= obj.isSetNumSamples1() == isSetNumSamples1();
      if (equals && isSetNumSamples1()) {
        equals &= (obj.getNumSamples1() == getNumSamples1());
      }
      equals &= obj.isSetNumSamples2() == isSetNumSamples2();
      if (equals && isSetNumSamples2()) {
        equals &= (obj.getNumSamples2() == getNumSamples2());
      }
      equals &= obj.isSetNumSamples3() == isSetNumSamples3();
      if (equals && isSetNumSamples3()) {
        equals &= (obj.getNumSamples3() == getNumSamples3());
      }
      equals &= obj.isSetInterpolationType() == isSetInterpolationType();
      if (equals && isSetInterpolationType()) {
        equals &= (obj.getInterpolationType() == getInterpolationType());
      }
      equals &= obj.isSetCompression() == isSetCompression();
      if (equals && isSetCompression()) {
        equals &= (obj.getCompression() == getCompression());
      }
      equals &= obj.isSetSamples() == isSetSamples();
      if (equals && isSetSamples()) {
        equals &= (obj.getSamples() == getSamples());
      }
      equals &= obj.isSetSamplesLength() == isSetSamplesLength();
      if (equals && isSetSamplesLength()) {
        equals &= (obj.getSamplesLength() == getSamplesLength());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public SampledField clone() {
    return new SampledField(this);
  }

  /**
   * Returns the value of {@link dataType}.
   *  
   * @return the value of {@link dataType}.
   */
  public DataKind getDataType() {
    if (isSetDataType()) {
      return dataType;
    }
    throw new PropertyUndefinedError(SpatialConstants.dataType, this);
  }

  /**
   * Returns the value of {@link numSamples1}.
   *  
   * @return the value of {@link numSamples1}.
   */
  public int getNumSamples1() {
    if (isSetNumSamples1()) {
      return numSamples1.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.numSamples1, this);
  }

  /**
   * Returns the value of {@link numSamples2}.
   *  
   * @return the value of {@link numSamples2}.
   */
  public int getNumSamples2() {
    if (isSetNumSamples2()) {
      return numSamples2.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.numSamples2, this);
  }

  /**
   * Returns the value of {@link numSamples3}.
   *  
   * @return the value of {@link numSamples3}.
   */
  public int getNumSamples3() {
    if (isSetNumSamples3()) {
      return numSamples3.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.numSamples3, this);
  }

  /**
   * Returns the value of {@link interpolationType}.
   *  
   * @return the value of {@link interpolationType}.
   */
  public InterpolationKind getInterpolationType() {
    if (isSetInterpolationType()) {
      return interpolationType;
    }
    throw new PropertyUndefinedError(SpatialConstants.interpolationType, this);
  }

  /**
   * Returns the value of {@link compression}.
   *  
   * @return the value of {@link compression}.
   */
  public CompressionKind getCompression() {
    if (isSetCompression()) {
      return compression;
    }
    throw new PropertyUndefinedError(SpatialConstants.compression, this);
  }

  public void getSamples(int outArray) {
    if (outArray == NULL || samples == NULL) {
      return;
    }
    memcpy(outArray, samples, sizeof(int)*samplesLength);
  }

  public void getSamples(int outArray) {
    if (outArray == NULL || samples == NULL) {
      return;
    }
    memcpy(outArray, samples, sizeof(int)*samplesLength);
  }

  /**
   * Returns the value of {@link samplesLength}.
   *  
   * @return the value of {@link samplesLength}.
   */
  public int getSamplesLength() {
    if (isSetSamplesLength()) {
      return samplesLength.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.samplesLength, this);
  }

  /**
   * Returns whether {@link dataType} is set.
   *  
   * @return whether {@link dataType} is set.
   */
  public boolean isSetDataType() {
    return this.dataType != null;
  }

  /**
   * Returns whether {@link numSamples1} is set.
   *  
   * @return whether {@link numSamples1} is set.
   */
  public boolean isSetNumSamples1() {
    return this.numSamples1 != null;
  }

  /**
   * Returns whether {@link numSamples2} is set.
   *  
   * @return whether {@link numSamples2} is set.
   */
  public boolean isSetNumSamples2() {
    return this.numSamples2 != null;
  }

  /**
   * Returns whether {@link numSamples3} is set.
   *  
   * @return whether {@link numSamples3} is set.
   */
  public boolean isSetNumSamples3() {
    return this.numSamples3 != null;
  }

  /**
   * Returns whether {@link interpolationType} is set.
   *  
   * @return whether {@link interpolationType} is set.
   */
  public boolean isSetInterpolationType() {
    return this.interpolationType != null;
  }

  /**
   * Returns whether {@link compression} is set.
   *  
   * @return whether {@link compression} is set.
   */
  public boolean isSetCompression() {
    return this.compression != null;
  }

  /**
   * Returns whether {@link samples} is set.
   *  
   * @return whether {@link samples} is set.
   */
  public boolean isSetSamples() {
    return this.samples != null;
  }

  /**
   * Returns whether {@link samplesLength} is set.
   *  
   * @return whether {@link samplesLength} is set.
   */
  public boolean isSetSamplesLength() {
    return this.samplesLength != null;
  }

  /**
   * Sets the value of dataType
   *  
   * @param dataType the value of dataType to be set.
   */
  public boolean setDataType(DataKind dataType) {
    if (dataType != this.dataType) {
      DataKind oldDataType = this.dataType;
      this.dataType = dataType;
      firePropertyChange(SpatialConstants.dataType, oldDataType,
        this.dataType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of numSamples1
   *  
   * @param numSamples1 the value of numSamples1 to be set.
   */
  public boolean setNumSamples1(int numSamples1) {
    if (numSamples1 != this.numSamples1) {
      Integer oldNumSamples1 = this.numSamples1;
      this.numSamples1 = numSamples1;
      firePropertyChange(SpatialConstants.numSamples1, oldNumSamples1,
        this.numSamples1);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of numSamples2
   *  
   * @param numSamples2 the value of numSamples2 to be set.
   */
  public boolean setNumSamples2(int numSamples2) {
    if (numSamples2 != this.numSamples2) {
      Integer oldNumSamples2 = this.numSamples2;
      this.numSamples2 = numSamples2;
      firePropertyChange(SpatialConstants.numSamples2, oldNumSamples2,
        this.numSamples2);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of numSamples3
   *  
   * @param numSamples3 the value of numSamples3 to be set.
   */
  public boolean setNumSamples3(int numSamples3) {
    if (numSamples3 != this.numSamples3) {
      Integer oldNumSamples3 = this.numSamples3;
      this.numSamples3 = numSamples3;
      firePropertyChange(SpatialConstants.numSamples3, oldNumSamples3,
        this.numSamples3);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of interpolationType
   *  
   * @param interpolationType the value of interpolationType to be set.
   */
  public boolean setInterpolationType(InterpolationKind interpolationType) {
    if (interpolationType != this.interpolationType) {
      InterpolationKind oldInterpolationType = this.interpolationType;
      this.interpolationType = interpolationType;
      firePropertyChange(SpatialConstants.interpolationType,
        oldInterpolationType, this.interpolationType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of compression
   *  
   * @param compression the value of compression to be set.
   */
  public boolean setCompression(CompressionKind compression) {
    if (compression != this.compression) {
      CompressionKind oldCompression = this.compression;
      this.compression = compression;
      firePropertyChange(SpatialConstants.compression, oldCompression,
        this.compression);
      return true;
    }
    return false;
  }

  /**
   * @param inArray int array value of the "samples" attribute to be set.
   * @param arrayLength int value for the length of the "samples" attribute to
   * be set.
   */
  public int setSamples(int inArray, int arrayLength) {
    if (inArray == NULL) {
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    }
    if (samples != NULL) {
      delete[] samples;
    }
    samples = new int[arrayLength];
    memcpy(samples, inArray, sizeof(int)*arrayLength);
    mIsSetSamplesLength = true;
    samplesLength = arrayLength;

    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of samplesLength
   *  
   * @param samplesLength the value of samplesLength to be set.
   */
  public boolean setSamplesLength(int samplesLength) {
    if (samplesLength != this.samplesLength) {
      Integer oldSamplesLength = this.samplesLength;
      this.samplesLength = samplesLength;
      firePropertyChange(SpatialConstants.samplesLength, oldSamplesLength,
        this.samplesLength);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable dataType.
   *  
   * @return {@code true} if dataType was set before, otherwise {@code false}.
   */
  public boolean unsetDataType() {
    if (isSetDataType()) {
      DataKind oldDataType = dataType;
      dataType = null;
      firePropertyChange(SpatialConstants.dataType, oldDataType, dataType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable numSamples1.
   *  
   * @return {@code true} if numSamples1 was set before, otherwise {@code
   * false}.
   */
  public boolean unsetNumSamples1() {
    if (isSetNumSamples1()) {
      Integer oldNumSamples1 = numSamples1;
      numSamples1 = null;
      firePropertyChange(SpatialConstants.numSamples1, oldNumSamples1,
        numSamples1);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable numSamples2.
   *  
   * @return {@code true} if numSamples2 was set before, otherwise {@code
   * false}.
   */
  public boolean unsetNumSamples2() {
    if (isSetNumSamples2()) {
      Integer oldNumSamples2 = numSamples2;
      numSamples2 = null;
      firePropertyChange(SpatialConstants.numSamples2, oldNumSamples2,
        numSamples2);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable numSamples3.
   *  
   * @return {@code true} if numSamples3 was set before, otherwise {@code
   * false}.
   */
  public boolean unsetNumSamples3() {
    if (isSetNumSamples3()) {
      Integer oldNumSamples3 = numSamples3;
      numSamples3 = null;
      firePropertyChange(SpatialConstants.numSamples3, oldNumSamples3,
        numSamples3);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable interpolationType.
   *  
   * @return {@code true} if interpolationType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetInterpolationType() {
    if (isSetInterpolationType()) {
      InterpolationKind oldInterpolationType = interpolationType;
      interpolationType = null;
      firePropertyChange(SpatialConstants.interpolationType,
        oldInterpolationType, interpolationType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable compression.
   *  
   * @return {@code true} if compression was set before, otherwise {@code
   * false}.
   */
  public boolean unsetCompression() {
    if (isSetCompression()) {
      CompressionKind oldCompression = compression;
      compression = null;
      firePropertyChange(SpatialConstants.compression, oldCompression,
        compression);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable samples.
   *  
   * @return {@code true} if samples was set before, otherwise {@code false}.
   */
  public boolean unsetSamples() {
    if (samples != NULL) {
      delete[] samples;
    }
    samples = NULL;

    return unsetSamplesLength();
  }

  /**
   * Unsets the variable samplesLength.
   *  
   * @return {@code true} if samplesLength was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSamplesLength() {
    if (isSetSamplesLength()) {
      Integer oldSamplesLength = samplesLength;
      samplesLength = null;
      firePropertyChange(SpatialConstants.samplesLength, oldSamplesLength,
        samplesLength);
      return true;
    }
    return false;
  }

  /* hashcode method for SampledField.
   */
  @Override
  public int hashCode() {
    final int prime = 9541171;

    int hashCode = super.hashCode();

    if (isSetDataType()) {
      hashCode += prime * getDataType().hashCode();
    }
    if (isSetNumSamples1()) {
      hashCode += prime;
    }
    if (isSetNumSamples2()) {
      hashCode += prime;
    }
    if (isSetNumSamples3()) {
      hashCode += prime;
    }
    if (isSetInterpolationType()) {
      hashCode += prime * getInterpolationType().hashCode();
    }
    if (isSetCompression()) {
      hashCode += prime * getCompression().hashCode();
    }
    if (isSetSamples()) {
      hashCode += prime;
    }
    if (isSetSamplesLength()) {
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
    builder.append("SampledField [");
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

      if (attributeName.equals(SpatialConstants.dataType)) {
        try {
          setDataType(DataKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.dataType + " on the 'SampledField' element.");
        }
      }      else if (attributeName.equals(SpatialConstants.numSamples1)) {
        setNumSamples1(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(SpatialConstants.numSamples2)) {
        setNumSamples2(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(SpatialConstants.numSamples3)) {
        setNumSamples3(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(SpatialConstants.interpolationType)) {
        try {
          setInterpolationType(InterpolationKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.interpolationType + " on the 'SampledField'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.compression)) {
        try {
          setCompression(CompressionKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.compression + " on the 'SampledField'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.samples)) {
        setSamples(StringTools.parseSBMLint(value));
      }      else if (attributeName.equals(SpatialConstants.samplesLength)) {
        setSamplesLength(StringTools.parseSBMLInt(value));
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
    if (isSetDataType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.dataType,
        getDataType().toString());
    }
    if (isSetNumSamples1()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.numSamples1,
        Integer.toString(getNumSamples1()));
    }
    if (isSetNumSamples2()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.numSamples2,
        Integer.toString(getNumSamples2()));
    }
    if (isSetNumSamples3()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.numSamples3,
        Integer.toString(getNumSamples3()));
    }
    if (isSetInterpolationType()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.interpolationType, getInterpolationType().toString());
    }
    if (isSetCompression()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.compression,
        getCompression().toString());
    }
    if (isSetSamples()) {
      hashCode += prime;
    }
    if (isSetSamplesLength()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.samplesLength,
        Integer.toString(getSamplesLength()));
    }
    return attributes;
  }

}
