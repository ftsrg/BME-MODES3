package hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;

/**
 * Converts the long representation of the direction used within the
 * statecharts, to the Java specific direction Enum and vice versa.
 *
 * @author bendekh
 */
public class DirectionConverterHelper {

    private static final int STRAIGHT = 0;
    private static final int DIVERGENT = 1;
    private static final int TOP = 2;

    /**
     * See {@link org.yakindu.scr.turnout.TurnoutStatemachine#init()} and
     * {@link org.yakindu.scr.section.SectionStatemachine#init()}.
     *
     * sCISections.setSTRAIGHT(0); -> STRAIGHT == 0;
     * sCISections.setDIVERGENT(1); -> DIVERGENT == 1; sCISections.setTOP(2); ->
     * TOP == 2;
     * 
     * @param value that shall be converted to enum
     * @return the converted representation of the long
     */
    public static Direction getDirectionFromValue(long value) {
        int intValue = (int) value;
        switch (intValue) {
            case STRAIGHT:
                return Direction.STRAIGHT;
            case DIVERGENT:
                return Direction.DIVERGENT;
            case TOP:
                return Direction.TOP;
            default:
                return null;
        }
    }

    /**
     * Convert from the Java specific Enum to the statechart specific direction
     * long value.
     *
     * @param direction that shall be converted to long
     * @return the converted representation of the enum
     */
    public static long getValueFromDirection(Direction direction) {
        switch (direction) {
            case STRAIGHT:
                return DirectionConverterHelper.STRAIGHT;
            case DIVERGENT:
                return DirectionConverterHelper.DIVERGENT;
            case TOP:
                return DirectionConverterHelper.TOP;
            default:
                return -1;
        }
    }

}
