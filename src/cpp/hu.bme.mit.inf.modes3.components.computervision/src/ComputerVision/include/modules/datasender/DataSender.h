/*
 * DataSender.h
 *
 *  Created on: Oct 3, 2016
 *      Author: teqbox
 */

#ifndef DATASENDER_H_
#define DATASENDER_H_

#include "core/graph/Processor.h"

enum DataFormat {
	PROTOBUF,
	JSON
};

template <typename INPUT>
class DataSender: public Processor<INPUT , tbb::flow::continue_msg , tbb::flow::queueing> {
protected:
	DataFormat dataFormat;
public:
	DataSender(DataFormat format, tbb::flow::graph& g , int concurrency):Processor<INPUT, tbb::flow::continue_msg , tbb::flow::queueing>(g , concurrency),dataFormat(format){};

	virtual tbb::flow::continue_msg process(INPUT modelData) = 0;

	//virtual void addReference(std::string reference) = 0;

	virtual ~DataSender() = default;
};

#endif /* DATASENDER_H_ */
