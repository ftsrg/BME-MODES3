
#include <string>
#include <sstream>
#include <fstream>
#include <iostream>
#include <tbb/concurrent_vector.h>
#include <tbb/concurrent_unordered_map.h>
#include <opencv2/core/types.hpp>
#include "core/data/proto/ComputerVisionObjectPositions.pb.h"
#include "core/data/proto/Message.pb.h"
#include "core/data/proto/Enums.pb.h"

#ifndef DATA_TYPES_H
#define DATA_TYPES_H

template<typename T, typename V>
using tbb_map = tbb::concurrent_unordered_map<T, V>;

template<typename T>
using tbb_vector = tbb::concurrent_vector<T>;

struct Frame {
	tbb_vector<cv::Mat> images;
	uint64_t timestamp;
	uint64_t frameIndex;
	float fps;
};

template <typename CONFIG> struct ImageProcessingData {
	tbb_vector<typename CONFIG::dataType> data;
	tbb_vector<typename CONFIG::identifierType> identifiers;
	uint64_t timestamp;
	uint64_t frameIndex;
	//serialize the data into a json object
	std::string toProto() {
		modes3::protobuf::ComputerVisionObjectPositions temp;
		return temp.default_instance().SerializeAsString();
	}

	std::string toJSON() {
		std::stringstream json;
		std::map<int, std::vector<cv::Point2f> > markerPositions;

		size_t idIndex = 0;
		for (tbb::concurrent_vector<int> identifier : identifiers) {
			size_t posIndex = 0;
			for (auto& id : identifier) {
				markerPositions[id].push_back(data[idIndex][posIndex]);
			}
			idIndex++;
		}
		if (!markerPositions.empty()) {
			json << "{ \"Markers\":[";
			size_t markerIndex = 0;
			for (auto& marker : markerPositions) {
				json << "{";
				json << "\"id\":" << marker.first << ",";
				json << "\"positions\":[";
				size_t posIndex = 0;
				for (auto position : marker.second) {
					json << "{";
					json << "\"x\":" << position.x << ",";
					json << "\"y\":" << position.y;
					json << "}";
					if (posIndex < marker.second.size() - 1) {
						json << ",";
					}
					posIndex++;
				}
				json << "]";

				json << "}";
				if (markerIndex < markerPositions.size() - 1) {
					json << ",";
				}
				markerIndex++;
			}
			json << "],";
			json << "\"timestamp\":" << timestamp << ",";
			json << "\"frameindex\":" << frameIndex;
			json << "}";
		}
		return json.str();
	}
};

struct MarkerData {
	std::string name;
	tbb_vector<bool> tracked;
	tbb_vector<cv::Point2f> screenPosition;
	cv::Point3f realPosition;
};

struct ObjectData {
	std::string name;
	tbb_map<std::string , MarkerData> markerData;
	uint64_t timestamp;
	uint64_t frameIndex;
	bool alive;
};

struct ModelData {
	tbb_map<std::string , ObjectData> objectData;
	uint64_t timestamp;
	uint64_t frameIndex;

