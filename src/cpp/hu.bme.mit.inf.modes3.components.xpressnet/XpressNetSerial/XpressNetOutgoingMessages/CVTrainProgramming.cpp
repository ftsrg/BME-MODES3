/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "CVTrainProgramming.h"

CVTrainProgramming::CVTrainProgramming(uint8_t trainID, uint8_t cvNumber, uint8_t cvValue) {
    messageBytes.push_back(cvProgrammingHeaderByte);
    messageBytes.push_back(cvProgrammingIdentificationByte);
    messageBytes.push_back(xpressNetHighAddressByte);
    messageBytes.push_back(trainID);
    messageBytes.push_back(cvProgrammingDataByte3WithoutFullRangeCV);
    messageBytes.push_back(cvNumber-1);
    messageBytes.push_back(cvValue);
}

std::vector<uint8_t> CVTrainProgramming::getMessageBytes() {
    return messageBytes;
}
