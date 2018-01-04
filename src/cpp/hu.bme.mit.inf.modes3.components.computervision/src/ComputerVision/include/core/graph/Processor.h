/*
 * Processor.h
 *
 *  Created on: 2016. aug. 23.
 *      Author: M�t�
 */

#ifndef PROCESSOR_H_
#define PROCESSOR_H_

#include <tbb/flow_graph.h>
#include <functional>
#include <algorithm>

template<typename INPUT, typename OUTPUT, typename BUFFER_POLICY>

class Processor {
protected:
	tbb::flow::function_node<INPUT, OUTPUT, BUFFER_POLICY> node;
public:
	virtual OUTPUT process(INPUT) = 0;

	Processor(tbb::flow::graph& g, int concurrency) :
			node(
					tbb::flow::function_node<INPUT, OUTPUT, BUFFER_POLICY>
							 (g, concurrency, std::bind(&Processor::process,
									this, std::placeholders::_1))) {};

	tbb::flow::function_node<INPUT, OUTPUT, BUFFER_POLICY>& getProcessorNode(){
		return node;
	}

	virtual ~Processor()=default;
};

#endif /* PROCESSOR_H_ */
