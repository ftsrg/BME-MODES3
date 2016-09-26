/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class GetLocomotiveInformation : public OutgoingXPNMessage {
public:
    GetLocomotiveInformation(uint8_t trainID);
public:
    std::vector<uint8_t> getMessageBytes();
};
