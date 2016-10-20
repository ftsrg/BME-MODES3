/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once

#include "TrainDirection.h"
#include "TurnoutState.h"
#include "TrackPowerState.h"
#include "TrainFunctionGroup.h"
#include "GoogleProtocolBuffers/Message.pb.h"

class ProtobufTranslator
{
    // Modes3 -> XpressNet
private:
    static bool setPowerState(int messagePriority, TrackPowerState powerState);
    static bool setTrainSpeed(int messagePriority, int trainAddress, TrainDirection trainDirection, int trainSpeed);
    static bool
    setTrainFunction(int messagePriority, int trainAddress, int trainFunctionNumber, bool trainFunctionState);
    static bool setTurnoutState(int messagePriority, int turnoutAddress, TurnoutState turnoutState);
    static bool
    setTrainCV(int messagePriority, int trainAddress, int cvRegisterAddress, int cvRegisterData); // advanced
    static bool sendCustomCommand(int messagePriority, int commandBytes[]);                       // advanced
    static bool sendMessage(modes3::protobuf::Message message);

public:
    static bool processMessage(std::string messageString);

    // XpressNet -> Modes3
    static void powerStateChanged(TrackPowerState powerState);
    static void trainSpeedChanged(int trainAddress, TrainDirection direction, int speed);
    static void trainFunctionChanged(int trainAddress, bool trainFunctions[13]);
    static void turnoutStateChanged(int turnoutAddress, TurnoutState turnoutState);
};