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
package org.sbml.jsbml.ext.groups;

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
public class GroupsModelPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 9891207272440019L;
  /**
   *
   */
  private ListOf<Group> listOfGroups;

  /**
   * @param model the GroupsModelPlugin instance to copy.
   */
  public GroupsModelPlugin(Model model) {
    super(model);

  }

  /**
   * @param groupsModel the GroupsModelPlugin instance to copy.
   */
  public GroupsModelPlugin(GroupsModelPlugin groupsModel) {
    super(groupsModel);

    if (groupsModel.isSetListOfGroups()) {
      setListOfGroups(groupsModel.getListOfGroups().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public GroupsModelPlugin clone() {
    return new GroupsModelPlugin(this);
  }

  /**
   * @param listOfGroups
   * the listOfGroups to add
   * @return
   */
  public boolean addGroups(Group listOfGroups) {
    return getListOfGroups().add(listOfGroups);
  }

  /**
   * Removes an element from the {@link #listOfGroupss}
   *  
   * @param Groups the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeGroups(Group listOfGroups) {
    if (isSetListOfGroups()) {
      return getListOfGroups().remove(listOfGroups);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfGroupss}
   *  
   * @param i the index where to remove the {@link Groups}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfGroupss)})
   */
  public Group removeGroups(int i) {
    if (isSetListOfGroups()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfGroups().remove(i);
  }

  /**
   * Returns the {@link listOfGroups}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfGroups}.
   */
  public ListOf<Group> getListOfGroups() {
    if (listOfGroups == null) {
      listOfGroups = new ListOf<Group>();
      listOfGroups.setNamespace(GroupsConstants.namespaceURI);
      listOfGroups.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfGroups);
    }
     ;
    return listOfGroups;
  }

  /**
   * Creates a new Groups element and adds it to the
   * {@link listOfGroupss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfGroupss}
   */
  public Group createGroups() {
    Group groups = new Group(getLevel(), getVersion());
    return addGroups(groups) ? groups : null;
  }

  /**
   * Returns the number of {@link Groups}s in this
   * {@link Groups}.
   *  
   * @return the number of {@link Groups}s in this {@link Groups}.
   * @libsbml.deprecated same as {@link #getGroupsCount()}
   */
  @Deprecated
  public int getNumGroups() {
    return getGroupsCount();
  }

  /**
   * Returns the number of {@link Groups}s in this {@link Groups}.
   *  
   * @return the number of {@link Groups}s in this {@link Groups}.
   * @libsbml.deprecated same as {@link #getGroupsCount()}
   */
  public int getGroupsCount() {
    return isSetListOfGroups() ? getListOfGroups().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfGroups} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfGroups} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfGroups() {
    if ((listOfGroups == null) || listOfGroups.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<Groups>}.
   * If {@link listOfGroups} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfGroups
   */
  public void setListOfGroups(ListOf<Group> listOfGroups) {
    unsetListOfGroups();
    this.listOfGroups = listOfGroups;
    this.listOfGroups.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfGroups);
    }
  }

  /**
   * Returns {@code true} if {@link listOfGroups} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfGroups} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfGroups() {
    if (isSetListOfGroups()) {
      ListOf<Group> oldGroups = this.listOfGroups;
      this.listOfGroups = null;
      oldGroups.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return GroupsConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return GroupsConstants.shortLabel;
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

    if (isSetListOfGroups()) {
      if (pos == index) {
        return getListOfGroups();
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

    if (isSetListOfGroups()) {
      count++;
    }
    return count;
  }

  /* hashcode method for GroupsModelPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 5861929;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfGroups == null) ? 0 :
      listOfGroups.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("GroupsModelPlugin [");
    builder.append("listOfGroups = ");
    builder.append(listOfGroups);
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
