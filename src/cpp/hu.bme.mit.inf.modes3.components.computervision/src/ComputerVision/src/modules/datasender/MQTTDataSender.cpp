#include "modules/datasender/MQTTDataSender.h"
#include <iostream>
#include "logger/logger.h"

template<typename INPUT>
MQTTDataSender<INPUT>::MQTTDataSender(std::string topic, std::string brokerUrl, std::string clientID ,DataFormat format,tbb::flow::graph& g)
	:DataSender<INPUT>(format,g, 1),
	topic(topic),
	brokerUrl(brokerUrl),
	clientID(clientID),
	dataFormat(format)
{

}

template<typename INPUT>
bool MQTTDataSender<INPUT>::initializeNetwork()
{
	MQTTClient_connectOptions conn_opts = MQTTClient_connectOptions_initializer;

	LOGGER::LOG(Severity::LOG, "MQTT data sender", "Creating MQTT client...");

	MQTTClient_create(&publisher, brokerUrl.c_str(), clientID.c_str(),
		MQTTCLIENT_PERSISTENCE_NONE, NULL);
	conn_opts.keepAliveInterval = 20;
	conn_opts.cleansession = 1;

	LOGGER::LOG(Severity::LOG, "MQTT data sender", "MQTT client created!");

	LOGGER::LOG(Severity::LOG, "MQTT data sender", "Connecting to MQTT broker...");

	int returnCode;
	if ((returnCode = MQTTClient_connect(publisher, &conn_opts)) != MQTTCLIENT_SUCCESS)
	{
		std::stringstream s;
		s << "Failed to connect to MQTT broker! Error code: " << returnCode;
		throw std::runtime_error(s.str().c_str());
	}

	LOGGER::LOG(Severity::LOG, "MQTT data sender", "Connected to MQTT broker!");
	return true;
}

template<typename INPUT>
tbb::flow::continue_msg MQTTDataSender<INPUT>::process(INPUT modelData)
{
	MQTTClient_message dataMessage = MQTTClient_message_initializer;
	MQTTClient_deliveryToken token;

	std::string data;

	switch (dataFormat) {
	case DataFormat::PROTOBUF:
		data = modelData.toProto();
		break;
	case DataFormat::JSON:
		data = modelData.toJSON();
		break;
	}
	dataMessage.payload = (void*)(data.c_str());
	dataMessage.payloadlen = data.length();
	dataMessage.qos = 0;
	dataMessage.retained = 0;

	int rc;
	MQTTClient_publishMessage(publisher, topic.c_str(), &dataMessage, &token);
	rc = MQTTClient_waitForCompletion(publisher, token, 10000);

	return tbb::flow::continue_msg();
}

template<typename INPUT>
MQTTDataSender<INPUT>::~MQTTDataSender()
{
	MQTTClient_disconnect(publisher, 10000);
	MQTTClient_destroy(&publisher);
}
