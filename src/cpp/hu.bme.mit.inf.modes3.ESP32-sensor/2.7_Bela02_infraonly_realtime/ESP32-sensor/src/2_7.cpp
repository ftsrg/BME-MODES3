#define MQTT_KEEPALIVE 15000
#define MQTT_SOCKET_TIMEOUT 15000
#define MQTT_MAX_PACKET_SIZE 512

#include <RealTimeSelect.hpp>
#include <RealTimeLength.h> //Length.Update nem működik 
#include <realtimespeed.hpp>
#include <string>
#include <PubSubClient.h>
#include <WiFi.h>
#include <ArduinoJson.h>
#include <stdlib.h>
//#include <sensor_monitor.h>

#define DEVICE_NAME "Bela02"
#define SSID    "MoDeS3"
#define PASS    "LaborImage"
#define MQTT_IP  "192.168.1.2"
#define MQTT_PT  1883
#define MQTT_US  ""
#define MQTT_PW  ""

#define BDATA_CH "/modes3/data/bela02"
#define CONSOLE_CH "/modes3/console"
#define DATA_CH  "/modes3/data"
#define BEVENT_CH "/modes3/event/bela02"
#define EVENT_CH "/modes3/event"

using namespace std;

//SensorMonitor monitor;

struct HeaderData {
   const char* sender;
   int time;
   char type[10];
};
int getTime() {
  return 100;
}

WiFiClient wifi;

void PongSend();

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.println("Callback running...");
  StaticJsonBuffer<200> json;
  char sender[20];
  char type[10];
  int time;
  JsonObject& root = json.parseObject((char*)payload);
  strcpy(sender, root["sender"]);
  time = root["time"];
  strcpy(type, root["type"]);
  if (!strcmp(type,"Ping")) {
    PongSend();
  }
}

PubSubClient client(wifi);

void PongSend()
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = "Pong";
    root.printTo(json, maxSize);
    Serial.println(json);
    client.publish(BEVENT_CH, json);
    client.publish(EVENT_CH, json);
}
void WifiConnect(){
  Serial.println("");
  Serial.print("Connecting to WiFi");
  WiFi.begin(SSID, PASS);
  while (WiFi.status() != WL_CONNECTED) {
      delay(500);
      Serial.print(".");
  }
  Serial.println("");
  Serial.println("Connected to the WiFi network");
}

void MQTTConnect(){
  client.setServer(MQTT_IP, MQTT_PT);
  while (!client.connected()) {
    Serial.print("Connecting to MQTT");
    for(int i=0; i<3; i++){
      Serial.print(".");
      delay(500);
    }
    if (client.connect(DEVICE_NAME, MQTT_US, MQTT_PW )) {
      Serial.println("");
      Serial.println("Connected to MQTT server");
      client.publish(CONSOLE_CH, "Connected to MQTT server");
    } else {
      Serial.print("failed with state ");
      Serial.println(client.state());
    }
  }
  client.setCallback(callback);
  client.subscribe(DATA_CH);
  client.subscribe(EVENT_CH);
  Serial.print("Message sent.");
}

void ConnCheck(){
  if(WiFi.status() != WL_CONNECTED){
    Serial.println("WiFi connection lost.");
    WifiConnect();
  }
  if(!client.connected()){
    Serial.println("MQTT connection lost.");
    MQTTConnect();
  }
}
void TrainSend(char* train, int kocsiszam)
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = "Train";
    root["counter"] = kocsiszam;
    root["train"] = train;
    root.printTo(json, maxSize);
    client.publish(BDATA_CH, json);
    client.publish(DATA_CH, json);
    Serial.println(json);
}

void EventSend(bool detect, bool direction)
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = "Event";
    if (detect) {
      if (direction) {
        root["detect"] = "Left";
      }
      else {root["detect"] = "Right";}
    }
    else {root["detect"] = "False";}
    //root["direction"] = direction;
    root.printTo(json, maxSize);
    Serial.println(json);
    client.publish(BEVENT_CH, json);
    client.publish(EVENT_CH, json);
}

