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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class SampledFieldGeometry extends GeometryDefinition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 71047926415866794L;
  /**
   *
   */
  private String sampledField;
  /**
   *
   */
  private ListOf<SampledVolume> listOfSampledVolumes;

  /**
   *  
   */
  public SampledFieldGeometry() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public SampledFieldGeometry(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public SampledFieldGeometry(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public SampledFieldGeometry(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public SampledFieldGeometry(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the SampledFieldGeometry instance to copy.
   */
  public SampledFieldGeometry(SampledFieldGeometry orig) {
    super(orig);

    if (orig.isSetListOfSampledVolumes()) {
      setListOfSampledVolumes(orig.getListOfSampledVolumes().clone());
    }
    if (orig.isSetSampledField()) {
      setSampledField(orig.getSampledField());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    listOfSampledVolumes = null;
    sampledField = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      SampledFieldGeometry obj = (SampledFieldGeometry) object;

      equals &= obj.isSetListOfSampledVolumes() == isSetListOfSampledVolumes();
      if (equals && isSetListOfSampledVolumes()) {
        equals &=
          obj.getListOfSampledVolumes().equals(getListOfSampledVolumes());
      }
      equals &= obj.isSetSampledField() == isSetSampledField();
      if (equals && isSetSampledField()) {
        equals &= (obj.getSampledField() == getSampledField());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public SampledFieldGeometry clone() {
    return new SampledFieldGeometry(this);
  }

  /**
   * Returns the value of {@link sampledField}.
   *  
   * @return the value of {@link sampledField}.
   */
  public String getSampledField() {
    return isSetSampledField() ? sampledField : "";
  }

  /**
   * Returns whether {@link sampledField} is set.
   *  
   * @return whether {@link sampledField} is set.
   */
  public boolean isSetSampledField() {
    return this.sampledField != null;
  }

  /**
   * Sets the value of sampledField
   *  
   * @param sampledField the value of sampledField to be set.
   */
  public boolean setSampledField(String sampledField) {
    if (sampledField != this.sampledField) {
      String oldSampledField = this.sampledField;
      this.sampledField = sampledField;
      firePropertyChange(SpatialConstants.sampledField, oldSampledField,
        this.sampledField);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable sampledField.
   *  
   * @return {@code true} if sampledField was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSampledField() {
    if (isSetSampledField()) {
      String oldSampledField = sampledField;
      sampledField = null;
      firePropertyChange(SpatialConstants.sampledField, oldSampledField,
        sampledField);
      return true;
    }
    return false;
  }

  /**
   * @param sampledVolume
   * the sampledVolume to add
   * @return
   */
  public boolean addSampledVolume(SampledVolume sampledVolume) {
    return getListOfSampledVolumes().add(sampledVolume);
  }

  /**
   * Removes an element from the {@link #listOfSampledVolumes}
   *  
   * @param SampledVolume the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeSampledVolume(SampledVolume sampledVolume) {
    if (isSetListOfSampledVolumes()) {
      return getListOfSampledVolumes().remove(sampledVolume);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfSampledVolumes}
   *  
   * @param i the index where to remove the {@link SampledVolume}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfSampledVolumes)})
   */
  public SampledVolume removeSampledVolume(int i) {
    if (isSetListOfSampledVolumes()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfSampledVolumes().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfSampledVolumes}.
   *  
   * @param sampledVolumeId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public SampledVolume removeSampledVolume(String sampledVolumeId) {
    if (isSetListOfSampledVolumes()) {
      return getListOfSampledVolumes().remove(sampledVolumeId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfSampledVolumes}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfSampledVolumes}.
   */
  public ListOf<SampledVolume> getListOfSampledVolumes() {
    if (listOfSampledVolumes == null) {
      listOfSampledVolumes = new ListOf<SampledVolume>();
      listOfSampledVolumes.setNamespace(SpatialConstants.namespaceURI);
      listOfSampledVolumes.setSBaseListType(ListOf.Type.other);
      registerChild(listOfSampledVolumes);
    }
    return listOfSampledVolumes;
  }

  /**
   * Creates a new SampledVolume element and adds it to the
   * {@link listOfSampledVolumes} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfSampledVolumes}
   */
  public SampledVolume createSampledVolume() {
    SampledVolume sampledVolume = new SampledVolume(getLevel(), getVersion());
    return addSampledVolume(sampledVolume) ? sampledVolume : null;
  }

  /**
   * Returns the number of {@link SampledVolume}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link SampledVolume}s in this {@link
   * SampledVolume}.
   * @libsbml.deprecated same as {@link #getSampledVolumeCount()}
   */
  @Deprecated
  public int getNumSampledVolumes() {
    return getSampledVolumeCount();
  }

  /**
   * Returns the number of {@link SampledVolume}s in this {@link Spatial}.
   *  
   * @return the number of {@link SampledVolume}s in this {@link
   * SampledVolume}.
   * @libsbml.deprecated same as {@link #getSampledVolumeCount()}
   */
  public int getSampledVolumeCount() {
    return isSetListOfSampledVolumes() ? getListOfSampledVolumes().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfSampledVolumes} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfSampledVolumes} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfSampledVolumes() {
    if ((listOfSampledVolumes == null) || listOfSampledVolumes.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<SampledVolume>}.
   * If {@link listOfSampledVolumes} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfSampledVolumes
   */
  public void setListOfSampledVolumes(ListOf<SampledVolume>    listOfSampledVolumes) {
    unsetListOfSampledVolumes();
    this.listOfSampledVolumes = listOfSampledVolumes;
    this.listOfSampledVolumes.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfSampledVolumes);
  }

  /**
   * Returns {@code true} if {@link listOfSampledVolumes} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfSampledVolumes} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfSampledVolumes() {
    if (isSetListOfSampledVolumes()) {
      ListOf<SampledVolume> oldSampledVolume = this.listOfSampledVolumes;
      this.listOfSampledVolumes = null;
      oldSampledVolume.fireNodeRemovedEvent();
      return true;
    }
    return false;
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
    int count = super.getChildCount(), pos = 0;

    if (index < count) {
      return super.getChildAt(index);
    } else {
      index -= count;
    }

    if (isSetListOfSampledVolumes()) {
      if (pos == index) {
        return getListOfSampledVolumes();
      }
      pos++;
    }
    throw new IndexOutOfBoundsException(MessageFormat.format(
      resourceBundle.getString("IndexExceedsBoundsException"), index,
        Math.min(pos, 0)));
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml#getAllowsChildren()
   */
  @Override
  public boolean getAllowsChildren() {
    return true;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#getChildCount()
   */
  @Override
  public int getChildCount() {
    int count = super.getChildCount();

    if (isSetListOfSampledVolumes()) {
      count++;
    }
    return count;
  }

  /* hashcode method for SampledFieldGeometry.
   */
  @Override
  public int hashCode() {
    final int prime = 5234687;

    int hashCode = super.hashCode();

    if (isSetSampledField()) {
      hashCode += prime * getSampledField().hashCode();
    }
    hashCode = prime * hashCode + ((listOfSampledVolumes == null) ? 0 :
      listOfSampledVolumes.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SampledFieldGeometry [");
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

    if (isSetSampledField()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.sampledField,
        getSampledField());
    }
    return attributes;
  }

}
