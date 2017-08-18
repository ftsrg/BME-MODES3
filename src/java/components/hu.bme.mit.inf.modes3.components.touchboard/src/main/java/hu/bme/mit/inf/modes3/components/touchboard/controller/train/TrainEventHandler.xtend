package hu.bme.mit.inf.modes3.components.touchboard.controller.train

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander

class TrainEventHandler {

	val ITrackElementCommander trackElementCommander
	val int id

	var Direction direction
	var SpeedPercentage percentage

	new(int id, ITrackElementCommander trackElementCommander) {
		this.id = id
		this.trackElementCommander = trackElementCommander

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
		trackElementCommander.setTrainReferenceSpeedAndDirection(id, speed, DirectionConverter.toDirection(direction))
	}

}
