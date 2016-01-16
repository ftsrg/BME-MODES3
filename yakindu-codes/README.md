# Yakindu-Codes

The development of this module started in August 2015, because severe bugs in the Verifier module of [BridgePoint](http://xtuml.org) (v5.1.0) that resulted in malfunction of the distributed system. Thus we switched to [Yakindu Statecharts](https://www.itemis.com/en/yakindu/statechart-tools/) that is a more reliable statechart designer and code-generator framework.

So state machines created with BridgePoints have been transformed to Yakindu statecharts. Besides, source codes have been generated from statecharts. This repository contains (1) the statecharts, (2) the generated source code from the statecharts, (3) additional codes which are necessary to communicate with the model railway track.

Statecharts which belong to the respective turnouts can be run separately, see [Use](https://github.com/FTSRG/BME-MODES3/tree/master/yakindu-codes#use) section below.

## Use

**Normal turnout (0x81-0x85):**

Run in command-line: 

`java -jar YakinduCodes-NormalTurnout.jar [-sl] [-tp <statechart trace log directory path>] [-ti <turnout ID>] [-a <IP address of KVControl>] [-p <port number of KVControl>] [-bpa <IP address of KVControl-BPExtension>] [-bpp <port number of KVControl-BPExtension>]`

Parameters:

* `sl`: if it is set, status information will be logged at the standard output and error output.
* `tp`: if it is set and a path is given as a parameter, then the trace log will be saved to an XML file within the respective folder. This way transitions can be logged for the statechart.
* `ti`: ID (as a decimal number) of the respective turnout, whose statechart will be started. Possible values: 129 (0x81), 130 (0x82), 131 (0x83), 132 (0x84), 133 (0x85).
* `a`: IP address of the computer which runs `KVControl`.
* `p`: port number of the computer whicch runs `KVControl`.
* `bpa`: IP address of the computer which runs `KVControl-BPExtension`.
* `bpp`: port number of the computer whicch runs `KVControl-BPExtension`.

Although all the parameters are optional, if the `ti` parameter is missing, the it will not be started.


**English turnout (0x86-0x87):**

Run in command-line: 

`java -jar YakinduCodes-EnglishTurnout.jar [-sl] [-tp1 <statechart trace log directory path for turnout 0x87>] [-tp2 <statechart trace log directory path for turnout 0x86>] [-a <IP address of KVControl>] [-p <port number of KVControl>] [-bpa <IP address of KVControl-BPExtension>] [-bpp <port number of KVControl-BPExtension>]`

Parameters:

* `sl`: if it is set, status information will be logged at the standard output and error output.
* `tp1`: if it is set and a path is given as a parameter, then the trace log will be saved to an XML file within the respective folder. This way transitions can be logged for the statechart of turnout 0x87.
* `tp2`: if it is set and a path is given as a parameter, then the trace log will be saved to an XML file within the respective folder. This way transitions can be logged for the statechart of turnout 0x86.
* `a`: IP address of the computer which runs `KVControl`.
* `p`: port number of the computer whicch runs `KVControl`.
* `bpa`: IP address of the computer which runs `KVControl-BPExtension`.
* `bpp`: port number of the computer whicch runs `KVControl-BPExtension`.

All the parameters are optional.

**Warning (1): Statecharts are always started on the same IP address as the computer that run them. The default port number is `3300+{turnoutID}`, where `turnoutID` is the ID of the given turnout (0x81-0x87).** This IP address and port number is important for the [KVControl-BPExtension](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-bpextension#configuration) module, that manages the communication between the statecharts.

**Warning (2):** To change the default IP address and port number of the statechart, see the [Implementation Notes](https://github.com/FTSRG/BME-MODES3/tree/master/yakindu-codes#implementation-notes) section below.

## Implementation Notes

For the normal turnouts a general statechart (model) has been designed, that is in the `models/normal-turnout` folder. It contains the "safety logic" that prevents trains collision in case of normal turnouts. This statechart has been designed quite generally. So it is enough to parameterize the .jar that contains the (1) source code generated from the statechart, and (2) the Java code snippet that is necessary to communicate with other modules (e.g. KVControl, KVControl-BPExtension). 

For the english turnout a separate statechart has been designed, that is in the `models/english-turnout` folder. It contains the "safety logic" that prevents trains collision in case of english turnout. Because the turnout consists of two parts itself, it is reflected the Java code level: double instantiation of the same "english turnout" statchart, and the interconnection of the cross-calls (events) from one part of the english turnout to the other. From every other perspective, the normal turnout and the english turnout are the same.

**Warning:** If you want to change the default port number of the statecharts, then in the `hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationServer` class set the `port` field for a new value. If you want to change the default IP address, then do it in `run` method of the respective class, at the first row of the `try` block, at the binding the `socket` (`serverSocketChannel.socket().bind(...)`).

## Dependants ##

*None*

## Dependencies ##

* [JOpt Simple](http://pholser.github.io/jopt-simple/download.html): handling command-line arguments correctly
* [KVControl-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-requestsender): to communicate with KVControl
* [KVControl-BPExtension-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-bpextension-requestsender): to communicate with KVControl-BPExtension

## Target Platform ##
JRE 1.7
