/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class EmergencyStopALocomotive : public OutgoingXPNMessage
{
public:
    EmergencyStopALocomotive(uint8_t trainAddress);

public:
    std::vector<uint8_t> getMessageBytes();
};
