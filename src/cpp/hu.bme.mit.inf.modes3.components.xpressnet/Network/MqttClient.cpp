#include "MqttClient.h"

bool MqttClient::initialized = false;

MqttClient::MqttClient() : mosquittopp("cv") {
    if (!initialized) {
        lib_init();
        initialized = true;
    }
}

void MqttClient::on_message(const mosquitto_message* message) {
    if(message->payloadlen > 0) {
        std::string str = static_cast<const char*>(message->payload);
        //std::cout << str << std::endl;
        ProtobufTranslator::processMessage(str);
    }
}

bool MqttClient::Connect(const char* host, int port, const char* topic, const char* username, const char* password) {
    //this->username_pw_set("controller", "password");
    if (this->connect(host,port)){
        std::cout << "Could not connect to MQTT Broker" << std::endl;
        return false;
    }
    this->loop_start();
    this->subscribe(nullptr, topic);

    return true;
}

bool MqttClient::SendMessage(const char* message) {
    std::cout << "Sending MQTT message..." << std::endl;
    return this->publish(NULL, "xpressnet", strlen(message), message);
}

void MqttClient::on_connect(int rc) {
    std::cout << "Connected to MQTT broker" << std::endl;
}
void MqttClient::on_disconnect(int rc) {
    std::cout << "Disconnected from MQTT broker" << std::endl;
}

void MqttClient::on_error() {
    std::cout << "Error!" << std::endl;
}
