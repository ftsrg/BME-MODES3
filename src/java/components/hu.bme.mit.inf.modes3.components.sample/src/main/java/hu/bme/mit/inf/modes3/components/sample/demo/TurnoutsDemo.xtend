package hu.bme.mit.inf.modes3.components.sample.demo

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import org.slf4j.ILoggerFactory

class TurnoutsDemo extends AbstractCommunicationComponent implements ITurnoutCommandListener, ITurnoutStateChangeListener {

	val knownTurnouts = LayoutConfiguration.INSTANCE.turnoutIds
	val knownSegmentIdToTurnoutIdMapping = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.trackElementCommandCallback.turnoutCommandListener = this
		locator.trackElementStateRegistry.turnoutStateChangeListener = this
	}

	override run() {
		getOccupancyOfAll
		printSeparatorAndSleep
		setAllTurnoutDivergent
		printSeparatorAndSleep
		getStateOfAll
		printSeparatorAndSleep
		setAllTurnoutStraight
		printSeparatorAndSleep
		getStateOfAll
		printSeparatorAndSleep
		setAllTurnoutDivergentBySegmentId
		printSeparatorAndSleep
		getStateOfAll
		printSeparatorAndSleep
		sendStateOfAll
		printSeparatorAndSleep
	}

	override onTurnoutCommand(int id, TurnoutState state) {
		logger.info('''Command SET «state» is received for turnout #«id»''')
	}

	override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		logger.info('''Turnout #«id» was «oldValue», but now it is «newValue»''')
	}

	private def printSeparatorAndSleep() {
		logger.info('''--------''')
		Thread.sleep(40)
	}

	private def setAllTurnoutDivergent() {
		setAllTurnout(TurnoutState.DIVERGENT)
	}

	private def setAllTurnoutStraight() {
		setAllTurnout(TurnoutState.STRAIGHT)
	}

	private def setAllTurnout(TurnoutState state) {
		knownTurnouts.forEach[locator.trackElementCommander.sendTurnoutCommandWithTurnoutId(it, state)]
	}

	private def getStateOfAll() {
		knownTurnouts.forEach [
			val state = locator.trackElementStateRegistry.getTurnoutState(it)
			logger.info('''Turnout #«it» is «state»''')
		]
	}

	private def getOccupancyOfAll() {
		knownSegmentIdToTurnoutIdMapping.entrySet.forEach [
			val state = locator.trackElementStateRegistry.getSegmentOccupancy(it.key)
			logger.info('''Turnout #«it.value» is «state»''')
		]
	}

	private def setAllTurnoutDivergentBySegmentId() {
		knownSegmentIdToTurnoutIdMapping.keySet.forEach [
			locator.trackElementCommander.sendTurnoutCommand(it, TurnoutState.DIVERGENT)
		]
	}

	private def sendStateOfAll() {
		knownTurnouts.forEach [
			val state = locator.trackElementStateRegistry.getTurnoutState(it)
			locator.trackElementStateSender.sendTurnoutState(it, state)
			logger.info('''Turnout #«it» is «state» was SENT over the network''')
		]
	}

}
