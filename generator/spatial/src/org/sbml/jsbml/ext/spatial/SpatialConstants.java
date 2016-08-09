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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.tree.TreeNode;

import org.sbml.jsbml.util.ResourceManager;
import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class SpatialConstants {

  /**
   * The namespace URI of this parser for SBML level 3, version 1 and package
   * version 1.
   */
  public static final String namespaceURI_L3V1V1 = "http://www.sbml.org/sbml/level3/version1/spatial/version1";
  /**
   * The latest namespace URI of this parser, this value can change between
   * releases.
   */
  public static final String namespaceURI = namespaceURI_L3V1V1;
  /**
   *
   */
  public static final ResourceBundle bundle = ResourceManager.getBundle("org.sbml.jsbml.ext.spatial.Messages");
  /**
   *
   */
  public static final String shortLabel = "spatial";
  /**
   *
   */
  public static final int MIN_SBML_LEVEL = 3;
  /**
   *
   */
  public static final int MIN_SBML_VERSION = 1;
  /**
   *
   */
  public static final int PACKAGE_VERSION = 1;
  /**
   *
   */
  public static final List<String> namespaces;
  /**
   *
   */
  public static final String packageName = "Spatial Processes";
  /**
   *
   */
  static {
    namespaces = new ArrayList<String>();
    namespaces.add(namespaceURI_L3V1V1);
  }
  /**
   * Generated serial version identifier.
   */
  private static final long     serialVersionUID = 62767973167520440L;
  /**
   *
   */
  public static final String spatialDimensions = "spatialDimensions";
  /**
   *
   */
  public static final String domainType = "domainType";
  /**
   *
   */
  public static final String interiorPoint = "interiorPoint";
  /**
   *
   */
  public static final String listOfInteriorPoints = "listOfInteriorPoints";
  /**
   *
   */
  public static final String coord1 = "coord1";
  /**
   *
   */
  public static final String coord2 = "coord2";
  /**
   *
   */
  public static final String coord3 = "coord3";
  /**
   *
   */
  public static final String value = "value";
  /**
   *
   */
  public static final String domain1 = "domain1";
  /**
   *
   */
  public static final String domain2 = "domain2";
  /**
   *
   */
  public static final String isActive = "isActive";
  /**
   *
   */
  public static final String unitSize = "unitSize";
  /**
   *
   */
  public static final String type = "type";
  /**
   *
   */
  public static final String unit = "unit";
  /**
   *
   */
  public static final String boundaryMin = "boundaryMin";
  /**
   *
   */
  public static final String boundaryMax = "boundaryMax";
  /**
   *
   */
  public static final String sampledVolume = "sampledVolume";
  /**
   *
   */
  public static final String listOfSampledVolumes = "listOfSampledVolumes";
  /**
   *
   */
  public static final String sampledField = "sampledField";
  /**
   *
   */
  public static final String dataType = "dataType";
  /**
   *
   */
  public static final String numSamples1 = "numSamples1";
  /**
   *
   */
  public static final String numSamples2 = "numSamples2";
  /**
   *
   */
  public static final String numSamples3 = "numSamples3";
  /**
   *
   */
  public static final String interpolationType = "interpolationType";
  /**
   *
   */
  public static final String compression = "compression";
  /**
   *
   */
  public static final String samples = "samples";
  /**
   *
   */
  public static final String samplesLength = "samplesLength";
  /**
   *
   */
  public static final String sampledValue = "sampledValue";
  /**
   *
   */
  public static final String minValue = "minValue";
  /**
   *
   */
  public static final String maxValue = "maxValue";
  /**
   *
   */
  public static final String analyticVolume = "analyticVolume";
  /**
   *
   */
  public static final String listOfAnalyticVolumes = "listOfAnalyticVolumes";
  /**
   *
   */
  public static final String functionType = "functionType";
  /**
   *
   */
  public static final String ordinal = "ordinal";
  /**
   *
   */
  public static final String math = "math";
  /**
   *
   */
  public static final String spatialPoints = "spatialPoints";
  /**
   *
   */
  public static final String parametricObject = "parametricObject";
  /**
   *
   */
  public static final String listOfParametricObjects = "listOfParametricObjects";
  /**
   *
   */
  public static final String polygonType = "polygonType";
  /**
   *
   */
  public static final String pointIndex = "pointIndex";
  /**
   *
   */
  public static final String pointIndexLength = "pointIndexLength";
  /**
   *
   */
  public static final String csgObject = "csgObject";
  /**
   *
   */
  public static final String listOfCsgObjects = "listOfCsgObjects";
  /**
   *
   */
  public static final String csgNode = "csgNode";
  /**
   *
   */
  public static final String translateX = "translateX";
  /**
   *
   */
  public static final String translateY = "translateY";
  /**
   *
   */
  public static final String translateZ = "translateZ";
  /**
   *
   */
  public static final String rotateX = "rotateX";
  /**
   *
   */
  public static final String rotateY = "rotateY";
  /**
   *
   */
  public static final String rotateZ = "rotateZ";
  /**
   *
   */
  public static final String rotateAngleInRadians = "rotateAngleInRadians";
  /**
   *
   */
  public static final String scaleX = "scaleX";
  /**
   *
   */
  public static final String scaleY = "scaleY";
  /**
   *
   */
  public static final String scaleZ = "scaleZ";
  /**
   *
   */
  public static final String forwardTransformation = "forwardTransformation";
  /**
   *
   */
  public static final String reverseTransformation = "reverseTransformation";
  /**
   *
   */
  public static final String components = "components";
  /**
   *
   */
  public static final String componentsLength = "componentsLength";
  /**
   *
   */
  public static final String primitiveType = "primitiveType";
  /**
   *
   */
  public static final String csgObjectRef = "csgObjectRef";
  /**
   *
   */
  public static final String operationType = "operationType";
  /**
   *
   */
  public static final String complementA = "complementA";
  /**
   *
   */
  public static final String complementB = "complementB";
  /**
   *
   */
  public static final String spatialRef = "spatialRef";
  /**
   *
   */
  public static final String variable = "variable";
  /**
   *
   */
  public static final String coordinateReference1 = "coordinateReference1";
  /**
   *
   */
  public static final String coordinateReference2 = "coordinateReference2";
  /**
   *
   */
  public static final String coordinate = "coordinate";
  /**
   *
   */
  public static final String coordinateBoundary = "coordinateBoundary";
  /**
   *
   */
  public static final String boundaryDomainType = "boundaryDomainType";
  /**
   *
   */
  public static final String coordinateSystem = "coordinateSystem";
  /**
   *
   */
  public static final String coordinateComponent = "coordinateComponent";
  /**
   *
   */
  public static final String listOfCoordinateComponents = "listOfCoordinateComponents";
  /**
   *
   */
  public static final String domain = "domain";
  /**
   *
   */
  public static final String listOfDomains = "listOfDomains";
  /**
   *
   */
  public static final String adjacentDomains = "adjacentDomains";
  /**
   *
   */
  public static final String listOfAdjacentDomainss = "listOfAdjacentDomainss";
  /**
   *
   */
  public static final String geometryDefinition = "geometryDefinition";
  /**
   *
   */
  public static final String listOfGeometryDefinitions = "listOfGeometryDefinitions";
  /**
   *
   */
  public static final String ordinalMapping = "ordinalMapping";
  /**
   *
   */
  public static final String listOfOrdinalMappings = "listOfOrdinalMappings";
  /**
   *
   */
  public static final String arrayData = "arrayData";
  /**
   *
   */
  public static final String arrayDataLength = "arrayDataLength";
  /**
   *
   */
  public static final String boundary = "Boundary";
  /**
   *
   */
  public static final String compartmentMapping = "CompartmentMapping";
  /**
   *
   */
  public static final String sampledFieldGeometry = "SampledFieldGeometry";
  /**
   *
   */
  public static final String analyticGeometry = "AnalyticGeometry";
  /**
   *
   */
  public static final String parametricGeometry = "ParametricGeometry";
  /**
   *
   */
  public static final String csgeometry = "CSGeometry";
  /**
   *
   */
  public static final String csgTransformation = "CSGTransformation";
  /**
   *
   */
  public static final String csgTranslation = "CSGTranslation";
  /**
   *
   */
  public static final String csgRotation = "CSGRotation";
  /**
   *
   */
  public static final String csgScale = "CSGScale";
  /**
   *
   */
  public static final String csgHomogeneousTransformation = "CSGHomogeneousTransformation";
  /**
   *
   */
  public static final String transformationComponents = "TransformationComponents";
  /**
   *
   */
  public static final String csgPrimitive = "CSGPrimitive";
  /**
   *
   */
  public static final String csgPseudoPrimitive = "CSGPseudoPrimitive";
  /**
   *
   */
  public static final String csgSetOperator = "CSGSetOperator";
  /**
   *
   */
  public static final String spatialSymbolReference = "SpatialSymbolReference";
  /**
   *
   */
  public static final String diffusionCoefficient = "DiffusionCoefficient";
  /**
   *
   */
  public static final String advectionCoefficient = "AdvectionCoefficient";
  /**
   *
   */
  public static final String boundaryCondition = "BoundaryCondition";
  /**
   *
   */
  public static final String geometry = "Geometry";
  /**
   *
   */
  public static final String coordinateReference = "CoordinateReference";
  /**
   *
   */
  public static final String mixedGeometry = "MixedGeometry";
  /**
   *
   */
  public static final String isSpatial = "isSpatial";
  /**
   *
   */
  public static final String isLocal = "isLocal";
  /**
   *  
   */
  public static String getNamespaceURI(int level, int version) {
    return namespaceURI;
  }

}
