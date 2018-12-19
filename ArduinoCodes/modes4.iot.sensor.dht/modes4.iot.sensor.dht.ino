/*
 *  This sketch sends data via HTTP GET requests to data.sparkfun.com service.
 *
 *  You need to get streamId and privateKey at data.sparkfun.com and paste them
 *  below. Or just customize this script to talk to other HTTP servers.
 *
 */

/*
 * Configuratins
 * flash mode : QIO
 * flash size : 2M
 * reset method : nodemcu
 * upload speed : 57600
 * flash frequency : 40MHz
 * CPU frequency : 80MHz
 * board : generic esp8266
 */

#include <ESP8266WiFi.h>

#include <ArduinoJson.h>
#include <Adafruit_BMP085.h>


#include "DHT.h"


#include <PubSubClient.h>

WiFiClient espClient;
PubSubClient client(espClient);
const char* TOPIC="raw/dht";
const char* MQTTID="mqtt-test";
const char* MQTTPSWD="mqtt-test";


void mqttconnect() {
  /* Loop until reconnected */
  while (!client.connected()) {
    Serial.print("MQTT connecting ...");
    /* client ID */
    String clientId = "WHEATHERNODE01";
    /* connect now */
    if (client.connect("DHT_Sensor_1")) {
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


#define DHTPIN D4     // what pin we're connected to

#define MQTTCOMM


#ifdef PRESSURE
Adafruit_BMP085 bmp;
#endif


// Uncomment whatever type you're using!

#define DHTTYPE DHT11   // DHT 11

//#define DHTTYPE DHT22   // DHT 22  (AM2302)

//#define DHTTYPE DHT21   // DHT 21 (AM2301)

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
       char* host = "192.168.43.199";
#endif





#ifndef MQTTCOMM    
    // Use WiFiClient class to create TCP connections
WiFiClient client;
const int httpPort = 5502;
#endif


DHT dht(DHTPIN, DHTTYPE);


void setup()
{
    Serial.begin(115200);
    delay(10);

    // We start by connecting to a WiFi network

    Serial.println();
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

    

    dht.begin();

    //#ifdef MQTTCOMM
    
    client.setServer("192.168.1.230",1883);
    mqttconnect();
    //#endif

    
    #ifdef PRESSURE
    if (!bmp.begin()) 
    {
     Serial.println("Could not find BMP180 or BMP085 sensor at 0x77");
     while (1) {}
    }

    #endif
    
    Serial.println("all sensors has been successfully initalised");
}

int value = 0;

void loop()
{
      delay(1000);

      //measure humidity and temperature:


      // Sensor readings may also be up to 2 seconds 'old' (its a very slow sensor)
    
      float humidity = dht.readHumidity();
    
      // Read temperature as Celsius (the default)
    
      float temperature = dht.readTemperature();

      #ifdef PRESSURE
      
      float pressure = bmp.readPressure();

      #endif

      Serial.println("put the data into JSON");
      // Allocate JsonBuffer
      // Use arduinojson.org/assistant to compute the capacity.
      
      StaticJsonBuffer<1024> jsonBuffer;
    
      // Create the root object
      JsonObject& root = jsonBuffer.createObject();

      root["SensorID"]="0012";
      
      root["Humidity"]=String(humidity);
      root["Temperature"]=String(temperature);
      
      root["MicroTimeStamp"]=String(millis());

      root["Type"]="DHTData";

      root["Pressure"]=-1;
      
      
      root.printTo(Serial);
      
      
      String message;
      root.printTo(message);
      char msg[1024];
      message.toCharArray(msg,1024);
      Serial.println(msg);
      client.publish(TOPIC, msg);
      Serial.println("massage has published");
      /*#ifndef MQTTCOMM
      Serial.println("sending the data with TCP");


      Serial.println("connecting to server");
      WiFiClient client;
      
      if (!client.connect(host, httpPort)) {
          Serial.println("connection failed");
          return;
      }

      Serial.println("sending data");
      
      root.printTo(client);
      #endif*/

      //#ifdef MQTTCOMM
/*
      char msg[2048];
      snprintf (msg, 20, "%lf", temperature);
      client.publish(TEMPERATURETOPIC, msg);
      snprintf (msg, 20, "%lf", temperature);
      client.publish(HUMIDITYTOPIC, msg);
          
      String message;
      root.printTo(message);
      message.toCharArray(msg,2048);
      client.publish("raw/dht", msg);
      Serial.println("massage has published");
      */
      Serial.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      //#endif
    
}

