/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package test.com.tridiumSamples.bajaSamples.lexiconizingAnEnum;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BEnumRange;
import javax.baja.sys.BasicContext;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;
import javax.baja.util.LexiconModule;

import com.tridiumSamples.bajaSamples.lexiconizingAnEnum.BCompassEnum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@NiagaraType
public class BEnumLexiconTest
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumSamples.bajaSamples.lexiconizingAnEnum.BEnumLexiconTest(2979906276)1.0$ @*/
/* Generated Tue Oct 03 16:39:34 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEnumLexiconTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Test(dataProvider = "translations")
  public void translatesDisplayTagToContextLanguage(int ordinal, String expectedText, Context cx)
  {
    String displayTag = COMPASS_ENUM_RANGE.getDisplayTag(ordinal, cx);

    assertEquals(displayTag, expectedText);
  }

  @DataProvider(name = "translations")
  public Object[][] translations()
  {
    Object[][] allLanguageTranslations = EMPTY_ARRAY;
    for (Context cx : SUPPORTED_LANGUAGES)
    {
      allLanguageTranslations = Stream.concat(
        Arrays.stream(allLanguageTranslations),
        Arrays.stream(getTranslations(cx))
      ).toArray(Object[][]::new);
    }
    return allLanguageTranslations;
  }

  private static Object[][] getTranslations(Context languageCx)
  {
    return new Object[][]{
      { 0, BAJA_SAMPLES_LEX.get("north", languageCx), languageCx },
      { 1, BAJA_SAMPLES_LEX.get("south", languageCx), languageCx },
      { 2, BAJA_SAMPLES_LEX.get("east", languageCx), languageCx },
      { 3, BAJA_SAMPLES_LEX.get("west", languageCx), languageCx }
    };
  }

  private static final LexiconModule BAJA_SAMPLES_LEX = LexiconModule.make("bajaSamples");
  private static final Context DEFAULT = Context.NULL;
  private static final Context FRENCH = new BasicContext(null, "fr");
  private static final Context GERMAN = new BasicContext(null, "de");
  private static final Context[] SUPPORTED_LANGUAGES = { DEFAULT, FRENCH, GERMAN };
  private static final BEnumRange COMPASS_ENUM_RANGE = BCompassEnum.DEFAULT.getRange();
  public static final Object[][] EMPTY_ARRAY = {};
}
