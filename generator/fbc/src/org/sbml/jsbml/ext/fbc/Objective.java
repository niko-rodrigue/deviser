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

import org.sbml.jsbml.*;
import org.sbml.jsbml.util.*;
import org.sbml.jsbml.util.filters.*;

/**
 * @author Deviser
 * @version $Rev: 2465 $
 * @since 1.2
 * @date $Date: $
 */
public class Objective extends AbstractNamedSBase implements UniqueNamedSBase {

  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = 29275439085716050L;
  /**
   *
   */
  private FbcType type;

  /**
   *  
   */
  public Objective() {
    super();
    initDefaults();
  }

  /**
   * @param level
   * @param version
   */
  public Objective(int level, int version) {
    this(null, null, level, version);
  }

  /**
   * @param id
   */
  public Objective(String id) {
    super(id);
    initDefaults();
  }

  /**
   * @param id
   * @param level
   * @param version
   */
  public Objective(String id, int level, int version) {
    this(id, null, level, version);
  }

  /**
   * @param id
   * @param name
   * @param level
   * @param version
   */
  public Objective(String id, String name, int level, int version) {
    super(id, name, level, version);

    if (getLevelAndVersion().compareTo(Integer.valueOf(3), Integer.valueOf(1)) < 0) {
      throw new LevelVersionError(getElementName(), level, version);
    }
    initDefaults();
  }

  /**
   * @param orig the Objective instance to copy.
   */
  public Objective(Objective orig) {
    super(orig);

    if (orig.isSetType()) {
      setType(orig.getType());
    }
    if (orig.isSetFluxObjective()) {
      setFluxObjective(orig.getFluxObjective());
    }  }

  /**
   *  
   */
  public void initDefaults() {
    setPackageVersion(-1);
    packageName = FbcConstants.shortLabel;
    type = null;
    fluxObjective = null;
  }

  /* Assignment operator for Objective.
   */
  @Override
  public boolean equals(Object object) {
    boolean equals = super.equals(object);

    if (equals) {
      Objective obj = (Objective) object;

      equals &= obj.isSetType() == isSetType();
      if (equals && isSetType()) {
        equals &= (obj.getType() == getType());
      }
      equals &= obj.isSetFluxObjective() == isSetFluxObjective();
      if (equals && isSetFluxObjective()) {
        equals &= (obj.getFluxObjective() == getFluxObjective());
      }
      return equals;
    }  }

  /**
   * (non-Javadoc)
   */
  public Objective clone() {
    return new Objective(this);
  }

  /**
   * @return the type
   */
  public FbcType getType() {
    if (isSetType()) {
      return type;
    }
    throw new PropertyUndefinedError(FbcConstants.type, this);
  }

  /**
   * @return 
   */
  public boolean isSetType() {
    return (type != FBC_TYPE_INVALID);
  }

  /**
   * @param type
   */
  public void setType(FbcType type) {
    if (FbcType_isValid(type) == 0) {
      type = FBC_TYPE_INVALID;
      return LIBSBML_INVALID_ATTRIBUTE_VALUE;
    } else {
      type = type;
      return LIBSBML_OPERATION_SUCCESS;
    }
  }

  /**
   * @return {@code true} if the unset of the type attribute was successful
   */
  public boolean unsetType() {
    type = FBC_TYPE_INVALID;
    return LIBSBML_OPERATION_SUCCESS;
  }

}
