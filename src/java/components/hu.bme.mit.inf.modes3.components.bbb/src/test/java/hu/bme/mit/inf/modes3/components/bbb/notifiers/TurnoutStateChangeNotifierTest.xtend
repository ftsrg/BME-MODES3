package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Collections
import org.junit.Test
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.slf4j.helpers.NOPLoggerFactory

@RunWith(Theories)
class TurnoutStateChangeNotifierTest {

	var TurnoutStateChangeNotifier notifier
	@Mock
	var ExpanderTurnoutController controller
	@Mock
	var ITrackElementStateSender stateSender

	@DataPoints
	public static var initialSegmentStates = #[TurnoutState.STRAIGHT, TurnoutState.DIVERGENT]

	/** returns the other possible value of TurnoutState */
	private def getNegatedTurnoutState(TurnoutState state) {
		switch (state) {
			case STRAIGHT: TurnoutState.DIVERGENT
			case DIVERGENT: TurnoutState.STRAIGHT
		}
	}

	@Theory
	def void reportStateChanged(TurnoutState initialState) {
		/** Theory -> see http://junit.sourceforge.net/doc/ReleaseNotes4.4.html Theories section */
		// Arrange
		val turnoutID = 42
		val turnoutIDset = #{turnoutID}
		// to simulate segment state change
		val negatedState = getNegatedTurnoutState(initialState)

		// set mocks
		controller = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(controller.managedTurnouts).thenReturn(turnoutIDset)
		Mockito.when(controller.getTurnoutStatus(turnoutID)).then(new Answer {

			private int count = 0

			override answer(InvocationOnMock invocation) throws Throwable {
				count++

				if(count == 1) {
					initialState
				} else {
					negatedState
				}
			}
		})
		stateSender = Mockito.mock(ITrackElementStateSender)
		notifier = new TurnoutStateChangeNotifier(stateSender, controller, new NOPLoggerFactory)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		Mockito.verify(stateSender, Mockito.times(1)).sendTurnoutState(turnoutID, negatedState)
		Mockito.verify(stateSender, Mockito.never).sendTurnoutState(turnoutID, initialState)
	}

	@Theory
	def void noReportWhenStateIsNotChanged(TurnoutState initialState) {
		// Arrange
		val turnoutID = 42
		val turnoutIDset = #{turnoutID}

		// set mocks
		controller = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(controller.managedTurnouts).thenReturn(turnoutIDset)
		Mockito.when(controller.getTurnoutStatus(turnoutID)).thenReturn(initialState)
		stateSender = Mockito.mock(ITrackElementStateSender)
		notifier = new TurnoutStateChangeNotifier(stateSender, controller, new NOPLoggerFactory)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		Mockito.verify(stateSender, Mockito.never).sendTurnoutState(Mockito.anyInt, Mockito.any(TurnoutState))
	}

	@Test
	def void withoutTurnoutsReportsNothing() {
		// Arrange
		// initialize mocks
		controller = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(controller.managedTurnouts).thenReturn(Collections.emptySet)
		stateSender = Mockito.mock(ITrackElementStateSender)

		// create unit under test
		notifier = new TurnoutStateChangeNotifier(stateSender, controller, new NOPLoggerFactory)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		Mockito.verify(stateSender, Mockito.never).sendTurnoutState(Mockito.anyInt, Mockito.any(TurnoutState))
	}
}
