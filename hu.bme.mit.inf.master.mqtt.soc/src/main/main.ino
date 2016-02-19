/**
 * includes for MQTT
 */
#include <StackTrace.h>
#include <Countdown.h>
#include <FP.h>
#include <MQTTUnsubscribe.h>
#include <MQTTConnect.h>
#include <MQTTClient.h>
#include <MQTTPublish.h>
#include <WifiIPStack.h>
#include <MQTTSubscribe.h>
#include <IPStack.h>
#include <MQTTFormat.h>
#include <MQTTLogging.h>
#include <MQTTPacket.h>
#include <Ethernet.h>

#include <ArduinoJson.h>

/**
 * include for serial debug
 */
#include <SPI.h>

/**
 * defines for MQTT and debug
 */
#define MQTT_PACKET_SIZE 256
#define SOC_REFRESH_WAIT 200
#define SERIAL_BAUD_RATE 9600


/**
 * defines for SOC and S88
 */
#define SOC_CLOCK_TIME_US 100
#define SOC_CYCLE_COUNT 8*3

#define S88_PIN_LOAD A2
#define S88_PIN_RESET A3
#define S88_PIN_CLK A4
#define S88_PIN_DATA A5

/****************************************************************************
 * 
 * functions for S88: S88_Init(), S88_readOccupancy()
 * Interrupt Service Routine for S88: ISR(TIMER1_COMPA_vect)
 * 
 * defines for S88: SOC_CLOCK_TIME_US, SOC_CYCLE_COUNT, 
 *                  S88_PIN_LOAD, S88_PIN_RESET, S88_PIN_CLK, S88_PIN_DATA
 *                  
 * global variables for S88: sensor, cycleCounter, occupancyBuffer
 * 
 ***************************************************************************/

// occupancy is stored in one vector
unsigned long sensor = 0; // 32 bits = 32 sections! (now: 15 sections + 6 turnouts = 21 bits)

// cycle counter for storing the remaining cycles to be generated
byte cycleCounter = 0;
 
/**
 * setups for S88 communication
 */
void S88_Init() {
    /**
     * setup ports for S88
     */
    pinMode(S88_PIN_LOAD, OUTPUT);
    pinMode(S88_PIN_RESET, OUTPUT);
    pinMode(S88_PIN_CLK, OUTPUT);
    pinMode(S88_PIN_DATA, INPUT);

    // reset, load, clk are initially low --> no communication
    digitalWrite(S88_PIN_RESET, LOW);
    digitalWrite(S88_PIN_LOAD, LOW);
    digitalWrite(S88_PIN_CLK, LOW);

    /**
     * Timer setup
     * cycle duration: variable called clockTimeUS
     * pl. ISR timeout: 250us (so cycle period is 500us -> 2 rising edges/ms
     */
    noInterrupts();
    TCCR1A = 0;
    TCCR1B = 0;
    TCNT1 = 0;
    TCCR1B |= (1 << WGM12); // CTC mode

    /** prescale
     *  CS12 CS11 CS10
     *  0    0    0 no clock
     *  0    0    1 clk/1
     *  0    1    0 clk/8
     *  0    1    1 clk/64
     *  1    0    0 clk/256
     *  1    0    1 clk/1024
     *  1    1    0 ext clk T1-pinen (falling edge)
     *  1    1    1 ext clk T1-pinen (rise edge)
     */
    TCCR1B |= (1 << CS11) | (1 << CS10); // 64 prescaler -> 250kHz
    OCR1A = 12; // 20 kHz kell -> 250/20 = 12
    TIMSK1 |= (1 << OCIE1A); // enable timer compare interrupt

    interrupts();
}

ISR(TIMER1_COMPA_vect) {

    // clock is, when it is enabled
    digitalWrite(S88_PIN_CLK, digitalRead(S88_PIN_CLK)^1);
    // if it is a falling edge
    if (digitalRead(S88_PIN_CLK) == LOW) {

        // for shifting the data we still use counter
        if (cycleCounter > 0) {
            cycleCounter--;

            // we always shift one, even there is no signal
            sensor >>= 1;
            // if there is a signal on the DATA, we shift the thing to the end
            if (digitalRead(S88_PIN_DATA)) {
                sensor |= 0x800000;
            }
        }
    }
}

/**
 * function for getting sections' occupancy
 * 
 * the fucntion is appling the S88 communication standard to get section's 
 * occupancy and returning an 32 bit wide long where
 * section #31 is the MSB
 * and section #0 is the LSB
 *
 */
