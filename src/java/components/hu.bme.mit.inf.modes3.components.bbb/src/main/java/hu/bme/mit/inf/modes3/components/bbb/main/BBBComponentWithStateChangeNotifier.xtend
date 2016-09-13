package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateChangeNotifier
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent

/**
 * The standalone component of the BBB code. It encapsulates the command processor and the state sender units as well.<br>
 * Command processor = handling section enable/disable, turnout set straight/divergent commands which were received over the network<br>
 * State sender = send section/turnout state change events to the network.
 * 
 * @author benedekh
 */
class BBBComponentWithStateChangeNotifier extends BBBComponent {

	new(CommunicationStack stack) {
		super(stack)
		stateNotifier = new TrackElementStateChangeNotifier(locator)
	}

	new(CommunicationStack stack, ExpanderSectionController sectionController, ExpanderTurnoutController turnoutController) {
		super(stack, sectionController, turnoutController)
		stateNotifier = new TrackElementStateChangeNotifier(locator, sectionController, turnoutController)
	}

}
