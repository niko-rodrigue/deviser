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
import java.util.TreeMap;
import javax.swing.tree.TreeNode;
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
public class DistribSBasePlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 9891207272440019L;
  /**
   *
   */
  private Uncertainty uncertainty;

  /**
   * @param sBase the DistribSBasePlugin instance to copy.
   */
  public DistribSBasePlugin(SBase sBase) {
    super(sBase);

  }

  /**
   * @param distribSBase the DistribSBasePlugin instance to copy.
   */
  public DistribSBasePlugin(DistribSBasePlugin distribSBase) {
    super(distribSBase);

    if (distribSBase.isSetUncertainty()) {
      setUncertainty(distribSBase.getUncertainty());
    }
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.AbstractSBasePlugin#clone()
   */
  @Override
  public DistribSBasePlugin clone() {
    return new DistribSBasePlugin(this);
  }

  /**
   * Returns the value of {@link uncertainty}.
   *  
   * @return the value of {@link uncertainty}.
   */
  public Uncertainty getUncertainty() {
    if (isSetUncertainty()) {
      return uncertainty;
    }
    throw new PropertyUndefinedError(DistribConstants.uncertainty, this);
  }

  /**
   * Returns whether {@link uncertainty} is set.
   *  
   * @return whether {@link uncertainty} is set.
   */
  public boolean isSetUncertainty() {
    return uncertainty != null;
  }

  /**
   * Sets the value of uncertainty
   *  
   * @param uncertainty the value of uncertainty to be set.
   */
  public boolean setUncertainty(Uncertainty uncertainty) {
    if (uncertainty != this.uncertainty) {
      Uncertainty oldUncertainty = this.uncertainty;
      this.uncertainty = uncertainty;
      firePropertyChange(DistribConstants.uncertainty, oldUncertainty, this.uncertainty);
      return true;
    }
    return false;
  }

  /**
   * Creates a new Uncertainty object, adds it to this DistribSBasePlugin
   * object and returns the Uncertainty object created.
   */
  public Uncertainty createUncertainty() {
    Uncertainty uncertainty = new Uncertainty(getLevel(), getVersion());
    return uncertainty;
  }

  /**
   * Unsets the variable uncertainty.
   *  
   * @return {@code true} if uncertainty was set before, otherwise {@code
   * false}.
   */
  public boolean unsetUncertainty() {
    if (isSetUncertainty()) {
      Uncertainty oldUncertainty = uncertainty;
      uncertainty = null;
      firePropertyChange(DistribConstants.uncertainty, oldUncertainty,
        uncertainty);
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
    if (index < 0) {
      throw new
        IndexOutOfBoundsException(MessageFormat.format(resourceBundle.getString("IndexSurpassesBoundsException"),
          index, 0));
    }
    int pos = 0;

    throw new IndexOutOfBoundsException(MessageFormat.format(
      resourceBundle.getString("IndexExceedsBoundsException"), index,
        Math.min(pos, 0)));
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

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 5861929;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DistribSBasePlugin [");
    builder.append("uncertainty = ");
    builder.append(uncertainty);
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.element.SBase#readAttribute(String attributeName, String prefix, String value)
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = false;

    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.element.SBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    return attributes;
  }

}
