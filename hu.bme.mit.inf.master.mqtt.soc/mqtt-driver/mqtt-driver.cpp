#include <SPI.h>
#include <Ethernet.h>
#include "mqtt-driver.h"
#include "../configuration.h"
#include "../MQTTClient/IPStack.h"
#include "../MQTTClient/Countdown.h"
#include "../MQTTClient/MQTTClient.h"

EthernetClient c;
IPStack ipstack(c);
MQTT::Client<IPStack, Countdown, 100, 1> client = MQTT::Client<IPStack, Countdown, 100, 1>(ipstack);


//            K     V     192   168   1     160
byte mac[] = {0x5B, 0x56, 0xC0, 0xA8, 0x01, 0xA0};
IPAddress ip(192, 168, 1, 160);

extern HardwareSerial Serial;

static void messageArrived(MQTT::MessageData&) {

}

void mqtt_initialize() {
    Ethernet.begin(mac, ip);
    mqtt_connect();
}

void mqtt_connect() {
#if VERBOSE_LOG == 1
    Serial.print("Connecting to ");
    Serial.print(MQTT_HOST);
    Serial.print(":");
    Serial.println(MQTT_PORT);
#endif

    byte rc = ipstack.connect(MQTT_HOST, MQTT_PORT);
    if (rc != 1) {
#if VERBOSE_LOG == 1
        Serial.print("rc from TCP connect is ");
        Serial.println(rc);
#endif

    }
#if VERBOSE_LOG == 1
    Serial.println("MQTT connecting");
#endif
    MQTTPacket_connectData data = MQTTPacket_connectData_initializer;
    data.MQTTVersion = 3;
    data.clientID.cstring = MQTT_CLID;
    rc = client.connect(data);
    if (rc != 0) {
#if VERBOSE_LOG == 1
        Serial.print("rc from MQTT connect is ");
        Serial.println(rc);
#endif
    }
#if VERBOSE_LOG == 1
    Serial.println("MQTT connected");
#endif

    rc = client.subscribe(MQTT_TOPC, MQTT::QOS2, messageArrived);
    if (rc != 0) {
#if VERBOSE_LOG == 1
        Serial.print("rc from MQTT subscribe is ");
        Serial.println(rc);
#endif
    }
#if VERBOSE_LOG == 1
    Serial.println("MQTT subscribed");
#endif
}

uint8_t mqtt_send(char* msg) {
    MQTT::Message message;
    message.qos = MQTT::QOS1;
    message.retained = false;
    message.dup = false;

    message.payload = (void*) msg;
    message.payloadlen = strlen(msg);

    if (!client.isConnected())
        mqtt_connect();

    return client.publish(MQTT_TOPC, message);
}