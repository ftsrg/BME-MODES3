#include <Arduino.h>
#include "configuration.h"
#include "mqtt-driver/mqtt-driver.h"

extern HardwareSerial Serial;

void setup() {
    // initialize serial debug
    Serial.begin(SERIAL_BAUD_RATE);
    Serial.println("MoDeS3 SOC started");
    mqtt_initialize();
}

void loop() {
    Serial.println("Sending message...");
    mqtt_send("test message");
    delay(5000);
}