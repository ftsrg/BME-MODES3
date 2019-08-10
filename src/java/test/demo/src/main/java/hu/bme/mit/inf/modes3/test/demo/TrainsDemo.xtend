package hu.bme.mit.inf.modes3.test.demo

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.utils.conf.LocomotivesConfiguration
import org.slf4j.ILoggerFactory

/**
 * A show-case (demo), how you can get diverse information about the trains and how you can control them.
 * 
 * @author benedekh
 */
class TrainsDemo extends AbstractCommunicationComponent implements ITrainSpeedStateListener {

	val knownTrains = LocomotivesConfiguration.INSTANCE.locomotiveIds

	/**
	 * @param locator the high-level communication service of the railway track
	 * @param factory the logger factory
	 */
	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.trainSpeedStateRegistry.addTrainSpeedStateListener(this)
	}

	/**
	 * Runs the demo of how to get diverse information about the trains and how you can control them.
	 */
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

	override onTrainSpeedState(int id, int speed, TrainDirection direction) {
		logger.info('''Train #«id» is «speed» fast in «direction» direction''')
	}

}
