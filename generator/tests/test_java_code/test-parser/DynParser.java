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
import org.sbml.jsbml.ext.dyn.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
@ProviderFor(ReadingParser.class)
public class DynParser extends AbstractReaderWriter implements PackageParser {

  /**
   *
   */
  private DynList groupList = DynList.none;
  /**
   *
   */
  private static final transient Logger logger = Logger.getLogger(DynParser.class);

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getNamespaceURI() {
    return DynConstants.namespaceURI;
  }

  /* (non-Javadoc)
   *  @see org.sbml.jsbml.xml.parsers.AbstractReaderWriter#getNamespaceURI()
   */
  @Override
  public String getShortLabel() {
    return DynConstants.shortLabel;
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
    return DynConstants.shortLabel;
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
    return DynConstants.namespaces;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#getNamespaceFor (java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public String getNamespaceFor(int level, int version, int packageVersion) {
    if (level == 3 && version == 1 && packageVersion == 1) {
      return DynConstants.namespaceURI_L3V1V1;
    }
    return null;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.PackageParser#createPluginFor(org.sbml.jsbml.SBase)
   */
  @Override
  public SBasePlugin createPluginFor(SBase sbase) {

    if (sbase != null) {
      if (sbase instanceof SBase) {
        return new DynSBasePlugin((SBase) sbase);
      }
      if (sbase instanceof Event) {
        return new DynEventPlugin((Event) sbase);
      }
      if (sbase instanceof Compartment) {
        return new DynCompartmentPlugin((Compartment) sbase);
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

    if (sbase instanceof SBase) {
      DynSBasePlugin SBasePlugin = (DynSBasePlugin) ((SBase) sbase).getExtension(DynConstants.namespaceURI);
    }
    if (sbase instanceof Event) {
      DynEventPlugin EventPlugin = (DynEventPlugin) ((Event) sbase).getExtension(DynConstants.namespaceURI);
    }
    if (sbase instanceof Compartment) {
      DynCompartmentPlugin CompartmentPlugin = (DynCompartmentPlugin) ((Compartment) sbase).getExtension(DynConstants.namespaceURI);
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

    if (contextObject instanceof SBase) {
      SBase sBase = (SBase) contextObject;
      DynSBasePlugin dynSBase = (DynSBasePlugin) sBase.getPlugin(DynConstants.shortLabel);
      contextObject = dynSBase;
    }
    if (contextObject instanceof Event) {
      Event event = (Event) contextObject;
      DynEventPlugin dynEvent = (DynEventPlugin) event.getPlugin(DynConstants.shortLabel);
      contextObject = dynEvent;
    }
    if (contextObject instanceof Compartment) {
      Compartment compartment = (Compartment) contextObject;
      DynCompartmentPlugin dynCompartment = (DynCompartmentPlugin) compartment.getPlugin(DynConstants.shortLabel);
      contextObject = dynCompartment;
    }

    super.processAttribute(elementName, attributeName, value, uri, prefix, isLastAttribute, contextObject);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processEndElement(java.lang.String, java.lang.String, boolean, java.lang.Object)
   */
  @Override
  public boolean processEndElement(String elementName, String prefix, boolean isNested, Object contextObject) {

    if (elementName.equals("listOfDynElements") || elementName.equals("listOfSpatialComponents")) {
      groupList = DynList.none;
    }

    return true;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.ReadingParser#processStartElement(java.lang.String, java.lang.String, boolean, boolean,
   */
  @Override
  public Object processStartElement(String elementName, String uri, String prefix, boolean hasAttributes, boolean hasNamespaces, Object contextObject) {


    if (contextObject instanceof SBase) {
      SBase sBase = (SBase) contextObject;
      DynSBasePlugin dynSBase = (DynSBasePlugin) sBase.getPlugin(DynConstants.shortLabel);
    } else if (contextObject  instanceof Event) {
      Event event = (Event) contextObject;
      DynEventPlugin dynEvent = (DynEventPlugin) event.getPlugin(DynConstants.shortLabel);

      if (elementName.equals(DynList.listOfDynElements.name())) {
        ListOf<DynElement> listOfDynElements = dynEvent.getListOfDynElements();
        groupList = DynList.listOfDynElements;
        return listOfDynElements;
      }
    } else if (contextObject  instanceof Compartment) {
      Compartment compartment = (Compartment) contextObject;
      DynCompartmentPlugin dynCompartment = (DynCompartmentPlugin) compartment.getPlugin(DynConstants.shortLabel);

      if (elementName.equals(DynList.listOfSpatialComponents.name())) {
        ListOf<SpatialComponent> listOfSpatialComponents = dynCompartment.getListOfSpatialComponents();
        groupList = DynList.listOfSpatialComponents;
        return listOfSpatialComponents;
      }
    } else if (contextObject instanceof ListOf<?>) {
      ListOf<SBase> listOf = (ListOf<SBase>) contextObject;

    }

    return contextObject;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.xml.parsers.WritingParser#writeElement(org.sbml.jsbml.xml.stax.SBMLObjectForXML, java.lang.Object)
   */
  @Override
  public void writeElement(SBMLObjectForXML xmlObject, Object sbmlElementToWrite) {

    if (logger.isDebugEnabled()) {
      logger.debug("DynParser: writeElement");
    }

    if (sbmlElementToWrite instanceof SBase) {
      SBase sbase = (SBase) sbmlElementToWrite;


      if (!xmlObject.isSetName()) {

        if (sbase instanceof ListOf<?>) {
          ListOf<?> listOf = (ListOf<?>) sbase;

          if (listOf.size() > 0) {

            if (listOf.get(0) instanceof DynElement) {
              xmlObject.setName(DynList.listOfDynElements.toString());
            } else if (listOf.get(0) instanceof SpatialComponent) {
              xmlObject.setName(DynList.listOfSpatialComponents.toString());
            }
          }
        } else {
          xmlObject.setName(sbase.getElementName());
        }
      }
    }
  }


}
