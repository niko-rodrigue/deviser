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
public class FluxObjective extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 58802514439760414L;
  /**
   *
   */
  private String reaction;
  /**
   *
   */
  private Double coefficient;

  /**
   *  
   */
  public FluxObjective() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public FluxObjective(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public FluxObjective(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public FluxObjective(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public FluxObjective(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the FluxObjective instance to copy.
   */
  public FluxObjective(FluxObjective orig) {
    super(orig);

    if (orig.isSetReaction()) {
      setReaction(orig.getReaction());
    }
    if (orig.isSetCoefficient()) {
      setCoefficient(orig.getCoefficient());
    }  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    reaction = null;
    coefficient = null;
  }

  /* Assignment operator for FluxObjective.
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      FluxObjective obj = (FluxObjective) object;

      equals &= obj.isSetReaction() == isSetReaction();
      if (equals && isSetReaction()) {
        equals &= (obj.getReaction() == getReaction());
      }
      equals &= obj.isSetCoefficient() == isSetCoefficient();
      if (equals && isSetCoefficient()) {
        equals &= (obj.getCoefficient() == getCoefficient());
      }
      return equals;
    }  }

  /**
   * (non-Javadoc)
   */
  public FluxObjective clone() {
    return new FluxObjective(this);
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
   * @return the coefficient
   */
  public double getCoefficient() {
    if (isSetCoefficient()) {
      return coefficient.doubleValue();
    }
    throw new PropertyUndefinedError(FbcConstants.coefficient, this);
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
  public boolean isSetCoefficient() {
    return coefficient != null;
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
   * @param coefficient
   */
  public void setCoefficient(double coefficient) {
    Double oldCoefficient = this.coefficient;
    this.coefficient = coefficient;
    firePropertyChange(FbcConstants.coefficient, oldCoefficient,
      this.coefficient);
  }

  /**
   * @return {@code true} if the unset of the reaction attribute was successful
   */
  public boolean unsetReaction() {
    return setReaction((String) null);
  }

  /**
   * @return {@code true} if the unset of the coefficient attribute was
   * successful
   */
  public boolean unsetCoefficient() {
    if (isSetCoefficient()) {
      Double oldCoefficient = coefficient;
      coefficient = null;
      firePropertyChange(FbcConstants.coefficient, oldCoefficient,
        coefficient);
      return true;
    } else {
      return false;
    }
  }

  /**
   * @return false
   */
  public boolean isCoefficientMandatory() {
    return false;
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
  public boolean isReactionMandatory() {
    return true;
  }

  /* hashcode method for FluxObjective.
   */
  @Override
  public int hashCode() {
    final int prime = 9933659;

    int hashCode = super.hashCode();

    if (isSetReaction()) {
      hashCode += prime * getReaction().hashCode();
    }
    if (isSetCoefficient()) {
      hashCode += prime;
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "FluxObjective [reaction = " + reaction + ", coefficient = " +
      coefficient + ", id = " + getId() + ", name = " + getName() + "]";
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
      }      else if (attributeName.equals(FbcConstants.coefficient)) {
        setCoefficient(StringTools.parseSBMLDouble(value));
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
    if (isSetCoefficient()) {
      hashCode += prime;
    }
    return attributes;
  }

}
