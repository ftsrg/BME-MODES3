/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include <vector>
#include <iostream>
#include "XpressNetSerial/BoardStatus.h"
#include "XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.h"

class IncomingXPNMessage
{
protected:
    std::vector<uint8_t> firstBytes;
    unsigned int length;

public:
    IncomingXPNMessage();
    virtual ~IncomingXPNMessage();
    virtual std::vector<uint8_t> getFirstBytes();
    virtual unsigned int getMessageLength();
    virtual bool recognizedMessage(std::vector<uint8_t> messageBytes);
    virtual bool isItSpecial() = 0;
};

enum TurnoutStatusFlag {
    NOT_CONTROLLED_IN_THIS_SECTION = 0b00,
    LAST_COMMAND_WAS_0 = 0b01,
    LAST_COMMAND_WAS_1 = 0b10,
    BOTH_ENDS_ARE_ACTIVE = 0b11
};
