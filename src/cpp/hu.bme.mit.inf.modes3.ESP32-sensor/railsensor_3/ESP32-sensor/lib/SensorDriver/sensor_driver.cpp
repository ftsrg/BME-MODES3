#include "sensor_driver.h"

void debugOut(const char* s){
  Serial.println(s);
}

int SensorDriver::nextID=1;

SensorDriver::SensorDriver(String typeName):ID(nextID),typeName(typeName){
  nextID++;
}


void taskLoop(void* v_driver){

  SensorDriver* driver=(SensorDriver*) v_driver;
  
  debugOut("call the init func of the driver...");

  //init the sensor
  driver->init();

  debugOut("sensor driver successfully initalised...");

  while(1){
    driver->lastTime=millis();
    if(driver->shouldRun){
      driver->isRunning=true;
      driver->update();
      driver->isRunning=false;
    }
    vTaskDelay(1);
  }

  debugOut("something wrong here");
  
}

bool SensorDriver::isAlive(){
  //check when was update function called
  if(abs(millis()-lastTime)>=timeOut){ 
    return false;
  }else{
    return true;
  }
}

void initaliseDriver(SensorDriver* driver){
  
  debugOut("initalising sensor driver...");

  //convert the ID of the driver to string
  char stringID[25]="Sensor Driver Task: ----";
  int localID=driver->ID;
  for(int i=23;i>=20;i--){
    stringID[i]=(char)('0'+localID%10);
    localID/=10;
  }
  debugOut(stringID);
 
  
  debugOut("start the task of the driver...");

  //init and start the freeRTOS thread
  void* param=(void*) driver;
  xTaskCreatePinnedToCore(taskLoop,stringID,driver->stackSize,param,driver->priority,&(driver->handle),driver->core); 
 
  
}

//cancel the task of the function
void SensorDriver::cancel(){
  vTaskDelete(handle);
}

//destructor of the object
SensorDriver::~SensorDriver(){
  debugOut("cancel the thread of the sensor driver...");
  cancel();
  debugOut("free the allocated dinamic memory");
  clear();
}

//restart the thread
void SensorDriver::restart(){
  debugOut("restart the thread of the sensor driver...");
  cancel();
  initaliseDriver(this);
}

void SensorDriver::start(){
  //restart the task if it is frozen
  clear();
  if(!isAlive()){
    restart();
  }
  debugOut("thread started...");
  shouldRun=true;
}

void SensorDriver::stop(){
  debugOut("stopping...");
  shouldRun=false;
  while(isRunning)
    if(!isAlive()) return;
  debugOut("thread has stopped");
}

void SensorDriver::clear(){
  debugOut("driver has cleared");
}






