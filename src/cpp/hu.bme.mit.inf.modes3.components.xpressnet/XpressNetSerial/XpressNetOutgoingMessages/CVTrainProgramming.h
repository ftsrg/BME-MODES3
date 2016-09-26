/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "OutgoingXPNMessage.h" // Base class: OutgoingXPNMessage

const uint8_t cvProgrammingHeaderByte = 0xE6;
const uint8_t cvProgrammingIdentificationByte = 0x30;
const uint8_t cvProgrammingDataByte3WithoutFullRangeCV = 0xEC;

class CVTrainProgramming : public OutgoingXPNMessage {
public:
    CVTrainProgramming(uint8_t trainID, uint8_t cvNumber, uint8_t cvValue);

public:
    std::vector<uint8_t> getMessageBytes();
};
