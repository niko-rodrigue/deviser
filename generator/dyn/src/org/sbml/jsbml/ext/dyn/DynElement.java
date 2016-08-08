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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class DynElement extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 33886213460338699L;
  /**
   *
   */
  private String idRef;
  /**
   *
   */
  private String metaIdRef;

  /**
   *  
   */
  public DynElement() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public DynElement(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public DynElement(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public DynElement(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public DynElement(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the DynElement instance to copy.
   */
  public DynElement(DynElement orig) {
    super(orig);

    if (orig.isSetIdRef()) {
      setIdRef(orig.getIdRef());
    }
    if (orig.isSetMetaIdRef()) {
      setMetaIdRef(orig.getMetaIdRef());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = DynConstants.shortLabel;
    idRef = null;
    metaIdRef = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      DynElement obj = (DynElement) object;

      equals &= obj.isSetIdRef() == isSetIdRef();
      if (equals && isSetIdRef()) {
        equals &= (obj.getIdRef() == getIdRef());
      }
      equals &= obj.isSetMetaIdRef() == isSetMetaIdRef();
      if (equals && isSetMetaIdRef()) {
        equals &= (obj.getMetaIdRef() == getMetaIdRef());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public DynElement clone() {
    return new DynElement(this);
  }

  /**
   * Returns the value of {@link idRef}.
   *  
   * @return the value of {@link idRef}.
   */
  public String getIdRef() {
    return isSetIdRef() ? idRef : "";
  }

  /**
   * Returns the value of {@link metaIdRef}.
   *  
   * @return the value of {@link metaIdRef}.
   */
  public String getMetaIdRef() {
    return isSetMetaIdRef() ? metaIdRef : "";
  }

  /**
   * Returns whether {@link idRef} is set.
   *  
   * @return whether {@link idRef} is set.
   */
  public boolean isSetIdRef() {
    return this.idRef != null;
  }

  /**
   * Returns whether {@link metaIdRef} is set.
   *  
   * @return whether {@link metaIdRef} is set.
   */
  public boolean isSetMetaIdRef() {
    return this.metaIdRef != null;
  }

  /**
   * Sets the value of idRef
   *  
   * @param idRef the value of idRef to be set.
   */
  public boolean setIdRef(String idRef) {
    if (idRef != this.idRef) {
      String oldIdRef = this.idRef;
      this.idRef = idRef;
      firePropertyChange(DynConstants.idRef, oldIdRef, this.idRef);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of metaIdRef
   *  
   * @param metaIdRef the value of metaIdRef to be set.
   */
  public boolean setMetaIdRef(String metaIdRef) {
    if (metaIdRef != this.metaIdRef) {
      String oldMetaIdRef = this.metaIdRef;
      this.metaIdRef = metaIdRef;
      firePropertyChange(DynConstants.metaIdRef, oldMetaIdRef, this.metaIdRef);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable idRef.
   *  
   * @return {@code true} if idRef was set before, otherwise {@code false}.
   */
  public boolean unsetIdRef() {
    if (isSetIdRef()) {
      String oldIdRef = idRef;
      idRef = null;
      firePropertyChange(DynConstants.idRef, oldIdRef, idRef);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable metaIdRef.
   *  
   * @return {@code true} if metaIdRef was set before, otherwise {@code false}.
   */
  public boolean unsetMetaIdRef() {
    if (isSetMetaIdRef()) {
      String oldMetaIdRef = metaIdRef;
      metaIdRef = null;
      firePropertyChange(DynConstants.metaIdRef, oldMetaIdRef, metaIdRef);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isIdRefMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isMetaIdRefMandatory() {
    return false;
  }

  /* hashcode method for DynElement.
   */
  @Override
  public int hashCode() {
    final int prime = 6922189;

    int hashCode = super.hashCode();

    if (isSetIdRef()) {
      hashCode += prime * getIdRef().hashCode();
    }
    if (isSetMetaIdRef()) {
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
    builder.append("DynElement [");
    builder.append("idRef = ");
    builder.append(idRef);
    builder.append(", ");
    builder.append("metaIdRef = ");
    builder.append(metaIdRef);
    builder.append(", id = ");
    builder.append(getId());
    builder.append(", name = ");
    builder.append(getName());
    builder.append("]");
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    if (!isAttributeRead) {
      isAttributeRead = true;

      if (attributeName.equals(DynConstants.idRef)) {
        setIdRef(value);
      }      else if (attributeName.equals(DynConstants.metaIdRef)) {
        setMetaIdRef(value);
      } else {
        isAttributeRead = false;
      }
    }
    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#writeXMLAttributes()
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(DynConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(DynConstants.shortLabel + ":name", getName());
    }
    if (isSetIdRef()) {
      attributes.put(DynConstants.shortLabel + ":" + DynConstants.idRef, getIdRef());
    }
    if (isSetMetaIdRef()) {
      attributes.put(DynConstants.shortLabel + ":" + DynConstants.metaIdRef,
        getMetaIdRef());
    }
    return attributes;
  }

}
