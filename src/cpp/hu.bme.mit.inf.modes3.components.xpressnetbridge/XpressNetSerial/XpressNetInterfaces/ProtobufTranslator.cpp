/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "ProtobufTranslator.h"
#include "XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessageList.h"
#include "XpressNetSerial/XpressNetSerial.h"
#include "Network/NetworkInterface.h"

//---------------------------------------------------------------------------------------------------
// Modes3 -> XpressNet
//---------------------------------------------------------------------------------------------------
bool ProtobufTranslator::processMessage(std::string messageString)
{
    // Parsing
    modes3::protobuf::Message message = modes3::protobuf::Message();
    message.ParseFromString(messageString);
    // PowerState
    if(message.type() == modes3::protobuf::DCC_OPERATIONS_COMMAND) {
        TrackPowerState powerState;
        if(message.mutable_dccoperationscommand()->dccoperations() ==
            modes3::protobuf::DccOperations::STOP_OPERATIONS) {
            powerState = TrackPowerState::OFF;
        } else if(message.mutable_dccoperationscommand()->dccoperations() ==
            modes3::protobuf::DccOperations::STOP_ALL_LOCOMOTIVES) {
            powerState = TrackPowerState::ALL_TRAINS_OFF;
        } else if(message.mutable_dccoperationscommand()->dccoperations() ==
            modes3::protobuf::DccOperations::NORMAL_OPERATIONS) {
            powerState = TrackPowerState::ON;
        }
        ProtobufTranslator::setPowerState(1, powerState);
    }
    // Turnout
    else if(message.type() == modes3::protobuf::TURNOUT_COMMAND) {
        TurnoutState turnoutState;
        // DIVERGENT
        if(message.mutable_turnoutcommand()->state() == modes3::protobuf::TurnoutStateValue::DIVERGENT) {
            turnoutState = TurnoutState::DIVERGENT;
        }
        // STRAIGHT
        else if(message.mutable_turnoutcommand()->state() == modes3::protobuf::TurnoutStateValue::STRAIGHT) {
            turnoutState = TurnoutState::STRAIGHT;
        }
        // ???
        else {
            return false;
        }
        int turnoutAddress = message.mutable_turnoutcommand()->turnoutid();
        ProtobufTranslator::setTurnoutState(1, turnoutAddress, turnoutState);
    }
    // TrainSpeed
    else if(message.type() == modes3::protobuf::TRAIN_REFERENCE_SPEED_COMMAND) {
        TrainDirection trainDirection;
        // BACKWARD
        if(message.mutable_trainreferencespeedcommand()->direction() ==
            modes3::protobuf::TrainDirectionValue::BACKWARD) {
            trainDirection = TrainDirection::BACKWARD;
        }
        // FORWARD
        else if(message.mutable_trainreferencespeedcommand()->direction() ==
            modes3::protobuf::TrainDirectionValue::FORWARD) {
            trainDirection = TrainDirection::FORWARD;
        }
        //???
        else {
            return false;
        }
        int trainAddress = message.mutable_trainreferencespeedcommand()->trainid();
        int trainSpeed = message.mutable_trainreferencespeedcommand()->referencespeed();
        ProtobufTranslator::setTrainSpeed(1, trainAddress, trainDirection, trainSpeed);
    }
    // TrainFunction
    else if(message.type() == modes3::protobuf::TRAIN_FUNCTION_COMMAND) {
        // Not yet implemented.
        return false;
    }
    // ???
    else {
        return false;
    }
    return true;
}

