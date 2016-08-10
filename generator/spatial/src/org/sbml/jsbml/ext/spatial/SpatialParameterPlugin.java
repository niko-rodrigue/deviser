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
public class SpatialParameterPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 48692696675903376L;
  /**
   *
   */
  private XMLNode spatialSymbolReference;
  /**
   *
   */
  private XMLNode advectionCoefficient;
  /**
   *
   */
  private XMLNode boundaryCondition;
  /**
   *
   */
  private XMLNode diffusionCoefficient;

  /**
   * @param model the SpatialParameterPlugin instance to copy.
   */
  public SpatialParameterPlugin(Model model) {
    super(model);

  }

  /**
   * @param spatialModel the SpatialParameterPlugin instance to copy.
   */
  public SpatialParameterPlugin(SpatialParameterPlugin spatialModel) {
    super(spatialModel);

    if (spatialModel.isSetSpatialSymbolReference()) {
      setSpatialSymbolReference(spatialModel.getSpatialSymbolReference().clone());
    }
    if (spatialModel.isSetAdvectionCoefficient()) {
      setAdvectionCoefficient(spatialModel.getAdvectionCoefficient().clone());
    }
    if (spatialModel.isSetBoundaryCondition()) {
      setBoundaryCondition(spatialModel.getBoundaryCondition().clone());
    }
    if (spatialModel.isSetDiffusionCoefficient()) {
      setDiffusionCoefficient(spatialModel.getDiffusionCoefficient().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public SpatialParameterPlugin clone() {
    return new SpatialParameterPlugin(this);
  }

  /**
   * Returns the value of {@link spatialSymbolReference}.
   *  
   * @return the value of {@link spatialSymbolReference}.
   */
  public XMLNode getSpatialSymbolReference() {
    if (isSetSpatialSymbolReference()) {
      return spatialSymbolReference;
    }
    throw new PropertyUndefinedError(SpatialConstants.spatialSymbolReference,
      this);
  }

  /**
   * Returns the value of {@link advectionCoefficient}.
   *  
   * @return the value of {@link advectionCoefficient}.
   */
  public XMLNode getAdvectionCoefficient() {
    if (isSetAdvectionCoefficient()) {
      return advectionCoefficient;
    }
    throw new PropertyUndefinedError(SpatialConstants.advectionCoefficient,
      this);
  }

  /**
   * Returns the value of {@link boundaryCondition}.
   *  
   * @return the value of {@link boundaryCondition}.
   */
  public XMLNode getBoundaryCondition() {
    if (isSetBoundaryCondition()) {
      return boundaryCondition;
    }
    throw new PropertyUndefinedError(SpatialConstants.boundaryCondition, this);
  }

  /**
   * Returns the value of {@link diffusionCoefficient}.
   *  
   * @return the value of {@link diffusionCoefficient}.
   */
  public XMLNode getDiffusionCoefficient() {
    if (isSetDiffusionCoefficient()) {
      return diffusionCoefficient;
    }
    throw new PropertyUndefinedError(SpatialConstants.diffusionCoefficient,
      this);
  }

  /**
   * Returns whether {@link spatialSymbolReference} is set.
   *  
   * @return whether {@link spatialSymbolReference} is set.
   */
  public boolean isSetSpatialSymbolReference() {
    return spatialSymbolReference != null;
  }

  /**
   * Returns whether {@link advectionCoefficient} is set.
   *  
   * @return whether {@link advectionCoefficient} is set.
   */
  public boolean isSetAdvectionCoefficient() {
    return advectionCoefficient != null;
  }

  /**
   * Returns whether {@link boundaryCondition} is set.
   *  
   * @return whether {@link boundaryCondition} is set.
   */
  public boolean isSetBoundaryCondition() {
    return boundaryCondition != null;
  }

  /**
   * Returns whether {@link diffusionCoefficient} is set.
   *  
   * @return whether {@link diffusionCoefficient} is set.
   */
  public boolean isSetDiffusionCoefficient() {
    return diffusionCoefficient != null;
  }

  /**
   * Sets the value of spatialSymbolReference
   *  
   * @param spatialSymbolReference the value of spatialSymbolReference to be
   * set.
   */
  public boolean setSpatialSymbolReference(XMLNode spatialSymbolReference) {
    if (spatialSymbolReference != this.spatialSymbolReference) {
      XMLNode oldSpatialSymbolReference = this.spatialSymbolReference;
      this.spatialSymbolReference = spatialSymbolReference;
      firePropertyChange(SpatialConstants.spatialSymbolReference,
        oldSpatialSymbolReference, this.spatialSymbolReference);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of advectionCoefficient
   *  
   * @param advectionCoefficient the value of advectionCoefficient to be set.
   */
  public boolean setAdvectionCoefficient(XMLNode advectionCoefficient) {
    if (advectionCoefficient != this.advectionCoefficient) {
      XMLNode oldAdvectionCoefficient = this.advectionCoefficient;
      this.advectionCoefficient = advectionCoefficient;
      firePropertyChange(SpatialConstants.advectionCoefficient,
        oldAdvectionCoefficient, this.advectionCoefficient);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of boundaryCondition
   *  
   * @param boundaryCondition the value of boundaryCondition to be set.
   */
  public boolean setBoundaryCondition(XMLNode boundaryCondition) {
    if (boundaryCondition != this.boundaryCondition) {
      XMLNode oldBoundaryCondition = this.boundaryCondition;
      this.boundaryCondition = boundaryCondition;
      firePropertyChange(SpatialConstants.boundaryCondition,
        oldBoundaryCondition, this.boundaryCondition);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of diffusionCoefficient
   *  
   * @param diffusionCoefficient the value of diffusionCoefficient to be set.
   */
  public boolean setDiffusionCoefficient(XMLNode diffusionCoefficient) {
    if (diffusionCoefficient != this.diffusionCoefficient) {
      XMLNode oldDiffusionCoefficient = this.diffusionCoefficient;
      this.diffusionCoefficient = diffusionCoefficient;
      firePropertyChange(SpatialConstants.diffusionCoefficient,
        oldDiffusionCoefficient, this.diffusionCoefficient);
      return true;
    }
    return false;
  }

  /**
   * Creates a new SpatialSymbolReference object, adds it to this
   * SpatialParameterPlugin object and returns the SpatialSymbolReference
   * object created.
   */
  public XMLNode createSpatialSymbolReference() {
    XMLNode spatialSymbolReference = new XMLNode(getLevel(), getVersion());
    return spatialSymbolReference;
  }

  /**
   * Creates a new AdvectionCoefficient object, adds it to this
   * SpatialParameterPlugin object and returns the AdvectionCoefficient object
   * created.
   */
  public XMLNode createAdvectionCoefficient() {
    XMLNode advectionCoefficient = new XMLNode(getLevel(), getVersion());
    return advectionCoefficient;
  }

  /**
   * Creates a new BoundaryCondition object, adds it to this
   * SpatialParameterPlugin object and returns the BoundaryCondition object
   * created.
   */
  public XMLNode createBoundaryCondition() {
    XMLNode boundaryCondition = new XMLNode(getLevel(), getVersion());
    return boundaryCondition;
  }

  /**
   * Creates a new DiffusionCoefficient object, adds it to this
   * SpatialParameterPlugin object and returns the DiffusionCoefficient object
   * created.
   */
  public XMLNode createDiffusionCoefficient() {
    XMLNode diffusionCoefficient = new XMLNode(getLevel(), getVersion());
    return diffusionCoefficient;
  }

  /**
   * Unsets the variable spatialSymbolReference.
   *  
   * @return {@code true} if spatialSymbolReference was set before, otherwise
   * {@code false}.
   */
  public boolean unsetSpatialSymbolReference() {
    if (isSetSpatialSymbolReference()) {
      XMLNode oldSpatialSymbolReference = spatialSymbolReference;
      spatialSymbolReference = null;
      firePropertyChange(SpatialConstants.spatialSymbolReference,
        oldSpatialSymbolReference, spatialSymbolReference);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable advectionCoefficient.
   *  
   * @return {@code true} if advectionCoefficient was set before, otherwise
   * {@code false}.
   */
  public boolean unsetAdvectionCoefficient() {
    if (isSetAdvectionCoefficient()) {
      XMLNode oldAdvectionCoefficient = advectionCoefficient;
      advectionCoefficient = null;
      firePropertyChange(SpatialConstants.advectionCoefficient,
        oldAdvectionCoefficient, advectionCoefficient);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable boundaryCondition.
   *  
   * @return {@code true} if boundaryCondition was set before, otherwise {@code
   * false}.
   */
  public boolean unsetBoundaryCondition() {
    if (isSetBoundaryCondition()) {
      XMLNode oldBoundaryCondition = boundaryCondition;
      boundaryCondition = null;
      firePropertyChange(SpatialConstants.boundaryCondition,
        oldBoundaryCondition, boundaryCondition);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable diffusionCoefficient.
   *  
   * @return {@code true} if diffusionCoefficient was set before, otherwise
   * {@code false}.
   */
  public boolean unsetDiffusionCoefficient() {
    if (isSetDiffusionCoefficient()) {
      XMLNode oldDiffusionCoefficient = diffusionCoefficient;
      diffusionCoefficient = null;
      firePropertyChange(SpatialConstants.diffusionCoefficient,
        oldDiffusionCoefficient, diffusionCoefficient);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return SpatialConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return SpatialConstants.shortLabel;
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

  /* hashcode method for SpatialParameterPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 5931949;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SpatialParameterPlugin [");
    builder.append("spatialSymbolReference = ");
    builder.append(spatialSymbolReference);
    builder.append(", ");
    builder.append("advectionCoefficient = ");
    builder.append(advectionCoefficient);
    builder.append(", ");
    builder.append("boundaryCondition = ");
    builder.append(boundaryCondition);
    builder.append(", ");
    builder.append("diffusionCoefficient = ");
    builder.append(diffusionCoefficient);
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

    return attributes;
  }

}
