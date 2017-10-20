
#ifndef COLOR_DRIVER
#define COLOR_DRIVER

#include "sensor_driver.h"
#include <SparkFun_APDS9960.h>

struct ColorData{
  int timeStamp;
  uint16_t red;
  uint16_t green;
  uint16_t blue;
  bool valid;
};

typedef std::list<ColorData> ColorList;

class ColorDriver : public SensorDriver{
  private:
    ColorList data;
    SparkFun_APDS9960 color=SparkFun_APDS9960();
  public:
    void init();
    void update();
    void clear();
    ColorDriver();
    String generateOut();
};


#endif
