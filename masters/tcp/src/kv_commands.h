/* 
 * File:   i2c_commands.h
 * Author: zsoltmazlo
 *
 * Created on 2014. július 8., 19:02
 */

#ifndef KV_COMMANDS_H
#define	KV_COMMANDS_H

#ifdef	__cplusplus
extern "C" {
#endif

    /**
     * commands in I2C communication
     * both the masters and the slaves need to know about these commands
     *
     */

    /**
     * COMMAND_IDENTIFY: master unit sends this command if he wants to intruduce
     * itself for slaves
     *
     * parameters: master's address
     */
#define COMMAND_IDENTIFY 0xC0

    /**
     * COMMAND_LINE_DISABLE: master unit sends this command if he want to 
     * shut down a section (like "stop the train")
     * 
     * when this command sends out, then the given section
     * could not use for transportation
     *
     * parameters: none, the slave identification managed by I2C addressing
     */
#define COMMAND_LINE_DISABLE 0xC1

    /**
     * COMMAND_LINE_ENABLE: master unit sends this command if he want to
     * allow transportation on a section
     * 
     * when this command sends out, then the given section
     * could use for any direction
     *
     * parameters: none, the slave identification managed by I2C addressing
     */
#define COMMAND_LINE_ENABLE 0xC2

    /**
     * COMMAND_LINE_STATUS: master unit sends this command if he want to 
     * know about a section's status
     * 
     * In that case, the slave must answer with a one byte status variable,
     * which is 0 if the section is locked, and 1 (or !=0) if the section
     * is available for transportation
     *
     * parameters: none, the slave identification managed by I2C addressing
     */

#define COMMAND_GET_SECTION_STATUS 0xC3

#define COMMAND_SEND_SECTION_STATUS 0xC4


    /**
     * commands in UDP communication
     * all master need to know about these commands
     *
     */


    /**
     * COMMAND_GET_OCCUPANCY: if a master need to know about a section's
     * occupancy, then it should send this command.
     * 
     * parameters: 1 byte: the section's ID
     */
#define COMMAND_GET_OCCUPANCY 0xC8

    /**
     * COMMAND_SEND_OCCUPANCY: this command will be always sended by the SOC unit,
     * which handling the occupancy of the track
     * 
     * parameters: 4 byte of occupancy
     */
#define COMMAND_SEND_OCCUPANCY 0xC9


    /**
     * COMMAND_GET_TURNOUT_STATUS: if a master need to know about a turnout's
     * status, then it should specify that which one did he care about
     * 
     * parameters: 1 byte: the turnout's ID
     * 
     * in best case he gets 1 byte as a result
     */
#define COMMAND_GET_TURNOUT_STATUS 0xCA


    /**
     * COMMAND_SEND_TURNOUT_STATUS: if a master get a COMMAND_GET_TURNOUT_STATUS
     * command with a parameter of a turnout's ID which he managing, then it 
     * should send back the results.
     * 
     * parameters: 1 byte: the turnout's status which could be
     * <ul>
     * <li>divergent</li>
     * <li>straight</li>
     * <li>p�rizsi</li>
     * </ul>
     */
#define COMMAND_SEND_TURNOUT_STATUS 0xCB

    /**
     * 
     */
#define COMMAND_GET_SECTION_LIST 0xCC

    /**
     */
#define COMMAND_SEND_SECTION_LIST 0xCD





    /*
     * errors in communication
     */
#define ERROR_NONE 0xE0




#ifdef	__cplusplus
}
#endif

#endif	/* KV_COMMANDS_H */

