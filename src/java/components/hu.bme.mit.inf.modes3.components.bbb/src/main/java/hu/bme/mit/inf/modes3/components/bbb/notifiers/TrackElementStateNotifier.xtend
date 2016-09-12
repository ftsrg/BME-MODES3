package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator

class TrackElementStateNotifier {

	protected val TrackCommunicationServiceLocator serviceLocator

	protected var SectionStateNotifier sectionStateNotifier

	protected var TurnoutStateNotifier turnoutStateNotifier

	new(CommunicationStack stack, ExpanderSectionController sectionController,
		ExpanderTurnoutController turnoutController) {
		serviceLocator = new TrackCommunicationServiceLocator(stack)
		sectionStateNotifier = new SectionStateNotifier(serviceLocator.trackElementStateSender, sectionController)
		turnoutStateNotifier = new TurnoutStateNotifier(serviceLocator.trackElementStateSender, turnoutController)
	}

	new(CommunicationStack stack) {
		this(stack, new ExpanderSectionController, new ExpanderTurnoutController)
	}

	def void start() {
		new Thread(sectionStateNotifier).start
		new Thread(turnoutStateNotifier).start
	}

}
