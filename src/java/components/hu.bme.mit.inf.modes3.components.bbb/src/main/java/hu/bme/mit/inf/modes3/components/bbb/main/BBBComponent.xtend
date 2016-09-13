package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.handlers.TrackElementCommandHandler
import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateNotifier
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The standalone component of the BBB code. It encapsulates the command processor and the state sender units as well.<br>
 * Command processor = handling section enable/disable, turnout set straight/divergent commands which were received over the network<br>
 * State sender = send section/turnout state events to the network.
 * 
 * @author benedekh
 */
class BBBComponent extends AbstractRailRoadCommunicationComponent {

	@Accessors(PROTECTED_GETTER) val TrackCommunicationServiceLocator locator = super.locator

	// to handle track element commands
	protected val TrackElementCommandHandler commandDispatcher

	// to send track element states
	protected var TrackElementStateNotifier stateNotifier

	new(CommunicationStack stack) {
		super(stack)
		commandDispatcher = new TrackElementCommandHandler(locator)
		stateNotifier = new TrackElementStateNotifier(locator)
	}

	new(CommunicationStack stack, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController) {
		super(stack)
		commandDispatcher = new TrackElementCommandHandler(locator, sectionController, turnoutController)
		stateNotifier = new TrackElementStateNotifier(locator, sectionController, turnoutController)
	}

	protected new(CommunicationStack stackForCommandDispatcher, TrackElementStateNotifier _stateNotifier) {
		super(stackForCommandDispatcher)
		commandDispatcher = new TrackElementCommandHandler(locator)
		stateNotifier = _stateNotifier
	}

	protected new(CommunicationStack stack, TrackElementStateNotifier _stateNotifier, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController) {
		super(stack)
		commandDispatcher = new TrackElementCommandHandler(locator, sectionController, turnoutController)
		stateNotifier = _stateNotifier
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
