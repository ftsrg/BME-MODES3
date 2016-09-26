/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "TrackPowerStatus.h"

TrackPowerStatus::TrackPowerStatus() {
    initialized = false;
}

TrackPowerStatus::TrackPowerStatus(TrackPowerState currentTrackPowerState) {
    trackPowerState = currentTrackPowerState;
    initialized = true;
}

TrackPowerState TrackPowerStatus::getTrackPowerState() {
    return trackPowerState;
}

bool TrackPowerStatus::operator==(const TrackPowerStatus& rhs) {
    if((trackPowerState == rhs.trackPowerState)&&(initialized==true)) {
        return true;
    } else {
        trackPowerState = rhs.trackPowerState;
        initialized = true;
        return false;
    }
}
