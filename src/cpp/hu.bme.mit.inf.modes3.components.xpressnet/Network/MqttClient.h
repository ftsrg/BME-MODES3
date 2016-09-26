#pragma once

#include <iostream>
#include <mosquittopp.h>
#include "XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.h"
//#include "GoogleProtocolBuffers/ProtobufToBoardInterfaces.h"

using namespace mosqpp;

class MqttClient : public mosquittopp {
    static bool initialized;
    void on_message(const mosquitto_message* message);
    void on_connect(int rc);
    void on_disconnect(int rc);
    void on_error();

public:
    MqttClient();
    bool Connect(const char* host, int port, const char* topic, const char* username, const char* password);
    bool SendMessage(const char* message);
};
