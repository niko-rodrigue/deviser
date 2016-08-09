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
import org.sbml.jsbml.ext.spatial.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
@ProviderFor(ReadingParser.class)
public class SpatialParser extends AbstractReaderWriter implements PackageParser {

  /**
   *
   */
  private SpatialList groupList = SpatialList.none;
  /**
   *
   */
  private static final transient Logger logger = Logger.getLogger(SpatialParser.class);

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getNamespaceURI() {
    return SpatialConstants.namespaceURI;
  }

  /* (non-Javadoc)
   *  @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getShortLabel() {
    return SpatialConstants.shortLabel;
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
    return SpatialConstants.shortLabel;
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
    return SpatialConstants.namespaces;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#getNamespaceFor (java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public String getNamespaceFor(int level, int version, int packageVersion) {
    if (level == 3 && version == 1 && packageVersion == 1) {
      return SpatialConstants.namespaceURI_L3V1V1;
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
        return new SpatialModelPlugin((Model) sbase);
      }
      if (sbase instanceof Compartment) {
        return new SpatialCompartmentPlugin((Compartment) sbase);
      }
      if (sbase instanceof Species) {
        return new SpatialSpeciesPlugin((Species) sbase);
      }
      if (sbase instanceof Parameter) {
        return new SpatialParameterPlugin((Parameter) sbase);
      }
      if (sbase instanceof Reaction) {
        return new SpatialReactionPlugin((Reaction) sbase);
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
      SpatialModelPlugin ModelPlugin = (SpatialModelPlugin) ((Model) sbase).getExtension(SpatialConstants.namespaceURI);
    }
    if (sbase instanceof Compartment) {
      SpatialCompartmentPlugin CompartmentPlugin = (SpatialCompartmentPlugin) ((Compartment) sbase).getExtension(SpatialConstants.namespaceURI);
    }
    if (sbase instanceof Species) {
      SpatialSpeciesPlugin SpeciesPlugin = (SpatialSpeciesPlugin) ((Species) sbase).getExtension(SpatialConstants.namespaceURI);
    }
    if (sbase instanceof Parameter) {
      SpatialParameterPlugin ParameterPlugin = (SpatialParameterPlugin) ((Parameter) sbase).getExtension(SpatialConstants.namespaceURI);
    }
    if (sbase instanceof Reaction) {
      SpatialReactionPlugin ReactionPlugin = (SpatialReactionPlugin) ((Reaction) sbase).getExtension(SpatialConstants.namespaceURI);
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
      SpatialModelPlugin spatialModel = (SpatialModelPlugin) model.getPlugin(SpatialConstants.shortLabel);
      contextObject = spatialModel;
    }
    if (contextObject instanceof Compartment) {
      Compartment compartment = (Compartment) contextObject;
      SpatialCompartmentPlugin spatialCompartment = (SpatialCompartmentPlugin) compartment.getPlugin(SpatialConstants.shortLabel);
      contextObject = spatialCompartment;
    }
    if (contextObject instanceof Species) {
      Species species = (Species) contextObject;
      SpatialSpeciesPlugin spatialSpecies = (SpatialSpeciesPlugin) species.getPlugin(SpatialConstants.shortLabel);
      contextObject = spatialSpecies;
    }
    if (contextObject instanceof Parameter) {
      Parameter parameter = (Parameter) contextObject;
      SpatialParameterPlugin spatialParameter = (SpatialParameterPlugin) parameter.getPlugin(SpatialConstants.shortLabel);
      contextObject = spatialParameter;
    }
    if (contextObject instanceof Reaction) {
      Reaction reaction = (Reaction) contextObject;
      SpatialReactionPlugin spatialReaction = (SpatialReactionPlugin) reaction.getPlugin(SpatialConstants.shortLabel);
      contextObject = spatialReaction;
    }

    super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processEndElement(java.lang.String, java.lang.String, boolean, java.lang.Object)
   */
  @Override
  public boolean processEndElement(String elementName, String prefix, boolean isNested, Object contextObject) {

    if (elementName.equals("listOfDomainTypes") || elementName.equals("listOfDomains") || elementName.equals("listOfInteriorPoints") ||      elementName.equals("listOfAdjacentDomains") || elementName.equals("listOfGeometryDefinitions") || elementName.equals("listOfCoordinateComponents")        || elementName.equals("listOfSampledFields") || elementName.equals("listOfSampledVolumes") || elementName.equals("listOfAnalyticVolumes") ||          elementName.equals("listOfParametricObjects") || elementName.equals("listOfCSGObjects") || elementName.equals("listOfCSGNodes") ||            elementName.equals("listOfCoordinateReferences") || elementName.equals("listOfOrdinalMappings")) {
      groupList = SpatialList.none;
    }

    if (elementName.equals("listOfInteriorPoints")) {
      groupList = SpatialList.listOfDomains;
    }

    if (elementName.equals("listOfSampledVolumes")) {
      groupList = SpatialList.listOfSampledFieldGeometrys;
    }

    if (elementName.equals("listOfAnalyticVolumes")) {
      groupList = SpatialList.listOfAnalyticGeometrys;
    }

    if (elementName.equals("listOfParametricObjects")) {
      groupList = SpatialList.listOfParametricGeometrys;
    }

    if (elementName.equals("listOfCSGObjects")) {
      groupList = SpatialList.listOfCSGeometrys;
    }

    if (elementName.equals("listOfCSGNodes")) {
      groupList = SpatialList.listOfCSGSetOperators;
    }

    if (elementName.equals("listOfCoordinateComponents") || elementName.equals("listOfDomainTypes") || elementName.equals("listOfDomains") ||      elementName.equals("listOfAdjacentDomains") || elementName.equals("listOfGeometryDefinitions") || elementName.equals("listOfSampledFields")) {
      groupList = SpatialList.listOfGeometrys;
    }

    if (elementName.equals("listOfGeometryDefinitions") || elementName.equals("listOfOrdinalMappings")) {
      groupList = SpatialList.listOfMixedGeometrys;
    }

    return true;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processStartElement(java.lang.String, java.lang.String, boolean, boolean,
   */
  @Override
  public Object processStartElement(String elementName, String uri, String prefix, boolean hasAttributes, boolean hasNamespaces, Object contextObject) {

    if (logger.isDebugEnabled()) {
      logger.debug("SpatialParser: writeElement");
    }

    if (contextObject instanceof Model) {
      Model model = (Model) contextObject;
      SpatialModelPlugin spatialModel = (SpatialModelPlugin) model.getPlugin(SpatialConstants.shortLabel);
    }    else if (contextObject instanceof Compartment) {
      Compartment compartment = (Compartment) contextObject;
      SpatialCompartmentPlugin spatialCompartment = (SpatialCompartmentPlugin) compartment.getPlugin(SpatialConstants.shortLabel);
    }    else if (contextObject instanceof Species) {
      Species species = (Species) contextObject;
      SpatialSpeciesPlugin spatialSpecies = (SpatialSpeciesPlugin) species.getPlugin(SpatialConstants.shortLabel);
    }    else if (contextObject instanceof Parameter) {
      Parameter parameter = (Parameter) contextObject;
      SpatialParameterPlugin spatialParameter = (SpatialParameterPlugin) parameter.getPlugin(SpatialConstants.shortLabel);
    }    else if (contextObject instanceof Reaction) {
      Reaction reaction = (Reaction) contextObject;
      SpatialReactionPlugin spatialReaction = (SpatialReactionPlugin) reaction.getPlugin(SpatialConstants.shortLabel);
    }

    return contextObject;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.WritingParser#writeElement(org.sbml.jsbml.xml.stax.SBMLObjectForXML, java.lang.Object)
   */
  @Override
  public void writeElement(SBMLObjectForXML xmlObject, Object sbmlElementToWrite) {

    if (logger.isDebugEnabled()) {
      logger.debug("SpatialParser: writeElement");
    }

    if (sbmlElementToWrite instanceof SBase) {
      SBase sbase = (SBase) sbmlElementToWrite;


      if (!xmlObject.isSetName()) {

        if (sbase instanceof ListOf<?>) {
          ListOf<?> listOf = (ListOf<?>) sbase;

          if (listOf.size() > 0) {

            if (listOf.get(0) instanceof DomainType) {
              xmlObject.setName(SpatialList.listOfDomainTypes.toString());
            }            else if (listOf.get(0) instanceof Domain) {
              xmlObject.setName(SpatialList.listOfDomains.toString());
            }            else if (listOf.get(0) instanceof InteriorPoint) {
              xmlObject.setName(SpatialList.listOfInteriorPoints.toString());
            }            else if (listOf.get(0) instanceof AdjacentDomains) {
              xmlObject.setName(SpatialList.listOfAdjacentDomains.toString());
            }            else if (listOf.get(0) instanceof GeometryDefinition) {
              xmlObject.setName(SpatialList.listOfGeometryDefinitions.toString());
            }            else if (listOf.get(0) instanceof CoordinateComponent) {
              xmlObject.setName(SpatialList.listOfCoordinateComponents.toString());
            }            else if (listOf.get(0) instanceof SampledField) {
              xmlObject.setName(SpatialList.listOfSampledFields.toString());
            }            else if (listOf.get(0) instanceof SampledVolume) {
              xmlObject.setName(SpatialList.listOfSampledVolumes.toString());
            }            else if (listOf.get(0) instanceof AnalyticVolume) {
              xmlObject.setName(SpatialList.listOfAnalyticVolumes.toString());
            }            else if (listOf.get(0) instanceof ParametricObject) {
              xmlObject.setName(SpatialList.listOfParametricObjects.toString());
            }            else if (listOf.get(0) instanceof CSGObject) {
              xmlObject.setName(SpatialList.listOfCSGObjects.toString());
            }            else if (listOf.get(0) instanceof CSGNode) {
              xmlObject.setName(SpatialList.listOfCSGNodes.toString());
            }            else if (listOf.get(0) instanceof CoordinateReference) {
              xmlObject.setName(SpatialList.listOfCoordinateReferences.toString());
            }            else if (listOf.get(0) instanceof OrdinalMapping) {
              xmlObject.setName(SpatialList.listOfOrdinalMappings.toString());
            }
          }
        } else {
          xmlObject.setName(sbase.getElementName());
        }
      }
    }
  }


}
