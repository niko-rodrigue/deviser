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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class DistribInput extends AbstractNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 9891207272440019L;
  /**
   *
   */
  private Integer index;

  /**
   *  
   */
  public DistribInput() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public DistribInput(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public DistribInput(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public DistribInput(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public DistribInput(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the DistribInput instance to copy.
   */
  public DistribInput(DistribInput orig) {
    super(orig);

    if (orig.isSetIndex()) {
      setIndex(orig.getIndex());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = DistribConstants.shortLabel;
    index = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      DistribInput obj = (DistribInput) object;

      equals &= obj.isSetIndex() == isSetIndex();
      if (equals && isSetIndex()) {
        equals &= (obj.getIndex() == getIndex());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public DistribInput clone() {
    return new DistribInput(this);
  }

  /**
   * Returns the value of {@link index}.
   *  
   * @return the value of {@link index}.
   */
  public int getIndex() {
    if (isSetIndex()) {
      return index.intValue();
    }
    throw new PropertyUndefinedError(DistribConstants.index, this);
  }

  /**
   * Returns whether {@link index} is set.
   *  
   * @return whether {@link index} is set.
   */
  public boolean isSetIndex() {
    return this.index != null;
  }

  /**
   * Sets the value of index
   *  
   * @param index the value of index to be set.
   */
  public boolean setIndex(int index) {
    if (index != this.index) {
      Integer oldIndex = this.index;
      this.index = index;
      firePropertyChange(DistribConstants.index, oldIndex, this.index);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable index.
   *  
   * @return {@code true} if index was set before, otherwise {@code false}.
   */
  public boolean unsetIndex() {
    if (isSetIndex()) {
      Integer oldIndex = index;
      index = null;
      firePropertyChange(DistribConstants.index, oldIndex, index);
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
  public boolean isIndexMandatory() {
    return true;
  }

  /* hashcode method for DistribInput.
   */
  @Override
  public int hashCode() {
    final int prime = 5861929;

    int hashCode = super.hashCode();

    if (isSetIndex()) {
      hashCode += prime * getIndex();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "DistribInput [index = " + index + "id = " + getId() + ", name = " + getName() + "]";
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractNamedSBase#readAttribute(java.lang.String,
   */
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value) {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);

    if (!isAttributeRead) {
      isAttributeRead = true;

      if (attributeName.equals(DistribConstants.index)) {
        setIndex(StringTools.parseSBMLInt(value));
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
      attributes.put(DistribConstants.shortLabel + ":id", getId());
    }
    if (isSetName()) {
      attributes.remove("name");
      attributes.put(DistribConstants.shortLabel + ":name", getName());
    }
    if (isSetIndex()) {
      attributes.put(DistribConstants.shortLabel + ":" + DistribConstants.index,
        Integer.toString(getIndex()));
    }
    return attributes;
  }

}
