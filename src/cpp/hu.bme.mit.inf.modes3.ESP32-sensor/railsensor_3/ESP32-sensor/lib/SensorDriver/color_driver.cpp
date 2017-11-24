

#include "color_driver.h"

void ColorDriver::init(){
  
  //initialise the color sensor
  color.init();
  color.enableLightSensor(false);
  
}

void ColorDriver::update(){

  //read and save data from color sensor
  vTaskDelay(5);//important!!! do not remove this line
  ColorData newData;
  newData.timeStamp=millis();
  color.readRedLight(newData.red);
  color.readBlueLight(newData.blue);
  color.readGreenLight(newData.green);
  newData.valid=true;
  data.push_back(newData);
  vTaskDelay(5);//important!!! do not remove this line
}

String ColorDriver::generateOut(){
  String buffer;
  //write the data in .cs format to the buffer string
  for(int i=data.size(); i>0;i--){
    ColorData actual=data.front();
    buffer+=String(actual.red)+"  "+String(actual.green)+"  "+String(actual.blue)+"  "+String(actual.timeStamp)+"  "+String(actual.valid)+"\n\r";
    data.pop_front();
  }
  return buffer;
}


ColorDriver::ColorDriver():SensorDriver("color"){
  
}


void ColorDriver::clear(){
  data.clear();
}

