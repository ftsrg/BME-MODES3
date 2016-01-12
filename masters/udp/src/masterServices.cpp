#include "masterServices.h"

#ifdef MASTER_ADDRESS


// Enter a MAC address and IP address for your controller below.
// The IP address will be dependent on your local network:
//            K     V     192   168   1     0x83
byte mac[] = {0x5B, 0x56, 0xC0, 0xA8, 0x01, MASTER_ADDRESS};
IPAddress ip(192, 168, 1, MASTER_ADDRESS);
unsigned int port = 8888;
IPAddress broadcast(192, 168, 1, 255);

// An EthernetUDP instance to let us send and receive packets over UDP
EthernetUDP Udp;

// buffers for receiving and sending data
byte UDP_packetBuffer[UDP_TX_PACKET_MAX_SIZE]; //buffer to hold incoming packet,

void UDP_init() {
    Ethernet.begin(mac, ip);
    Udp.begin(port);
}

#endif

#ifdef SC_FUNCTIONALITY


/**
 * holding slave addresses
 */
byte slave_addresses[I2C_MAX_SLAVE_COUNT];

/**
 * holding how many slave could we reach
 */
byte slave_count = 0;

byte I2C_tmp;

byte I2C_buffer[8];

volatile boolean I2C_waitResponse = false;

void I2C_receiveEvent(int bytes) {
    if (Wire.available() != 0) {
//        Serial.println("Received on Wire");
        for (int i = 0; i < bytes; i++) {
            I2C_tmp = Wire.read();
//            Serial.println(I2C_tmp, HEX);
            I2C_buffer[i] = I2C_tmp;
        }

        // if the command was 0xC0, which means the slave send back
        // he's address, then we should store it
        switch (I2C_buffer[1]) {
            case COMMAND_IDENTIFY:
                Serial.print("Storing slave's address: 0x");
                Serial.println(I2C_buffer[0], HEX);
                slave_addresses[slave_count++] = I2C_buffer[0];
                break;

            case COMMAND_GET_SECTION_STATUS:
                I2C_waitResponse = false;
                break;
        }
    }
}

void I2C_init(byte addr) {

    Wire.begin(addr);
    Wire.onReceive(I2C_receiveEvent);

    delay(100);
    for (byte i = 0; i < I2C_MAX_SLAVE_COUNT; i++) {

        Serial.print("Testing: 0x");
        Serial.println(i, HEX);

        // Attempting to Communicate with slaves 
        Wire.beginTransmission(i);
        Wire.write(COMMAND_IDENTIFY);
        Wire.write(addr);
        Wire.endTransmission();

        // wait 100ms to finish communication
        delay(100);
    }
}

void I2C_sendMessage(byte address, byte* message, byte length) {
    Wire.beginTransmission(address);
    for (byte i = 0; i < length; i++) {
        Wire.write(*(message++));
    }
    Wire.endTransmission();
}

void UDP_setSectionStatus(byte section, boolean isEnabled) {
    for (byte i = 0; i < slave_count; i++) {

        if (section == slave_addresses[i]) {

            // its enough only 1 byte of message
            byte message[1];

            if (isEnabled) {
                message[0] = COMMAND_LINE_ENABLE;
            } else {
                message[0] = COMMAND_LINE_DISABLE;
            }

            // sending command
            I2C_sendMessage(section, message, 1);

            break;

        } // if slave_address
    }
}

void UDP_sendSectionStatus(byte section, IPAddress requester, int port) {
    for (byte i = 0; i < slave_count; i++) {

        if (section == slave_addresses[i]) {
            
//            Serial.println("UDP_sendSectionStatus");

            // its enough only 1 byte of message
            byte message[1] = {COMMAND_GET_SECTION_STATUS};

            // sending command
            I2C_waitResponse = true;
            I2C_sendMessage(section, message, 1);

            // wait until response get
            while (I2C_waitResponse);

            UDP_packetBuffer[0] = COMMAND_SEND_SECTION_STATUS;
            UDP_packetBuffer[1] = section;
            UDP_packetBuffer[2] = I2C_buffer[2];
            UDP_packetBuffer[3] = MASTER_ADDRESS;
            Udp.beginPacket(requester, port);
            Udp.write(UDP_packetBuffer, 3);
            Udp.endPacket();

            break;

        } // if slave_address
    }
}

void UDP_sendTurnoutStatus(byte turnout, IPAddress requester, int port) {

    int sw1 = 0, sw2 = 0;
    int response = readTurnoutStatus(turnout, &sw1, &sw2);
    if (response == 0) {
        UDP_packetBuffer[0] = COMMAND_SEND_TURNOUT_STATUS;
        UDP_packetBuffer[1] = turnout;
        UDP_packetBuffer[2] = (byte) map(sw1, 0, 1023, 0, 255);
        UDP_packetBuffer[3] = (byte) map(sw2, 0, 1023, 0, 255);
        UDP_packetBuffer[4] = MASTER_ADDRESS;
        // csomag inicializálása, 4 byte írása
        Udp.beginPacket(requester, port);
        Udp.write(UDP_packetBuffer, 5);
        Udp.endPacket();
    }
}

