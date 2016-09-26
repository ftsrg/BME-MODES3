/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class StopOperations : public OutgoingXPNMessage
{
public:
    StopOperations();

public:
    std::vector<uint8_t> getMessageBytes();
};
