/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.bajaSamples.dynamicAction;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BAction;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.BValue;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BDynamicAction
  extends BAction
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.bajaSamples.dynamicAction.BDynamicAction(2979906276)1.0$ @*/
/* Generated Fri Sep 29 09:56:52 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDynamicAction.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public Type getParameterType()
  {
    return BString.TYPE;
  }

  @Override
  public BValue getParameterDefault()
  {
    return BString.DEFAULT;
  }

  /**
   * Invoke the action on the specified target with given argument array.
   */
  @Override
  public BValue invoke(BComponent target, BValue arg)
    throws Exception
  {
    // check we have the correct parameter type
    if (!arg.getType().is(getParameterType()))
    {
      throw new IllegalArgumentException("Invalid type " + arg.getType());
    }

    // functionality for action goes here ...

    if (LOG.isLoggable(Level.INFO)) { LOG.info(" dynamic action is now doing its thing with argument: " + arg); }

    return null;
  }

  @Override
  public Type getReturnType()
  {
    return null;
  }

  private final static Logger LOG = Logger.getLogger(BDynamicAction.class.getSimpleName());
}
