/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

class SetTurnout : public OutgoingXPNMessage
{
public:
    SetTurnout(uint8_t turnoutAddress, TurnoutState turnoutState);

public:
    std::vector<uint8_t> getMessageBytes();
};
