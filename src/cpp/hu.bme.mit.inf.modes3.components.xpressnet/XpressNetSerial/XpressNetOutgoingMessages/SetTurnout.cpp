/**
 * Created by      Bálint Hegyi & Attila Biró
 * GitHub account: hegyibalint  & Chorithian
**/
#include "SetTurnout.h"

const uint8_t setTurnoutHeaderByte = 0x52;
const uint8_t setTurnoutDatabyte2Offset = 0x80;
const uint8_t setTurnOutMaskForLower2Bits = 0x03;
const uint8_t setTurnOutStraightBit = 0x01;
const uint8_t setTurnOutDivergentBit = 0x00;

SetTurnout::SetTurnout(uint8_t turnoutAddress, TurnoutState turnoutState) {
    uint8_t xpnTurnoutAddress = turnoutAddress - 1;
    messageBytes.push_back(setTurnoutHeaderByte);
    messageBytes.push_back(xpnTurnoutAddress >> 2);
    messageBytes.push_back(setTurnoutDatabyte2Offset |
                           ((xpnTurnoutAddress & setTurnOutMaskForLower2Bits) << 1) |
                           (turnoutState == TurnoutState::STRAIGHT ? setTurnOutStraightBit : setTurnOutDivergentBit));

    OutgoingXPNMessage::addXORto(messageBytes);
}

std::vector<uint8_t> SetTurnout::getMessageBytes() {
    return messageBytes;
}
