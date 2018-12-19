#include <DHT.h>
#include <DHT_U.h>

#include <Wire.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_LSM303_U.h>
#include <SparkFun_APDS9960.h>
#include <BMI160Gen.h>
#include <algorithm>
#include <list>
#include <SPI.h>
#include <MFRC522.h>


#include <PubSubClient.h>

#include <ArduinoJson.h>
#include <WiFi.h>

#define LABORWIFI
#define MQTTCOMM

#ifndef SENSOR_MONITOR
#define SENSOR_MONITOR



class SensorMonitor{
  private:

        
    WiFiClient espClient;
    PubSubClient client;
    const char* TOPIC="raw/rail";
    const char* MQTTID = "mqtt-test";
    const char* MQTTPSWD = "mqtt-test";

    void mqttconnect();

  
    Adafruit_LSM303_Accel_Unified gyro=Adafruit_LSM303_Accel_Unified(54321);
    SparkFun_APDS9960 color=SparkFun_APDS9960();
    MFRC522 rfid;
    MFRC522::MIFARE_Key key;
    const int coreID=1;
    const int ssPinGyro=14;
    const int ssPinRFID=12;
    const int rstPinRFID=27;
    const int dhtPin=4;
    const int forcePin=33;
    const int lightPin=25;
//    const int infraPin1=32;
    const int infraPin1=27;
    const int infraPin2=13;
//    DHT dht(dhtPin, DHT11);
    bool running;
    bool isRunning=false;

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

  public:
    String prevNUID;
    SensorMonitor();
    void start();
    void stop();
    void update();
};


#endif
