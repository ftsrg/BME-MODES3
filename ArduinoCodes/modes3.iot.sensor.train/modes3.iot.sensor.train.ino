#include <Wire.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_LSM303_U.h>
#include "FS.h"
#include <ESP8266WiFi.h>

#include <ArduinoJson.h>


#include <PubSubClient.h>

WiFiClient espClient;
PubSubClient client(espClient);
const char* TOPIC="raw/acc";
const char* MQTTID = "mqtt-test";
const char* MQTTPSWD = "mqtt-test";


void mqttconnect() {
  /* Loop until reconnected */
  while (!client.connected()) {
    Serial.print("MQTT connecting ...");
    /* client ID */
    String clientId = "TRAINNODE01";
    /* connect now */
    if (client.connect("train_sensor_1")) {
      Serial.println("connected");
    } else {
      Serial.print("failed, status code =");
      Serial.print(client.state());
      Serial.println("try again in 5 seconds");
      /* Wait 5 seconds before retrying */
      delay(5000);
    }
  }
}


#define MQTTCONN
#define LABORWIFI

#ifdef LABWIFI
char* ssid     = "Container";
char* password = "LaborImage";
char* host = "192.168.1.239";
#endif
#ifdef LABORWIFI
char* ssid     = "MoDeS3";
char* password = "LaborImage";
char* host = "192.168.1.239";
#endif
#ifdef OTTHONWIFI
char* ssid     = "VargaK";
char* password = "14Basipa";
const char* host = "192.168.1.239";
#endif
#ifdef UTIWIFI
char* ssid     = "HungarianWiFi";
char* password = "flower01";
char* host = "192.168.43.199";
#endif
#ifdef JENOWIFI
char* ssid     = "szepnapot";
char* password = "analizis";
char* host = "192.168.43.208";
#endif

const int serverPort = 5502;


/* Assign a unique ID to this sensor at the same time */
Adafruit_LSM303_Accel_Unified accel = Adafruit_LSM303_Accel_Unified(54321);

int period = 10000;

void displaySensorDetails(void)
{
  sensor_t sensor;
  accel.getSensor(&sensor);
  Serial.println("------------------------------------");
  Serial.print  ("Sensor:       "); Serial.println(sensor.name);
  Serial.print  ("Driver Ver:   "); Serial.println(sensor.version);
  Serial.print  ("Unique ID:    "); Serial.println(sensor.sensor_id);
  Serial.print  ("Max Value:    "); Serial.print(sensor.max_value); Serial.println(" m/s^2");
  Serial.print  ("Min Value:    "); Serial.print(sensor.min_value); Serial.println(" m/s^2");
  Serial.print  ("Resolution:   "); Serial.print(sensor.resolution); Serial.println(" m/s^2");
  Serial.println("------------------------------------");
  Serial.println("");
  delay(500);
}

void setup(void)
{
  Serial.begin(115200);
  Serial.println("Accelerometer Test"); Serial.println("");

  /* Initialise the sensor */
  if (!accel.begin())
  {
    /* There was a problem detecting the ADXL345 ... check your connections */
    Serial.println("Ooops, no LSM303 detected ... Check your wiring!");
    while (1);
  }

  /* Display some basic information on this sensor */
  displaySensorDetails();

  Serial.println("initalising network communication");
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());


  client.setServer("192.168.1.230",1883);
  mqttconnect();



}

void loop(void)
{
  int t0 = micros();
  /* Get a new sensor event */
  sensors_event_t event;
  accel.getEvent(&event);

  /* Display the results (acceleration is measured in m/s^2) */
  Serial.print("X: "); Serial.print(event.acceleration.x); Serial.print("  ");
  Serial.print("Y: "); Serial.print(event.acceleration.y); Serial.print("  ");
  Serial.print("Z: "); Serial.print(event.acceleration.z); Serial.print("  "); Serial.println("m/s^2 ");



  Serial.println("put the data into JSON");

  // Allocate JsonBuffer
  // Use arduinojson.org/assistant to compute the capacity.

  StaticJsonBuffer<1024> jsonBuffer;

  // Create the root object
  JsonObject& root = jsonBuffer.createObject();

  root["SensorID"] = "008";

  root["AccX"] = String(event.acceleration.x);
  root["AccY"] = String(event.acceleration.y);
  root["AccZ"] = String(event.acceleration.z);

  root["MicroTimeStamp"] = String(millis());

  root["Type"] = "acc";
  #ifndef MQTTCONN
  root.printTo(Serial);


  Serial.println("sending the data with TCP");


  Serial.println("connecting to server");
  WiFiClient client;

  if (!client.connect(host, serverPort)) {
    Serial.println("connection failed");
    return;
  }

  Serial.println("sending data");

  root.printTo(client);
#endif


  String message;
  root.printTo(message);
  char msg[1024];
  message.toCharArray(msg,1024);
  Serial.println(msg);
  client.publish(TOPIC, msg);
  Serial.println("massage has published");




  delay(1000);

}
