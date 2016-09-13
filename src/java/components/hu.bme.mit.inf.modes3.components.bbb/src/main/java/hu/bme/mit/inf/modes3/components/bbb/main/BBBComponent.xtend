package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.handlers.TrackElementCommandDispatcher
import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateChangeNotifier
import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateNotifier
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.utils.StateNotifierType
import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack

class BBBComponent extends AbstractCommunicationComponent {

	protected val TrackElementCommandDispatcher commandDispatcher

	protected var TrackElementStateNotifier stateNotifier

	protected var TrackElementStateChangeNotifier stateChangeNotifier

	new(CommunicationStack stack, StateNotifierType notifierType) {
		super(stack)
		commandDispatcher = new TrackElementCommandDispatcher(stack)
		switch (notifierType) {
			case STATE_NOTIFIER: stateNotifier = new TrackElementStateNotifier(stack)
			case STATE_CHANGE_NOTIFIER: stateChangeNotifier = new TrackElementStateChangeNotifier(stack)
		}
	}

	new(CommunicationStack stack, StateNotifierType notifierType, ExpanderSectionController sectionController,
		ExpanderTurnoutController turnoutController) {
		super(stack)
		commandDispatcher = new TrackElementCommandDispatcher(stack, sectionController, turnoutController)
		switch (notifierType) {
			case STATE_NOTIFIER:
				stateNotifier = new TrackElementStateNotifier(stack, sectionController, turnoutController)
			case STATE_CHANGE_NOTIFIER:
				stateChangeNotifier = new TrackElementStateChangeNotifier(stack, sectionController, turnoutController)
		}
	}

	override run() {
		stateNotifier?.start
		stateChangeNotifier?.start
	}

}
