# MQTT-Common

Common classes used for MQTT communication and configuration.

We use Maven for building the project and fetching the dependencies specified in the pom.xml.

## Use the library development time

Create a Maven project in any IDE (Eclipse or NetBeans are recommended). Maven should fetch the dependencies specified in the pom.xml. Build a new jar from the plugin and deploy it anywhere you would like to use. Beware to use the jar ending with _*-jar-with-dependencies_, because it contains all dependencies.

## Dependants

* [KVControl-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.kvcontrol.mqtt.client)
* [Yakindu-Codes-Normal-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.normal)
* [Yakindu-Codes-English-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.english)

## Dependencies

* [Maven](https://maven.apache.org/download.cgi): to build the project.
* [Paho](http://www.eclipse.org/paho/): the MQTT client. *See pom.xml*
* [GSON](https://github.com/google/gson): we use Gson instead of JSON, because it is more convenient. *See pom.xml*
* [log4j](http://logging.apache.org/log4j/1.2/): for logging. *See pom.xml*

## Target Platform
JRE 1.7