bool ProtobufTranslator::setPowerState(int messagePriority, TrackPowerState powerState)
{
    bool successfullyAdded = false;
    // ON
    if(powerState == TrackPowerState::ON) {
        StartOperations stop = StartOperations(); // STart OPerations
        if(messagePriority < 1) {
            successfullyAdded = XpressNetSerial::addMessageToWriteQueue(stop);
        } else {
            successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(stop);
        }
    }
    // ALL TRAINS OFF
    else if(powerState == TrackPowerState::ALL_TRAINS_OFF) {
        StopAllLocomotives stop = StopAllLocomotives(); // Stop all Trains OPeration
        if(messagePriority < 1) {
            successfullyAdded = XpressNetSerial::addMessageToWriteQueue(stop);
        } else {
            successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(stop);
        }
    }
    // OFF
    else if(powerState == TrackPowerState::OFF) {
        StopOperations stop = StopOperations(); // STop OPerations
        if(messagePriority < 1) {
            successfullyAdded = XpressNetSerial::addMessageToWriteQueue(stop);
        } else {
            successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(stop);
        }
    }
    // ???
    else {
        return false;
    }
    return successfullyAdded;
}

bool ProtobufTranslator::setTrainSpeed(int messagePriority,
    int trainAddress,
    TrainDirection trainDirection,
    int trainSpeed)
{

    bool successfullyAdded = false;
    int sTrainSpeed;
    // TOO LOW
    if(trainSpeed < -1) {
        sTrainSpeed = -1;
    }
    // TOO HOGH
    else if(trainSpeed > 126) {
        sTrainSpeed = 126;
    }
    // NORMAL
    else {
        sTrainSpeed = trainSpeed;
    }
    SetLocomotiveSpeed slp = SetLocomotiveSpeed(trainAddress, trainDirection, sTrainSpeed);
    // HIGH PRIO
    if(messagePriority < 1) {
        successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(slp);
    }
    // LOW PRIO
    else {
        successfullyAdded = XpressNetSerial::addMessageToWriteQueue(slp);
    }
    return successfullyAdded;
}

bool ProtobufTranslator::setTrainFunction(int messagePriority,
    int trainAddress,
    int trainFunctionNumber,
    bool trainFunctionState)
{

    bool successfullyAdded = false;
    TrainFunctionGroup trainFunctionGroup;
    int function;
    int position = 0;
    if(trainFunctionNumber < 5) {
        trainFunctionGroup = TrainFunctionGroup::GROUP_0_4;
        function = 0;
        position--;
    } else if(trainFunctionNumber < 9) {
        trainFunctionGroup = TrainFunctionGroup::GROUP_5_8;
        function = 5;
    } else if(trainFunctionNumber < 13) {
        trainFunctionGroup = TrainFunctionGroup::GROUP_9_12;
        function = 9;
    } else {
        return false;
    }
    position += trainFunctionNumber - function;
    std::vector<bool> functions;
    TrainStatus trainStatus = BoardStatus::getTrainStatus(trainAddress);
    for(int i = 0; i < 5; i++) {
        if(i == position) {
            functions.push_back(trainFunctionState);
        } else {
            functions.push_back(trainStatus.getTrainFunctionStatus(function + i));
        }
    }
    if(trainFunctionGroup == TrainFunctionGroup::GROUP_0_4) {
        if(trainFunctionNumber == 0) {
            functions.push_back(trainFunctionState);
        } else {
            functions.push_back(trainStatus.getTrainFunctionStatus(0));
        }
    }
    SetLocomotiveFunctions slf = SetLocomotiveFunctions(trainAddress, trainFunctionGroup, functions);

    if(messagePriority < 1) {
        successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(slf);
    } else {
        successfullyAdded = XpressNetSerial::addMessageToWriteQueue(slf);
    }
    return successfullyAdded;
}

bool ProtobufTranslator::setTurnoutState(int messagePriority, int turnoutAddress, TurnoutState turnoutState)
{
    SetTurnout st = SetTurnout(turnoutAddress, turnoutState);
    bool successfullyAdded = false;
    if(messagePriority < 1) {
        successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(st);
    } else {
        successfullyAdded = XpressNetSerial::addMessageToWriteQueue(st);
    }
    return successfullyAdded;
}

bool ProtobufTranslator::setTrainCV(int messagePriority, int trainAddress, int cvRegisterAddress, int cvRegisterData)
{ // advanced
    CVTrainProgramming cvp = CVTrainProgramming(trainAddress, cvRegisterAddress, cvRegisterData);
    bool successfullyAdded = false;
    if(messagePriority < 1) {
        successfullyAdded = XpressNetSerial::addUrgentMessageToWriteQueue(cvp);
    } else {
        successfullyAdded = XpressNetSerial::addMessageToWriteQueue(cvp);
    }
    return successfullyAdded;
}

