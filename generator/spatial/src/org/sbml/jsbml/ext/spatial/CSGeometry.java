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
public class CSGeometry extends GeometryDefinition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 15431182415876746L;
  /**
   *
   */
  private ListOf<CsgObject> listOfCSGObjects;

  /**
   *  
   */
  public CSGeometry() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGeometry(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGeometry(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGeometry(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGeometry(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGeometry instance to copy.
   */
  public CSGeometry(CSGeometry orig) {
    super(orig);

    if (orig.isSetListOfCSGObjects()) {
      setListOfCSGObjects(orig.getListOfCSGObjects().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    listOfCSGObjects = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGeometry obj = (CSGeometry) object;

      equals &= obj.isSetListOfCSGObjects() == isSetListOfCSGObjects();
      if (equals && isSetListOfCSGObjects()) {
        equals &= obj.getListOfCSGObjects().equals(getListOfCSGObjects());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGeometry clone() {
    return new CSGeometry(this);
  }

  /**
   * @param csgObject
   * the csgObject to add
   * @return
   */
  public boolean addCSGObject(CSGObject csgObject) {
    return getListOfCSGObjects().add(csgObject);
  }

  /**
   * Removes an element from the {@link #listOfCSGObjects}
   *  
   * @param CSGObject the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeCSGObject(CSGObject csgObject) {
    if (isSetListOfCSGObjects()) {
      return getListOfCSGObjects().remove(csgObject);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfCSGObjects}
   *  
   * @param i the index where to remove the {@link CSGObject}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfCSGObjects)})
   */
  public CSGObject removeCSGObject(int i) {
    if (isSetListOfCSGObjects()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfCSGObjects().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfCSGObjects}.
   *  
   * @param csgObjectId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public CSGObject removeCSGObject(String csgObjectId) {
    if (isSetListOfCSGObjects()) {
      return getListOfCSGObjects().remove(csgObjectId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfCSGObjects}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfCSGObjects}.
   */
  public ListOf<CSGObject> getListOfCSGObjects() {
    if (listOfCSGObjects == null) {
      listOfCSGObjects = new ListOf<CSGObject>();
      listOfCSGObjects.setNamespace(SpatialConstants.namespaceURI);
      listOfCSGObjects.setSBaseListType(ListOf.Type.other);
      registerChild(listOfCSGObjects);
    }
    return listOfCSGObjects;
  }

  /**
   * Creates a new CSGObject element and adds it to the
   * {@link listOfCSGObjects} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGObjects}
   */
  public CSGObject createCSGObject() {
    CSGObject csgObject = new CSGObject(getLevel(), getVersion());
    return addCSGObject(csgObject) ? csgObject : null;
  }

  /**
   * Returns the number of {@link CSGObject}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link CSGObject}s in this {@link CSGObject}.
   * @libsbml.deprecated same as {@link #getCSGObjectCount()}
   */
  @Deprecated
  public int getNumCSGObjects() {
    return getCSGObjectCount();
  }

  /**
   * Returns the number of {@link CSGObject}s in this {@link Spatial}.
   *  
   * @return the number of {@link CSGObject}s in this {@link CSGObject}.
   * @libsbml.deprecated same as {@link #getCSGObjectCount()}
   */
  public int getCSGObjectCount() {
    return isSetListOfCSGObjects() ? getListOfCSGObjects().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfCSGObjects} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfCSGObjects} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfCSGObjects() {
    if ((listOfCSGObjects == null) || listOfCSGObjects.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<CSGObject>}.
   * If {@link listOfCSGObjects} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfCSGObjects
   */
  public void setListOfCSGObjects(ListOf<CSGObject> listOfCSGObjects) {
    unsetListOfCSGObjects();
    this.listOfCSGObjects = listOfCSGObjects;
    this.listOfCSGObjects.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfCSGObjects);
  }

  /**
   * Returns {@code true} if {@link listOfCSGObjects} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfCSGObjects} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfCSGObjects() {
    if (isSetListOfCSGObjects()) {
      ListOf<CSGObject> oldCSGObject = this.listOfCSGObjects;
      this.listOfCSGObjects = null;
      oldCSGObject.fireNodeRemovedEvent();
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

    if (isSetListOfCsgObjects()) {
      if (pos == index) {
        return getListOfCsgObjects();
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

    if (isSetListOfCsgObjects()) {
      count++;
    }
    return count;
  }

  /* hashcode method for CSGeometry.
   */
  @Override
  public int hashCode() {
    final int prime = 7930907;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfCSGObjects == null) ? 0 :
      listOfCSGObjects.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGeometry [");
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
