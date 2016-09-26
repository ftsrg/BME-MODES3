/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "EmergencyStopALocomotive.h"

const uint8_t emergencyStopALocomotiveHeaderByte = 0x92;

EmergencyStopALocomotive::EmergencyStopALocomotive(uint8_t trainAddress) {
    messageBytes.push_back(emergencyStopALocomotiveHeaderByte);
    messageBytes.push_back(xpressNetHighAddressByte);
    messageBytes.push_back(trainAddress);
    OutgoingXPNMessage::addXORto(messageBytes);
}

std::vector<uint8_t> EmergencyStopALocomotive::getMessageBytes() {
    return messageBytes;
}
