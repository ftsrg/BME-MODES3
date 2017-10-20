

#include "color_driver.h"

void ColorDriver::init(){
  
  //initialise the color sensor
  color.init();
  color.enableLightSensor(false);
  
}

void ColorDriver::update(){

  //read and save data from color sensor
  ColorData newData;
  newData.timeStamp=millis();
  color.readRedLight(newData.red);
  color.readBlueLight(newData.blue);
  color.readGreenLight(newData.green);
  newData.valid=true;
  data.push_back(newData);
}

String ColorDriver::generateOut(){
  String buffer;
  //write the data in .cs format to the buffer string
  for(int i=data.size(); i>0;i--){
    ColorData actual=data.front();
    buffer+=String(actual.red)+"  "+String(actual.green)+"  "+String(actual.blue)+"  "+String(actual.timeStamp)+"  "+String(actual.valid);
    data.pop_front();
  }
  return buffer;
}


ColorDriver::ColorDriver():SensorDriver("Color"){
  
}


void ColorDriver::clear(){
  data.clear();
}

