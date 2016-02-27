# Yakindu-Codes

*This module is deprecated, use [Yakindu-Codes-Normal-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.normal) and [Yakindu-Codes-English-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.english) instead.*

The development of this module started in August 2015, because severe bugs in the Verifier module of [BridgePoint](http://xtuml.org) (v5.1.0) that resulted in malfunction of the distributed system. Thus we switched to [Yakindu Statecharts](https://www.itemis.com/en/yakindu/statechart-tools/) that is a more reliable statechart designer and code-generator framework.

So state machines created with BridgePoints have been transformed to Yakindu statecharts. Besides, source codes have been generated from statecharts. This repository contains (1) the statecharts, (2) the generated source code from the statecharts, (3) additional codes which are necessary to communicate with the model railway track.

Statecharts which belong to the respective turnouts can be run separately, see [Use](https://github.com/FTSRG/BME-MODES3/tree/master/yakindu-codes#use) section below.

## Use

**Normal turnout (0x81-0x85):**

Run in command-line: 

`java -jar YakinduCodes-NormalTurnout.jar [-sl] [-tp <statechart trace log directory path>] [-ti <turnout ID>] [-a <IP address of KVControl>] [-p <port number of KVControl>] [--smba <IP address of the MQTT Broker>] [--smbp <port number of the MQTT Broker>] [--smbpp <protocol of the MQTT Broker>] [--smbq <QOS of the MQTT Broker>]  [--smbt <topic name for the MQTT Broker>]`

Parameters:

* `sl`: if it is set, status information will be logged at the standard output and error output.
* `tp`: if it is set and a path is given as a parameter, then the trace log will be saved to an XML file within the respective folder. This way transitions can be logged for the statecharts.
* `ti`: ID (as a decimal number) of the respective turnout, whose statechart will be started. Possible values: 129 (0x81), 130 (0x82), 131 (0x83), 132 (0x84), 133 (0x85).
* `a`: IP address of the computer which runs `KVControl`.
* `p`: port number of the computer which runs `KVControl`.
* `smba`: IP address of the computer which runs the MQTT Broker *(default: localhost)*.
* `smbp`: port number of the computer which runs the MQTT Broker *(default: 1883)*.
* `smbpp`: protocol of the computer which runs the MQTT Broker *(default: tcp)*.
* `smbq`: QOS of the MQTT Broker *(default: 1)*.
* `smbt`: topic name for the MQTT Broker *(default: modes3/yakindu)*.

Although all parameters are optional, if the `ti` parameter is missing, the it will not be started.

**English turnout (0x86-0x87):**

Run in command-line: 

`java -jar YakinduCodes-EnglishTurnout.jar [-sl] [-tp <statechart trace log directory path>] [-a <IP address of KVControl>] [-p <port number of KVControl>] [--smba <IP address of the MQTT Broker>] [--smbp <port number of the MQTT Broker>] [--smbpp <protocol of the MQTT Broker>] [--smbq <QOS of the MQTT Broker>]  [--smbt <topic name for the MQTT Broker>]`

Parameters:

* `sl`: if it is set, status information will be logged at the standard output and error output.
* `tp`: if it is set and a path is given as a parameter, then the trace log will be saved to an XML file within the respective folder. This way transitions can be logged for the statecharts.
* `a`: IP address of the computer which runs `KVControl`.
* `p`: port number of the computer which runs `KVControl`.
* `smba`: IP address of the computer which runs the MQTT Broker *(default: localhost)*.
* `smbp`: port number of the computer which runs the MQTT Broker *(default: 1883)*.
* `smbpp`: protocol of the computer which runs the MQTT Broker *(default: tcp)*.
* `smbq`: QOS of the MQTT Broker *(default: 1)*.
* `smbt`: topic name for the MQTT Broker *(default: modes3/yakindu)*.

All parameters are optional.

### How to install Mosquitto on a computer?

#### Ubuntu

`sudo apt-add-repository ppa:mosquitto-dev/mosquitto-ppa`

If the command "apt-add-repository" is not recognised, it can be installed with:

`sudo apt-get install python-software-properties`

After addig the repository, install the Mosquitto:

`sudo apt-get update`

`sudo apt-get install mosquitto`


#### Windows (8.1)

Download the *win32 native build* installer either from the [homepage](http://www.eclipse.org/mosquitto/download/#windows) or from the [alternative link](http://home.sch.bme.hu/~benjo123/mqtt/mosquitto-1.4.7-install-win32.exe) (version 1.4.7 as February 2016).

Download the following DLLs and copy it to the installation folder of Mosquitto:

* [libeay32.dll](http://home.sch.bme.hu/~benjo123/mqtt/libeay32.dll) fetchable from [Win32 OpenSSL homepage](http://slproweb.com/products/Win32OpenSSL.html) as well.
* [ssleay32.dll](http://home.sch.bme.hu/~benjo123/mqtt/ssleay32.dll) fetchable from [Win32 OpenSSL homepage](http://slproweb.com/products/Win32OpenSSL.html) as well.
* [pthreadVC2.dll](http://home.sch.bme.hu/~benjo123/mqtt/pthreadVC2.dll) fetchable from [pthreads-win32 ftp](ftp://sources.redhat.com/pub/pthreads-win32/dll-latest/dll/x86/) as well.

Now start the Mosquitto Service at Windows Control Panel -> Administrative Tools -> View local services -> Mosquitto Broker.

## Implementation Notes

For the normal turnouts a general statechart (model) has been designed, that is in the `models/normal-turnout` folder. It contains the "safety logic" that prevents trains collision in case of normal turnouts. This statechart has been designed quite generally. So it is enough to parameterize the .jar that contains the (1) source code generated from the statechart, and (2) the Java code snippet that is necessary to communicate with other modules (e.g. [KVControl](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol), [Yakindu-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.mqtt.client)). 

For the english turnout a separate statechart has been designed, that is in the `models/english-turnout` folder. It contains the "safety logic" that prevents trains collision in case of english turnout. Because the turnout consists of two parts itself, it is reflected the Java code level: double instantiation of the same "english turnout" statchart, and the interconnection of the cross-calls (events) from one part of the english turnout to the other. From every other perspective, the normal turnout and the english turnout are the same.

## Dependants ##

*None*

## Dependencies ##

* [JOpt Simple](http://pholser.github.io/jopt-simple/download.html): handling command-line arguments correctly
* [KVControl-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/kvcontrol-requestsender): to communicate with KVControl
* [Yakindu-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.mqtt.client): to communicate with the other state machines

## Target Platform ##
JRE 1.7
