

#include "core/graph/ObjectDataCollector.h"

#include <thread>
#include <mutex>
#include <chrono>
#include <iostream>


void ObjectDataCollector::process(ObjectData objectData, collector_node::output_ports_type& output){
	
	dataBuffer[objectData.name].push_back(objectData);
	bool readyToSend = true;
	
	if (dataBuffer.size() == numberOfObjects) {
		for (auto& object : dataBuffer) {
			if (object.second.empty()) {
				readyToSend = false;
			}
			else if((object.second[0].frameIndex != nextFrameIndex)){
				readyToSend = false;
			}
		}

		if (readyToSend) {
			nextFrameIndex++;
			ModelData modelData;
			
			for (auto& object : dataBuffer) {
				modelData.objectData[object.first] = object.second[0];
			}
			modelData.frameIndex = dataBuffer.begin()->second[0].frameIndex;
			modelData.timestamp = dataBuffer.begin()->second[0].timestamp;

			std::vector<std::string> deadObjects;
			for (auto& object : dataBuffer) {
				if (object.second[0].alive) {
					object.second.erase(object.second.begin());
				}
				else {
					deadObjects.push_back(object.first);
					numberOfObjects--;
				}
			}
			for (auto& dead : deadObjects) {
				dataBuffer.erase(dead);
			}
#ifdef LOG_DELAY
			auto currentTime = std::chrono::steady_clock::now();
			auto currentTimeStamp = std::chrono::duration_cast<std::chrono::milliseconds>(currentTime.time_since_epoch()).count();
			auto delay = currentTimeStamp - modelData.timestamp;

			auto processingCurrentFps = roundf((float)1000 / (currentTimeStamp-lastTimestamp));

			std::cout<< delay << " ; " << processingCurrentFps << std::endl;

			lastTimestamp = currentTimeStamp;
#endif

			std::get<0>(output).try_put(modelData);
			tbb::flow::continue_msg msg;
			std::get<1>(output).try_put(msg);
		}
	}
	else {
		readyToSend = false;
	}
}
