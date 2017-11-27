#include <Wire.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_LSM303_U.h>
#include <SparkFun_APDS9960.h>
#include <BMI160Gen.h>
#include <algorithm>
#include <list>
#include <SPI.h>
#include <MFRC522.h>



#ifndef SENSOR_MONITOR
#define SENSOR_MONITOR



class SensorMonitor{
  private:
    Adafruit_LSM303_Accel_Unified gyro=Adafruit_LSM303_Accel_Unified(54321);
    SparkFun_APDS9960 color=SparkFun_APDS9960();
    MFRC522 rfid;
    MFRC522::MIFARE_Key key;
    const int coreID=1;
    const int ssPinGyro=16;
    const int ssPinRFID=5;
    const int rstPinRFID=17;
    bool running;
    bool isRunning=false;
    std::list<double> colorRStack;
    std::list<double> colorGStack;
    std::list<double> colorBStack;
    std::list<double> gyroXStack;
    std::list<double> gyroYStack;
    std::list<double> gyroZStack;
    std::list<int> timeStack;
    std::list<String> rfidStack;
  public:
    String prevNUID;
    SensorMonitor();
    void start();
    void stop();
    void clear();
    std::list<double> getR() const;
    std::list<double> getG() const;
    std::list<double> getB() const;
    std::list<double> getX() const;
    std::list<double> getY() const;
    std::list<double> getZ() const;
    std::list<int> getT() const;
    String getRFID() const;
    void update();
};


#endif
