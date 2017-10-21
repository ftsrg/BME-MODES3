#include "sensor_master.h"
//#include "gyro_driver.h"

void ping(){
  Serial.println("Ping!");
}


void setup() {
  Serial.begin(115200);
  initalise();

}

void loop() {
  ping();
  startMeasurement();
  vTaskDelay(5000);
  ping();
  stopMeasurement();

}
