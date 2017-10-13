
#include "sensor_monitor.h"


float convertRawGyro(int gRaw) {
  // since we are using 250 degrees/seconds range
  // -250 maps to a raw value of -32768
  // +250 maps to a raw value of 32767

  float g = (gRaw * 250.0) / 32768.0;

  return g;
}


void updateCallback(void *arg) {
  //Serial.println("collecting color and gyro data...");
  SensorMonitor *moni = static_cast<SensorMonitor *>(arg);
  while(1) {
    moni->update();
    vTaskDelay(1);
  }
}


void printHex(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    //Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    //Serial.print(buffer[i], HEX);
  }
}



void SensorMonitor::update(){
  
    //local variables
    uint16_t red=-1,green=-1,blue=-1;
    int rawX=-1,rawY=-1,rawZ=-1;
    double accX=-1,accY=-1,accZ=-1;
    
    if(running){
      //Serial.println("updating");
      isRunning=true;
      //local variables
      uint16_t red=-1,green=-1,blue=-1;
      int rawX=-1,rawY=-1,rawZ=-1;
      double accX=-1,accY=-1,accZ=-1;
      
      //Serial.println("read sensor data...");

      //save timestamp
      timeStack.push_back(millis());


      //read color sensor
      //Serial.println("read color sensor");
      color.readRedLight(red);
      color.readBlueLight(blue);
      color.readGreenLight(green);

      /*old gyro sensor
      sensors_event_t gyroData;
      gyro.getEvent(&gyroData);
      */

      //read gyro sensor
      //Serial.println("read gyro sensor");
      BMI160.readGyro(rawX, rawY, rawZ);

      accX=convertRawGyro(rawX);
      accY=convertRawGyro(rawY);
      accZ=convertRawGyro(rawZ);

      //read RFID sensor
      //Serial.println("read rfid sensor");

      if ( rfid.PICC_IsNewCardPresent())
        if (rfid.PICC_ReadCardSerial()){
            
          //Serial.println(F("The NUID tag is:"));
          //Serial.print(F("In hex: "));
          prevNUID = String(rfid.uid.uidByte[0]) +" >>> "+ String(rfid.uid.uidByte[1]) +" >>> "+ String(rfid.uid.uidByte[2]) +" >>> "+ String(rfid.uid.uidByte[3]);
          //Serial.println(prevNUID);
          //rfidStack.push_back(prevNUID);
        }

      
      
      
      //Serial.println("saving data...");
      
      gyroXStack.push_back(accX);
      gyroYStack.push_back(accY);
      gyroZStack.push_back(accZ);
      
  
      colorRStack.push_back(red);
      colorBStack.push_back(blue);
      colorGStack.push_back(green);
      
      //Serial.println("data has saved successfully");
      
    }else{
      isRunning=false;
    }
  
}

void SensorMonitor::SensorMonitor() {
  //Serial.println("initialising the sensors...");
  
  xTaskCreatePinnedToCore(updateCallback,"update",50000,this,3,NULL,0);
  
    //initialise the color sensor
    color.init();
    color.enableLightSensor(false);
    
    /*old gyro sensor
     * gyro.begin();
     */
     
    //initialise the gyro sensor
    BMI160.begin(BMI160GenClass::SPI_MODE, ssPinGyro);
    BMI160.setGyroRange(250);
  
    //initialise RFID sensor
    SPI.begin();
    rfid.PCD_Init();
    
    //Serial.println("sensors successfully initialised");
}

void SensorMonitor::start(){
  //Serial.println("start monitoring");
  prevNUID="NONE";
  clear();
  running=true;
}

void SensorMonitor::stop(){
  //Serial.println("stop monitoring...");
  running=false;
  while(isRunning){
    //Serial.println("waiting for core 0");
    delay(5);
  }
  //Serial.println("monitoring has stopped");
}

void SensorMonitor::clear(){
    timeStack.clear();
    colorRStack.clear();
    colorGStack.clear();
    colorBStack.clear();
    gyroXStack.clear();
    gyroYStack.clear();
    gyroZStack.clear();
}

std::list<double> SensorMonitor::getR()const{
  if(!running && !isRunning){
    return colorRStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  while(1);
}

std::list<double> SensorMonitor::getG()const{
  if(!running && !isRunning){
    return colorGStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  while(1);
}

std::list<double> SensorMonitor::getB()const{
  if(!running && !isRunning){
    return colorBStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  while(1);
}

std::list<double> SensorMonitor::getX()const{
  if(!running && !isRunning){
    return colorRStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  while(1);
}

std::list<double> SensorMonitor::getY()const{
  if(!running && !isRunning){
    return colorRStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  while(1);
}

std::list<double> SensorMonitor::getZ()const{
  if(!running && !isRunning){
    return colorRStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  while(1);
}

std::list<int> SensorMonitor::getT()const{
  if(!running && !isRunning){
    return timeStack;
  }
  //baj van a programnak le kell, hogy fagyjon
  //Serial.println("the reading of data has not been stopped");
  //Serial.println("restarting the core");
  while(1);
}

String SensorMonitor::getRFID()const{
  if(!running && !isRunning){
    return prevNUID;
  }
  //baj van a programnak le kell, hogy fagyjon
  //Serial.println("the reading of data has not been stopped");
  //Serial.println("restarting the core");
  while(1);
}



