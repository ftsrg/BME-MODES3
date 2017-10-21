
#ifndef SENSOR_DRIVER
#define SENSOR_DRIVER

#include <math.h>
#include <Arduino.h>#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "freertos/queue.h"
#include "driver/gpio.h"
#include "time.h"
#include <algorithm>
#include <list>
#include <math.h>


void debugOut(const char* );


class SensorDriver{
  private:
    const int core=0;
    const int stackSize=8192; //8kB stack memory at each driver
    static int nextID;
    TaskHandle_t handle;
    const unsigned timeOut=1000;
    const int priority=2;
    bool isRunning;
    bool shouldRun;
  public:
    virtual void update()=0;
    virtual void init()=0;
    virtual String generateOut()=0;
    virtual void clear();
    const int ID;
    const String typeName;
    SensorDriver(String);
    bool isAlive();
    void cancel();
    void restart();
    int lastTime;
    void start();
    void stop();
    ~SensorDriver();
    
    
  friend void initaliseDriver(SensorDriver*);
  friend void taskLoop(void*);
  
  
};

//test function which randomly freeze the task
inline void randomFreeze(){
  double pFroze=0.1;
  double limit=RAND_MAX*pFroze;
  if(rand()<limit){
    while(1);
  }else{
    return;
  }
}


#endif
