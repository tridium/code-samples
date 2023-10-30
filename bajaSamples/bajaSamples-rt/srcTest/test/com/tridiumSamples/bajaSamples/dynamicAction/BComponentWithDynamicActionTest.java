/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package test.com.tridiumSamples.bajaSamples.dynamicAction;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.ActionInvokeException;
import javax.baja.sys.BInteger;
import javax.baja.sys.BStation;
import javax.baja.sys.BString;
import javax.baja.sys.BValue;
import javax.baja.sys.Slot;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridiumSamples.bajaSamples.dynamicAction.BComponentWithDynamicAction;
import com.tridiumSamples.bajaSamples.dynamicAction.BDynamicAction;
import org.testng.annotations.Test;

import com.tridium.testng.BStationTestBase;

@NiagaraType
@Test
public class BComponentWithDynamicActionTest
  extends BStationTestBase
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumSamples.bajaSamples.dynamicAction.BComponentWithDynamicActionTest(2979906276)1.0$ @*/
/* Generated Fri Sep 29 12:59:23 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BComponentWithDynamicActionTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  protected void configureTestStation(BStation station, String stationName, int webPort, int foxPort)
    throws Exception
  {
    super.configureTestStation(station, stationName, webPort, foxPort);

    // Disable history warmup- keeps extra threads from starting
    System.setProperty("niagara.history.warmup", "false");

    componentWithDynamicAction = new BComponentWithDynamicAction();
    station.add("componentWithDynamicAction", componentWithDynamicAction);
  }

  public void componentHasDynamicActionTest()
  {
    BValue val = componentWithDynamicAction.get(BComponentWithDynamicAction.DYNAMIC_ACTION_NAME);

    assertEquals(val.getType(), BDynamicAction.TYPE, "not a BDynamicAction");
  }

  public void dynamicActionSlotIsDynamicTest()
  {
    Slot slot = componentWithDynamicAction.getSlot(BComponentWithDynamicAction.DYNAMIC_ACTION_NAME);

    assertTrue(slot.isDynamic(), "not a dynamic slot");
  }

  public void dynamicActionSlotIsAnActionTest()
  {
    Slot slot = componentWithDynamicAction.getSlot(BComponentWithDynamicAction.DYNAMIC_ACTION_NAME);

    assertTrue(slot.isAction(), "not an action slot");
  }

  public void invokeDynamicActionTest()
  {
    componentWithDynamicAction.invoke(
      componentWithDynamicAction.getAction(BComponentWithDynamicAction.DYNAMIC_ACTION_NAME),
      BString.make("a string parameter")
    );
  }

  @Test(expectedExceptions = ActionInvokeException.class)
  public void invokeDynamicActionWithWrongParameterTypeTest()
  {
    componentWithDynamicAction.invoke(
      componentWithDynamicAction.getAction(BComponentWithDynamicAction.DYNAMIC_ACTION_NAME),
      BInteger.DEFAULT
    );
  }

  private BComponentWithDynamicAction componentWithDynamicAction;
}
