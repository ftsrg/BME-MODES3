package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import java.util.ArrayList
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.slf4j.helpers.NOPLoggerFactory

class TurnoutMessageHandlerMQTTTransportTests {

	val createdStacks = new ArrayList<CommunicationStack>

	var BBBComponent componentUnderTest

	@Mock
	var ExpanderTurnoutController expander

	@Mock
	var ExpanderSectionController neverUsedInTests

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	private def createAndRegisterStack() {
		val stack = CommunicationStackFactory::createLocalMQTTStack
		createdStacks.add(stack)
		stack
	}

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderSectionController)
		communicationService = new TrackCommunicationServiceLocator(createAndRegisterStack, new NOPLoggerFactory)
	}

	@After
	def void tearDown() {
		createdStacks.forEach[stack|stack.stop]
	}

	@Test
	def void setHandledTurnoutStraight() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.controllerManagesTurnout(turnoutId)).thenReturn(true)
		componentUnderTest = new BBBComponent(createAndRegisterStack, neverUsedInTests, expander, new NOPLoggerFactory)

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
		componentUnderTest = new BBBComponent(createAndRegisterStack, neverUsedInTests, expander, new NOPLoggerFactory)

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
		componentUnderTest = new BBBComponent(createAndRegisterStack, neverUsedInTests, expander, new NOPLoggerFactory)

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
		componentUnderTest = new BBBComponent(createAndRegisterStack, neverUsedInTests, expander, new NOPLoggerFactory)

		// Act
		communicationService.trackElementCommander.sendTurnoutCommand(turnoutId, TurnoutState.DIVERGENT)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesTurnout(turnoutId)
		Mockito.verify(expander, Mockito.never).setTurnoutDivergent(turnoutId)
	}
}
