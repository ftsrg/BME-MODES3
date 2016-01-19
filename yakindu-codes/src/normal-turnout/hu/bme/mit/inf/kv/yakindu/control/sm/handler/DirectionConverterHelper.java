package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author bendekh
 */
public class DirectionConverterHelper {

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
            case 0:
                return Direction.STRAIGHT;
            case 1:
                return Direction.DIVERGENT;
            case 2:
                return Direction.TOP;
            default:
                return null;
        }
    }

}
