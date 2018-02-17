# **Mo**del-based **De**monstrator for **S**mart and **S**afe **S**ystems (MoDeS3)

[![Build Status](https://travis-ci.org/FTSRG/BME-MODES3.svg?branch=gen3-arch)](https://travis-ci.org/FTSRG/BME-MODES3)

Table of Contents
- [Getting Started](#getting-started)
- [Structure of the repository](#structure-of-the-repository)
  * [Configuration management scripts](#configuration-management-scripts)
  * [Sources divided by programming language](#sources-divided-by-programming-language)
    + [C++](#c--)
    + [JavaScript](#javascript)
    + [Java](#java)

A case study system using the cooperation of a model railway and a robot to demonstrate techniques and methods for developing IoT and CPS systems. See a [quick overview](https://inf.mit.bme.hu/en/research/projects/modes3) and our [blog](http://modes3.tumblr.com/) for more details.

This repository uses [Gradle](https://gradle.org/) for build management. To build the repository see the [Build and deployment guide](https://github.com/FTSRG/BME-MODES3/wiki/Building-and-deploying-the-repository).

## Getting Started

To set up the development environment on your machine, follow the [Getting Started](https://github.com/FTSRG/BME-MODES3/wiki/Getting-Started) page.

## Structure of the repository

### Configuration management scripts

|  Physical location      | Comments | Owner|
|:------------------------|:--------:|:---:|
|/config-management     | Scripts to deploy the code for the embedded systems.         |  hegyibalint   |

### Sources divided by programming language

#### C++

- Root path: `/src/cpp/`
- Folder prefix: `hu.bme.mit.inf.modes3.`
- Path prefix: `<root_path> + <folder_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
|Barrier Controller | <path_prefix>.components.barriercontroller| The controller script of the railway barriers. | zsoltmazlo |
|Computer Vision | <path_prefix>.components.computervision | The OpenCV-based Computer Vision component, which provides the coordinates of the train markers. | FuzesiMate |
|imu                | <path_prefix>.components.imu     |           |     |
|Section Occupancy Query   | <path_prefix>.components.soc | Reads the sections occupancy from the physical sensors.   | zsoltmazlo, hegyibalint    |
|Train Detector | <path_prefix>.components.trainsamplegenerator | Train detector and locomotive length measurer using infrared sensors. | hegyibalint |
|train_sample_generator   | <path_prefix>.components.trainsamplegenerator |    |  FuzesiMate |
|Turnout Actuator   | <path_prefix>.components.turnoutactuator | The actuator to set the turnouts' directions.   | hegyibalint    |
|XPressNet Bridge   | <path_prefix>.components.xpressnetbridge | C++ implementation for the XPressNetBridge, in order to send DCC commands to the trains.   | Chorithian (Attila Biró)    |

#### JavaScript

- Root path: `/src/js/`
- Folder prefix: `modes3`
- Path prefix: `<root_path> + <folder_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
|Dashboard UI      | <path_prefix>-dashboard  | Dashboard for the model railway track.  |   zsoltmazlo  |
|Touchboard UI   | <path_prefix>-touchboard | Dashboard for the model railway track, with focus on touchable elements.   | hegyibalint    |

#### Java

- Root path: `/src/java/`

- Components folder path: `<root_path>/components/`
- Components project prefix: `hu.bme.mit.inf.modes3.components`
- Components path prefix: `<components_folder_path> + <components_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Barrier |  <components_path_prefix>.barrier | Sends open/close commands to the barrier over the network, depnending on the occupancy of certain segments. | benedekh
| Dashboard |  <components_path_prefix>.dashboard | Dashboard for the model railway track. | zsoltmazlo
| GPIO Manager |  <components_path_prefix>.gpiomanager | To control the GPIO pins of the Beagle Bone Black embedded units from Java. | hegyibalint
| Leapmotion |  <components_path_prefix>.leapmotion | Leapmotion sensor code in Java. | pappist (Papp István)
| Section Occupancy Query   | <components_path_prefix>.occupancyquery | Reads the sections occupancy from the embededd system and broadcasts it on the network.   | hegyibalint, baloghlaszlo, benedekh    |
| Sample Component | <components_path_prefix>.sample | A sample component which can be linked to a tutorial | hegyibalint, baloghlaszlo, benedekh
| Touchboard |  <components_path_prefix>.touchboard | Dashboard for the model railway track, with focus on touchable elements. | hegyibalint, benedekh
| Track Element Controller  | <components_path_prefix>.trackelementcontroller | Implementation of the platform-specific actuator code of disabling and enabling sections and setting turnout directions for the BeagleBone Black embedded units. | benedekh, hegyibalint |

- Safetylogic folder path: `<components_folder_path>/safetylogic/`
- Safetylogic project prefix: `hu.bme.mit.inf.modes3.components.safetylogic`
- Safetylogic path prefix: `<safetylogic_folder_path> + <safetylogic_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Component level safety logic | <safetylogic_path_prefix>.componentlevel.sc | Component level safetylogic by Yakindu statecharts | benedekh |
| Component level safety logic (Model) | <safetylogic_path_prefix>.componentlevel.sc.model | Yakindu models for component level safety logic | benedekh |
| System level safety logic (Event) | <safetylogic_path_prefix>.systemlevel.event | System level safety logic with a runtime EMF model and using VIATRA-Queries| baloghlaszlo
| System level safety logic (Model) | <safetylogic_path_prefix>.systemlevel.model | Model for system level safety logic | baloghlaszlo
| System level safety logic (Model instance) | <safetylogic_path_prefix>.systemlevel.model.instance | Model instance for system level safety logic | baloghlaszlo
| System level safety logic (Sirus editor) | <safetylogic_path_prefix>.systemlevel.model.sirius | Sirius editor for system level safety logic | baloghlaszlo
| System level safety logic (Patterns) | <safetylogic_path_prefix>.systemlevel.rules | VIATRA-CEP rules for system level safety logic | baloghlaszlo

- Messaging folder path: `<root_path>/messaging/`
- Messaging project prefix: `hu.bme.mit.inf.modes3.messaging`
- Messaging path prefix: `<messaging_folder_path> + <messaging_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| High-level API designed for communication with the railroad system | <messaging_path_prefix>.communication | Communication technology independent API designed for further use in the components. | baloghlaszlo | 
| Common messages | <messaging_path_prefix>.messages | Common representation for the messages used over the network in Java. | benedekh | 
| Messaging service + Dispatcher | <messaging_path_prefix>.mms | Messaging service and message dispatcher to dispatch different messages. | baloghlaszlo, benedekh | 
| Protobuf specific classes | <messaging_path_prefix>.proto | Protobuf specific transformators and dispatcher for the messages. | benedekh | 
| Protobuf message definitions | <messaging_path_prefix>.proto.messages | Message definitions in protobuf representation and Java classes generated from them. | hegyibalint, benedekh | 

- Test folder path: `<root_path>/test/`
- Test project prefix: `hu.bme.mit.inf.modes3.test`
- Test path prefix: `<test_folder_path> + <test_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Test project | <test_path_prefix> | Project for testing purposes. To show, how a system test might be implemented. | baloghlaszlo | 

- Transports folder path: `<root_path>/transports/`
- Transports project prefix: `hu.bme.mit.inf.modes3.transports`
- Transports path prefix: `<transports_folder_path> + <transports_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Transport common | <transport_common_prefix>.common | Common classes for the transport layer. | baloghlaszlo | 
| MQTT Transport | <transport_common_prefix>.mqtt | Implementation of the transport layer, using MQTT. | benedekh | 

- Utils folder path: `<root_path>/utils/`
- Utils project prefix: `hu.bme.mit.inf.modes3.utils`
- Utils path prefix: `<utils_folder_path> + <utils_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Utility classes for components | <utils_path_prefix>.common | Utility classes that can be used by every component. E.g. handling command-line arguments in Java. | benedekh |
| Common configuration files | <utils_path_prefix>.conf | Common configuration files for the model railway track. E.g. files containing information about segment, turnout, locomotive IDs | benedekh |
| Serial monitor | <utils_path_prefix>.serialmonitor | Utility project to monitor the serial (USB) port from Java. | zsoltmazlo |
| SVG Transformer | <utils_path_prefix>.svgtransformer | Utility project to transform SVG in Java, in order to map the Open CV coordinates for segments on the railway track. | hegyibalint |