#pragma once

#include <chrono>
#include <vector>
#include <sstream>

#include "Train.hpp"

class DataSerializer {
    std::vector<std::string> trainChunks;
    std::chrono::steady_clock::time_point timestamp;
    
public:
	void addTrain(Train& train);
	
	void setTimestamp(std::chrono::steady_clock::time_point t);
	
	std::string generateJSON();
};