#define SENSOR_DISTANCE 7.0
#define CONF_SSID "MoDeS3"
#define PASS "LaborImage"

#include <MQTT_JSON.hpp>
#include <InfraSensor.hpp>
#include <SensorStatemachine.hpp>
#include <RealTimeSelect.hpp>
#include <RealTimeLength.h>
#include <realtimespeed.hpp>
#include <string>
#include <stdlib.h>

struct Serl {
  Serl() {
    Serial.begin(9600);
  };
};
Serl s;

InfSensor Sensor[2]={InfSensor(13),InfSensor(27)};
SensorStateMachine stateMachine(Sensor);
RealTimeSpeed RTSpeed(Sensor[0].GetDexP(),Sensor[0].DATAstack,Sensor[1].GetDexP(),Sensor[1].DATAstack);
RealTimeLength Length(Sensor[0].GetDexP(),Sensor[0].DATAstack,Sensor[1].GetDexP(),Sensor[1].DATAstack);
RealTimeSelect TrainSelect;
WiFiClient wifi;
MQTT_JSON send(&wifi);

void setup() {
  Serial.begin(9600);                     // Serial init

  for(int i=0;i<2;i++){                   // Sensors input init
    pinMode(Sensor[i].GetPin(), INPUT);
    Sensor[i].Reset();
  }
  
  WiFi.begin(CONF_SSID, PASS);            // WiFi connection init
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
  }

  send.client.setServer(MQTT_IP, MQTT_PT);   // MQTT connection init
  while (!send.client.connected())
  {
    send.client.connect(DEVICE_NAME, MQTT_US, MQTT_PW);
  }
  send.client.setCallback(callback);
  send.client.subscribe(DATA_CH);
  send.client.subscribe(EVENT_CH);

  Serial.println("Kakadu0");

  TrainSelect.AddTrain("UNKNOWN",25.0);
  TrainSelect.AddTrain("Taurus",21.5);
  TrainSelect.AddTrain("SNCF",18.5);
  TrainSelect.AddTrain("Vagon",12.25);
  TrainSelect.AddTrain("UNKNOWN",8.0);

  while (1)
  {
    Serial.println("Kakadu");
    send.client.publish(EVENT_CH,"KAKADU");
    delay(1000);
  }
}

//unsigned long lastLoop = 0;

void loop() {/*
  send.ConnCheck();
  /*if ( millis() - lastLoop > 100 ) {
    send.client.loop();
    lastLoop = millis();
  }*/
  /*
  stateMachine.Update();
  if(stateMachine.GetState()==Datasend){
    Length.Reset();
    RTSpeed.Reset();
    send.EventSend(false, false);
  }
  if(stateMachine.GetState()==Firstdetect){
    send.EventSend(true, stateMachine.GetDirection());
  }
  if(RTSpeed.Update()){
    send.SpeedSend(RTSpeed.GetLastSpeed());
  }
  if(Length.Update(Sensor[0].GetDex(), Sensor[1].GetDex())){
    stateMachine.IncKocsiszam();
    send.LengthSend(Length.GetLastLength(), stateMachine.GetKocsiszam());
    send.TrainSend(TrainSelect.Search(Length.GetLastLength()), stateMachine.GetKocsiszam());
  }*/
}