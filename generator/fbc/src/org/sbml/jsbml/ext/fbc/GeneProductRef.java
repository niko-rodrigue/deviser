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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class GeneProductRef extends Association {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 47041076814993150L;
  /**
   *
   */
  private String geneProduct;

  /**
   *  
   */
  public GeneProductRef() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public GeneProductRef(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public GeneProductRef(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public GeneProductRef(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public GeneProductRef(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the GeneProductRef instance to copy.
   */
  public GeneProductRef(GeneProductRef orig) {
    super(orig);

    if (orig.isSetGeneProduct()) {
      setGeneProduct(orig.getGeneProduct());
    }
  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    geneProduct = null;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      GeneProductRef obj = (GeneProductRef) object;

      equals &= obj.isSetGeneProduct() == isSetGeneProduct();
      if (equals && isSetGeneProduct()) {
        equals &= (obj.getGeneProduct() == getGeneProduct());
      }
    }
    return equals;
  }

  /**
   * (non-Javadoc)
   */
  public GeneProductRef clone() {
    return new GeneProductRef(this);
  }

  /**
   * Returns the value of {@link geneProduct}.
   *  
   * @return the value of {@link geneProduct}.
   */
  public String getGeneProduct() {
    return isSetGeneProduct() ? geneProduct : "";
  }

  /**
   * Returns whether {@link geneProduct} is set.
   *  
   * @return whether {@link geneProduct} is set.
   */
  public boolean isSetGeneProduct() {
    return this.geneProduct != null;
  }

  /**
   * Sets the value of geneProduct
   *  
   * @param geneProduct the value of geneProduct to be set.
   */
  public boolean setGeneProduct(String geneProduct) {
    if (geneProduct != this.geneProduct) {
      String oldGeneProduct = this.geneProduct;
      this.geneProduct = geneProduct;
      firePropertyChange(FbcConstants.geneProduct, oldGeneProduct,
        this.geneProduct);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable geneProduct.
   *  
   * @return {@code true} if geneProduct was set before, otherwise {@code
   * false}.
   */
  public boolean unsetGeneProduct() {
    if (isSetGeneProduct()) {
      String oldGeneProduct = geneProduct;
      geneProduct = null;
      firePropertyChange(FbcConstants.geneProduct, oldGeneProduct,
        geneProduct);
      return true;
    }
    return false;
  }

  /* hashcode method for GeneProductRef.
   */
  @Override
  public int hashCode() {
    final int prime = 1843027;

    int hashCode = super.hashCode();

    if (isSetGeneProduct()) {
      hashCode += prime * getGeneProduct().hashCode();
    }
    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("GeneProductRef [");
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

      if (attributeName.equals(FbcConstants.geneProduct)) {
        setGeneProduct(value);
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
    if (isSetGeneProduct()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.geneProduct,
        getGeneProduct());
    }
    return attributes;
  }

}
