package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener
import java.util.Collections
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class BBBSectionStateNotifierLocalTransportIntegrationTest {

	var BBBComponent componentUnderTest

	@Mock
	var ExpanderSectionController expander

	@Mock
	var ExpanderTurnoutController neverUsedInTests

	@Mock
	var ISegmentStateChangeListener changeListenerMock

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderTurnoutController)
		communicationService = new TrackCommunicationServiceLocator(CommunicationStack::createLocalStack)
	}

	@After
	def void stop() {
		// stop the internal threads
		componentUnderTest.interrupt
	}

	@Test
	def void enabledOrDisabledStatesAreSentForTwoSegments() {
		// Arrange		
		val sectionIDs = #["42", "43"]
		val sectionIDset = #{sectionIDs.get(0), sectionIDs.get(1)}
		val sectionStatuses = #{sectionIDs.get(0) -> SegmentState.ENABLED, sectionIDs.get(1) -> SegmentState.DISABLED}

		// initialize mocks
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.managedSections).thenReturn(sectionIDset)
		for (id : sectionIDs) {
			Mockito.when(expander.getSectionStatus(Integer.valueOf(id))).thenReturn(sectionStatuses.get(id))
		}
		changeListenerMock = Mockito.mock(ISegmentStateChangeListener)
		communicationService.trackElementStateRegistry.segmentStateChangeListener = changeListenerMock

		// create component
		componentUnderTest = new BBBComponent(CommunicationStack::createLocalStack, CommunicationStack::createLocalStack, expander, neverUsedInTests)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		for (id : sectionIDs) {
			val sectionID = Integer.valueOf(id)
			val sectionStatus = sectionStatuses.get(id)
			Assert.assertEquals(sectionStatus, communicationService.trackElementStateRegistry.getSegmentState(sectionID))
			Mockito.verify(changeListenerMock, Mockito.times(1)).onSegmentStateChange(sectionID, null, sectionStatus)
		}
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
		componentUnderTest = new BBBComponent(CommunicationStack::createLocalStack, CommunicationStack::createLocalStack, expander, neverUsedInTests)

		// Act
		new Thread(componentUnderTest).start

		// Assert
		Thread.sleep(150) // so that internal threads can handle transferred messages
		Mockito.verify(changeListenerMock, Mockito.never).onSegmentStateChange(Mockito.anyInt, Mockito.any(SegmentState), Mockito.any(SegmentState))
	}

}
