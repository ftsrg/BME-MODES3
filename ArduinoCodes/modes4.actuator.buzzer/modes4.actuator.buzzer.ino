

#include <ESP8266WiFi.h>
#include <PubSubClient.h>

#include "connectons.h"
#include "music.h"


const char* mqtt_server = "192.168.1.230";

const char* TOPIC="actuator/buzzer";
const char* MQTTID = "";
const char* MQTTPSWD = "";


String clientId = "MoDeS4_IoT_Actuator_Buzzer_0001";

PubSubClient client(espClient);
long lastMsg = 0;
char msg[50];
int value = 0;






void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();

  playMusic();

}


void reconnect() {
  // Loop until we're reconnected
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    // Create a random client ID
    // Attempt to connect
    if (client.connect(clientId.c_str())) {
      Serial.println("connected");
      client.subscribe(TOPIC);
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      // Wait 5 seconds before retrying
      delay(5000);
    }
  }
}

void setup() {    
  Serial.begin(115200);
  setup_wifi();
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);

}

void loop() {
  
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

}
