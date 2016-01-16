# KVControl: Model railway track controller and data collector library

REST API created in order to communicate with the model railway track.

Documentation of the API (providing it is running at `http://localhost:8080`):

`GET`:

* `/occupancy`: gives the occupancy of all the sections as a number in the `result` field of the reply JSON object. Indexing the binary representation of this number with the ID of the given section, indicates whether the respective section is occupied (1) or not (0). Occupied means there is something on the section which has a resistance in the electricity aspects.

* `/occupancy/{id}`: gives the occupancy of the section, identified by `id`. The `result` field of the reply JSON object indicates whether the respective section is occupied (1) or not (0). Occupied means there is something on the section which has a resistance in the electricity aspects.

* `/section/{id}`: gives the state of the section, identified by `id`. The `result` field of the reply JSON object indicates whether the respective section is `enabled` or `disabled`. Disabled means no train can go through the section, all of them must stop there.

* `/turnout/{id}`: gives the recent direction of the turnout, identified by `id`. The `result` filed of the reply JSON object indicates whether the respective turnout is in `straight` or `divergent` direction. 


`PUT`:

* `/section/{id}`: sets the state of the section, identified by `id`. The state of the section can be set, by the `state` parameter of the JSON object that will be sent to this URL. If the respective parameter is `true`, the sections will be `enabled`. If the parameter is `false`, the section will be `disabled`.

If the section or turnout identified by `id` does not exist, the value of `result` field of the reply JSON object will be `NotFound`.

Any other incorrect query will result in a HTTP 400 response code.


## Use

a) Run in command-line: `java -jar KVControl.jar -p <port> -t <timeout>`, where `port` will be the port number of the REST server, and `timeout` will be refresh frequency of the data in milliseconds.

b) Add this library as a .jar dependency to a Java project, and use its classes and methods.
 
## Dependants

* [PiClient](https://github.com/FTSRG/BME-MODES3/tree/master/piclient_v4)

## Dependencies

* [JOpt Simple](http://pholser.github.io/jopt-simple/download.html): handling command-line arguments correctly

* [JSON](https://github.com/FTSRG/BME-MODES3/tree/master/json)

## Target Platform
JRE 1.7