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
import java.util.Map;

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
  private static final long serialVersionUID = 48649891067297965L;
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

    if (orig.isSetInput()) {
      setInput(orig.getInput());
    }
    if (orig.isSetOutput()) {
      setOutput(orig.getOutput());
    }
    if (orig.isSetFunctionTerm()) {
      setFunctionTerm(orig.getFunctionTerm());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    functionTerm = null;
  }

  /* Assignment operator for Transition.
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Transition obj = (Transition) object;

      equals &= obj.isSetInput() == isSetInput();
      if (equals && isSetInput()) {
        equals &= (obj.getInput() == getInput());
      }
      equals &= obj.isSetOutput() == isSetOutput();
      if (equals && isSetOutput()) {
        equals &= (obj.getOutput() == getOutput());
      }
      equals &= obj.isSetFunctionTerm() == isSetFunctionTerm();
      if (equals && isSetFunctionTerm()) {
        equals &= (obj.getFunctionTerm() == getFunctionTerm());
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
  public boolean removeInput(int i) {
    if (isSetListOfInputs()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfInputs().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfOutputs}
   *  
   * @param Output the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeOutput(int i) {
    if (isSetListOfOutputs()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfOutputs().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfFunctionTerms}
   *  
   * @param FunctionTerm the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeFunctionTerm(int i) {
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
      listOfInputs == new ListOf<Input>();
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
      listOfOutputs == new ListOf<Output>();
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
      listOfFunctionTerms == new ListOf<FunctionTerm>();
      listOfFunctionTerms.setNamespace(QualConstants.namespaceURI);
      listOfFunctionTerms.setSBaseListType(ListOf.Type.other);
      registerChild(listOfFunctionTerms);
    }
    return listOfFunctionTerms;
  }

  /**
   * Creates a new Input element and adds it to the
   * {@link #listOf$Inputs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link #listOf$Inputs}
   */
  public Input createInput() {
    return createInput(null);
  }

  /**
   * Creates a new Output element and adds it to the
   * {@link #listOf$Outputs} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link #listOf$Outputs}
   */
  public Output createOutput() {
    return createOutput(null);
  }

  /**
   * Creates a new FunctionTerm element and adds it to the
   * {@link #listOf$FunctionTerms} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link #listOf$FunctionTerms}
   */
  public FunctionTerm createFunctionTerm() {
    return createFunctionTerm(null);
  }

  /**
   * Creates a new Input element and adds it to the
   * {@link #listOf$Inputs} list.
   *  
   * @param id the identifier that is to be applied to the new element.
   * @return the newly created element, which is the last item in the
   * {@link #listOf$Inputs}
   */
  public Input createInput(String id) {
    Input input = new Input(id);
    addInput(input);
    return input;
  }

  /**
   * Creates a new Output element and adds it to the
   * {@link #listOf$Outputs} list.
   *  
   * @param id the identifier that is to be applied to the new element.
   * @return the newly created element, which is the last item in the
   * {@link #listOf$Outputs}
   */
  public Output createOutput(String id) {
    Output output = new Output(id);
    addOutput(output);
    return output;
  }

  /**
   * Creates a new FunctionTerm element and adds it to the
   * {@link #listOf$FunctionTerms} list.
   *  
   * @param id the identifier that is to be applied to the new element.
   * @return the newly created element, which is the last item in the
   * {@link #listOf$FunctionTerms}
   */
  public FunctionTerm createFunctionTerm(String id) {
    FunctionTerm functionTerm = new FunctionTerm(id);
    addFunctionTerm(functionTerm);
    return functionTerm;
  }

  /**
   * Returns the number of {@link Input}s in this
   * {@link Qual}.
   *  
   * @return the number of {@link Input}s in this {@link Input}.
   * @libsbml.deprecated same as {@link #getInputCount()}
   */
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
  public int getNumFunctionTerms() {
    return getFunctionTermCount();
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
    unsetlistOfInputs();
    this.listOfInputs = listOfInputs;
    this.listOfInputs.setSBaseListType(ListOf.Type.other);
    registerChild(listOfInputs);

    return listOfInputs;
  }

  /**
   * Sets the given {@code ListOf<Output>}.
   * If {@link listOfOutputs} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfOutputs
   */
  public void setListOfOutputs(ListOf<Output> listOfOutputs) {
    unsetlistOfOutputs();
    this.listOfOutputs = listOfOutputs;
    this.listOfOutputs.setSBaseListType(ListOf.Type.other);
    registerChild(listOfOutputs);

    return listOfOutputs;
  }

  /**
   * Sets the given {@code ListOf<FunctionTerm>}.
   * If {@link listOfFunctionTerms} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfFunctionTerms
   */
  public void setListOfFunctionTerms(ListOf<FunctionTerm> listOfFunctionTerms) {
    unsetlistOfFunctionTerms();
    this.listOfFunctionTerms = listOfFunctionTerms;
    this.listOfFunctionTerms.setSBaseListType(ListOf.Type.other);
    registerChild(listOfFunctionTerms);

    return listOfFunctionTerms;
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
      ListOf<Input> oldListOfInputs = this.listOfInputs;
      this.listOfInputs = null;
      oldListOfInputs.fireNodeRemovedEvent();
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
      ListOf<Output> oldListOfOutputs = this.listOfOutputs;
      this.listOfOutputs = null;
      oldListOfOutputs.fireNodeRemovedEvent();
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
      ListOf<FunctionTerm> oldListOfFunctionTerms = this.listOfFunctionTerms;
      this.listOfFunctionTerms = null;
      oldListOfFunctionTerms.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /* hashcode method for Transition.
   */
  @Override
  public int hashCode() {
    final int prime = 5788129;

    int hashCode = super.hashCode();

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Transition [id = " + getId() + ", name = " + getName() + "]";
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
