/**
 * @copyright 2023 Tridium, Inc. All Rights Reserved.
 */

/**
 * A widget that performs a NEQL or BQL query and displays the results.
 *
 * @module nmodule/uxSamples/rc/neqlAndBqlInJs/NeqlAndBqlWidget
 */
define([
  'baja!',
  'bajaux/mixin/subscriberMixIn',
  'bajaux/Widget',
  'underscore'
], function (
  baja,
  subscriberMixIn,
  Widget,
  _
) {

  'use strict';

  const widgetDefaults = () => ({
    properties: {
      runNeqlQuery: true,
      rootCssClass: { value: 'NeqlAndBqlWidget', hidden: true }
    }
  });

  const makeDisplayTextForDom = (c) => {
    const displayText = c.getDisplayName() + ': ' + c.getOutDisplay();

    //return displayText; // DO NOT DO THIS!
    //
    // Directly returning user-generated data is an XSS vulnerability ...
    //
    // ... so user-generated data must be escaped before inserting it into the DOM.
    return _.escape(displayText);
  };

  /**
   * @class
   * @alias module:nmodule/uxSamples/rc/neqlAndBqlInJs/NeqlAndBqlWidget
   * @extends {module:bajaux/Widget}
   */
  return class NeqlAndBqlWidget extends Widget {
    constructor(params) {
      super({ params, defaults: widgetDefaults() });
      subscriberMixIn(this);
    }

    /**
     * Build HTML and run the query.
     * @param {JQuery} jq
     * @returns {Promise}
     */
    doInitialize(jq) {
      jq.html(
        `<div>
          <div class="title">NeqlAndBqlWidget</div>
          <div>Query Results:</div>
          <div class="query-results"/>
        </div>`
      );

      return this.$runQuery();
    }

    /**
     * Run the NEQL or BQL query, and update the ui.
     * @private
     * @returns {Promise}
     */
    $runQuery() {
      const jq = this.jq(),
        sub = this.getSubscriber(),
        doNeqlQuery = this.properties().getValue('runNeqlQuery'),
        neqlQueryOrd = 'station:|slot:|neql: n:point',
        bqlQueryOrd = 'station:|slot:|bql:select from control:ControlPoint',
        queryOrd = doNeqlQuery ? neqlQueryOrd : bqlQueryOrd,
        ords = [];

      return baja.Ord.make(queryOrd).get({
        cursor: {
          // limit: 10, // Specify optional limit on the number of records (defaults to 10)
          // offset: 0, // Specify optional record offset (defaults to 0)
          // before: () => {
          //  console.log('Called just before iterating through the Cursor');
          // },
          // after: () => {
          //  console.log('Called just after iterating through the Cursor');
          // },
          each: (result) => {
            if (doNeqlQuery) {
              // for a neql search, we get a BasicEntity
              ords.push(result.getOrdToEntity().toString());
            } else {
              // for bql, it's a component
              ords.push(result.get('navOrd'));
            }
          }
        }
      })
        .then(() => {
          const resolve = new baja.BatchResolve(ords),
            resultsDiv = jq.find('.query-results');
          return resolve.resolve({
            subscriber: sub,
            each: (point) => {
              resultsDiv.append(
                '<div class="row-' + point.getName() + '">' + makeDisplayTextForDom(point) + '</div>'
              );
            }
          });
        })
        .then(() => {
          sub.attach('changed', function (prop) {
            if (prop.getName() === 'out') {
              jq.find('.row-' + this.getName()).text(makeDisplayTextForDom(this));
            }
          });
        });
    };
  };
});
