package hu.bme.mit.inf.mqtt.common.data;

/**
 * data class for holding commands via UDP communication
 * <p>
 *
 * @author zsoltmazlo
 */
public enum Command {

    IDENTIFY((byte) 0xC0),
    LINE_DISABLE((byte) 0xC1),
    LINE_ENABLE((byte) 0xC2),
    GET_SECTION_STATUS((byte) 0xC3),
    SEND_SECTION_STATUS((byte) 0xC4),
    GET_OCCUPANCY((byte) 0xC8),
    SEND_OCCUPANCY((byte) 0xC9),
    GET_TURNOUT_STATUS((byte) 0xCA),
    SEND_TURNOUT_STATUS((byte) 0xCB);

    private final byte value;

    Command(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

}
