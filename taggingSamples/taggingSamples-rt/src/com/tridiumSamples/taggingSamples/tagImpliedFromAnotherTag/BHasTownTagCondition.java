/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag;

import java.util.Optional;

import javax.baja.naming.BOrd;
import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BValue;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Entity;
import javax.baja.tag.Id;
import javax.baja.tagdictionary.BTagDictionary;
import javax.baja.tagdictionary.BTagRuleCondition;

import com.tridium.util.CompUtil;

@NiagaraType
public class BHasTownTagCondition
  extends BTagRuleCondition
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BHasTownTagCondition(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:59 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHasTownTagCondition.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**
   * Test whether the entity has the townTag.
   *
   * @param entity The entity to evaluate.
   * @return Returns true if the entity type matches, false otherwise.
   */
  @Override
  public boolean test(Entity entity)
  {
    Optional<BOrd> entityOrd = entity.getOrdToEntity();

    if (!entityOrd.isPresent()) { return false; }

    Optional<BTagDictionary> tagDictionary = CompUtil.closestAncestor(asComplex(), BTagDictionary.class);
    if (!tagDictionary.isPresent())
    {
      return false;
    }

    Id townTagId = Id.newId(tagDictionary.get().getNamespace(), BTownTag.TAG_NAME);

    BComponent comp = (BComponent) entityOrd.get().get();

    BValue tagValue = comp.get(SlotPath.escape(townTagId.getQName()));

    return null == tagValue ? false : true;
  }

  @Override
  public boolean testIdealMatch(Type type)
  {
    return false;
  }
}
