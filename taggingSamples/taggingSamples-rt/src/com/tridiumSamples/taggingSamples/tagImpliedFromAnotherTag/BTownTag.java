/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag;

import javax.baja.data.BIDataValue;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BInteger;
import javax.baja.sys.BString;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Entity;
import javax.baja.tag.Tag;
import javax.baja.tagdictionary.BSimpleTagInfo;

@NiagaraType
public final class BTownTag
  extends BSimpleTagInfo
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BTownTag(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:59 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTownTag.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public BIDataValue getDefaultValue()
  {
    return BString.make("default town");
  }

  public static final String TAG_NAME = "townTag";
}
