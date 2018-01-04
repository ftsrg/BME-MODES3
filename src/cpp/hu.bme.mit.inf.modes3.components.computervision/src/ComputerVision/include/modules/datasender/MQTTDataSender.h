#ifndef MQTTDATASENDER_H_
#define MQTTDATASENDER_H_

#include <MQTTClient.h>
#include "modules/datasender/DataSender.h"
#include "core/data/DataTypes.h"

constexpr auto BROKER_URL = "brokerurl";
constexpr auto CLIENTID	  =	"clientid";

template <typename INPUT>
class MQTTDataSender : public DataSender<INPUT> {
private:
	MQTTClient publisher;
	std::string topic;
	std::string brokerUrl;
	std::string clientID;
	DataFormat dataFormat;
public:
	MQTTDataSender(std::string topic, std::string brokerUrl,std::string clientID, DataFormat format, tbb::flow::graph& g);
	bool initializeNetwork();
	tbb::flow::continue_msg process(INPUT modelData);
	virtual ~MQTTDataSender();
};

#endif
