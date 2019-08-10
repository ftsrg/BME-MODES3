package hu.bme.mit.inf.modes3.components.touchboard.controller.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander

/**
 * A handler for the train events.
 * 
 * @author benedekh
 */
class TrainEventHandler {

	val ITrainCommander trainCommander
	val int id

	var Direction direction
	var SpeedPercentage percentage
	
	/**
	 * @param id the ID of the train
	 * @param trainCommander a commander that controls the train
	 */
	new(int id, ITrainCommander trainCommander) {
		this.id = id
		this.trainCommander = trainCommander

		this.direction = Direction.FORWARD
		this.percentage = SpeedPercentage.FIFTY
	}

	/**
	 * Sets the direction of movement of the train.
	 * 
	 * @param direction the direction of movement to be set
	 */
	def setDirection(Direction direction) {
		this.direction = direction
		setTrainSpeed
	}

	/**
	 * Sets the speed percentage of the train
	 * 
	 * @param percentage the speed percentage of the train to be set
	 */
	def setSpeedPercentage(SpeedPercentage percentage) {
		this.percentage = percentage
		setTrainSpeed
	}

	private def setTrainSpeed() {
		val speed = SpeedPercentageUtil.toSpeed(percentage)
		trainCommander.setTrainReferenceSpeedAndDirection(id, speed, DirectionConverter.toDirection(direction))
	}

}
