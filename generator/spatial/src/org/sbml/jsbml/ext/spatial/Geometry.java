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
public class Geometry {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 31205381841129796L;
  /**
   *
   */
  private GeometryKind coordinateSystem;
  /**
   *
   */
  private ListOf<CoordinateComponent> listOfCoordinateComponents;
  /**
   *
   */
  private ListOf<DomainType> listOfDomainTypes;
  /**
   *
   */
  private ListOf<Domain> listOfDomains;
  /**
   *
   */
  private ListOf<AdjacentDomains> listOfAdjacentDomains;
  /**
   *
   */
  private ListOf<GeometryDefinition> listOfGeometryDefinitions;
  /**
   *
   */
  private ListOf<SampledField> listOfSampledFields;

  /**
   *  
   */
  public Geometry() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Geometry(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Geometry(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Geometry(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Geometry(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Geometry instance to copy.
   */
  public Geometry(Geometry orig) {
    super(orig);

    if (orig.isSetCoordinateSystem()) {
      setCoordinateSystem(orig.getCoordinateSystem());
    }
    if (orig.isSetListOfCoordinateComponents()) {
      setListOfCoordinateComponents(orig.getListOfCoordinateComponents().clone());
    }
    if (orig.isSetListOfDomainTypes()) {
      setListOfDomainTypes(orig.getListOfDomainTypes().clone());
    }
    if (orig.isSetListOfDomains()) {
      setListOfDomains(orig.getListOfDomains().clone());
    }
    if (orig.isSetListOfAdjacentDomains()) {
      setListOfAdjacentDomains(orig.getListOfAdjacentDomains().clone());
    }
    if (orig.isSetListOfGeometryDefinitions()) {
      setListOfGeometryDefinitions(orig.getListOfGeometryDefinitions().clone());
    }
    if (orig.isSetListOfSampledFields()) {
      setListOfSampledFields(orig.getListOfSampledFields().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    coordinateSystem = null;
    listOfCoordinateComponents = null;
    listOfDomainTypes = null;
    listOfDomains = null;
    listOfAdjacentDomains = null;
    listOfGeometryDefinitions = null;
    listOfSampledFields = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Geometry obj = (Geometry) object;

      equals &= obj.isSetCoordinateSystem() == isSetCoordinateSystem();
      if (equals && isSetCoordinateSystem()) {
        equals &= (obj.getCoordinateSystem() == getCoordinateSystem());
      }
      equals &= obj.isSetListOfCoordinateComponents() ==
        isSetListOfCoordinateComponents();
      if (equals && isSetListOfCoordinateComponents()) {
        equals &=
          obj.getListOfCoordinateComponents().equals(getListOfCoordinateComponents());
      }
      equals &= obj.isSetListOfDomainTypes() == isSetListOfDomainTypes();
      if (equals && isSetListOfDomainTypes()) {
        equals &= obj.getListOfDomainTypes().equals(getListOfDomainTypes());
      }
      equals &= obj.isSetListOfDomains() == isSetListOfDomains();
      if (equals && isSetListOfDomains()) {
        equals &= obj.getListOfDomains().equals(getListOfDomains());
      }
      equals &= obj.isSetListOfAdjacentDomains() ==
        isSetListOfAdjacentDomains();
      if (equals && isSetListOfAdjacentDomains()) {
        equals &=
          obj.getListOfAdjacentDomains().equals(getListOfAdjacentDomains());
      }
      equals &= obj.isSetListOfGeometryDefinitions() ==
        isSetListOfGeometryDefinitions();
      if (equals && isSetListOfGeometryDefinitions()) {
        equals &=
          obj.getListOfGeometryDefinitions().equals(getListOfGeometryDefinitions());
      }
      equals &= obj.isSetListOfSampledFields() == isSetListOfSampledFields();
      if (equals && isSetListOfSampledFields()) {
        equals &=
          obj.getListOfSampledFields().equals(getListOfSampledFields());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Geometry clone() {
    return new Geometry(this);
  }

  /**
   * Returns the value of {@link coordinateSystem}.
   *  
   * @return the value of {@link coordinateSystem}.
   */
  public GeometryKind getCoordinateSystem() {
    if (isSetCoordinateSystem()) {
      return coordinateSystem;
    }
    throw new PropertyUndefinedError(SpatialConstants.coordinateSystem, this);
  }

  /**
   * Returns whether {@link coordinateSystem} is set.
   *  
   * @return whether {@link coordinateSystem} is set.
   */
  public boolean isSetCoordinateSystem() {
    return this.coordinateSystem != null;
  }

  /**
   * Sets the value of coordinateSystem
   *  
   * @param coordinateSystem the value of coordinateSystem to be set.
   */
  public boolean setCoordinateSystem(GeometryKind coordinateSystem) {
    if (coordinateSystem != this.coordinateSystem) {
      GeometryKind oldCoordinateSystem = this.coordinateSystem;
      this.coordinateSystem = coordinateSystem;
      firePropertyChange(SpatialConstants.coordinateSystem,
        oldCoordinateSystem, this.coordinateSystem);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable coordinateSystem.
   *  
   * @return {@code true} if coordinateSystem was set before, otherwise {@code
   * false}.
   */
  public boolean unsetCoordinateSystem() {
    if (isSetCoordinateSystem()) {
      GeometryKind oldCoordinateSystem = coordinateSystem;
      coordinateSystem = null;
      firePropertyChange(SpatialConstants.coordinateSystem,
        oldCoordinateSystem, coordinateSystem);
      return true;
    }
    return false;
  }

  /**
   * @param coordinateComponent
   * the coordinateComponent to add
   * @return
   */
  public boolean addCoordinateComponent(CoordinateComponent    coordinateComponent) {
    return getListOfCoordinateComponents().add(coordinateComponent);
  }

  /**
   * @param domainType
   * the domainType to add
   * @return
   */
  public boolean addDomainType(DomainType domainType) {
    return getListOfDomainTypes().add(domainType);
  }

  /**
   * @param domain
   * the domain to add
   * @return
   */
  public boolean addDomain(Domain domain) {
    return getListOfDomains().add(domain);
  }

  /**
   * @param adjacentDomains
   * the adjacentDomains to add
   * @return
   */
  public boolean addAdjacentDomains(AdjacentDomains adjacentDomains) {
    return getListOfAdjacentDomains().add(adjacentDomains);
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
   * @param sampledField
   * the sampledField to add
   * @return
   */
  public boolean addSampledField(SampledField sampledField) {
    return getListOfSampledFields().add(sampledField);
  }

  /**
   * Removes an element from the {@link #listOfCoordinateComponents}
   *  
   * @param CoordinateComponent the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeCoordinateComponent(CoordinateComponent    coordinateComponent) {
    if (isSetListOfCoordinateComponents()) {
      return getListOfCoordinateComponents().remove(coordinateComponent);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfDomainTypes}
   *  
   * @param DomainType the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeDomainType(DomainType domainType) {
    if (isSetListOfDomainTypes()) {
      return getListOfDomainTypes().remove(domainType);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfDomains}
   *  
   * @param Domain the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeDomain(Domain domain) {
    if (isSetListOfDomains()) {
      return getListOfDomains().remove(domain);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfAdjacentDomainss}
   *  
   * @param AdjacentDomains the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeAdjacentDomains(AdjacentDomains adjacentDomains) {
    if (isSetListOfAdjacentDomainss()) {
      return getListOfAdjacentDomainss().remove(adjacentDomains);
    }
    return false;
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
   * Removes an element from the {@link #listOfSampledFields}
   *  
   * @param SampledField the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeSampledField(SampledField sampledField) {
    if (isSetListOfSampledFields()) {
      return getListOfSampledFields().remove(sampledField);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfCoordinateComponents}
   *  
   * @param i the index where to remove the {@link CoordinateComponent}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfCoordinateComponents)})
   */
  public CoordinateComponent removeCoordinateComponent(int i) {
    if (isSetListOfCoordinateComponents()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfCoordinateComponents().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfDomainTypes}
   *  
   * @param i the index where to remove the {@link DomainType}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfDomainTypes)})
   */
  public DomainType removeDomainType(int i) {
    if (isSetListOfDomainTypes()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfDomainTypes().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfDomains}
   *  
   * @param i the index where to remove the {@link Domain}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfDomains)})
   */
  public Domain removeDomain(int i) {
    if (isSetListOfDomains()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfDomains().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfAdjacentDomainss}
   *  
   * @param i the index where to remove the {@link AdjacentDomains}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfAdjacentDomainss)})
   */
  public AdjacentDomains removeAdjacentDomains(int i) {
    if (isSetListOfAdjacentDomainss()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfAdjacentDomainss().remove(i);
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
   * Removes an element from the {@link #listOfSampledFields}
   *  
   * @param i the index where to remove the {@link SampledField}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfSampledFields)})
   */
  public SampledField removeSampledField(int i) {
    if (isSetListOfSampledFields()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfSampledFields().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfCoordinateComponents}.
   *  
   * @param coordinateComponentId the id of the element to be removed from the
   * list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public CoordinateComponent removeCoordinateComponent(String    coordinateComponentId) {
    if (isSetListOfCoordinateComponents()) {
      return getListOfCoordinateComponents().remove(coordinateComponentId);
    }
    return null;
  }

  /**
   * Removes an element from the {@link #listOfDomainTypes}.
   *  
   * @param domainTypeId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public DomainType removeDomainType(String domainTypeId) {
    if (isSetListOfDomainTypes()) {
      return getListOfDomainTypes().remove(domainTypeId);
    }
    return null;
  }

  /**
   * Removes an element from the {@link #listOfDomains}.
   *  
   * @param domainId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public Domain removeDomain(String domainId) {
    if (isSetListOfDomains()) {
      return getListOfDomains().remove(domainId);
    }
    return null;
  }

  /**
   * Removes an element from the {@link #listOfAdjacentDomainss}.
   *  
   * @param adjacentDomainsId the id of the element to be removed from the
   * list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public AdjacentDomains removeAdjacentDomains(String adjacentDomainsId) {
    if (isSetListOfAdjacentDomainss()) {
      return getListOfAdjacentDomainss().remove(adjacentDomainsId);
    }
    return null;
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
   * Removes an element from the {@link #listOfSampledFields}.
   *  
   * @param sampledFieldId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public SampledField removeSampledField(String sampledFieldId) {
    if (isSetListOfSampledFields()) {
      return getListOfSampledFields().remove(sampledFieldId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfCoordinateComponents}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfCoordinateComponents}.
   */
  public ListOf<CoordinateComponent> getListOfCoordinateComponents() {
    if (listOfCoordinateComponents == null) {
      listOfCoordinateComponents = new ListOf<CoordinateComponent>();
      listOfCoordinateComponents.setNamespace(SpatialConstants.namespaceURI);
      listOfCoordinateComponents.setSBaseListType(ListOf.Type.other);
      registerChild(listOfCoordinateComponents);
    }
    return listOfCoordinateComponents;
  }

  /**
   * Returns the {@link listOfDomainTypes}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfDomainTypes}.
   */
  public ListOf<DomainType> getListOfDomainTypes() {
    if (listOfDomainTypes == null) {
      listOfDomainTypes = new ListOf<DomainType>();
      listOfDomainTypes.setNamespace(SpatialConstants.namespaceURI);
      listOfDomainTypes.setSBaseListType(ListOf.Type.other);
      registerChild(listOfDomainTypes);
    }
    return listOfDomainTypes;
  }

  /**
   * Returns the {@link listOfDomains}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfDomains}.
   */
  public ListOf<Domain> getListOfDomains() {
    if (listOfDomains == null) {
      listOfDomains = new ListOf<Domain>();
      listOfDomains.setNamespace(SpatialConstants.namespaceURI);
      listOfDomains.setSBaseListType(ListOf.Type.other);
      registerChild(listOfDomains);
    }
    return listOfDomains;
  }

  /**
   * Returns the {@link listOfAdjacentDomains}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfAdjacentDomains}.
   */
  public ListOf<AdjacentDomains> getListOfAdjacentDomains() {
    if (listOfAdjacentDomains == null) {
      listOfAdjacentDomains = new ListOf<AdjacentDomains>();
      listOfAdjacentDomains.setNamespace(SpatialConstants.namespaceURI);
      listOfAdjacentDomains.setSBaseListType(ListOf.Type.other);
      registerChild(listOfAdjacentDomains);
    }
    return listOfAdjacentDomains;
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
   * Returns the {@link listOfSampledFields}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfSampledFields}.
   */
  public ListOf<SampledField> getListOfSampledFields() {
    if (listOfSampledFields == null) {
      listOfSampledFields = new ListOf<SampledField>();
      listOfSampledFields.setNamespace(SpatialConstants.namespaceURI);
      listOfSampledFields.setSBaseListType(ListOf.Type.other);
      registerChild(listOfSampledFields);
    }
    return listOfSampledFields;
  }

  /**
   * Creates a new CoordinateComponent element and adds it to the
   * {@link listOfCoordinateComponents} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCoordinateComponents}
   */
  public CoordinateComponent createCoordinateComponent() {
    CoordinateComponent coordinateComponent = new
      CoordinateComponent(getLevel(), getVersion());
    return addCoordinateComponent(coordinateComponent) ? coordinateComponent :
      null;
  }

  /**
   * Creates a new DomainType element and adds it to the
   * {@link listOfDomainTypes} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfDomainTypes}
   */
  public DomainType createDomainType() {
    DomainType domainType = new DomainType(getLevel(), getVersion());
    return addDomainType(domainType) ? domainType : null;
  }

  /**
   * Creates a new Domain element and adds it to the
   * {@link listOfDomains} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfDomains}
   */
  public Domain createDomain() {
    Domain domain = new Domain(getLevel(), getVersion());
    return addDomain(domain) ? domain : null;
  }

  /**
   * Creates a new AdjacentDomains element and adds it to the
   * {@link listOfAdjacentDomainss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfAdjacentDomainss}
   */
  public AdjacentDomains createAdjacentDomains() {
    AdjacentDomains adjacentDomains = new AdjacentDomains(getLevel(),
      getVersion());
    return addAdjacentDomains(adjacentDomains) ? adjacentDomains : null;
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
   * Creates a new SampledField element and adds it to the
   * {@link listOfSampledFields} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfSampledFields}
   */
  public SampledField createSampledField() {
    SampledField sampledField = new SampledField(getLevel(), getVersion());
    return addSampledField(sampledField) ? sampledField : null;
  }

  /**
   * Returns the number of {@link CoordinateComponent}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link CoordinateComponent}s in this {@link
   * CoordinateComponent}.
   * @libsbml.deprecated same as {@link #getCoordinateComponentCount()}
   */
  @Deprecated
  public int getNumCoordinateComponents() {
    return getCoordinateComponentCount();
  }

  /**
   * Returns the number of {@link DomainType}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link DomainType}s in this {@link DomainType}.
   * @libsbml.deprecated same as {@link #getDomainTypeCount()}
   */
  @Deprecated
  public int getNumDomainTypes() {
    return getDomainTypeCount();
  }

  /**
   * Returns the number of {@link Domain}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link Domain}s in this {@link Domain}.
   * @libsbml.deprecated same as {@link #getDomainCount()}
   */
  @Deprecated
  public int getNumDomains() {
    return getDomainCount();
  }

  /**
   * Returns the number of {@link AdjacentDomains}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link AdjacentDomains}s in this {@link
   * AdjacentDomains}.
   * @libsbml.deprecated same as {@link #getAdjacentDomainsCount()}
   */
  @Deprecated
  public int getNumAdjacentDomains() {
    return getAdjacentDomainsCount();
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
   * Returns the number of {@link SampledField}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link SampledField}s in this {@link SampledField}.
   * @libsbml.deprecated same as {@link #getSampledFieldCount()}
   */
  @Deprecated
  public int getNumSampledFields() {
    return getSampledFieldCount();
  }

  /**
   * Returns the number of {@link CoordinateComponent}s in this {@link
   * Spatial}.
   *  
   * @return the number of {@link CoordinateComponent}s in this {@link
   * CoordinateComponent}.
   * @libsbml.deprecated same as {@link #getCoordinateComponentCount()}
   */
  public int getCoordinateComponentCount() {
    return isSetListOfCoordinateComponents() ?
      getListOfCoordinateComponents().size() : 0;
  }

  /**
   * Returns the number of {@link DomainType}s in this {@link Spatial}.
   *  
   * @return the number of {@link DomainType}s in this {@link DomainType}.
   * @libsbml.deprecated same as {@link #getDomainTypeCount()}
   */
  public int getDomainTypeCount() {
    return isSetListOfDomainTypes() ? getListOfDomainTypes().size() : 0;
  }

  /**
   * Returns the number of {@link Domain}s in this {@link Spatial}.
   *  
   * @return the number of {@link Domain}s in this {@link Domain}.
   * @libsbml.deprecated same as {@link #getDomainCount()}
   */
  public int getDomainCount() {
    return isSetListOfDomains() ? getListOfDomains().size() : 0;
  }

  /**
   * Returns the number of {@link AdjacentDomains}s in this {@link Spatial}.
   *  
   * @return the number of {@link AdjacentDomains}s in this {@link
   * AdjacentDomains}.
   * @libsbml.deprecated same as {@link #getAdjacentDomainsCount()}
   */
  public int getAdjacentDomainsCount() {
    return isSetListOfAdjacentDomainss() ? getListOfAdjacentDomainss().size() :
      0;
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
   * Returns the number of {@link SampledField}s in this {@link Spatial}.
   *  
   * @return the number of {@link SampledField}s in this {@link SampledField}.
   * @libsbml.deprecated same as {@link #getSampledFieldCount()}
   */
  public int getSampledFieldCount() {
    return isSetListOfSampledFields() ? getListOfSampledFields().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfCoordinateComponents} contains at
   * least one element.
   *  
   * @return {@code true} if {@link listOfCoordinateComponents} contains at
   * least one element, otherwise {@code false}.
   */
  public boolean isSetListOfCoordinateComponents() {
    if ((listOfCoordinateComponents == null) ||      listOfCoordinateComponents.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfDomainTypes} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfDomainTypes} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfDomainTypes() {
    if ((listOfDomainTypes == null) || listOfDomainTypes.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfDomains} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfDomains} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfDomains() {
    if ((listOfDomains == null) || listOfDomains.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfAdjacentDomains} contains at least
   * one element.
   *  
   * @return {@code true} if {@link listOfAdjacentDomains} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean isSetListOfAdjacentDomains() {
    if ((listOfAdjacentDomains == null) || listOfAdjacentDomains.isEmpty()) {
      return false;
    }
    return true;
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
   * Returns {@code true} if {@link listOfSampledFields} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfSampledFields} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfSampledFields() {
    if ((listOfSampledFields == null) || listOfSampledFields.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<CoordinateComponent>}.
   * If {@link listOfCoordinateComponents} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfCoordinateComponents
   */
  public void setListOfCoordinateComponents(ListOf<CoordinateComponent>    listOfCoordinateComponents) {
    unsetListOfCoordinateComponents();
    this.listOfCoordinateComponents = listOfCoordinateComponents;
    this.listOfCoordinateComponents.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfCoordinateComponents);
  }

  /**
   * Sets the given {@code ListOf<DomainType>}.
   * If {@link listOfDomainTypes} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfDomainTypes
   */
  public void setListOfDomainTypes(ListOf<DomainType> listOfDomainTypes) {
    unsetListOfDomainTypes();
    this.listOfDomainTypes = listOfDomainTypes;
    this.listOfDomainTypes.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfDomainTypes);
  }

  /**
   * Sets the given {@code ListOf<Domain>}.
   * If {@link listOfDomains} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfDomains
   */
  public void setListOfDomains(ListOf<Domain> listOfDomains) {
    unsetListOfDomains();
    this.listOfDomains = listOfDomains;
    this.listOfDomains.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfDomains);
  }

  /**
   * Sets the given {@code ListOf<AdjacentDomains>}.
   * If {@link listOfAdjacentDomains} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfAdjacentDomains
   */
  public void setListOfAdjacentDomains(ListOf<AdjacentDomains>    listOfAdjacentDomains) {
    unsetListOfAdjacentDomains();
    this.listOfAdjacentDomains = listOfAdjacentDomains;
    this.listOfAdjacentDomains.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfAdjacentDomains);
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
   * Sets the given {@code ListOf<SampledField>}.
   * If {@link listOfSampledFields} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfSampledFields
   */
  public void setListOfSampledFields(ListOf<SampledField> listOfSampledFields) {
    unsetListOfSampledFields();
    this.listOfSampledFields = listOfSampledFields;
    this.listOfSampledFields.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfSampledFields);
  }

  /**
   * Returns {@code true} if {@link listOfCoordinateComponents} contains at
   * least one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfCoordinateComponents} contains at
   * least one element, otherwise {@code false}.
   */
  public boolean unsetListOfCoordinateComponents() {
    if (isSetListOfCoordinateComponents()) {
      ListOf<CoordinateComponent> oldCoordinateComponent =
        this.listOfCoordinateComponents;
      this.listOfCoordinateComponents = null;
      oldCoordinateComponent.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfDomainTypes} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfDomainTypes} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfDomainTypes() {
    if (isSetListOfDomainTypes()) {
      ListOf<DomainType> oldDomainType = this.listOfDomainTypes;
      this.listOfDomainTypes = null;
      oldDomainType.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfDomains} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfDomains} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfDomains() {
    if (isSetListOfDomains()) {
      ListOf<Domain> oldDomain = this.listOfDomains;
      this.listOfDomains = null;
      oldDomain.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfAdjacentDomains} contains at least
   * one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfAdjacentDomains} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean unsetListOfAdjacentDomains() {
    if (isSetListOfAdjacentDomains()) {
      ListOf<AdjacentDomains> oldAdjacentDomains = this.listOfAdjacentDomains;
      this.listOfAdjacentDomains = null;
      oldAdjacentDomains.fireNodeRemovedEvent();
      return true;
    }
    return false;
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
   * Returns {@code true} if {@link listOfSampledFields} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfSampledFields} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfSampledFields() {
    if (isSetListOfSampledFields()) {
      ListOf<SampledField> oldSampledField = this.listOfSampledFields;
      this.listOfSampledFields = null;
      oldSampledField.fireNodeRemovedEvent();
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

    if (isSetListOfCoordinateComponents()) {
      if (pos == index) {
        return getListOfCoordinateComponents();
      }
      pos++;
    }
    if (isSetListOfDomainTypes()) {
      if (pos == index) {
        return getListOfDomainTypes();
      }
      pos++;
    }
    if (isSetListOfDomains()) {
      if (pos == index) {
        return getListOfDomains();
      }
      pos++;
    }
    if (isSetListOfAdjacentDomainss()) {
      if (pos == index) {
        return getListOfAdjacentDomainss();
      }
      pos++;
    }
    if (isSetListOfGeometryDefinitions()) {
      if (pos == index) {
        return getListOfGeometryDefinitions();
      }
      pos++;
    }
    if (isSetListOfSampledFields()) {
      if (pos == index) {
        return getListOfSampledFields();
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

    if (isSetListOfCoordinateComponents()) {
      count++;
    }
    if (isSetListOfDomainTypes()) {
      count++;
    }
    if (isSetListOfDomains()) {
      count++;
    }
    if (isSetListOfAdjacentDomainss()) {
      count++;
    }
    if (isSetListOfGeometryDefinitions()) {
      count++;
    }
    if (isSetListOfSampledFields()) {
      count++;
    }
    return count;
  }

  /* hashcode method for Geometry.
   */
  @Override
  public int hashCode() {
    final int prime = 986437;

    int hashCode = super.hashCode();

    if (isSetCoordinateSystem()) {
      hashCode += prime * getCoordinateSystem().hashCode();
    }
    hashCode = prime * hashCode + ((listOfCoordinateComponents == null) ? 0 :
      listOfCoordinateComponents.hashCode());

    hashCode = prime * hashCode + ((listOfDomainTypes == null) ? 0 :
      listOfDomainTypes.hashCode());

    hashCode = prime * hashCode + ((listOfDomains == null) ? 0 :
      listOfDomains.hashCode());

    hashCode = prime * hashCode + ((listOfAdjacentDomains == null) ? 0 :
      listOfAdjacentDomains.hashCode());

    hashCode = prime * hashCode + ((listOfGeometryDefinitions == null) ? 0 :
      listOfGeometryDefinitions.hashCode());

    hashCode = prime * hashCode + ((listOfSampledFields == null) ? 0 :
      listOfSampledFields.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Geometry [");
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
    if (isSetCoordinateSystem()) {
      attributes.put(SpatialConstants.shortLabel + ":" +
        SpatialConstants.coordinateSystem, getCoordinateSystem().toString());
    }
    return attributes;
  }

}
