/* 
 * File:   masterServices.h
 * Author: zsoltmazlo
 *
 * Created on 2014. augusztus 14., 15:21
 */

#ifndef MASTERSERVICES_H
#define	MASTERSERVICES_H

#include "kv_commands.h"
#include "main.h"


#include <Ethernet.h>
#include <EthernetUdp.h>

#define SERIAL_BAUD_RATE 9600

/**
 * setups for UDP communication
 */
void UDP_init();


#ifdef SC_FUNCTIONALITY


#include <Wire.h>
#define I2C_MAX_SLAVE_COUNT 0x20

/**
 * reading analog values of turnout
 * 
 * @param turnout turnout's ID
 * @param value1 an pointer to write analog value #1
 * @param value2 an pointer to write analog value #1
 * @return 0, if readout was successful, -1 if turnout is not found
 */
int readTurnoutStatus(byte turnout, int* value1, int* value2);

/**
 * Inicialize I2C communication and testing all address over I2C
 * 
 * Uses Serial communication to debug, if its not setted up then
 * it sets up
 * @param addr master's address for I2C communication (use MASTER_ADDRESS constant!)
 */
void I2C_init(byte addr);

/**
 * Communicate with I2C slave which hold address for I2C address
 * and send the message given by parameters.
 * 
 * if slave is not reacheble at the reset of the master, then the
 * function is halted
 * 
 * @param addr slave's address
 * @param message byte array of message
 * @param length length of message-array
 */
void I2C_sendMessage(byte address, byte* message, byte length);


/**
 * function for setting section's status (enabled or disabled for transportation)
 * via UDP (or locally)
 * 
 * if the given section is found locally (accessed by the master), then it sends
 * the command via I2C
 * byte order:
 *  - command: COMMAND_LINE_ENABLE or COMMAND_LINE_DISABLE
 *  - section's ID
 *  - master's address
 * 
 * @param section
 * @param isEnabled
 */
void UDP_setSectionStatus(byte section, boolean isEnabled);

/**
 * function for sending section's status (enabled or disabled for transportation)
 * via UDP
 * 
 * the function get's the section's ID, and it decides it could send back
 * valid data or won't (if it connected to the section, then it could)
 * 
 * if not, then the function halt, otherwise sending the data via UDP
 * byte order:
 *  - COMMAND_LINE_STATUS
 *  - section ID
 *  - status (1 if disabled, 0 if enabled)
 *  - master's address
 * 
 * @param section section's ID we are interested in
 * @param requester UDP destionation IP
 * @param port UDP port
 */
void UDP_sendSectionStatus(byte section, IPAddress requester, int port);

/**
 * function for sending turnout's status (Voltage measurement both branches)
 * via UDP
 * 
 * the function get's the turnout's ID, and it decides it could send back
 * valid data or won't (if it connected to the turnout, then it could)
 * 
 * if not, then the function halt, otherwise sending the data via UDP
 * byte order:
 *  - COMMAND_SEND_TURNOUT_STATUS
 *  - turnout ID
 *  - measurement value #1
 *  - measurement value #2
 *  - master's address
 * 
 * The measured values could not decide which brach are belongs them,
 * so the requester should know the order (usually by visual response)
 * 
 * @param turnout turnout's ID we are interested in
 * @param requester UDP destionation IP
 * @param port UDP port
 */
void UDP_sendTurnoutStatus(byte turnout, IPAddress requester, int port);

/**
 * function for sending reachable sections' via UDP
 * 
 * the function is send all the reachable sections' ID. If count of them is 
 * lower then 4, then the remaining bytes are all 0.
 * byte order:
 *  - COMMAND_SEND_STATUS_LIST
 *  - #1 section's ID (0, section's count 0)
 *  - #2 section's ID (0, section's count 1)
 *  - #3 section's ID (0, section's count 2)
 *  - #4 section's ID (0, section's count 3)
 *  - master's address
 *  
 * @param requester UDP destionation IP
 * @param port UDP port
 */
void UDP_sendSectionList(IPAddress requester, int port);

#endif

#ifdef SOC_FUNCTIONALITY

#define SOC_CLOCK_TIME_US 100

#define SOC_CYCLE_COUNT 8*3

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
 * @return 32 bit wide long of sections' occupancy
 */
unsigned long S88_readOccupancy();


/**
 * function for sending sections' occupancy via UDP
 * 
 * the function is read out occupancy from occupancy-devices via S88
 * then send it to the requiester
 * byte order:
 *  - COMMAND_SEND_OCCUPANCY
 *  - section #31 - #24
 *  - section #23 - #16
 *  - section #15 - #8
 *  - section #7  - #0
 *  - master's address
 * 
 * @param requester UDP destionation IP
 * @param port UDP port
 */
void UDP_sendOccupancy(IPAddress requester, int port);

#endif

#endif	/* MASTERSERVICES_H */

