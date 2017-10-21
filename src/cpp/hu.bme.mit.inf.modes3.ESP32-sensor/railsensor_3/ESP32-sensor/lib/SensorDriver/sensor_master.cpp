#include "sensor_master.h"


ColorDriver colorSensor;
GyroDriver gyroSensor;
ForceDriver forceSensor;


//heterogen collection of sensor drivers
const int driverCount=3;
SensorDriver* driverStage[driverCount];
const int priority=0;
const int core=1;
const int stackSize=8192;


//send the collected data of a sensor driver to the server via MQTT
void sensorDataSend(SensorDriver* driver){
  Serial.println(driver->generateOut());
}

// to the server via MQTT
void sensorErrorSend(SensorDriver* driver)
{
  Serial.println(driver->generateOut());
}


void masterTask(void* args){
  while(1){
    //check the threads of the drivers and restart them if they are frozen
    for(int i=0;i<driverCount;i++){
      if(!(driverStage[i]->isAlive())){
        debugOut("a thread is frosen ");
        sensorErrorSend(driverStage[i]);
        debugOut("restarting...");
        driverStage[i]->restart();
      }
    }
    vTaskDelay(500);
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
    driverStage[i]->clear();
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
  xTaskCreatePinnedToCore(masterTask,"master task",5000,NULL,priority,NULL,core);
}


