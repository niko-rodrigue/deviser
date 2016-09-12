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
import org.sbml.jsbml.ext.qual.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
@ProviderFor(ReadingParser.class)
public class QualParser extends AbstractReaderWriter implements PackageParser {

  /**
   *
   */
  private QualList groupList = QualList.none;
  /**
   *
   */
  private static final transient Logger logger = Logger.getLogger(QualParser.class);

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getNamespaceURI() {
    return QualConstants.namespaceURI;
  }

  /* (non-Javadoc)
   *  @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getShortLabel() {
    return QualConstants.shortLabel;
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
    return QualConstants.shortLabel;
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
    return QualConstants.namespaces;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#getNamespaceFor (java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public String getNamespaceFor(int level, int version, int packageVersion) {
    if (level == 3 && version == 1 && packageVersion == 1) {
      return QualConstants.namespaceURI_L3V1V1;
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
        return new QualModelPlugin((Model) sbase);
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
      QualModelPlugin ModelPlugin = (QualModelPlugin) ((Model) sbase).getExtension(QualConstants.namespaceURI);
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
      QualModelPlugin qualModel = (QualModelPlugin) model.getPlugin(QualConstants.shortLabel);
      contextObject = qualModel;
    }

    super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processEndElement(java.lang.String, java.lang.String, boolean, java.lang.Object)
   */
  @Override
  public boolean processEndElement(String elementName, String prefix, boolean isNested, Object contextObject) {

    if (elementName.equals("listOfQualitativeSpecies") || elementName.equals("listOfTransitions")) {
      groupList = QualList.none;
    }

    if (elementName.equals("listOfInputs") || elementName.equals("listOfOutputs") || elementName.equals("listOfFunctionTerms")) {
      groupList = QualList.listOfTransitions;
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
      QualModelPlugin qualModel = (QualModelPlugin) model.getPlugin(QualConstants.shortLabel);

      if (elementName.equals(QualList.listOfQualitativeSpecies.name())) {
        ListOf<QualitativeSpecies> listOfQualitativeSpecies = qualModel.getListOfQualitativeSpecies();
        groupList = QualList.listOfQualitativeSpecies;
        return listOfQualitativeSpecies;
      } else if (elementName.equals(QualList.listOfTransitions.name())) {
        ListOf<Transition> listOfTransitions = qualModel.getListOfTransitions();
        groupList = QualList.listOfTransitions;
        return listOfTransitions;
      }
    } else if (contextObject instanceof Transition) {
      Transition transition = (Transition) contextObject;

      if (elementName.equals(QualList.listOfInputs.name())) {

        ListOf<Input> listOfInputs = transition.getListOfInputs();
        groupList = QualList.listOfInputs;
        return listOfInputs;
      } else if (elementName.equals(QualList.listOfOutputs.name())) {

        ListOf<Output> listOfOutputs = transition.getListOfOutputs();
        groupList = QualList.listOfOutputs;
        return listOfOutputs;
      } else if (elementName.equals(QualList.listOfFunctionTerms.name())) {

        ListOf<FunctionTerm> listOfFunctionTerms = transition.getListOfFunctionTerms();
        groupList = QualList.listOfFunctionTerms;
        return listOfFunctionTerms;
      }
    } else if (contextObject instanceof ListOf<?>) {
      ListOf<SBase> listOf = (ListOf<SBase>) contextObject;

      if (elementName.equals(QualConstants.qualitativeSpecies) && groupList.equals(QualList.listOfQualitativeSpecies)) {
        Model model = (Model) listOf.getParentSBMLObject();
        QualModelPlugin extendedModel = (QualModelPlugin) model.getExtension (QualConstants.shortLabel);

        QualitativeSpecies qualitativeSpecies = new QualitativeSpecies();
        extendedModel.addQualitativeSpecies(qualitativeSpecies);

        return qualitativeSpecies;
      } else if (elementName.equals(QualConstants.transition) && groupList.equals(QualList.listOfTransitions)) {
        Model model = (Model) listOf.getParentSBMLObject();
        QualModelPlugin extendedModel = (QualModelPlugin) model.getExtension (QualConstants.shortLabel);

        Transition transition = new Transition();
        extendedModel.addTransition(transition);

        return transition;
      } else if (elementName.equals(QualConstants.input) && groupList.equals(QualList.listOfInputs)) {
        Transition transition = (Transition) listOf.getParentSBMLObject();

        Input input = new Input();
        transition.addInput(input);

        return input;
      } else if (elementName.equals(QualConstants.output) && groupList.equals(QualList.listOfOutputs)) {
        Transition transition = (Transition) listOf.getParentSBMLObject();

        Output output = new Output();
        transition.addOutput(output);

        return output;
      } else if (elementName.equals(QualConstants.functionTerm) && groupList.equals(QualList.listOfFunctionTerms)) {
        Transition transition = (Transition) listOf.getParentSBMLObject();

        FunctionTerm functionTerm = new FunctionTerm();
        transition.addFunctionTerm(functionTerm);

        return functionTerm;
      }
    }

    return contextObject;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.WritingParser#writeElement(org.sbml.jsbml.xml.stax.SBMLObjectForXML, java.lang.Object)
   */
  @Override
  public void writeElement(SBMLObjectForXML xmlObject, Object sbmlElementToWrite) {

    if (logger.isDebugEnabled()) {
      logger.debug("QualParser: writeElement");
    }

    if (sbmlElementToWrite instanceof SBase) {
      SBase sbase = (SBase) sbmlElementToWrite;


      if (!xmlObject.isSetName()) {

        if (sbase instanceof ListOf<?>) {
          ListOf<?> listOf = (ListOf<?>) sbase;

          if (listOf.size() > 0) {

            if (listOf.get(0) instanceof QualitativeSpecies) {
              xmlObject.setName(QualList.listOfQualitativeSpecies.toString());
            } else if (listOf.get(0) instanceof Transition) {
              xmlObject.setName(QualList.listOfTransitions.toString());
            } else if (listOf.get(0) instanceof Input) {
              xmlObject.setName(QualList.listOfInputs.toString());
            } else if (listOf.get(0) instanceof Output) {
              xmlObject.setName(QualList.listOfOutputs.toString());
            } else if (listOf.get(0) instanceof FunctionTerm) {
              xmlObject.setName(QualList.listOfFunctionTerms.toString());
            }
          }
        } else {
          xmlObject.setName(sbase.getElementName());
        }
      }
    }
  }


}
