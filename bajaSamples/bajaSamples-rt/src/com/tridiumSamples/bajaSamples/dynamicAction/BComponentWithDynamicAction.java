/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.bajaSamples.dynamicAction;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.BFormat;

@NiagaraType
public class BComponentWithDynamicAction
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.bajaSamples.dynamicAction.BComponentWithDynamicAction(2979906276)1.0$ @*/
/* Generated Fri Sep 29 09:56:52 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BComponentWithDynamicAction.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void started() throws Exception
  {
    add(
      DYNAMIC_ACTION_NAME,
      new BDynamicAction(),
      // make the action transient so we can add it each time on startup without having to check whether it's already there.
      Flags.TRANSIENT
    );

    setDisplayName(getProperty(DYNAMIC_ACTION_NAME), BFormat.make(DYNAMIC_ACTION_DISPLAY_NAME), null);
  }

  public final static String DYNAMIC_ACTION_NAME = "dynamicAction";
  private final static String DYNAMIC_ACTION_DISPLAY_NAME = "Run My Dynamic Action";
}
