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
package org.sbml.jsbml.ext.fbc;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class FluxBound extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 33493007498532203L;
  /**
   *
   */
  private String reaction;
  /**
   *
   */
  private FbcOperation operation;
  /**
   *
   */
  private Double value;

  /**
   *  
   */
  public FluxBound() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public FluxBound(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public FluxBound(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public FluxBound(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public FluxBound(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the FluxBound instance to copy.
   */
  public FluxBound(FluxBound orig) {
    super(orig);

    if (orig.isSetReaction()) {
      setReaction(orig.getReaction());
    }
    if (orig.isSetOperation()) {
      setOperation(orig.getOperation());
    }
    if (orig.isSetValue()) {
      setValue(orig.getValue());
    }  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    reaction = null;
    operation = null;
    value = null;
  }

  /* Assignment operator for FluxBound.
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      FluxBound obj = (FluxBound) object;

      equals &= obj.isSetReaction() == isSetReaction();
      if (equals && isSetReaction()) {
        equals &= (obj.getReaction() == getReaction());
      }
      equals &= obj.isSetOperation() == isSetOperation();
      if (equals && isSetOperation()) {
        equals &= (obj.getOperation() == getOperation());
      }
      equals &= obj.isSetValue() == isSetValue();
      if (equals && isSetValue()) {
        equals &= (obj.getValue() == getValue());
      }
      return equals;
    }  }

  /**
   * (non-Javadoc)
   */
  public FluxBound clone() {
    return new FluxBound(this);
  }

  /**
   * @return the reaction
   */
  public String getReaction() {
    return isSetReaction() ? reaction : "";
  }

  /**
   * @return the reaction
   */
  public Reaction getReactionInstance() {
    if (isSetReaction()) {
      Model model = getModel();
      if (model != null) {
        return model.getReaction(getReaction());
      }
    }
    return null;
  }

  /**
   * @return the operation
   */
  public FbcOperation getOperation() {
    if (isSetOperation()) {
      return operation;
    }
    throw new PropertyUndefinedError(FbcConstants.operation, this);
  }

  /**
   * @return the value
   */
  public double getValue() {
    if (isSetValue()) {
      return value.doubleValue();
    }
    throw new PropertyUndefinedError(FbcConstants.value, this);
  }

  /**
   * @return 
   */
  public boolean isSetReaction() {
    return reaction != null;
  }

  /**
   * @return 
   */
  public boolean isSetReactionInstance() {
    return getReactionInstance() != null;
  }

  /**
   * @return 
   */
  public boolean isSetOperation() {
    return (operation != FBC_OPERATION_INVALID);
  }

  /**
   * @return 
   */
  public boolean isSetValue() {
    return value != null;
  }

  /**
   * @param reaction
   */
  public boolean setReaction(String reaction) {
    if (reaction != this.reaction) {
      String oldReaction = this.reaction;
      if ((reaction == null) || (reaction.isEmpty())) {
        this.reaction = null;
      } else {
        this.reaction = reaction;
      }

      firePropertyChange(FbcConstants.reaction, oldReaction, this.reaction);
      return true;
    }
    return false;
  }

  /**
   * @param operation
   */
  public void setOperation(FbcOperation operation) {
    if (FbcOperation_isValid(operation) == 0) {
      operation = FBC_OPERATION_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      operation = operation;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * @param value
   */
  public void setValue(double value) {
    Double oldValue = this.value;
    this.value = value;
    firePropertyChange(FbcConstants.value, oldValue, this.value);
  }

  /**
   * @return {@code true} if the unset of the reaction attribute was successful
   */
  public boolean unsetReaction() {
    return setReaction((String) null);
  }

  /**
   * @return {@code true} if the unset of the operation attribute was
   * successful
   */
  public boolean unsetOperation() {
    operation = FBC_OPERATION_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /**
   * @return {@code true} if the unset of the value attribute was successful
   */
  public boolean unsetValue() {
    if (isSetValue()) {
      Double oldValue = value;
      value = null;
      firePropertyChange(FbcConstants.value, oldValue, value);
      return true;
    } else {
      return false;
    }
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.Reaction#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return false;
  }

  /**
   * @return true
   */
  public boolean isOperationMandatory() {
    return true;
  }

  /**
   * @return true
   */
  public boolean isReactionMandatory() {
    return true;
  }

  /**
   * @return false
   */
  public boolean isValueMandatory() {
    return false;
  }

  /* hashcode method for FluxBound.
   */
  @Override
  public int hashCode() {
    final int prime = 1368659;

    int hashCode = super.hashCode();

    if (isSetReaction()) {
      hashCode += prime * getReaction().hashCode();
    }
    if (isSetOperation()) {
      hashCode += prime;
    }
    if (isSetValue()) {
      hashCode += prime;
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "FluxBound [reaction = " + reaction + ", operation = " + operation +
      ", value = " + value + ", id = " + getId() + ", name = " + getName() + "]";
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    if (!isAttributeRead) {
      isAttributeRead = true;

      if (attributeName.equals(FbcConstants.reaction)) {
        setReaction(value);
      }      else if (attributeName.equals(FbcConstants.operation)) {
        setOperation(StringTools.parseSBMLFbcOperation(value));
      }      else if (attributeName.equals(FbcConstants.value)) {
        setValue(StringTools.parseSBMLDouble(value));
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
      attributes.put(FbcConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(FbcConstants.shortLabel + ":name", getName());
    }
    if (isSetReaction()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.reaction, getReaction());
    }
    if (isSetOperation()) {
      hashCode += prime;
    }
    if (isSetValue()) {
      hashCode += prime;
    }
    return attributes;
  }

}
