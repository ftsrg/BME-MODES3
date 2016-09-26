/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "IncomingXPNMessage.h" // Base class: IncomingXPNMessage
#include "XpressNetSerial/BoardStatus.h"

const int tpsLength = 3;
const uint8_t tpsFirstByte = 0x61;

class TrackPowerStatusMessage : public IncomingXPNMessage {
public:
    TrackPowerStatusMessage();
    bool recognizedMessage(std::vector<uint8_t> messageBytes);
    unsigned int getMessageLength();
    std::vector<uint8_t> getFirstBytes();
    bool isItSpecial();
};
