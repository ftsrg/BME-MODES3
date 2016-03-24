# Yakindu-Codes: English turnout

The development of this module started in August 2015, because severe bugs in the Verifier module of [BridgePoint](http://xtuml.org) (v5.1.0) that resulted in malfunction of the distributed system. Thus we switched to [Yakindu Statecharts](https://www.itemis.com/en/yakindu/statechart-tools/) that is a more reliable statechart designer and code-generator framework.

So state machines created with BridgePoints have been transformed to Yakindu statecharts. Besides, source codes have been generated from statecharts. This repository contains (1) the statecharts, (2) the generated source code from the statecharts, (3) additional codes which are necessary to communicate with the model railway track.

Statecharts which belong to the respective turnouts can be run separately, see [Use](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.english#use) section below.

*Normal turnout version of the library is available [here](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.normal).*

*Former version of the library is available [here](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/yakindu-codes).*

## Use

### Development time

Create a Maven project in any IDE (Eclipse or NetBeans are recommended). Maven should fetch the dependencies specified in the pom.xml. Build a new jar from the plugin and deploy it anywhere you would like to use. Beware to use the jar ending with _*-jar-with-dependencies_, because it contains all dependencies.

### Deployment time

**English turnout (0x86-0x87):**

Run in command-line: 

`java -jar hu.bme.mit.inf.yakindu.sc.english-1.0.0-SNAPSHOT-jar-with-dependencies.jar [--sl] [--tp <statechart trace log directory path>] [-a <IP address of MQTT Broker>] [-p <port number of MQTT Broker>] [--pp <protocol of MQTT Broker>] [-q <QOS of MQTT Broker>]`

Parameters:

* `sl`: if it is set, status information will be logged at the standard output and error output.
* `tp`: if it is set and a path is given as a parameter, then the trace log will be saved to an XML file within the respective folder. This way transitions can be logged for the statecharts.
* `a`: IP address of the computer which runs the MQTT Broker *(default: localhost)*.
* `p`: port number of the computer which runs the MQTT Broker *(default: 1883)*.
* `pp`: protocol of the computer which runs the MQTT Broker *(default: tcp)*.
* `q`: QOS of MQTT Broker *(default: 1)*.

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

For the english turnout a separate statechart has been designed, that is in the `models/english-turnout` folder. It contains the "safety logic" that prevents trains collision in case of english turnout. Because the turnout consists of two parts itself, it is reflected the Java code level: double instantiation of the same "english turnout" statchart, and the interconnection of the cross-calls (events) from one part of the english turnout to the other. From every other perspective, the normal turnout and the english turnout are the same.

## Dependants ##

*None*

## Dependencies ##

* [JOpt Simple](http://pholser.github.io/jopt-simple/download.html): handling command-line arguments correctly
* [KVControl-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.kvcontrol.mqtt.client): to communicate with the [embedded controller](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.master.mqtt.client)
* [Yakindu-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.mqtt.client): to communicate with the other state machines

## Target Platform ##
JRE 1.7