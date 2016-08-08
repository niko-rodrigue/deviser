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
public class GeneProduct extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 41456970696179482L;
  /**
   *
   */
  private String label;
  /**
   *
   */
  private String associatedSpecies;

  /**
   *  
   */
  public GeneProduct() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public GeneProduct(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public GeneProduct(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public GeneProduct(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public GeneProduct(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the GeneProduct instance to copy.
   */
  public GeneProduct(GeneProduct orig) {
    super(orig);

    if (orig.isSetLabel()) {
      setLabel(orig.getLabel());
    }
    if (orig.isSetAssociatedSpecies()) {
      setAssociatedSpecies(orig.getAssociatedSpecies());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    label = null;
    associatedSpecies = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      GeneProduct obj = (GeneProduct) object;

      equals &= obj.isSetLabel() == isSetLabel();
      if (equals && isSetLabel()) {
        equals &= (obj.getLabel() == getLabel());
      }
      equals &= obj.isSetAssociatedSpecies() == isSetAssociatedSpecies();
      if (equals && isSetAssociatedSpecies()) {
        equals &= (obj.getAssociatedSpecies() == getAssociatedSpecies());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public GeneProduct clone() {
    return new GeneProduct(this);
  }

  /**
   * Returns the value of {@link label}.
   *  
   * @return the value of {@link label}.
   */
  public String getLabel() {
    return isSetLabel() ? label : "";
  }

  /**
   * Returns the value of {@link associatedSpecies}.
   *  
   * @return the value of {@link associatedSpecies}.
   */
  public String getAssociatedSpecies() {
    return isSetAssociatedSpecies() ? associatedSpecies : "";
  }

  /**
   * Returns whether {@link label} is set.
   *  
   * @return whether {@link label} is set.
   */
  public boolean isSetLabel() {
    return this.label != null;
  }

  /**
   * Returns whether {@link associatedSpecies} is set.
   *  
   * @return whether {@link associatedSpecies} is set.
   */
  public boolean isSetAssociatedSpecies() {
    return this.associatedSpecies != null;
  }

  /**
   * Sets the value of label
   *  
   * @param label the value of label to be set.
   */
  public boolean setLabel(String label) {
    if (label != this.label) {
      String oldLabel = this.label;
      this.label = label;
      firePropertyChange(FbcConstants.label, oldLabel, this.label);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of associatedSpecies
   *  
   * @param associatedSpecies the value of associatedSpecies to be set.
   */
  public boolean setAssociatedSpecies(String associatedSpecies) {
    if (associatedSpecies != this.associatedSpecies) {
      String oldAssociatedSpecies = this.associatedSpecies;
      this.associatedSpecies = associatedSpecies;
      firePropertyChange(FbcConstants.associatedSpecies, oldAssociatedSpecies,
        this.associatedSpecies);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable label.
   *  
   * @return {@code true} if label was set before, otherwise {@code false}.
   */
  public boolean unsetLabel() {
    if (isSetLabel()) {
      String oldLabel = label;
      label = null;
      firePropertyChange(FbcConstants.label, oldLabel, label);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable associatedSpecies.
   *  
   * @return {@code true} if associatedSpecies was set before, otherwise {@code
   * false}.
   */
  public boolean unsetAssociatedSpecies() {
    if (isSetAssociatedSpecies()) {
      String oldAssociatedSpecies = associatedSpecies;
      associatedSpecies = null;
      firePropertyChange(FbcConstants.associatedSpecies, oldAssociatedSpecies,
        associatedSpecies);
      return true;
    }
    return false;
  }

  /**
   * @return false
   */
  public boolean isAssociatedSpeciesMandatory() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return true;
  }

  /**
   * @return true
   */
  public boolean isLabelMandatory() {
    return true;
  }

  /* hashcode method for GeneProduct.
   */
  @Override
  public int hashCode() {
    final int prime = 8405609;

    int hashCode = super.hashCode();

    if (isSetLabel()) {
      hashCode += prime;
    }
    if (isSetAssociatedSpecies()) {
      hashCode += prime * getAssociatedSpecies().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("GeneProduct [");
    builder.append("label = ");
    builder.append(label);
    builder.append(", ");
    builder.append("associatedSpecies = ");
    builder.append(associatedSpecies);
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

      if (attributeName.equals(FbcConstants.label)) {
        setLabel(StringTools.parseSBMLString(value));
      }      else if (attributeName.equals(FbcConstants.associatedSpecies)) {
        setAssociatedSpecies(value);
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
    if (isSetLabel()) {
      attributes.remove("label");
      attributes.put(FbcConstants.shortLabel + ":label", getLabel());
    }
    if (isSetAssociatedSpecies()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.associatedSpecies,
        getAssociatedSpecies());
    }
    return attributes;
  }

}
