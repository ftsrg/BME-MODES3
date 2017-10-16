#include <InfraSensor.hpp> 

InfraSensor::InfraSensor(int p) : pin(p),
                                  prelltime(SENSOR_PRELLTIME)
{
}

InfraSensor::InfraSensor() : prelltime(SENSOR_PRELLTIME) {}

void InfraSensor::SetPin(int pin)
{
    this->pin = pin;
}

bool InfraSensor::Update()
{
    value = (digitalRead(pin) == 0);
    switch (state)
    {
    case Wait:
        if (value != 0)
        {
            state = Detect;
            DATAstack[stackIndex] = SecTime(); //in
            stackIndex++;
            DATAstack[stackIndex] = SecTime(); //"out"
            return true;
        }
        if (value == 0)
        {
            state = Wait;
            return false;
        }
        state = Error;
        return false;
        break;
    case Detect:
        if (value == 0)
        {
            state = Prell;
            return true;
        }
        if (value != 0)
        {
            state = Detect;
            DATAstack[stackIndex] = SecTime(); //update
            return true;
        }
        state = Error;
        return true;
        break;
    case Prell:
        if (value != 0)
        {
            state = Detect;
            DATAstack[stackIndex] = SecTime(); //update
            return true;
        }
        if (value == 0 && (SecTime() - DATAstack[stackIndex] > prelltime))
        {
            state = Wait;
            stackIndex++;
            return false;
        }
        state = Prell;
        return true;
        break;
    }
}

int InfraSensor::GetDex()
{
    return stackIndex;
}

int *InfraSensor::GetDexP()
{
    return &stackIndex;
}

int InfraSensor::GetValue()
{
    return value;
}

bool InfraSensor::Reset()
{
    value = 0;
    stackIndex = 0;
    state = Wait;
}

int InfraSensor::GetPin()
{
    return pin;
}

int InfraSensor::GetState()
{
    return state;
}
