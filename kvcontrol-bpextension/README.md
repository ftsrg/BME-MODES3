# KVControl-BPExtension

This component is responsible for the communication of the state machines designed in [Yakindu Statecharts](https://www.itemis.com/en/yakindu/statechart-tools/) (formerly we used [BridgePoint](http://xtuml.org) instead of Yakindu). This component provides a REST API which transfers the queries to the respective state machines. It can be parameterized, that which state machine is available at which IP address and port (see the [Configuration](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-bpextension#configuration) section).

*This module is called BPExtension, because formerly we used it for communication between BridgePoint (BP) nodes.*

Documentation of the API (providing it is running at `http://localhost:8080`):

`GET`:

* `/passage_request/{direction}/{receiverID}`: sends a `DISTRIBUTED_PASSAGE_REQUEST_{direction}` message to state machine which belongs to the turnout identified by `receiverID`.

* `/short_passage_request/{direction}/{receiverID}`: sends a `DISTRIBUTED_SHORT_PASSAGE_REQUEST_{direction}` message to the state machine which belongs to the turnout identified by `receiverID`.

`PUT`:

* `/passage_response/{direction}/{allowance}/{receiverID}`: sends a `DISTRIBUTED_PASSAGE_RESPONSE_{direction}` message to the state machine which belongs to the turnout identified by `receiverID`. In this message, depending on the `allowance` parameter of the query, a `DISTRUBUTED_PASSAGE_{allowance}` value is transferred as well. It indicates wheter the passage is `ALLOWED` or `DENIED` from the respective turnout identified by `receiverID`.

Valid values of the `receiverID` parameter: 0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87

Valid values of the `direction` parameter: TOP, STRAIGHT, DIVERGENT

Valud values of the `allowance` parameter: ALLOWED, DENIED

Any other incorrect query will result in a HTTP 400 response code.

## Configuration

Running this module in command-line requires a configuration ini file, that contains the running Yakindu state machines IP addressess and prot numbers. The ini file should be structured as follows: 

ID of the turnout as a hexadecimal number, IP address of the state machine that belongs to the turnout, port number of the state machine that belongs to the turnout.

```
[turnouts]
turnout = <ID>;<IP address>:<port number>
```

If all the state machines run on localhost, then the ini file should be:

```
[turnouts]
turnout = 0x81;127.0.0.1:3429
turnout = 0x82;127.0.0.1:3430
turnout = 0x83;127.0.0.1:3431
turnout = 0x84;127.0.0.1:3432
turnout = 0x85;127.0.0.1:3433
turnout = 0x86;127.0.0.1:3434
turnout = 0x87;127.0.0.1:3435
```

## Use

a) Run in command-line: `java -jar KVControl-BPExtension.jar -p <port> --ini <ini>`, where `port` will be the port number of the REST server, and `ini` indicates the path of the ini file containing the configuration information (see the [Configuration](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-bpextension#configuration) section above).

b) Add this library as a .jar dependency to a Java project, and use its classes and methods.

## Dependants

*None*

## Dependencies

* [JOpt Simple](http://pholser.github.io/jopt-simple/download.html): handling command-line arguments correctly
* [ini4j](http://ini4j.sourceforge.net/download.html): handling ini file

## Target Platform
JRE 1.7