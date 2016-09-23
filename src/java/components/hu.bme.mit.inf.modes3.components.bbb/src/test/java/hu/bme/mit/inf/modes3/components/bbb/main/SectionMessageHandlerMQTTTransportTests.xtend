package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
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

class SectionMessageHandlerMQTTTransportTests {

	val createdStacks = new ArrayList<CommunicationStack>

	var BBBComponent componentUnderTest

	@Mock
	var ExpanderSectionController expander

	@Mock
	var ExpanderTurnoutController neverUsedInTests

	// used for sending messages over the network
	var TrackCommunicationServiceLocator communicationService

	private def createAndRegisterStack() {
		val stack = CommunicationStackFactory::createLocalMQTTStack
		createdStacks.add(stack)
		stack
	}

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ExpanderTurnoutController)
		communicationService = new TrackCommunicationServiceLocator(createAndRegisterStack, new NOPLoggerFactory)
	}

	@After
	def void tearDown() {
		createdStacks.forEach[stack|stack.stop]
	}

	@Test
	def void enableHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(true)
		// create component
		componentUnderTest = new BBBComponent(createAndRegisterStack, expander, neverUsedInTests, new NOPLoggerFactory)

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
		// create component
		componentUnderTest = new BBBComponent(createAndRegisterStack, expander, neverUsedInTests, new NOPLoggerFactory)

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
		// create component
		componentUnderTest = new BBBComponent(createAndRegisterStack, expander, neverUsedInTests, new NOPLoggerFactory)

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
		// create component
		componentUnderTest = new BBBComponent(createAndRegisterStack, expander, neverUsedInTests, new NOPLoggerFactory)

		// Act
		communicationService.trackElementCommander.sendSegmentCommand(sectionId, SegmentState.DISABLED)

		// Assert
		Thread.sleep(50) // so that internal threads can handle transferred messages
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.never).disableSection(sectionId)
	}
}
