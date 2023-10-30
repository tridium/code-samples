/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package test.com.tridiumSamples.rpcSamples.accessingJavaMethodInJs;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.any;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import javax.baja.control.BNumericWritable;
import javax.baja.history.BHistoryConfig;
import javax.baja.history.ext.BNumericCovHistoryExt;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.security.BPermissions;
import javax.baja.security.PermissionException;
import javax.baja.sys.BStation;
import javax.baja.sys.BasicContext;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.user.BUser;

import com.tridiumSamples.rpcSamples.accessingJavaMethodInJs.BRpcUtil;
import org.mockito.*;
import org.testng.annotations.Test;

import com.tridium.testng.BStationTestBase;

@NiagaraType
@Test
public class BRpcUtilTest
  extends BStationTestBase
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumSamples.rpcSamples.accessingJavaMethodInJs.BRpcUtilTest(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:58 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRpcUtilTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  protected void configureTestStation(BStation station, String stationName, int webPort, int foxPort)
    throws Exception
  {
    super.configureTestStation(station, stationName, webPort, foxPort);

    componentWithHistory = new BNumericWritable();
    BNumericCovHistoryExt historyExt = new BNumericCovHistoryExt();

    // Using Mockito to fake the #getRecordSize lookup,
    // so this station does not need to set up a history and its records
    historyConfig = Mockito.spy(new BHistoryConfig());
    doReturn(MOCK_RECORD_SIZE).when(historyConfig).getRecordSize();

    historyExt.setHistoryConfig(historyConfig);

    componentWithHistory.add("NumericCov", historyExt);

    station.add("componentWithHistory", componentWithHistory);
  }

  public void findRecordSizeTest()
    throws IOException
  {
    int result = BRpcUtil.findRecordSize(historyConfig.getNavOrd().toString(), USER_CONTEXT_WITH_FULL_PERMISSIONS);

    assertEquals(result, MOCK_RECORD_SIZE);
  }

  @Test(
    expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "HistoryConfig expected: local:\\|station:\\|slot:/componentWithHistory"
  )
  public void findRecordSize_notAHistoryConfigTest()
    throws IOException
  {
    BRpcUtil.findRecordSize(componentWithHistory.getNavOrd().toString(), USER_CONTEXT_WITH_FULL_PERMISSIONS);
  }

  @Test(
    expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "Invalid Ord: local:\\|station:\\|slot:/non/existent/ord"
  )
  public void findRecordSize_nonExistentOrdTest()
    throws IOException
  {
    BRpcUtil.findRecordSize(INVALID_ORD, USER_CONTEXT_WITH_FULL_PERMISSIONS);
  }

  @Test(
    expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "Supplied Ord is blank"
  )
  public void findRecordSize_emptyOrdStringTest()
    throws IOException
  {
    BRpcUtil.findRecordSize("", USER_CONTEXT_WITH_FULL_PERMISSIONS);
  }

  @Test(expectedExceptions = PermissionException.class)
  public void findRecordSize_noPermissionTest()
    throws IOException
  {
    BRpcUtil.findRecordSize(historyConfig.getNavOrd().toString(), USER_CONTEXT_WITH_NO_PERMISSIONS);
  }

  private static Context userContextWithPermissions(BPermissions permissions)
  {
    // Use Mockito to create a context that has a user with the given permissions
    // (again so we don't have to set them up in the station)
    BUser mockUser = Mockito.spy(new BUser());
    doReturn(permissions).when(mockUser).getPermissionsFor(any());
    return new BasicContext(mockUser);
  }

  private BNumericWritable componentWithHistory;
  private BHistoryConfig historyConfig;
  private final static int MOCK_RECORD_SIZE = 19;
  private final static String INVALID_ORD = "local:|station:|slot:/non/existent/ord";

  private final static Context USER_CONTEXT_WITH_FULL_PERMISSIONS = userContextWithPermissions(BPermissions.all);
  private final static Context USER_CONTEXT_WITH_NO_PERMISSIONS = userContextWithPermissions(BPermissions.none);
}
