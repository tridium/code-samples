
# Using RPC in BajaScript to access a Java method on a BComponent

Any Niagara Property, Action or Topic on a component is automatically available in BajaScript.

Sometimes however a `BComponent` contains methods that are not actions but we still want to access them in BajaScript.
This is where RPC can help.

In this example we're using `BHistoryConfig`. It has a number of Properties that can be accessed in BajaScript, but it also has a method `#getRecordSize` that is not available.

So here we have a utility class - `BRpcUtil` - that has an RPC method on it (`#findRecordSize`).
This uses the supplied Ord to find and return the record size of a HistoryConfig.

Any JavaScript widget can then call this method and use the result.

For testing purposes the RpcLookupWidget is available in the palette. 

For more information on RPC see docDeveloper: 
\
`module://docDeveloper/doc/niagaraRpc.html`
\
`module://docDeveloper/doc/jsdoc/bajaScript-ux/baja.html#.rpc`

Plus the docDeveloper palette has in-browser examples you can try.