void SpeedSend(double speed)
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = "Speed";
    root["speed"] = speed;
    root.printTo(json, maxSize);
    client.publish(BDATA_CH, json);
    client.publish(DATA_CH, json);
    Serial.println(json);
}

void LengthSend(double length, int kocsiszam)
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = "Length";
    root["counter"] = kocsiszam;
    root["length"] = length;
    root.printTo(json, maxSize);
    client.publish(BDATA_CH, json);
    client.publish(DATA_CH, json);
    Serial.println(json);
}

/*void DataSend(double speed, int vagondb, double* vagonhosszok)
{
    size_t maxSize = 800;
    char json[maxSize];
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = "Data";
    root["speed"] = speed;
    JsonArray& hosszok = root.createNestedArray("hosszok");
    for (int i=0; i<vagondb; i++) {
      hosszok.add(vagonhosszok[i]);
    }
    root.printTo(json, maxSize);
    Serial.println(json);
    client.publish(BDATA_CH, json);
    client.publish(DATA_CH, json);
}*/

double SecTime(){
    double ret=micros()/1000000.0;
    return ret;
}

const double hossz = 3.178; // sensor distance
const double maxtime=6;
const double prelltime=0.01;
char str[60];
char strg[30];

enum InfSensorState{
  Wait,
  Detect,
  Prell,
  Error
};

class InfSensor{
private:
  const int pin;
  int value;
  InfSensorState state;
  int sindex;
public:
  double DATAstack[20];
  InfSensor(int p):pin(p){}
  bool Update(){
    value=(digitalRead(pin)==0);
    switch (state){
      case Wait:
        if(value!=0){
          state=Detect;
          DATAstack[sindex]=SecTime(); //in
          sindex++;
          DATAstack[sindex]=SecTime(); //"out"
          return true;
        }
        if(value==0){
          state=Wait;
          return false;
        }
        state=Error;
        return false;
      break;
      case Detect:
        if(value==0){
          state=Prell;
          return true;
        }
        if(value!=0){
          state=Detect;
          DATAstack[sindex]=SecTime();  //update
          return true;
        }
        state=Error;
        return true;
      break;
      case Prell:
        if(value!=0){
          state=Detect;
          DATAstack[sindex]=SecTime();  //update
          return true;
        }
        if(value==0&&(SecTime()-DATAstack[sindex]>prelltime)){
          state=Wait;
          sindex++;
          return false;
        }
        state=Prell;
        return true;
      break;
    }
  }
  int GetDex(){
    return sindex;
  }
  int* GetDexP(){
    return &sindex;
  }
  int GetValue(){
    return value;
  }
  bool Reset(){
    value=0;
    sindex=0;
    state=Wait;
  }
  int GetPin(){
    return pin;
  }
  int GetState(){
    return state;
  }
};

InfSensor Sensor[2]={InfSensor(26),InfSensor(27)};
RealTimeSpeed RTSpeed(Sensor[0].GetDexP(),Sensor[0].DATAstack,Sensor[1].GetDexP(),Sensor[1].DATAstack);
RealTimeLength Length(Sensor[0].GetDexP(),Sensor[0].DATAstack,Sensor[1].GetDexP(),Sensor[1].DATAstack);
RealTimeSelect TrainSelect;


void setup() {
  Serial.begin(9600);
  Serial.println("Serial initialized");
  
  WifiConnect();
  MQTTConnect();
  for(int i=0;i<2;i++){
    pinMode(Sensor[i].GetPin(), INPUT);
    Sensor[i].Reset();
  }

  //mért hosszok:
  //Taurus: 20.96, 20.89, 20.86, 20.84 
  //piros vagon: 
  TrainSelect.AddTrain("Taurus",21.5);
  TrainSelect.AddTrain("SNCF",18.5);
  TrainSelect.AddTrain("BR-204",14);
  TrainSelect.AddTrain("Vagon",12.25);

  PongSend();

  //monitor.init();
}

