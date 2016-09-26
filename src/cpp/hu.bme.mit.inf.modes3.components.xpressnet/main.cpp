/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include <iostream>
#include <chrono>
//#include <thread>

//#include <termios.h>
#include <boost/lexical_cast.hpp>
#include <boost/thread.hpp>
#include <boost/program_options.hpp>

#include "XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.h"
//#include "MQTT/MqttClient.h"
#include "XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.h"
#include "XpressNetSerial/XpressNetSerial.h"

#include "XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.h"
#include "Network/MqttClient.h"

#include "XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.h"


//********
#include "XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.h"
#include "XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.h"
//********
#include "Network/NetworkInterface.h"

IncomingByteBuffer ibb;

void receivedDataFromSerialPort(const char *data, unsigned int len) {
    std::vector<char> v(data,data+len);
    for(unsigned int i=0; i<v.size(); i++) {
        if(v[i]=='\n') {
            //std::cout<<std::endl;
        } else {
            //std::cout << std::hex << std::setfill ('0') << std::setw(2) << (unsigned int) (v[i]) << " " << std::endl;
            ibb.addByte((unsigned int) v[i]);
        }
    }
    std::cout.flush();//Flush screen buffer
}

int main(int argc, char** argv) {
    MqttClient mqttClient = MqttClient();
    mqttClient.Connect("192.168.1.2",1883,"xpressnet","","");
    NetworkInterface::setMqttClient(mqttClient);
    //std::cout << argc << std::endl;
    
    XpressNetSerial::getSerial().setCallback(receivedDataFromSerialPort);
   
    boost::this_thread::sleep_for(boost::chrono::milliseconds(1000));
    boost::thread serialWriter(XpressNetSerial::writeThread);
    std::vector<bool> args;
    args.push_back(false);
    args.push_back(false);
    args.push_back(false);
    args.push_back(false);
    args.push_back(true);
    SetLocomotiveFunctions onee(10, TrainFunctionGroup::GROUP_0_4, args);
    args.pop_back();
    args.push_back(false);
    SetLocomotiveFunctions nulle(10, TrainFunctionGroup::GROUP_0_4, args);
    
    while(true) {
        boost::this_thread::sleep_for(boost::chrono::milliseconds(3000));
        //XpressNetSerial::addMessageToWriteQueue(onee);
        //AutomatedTrainControlInterface::setPowerState(false, TrackPowerState::OFF);
        boost::this_thread::sleep_for(boost::chrono::milliseconds(3000));
        //XpressNetSerial::addMessageToWriteQueue(nulle);
        //AutomatedTrainControlInterface::setPowerState(false, TrackPowerState::ON);
    }
}