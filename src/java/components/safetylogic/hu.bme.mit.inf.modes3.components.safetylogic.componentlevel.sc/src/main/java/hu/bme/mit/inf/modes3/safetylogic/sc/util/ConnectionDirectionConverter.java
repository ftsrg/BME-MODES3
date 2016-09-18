package hu.bme.mit.inf.modes3.safetylogic.sc.util;

import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;

public class ConnectionDirectionConverter {

	public static ConnectionDirection toInternalDirection(YakinduConnectionDirection direction) {
		switch (direction) {
		case Y_TOP:
			return ConnectionDirection.TOP;
		case Y_STRAIGHT:
			return ConnectionDirection.STRAIGHT;
		case Y_DIVERGENT:
			return ConnectionDirection.TOP;
		case CW:
			return ConnectionDirection.CW;
		case CCW:
			return ConnectionDirection.CCW;
		default:
			return ConnectionDirection.UNSPECIFIED;
		}
	}

	public static YakinduConnectionDirection toProtobufDirection(ConnectionDirection direction) {
		switch (direction) {
		case TOP:
			return YakinduConnectionDirection.Y_TOP;
		case STRAIGHT:
			return YakinduConnectionDirection.Y_STRAIGHT;
		case DIVERGENT:
			return YakinduConnectionDirection.Y_DIVERGENT;
		case CW:
			return YakinduConnectionDirection.CW;
		case CCW:
			return YakinduConnectionDirection.CCW;
		default:
			return YakinduConnectionDirection.UNRECOGNIZED;
		}
	}
}
