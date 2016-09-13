package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.bbb.strategy.BoardWrapper
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator

/**
 * Encapsulates a SectionMessageHandler along with a TurnoutMessageHandler so that instantiating
 * this class can handle sections and turnouts through the network.
 * 
 * @author benedekh
 */
class TrackElementCommandHandler {

	// handler of the section messages
	private val SectionMessageHandler sectionMessageHandler

	// handler of the turnout messages
	private val TurnoutMessageHandler turnoutMessageHandler

	new(TrackCommunicationServiceLocator locator, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController) {
		sectionMessageHandler = new SectionMessageHandler(locator.trackElementCommandCallback, sectionController)
		turnoutMessageHandler = new TurnoutMessageHandler(locator.trackElementCommandCallback, turnoutController)
	}

	new(TrackCommunicationServiceLocator locator) {
		val board = new BoardWrapper
		sectionMessageHandler = new SectionMessageHandler(locator.trackElementCommandCallback, new ExpanderSectionController(board))
		turnoutMessageHandler = new TurnoutMessageHandler(locator.trackElementCommandCallback, new ExpanderTurnoutController(board))
	}

}
