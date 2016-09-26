/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#include "SetLocomotiveSpeed.h"

SetLocomotiveSpeed::SetLocomotiveSpeed(uint8_t trainID, TrainDirection trainDirection, uint8_t trainSpeed) {
    messageBytes.push_back(0xE4);
    messageBytes.push_back(0x13);
    messageBytes.push_back(0x00);
    messageBytes.push_back(trainID);
    messageBytes.push_back(trainDirection | trainSpeed);
    OutgoingXPNMessage::addXORto(messageBytes);
}

std::vector<uint8_t> SetLocomotiveSpeed::getMessageBytes() {
    return messageBytes;
}
