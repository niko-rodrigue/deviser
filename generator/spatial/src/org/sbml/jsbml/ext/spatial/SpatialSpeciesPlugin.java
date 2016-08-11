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
public class SpatialSpeciesPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 22294302725086819L;
  /**
   *
   */
  private Boolean isSpatial;

  /**
   * @param model the SpatialSpeciesPlugin instance to copy.
   */
  public SpatialSpeciesPlugin(Model model) {
    super(model);

  }

  /**
   * @param spatialModel the SpatialSpeciesPlugin instance to copy.
   */
  public SpatialSpeciesPlugin(SpatialSpeciesPlugin spatialModel) {
    super(spatialModel);

    if (spatialModel.isSetIsSpatial()) {
      setIsSpatial(spatialModel.getIsSpatial());
    }
  }

  /**
   * (non-Javadoc)
   */
  public SpatialSpeciesPlugin clone() {
    return new SpatialSpeciesPlugin(this);
  }

  /**
   * Returns the value of {@link isSpatial}.
   *  
   * @return the value of {@link isSpatial}.
   */
  public boolean getIsSpatial() {
    if (isSetIsSpatial()) {
      return isSpatial.booleanValue();
    }
    throw new PropertyUndefinedError(SpatialConstants.isSpatial, this);
  }

  /**
   * Returns whether {@link isSpatial} is set.
   *  
   * @return whether {@link isSpatial} is set.
   */
  public boolean isSetIsSpatial() {
    return this.isSpatial != null;
  }

  /**
   * Sets the value of isSpatial
   *  
   * @param isSpatial the value of isSpatial to be set.
   */
  public boolean setIsSpatial(boolean isSpatial) {
    if (isSpatial != this.isSpatial) {
      Boolean oldIsSpatial = this.isSpatial;
      this.isSpatial = isSpatial;
      firePropertyChange(SpatialConstants.isSpatial, oldIsSpatial,
        this.isSpatial);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable isSpatial.
   *  
   * @return {@code true} if isSpatial was set before, otherwise {@code false}.
   */
  public boolean unsetIsSpatial() {
    if (isSetIsSpatial()) {
      Boolean oldIsSpatial = isSpatial;
      isSpatial = null;
      firePropertyChange(SpatialConstants.isSpatial, oldIsSpatial, isSpatial);
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

  /* hashcode method for SpatialSpeciesPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 7340869;

    int hashCode = super.hashCode();

    if (isSetIsSpatial()) {
      hashCode += prime + (getIsSpatial() ? 1 : -1);
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SpatialSpeciesPlugin [");
    builder.append("isSpatial = ");
    builder.append(isSpatial);
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

    if (isSetIsSpatial()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.isSpatial,
        Boolean.toString(getIsSpatial()));
    }
    return attributes;
  }

}
