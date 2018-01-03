/*
 * DataSender.h
 *
 *  Created on: Oct 3, 2016
 *      Author: teqbox
 */

#ifndef ZEROMQDATASENDER_H_
#define ZEROMQDATASENDER_H_

#include "core/data/DataTypes.h"
#include "modules/datasender/DataSender.h"
#include <zmq.hpp>

constexpr auto BIND_ADRESSES = "bindaddress";

template <typename INPUT>
class ZeroMQDataSender: public DataSender<INPUT> {
private:
	zmq::context_t context;
	zmq::socket_t publisher;
	std::string topic;
	DataFormat dataFormat;
public:
	ZeroMQDataSender(std::string topic ,std::vector<std::string> bindAddresses ,DataFormat format, tbb::flow::graph& g):DataSender<INPUT>(format,g,1),context(zmq::context_t(1)),publisher(zmq::socket_t(context, ZMQ_PUB)),topic(topic),dataFormat(format){
		for (auto address : bindAddresses) {
			publisher.bind(address);
		}
	};

	tbb::flow::continue_msg process(INPUT modelData);

	virtual ~ZeroMQDataSender();
};

#endif /* ZEROMQDATASENDER_H_ */
