package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import java.util.Collections
import org.junit.After
import org.junit.Before
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
class BBBTurnoutStateChangeNotifierLocalTransportIntegrationTest {

	var BBBComponentWithStateChangeNotifier componentUnderTest

	@Mock
	var ExpanderTurnoutController expander

	@Mock
	var ExpanderSectionController neverUsedInTests

	@Mock
	var ITurnoutStateChangeListener changeListenerMock

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	@DataPoints
	public static var initialSegmentStates = #[TurnoutState.STRAIGHT, TurnoutState.DIVERGENT]

	/** returns the other possible value of TurnoutState */
	private def getNegatedTurnoutState(TurnoutState state) {
		switch (state) {
			case STRAIGHT: TurnoutState.DIVERGENT
			case DIVERGENT: TurnoutState.STRAIGHT
		}
	}

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderSectionController)
		communicationService = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack, (new NOPLoggerFactory).getLogger(''))
	}

	@After
	def void stop() {
		// stop the internal threads
		componentUnderTest.interrupt
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
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.managedTurnouts).thenReturn(turnoutIDset)
		Mockito.when(expander.getTurnoutStatus(turnoutID)).then(new Answer {

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
		changeListenerMock = Mockito.mock(ITurnoutStateChangeListener)
		communicationService.trackElementStateRegistry.turnoutStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponentWithStateChangeNotifier(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander, new NOPLoggerFactory)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(200) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.times(1)).onTurnoutStateChange(turnoutID, null, negatedState)
		Mockito.verify(changeListenerMock, Mockito.never).onTurnoutStateChange(turnoutID, null, initialState)
	}

	@Theory
	def void noReportWhenStateIsNotChanged(TurnoutState initialState) {
		// Arrange
		val turnoutID = 42
		val turnoutIDset = #{turnoutID}

		// set mocks
		expander = Mockito.mock(ExpanderTurnoutController)
		Mockito.when(expander.managedTurnouts).thenReturn(turnoutIDset)
		Mockito.when(expander.getTurnoutStatus(turnoutID)).thenReturn(initialState)
		changeListenerMock = Mockito.mock(ITurnoutStateChangeListener)
		communicationService.trackElementStateRegistry.turnoutStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponentWithStateChangeNotifier(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander, new NOPLoggerFactory)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onTurnoutStateChange(Mockito.anyInt, Mockito.any(TurnoutState), Mockito.any(TurnoutState))
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
		componentUnderTest = new BBBComponentWithStateChangeNotifier(CommunicationStackFactory::createLocalStack, neverUsedInTests, expander, new NOPLoggerFactory)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onTurnoutStateChange(Mockito.anyInt, Mockito.any(TurnoutState), Mockito.any(TurnoutState))
	}

}
