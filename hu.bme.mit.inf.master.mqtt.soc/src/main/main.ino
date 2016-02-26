/**
 * includes for MQTT
 */
#include <Ethernet.h>
#include <IPStack.h>
#include <Countdown.h>
#include <MQTTClient.h>

/**
 * include for serial debug
 */
#include <SPI.h>

/**
 * defines for MQTT and debug
 */
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

/************************************************************************************
 * 
 * functions for MQTT: messageArrived(MQTT:MessageData&), connect(), sendOccupancy()
 * 
 * defines for MQTT: SOC_REFRESH_WAIT
 *                  
 * global variables for MQTT: MQTT_PACKET_SIZE, c, ipstack, client, mac[], ip,
 *                            clientId, hostname, topic, port
 * 
 ************************************************************************************/

const byte MQTT_PACKET_SIZE = 200;

EthernetClient c;
IPStack ipstack(c);
MQTT::Client<IPStack, Countdown, MQTT_PACKET_SIZE, 1> client = MQTT::Client<IPStack, Countdown, MQTT_PACKET_SIZE, 1>(ipstack);

//            K     V     192   168   1     160
byte mac[] = {0x5B, 0x56, 0xC0, 0xA8, 0x01, 0xA0};
IPAddress ip(192, 168, 0, 160);

const char* clientId = "arduinoSOC";
const char* hostname = "192.168.0.120";
const char* topic = "modes3/kvcontrol";
const int port = 1883;

void messageArrived(MQTT::MessageData& md)
{
  
}

/**
 * MQTT connect
 */
void connect()
{
  Serial.print("Connecting to ");
  Serial.print(hostname);
  Serial.print(":");
  Serial.println(port);
 
  byte rc = ipstack.connect((char*)hostname, (int)port);
  Serial.println("MQTT connecting");
  
  MQTTPacket_connectData data = MQTTPacket_connectData_initializer;       
  data.MQTTVersion = 3;
  data.clientID.cstring = (char*)clientId;
  rc = client.connect(data);
  Serial.println("MQTT connected");
  
  rc = client.subscribe(topic, MQTT::QOS1, messageArrived);   
  Serial.println("MQTT subscribed");
}

/**
 * send occupancy through MQTT
 */
void sendOccupancy(){
  // read the occupancy into the sensor global variable
  S88_readOccupancy();

  // sensor = 4294967295; // debug value, all sections are occupied

  // create the occupancy JSON structure
  // sample: {"command":"SEND_OCCUPANCY","content":"{\"occupancyVector\":[1,2,3,4]}"}
  String base = "{\"command\":\"SEND_OCCUPANCY\",\"content\":\"{\\\"occupancyVector\\\":[";
  
  // we transfer 4 bytes always
  for (byte i = 0; i < 4; i++) {
     // cut the lowest 8 bits
     byte tmp = sensor & 0xFF;
     base.concat(tmp);
     if(i < 3){
      base.concat(",");
     }
     // shift the sensor with 8 bits
     sensor >>= 8;
  }
  base.concat("]}\"}");


  int len = base.length()+1;
  char buf[len];
  base.toCharArray(buf,len);
  Serial.println(buf);

  // send the json over MQTT
  MQTT::Message message;
  message.qos = MQTT::QOS1;
  message.retained = false;
  message.dup = false;

  message.payload = (void*)buf;
  message.payloadlen = strlen(buf);

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
  Ethernet.begin(mac, ip);
  connect(); 
  // initialize S88 protocol for getting the sections occupancies
  S88_Init();
 
  delay(100);
}

void loop() {
  sendOccupancy();
  delay(SOC_REFRESH_WAIT);
}
