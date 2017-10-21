#ifndef SENSOR_STATEMACHINE_HPP
#define SENSOR_STATEMACHINE_HPP

#include <InfraSensor.hpp>

const double maxtime = 4;

enum StateMachine
{
  Trainwait,
  Firstdetect,
  Traindetect,
  Nextwait,
  Datasend
};

class SensorStateMachine
{
private:
  bool detect;
  int kocsiszam;
  bool direction;
  StateMachine state;
public:
  InfraSensor sensor[2];
  void Init(int pinA, int pinB);
  bool Update();
  int GetKocsiszam();
  StateMachine GetState();
  bool GetDirection();
  void IncKocsiszam();
  InfraSensor getSensor(int i);
};

#endif