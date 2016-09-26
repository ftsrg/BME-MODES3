/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "OutgoingXPNMessage.h"

OutgoingXPNMessage::OutgoingXPNMessage() {
}

std::vector<uint8_t> OutgoingXPNMessage::getMessageBytes() {
    //return vector<uint8_t>();
}

uint8_t OutgoingXPNMessage::addXORto(std::vector<uint8_t>& commandBytesWithoutXOR) {
    uint8_t xorByte = 0;
    for (uint8_t commandByte : commandBytesWithoutXOR) {
        xorByte ^= commandByte;
    }
    commandBytesWithoutXOR.push_back(xorByte);
    return xorByte;
}