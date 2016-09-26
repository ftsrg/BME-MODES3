/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include <vector>
#include <array>
#include <mutex>
#include <memory>

#include <iostream>
#include <iomanip>

#include "IncomingXPNMessage.h"
#include "AccessoryDecoderInformationResponse.h"
#include "TrackPowerStatusMessage.h"
#include "LocomotiveInformation.h"
#include "LocomotiveNotAvailable.h"
#include "LocomotiveControlTaken.h"
#include "AccessoryDecoderInformationResponse_LNN.h"

const int maxMessageLength = 16;

class IncomingByteBuffer
{
protected:
    std::vector<uint8_t> byteBuffer;
    boost::mutex byteBuffer_Mutex;
    std::vector<std::unique_ptr<IncomingXPNMessage> > expectedMessages;

public:
    IncomingByteBuffer();
    void addByte(uint8_t byte);
    void recognizeMessages();
    void deleteFromByteBuffer(unsigned int i);
};
