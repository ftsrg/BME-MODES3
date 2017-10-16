#pragma once

namespace td {

    typedef enum {
        C, O, CO, COMPL
    } DetectionState;

    typedef enum {
        NOSIDE, RIGHT, LEFT
    } SensorSide;

    typedef enum {
        NOSIGNAL, LOW, HIGH
    } SignalLevel;

    typedef enum {
        NOEDGE, FALLING, RISING
    } EdgeDirection;
    
};