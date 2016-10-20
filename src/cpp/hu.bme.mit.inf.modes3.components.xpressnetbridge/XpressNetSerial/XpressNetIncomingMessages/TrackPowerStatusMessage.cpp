/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "TrackPowerStatusMessage.h"

TrackPowerStatusMessage::TrackPowerStatusMessage()
    : IncomingXPNMessage()
{
    firstBytes.push_back(0x61);
    length = 3;
}

bool TrackPowerStatusMessage::recognizedMessage(std::vector<uint8_t> messageBytes)
{
    if(messageBytes[1] > 1) {
        // std::cout << "Invalid TrackPowerStatus" << std::hex << (unsigned int) messageBytes.size() << std::endl;
        return false;
    }

    std::string status;
    bool change;
    TrackPowerState trackPowerState;
    if(messageBytes[1] == 0) {
        status = "OFF";
        trackPowerState = TrackPowerState::OFF;
        change = BoardStatus::setTrackPowerStatus(TrackPowerStatus(TrackPowerState::OFF));
    } else {
        status = "ON";
        trackPowerState = TrackPowerState::ON;
        change = BoardStatus::setTrackPowerStatus(TrackPowerStatus(TrackPowerState::ON));
    }

    if(change == true) {
        std::cout << "TrackPowerStatus: " << status << std::endl;
        ProtobufTranslator::powerStateChanged(trackPowerState);
    } else {
        // std::cout << " & NOT CHANGED" << std::endl;
    }
    // std::cout << std::endl;
    return true;
}

unsigned int TrackPowerStatusMessage::getMessageLength()
{
    return tpsLength;
}
std::vector<uint8_t> TrackPowerStatusMessage::getFirstBytes()
{
    return firstBytes;
}

bool TrackPowerStatusMessage::isItSpecial()
{
    return false;
}
