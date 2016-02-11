package hu.bme.mit.inf.yakindu.mqtt.client.data;

/**
 * data class for holding commands between the state machines
 *
 * @author benedekh
 */
public enum StatemachineCommand {

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

    StatemachineCommand(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

}
