/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "NetworkInterface.h"

NetworkInterface::NetworkInterface() {}
void NetworkInterface::sendMessage( std::string messageString ){
    const char * charMessage = messageString.c_str();
    mqttClient.SendMessage(charMessage);
}
void NetworkInterface::setMqttClient(MqttClient mqtt) {
    mqttClient = mqtt;
}

MqttClient NetworkInterface::mqttClient;