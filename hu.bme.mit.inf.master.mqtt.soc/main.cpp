#include <Arduino.h>
#include "configuration.h"
#include "mqtt-driver/mqtt-driver.h"
#include "s88/s88.h"

extern HardwareSerial Serial;

void setup() {
    // initialize serial debug
    Serial.begin(SERIAL_BAUD_RATE);
    mqtt_initialize();

    S88_Init();
    Serial.println("MoDeS3 SOC started");
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

    // insert occ. vector into json message
    // sample: {"command":"SEND_OCCUPANCY","content":"{"occupancyVector":[1,2,3,4]}"}
    uint8_t vect_arr[4];

    // we transfer 4 bytes always
    for (uint8_t i = 0; i < 4; ++i) {
        // cut the lowest 8 bits
        vect_arr[i] = occupancy_vector & 0xFF;
        // shift the sensor with 8 bits
        occupancy_vector >>= 8;
    }
    char buff[300];
    sprintf(buff, "{\"command\":\"OCCUPANCY\", \"content\":[%u,%u,%u,%u]}",
            vect_arr[0], vect_arr[1], vect_arr[2], vect_arr[3]);

    // sending message
    uint8_t success = mqtt_send(buff);
    
#if VERBOSE_LOG == 1
    Serial.print(", success: ");
    Serial.println(success);
#endif
    delay(SOC_REFRESH_RATE);
}