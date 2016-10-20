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

const uint8_t adirlnnHeaderByte = 0x42;
const unsigned int adirlnnLength = 3;
// LowerNibbleNull
class AccessoryDecoderInformationResponse_LNN : public IncomingXPNMessage
{
public:
    AccessoryDecoderInformationResponse_LNN();
    bool recognizedMessage(std::vector<uint8_t> messageBytes) override;
    unsigned int getMessageLength();
    std::vector<uint8_t> getFirstBytes();
    bool isItSpecial();
};
