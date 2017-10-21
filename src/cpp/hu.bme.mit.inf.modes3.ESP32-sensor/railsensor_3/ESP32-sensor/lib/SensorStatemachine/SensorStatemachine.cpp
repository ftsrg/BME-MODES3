#include <SensorStatemachine.hpp>

void SensorStateMachine::Init(int pinA, int pinB)
{
  kocsiszam = 0;
  state = Trainwait;
  sensor[0].SetPin(pinA);
  sensor[1].SetPin(pinB);
}
bool SensorStateMachine::Update()
{
  double atime;
  bool det[2], detect;
  for (int i = 0; i < 2; i++)
  {
    det[i] = sensor[i].Update();
  }
  detect = det[0] || det[1];
  switch (state)
  {
  case Firstdetect:
    state = Traindetect;
    if (sensor[0].GetValue() == 1)
    {
      direction = false;
    }
    else
    {
      direction = true;
    }
    break;
  case Trainwait:
    if (detect == 1)
    {
      state = Firstdetect;
    }
    break;
  case Traindetect:
    if (detect == 0)
    {
      state = Nextwait;
      atime = SecTime();
    }
    break;
  case Nextwait:
    if (detect == 1)
    {
      state = Traindetect;
    }
    if (detect == 0 && (SecTime() - atime > maxtime))
    {
      state = Datasend;
      for (int i = 0; i < 2; i++)
      {
        sensor[i].Reset();
      }
      kocsiszam = 0;
    }
    break;
  case Datasend:
    state = Trainwait;
    break;
  }
}
int SensorStateMachine::GetKocsiszam()
{
  return kocsiszam;
}
StateMachine SensorStateMachine::GetState()
{
  return state;
}
bool SensorStateMachine::GetDirection()
{
  return direction;
}
void SensorStateMachine::IncKocsiszam()
{
  kocsiszam++;
}
InfraSensor SensorStateMachine::getSensor(int i)
{
  return sensor[i];
}