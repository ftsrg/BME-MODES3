
#include "gyro_driver.h"


GyroDriver::GyroDriver():SensorDriver("gyro"){
  
}

void GyroDriver::init(){
  //initialise the gyro sensor
  debugOut("BMI160 begin");
  BMI160.begin(BMI160GenClass::SPI_MODE, ssPinGyro);
  debugOut("BMI160 set range");
  BMI160.setGyroRange(250);
}

void GyroDriver::update(){
  GyroData newData;
  newData.valid=false;
  newData.timeStamp=millis();
  //it is extremly important to delay the task beacouse if you don't do this the tread will be frozen
  vTaskDelay(1); //important!!! do not remove this line
  BMI160.readGyro(newData.accX,newData.accY,newData.accZ);
  newData.valid=true;
  data.push_back(newData);
  vTaskDelay(5); //important!!! do not remove this line
}

String GyroDriver::generateOut(){
  String buffer;
  for(int i=data.size();i>0;i--){
    GyroData actual=data.front();
    buffer+=String(actual.accX)+"  "+String(actual.accY)+"  "+String(actual.accZ)+"  "+String(actual.timeStamp)+"  "+String(actual.valid)+"\n\r";
    data.pop_front();
  }
  return buffer;
}

void GyroDriver::clear(){
  data.clear();
}


