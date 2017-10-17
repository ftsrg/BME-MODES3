#include <stdlib.h>
#include <string.h>
#include <esp_event_loop.h>
#include <esp_mqtt.h>
#include <esp_wifi.h>

#define WIFI_SSID "Redmi"
#define WIFI_PASS "12345678"

#define MQTT_HOST "192.168.43.64"
#define MQTT_PORT 1883
#define MQTT_USER ""
#define MQTT_PASS ""
#define CLIENT_NAME "ESP32-test"

static void start(void*);
void start_wifi();
void start_mqtt();
static void status_callback(esp_mqtt_status_t);
static void message_callback(const char*, uint8_t*, size_t);
static esp_err_t event_handler(void*, system_event_t*);
void mqtt_write(char*);