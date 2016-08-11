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
public class SpatialPoints {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 27547052846438825L;
  /**
   *
   */
  private CompressionKind compression;
  /**
   *
   */
  private double arrayData;
  /**
   *
   */
  private Integer arrayDataLength;
  /**
   *
   */
  private DataKind dataType;

  /**
   *  
   */
  public SpatialPoints() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public SpatialPoints(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public SpatialPoints(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public SpatialPoints(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public SpatialPoints(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the SpatialPoints instance to copy.
   */
  public SpatialPoints(SpatialPoints orig) {
    super(orig);

    if (orig.isSetCompression()) {
      setCompression(orig.getCompression());
    }
    if (orig.isSetArrayData()) {
      setArrayData(orig.getArrayData());
    }
    if (orig.isSetArrayDataLength()) {
      setArrayDataLength(orig.getArrayDataLength());
    }
    if (orig.isSetDataType()) {
      setDataType(orig.getDataType());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    compression = null;
    arrayData = null;
    arrayDataLength = null;
    dataType = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      SpatialPoints obj = (SpatialPoints) object;

      equals &= obj.isSetCompression() == isSetCompression();
      if (equals && isSetCompression()) {
        equals &= (obj.getCompression() == getCompression());
      }
      equals &= obj.isSetArrayData() == isSetArrayData();
      if (equals && isSetArrayData()) {
        equals &= (obj.getArrayData() == getArrayData());
      }
      equals &= obj.isSetArrayDataLength() == isSetArrayDataLength();
      if (equals && isSetArrayDataLength()) {
        equals &= (obj.getArrayDataLength() == getArrayDataLength());
      }
      equals &= obj.isSetDataType() == isSetDataType();
      if (equals && isSetDataType()) {
        equals &= (obj.getDataType() == getDataType());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public SpatialPoints clone() {
    return new SpatialPoints(this);
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

  public void getArrayData(double outArray) {
    if (outArray == NULL || arrayData == NULL) {
      return;
    }
    memcpy(outArray, arrayData, sizeof(double)*arrayDataLength);
  }

  public void getArrayData(double outArray) {
    if (outArray == NULL || arrayData == NULL) {
      return;
    }
    memcpy(outArray, arrayData, sizeof(double)*arrayDataLength);
  }

  /**
   * Returns the value of {@link arrayDataLength}.
   *  
   * @return the value of {@link arrayDataLength}.
   */
  public int getArrayDataLength() {
    if (isSetArrayDataLength()) {
      return arrayDataLength.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.arrayDataLength, this);
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
   * Returns whether {@link compression} is set.
   *  
   * @return whether {@link compression} is set.
   */
  public boolean isSetCompression() {
    return this.compression != null;
  }

  /**
   * Returns whether {@link arrayData} is set.
   *  
   * @return whether {@link arrayData} is set.
   */
  public boolean isSetArrayData() {
    return this.arrayData != null;
  }

  /**
   * Returns whether {@link arrayDataLength} is set.
   *  
   * @return whether {@link arrayDataLength} is set.
   */
  public boolean isSetArrayDataLength() {
    return this.arrayDataLength != null;
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
   * @param inArray double array value of the "arrayData" attribute to be set.
   * @param arrayLength int value for the length of the "arrayData" attribute
   * to be set.
   */
  public int setArrayData(double inArray, int arrayLength) {
    if (inArray == NULL) {
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    }
    if (arrayData != NULL) {
      delete[] arrayData;
    }
    arrayData = new double[arrayLength];
    memcpy(arrayData, inArray, sizeof(double)*arrayLength);
    mIsSetArrayDataLength = true;
    arrayDataLength = arrayLength;

    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of arrayDataLength
   *  
   * @param arrayDataLength the value of arrayDataLength to be set.
   */
  public boolean setArrayDataLength(int arrayDataLength) {
    if (arrayDataLength != this.arrayDataLength) {
      Integer oldArrayDataLength = this.arrayDataLength;
      this.arrayDataLength = arrayDataLength;
      firePropertyChange(SpatialConstants.arrayDataLength, oldArrayDataLength,
        this.arrayDataLength);
      return true;
    }
    return false;
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
   * Unsets the variable arrayData.
   *  
   * @return {@code true} if arrayData was set before, otherwise {@code false}.
   */
  public boolean unsetArrayData() {
    if (arrayData != NULL) {
      delete[] arrayData;
    }
    arrayData = NULL;

    return unsetArrayDataLength();
  }

  /**
   * Unsets the variable arrayDataLength.
   *  
   * @return {@code true} if arrayDataLength was set before, otherwise {@code
   * false}.
   */
  public boolean unsetArrayDataLength() {
    if (isSetArrayDataLength()) {
      Integer oldArrayDataLength = arrayDataLength;
      arrayDataLength = null;
      firePropertyChange(SpatialConstants.arrayDataLength, oldArrayDataLength,
        arrayDataLength);
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

  /* hashcode method for SpatialPoints.
   */
  @Override
  public int hashCode() {
    final int prime = 2002459;

    int hashCode = super.hashCode();

    if (isSetCompression()) {
      hashCode += prime * getCompression().hashCode();
    }
    if (isSetArrayData()) {
      hashCode += prime;
    }
    if (isSetArrayDataLength()) {
      hashCode += prime;
    }
    if (isSetDataType()) {
      hashCode += prime * getDataType().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SpatialPoints [");
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

      if (attributeName.equals(SpatialConstants.compression)) {
        try {
          setCompression(CompressionKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.compression + " on the 'SpatialPoints'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.arrayData)) {
        setArrayData(StringTools.parseSBMLdouble(value));
      }      else if (attributeName.equals(SpatialConstants.arrayDataLength)) {
        setArrayDataLength(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(SpatialConstants.dataType)) {
        try {
          setDataType(DataKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.dataType + " on the 'SpatialPoints' element.");
        }
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
    if (isSetCompression()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.compression,
        getCompression().toString());
    }
    if (isSetArrayData()) {
      hashCode += prime;
    }
    if (isSetArrayDataLength()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.arrayDataLength,
        Integer.toString(getArrayDataLength()));
    }
    if (isSetDataType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.dataType,
        getDataType().toString());
    }
    return attributes;
  }

}
