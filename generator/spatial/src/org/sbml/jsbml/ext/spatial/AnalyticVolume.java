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
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;
import org.sbml.jsbml.xml.XMLNode;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class AnalyticVolume {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 33673342796048656L;
  /**
   *
   */
  private FunctionKind functionType;
  /**
   *
   */
  private Integer ordinal;
  /**
   *
   */
  private String domainType;
  /**
   *
   */
  private ASTNode math;

  /**
   *  
   */
  public AnalyticVolume() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public AnalyticVolume(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the AnalyticVolume instance to copy.
   */
  public AnalyticVolume(AnalyticVolume orig) {
    super(orig);

    if (orig.isSetFunctionType()) {
      setFunctionType(orig.getFunctionType());
    }
    if (orig.isSetOrdinal()) {
      setOrdinal(orig.getOrdinal());
    }
    if (orig.isSetDomainType()) {
      setDomainType(orig.getDomainType());
    }
    if (orig.isSetMath()) {
      setMath(orig.getMath().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    functionType = null;
    ordinal = null;
    domainType = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      AnalyticVolume obj = (AnalyticVolume) object;

      equals &= obj.isSetFunctionType() == isSetFunctionType();
      if (equals && isSetFunctionType()) {
        equals &= (obj.getFunctionType() == getFunctionType());
      }
      equals &= obj.isSetOrdinal() == isSetOrdinal();
      if (equals && isSetOrdinal()) {
        equals &= (obj.getOrdinal() == getOrdinal());
      }
      equals &= obj.isSetDomainType() == isSetDomainType();
      if (equals && isSetDomainType()) {
        equals &= (obj.getDomainType() == getDomainType());
      }
      equals &= obj.isSetMath() == isSetMath();
      if (equals && isSetMath()) {
        equals &= (obj.getMath() == getMath());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public AnalyticVolume clone() {
    return new AnalyticVolume(this);
  }

  /**
   * Returns the value of {@link functionType}.
   *  
   * @return the value of {@link functionType}.
   */
  public FunctionKind getFunctionType() {
    if (isSetFunctionType()) {
      return functionType;
    }
    throw new PropertyUndefinedError(SpatialConstants.functionType, this);
  }

  /**
   * Returns the value of {@link ordinal}.
   *  
   * @return the value of {@link ordinal}.
   */
  public int getOrdinal() {
    if (isSetOrdinal()) {
      return ordinal.intValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.ordinal, this);
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
   * Returns whether {@link functionType} is set.
   *  
   * @return whether {@link functionType} is set.
   */
  public boolean isSetFunctionType() {
    return this.functionType != null;
  }

  /**
   * Returns whether {@link ordinal} is set.
   *  
   * @return whether {@link ordinal} is set.
   */
  public boolean isSetOrdinal() {
    return this.ordinal != null;
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
   * Sets the value of functionType
   *  
   * @param functionType the value of functionType to be set.
   */
  public boolean setFunctionType(FunctionKind functionType) {
    if (functionType != this.functionType) {
      FunctionKind oldFunctionType = this.functionType;
      this.functionType = functionType;
      firePropertyChange(SpatialConstants.functionType, oldFunctionType,
        this.functionType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of ordinal
   *  
   * @param ordinal the value of ordinal to be set.
   */
  public boolean setOrdinal(int ordinal) {
    if (ordinal != this.ordinal) {
      Integer oldOrdinal = this.ordinal;
      this.ordinal = ordinal;
      firePropertyChange(SpatialConstants.ordinal, oldOrdinal, this.ordinal);
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
   * Unsets the variable functionType.
   *  
   * @return {@code true} if functionType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetFunctionType() {
    if (isSetFunctionType()) {
      FunctionKind oldFunctionType = functionType;
      functionType = null;
      firePropertyChange(SpatialConstants.functionType, oldFunctionType,
        functionType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable ordinal.
   *  
   * @return {@code true} if ordinal was set before, otherwise {@code false}.
   */
  public boolean unsetOrdinal() {
    if (isSetOrdinal()) {
      Integer oldOrdinal = ordinal;
      ordinal = null;
      firePropertyChange(SpatialConstants.ordinal, oldOrdinal, ordinal);
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
   * Returns the value of {@link math}.
   *  
   * @return the value of {@link math}.
   */
  public ASTNode getMath() {
    return math;
  }

  /**
   * Returns whether {@link math} is set.
   *  
   * @return whether {@link math} is set.
   */
  public boolean isSetMath() {
    return math != null;
  }

  /**
   * Sets the value of math
   *  
   * @param math the value of math to be set.
   */
  public void setMath(ASTNode math) {
    ASTNode oldMath = this.math;

    this.math = math;

    if (oldMath != null) {
      oldMath.fireNodeRemovedEvent();
    }
    if (this.math != null) {
      firePropertyChange(TreeNodeChangeEvent.math, oldMath, math);
    }
  }

  /**
   * Unsets the variable math.
   *  
   * @return {@code true} if math was set before, otherwise {@code false}.
   */
  public void unsetMath() {
    setMath(null);
  }

  /* hashcode method for AnalyticVolume.
   */
  @Override
  public int hashCode() {
    final int prime = 3220319;

    int hashCode = super.hashCode();

    if (isSetFunctionType()) {
      hashCode += prime * getFunctionType().hashCode();
    }
    if (isSetOrdinal()) {
      hashCode += prime;
    }
    if (isSetDomainType()) {
      hashCode += prime * getDomainType().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AnalyticVolume [");
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

      if (attributeName.equals(SpatialConstants.functionType)) {
        try {
          setFunctionType(FunctionKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.functionType + " on the 'AnalyticVolume'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.ordinal)) {
        setOrdinal(StringTools.parseSBMLInt(value));
      }      else if (attributeName.equals(SpatialConstants.domainType)) {
        setDomainType(value);
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
    if (isSetFunctionType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.functionType,
        getFunctionType().toString());
    }
    if (isSetOrdinal()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.ordinal,
        Integer.toString(getOrdinal()));
    }
    if (isSetDomainType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domainType,
        getDomainType());
    }
    return attributes;
  }

}
