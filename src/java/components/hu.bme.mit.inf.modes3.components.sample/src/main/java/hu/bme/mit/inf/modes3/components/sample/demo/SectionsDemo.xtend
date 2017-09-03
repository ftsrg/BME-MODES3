package hu.bme.mit.inf.modes3.components.sample.demo

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import org.slf4j.ILoggerFactory
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy

class SectionsDemo extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener, ISegmentStateChangeListener {

	val knownSections = LayoutConfiguration.INSTANCE.sectionsAsInteger

	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.trackElementStateRegistry.segmentOccupancyChangeListener = this
		locator.trackElementStateRegistry.segmentStateChangeListener = this
	}

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
