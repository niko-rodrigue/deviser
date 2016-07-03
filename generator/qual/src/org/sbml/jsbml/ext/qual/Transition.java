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
  private static final long serialVersionUID = -6048861420699176889L;

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
    }  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = QualConstants.shortLabel;
    input = null;
    output = null;
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
      return equals;
    }  }

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
   * For Transition, the XML element name is always @c "transition".
   */
  public const std::string& getElementName() {
    static const string name = "transition";
    return name;
  }

  public int getTypeCode() {
    return SBML_QUAL_TRANSITION;
  }

  public bool hasRequiredAttributes() {
    bool allPresent = true;

    return allPresent;
  }

  public bool hasRequiredElements() {
    bool allPresent = true;

    if (getNumFunctionTerms() == 0) {
      allPresent = false;
    }
    return allPresent;
  }


  /** @cond doxygenJSBMLInternal */

  /**
   * Write any contained elements
   */
  public void writeElements(XMLOutputStream& stream) {
    SBase::writeElements(stream);

    if (getNumInputs() > 0) {
      mInputs.write(stream);
    }
    if (getNumOutputs() > 0) {
      mOutputs.write(stream);
    }
    if (getNumFunctionTerms() > 0) {
      mFunctionTerms.write(stream);
    }
    SBase::writeExtensionElements(stream);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Accepts the given SBMLVisitor
   */
  public bool accept(SBMLVisitor& v) {
    v.visit(*this);

    mInputs.accept(v);

    mOutputs.accept(v);

    mFunctionTerms.accept(v);

    v.leave(*this);
    return true;
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Sets the parent SBMLDocument
   */
  public void setSBMLDocument(SBMLDocument* d) {
    SBase::setSBMLDocument(d);

    mInputs.setSBMLDocument(d);

    mOutputs.setSBMLDocument(d);

    mFunctionTerms.setSBMLDocument(d);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Connects to child elements
   */
  public void connectToChild() {
    SBase::connectToChild();

    mInputs.connectToParent(this);

    mOutputs.connectToParent(this);

    mFunctionTerms.connectToParent(this);
  }

  /** @endcond */



  /** @cond doxygenJSBMLInternal */

  /**
   * Enables/disables the given package with this element
   */
  public void enablePackageInternal(const std::string& pkgURI, {
                                    const std::string& pkgPrefix, {
                                    bool flag) {
    SBase::enablePackageInternal(pkgURI, pkgPrefix, flag);

    mInputs.enablePackageInternal(pkgURI, pkgPrefix, flag);

    mOutputs.enablePackageInternal(pkgURI, pkgPrefix, flag);

    mFunctionTerms.enablePackageInternal(pkgURI, pkgPrefix, flag);
  }

  /** @endcond */


}
