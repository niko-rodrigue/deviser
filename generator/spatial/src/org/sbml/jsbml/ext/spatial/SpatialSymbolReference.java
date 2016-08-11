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
public class SpatialSymbolReference {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 52991435384739546L;
  /**
   *
   */
  private String spatialRef;

  /**
   *  
   */
  public SpatialSymbolReference() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public SpatialSymbolReference(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public SpatialSymbolReference(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public SpatialSymbolReference(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public SpatialSymbolReference(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the SpatialSymbolReference instance to copy.
   */
  public SpatialSymbolReference(SpatialSymbolReference orig) {
    super(orig);

    if (orig.isSetSpatialRef()) {
      setSpatialRef(orig.getSpatialRef());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    spatialRef = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      SpatialSymbolReference obj = (SpatialSymbolReference) object;

      equals &= obj.isSetSpatialRef() == isSetSpatialRef();
      if (equals && isSetSpatialRef()) {
        equals &= (obj.getSpatialRef() == getSpatialRef());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public SpatialSymbolReference clone() {
    return new SpatialSymbolReference(this);
  }

  /**
   * Returns the value of {@link spatialRef}.
   *  
   * @return the value of {@link spatialRef}.
   */
  public String getSpatialRef() {
    return isSetSpatialRef() ? spatialRef : "";
  }

  /**
   * Returns whether {@link spatialRef} is set.
   *  
   * @return whether {@link spatialRef} is set.
   */
  public boolean isSetSpatialRef() {
    return this.spatialRef != null;
  }

  /**
   * Sets the value of spatialRef
   *  
   * @param spatialRef the value of spatialRef to be set.
   */
  public boolean setSpatialRef(String spatialRef) {
    if (spatialRef != this.spatialRef) {
      String oldSpatialRef = this.spatialRef;
      this.spatialRef = spatialRef;
      firePropertyChange(SpatialConstants.spatialRef, oldSpatialRef,
        this.spatialRef);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable spatialRef.
   *  
   * @return {@code true} if spatialRef was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSpatialRef() {
    if (isSetSpatialRef()) {
      String oldSpatialRef = spatialRef;
      spatialRef = null;
      firePropertyChange(SpatialConstants.spatialRef, oldSpatialRef,
        spatialRef);
      return true;
    }
    return false;
  }

  /* hashcode method for SpatialSymbolReference.
   */
  @Override
  public int hashCode() {
    final int prime = 3485633;

    int hashCode = super.hashCode();

    if (isSetSpatialRef()) {
      hashCode += prime * getSpatialRef().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SpatialSymbolReference [");
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

    if (isSetSpatialRef()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.spatialRef,
        getSpatialRef());
    }
    return attributes;
  }

}
