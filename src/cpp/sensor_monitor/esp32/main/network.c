#include "network.h"

static TaskHandle_t task = NULL;
static void networking(void *p) {
    char *payload = "ping               \n";
    for (;;) {
      
      mqtt_write(payload, "ping");
      vTaskDelay(1000 / portTICK_PERIOD_MS);
    }
}

void mqtt_write(char* payload, char* channel)
{
  esp_mqtt_publish(channel, (void *)payload, (int)strlen(payload), 0, false);
  printf("%s", payload);
}


void start_wifi(){
    tcpip_adapter_init();
    ESP_ERROR_CHECK(esp_event_loop_init(event_handler, NULL));
  
    wifi_init_config_t cfg = WIFI_INIT_CONFIG_DEFAULT();
  
    ESP_ERROR_CHECK(esp_wifi_init(&cfg));
    ESP_ERROR_CHECK(esp_wifi_set_storage(WIFI_STORAGE_RAM));
  
    wifi_config_t wifi_config = {
        .sta =
            {
                .ssid = WIFI_SSID,
                .password = WIFI_PASS,
            },
    };
  
    ESP_ERROR_CHECK(esp_wifi_set_mode(WIFI_MODE_STA));
    ESP_ERROR_CHECK(esp_wifi_set_config(ESP_IF_WIFI_STA, &wifi_config));
    ESP_ERROR_CHECK(esp_wifi_start());
    start_mqtt();
}

void start_mqtt(){
    esp_mqtt_init(status_callback, message_callback, 256, 2000);
}

static void status_callback(esp_mqtt_status_t status) {
    switch (status) {
      case ESP_MQTT_STATUS_CONNECTED:
        esp_mqtt_subscribe("test", 0);
        esp_mqtt_subscribe("ping", 0);
        xTaskCreatePinnedToCore(networking, "networking", 4096, NULL, 10, &task, 1);
        break;
      case ESP_MQTT_STATUS_DISCONNECTED:
        vTaskDelete(task);
        break;
    }
  }
  
static void message_callback(const char *topic, uint8_t *payload, size_t len) {
    printf("incoming: %s => %s (%d)\n", topic, payload, (int)len);
  }

static esp_err_t event_handler(void *ctx, system_event_t *event) {
    switch (event->event_id) {
      case SYSTEM_EVENT_STA_START:
        esp_wifi_connect();
        break;
  
      case SYSTEM_EVENT_STA_GOT_IP:
        esp_mqtt_start(MQTT_HOST, MQTT_PORT, CLIENT_NAME, MQTT_USER, MQTT_PASS);
        break;
  
      case SYSTEM_EVENT_STA_DISCONNECTED:
        esp_mqtt_stop();
        esp_wifi_connect();
        break;
  
      default:
        break;
    }
  
    return ESP_OK;
  }
  