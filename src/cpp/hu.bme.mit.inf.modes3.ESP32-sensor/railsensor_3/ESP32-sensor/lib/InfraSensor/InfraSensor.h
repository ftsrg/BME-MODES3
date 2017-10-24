#ifndef INFRASENSOR_HPP
#define INFRASENSOR_HPP

#ifndef SENSOR_PRELLTIME
  #define SENSOR_PRELLTIME 0.01
#endif

#include <Arduino.h>

double SecTime(){
    double ret=micros()/1000000.0;
    return ret;
}

enum InfraSensorState{
  Wait,
  Detect,
  Prell,
  Error
};
  
class InfraSensor{
private:
  const int prelltime;
  int pin;
  int value;
  InfraSensorState state;
  int sindex;
public:
  double DATAstack[20];
  InfraSensor(int);
  InfraSensor();
  void SetPin(int);
  bool Update();
  int GetDex();
  int* GetDexP();
  int GetValue();
  bool Reset();
  int GetPin();
  int GetState();
};


#endif