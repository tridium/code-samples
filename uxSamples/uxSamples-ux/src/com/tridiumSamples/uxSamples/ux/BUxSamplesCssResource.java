/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.uxSamples.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BCssResource;

@NiagaraType
@NiagaraSingleton
public final class BUxSamplesCssResource
  extends BCssResource
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.uxSamples.ux.BUxSamplesCssResource(2747097003)1.0$ @*/
/* Generated Fri Sep 29 11:32:22 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BUxSamplesCssResource INSTANCE = new BUxSamplesCssResource();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUxSamplesCssResource.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private BUxSamplesCssResource()
  {
    super(BOrd.make("module://uxSamples/rc/uxSamples.css"));
  }
}
