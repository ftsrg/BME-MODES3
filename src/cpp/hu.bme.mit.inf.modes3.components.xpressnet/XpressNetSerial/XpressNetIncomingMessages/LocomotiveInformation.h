/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "IncomingXPNMessage.h" // Base class: IncomingXPNMessage
#include <vector>
#include <iostream>
#include <iomanip>
#include <bitset>


class LocomotiveInformation : public IncomingXPNMessage {
public:
    LocomotiveInformation();
    std::vector<uint8_t> getFirstBytes();
    unsigned int getMessageLength();
    bool isItSpecial();
    bool recognizedMessage(std::vector<uint8_t> messageBytes);
};
