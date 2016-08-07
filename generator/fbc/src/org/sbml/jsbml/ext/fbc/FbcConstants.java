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
public class FbcConstants {

  /**
   * The namespace URI of this parser for SBML level 0, version 0 and package
   * version 1.
   */
  public static final String namespaceURI_L0V0V1 = "http://www.sbml.org/sbml/level0/version0/fbc/version1";
  /**
   * The latest namespace URI of this parser, this value can change between
   * releases.
   */
  public static final String namespaceURI = namespaceURI_L0V0V1;
  /**
   *
   */
  public static final ResourceBundle bundle = ResourceManager.getBundle("org.sbml.jsbml.ext.fbc.Messages");
  /**
   *
   */
  public static final String shortLabel = "fbc";
  /**
   *
   */
  public static final int MIN_SBML_LEVEL = 0;
  /**
   *
   */
  public static final int MIN_SBML_VERSION = 0;
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
  public static final String packageName = "Flux Balance Constraints";
  /**
   *
   */
  static {
    namespaces = new ArrayList<String>();
    namespaces.add(namespaceURI_L0V0V1);
  }
  /**
   * Generated serial version identifier.
   */
  private static final long     serialVersionUID = 18507804571772396L;
  /**
   *
   */
  public static final String reaction = "reaction";
  /**
   *
   */
  public static final String operation = "operation";
  /**
   *
   */
  public static final String value = "value";
  /**
   *
   */
  public static final String coefficient = "coefficient";
  /**
   *
   */
  public static final String type = "type";
  /**
   *
   */
  public static final String fluxObjective = "fluxObjective";
  /**
   *
   */
  public static final String listOfFluxObjectives = "listOfFluxObjectives";
  /**
   *
   */
  public static final String fluxBound = "FluxBound";
  /**
   *
   */
  public static final String objective = "Objective";
  /**
   *  
   */
  public static String getNamespaceURI(int level, int version) {
    return namespaceURI;
  }

}
