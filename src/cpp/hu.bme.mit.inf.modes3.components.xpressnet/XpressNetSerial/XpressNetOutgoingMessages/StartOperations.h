/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class StartOperations : public OutgoingXPNMessage {
public:
    StartOperations();

public:
    std::vector<uint8_t> getMessageBytes();
};
