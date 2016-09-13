package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy

/**
 * Encapsulates a SectionMessageHandler along with a TurnoutMessageHandler so that instantiating
 * this class can handle sections and turnouts through the network.
 * 
 * @author benedekh
 */
class TrackElementCommandHandler {

	// the message handlers are registered into this service locator that encapsulates the CommunicationStack
	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val TrackCommunicationServiceLocator serviceLocator

	// handler of the section messages
	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val SectionMessageHandler sectionMessageHandler

	// handler of the turnout messages
	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val TurnoutMessageHandler turnoutMessageHandler

	new(CommunicationStack stack, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController) {
		serviceLocator = new TrackCommunicationServiceLocator(stack)
		sectionMessageHandler = new SectionMessageHandler(serviceLocator.trackElementCommandCallback, sectionController)
		turnoutMessageHandler = new TurnoutMessageHandler(serviceLocator.trackElementCommandCallback, turnoutController)
	}

	new(CommunicationStack stack) {
		this(stack, new ExpanderSectionController, new ExpanderTurnoutController)
	}

}
