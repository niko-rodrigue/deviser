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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class CSGPseudoPrimitive extends CSGNode {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 53439239126451491L;
  /**
   *
   */
  private String csgObjectRef;

  /**
   *  
   */
  public CSGPseudoPrimitive() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGPseudoPrimitive(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGPseudoPrimitive(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGPseudoPrimitive(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGPseudoPrimitive(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGPseudoPrimitive instance to copy.
   */
  public CSGPseudoPrimitive(CSGPseudoPrimitive orig) {
    super(orig);

    if (orig.isSetCsgObjectRef()) {
      setCsgObjectRef(orig.getCsgObjectRef());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    csgObjectRef = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGPseudoPrimitive obj = (CSGPseudoPrimitive) object;

      equals &= obj.isSetCsgObjectRef() == isSetCsgObjectRef();
      if (equals && isSetCsgObjectRef()) {
        equals &= (obj.getCsgObjectRef() == getCsgObjectRef());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGPseudoPrimitive clone() {
    return new CSGPseudoPrimitive(this);
  }

  /**
   * Returns the value of {@link csgObjectRef}.
   *  
   * @return the value of {@link csgObjectRef}.
   */
  public String getCsgObjectRef() {
    return isSetCsgObjectRef() ? csgObjectRef : "";
  }

  /**
   * Returns whether {@link csgObjectRef} is set.
   *  
   * @return whether {@link csgObjectRef} is set.
   */
  public boolean isSetCsgObjectRef() {
    return this.csgObjectRef != null;
  }

  /**
   * Sets the value of csgObjectRef
   *  
   * @param csgObjectRef the value of csgObjectRef to be set.
   */
  public boolean setCsgObjectRef(String csgObjectRef) {
    if (csgObjectRef != this.csgObjectRef) {
      String oldCsgObjectRef = this.csgObjectRef;
      this.csgObjectRef = csgObjectRef;
      firePropertyChange(SpatialConstants.csgObjectRef, oldCsgObjectRef,
        this.csgObjectRef);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable csgObjectRef.
   *  
   * @return {@code true} if csgObjectRef was set before, otherwise {@code
   * false}.
   */
  public boolean unsetCsgObjectRef() {
    if (isSetCsgObjectRef()) {
      String oldCsgObjectRef = csgObjectRef;
      csgObjectRef = null;
      firePropertyChange(SpatialConstants.csgObjectRef, oldCsgObjectRef,
        csgObjectRef);
      return true;
    }
    return false;
  }

  /* hashcode method for CSGPseudoPrimitive.
   */
  @Override
  public int hashCode() {
    final int prime = 1184653;

    int hashCode = super.hashCode();

    if (isSetCsgObjectRef()) {
      hashCode += prime * getCsgObjectRef().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGPseudoPrimitive [");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    if (isSetCsgObjectRef()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.csgObjectRef,
        getCsgObjectRef());
    }
    return attributes;
  }

}
