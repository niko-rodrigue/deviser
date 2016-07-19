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
  private static final long serialVersionUID = 52273494992473694L;
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
   * Returns the ListOfInputs from this Transition.
   */
  public const ListOfInputs* getListOfInputs() {
    return &mInputs;
  }

  public Input* getInput(unsigned int n) {
    return mInputs.get(n);
  }

  public int addInput(const Input* i) {
    if (i == NULL) {
      return LIBSBML_OPERATION_FAILED;
    }    else if (i->hasRequiredAttributes() == false) {
      return LIBSBML_INVALID_OBJECT;
    }    else if (getLevel() != i->getLevel()) {
      return LIBSBML_LEVEL_MISMATCH;
    }    else if (getVersion() != i->getVersion()) {
      return LIBSBML_VERSION_MISMATCH;
    }    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const      SBase*>(i)) == false) {
      return LIBSBML_NAMESPACES_MISMATCH;
    }    else if (i->isSetId() && (mInputs.get(i->getId())) != NULL) {
      return LIBSBML_DUPLICATE_OBJECT_ID;
    } else {
      mInputs.append(i);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * Get the number of Input objects in this Transition.
   */
  public unsigned int getNumInputs() {
    return mInputs.size();
  }

  public Input* createInput() {
    Input* i = NULL;

 try {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      i = new Input(qualns);
      delete qualns;
    }
    catch (...) {
    }
    if (i != NULL) {
      mInputs.appendAndOwn(i);
    }
    return i;
  }

  public Input* removeInput(unsigned int n) {
    return mInputs.remove(n);
  }

  public Input* removeInput(const std::string& sid) {
    return mInputs.remove(sid);
  }

  /**
   * Returns the ListOfOutputs from this Transition.
   */
  public const ListOfOutputs* getListOfOutputs() {
    return &mOutputs;
  }

  public Output* getOutput(unsigned int n) {
    return mOutputs.get(n);
  }

  public int addOutput(const Output* o) {
    if (o == NULL) {
      return LIBSBML_OPERATION_FAILED;
    }    else if (o->hasRequiredAttributes() == false) {
      return LIBSBML_INVALID_OBJECT;
    }    else if (getLevel() != o->getLevel()) {
      return LIBSBML_LEVEL_MISMATCH;
    }    else if (getVersion() != o->getVersion()) {
      return LIBSBML_VERSION_MISMATCH;
    }    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const      SBase*>(o)) == false) {
      return LIBSBML_NAMESPACES_MISMATCH;
    }    else if (o->isSetId() && (mOutputs.get(o->getId())) != NULL) {
      return LIBSBML_DUPLICATE_OBJECT_ID;
    } else {
      mOutputs.append(o);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * Get the number of Output objects in this Transition.
   */
  public unsigned int getNumOutputs() {
    return mOutputs.size();
  }

  public Output* createOutput() {
    Output* o = NULL;

 try {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      o = new Output(qualns);
      delete qualns;
    }
    catch (...) {
    }
    if (o != NULL) {
      mOutputs.appendAndOwn(o);
    }
    return o;
  }

  public Output* removeOutput(unsigned int n) {
    return mOutputs.remove(n);
  }

  public Output* removeOutput(const std::string& sid) {
    return mOutputs.remove(sid);
  }

  /**
   * Returns the ListOfFunctionTerms from this Transition.
   */
  public const ListOfFunctionTerms* getListOfFunctionTerms() {
    return &mFunctionTerms;
  }

  public FunctionTerm* getFunctionTerm(unsigned int n) {
    return mFunctionTerms.get(n);
  }

  public int addFunctionTerm(const FunctionTerm* ft) {
    if (ft == NULL) {
      return LIBSBML_OPERATION_FAILED;
    }    else if (ft->hasRequiredAttributes() == false) {
      return LIBSBML_INVALID_OBJECT;
    }    else if (ft->hasRequiredElements() == false) {
      return LIBSBML_INVALID_OBJECT;
    }    else if (getLevel() != ft->getLevel()) {
      return LIBSBML_LEVEL_MISMATCH;
    }    else if (getVersion() != ft->getVersion()) {
      return LIBSBML_VERSION_MISMATCH;
    }    else if (matchesRequiredSBMLNamespacesForAddition(static_cast<const      SBase*>(ft)) == false) {
      return LIBSBML_NAMESPACES_MISMATCH;
    } else {
      mFunctionTerms.append(ft);
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * Get the number of FunctionTerm objects in this Transition.
   */
  public unsigned int getNumFunctionTerms() {
    return mFunctionTerms.size();
  }

  public FunctionTerm* createFunctionTerm() {
    FunctionTerm* ft = NULL;

 try {
      QUAL_CREATE_NS(qualns, getSBMLNamespaces());
      ft = new FunctionTerm(qualns);
      delete qualns;
    }
    catch (...) {
    }
    if (ft != NULL) {
      mFunctionTerms.appendAndOwn(ft);
    }
    return ft;
  }

  public FunctionTerm* removeFunctionTerm(unsigned int n) {
    return mFunctionTerms.remove(n);
  }

  /**
   * @return the defaultTerm
   */
  public DefaultTerm getDefaultTerm() {
    if (isSetDefaultTerm()) {
      return defaultTerm;
    }
    throw new PropertyUndefinedError(QualConstants.defaultTerm, this);
  }

  /**
   * @return the defaultTerm
   */
  public DefaultTerm getDefaultTerm() {
    if (isSetDefaultTerm()) {
      return defaultTerm;
    }
    throw new PropertyUndefinedError(QualConstants.defaultTerm, this);
  }

  /**
   * @return 
   */
  public boolean isSetDefaultTerm() {
    return (defaultTerm != NULL);
  }

  /**
   * @param defaultTerm
   */
  public void setDefaultTerm(DefaultTerm defaultTerm) {
    if (defaultTerm == defaultTerm) {
      return LIBSBML_OPERATION_SUCCESS;
    }    else if (defaultTerm == NULL) {
      delete defaultTerm;
      defaultTerm = NULL;
      return LIBSBML_OPERATION_SUCCESS;
    } else {
      delete defaultTerm;
      defaultTerm = (defaultTerm != NULL) ? defaultTerm->clone() : NULL;
      if (defaultTerm != NULL) {
        defaultTerm->connectToParent(this);
      }
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * Creates a new DefaultTerm object, adds it to this Transition object and
   * returns the DefaultTerm object created.
   */
  public DefaultTerm createDefaultTerm() {
  }

  /**
   * @return {@code true} if the unset of the defaultTerm attribute was
   * successful
   */
  public boolean unsetDefaultTerm() {
    delete defaultTerm;
    defaultTerm = NULL;
    return LIBSBML_OPERATION_SUCCESS;
  }

  /* hashcode method for Transition.
   */
  @Override
  public int hashCode() {
    final int prime = 9882307;

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
