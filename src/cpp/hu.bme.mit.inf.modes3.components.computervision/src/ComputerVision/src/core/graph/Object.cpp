/*
 * Object.cpp
 *
 *  Created on: 2016. aug. 11.
 *      Author: M�t�
 */

#include "core/graph/Object.h"
#include "logger/logger.h"
#include <iostream>

template<typename CONFIG>
ObjectData Object<CONFIG>::process(ImageProcessingData<CONFIG> ipData){

	ObjectData objectData;
	objectData.name = name;

		for(auto m : markers){
			
			int id = m.second;
			MarkerData markerData;
			markerData.name = m.first;
			markerData.screenPosition = tbb::concurrent_vector<cv::Point2f>(ipData.data.size());

			int i = 0;
			for(auto identifier : ipData.identifiers){
				auto index = std::find(identifier.begin() , identifier.end() , id);

				if(index!=identifier.end()){
					auto posIndex = std::distance(identifier.begin() , index);
					markerData.screenPosition[i]=(ipData.data[i][posIndex]);
					markerData.tracked.push_back(true);
				}else{
					markerData.tracked.push_back(false);
				}
				i++;
			}
			objectData.markerData[m.first]=markerData;
		}
		callCounter++;

		if (limit == -1) {
			objectData.alive = true;
		}
		else {
			objectData.alive = callCounter < (limit);
		}
	objectData.frameIndex = ipData.frameIndex;
	objectData.timestamp = ipData.timestamp;

	if (!objectData.alive) {
		LOGGER::LOG(Severity::LOG, "Object processor", "Object "+name+" reached its detection limit!");
	}
	return objectData;
}


template<typename CONFIG>
std::vector<std::string> Object<CONFIG>::getMarkerNames(){
	std::vector<std::string> names;
	for(auto m : markers){
		names.push_back(m.first);
	}
	return names;
}

template<typename CONFIG>
void Object<CONFIG>::addMarker(std::string name , int id){
	markers[name] = id;
}

template <typename CONFIG>
std::string Object<CONFIG>::getMarkerType(){
	return markerType;
}



