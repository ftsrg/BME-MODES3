package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.bbb.strategy.BoardWrapper
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.slf4j.ILoggerFactory

/**
 * Encapsulates a SectionMessageHandler along with a TurnoutMessageHandler so that instantiating
 * this class can handle sections and turnouts through the network.
 * 
 * @author benedekh
 */
class TrackElementCommandHandler {

	// handler of the section messages
	protected val SectionMessageHandler sectionMessageHandler

	// handler of the turnout messages
	protected val TurnoutMessageHandler turnoutMessageHandler

	new(TrackCommunicationServiceLocator locator, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController, ILoggerFactory factory) {
		sectionMessageHandler = new SectionMessageHandler(locator.trackElementCommandCallback, sectionController, factory)
		turnoutMessageHandler = new TurnoutMessageHandler(locator.trackElementCommandCallback, turnoutController, factory)
	}

	new(int turnoutID, TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		val board = new BoardWrapper(factory)
		sectionMessageHandler = new SectionMessageHandler(locator.trackElementCommandCallback, new ExpanderSectionController(turnoutID, board, factory), factory)
		turnoutMessageHandler = new TurnoutMessageHandler(locator.trackElementCommandCallback, new ExpanderTurnoutController(turnoutID, board, factory), factory)
	}

}
