#include "Arduino.h"
#include "s88.h"


// occupancy is stored in one vector
uint32_t sensor = 0; // 32 bits = 32 sections! (now: 15 sections + 6 turnouts = 21 bits)

// cycle counter for storing the remaining cycles to be generated
uint8_t cycleCounter = 0;

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
		// This number should be the same with, as the incoming data width
		// E.g. 4 section sensor = 32 bit of data
                sensor |= 0x80000000;
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
uint32_t S88_readOccupancy() {
    // load is necessary until 240us
    digitalWrite(S88_PIN_LOAD, HIGH);
    delayMicroseconds(240);

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
    delayMicroseconds(240);
    TCNT1 = 0;
    interrupts();
    digitalWrite(S88_PIN_LOAD, LOW);

    // wait for reading to be completed
    delayMicroseconds((SOC_CYCLE_COUNT + 2) * SOC_CLOCK_TIME_US);
    
    // return with occ. vector
    return sensor;
}