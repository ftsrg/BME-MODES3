/*
#ifndef SENSOR_MASTER
#define SENSOR_MASTER

#include "color_driver.h"
#include "gyro_driver.h"
#include "force_driver.h"

ColorDriver colorSensor;
GyroDriver gyroSensor;
ForceDriver forceSensor;

//heterogen collection of sensor drivers
const int driverCount=3;
SensorDriver* driverStage[driverCount];

//send the collected data of a sensor driver to the server via MQTT
void sensorDataSend(SensorDriver* driver)
{
  debugOut("send the collected data...");
  StaticJsonBuffer<800> jsonBuffer;
  JsonObject &root = jsonBuffer.createObject();
  root["sender"] = DEVICE_NAME;
  root["time"] = getTime();
  root["type"] = driver->typeName;
  root["data"] = driver->generateOut();
  root.printTo(json, maxSize);
  client.publish(BDATA_CH, json);
  client.publish(DATA_CH, json);
}

//send the driver error to the server via MQTT
void sensorErrorSend(SensorDriver* driver)
{
  debugOut("send the error...");
  StaticJsonBuffer<800> jsonBuffer;
  JsonObject &root = jsonBuffer.createObject();
  root["sender"] = DEVICE_NAME;
  root["time"] = getTime();
  root["type"] = "error";
  root["data"] = driver->typeName+" sensor is frosen, attempting to restart";
  root.printTo(json, maxSize);
  client.publish(BDATA_CH, json);
  client.publish(DATA_CH, json);
}

const int priority=0;
const int core=0;
void masterTask(){
  //check the threads of the drivers
  for(int i=0;i<driverCount;i++){
    if(!driverStage[i]->isAlive()){
      driverStage[i]->restart();
    }
  }
  
}

void startMeasurement(){
  for(int i=0;i<driverCount;i++){
    driverStage[i]->start();
  }
}

void stopMeasurement(){
  for(int i=0;i<driverCount;i++){
    driverStage[i]->stop();
    sensorDataSend(driverStage[i]);
  }
}

void initalise(){
  //initalise the drivers
  driverStage[0]=&colorSensor;
  driverStage[1]=&gyroSensor;
  driverStage[2]=&forceSensor;
  for(int i=0;i<driverCount;i++){
    initaliseDriver(driverStage[i]);
  }
  //initalise the master loop
  xTaskCreatePinnedToCore(masterTask,"master task",5000,priority,NULL,core);
}



#endif*/
