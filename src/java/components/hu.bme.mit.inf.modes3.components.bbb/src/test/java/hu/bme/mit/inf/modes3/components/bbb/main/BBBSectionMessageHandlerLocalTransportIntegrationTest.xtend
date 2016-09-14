package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class BBBSectionMessageHandlerLocalTransportIntegrationTest {

	var BBBComponent componentUnderTest

	@Mock
	var ExpanderSectionController expander

	@Mock
	var ExpanderTurnoutController neverUsedInTests

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderTurnoutController)
		communicationService = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack)
	}

	@Test
	def void enableHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(true)
		// create component under test
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests)

		// Act
		communicationService.trackElementCommander.sendSegmentCommand(sectionId, SegmentState.ENABLED)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.times(1)).enableSection(sectionId)
	}

	@Test
	def void shallNotEnableNotHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(false)
		// create component under test
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests)

		// Act
		communicationService.trackElementCommander.sendSegmentCommand(sectionId, SegmentState.ENABLED)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.never).enableSection(sectionId)
	}

	@Test
	def void disableHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(true)
		// create component under test
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests)

		// Act
		communicationService.trackElementCommander.sendSegmentCommand(sectionId, SegmentState.DISABLED)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.times(1)).disableSection(sectionId)
	}

	@Test
	def void shallNotDisableNotHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(false)
		// create component under test
		componentUnderTest = new BBBComponent(CommunicationStackFactory::createLocalStack, expander, neverUsedInTests)

		// Act
		communicationService.trackElementCommander.sendSegmentCommand(sectionId, SegmentState.DISABLED)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.never).disableSection(sectionId)
	}
}
