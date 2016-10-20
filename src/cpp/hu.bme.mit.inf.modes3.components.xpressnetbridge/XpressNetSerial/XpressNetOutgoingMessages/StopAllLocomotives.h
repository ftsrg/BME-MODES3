/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class StopAllLocomotives : public OutgoingXPNMessage
{
public:
    StopAllLocomotives();

public:
    std::vector<uint8_t> getMessageBytes();
};
