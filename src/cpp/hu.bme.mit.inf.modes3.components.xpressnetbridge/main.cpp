/**
 * Created by Attila Biró
 * GitHub account: Chorithian
 **/
#include <iostream>
#include <chrono>
#include <boost/lexical_cast.hpp>
#include <boost/thread.hpp>
//#include <boost/program_options.hpp>
#include "XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.h"
#include "XpressNetSerial/XpressNetSerial.h"
#include "Network/NetworkInterface.h"
#include "Network/MosquittoppClient.h"

IncomingByteBuffer ibb;

void receivedDataFromSerialPort(const char* data, unsigned int len) {
    std::vector<char> v(data, data + len);
    for (unsigned int i = 0; i < v.size(); i++) {
        if (v[i] == '\n') {
            // std::cout<<std::endl;
        } else {
            // std::cout << std::hex << std::setfill ('0') << std::setw(2) << (unsigned int) (v[i]) << " " << std::endl;
            ibb.addByte((unsigned int) v[i]);
        }
    }
    std::cout.flush(); // Flush screen buffer
}

int main(int argc, char** argv) {
    GOOGLE_PROTOBUF_VERIFY_VERSION;

    MosquittoppClient mosquittoppClient = MosquittoppClient(NULL, "/modes3/all", "192.168.1.2", 1883);
    NetworkInterface::setMqttClient(&mosquittoppClient);
    // std::cout << argc << std::endl;

    boost::this_thread::sleep_for(boost::chrono::milliseconds(1000));
    boost::thread serialWriter(XpressNetSerial::trainInfoPollingThread);
    XpressNetSerial::getSerial().setCallback(receivedDataFromSerialPort);

    while (true) {
        boost::this_thread::sleep_for(boost::chrono::milliseconds(3000));

        boost::this_thread::sleep_for(boost::chrono::milliseconds(3000));
    }
}
