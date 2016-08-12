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
package org.sbml.jsbml.ext.fbc;

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
public class FbcAnd extends Association {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 221752935164838L;
  /**
   *
   */
  private ListOf<Association> listOfAssociations;

  /**
   *  
   */
  public FbcAnd() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public FbcAnd(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public FbcAnd(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public FbcAnd(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public FbcAnd(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the FbcAnd instance to copy.
   */
  public FbcAnd(FbcAnd orig) {
    super(orig);

    if (orig.isSetListOfAssociations()) {
      setListOfAssociations(orig.getListOfAssociations().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    listOfAssociations = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      FbcAnd obj = (FbcAnd) object;

      equals &= obj.isSetListOfAssociations() == isSetListOfAssociations();
      if (equals && isSetListOfAssociations()) {
        equals &= obj.getListOfAssociations().equals(getListOfAssociations());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public FbcAnd clone() {
    return new FbcAnd(this);
  }

  /**
   * @param association
   * the association to add
   * @return
   */
  public boolean addAssociation(Association association) {
    return getListOfAssociations().add(association);
  }

  /**
   * Removes an element from the {@link listOfAssociations}
   *  
   * @param Association the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeAssociation(Association association) {
    if (isSetListOfAssociations()) {
      return getListOfAssociations().remove(association);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfAssociations}
   *  
   * @param i the index where to remove the {@link Association}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfAssociations)})
   */
  public Association removeAssociation(int i) {
    if (isSetListOfAssociations()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfAssociations().remove(i);
  }

  /**
   * Returns the {@link listOfAssociations}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfAssociations}.
   */
  public ListOf<Association> getListOfAssociations() {
    if (listOfAssociations == null) {
      listOfAssociations = new ListOf<Association>();
      listOfAssociations.setNamespace(FbcConstants.namespaceURI);
      listOfAssociations.setSBaseListType(ListOf.Type.other);
      registerChild(listOfAssociations);
    }
    return listOfAssociations;
  }

  /**
   * Creates a new FbcAnd element and adds it to the
   * {@link listOfFbcAnds} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfFbcAnds}
   */
  public FbcAnd createAnd() {
  }

  /**
   * Creates a new FbcOr element and adds it to the
   * {@link listOfFbcOrs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfFbcOrs}
   */
  public FbcOr createOr() {
  }

  /**
   * Creates a new GeneProductRef element and adds it to the
   * {@link listOfGeneProductRefs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfGeneProductRefs}
   */
  public GeneProductRef createGeneProductRef() {
  }

  /**
   * Returns the number of {@link Association}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link Association}s in this {@link Association}.
   * @libsbml.deprecated same as {@link #getAssociationCount()}
   */
  @Deprecated
  public int getNumAssociations() {
    return getAssociationCount();
  }

  /**
   * Returns the number of {@link Association}s in this {@link Fbc}.
   *  
   * @return the number of {@link Association}s in this {@link Association}.
   * @libsbml.deprecated same as {@link #getAssociationCount()}
   */
  public int getAssociationCount() {
    return isSetListOfAssociations() ? getListOfAssociations().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfAssociations} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfAssociations} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfAssociations() {
    if ((listOfAssociations == null) || listOfAssociations.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<Association>}.
   * If {@link listOfAssociations} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfAssociations
   */
  public void setListOfAssociations(ListOf<Association> listOfAssociations) {
    unsetListOfAssociations();
    this.listOfAssociations = listOfAssociations;
    this.listOfAssociations.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfAssociations);
  }

  /**
   * Returns {@code true} if {@link listOfAssociations} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfAssociations} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfAssociations() {
    if (isSetListOfAssociations()) {
      ListOf<Association> oldAssociation = this.listOfAssociations;
      this.listOfAssociations = null;
      oldAssociation.fireNodeRemovedEvent();
      return true;
    }
    return false;
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

    if (isSetListOfAssociations()) {
      count++;
    }
    return count;
  }

  /* hashcode method for FbcAnd.
   */
  @Override
  public int hashCode() {
    final int prime = 5417179;

    int hashCode = super.hashCode();

    if (isSetAssociation()) {
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
    builder.append("FbcAnd [");
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
