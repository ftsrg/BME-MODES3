/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "LocomotiveInformation.h"

LocomotiveInformation::LocomotiveInformation() : IncomingXPNMessage() {
    firstBytes.push_back(0xE4);
    length = 6;
}

std::vector<uint8_t> LocomotiveInformation::getFirstBytes() {
    return firstBytes;
}

unsigned int LocomotiveInformation::getMessageLength() {
    return length;
}

bool LocomotiveInformation::isItSpecial() {
    return false;
}

bool LocomotiveInformation::recognizedMessage(std::vector<uint8_t> messageBytes) {
    const uint8_t identificationByte = messageBytes[1];
    if(identificationByte>15) {
        std::cout << "LocomotiveInformation - Bad format" << std::endl;
        return false;
    }


    bool isLocomotiveFree = (((identificationByte & 0b00001000)>>3) == 0);
    uint8_t currentSpeedStepMode = (identificationByte & 0b00000111);
    int currentSpeedSteps;
    std::string free;
    if(isLocomotiveFree == true) {
        free = "YES";
    } else {
        free = "NO";
    }

    switch(currentSpeedStepMode) {
    case 0b000 :
        currentSpeedSteps =  14;
        break;
    case 0b001 :
        currentSpeedSteps =  27;
        break;
    case 0b010 :
        currentSpeedSteps =  28;
        break;
    case 0b100 :
        currentSpeedSteps = 128;
        break;
    default    :
        return false;
    }

    const uint8_t speedByte = messageBytes[2];
    int speed;
    //bool forward;
    TrainDirection trainDirection;
    if((speedByte & 0b10000000)==0b10000000) {
        //forward = true;
        trainDirection = TrainDirection::FORWARD;
    } else {
        //forward = false;
        trainDirection = TrainDirection::BACKWARD;
    }

    switch(speedByte & 0b01111111) {
    case 0b00000000 :
        speed = 0;
        break;     // Speed 0
    case 0b00000001 :
        speed = -1;
        break;    // Emergency stop
    default         :
        speed = (int) ((speedByte & 0b01111111)-1);
    }


    const uint8_t functionByteA = messageBytes[3];
    const uint8_t functionByteB = messageBytes[4];

    bool functionStatus[numberOfTrainFunctions];

    functionStatus[0] = ((functionByteA & 0b00010000) == 0b00010000);
    for(int i = 1; i < 5; i++) {
        functionStatus[i] = (((functionByteA & (0b00000001) << (i-1)) >> (i-1)) == 0b00000001);
    }
    for(int i = 0; i < 8; i++) {
        functionStatus[i+5] = (((functionByteB & (0b00000001) << (i)) >> (i)) == 0b00000001);
    }


    TrainStatus trainStatus(trainDirection, speed, functionStatus);
    int trainAddress = BoardStatus::getFirstInquiredTrainAddress();
    //int trainAddress = BoardStatus::trainAddresses[0];
    //BoardStatus::trainAddresses.erase(BoardStatus::trainAddresses.begin());
    if(trainAddress != -1) {
        bool changed = BoardStatus::setTrainStatus(trainAddress, trainStatus);
        //&&(trainAddress == 9)
        if(changed == true) {
            std::cout << "LocomotiveInformation changed " << trainAddress << std::endl;
            std::cout << "Is locomotive free: " << free << " Current speed step mode: "<< std::dec << currentSpeedSteps << std::endl;
            std::cout << "TrainSpeed : " << speed << std::endl;
            for(int i = 0; i < 13; i++) {
                std::string str;
                if(functionStatus[i]==true) {
                    str = "ON";
                } else {
                    str = "OFF";
                }
                std::cout << "FunctionStatus[" << i << "] is: " << str << std::endl;
            }
        }
        /*
         * Only for testing. Set the trains functions correctly, then test.
        if((functionStatus[trainAddress] != true)){
            std::cout << "I HAVE A BAD FEELING ABOUT THIS" << std::endl;
        }*/
    }
    else {
            //std::cout << "A FLUSH MIGHT HELP, BUT IT COULD WIPE USEFUL INFO" << std::endl;
    }
    return true;
}
