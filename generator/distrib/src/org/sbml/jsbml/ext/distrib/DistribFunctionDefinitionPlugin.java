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
package org.sbml.jsbml.ext.distrib;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import javax.swing.tree.TreeNode;

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
public class DistribFunctionDefinitionPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 52123018533273757L;
  /**
   *
   */
  private DrawFromDistribution drawFromDistribution;

  /**
   * @param model the DistribFunctionDefinitionPlugin instance to copy.
   */
  public DistribFunctionDefinitionPlugin(Model model) {
    super(model);

  }

  /**
   * @param distribModel the DistribFunctionDefinitionPlugin instance to copy.
   */
  public DistribFunctionDefinitionPlugin(DistribFunctionDefinitionPlugin    distribModel) {
    super(distribModel);

    if (distribModel.isSetDrawFromDistribution()) {
      setDrawFromDistribution(distribModel.getDrawFromDistribution());
    }
  }

  /**
   * (non-Javadoc)
   */
  public DistribFunctionDefinitionPlugin clone() {
    return new DistribFunctionDefinitionPlugin(this);
  }

  /**
   * Returns the value of {@link drawFromDistribution}.
   *  
   * @return the value of {@link drawFromDistribution}.
   */
  public DrawFromDistribution getDrawFromDistribution() {
    if (isSetDrawFromDistribution()) {
      return drawFromDistribution;
    }
    throw new PropertyUndefinedError(DistribConstants.drawFromDistribution,
      this);
  }

  /**
   * Returns whether {@link drawFromDistribution} is set.
   *  
   * @return whether {@link drawFromDistribution} is set.
   */
  public boolean isSetDrawFromDistribution() {
    return drawFromDistribution != null;
  }

  /**
   * Sets the value of drawFromDistribution
   *  
   * @param drawFromDistribution the value of drawFromDistribution to be set.
   */
  public boolean setDrawFromDistribution(DrawFromDistribution    drawFromDistribution) {
    if (drawFromDistribution != this.drawFromDistribution) {
      DrawFromDistribution oldDrawFromDistribution = this.drawFromDistribution;
      this.drawFromDistribution = drawFromDistribution;
      firePropertyChange(DistribConstants.drawFromDistribution,
        oldDrawFromDistribution, this.drawFromDistribution);
      return true;
    }
    return false;
  }

  /**
   * Creates a new DrawFromDistribution object, adds it to this
   * DistribFunctionDefinitionPlugin object and returns the
   * DrawFromDistribution object created.
   */
  public DrawFromDistribution createDrawFromDistribution() {
    DrawFromDistribution drawFromDistribution = new
      DrawFromDistribution(getLevel(), getVersion());
    return drawFromDistribution;
  }

  /**
   * Unsets the variable drawFromDistribution.
   *  
   * @return {@code true} if drawFromDistribution was set before, otherwise
   * {@code false}.
   */
  public boolean unsetDrawFromDistribution() {
    if (isSetDrawFromDistribution()) {
      DrawFromDistribution oldDrawFromDistribution = drawFromDistribution;
      drawFromDistribution = null;
      firePropertyChange(DistribConstants.drawFromDistribution,
        oldDrawFromDistribution, drawFromDistribution);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return DistribConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return DistribConstants.shortLabel;
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

  /* hashcode method for DistribFunctionDefinitionPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 3103033;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DistribFunctionDefinitionPlugin [");
    builder.append("drawFromDistribution = ");
    builder.append(drawFromDistribution);
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
