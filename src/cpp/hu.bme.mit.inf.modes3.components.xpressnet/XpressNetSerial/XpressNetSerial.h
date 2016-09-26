/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#pragma once
#include "AsyncSerial.h"
#include "XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.h"
#include <vector>
#include <mutex>


class XpressNetSerial {
protected:
    static CallbackAsyncSerial serial;
    static std::vector<OutgoingXPNMessage> writeBuffer;
    static std::vector<std::vector<uint8_t>> messageByteBuffer;
    static std::mutex messageByteBufferMutex;
    
    static bool threadStateIsOn;
public:
    XpressNetSerial();
    static CallbackAsyncSerial& getSerial();
    static bool addMessageToWriteQueue(OutgoingXPNMessage& xpnMessage);
    static bool addUrgentMessageToWriteQueue(OutgoingXPNMessage& xpnMessage);
    static void setThreadState(bool on);
    static void writeThread();
    static void trainInfoThread(); // Only for testing
};
