/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include "XpressNetSerial/XpressNetInterfaces/TurnoutState.h"

class TurnoutStatus
{
protected:
    TurnoutState turnoutState;
    bool initialized;

public:
    TurnoutStatus();
    TurnoutStatus(TurnoutState currentTurnoutState);
    bool setTurnoutState(TurnoutState currentTurnoutState);
    const TurnoutState& getTurnoutState();
    bool operator==(const TurnoutStatus& rhs);
};
