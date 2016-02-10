# KVControl-MQTT-Client: Model railway track controller and data collector library based on MQTT

Created in order to communicate with the model railway track.

Formerly [KVControl](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol) and [KVControl-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-requestsender) were used for this purpose, but as of the Eclipse IoT Challange 2016 we switched for MQTT ([Paho](http://www.eclipse.org/paho/) and [Mosquitto](http://www.eclipse.org/mosquitto/)).

We use Maven for building the project and fetching the dependencies specified in the pom.xml.

## Use the library development time

Create a Maven project in any IDE (Eclipse or NetBeans are recommended). Maven should fetch the dependencies specified in the pom.xml. Build a new jar from the plugin and deploy it anywhere you would like to use. Beware to use the jar ending with _*-jar-with-dependencies_, because it contains all dependencies.

## Use the library at runtime (deployment)

Because of MQTT you need a Broker to make the clients be able to communicate with each other. As a broker we use [Mosquitto](http://www.eclipse.org/mosquitto/). You should deployed on a computer that is accessible by this library through a network. Required contact information: IP address, port, protocol of the deployed Mosquitto broker. Default values for these parameters are:

* IP address: *IP address of the computer that runs the Mosquitto broker*
* port: *1883*
* protocol: *TCP*

You should instantiate the classes in the `hu.bme.mit.inf.kvcontrol.mqtt.client.senders` package with the paramers specified above. Note: the `MQTTConfiguration` object requires a `topic` field as well, its default value ought to be `modes3/kvcontrol`.

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

## Dependants

*None*

## Dependencies

* [Maven](https://maven.apache.org/download.cgi): to build the project.
* [Paho](http://www.eclipse.org/paho/): the MQTT client. *See pom.xml*
* [GSON](https://github.com/google/gson): we use Gson instead of JSON, because it is more convenient. *See pom.xml*
* [log4j](http://logging.apache.org/log4j/1.2/): for logging. *See pom.xml*

## Target Platform
JRE 1.8