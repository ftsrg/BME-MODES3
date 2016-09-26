/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "TurnoutStatus.h"

TurnoutStatus::TurnoutStatus()
{
    initialized = false;
}

TurnoutStatus::TurnoutStatus(TurnoutState currentTurnoutState)
{
    turnoutState = currentTurnoutState;
    initialized = true;
}

// depr
bool TurnoutStatus::setTurnoutState(TurnoutState currentTurnoutState)
{
    if(turnoutState == currentTurnoutState) {
        return false;
    } else {
        turnoutState = currentTurnoutState;
        return true;
    }
}

const TurnoutState& TurnoutStatus::getTurnoutState()
{
    return turnoutState;
}

bool TurnoutStatus::operator==(const TurnoutStatus& rhs)
{
    if((turnoutState == rhs.turnoutState) && (initialized == true)) {
        return true;
    } else {
        turnoutState = rhs.turnoutState;
        initialized = true;
        return false;
    }
}
