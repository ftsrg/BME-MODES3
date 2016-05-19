# EDA collector

This module is responsible for collecting various data from the railway track for EDA (Exploratory Data Analysis) purposes.

## Use

### Development time

Create a Maven project in any IDE (Eclipse or NetBeans are recommended). Maven should fetch the dependencies specified in the pom.xml. Build a new jar from the plugin and deploy it anywhere you would like to use. Beware to use the jar ending with _*-jar-with-dependencies_, because it contains all dependencies.

### Deployment time

Run in command-line: 

`java -jar hu.bme.mit.inf.eda-1.0-SNAPSHOT-jar-with-dependencies.jar [--sl <section status log path>] [--tl <turnout status log path>] [--ol <section occupancy log path>] [--tcvl <trains location based on CV log path>] [-i <data collection interval in minutes>] [-f <data collection frequency in milliseconds>] [-a <IP address of MQTT Broker>] [-p <port number of MQTT Broker>] [--pp <protocol of MQTT Broker>] [-q <QOS of MQTT Broker>]`

Parameters:

* `sl`: Path for section status (enabled/disabled) log file [optional, if omitted then section status is excluded].
* `tl`: Path for turnout status (divergent/straight) log file [optional, if omitted then turnout status is excluded].
* `ol`: Path for occupancy section status (occupied/free) log file [optional, if omitted then section occupancy status is excluded].
* `tcvl`: Path for trains location information based on CV (Computer Vision) log file [optional, if omitted then trains CV status is excluded].
* `i`: data collection interval in minutes (default: 1).
* `f`: data collection frequency in milliseconds (default: 100).
* `a`: IP address of the computer which runs the MQTT Broker *(default: localhost)*.
* `p`: port number of the computer which runs the MQTT Broker *(default: 1883)*.
* `pp`: protocol of the computer which runs the MQTT Broker *(default: tcp)*.
* `q`: QOS of MQTT Broker *(default: 1)*.

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

## Dependants ##

*None*

## Dependencies ##

* [Maven](https://maven.apache.org/download.cgi): to build the project
* [KVControl-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.kvcontrol.mqtt.client): to communicate with the [embedded controller](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.master.mqtt.client)

## Target Platform ##
JRE 1.8