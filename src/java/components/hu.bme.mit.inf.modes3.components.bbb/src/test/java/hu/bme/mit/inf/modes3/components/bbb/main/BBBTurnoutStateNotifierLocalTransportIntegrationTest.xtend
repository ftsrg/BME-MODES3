package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import java.util.Collections
import java.util.HashSet
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class BBBTurnoutStateNotifierLocalTransportIntegrationTest {

	var BBBComponent componentUnderTest

	@Mock
	var ExpanderTurnoutController expander

	@Mock
	var ExpanderSectionController neverUsedInTests

	@Mock
	var ITurnoutStateChangeListener changeListenerMock

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderSectionController)
		communicationService = new TrackCommunicationServiceLocator(CommunicationStack::createLocalStack)
	}

	@After
	def void stop() {
		// stop the internal threads
		componentUnderTest.interrupt
	}

	@Test
	def void straightOrDivergentDirectionsAreSentForTwoTurnouts() {
		// Arrange		
		val turnoutIDs = #["42", "43"]
		val turnoutIDset = new HashSet<String>
		turnoutIDset.addAll(turnoutIDs)
		val turnoutStatuses = #{"42" -> TurnoutState.STRAIGHT, "43" -> TurnoutState.DIVERGENT}

		// initialize mocks
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.managedTurnouts).thenReturn(turnoutIDset)
		for (id : turnoutIDs) {
			Mockito.when(expander.getTurnoutStatus(Integer.valueOf(id))).thenReturn(turnoutStatuses.get(id))
		}
		changeListenerMock = Mockito.mock(ITurnoutStateChangeListener)
		communicationService.trackElementStateRegistry.turnoutStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponent(CommunicationStack::createLocalStack, CommunicationStack::createLocalStack, neverUsedInTests, expander)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		for (id : turnoutIDs) {
			val turnoutID = Integer.valueOf(id)
			val turnoutStatus = turnoutStatuses.get(id)
			Assert.assertEquals(turnoutStatus, communicationService.trackElementStateRegistry.getTurnoutState(turnoutID))
			Mockito.verify(changeListenerMock, Mockito.times(1)).onTurnoutStateChange(turnoutID, null, turnoutStatus)
		}
	}

	@Test
	def void withoutTurnoutsReportsNothing() {
		// Arrange
		// initialize mocks
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.managedTurnouts).thenReturn(Collections.emptySet)
		changeListenerMock = Mockito.mock(ITurnoutStateChangeListener)
		communicationService.trackElementStateRegistry.turnoutStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponent(CommunicationStack::createLocalStack, CommunicationStack::createLocalStack, neverUsedInTests, expander)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onTurnoutStateChange(Mockito.anyInt, Mockito.any(TurnoutState), Mockito.any(TurnoutState))
	}

}
