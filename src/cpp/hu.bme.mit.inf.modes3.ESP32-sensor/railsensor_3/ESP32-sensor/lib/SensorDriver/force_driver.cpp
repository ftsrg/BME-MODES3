
#include "force_driver.h"


void ForceDriver::init(){
  pinMode(25,INPUT);
}


void ForceDriver::update(){
  vTaskDelay(1);//important!!! do not remove this line
  ForceData newData;
  newData.timeStamp=millis();
  newData.force=analogRead(forcePin);
  newData.valid=true;
  vTaskDelay(1);
  data.push_back(newData);
}

String ForceDriver::generateOut(){
  String buffer;
  for(int i=data.size();i>0;i--){
    ForceData actual=data.front();
    buffer+=String(actual.force)+"  "+String(actual.timeStamp)+"  "+String(actual.valid)+"\n\r";
    data.pop_front();
  }
  
  return buffer;
}

ForceDriver::ForceDriver():SensorDriver("Force"){
  
}

void ForceDriver::clear(){
  data.clear();
}


