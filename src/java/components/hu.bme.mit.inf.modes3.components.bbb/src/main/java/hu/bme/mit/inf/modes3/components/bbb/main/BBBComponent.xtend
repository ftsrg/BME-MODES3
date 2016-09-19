package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.handlers.TrackElementCommandHandler
import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateNotifier
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.slf4j.ILoggerFactory

/**
 * The standalone component of the BBB code. It encapsulates the command processor and the state sender units as well.<br>
 * Command processor = handling section enable/disable, turnout set straight/divergent commands which were received over the network<br>
 * State sender = send section/turnout state events to the network.
 * 
 * @author benedekh
 */
class BBBComponent extends AbstractRailRoadCommunicationComponent {

	// to handle track element commands
	protected val TrackElementCommandHandler commandDispatcher

	// to send track element states
	protected var TrackElementStateNotifier stateNotifier

	new(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		commandDispatcher = new TrackElementCommandHandler(locator, factory)
		stateNotifier = new TrackElementStateNotifier(locator, factory)
	}

	new(CommunicationStack stack, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController, ILoggerFactory factory) {
		super(stack, factory)
		commandDispatcher = new TrackElementCommandHandler(locator, sectionController, turnoutController)
		stateNotifier = new TrackElementStateNotifier(locator, sectionController, turnoutController, factory)
	}

	override run() {
		stateNotifier?.start
	}

	/**
	 * Stop internal threads.
	 */
	def interrupt() {
		stateNotifier?.interrupt
	}

}