void S88_readOccupancy() {
    // load is neccessary until 240us
    digitalWrite(S88_PIN_LOAD, HIGH);
    delayMicroseconds(100);

    // reset signal 120us after the load, for 50us
    // disable the cycle generation before reset, until the reset completes
    noInterrupts();
    // null the sensor, because of new data
    sensor = 0;
    // setup the cycles to be generated
    cycleCounter = SOC_CYCLE_COUNT;
    digitalWrite(S88_PIN_CLK, LOW);
    delayMicroseconds(50);
    digitalWrite(S88_PIN_RESET, HIGH);
    delayMicroseconds(50);
    digitalWrite(S88_PIN_RESET, LOW);

    // extends for 240us, after that LOAD LOW
    delayMicroseconds(20);
    TCNT1 = 0;
    interrupts();
    digitalWrite(S88_PIN_LOAD, LOW);

    // wait for reading to be completed
    delayMicroseconds((SOC_CYCLE_COUNT + 2) * SOC_CLOCK_TIME_US);
}

/****************************************************************************
 * 
 * functions for MQTT:
 * 
 * defines for MQTT: 
 *                  
 * global variables for MQTT: 
 * 
 ***************************************************************************/

EthernetClient c;
IPStack ipstack(c);
MQTT::Client<IPStack, Countdown, MQTT_PACKET_SIZE, 1> client = MQTT::Client<IPStack, Countdown, MQTT_PACKET_SIZE, 1>(ipstack);

//            K     V     192   168   1     160
byte mac[] = {0x5B, 0x56, 0xC0, 0xA8, 0x01, 0xA0};

const char* clientId = "arduinoSOC";
const char* hostname = "localhost";
const char* topic = "modes3/kvcontrol";
const int port = 1883;

/**
 * MQTT connect
 */
void connect()
{
  Serial.print("Connecting to ");
  Serial.print(hostname);
  Serial.print(":");
  Serial.println(port);
 
  int rc = ipstack.connect((char*)hostname, (int)port);
  if (rc != 1)
  {
    Serial.print("rc from TCP connect is ");
    Serial.println(rc);
  }
 
  Serial.println("MQTT connecting");
  MQTTPacket_connectData data = MQTTPacket_connectData_initializer;       
  data.MQTTVersion = 3;
  data.clientID.cstring = (char*)clientId;
  rc = client.connect(data);
  if (rc != 0)
  {
    Serial.print("rc from MQTT connect is ");
    Serial.println(rc);
  }
  Serial.println("MQTT connected");
  
  rc = client.subscribe(topic, MQTT::QOS2, messageArrived);   
  if (rc != 0)
  {
    Serial.print("rc from MQTT subscribe is ");
    Serial.println(rc);
  }
  Serial.println("MQTT subscribed");
}

/**
 * send occupancy through MQTT
 */
void sendOccupancy(){
  // read the occupancy into the sensor global variable
  S88_readOccupancy();
  
  // Memory pool for JSON object tree.
  //
  // Inside the brackets, MQTT_PACKET_SIZE is the size of the pool in bytes,
  // If the JSON object is more complex, you need to increase that value.
  StaticJsonBuffer<MQTT_PACKET_SIZE> jsonBuffer;

  // create the occupancy JSON structure
  // sample: {"command":"SEND_OCCUPANCY","content":"{\"sections\":[{\"id\":12,\"occupancyStatus\":\"FREE\"},{\"id\":13,\"occupancyStatus\":\"OCCUPIED\"}]}"}
  JsonObject& root = jsonBuffer.createObject();
  root["command"] = "SEND_OCCUPANCY";
  JsonObject& content = root.createNestedObject("content");
  JsonArray& sections = content.createNestedArray("sections");
  
  unsigned byte offset = 1;
  for(offset = 1; offset < 0x18; ++offset){
    JsonObject& section = sections.createNestedObject();
    section["id"] = id;
    
    if(((sensor & (1 << offset)) >> offset) == 1){
      section["occupancyStatus"] = "OCCUPIED";
    } else{
      section["occupancyStatus"] = "FREE";
    }
  }

  // send the json over MQTT
  MQTT::Message message;
  message.qos = MQTT::QOS1;
  message.retained = false;
  message.dup = false;
  
  char buf[MQTT_PACKET_SIZE];
  root.printTo(buf, sizeof(buf));
  
  message.payload = (void*)buf;
  message.payloadlen = strlen(buf)+1;

  if (!client.isConnected())
    connect();
  client.publish(topic, message);
}

/**
 * Arduino SETUP
 */
void setup() {
  // initialize serial debug
  Serial.begin(SERIAL_BAUD_RATE);
  // connect to MQTT
  Ethernet.begin(mac);
  connect(); 
  // initialize S88 protocol for getting the sections occupancies
  S88_Init();
 
  delay(100);
}

void loop() {
  sendOccupancy();
  delay(SOC_REFRESH_WAIT);
}
