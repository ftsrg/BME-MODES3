/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class SetLocomotiveSpeed : public OutgoingXPNMessage
{
public:
    SetLocomotiveSpeed(uint8_t trainID, TrainDirection trainDirection, int trainSpeed);

public:
    std::vector<uint8_t> getMessageBytes();
};