bool ProtobufTranslator::sendCustomCommand(int messagePriority, int commandBytes[])
{ // advanced
    // currently not implemented
    return false;
}
//---------------------------------------------------------------------------------------------------
// XpressNet -> Modes3
//---------------------------------------------------------------------------------------------------
void ProtobufTranslator::powerStateChanged(TrackPowerState powerState)
{
    modes3::protobuf::Message wrapperMessage = modes3::protobuf::Message();
    wrapperMessage.set_type(modes3::protobuf::DCC_OPERATIONS_STATE);
    wrapperMessage.set_type(modes3::protobuf::DCC_OPERATIONS_STATE);

    modes3::protobuf::DccOperations dccOperations;
    // ALL OFF
    if(powerState == TrackPowerState::OFF) {
        dccOperations = modes3::protobuf::DccOperations::STOP_OPERATIONS;
    }
    // ALL TRAINS OFF
    else if(powerState == TrackPowerState::ALL_TRAINS_OFF) {
        dccOperations = modes3::protobuf::DccOperations::STOP_ALL_LOCOMOTIVES;
    }
    // ALL ON
    else {
        dccOperations = modes3::protobuf::DccOperations::NORMAL_OPERATIONS;
    }
    wrapperMessage.mutable_dccoperationsstate()->set_dccoperations(dccOperations);
    ProtobufTranslator::sendMessage(wrapperMessage);
}

void ProtobufTranslator::trainSpeedChanged(int trainAddress, TrainDirection direction, int speed) {
    modes3::protobuf::Message wrapperMessage = modes3::protobuf::Message();
    wrapperMessage.set_type(modes3::protobuf::TRAIN_REFERENCE_SPEED);
    modes3::protobuf::TrainDirectionValue mTrainDirection;
    // BACKWARD
    if(direction == TrainDirection::BACKWARD) {
        mTrainDirection = modes3::protobuf::TrainDirectionValue::BACKWARD;
    }
    // FORWARD
    else {
        mTrainDirection = modes3::protobuf::TrainDirectionValue::FORWARD;
    }
    wrapperMessage.mutable_trainreferencespeed()->set_trainid(trainAddress);
    wrapperMessage.mutable_trainreferencespeed()->set_direction(mTrainDirection);
    wrapperMessage.mutable_trainreferencespeed()->set_referencespeed(speed);
    ProtobufTranslator::sendMessage(wrapperMessage);
}

void ProtobufTranslator::trainFunctionChanged(int trainAddress, bool trainFunctions[13]) {
    // NOT IMPLEMENTED YET.
}

void ProtobufTranslator::turnoutStateChanged(int turnoutAddress, TurnoutState turnoutState) {
    modes3::protobuf::Message wrapperMessage = modes3::protobuf::Message();
    wrapperMessage.set_type(modes3::protobuf::TURNOUT_REFERENCE_STATE);

    modes3::protobuf::TurnoutStateValue tsv;
    if(turnoutState == TurnoutState::STRAIGHT) {
        tsv = modes3::protobuf::TurnoutStateValue::STRAIGHT;
    } else if(turnoutState == TurnoutState::DIVERGENT) {
        tsv = modes3::protobuf::TurnoutStateValue::DIVERGENT;
    }
    wrapperMessage.mutable_turnoutreferencestate()->set_turnoutid(turnoutAddress);
    wrapperMessage.mutable_turnoutreferencestate()->set_state(tsv);
    ProtobufTranslator::sendMessage(wrapperMessage);
}

bool ProtobufTranslator::sendMessage(modes3::protobuf::Message message) {
    std::ostringstream stream;
    message.SerializeToOstream(&stream);

    std::string messageString = stream.str();
    NetworkInterface::sendMessage(messageString);
    return true;
}