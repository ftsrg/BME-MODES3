
#include "gyro_driver.h"


GyroDriver::GyroDriver():SensorDriver("Gyro"){
  
}

void GyroDriver::init(){
  //initialise the gyro sensor
  BMI160.begin(BMI160GenClass::SPI_MODE, ssPinGyro);
  BMI160.setGyroRange(250);
}

void GyroDriver::update(){
  GyroData newData;
  newData.valid=false;
  newData.timeStamp=millis();
  BMI160.readGyro(newData.accX,newData.accY,newData.accZ);
  newData.valid=true;
  data.push_back(newData);
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


