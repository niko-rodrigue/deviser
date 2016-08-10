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
public class Domain {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 37807656229374953L;
  /**
   *
   */
  private String domainType;
  /**
   *
   */
  private ListOf<InteriorPoint> listOfInteriorPoints;

  /**
   *  
   */
  public Domain() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Domain(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Domain(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Domain(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Domain(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Domain instance to copy.
   */
  public Domain(Domain orig) {
    super(orig);

    if (orig.isSetDomainType()) {
      setDomainType(orig.getDomainType());
    }
    if (orig.isSetListOfInteriorPoints()) {
      setListOfInteriorPoints(orig.getListOfInteriorPoints().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    domainType = null;
    listOfInteriorPoints = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Domain obj = (Domain) object;

      equals &= obj.isSetDomainType() == isSetDomainType();
      if (equals && isSetDomainType()) {
        equals &= (obj.getDomainType() == getDomainType());
      }
      equals &= obj.isSetListOfInteriorPoints() == isSetListOfInteriorPoints();
      if (equals && isSetListOfInteriorPoints()) {
        equals &=
          obj.getListOfInteriorPoints().equals(getListOfInteriorPoints());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Domain clone() {
    return new Domain(this);
  }

  /**
   * Returns the value of {@link domainType}.
   *  
   * @return the value of {@link domainType}.
   */
  public String getDomainType() {
    return isSetDomainType() ? domainType : "";
  }

  /**
   * Returns whether {@link domainType} is set.
   *  
   * @return whether {@link domainType} is set.
   */
  public boolean isSetDomainType() {
    return this.domainType != null;
  }

  /**
   * Sets the value of domainType
   *  
   * @param domainType the value of domainType to be set.
   */
  public boolean setDomainType(String domainType) {
    if (domainType != this.domainType) {
      String oldDomainType = this.domainType;
      this.domainType = domainType;
      firePropertyChange(SpatialConstants.domainType, oldDomainType,
        this.domainType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable domainType.
   *  
   * @return {@code true} if domainType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetDomainType() {
    if (isSetDomainType()) {
      String oldDomainType = domainType;
      domainType = null;
      firePropertyChange(SpatialConstants.domainType, oldDomainType,
        domainType);
      return true;
    }
    return false;
  }

  /**
   * @param interiorPoint
   * the interiorPoint to add
   * @return
   */
  public boolean addInteriorPoint(InteriorPoint interiorPoint) {
    return getListOfInteriorPoints().add(interiorPoint);
  }

  /**
   * Removes an element from the {@link #listOfInteriorPoints}
   *  
   * @param InteriorPoint the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeInteriorPoint(InteriorPoint interiorPoint) {
    if (isSetListOfInteriorPoints()) {
      return getListOfInteriorPoints().remove(interiorPoint);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfInteriorPoints}
   *  
   * @param i the index where to remove the {@link InteriorPoint}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfInteriorPoints)})
   */
  public InteriorPoint removeInteriorPoint(int i) {
    if (isSetListOfInteriorPoints()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfInteriorPoints().remove(i);
  }

  /**
   * Returns the {@link listOfInteriorPoints}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfInteriorPoints}.
   */
  public ListOf<InteriorPoint> getListOfInteriorPoints() {
    if (listOfInteriorPoints == null) {
      listOfInteriorPoints = new ListOf<InteriorPoint>();
      listOfInteriorPoints.setNamespace(SpatialConstants.namespaceURI);
      listOfInteriorPoints.setSBaseListType(ListOf.Type.other);
      registerChild(listOfInteriorPoints);
    }
    return listOfInteriorPoints;
  }

  /**
   * Creates a new InteriorPoint element and adds it to the
   * {@link listOfInteriorPoints} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfInteriorPoints}
   */
  public InteriorPoint createInteriorPoint() {
    InteriorPoint interiorPoint = new InteriorPoint(getLevel(), getVersion());
    return addInteriorPoint(interiorPoint) ? interiorPoint : null;
  }

  /**
   * Returns the number of {@link InteriorPoint}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link InteriorPoint}s in this {@link
   * InteriorPoint}.
   * @libsbml.deprecated same as {@link #getInteriorPointCount()}
   */
  @Deprecated
  public int getNumInteriorPoints() {
    return getInteriorPointCount();
  }

  /**
   * Returns the number of {@link InteriorPoint}s in this {@link Spatial}.
   *  
   * @return the number of {@link InteriorPoint}s in this {@link
   * InteriorPoint}.
   * @libsbml.deprecated same as {@link #getInteriorPointCount()}
   */
  public int getInteriorPointCount() {
    return isSetListOfInteriorPoints() ? getListOfInteriorPoints().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfInteriorPoints} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfInteriorPoints} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfInteriorPoints() {
    if ((listOfInteriorPoints == null) || listOfInteriorPoints.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<InteriorPoint>}.
   * If {@link listOfInteriorPoints} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfInteriorPoints
   */
  public void setListOfInteriorPoints(ListOf<InteriorPoint>    listOfInteriorPoints) {
    unsetListOfInteriorPoints();
    this.listOfInteriorPoints = listOfInteriorPoints;
    this.listOfInteriorPoints.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfInteriorPoints);
  }

  /**
   * Returns {@code true} if {@link listOfInteriorPoints} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfInteriorPoints} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfInteriorPoints() {
    if (isSetListOfInteriorPoints()) {
      ListOf<InteriorPoint> oldInteriorPoint = this.listOfInteriorPoints;
      this.listOfInteriorPoints = null;
      oldInteriorPoint.fireNodeRemovedEvent();
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

    if (isSetListOfInteriorPoints()) {
      if (pos == index) {
        return getListOfInteriorPoints();
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

    if (isSetListOfInteriorPoints()) {
      count++;
    }
    return count;
  }

  /* hashcode method for Domain.
   */
  @Override
  public int hashCode() {
    final int prime = 8510519;

    int hashCode = super.hashCode();

    if (isSetDomainType()) {
      hashCode += prime * getDomainType().hashCode();
    }
    hashCode = prime * hashCode + ((listOfInteriorPoints == null) ? 0 :
      listOfInteriorPoints.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Domain [");
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

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(SpatialConstants.shortLabel + ":id", getId());
    }
    if (isSetDomainType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domainType,
        getDomainType());
    }
    return attributes;
  }

}
