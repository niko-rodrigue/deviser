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
package org.sbml.jsbml.ext.dyn;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.ext.AbstractSBasePlugin;
import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;
import org.sbml.jsbml.ontology.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class DynSBasePlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 32854485373874604L;
  /**
   *
   */
  private Term cboTerm;

  /**
   * @param model the DynSBasePlugin instance to copy.
   */
  public DynSBasePlugin(Model model) {
    super(model);

  }

  /**
   * @param dynModel the DynSBasePlugin instance to copy.
   */
  public DynSBasePlugin(DynSBasePlugin dynModel) {
    super(dynModel);

    if (dynModel.isSetCboTerm()) {
      setCboTerm(dynModel.getCboTerm());
    }
  }

  /**
   * (non-Javadoc)
   */
  public DynSBasePlugin clone() {
    return new DynSBasePlugin(this);
  }

  /**
   * Returns the value of {@link cboTerm}.
   *  
   * @return the value of {@link cboTerm}.
   */
  public Term getCboTerm() {
    if (isSetCboTerm()) {
      return cboTerm;
    }
    throw new PropertyUndefinedError(DynConstants.cboTerm, this);
  }

  /**
   * Returns whether {@link cboTerm} is set.
   *  
   * @return whether {@link cboTerm} is set.
   */
  public boolean isSetCboTerm() {
    return this.cboTerm != null;
  }

  /**
   * Sets the value of cboTerm
   *  
   * @param cboTerm the value of cboTerm to be set.
   */
  public boolean setCboTerm(Term cboTerm) {
    if (isSetCboTerm()) {
      Term oldCboTerm = cboTerm;
      cboTerm = null;
      firePropertyChange(DynConstants.cboTerm, oldCboTerm, cboTerm);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable cboTerm.
   *  
   * @return {@code true} if cboTerm was set before, otherwise {@code false}.
   */
  public boolean unsetCboTerm() {
    if (isSetCboTerm()) {
      Term oldCboTerm = cboTerm;
      cboTerm = null;
      firePropertyChange(DynConstants.cboTerm, oldCboTerm, cboTerm);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return DynConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return DynConstants.shortLabel;
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

  /* hashcode method for DynSBasePlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 699649;

    int hashCode = super.hashCode();

    if (isSetCboTerm()) {
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
    builder.append("DynSBasePlugin [");
    builder.append("cboTerm = ");
    builder.append(cboTerm);
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

    if (isSetCboTerm()) {
      attributes.put(DynConstants.shortLabel + ":" + DynConstants.cboTerm,
        cboTerm.getId());
    }
    return attributes;
  }

}
