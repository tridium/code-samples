/**
 * @copyright 2023 Tridium, Inc. All Rights Reserved.
 */

define([
  'nmodule/uxSamples/rc/neqlAndBqlInJs/NeqlAndBqlWidget',
  'baja!',
  'baja!control:NumericWritable',
  'jquery',
  'nmodule/js/rc/jasmine/promiseUtils'
], function (
  NeqlAndBqlWidget,
  baja,
  types,
  $,
  promiseUtils
) {
  'use strict';

  const { waitForTrue } = promiseUtils;

  describe('nmodule/uxSamples/rc/neqlAndBqlInJs/NeqlAndBqlWidget', () => {
    let widget, dom;

    const initWidget = (runNeqlQuery) => {
      widget = new NeqlAndBqlWidget();
      widget.properties().setValue('runNeqlQuery', runNeqlQuery);
      dom = $('<div/>');
      return widget.initialize(dom);
    };

    afterEach(() => widget.isInitialized() && widget.destroy());

    describe('#doInitialize', () => {
      it('adds NeqlAndBqlWidget class', () => {
        return initWidget(true)
          .then(() => {
            expect(dom).toHaveClass('NeqlAndBqlWidget');
          });
      });

      it('adds a row for each point found with the neql query to the widget', () => {
        return initWidget(true)
          .then(() => {
            expect(widget.properties().getValue('runNeqlQuery')).toBe(true);
            // Note: the uxSamples test station has 2 control points in it, under a folder called 'components'
            return waitForTrue(() => dom.find('.query-results').children().length === 2);
          });
      });

      it('adds a row for each point found with the bql query to the widget', () => {
        return initWidget(false)
          .then(() => {
            expect(widget.properties().getValue('runNeqlQuery')).toBe(false);
            // should find the same 2 control point as the previous test
            return waitForTrue(() => dom.find('.query-results').children().length === 2);
          });
      });
    });
  });
});
