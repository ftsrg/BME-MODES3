/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#include "StopOperations.h"

const uint8_t headerByte = 0x21;
const uint8_t dataByte = 0x80;
const uint8_t xorByte = 0xA1;

StopOperations::StopOperations()
{
}

std::vector<uint8_t> StopOperations::getMessageBytes()
{
    return { 0x21, 0x80, 0xA1 };
}
