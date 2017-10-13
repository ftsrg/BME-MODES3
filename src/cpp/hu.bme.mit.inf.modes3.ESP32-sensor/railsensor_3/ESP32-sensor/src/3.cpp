#define SENSOR_DISTANCE 7.0

#include <MQTT_JSON.hpp>
#include <InfraSensor.hpp>
#include <SensorStatemachine.hpp>
#include <RealTimeSelect.hpp>
#include <RealTimeLength.h>
#include <realtimespeed.hpp>
#include <string>
#include <stdlib.h>

using namespace std;

InfSensor Sensor[2]={InfSensor(13),InfSensor(27)};
SensorStateMachine stateMachine(Sensor);
RealTimeSpeed RTSpeed(Sensor[0].GetDexP(),Sensor[0].DATAstack,Sensor[1].GetDexP(),Sensor[1].DATAstack);
RealTimeLength Length(Sensor[0].GetDexP(),Sensor[0].DATAstack,Sensor[1].GetDexP(),Sensor[1].DATAstack);
RealTimeSelect TrainSelect;
WiFiClient wifi;
MQTT_JSON send(&wifi);

void setup() {
  Serial.begin(9600);
  
  for(int i=0;i<2;i++){
    pinMode(Sensor[i].GetPin(), INPUT);
    Sensor[i].Reset();
  }

  TrainSelect.AddTrain("UNKNOWN",25.0);
  TrainSelect.AddTrain("Taurus",21.5);
  TrainSelect.AddTrain("SNCF",18.5);
  TrainSelect.AddTrain("Vagon",12.25);
  TrainSelect.AddTrain("UNKNOWN",8.0);

  send.PongSend();
}

unsigned long lastLoop = 0;

void loop() {
  send.ConnCheck();
  /*if ( millis() - lastLoop > 100 ) {
    send.client.loop();
    lastLoop = millis();
  }*/
  
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
  }
}