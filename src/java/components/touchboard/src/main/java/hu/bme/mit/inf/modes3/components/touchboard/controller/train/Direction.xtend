package hu.bme.mit.inf.modes3.components.touchboard.controller.train

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

public enum Direction {
	FORWARD,
	BACKWARD
}

public class DirectionConverter {

	static def toDirection(Direction direction) {
		switch (direction) {
			case FORWARD: TrainDirection.FORWARD
			case BACKWARD: TrainDirection.BACKWARD
		}
	}
}
