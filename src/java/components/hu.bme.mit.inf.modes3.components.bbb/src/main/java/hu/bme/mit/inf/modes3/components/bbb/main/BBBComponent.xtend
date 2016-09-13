package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.handlers.TrackElementCommandHandler
import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateNotifier
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack

/**
 * The standalone component of the BBB code. It encapsulates the command processor and the state sender units as well.<br>
 * Command processor = handling section enable/disable, turnout set straight/divergent commands which were received over the network<br>
 * State sender = send section/turnout state events to the network.
 * 
 * @author benedekh
 */
class BBBComponent extends AbstractCommunicationComponent {

	// to handle track element commands
	protected val TrackElementCommandHandler commandDispatcher

	// to send track element states
	protected var TrackElementStateNotifier stateNotifier

	new(CommunicationStack stackForCommandDispatcher, CommunicationStack stackForStateNotifier) {
		super(null)
		commandDispatcher = new TrackElementCommandHandler(stackForCommandDispatcher)
		stateNotifier = new TrackElementStateNotifier(stackForStateNotifier)
	}

	new(CommunicationStack stack, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController) {
		super(stack)
		commandDispatcher = new TrackElementCommandHandler(stack, sectionController, turnoutController)
		stateNotifier = new TrackElementStateNotifier(stack, sectionController, turnoutController)
	}

	protected new(CommunicationStack stackForCommandDispatcher, TrackElementStateNotifier _stateNotifier) {
		super(null)
		commandDispatcher = new TrackElementCommandHandler(stackForCommandDispatcher)
		stateNotifier = _stateNotifier
	}

	protected new(CommunicationStack stack, TrackElementStateNotifier _stateNotifier, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController) {
		super(stack)
		commandDispatcher = new TrackElementCommandHandler(stack, sectionController, turnoutController)
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
