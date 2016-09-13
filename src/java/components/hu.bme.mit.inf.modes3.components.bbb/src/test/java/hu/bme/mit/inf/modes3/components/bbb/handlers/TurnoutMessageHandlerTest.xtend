package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class TurnoutMessageHandlerTest {

	var TurnoutMessageHandler handler
	@Mock
	var ITrackElementCommandCallback neverUsedInTests
	@Mock
	var ExpanderTurnoutController expander

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ITrackElementCommandCallback)
	}

	@Test
	def void setHandledTurnoutStraight() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.controllerManagesTurnout(turnoutId)).thenReturn(true)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onTurnoutCommand(int turnoutId, TurnoutState state))
		handler = new TurnoutMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onTurnoutCommand(turnoutId, TurnoutState.STRAIGHT)

		// Assert
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
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onTurnoutCommand(int turnoutId, TurnoutState state))
		handler = new TurnoutMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onTurnoutCommand(turnoutId, TurnoutState.STRAIGHT)

		// Assert
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
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onTurnoutCommand(int turnoutId, TurnoutState state))
		handler = new TurnoutMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onTurnoutCommand(turnoutId, TurnoutState.DIVERGENT)

		// Assert
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
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onTurnoutCommand(int turnoutId, TurnoutState state))
		handler = new TurnoutMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onTurnoutCommand(turnoutId, TurnoutState.DIVERGENT)

		// Assert
		Mockito.verify(expander, Mockito.times(1)).controllerManagesTurnout(turnoutId)
		Mockito.verify(expander, Mockito.never).setTurnoutDivergent(turnoutId)
	}

	@Test
	def void shallNeitherSetStraightNorDivergentIfCommandIsInvalid() {
		// Arrange
		val turnoutId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderTurnoutController)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onTurnoutCommand(int turnoutId, TurnoutState state))
		handler = new TurnoutMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onTurnoutCommand(turnoutId, null)

		// Assert
		Mockito.verify(expander, Mockito.never).setTurnoutStraight(turnoutId)
		Mockito.verify(expander, Mockito.never).setTurnoutDivergent(turnoutId)
		Mockito.verify(expander, Mockito.never).controllerManagesTurnout(turnoutId)
	}

}
