#include <MQTT_JSON.hpp>

void callback(char *topic, byte *payload, unsigned int length)
{
  StaticJsonBuffer<200> json;
  JsonObject &root = json.parseObject((char *)payload);
  /*if (!strcmp(type, "Ping"))
  {
    PongSend();
  }*/
}

int MQTT_JSON::getTime()
{
  return 100;
}

MQTT_JSON::MQTT_JSON(WiFiClient *wifi) : client(*wifi)
{
}

void MQTT_JSON::PongSend()
{
  char json[800];
  size_t maxSize = 800;
  StaticJsonBuffer<800> jsonBuffer;
  JsonObject &root = jsonBuffer.createObject();
  root["sender"] = DEVICE_NAME;
  root["time"] = getTime();
  root["type"] = "Pong";
  root.printTo(json, maxSize);
  Serial.println(json);
  client.publish(BEVENT_CH, json);
  client.publish(EVENT_CH, json);
}

void MQTT_JSON::ConnCheck()
{
  if (WiFi.status() != WL_CONNECTED)
  {
    Serial.println("WiFi connection lost.");
    //WifiConnect();
  }
  if (!client.connected())
  {
    Serial.println("MQTT connection lost.");
    MQTTConnect();
  }
}

void MQTT_JSON::TrainSend(char *train, int kocsiszam)
{
  char json[800];
  size_t maxSize = 800;
  StaticJsonBuffer<800> jsonBuffer;
  JsonObject &root = jsonBuffer.createObject();
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
  JsonObject &root = jsonBuffer.createObject();
  root["sender"] = DEVICE_NAME;
  root["time"] = getTime();
  root["type"] = "Event";
  if (detect)
  {
    if (direction)
    {
      root["detect"] = "Left";
    }
    else
    {
      root["detect"] = "Right";
    }
  }
  else
  {
    root["detect"] = "False";
  }
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
  JsonObject &root = jsonBuffer.createObject();
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
  JsonObject &root = jsonBuffer.createObject();
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