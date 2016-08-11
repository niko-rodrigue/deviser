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
package org.sbml.jsbml.ext.spatial;

import java.text.MessageFormat;
import java.util.Locale;
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
public class AdjacentDomains {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 49312425905054147L;
  /**
   *
   */
  private String domain1;
  /**
   *
   */
  private String domain2;

  /**
   *  
   */
  public AdjacentDomains() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public AdjacentDomains(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public AdjacentDomains(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public AdjacentDomains(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public AdjacentDomains(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the AdjacentDomains instance to copy.
   */
  public AdjacentDomains(AdjacentDomains orig) {
    super(orig);

    if (orig.isSetDomain1()) {
      setDomain1(orig.getDomain1());
    }
    if (orig.isSetDomain2()) {
      setDomain2(orig.getDomain2());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = SpatialConstants.shortLabel;
    domain1 = null;
    domain2 = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      AdjacentDomains obj = (AdjacentDomains) object;

      equals &= obj.isSetDomain1() == isSetDomain1();
      if (equals && isSetDomain1()) {
        equals &= (obj.getDomain1() == getDomain1());
      }
      equals &= obj.isSetDomain2() == isSetDomain2();
      if (equals && isSetDomain2()) {
        equals &= (obj.getDomain2() == getDomain2());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public AdjacentDomains clone() {
    return new AdjacentDomains(this);
  }

  /**
   * Returns the value of {@link domain1}.
   *  
   * @return the value of {@link domain1}.
   */
  public String getDomain1() {
    return isSetDomain1() ? domain1 : "";
  }

  /**
   * Returns the value of {@link domain2}.
   *  
   * @return the value of {@link domain2}.
   */
  public String getDomain2() {
    return isSetDomain2() ? domain2 : "";
  }

  /**
   * Returns whether {@link domain1} is set.
   *  
   * @return whether {@link domain1} is set.
   */
  public boolean isSetDomain1() {
    return this.domain1 != null;
  }

  /**
   * Returns whether {@link domain2} is set.
   *  
   * @return whether {@link domain2} is set.
   */
  public boolean isSetDomain2() {
    return this.domain2 != null;
  }

  /**
   * Sets the value of domain1
   *  
   * @param domain1 the value of domain1 to be set.
   */
  public boolean setDomain1(String domain1) {
    if (domain1 != this.domain1) {
      String oldDomain1 = this.domain1;
      this.domain1 = domain1;
      firePropertyChange(SpatialConstants.domain1, oldDomain1, this.domain1);
      return true;
    }
    return false;
  }

  /**
   * Sets the value of domain2
   *  
   * @param domain2 the value of domain2 to be set.
   */
  public boolean setDomain2(String domain2) {
    if (domain2 != this.domain2) {
      String oldDomain2 = this.domain2;
      this.domain2 = domain2;
      firePropertyChange(SpatialConstants.domain2, oldDomain2, this.domain2);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable domain1.
   *  
   * @return {@code true} if domain1 was set before, otherwise {@code false}.
   */
  public boolean unsetDomain1() {
    if (isSetDomain1()) {
      String oldDomain1 = domain1;
      domain1 = null;
      firePropertyChange(SpatialConstants.domain1, oldDomain1, domain1);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable domain2.
   *  
   * @return {@code true} if domain2 was set before, otherwise {@code false}.
   */
  public boolean unsetDomain2() {
    if (isSetDomain2()) {
      String oldDomain2 = domain2;
      domain2 = null;
      firePropertyChange(SpatialConstants.domain2, oldDomain2, domain2);
      return true;
    }
    return false;
  }

  /* hashcode method for AdjacentDomains.
   */
  @Override
  public int hashCode() {
    final int prime = 8207897;

    int hashCode = super.hashCode();

    if (isSetDomain1()) {
      hashCode += prime * getDomain1().hashCode();
    }
    if (isSetDomain2()) {
      hashCode += prime * getDomain2().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AdjacentDomains [");
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

      if (attributeName.equals(SpatialConstants.domain1)) {
        setDomain1(value);
      }      else if (attributeName.equals(SpatialConstants.domain2)) {
        setDomain2(value);
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
      attributes.put(SpatialConstants.shortLabel + ":id", getId());
    }
    if (isSetDomain1()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domain1,
        getDomain1());
    }
    if (isSetDomain2()) {
      attributes.put(SpatialConstants.shortLabel + ":" + SpatialConstants.domain2,
        getDomain2());
    }
    return attributes;
  }

}
