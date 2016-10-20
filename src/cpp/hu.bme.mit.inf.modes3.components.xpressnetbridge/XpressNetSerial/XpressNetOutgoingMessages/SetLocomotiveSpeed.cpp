/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#include "SetLocomotiveSpeed.h"

SetLocomotiveSpeed::SetLocomotiveSpeed(uint8_t trainID, TrainDirection trainDirection, int trainSpeed)
{
    messageBytes.push_back(0xE4);
    messageBytes.push_back(0x13);
    messageBytes.push_back(0x00);
    messageBytes.push_back(trainID);
    uint8_t uTrainSpeed;
    switch(trainSpeed) {
    case -1:
        uTrainSpeed = 1;
    case 0:
        break;
    default:
        uTrainSpeed = trainSpeed + 1;
    }
    messageBytes.push_back(trainDirection | uTrainSpeed);
    OutgoingXPNMessage::addXORto(messageBytes);
}

std::vector<uint8_t> SetLocomotiveSpeed::getMessageBytes()
{
    return messageBytes;
}
