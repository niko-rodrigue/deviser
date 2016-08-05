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
public class FbcModelPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 70608148676002013L;
  /**
   *
   */
  private ListOf<FluxBound> listOfFluxBounds;
  /**
   *
   */
  private ListOf<Objective> listOfObjectives;

  /**
   * @param model the FbcModelPlugin instance to copy.
   */
  public FbcModelPlugin(Model model) {
    super(model);

  }

  /**
   * @param fbcModel the FbcModelPlugin instance to copy.
   */
  public FbcModelPlugin(FbcModelPlugin fbcModel) {
    super(fbcModel);

    if (fbcModel.isSetListOfFluxBounds()) {
      setListOfFluxBounds(fbcModel.getListOfFluxBounds().clone());
    }
    if (fbcModel.isSetListOfObjectives()) {
      setListOfObjectives(fbcModel.getListOfObjectives().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public FbcModelPlugin clone() {
    return new FbcModelPlugin(this);
  }

  /**
   * @param listOfFluxBounds
   * the listOfFluxBounds to add
   * @return
   */
  public boolean addFluxBounds(FluxBound listOfFluxBounds) {
    return getListOfFluxBounds().add(listOfFluxBounds);
  }

  /**
   * @param listOfObjectives
   * the listOfObjectives to add
   * @return
   */
  public boolean addObjectives(Objective listOfObjectives) {
    return getListOfObjectives().add(listOfObjectives);
  }

  /**
   * Removes an element from the {@link #listOfFluxBoundss}
   *  
   * @param FluxBounds the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeFluxBounds(FluxBound listOfFluxBounds) {
    if (isSetListOfFluxBounds()) {
      return getListOfFluxBounds().remove(listOfFluxBounds);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfObjectivess}
   *  
   * @param Objectives the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeObjectives(Objective listOfObjectives) {
    if (isSetListOfObjectives()) {
      return getListOfObjectives().remove(listOfObjectives);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfFluxBoundss}
   *  
   * @param i the index where to remove the {@link FluxBounds}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfFluxBoundss)})
   */
  public FluxBound removeFluxBounds(int i) {
    if (isSetListOfFluxBounds()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfFluxBounds().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfObjectivess}
   *  
   * @param i the index where to remove the {@link Objectives}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfObjectivess)})
   */
  public Objective removeObjectives(int i) {
    if (isSetListOfObjectives()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfObjectives().remove(i);
  }

  /**
   * Returns the {@link listOfFluxBounds}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfFluxBounds}.
   */
  public ListOf<FluxBound> getListOfFluxBounds() {
    if (listOfFluxBounds == null) {
      listOfFluxBounds = new ListOf<FluxBound>();
      listOfFluxBounds.setNamespace(FbcConstants.namespaceURI);
      listOfFluxBounds.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfFluxBounds);
    }
     ;
    return listOfFluxBounds;
  }

  /**
   * Returns the {@link listOfObjectives}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfObjectives}.
   */
  public ListOf<Objective> getListOfObjectives() {
    if (listOfObjectives == null) {
      listOfObjectives = new ListOf<Objective>();
      listOfObjectives.setNamespace(FbcConstants.namespaceURI);
      listOfObjectives.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfObjectives);
    }
     ;
    return listOfObjectives;
  }

  /**
   * Creates a new FluxBounds element and adds it to the
   * {@link listOfFluxBoundss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfFluxBoundss}
   */
  public FluxBound createFluxBounds() {
    FluxBound fluxBounds = new FluxBound(getLevel(), getVersion());
    return addFluxBounds(fluxBounds) ? fluxBounds : null;
  }

  /**
   * Creates a new Objectives element and adds it to the
   * {@link listOfObjectivess} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfObjectivess}
   */
  public Objective createObjectives() {
    Objective objectives = new Objective(getLevel(), getVersion());
    return addObjectives(objectives) ? objectives : null;
  }

  /**
   * Returns the number of {@link FluxBounds}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link FluxBounds}s in this {@link FluxBounds}.
   * @libsbml.deprecated same as {@link #getFluxBoundsCount()}
   */
  @Deprecated
  public int getNumFluxBounds() {
    return getFluxBoundsCount();
  }

  /**
   * Returns the number of {@link Objectives}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link Objectives}s in this {@link Objectives}.
   * @libsbml.deprecated same as {@link #getObjectivesCount()}
   */
  @Deprecated
  public int getNumObjectives() {
    return getObjectivesCount();
  }

  /**
   * Returns the number of {@link FluxBounds}s in this {@link Fbc}.
   *  
   * @return the number of {@link FluxBounds}s in this {@link FluxBounds}.
   * @libsbml.deprecated same as {@link #getFluxBoundsCount()}
   */
  public int getFluxBoundsCount() {
    return isSetListOfFluxBounds() ? getListOfFluxBounds().size() : 0;
  }

  /**
   * Returns the number of {@link Objectives}s in this {@link Fbc}.
   *  
   * @return the number of {@link Objectives}s in this {@link Objectives}.
   * @libsbml.deprecated same as {@link #getObjectivesCount()}
   */
  public int getObjectivesCount() {
    return isSetListOfObjectives() ? getListOfObjectives().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfFluxBounds} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfFluxBounds} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfFluxBounds() {
    if ((listOfFluxBounds == null) || listOfFluxBounds.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfObjectives} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfObjectives} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfObjectives() {
    if ((listOfObjectives == null) || listOfObjectives.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<FluxBounds>}.
   * If {@link listOfFluxBounds} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfFluxBounds
   */
  public void setListOfFluxBounds(ListOf<FluxBound> listOfFluxBounds) {
    unsetListOfFluxBounds();
    this.listOfFluxBounds = listOfFluxBounds;
    this.listOfFluxBounds.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfFluxBounds);
    }
  }

  /**
   * Sets the given {@code ListOf<Objectives>}.
   * If {@link listOfObjectives} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfObjectives
   */
  public void setListOfObjectives(ListOf<Objective> listOfObjectives) {
    unsetListOfObjectives();
    this.listOfObjectives = listOfObjectives;
    this.listOfObjectives.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfObjectives);
    }
  }

  /**
   * Returns {@code true} if {@link listOfFluxBounds} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfFluxBounds} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfFluxBounds() {
    if (isSetListOfFluxBounds()) {
      ListOf<FluxBound> oldFluxBounds = this.listOfFluxBounds;
      this.listOfFluxBounds = null;
      oldFluxBounds.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfObjectives} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfObjectives} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfObjectives() {
    if (isSetListOfObjectives()) {
      ListOf<Objective> oldObjectives = this.listOfObjectives;
      this.listOfObjectives = null;
      oldObjectives.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return FbcConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return FbcConstants.shortLabel;
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

    if (isSetListOfFluxBounds()) {
      if (pos == index) {
        return getListOfFluxBounds();
      }
      pos++;
    }
    if (isSetListOfObjectives()) {
      if (pos == index) {
        return getListOfObjectives();
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

    if (isSetListOfFluxBounds()) {
      count++;
    }
    if (isSetListOfObjectives()) {
      count++;
    }
    return count;
  }

  /* hashcode method for FbcModelPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 882961;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfFluxBounds == null) ? 0 :
      listOfFluxBounds.hashCode());

    hashCode = prime * hashCode + ((listOfObjectives == null) ? 0 :
      listOfObjectives.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("FbcModelPlugin [");
    builder.append("listOfFluxBounds = ");
    builder.append(listOfFluxBounds);
    builder.append(", ");
    builder.append("listOfObjectives = ");
    builder.append(listOfObjectives);
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
