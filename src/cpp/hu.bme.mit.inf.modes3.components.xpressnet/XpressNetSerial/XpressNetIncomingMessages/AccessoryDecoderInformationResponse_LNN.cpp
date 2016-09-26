/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "AccessoryDecoderInformationResponse_LNN.h"

AccessoryDecoderInformationResponse_LNN::AccessoryDecoderInformationResponse_LNN() {
    firstBytes.push_back(adirlnnHeaderByte);
    length = adirlnnLength;
}

std::vector<uint8_t> AccessoryDecoderInformationResponse_LNN::getFirstBytes() {
    return firstBytes;
}

unsigned int AccessoryDecoderInformationResponse_LNN::getMessageLength() {
    return adirlnnLength;
}

bool AccessoryDecoderInformationResponse_LNN::recognizedMessage(std::vector<uint8_t> messageBytes) {
    // THIS IS MAGIC
    if(messageBytes[2] < 0x47) {
        return false;
    }
    unsigned int baseAddress = messageBytes[1]*4+1; //+1 for MultiMaus friendly address
    
    // New table anomaly
    if(baseAddress > 100){
        return false;
    }

    for(int i=0; i<2; i++) {
        TurnoutStatus currentTurnoutStatus(TurnoutState::STRAIGHT);
        bool changed = BoardStatus::setTurnoutStatus((int) (baseAddress+i), currentTurnoutStatus);
        if(changed == true){
            std::cout << std::dec << std::setfill ('0') << std::setw(2) << baseAddress+i << " STRAIGHT LNN" << std::endl;
        }
    }
    
    return true;
}

bool AccessoryDecoderInformationResponse_LNN::isItSpecial() {
    return true;
}