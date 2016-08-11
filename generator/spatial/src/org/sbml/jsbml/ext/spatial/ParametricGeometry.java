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
import org.sbml.jsbml.xml.XMLNode;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class ParametricGeometry extends GeometryDefinition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 33882001335035041L;
  /**
   *
   */
  private XMLNode spatialPoints;
  /**
   *
   */
  private ListOf<ParametricObject> listOfParametricObjects;

  /**
   *  
   */
  public ParametricGeometry() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public ParametricGeometry(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the ParametricGeometry instance to copy.
   */
  public ParametricGeometry(ParametricGeometry orig) {
    super(orig);

    if (orig.isSetSpatialPoints()) {
      setSpatialPoints(orig.getSpatialPoints().clone());
    }
    if (orig.isSetListOfParametricObjects()) {
      setListOfParametricObjects(orig.getListOfParametricObjects().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      ParametricGeometry obj = (ParametricGeometry) object;

      equals &= obj.isSetSpatialPoints() == isSetSpatialPoints();
      if (equals && isSetSpatialPoints()) {
        equals &= (obj.getSpatialPoints() == getSpatialPoints());
      }
      equals &= obj.isSetListOfParametricObjects() ==
        isSetListOfParametricObjects();
      if (equals && isSetListOfParametricObjects()) {
        equals &=
          obj.getListOfParametricObjects().equals(getListOfParametricObjects());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public ParametricGeometry clone() {
    return new ParametricGeometry(this);
  }

  /**
   * Returns the value of {@link spatialPoints}.
   *  
   * @return the value of {@link spatialPoints}.
   */
  public XMLNode getSpatialPoints() {
    if (isSetSpatialPoints()) {
      return spatialPoints;
    }
    throw new PropertyUndefinedError(SpatialConstants.spatialPoints, this);
  }

  /**
   * Returns whether {@link spatialPoints} is set.
   *  
   * @return whether {@link spatialPoints} is set.
   */
  public boolean isSetSpatialPoints() {
    return spatialPoints != null;
  }

  /**
   * Sets the value of spatialPoints
   *  
   * @param spatialPoints the value of spatialPoints to be set.
   */
  public boolean setSpatialPoints(XMLNode spatialPoints) {
    if (spatialPoints != this.spatialPoints) {
      XMLNode oldSpatialPoints = this.spatialPoints;
      this.spatialPoints = spatialPoints;
      firePropertyChange(SpatialConstants.spatialPoints, oldSpatialPoints,
        this.spatialPoints);
      return true;
    }
    return false;
  }

  /**
   * Creates a new SpatialPoints object, adds it to this ParametricGeometry
   * object and returns the SpatialPoints object created.
   */
  public XMLNode createSpatialPoints() {
    XMLNode spatialPoints = new XMLNode(getLevel(), getVersion());
    return spatialPoints;
  }

  /**
   * Unsets the variable spatialPoints.
   *  
   * @return {@code true} if spatialPoints was set before, otherwise {@code
   * false}.
   */
  public boolean unsetSpatialPoints() {
    if (isSetSpatialPoints()) {
      XMLNode oldSpatialPoints = spatialPoints;
      spatialPoints = null;
      firePropertyChange(SpatialConstants.spatialPoints, oldSpatialPoints,
        spatialPoints);
      return true;
    }
    return false;
  }

  /**
   * @param parametricObject
   * the parametricObject to add
   * @return
   */
  public boolean addParametricObject(ParametricObject parametricObject) {
    return getListOfParametricObjects().add(parametricObject);
  }

  /**
   * Removes an element from the {@link #listOfParametricObjects}
   *  
   * @param ParametricObject the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeParametricObject(ParametricObject parametricObject) {
    if (isSetListOfParametricObjects()) {
      return getListOfParametricObjects().remove(parametricObject);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfParametricObjects}
   *  
   * @param i the index where to remove the {@link ParametricObject}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfParametricObjects)})
   */
  public ParametricObject removeParametricObject(int i) {
    if (isSetListOfParametricObjects()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfParametricObjects().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfParametricObjects}.
   *  
   * @param parametricObjectId the id of the element to be removed from the
   * list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public ParametricObject removeParametricObject(String parametricObjectId) {
    if (isSetListOfParametricObjects()) {
      return getListOfParametricObjects().remove(parametricObjectId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfParametricObjects}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfParametricObjects}.
   */
  public ListOf<ParametricObject> getListOfParametricObjects() {
    if (listOfParametricObjects == null) {
      listOfParametricObjects = new ListOf<ParametricObject>();
      listOfParametricObjects.setNamespace(SpatialConstants.namespaceURI);
      listOfParametricObjects.setSBaseListType(ListOf.Type.other);
      registerChild(listOfParametricObjects);
    }
    return listOfParametricObjects;
  }

  /**
   * Creates a new ParametricObject element and adds it to the
   * {@link listOfParametricObjects} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfParametricObjects}
   */
  public ParametricObject createParametricObject() {
    ParametricObject parametricObject = new ParametricObject(getLevel(),
      getVersion());
    return addParametricObject(parametricObject) ? parametricObject : null;
  }

  /**
   * Returns the number of {@link ParametricObject}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link ParametricObject}s in this {@link
   * ParametricObject}.
   * @libsbml.deprecated same as {@link #getParametricObjectCount()}
   */
  @Deprecated
  public int getNumParametricObjects() {
    return getParametricObjectCount();
  }

  /**
   * Returns the number of {@link ParametricObject}s in this {@link Spatial}.
   *  
   * @return the number of {@link ParametricObject}s in this {@link
   * ParametricObject}.
   * @libsbml.deprecated same as {@link #getParametricObjectCount()}
   */
  public int getParametricObjectCount() {
    return isSetListOfParametricObjects() ? getListOfParametricObjects().size()
      : 0;
  }

  /**
   * Returns {@code true} if {@link listOfParametricObjects} contains at least
   * one element.
   *  
   * @return {@code true} if {@link listOfParametricObjects} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean isSetListOfParametricObjects() {
    if ((listOfParametricObjects == null) || listOfParametricObjects.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<ParametricObject>}.
   * If {@link listOfParametricObjects} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfParametricObjects
   */
  public void setListOfParametricObjects(ListOf<ParametricObject>    listOfParametricObjects) {
    unsetListOfParametricObjects();
    this.listOfParametricObjects = listOfParametricObjects;
    this.listOfParametricObjects.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfParametricObjects);
  }

  /**
   * Returns {@code true} if {@link listOfParametricObjects} contains at least
   * one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfParametricObjects} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean unsetListOfParametricObjects() {
    if (isSetListOfParametricObjects()) {
      ListOf<ParametricObject> oldParametricObject =
        this.listOfParametricObjects;
      this.listOfParametricObjects = null;
      oldParametricObject.fireNodeRemovedEvent();
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

    if (isSetListOfParametricObjects()) {
      if (pos == index) {
        return getListOfParametricObjects();
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

    if (isSetSpatialPoints()) {
      count++;
    }
    if (isSetListOfParametricObjects()) {
      count++;
    }
    return count;
  }

  /* hashcode method for ParametricGeometry.
   */
  @Override
  public int hashCode() {
    final int prime = 8268283;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfParametricObjects == null) ? 0 :
      listOfParametricObjects.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ParametricGeometry [");
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
