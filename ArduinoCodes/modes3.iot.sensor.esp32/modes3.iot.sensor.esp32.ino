#include "sensor_monitor.h"


void setup() {

  SensorMonitor sm=SensorMonitor();
  Serial.println("sensormonitor object is created");

    
  sm.start();

  while(1){
    sm.update();
    delay(1000);
  }

  

}

void loop() {
  // put your main code here, to run repeatedly:
}
