#include <Arduino.h>
#include "configuration.h"
#include "s88/s88.h"

extern HardwareSerial Serial;

void setup() {
    // initialize serial debug
    Serial.begin(SERIAL_BAUD_RATE);
    S88_Init();
}

void loop() {

#if VERBOSE_LOG == 1
    Serial.print("SOC message sending try, data: ");
#endif

    // reading occupancy vector
    uint32_t occupancy_vector = S88_readOccupancy();

#if VERBOSE_LOG == 1
    Serial.print(occupancy_vector);
#endif

    // sending header first
    for (uint8_t i = 0; i < 7; ++i) {
        Serial.write(0xFF);
    }
    
    Serial.write(0xAA);
    
    uint8_t arr[4];

    // we transfer 4 bytes always
    for (uint8_t i = 0; i < 4; ++i) {
        // cut the lowest 8 bits
        arr[i] = occupancy_vector & 0xFF;
        // shift the sensor with 8 bits
        occupancy_vector >>= 8;
    }
    
    // sending for the first time
    for(uint8_t i = 0; i<4; ++i ) {
        Serial.write(arr[i]);
    }
    
    // sending for the second time
    for(uint8_t i = 0; i<4; ++i ) {
        Serial.write(arr[i]);
    }

}