/*double Speed(){
    char irany='0';
    double avgtime=0;
    double deltatime=0;
    double avgspeed=0;
    if(Sensor[0].GetDex()!=Sensor[1].GetDex()) return 0;
    for(int i=0;i<Sensor[0].GetDex();i++){
        avgtime+=(Sensor[0].DATAstack[i]-Sensor[1].DATAstack[i]);
    }
    avgtime=avgtime/Sensor[0].GetDex();
    irany=avgtime>0?'+':'-';
    avgtime=avgtime>0 ? avgtime : -1.0*avgtime;
    avgspeed=hossz/avgtime;
    return avgspeed;
}*/

/*void Lenght(double speed){
  double lenarray[10];
  int lendb=Sensor[0].GetDex()/2;
  for(int i=0;i<lendb;i++){
    lenarray[i]=(Sensor[0].DATAstack[2*i]-Sensor[0].DATAstack[2*i+1]+Sensor[1].DATAstack[2*i]-Sensor[1].DATAstack[2*i+1])/2.0;
    lenarray[i]=lenarray[i]*speed;
    lenarray[i]=lenarray[i]>0 ? lenarray[i] : -1.0*lenarray[i];
    snprintf(str, 40, "%s: %4.1f: Az %d. kocsihossz: %3.1fcm;",DEVICE_NAME, SecTime(),i,lenarray[i]);
    Serial.println(str);
    //client.publish(DATA_CH, str);
    Serial.println("\tMQTT-re kiirva");
  }
  DataSend(speed, lendb, lenarray);
}*/

enum StateMachine{
  Trainwait,
  Firstdetect,
  Traindetect,
  Nextwait,
  Datasend
};
StateMachine state=Trainwait;
bool det[2], detect;
double atime;

int kocsiszam=0;
int tmp=0;
bool tmpb=false;
unsigned long lastLoop = 0;

void loop() {
  ConnCheck();
  if ( millis() - lastLoop > 1000 ) {
    //Serial.println("pubsubloop");
    client.loop();
    lastLoop = millis();
  }
  for(int i=0;i<2;i++){
    det[i]=Sensor[i].Update();
  }
  detect=det[0]||det[1];
  switch(state){
    case Firstdetect:
      state = Traindetect;
      //monitor.start();
      bool direction;
      if(Sensor[0].GetValue()==1){
        direction=false;
      }else{
        direction=true;
      }
      EventSend(true, direction);
    break;
    case Trainwait:
      if(detect==1){
        state=Firstdetect;
      }
    break;
    case Traindetect:
      if(detect==0){
        state=Nextwait;
        atime=SecTime();
      }
    break;
    case Nextwait:
      if(detect==1){
        state=Traindetect;
      }
      if(detect==0&&(SecTime()-atime>maxtime)){
        state=Datasend;
        //double speed=Speed();
        //snprintf(str, 30, "%s: Speed: %fcm/s;", DEVICE_NAME, speed);
        //Serial.println(str);
        //client.publish(DATA_CH, str);
        Serial.println("\tMQTT-re kiirva");
        //Lenght(speed);
        for(int i=0;i<2;i++){
          Sensor[i].Reset();
        }
        kocsiszam = 0;
        Length.Reset();
        RTSpeed.Reset();
      }
    break;
    case Datasend:
      //monitor.stop();
      EventSend(false, false);
      state=Trainwait;
    break;
  }
  tmp++;
  if(RTSpeed.Update()){
    SpeedSend(RTSpeed.GetLastSpeed());
  }
  if(Length.Update(Sensor[0].GetDex(), Sensor[1].GetDex())){
    kocsiszam++;
    LengthSend(Length.GetLastLength(), kocsiszam);
    TrainSend(TrainSelect.Search(Length.GetLastLength()), kocsiszam);
  }
}
