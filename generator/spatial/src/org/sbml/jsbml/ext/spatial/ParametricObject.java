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
public class ParametricObject {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 13150598003068880L;
  /**
   *
   */
  private PolygonKind polygonType;
  /**
   *
   */
  private String domainType;
  /**
   *
   */
  private int pointIndex;
  /**
   *
   */
  private Integer pointIndexLength;
  /**
   *
   */
  private CompressionKind compression;
  /**
   *
   */
  private DataKind dataType;

  /**
   *  
   */
  public ParametricObject() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public ParametricObject(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public ParametricObject(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public ParametricObject(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public ParametricObject(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the ParametricObject instance to copy.
   */
  public ParametricObject(ParametricObject orig) {
    super(orig);

    if (orig.isSetPolygonType()) {
      setPolygonType(orig.getPolygonType());
    }
    if (orig.isSetDomainType()) {
      setDomainType(orig.getDomainType());
    }
    if (orig.isSetPointIndex()) {
      setPointIndex(orig.getPointIndex());
    }
    if (orig.isSetPointIndexLength()) {
      setPointIndexLength(orig.getPointIndexLength());
    }
    if (orig.isSetCompression()) {
      setCompression(orig.getCompression());
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
    polygonType = null;
    domainType = null;
    pointIndex = null;
    pointIndexLength = null;
    compression = null;
    dataType = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      ParametricObject obj = (ParametricObject) object;

      equals &= obj.isSetPolygonType() == isSetPolygonType();
      if (equals && isSetPolygonType()) {
        equals &= (obj.getPolygonType() == getPolygonType());
      }
      equals &= obj.isSetDomainType() == isSetDomainType();
      if (equals && isSetDomainType()) {
        equals &= (obj.getDomainType() == getDomainType());
      }
      equals &= obj.isSetPointIndex() == isSetPointIndex();
      if (equals && isSetPointIndex()) {
        equals &= (obj.getPointIndex() == getPointIndex());
      }
      equals &= obj.isSetPointIndexLength() == isSetPointIndexLength();
      if (equals && isSetPointIndexLength()) {
        equals &= (obj.getPointIndexLength() == getPointIndexLength());
      }
      equals &= obj.isSetCompression() == isSetCompression();
      if (equals && isSetCompression()) {
        equals &= (obj.getCompression() == getCompression());
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
  public ParametricObject clone() {
    return new ParametricObject(this);
  }

  /**
   * Returns the value of {@link polygonType}.
   *  
   * @return the value of {@link polygonType}.
   */
  public PolygonKind getPolygonType() {
    if (isSetPolygonType()) {
      return polygonType;
    }
    throw new PropertyUndefinedError(SpatialConstants.polygonType, this);
  }

  /**
   * Returns the value of {@link domainType}.
   *  
   * @return the value of {@link domainType}.
   */
  public String getDomainType() {
    return isSetDomainType() ? domainType : "";
  }

  public void getPointIndex(int outArray) {
    if (outArray == NULL || pointIndex == NULL) {
      return;
    }
    memcpy(outArray, pointIndex, sizeof(int)*pointIndexLength);
  }

  public void getPointIndex(int outArray) {
    if (outArray == NULL || pointIndex == NULL) {
      return;
    }
    memcpy(outArray, pointIndex, sizeof(int)*pointIndexLength);
  }

  /**
   * Returns the value of {@link pointIndexLength}.
   *  
   * @return the value of {@link pointIndexLength}.
   */
  public int getPointIndexLength() {
    if (isSetPointIndexLength()) {
      return pointIndexLength.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.pointIndexLength, this);
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
   * Returns whether {@link polygonType} is set.
   *  
   * @return whether {@link polygonType} is set.
   */
  public boolean isSetPolygonType() {
    return this.polygonType != null;
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
   * Returns whether {@link pointIndex} is set.
   *  
   * @return whether {@link pointIndex} is set.
   */
  public boolean isSetPointIndex() {
    return this.pointIndex != null;
  }

  /**
   * Returns whether {@link pointIndexLength} is set.
   *  
   * @return whether {@link pointIndexLength} is set.
   */
  public boolean isSetPointIndexLength() {
    return this.pointIndexLength != null;
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
   * Returns whether {@link dataType} is set.
   *  
   * @return whether {@link dataType} is set.
   */
  public boolean isSetDataType() {
    return this.dataType != null;
  }

  /**
   * Sets the value of polygonType
   *  
   * @param polygonType the value of polygonType to be set.
   */
  public boolean setPolygonType(PolygonKind polygonType) {
    if (polygonType != this.polygonType) {
      PolygonKind oldPolygonType = this.polygonType;
      this.polygonType = polygonType;
      firePropertyChange(SpatialConstants.polygonType, oldPolygonType,
        this.polygonType);
      return true;
    }
    return false;
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
   * @param inArray int array value of the "pointIndex" attribute to be set.
   * @param arrayLength int value for the length of the "pointIndex" attribute
   * to be set.
   */
  public int setPointIndex(int inArray, int arrayLength) {
    if (inArray == NULL) {
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    }
    if (pointIndex != NULL) {
      delete[] pointIndex;
    }
    pointIndex = new int[arrayLength];
    memcpy(pointIndex, inArray, sizeof(int)*arrayLength);
    mIsSetPointIndexLength = true;
    pointIndexLength = arrayLength;

    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * Sets the value of pointIndexLength
   *  
   * @param pointIndexLength the value of pointIndexLength to be set.
   */
  public boolean setPointIndexLength(int pointIndexLength) {
    if (pointIndexLength != this.pointIndexLength) {
      Integer oldPointIndexLength = this.pointIndexLength;
      this.pointIndexLength = pointIndexLength;
      firePropertyChange(SpatialConstants.pointIndexLength,
        oldPointIndexLength, this.pointIndexLength);
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
   * Unsets the variable polygonType.
   *  
   * @return {@code true} if polygonType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetPolygonType() {
    if (isSetPolygonType()) {
      PolygonKind oldPolygonType = polygonType;
      polygonType = null;
      firePropertyChange(SpatialConstants.polygonType, oldPolygonType,
        polygonType);
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
   * Unsets the variable pointIndex.
   *  
   * @return {@code true} if pointIndex was set before, otherwise {@code
   * false}.
   */
  public boolean unsetPointIndex() {
    if (pointIndex != NULL) {
      delete[] pointIndex;
    }
    pointIndex = NULL;

    return unsetPointIndexLength();
  }

  /**
   * Unsets the variable pointIndexLength.
   *  
   * @return {@code true} if pointIndexLength was set before, otherwise {@code
   * false}.
   */
  public boolean unsetPointIndexLength() {
    if (isSetPointIndexLength()) {
      Integer oldPointIndexLength = pointIndexLength;
      pointIndexLength = null;
      firePropertyChange(SpatialConstants.pointIndexLength,
        oldPointIndexLength, pointIndexLength);
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

  /* hashcode method for ParametricObject.
   */
  @Override
  public int hashCode() {
    final int prime = 3461099;

    int hashCode = super.hashCode();

    if (isSetPolygonType()) {
      hashCode += prime * getPolygonType().hashCode();
    }
    if (isSetDomainType()) {
      hashCode += prime * getDomainType().hashCode();
    }
    if (isSetPointIndex()) {
      hashCode += prime;
    }
    if (isSetPointIndexLength()) {
      hashCode += prime;
    }
    if (isSetCompression()) {
      hashCode += prime * getCompression().hashCode();
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
    builder.append("ParametricObject [");
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

      if (attributeName.equals(SpatialConstants.polygonType)) {
        try {
          setPolygonType(PolygonKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.polygonType + " on the 'ParametricObject'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.domainType)) {
        setDomainType(value);
      }      else if (attributeName.equals(SpatialConstants.pointIndex)) {
        setPointIndex(StringTools.parseSBMLint(value));
      }      else if (attributeName.equals(SpatialConstants.pointIndexLength)) {
        setPointIndexLength(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(SpatialConstants.compression)) {
        try {
          setCompression(CompressionKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.compression + " on the 'ParametricObject'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.dataType)) {
        try {
          setDataType(DataKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.dataType + " on the 'ParametricObject'
              element.");
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
    if (isSetPolygonType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.polygonType,
        getPolygonType().toString());
    }
    if (isSetDomainType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domainType,
        getDomainType());
    }
    if (isSetPointIndex()) {
      hashCode += prime;
    }
    if (isSetPointIndexLength()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.pointIndexLength, Integer.toString(getPointIndexLength()));
    }
    if (isSetCompression()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.compression,
        getCompression().toString());
    }
    if (isSetDataType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.dataType,
        getDataType().toString());
    }
    return attributes;
  }

}
