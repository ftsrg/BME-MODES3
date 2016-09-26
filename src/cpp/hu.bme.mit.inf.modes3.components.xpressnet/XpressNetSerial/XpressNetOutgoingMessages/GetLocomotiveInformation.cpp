/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "GetLocomotiveInformation.h"

const uint8_t locomotiveInformationRequestHeaderByte = 0xE3;
const uint8_t locomotiveInformationRequestIdentificationByte = 0x00;

GetLocomotiveInformation::GetLocomotiveInformation(uint8_t trainID) {
    messageBytes.push_back(locomotiveInformationRequestHeaderByte);
    messageBytes.push_back(locomotiveInformationRequestIdentificationByte);
    messageBytes.push_back(xpressNetHighAddressByte);
    messageBytes.push_back(trainID);
    OutgoingXPNMessage::addXORto(messageBytes);
}

std::vector<uint8_t> GetLocomotiveInformation::getMessageBytes() {
    return messageBytes;
}
