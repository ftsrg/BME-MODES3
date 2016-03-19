package hu.bme.mit.inf.mqtt.common.data;

/**
 * @author zsoltmazlo, benedekh
 */
public enum Command {

    /**
     * Commands to the embedded controllers.
     */
    IDENTIFY((byte) 0xC0),
    LINE_DISABLE((byte) 0xC1),
    LINE_ENABLE((byte) 0xC2),
    GET_SECTION_STATUS((byte) 0xC3),
    SEND_SECTION_STATUS((byte) 0xC4),
    OCCUPANCY((byte)0xC5),
    GET_OCCUPANCY((byte) 0xC8),
    SEND_OCCUPANCY((byte) 0xC9),
    GET_TURNOUT_STATUS((byte) 0xCA),
    SEND_TURNOUT_STATUS((byte) 0xCB),
    
    /**
     * Commands to the statemachines.
     */
    PASSAGE_REQUEST_TOP((byte) 0xD0),
    PASSAGE_REQUEST_STRAIGHT((byte) 0xD1),
    PASSAGE_REQUEST_DIVERGENT((byte) 0xD2),
    SHORT_PASSAGE_REQUEST_TOP((byte) 0xD3),
    SHORT_PASSAGE_REQUEST_STRAIGHT((byte) 0xD4),
    SHORT_PASSAGE_REQUEST_DIVERGENT((byte) 0xD5),
    PASSAGE_RESPONSE_TOP((byte) 0xD6),
    PASSAGE_RESPONSE_STRAIGHT((byte) 0xD7),
    PASSAGE_RESPONSE_DIVERGENT((byte) 0xD8),
    PASSAGE_ALLOWED((byte) 0xD9),
    PASSAGE_DENIED((byte) 0xDA);

    private final byte value;

    Command(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

}
