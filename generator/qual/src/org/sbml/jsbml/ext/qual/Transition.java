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
package org.sbml.jsbml.ext.qual

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
public class Transition {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -6048861420699176889L;

  /**
   */
  public Transition() {
    super();
    initDefaults();
  }

  /**
   * @param level @param version
   */
  public Transition(int level, int version, int pkgVersion) {
    : SBase(level, version) {
    , mId ("") {
    , mName ("") {
    , mInputs (level, version, pkgVersion) {
    , mOutputs (level, version, pkgVersion) {
    , mFunctionTerms (level, version, pkgVersion) {
    setSBMLNamespacesAndOwn(new QualPkgNamespaces(level, version, pkgVersion));
    connectToChild();
  }

  /**
   * Creates a new Transition using the given QualPkgNamespaces object.
   */
  public Transition(QualPkgNamespaces *qualns) {
    : SBase(qualns) {
    , mId ("") {
    , mName ("") {
    , mInputs (qualns) {
    , mOutputs (qualns) {
    , mFunctionTerms (qualns) {
    setElementNamespace(qualns->getURI());
    connectToChild();
    loadPlugins(qualns);
  }

}
