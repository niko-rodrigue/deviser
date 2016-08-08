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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class Transition extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 67648451496157063L;
  /**
   *
   */
  private ListOf<Input> listOfInputs;
  /**
   *
   */
  private ListOf<Output> listOfOutputs;
  /**
   *
   */
  private ListOf<FunctionTerm> listOfFunctionTerms;

  /**
   *  
   */
  public Transition() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Transition(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Transition(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Transition(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Transition(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Transition instance to copy.
   */
  public Transition(Transition orig) {
    super(orig);

    if (orig.isSetListOfInputs()) {
      setListOfInputs(orig.getListOfInputs().clone());
    }
    if (orig.isSetListOfOutputs()) {
      setListOfOutputs(orig.getListOfOutputs().clone());
    }
    if (orig.isSetListOfFunctionTerms()) {
      setListOfFunctionTerms(orig.getListOfFunctionTerms().clone());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    listOfInputs = null;
    listOfOutputs = null;
    listOfFunctionTerms = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Transition obj = (Transition) object;

      equals &= obj.isSetListOfInputs() == isSetListOfInputs();
      if (equals && isSetListOfInputs()) {
        equals &= obj.getListOfInputs().equals(getListOfInputs());
      }
      equals &= obj.isSetListOfOutputs() == isSetListOfOutputs();
      if (equals && isSetListOfOutputs()) {
        equals &= obj.getListOfOutputs().equals(getListOfOutputs());
      }
      equals &= obj.isSetListOfFunctionTerms() == isSetListOfFunctionTerms();
      if (equals && isSetListOfFunctionTerms()) {
        equals &=
          obj.getListOfFunctionTerms().equals(getListOfFunctionTerms());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public Transition clone() {
    return new Transition(this);
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
  public boolean isListOfFunctionTermsMandatory() {
    return true;
  }

  /**
   * @return false
   */
  public boolean isListOfInputsMandatory() {
    return false;
  }

  /**
   * @return false
   */
  public boolean isListOfOutputsMandatory() {
    return false;
  }

  /**
   * @param input
   * the input to add
   * @return
   */
  public boolean addInput(Input input) {
    return getListOfInputs().add(input);
  }

  /**
   * @param output
   * the output to add
   * @return
   */
  public boolean addOutput(Output output) {
    return getListOfOutputs().add(output);
  }

  /**
   * @param functionTerm
   * the functionTerm to add
   * @return
   */
  public boolean addFunctionTerm(FunctionTerm functionTerm) {
    return getListOfFunctionTerms().add(functionTerm);
  }

  /**
   * Removes an element from the {@link #listOfInputs}
   *  
   * @param Input the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeInput(Input input) {
    if (isSetListOfInputs()) {
      return getListOfInputs().remove(input);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfOutputs}
   *  
   * @param Output the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeOutput(Output output) {
    if (isSetListOfOutputs()) {
      return getListOfOutputs().remove(output);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfFunctionTerms}
   *  
   * @param FunctionTerm the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeFunctionTerm(FunctionTerm functionTerm) {
    if (isSetListOfFunctionTerms()) {
      return getListOfFunctionTerms().remove(functionTerm);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfInputs}
   *  
   * @param i the index where to remove the {@link Input}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfInputs)})
   */
  public Input removeInput(int i) {
    if (isSetListOfInputs()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfInputs().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfOutputs}
   *  
   * @param i the index where to remove the {@link Output}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfOutputs)})
   */
  public Output removeOutput(int i) {
    if (isSetListOfOutputs()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfOutputs().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfFunctionTerms}
   *  
   * @param i the index where to remove the {@link FunctionTerm}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfFunctionTerms)})
   */
  public FunctionTerm removeFunctionTerm(int i) {
    if (isSetListOfFunctionTerms()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfFunctionTerms().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfInputs}.
   *  
   * @param inputId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public Input removeInput(String inputId) {
    if (isSetListOfInputs()) {
      return getListOfInputs().remove(inputId);
    }
    return null;
  }

  /**
   * Removes an element from the {@link #listOfOutputs}.
   *  
   * @param outputId the id of the element to be removed from the list.
   * @return the removed element, if it was successfully found and removed or
   * {@code null}.
   */
  public Output removeOutput(String outputId) {
    if (isSetListOfOutputs()) {
      return getListOfOutputs().remove(outputId);
    }
    return null;
  }

  /**
   * Returns the {@link listOfInputs}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfInputs}.
   */
  public ListOf<Input> getListOfInputs() {
    if (listOfInputs == null) {
      listOfInputs = new ListOf<Input>();
      listOfInputs.setNamespace(QualConstants.namespaceURI);
      listOfInputs.setSBaseListType(ListOf.Type.other);
      registerChild(listOfInputs);
    }
    return listOfInputs;
  }

  /**
   * Returns the {@link listOfOutputs}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfOutputs}.
   */
  public ListOf<Output> getListOfOutputs() {
    if (listOfOutputs == null) {
      listOfOutputs = new ListOf<Output>();
      listOfOutputs.setNamespace(QualConstants.namespaceURI);
      listOfOutputs.setSBaseListType(ListOf.Type.other);
      registerChild(listOfOutputs);
    }
    return listOfOutputs;
  }

  /**
   * Returns the {@link listOfFunctionTerms}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfFunctionTerms}.
   */
  public ListOf<FunctionTerm> getListOfFunctionTerms() {
    if (listOfFunctionTerms == null) {
      listOfFunctionTerms = new ListOf<FunctionTerm>();
      listOfFunctionTerms.setNamespace(QualConstants.namespaceURI);
      listOfFunctionTerms.setSBaseListType(ListOf.Type.other);
      registerChild(listOfFunctionTerms);
    }
    return listOfFunctionTerms;
  }

  /**
   * Creates a new Input element and adds it to the
   * {@link listOfInputs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfInputs}
   */
  public Input createInput() {
    Input input = new Input(getLevel(), getVersion());
    return addInput(input) ? input : null;
  }

  /**
   * Creates a new Output element and adds it to the
   * {@link listOfOutputs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfOutputs}
   */
  public Output createOutput() {
    Output output = new Output(getLevel(), getVersion());
    return addOutput(output) ? output : null;
  }

  /**
   * Creates a new FunctionTerm element and adds it to the
   * {@link listOfFunctionTerms} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfFunctionTerms}
   */
  public FunctionTerm createFunctionTerm() {
    FunctionTerm functionTerm = new FunctionTerm(getLevel(), getVersion());
    return addFunctionTerm(functionTerm) ? functionTerm : null;
  }

  /**
   * Returns the number of {@link Input}s in this
   * {@link Qual}.
   *  
   * @return the number of {@link Input}s in this {@link Input}.
   * @libsbml.deprecated same as {@link #getInputCount()}
   */
  @Deprecated
  public int getNumInputs() {
    return getInputCount();
  }

  /**
   * Returns the number of {@link Output}s in this
   * {@link Qual}.
   *  
   * @return the number of {@link Output}s in this {@link Output}.
   * @libsbml.deprecated same as {@link #getOutputCount()}
   */
  @Deprecated
  public int getNumOutputs() {
    return getOutputCount();
  }

  /**
   * Returns the number of {@link FunctionTerm}s in this
   * {@link Qual}.
   *  
   * @return the number of {@link FunctionTerm}s in this {@link FunctionTerm}.
   * @libsbml.deprecated same as {@link #getFunctionTermCount()}
   */
  @Deprecated
  public int getNumFunctionTerms() {
    return getFunctionTermCount();
  }

  /**
   * Returns the number of {@link Input}s in this {@link Qual}.
   *  
   * @return the number of {@link Input}s in this {@link Input}.
   * @libsbml.deprecated same as {@link #getInputCount()}
   */
  public int getInputCount() {
    return isSetListOfInputs() ? getListOfInputs().size() : 0;
  }

  /**
   * Returns the number of {@link Output}s in this {@link Qual}.
   *  
   * @return the number of {@link Output}s in this {@link Output}.
   * @libsbml.deprecated same as {@link #getOutputCount()}
   */
  public int getOutputCount() {
    return isSetListOfOutputs() ? getListOfOutputs().size() : 0;
  }

  /**
   * Returns the number of {@link FunctionTerm}s in this {@link Qual}.
   *  
   * @return the number of {@link FunctionTerm}s in this {@link FunctionTerm}.
   * @libsbml.deprecated same as {@link #getFunctionTermCount()}
   */
  public int getFunctionTermCount() {
    return isSetListOfFunctionTerms() ? getListOfFunctionTerms().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfInputs} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfInputs} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfInputs() {
    if ((listOfInputs == null) || listOfInputs.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfOutputs} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfOutputs} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfOutputs() {
    if ((listOfOutputs == null) || listOfOutputs.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfFunctionTerms} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfFunctionTerms} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfFunctionTerms() {
    if ((listOfFunctionTerms == null) || listOfFunctionTerms.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<Input>}.
   * If {@link listOfInputs} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfInputs
   */
  public void setListOfInputs(ListOf<Input> listOfInputs) {
    unsetListOfInputs();
    this.listOfInputs = listOfInputs;
    this.listOfInputs.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfInputs);
  }

  /**
   * Sets the given {@code ListOf<Output>}.
   * If {@link listOfOutputs} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfOutputs
   */
  public void setListOfOutputs(ListOf<Output> listOfOutputs) {
    unsetListOfOutputs();
    this.listOfOutputs = listOfOutputs;
    this.listOfOutputs.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfOutputs);
  }

  /**
   * Sets the given {@code ListOf<FunctionTerm>}.
   * If {@link listOfFunctionTerms} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfFunctionTerms
   */
  public void setListOfFunctionTerms(ListOf<FunctionTerm> listOfFunctionTerms) {
    unsetListOfFunctionTerms();
    this.listOfFunctionTerms = listOfFunctionTerms;
    this.listOfFunctionTerms.setSBaseListType(ListOf.Type.other);
    registerChild(this.listOfFunctionTerms);
  }

  /**
   * Returns {@code true} if {@link listOfInputs} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfInputs} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfInputs() {
    if (isSetListOfInputs()) {
      ListOf<Input> oldInput = this.listOfInputs;
      this.listOfInputs = null;
      oldInput.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfOutputs} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfOutputs} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfOutputs() {
    if (isSetListOfOutputs()) {
      ListOf<Output> oldOutput = this.listOfOutputs;
      this.listOfOutputs = null;
      oldOutput.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfFunctionTerms} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfFunctionTerms} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfFunctionTerms() {
    if (isSetListOfFunctionTerms()) {
      ListOf<FunctionTerm> oldFunctionTerm = this.listOfFunctionTerms;
      this.listOfFunctionTerms = null;
      oldFunctionTerm.fireNodeRemovedEvent();
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

    if (isSetListOfInputs()) {
      if (pos == index) {
        return getListOfInputs();
      }
      pos++;
    }
    if (isSetListOfOutputs()) {
      if (pos == index) {
        return getListOfOutputs();
      }
      pos++;
    }
    if (isSetListOfFunctionTerms()) {
      if (pos == index) {
        return getListOfFunctionTerms();
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

    if (isSetListOfInputs()) {
      count++;
    }
    if (isSetListOfOutputs()) {
      count++;
    }
    if (isSetListOfFunctionTerms()) {
      count++;
    }
    return count;
  }

  /* hashcode method for Transition.
   */
  @Override
  public int hashCode() {
    final int prime = 329801;

    int hashCode = super.hashCode();

    hashCode = prime * hashCode + ((listOfInputs == null) ? 0 :
      listOfInputs.hashCode());

    hashCode = prime * hashCode + ((listOfOutputs == null) ? 0 :
      listOfOutputs.hashCode());

    hashCode = prime * hashCode + ((listOfFunctionTerms == null) ? 0 :
      listOfFunctionTerms.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Transition [");
    builder.append("listOfInputs = ");
    builder.append(listOfInputs);
    builder.append(", ");
    builder.append("listOfOutputs = ");
    builder.append(listOfOutputs);
    builder.append(", ");
    builder.append("listOfFunctionTerms = ");
    builder.append(listOfFunctionTerms);
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
      attributes.put(QualConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(QualConstants.shortLabel + ":name", getName());
    }
    return attributes;
  }

}
