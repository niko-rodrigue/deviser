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
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.ext.AbstractSBasePlugin;
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
public class FbcReactionPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 14795673117972261L;
  /**
   *
   */
  private String lowerFluxBound;
  /**
   *
   */
  private String upperFluxBound;
  /**
   *
   */
  private XMLNode geneProductAssociation;

  /**
   * @param model the FbcReactionPlugin instance to copy.
   */
  public FbcReactionPlugin(Model model) {
    super(model);

  }

  /**
   * @param fbcModel the FbcReactionPlugin instance to copy.
   */
  public FbcReactionPlugin(FbcReactionPlugin fbcModel) {
    super(fbcModel);

    if (fbcModel.isSetLowerFluxBound()) {
      setLowerFluxBound(fbcModel.getLowerFluxBound());
    }
    if (fbcModel.isSetUpperFluxBound()) {
      setUpperFluxBound(fbcModel.getUpperFluxBound());
    }
    if (fbcModel.isSetGeneProductAssociation()) {
      setGeneProductAssociation(fbcModel.getGeneProductAssociation().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public FbcReactionPlugin clone() {
    return new FbcReactionPlugin(this);
  }

  /**
   * Returns the value of {@link lowerFluxBound}.
   *  
   * @return the value of {@link lowerFluxBound}.
   */
  public String getLowerFluxBound() {
    return isSetLowerFluxBound() ? lowerFluxBound : "";
  }

  /**
   * Returns the value of {@link upperFluxBound}.
   *  
   * @return the value of {@link upperFluxBound}.
   */
  public String getUpperFluxBound() {
    return isSetUpperFluxBound() ? upperFluxBound : "";
  }

  /**
   * Returns whether {@link lowerFluxBound} is set.
   *  
   * @return whether {@link lowerFluxBound} is set.
   */
  public boolean isSetLowerFluxBound() {
    return this.lowerFluxBound != null;
  }

  /**
   * Returns whether {@link upperFluxBound} is set.
   *  
   * @return whether {@link upperFluxBound} is set.
   */
  public boolean isSetUpperFluxBound() {
    return this.upperFluxBound != null;
  }

  /**
   * Sets the value of lowerFluxBound
   *  
   * @param lowerFluxBound the value of lowerFluxBound to be set.
   */
  public boolean setLowerFluxBound(String lowerFluxBound) {
    if (lowerFluxBound != this.lowerFluxBound) {
      String oldLowerFluxBound = this.lowerFluxBound;
      this.lowerFluxBound = lowerFluxBound;
      firePropertyChange(FbcConstants.lowerFluxBound, oldLowerFluxBound,
        this.lowerFluxBound);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of upperFluxBound
   *  
   * @param upperFluxBound the value of upperFluxBound to be set.
   */
  public boolean setUpperFluxBound(String upperFluxBound) {
    if (upperFluxBound != this.upperFluxBound) {
      String oldUpperFluxBound = this.upperFluxBound;
      this.upperFluxBound = upperFluxBound;
      firePropertyChange(FbcConstants.upperFluxBound, oldUpperFluxBound,
        this.upperFluxBound);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable lowerFluxBound.
   *  
   * @return {@code true} if lowerFluxBound was set before, otherwise {@code
   * false}.
   */
  public boolean unsetLowerFluxBound() {
    if (isSetLowerFluxBound()) {
      String oldLowerFluxBound = lowerFluxBound;
      lowerFluxBound = null;
      firePropertyChange(FbcConstants.lowerFluxBound, oldLowerFluxBound,
        lowerFluxBound);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable upperFluxBound.
   *  
   * @return {@code true} if upperFluxBound was set before, otherwise {@code
   * false}.
   */
  public boolean unsetUpperFluxBound() {
    if (isSetUpperFluxBound()) {
      String oldUpperFluxBound = upperFluxBound;
      upperFluxBound = null;
      firePropertyChange(FbcConstants.upperFluxBound, oldUpperFluxBound,
        upperFluxBound);
      return true;
    }
    return false;
  }

  /**
   * Returns the value of {@link geneProductAssociation}.
   *  
   * @return the value of {@link geneProductAssociation}.
   */
  public XMLNode getGeneProductAssociation() {
    if (isSetGeneProductAssociation()) {
      return geneProductAssociation;
    }
    throw new PropertyUndefinedError(FbcConstants.geneProductAssociation,
      this);
  }

  /**
   * Returns whether {@link geneProductAssociation} is set.
   *  
   * @return whether {@link geneProductAssociation} is set.
   */
  public boolean isSetGeneProductAssociation() {
    return geneProductAssociation != null;
  }

  /**
   * Sets the value of geneProductAssociation
   *  
   * @param geneProductAssociation the value of geneProductAssociation to be
   * set.
   */
  public boolean setGeneProductAssociation(XMLNode geneProductAssociation) {
    if (geneProductAssociation != this.geneProductAssociation) {
      XMLNode oldGeneProductAssociation = this.geneProductAssociation;
      this.geneProductAssociation = geneProductAssociation;
      firePropertyChange(FbcConstants.geneProductAssociation,
        oldGeneProductAssociation, this.geneProductAssociation);
      return true;
    }
    return false;
  }

  /**
   * Creates a new GeneProductAssociation object, adds it to this
   * FbcReactionPlugin object and returns the GeneProductAssociation object
   * created.
   */
  public XMLNode createGeneProductAssociation() {
    XMLNode geneProductAssociation = new XMLNode(getLevel(), getVersion());
    return geneProductAssociation;
  }

  /**
   * Unsets the variable geneProductAssociation.
   *  
   * @return {@code true} if geneProductAssociation was set before, otherwise
   * {@code false}.
   */
  public boolean unsetGeneProductAssociation() {
    if (isSetGeneProductAssociation()) {
      XMLNode oldGeneProductAssociation = geneProductAssociation;
      geneProductAssociation = null;
      firePropertyChange(FbcConstants.geneProductAssociation,
        oldGeneProductAssociation, geneProductAssociation);
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

  /* hashcode method for FbcReactionPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 85201;

    int hashCode = super.hashCode();

    if (isSetLowerFluxBound()) {
      hashCode += prime * getLowerFluxBound().hashCode();
    }
    if (isSetUpperFluxBound()) {
      hashCode += prime * getUpperFluxBound().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("FbcReactionPlugin [");
    builder.append("lowerFluxBound = ");
    builder.append(lowerFluxBound);
    builder.append(", ");
    builder.append("upperFluxBound = ");
    builder.append(upperFluxBound);
    builder.append(", ");
    builder.append("geneProductAssociation = ");
    builder.append(geneProductAssociation);
    builder.append("]");
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

    if (isSetLowerFluxBound()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.lowerFluxBound,
        getLowerFluxBound());
    }
    if (isSetUpperFluxBound()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.upperFluxBound,
        getUpperFluxBound());
    }
    return attributes;
  }

}
