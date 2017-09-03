
#define MQTT_KEEPALIVE 15000
#define MQTT_SOCKET_TIMEOUT 15000
#define MQTT_MAX_PACKET_SIZE 512

#include <string>
#include <PubSubClient.h>
#include <WiFi.h>
#include <ArduinoJson.h>
//#include <sensor_monitor.h>

#define DEVICE_NAME "Bela02"
#define SSID    "MoDeS3"
#define PASS    "LaborImage"
#define MQTT_IP  "92.222.64.167"
#define MQTT_PT  1883
#define MQTT_US  ""
#define MQTT_PW  ""

#define CONSOLE_CH "/modes3/console"
#define DATA_CH  "/modes3/data"
#define FLAG_CH "/modes3/flag"

#define T_SPEED 4
#define T_DATA 3
#define T_FLAG 2
#define T_PONG 1
#define T_PING 0

using namespace std;

//SensorMonitor monitor;

struct HeaderData {
   const char* sender;
   int time;
   int type;
};
int getTime() {
  return 100;
}

WiFiClient wifi;
PubSubClient client(wifi);

bool HeaderDeser(HeaderData& data, char* json)
{
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& root = jsonBuffer.parseObject(json);
    data.sender = root["sender"];
    data.time = root["time"];
    data.type = root["type"];
    return root.success();
}

void PingSer(char* json, bool pong=false)
{
    size_t maxSize=100;
    DynamicJsonBuffer jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    if(pong){ root["type"] = T_PONG;
    }else{root["type"] = T_PING;}
    root.printTo(json, maxSize);
}

void callback(char* topic, byte* payload, unsigned int length) {
    HeaderData header;
    HeaderDeser(header, (char*)payload);
    switch(header.type){
        case T_PING:
          char pong[100];
          PingSer(pong,false);
          client.publish(DATA_CH,pong);
        break;
        case T_FLAG:
        break;
        case T_DATA:
        break;
    }
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
  client.subscribe(DATA_CH);
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

void FlagSend(bool detect, bool direction)
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = T_FLAG;
    root["detect"] = detect;
    root["direction"] = direction;
    root.printTo(json, maxSize);
    Serial.println(json);
    client.publish(FLAG_CH, json);
}

void SpeedSend(double speed)
{
    char json[800];
    size_t maxSize = 800;
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = T_SPEED;
    root["speed"] = speed;
    root.printTo(json, maxSize);
    client.publish(DATA_CH, json);
}

void DataSend(double speed, int vagondb, double* vagonhosszok)
{
    size_t maxSize = 800;
    char json[maxSize];
    StaticJsonBuffer<800> jsonBuffer;
    JsonObject& root = jsonBuffer.createObject();
    root["sender"] = DEVICE_NAME;
    root["time"] = getTime();
    root["type"] = T_DATA;
    root["speed"] = speed;
    JsonArray& hosszok = root.createNestedArray("hosszok");
    for (int i=0; i<vagondb; i++) {
      hosszok.add(vagonhosszok[i]);
    }
    root.printTo(json, maxSize);
    Serial.println(json);
    client.publish(DATA_CH, json);
}

double SecTime(){
    double ret=micros()/1000000.0;
    return ret;
}

const double hossz = 3.178; // sensor distance
const double maxtime=4;
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

void setup() {
  Serial.begin(9600);
  Serial.println("Serial initialized");
  
  WifiConnect();
  MQTTConnect();
  for(int i=0;i<2;i++){
    pinMode(Sensor[i].GetPin(), INPUT);
    Sensor[i].Reset();
  }

  //monitor.init();
}

double Speed(){
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
}

void Lenght(double speed){
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
}

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

int tmp=0;

void loop() {
  ConnCheck();
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
      FlagSend(true, direction);
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
        double speed=Speed();
        snprintf(str, 30, "%s: Speed: %fcm/s;", DEVICE_NAME, speed);
        Serial.println(str);
        //client.publish(DATA_CH, str);
        Serial.println("\tMQTT-re kiirva");
        Lenght(speed);
        for(int i=0;i<2;i++){
          Sensor[i].Reset();
        }
      }
    break;
    case Datasend:
      //monitor.stop();
      FlagSend(false, false);
      state=Trainwait;
    break;
    return;
  }
}
