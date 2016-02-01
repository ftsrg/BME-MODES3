#include "MqttClient.hpp"

bool MqttClient::initialized = false;

MqttClient::MqttClient() : mosquittopp("cv")
{
	if (!initialized) {
		lib_init();
		initialized = true;
	}
}

bool MqttClient::Connect(const char* host) {
	this->username_pw_set("controller", "password");
	
	if (this->connect(host))
		return false;
	this->loop_start();
	this->subscribe(nullptr, "modes3/cv");

	return true;
}

void MqttClient::SendTrainData(DataSerializer trains) {
	std::string data = trains.generateJSON();
	int retval = this->publish(nullptr, "modes3/cv", static_cast<int>(data.length()), data.data(), 0, false);
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