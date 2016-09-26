/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "XpressNetSerial.h"
#include <iostream>
//********
#include "XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.h"
//********
const int msSleepIfThreadIsOn = 100;
const int msSleepIfThreadIsOff = 10000;
const int writeBufferSoftLimit = 100;
const int writeBufferHardLimit = 200;

XpressNetSerial::XpressNetSerial()
{
}

// DEPR
CallbackAsyncSerial& XpressNetSerial::getSerial()
{
    return serial;
}

bool XpressNetSerial::addMessageToWriteQueue(OutgoingXPNMessage& xpnMessage)
{
    std::lock_guard<std::mutex> guard(messageByteBufferMutex);
    if(messageByteBuffer.size() < writeBufferSoftLimit) {
        // writeBuffer.push_back(xpnMessage);
        messageByteBuffer.push_back(xpnMessage.getMessageBytes());
        return true;
    } else {
        return false;
    }
}

bool XpressNetSerial::addUrgentMessageToWriteQueue(OutgoingXPNMessage& xpnMessage)
{
    std::lock_guard<std::mutex> guard(messageByteBufferMutex);
    if(messageByteBuffer.size() < writeBufferHardLimit) {
        messageByteBuffer.insert(messageByteBuffer.begin(), xpnMessage.getMessageBytes());
        return true;
    } else {
        return false;
    }
}

void XpressNetSerial::setThreadState(bool on)
{
    threadStateIsOn = on;
}

void XpressNetSerial::trainInfoPollingThread()
{
    int i = 0;
    // Until the end of time ...
    while(true) {
        // ... if the game is on, then work.
        if(threadStateIsOn == true) {
            messageByteBufferMutex.lock();
            // If there is nothing waiting to write ...
            if(messageByteBuffer.size() == 0) {
                // ... harass trains for informations.
                i = i % 3;
                int train = 8 + i;
                GetLocomotiveInformation gli(train);
                BoardStatus::inquireTrainInformation(train);
                // std::cout << "KAKUKKKKK: " << BoardStatus::getInquiryVectorSize() <<std::endl;
                serial.write(gli.getMessageBytes());
                i++;
            }
            // If there is at least one message to write ...
            else {
                // ... write the first one ...
                serial.write(messageByteBuffer[0]);
                // ... then delete it from the buffer.
                messageByteBuffer.erase(messageByteBuffer.begin());
            }
            messageByteBufferMutex.unlock();
            boost::this_thread::sleep_for(boost::chrono::milliseconds(msSleepIfThreadIsOn));
        }
        // ... if the game isn't on, then sleep.
        else {
            boost::this_thread::sleep_for(boost::chrono::milliseconds(msSleepIfThreadIsOff));
        }
    }
}

// Only for testing
void XpressNetSerial::trainInfoThread()
{
    int train = 9;
    GetLocomotiveInformation gli(train);
    boost::this_thread::sleep_for(boost::chrono::milliseconds(1000));
    BoardStatus::inquireTrainInformation(train);
    XpressNetSerial::getSerial().write(gli.getMessageBytes());

    while(true) {
        boost::this_thread::sleep_for(boost::chrono::milliseconds(50));
        BoardStatus::inquireTrainInformation(train);
        XpressNetSerial::getSerial().write(gli.getMessageBytes());
    }
}

CallbackAsyncSerial XpressNetSerial::serial("/dev/ttyACM0", 9600);
std::vector<std::vector<uint8_t> > XpressNetSerial::messageByteBuffer;
std::mutex XpressNetSerial::messageByteBufferMutex;
bool XpressNetSerial::threadStateIsOn = true;
