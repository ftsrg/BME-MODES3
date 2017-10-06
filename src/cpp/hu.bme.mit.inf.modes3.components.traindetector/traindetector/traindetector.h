#pragma once

#include <iostream>
#include <vector>

#include "traindetection.h"

class TrainDetector {
protected:
    std::vector<TrainDetection> detections;

public:
    const TrainDetection &handleEdge(SensorSide side, EdgeDirection dir, time_t timestamp = 0);
    std::vector<TrainDetection> getDetections();
};
