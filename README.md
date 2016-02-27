# BME-MODES3

*This repository extensively uses Git-LFS, hence install it (https://git-lfs.github.com/) and upgrade your Git to at least v2.7.0 for full compatibility.*

Source code repository of the **Mo**del-based **De**monstrator for **S**mart and **S**afe **S**ystems (MoDeS3).

This repository uses [Maven](https://maven.apache.org/download.cgi) for some projects. It has a top-level pom.xml that should be cleaned and installed, so type `mvn clean install` in the command-line in this folder.

Modules stored in the repository:

* [BP-TO-UPPAAL](https://github.com/FTSRG/BME-MODES3/tree/master/bp2uppaal)
* [KVControl-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.kvcontrol.mqtt.client)
* [Master-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.master.mqtt.client)
* [Master-MQTT-SOC](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.master.mqtt.soc)
* [Masters](https://github.com/FTSRG/BME-MODES3/tree/master/masters)
* [MQTT-Common](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.mqtt.common)
[PiClient-MQTT](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.piclient)
* [SerialMonitor](https://github.com/FTSRG/BME-MODES3/tree/master/serialmonitor)
* [Yakindu-Codes-Normal-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.normal)
* [Yakindu-Codes-English-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.english)
* [Yakindu-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.mqtt.client)

Deprecated modules stored in the repository:

* [JSON](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/json)
* [BridgePoint-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/bridgepoint-codes) is deprecated, use [Yakindu-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/yakindu-codes) instead.
* [KVControl](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/kvcontrol) is deprecated, use [KVControl-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.kvcontrol.mqtt.client) instead.
* [KVControl-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/kvcontrol-requestsender) is deprecated, use [KVControl-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.kvcontrol.mqtt.client) instead.
* [KVControl-BPExtension](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/kvcontrol-bpextension) is deprecated, use [Yakindu-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.mqtt.client) instead.
* [KVControl-BPExtension-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/kvcontrol-bpextension-requestsender) is deprecated, use [Yakindu-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.mqtt.client) instead.
* [PiClient](https://github.com/FTSRG/BME-MODES3/tree/master/deprecated/piclient_v4) is deprecated use [PiClient-MQTT](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.piclient) instead
* [Yakindu-Codes](https://github.com/FTSRG/BME-MODES3/tree/master/yakindu-codes) is deprecated use [Yakindu-Codes-Normal-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.normal) and [Yakindu-Codes-English-Turnout](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.yakindu.sc.english) instead.