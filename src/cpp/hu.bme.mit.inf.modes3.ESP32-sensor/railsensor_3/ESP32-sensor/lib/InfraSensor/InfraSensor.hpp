#ifndef SENSOR_PRELLTIME
#define SENSOR_PRELLTIME 0.01
#endif

#ifndef INFRASENSOR_HPP
#define INFRASENSOR_HPP

#include <Arduino.h>

inline double SecTime()
{
  double ret = micros() / 1000000.0;
  return ret;
}

enum InfraSensorState
{
  Wait,
  Detect,
  Prell,
  Error
};

class InfraSensor
{
private:
  const int prelltime;
  int pin;
  int value;
  InfraSensorState state;
  int stackIndex;
  
  friend class RealTimeSpeed;
  friend class RealTimeLength;
  friend class RealTimeSelect;
public:
  double DATAstack[20];
public:
  InfraSensor(int);
  InfraSensor();
  void SetPin(int);
  bool Update();
  int GetDex();
  int *GetDexP();
  int GetValue();
  bool Reset();
  int GetPin();
  int GetState();
};

#endif