package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

/**
 * data class for holding commands via UDP communication
 * <p>
 *
 * @author zsoltmazlo
 */
public class Commands {

    public static final byte COMMAND_IDENTIFY = (byte) 0xC0;
    public static final byte COMMAND_LINE_DISABLE = (byte) 0xC1;
    public static final byte COMMAND_LINE_ENABLE = (byte) 0xC2;
    public static final byte COMMAND_GET_SECTION_STATUS = (byte) 0xC3;
    public static final byte COMMAND_SEND_SECTION_STATUS = (byte) 0xC4;
    public static final byte COMMAND_GET_OCCUPANCY = (byte) 0xC8;
    public static final byte COMMAND_SEND_OCCUPANCY = (byte) 0xC9;
    public static final byte COMMAND_GET_TURNOUT_STATUS = (byte) 0xCA;
    public static final byte COMMAND_SEND_TURNOUT_STATUS = (byte) 0xCB;
}
