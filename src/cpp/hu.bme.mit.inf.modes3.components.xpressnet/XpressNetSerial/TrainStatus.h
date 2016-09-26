/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include "XpressNetSerial/XpressNetInterfaces/TrainDirection.h"
#include "XpressNetSerial/XpressNetInterfaces/TrainFunctionGroup.h"

const int numberOfTrainFunctions = 13;

class TrainStatus
{
protected:
    int trainSpeed;
    TrainDirection trainDirection;
    bool trainFunctions[numberOfTrainFunctions];
    bool initialized;

public:
    TrainStatus();
    TrainStatus(TrainDirection currentTrainDirection,
        int currentTrainSpeed,
        bool currentTrainFunctions[numberOfTrainFunctions]);
    bool setTrainStatus(TrainDirection currentTrainDirection,
        int currentTrainSpeed,
        bool currentTrainFunctions[numberOfTrainFunctions]);
    const TrainDirection& getTrainDirection();
    int getTrainSpeed();
    bool getTrainFunctionStatus(int trainFunctionNumber);
    bool operator==(const TrainStatus& rhs);
};
