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
public class AnalyticGeometry extends GeometryDefinition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 2900893275513228L;
  /**
   *
   */
  private ListOf<AnalyticVolume> listOfAnalyticVolumes;

  /**
   *  
   */
  public AnalyticGeometry() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public AnalyticGeometry(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public AnalyticGeometry(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public AnalyticGeometry(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public AnalyticGeometry(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the AnalyticGeometry instance to copy.
   */
  public AnalyticGeometry(AnalyticGeometry orig) {
    super(orig);

    if (orig.isSetListOfAnalyticVolumes()) {
      setListOfAnalyticVolumes(orig.getListOfAnalyticVolumes().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    listOfAnalyticVolumes = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      AnalyticGeometry obj = (AnalyticGeometry) object;

      equals &= obj.isSetListOfAnalyticVolumes() ==
        isSetListOfAnalyticVolumes();
      if (equals && isSetListOfAnalyticVolumes()) {
        equals &=
          obj.getListOfAnalyticVolumes().equals(getListOfAnalyticVolumes());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public AnalyticGeometry clone() {
    return new AnalyticGeometry(this);
  }

  /**
   * @param analyticVolume
   * the analyticVolume to add
   * @return
   */
  public boolean addAnalyticVolume(AnalyticVolume analyticVolume) {
    return getListOfAnalyticVolumes().add(analyticVolume);
  }

  /**
   * Removes an element from the {@link #listOfAnalyticVolumes}
   *  
   * @param AnalyticVolume the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeAnalyticVolume(AnalyticVolume analyticVolume) {
    if (isSetListOfAnalyticVolumes()) {
      return getListOfAnalyticVolumes().remove(analyticVolume);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfAnalyticVolumes}
   *  
   * @param i the index where to remove the {@link AnalyticVolume}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfAnalyticVolumes)})
   */
  public AnalyticVolume removeAnalyticVolume(int i) {
    if (isSetListOfAnalyticVolumes()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfAnalyticVolumes().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfAnalyticVolumes}.
   *  
   * @param analyticVolumeId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public AnalyticVolume removeAnalyticVolume(String analyticVolumeId) {
    if (isSetListOfAnalyticVolumes()) {
      return getListOfAnalyticVolumes().remove(analyticVolumeId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfAnalyticVolumes}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfAnalyticVolumes}.
   */
  public ListOf<AnalyticVolume> getListOfAnalyticVolumes() {
    if (listOfAnalyticVolumes == null) {
      listOfAnalyticVolumes = new ListOf<AnalyticVolume>();
      listOfAnalyticVolumes.setNamespace(SpatialConstants.namespaceURI);
      listOfAnalyticVolumes.setSBaseListType(ListOf.Type.other);
      registerChild(listOfAnalyticVolumes);
    }
    return listOfAnalyticVolumes;
  }

  /**
   * Creates a new AnalyticVolume element and adds it to the
   * {@link listOfAnalyticVolumes} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfAnalyticVolumes}
   */
  public AnalyticVolume createAnalyticVolume() {
    AnalyticVolume analyticVolume = new AnalyticVolume(getLevel(),
      getVersion());
    return addAnalyticVolume(analyticVolume) ? analyticVolume : null;
  }

  /**
   * Returns the number of {@link AnalyticVolume}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link AnalyticVolume}s in this {@link
   * AnalyticVolume}.
   * @libsbml.deprecated same as {@link #getAnalyticVolumeCount()}
   */
  @Deprecated
  public int getNumAnalyticVolumes() {
    return getAnalyticVolumeCount();
  }

  /**
   * Returns the number of {@link AnalyticVolume}s in this {@link Spatial}.
   *  
   * @return the number of {@link AnalyticVolume}s in this {@link
   * AnalyticVolume}.
   * @libsbml.deprecated same as {@link #getAnalyticVolumeCount()}
   */
  public int getAnalyticVolumeCount() {
    return isSetListOfAnalyticVolumes() ? getListOfAnalyticVolumes().size() :
      0;
  }

  /**
   * Returns {@code true} if {@link listOfAnalyticVolumes} contains at least
   * one element.
   *  
   * @return {@code true} if {@link listOfAnalyticVolumes} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean isSetListOfAnalyticVolumes() {
    if ((listOfAnalyticVolumes == null) || listOfAnalyticVolumes.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<AnalyticVolume>}.
   * If {@link listOfAnalyticVolumes} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfAnalyticVolumes
   */
  public void setListOfAnalyticVolumes(ListOf<AnalyticVolume>    listOfAnalyticVolumes) {
    unsetListOfAnalyticVolumes();
    this.listOfAnalyticVolumes = listOfAnalyticVolumes;
    this.listOfAnalyticVolumes.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfAnalyticVolumes);
  }

  /**
   * Returns {@code true} if {@link listOfAnalyticVolumes} contains at least
   * one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfAnalyticVolumes} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean unsetListOfAnalyticVolumes() {
    if (isSetListOfAnalyticVolumes()) {
      ListOf<AnalyticVolume> oldAnalyticVolume = this.listOfAnalyticVolumes;
      this.listOfAnalyticVolumes = null;
      oldAnalyticVolume.fireNodeRemovedEvent();
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

    if (isSetListOfAnalyticVolumes()) {
      if (pos == index) {
        return getListOfAnalyticVolumes();
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

    if (isSetListOfAnalyticVolumes()) {
      count++;
    }
    return count;
  }

  /* hashcode method for AnalyticGeometry.
   */
  @Override
  public int hashCode() {
    final int prime = 5956751;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfAnalyticVolumes == null) ? 0 :
      listOfAnalyticVolumes.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AnalyticGeometry [");
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

    return attributes;
  }

}
