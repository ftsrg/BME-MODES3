package hu.bme.mit.inf.modes3.components.touchboard.controller.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander

class TrainEventHandler {

	val ITrainCommander trainCommander
	val int id

	var Direction direction
	var SpeedPercentage percentage

	new(int id, ITrainCommander trainCommander) {
		this.id = id
		this.trainCommander = trainCommander

		this.direction = Direction.FORWARD
		this.percentage = SpeedPercentage.FIFTY
	}

	def setDirection(Direction direction) {
		this.direction = direction
		setTrainSpeed
	}

	def setSpeedPercentage(SpeedPercentage percentage) {
		this.percentage = percentage
		setTrainSpeed
	}

	private def setTrainSpeed() {
		val speed = SpeedPercentageUtil.toSpeed(percentage)
		trainCommander.setTrainReferenceSpeedAndDirection(id, speed, DirectionConverter.toDirection(direction))
	}

}
