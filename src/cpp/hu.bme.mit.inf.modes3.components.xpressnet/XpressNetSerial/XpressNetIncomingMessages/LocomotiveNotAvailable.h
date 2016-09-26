/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "IncomingXPNMessage.h" // Base class: IncomingXPNMessage

/**
 * @class LocomotiveNotAvailable
 * @author Chorithian
 * @date 29/07/16
 * @file LocomotiveNotAvailable.h
 * @brief Represents the arriving message after requesting information from a non-reachable train.
 */
class LocomotiveNotAvailable : public IncomingXPNMessage {
public:
    LocomotiveNotAvailable();

public:
    std::vector<uint8_t> getFirstBytes();
    unsigned int getMessageLength();
    bool isItSpecial();
    bool recognizedMessage(std::vector<uint8_t> messageBytes);
};
