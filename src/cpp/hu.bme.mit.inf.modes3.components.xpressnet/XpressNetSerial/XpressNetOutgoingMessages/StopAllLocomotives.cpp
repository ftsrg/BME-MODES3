/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "StopAllLocomotives.h"

const uint8_t headerByte = 0x80;
const uint8_t xorByte = 0x80;

StopAllLocomotives::StopAllLocomotives() {
}

std::vector<uint8_t> StopAllLocomotives::getMessageBytes() {
    return {0x80, 0x80};
}
