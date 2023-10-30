/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.rpcSamples.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.web.js.BJsBuild;
import javax.baja.webeditors.ux.BWebEditorsJsBuild;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraSingleton
public final class BRpcSamplesJsBuild
  extends BJsBuild
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.rpcSamples.ux.BRpcSamplesJsBuild(2747097003)1.0$ @*/
/* Generated Tue Oct 10 15:33:43 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BRpcSamplesJsBuild INSTANCE = new BRpcSamplesJsBuild();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRpcSamplesJsBuild.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private BRpcSamplesJsBuild()
  {
    super(
      "rpcSamples",
      BOrd.make("module://rpcSamples/rc/rpcSamples.built.min.js"),
      BWebEditorsJsBuild.TYPE
    );
  }
}
