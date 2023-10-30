/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package test.com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag;

import static org.testng.Assert.assertEquals;

import javax.baja.data.BIDataValue;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.BStation;
import javax.baja.sys.BString;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.tag.Id;
import javax.baja.tagdictionary.BSmartTagDictionary;
import javax.baja.tagdictionary.BTagDictionaryService;
import javax.baja.util.BServiceContainer;

import com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BCountryRule;
import com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BTownTag;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tridium.testng.BStationTestBase;

@NiagaraType
public class BTagImpliedFromAnotherTagTest
  extends BStationTestBase
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumSamples.taggingSamples.tagImpliedFromAnotherTag.BTagImpliedFromAnotherTagTest(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:59 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTagImpliedFromAnotherTagTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  protected void configureTestStation(BStation station, String stationName, int webPort, int foxPort)
    throws Exception
  {
    super.configureTestStation(station, stationName, webPort, foxPort);

    BServiceContainer services = station.getServices();

    BTagDictionaryService tagDictionaryService = (BTagDictionaryService) services.get("TagDictionaryService");
    if (tagDictionaryService == null)
    {
      tagDictionaryService = new BTagDictionaryService();
    }

    BSmartTagDictionary smartDictionary = new BSmartTagDictionary(DICTIONARY_NAMESPACE);

    smartDictionary.getTagDefinitions().add(BTownTag.TAG_NAME, new BTownTag());
    smartDictionary.getTagRules().add("CountryRule", new BCountryRule());

    tagDictionaryService.add("smartDictionary", smartDictionary);
    services.add("TagDictionaryService", tagDictionaryService);

    testComponent = new BComponent();
    station.add("testComponent", testComponent);
  }

  @DataProvider(name = "townAndCountry")
  private Object[][] townAndCountry()
  {
    return new Object[][]
      {
        { "London", "England" },
        { "Birmingham", "England" },
        { "Brighton", "England" },
        { "Preston", "England" },
        { "Oban", "Scotland" },
        { "Inverness", "Scotland" },
        { "Llanfairpwllgwyngyllgogeryrchwyrndrobwllllantysiliogogogoch", "Wales" },
        { "Paris", "France" },
        { "Atlantis", "not known" }
      };
  }

  @Test(dataProvider = "townAndCountry")
  public void getTagTest(String town, String expectedCountry)
  {
    testComponent.tags().set(TOWN_TAG_ID, BString.make(town));

    BIDataValue returnedTagValue = testComponent.tags().get(COUNTRY_TAG_ID).orElse(null);

    assertEquals(returnedTagValue.toString(), expectedCountry);
  }

  private BComponent testComponent;
  private static final String DICTIONARY_NAMESPACE = "td";
  private static final Id TOWN_TAG_ID = Id.newId(DICTIONARY_NAMESPACE, BTownTag.TAG_NAME);
  private static final Id COUNTRY_TAG_ID = Id.newId(DICTIONARY_NAMESPACE, "countryTag");
}
