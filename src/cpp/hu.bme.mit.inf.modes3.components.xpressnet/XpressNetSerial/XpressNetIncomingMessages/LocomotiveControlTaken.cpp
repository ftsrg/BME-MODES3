/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "LocomotiveControlTaken.h"

LocomotiveControlTaken::LocomotiveControlTaken() {
    firstBytes.push_back(0xE3);
    firstBytes.push_back(0x40);
    length = 5;
}

std::vector<uint8_t> LocomotiveControlTaken::getFirstBytes() {
    return firstBytes;
}
unsigned int LocomotiveControlTaken::getMessageLength() {
    return length;
}
bool LocomotiveControlTaken::isItSpecial() {
    return false;
}
bool LocomotiveControlTaken::recognizedMessage(std::vector<uint8_t> messageBytes) {
    const uint8_t trainAddress = messageBytes[3];
    std::cout << "LocomotiveControlTaken: " << std::hex << (int) trainAddress << std::endl;
    return true;
}
