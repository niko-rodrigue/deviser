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
package org.sbml.jsbml.ext.qual;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.ext.AbstractSBasePlugin;
import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class QualModelPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 42311250780349641L;
  /**
   *
   */
  private ListOf<QualitativeSpecies> listOfQualitativeSpecies;
  /**
   *
   */
  private ListOf<Transition> listOfTransitions;

  /**
   * @param model the QualModelPlugin instance to copy.
   */
  public QualModelPlugin(Model model) {
    super(model);

  }

  /**
   * @param qualModel the QualModelPlugin instance to copy.
   */
  public QualModelPlugin(QualModelPlugin qualModel) {
    super(qualModel);

    if (qualModel.isSetListOfQualitativeSpecies()) {
      setListOfQualitativeSpecies(qualModel.getListOfQualitativeSpecies().clone());
    }
    if (qualModel.isSetListOfTransitions()) {
      setListOfTransitions(qualModel.getListOfTransitions().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public QualModelPlugin clone() {
    return new QualModelPlugin(this);
  }

  /**
   * @param listOfQualitativeSpecies
   * the listOfQualitativeSpecies to add
   * @return
   */
  public boolean addQualitativeSpecies(QualitativeSpecies    listOfQualitativeSpecies) {
    return getListOfQualitativeSpecies().add(listOfQualitativeSpecies);
  }

  /**
   * @param listOfTransitions
   * the listOfTransitions to add
   * @return
   */
  public boolean addTransitions(Transition listOfTransitions) {
    return getListOfTransitions().add(listOfTransitions);
  }

  /**
   * Removes an element from the {@link #listOfQualitativeSpeciess}
   *  
   * @param QualitativeSpecies the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeQualitativeSpecies(QualitativeSpecies    listOfQualitativeSpecies) {
    if (isSetListOfQualitativeSpecies()) {
      return getListOfQualitativeSpecies().remove(listOfQualitativeSpecies);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfTransitionss}
   *  
   * @param Transitions the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeTransitions(Transition listOfTransitions) {
    if (isSetListOfTransitions()) {
      return getListOfTransitions().remove(listOfTransitions);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfQualitativeSpeciess}
   *  
   * @param i the index where to remove the {@link QualitativeSpecies}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfQualitativeSpeciess)})
   */
  public QualitativeSpecies removeQualitativeSpecies(int i) {
    if (isSetListOfQualitativeSpecies()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfQualitativeSpecies().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfTransitionss}
   *  
   * @param i the index where to remove the {@link Transitions}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfTransitionss)})
   */
  public Transition removeTransitions(int i) {
    if (isSetListOfTransitions()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfTransitions().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfQualitativeSpeciess}.
   *  
   * @param listOfQualitativeSpeciesId the id of the element to be removed from
   * the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public QualitativeSpecies removeQualitativeSpecies(String    listOfQualitativeSpeciesId) {
    if (isSetListOfQualitativeSpecies()) {
      return getListOfQualitativeSpecies().remove(listOfQualitativeSpeciesId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfQualitativeSpecies}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfQualitativeSpecies}.
   */
  public ListOf<QualitativeSpecies> getListOfQualitativeSpecies() {
    if (listOfQualitativeSpecies == null) {
      listOfQualitativeSpecies = new ListOf<QualitativeSpecies>();
      listOfQualitativeSpecies.setNamespace(QualConstants.namespaceURI);
      listOfQualitativeSpecies.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfQualitativeSpecies);
    }
     ;
    return listOfQualitativeSpecies;
  }

  /**
   * Returns the {@link listOfTransitions}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfTransitions}.
   */
  public ListOf<Transition> getListOfTransitions() {
    if (listOfTransitions == null) {
      listOfTransitions = new ListOf<Transition>();
      listOfTransitions.setNamespace(QualConstants.namespaceURI);
      listOfTransitions.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfTransitions);
    }
     ;
    return listOfTransitions;
  }

  /**
   * Creates a new QualitativeSpecies element and adds it to the
   * {@link listOfQualitativeSpeciess} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfQualitativeSpeciess}
   */
  public QualitativeSpecies createQualitativeSpecies() {
    QualitativeSpecies qualitativeSpecies = new QualitativeSpecies(getLevel(),
      getVersion());
    return addQualitativeSpecies(qualitativeSpecies) ? qualitativeSpecies :
      null;
  }

  /**
   * Creates a new Transitions element and adds it to the
   * {@link listOfTransitionss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfTransitionss}
   */
  public Transition createTransitions() {
    Transition transitions = new Transition(getLevel(), getVersion());
    return addTransitions(transitions) ? transitions : null;
  }

  /**
   * Returns the number of {@link QualitativeSpecies}s in this
   * {@link Qual}.
   *  
   * @return the number of {@link QualitativeSpecies}s in this {@link
   * QualitativeSpecies}.
   * @libsbml.deprecated same as {@link #getQualitativeSpeciesCount()}
   */
  @Deprecated
  public int getNumQualitativeSpecies() {
    return getQualitativeSpeciesCount();
  }

  /**
   * Returns the number of {@link Transitions}s in this
   * {@link Qual}.
   *  
   * @return the number of {@link Transitions}s in this {@link Transitions}.
   * @libsbml.deprecated same as {@link #getTransitionsCount()}
   */
  @Deprecated
  public int getNumTransitions() {
    return getTransitionsCount();
  }

  /**
   * Returns the number of {@link QualitativeSpecies}s in this {@link Qual}.
   *  
   * @return the number of {@link QualitativeSpecies}s in this {@link
   * QualitativeSpecies}.
   * @libsbml.deprecated same as {@link #getQualitativeSpeciesCount()}
   */
  public int getQualitativeSpeciesCount() {
    return isSetListOfQualitativeSpecies() ?
      getListOfQualitativeSpecies().size() : 0;
  }

  /**
   * Returns the number of {@link Transitions}s in this {@link Qual}.
   *  
   * @return the number of {@link Transitions}s in this {@link Transitions}.
   * @libsbml.deprecated same as {@link #getTransitionsCount()}
   */
  public int getTransitionsCount() {
    return isSetListOfTransitions() ? getListOfTransitions().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfQualitativeSpecies} contains at least
   * one element.
   *  
   * @return {@code true} if {@link listOfQualitativeSpecies} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean isSetListOfQualitativeSpecies() {
    if ((listOfQualitativeSpecies == null) ||      listOfQualitativeSpecies.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfTransitions} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfTransitions} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfTransitions() {
    if ((listOfTransitions == null) || listOfTransitions.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<QualitativeSpecies>}.
   * If {@link listOfQualitativeSpecies} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfQualitativeSpecies
   */
  public void setListOfQualitativeSpecies(ListOf<QualitativeSpecies>    listOfQualitativeSpecies) {
    unsetListOfQualitativeSpecies();
    this.listOfQualitativeSpecies = listOfQualitativeSpecies;
    this.listOfQualitativeSpecies.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfQualitativeSpecies);
    }
  }

  /**
   * Sets the given {@code ListOf<Transitions>}.
   * If {@link listOfTransitions} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfTransitions
   */
  public void setListOfTransitions(ListOf<Transition> listOfTransitions) {
    unsetListOfTransitions();
    this.listOfTransitions = listOfTransitions;
    this.listOfTransitions.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfTransitions);
    }
  }

  /**
   * Returns {@code true} if {@link listOfQualitativeSpecies} contains at least
   * one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfQualitativeSpecies} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean unsetListOfQualitativeSpecies() {
    if (isSetListOfQualitativeSpecies()) {
      ListOf<QualitativeSpecies> oldQualitativeSpecies =
        this.listOfQualitativeSpecies;
      this.listOfQualitativeSpecies = null;
      oldQualitativeSpecies.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfTransitions} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfTransitions} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfTransitions() {
    if (isSetListOfTransitions()) {
      ListOf<Transition> oldTransitions = this.listOfTransitions;
      this.listOfTransitions = null;
      oldTransitions.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return QualConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return QualConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getURI()
   */
  @Override
  public String getURI() {
    return getElementNamespace();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getParent()
   */
  @Override
  public SBMLDocument getParent() {
    if (isSetExtendedSBase()) {
      return (SBMLDocument) getExtendedSBase().getParent();
    }
    return null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getParentSBMLObject()
   */
  @Override
  public SBMLDocument getParentSBMLObject() {
    return getParent();
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
    int pos = 0;

    if (isSetListOfQualitativeSpecies()) {
      if (pos == index) {
        return getListOfQualitativeSpecies();
      }
      pos++;
    }
    if (isSetListOfTransitions()) {
      if (pos == index) {
        return getListOfTransitions();
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
    int count = 0;

    if (isSetListOfQualitativeSpecies()) {
      count++;
    }
    if (isSetListOfTransitions()) {
      count++;
    }
    return count;
  }

  /* hashcode method for QualModelPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 3865523;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfQualitativeSpecies == null) ? 0 :
      listOfQualitativeSpecies.hashCode());

    hashCode = prime * hashCode + ((listOfTransitions == null) ? 0 :
      listOfTransitions.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("QualModelPlugin [");
    builder.append("listOfQualitativeSpecies = ");
    builder.append(listOfQualitativeSpecies);
    builder.append(", ");
    builder.append("listOfTransitions = ");
    builder.append(listOfTransitions);
    return builder.toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = false;

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
