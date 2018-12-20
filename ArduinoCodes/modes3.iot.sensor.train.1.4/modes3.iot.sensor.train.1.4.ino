
#include <Wire.h>
#include "FS.h"
#include <ESP8266WiFi.h>

#include <ArduinoJson.h>


#include "MPU9250_p.h"
#include <PubSubClient.h>

WiFiClient espClient;
PubSubClient client(espClient);
const char* TOPIC="raw/acc";
const char* MQTTID = "mqtt-test";
const char* MQTTPSWD = "mqtt-test";


// an MPU9250 object with the MPU-9250 sensor on I2C bus 0 with address 0x68
MPU9250FIFO IMU(Wire,0x68);
//MPU9250 IMU(Wire,0x68);
int status;


const int fifoSize_=1024;

float ax[fifoSize_], ay[fifoSize_], az[fifoSize_];
size_t fifoSize;



void mqttconnect() {
  /* Loop until reconnected */
  while (!client.connected()) {
    Serial.print("MQTT connecting ...");
    /* client ID */
    String clientId = "TRAINNODE01";
    /* connect now */
    if (client.connect("train_sensor_2")) {
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
char* host = "192.168.1.150";
//char* host = "192.168.1.129";
#endif
#ifdef OTTHONWIFI
char* ssid     = "VargaK";
char* password = "14Basipa";
const char* host = "192.168.1.239";
#endif
#ifdef UTIWIFI
char* ssid     = "HungarianWiFi";
char* password = "flower01";
char* host = "192.168.43.182";
#endif
#ifdef JENOWIFI
char* ssid     = "szepnapot";
char* password = "analizis";
char* host = "192.168.43.208";
#endif

const int serverPort = 5502;


/* Assign a unique ID to this sensor at the same time */

int period = 1000;


void setup(void)
{
  Serial.begin(500000);


  
  // start communication with IMU 
  status = IMU.begin();
  if (status < 0) {
    Serial.println("IMU initialization unsuccessful");
    Serial.println("Check IMU wiring or try cycling power");
    Serial.print("Status: ");
    Serial.println(status);
    while(1) {}
  }

  IMU.enableFifo(true,false,false,false);
  IMU.setAccelRange(MPU9250::ACCEL_RANGE_2G);
  if(IMU.setDlpfBandwidth(MPU9250::NO_DLPF)<0){
    Serial.println("Error with dlp settings");
    while(1);
  }
  IMU.setSrd(0);
  
  Serial.println("initalising network communication");
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(2500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());


  client.setServer(host,1883);
  mqttconnect();

}


void readData(){
  int t0 = micros();
  
  if(!IMU.readFifo()){
    Serial.println("There is an error with the IMU");
    setup();
  }

  
//  IMU.getFifoAccelX_mss(&fifoSize,ax);

IMU.readSensor();
sendData();

      //Serial.println( String(IMU.getAccelX_mss()) + " " + String(IMU.getGyroX_rads()) + " " + String(IMU.getTemperature_C()));
      
}

void sendData(){
  //Serial.println( "sent" + String(IMU.getAccelX_mss())+ String(IMU.getAccelY_mss()) +String(IMU.getAccelZ_mss()));
  
    static int cntr=0;
    StaticJsonBuffer<256> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["SensorID"] = "Train01";


    root["AccX"] = String(IMU.getAccelX_mss());
    root["AccY"] = String(IMU.getAccelY_mss());
    root["AccZ"] = String(IMU.getAccelZ_mss());
  
    root["MicroTimeStamp"] = String(cntr++);
  
    root["Type"] = "acc";
  
  
    //Serial.println(micros()-t0);
    String message;
    
    root.printTo(message);
    Serial.println(message);
    char msg[256];
    if(message.length()>30){
      
      message.toCharArray(msg,256);
      if(!client.publish(TOPIC, msg)){
        Serial.println("mqtt connection lost");
        mqttconnect();
      }
    
    }else{
      Serial.println("Bad formatting:");
      Serial.println(message);
    }
  
}


void loop(void){

//delay(1);
readData();
}
