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
public class FluxBound extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 43559993923557133L;
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
    }
  }

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

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
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
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public FluxBound clone() {
    return new FluxBound(this);
  }

  /**
   * Returns the value of {@link reaction}.
   *  
   * @return the value of {@link reaction}.
   */
  public String getReaction() {
    return isSetReaction() ? reaction : "";
  }

  /**
   * Returns the value of {@link operation}.
   *  
   * @return the value of {@link operation}.
   */
  public FbcOperation getOperation() {
    if (isSetOperation()) {
      return operation;
    }
    throw new PropertyUndefinedError(FbcConstants.operation, this);
  }

  /**
   * Returns the value of {@link value}.
   *  
   * @return the value of {@link value}.
   */
  public double getValue() {
    if (isSetValue()) {
      return value.doubleValue();
    }
    throw new PropertyUndefinedError(FbcConstants.value, this);
  }

  /**
   * Returns whether {@link reaction} is set.
   *  
   * @return whether {@link reaction} is set.
   */
  public boolean isSetReaction() {
    return this.reaction != null;
  }

  /**
   * Returns whether {@link operation} is set.
   *  
   * @return whether {@link operation} is set.
   */
  public boolean isSetOperation() {
    return this.operation != null;
  }

  /**
   * Returns whether {@link value} is set.
   *  
   * @return whether {@link value} is set.
   */
  public boolean isSetValue() {
    return this.value != null;
  }

  /**
   * Sets the value of reaction
   *  
   * @param reaction the value of reaction to be set.
   */
  public boolean setReaction(String reaction) {
    if (reaction != this.reaction) {
      String oldReaction = this.reaction;
      this.reaction = reaction;
      firePropertyChange(FbcConstants.reaction, oldReaction, this.reaction);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of operation
   *  
   * @param operation the value of operation to be set.
   */
  public boolean setOperation(FbcOperation operation) {
    if (operation != this.operation) {
      FbcOperation oldOperation = this.operation;
      this.operation = operation;
      firePropertyChange(FbcConstants.operation, oldOperation, this.operation);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of value
   *  
   * @param value the value of value to be set.
   */
  public boolean setValue(double value) {
    if (value != this.value) {
      Double oldValue = this.value;
      this.value = value;
      firePropertyChange(FbcConstants.value, oldValue, this.value);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable reaction.
   *  
   * @return {@code true} if reaction was set before, otherwise {@code false}.
   */
  public boolean unsetReaction() {
    if (isSetReaction()) {
      String oldReaction = reaction;
      reaction = null;
      firePropertyChange(FbcConstants.reaction, oldReaction, reaction);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable operation.
   *  
   * @return {@code true} if operation was set before, otherwise {@code false}.
   */
  public boolean unsetOperation() {
    if (isSetOperation()) {
      FbcOperation oldOperation = operation;
      operation = null;
      firePropertyChange(FbcConstants.operation, oldOperation, operation);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable value.
   *  
   * @return {@code true} if value was set before, otherwise {@code false}.
   */
  public boolean unsetValue() {
    if (isSetValue()) {
      Double oldValue = value;
      value = null;
      firePropertyChange(FbcConstants.value, oldValue, value);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.Reaction#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return true;
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
   * @return true
   */
  public boolean isValueMandatory() {
    return true;
  }

  /* hashcode method for FluxBound.
   */
  @Override
  public int hashCode() {
    final int prime = 9005011;

    int hashCode = super.hashCode();

    if (isSetReaction()) {
      hashCode += prime * getReaction().hashCode();
    }
    if (isSetOperation()) {
      hashCode += prime * getOperation().hashCode();
    }
    if (isSetValue()) {
      hashCode += prime * getValue();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("FluxBound [");
    builder.append("reaction = ");
    builder.append(reaction);
    builder.append(", ");
    builder.append("operation = ");
    builder.append(operation);
    builder.append(", ");
    builder.append("value = ");
    builder.append(value);
    builder.append(", id = ");
    builder.append(getId());
    builder.append(", name = ");
    builder.append(getName());
    builder.append("]");
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

      if (attributeName.equals(FbcConstants.reaction)) {
        setReaction(value);
      }      else if (attributeName.equals(FbcConstants.operation)) {
        try {
          setOperation(FbcOperation.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + FbcConstants.operation + " on the 'FluxBound' element.");
        }
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
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.reaction,
        getReaction());
    }
    if (isSetOperation()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.operation,
        getOperation().toString());
    }
    if (isSetValue()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.value,
        StringTools.toString(Locale.ENGLISH, getValue()));
    }
    return attributes;
  }

}
