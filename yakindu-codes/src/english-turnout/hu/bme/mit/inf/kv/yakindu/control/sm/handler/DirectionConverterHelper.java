package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import org.yakindu.scr.section.SectionStatemachine;
import org.yakindu.scr.turnout.TurnoutStatemachine;

/**
 *
 * @author bendekh
 */
public class DirectionConverterHelper {

    private static final int STRAIGHT = 0;
    private static final int DIVERGENT = 1;
    private static final int TOP = 2;

    /**
     * @see TurnoutStatemachine.java -> init() method
     * @see SectionStatemachine.java -> init() method
     *
     * sCISections.setSTRAIGHT(0); -> STRAIGHT == 0;
     * sCISections.setDIVERGENT(1); -> DIVERGENT == 1; sCISections.setTOP(2); ->
     * TOP == 2;
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
