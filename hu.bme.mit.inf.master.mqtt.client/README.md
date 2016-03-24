# Master-MQTT-Client

This module is responsible for providing information from the masters' perspective. So this code is uploaded to the embedded controller, which is responsible for enabling/disabling the sections, querying the turnout's direction and the sections' status (free or occupied).

We use Maven for building the project and fetching the dependencies specified in the pom.xml.

## Use 

### Development time

Create a Maven project in any IDE (Eclipse or NetBeans are recommended). Maven should fetch the dependencies specified in the pom.xml. Build a new jar from the plugin and deploy it anywhere you would like to use. Beware to use the jar ending with _*-jar-with-dependencies_, because it contains all dependencies.

### Deployment time

`java -jar hu.bme.mit.inf.master.mqtt.client-1.0.0-SNAPSHOT-jar-with-dependencies.jar [--sl] [-a <IP address of MQTT Broker>] [-p <port number of MQTT Broker>] [--pp <protocol of MQTT Broker>] [-q <QOS of MQTT Broker>]`

Parameters:

* `sl`: if it is set, status information will be logged at the standard output and error output.
* `a`: IP address of the computer which runs the MQTT Broker *(default: localhost)*.
* `p`: port number of the computer which runs the MQTT Broker *(default: 1883)*.
* `pp`: protocol of the computer which runs the MQTT Broker *(default: tcp)*.
* `q`: QOS of MQTT Broker *(default: 1)*.

All parameters are optional.

## Dependants

*None*

## Dependencies

* [Maven](https://maven.apache.org/download.cgi): to build the project.
* [JOpt-Simple](https://pholser.github.io/jopt-simple/): to handle the command-line parameters.
* [MQTT-Common](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.mqtt.common): common classes used for MQTT communication and configuration.
* [Bulldog lib](https://github.com/px3/bulldog): BeagleBoneBlack Java library.

## Target Platform
JRE 1.7