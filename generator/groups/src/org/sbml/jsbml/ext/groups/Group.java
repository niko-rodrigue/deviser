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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class Group extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 36359791896895429L;
  /**
   *
   */
  private GroupKind kind;
  /**
   *
   */
  private ListOf<Member> listOfMembers;

  /**
   *  
   */
  public Group() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Group(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Group(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Group(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Group(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Group instance to copy.
   */
  public Group(Group orig) {
    super(orig);

    if (orig.isSetKind()) {
      setKind(orig.getKind());
    }
    if (orig.isSetListOfMembers()) {
      setListOfMembers(orig.getListOfMembers().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = GroupsConstants.shortLabel;
    kind = null;
    listOfMembers = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Group obj = (Group) object;

      equals &= obj.isSetKind() == isSetKind();
      if (equals && isSetKind()) {
        equals &= (obj.getKind() == getKind());
      }
      equals &= obj.isSetListOfMembers() == isSetListOfMembers();
      if (equals && isSetListOfMembers()) {
        equals &= obj.getListOfMembers().equals(getListOfMembers());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Group clone() {
    return new Group(this);
  }

  /**
   * Returns the value of {@link kind}.
   *  
   * @return the value of {@link kind}.
   */
  public GroupKind getKind() {
    if (isSetKind()) {
      return kind;
    }
    throw new PropertyUndefinedError(GroupsConstants.kind, this);
  }

  /**
   * Returns whether {@link kind} is set.
   *  
   * @return whether {@link kind} is set.
   */
  public boolean isSetKind() {
    return this.kind != null;
  }

  /**
   * Sets the value of kind
   *  
   * @param kind the value of kind to be set.
   */
  public boolean setKind(GroupKind kind) {
    if (kind != this.kind) {
      GroupKind oldKind = this.kind;
      this.kind = kind;
      firePropertyChange(GroupsConstants.kind, oldKind, this.kind);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable kind.
   *  
   * @return {@code true} if kind was set before, otherwise {@code false}.
   */
  public boolean unsetKind() {
    if (isSetKind()) {
      GroupKind oldKind = kind;
      kind = null;
      firePropertyChange(GroupsConstants.kind, oldKind, kind);
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.NamedSBase#isIdMandatory
   */
  @Override
  public boolean isIdMandatory() {
    return false;
  }

  /**
   * @return true
   */
  public boolean isKindMandatory() {
    return true;
  }

  /**
   * @return false
   */
  public boolean isListOfMembersMandatory() {
    return false;
  }

  /**
   * @param member
   * the member to add
   * @return
   */
  public boolean addMember(Member member) {
    return getListOfMembers().add(member);
  }

  /**
   * Removes an element from the {@link #listOfMembers}
   *  
   * @param Member the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeMember(Member member) {
    if (isSetListOfMembers()) {
      return getListOfMembers().remove(member);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfMembers}
   *  
   * @param i the index where to remove the {@link Member}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfMembers)})
   */
  public Member removeMember(int i) {
    if (isSetListOfMembers()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfMembers().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfMembers}.
   *  
   * @param memberId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public Member removeMember(String memberId) {
    if (isSetListOfMembers()) {
      return getListOfMembers().remove(memberId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfMembers}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfMembers}.
   */
  public ListOf<Member> getListOfMembers() {
    if (listOfMembers == null) {
      listOfMembers = new ListOf<Member>();
      listOfMembers.setNamespace(GroupsConstants.namespaceURI);
      listOfMembers.setSBaseListType(ListOf.Type.other);
      registerChild(listOfMembers);
    }
    return listOfMembers;
  }

  /**
   * Creates a new Member element and adds it to the
   * {@link listOfMembers} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfMembers}
   */
  public Member createMember() {
    Member member = new Member(getLevel(), getVersion());
    return addMember(member) ? member : null;
  }

  /**
   * Returns the number of {@link Member}s in this
   * {@link Groups}.
   *  
   * @return the number of {@link Member}s in this {@link Member}.
   * @libsbml.deprecated same as {@link #getMemberCount()}
   */
  @Deprecated
  public int getNumMembers() {
    return getMemberCount();
  }

  /**
   * Returns the number of {@link Member}s in this {@link Groups}.
   *  
   * @return the number of {@link Member}s in this {@link Member}.
   * @libsbml.deprecated same as {@link #getMemberCount()}
   */
  public int getMemberCount() {
    return isSetListOfMembers() ? getListOfMembers().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfMembers} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfMembers} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfMembers() {
    if ((listOfMembers == null) || listOfMembers.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<Member>}.
   * If {@link listOfMembers} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfMembers
   */
  public void setListOfMembers(ListOf<Member> listOfMembers) {
    unsetListOfMembers();
    this.listOfMembers = listOfMembers;
    this.listOfMembers.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfMembers);
  }

  /**
   * Returns {@code true} if {@link listOfMembers} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfMembers} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfMembers() {
    if (isSetListOfMembers()) {
      ListOf<Member> oldMember = this.listOfMembers;
      this.listOfMembers = null;
      oldMember.fireNodeRemovedEvent();
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

    if (isSetListOfMembers()) {
      if (pos == index) {
        return getListOfMembers();
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

    if (isSetListOfMembers()) {
      count++;
    }
    return count;
  }

  /* hashcode method for Group.
   */
  @Override
  public int hashCode() {
    final int prime = 1545233;

    int hashCode = super.hashCode();

    if (isSetKind()) {
      hashCode += prime * getKind().hashCode();
    }
    hashCode = prime * hashCode + ((listOfMembers == null) ? 0 :
      listOfMembers.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Group [");
    builder.append("kind = ");
    builder.append(kind);
    builder.append(", ");
    builder.append("listOfMembers = ");
    builder.append(listOfMembers);
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

      if (attributeName.equals(GroupsConstants.kind)) {
        try {
          setKind(GroupKind.valueOf(value));
        }
        catch (Exception e) {
          throw new SBMLException("Could not recognized the value '" + value + "' for the "+
            "attribute " + GroupsConstants.kind + " on the 'Group' element.");
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
      attributes.put(GroupsConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(GroupsConstants.shortLabel + ":name", getName());
    }
    if (isSetKind()) {
      attributes.put(GroupsConstants.shortLabel + ":" + GroupsConstants.kind,
        getKind().toString());
    }
    return attributes;
  }

}
