/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "TrainStatus.h"

TrainStatus::TrainStatus()
{
    initialized = false;
}

TrainStatus::TrainStatus(TrainDirection currentTrainDirection,
    int currentTrainSpeed,
    bool currentTrainFunctions[numberOfTrainFunctions])
{
    trainDirection = currentTrainDirection;
    trainSpeed = currentTrainSpeed;
    for(int i = 0; i < numberOfTrainFunctions; i++) {
        trainFunctions[i] = currentTrainFunctions[i];
    }
    initialized = true;
}

// deprecated
bool TrainStatus::setTrainStatus(TrainDirection currentTrainDirection,
    int currentTrainSpeed,
    bool currentTrainFunctions[numberOfTrainFunctions])
{

    bool trainStatusChanged = false;
    if(trainSpeed != currentTrainSpeed) {
        trainSpeed = currentTrainSpeed;
        trainStatusChanged = true;
    }
    if(trainDirection != currentTrainDirection) {
        trainDirection = currentTrainDirection;
        trainStatusChanged = true;
    }
    for(int i = 0; i < 13; i++) {
        if(trainFunctions[i] != currentTrainFunctions[i]) {
            trainFunctions[i] = currentTrainFunctions[i];
            trainStatusChanged = true;
        }
    }
    return trainStatusChanged;
}

const TrainDirection& TrainStatus::getTrainDirection()
{
    return trainDirection;
}

int TrainStatus::getTrainSpeed()
{
    return trainSpeed;
}

bool TrainStatus::getTrainFunctionStatus(int trainFunctionNumber)
{
    if(trainFunctionNumber < numberOfTrainFunctions) {
        return trainFunctions[trainFunctionNumber];
    } else {
        return false;
    }
}

bool TrainStatus::operator==(const TrainStatus& rhs)
{

    bool equals = true;
    if(trainSpeed != rhs.trainSpeed) {
        trainSpeed = rhs.trainSpeed;
        equals = false;
    }
    if(trainDirection != rhs.trainDirection) {
        trainDirection = rhs.trainDirection;
        equals = false;
    } /* DISABLED TEMPORARLY
     for(int i=0; i<13; i++) {
         if(trainFunctions[i] != rhs.trainFunctions[i]) {
             trainFunctions[i] = rhs.trainFunctions[i];
             equals = false;
         }
     }

     if(initialized == false) {
         equals = false;
         initialized = true;
     }*/

    return equals;
}