	std::string toProto() {

		modes3::protobuf::Message message;
		message.set_type(modes3::protobuf::MessageType::COMPUTER_VISION_OBJECT_POSITIONS);

		auto computerVisionObjectPositions = message.mutable_computervisionobjectpositions();
		computerVisionObjectPositions->set_frameindex(frameIndex);
		computerVisionObjectPositions->set_timestamp(timestamp);
		auto physicalObjects = computerVisionObjectPositions->mutable_physicalobjects();

		for (auto& object : objectData) {
			modes3::protobuf::PhysicalObject physicalObject;
			physicalObject.set_name(object.first);
			auto markers = physicalObject.mutable_markers();

			for (auto& marker : object.second.markerData) {
				modes3::protobuf::Marker markerProto;
				markerProto.set_name(marker.first);
				
				for (auto tracked : marker.second.tracked) {
					markerProto.add_tracked(tracked);
				}

				for (auto screenPosition : marker.second.screenPosition) {
					auto screenPositionProto = markerProto.add_screenpositions();
					screenPositionProto->set_x(screenPosition.x);
					screenPositionProto->set_y(screenPosition.y);

				}

				auto realPositionProto = markerProto.mutable_realposition();
				realPositionProto->set_x(marker.second.realPosition.x);
				realPositionProto->set_y(marker.second.realPosition.y);
				realPositionProto->set_z(1.5);
				//std::cout << "ORIGINAL: " << marker.second.realPosition.x << " " << marker.second.realPosition.y << " " << marker.second.realPosition.z << std::endl;
				std::cout <<  "PROTO:"<< markerProto.name() << " " << realPositionProto->x()<<"  "<< realPositionProto->y()<<"  "<< realPositionProto->z() << std::endl;

				(*markers)[marker.first] = markerProto;
			}

			//physicalObjects[object.first] = physicalObject;

			(*physicalObjects)[object.first] = physicalObject;
		}
		/*auto objectPositionsProto = 
				std::make_unique<modes3::protobuf::ComputerVisionObjectPositions>();

		objectPositionsProto->set_frameindex(frameIndex);
		objectPositionsProto->set_timestamp(timestamp);
		auto& objectsMap = objectPositionsProto->mutable_physicalobjects();

		for (auto& object : objectData) {
			modes3::protobuf::PhysicalObject objectProto;
			objectProto.set_name(object.second.name);

			auto& markerMap = *objectProto.mutable_markers();
			
			for (auto& marker : object.second.markerData) {
				modes3::protobuf::Marker markerProto;
				markerProto.set_name(marker.second.name);

				for (auto tracked : marker.second.tracked) {
					markerProto.add_tracked(tracked);
				}

				for (auto screenPosition : marker.second.screenPosition) {
					auto screenPositionProto = markerProto.add_screenpositions();
					screenPositionProto->set_x(screenPosition.x);
					screenPositionProto->set_y(screenPosition.y);

				}
				
				std::unique_ptr<modes3::protobuf::ThreeDPosition> realPositionProto = 
												std::make_unique< modes3::protobuf::ThreeDPosition>();
				realPositionProto->set_x(marker.second.realPosition.x);
				realPositionProto->set_y(marker.second.realPosition.y);
				realPositionProto->set_z(0);

				std::cout <<marker.first<<" "<<marker.second.realPosition.x << " " << marker.second.realPosition.y << " " << marker.second.realPosition.z << std::endl;

				markerProto.set_allocated_realposition(realPositionProto.release());
				markerMap[marker.second.name] = markerProto;
			}
			objectsMap[object.second.name] = objectProto;
		}

		modes3::protobuf::Message message;
		message.set_type(modes3::protobuf::MessageType::COMPUTER_VISION_OBJECT_POSITIONS);
		message.set_allocated_computervisionobjectpositions(objectPositionsProto.release());*/
		return message.SerializeAsString();
	}


	//serialize the data into a json object
	std::string toJSON() {
		std::stringstream json;

		json << "{\"Objects\":[";

		size_t objectIndex = 0;
		for (auto& object : objectData) {
			json << "{\"name\":" << "\"" << object.second.name << "\"" << ",";
			json << "\"markers\":[";

			size_t markerIndex = 0;
			for (auto& marker : object.second.markerData) {
				json << "{";
				json << "\"name\":" << "\"" << marker.second.name << "\"" << ",";
				json << "\"realposition\":";
				json << "{" << "\"x\":" << marker.second.realPosition.x << "," << "\"y\":" << marker.second.realPosition.y << "," << "\"z\":" << marker.second.realPosition.z << "},";
				json << "\"screenpositions\":[";

				size_t positionIndex = 0;
				for (auto& screenPosition : marker.second.screenPosition) {
					json << "{";

					std::string tracked = marker.second.tracked[positionIndex] ? "true" : "false";

					json << "\"x\":" << screenPosition.x << "," << "\"y\":" << screenPosition.y << "," << "\"tracked\":" << "\"" << tracked << "\"";
					json << "}";

					if (positionIndex < marker.second.screenPosition.size() - 1) {
						json << ",";
					}

					positionIndex++;
				}

				json << "]}";

				if (markerIndex < object.second.markerData.size() - 1) {
					json << ",";
				}
				markerIndex++;
			}
			json << "]}";

			if (objectIndex < objectData.size() - 1) {
				json << ",";
			}
			objectIndex++;
		}
		json << "],";
		json << "\"timestamp\":" << timestamp << ",";
		json << "\"frameindex\":" << frameIndex;
		json << "}";
		return json.str();
	}
};

#endif /*DATA_TYPES_H*/
