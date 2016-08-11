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
public class SpatialCompartmentPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 42788804633639295L;
  /**
   *
   */
  private XMLNode compartmentMapping;

  /**
   * @param model the SpatialCompartmentPlugin instance to copy.
   */
  public SpatialCompartmentPlugin(Model model) {
    super(model);

  }

  /**
   * @param spatialModel the SpatialCompartmentPlugin instance to copy.
   */
  public SpatialCompartmentPlugin(SpatialCompartmentPlugin spatialModel) {
    super(spatialModel);

    if (spatialModel.isSetCompartmentMapping()) {
      setCompartmentMapping(spatialModel.getCompartmentMapping().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public SpatialCompartmentPlugin clone() {
    return new SpatialCompartmentPlugin(this);
  }

  /**
   * Returns the value of {@link compartmentMapping}.
   *  
   * @return the value of {@link compartmentMapping}.
   */
  public XMLNode getCompartmentMapping() {
    if (isSetCompartmentMapping()) {
      return compartmentMapping;
    }
    throw new PropertyUndefinedError(SpatialConstants.compartmentMapping,
      this);
  }

  /**
   * Returns whether {@link compartmentMapping} is set.
   *  
   * @return whether {@link compartmentMapping} is set.
   */
  public boolean isSetCompartmentMapping() {
    return compartmentMapping != null;
  }

  /**
   * Sets the value of compartmentMapping
   *  
   * @param compartmentMapping the value of compartmentMapping to be set.
   */
  public boolean setCompartmentMapping(XMLNode compartmentMapping) {
    if (compartmentMapping != this.compartmentMapping) {
      XMLNode oldCompartmentMapping = this.compartmentMapping;
      this.compartmentMapping = compartmentMapping;
      firePropertyChange(SpatialConstants.compartmentMapping,
        oldCompartmentMapping, this.compartmentMapping);
      return true;
    }
    return false;
  }

  /**
   * Creates a new CompartmentMapping object, adds it to this
   * SpatialCompartmentPlugin object and returns the CompartmentMapping object
   * created.
   */
  public XMLNode createCompartmentMapping() {
    XMLNode compartmentMapping = new XMLNode(getLevel(), getVersion());
    return compartmentMapping;
  }

  /**
   * Unsets the variable compartmentMapping.
   *  
   * @return {@code true} if compartmentMapping was set before, otherwise
   * {@code false}.
   */
  public boolean unsetCompartmentMapping() {
    if (isSetCompartmentMapping()) {
      XMLNode oldCompartmentMapping = compartmentMapping;
      compartmentMapping = null;
      firePropertyChange(SpatialConstants.compartmentMapping,
        oldCompartmentMapping, compartmentMapping);
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

  /* hashcode method for SpatialCompartmentPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 449959;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SpatialCompartmentPlugin [");
    builder.append("compartmentMapping = ");
    builder.append(compartmentMapping);
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
