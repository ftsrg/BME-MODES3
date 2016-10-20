/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include "XpressNetSerial/XpressNetInterfaces/TrackPowerState.h"

class TrackPowerStatus
{
protected:
    TrackPowerState trackPowerState;
    bool initialized;

public:
    TrackPowerStatus();
    TrackPowerStatus(TrackPowerState currentTrackPowerState);
    TrackPowerState getTrackPowerState();
    bool operator==(const TrackPowerStatus& rhs);
};
