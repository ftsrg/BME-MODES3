/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#include "StartOperations.h"

const uint8_t startOperationsHeaderByte = 0x21;
const uint8_t startOperationsDataByte = 0x81;
const uint8_t startOperationsXORByte = 0xA0;

StartOperations::StartOperations()
{
}

std::vector<uint8_t> StartOperations::getMessageBytes()
{
    return { 0x21, 0x81, 0xA0 };
}
