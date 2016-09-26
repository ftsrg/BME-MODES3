/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include "XpressNetSerial/BoardStatus.h"
#include "GoogleProtocolBuffers/Message.pb.h"
#include "Network/MqttClient.h"

class NetworkInterface {
protected:
    static MqttClient mqttClient;
public:
    NetworkInterface();
    static void sendMessage( std::string messageString );
    static void setMqttClient(MqttClient mqtt);
};
