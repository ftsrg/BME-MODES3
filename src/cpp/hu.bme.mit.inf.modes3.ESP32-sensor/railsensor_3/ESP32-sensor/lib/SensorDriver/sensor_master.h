/* 
 * This is the main control library of the sensor drivers
 * @aouthor=Simon József Nagy
 */


#ifndef SENSOR_MASTER
#define SENSOR_MASTER

#include "Arduino.h"
#include "color_driver.h"
#include "gyro_driver.h"
#include "force_driver.h"
#include <MQTT_JSON>

void sensorDataSend(SensorDriver* );
void sensorErrorSend(SensorDriver* );

void startMeasurement();
void stopMeasurement();
void initalise();

#endif
