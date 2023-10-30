/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tagdictionary.BTagRule;

@NiagaraType
public class BCountryRule
  extends BTagRule
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BCountryRule(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:59 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCountryRule.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BCountryRule()
  {
    setCondition(new BHasTownTagCondition());

    getTagList().add("countryTag", new BCountryTag());
  }
}
