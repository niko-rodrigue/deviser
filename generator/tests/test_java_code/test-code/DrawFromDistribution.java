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
package org.sbml.jsbml.ext.distrib;

import java.text.MessageFormat;
import java.util.Map;
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;
import org.sbml.jsbml.xml.XMLNode;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class DrawFromDistribution extends AbstractSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 9891207272440019L;
  /**
   *
   */
  private XMLNode uncertML;
  /**
   *
   */
  private ListOf<DistribInput> listOfDistribInputs;

  /**
   *  
   */
  public DrawFromDistribution() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public DrawFromDistribution(int level, int version) {
    super(level, version);
    initDefaults();
  }

  /**
   * @param orig the DrawFromDistribution instance to copy.
   */
  public DrawFromDistribution(DrawFromDistribution orig) {
    super(orig);

    if (orig.isSetListOfDistribInputs()) {
      setListOfDistribInputs(orig.getListOfDistribInputs().clone());
    }
    if (orig.isSetUncertML()) {
      setUncertML(orig.getUncertML().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = DistribConstants.shortLabel;
    listOfDistribInputs = null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.SBase#equals
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      DrawFromDistribution obj = (DrawFromDistribution) object;

      equals &= obj.isSetListOfDistribInputs() == isSetListOfDistribInputs();
      if (equals && isSetListOfDistribInputs()) {
        equals &=
          obj.getListOfDistribInputs().equals(getListOfDistribInputs());
      }
      equals &= obj.isSetUncertML() == isSetUncertML();
      if (equals && isSetUncertML()) {
        equals &= (obj.getUncertML() == getUncertML());
      }
    }
    return equals;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.SBase#clone
   */
  @Override
  public DrawFromDistribution clone() {
    return new DrawFromDistribution(this);
  }

  /**
   * Returns the value of {@link uncertML}.
   *  
   * @return the value of {@link uncertML}.
   */
  public XMLNode getUncertML() {
    if (isSetUncertML()) {
      return uncertML;
    }
    throw new PropertyUndefinedError(DistribConstants.uncertML, this);
  }

  /**
   * Returns whether {@link uncertML} is set.
   *  
   * @return whether {@link uncertML} is set.
   */
  public boolean isSetUncertML() {
    return uncertML != null;
  }

  /**
   * Sets the value of uncertML
   *  
   * @param uncertML the value of uncertML to be set.
   */
  public boolean setUncertML(XMLNode uncertML) {
    if (uncertML != this.uncertML) {
      XMLNode oldUncertML = this.uncertML;
      this.uncertML = uncertML;
      firePropertyChange(DistribConstants.uncertML, oldUncertML,
        this.uncertML);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable uncertML.
   *  
   * @return {@code true} if uncertML was set before, otherwise {@code false}.
   */
  public boolean unsetUncertML() {
    if (isSetUncertML()) {
      XMLNode oldUncertML = uncertML;
      uncertML = null;
      firePropertyChange(DistribConstants.uncertML, oldUncertML, uncertML);
      return true;
    }
    return false;
  }

  /**
   * @param distribInput
   * the distribInput to add
   * @return
   */
  public boolean addDistribInput(DistribInput distribInput) {
    return getListOfDistribInputs().add(distribInput);
  }

  /**
   * Removes an element from the {@link #listOfDistribInputs}
   *  
   * @param DistribInput the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeDistribInput(DistribInput distribInput) {
    if (isSetListOfDistribInputs()) {
      return getListOfDistribInputs().remove(distribInput);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfDistribInputs}
   *  
   * @param i the index where to remove the {@link DistribInput}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfDistribInputs)})
   */
  public DistribInput removeDistribInput(int i) {
    if (isSetListOfDistribInputs()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfDistribInputs().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfDistribInputs}.
   *  
   * @param distribInputId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public DistribInput removeDistribInput(String distribInputId) {
    if (isSetListOfDistribInputs()) {
      return getListOfDistribInputs().remove(distribInputId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfDistribInputs}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfDistribInputs}.
   */
  public ListOf<DistribInput> getListOfDistribInputs() {
    if (listOfDistribInputs == null) {
      listOfDistribInputs = new ListOf<DistribInput>();
      listOfDistribInputs.setNamespace(DistribConstants.namespaceURI);
      listOfDistribInputs.setSBaseListType(ListOf.Type.other);
      registerChild(listOfDistribInputs);
    }
    return listOfDistribInputs;
  }

  /**
   * Creates a new DistribInput element and adds it to the
   * {@link listOfDistribInputs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfDistribInputs}
   */
  public DistribInput createDistribInput() {
    DistribInput distribInput = new DistribInput(getLevel(), getVersion());
    return addDistribInput(distribInput) ? distribInput : null;
  }

  /**
   * Returns the number of {@link DistribInput}s in this
   * {@link Distrib}.
   *  
   * @return the number of {@link DistribInput}s in this {@link DistribInput}.
   * @libsbml.deprecated same as {@link #getDistribInputCount()}
   */
  @Deprecated
  public int getNumDistribInputs() {
    return getDistribInputCount();
  }

  /**
   * Returns the number of {@link DistribInput}s in this {@link Distrib}.
   *  
   * @return the number of {@link DistribInput}s in this {@link DistribInput}.
   * @libsbml.deprecated same as {@link #getDistribInputCount()}
   */
  public int getDistribInputCount() {
    return isSetListOfDistribInputs() ? getListOfDistribInputs().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfDistribInputs} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfDistribInputs} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfDistribInputs() {
    if ((listOfDistribInputs == null) || listOfDistribInputs.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<DistribInput>}.
   * If {@link listOfDistribInputs} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfDistribInputs
   */
  public void setListOfDistribInputs(ListOf<DistribInput> listOfDistribInputs) {
    unsetListOfDistribInputs();
    this.listOfDistribInputs = listOfDistribInputs;
    this.listOfDistribInputs.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfDistribInputs);
  }

  /**
   * Returns {@code true} if {@link listOfDistribInputs} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfDistribInputs} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfDistribInputs() {
    if (isSetListOfDistribInputs()) {
      ListOf<DistribInput> oldDistribInput = this.listOfDistribInputs;
      this.listOfDistribInputs = null;
      oldDistribInput.fireNodeRemovedEvent();
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

    if (isSetListOfDistribInputs()) {
      if (pos == index) {
        return getListOfDistribInputs();
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

    if (isSetListOfDistribInputs()) {
      count++;
    }
    return count;
  }

  /* hashcode method for DrawFromDistribution.
   */
  @Override
  public int hashCode() {
    final int prime = 5861929;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfDistribInputs == null) ? 0 :
      listOfDistribInputs.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#toString
   */
  @Override
  public String toString() {
    return "DrawFromDistribution [uncertML = " + uncertML + ", listOfDistribInputs = " + listOfDistribInputs + "]";
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.SBase#readAttribute
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    return isAttributeRead;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.SBase#writeXMLAttributes
   */
  @Override
  public Map <String, String> writeXMLAttributes() {
    Map <String, String> attributes = super.writeXMLAttributes();

    return attributes;
  }

}
