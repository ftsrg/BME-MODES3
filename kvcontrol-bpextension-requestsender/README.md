# KVControl-BPExtension-RequestSender

This component is responsible for the communication of the state machines designed in [Yakindu Statecharts](https://www.itemis.com/en/yakindu/statechart-tools/) (formerly we used [BridgePoint](http://xtuml.org) instead of Yakindu). It provides a simple API in Java for [KVControl-BPExtension](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-bpextension).

## Configuration

The `hu.bme.mit.inf.kvcontrol.bpextension.requests.AbstractRequest` class has `setDefaultAddress(address: String)` and `setDefaultPort(port: int)` methods. They should be parameterized according to the IP address and port number of the running `KVControl-BPExtension` module.

**Warning (1)**: IP address should include the `http://` prefix as well, otherwise it won't work correctly.

**Warning (2)**: These parameters should be set before sending the first API query to `KVControl-BPExtension`, otherwise the Java library will not be able to communicate with the REST API.

## Use

Add the library as a dependency to a Java project.

## Dependants

 * [Yakindu-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/yakindu-codes)
 * [BridgePoint-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/bridgepoint-codes)

## Dependencies

* [Apache HttpComponents](https://hc.apache.org/downloads.cgi):
    * HttpClient 4.5
    * HttpCore 4.4.1
    * CommonsCodec 1.9
    * CommonsLogging 1.2

* [JSON](https://github.com/FTSRG/BME-MODES3/tree/master/json)

## Target Platform
JRE 1.7