/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include <vector>
#include "XpressNetSerial/AsyncSerial.h"
#include "XpressNetSerial/BoardStatus.h"

const uint8_t xpressNetHighAddressByte = 0x00;

class OutgoingXPNMessage {
protected:
    std::vector<uint8_t> messageBytes;

public:
    OutgoingXPNMessage();
    virtual std::vector<uint8_t> getMessageBytes();
    static uint8_t addXORto(std::vector<uint8_t>& commandBytesWithoutXOR);
};
