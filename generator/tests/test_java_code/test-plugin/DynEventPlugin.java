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
import java.util.TreeMap;
import javax.swing.tree.TreeNode;
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
public class DynEventPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 9891207272440019L;
  /**
   *
   */
  private Boolean applyToAll;
  /**
   *
   */
  private ListOf<DynElement> listOfDynElements;

  /**
   * @param event the DynEventPlugin instance to copy.
   */
  public DynEventPlugin(Event event) {
    super(event);

  }

  /**
   * @param dynEvent the DynEventPlugin instance to copy.
   */
  public DynEventPlugin(DynEventPlugin dynEvent) {
    super(dynEvent);

    if (dynEvent.isSetApplyToAll()) {
      setApplyToAll(dynEvent.getApplyToAll());
    }
    if (dynEvent.isSetListOfDynElements()) {
      setListOfDynElements(dynEvent.getListOfDynElements().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public DynEventPlugin clone() {
    return new DynEventPlugin(this);
  }

  /**
   * Returns the value of {@link applyToAll}.
   *  
   * @return the value of {@link applyToAll}.
   */
  public boolean getApplyToAll() {
    if (isSetApplyToAll()) {
      return applyToAll.booleanValue();
    }
    throw new PropertyUndefinedError(DynConstants.applyToAll, this);
  }

  /**
   * Returns whether {@link applyToAll} is set.
   *  
   * @return whether {@link applyToAll} is set.
   */
  public boolean isSetApplyToAll() {
    return this.applyToAll != null;
  }

  /**
   * Sets the value of applyToAll
   *  
   * @param applyToAll the value of applyToAll to be set.
   */
  public boolean setApplyToAll(boolean applyToAll) {
    if (applyToAll != this.applyToAll) {
      Boolean oldApplyToAll = this.applyToAll;
      this.applyToAll = applyToAll;
      firePropertyChange(DynConstants.applyToAll, oldApplyToAll,
        this.applyToAll);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable applyToAll.
   *  
   * @return {@code true} if applyToAll was set before, otherwise {@code
   * false}.
   */
  public boolean unsetApplyToAll() {
    if (isSetApplyToAll()) {
      Boolean oldApplyToAll = applyToAll;
      applyToAll = null;
      firePropertyChange(DynConstants.applyToAll, oldApplyToAll, applyToAll);
      return true;
    }
    return false;
  }

  /**
   * @param dynElement
   * the dynElement to add
   * @return
   */
  public boolean addDynElement(DynElement dynElement) {
    return getListOfDynElements().add(dynElement);
  }

  /**
   * Removes an element from the {@link listOfDynElements}
   *  
   * @param DynElement the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeDynElement(DynElement dynElement) {
    if (isSetListOfDynElements()) {
      return getListOfDynElements().remove(dynElement);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfDynElements}
   *  
   * @param i the index where to remove the {@link DynElement}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfDynElements)})
   */
  public DynElement removeDynElement(int i) {
    if (isSetListOfDynElements()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfDynElements().remove(i);
  }

  /**
   * Removes an element from the {@link listOfDynElements}.
   *  
   * @param listOfDynElementsId the id of the element to be removed from the
   * list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public DynElement removeDynElement(String listOfDynElementsId) {
    if (isSetListOfDynElements()) {
      return getListOfDynElements().remove(listOfDynElementsId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfDynElements}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfDynElements}.
   */
  public ListOf<DynElement> getListOfDynElements() {
    if (listOfDynElements == null) {
      listOfDynElements = new ListOf<DynElement>();
      listOfDynElements.setNamespace(DynConstants.namespaceURI);
      listOfDynElements.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfDynElements);
    }
     ;
    return listOfDynElements;
  }

  /**
   * Creates a new DynElement element and adds it to the
   * {@link listOfDynElements} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfDynElements}
   */
  public DynElement createDynElement() {
    DynElement dynElement = new DynElement(getLevel(), getVersion());
    return addDynElement(dynElement) ? dynElement : null;
  }

  /**
   * Returns the number of {@link DynElement}s in this
   * {@link Dyn}.
   *  
   * @return the number of {@link DynElement}s in this {@link DynElement}.
   * @libsbml.deprecated same as {@link #getDynElementCount()}
   */
  @Deprecated
  public int getNumDynElements() {
    return getDynElementCount();
  }

  /**
   * Returns the number of {@link DynElement}s in this {@link Dyn}.
   *  
   * @return the number of {@link DynElement}s in this {@link DynElement}.
   * @libsbml.deprecated same as {@link #getDynElementCount()}
   */
  public int getDynElementCount() {
    return isSetListOfDynElements() ? getListOfDynElements().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfDynElements} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfDynElements} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfDynElements() {
    if ((listOfDynElements == null) || listOfDynElements.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<DynElement>}.
   * If {@link listOfDynElements} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfDynElements
   */
  public void setListOfDynElements(ListOf<DynElement> listOfDynElements) {
    unsetListOfDynElements();
    this.listOfDynElements = listOfDynElements;
    this.listOfDynElements.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfDynElements);
    }
  }

  /**
   * Returns {@code true} if {@link listOfDynElements} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfDynElements} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfDynElements() {
    if (isSetListOfDynElements()) {
      ListOf<DynElement> oldDynElement = this.listOfDynElements;
      this.listOfDynElements = null;
      oldDynElement.fireNodeRemovedEvent();
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

    if (isSetListOfDynElements()) {
      if (pos == index) {
        return getListOfDynElements();
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

    if (isSetListOfDynElements()) {
      count++;
    }
    return count;
  }

  /* hashcode method for DynEventPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 5861929;

    int hashCode = super.hashCode();

    if (isSetApplyToAll()) {
      hashCode += prime + (getApplyToAll() ? 1 : -1);
    }
    hashCode = prime * hashCode + ((listOfDynElements == null) ? 0 :
      listOfDynElements.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DynEventPlugin [");
    builder.append("applyToAll = ");
    builder.append(applyToAll);
    builder.append(", ");
    builder.append("listOfDynElements = ");
    builder.append(listOfDynElements);
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

    if (isSetApplyToAll()) {
      attributes.put(DynConstants.shortLabel + ":" + DynConstants.applyToAll,
        Boolean.toString(getApplyToAll()));
    }
    return attributes;
  }

}
