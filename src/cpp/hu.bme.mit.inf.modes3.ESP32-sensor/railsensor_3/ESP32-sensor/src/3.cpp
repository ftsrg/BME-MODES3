#define SENSOR_DISTANCE 7.0
#define CONF_SSID "MoDeS3"
#define PASS "LaborImage"

#include <MQTT_JSON.hpp>
#include <InfraSensor.h>
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

SensorStateMachine stateMachine;
RealTimeSpeed RTSpeed(stateMachine.sensor[0].GetDexP(),stateMachine.sensor[0].DATAstack,stateMachine.sensor[1].GetDexP(),stateMachine.sensor[1].DATAstack);
RealTimeLength Length(stateMachine.sensor[0].GetDexP(),stateMachine.sensor[0].DATAstack,stateMachine.sensor[1].GetDexP(),stateMachine.sensor[1].DATAstack);
RealTimeSelect TrainSelect;
WiFiClient wifi;
MQTT_JSON send(&wifi);

void setup() {
  Serial.println("");
  Serial.begin(9600);                           // Serial init
  Serial.println("Serial init");

  for(int i=0;i<2;i++){                         // Sensors input init
    pinMode(stateMachine.sensor[i].GetPin(), INPUT);
    stateMachine.sensor[i].Reset();
  }
  Serial.println("IO init");
  
  WiFi.begin(CONF_SSID, PASS);                  // WiFi connection init
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
  }
  delay(1000);
  Serial.println("Wifi init");

  send.client.setServer(MQTT_IP, MQTT_PT);      // MQTT connection init
  while (!send.client.connected())
  {
    send.client.connect(DEVICE_NAME, MQTT_US, MQTT_PW);
  }
  send.client.setCallback(callback);
  send.client.subscribe(DATA_CH);
  send.client.subscribe(EVENT_CH);
  Serial.println("MQTT init");
  
  TrainSelect.AddTrain("UNKNOWN",25.0);         // TrainSelect init
  TrainSelect.AddTrain("Taurus",21.5);
  TrainSelect.AddTrain("SNCF",18.5);
  TrainSelect.AddTrain("Vagon",12.25);
  TrainSelect.AddTrain("UNKNOWN",8.0);
  Serial.println("Selector init");

  stateMachine.Init(13,27);                    // stateMachine init
  Serial.println("Statemachine init");
}

unsigned long lastLoop = 0;

void loop() {
  send.ConnCheck();
  if ( millis() - lastLoop > 100 ) {
    send.client.loop();
    lastLoop = millis();
  }

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

  if(Length.Update(stateMachine.sensor[0].GetDex(), stateMachine.sensor[1].GetDex())){
    stateMachine.IncKocsiszam();
    send.LengthSend(Length.GetLastLength(), stateMachine.GetKocsiszam());
    send.TrainSend(TrainSelect.Search(Length.GetLastLength()), stateMachine.GetKocsiszam());
    send.MozdonySend(TrainSelect.Search(Length.GetLastLength()),Length.GetLastLength(),RTSpeed.GetLastSpeed());
  }
}