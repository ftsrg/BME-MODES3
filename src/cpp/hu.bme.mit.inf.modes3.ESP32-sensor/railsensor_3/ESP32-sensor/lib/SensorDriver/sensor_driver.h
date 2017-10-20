
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


void debugOut(const char* );


class SensorDriver{
  private:
    const int core=0;
    static int nextID;
    TaskHandle_t handle;
    const unsigned timeOut=100;
    const int priority=0;
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


#endif
