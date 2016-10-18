#include <Arduino.h>
#include "configuration.h"
#include "s88/s88.h"

#define DEBUG_MODE 0

extern HardwareSerial Serial;

void setup() {
    // initialize serial debug
    Serial.begin(SERIAL_BAUD_RATE);
    S88_Init();
}

void send(uint8_t b) {
#if DEBUG_MODE == 0
	Serial.write(b);
#else
	Serial.print(b, HEX);
	Serial.print('|');
#endif
}

void endPacket() { 
#if DEBUG_MODE == 1
	Serial.println(' ');
#endif
}

void loop() {

    // reading occupancy vector
    uint32_t occupancy_vector = S88_readOccupancy();

    // sending header first
    for (uint8_t i = 0; i < 7; ++i) {
        send(0xFF);
    }
    
    send(0xAA);
    
    uint8_t arr[4];

    // we transfer 4 bytes always
    for (uint8_t i = 0; i < 4; ++i) {
        // cut the lowest 8 bits
        arr[i] = (occupancy_vector >> (i * 8));
    }
    
    // sending for the first time
    for(uint8_t i = 0; i < 4; ++i) {
        send(arr[i]);
    }
    
    // sending for the second time
    for(uint8_t i = 0; i < 4; ++i) {
        send(arr[i]);
    }

    endPacket();


#if DEBUG_MODE == 1
    Serial.print("Occupied: ");
    for(uint8_t i=0; i<4; ++i ) {
	uint8_t arr_cpy = arr[i];
	for(uint8_t j=0; j < 8; ++j)  {
	    uint32_t segmentOccupied = arr_cpy & 1;
	    if( segmentOccupied > 0 ) {
	        Serial.print(32-(i*8+(8-j))+1);
		Serial.print(',');
	    }
	    arr_cpy >>= 1;
    	}
    }
    Serial.println('\n');
#endif
    delay(100);

}
