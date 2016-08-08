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
package org.sbml.jsbml.xml.parsers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.tree.TreeNode;
import org.apache.log4j.Logger;
import org.mangosdk.spi.ProviderFor;

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;
import org.sbml.jsbml.xml.stax.SBMLObjectForXML;
import org.sbml.jsbml.ext.SBasePlugin;
import org.sbml.jsbml.ext.fbc.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
@ProviderFor(ReadingParser.class)
public class FbcParser extends AbstractReaderWriter implements PackageParser {

  /**
   *
   */
  private FbcList groupList = FbcList.none;
  /**
   *
   */
  private static final transient Logger logger = Logger.getLogger(FbcParser.class);

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getNamespaceURI() {
    return FbcConstants.namespaceURI;
  }

  /* (non-Javadoc)
   *  @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getShortLabel() {
    return FbcConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#isRequired()
   */
  @Override
  public boolean isRequired() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#getPackageName()
   */
  @Override
  public String getPackageName() {
    return FbcConstants.shortLabel;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#getPackageNamespaces()
   */
  @Override
  public List<String> getPackageNamespaces() {
    return getNamespaces();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#getNamespaces()
   */
  @Override
  public List<String> getNamespaces() {
    return FbcConstants.namespaces;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#getNamespaceFor (java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public String getNamespaceFor(int level, int version, int packageVersion) {
    if (level == 3 && version == 1 && packageVersion == 1) {
      return FbcConstants.namespaceURI_L3V1V1;
    }
    return null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#createPluginFor(org.sbml.jsbml.SBase)
   */
  @Override
  public SBasePlugin createPluginFor(SBase sbase) {

    if (sbase != null) {
      if (sbase instanceof Model) {
        return new FbcModelPlugin((Model) sbase);
      }
      if (sbase instanceof Species) {
        return new FbcSpeciesPlugin((Species) sbase);
      }
      if (sbase instanceof Reaction) {
        return new FbcReactionPlugin((Reaction) sbase);
      }
    }

    return null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.WritingParser#getListOfSBMLElementsToWrite(Object sbase)
   */
  @Override
  public List<Object> getListOfSBMLElementsToWrite(Object sbase) {
    if (logger.isDebugEnabled()) {
      logger.debug("getListOfSBMLElementsToWrite: " + sbase.getClass().getCanonicalName());
    }
    List<Object> listOfElementsToWrite = new ArrayList<Object>();

    if (sbase instanceof Model) {
      FbcModelPlugin ModelPlugin = (FbcModelPlugin) ((Model) sbase).getExtension(FbcConstants.namespaceURI);
    }
    if (sbase instanceof Species) {
      FbcSpeciesPlugin SpeciesPlugin = (FbcSpeciesPlugin) ((Species) sbase).getExtension(FbcConstants.namespaceURI);
    }
    if (sbase instanceof Reaction) {
      FbcReactionPlugin ReactionPlugin = (FbcReactionPlugin) ((Reaction) sbase).getExtension(FbcConstants.namespaceURI);
    }
    return listOfElementsToWrite;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processAttribute(String elementName, String attributeName, String value, String
   */
  @Override
  public void processAttribute(String elementName, 
                               String attributeName, 
                               String value, 
                               String uri, 
                               String prefix, 
                               boolean isLastAttribute, 
                               Object contextObject) {

    logger.debug("processAttribute -> " + prefix + ":" + attributeName + " = " + value + " (" + contextObject.getClass().getName() + ")");

    if (contextObject instanceof Model) {
      Model model = (Model) contextObject;
      FbcModelPlugin fbcModel = (FbcModelPlugin) model.getPlugin(FbcConstants.shortLabel);
      contextObject = fbcModel;
    }
    if (contextObject instanceof Species) {
      Species species = (Species) contextObject;
      FbcSpeciesPlugin fbcSpecies = (FbcSpeciesPlugin) species.getPlugin(FbcConstants.shortLabel);
      contextObject = fbcSpecies;
    }
    if (contextObject instanceof Reaction) {
      Reaction reaction = (Reaction) contextObject;
      FbcReactionPlugin fbcReaction = (FbcReactionPlugin) reaction.getPlugin(FbcConstants.shortLabel);
      contextObject = fbcReaction;
    }

    super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processEndElement(java.lang.String, java.lang.String, boolean, java.lang.Object)
   */
  @Override
  public boolean processEndElement(String elementName, String prefix, boolean isNested, Object contextObject) {

    if (elementName.equals("listOfFluxBounds") || elementName.equals("listOfObjectives") || elementName.equals("listOfFluxObjectives") ||      elementName.equals("listOfGeneProducts") || elementName.equals("listOfAssociations")) {
      groupList = FbcList.none;
    }

    if (elementName.equals("listOfFluxObjectives")) {
      groupList = FbcList.listOfObjectives;
    }

    if (elementName.equals("listOfAssociations")) {
      groupList = FbcList.listOfFbcAnds;
    }

    if (elementName.equals("listOfAssociations")) {
      groupList = FbcList.listOfFbcOrs;
    }

    if (elementName.equals("listOfAssociations")) {
      groupList = FbcList.listOfGeneProductAssociations;
    }

    return true;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processStartElement(java.lang.String, java.lang.String, boolean, boolean,
   */
  @Override
  public Object processStartElement(String elementName, String uri, String prefix, boolean hasAttributes, boolean hasNamespaces, Object contextObject) {

    if (contextObject instanceof Model) {
      Model model = (Model) contextObject;
      FbcModelPlugin fbcModel = (FbcModelPlugin) model.getPlugin(FbcConstants.shortLabel);


      if (elementName.equals(FbcList.listOfObjectives.name())) {
        ListOf<Objective> listOfObjectives = fbcModel.getListOfObjectives();
        groupList = FbcList.listOfObjectives;
        return listOfObjectives;
      }

      if (elementName.equals(FbcList.listOfFluxBounds.name())) {
        ListOf<FluxBound> listOfFluxBounds = fbcModel.getListOfFluxBounds();
        groupList = FbcList.listOfFluxBounds;
        return listOfFluxBounds;
      }

      if (elementName.equals(FbcList.listOfGeneProducts.name())) {
        ListOf<GeneProduct> listOfGeneProducts = fbcModel.getListOfGeneProducts();
        groupList = FbcList.listOfGeneProducts;
        return listOfGeneProducts;
      }
    }    else if (contextObject instanceof Species) {
      Species species = (Species) contextObject;
      FbcSpeciesPlugin fbcSpecies = (FbcSpeciesPlugin) species.getPlugin(FbcConstants.shortLabel);

    }    else if (contextObject instanceof Reaction) {
      Reaction reaction = (Reaction) contextObject;
      FbcReactionPlugin fbcReaction = (FbcReactionPlugin) reaction.getPlugin(FbcConstants.shortLabel);

    }

    return contextObject;
  }

