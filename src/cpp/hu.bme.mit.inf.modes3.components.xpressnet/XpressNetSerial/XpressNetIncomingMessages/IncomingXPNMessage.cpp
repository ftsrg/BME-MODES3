/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "IncomingXPNMessage.h"

IncomingXPNMessage::IncomingXPNMessage()
{
}

IncomingXPNMessage::~IncomingXPNMessage()
{
}

std::vector<uint8_t> IncomingXPNMessage::getFirstBytes()
{
    return firstBytes;
}

unsigned int IncomingXPNMessage::getMessageLength()
{
    return firstBytes.size();
}

bool IncomingXPNMessage::recognizedMessage(std::vector<uint8_t> messageBytes)
{
    std::cout << "Basic IncomingXPNMessage WTF" << std::endl;
    return false;
}
