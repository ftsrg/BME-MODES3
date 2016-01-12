#include <Arduino.h>
#include "masterServices.h"


// An EthernetUDP instance to let us send and receive packets over UDP
extern EthernetUDP Udp;

// buffers for receiving and sending data
byte UDP_incomePacketBuffer[UDP_TX_PACKET_MAX_SIZE]; //buffer to hold incoming packet,

extern HardwareSerial Serial;

void setup() {

    Serial.begin(SERIAL_BAUD_RATE);
    Serial.println("SC started");

    UDP_init();
    I2C_init(MASTER_ADDRESS);
    delay(100);
}

void loop() {

    int packetSize = Udp.parsePacket();

    if (packetSize) {

        // read the packet into packetBufffer
        Udp.read(UDP_incomePacketBuffer, UDP_TX_PACKET_MAX_SIZE);

        switch (UDP_incomePacketBuffer[0]) {
            case COMMAND_GET_TURNOUT_STATUS:
                UDP_sendTurnoutStatus(UDP_incomePacketBuffer[1], Udp.remoteIP(), Udp.remotePort());
                break;

            case COMMAND_LINE_ENABLE:
                UDP_setSectionStatus(UDP_incomePacketBuffer[1], true);
                break;

            case COMMAND_LINE_DISABLE:
                UDP_setSectionStatus(UDP_incomePacketBuffer[1], false);
                break;
                
            case COMMAND_GET_SECTION_STATUS:
                UDP_sendSectionStatus(UDP_incomePacketBuffer[1], Udp.remoteIP(), Udp.remotePort());
                break;
        }
        

    } // if packetSize
}

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

