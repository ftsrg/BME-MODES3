# Introduction

TODO let `Andrew the Red` handle this.

<!-- Use a top-down approach -->

 # Capabilities of the system

<!-- TODO -->

 Base capabilities of the system:

- Detect occupancy
- Sense the turnouts state
- Turn off segments

Additional capabilities of the system <!-- (via the XpressNet component) -->

- Set the speed of the trains
- Sense the speed of the trains
- Send and receive STOP signals.

# Operation of the system

## Start the BBB's

## Start the occupancy query

## Start the XpressNet bridge

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
