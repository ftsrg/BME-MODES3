/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "AccessoryDecoderInformationResponse.h"

AccessoryDecoderInformationResponse::AccessoryDecoderInformationResponse() : IncomingXPNMessage() {
    firstBytes.push_back(adirHeaderByte);
    length = adirLength;
}

bool AccessoryDecoderInformationResponse::recognizedMessage(std::vector<uint8_t> messageBytes) {
    unsigned int baseAddress = messageBytes[1]*4 + ((messageBytes[2] & nibbleMask)>>4)*2 + 1; //+1 for MultiMaus friendly address
    
    // New table anomaly
    if(baseAddress > 100){
        return false;
    }
    
    uint8_t status[2];
    
    for(int i=0; i<2; i++) {
        status[i] = (messageBytes[2] & (firstStatusFlagMask<<(i*2)))>>(i*2);
        if((status[i] > 0) && (status[i] < 3)){
            TurnoutState currentTurnoutState;
            std::string direction;
            if (status[i] == 0b01) {
                currentTurnoutState = TurnoutState::DIVERGENT;
                direction = "DIVERGENT";
            }
            else {
                currentTurnoutState = TurnoutState::STRAIGHT;
                direction = "STRAIGHT";
            }
            TurnoutStatus currentTurnoutStatus(currentTurnoutState);
            bool changed = BoardStatus::setTurnoutStatus((int) (baseAddress+i), currentTurnoutStatus);
            if(changed == true){
                std::cout << std::dec << std::setfill ('0') << std::setw(2) << baseAddress+i << " " << direction << std::endl;
            }
        }
    }
    
    return true;
}

unsigned int AccessoryDecoderInformationResponse::getMessageLength() {
    return length;
}

std::vector<uint8_t> AccessoryDecoderInformationResponse::getFirstBytes() {
    return firstBytes;
}

bool AccessoryDecoderInformationResponse::isItSpecial() {
    return false;
}