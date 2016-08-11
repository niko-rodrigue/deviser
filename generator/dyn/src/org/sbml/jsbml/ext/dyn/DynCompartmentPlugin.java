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
package org.sbml.jsbml.ext.dyn;

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
public class DynCompartmentPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 35360407176978105L;
  /**
   *
   */
  private ListOf<SpatialComponent> listOfSpatialComponents;

  /**
   * @param model the DynCompartmentPlugin instance to copy.
   */
  public DynCompartmentPlugin(Model model) {
    super(model);

  }

  /**
   * @param dynModel the DynCompartmentPlugin instance to copy.
   */
  public DynCompartmentPlugin(DynCompartmentPlugin dynModel) {
    super(dynModel);

    if (dynModel.isSetListOfSpatialComponents()) {
      setListOfSpatialComponents(dynModel.getListOfSpatialComponents().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public DynCompartmentPlugin clone() {
    return new DynCompartmentPlugin(this);
  }

  /**
   * @param listOfSpatialComponents
   * the listOfSpatialComponents to add
   * @return
   */
  public boolean addSpatialComponents(SpatialComponent listOfSpatialComponents) {
    return getListOfSpatialComponents().add(listOfSpatialComponents);
  }

  /**
   * Removes an element from the {@link #listOfSpatialComponentss}
   *  
   * @param SpatialComponents the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeSpatialComponents(SpatialComponent    listOfSpatialComponents) {
    if (isSetListOfSpatialComponents()) {
      return getListOfSpatialComponents().remove(listOfSpatialComponents);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfSpatialComponentss}
   *  
   * @param i the index where to remove the {@link SpatialComponents}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfSpatialComponentss)})
   */
  public SpatialComponent removeSpatialComponents(int i) {
    if (isSetListOfSpatialComponents()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfSpatialComponents().remove(i);
  }

  /**
   * Returns the {@link listOfSpatialComponents}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfSpatialComponents}.
   */
  public ListOf<SpatialComponent> getListOfSpatialComponents() {
    if (listOfSpatialComponents == null) {
      listOfSpatialComponents = new ListOf<SpatialComponent>();
      listOfSpatialComponents.setNamespace(DynConstants.namespaceURI);
      listOfSpatialComponents.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfSpatialComponents);
    }
     ;
    return listOfSpatialComponents;
  }

  /**
   * Creates a new SpatialComponents element and adds it to the
   * {@link listOfSpatialComponentss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfSpatialComponentss}
   */
  public SpatialComponent createSpatialComponents() {
    SpatialComponent spatialComponents = new SpatialComponent(getLevel(),
      getVersion());
    return addSpatialComponents(spatialComponents) ? spatialComponents : null;
  }

  /**
   * Returns the number of {@link SpatialComponents}s in this
   * {@link Dyn}.
   *  
   * @return the number of {@link SpatialComponents}s in this {@link
   * SpatialComponents}.
   * @libsbml.deprecated same as {@link #getSpatialComponentsCount()}
   */
  @Deprecated
  public int getNumSpatialComponents() {
    return getSpatialComponentsCount();
  }

  /**
   * Returns the number of {@link SpatialComponents}s in this {@link Dyn}.
   *  
   * @return the number of {@link SpatialComponents}s in this {@link
   * SpatialComponents}.
   * @libsbml.deprecated same as {@link #getSpatialComponentsCount()}
   */
  public int getSpatialComponentsCount() {
    return isSetListOfSpatialComponents() ? getListOfSpatialComponents().size()
      : 0;
  }

  /**
   * Returns {@code true} if {@link listOfSpatialComponents} contains at least
   * one element.
   *  
   * @return {@code true} if {@link listOfSpatialComponents} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean isSetListOfSpatialComponents() {
    if ((listOfSpatialComponents == null) || listOfSpatialComponents.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<SpatialComponents>}.
   * If {@link listOfSpatialComponents} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfSpatialComponents
   */
  public void setListOfSpatialComponents(ListOf<SpatialComponent>    listOfSpatialComponents) {
    unsetListOfSpatialComponents();
    this.listOfSpatialComponents = listOfSpatialComponents;
    this.listOfSpatialComponents.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfSpatialComponents);
    }
  }

  /**
   * Returns {@code true} if {@link listOfSpatialComponents} contains at least
   * one element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfSpatialComponents} contains at least
   * one element, otherwise {@code false}.
   */
  public boolean unsetListOfSpatialComponents() {
    if (isSetListOfSpatialComponents()) {
      ListOf<SpatialComponent> oldSpatialComponents =
        this.listOfSpatialComponents;
      this.listOfSpatialComponents = null;
      oldSpatialComponents.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return DynConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return DynConstants.shortLabel;
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

    if (isSetListOfSpatialComponents()) {
      if (pos == index) {
        return getListOfSpatialComponents();
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

    if (isSetListOfSpatialComponents()) {
      count++;
    }
    return count;
  }

  /* hashcode method for DynCompartmentPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 25873;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfSpatialComponents == null) ? 0 :
      listOfSpatialComponents.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DynCompartmentPlugin [");
    builder.append("listOfSpatialComponents = ");
    builder.append(listOfSpatialComponents);
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
