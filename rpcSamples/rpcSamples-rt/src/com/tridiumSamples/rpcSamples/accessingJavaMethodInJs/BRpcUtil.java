/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */

package com.tridiumSamples.rpcSamples.accessingJavaMethodInJs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.baja.history.BHistoryConfig;
import javax.baja.naming.BOrd;
import javax.baja.naming.OrdTarget;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.rpc.NiagaraRpc;
import javax.baja.rpc.Transport;
import javax.baja.rpc.TransportType;
import javax.baja.security.PermissionException;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
public class BRpcUtil
  extends BObject
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.tridiumSamples.rpcSamples.accessingJavaMethodInJs.BRpcUtil(2979906276)1.0$ @*/
/* Generated Wed Oct 04 15:05:58 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BRpcUtil.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**
   * Returns the history record size for the HistoryConfig at the targetOrd.
   * The method expects the targetOrd to resolve to a HistoryConfig.
   *
   * @param targetOrd
   * @param cx
   * @return int the record size from the HistoryConfig
   */
  @NiagaraRpc(
    permissions = "unrestricted",
    transports = {@Transport(type = TransportType.box)}
  )
  public static int findRecordSize(String targetOrd, Context cx)
    throws IOException
  {
    if (LOG.isLoggable(Level.FINE)) { LOG.fine("findRecordSize: targetOrd: " + targetOrd); }

    if (targetOrd.isEmpty())
    {
      throw new IllegalArgumentException("Supplied Ord is blank");
    }

    OrdTarget ordTarget;
    try
    {
      ordTarget = BOrd.make(targetOrd).resolve(null, cx);
    }
    catch (UnresolvedException ex)
    {
      throw new IllegalArgumentException("Invalid Ord: " + targetOrd);
    }

    // make sure the user has permission to read this ord
    if (!ordTarget.canRead()) { throw new PermissionException(); }

    BObject target = ordTarget.get();
    if (ordTarget.get() instanceof BHistoryConfig)
    {
      return ((BHistoryConfig)target).getRecordSize();
    }

    throw new IllegalArgumentException("HistoryConfig expected: " + targetOrd);
  }

  private final static Logger LOG = Logger.getLogger(BRpcUtil.class.getSimpleName());
}
