package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

/**
 * data class for holding commands via UDP communication
 * <p>
 *
 * @author zsoltmazlo
 */
public enum Command {
	COMMAND_IDENTIFY((byte)0xC0),
	COMMAND_LINE_DISABLE((byte)0xC1),
	COMMAND_LINE_ENABLE((byte)0xC2),
	COMMAND_GET_SECTION_STATUS((byte)0xC3),
	COMMAND_SEND_SECTION_STATUS((byte)0xC4),
	COMMAND_GET_OCCUPANCY((byte)0xC8),
	COMMAND_SEND_OCCUPANCY((byte)0xC9),
	COMMAND_GET_TURNOUT_STATUS((byte)0xCA),
	COMMAND_SEND_TURNOUT_STATUS((byte)0xCB);
	
	private final byte value;
	
	Command(byte value) {
		this.value = value;
	}
	
    public int getValue() { return value; }

}
