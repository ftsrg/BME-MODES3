# Arduino masters

*This module is deprecated, use [Master-MQTT-Client](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.master.mqtt.client) and [Master-MQTT-SOC](https://github.com/FTSRG/BME-MODES3/tree/master/hu.bme.mit.inf.master.mqtt.soc) instead.*

Source codes uploded to Arduino for communication over TCP/IP and UDP protocols.

**Beware which folder (tcp or udp) you want to use!**

`SOC` (Section Occupancy Controller) and `SC` (Safety Controller) functionalities are implemented, separated by `define`.

## Use

`main.h`: 

1. `MASTER_ADDRESS` constant should be set (it defines the last octet of the IP address as well)

2. 

	a) Use `define` for the `SC_FUNCTIONALITY`, if you want to use it as a Safety Controller (SC). **Do not `define SOC_FUNCTIONALITY` in this case!**

	b) Use `define`ÿfor the `SOC_FUNCTIONALITY`, if you want to use it as Section Occupancy Controller (SOC). **Do not `define SC_FUNCTIONALITY` in this case!**

`main.cpp`:

Implement the `readTurnoutStatus` function (which is responsible for sensing the recent direction of the turnout wired to the Arduino), if you want to use it as a Safety Controller (SC).