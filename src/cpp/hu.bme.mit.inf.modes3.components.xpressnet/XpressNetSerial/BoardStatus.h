/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include <map>
#include <boost/thread/mutex.hpp>
#include "XpressNetSerial/TurnoutStatus.h"
#include "XpressNetSerial/TrainStatus.h"
#include "XpressNetSerial/TrackPowerStatus.h"
#include "XpressNetSerial/AsyncSerial.h"

class BoardStatus {
protected:
    static std::map<int, TrainStatus> trainStatusMap;
    static std::map<int, TurnoutStatus> turnoutStatusMap;
    static TrackPowerStatus trackPowerStatus;
    static std::vector<int> trainAddresses;
    static boost::mutex trainAddresses_mutex;
    static int lastAddress;
    static int notRespondedQueries;

public:
    BoardStatus();
    static bool setTrainStatus(int trainAddress, TrainStatus currentTrainStatus);
    static TrainStatus getTrainStatus(int trainAddress);
    static bool setTurnoutStatus(int turnoutID, TurnoutStatus currentTurnoutStatus);
    static TurnoutStatus getTurnoutStatus(int turnoutID);
    static bool setTrackPowerStatus(TrackPowerStatus currentTrackPowerStatus);
    static TrackPowerStatus getTrackPowerStatus();
    //TODO naming
    static void inquireTrainInformation(int trainAddress);
    static int getFirstInquiredTrainAddress();
    static int getInquiryVectorSize();
    static int getNotRespondedQueriesNumber();
};
