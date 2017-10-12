#pragma once

#include <Arduino.h>
#include <Ethernet.h>
#include <PubSubClient.h>
#include <SPI.h>

#include "configuration.h"
#include "connection.h"

void network_connect();

void network_disconnect();

void mqtt_connect();

bool mqtt_connected();

void mqtt_disconnect();

bool mqtt_subscribe(const char* channel);

bool mqtt_publish(const char* topic, const char* message);

bool mqtt_receive(const char* topic, char* buffer, uint16_t timeout,
                  bool silent);