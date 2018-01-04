#include <Arduino.h>
#include <ArduinoJson.h>
#include <EEPROM.h>
#include <Servo.h>
#include <stdint.h>

#include "configuration.h"
#include "connection.h"

extern HardwareSerial Serial;

enum GateState { GATES_OPENED, GATES_CLOSED };

struct Gate {
    Servo servo;
    uint8_t closed_angle, opened_angle;
};

Gate g1, g2;

GateState state = GATES_CLOSED;
GateState prevState = GATES_OPENED;

void apply_state(GateState st) {
    // if previously known state is not equal with the current one
    // follow it
    if (prevState != st) {
        g1.servo.attach(A0);
        g2.servo.attach(A1);
        switch (st) {
            case GATES_CLOSED:
                g1.servo.write(g1.closed_angle);
                g2.servo.write(g2.closed_angle);
                break;
            case GATES_OPENED:
                g1.servo.write(g1.opened_angle);
                g2.servo.write(g2.opened_angle);
                break;
        }
        prevState = st;
        delay(200);
        g1.servo.detach();
        g2.servo.detach();
    }
}

void setup() {
    Serial.begin(9600);
    Serial.println("Controller started");

    // eeprom addresses are 0,1,2,3
    g1.closed_angle = EEPROM.read(0);
    g2.closed_angle = EEPROM.read(1);

    g1.opened_angle = EEPROM.read(2);
    g2.opened_angle = EEPROM.read(3);

    Serial.print("g1 closed: ");
    Serial.println(g1.closed_angle);
    Serial.print("g2 closed: ");
    Serial.println(g2.closed_angle);
    Serial.print("g1 opened: ");
    Serial.println(g1.opened_angle);
    Serial.print("g2 opened: ");
    Serial.println(g2.opened_angle);

    // close gates immediatelly
    apply_state(GATES_CLOSED);

    network_connect();
    mqtt_connect();

}

void loop() {
    // if there is any message from serial, receive it and process it
    if (Serial.available() > 0) {
        processSerialData();
    }

    // check connection
    if( !mqtt_connected() ) {
        mqtt_connect();
    }

    // receive message from mqtt
    char buffer[200];
    bool received = mqtt_receive(CONF_DATA_CH, buffer, 1000, true);
    if( received ) {
        command_message_handler(buffer);
    }

    // check if state is changed
    apply_state(state);
}

void command_message_handler(const char* message) {
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& root = jsonBuffer.parseObject(message);
    if (!root.success()) {
        Serial.println("parseObject() failed");
        return;
    }
    const char* st = root["state"];
    if (st != NULL) {
        if (strcmp(st, "opened") == 0) {
            state = GATES_OPENED;
        }
        if (strcmp(st, "closed") == 0) {
            state = GATES_CLOSED;
        }
        return;
    }
}

void processSerialData() {
    char buffer[40];
    uint8_t i = 0, j = 0, k = 0;

    // first, receive all data from Serial
    while (Serial.available() > 0) {
        buffer[i] = Serial.read();
        ++i;
        delay(5);
    }
    buffer[i - 1] = 0;

    Serial.print("Data received: ");
    Serial.println(buffer);

    for (i = 0; i < 40; ++i) {
        Serial.print(buffer[i], HEX);
        Serial.print(' ');
    }
    Serial.println(' ');

    // check if up/down message received
    if (strcmp(buffer, "open") == 0) {
        state = GATES_OPENED;
        Serial.println("Opened");
        return;
    }

    if (strcmp(buffer, "close") == 0) {
        state = GATES_CLOSED;
        Serial.println("Closed");
        return;
    }

    // check if save message is received
    if (strcmp(buffer, "save") == 0) {
        EEPROM.write(0, g1.closed_angle);
        EEPROM.write(1, g2.closed_angle);
        EEPROM.write(2, g1.opened_angle);
        EEPROM.write(3, g2.opened_angle);
        Serial.println("Saved");
        return;
    }

    // otherwise we got state message, process it
    i = 0;

    while (i < strlen(buffer) && j < 4) {
        // if we read ; character, save the current value
        // for the next element
        if (buffer[i] == ';') {
            Serial.print("Sep @");
            Serial.println(i);
            switch (j) {
                case 0:
                    g1.closed_angle = k;
                    Serial.print("G1 closed angle: ");
                    Serial.println(k);
                    break;
                case 1:
                    g2.closed_angle = k;
                    Serial.print("G2 closed angle: ");
                    Serial.println(k);
                    break;
                case 2:
                    g1.opened_angle = k;
                    Serial.print("G1 opened angle: ");
                    Serial.println(k);
                    break;
                case 3:
                    g2.opened_angle = k;
                    Serial.print("G2 opened angle: ");
                    Serial.println(k);
                    break;
            }
            k = 0;
            ++j;
            ++i;
            continue;
        }
        k *= 10;
        k += buffer[i] - 0x30;
        ++i;
        Serial.print("k=");
        Serial.println(k);
    }

    // clear memory
    memset(buffer, 0x00, sizeof(buffer));
}