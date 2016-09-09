package hu.bme.mit.inf.modes3.safetylogic.sc.util;

import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;

public class ConnectionDirectionTransformator {

	public static ConnectionDirection toInternalDirection(YakinduConnectionDirection direction) {
		switch (direction) {
		case LEFT:
			return ConnectionDirection.LEFT;
		case RIGHT:
			return ConnectionDirection.RIGHT;
		case BOTTOM:
			return ConnectionDirection.BOTTOM;
		default:
			return null;
		}
	}

	public static YakinduConnectionDirection toProtobufDirection(ConnectionDirection direction) {
		switch (direction) {
		case LEFT:
			return YakinduConnectionDirection.LEFT;
		case RIGHT:
			return YakinduConnectionDirection.RIGHT;
		case BOTTOM:
			return YakinduConnectionDirection.BOTTOM;
		}
		return null;
	}
}
