/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.bajaSamples.lexiconizingAnEnum;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum
(
  range = { 
    @Range("north"), 
    @Range("south"), 
    @Range("east"),
    @Range("west") 
  },
  defaultValue = "south"
)
public final class BCompassEnum
  extends BFrozenEnum
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.bajaSamples.lexiconizingAnEnum.BCompassEnum(957317988)1.0$ @*/
/* Generated Fri Sep 29 09:56:52 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  /** Ordinal value for north. */
  public static final int NORTH = 0;
  /** Ordinal value for south. */
  public static final int SOUTH = 1;
  /** Ordinal value for east. */
  public static final int EAST = 2;
  /** Ordinal value for west. */
  public static final int WEST = 3;

  /** BCompassEnum constant for north. */
  public static final BCompassEnum north = new BCompassEnum(NORTH);
  /** BCompassEnum constant for south. */
  public static final BCompassEnum south = new BCompassEnum(SOUTH);
  /** BCompassEnum constant for east. */
  public static final BCompassEnum east = new BCompassEnum(EAST);
  /** BCompassEnum constant for west. */
  public static final BCompassEnum west = new BCompassEnum(WEST);

  /** Factory method with ordinal. */
  public static BCompassEnum make(int ordinal)
  {
    return (BCompassEnum)north.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BCompassEnum make(String tag)
  {
    return (BCompassEnum)north.getRange().get(tag);
  }

  /** Private constructor. */
  private BCompassEnum(int ordinal)
  {
    super(ordinal);
  }

  public static final BCompassEnum DEFAULT = south;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCompassEnum.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}
