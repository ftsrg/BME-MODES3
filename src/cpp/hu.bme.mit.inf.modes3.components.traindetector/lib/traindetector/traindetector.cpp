#include "traindetector.h"

static int ID_COUNTER = 0;

using namespace td;

const TrainDetection &TrainDetector::handleEdge(SensorSide side, EdgeDirection dir, time_t timestamp) {
    for (TrainDetection &td : this->detections) {
        if (td.step(side, dir, timestamp)) {
            if (td.getState() == COMPL) {
                std::cout << td << std::endl;
            }
            return td;
        }

    }

    this->detections.emplace_back(ID_COUNTER++, side, timestamp);
    std::cout << "New detection added from side " << (side == LEFT ? "LEFT" : "RIGHT") << std::endl;
    return this->detections.back();
}

std::vector<TrainDetection> TrainDetector::getDetections() {
    return this->detections;
}
