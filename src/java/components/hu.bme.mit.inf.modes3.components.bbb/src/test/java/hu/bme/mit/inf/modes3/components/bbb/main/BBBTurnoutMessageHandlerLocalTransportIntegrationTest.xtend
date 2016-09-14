package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class BBBTurnoutMessageHandlerLocalTransportIntegrationTest {

	var BBBComponent componentUnderTest

	@Mock
	var ExpanderTurnoutController expander

	@Mock
	var ExpanderSectionController neverUsedInTests

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderSectionController)
		communicationService = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack)
	}

	@Test
	def void setHandledTurnoutStraight() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.controllerManagesTurnout(turnoutId)).thenReturn(true)
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander)

		// Act
		communicationService.trackElementCommander.sendTurnoutCommand(turnoutId, TurnoutState.STRAIGHT)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesTurnout(turnoutId)
		Mockito.verify(expander, Mockito.times(1)).setTurnoutStraight(turnoutId)
	}

	@Test
	def void shallNotSetNotHandledTurnoutStraight() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.controllerManagesTurnout(turnoutId)).thenReturn(false)
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander)

		// Act
		communicationService.trackElementCommander.sendTurnoutCommand(turnoutId, TurnoutState.STRAIGHT)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesTurnout(turnoutId)
		Mockito.verify(expander, Mockito.never).setTurnoutStraight(turnoutId)
	}

	@Test
	def void setHandledTurnoutDivergent() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.controllerManagesTurnout(turnoutId)).thenReturn(true)
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander)

		// Act
		communicationService.trackElementCommander.sendTurnoutCommand(turnoutId, TurnoutState.DIVERGENT)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesTurnout(turnoutId)
		Mockito.verify(expander, Mockito.times(1)).setTurnoutDivergent(turnoutId)
	}

	@Test
	def void shallNotSetNotHandledTurnoutDivergent() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.controllerManagesTurnout(turnoutId)).thenReturn(false)
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander)

		// Act
		communicationService.trackElementCommander.sendTurnoutCommand(turnoutId, TurnoutState.DIVERGENT)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesTurnout(turnoutId)
		Mockito.verify(expander, Mockito.never).setTurnoutDivergent(turnoutId)
	}
}
