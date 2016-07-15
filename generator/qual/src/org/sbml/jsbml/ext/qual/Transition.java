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
  private static final long serialVersionUID = 733531209125534L;

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
      }    }
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

  /* hashcode method for Transition.
   */
  @Override
  public int hashCode() {
    final int prime = 9037817;

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
