# Master-MQTT-SOC

This module is responsible for providing section occupancy vector. It is installed for the Arduino that queries the occupancy through the model railway protocol over the telephone cable (RJ11).

We use Maven for building the project and fetching the dependencies specified in the pom.xml.

## Use the library

Open the [src/main/main.ino](https://github.com/FTSRG/BME-MODES3/blob/master/hu.bme.mit.inf.master.mqtt.soc/src/main/main.ino) file in the [Arduino IDE](https://www.arduino.cc/en/Main/Software), and upload the code for the Arduino. 

Install the dependencies in the Arduino IDE, so all the headers will be resolved correctly.

## Dependants

*None*

## Dependencies

* [Arduino MQTT Client](http://www.eclipse.org/paho/clients/c/embedded/): classes used for MQTT communication and configuration.

## Target Platform
Arduino