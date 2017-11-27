#include "sensor_monitor.h"



void setup() {
  //Serial.begin(115200);
  //Serial.println("start testing...");
  SensorMonitor sm=SensorMonitor();
  while(1){
    
    sm.start();
  
    delay(1000);
  
    sm.stop();
  
    std::list<int> timestamp=sm.getT();
    std::list<double> r=sm.getR();
    std::list<double> x=sm.getX();
    //Serial.println("send to serial the data...");
    //Serial.print("size of the list:  ");
    //Serial.println(timestamp.size());
    for(int i=timestamp.size();i>0;i--){
      //Serial.print(timestamp.front());
      //Serial.print("  :  ");
      //Serial.print(r.front());
      //Serial.print("  :  ");
      //Serial.print(x.front());
      ////Serial.println(ref.front());
      
      timestamp.pop_front();
      x.pop_front();
      r.pop_front();

      //ref.pop_front();
    }

    //Serial.println(sm.prevNUID);

  
    sm.clear();

  }
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:
}
