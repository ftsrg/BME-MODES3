# **Mo**del-based **De**monstrator for **S**mart and **S**afe **S**ystems (MoDeS3)

[![Build Status](https://travis-ci.org/FTSRG/BME-MODES3.svg?branch=gen3-arch)](https://travis-ci.org/FTSRG/BME-MODES3)

Table of Contents
- [Structure of the repository](#structure-of-the-repository)
  * [Configuration management scripts](#configuration-management-scripts)
    + [Sources divided by programming language](#sources-divided-by-programming-language)
      - [C++](#c--)
      - [JavaScript](#javascript)
      - [Java](#java)
- [Getting Started](#getting-started)
  * [As a User](#as-a-user)
  * [As a core developer](#as-a-core-developer)
    + [Troubleshooting](#troubleshooting)

A case study system using the cooperation of a model railway and a robot to demonstrate techniques and methods for developing IoT and CPS systems. See a [quick overview](https://inf.mit.bme.hu/en/research/projects/modes3) and our [blog](http://modes3.tumblr.com/) for more details.

*This repository extensively uses [Git-LFS](https://git-lfs.github.com/), hence install it and upgrade your Git to at least v2.7.0 for full compatibility.*

This repository uses [Gradle](https://gradle.org/) for build management. To build the project type

```
cd src/java
./gradlew build
```

## Structure of the repository

### Configuration management scripts

|  Physical location      | Comments | Owner|
|:------------------------|:--------:|:---:|
|/config-management     | Scripts to deploy the code for the embedded systems.         |  hegyibalint   |

#### Sources divided by programming language

##### C++

- Root path: `/src/cpp/`
- Folder prefix: `hu.bme.mit.inf.modes3.`
- Path prefix: `<root_path> + <folder_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
|imu                | <path_prefix>.components.imu     |           |     |
|Section Occupancy Query   | <path_prefix>.components.soc | Reads the sections occupancy from the physical sensors.   | zsoltmazlo, hegyibalint    |
|Turnout Actuator   | <path_prefix>.components.turnoutactuator | The actuator to set the turnouts' directions.   | hegyibalint    |
|XPressNet Bridge   | <path_prefix>.components.xpressnetbridge | C++ implementation for the XPressNetBridge, in order to send DCC commands to the trains.   | Chorithian (Attila Biró)    |
|train_sample_generator   | <path_prefix>.train_sample_generator |    |  FuzesiMate |

##### JavaScript

- Root path: `/src/js/`
- Folder prefix: `modes3`
- Path prefix: `<root_path> + <folder_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
|Dashboard UI      | <path_prefix>-dashboard  | Dashboard for the model railway track.  |   zsoltmazlo  |
|Touchboard UI   | <path_prefix>-touchboard | Dashboard for the model railway track, with focus on touchable elements.   | hegyibalint    |

##### Java

- Root path: `/src/java/`

- Components folder path: `<root_path>/components/`
- Components project prefix: `hu.bme.mit.inf.modes3.components`
- Components path prefix: `<root_path> + <components_folder_path> + <components_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Dashboard |  <components_path_prefix>.dashboard | Dashboard for the model railway track. | zsoltmazlo
| GPIO Manager |  <components_path_prefix>.gpiomanager | To control the GPIO pins of the Beagle Bone Black embedded units from Java. | hegyibalint
| Leapmotion |  <components_path_prefix>.leapmotion | Leapmotion sensor code in Java. | pappist (Papp István)
| Section Occupancy Query   | <components_path_prefix>.occupancyquery | Reads the sections occupancy from the embededd system and boradcasts it on the network.   | hegyibalint, baloghlaszlo, benedekh    |
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
| Protobuf specific classes and message definitions | <messaging_path_prefix>.proto | Message definitions in protobuf representation and protobuf specific transformators for the messages. | hegyibalint, benedekh | 

- Test folder path: `<root_path>/test/`
- Test project prefix: `hu.bme.mit.inf.modes3.test`
- Test path prefix: `<test_folder_path> + <test_project_prefix>`

| Logical Component |  Physical location      | Comments | Owner|
|:-------------------:|:------------------------|:--------:|:---:|
| Test project | <test_path_prefix> |  | baloghlaszlo | 

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
| SVG Transformer | <utils_path_prefix>.svgtransformer | Utility project to transform SVG in Java. | hegyibalint |



## Getting Started

### As a User

_Should you develop your own application and use 'MoDeS3 as a Service'._

1. Install Java 8 at least.
2. Download the corresponding jar on the [releases](https://github.com/FTSRG/BME-MODES3/releases) page.
3. Read the Wiki pages, especially [Network messages](https://github.com/FTSRG/BME-MODES3/wiki/Network-messages), [On the communication component of the API](https://github.com/FTSRG/BME-MODES3/wiki/On-the-communication-component-of-the-API).

### As a core developer

_Should you develop something to the core library, aka things stored in this repository._

1. Install Java 8 at least.
2. Install Gradle.
3. Clone this repository.
4. Build the gradle projects:

```
cd src/java
./gradlew build
```

5. Install Eclipse or your faviourite IDE, and install Xtend, Gradle plugins there. (Most of the code is implemented in Xtend, we use Gradle as a build system.)

6. Import the Gradle projects in your IDE and try to build the projects there. _Note:_ Should you not need any project, please put a comment mark `#` in front of the lines, which include projects you do not need, in the root folder's `/src/java/build.gradle` file. Please do not commit these changes though.


#### Troubleshooting

- Should you use Eclipse with the Gradle plugin AND change something in any of the *.gradle files (either in the root `/src/java` folder or in your project's folder), do not forget to click on the project name with the right mouse button, and in the dropdown menu go to Gradle -> Plugin refresh. Otherwise, the plugin might not recognize the changes and will end up in an incorrect configuration.

- Should you have build problems in Eclipse with Xtend, check if there is a `build/xtend/main` and `build/xtend/test` folders in the project. If so, remove the folders. In addition to that, remove the `	<classpathentry kind="src" path="build/xtend/main"/>
	<classpathentry kind="src" path="build/xtend/test"/>` lines from the `.classpath` file in the corresponding project.

- Should some change notifications from the file system not arrive to Eclipse, don't forget to use the 'good old' right click on the project name -> Refresh project option. Restarting Eclipse might also solve problems sometimes.
