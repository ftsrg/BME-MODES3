#pragma once

#include <iostream>
#include <vector>
#include "enums.h"
#include "traindetection.h"

namespace td {

    class TrainDetector {
    protected:
        std::vector<TrainDetection> detections;

    public:
        const TrainDetection &handleEdge(SensorSide side, EdgeDirection dir, time_t timestamp = 0);
        std::vector<TrainDetection> getDetections();
    };

};