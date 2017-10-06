#pragma once

#include <iostream>

#define DISTANCE_BETWEEN_SENSORS 100 // in mm

typedef enum {
    C, O, CO, COMPL_STR, COMPL_REV
} DetectionState;

typedef enum {
    NOSIDE, RIGHT, LEFT
} SensorSide;

typedef enum {
    FALLING, RISING
} EdgeDirection;

class TrainDetection {

protected:
    void computeSpeed(time_t coverTimestamp);
    void computeLength(time_t departionTimestamp);

public:
    int id;
    SensorSide side = SensorSide::NOSIDE;
    DetectionState state = DetectionState::C;

    time_t startTimestamp = 0;
    double speed = 0.0;
    double length = 0.0;

    //
    TrainDetection(int id, SensorSide side, time_t timestamp) : id(id), side(side), startTimestamp(timestamp) {}
    bool step(SensorSide side, EdgeDirection dir, time_t timestamp);

    friend std::ostream &operator<<(std::ostream &stream, const TrainDetection &td);
};
