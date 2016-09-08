# **Mo**del-based **De**monstrator for **S**mart and **S**afe **S**ystems (MoDeS3)

[![Build Status](https://travis-ci.org/FTSRG/BME-MODES3.svg?branch=gen3-arch)](https://travis-ci.org/FTSRG/BME-MODES3)

A case study system using the cooperation of a model railway and a robot to demonstrate techniques and methods for developing IoT and CPS systems. See a [quick overview](https://inf.mit.bme.hu/en/research/projects/modes3) and our [blog](http://modes3.tumblr.com/) for more details.

*This repository extensively uses [Git-LFS](https://git-lfs.github.com/), hence install it and upgrade your Git to at least v2.7.0 for full compatibility.*

This repository uses [Gradle](https://gradle.org/) for build management. To build the project type

```
cd src
./gradlew build
```

Modules stored in the repository:


| Logical Components  |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Web-based Dashboard | src/js/modes3-dashboard | | hegyibalint, zsoltmazlo
| Codes for the BBBs  | src/java/components/hu.bme.mit.inf.modes3.components.bbb/ | | benedekh
| Common Components | src/java/components/hu.bme.mit.inf.modes3.components.common | Common codes and helpers for all components| hegyibalint, baloghlaszlo, benedekh
| Sample Component | src/java/components/hu.bme.mit.inf.modes3.components.sample | A sample component which can be linked to a tutorial | hegyibalint, baloghlaszlo, benedekh
| TODO Beni | src/java/components/hu.bme.mit.inf.modes3.components.util | | benedekh |
| System level safety logic | src/java/components/safetylogic/hu.bme.mit.inf.modes3.components.safetylogic.event | System level safety logic with a runtime EMF model and using VIATRA-Queries TODO english | baloghlaszlo
| Component level safety logic | src/java/components/safetylogic/hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc | Component level safetylogic with Yakindu statecharts | benedekh |
| High-level API designed for communication with the railroad system | src/java/messaging/hu.bme.mit.inf.modes3.messaging.communication | Communication technology independent API designed for further use in the components | baloghlaszlo | 
| | src/java/messaging/hu.bme.mit.inf.modes3.messaging.communication | | hegyibalint |
| | src/java/transports/hu.bme.mit.inf.modes3.transports.common | | hegyibalint |
| | src/java/transports/hu.bme.mit.inf.modes3.transports.zeromq | | hegyibalint |


