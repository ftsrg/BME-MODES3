#include <Arduino.h>
#include "s88.h"

//#define DEBUG
#define WINDOW_SIZE 21

uint32_t buffer[WINDOW_SIZE];

void setup() {
    // Initialize serial
    Serial.begin(115200);
    // Initialize the S88 processor
    S88_Init();

    // Zeroing out the buffer
    for(uint8_t i = 0; i < WINDOW_SIZE; ++i) {
    	buffer[i] = 0;
    }
}

void send(uint8_t b) {
#ifdef DEBUG
    Serial.print(b, HEX);
    Serial.print('|');
#else
    Serial.write(b);
#endif
}

void loop() {
    uint32_t occ = S88_readOccupancy();

#ifdef DEBUG
    Serial.print(occ);
    Serial.print(" > ");

    for(int8_t shift = 24; shift >= 0; shift -= 8) {
        uint8_t byte = (occ >> shift) & 0xFF;
        Serial.print(byte);
        Serial.print(' ');
        Serial.println();
    }
#endif

    // Shifting the previous buffer values
    for (uint8_t i = 0; i < WINDOW_SIZE - 1; i++) {
        buffer[i] = buffer[i+1];
    }
    // Reading the occupancy vector into the buffer
    buffer[WINDOW_SIZE-1] = occ;

    // majority decision for each section
    uint32_t max = 0;
    for (uint32_t sectionId = 0; sectionId < 32; ++sectionId){
      uint32_t ones = 0;
      uint32_t zeroes = 0;
      for (uint32_t window = 0; window < WINDOW_SIZE; ++window){
          uint32_t bit = buffer[window] & (static_cast<uint32_t>(1) << sectionId);
          if(bit){
             ones += 1;
          } else {
             zeroes += 1;
          }
      }
#ifdef DEBUG
      Serial.print(sectionId);
      Serial.print(" ");
      Serial.print(ones);
      Serial.print(" ");
      Serial.println(zeroes);
#endif
      if(ones > zeroes){
        max |= (static_cast<uint32_t>(1) << sectionId);
      }
    }

    // Sending header first
    for (uint8_t i = 0; i < 4; ++i) {
        send(0xFF);
    }

    // We always transfer 4 bytes
    for (uint8_t i = 0; i < 4; ++i) {
        // Cut the lowest 8 bits
        send(max >> (i * 8));
    }

#ifdef DEBUG
    Serial.println();
#endif
     delay(10);
}
