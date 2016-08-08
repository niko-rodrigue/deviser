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
public class FbcModelPlugin extends AbstractSBasePlugin {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 2962649200331042L;
  /**
   *
   */
  private Boolean strict;
  /**
   *
   */
  private ListOf<Objective> listOfObjectives;
  /**
   *
   */
  private ListOf<FluxBound> listOfFluxBounds;
  /**
   *
   */
  private ListOf<GeneProduct> listOfGeneProducts;

  /**
   * @param model the FbcModelPlugin instance to copy.
   */
  public FbcModelPlugin(Model model) {
    super(model);

  }

  /**
   * @param fbcModel the FbcModelPlugin instance to copy.
   */
  public FbcModelPlugin(FbcModelPlugin fbcModel) {
    super(fbcModel);

    if (fbcModel.isSetStrict()) {
      setStrict(fbcModel.getStrict());
    }
    if (fbcModel.isSetListOfObjectives()) {
      setListOfObjectives(fbcModel.getListOfObjectives().clone());
    }
    if (fbcModel.isSetListOfFluxBounds()) {
      setListOfFluxBounds(fbcModel.getListOfFluxBounds().clone());
    }
    if (fbcModel.isSetListOfGeneProducts()) {
      setListOfGeneProducts(fbcModel.getListOfGeneProducts().clone());
    }
  }

  /**
   * (non-Javadoc)
   */
  public FbcModelPlugin clone() {
    return new FbcModelPlugin(this);
  }

  /**
   * Returns the value of {@link strict}.
   *  
   * @return the value of {@link strict}.
   */
  public boolean getStrict() {
    if (isSetStrict()) {
      return strict.booleanValue();
    }
    throw new PropertyUndefinedError(FbcConstants.strict, this);
  }

  /**
   * Returns whether {@link strict} is set.
   *  
   * @return whether {@link strict} is set.
   */
  public boolean isSetStrict() {
    return this.strict != null;
  }

  /**
   * Sets the value of strict
   *  
   * @param strict the value of strict to be set.
   */
  public boolean setStrict(boolean strict) {
    if (strict != this.strict) {
      Boolean oldStrict = this.strict;
      this.strict = strict;
      firePropertyChange(FbcConstants.strict, oldStrict, this.strict);
      return true;
    }
    return false;
  }

  /**
   * Unsets the variable strict.
   *  
   * @return {@code true} if strict was set before, otherwise {@code false}.
   */
  public boolean unsetStrict() {
    if (isSetStrict()) {
      Boolean oldStrict = strict;
      strict = null;
      firePropertyChange(FbcConstants.strict, oldStrict, strict);
      return true;
    }
    return false;
  }

  /**
   * @param listOfObjectives
   * the listOfObjectives to add
   * @return
   */
  public boolean addObjectives(Objective listOfObjectives) {
    return getListOfObjectives().add(listOfObjectives);
  }

  /**
   * @param listOfFluxBounds
   * the listOfFluxBounds to add
   * @return
   */
  public boolean addFluxBounds(FluxBound listOfFluxBounds) {
    return getListOfFluxBounds().add(listOfFluxBounds);
  }

  /**
   * @param listOfGeneProducts
   * the listOfGeneProducts to add
   * @return
   */
  public boolean addGeneProducts(GeneProduct listOfGeneProducts) {
    return getListOfGeneProducts().add(listOfGeneProducts);
  }

  /**
   * Removes an element from the {@link #listOfObjectivess}
   *  
   * @param Objectives the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeObjectives(Objective listOfObjectives) {
    if (isSetListOfObjectives()) {
      return getListOfObjectives().remove(listOfObjectives);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfFluxBoundss}
   *  
   * @param FluxBounds the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeFluxBounds(FluxBound listOfFluxBounds) {
    if (isSetListOfFluxBounds()) {
      return getListOfFluxBounds().remove(listOfFluxBounds);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfGeneProductss}
   *  
   * @param GeneProducts the element to be removed from the list.
   * @return {@code true} if the list contained the specified element and it
   * was removed.
   * @see java.util.List#remove(Object)
   */
  public boolean removeGeneProducts(GeneProduct listOfGeneProducts) {
    if (isSetListOfGeneProducts()) {
      return getListOfGeneProducts().remove(listOfGeneProducts);
    }
    return false;
  }

