# KVControl-RequestSender

This component provides a simple Java API for the communication with [KVControl](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol).

## Configuration ##

The `hu.bme.mit.inf.kvcontrol.requests.AbstractRequest` class has `setDefaultAddress(address: String)` and `setDefaultPort(port: int)` methods. They should be parameterized according to the IP address and port number of the running `KVControl` module.

**Warning (1)**: IP address should include the `http://` prefix as well, otherwise it won't work correctly.

**Warning (2)**: These parameters should be set before sending the first API query to `KVControl`, otherwise the Java library will not be able to communicate with the REST API.

## Use ##

Add the library as a dependency to a Java project.

## Dependants

 * [PiClient](https://github.com/FTSRG/BME-MODES3/tree/master/piclient_v4)
 * [Yakindu-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/yakindu-codes)
 * [BridgePoint-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/bridgepoint-codes)
 
## Dependencies

* [Apache HttpComponents](https://hc.apache.org/downloads.cgi):
    * HttpClient 4.5
    * HttpCore 4.4.1
    * CommonsCodec 1.9
    * CommonsLogging 1.2

* [JSON](https://github.com/FTSRG/BME-MODES3/tree/master/json)

## Target Platform
JRE 1.7