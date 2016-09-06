package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Collections
import java.util.HashSet
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class TurnoutStateNotifierTest {

	var TurnoutStateNotifier notifier
	@Mock
	var ExpanderTurnoutController controller
	@Mock
	var ITrackElementStateSender stateSender

	@Test
	def void straightOrDivergentDirectionsAreSentForTwoTurnouts() {
		// Arrange		
		val turnoutIDs = #["42", "43"]
		val turnoutIDset = new HashSet<String>
		turnoutIDset.addAll(turnoutIDs)
		val turnoutStatuses = #{"42" -> TurnoutState.STRAIGHT, "43" -> TurnoutState.DIVERGENT}

		// initialize mocks
		controller = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(controller.managedTurnouts).thenReturn(turnoutIDset)
		for (id : turnoutIDs) {
			Mockito.when(controller.getTurnoutStatus(Integer.valueOf(id))).thenReturn(turnoutStatuses.get(id))
		}
		stateSender = Mockito.mock(ITrackElementStateSender)

		// create unit under test
		notifier = new TurnoutStateNotifier(stateSender, controller)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		for (id : turnoutIDs) {
			Mockito.verify(stateSender, Mockito.atLeastOnce).sendTurnoutState(Integer.valueOf(id),
				turnoutStatuses.get(id))
		}
	}

	@Test
	def void withoutSegmentsReportsNothing() {
		// Arrange
		// initialize mocks
		controller = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(controller.managedTurnouts).thenReturn(Collections.emptySet)
		stateSender = Mockito.mock(ITrackElementStateSender)

		// create unit under test
		notifier = new TurnoutStateNotifier(stateSender, controller)

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
