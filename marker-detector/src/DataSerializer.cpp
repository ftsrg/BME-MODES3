#include "DataSerializer.hpp"

void DataSerializer::addTrain(Train& train) {
	std::stringstream ss;
	
	if (train.getSpeed() > 100)
		return;
	
	Point2f c = train.getCoordinate();
	ss << "{ \"id\": " << train.id << ", \"x\": " << c.x << ", \"y\": " << c.y << ", \"speed\": " << train.getSpeed() << ", \"dir\": \"" << train.getDir() << "\" }";
	
	trainChunks.push_back(ss.str());
}

void DataSerializer::setTimestamp(std::chrono::steady_clock::time_point t) {
	timestamp = t;
}

std::string DataSerializer::generateJSON() {
	std::stringstream ss;
	
	ss << "{" << std::endl;
	ss << "\t\"trains\": [" << std::endl;
	
	for (int i = 0; i < trainChunks.size(); ++i) {
		ss << "\t\t" << trainChunks[i];
		if (i != trainChunks.size() - 1)
			ss << ",";
		ss << std::endl;
	}
	
	ss << "\t]" << std::endl;
	ss << "}" << std::endl;
	
	return ss.str();
}