void UDP_sendSectionList(IPAddress requester, int port) {

    UDP_packetBuffer[0] = COMMAND_SEND_SECTION_LIST;
    UDP_packetBuffer[1] = slave_addresses[0];
    UDP_packetBuffer[2] = slave_addresses[1];
    UDP_packetBuffer[3] = slave_addresses[2];
    UDP_packetBuffer[4] = slave_addresses[3];
    UDP_packetBuffer[5] = MASTER_ADDRESS;

    Udp.beginPacket(requester, port);
    Udp.write(UDP_packetBuffer, 4);
    Udp.endPacket();
}

#endif

#ifdef SOC_FUNCTIONALITY

void S88_Init() {
    /**
     * beállítjuk az S88-hoz tartozó be-kimenő portokat
     */
    pinMode(S88_PIN_LOAD, OUTPUT);
    pinMode(S88_PIN_RESET, OUTPUT);
    pinMode(S88_PIN_CLK, OUTPUT);
    pinMode(S88_PIN_DATA, INPUT);

    // reset, load, clk kezdetben legyenek alacsonyak --> nincs kommunikáció
    digitalWrite(S88_PIN_RESET, LOW);
    digitalWrite(S88_PIN_LOAD, LOW);
    digitalWrite(S88_PIN_CLK, LOW);

    /**
     * beállítjuk az órajel generálásához szükséges Timert
     * periódusidő: clockTimeUS változó
     * pl. ISR timeout: 250us (így 500us a ciklusidő -> 2 felfutóél/ms
     */
    noInterrupts();
    TCCR1A = 0;
    TCCR1B = 0;
    TCNT1 = 0;
    TCCR1B |= (1 << WGM12); // CTC mode

    /** elősztás
     *  CS12 CS11 CS10
     *  0    0    0 nincs clock
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

// ebben tároljuk a nyolc adatot
unsigned long sensor = 0; // 32 bit: 32 szakasz! (most: 15 szakasz + 6 váltó)

// ciklusszámláló, amely tárolja a még hátralévő generálandó ciklusok számát
byte cycleCounter = 0;

ISR(TIMER1_COMPA_vect) {

    /// órajel akkor van, amikor engedélyezve van az
    digitalWrite(S88_PIN_CLK, digitalRead(S88_PIN_CLK)^1);
    // ha lefutóélről beszélünk
    if (digitalRead(S88_PIN_CLK) == LOW) {

        // az adatok shifteléséhez továbbra is countert hasznáknuk
        if (cycleCounter > 0) {
            cycleCounter--;

            // mindenképp shiftelünk egyet, ha van jel ha nem
            sensor >>= 1;
            // ha az adaton van jel, akkor shifteljünk egy egyest a cuccos végére
            if (digitalRead(S88_PIN_DATA)) {
                sensor |= 0x800000;
            }
        }
    }
}

unsigned long S88_readOccupancy() {
    // load 240us-ig kell
    digitalWrite(S88_PIN_LOAD, HIGH);
    delayMicroseconds(100);

    // reset jel 120us-sel a load után, 50us-ig
    // reset előtt állítsuk le a ciklusgenerálást egészen reset lefutásáig
    noInterrupts();
    // nullázuk a sensort az új adatok miatt
    sensor = 0;
    // a generálandó ciklusokat beállítjuk
    cycleCounter = SOC_CYCLE_COUNT;
    digitalWrite(S88_PIN_CLK, LOW);
    delayMicroseconds(50);
    digitalWrite(S88_PIN_RESET, HIGH);
    delayMicroseconds(50);
    digitalWrite(S88_PIN_RESET, LOW);


    // 240us-re kiegészít, majd LOAD LOW
    delayMicroseconds(20);
    TCNT1 = 0;
    interrupts();
    digitalWrite(S88_PIN_LOAD, LOW);

    // megvárjuk, amíg az olvasás megtörténik
    delayMicroseconds((SOC_CYCLE_COUNT + 2) * SOC_CLOCK_TIME_US);

    return sensor;
}

void UDP_sendOccupancy(IPAddress requester, int port) {
    
    unsigned long sensor = S88_readOccupancy();
   
    UDP_packetBuffer[0] = COMMAND_SEND_OCCUPANCY;
    UDP_packetBuffer[5] = MASTER_ADDRESS;
    
    Serial.println("-----------");

    // 4 byte-t küldünk el mindig
    for (byte i = 0; i < 4; i++) {
        // levágjuk az alsó 8 bitet, és ezt visszük át
        byte tmp = sensor & 0xFF;
        // eltesszük az így kapott számot a bufferbe
        UDP_packetBuffer[i + 1] = tmp;
        // elshifteljük a sensort 8 bittel
        sensor >>= 8;
    }

    // csomag inicializálása
    Udp.beginPacket(requester, port);
    Udp.write(UDP_packetBuffer, 6);
    Udp.endPacket();
}

#endif


