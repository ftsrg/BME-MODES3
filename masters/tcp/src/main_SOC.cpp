//#include <Arduino.h>
//
//#include "masterServices.h"
//
//
//// An EthernetUDP instance to let us send and receive packets over UDP
//extern EthernetUDP Udp;
//
//// buffers for receiving and sending data
//byte UDP_incomePacketBuffer[UDP_TX_PACKET_MAX_SIZE]; //buffer to hold incoming packet,
//
//extern HardwareSerial Serial;
//
//void setup() {
//
//    Serial.begin(SERIAL_BAUD_RATE);
//    Serial.println("SOC started");
//
//    S88_Init();
//    UDP_init();
//    delay(100);
//}
//
//void loop() {
//
//    int packetSize = Udp.parsePacket();
//
//    if (packetSize) {
//
//        // read the packet into packetBufffer
//        Udp.read(UDP_incomePacketBuffer, UDP_TX_PACKET_MAX_SIZE);
//
//        switch (UDP_incomePacketBuffer[0]) {
//            case COMMAND_GET_OCCUPANCY:
//                UDP_sendOccupancy(Udp.remoteIP(), Udp.remotePort());
//                break;
//        }
//        
//
//    } // if packetSize
//}