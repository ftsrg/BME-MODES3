#pragma once
#include <iostream>
#include <mosquittopp.h>
#include "XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.h"

class MosquittoppClient : public mosqpp::mosquittopp
{
private:
    const char* host;
    const char* id;
    const char* topic;
    int port;
    int keepalive;

    void on_connect(int rc);
    void on_disconnect(int rc);
    void on_publish(int mid);
    void on_message(const mosquitto_message* message);

public:
    MosquittoppClient(const char* id, const char* _topic, const char* host, int port);
    ~MosquittoppClient();
    bool send_message(const char* _message);
};
