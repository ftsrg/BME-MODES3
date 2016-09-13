package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.BoardWrapper
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator

/**
 * Encapsulates a SectionStateNotifier along with a TurnoutStateNotifier so that instantiating
 * this class can send status change information about the sections and turnouts to the network.
 * 
 * @author benedekh
 */
class TrackElementStateChangeNotifier extends TrackElementStateNotifier {

	new(TrackCommunicationServiceLocator locator, ExpanderSectionController sectionController, ExpanderTurnoutController turnoutController) {
		super(locator, sectionController, turnoutController)
		sectionStateNotifier = new SectionStateChangeNotifier(locator.trackElementStateSender, sectionController)
		turnoutStateNotifier = new TurnoutStateChangeNotifier(locator.trackElementStateSender, turnoutController)
	}
	
	private new(TrackCommunicationServiceLocator locator, BoardWrapper board){
		this(locator, new ExpanderSectionController(board), new ExpanderTurnoutController(board))
	}

	new(TrackCommunicationServiceLocator locator) {
		this(locator, new BoardWrapper)
	}
}
