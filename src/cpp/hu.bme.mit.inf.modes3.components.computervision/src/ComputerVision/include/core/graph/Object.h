/*
 * Object.h
 *
 *  Created on: 2016. aug. 11.
 *      Author: M�t�
 */

#ifndef OBJECT_H_
#define OBJECT_H_

#include <tbb/flow_graph.h>
#include <tbb/concurrent_unordered_map.h>
#include <atomic>
#include "core/data/DataTypes.h"
#include "core/data/TemplateConfiguration.h"
#include "core/graph/Processor.h"


template<typename CONFIG>
class Object: public Processor<ImageProcessingData<CONFIG> , ObjectData , tbb::flow::queueing >{
private:

	//name of the object provided by user in config file
	std::string name;
	//counts how many times the object was tried to detect
	std::atomic<int> callCounter;
	//detection limit provided by user in config file
	std::atomic<int> limit;
	//type of the marker on the object
	std::string markerType;

	tbb::concurrent_unordered_map<std::string, int> markers;

public:

	Object(std::string name, std::string type, int limit,
			tbb::flow::graph& g) :Processor<ImageProcessingData<CONFIG> , ObjectData , tbb::flow::queueing >(g  , tbb::flow::serial), name(
					name), callCounter(0), limit(limit), markerType(type) {};

	//Body of intel tbb function node
	ObjectData process(ImageProcessingData<CONFIG> data);

	void addMarker(std::string name, int id);
	std::vector<std::string> getMarkerNames();
	int getCallCounter();
	std::string getMarkerType();bool isDone();
	void remove();bool isRemoved();
	std::string getName(){
		return name;
	}
	virtual ~Object() = default;
};

#endif /* OBJECT_H_ */
