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
public class Objective extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 7724594820083606L;
  /**
   *
   */
  private FbcType type;
  /**
   *
   */
  private ListOf<FluxObjective> listOfFluxObjectives;

  /**
   *  
   */
  public Objective() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Objective(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Objective(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Objective(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Objective(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Objective instance to copy.
   */
  public Objective(Objective orig) {
    super(orig);

    if (orig.isSetType()) {
      setType(orig.getType());
    }
    if (orig.isSetListOfFluxObjectives()) {
      setListOfFluxObjectives(orig.getListOfFluxObjectives().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    type = null;
    listOfFluxObjectives = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Objective obj = (Objective) object;

      equals &= obj.isSetType() == isSetType();
      if (equals && isSetType()) {
        equals &= (obj.getType() == getType());
      }
      equals &= obj.isSetListOfFluxObjectives() == isSetListOfFluxObjectives();
      if (equals && isSetListOfFluxObjectives()) {
        equals &=
          obj.getListOfFluxObjectives().equals(getListOfFluxObjectives());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Objective clone() {
    return new Objective(this);
  }

  /**
   * Returns the value of {@link type}.
   *  
   * @return the value of {@link type}.
   */
  public FbcType getType() {
    if (isSetType()) {
      return type;
    }
    throw new PropertyUndefinedError(FbcConstants.type, this);
  }

  /**
   * Returns whether {@link type} is set.
   *  
   * @return whether {@link type} is set.
   */
  public boolean isSetType() {
    return this.type != null;
  }

  /**
   * Sets the value of type
   *  
   * @param type the value of type to be set.
   */
  public boolean setType(FbcType type) {
    if (type != this.type) {
      FbcType oldType = this.type;
      this.type = type;
      firePropertyChange(FbcConstants.type, oldType, this.type);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable type.
   *  
   * @return {@code true} if type was set before, otherwise {@code false}.
   */
  public boolean unsetType() {
    if (isSetType()) {
      FbcType oldType = type;
      type = null;
      firePropertyChange(FbcConstants.type, oldType, type);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return true;
  }

  /**
   * @return true
   */
  public boolean isListOfFluxObjectivesMandatory() {
    return true;
  }

  /**
   * @return true
   */
  public boolean isTypeMandatory() {
    return true;
  }

  /**
   * @param fluxObjective
   * the fluxObjective to add
   * @return
   */
  public boolean addFluxObjective(FluxObjective fluxObjective) {
    return getListOfFluxObjectives().add(fluxObjective);
  }

  /**
   * Removes an element from the {@link #listOfFluxObjectives}
   *  
   * @param FluxObjective the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeFluxObjective(FluxObjective fluxObjective) {
    if (isSetListOfFluxObjectives()) {
      return getListOfFluxObjectives().remove(fluxObjective);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfFluxObjectives}
   *  
   * @param i the index where to remove the {@link FluxObjective}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfFluxObjectives)})
   */
  public FluxObjective removeFluxObjective(int i) {
    if (isSetListOfFluxObjectives()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfFluxObjectives().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfFluxObjectives}.
   *  
   * @param fluxObjectiveId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public FluxObjective removeFluxObjective(String fluxObjectiveId) {
    if (isSetListOfFluxObjectives()) {
      return getListOfFluxObjectives().remove(fluxObjectiveId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfFluxObjectives}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfFluxObjectives}.
   */
  public ListOf<FluxObjective> getListOfFluxObjectives() {
    if (listOfFluxObjectives == null) {
      listOfFluxObjectives = new ListOf<FluxObjective>();
      listOfFluxObjectives.setNamespace(FbcConstants.namespaceURI);
      listOfFluxObjectives.setSBaseListType(ListOf.Type.other);
      registerChild(listOfFluxObjectives);
    }
    return listOfFluxObjectives;
  }

  /**
   * Creates a new FluxObjective element and adds it to the
   * {@link listOfFluxObjectives} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfFluxObjectives}
   */
  public FluxObjective createFluxObjective() {
    FluxObjective fluxObjective = new FluxObjective(getLevel(), getVersion());
    return addFluxObjective(fluxObjective) ? fluxObjective : null;
  }

  /**
   * Returns the number of {@link FluxObjective}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link FluxObjective}s in this {@link
   * FluxObjective}.
   * @libsbml.deprecated same as {@link #getFluxObjectiveCount()}
   */
  @Deprecated
  public int getNumFluxObjectives() {
    return getFluxObjectiveCount();
  }

  /**
   * Returns the number of {@link FluxObjective}s in this {@link Fbc}.
   *  
   * @return the number of {@link FluxObjective}s in this {@link
   * FluxObjective}.
   * @libsbml.deprecated same as {@link #getFluxObjectiveCount()}
   */
  public int getFluxObjectiveCount() {
    return isSetListOfFluxObjectives() ? getListOfFluxObjectives().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfFluxObjectives} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfFluxObjectives} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfFluxObjectives() {
    if ((listOfFluxObjectives == null) || listOfFluxObjectives.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<FluxObjective>}.
   * If {@link listOfFluxObjectives} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfFluxObjectives
   */
  public void setListOfFluxObjectives(ListOf<FluxObjective>    listOfFluxObjectives) {
    unsetListOfFluxObjectives();
    this.listOfFluxObjectives = listOfFluxObjectives;
    this.listOfFluxObjectives.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfFluxObjectives);
  }

  /**
   * Returns {@code true} if {@link listOfFluxObjectives} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfFluxObjectives} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfFluxObjectives() {
    if (isSetListOfFluxObjectives()) {
      ListOf<FluxObjective> oldFluxObjective = this.listOfFluxObjectives;
      this.listOfFluxObjectives = null;
      oldFluxObjective.fireNodeRemovedEvent();
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

    if (isSetListOfFluxObjectives()) {
      if (pos == index) {
        return getListOfFluxObjectives();
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

    if (isSetListOfFluxObjectives()) {
      count++;
    }
    return count;
  }

  /* hashcode method for Objective.
   */
  @Override
  public int hashCode() {
    final int prime = 1002121;

    int hashCode = super.hashCode();

    if (isSetType()) {
      hashCode += prime * getType().hashCode();
    }
    hashCode = prime * hashCode + ((listOfFluxObjectives == null) ? 0 :
      listOfFluxObjectives.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Objective [");
    builder.append("type = ");
    builder.append(type);
    builder.append(", ");
    builder.append("listOfFluxObjectives = ");
    builder.append(listOfFluxObjectives);
    builder.append(", id = ");
    builder.append(getId());
    builder.append(", name = ");
    builder.append(getName());
    builder.append("]");
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

      if (attributeName.equals(FbcConstants.type)) {
        try {
          setType(FbcType.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + FbcConstants.type + " on the 'Objective' element.");
        }
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

    if (isSetId()) {
      attributes.remove("id");
      attributes.put(FbcConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(FbcConstants.shortLabel + ":name", getName());
    }
    if (isSetType()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.type,
        getType().toString());
    }
    return attributes;
  }

}
