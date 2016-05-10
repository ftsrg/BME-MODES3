#include "masterServices.h"

extern HardwareSerial Serial;
extern EthernetServer server;
byte Ethernet_receiveBuffer[100];


#ifdef SC_FUNCTIONALITY

void setup() {
    Serial.begin(SERIAL_BAUD_RATE);
    Serial.println("SC started");
    Ethernet_init();
    I2C_init(MASTER_ADDRESS);
    
    delay(100);

}


void loop() {

    // Listen for incoming client requests.
    int length = Ethernet_readMessage(Ethernet_receiveBuffer);

    if (length == 0) {
        return;
    }

    Serial.print("message: ");
    for (byte i = 0; i < length; i++) {
        Serial.print(Ethernet_receiveBuffer[i], HEX);
    }
    Serial.print(", length: ");
    Serial.print(length);
    Serial.println("");

    switch ((int) Ethernet_receiveBuffer[0]) {
        case COMMAND_GET_TURNOUT_STATUS:
            Ethernet_sendTurnoutStatus(Ethernet_receiveBuffer[1]);
            break;

        case COMMAND_LINE_ENABLE:
            Ethernet_setSectionStatus(Ethernet_receiveBuffer[1], true);
            break;

        case COMMAND_LINE_DISABLE:
            Ethernet_setSectionStatus(Ethernet_receiveBuffer[1], false);
            break;

        case COMMAND_GET_SECTION_STATUS:
            Ethernet_sendSectionStatus(Ethernet_receiveBuffer[1]);
            break;
    }

}

#endif

#ifdef SOC_FUNCTIONALITY

void setup() {
    Serial.begin(SERIAL_BAUD_RATE);
    Serial.println("SOC started");
    Ethernet_init();
    S88_Init();    
    delay(100);

}

void loop() {

    // Listen for incoming client requests.
    int length = Ethernet_readMessage(Ethernet_receiveBuffer);

    if (length == 0) {
        return;
    }

    Serial.print("message: ");
    for (byte i = 0; i < length; i++) {
        Serial.print(Ethernet_receiveBuffer[i], HEX);
    }
    Serial.print(", length: ");
    Serial.print(length);
    Serial.println("");

    switch ((int) Ethernet_receiveBuffer[0]) {
        case COMMAND_GET_OCCUPANCY:
            Ethernet_sendOccupancy();
            break;
    }
}

#endif

int readTurnoutStatus(byte turnout, int* value1, int* value2) {
    if (turnout == MASTER_ADDRESS) {
        const byte turnoutBranch1 = A0;
        const byte turnoutBranch2 = A1;

        pinMode(turnoutBranch1, INPUT);
        pinMode(turnoutBranch2, INPUT);

        *value1 = analogRead(turnoutBranch1);
        *value2 = analogRead(turnoutBranch2);

        // no failure
        return 0;
    }

    return -1;
}

//int readTurnoutStatus(byte turnout, int* value1, int* value2) {
//    if (turnout == 0x86) {
//        const byte turnoutBranch1 = A0;
//        const byte turnoutBranch2 = A1;
//
//        pinMode(turnoutBranch1, INPUT);
//        pinMode(turnoutBranch2, INPUT);
//
//        *value1 = analogRead(turnoutBranch1);
//        *value2 = analogRead(turnoutBranch2);
//
//        // no failure
//        return 0;
//    } else if (turnout == 0x87) {
//        const byte turnoutBranch1 = A2;
//        const byte turnoutBranch2 = A3;
//
//        pinMode(turnoutBranch1, INPUT);
//        pinMode(turnoutBranch2, INPUT);
//
//        *value1 = analogRead(turnoutBranch1);
//        *value2 = analogRead(turnoutBranch2);
//
//        // no failure
//        return 0;
//    }
//
//    return -1;
//}

