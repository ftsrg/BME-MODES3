/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "NetworkInterface.h"

NetworkInterface::NetworkInterface()
{
}
void NetworkInterface::sendMessage(std::string messageString)
{
    const char* charMessage = messageString.c_str();
    mosquittoppClient->send_message(charMessage);
}
void NetworkInterface::setMqttClient(MosquittoppClient* mosquittoCl)
{
    mosquittoppClient = mosquittoCl;
}

MosquittoppClient* NetworkInterface::mosquittoppClient;