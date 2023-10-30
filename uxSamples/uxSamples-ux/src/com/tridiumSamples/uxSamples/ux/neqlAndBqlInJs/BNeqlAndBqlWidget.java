/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.uxSamples.ux.neqlAndBqlInJs;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

import com.tridiumSamples.uxSamples.ux.BUxSamplesJsBuild;

@NiagaraType
@NiagaraSingleton
public class BNeqlAndBqlWidget
  extends BSingleton
  implements BIJavaScript, BIFormFactorMax
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.uxSamples.ux.neqlAndBqlInJs.BNeqlAndBqlWidget(2747097003)1.0$ @*/
/* Generated Tue Oct 10 16:37:14 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  public static final BNeqlAndBqlWidget INSTANCE = new BNeqlAndBqlWidget();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNeqlAndBqlWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  protected BNeqlAndBqlWidget () {}

  @Override
  public JsInfo getJsInfo(Context cx) { return JS_INFO; }

  private static final JsInfo JS_INFO = JsInfo.make(
    BOrd.make("module://uxSamples/rc/neqlAndBqlInJs/NeqlAndBqlWidget.js"),
    BUxSamplesJsBuild.TYPE
  );
}
