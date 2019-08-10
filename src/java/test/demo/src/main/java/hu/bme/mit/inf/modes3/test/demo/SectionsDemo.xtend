package hu.bme.mit.inf.modes3.test.demo

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import org.slf4j.ILoggerFactory

/**
 * A show-case (demo), how you can get diverse information about the sections and how you can control the sections too.
 * 
 * @author benedekh
 */
class SectionsDemo extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener, ISegmentStateChangeListener {

	val knownSections = LayoutConfiguration.INSTANCE.sections

	/**
	 * @param locator the high-level communication service of the railway track
	 * @param factory the logger factory
	 */
	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.trackElementStateRegistry.registerSegmentOccupancyChangeListener = this
		locator.trackElementStateRegistry.registerSegmentStateChangeListener = this
	}

	/**
	 * Runs the demo of how to get status information from the sections and how you can control them.
	 */
	override run() {
		getOccupancyOfAll
		printSeparatorAndSleep
		disableAllSection
		printSeparatorAndSleep
		getStateOfAll
		printSeparatorAndSleep
		enableAllSection
		printSeparatorAndSleep
		getStateOfAll
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		logger.info('''Section #«id» was «oldValue», but now it is «newValue»''')
	}

	override onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue) {
		logger.info('''Section #«id» was «oldValue», but now it is «newValue»''')
	}

	private def printSeparatorAndSleep() {
		logger.info('''--------''')
		Thread.sleep(40)
	}

	private def disableAllSection() {
		setAllSection(SegmentState.DISABLED)
	}

	private def enableAllSection() {
		setAllSection(SegmentState.ENABLED)
	}

	private def setAllSection(SegmentState state) {
		knownSections.forEach[locator.trackElementCommander.sendSegmentCommand(it, state)]
	}

	private def getStateOfAll() {
		knownSections.forEach [
			val state = locator.trackElementStateRegistry.getSegmentState(it)
			logger.info('''Section #«it» is «state»''')
		]
	}

	private def getOccupancyOfAll() {
		knownSections.forEach [
			val state = locator.trackElementStateRegistry.getSegmentOccupancy(it)
			logger.info('''Section #«it» is «state»''')
		]
	}

}
