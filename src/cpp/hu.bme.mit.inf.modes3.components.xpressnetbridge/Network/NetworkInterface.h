/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include "XpressNetSerial/BoardStatus.h"
#include "GoogleProtocolBuffers/Message.pb.h"
#include "Network/MosquittoppClient.h"

class NetworkInterface
{
protected:
    static MosquittoppClient* mosquittoppClient;

public:
    NetworkInterface();
    static void sendMessage(std::string messageString);
    static void setMqttClient(MosquittoppClient* mosquittoCl);
};
