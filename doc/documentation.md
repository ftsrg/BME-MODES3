# Introduction

TODO let `Andrew the Red` handle this.

<!-- Use a top-down approach -->

 # Capabilities of the system

<!-- TODO -->

 Base capabilities of the system:

-----------
 The `BBB` service is responsible of handling expanders installed on the BeagleBone Black. At the moment, the `BBB` service handles the following features:
   - Section control: The device can control the sections connected to it, and switch the track off, causing the train to stop.
   - Turnout control & sense: The device can control, and sense the position of the turnouts connected to it. This position might be STR (Straight), or DIV (Divergent)
-----------

- Detect occupancy
- Sense the turnouts state
- Turn off segments

Additional capabilities of the system <!-- (via the XpressNet component) -->

- Set the speed of the trains
- Sense the speed of the trains
- Send and receive STOP signals.

# Operation of the system

## Start the `BBB` service

Each BeagleBone Black have a `/modes3` directory. This root directory contains two important entries:
  - `run_bbb.sh`, which starts the `bbb` service with the default parameters. In most cases, this is enough.
  - `hu.bme.mit.inf.modes3.components.bbb`, which is the compiled package directory. Inside, the `bin` folder contains the `bbb` component's executable. This executable can be parametrized for special use-cases.

The parameters of the service are the following:
  - `-address`: The address of the broker
  - `-pubPort`: The port which the broker communicates on
  - `-id`: The ID of the current turnout running the service. This ID can be selected from the range `t1`..`t6`.

## Start the occupancy query

The section occupancy detector is connected to the Management Pi (`manage.modes3.intra`), and the `occupancyquery` service can be started from there.

The service can be started from the `/modes3/hu.bme.mit.inf.modes3.components.occupancyquery/bin` directory.

The parameters of the service are the following:
  - `-address`: The address of the broker
  - `-pubPort`: The port which the broker communicates on
  - `-id`: This must be `query`
  - `-config`: For normal operation, this must be `production`

  Example: `/modes3/hu.bme.mit.inf.modes3.components.occupancyquery/bin/hu.bme.mit.inf.modes3.components.occupancyquery -address root.modes3.intra -id query -pubPort 1883 -config production`

## Start the XpressNet bridge

The XpressNet controller is connected to the Management Pi (`manage.modes3.intra`), and the `xpressnetbridge` service can be started from there.

The service can be started from the `/modes3/hu.bme.mit.inf.modes3.components.xpressnetbridge` directory.

The binary can be executed without any parameter.

## Start the safety logic

# Physical stuff

TODO

## Layout of the track

Add a PNG showing the track. Explain the properties of the layout. (There are two disjunct circles etc.)

## Custom electrics

### One turnout

Explain what is connected to one turnout, how do they work
informations about the BBBs. How do we turn off a segment. And how do we sense the status of the turnouts. -- could be a separate section

### Network of the turnouts

Explain how does it work, how do they communicate with each other.

Add a PNG showing the electrical layout.

### Unique stuff -- stuff which only has one instance in the System

Arduinos - how do we read the occupancy

# Software stuff

# High-level API for communication with the base system.
<!-- We should define what is the base system :) -->

## Communication Locator class 1

## Communication Locator class 2 ...

## Safetylogic

### metamodel

###
