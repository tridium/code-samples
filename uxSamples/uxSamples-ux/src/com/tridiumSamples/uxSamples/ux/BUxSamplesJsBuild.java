/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.uxSamples.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.web.js.BJsBuild;
import javax.baja.webeditors.ux.BWebEditorsJsBuild;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraSingleton
public final class BUxSamplesJsBuild
  extends BJsBuild
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.uxSamples.ux.BUxSamplesJsBuild(2747097003)1.0$ @*/
/* Generated Tue Oct 10 15:34:39 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BUxSamplesJsBuild INSTANCE = new BUxSamplesJsBuild();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUxSamplesJsBuild.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private BUxSamplesJsBuild()
  {
    super(
      "uxSamples",
      BOrd.make("module://uxSamples/rc/uxSamples.built.min.js"),
      BWebEditorsJsBuild.TYPE,
      BUxSamplesCssResource.TYPE
    );
  }
}
