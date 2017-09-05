package hu.bme.mit.inf.modes3.components.sample.demo

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.utils.conf.LocomotivesConfiguration
import org.slf4j.ILoggerFactory

class TrainsDemo extends AbstractCommunicationComponent implements ITrainReferenceSpeedListener {

	val knownTrains = LocomotivesConfiguration.INSTANCE.locomotiveIds

	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.trainSpeedStateRegistry.addTrainReferenceSpeedListener(this)
	}

	override run() {
		initiateStopEntireRailroad
		Thread.sleep(100)
		initiateStartEntireRailroad
		Thread.sleep(100)
		initiateStartAllTrains
		Thread.sleep(100)
		initiateStopAllTrains
		Thread.sleep(100)
	}

	private def initiateStartAllTrains() {
		knownTrains.forEach [
			locator.trainCommander.setTrainReferenceSpeedAndDirection(it, 10, TrainDirection.BACKWARD)
		]
	}

	private def initiateStartEntireRailroad() {
		logger.warn('''As of 03.09.2017, this feature (startEntireRailRoad) is not sure to be already tested.''')
		locator.dccCommander.startEntireRailRoad
	}

	private def initiateStopEntireRailroad() {
		logger.warn('''As of 03.09.2017, this feature (stopEntireRailRoad) is not sure to be already tested.''')
		locator.dccCommander.stopEntireRailRoad
	}

	private def initiateStopAllTrains() {
		logger.warn('''As of 03.09.2017, this feature (stopTrains) is not sure to be already tested.''')
		locator.dccCommander.stopTrains
	}

	override onTrainReferenceSpeed(int id, int speed, TrainDirection direction) {
		logger.info('''Train #«id» is «speed» fast in «direction» direction''')
	}

}
