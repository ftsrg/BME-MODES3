package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
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
import org.yakindu.scr.section.ISectionStatemachine
import org.yakindu.scr.section.ISectionStatemachine.SCISection
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener

class SectionCommandToExternalTransmitterMQTTTransport {

	val createdStacks = new ArrayList<CommunicationStack>

	var SectionCommandToExternalTransmitter unitUnderTest

	@Mock
	var ISegmentCommandListener receiverMock

	@Mock
	var ISectionStatemachine notUsedInTests

	private def createAndRegisterStack() {
		val stack = CommunicationStackFactory::createLocalMQTTStack
		createdStacks.add(stack)
		stack
	}

	@Before
	def void init() {
		// create fake mock for ISectionStatemachine
		notUsedInTests = Mockito.mock(ISectionStatemachine)
		val sciSectionMock = Mockito.mock(SCISection)
		Mockito.when(notUsedInTests.SCISection).thenReturn(sciSectionMock)
		Mockito.when(sciSectionMock.listeners).thenReturn(new ArrayList<SCISectionListener>)

		// stack used for sending messages over the network
		val senderStack = new TrackCommunicationServiceLocator(createAndRegisterStack, new NOPLoggerFactory)

		// register mock and track element commander
		unitUnderTest = new SectionCommandToExternalTransmitter(notUsedInTests, senderStack.trackElementCommander, new NOPLoggerFactory)

		// create receiver mock
		receiverMock = Mockito.mock(ISegmentCommandListener)
	}

	@After
	def void tearDown() {
		createdStacks.forEach[stack|stack.stop]
	}

	@Test
	def void enableSection() {
		// Arrange
		val targetID = 12
		val receiverStack = new TrackCommunicationServiceLocator(createAndRegisterStack, new NOPLoggerFactory)

		receiverStack.trackElementCommandCallback.segmentCommandListener = receiverMock

		// Act
		unitUnderTest.onEnableSectionRaised(targetID)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		Mockito.verify(receiverMock, Mockito.times(1)).onSegmentCommand(targetID, SegmentState.ENABLED)
	}

	@Test
	def void disableSection() {
		// Arrange
		val targetID = 12
		val receiverStack = new TrackCommunicationServiceLocator(createAndRegisterStack, new NOPLoggerFactory)
		receiverStack.trackElementCommandCallback.segmentCommandListener = receiverMock

		// Act
		unitUnderTest.onDisableSectionRaised(targetID)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		Mockito.verify(receiverMock, Mockito.times(1)).onSegmentCommand(targetID, SegmentState.DISABLED)
	}

}
