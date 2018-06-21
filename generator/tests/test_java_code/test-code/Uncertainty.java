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
public class Uncertainty extends AbstractNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 9891207272440019L;
  /**
   *
   */
  private XMLNode uncertML;

  /**
   *  
   */
  public Uncertainty() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Uncertainty(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the Uncertainty instance to copy.
   */
  public Uncertainty(Uncertainty orig) {
    super(orig);

    if (orig.isSetUncertML()) {
      setUncertML(orig.getUncertML().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = DistribConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Uncertainty obj = (Uncertainty) object;

      equals &= obj.isSetUncertML() == isSetUncertML();
      if (equals && isSetUncertML()) {
        equals &= (obj.getUncertML() == getUncertML());
      }
    }
    return equals;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.AbstractSBase#clone()
   */
  @Override
  public Uncertainty clone() {
    return new Uncertainty(this);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return false;
  }

  /**
   * @return true
   */
  public boolean isUncertMLMandatory() {
    return true;
  }

  /**
   * Returns the value of {@link uncertML}.
   *  
   * @return the value of {@link uncertML}.
   */
  public XMLNode getUncertML() {
    if (isSetUncertML()) {
      return uncertML;
    }
    throw new PropertyUndefinedError(DistribConstants.uncertML, this);
  }

  /**
   * Returns whether {@link uncertML} is set.
   *  
   * @return whether {@link uncertML} is set.
   */
  public boolean isSetUncertML() {
    return uncertML != null;
  }

  /**
   * Sets the value of uncertML
   *  
   * @param uncertML the value of uncertML to be set.
   */
  public boolean setUncertML(XMLNode uncertML) {
    if (uncertML != this.uncertML) {
      XMLNode oldUncertML = this.uncertML;
      this.uncertML = uncertML;
      firePropertyChange(DistribConstants.uncertML, oldUncertML, this.uncertML);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable uncertML.
   *  
   * @return {@code true} if uncertML was set before, otherwise {@code false}.
   */
  public boolean unsetUncertML() {
    if (isSetUncertML()) {
      XMLNode oldUncertML = uncertML;
      uncertML = null;
      firePropertyChange(DistribConstants.uncertML, oldUncertML, uncertML);
      return true;
    }
    return false;
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
    builder.append("Uncertainty [");
    builder.append("uncertML = ");
    builder.append(uncertML);
    builder.append("]");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.element.SBase#readAttribute(String attributeName, String prefix, String value)
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.element.SBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(DistribConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(DistribConstants.shortLabel + ":name", getName());
    }
    return attributes;
  }

}
