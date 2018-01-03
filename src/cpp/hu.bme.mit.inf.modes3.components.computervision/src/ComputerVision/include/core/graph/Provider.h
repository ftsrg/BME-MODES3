/*
 * Provider.h
 *
 *  Created on: 2016. aug. 22.
 *      Author: M�t�
 */

#ifndef PROVIDER_H_
#define PROVIDER_H_

#include <tbb/flow_graph.h>
#include <iostream>
#include <atomic>

template<typename OUTPUT>
class Provider {
protected:
	tbb::flow::source_node<OUTPUT> provider_node;
	std::atomic<bool> providing;
public:

	virtual bool provide(OUTPUT& output)=0;

	Provider(tbb::flow::graph& g) :
			provider_node(
					tbb::flow::source_node<OUTPUT>(g,
							std::bind(&Provider::provide, this,
									std::placeholders::_1), false)), providing(
					false) {
	}

virtual	void stop() {
		providing = false;
	}

	tbb::flow::source_node<OUTPUT>& getProviderNode() {
		return provider_node;
	}

	void start() {
		providing = true;
		provider_node.activate();
	}

	virtual ~Provider()=default;
};

#endif /* PROVIDER_H_ */
