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
public class CSGSetOperator extends CSGNode {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 19199397394849161L;
  /**
   *
   */
  private SetOperation operationType;
  /**
   *
   */
  private String complementA;
  /**
   *
   */
  private String complementB;
  /**
   *
   */
  private ListOf<CsgNode> listOfCSGNodes;

  /**
   *  
   */
  public CSGSetOperator() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public CSGSetOperator(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public CSGSetOperator(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public CSGSetOperator(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public CSGSetOperator(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the CSGSetOperator instance to copy.
   */
  public CSGSetOperator(CSGSetOperator orig) {
    super(orig);

    if (orig.isSetOperationType()) {
      setOperationType(orig.getOperationType());
    }
    if (orig.isSetComplementA()) {
      setComplementA(orig.getComplementA());
    }
    if (orig.isSetComplementB()) {
      setComplementB(orig.getComplementB());
    }
    if (orig.isSetListOfCSGNodes()) {
      setListOfCSGNodes(orig.getListOfCSGNodes().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    operationType = null;
    complementA = null;
    complementB = null;
    listOfCSGNodes = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      CSGSetOperator obj = (CSGSetOperator) object;

      equals &= obj.isSetOperationType() == isSetOperationType();
      if (equals && isSetOperationType()) {
        equals &= (obj.getOperationType() == getOperationType());
      }
      equals &= obj.isSetComplementA() == isSetComplementA();
      if (equals && isSetComplementA()) {
        equals &= (obj.getComplementA() == getComplementA());
      }
      equals &= obj.isSetComplementB() == isSetComplementB();
      if (equals && isSetComplementB()) {
        equals &= (obj.getComplementB() == getComplementB());
      }
      equals &= obj.isSetListOfCSGNodes() == isSetListOfCSGNodes();
      if (equals && isSetListOfCSGNodes()) {
        equals &= obj.getListOfCSGNodes().equals(getListOfCSGNodes());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public CSGSetOperator clone() {
    return new CSGSetOperator(this);
  }

  /**
   * Returns the value of {@link operationType}.
   *  
   * @return the value of {@link operationType}.
   */
  public SetOperation getOperationType() {
    if (isSetOperationType()) {
      return operationType;
    }
    throw new PropertyUndefinedError(SpatialConstants.operationType, this);
  }

  /**
   * Returns the value of {@link complementA}.
   *  
   * @return the value of {@link complementA}.
   */
  public String getComplementA() {
    return isSetComplementA() ? complementA : "";
  }

  /**
   * Returns the value of {@link complementB}.
   *  
   * @return the value of {@link complementB}.
   */
  public String getComplementB() {
    return isSetComplementB() ? complementB : "";
  }

  /**
   * Returns whether {@link operationType} is set.
   *  
   * @return whether {@link operationType} is set.
   */
  public boolean isSetOperationType() {
    return this.operationType != null;
  }

  /**
   * Returns whether {@link complementA} is set.
   *  
   * @return whether {@link complementA} is set.
   */
  public boolean isSetComplementA() {
    return this.complementA != null;
  }

  /**
   * Returns whether {@link complementB} is set.
   *  
   * @return whether {@link complementB} is set.
   */
  public boolean isSetComplementB() {
    return this.complementB != null;
  }

  /**
   * Sets the value of operationType
   *  
   * @param operationType the value of operationType to be set.
   */
  public boolean setOperationType(SetOperation operationType) {
    if (operationType != this.operationType) {
      SetOperation oldOperationType = this.operationType;
      this.operationType = operationType;
      firePropertyChange(SpatialConstants.operationType, oldOperationType,
        this.operationType);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of complementA
   *  
   * @param complementA the value of complementA to be set.
   */
  public boolean setComplementA(String complementA) {
    if (complementA != this.complementA) {
      String oldComplementA = this.complementA;
      this.complementA = complementA;
      firePropertyChange(SpatialConstants.complementA, oldComplementA,
        this.complementA);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of complementB
   *  
   * @param complementB the value of complementB to be set.
   */
  public boolean setComplementB(String complementB) {
    if (complementB != this.complementB) {
      String oldComplementB = this.complementB;
      this.complementB = complementB;
      firePropertyChange(SpatialConstants.complementB, oldComplementB,
        this.complementB);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable operationType.
   *  
   * @return {@code true} if operationType was set before, otherwise {@code
   * false}.
   */
  public boolean unsetOperationType() {
    if (isSetOperationType()) {
      SetOperation oldOperationType = operationType;
      operationType = null;
      firePropertyChange(SpatialConstants.operationType, oldOperationType,
        operationType);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable complementA.
   *  
   * @return {@code true} if complementA was set before, otherwise {@code
   * false}.
   */
  public boolean unsetComplementA() {
    if (isSetComplementA()) {
      String oldComplementA = complementA;
      complementA = null;
      firePropertyChange(SpatialConstants.complementA, oldComplementA,
        complementA);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable complementB.
   *  
   * @return {@code true} if complementB was set before, otherwise {@code
   * false}.
   */
  public boolean unsetComplementB() {
    if (isSetComplementB()) {
      String oldComplementB = complementB;
      complementB = null;
      firePropertyChange(SpatialConstants.complementB, oldComplementB,
        complementB);
      return true;
    }
    return false;
  }

  /**
   * @param csgNode
   * the csgNode to add
   * @return
   */
  public boolean addCSGNode(CSGNode csgNode) {
    return getListOfCSGNodes().add(csgNode);
  }

  /**
   * Removes an element from the {@link #listOfCSGNodes}
   *  
   * @param CSGNode the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeCSGNode(CSGNode csgNode) {
    if (isSetListOfCSGNodes()) {
      return getListOfCSGNodes().remove(csgNode);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfCSGNodes}
   *  
   * @param i the index where to remove the {@link CSGNode}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfCSGNodes)})
   */
  public CSGNode removeCSGNode(int i) {
    if (isSetListOfCSGNodes()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfCSGNodes().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfCSGNodes}.
   *  
   * @param csgNodeId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public CSGNode removeCSGNode(String csgNodeId) {
    if (isSetListOfCSGNodes()) {
      return getListOfCSGNodes().remove(csgNodeId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfCSGNodes}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfCSGNodes}.
   */
  public ListOf<CSGNode> getListOfCSGNodes() {
    if (listOfCSGNodes == null) {
      listOfCSGNodes = new ListOf<CSGNode>();
      listOfCSGNodes.setNamespace(SpatialConstants.namespaceURI);
      listOfCSGNodes.setSBaseListType(ListOf.Type.other);
      registerChild(listOfCSGNodes);
    }
    return listOfCSGNodes;
  }

  /**
   * Creates a new CSGPrimitive element and adds it to the
   * {@link listOfCSGPrimitives} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGPrimitives}
   */
  public CSGPrimitive createCSGPrimitive() {
  }

  /**
   * Creates a new CSGTranslation element and adds it to the
   * {@link listOfCSGTranslations} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGTranslations}
   */
  public CSGTranslation createCSGTranslation() {
  }

  /**
   * Creates a new CSGRotation element and adds it to the
   * {@link listOfCSGRotations} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGRotations}
   */
  public CSGRotation createCSGRotation() {
  }

  /**
   * Creates a new CSGScale element and adds it to the
   * {@link listOfCSGScales} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGScales}
   */
  public CSGScale createCSGScale() {
  }

  /**
   * Creates a new CSGHomogeneousTransformation element and adds it to the
   * {@link listOfCSGHomogeneousTransformations} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGHomogeneousTransformations}
   */
  public CSGHomogeneousTransformation createCSGHomogeneousTransformation() {
  }

  /**
   * Creates a new CSGPseudoPrimitive element and adds it to the
   * {@link listOfCSGPseudoPrimitives} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGPseudoPrimitives}
   */
  public CSGPseudoPrimitive createCSGPseudoPrimitive() {
  }

  /**
   * Creates a new CSGSetOperator element and adds it to the
   * {@link listOfCSGSetOperators} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfCSGSetOperators}
   */
  public CSGSetOperator createCSGSetOperator() {
  }

  /**
   * Returns the number of {@link CSGNode}s in this
   * {@link Spatial}.
   *  
   * @return the number of {@link CSGNode}s in this {@link CSGNode}.
   * @libsbml.deprecated same as {@link #getCSGNodeCount()}
   */
  @Deprecated
  public int getNumCSGNodes() {
    return getCSGNodeCount();
  }

  /**
   * Returns the number of {@link CSGNode}s in this {@link Spatial}.
   *  
   * @return the number of {@link CSGNode}s in this {@link CSGNode}.
   * @libsbml.deprecated same as {@link #getCSGNodeCount()}
   */
  public int getCSGNodeCount() {
    return isSetListOfCSGNodes() ? getListOfCSGNodes().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfCSGNodes} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfCSGNodes} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfCSGNodes() {
    if ((listOfCSGNodes == null) || listOfCSGNodes.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<CSGNode>}.
   * If {@link listOfCSGNodes} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfCSGNodes
   */
  public void setListOfCSGNodes(ListOf<CSGNode> listOfCSGNodes) {
    unsetListOfCSGNodes();
    this.listOfCSGNodes = listOfCSGNodes;
    this.listOfCSGNodes.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfCSGNodes);
  }

  /**
   * Returns {@code true} if {@link listOfCSGNodes} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfCSGNodes} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfCSGNodes() {
    if (isSetListOfCSGNodes()) {
      ListOf<CSGNode> oldCSGNode = this.listOfCSGNodes;
      this.listOfCSGNodes = null;
      oldCSGNode.fireNodeRemovedEvent();
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

    if (isSetListOfCsgNodes()) {
      if (pos == index) {
        return getListOfCsgNodes();
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

    if (isSetListOfCsgNodes()) {
      count++;
    }
    return count;
  }

  /* hashcode method for CSGSetOperator.
   */
  @Override
  public int hashCode() {
    final int prime = 4910239;

    int hashCode = super.hashCode();

    if (isSetOperationType()) {
      hashCode += prime * getOperationType().hashCode();
    }
    if (isSetComplementA()) {
      hashCode += prime * getComplementA().hashCode();
    }
    if (isSetComplementB()) {
      hashCode += prime * getComplementB().hashCode();
    }
    hashCode = prime * hashCode + ((listOfCSGNodes == null) ? 0 :
      listOfCSGNodes.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CSGSetOperator [");
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

      if (attributeName.equals(SpatialConstants.operationType)) {
        try {
          setOperationType(SetOperation.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + SpatialConstants.operationType + " on the 'CSGSetOperator'
              element.");
        }
      }      else if (attributeName.equals(SpatialConstants.complementA)) {
        setComplementA(value);
      }      else if (attributeName.equals(SpatialConstants.complementB)) {
        setComplementB(value);
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

    if (isSetOperationType()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.operationType,
        getOperationType().toString());
    }
    if (isSetComplementA()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.complementA,
        getComplementA());
    }
    if (isSetComplementB()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.complementB,
        getComplementB());
    }
    return attributes;
  }

}
