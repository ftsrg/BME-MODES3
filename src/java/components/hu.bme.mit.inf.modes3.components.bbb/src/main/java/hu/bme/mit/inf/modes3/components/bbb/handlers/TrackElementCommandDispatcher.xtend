package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors

class TrackElementCommandDispatcher {

	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val TrackCommunicationServiceLocator serviceLocator

	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val SectionMessageHandler sectionMessageHandler

	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val TurnoutMessageHandler turnoutMessageHandler

	new(CommunicationStack stack, ExpanderSectionController sectionController,
		ExpanderTurnoutController turnoutController) {
		serviceLocator = new TrackCommunicationServiceLocator(stack)
		sectionMessageHandler = new SectionMessageHandler(serviceLocator.trackElementCommandCallback, sectionController)
		turnoutMessageHandler = new TurnoutMessageHandler(serviceLocator.trackElementCommandCallback, turnoutController)
	}

	new(CommunicationStack stack) {
		this(stack, new ExpanderSectionController, new ExpanderTurnoutController)
	}

}
