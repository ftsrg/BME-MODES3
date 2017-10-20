

#ifndef FORCE_DRIVER
#define FORCE_DRIVER

#include "sensor_driver.h"

struct ForceData{
  int timeStamp;
  int force;
  bool valid;
};

typedef std::list<ForceData> ForceList;

class ForceDriver : public SensorDriver{
  private:
    const int forcePin=25;
    ForceList data;
  public:
    ForceDriver();
    void init();
    void update();
    void clear();
    String generateOut();
};

#endif
