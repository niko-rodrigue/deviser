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

import org.sbml.jsbml.ext.AbstractSBasePlugin;
import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class FbcSpeciesPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 15358292317460986L;
  /**
   *
   */
  private Integer charge;
  /**
   *
   */
  private String chemicalFormula;

  /**
   * @param model the FbcSpeciesPlugin instance to copy.
   */
  public FbcSpeciesPlugin(Model model) {
    super(model);

  }

  /**
   * @param fbcModel the FbcSpeciesPlugin instance to copy.
   */
  public FbcSpeciesPlugin(FbcSpeciesPlugin fbcModel) {
    super(fbcModel);

    if (fbcModel.isSetCharge()) {
      setCharge(fbcModel.getCharge());
    }
    if (fbcModel.isSetChemicalFormula()) {
      setChemicalFormula(fbcModel.getChemicalFormula());
    }
  }

  /**
   * (non-Javadoc)
   */
  public FbcSpeciesPlugin clone() {
    return new FbcSpeciesPlugin(this);
  }

  /**
   * Returns the value of {@link charge}.
   *  
   * @return the value of {@link charge}.
   */
  public int getCharge() {
    if (isSetCharge()) {
      return charge.intValue();
    }
    throw new PropertyUndefinedError(FbcConstants.charge, this);
  }

  /**
   * Returns the value of {@link chemicalFormula}.
   *  
   * @return the value of {@link chemicalFormula}.
   */
  public String getChemicalFormula() {
    return isSetChemicalFormula() ? chemicalFormula : "";
  }

  /**
   * Returns whether {@link charge} is set.
   *  
   * @return whether {@link charge} is set.
   */
  public boolean isSetCharge() {
    return this.charge != null;
  }

  /**
   * Returns whether {@link chemicalFormula} is set.
   *  
   * @return whether {@link chemicalFormula} is set.
   */
  public boolean isSetChemicalFormula() {
    return this.chemicalFormula != null;
  }

  /**
   * Sets the value of charge
   *  
   * @param charge the value of charge to be set.
   */
  public boolean setCharge(int charge) {
    if (charge != this.charge) {
      Integer oldCharge = this.charge;
      this.charge = charge;
      firePropertyChange(FbcConstants.charge, oldCharge, this.charge);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of chemicalFormula
   *  
   * @param chemicalFormula the value of chemicalFormula to be set.
   */
  public boolean setChemicalFormula(String chemicalFormula) {
    if (chemicalFormula != this.chemicalFormula) {
      String oldChemicalFormula = this.chemicalFormula;
      this.chemicalFormula = chemicalFormula;
      firePropertyChange(FbcConstants.chemicalFormula, oldChemicalFormula,
        this.chemicalFormula);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable charge.
   *  
   * @return {@code true} if charge was set before, otherwise {@code false}.
   */
  public boolean unsetCharge() {
    if (isSetCharge()) {
      Integer oldCharge = charge;
      charge = null;
      firePropertyChange(FbcConstants.charge, oldCharge, charge);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable chemicalFormula.
   *  
   * @return {@code true} if chemicalFormula was set before, otherwise {@code
   * false}.
   */
  public boolean unsetChemicalFormula() {
    if (isSetChemicalFormula()) {
      String oldChemicalFormula = chemicalFormula;
      chemicalFormula = null;
      firePropertyChange(FbcConstants.chemicalFormula, oldChemicalFormula,
        chemicalFormula);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return FbcConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return FbcConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getURI()
   */
  @Override
  public String getURI() {
    return getElementNamespace();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getParent()
   */
  @Override
  public SBMLDocument getParent() {
    if (isSetExtendedSBase()) {
      return (SBMLDocument) getExtendedSBase().getParent();
    }
    return null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getParentSBMLObject()
   */
  @Override
  public SBMLDocument getParentSBMLObject() {
    return getParent();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#getChildAt(int)
   */
  @Override
  public TreeNode getChildAt(int index) {
    return null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#getChildAt(int)
   */
  @Override
  public boolean getAllowsChildren() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#getChildAt(int)
   */
  @Override
  public int getChildCount() {
    return 0;
  }

  /* hashcode method for FbcSpeciesPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 2923499;

    int hashCode = super.hashCode();

    if (isSetCharge()) {
      hashCode += prime;
    }
    if (isSetChemicalFormula()) {
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
    builder.append("FbcSpeciesPlugin [");
    builder.append("charge = ");
    builder.append(charge);
    builder.append(", ");
    builder.append("chemicalFormula = ");
    builder.append(chemicalFormula);
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = false;

    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    if (isSetCharge()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.charge,
        Integer.toString(getCharge()));
    }
    if (isSetChemicalFormula()) {
      attributes.remove("chemicalFormula");
      attributes.put(FbcConstants.shortLabel + ":chemicalFormula", getChemicalFormula());
    }
    return attributes;
  }

}
