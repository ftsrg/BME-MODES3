/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include <iostream>

#include "IncomingXPNMessage.h" // Base class: IncomingXPNMessage

class LocomotiveControlTaken : public IncomingXPNMessage {
public:
    LocomotiveControlTaken();
    std::vector<uint8_t> getFirstBytes();
    unsigned int getMessageLength();
    bool isItSpecial();
    bool recognizedMessage(std::vector<uint8_t> messageBytes);
};
