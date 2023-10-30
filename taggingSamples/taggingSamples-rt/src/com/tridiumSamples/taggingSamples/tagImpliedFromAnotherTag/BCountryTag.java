/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag;

import java.util.Optional;

import javax.baja.data.BIDataValue;
import javax.baja.naming.BOrd;
import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BString;
import javax.baja.sys.BValue;
import javax.baja.sys.BajaRuntimeException;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Entity;
import javax.baja.tag.Id;
import javax.baja.tag.Tag;
import javax.baja.tagdictionary.BSimpleTagInfo;

@NiagaraType
public final class BCountryTag
  extends BSimpleTagInfo
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BCountryTag(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:59 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCountryTag.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public Tag getTag(Entity entity)
  {
    return new Tag(getTagId(), calculateTagValue(entity));
  }

  @Override
  public BIDataValue getDefaultValue() { return DEFAULT_VALUE; }

  /*
   * Calculate the tag value as required ...
   */
  private BString calculateTagValue(Entity entity)
  {
    Optional<BOrd> entityOrd = entity.getOrdToEntity();

    if (!entityOrd.isPresent() || !getDictionary().isPresent())
    {
      return null;
    }

    Id townTagId = Id.newId(getDictionary().get().getNamespace(), BTownTag.TAG_NAME);

    BComponent comp = (BComponent) entityOrd.get().get();

    BValue val = comp.get(SlotPath.escape(townTagId.getQName()));

    if (val == null) { return DEFAULT_VALUE; }

    String town = val.toString();

    switch (town)
    {
      case "London":
      case "Birmingham":
      case "Brighton":
      case "Preston":
        return ENGLAND;

      case "Oban":
      case "Inverness":
        return SCOTLAND;

      case "Llanfairpwllgwyngyllgogeryrchwyrndrobwllllantysiliogogogoch":
        return WALES;

      case "Paris":
        return FRANCE;

      default:
        return DEFAULT_VALUE;
    }
  }

  private static final BString ENGLAND = BString.make("England");
  private static final BString SCOTLAND = BString.make("Scotland");
  private static final BString WALES = BString.make("Wales");
  private static final BString FRANCE = BString.make("France");
  private static final BString DEFAULT_VALUE = BString.make("not known");
}
