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
package org.sbml.jsbml.ext.groups;

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
public class Member extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 41065238049940067L;
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
  public Member() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Member(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Member(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Member(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Member(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Member instance to copy.
   */
  public Member(Member orig) {
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
    packageName = GroupsConstants.shortLabel;
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
      Member obj = (Member) object;

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
  public Member clone() {
    return new Member(this);
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
      firePropertyChange(GroupsConstants.idRef, oldIdRef, this.idRef);
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
      firePropertyChange(GroupsConstants.metaIdRef, oldMetaIdRef,
        this.metaIdRef);
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
      firePropertyChange(GroupsConstants.idRef, oldIdRef, idRef);
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
      firePropertyChange(GroupsConstants.metaIdRef, oldMetaIdRef, metaIdRef);
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

  /* hashcode method for Member.
   */
  @Override
  public int hashCode() {
    final int prime = 864551;

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
    builder.append("Member [");
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

      if (attributeName.equals(GroupsConstants.idRef)) {
        setIdRef(value);
      }      else if (attributeName.equals(GroupsConstants.metaIdRef)) {
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
      attributes.put(GroupsConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(GroupsConstants.shortLabel + ":name", getName());
    }
    if (isSetIdRef()) {
      attributes.put(GroupsConstants.shortLabel + ":" + GroupsConstants.idRef,
        getIdRef());
    }
    if (isSetMetaIdRef()) {
      attributes.put(GroupsConstants.shortLabel + ":" + GroupsConstants.metaIdRef,
        getMetaIdRef());
    }
    return attributes;
  }

}
