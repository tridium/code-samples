/**
 * @copyright 2023 Tridium, Inc. All Rights Reserved.
 */

define([
  'nmodule/rpcSamples/rc/accessingJavaMethodInJs/RpcLookupWidget',
  'baja!',
  'baja!baja:Folder,control:NumericWritable,history:NumericCovHistoryExt',
  'jquery'
], function (
  RpcLookupWidget,
  baja,
  types,
  $
) {
  'use strict';

  describe('nmodule/rpcSamples/rc/accessingJavaMethodInJs/RpcLookupWidget', () => {
    describe('#$lookup', () => {
      const FAKE_RECORD_SIZE = String(35);
      let widget, componentWithHistoryName, historyConfig;

      const parent = baja.$('baja:Folder', {
        componentWithHistoryName: baja.$('control:NumericWritable', {
          NumericCov: baja.$('history:NumericCovHistoryExt')
        })
      });

      beforeEach(() => {
        componentWithHistoryName = parent.get('componentWithHistoryName');
        widget = new RpcLookupWidget();
        historyConfig = componentWithHistoryName.get('NumericCov').getHistoryConfig();

        spyOn(widget, 'retrieveRecordSizeByRpc').andResolve(FAKE_RECORD_SIZE);
        spyOn(historyConfig, 'getNavOrd').andReturn('AFakeNavOrd');

        return widget.initialize($('<div/>'))
          .then(() => {
            spyOn(widget, 'rerender').andCallThrough();

            return widget.load(historyConfig);
          });
      });

      afterEach(() => widget.isInitialized() && widget.destroy());

      it("populates a value for recordSize on the widget", () => {
        return widget.$lookup()
          .then(() => {
            expect(widget.$recordSize).toBe(FAKE_RECORD_SIZE);
          });
      });

      it("populates the dom with a value for recordSize", () => {
        return widget.$lookup()
          .then(() => {
            expect(widget.jq().find('.record-size').text()).toBe(FAKE_RECORD_SIZE);
          });
      });

      it("populates a value for $componentWithHistoryName on the widget", () => {
        return widget.$lookup()
          .then(() => {
            expect(widget.$componentWithHistoryName).toBe('componentWithHistoryName');
          });
      });

      it("populates the dom with a value for 'Component with history'", () => {
        return widget.$lookup()
          .then(() => {
            expect(widget.jq().find('.component-with-history-name').text()).toBe('componentWithHistoryName');
          });
      });
    });
  });
});
