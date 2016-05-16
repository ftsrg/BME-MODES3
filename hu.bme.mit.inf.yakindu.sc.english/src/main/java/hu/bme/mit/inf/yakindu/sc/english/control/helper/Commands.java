package hu.bme.mit.inf.yakindu.sc.english.control.helper;

/**
 * Commands used for communication between the statecharts. It is used between
 * the MQTT and the statecharts themselves.
 *
 * @author benedekh
 */
public class Commands {

    public static final byte DISTRIBUTED_PASSAGE_REQUEST_TOP = (byte) 0xD0;
    public static final byte DISTRIBUTED_PASSAGE_REQUEST_STRAIGHT = (byte) 0xD1;
    public static final byte DISTRIBUTED_PASSAGE_REQUEST_DIVERGENT = (byte) 0xD2;
    public static final byte DISTRIBUTED_SHORT_PASSAGE_REQUEST_TOP = (byte) 0xD3;
    public static final byte DISTRIBUTED_SHORT_PASSAGE_REQUEST_STRAIGHT = (byte) 0xD4;
    public static final byte DISTRIBUTED_SHORT_PASSAGE_REQUEST_DIVERGENT = (byte) 0xD5;
    public static final byte DISTRIBUTED_PASSAGE_RESPONSE_TOP = (byte) 0xD6;
    public static final byte DISTRIBUTED_PASSAGE_RESPONSE_STRAIGHT = (byte) 0xD7;
    public static final byte DISTRIBUTED_PASSAGE_RESPONSE_DIVERGENT = (byte) 0xD8;
    public static final byte DISTRIBUTED_PASSAGE_ALLOWED = (byte) 0xD9;
    public static final byte DISTRIBUTED_PASSAGE_DENIED = (byte) 0xDA;

}
