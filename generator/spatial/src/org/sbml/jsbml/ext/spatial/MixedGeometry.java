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
public class MixedGeometry extends GeometryDefinition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 32014313646971301L;
  /**
   *
   */
  private ListOf<GeometryDefinition> listOfGeometryDefinitions;
  /**
   *
   */
  private ListOf<OrdinalMapping> listOfOrdinalMappings;

  /**
   *  
   */
  public MixedGeometry() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public MixedGeometry(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public MixedGeometry(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public MixedGeometry(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public MixedGeometry(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the MixedGeometry instance to copy.
   */
  public MixedGeometry(MixedGeometry orig) {
    super(orig);

    if (orig.isSetListOfGeometryDefinitions()) {
      setListOfGeometryDefinitions(orig.getListOfGeometryDefinitions().clone());
    }
    if (orig.isSetListOfOrdinalMappings()) {
      setListOfOrdinalMappings(orig.getListOfOrdinalMappings().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    listOfGeometryDefinitions = null;
    listOfOrdinalMappings = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      MixedGeometry obj = (MixedGeometry) object;

      equals &= obj.isSetListOfGeometryDefinitions() ==
        isSetListOfGeometryDefinitions();
      if (equals && isSetListOfGeometryDefinitions()) {
        equals &=
          obj.getListOfGeometryDefinitions().equals(getListOfGeometryDefinitions());
      }
      equals &= obj.isSetListOfOrdinalMappings() ==
        isSetListOfOrdinalMappings();
      if (equals && isSetListOfOrdinalMappings()) {
        equals &=
          obj.getListOfOrdinalMappings().equals(getListOfOrdinalMappings());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public MixedGeometry clone() {
    return new MixedGeometry(this);
  }

  /**
   * @param geometryDefinition
   * the geometryDefinition to add
   * @return
   */
  public boolean addGeometryDefinition(GeometryDefinition geometryDefinition) {
    return getListOfGeometryDefinitions().add(geometryDefinition);
  }

  /**
   * @param ordinalMapping
   * the ordinalMapping to add
   * @return
   */
  public boolean addOrdinalMapping(OrdinalMapping ordinalMapping) {
    return getListOfOrdinalMappings().add(ordinalMapping);
  }

  /**
   * Removes an element from the {@link #listOfGeometryDefinitions}
   *  
   * @param GeometryDefinition the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeGeometryDefinition(GeometryDefinition    geometryDefinition) {
    if (isSetListOfGeometryDefinitions()) {
      return getListOfGeometryDefinitions().remove(geometryDefinition);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfOrdinalMappings}
   *  
   * @param OrdinalMapping the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeOrdinalMapping(OrdinalMapping ordinalMapping) {
    if (isSetListOfOrdinalMappings()) {
      return getListOfOrdinalMappings().remove(ordinalMapping);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfGeometryDefinitions}
   *  
   * @param i the index where to remove the {@link GeometryDefinition}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfGeometryDefinitions)})
   */
  public GeometryDefinition removeGeometryDefinition(int i) {
    if (isSetListOfGeometryDefinitions()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfGeometryDefinitions().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfOrdinalMappings}
   *  
   * @param i the index where to remove the {@link OrdinalMapping}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfOrdinalMappings)})
   */
  public OrdinalMapping removeOrdinalMapping(int i) {
    if (isSetListOfOrdinalMappings()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfOrdinalMappings().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfGeometryDefinitions}.
   *  
   * @param geometryDefinitionId the id of the element to be removed from the
   * list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public GeometryDefinition removeGeometryDefinition(String    geometryDefinitionId) {
    if (isSetListOfGeometryDefinitions()) {
      return getListOfGeometryDefinitions().remove(geometryDefinitionId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfGeometryDefinitions}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfGeometryDefinitions}.
   */
  public ListOf<GeometryDefinition> getListOfGeometryDefinitions() {
    if (listOfGeometryDefinitions == null) {
      listOfGeometryDefinitions = new ListOf<GeometryDefinition>();
      listOfGeometryDefinitions.setNamespace(SpatialConstants.namespaceURI);
      listOfGeometryDefinitions.setSBaseListType(ListOf.Type.other);
      registerChild(listOfGeometryDefinitions);
    }
    return listOfGeometryDefinitions;
  }

  /**
   * Returns the {@link listOfOrdinalMappings}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfOrdinalMappings}.
   */
  public ListOf<OrdinalMapping> getListOfOrdinalMappings() {
    if (listOfOrdinalMappings == null) {
      listOfOrdinalMappings = new ListOf<OrdinalMapping>();
      listOfOrdinalMappings.setNamespace(SpatialConstants.namespaceURI);
      listOfOrdinalMappings.setSBaseListType(ListOf.Type.other);
      registerChild(listOfOrdinalMappings);
    }
    return listOfOrdinalMappings;
  }

  /**
   * Creates a new AnalyticGeometry element and adds it to the
   * {@link listOfAnalyticGeometrys} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfAnalyticGeometrys}
   */
  public AnalyticGeometry createAnalyticGeometry() {
  }

  /**
   * Creates a new SampledFieldGeometry element and adds it to the
   * {@link listOfSampledFieldGeometrys} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfSampledFieldGeometrys}
   */
  public SampledFieldGeometry createSampledFieldGeometry() {
  }

  /**
   * Creates a new CSGeometry element and adds it to the
   * {@link listOfCSGeometrys} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGeometrys}
   */
  public CSGeometry createCSGeometry() {
  }

  /**
   * Creates a new ParametricGeometry element and adds it to the
   * {@link listOfParametricGeometrys} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfParametricGeometrys}
   */
  public ParametricGeometry createParametricGeometry() {
  }

  /**
   * Creates a new MixedGeometry element and adds it to the
   * {@link listOfMixedGeometrys} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfMixedGeometrys}
   */
  public MixedGeometry createMixedGeometry() {
  }

  /**
   * Creates a new OrdinalMapping element and adds it to the
   * {@link listOfOrdinalMappings} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfOrdinalMappings}
   */
  public OrdinalMapping createOrdinalMapping() {
    OrdinalMapping ordinalMapping = new OrdinalMapping(getLevel(),
      getVersion());
    return addOrdinalMapping(ordinalMapping) ? ordinalMapping : null;
  }

  /**
   * Returns the number of {@link GeometryDefinition}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link GeometryDefinition}s in this {@link
   * GeometryDefinition}.
   * @libsbml.deprecated same as {@link #getGeometryDefinitionCount()}
   */
  @Deprecated
  public int getNumGeometryDefinitions() {
    return getGeometryDefinitionCount();
  }

  /**
   * Returns the number of {@link OrdinalMapping}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link OrdinalMapping}s in this {@link
   * OrdinalMapping}.
   * @libsbml.deprecated same as {@link #getOrdinalMappingCount()}
   */
  @Deprecated
  public int getNumOrdinalMappings() {
    return getOrdinalMappingCount();
  }

  /**
   * Returns the number of {@link GeometryDefinition}s in this {@link Spatial}.
   *  
   * @return the number of {@link GeometryDefinition}s in this {@link
   * GeometryDefinition}.
   * @libsbml.deprecated same as {@link #getGeometryDefinitionCount()}
   */
  public int getGeometryDefinitionCount() {
    return isSetListOfGeometryDefinitions() ?
      getListOfGeometryDefinitions().size() : 0;
  }

  /**
   * Returns the number of {@link OrdinalMapping}s in this {@link Spatial}.
   *  
   * @return the number of {@link OrdinalMapping}s in this {@link
   * OrdinalMapping}.
   * @libsbml.deprecated same as {@link #getOrdinalMappingCount()}
   */
  public int getOrdinalMappingCount() {
    return isSetListOfOrdinalMappings() ? getListOfOrdinalMappings().size() :
      0;
  }

  /**
   * Returns {@code true} if {@link listOfGeometryDefinitions} contains at
   * least one element.
   *  
   * @return {@code true} if {@link listOfGeometryDefinitions} contains at
   * least one element, otherwise {@code false}.
   */
  public boolean isSetListOfGeometryDefinitions() {
    if ((listOfGeometryDefinitions == null) ||      listOfGeometryDefinitions.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfOrdinalMappings} contains at least
   * one element.
   *  
   * @return {@code true} if {@link listOfOrdinalMappings} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean isSetListOfOrdinalMappings() {
    if ((listOfOrdinalMappings == null) || listOfOrdinalMappings.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<GeometryDefinition>}.
   * If {@link listOfGeometryDefinitions} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfGeometryDefinitions
   */
  public void setListOfGeometryDefinitions(ListOf<GeometryDefinition>    listOfGeometryDefinitions) {
    unsetListOfGeometryDefinitions();
    this.listOfGeometryDefinitions = listOfGeometryDefinitions;
    this.listOfGeometryDefinitions.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfGeometryDefinitions);
  }

  /**
   * Sets the given {@code ListOf<OrdinalMapping>}.
   * If {@link listOfOrdinalMappings} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfOrdinalMappings
   */
  public void setListOfOrdinalMappings(ListOf<OrdinalMapping>    listOfOrdinalMappings) {
    unsetListOfOrdinalMappings();
    this.listOfOrdinalMappings = listOfOrdinalMappings;
    this.listOfOrdinalMappings.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfOrdinalMappings);
  }

  /**
   * Returns {@code true} if {@link listOfGeometryDefinitions} contains at
   * least one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfGeometryDefinitions} contains at
   * least one element, otherwise {@code false}.
   */
  public boolean unsetListOfGeometryDefinitions() {
    if (isSetListOfGeometryDefinitions()) {
      ListOf<GeometryDefinition> oldGeometryDefinition =
        this.listOfGeometryDefinitions;
      this.listOfGeometryDefinitions = null;
      oldGeometryDefinition.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfOrdinalMappings} contains at least
   * one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfOrdinalMappings} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean unsetListOfOrdinalMappings() {
    if (isSetListOfOrdinalMappings()) {
      ListOf<OrdinalMapping> oldOrdinalMapping = this.listOfOrdinalMappings;
      this.listOfOrdinalMappings = null;
      oldOrdinalMapping.fireNodeRemovedEvent();
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

    if (isSetListOfGeometryDefinitions()) {
      if (pos == index) {
        return getListOfGeometryDefinitions();
      }
      pos++;
    }
    if (isSetListOfOrdinalMappings()) {
      if (pos == index) {
        return getListOfOrdinalMappings();
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

    if (isSetListOfGeometryDefinitions()) {
      count++;
    }
    if (isSetListOfOrdinalMappings()) {
      count++;
    }
    return count;
  }

  /* hashcode method for MixedGeometry.
   */
  @Override
  public int hashCode() {
    final int prime = 6423649;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfGeometryDefinitions == null) ? 0 :
      listOfGeometryDefinitions.hashCode());

    hashCode = prime * hashCode + ((listOfOrdinalMappings == null) ? 0 :
      listOfOrdinalMappings.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("MixedGeometry [");
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
