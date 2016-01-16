# BridgePoint-Codes

Source codes implemented in addition to state machines designed in [BridgePoint](http://xtuml.org). These codes are neccessary to communicate with the model railway track's embedded controllers. Moreover, the state machines can communicate with each other with its help.

This module has been deprecated since August 2015. Because in the Verifier module of the BridgePoint (v5.1.0) there were severe runtime errors that resulted in malfunction of the distributed system. Thus we switched to [Yakindu Statecharts](https://www.itemis.com/en/yakindu/statechart-tools/) that is a more reliable statechart designer and code-generator framework.

## Use

Add this library as a .jar dependency to the xtUML Model Project in BridgePoint. The *RealizedComponent* implementation is in the `bpcontrol.components.Rarduino` Java class.

Beware, that some packages of this library are not prefixed with `hu.bme.mit.inf.*`, otherwise BridgePoint won't find them. (See in the Help, how to connect a RealizedComponent to BridgePoint.)

## Dependants

*None*

## Dependencies

* core.jar: look for the plugins folder in the installation directory of BridgePoint
* [KVControl-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-requestsender)
* [KVControl-BPExtension-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-bpextension-requestsender)

## Target Platform
JRE 1.7