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
package org.sbml.jsbml.ext.dyn;

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
public class DynConstants {

  /**
   * The namespace URI of this parser for SBML level 3, version 1 and package
   * version 1.
   */
  public static final String namespaceURI_L3V1V1 = "http://www.sbml.org/sbml/level3/version1/dyn/version1";
  /**
   * The latest namespace URI of this parser, this value can change between
   * releases.
   */
  public static final String namespaceURI = namespaceURI_L3V1V1;
  /**
   *
   */
  public static final ResourceBundle bundle = ResourceManager.getBundle("org.sbml.jsbml.ext.dyn.Messages");
  /**
   *
   */
  public static final String shortLabel = "dyn";
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
  public static final String packageName = "Dynamic Processes";
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
  private static final long     serialVersionUID = 34353575816296757L;
  /**
   *
   */
  public static final String idRef = "idRef";
  /**
   *
   */
  public static final String metaIdRef = "metaIdRef";
  /**
   *
   */
  public static final String spatialIndex = "spatialIndex";
  /**
   *
   */
  public static final String variable = "variable";
  /**
   *
   */
  public static final String dynElement = "DynElement";
  /**
   *
   */
  public static final String spatialComponent = "SpatialComponent";
  /**
   *
   */
  public static final String cboTerm = "cboTerm";
  /**
   *
   */
  public static final String applyToAll = "applyToAll";
  /**
   *  
   */
  public static String getNamespaceURI(int level, int version) {
    return namespaceURI;
  }

}
