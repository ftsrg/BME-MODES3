
#ifndef GYRO_DRIVER
#define GYRO_DRIVER

#include "sensor_driver.h"
#include <BMI160Gen.h>


struct GyroData{
  int accX;
  int accY;
  int accZ;
  int timeStamp;
  bool valid;
};


typedef std::list<GyroData> GyroList;

class GyroDriver : public SensorDriver{
  private:
    GyroList data;
    const int ssPinGyro=14;
  public:
    void init();
    void update();
    String generateOut();
    void clear();
    GyroDriver();
};


#endif
