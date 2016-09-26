/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "SetLocomotiveFunctions.h"

const uint8_t functionOperationInstructionsHeaderByte = 0xE4;
const uint8_t functionOperationInstructionsIdentificationByte = 0x20;

SetLocomotiveFunctions::SetLocomotiveFunctions(uint8_t trainID, TrainFunctionGroup group, std::vector<bool> functions) {
    messageBytes.push_back(functionOperationInstructionsHeaderByte);
    messageBytes.push_back(functionOperationInstructionsIdentificationByte + group);
    messageBytes.push_back(xpressNetHighAddressByte);
    messageBytes.push_back(trainID);
    uint8_t functionByte = 0x00;

    // F0 has a special place in our byte.

    for(unsigned int i = 0; i < functions.size(); i++) {
        if(functions[i] == true) {
            functionByte = (functionByte | (0b00000001 << i));
        }
    }

    messageBytes.push_back(functionByte);
    OutgoingXPNMessage::addXORto(messageBytes);

}

std::vector<uint8_t> SetLocomotiveFunctions::getMessageBytes() {
    return messageBytes;
}
