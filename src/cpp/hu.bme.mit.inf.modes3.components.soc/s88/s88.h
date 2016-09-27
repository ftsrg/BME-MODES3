/* 
 * File:   s88.h
 * Author: zsoltmazlo
 *
 * Created on March 19, 2016, 11:32 AM
 */

#ifndef S88_H
#define	S88_H



/****************************************************************************
 * 
 * functions for S88: S88_Init(), S88_readOccupancy()
 * Interrupt Service Routine for S88: ISR(TIMER1_COMPA_vect)
 * 
 * defines for S88: SOC_CLOCK_TIME_US, SOC_CYCLE_COUNT, 
 *                  S88_PIN_LOAD, S88_PIN_RESET, S88_PIN_CLK, S88_PIN_DATA
 * 
 ***************************************************************************/

/**
 * defines for SOC and S88
 */

#define SOC_CYCLE_COUNT 32

#define SOC_CLOCK_TIME_US 100
#define S88_PIN_LOAD A2
#define S88_PIN_RESET A3
#define S88_PIN_CLK A4
#define S88_PIN_DATA A5

/**
 * setups for S88 communication
 */
void S88_Init();

/**
 * function for getting sections' occupancy
 * 
 * the fucntion is appling the S88 communication standard to get section's 
 * occupancy and returning an 32 bit wide long where
 * section #31 is the MSB
 * and section #0 is the LSB
 *
 */
uint32_t S88_readOccupancy();


#endif	/* S88_H */

