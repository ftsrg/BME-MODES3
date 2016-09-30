/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "LocomotiveNotAvailable.h"
#include <iostream>

LocomotiveNotAvailable::LocomotiveNotAvailable()
{
    firstBytes.push_back(1);
    firstBytes.push_back(3);
    length = 3;
}

std::vector<uint8_t> LocomotiveNotAvailable::getFirstBytes()
{
    return firstBytes;
}
unsigned int LocomotiveNotAvailable::getMessageLength()
{
    return length;
}
bool LocomotiveNotAvailable::isItSpecial()
{
    return false;
}
bool LocomotiveNotAvailable::recognizedMessage(std::vector<uint8_t> messageBytes)
{
    std::cout << "BAD ADDRESS: " << BoardStatus::getFirstInquiredTrainAddress() << std::endl;
    std::cout << "Vector size " << BoardStatus::getInquiryVectorSize() << std::endl;
    return true;
}
