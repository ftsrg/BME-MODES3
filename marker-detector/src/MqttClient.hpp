#pragma once

#include <iostream>
#include <mosquittopp.h>

// User
#include "Constants.hpp"
#include "DataSerializer.hpp"

using namespace mosqpp;

class MqttClient : public mosquittopp {
	static bool initialized;
	
	void on_connect(int rc);
	void on_disconnect(int rc);
	void on_error();

public:
	MqttClient();
	bool Connect(const char* host);
	void SendTrainData(DataSerializer data);
};