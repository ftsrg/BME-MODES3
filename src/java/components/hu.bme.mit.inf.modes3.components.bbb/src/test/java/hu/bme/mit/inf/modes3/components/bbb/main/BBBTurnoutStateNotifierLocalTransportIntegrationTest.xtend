package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import java.util.Collections
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.slf4j.helpers.NOPLoggerFactory

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
		communicationService = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack)
	}

	@After
	def void stop() {
		// stop the internal threads
		componentUnderTest.interrupt
	}

	@Test
	def void straightOrDivergentDirectionsAreSentForTwoTurnouts() {
		// Arrange		
		val turnoutIDs = #[42, 43]
		val turnoutIDset = #{turnoutIDs.get(0), turnoutIDs.get(1)}
		val turnoutStatuses = #{turnoutIDs.get(0) -> TurnoutState.STRAIGHT, turnoutIDs.get(1) -> TurnoutState.DIVERGENT}

		// initialize mocks
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.managedTurnouts).thenReturn(turnoutIDset)
		for (id : turnoutIDs) {
			Mockito.when(expander.getTurnoutStatus(Integer.valueOf(id))).thenReturn(turnoutStatuses.get(id))
		}
		changeListenerMock = Mockito.mock(ITurnoutStateChangeListener)
		communicationService.trackElementStateRegistry.turnoutStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack,neverUsedInTests,  expander, new NOPLoggerFactory)

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
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack,neverUsedInTests,  expander, new NOPLoggerFactory)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onTurnoutStateChange(Mockito.anyInt, Mockito.any(TurnoutState), Mockito.any(TurnoutState))
	}

}
