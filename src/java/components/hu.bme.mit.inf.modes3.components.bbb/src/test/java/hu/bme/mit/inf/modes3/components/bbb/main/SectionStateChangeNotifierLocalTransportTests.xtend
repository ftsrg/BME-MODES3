package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener
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
class SectionStateChangeNotifierLocalTransportTests {

	var BBBComponentWithStateChangeNotifier componentUnderTest

	@Mock
	var ExpanderSectionController expander

	@Mock
	var ExpanderTurnoutController neverUsedInTests

	@Mock
	var ISegmentStateChangeListener changeListenerMock

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	@DataPoints
	public static var initialSegmentStates = #[SegmentState.ENABLED, SegmentState.DISABLED]

	/** returns the other possible value of SegmentState */
	private def getNegatedSegmentState(SegmentState state) {
		switch (state) {
			case ENABLED: SegmentState.DISABLED
			case DISABLED: SegmentState.ENABLED
		}
	}

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderTurnoutController)
		communicationService = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack, new NOPLoggerFactory)

	}

	@After
	def void tearDown() {
		// stop the internal threads
		componentUnderTest.interrupt
		Thread.sleep(300)
	}

	@Theory
	def void reportStateChanged(SegmentState initialState) {
		/** Theory -> see http://junit.sourceforge.net/doc/ReleaseNotes4.4.html Theories section */
		// Arrange
		val sectionID = 42
		val sectionIDset = #{sectionID}
		// to simulate segment state change
		val negatedState = getNegatedSegmentState(initialState)

		// set mocks
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.managedSections).thenReturn(sectionIDset)
		Mockito.when(expander.getSectionStatus(sectionID)).then(new Answer {

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
		changeListenerMock = Mockito.mock(ISegmentStateChangeListener)
		communicationService.trackElementStateRegistry.segmentStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponentWithStateChangeNotifier(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests, new NOPLoggerFactory)
		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.times(1)).onSegmentStateChange(sectionID, null, negatedState)
		Mockito.verify(changeListenerMock, Mockito.never).onSegmentStateChange(sectionID, null, initialState)
	}

	@Theory
	def void noReportWhenStateIsNotChanged(SegmentState initialState) {
		// Arrange
		val sectionID = 42
		val sectionIDset = #{sectionID}

		// set mocks
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.managedSections).thenReturn(sectionIDset)
		Mockito.when(expander.getSectionStatus(sectionID)).thenReturn(initialState)
		changeListenerMock = Mockito.mock(ISegmentStateChangeListener)
		communicationService.trackElementStateRegistry.segmentStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponentWithStateChangeNotifier(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests, new NOPLoggerFactory)
		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onSegmentStateChange(Mockito.anyInt, Mockito.any(SegmentState), Mockito.any(SegmentState))
	}

	@Test
	def void withoutSegmentsReportsNothing() {
		// Arrange
		// initialize mocks
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.managedSections).thenReturn(Collections.emptySet)
		changeListenerMock = Mockito.mock(ISegmentStateChangeListener)
		communicationService.trackElementStateRegistry.segmentStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponentWithStateChangeNotifier(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests, new NOPLoggerFactory)
		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onSegmentStateChange(Mockito.anyInt, Mockito.any(SegmentState), Mockito.any(SegmentState))
	}

}