  /**
   * Removes an element from the {@link #listOfObjectivess}
   *  
   * @param i the index where to remove the {@link Objectives}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfObjectivess)})
   */
  public Objective removeObjectives(int i) {
    if (isSetListOfObjectives()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfObjectives().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfFluxBoundss}
   *  
   * @param i the index where to remove the {@link FluxBounds}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfFluxBoundss)})
   */
  public FluxBound removeFluxBounds(int i) {
    if (isSetListOfFluxBounds()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfFluxBounds().remove(i);
  }

  /**
   * Removes an element from the {@link #listOfGeneProductss}
   *  
   * @param i the index where to remove the {@link GeneProducts}.
   * @return the specified element if it was successfully found and removed.
   * @throws IndexOutOfBoundsException if the listOf is not set or if the index
   * is out of bound ({@code (i < 0) || (i > listOfGeneProductss)})
   */
  public GeneProduct removeGeneProducts(int i) {
    if (isSetListOfGeneProducts()) {
      throw new IndexOutOfBoundsException(Integer.toString(i));
    }
    return getListOfGeneProducts().remove(i);
  }

  /**
   * Returns the {@link listOfObjectives}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfObjectives}.
   */
  public ListOf<Objective> getListOfObjectives() {
    if (listOfObjectives == null) {
      listOfObjectives = new ListOf<Objective>();
      listOfObjectives.setNamespace(FbcConstants.namespaceURI);
      listOfObjectives.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfObjectives);
    }
     ;
    return listOfObjectives;
  }

  /**
   * Returns the {@link listOfFluxBounds}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfFluxBounds}.
   */
  public ListOf<FluxBound> getListOfFluxBounds() {
    if (listOfFluxBounds == null) {
      listOfFluxBounds = new ListOf<FluxBound>();
      listOfFluxBounds.setNamespace(FbcConstants.namespaceURI);
      listOfFluxBounds.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfFluxBounds);
    }
     ;
    return listOfFluxBounds;
  }

  /**
   * Returns the {@link listOfGeneProducts}
   * Creates it if it does not already exist.
   *  
   * @return the {@link listOfGeneProducts}.
   */
  public ListOf<GeneProduct> getListOfGeneProducts() {
    if (listOfGeneProducts == null) {
      listOfGeneProducts = new ListOf<GeneProduct>();
      listOfGeneProducts.setNamespace(FbcConstants.namespaceURI);
      listOfGeneProducts.setSBaseListType(ListOf.Type.other);
    }
    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfGeneProducts);
    }
     ;
    return listOfGeneProducts;
  }

  /**
   * Creates a new Objectives element and adds it to the
   * {@link listOfObjectivess} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfObjectivess}
   */
  public Objective createObjectives() {
    Objective objectives = new Objective(getLevel(), getVersion());
    return addObjectives(objectives) ? objectives : null;
  }

  /**
   * Creates a new FluxBounds element and adds it to the
   * {@link listOfFluxBoundss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfFluxBoundss}
   */
  public FluxBound createFluxBounds() {
    FluxBound fluxBounds = new FluxBound(getLevel(), getVersion());
    return addFluxBounds(fluxBounds) ? fluxBounds : null;
  }

  /**
   * Creates a new GeneProducts element and adds it to the
   * {@link listOfGeneProductss} list.
   *  
   * @return the newly created element, i.e., the last item in the
   * {@link listOfGeneProductss}
   */
  public GeneProduct createGeneProducts() {
    GeneProduct geneProducts = new GeneProduct(getLevel(), getVersion());
    return addGeneProducts(geneProducts) ? geneProducts : null;
  }

  /**
   * Returns the number of {@link Objectives}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link Objectives}s in this {@link Objectives}.
   * @libsbml.deprecated same as {@link #getObjectivesCount()}
   */
  @Deprecated
  public int getNumObjectives() {
    return getObjectivesCount();
  }

  /**
   * Returns the number of {@link FluxBounds}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link FluxBounds}s in this {@link FluxBounds}.
   * @libsbml.deprecated same as {@link #getFluxBoundsCount()}
   */
  @Deprecated
  public int getNumFluxBounds() {
    return getFluxBoundsCount();
  }

  /**
   * Returns the number of {@link GeneProducts}s in this
   * {@link Fbc}.
   *  
   * @return the number of {@link GeneProducts}s in this {@link GeneProducts}.
   * @libsbml.deprecated same as {@link #getGeneProductsCount()}
   */
  @Deprecated
  public int getNumGeneProducts() {
    return getGeneProductsCount();
  }

  /**
   * Returns the number of {@link Objectives}s in this {@link Fbc}.
   *  
   * @return the number of {@link Objectives}s in this {@link Objectives}.
   * @libsbml.deprecated same as {@link #getObjectivesCount()}
   */
  public int getObjectivesCount() {
    return isSetListOfObjectives() ? getListOfObjectives().size() : 0;
  }

  /**
   * Returns the number of {@link FluxBounds}s in this {@link Fbc}.
   *  
   * @return the number of {@link FluxBounds}s in this {@link FluxBounds}.
   * @libsbml.deprecated same as {@link #getFluxBoundsCount()}
   */
  public int getFluxBoundsCount() {
    return isSetListOfFluxBounds() ? getListOfFluxBounds().size() : 0;
  }

  /**
   * Returns the number of {@link GeneProducts}s in this {@link Fbc}.
   *  
   * @return the number of {@link GeneProducts}s in this {@link GeneProducts}.
   * @libsbml.deprecated same as {@link #getGeneProductsCount()}
   */
  public int getGeneProductsCount() {
    return isSetListOfGeneProducts() ? getListOfGeneProducts().size() : 0;
  }

  /**
   * Returns {@code true} if {@link listOfObjectives} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfObjectives} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfObjectives() {
    if ((listOfObjectives == null) || listOfObjectives.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfFluxBounds} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfFluxBounds} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfFluxBounds() {
    if ((listOfFluxBounds == null) || listOfFluxBounds.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Returns {@code true} if {@link listOfGeneProducts} contains at least one
   * element.
   *  
   * @return {@code true} if {@link listOfGeneProducts} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean isSetListOfGeneProducts() {
    if ((listOfGeneProducts == null) || listOfGeneProducts.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Sets the given {@code ListOf<Objectives>}.
   * If {@link listOfObjectives} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfObjectives
   */
  public void setListOfObjectives(ListOf<Objective> listOfObjectives) {
    unsetListOfObjectives();
    this.listOfObjectives = listOfObjectives;
    this.listOfObjectives.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfObjectives);
    }
  }

  /**
   * Sets the given {@code ListOf<FluxBounds>}.
   * If {@link listOfFluxBounds} was defined before and contains some elements,
   * they are all unset.
   *  
   * @param listOfFluxBounds
   */
  public void setListOfFluxBounds(ListOf<FluxBound> listOfFluxBounds) {
    unsetListOfFluxBounds();
    this.listOfFluxBounds = listOfFluxBounds;
    this.listOfFluxBounds.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfFluxBounds);
    }
  }

  /**
   * Sets the given {@code ListOf<GeneProducts>}.
   * If {@link listOfGeneProducts} was defined before and contains some
   * elements, they are all unset.
   *  
   * @param listOfGeneProducts
   */
  public void setListOfGeneProducts(ListOf<GeneProduct> listOfGeneProducts) {
    unsetListOfGeneProducts();
    this.listOfGeneProducts = listOfGeneProducts;
    this.listOfGeneProducts.setSBaseListType(ListOf.Type.other);

    if (isSetExtendedSBase()) {
      extendedSBase.registerChild(listOfGeneProducts);
    }
  }

  /**
   * Returns {@code true} if {@link listOfObjectives} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfObjectives} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfObjectives() {
    if (isSetListOfObjectives()) {
      ListOf<Objective> oldObjectives = this.listOfObjectives;
      this.listOfObjectives = null;
      oldObjectives.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfFluxBounds} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfFluxBounds} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfFluxBounds() {
    if (isSetListOfFluxBounds()) {
      ListOf<FluxBound> oldFluxBounds = this.listOfFluxBounds;
      this.listOfFluxBounds = null;
      oldFluxBounds.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if {@link listOfGeneProducts} contains at least one
   * element, otherwise {@code false}.
   *  
   * @return {@code true} if {@link listOfGeneProducts} contains at least one
   * element, otherwise {@code false}.
   */
  public boolean unsetListOfGeneProducts() {
    if (isSetListOfGeneProducts()) {
      ListOf<GeneProduct> oldGeneProducts = this.listOfGeneProducts;
      this.listOfGeneProducts = null;
      oldGeneProducts.fireNodeRemovedEvent();
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPackageName()
   */
  @Override
  public String getPackageName() {
    return FbcConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.ext.SBasePlugin#getPrefix()
   */
  @Override
  public String getPrefix() {
    return FbcConstants.shortLabel;
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

    if (isSetListOfObjectives()) {
      if (pos == index) {
        return getListOfObjectives();
      }
      pos++;
    }
    if (isSetListOfFluxBounds()) {
      if (pos == index) {
        return getListOfFluxBounds();
      }
      pos++;
    }
    if (isSetListOfGeneProducts()) {
      if (pos == index) {
        return getListOfGeneProducts();
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

    if (isSetListOfObjectives()) {
      count++;
    }
    if (isSetListOfFluxBounds()) {
      count++;
    }
    if (isSetListOfGeneProducts()) {
      count++;
    }
    return count;
  }

  /* hashcode method for FbcModelPlugin.
   */
  @Override
  public int hashCode() {
    final int prime = 720397;

    int hashCode = super.hashCode();

    if (isSetStrict()) {
      hashCode += prime + (getStrict() ? 1 : -1);
    }
    hashCode = prime * hashCode + ((listOfObjectives == null) ? 0 :
      listOfObjectives.hashCode());

    hashCode = prime * hashCode + ((listOfFluxBounds == null) ? 0 :
      listOfFluxBounds.hashCode());

    hashCode = prime * hashCode + ((listOfGeneProducts == null) ? 0 :
      listOfGeneProducts.hashCode());

    return hashCode;
  }

  /* (non-Javadoc)
   * see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("FbcModelPlugin [");
    builder.append("strict = ");
    builder.append(strict);
    builder.append(", ");
    builder.append("listOfObjectives = ");
    builder.append(listOfObjectives);
    builder.append(", ");
    builder.append("listOfFluxBounds = ");
    builder.append(listOfFluxBounds);
    builder.append(", ");
    builder.append("listOfGeneProducts = ");
    builder.append(listOfGeneProducts);
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

    if (isSetStrict()) {
      attributes.put(FbcConstants.shortLabel + ":" + FbcConstants.strict,
        Boolean.toString(getStrict()));
    }
    return attributes;
  }

}
