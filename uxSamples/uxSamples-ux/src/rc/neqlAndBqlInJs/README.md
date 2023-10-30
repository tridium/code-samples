
# Making NEQL and BQL lookup in BajaScript

For this example there is a widget available in the palette - NeqlAndBqlWidget.
The widget looks for control points within a station. It can use either a NEQL query (`neql: n:point`) or a BQL query (`select from baja:ControlPoint`).

It has a property 'runNeqlQuery' to switch between the two.

The widget demonstrates how to deal with the differing results of these 2 queries.

It also shows how to subscribe to the results, so the values continuously update.

There have to be some control points in your station for the query to work!
