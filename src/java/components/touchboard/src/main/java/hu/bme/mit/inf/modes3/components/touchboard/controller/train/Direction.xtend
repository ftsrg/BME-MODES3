package hu.bme.mit.inf.modes3.components.touchboard.controller.train

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * The direction of movement of a train. 
 * 
 * @author benedekh
 */
public enum Direction {
	FORWARD,
	BACKWARD
}

/**
 * Flips the direction.
 * 
 * @author benedekh
 */
public class DirectionConverter {
	
	/**
	 * Flips a direction.
	 * 
	 * @param direction the recent direction
	 * 
	 * @return the opposite direction
	 */
	static def toDirection(Direction direction) {
		switch (direction) {
			case FORWARD: TrainDirection.FORWARD
			case BACKWARD: TrainDirection.BACKWARD
		}
	}
}
