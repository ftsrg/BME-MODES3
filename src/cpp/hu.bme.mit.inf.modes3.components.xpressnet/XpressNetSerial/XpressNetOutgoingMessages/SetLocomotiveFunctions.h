/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage
#include "XpressNetSerial/XpressNetInterfaces/TrainFunctionGroup.h"

class SetLocomotiveFunctions : public OutgoingXPNMessage {
public:
    SetLocomotiveFunctions(uint8_t trainID, TrainFunctionGroup group, std::vector<bool> functions);

public:
    std::vector<uint8_t> getMessageBytes();
};
