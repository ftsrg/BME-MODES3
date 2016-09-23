package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageBridgeToExternal
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageDispatcher
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.factory.YakinduCommunicationStackFactory
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCanGoTo
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCannotGoTo
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReleaseTo
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReserveTo
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduCanGoToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduCannotGoToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduReleaseToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduReserveToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.slf4j.helpers.NOPLoggerFactory

/**
 * YakinduMessageBridgeToExternalLocalTransportTests
 */
@Ignore
@RunWith(Theories)
class YakinduMessageExternalMQTTTranport {

	val createdStacks = new ArrayList<CommunicationStack>

	var YakinduMessageBridgeToExternal unitUnderTest

	var YakinduMessageDispatcher receiverDispatcher

	static val targetId = 12

	/****************************************************************************************************
	 * helper class, used by the @Theory tests
	 ****************************************************************************************************/
	static class TestTargetSegment {
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var int id
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var ConnectionDirection direction
	}

	/****************************************************************************************************
	 * fields: data points used by the @Theory tests
	 ****************************************************************************************************/
	@DataPoints
	public static var testParams = #[
		new TestTargetSegment => [id = targetId direction = ConnectionDirection.CW],
		new TestTargetSegment => [id = targetId direction = ConnectionDirection.CCW],
		new TestTargetSegment => [id = targetId direction = ConnectionDirection.DIVERGENT],
		new TestTargetSegment => [id = targetId direction = ConnectionDirection.STRAIGHT],
		new TestTargetSegment => [id = targetId direction = ConnectionDirection.TOP]
	]

	@Before
	def void init() {
		// create sender communication stack
		val senderStack = YakinduCommunicationStackFactory::createLocalMQTTStack(new NOPLoggerFactory)
		createdStacks.add(senderStack)
		senderStack.start

		unitUnderTest = new YakinduMessageBridgeToExternal(senderStack.mms, new NOPLoggerFactory)

		// create receiver communication stack
		receiverDispatcher = new YakinduMessageDispatcher(new NOPLoggerFactory)
		val receiverStack = YakinduCommunicationStackFactory::createLocalMQTTStackFromDispatcher(receiverDispatcher, new NOPLoggerFactory)
		createdStacks.add(receiverStack)
		receiverStack.start
	}

	@After
	def void tearDown() {
		createdStacks.forEach[stack|stack.stop]
	}

	@Theory
	def void sendReserveTo(TestTargetSegment target) {
		// Arrange
		val targetID = target.id
		val direction = target.direction
		val reserveToMock = Mockito.mock(IYakinduReserveTo)
		receiverDispatcher.reserveToHandler = new YakinduReserveToHandler(reserveToMock)

		// Act
		unitUnderTest.reserveTo(targetID, direction)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		Mockito.verify(reserveToMock, Mockito.times(1)).reserveTo(targetID, direction)
	}

	@Theory
	def void sendReleaseTo(TestTargetSegment target) {
		// Arrange
		val targetID = target.id
		val direction = target.direction
		val releaseToMock = Mockito.mock(IYakinduReleaseTo)
		receiverDispatcher.releaseToHandler = new YakinduReleaseToHandler(releaseToMock)

		// Act
		unitUnderTest.releaseTo(targetID, direction)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		Mockito.verify(releaseToMock, Mockito.times(1)).releaseTo(targetID, direction)
	}

	@Theory
	def void sendCanGoTo(TestTargetSegment target) {
		// Arrange
		val targetID = target.id
		val direction = target.direction
		val canGoToMock = Mockito.mock(IYakinduCanGoTo)
		receiverDispatcher.canGoToHandler = new YakinduCanGoToHandler(canGoToMock)

		// Act
		unitUnderTest.canGoTo(targetID, direction)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		Mockito.verify(canGoToMock, Mockito.times(1)).canGoTo(targetID, direction)
	}

	@Theory
	def void sendCannotGoTo(TestTargetSegment target) {
		// Arrange
		val targetID = target.id
		val direction = target.direction
		val cannotGoToMock = Mockito.mock(IYakinduCannotGoTo)
		receiverDispatcher.cannotGoToHandler = new YakinduCannotGoToHandler(cannotGoToMock)

		// Act
		unitUnderTest.cannotGoTo(targetID, direction)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		Mockito.verify(cannotGoToMock, Mockito.times(1)).cannotGoTo(targetID, direction)
	}

}
