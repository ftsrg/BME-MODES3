#ifndef SENSOR_PRELLTIME
    #define SENSOR_PRELLTIME 0.01
#endif

#ifndef INFRASENSOR_HPP
#define INFRASENSOR_HPP

double SecTime(){
    double ret=micros()/1000000.0;
    return ret;
}

enum InfSensorState{
  Wait,
  Detect,
  Prell,
  Error
};
  
class InfSensor{
private:
  const int prelltime;
  const int pin;
  int value;
  InfSensorState state;
  int sindex;
public:
  double DATAstack[20];
  InfSensor(int p):pin(p), prelltime(SENSOR_PRELLTIME){}
  bool Update(){
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
  int GetDex(){
    return sindex;
  }
  int* GetDexP(){
    return &sindex;
  }
  int GetValue(){
    return value;
  }
  bool Reset(){
    value=0;
    sindex=0;
    state=Wait;
  }
  int GetPin(){
    return pin;
  }
  int GetState(){
    return state;
  }
};

#endif