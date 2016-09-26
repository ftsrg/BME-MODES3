/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "IncomingXPNMessage.h" // Base class: IncomingXPNMessage
#include <vector>
#include <iostream>
#include <iomanip>
#include <bitset>

const uint8_t adirHeaderByte = 0x42;
const unsigned int adirLength = 4;
const unsigned int nibbleMask = 0b00010000;
const unsigned int firstStatusFlagMask  = 0b00000011;
const unsigned int secondStatusFlagMask = 0b00001100;

class AccessoryDecoderInformationResponse : public IncomingXPNMessage {
public:
    AccessoryDecoderInformationResponse();
    bool recognizedMessage(std::vector<uint8_t> messageBytes) override;
    unsigned int getMessageLength();
    std::vector<uint8_t> getFirstBytes();
    bool isItSpecial();
};
