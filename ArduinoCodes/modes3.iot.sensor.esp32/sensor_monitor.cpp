
#include "sensor_monitor.h"





void SensorMonitor::mqttconnect() {
  /* Loop until reconnected */
  while (!client.connected()) {
    Serial.print("MQTT connecting ...");
    /* client ID */
    String clientId = "TRAINNODE01";
    /* connect now */
    if (client.connect("MQTT", MQTTID, MQTTPSWD)) {
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


float convertRawGyro(int gRaw) {
  // since we are using 250 degrees/seconds range
  // -250 maps to a raw value of -32768
  // +250 maps to a raw value of 32767

  float g = (gRaw * 250.0) / 32768.0;

  return g;
}


void updateCallback(void *arg) {
  //Serial.println("collecting color and gyro data...");
  SensorMonitor *moni = static_cast<SensorMonitor *>(arg);
  while(1){
    moni->update();
  }
}


void printHex(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    //Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    //Serial.print(buffer[i], HEX);
  }
}



void SensorMonitor::update(){

    delay(100);
    
    //local variables
    uint16_t red=-1,green=-1,blue=-1;
    int rawX=-1,rawY=-1,rawZ=-1;
    double accX=-1,accY=-1,accZ=-1;
    
    if(running){
      Serial.println("updating");
      isRunning=true;
      //local variables
      uint16_t red=-1,green=-1,blue=-1;
      int rawX=-1,rawY=-1,rawZ=-1;
      double accX=-1,accY=-1,accZ=-1;
      
      Serial.println("read sensor data...");


      //read color sensor
      Serial.println("read color sensor");
      color.readRedLight(red);
      color.readBlueLight(blue);
      color.readGreenLight(green);
      delay(10);


      //read gyro sensor
      Serial.println("read gyro sensor");
      BMI160.readGyro(rawX, rawY, rawZ);
      delay(10);

      accX=convertRawGyro(rawX);
      accY=convertRawGyro(rawY);
      accZ=convertRawGyro(rawZ);

      
      Serial.println(String(accX)+String(accY)+String(accZ)+String(red)+String(green)+String(blue));

      Serial.println("put the data into JSON");
      // Allocate JsonBuffer
      // Use arduinojson.org/assistant to compute the capacity.
      StaticJsonBuffer<1024> jsonBuffer;
    
      // Create the root object
      JsonObject& root = jsonBuffer.createObject();

      root["SensorID"]="002";
      //root["RedLight"]=String(red);
      //root["BlueLight"]=String(blue);
      //root["GreenLight"]=String(green);
      root["AccX"]=String(accX);
      root["AccY"]=String(accY);
      root["AccZ"]=String(accZ);
      root["Infra1"]=String(digitalRead(infraPin1));
      root["Infra2"]=String(digitalRead(infraPin2));
      //root["Force"]=String(analogRead(forcePin));
      //root["Light"]=String(analogRead(lightPin));
      root["MicroTimeStamp"]=String(millis());

      /*root["Type"]="light";
      if(digitalRead(27)==LOW){
        
        root["Light"]="10";
      }else{
        root["Light"]="1000";
      }*/

      root.printTo(Serial);
      
      #ifndef MQTTCOMM
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

      #ifdef MQTTCOMM

      
    
      String message;
      root.printTo(message);
      char msg[1024];
      message.toCharArray(msg,1024);
      Serial.println(msg);
      client.publish(TOPIC, msg);
      Serial.println("massage has published");

      #endif
      
      //client.stop();
      
    }else{
      isRunning=false;
    }
  
}


SensorMonitor::SensorMonitor(){
  Serial.begin(115200);
  
  

  Serial.println("initialising the sensors...");
  Serial.println("initialising the sensors...");

  Serial.println("initalising the color sensor");
  //initialise the color sensor
  color.init();
  color.enableLightSensor(false);
  delay(10);

//  DHT.begin();
  
  Serial.println("initalising the gyro sensor");
   
  //initialise the gyro sensor
  BMI160.begin(BMI160GenClass::SPI_MODE, ssPinGyro);
  BMI160.setGyroRange(250);
  delay(10);

  
  Serial.println("sensors successfully initialised");


  delay(10);

  // We start by connecting to a WiFi network

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

  //Serial.println("Creating update thread");
  //xTaskCreatePinnedToCore(updateCallback,"update",50000,this,3,NULL,0);

  #ifdef MQTTCOMM
  client=PubSubClient(espClient);
  Serial.println("initalising mqtt connection...");
  client.setServer("192.168.1.230",1883);
  mqttconnect();

  Serial.println("initalisation of mqtt connection is successful :)");

  #endif
  
  Serial.println("initalisation is successful :)");
  
}


void SensorMonitor::start(){
  //Serial.println("start monitoring");
  prevNUID="NONE";
  running=true;
}

void SensorMonitor::stop(){
  //Serial.println("stop monitoring...");
  running=false;
  while(isRunning){
    Serial.println("waiting for core 0");
    delay(5);
  }
  Serial.println("monitoring has stopped");
}



