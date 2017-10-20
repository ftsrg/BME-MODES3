#include "force_driver.h"

ForceDriver force;

void setup() {
  Serial.begin(115200);
  initaliseDriver(&force);

}

void loop() {

  force.start();
  vTaskDelay(5000);
  force.stop();
  Serial.println(force.generateOut());
  vTaskDelay(5000);

}
