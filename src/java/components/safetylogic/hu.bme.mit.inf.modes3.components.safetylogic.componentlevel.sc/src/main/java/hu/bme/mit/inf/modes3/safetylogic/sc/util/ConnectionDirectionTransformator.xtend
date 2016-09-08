package hu.bme.mit.inf.modes3.safetylogic.sc.util

import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection

class ConnectionDirectionTransformator {

	static def ConnectionDirection toInternalDirection(YakinduConnectionDirection direction) {
		switch (direction) {
			case YakinduConnectionDirection.LEFT: return ConnectionDirection.LEFT
			case YakinduConnectionDirection.RIGHT: return ConnectionDirection.RIGHT
			case YakinduConnectionDirection.BOTTOM: return ConnectionDirection.BOTTOM
			default: return null
		}
	}

	static def YakinduConnectionDirection toProtobufDirection(ConnectionDirection direction) {
		switch (direction) {
			case ConnectionDirection.LEFT: return YakinduConnectionDirection.LEFT
			case ConnectionDirection.RIGHT: return YakinduConnectionDirection.RIGHT
			case ConnectionDirection.BOTTOM: return YakinduConnectionDirection.BOTTOM
		}
	}
}
