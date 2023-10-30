/**
 * @copyright 2023 Tridium, Inc. All Rights Reserved.
 */

/** @jsx spandrel.jsx */

/**
 * A widget that makes an RPC lookup and displays the returned value.
 * The value looked up is the record size of a history:HistoryConfig component,
 * so the widget expects the ord value of its binding to be a HistoryConfig.
 *
 * @module nmodule/rpcSamples/rc/accessingJavaMethodInJs/RpcLookupWidget
 */
define([
  'baja!',
  'bajaux/spandrel',
  'log!nmodule.rpcSamples.rc.accessingJavaMethodInJs.RpcLookupWidget' // log name can be anything, this format is the Tridium convention
], function (
  baja,
  spandrel,
  log
) {

  'use strict';

  const logInfo = log.info.bind(log);

  /**
   * @class
   * @alias module:nmodule/rpcSamples/rc/accessingJavaMethodInJs/RpcLookupWidget
   * @extends {module:bajaux/Widget}
   */
  return class RpcLookupWidget extends spandrel((component, { self }) => {
    return (
      <div>
        <div><label>RpcLookupWidget</label></div><br/>
        <div><button type="button" onClick={() => self.$lookup()}>Lookup</button></div><br/>
        <div><span>Component with history: </span><span class="component-with-history-name">{self.$componentWithHistoryName}</span></div>
        <div><span>Record Size: </span><span class="record-size">{self.$recordSize}</span></div>
      </div>
    );
  }) {

    /**
     * Use RPC to look up the record size, and update the ui.
     * @private
     * @returns {Promise}
     */
    $lookup() {
      const historyConfig = this.value();

      // Note: this method is expecting a HistoryConfig as its value, ie the ord defined in the wbViewBinding
      logInfo('$lookup: historyConfig type: ' + historyConfig.getType()); // => history:HistoryConfig

      // Confirm the HistoryConfig doesn't have #getRecordSize
      logInfo('$lookup: historyConfig.getRecordSize: ' + historyConfig.getRecordSize); // => undefined

      return this.retrieveRecordSizeByRpc(historyConfig)
        .then((recordSize) => {
          this.$recordSize = String(recordSize);
          this.$componentWithHistoryName = historyConfig.getParent().getParent().getName();

          return this.rerender();
        });
    }

    /**
     * Use RPC to get the RecordSize of the history:HistoryConfig
     * @param {baja.Component} config a HistoryConfig
     * @returns {Promise.<Number>} a promise that resolves to the RecordSize of the HistoryConfig
     */
    retrieveRecordSizeByRpc(config) {
      return baja.rpc({
        typeSpec: 'rpcSamples:RpcUtil',
        method: 'findRecordSize',
        args: [ config.getNavOrd().toString() ]
      });
    }

  };
});
