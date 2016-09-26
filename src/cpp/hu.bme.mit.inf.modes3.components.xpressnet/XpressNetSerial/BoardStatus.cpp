/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "BoardStatus.h"

BoardStatus::BoardStatus()
{
}

bool BoardStatus::setTrainStatus(int trainAddress, TrainStatus currentTrainStatus)
{
    bool equals = (trainStatusMap[trainAddress] == currentTrainStatus);
    return !equals;
}

TrainStatus BoardStatus::getTrainStatus(int trainAddress)
{
    return trainStatusMap[trainAddress];
}

bool BoardStatus::setTurnoutStatus(int turnoutAddress, TurnoutStatus currentTurnoutStatus)
{
    bool equals = (turnoutStatusMap[turnoutAddress] == currentTurnoutStatus);
    return !equals;
}

TurnoutStatus BoardStatus::getTurnoutStatus(int turnoutAddress)
{
    return turnoutStatusMap[turnoutAddress];
}

bool BoardStatus::setTrackPowerStatus(TrackPowerStatus currentTrackPowerStatus)
{
    bool equals = (trackPowerStatus == currentTrackPowerStatus);
    return !equals;
}

TrackPowerStatus BoardStatus::getTrackPowerStatus()
{
    return trackPowerStatus;
}

void BoardStatus::inquireTrainInformation(int trainAddress)
{
    boost::lock_guard<boost::mutex> lockGuard(trainAddresses_mutex);
    /*BoardStatus::trainAddresses.push_back(trainAddress);*/
    lastAddress = trainAddress;
    notRespondedQueries++;
}

int BoardStatus::getFirstInquiredTrainAddress()
{
    boost::lock_guard<boost::mutex> lockGuard(trainAddresses_mutex);
    /*if(BoardStatus::getInquiryVectorSize() > 0) {
        int trainAddress = BoardStatus::trainAddresses[0];
        BoardStatus::trainAddresses.erase(BoardStatus::trainAddresses.begin());
        return trainAddress;
    } else {
        return -1;
    }*/
    if(lastAddress != -1) {
        notRespondedQueries--;
    }
    return lastAddress;
}

int BoardStatus::getInquiryVectorSize()
{
    // boost::lock_guard<boost::mutex> lockGuard(trainAddresses_mutex);
    // return trainAddresses.size();
    return lastAddress;
}

int BoardStatus::getNotRespondedQueriesNumber()
{
    return notRespondedQueries;
}

std::map<int, TrainStatus> BoardStatus::trainStatusMap;
std::map<int, TurnoutStatus> BoardStatus::turnoutStatusMap;
TrackPowerStatus BoardStatus::trackPowerStatus;
std::vector<int> BoardStatus::trainAddresses;
boost::mutex BoardStatus::trainAddresses_mutex;
int BoardStatus::lastAddress = -1;
int BoardStatus::notRespondedQueries = 0;
