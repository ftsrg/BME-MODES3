#include "InfraSensor.h"

InfraSensor::InfraSensor(int p):pin(p), prelltime(SENSOR_PRELLTIME){}
InfraSensor::InfraSensor():prelltime(SENSOR_PRELLTIME){}
void InfraSensor::SetPin(int pin){
  this->pin=pin;
}
bool InfraSensor::Update(){
value=(digitalRead(pin)==0);
  switch (state){
    case Wait:
      if(value!=0){
        state=Detect;
        DATAstack[sindex]=SecTime(); //in
        sindex++;
        DATAstack[sindex]=SecTime(); //"out"
        return true;
      }
      if(value==0){
        state=Wait;
        return false;
      }
      state=Error;
      return false;
    break;
    case Detect:
      if(value==0){
        state=Prell;
        return true;
      }
      if(value!=0){
        state=Detect;
        DATAstack[sindex]=SecTime();  //update
        return true;
      }
      state=Error;
      return true;
    break;
    case Prell:
      if(value!=0){
        state=Detect;
        DATAstack[sindex]=SecTime();  //update
        return true;
      }
      if(value==0&&(SecTime()-DATAstack[sindex]>prelltime)){
        state=Wait;
        sindex++;
        return false;
      }
      state=Prell;
      return true;
    break;
  }
}
int InfraSensor::GetDex(){
  return sindex;
}
int* InfraSensor::GetDexP(){
  return &sindex;
}
int InfraSensor::GetValue(){
  return value;
}
bool InfraSensor::Reset(){
  value=0;
  sindex=0;
  state=Wait;
}
int InfraSensor::GetPin(){
  return pin;
}
int InfraSensor::GetState(){
  return state;
}