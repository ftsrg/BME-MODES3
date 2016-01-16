# PiClient

It is a simple monitoring application, which supervises the model railway track's recent state: turnouts' direction, sections' occupancy and status. Its name comes from the target deployment platform which is Raspberry Pi.

## Use

Create a jar from the source codes, make `hu.bme.mit.inf.piclient.Application` as the main class of the jar file. **Beware that the `resources` folder, containin the `layout.svg` is on the same hierarchy level as the recently compiled jar of PiClient!**

If the application throws an SVG Error at runtime, just ignore it and restart the application.

## Configuration

After starting the jar, open the `Settings` menu and set how you want to connect to the model railway track:

a) `Connect to remote server`: set the IP address and port number of the computer which runs the module called `KVControl` (see [KVControl](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol) repository).

b) `Create local server`: set the port number where the `KVControl` would be executed. **Beware that choosing this option means `PiClient` will run `KVControl` implicitly.** Tick the `Connect directly`, so `PiClient` will directly communicate with the model railway track, and start a `KVControl` as well.

c) `Direct connection`: `PiClient` will not start a `KVControl`, but directly communicate with the model railway track.

In the other sections of the `Settings` windows, the data update can be enabled, and the coloring can be set. Besides, with the slider at the bottom of the window, the frequency of data update (turnouts' direction, sections' status and occupancy) in milliseconds.
 

## Dependants

*None*

## Dependencies

* [KVControl](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol): if PiClient starts KVControl itself
* [KVControl-RequestSender](https://github.com/FTSRG/BME-MODES3/tree/master/kvcontrol-requestsender): to communicate with KVControl
* [Apache Batik SVG Toolkit](https://xmlgraphics.apache.org/batik/download.html)
* other libraries: to handle SVG

## Target Platform ##
JRE 1.7