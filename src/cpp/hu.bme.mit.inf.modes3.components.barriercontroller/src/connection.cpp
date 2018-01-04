#include <Arduino.h>
#include <Ethernet.h>
#include <PubSubClient.h>
#include <SPI.h>

#include "configuration.h"
#include "connection.h"

extern HardwareSerial Serial;

static EthernetClient ethClient;
static PubSubClient client(ethClient);

static bool is_response_received = false;
static char message_topic[50];
static char message_buffer[200];

void network_connect() {
    // K V 192 168 1 177
    uint8_t mac[] = {0x4B, 0x56, 0xC0, 0xA8, 0x01, 0xB1};
    IPAddress ip(192, 168, 1, 177);
    Ethernet.begin(mac, ip);
    delay(1500);
}

void network_disconnect() {}

static void callback(char* topic, uint8_t* payload, unsigned int length) {
    Serial.print("\nMessage received from:");
    Serial.print(topic);
    Serial.print("target: ");
    Serial.println(message_topic);

    if (strcmp(message_topic, topic) == 0) {
        is_response_received = true;
        strcpy(message_buffer, (const char*)payload);
    }
}

void mqtt_connect() {
    client.setServer(CONF_MQTT_HOST, CONF_MQTT_PORT);
    client.setCallback(callback);

    // Loop until we're reconnected
    while (!client.connected()) {
        Serial.print("Attempting MQTT connection...");
        // Attempt to connect
        if (client.connect(CONF_CLIENTID)) {
            client.subscribe(CONF_DATA_CH);
            Serial.println("connected");
        } else {
            Serial.print("failed, rc=");
            Serial.print(client.state());
            Serial.println(" try again in 5 seconds");
            // Wait 5 seconds before retrying
            delay(5000);
        }
    }

    // send one loop
    client.loop();
}

bool mqtt_connected() { return client.connected(); }

void mqtt_disconnect() { client.disconnect(); }

bool mqtt_subscribe(const char* channel) {
    if( mqtt_connected() ) {
        client.subscribe(channel);
        return true;
    }

    return false;
}

bool mqtt_publish(const char* topic, const char* message) {
    return client.publish(topic, message);
}

bool mqtt_receive(const char* topic, char* buffer, uint16_t timeout,
                  bool silent) {
    is_response_received = false;
    strcpy(message_topic, topic);

    // waiting for response, if timeout is <=0, infinite cycle
    if (!silent) {
        Serial.print("Receive timeout: "); Serial.println(timeout);
    }
    uint16_t time_left = timeout / 50;
    while (time_left) {
        if (!silent) Serial.print(".");
        client.loop();
        if (is_response_received) {
            if (!silent) Serial.println("Response received");
            // loading message into buffer
            strcpy(buffer, message_buffer);
            break;
        }
        delay(50);
        if (timeout > 0) {
            --time_left;
        }
    }

    return is_response_received;
}