package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack

/**
 * Encapsulates a SectionStateNotifier along with a TurnoutStateNotifier so that instantiating
 * this class can send status change information about the sections and turnouts to the network.
 * 
 * @author benedekh
 */
class TrackElementStateChangeNotifier extends TrackElementStateNotifier {

	new(CommunicationStack stack, ExpanderSectionController sectionController, ExpanderTurnoutController turnoutController) {
		super(stack, sectionController, turnoutController)
		sectionStateNotifier = new SectionStateChangeNotifier(serviceLocator.trackElementStateSender, sectionController)
		turnoutStateNotifier = new TurnoutStateChangeNotifier(serviceLocator.trackElementStateSender, turnoutController)
	}

	new(CommunicationStack stack) {
		this(stack, new ExpanderSectionController, new ExpanderTurnoutController)
	}
}
