#include <MQTT_JSON.hpp>


int MQTT_JSON::getTime() {
    return 100;
  }
  
  
  MQTT_JSON::MQTT_JSON(WiFiClient* wifi):client(*wifi){
   WifiConnect();
   MQTTConnect();
 }
 
 void MQTT_JSON::callback(char* topic, byte* payload, unsigned int length) {
    Serial.println("Callback running...");
    StaticJsonBuffer<200> json;
    char sender[20];
    char type[10];
    int time;
    JsonObject& root = json.parseObject((char*)payload);
    strcpy(sender, root["sender"]);
    time = root["time"];
    strcpy(type, root["type"]);
    if (!strcmp(type,"Ping")) {
      PongSend();
    }
  }
  
 void MQTT_JSON::PongSend()
  {
      char json[800];
      size_t maxSize = 800;
      StaticJsonBuffer<800> jsonBuffer;
      JsonObject& root = jsonBuffer.createObject();
      root["sender"] = DEVICE_NAME;
      root["time"] = getTime();
      root["type"] = "Pong";
      root.printTo(json, maxSize);
      Serial.println(json);
      client.publish(BEVENT_CH, json);
      client.publish(EVENT_CH, json);
  }
  void MQTT_JSON::WifiConnect(){
    Serial.println("");
    Serial.print("Connecting to WiFi");
    WiFi.begin(CONF_SSID, PASS);
    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
    }
    Serial.println("");
    Serial.println("Connected to the WiFi network");
  }
  
  void MQTT_JSON::MQTTConnect(){
    client.setServer(MQTT_IP, MQTT_PT);
    while (!client.connected()) {
      Serial.print("Connecting to MQTT");
      for(int i=0; i<3; i++){
        Serial.print(".");
        delay(500);
      }
      if (client.connect(DEVICE_NAME, MQTT_US, MQTT_PW )) {
        Serial.println("");
        Serial.println("Connected to MQTT server");
        client.publish(CONSOLE_CH, "Connected to MQTT server");
      } else {
        Serial.print("failed with state ");
        Serial.println(client.state());
      }
    }
    //client.setCallback(callback);
    client.subscribe(DATA_CH);
    client.subscribe(EVENT_CH);
    Serial.print("Message sent.");
  }
  
  void MQTT_JSON::ConnCheck(){
    if(WiFi.status() != WL_CONNECTED){
      Serial.println("WiFi connection lost.");
      WifiConnect();
    }
    if(!client.connected()){
      Serial.println("MQTT connection lost.");
      MQTTConnect();
    }
  }
 
  void MQTT_JSON::TrainSend(char* train, int kocsiszam)
  {
      char json[800];
      size_t maxSize = 800;
      StaticJsonBuffer<800> jsonBuffer;
      JsonObject& root = jsonBuffer.createObject();
      root["sender"] = DEVICE_NAME;
      root["time"] = getTime();
      root["type"] = "Train";
      root["counter"] = kocsiszam;
      root["train"] = train;
      root.printTo(json, maxSize);
      client.publish(BDATA_CH, json);
      client.publish(DATA_CH, json);
  }
  
  void MQTT_JSON::EventSend(bool detect, bool direction)
  {
      char json[800];
      size_t maxSize = 800;
      StaticJsonBuffer<800> jsonBuffer;
      JsonObject& root = jsonBuffer.createObject();
      root["sender"] = DEVICE_NAME;
      root["time"] = getTime();
      root["type"] = "Event";
      if (detect) {
        if (direction) {
          root["detect"] = "Left";
        }
        else {root["detect"] = "Right";}
      }
      else {root["detect"] = "False";}
      //root["direction"] = direction;
      root.printTo(json, maxSize);
      Serial.println(json);
      client.publish(BEVENT_CH, json);
      client.publish(EVENT_CH, json);
  }
  
  void MQTT_JSON::SpeedSend(double speed)
  {
      char json[800];
      size_t maxSize = 800;
      StaticJsonBuffer<800> jsonBuffer;
      JsonObject& root = jsonBuffer.createObject();
      root["sender"] = DEVICE_NAME;
      root["time"] = getTime();
      root["type"] = "Speed";
      root["speed"] = speed;
      root.printTo(json, maxSize);
      client.publish(BDATA_CH, json);
      client.publish(DATA_CH, json);
      Serial.println(json);
  }
  
  void MQTT_JSON::LengthSend(double length, int kocsiszam)
  {
      char json[800];
      size_t maxSize = 800;
      StaticJsonBuffer<800> jsonBuffer;
      JsonObject& root = jsonBuffer.createObject();
      root["sender"] = DEVICE_NAME;
      root["time"] = getTime();
      root["type"] = "Length";
      root["counter"] = kocsiszam;
      root["length"] = length;
      root.printTo(json, maxSize);
      client.publish(BDATA_CH, json);
      client.publish(DATA_CH, json);
      Serial.println(json);
  };