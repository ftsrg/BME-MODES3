package hu.bme.mit.inf.modes3.components.safetylogic.sc

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageBridgeToInternal
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageDispatcher
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduCanGoToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduCannotGoToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduReleaseToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduReserveToHandler
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionConverter
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.messaging.mms.messages.MessageType
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCanGoTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCannotGoTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.yakindu.scr.section.ISectionStatemachine
import org.yakindu.scr.turnout.ITurnoutStatemachine

@RunWith(Theories)
class YakinduMessageForwardingFromNetworkToInternal {

	/****************************************************************************************************
	 * fields: unit under test, mocks and classes for simulating message receive over the network
	 ****************************************************************************************************/
	var YakinduMessageBridgeToInternal unitUnderTest

	// network communication dispatcher (in each test a Protobuf message is received that triggers the test)
	var YakinduMessageDispatcher messageDispatcher

	@Mock
	var ISectionStatemachine.SCIProtocol sectionStatemachineSCIProtocolMock
	static val sectionStatemachineId = 12

	@Mock
	var ITurnoutStatemachine.SCIProtocol turnoutStatemachineSCIProtocolMock
	static val turnoutStatemachineId = 15

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
		new TestTargetSegment => [id = sectionStatemachineId direction = ConnectionDirection.CW],
		new TestTargetSegment => [id = sectionStatemachineId direction = ConnectionDirection.CCW],
		new TestTargetSegment => [id = turnoutStatemachineId direction = ConnectionDirection.DIVERGENT],
		new TestTargetSegment => [id = turnoutStatemachineId direction = ConnectionDirection.STRAIGHT],
		new TestTargetSegment => [id = turnoutStatemachineId direction = ConnectionDirection.TOP]
	]

	/****************************************************************************************************
	 * methods: initializer method and tests
	 ****************************************************************************************************/
	@Before
	def void init() {
		unitUnderTest = new YakinduMessageBridgeToInternal

		// register the network message handlers
		messageDispatcher = new YakinduMessageDispatcher
		messageDispatcher.releaseToHandler = new YakinduReleaseToHandler(unitUnderTest)
		messageDispatcher.reserveToHandler = new YakinduReserveToHandler(unitUnderTest)
		messageDispatcher.canGoToHandler = new YakinduCanGoToHandler(unitUnderTest)
		messageDispatcher.cannotGoToHandler = new YakinduCannotGoToHandler(unitUnderTest)

		// create mocks
		val sectionStatemachineMock = Mockito.mock(ISectionStatemachine)
		sectionStatemachineSCIProtocolMock = Mockito.mock(ISectionStatemachine.SCIProtocol)
		Mockito.when(sectionStatemachineMock.SCIProtocol).thenReturn(sectionStatemachineSCIProtocolMock)
		unitUnderTest.registerSectionStatemachine(12, sectionStatemachineMock)

		val turnoutStatemachineMock = Mockito.mock(ITurnoutStatemachine)
		turnoutStatemachineSCIProtocolMock = Mockito.mock(ITurnoutStatemachine.SCIProtocol)
		Mockito.when(turnoutStatemachineMock.SCIProtocol).thenReturn(turnoutStatemachineSCIProtocolMock)
		unitUnderTest.registerTurnoutStatemachine(15, turnoutStatemachineMock)
	}

	/**********************************************************************************
	 * reserveTo[CW|CCW|TOP|STRAIGHT|DIVERGENT] tests
	 **********************************************************************************/
	private def createReserveToMessageBytes(int targetID, ConnectionDirection direction) {
		val messageContent = (YakinduReserveTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionConverter.toProtobufDirection(direction)
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_RESERVE_TO
		message.yakinduReserveTo = messageContent
		message.build.toByteArray
	}

	@Theory
	def void reserveToTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction

		// Act
		messageDispatcher.dispatchMessage(createReserveToMessageBytes(targetID, direction))

		// Assert
		if(sectionStatemachineId == targetID) {
			Mockito.verify(sectionStatemachineSCIProtocolMock, Mockito.times(1)).raiseReserveFrom(direction.valueInYakindu)
		} else {
			Assert.assertEquals(turnoutStatemachineId, targetID)
			Mockito.verify(turnoutStatemachineSCIProtocolMock, Mockito.times(1)).raiseReserveFrom(direction.valueInYakindu)
		}
	}

	/**********************************************************************************
	 * releaseTo[CW|CCW|TOP|STRAIGHT|DIVERGENT] tests
	 **********************************************************************************/
	private def createReleaseToMessageBytes(int targetID, ConnectionDirection direction) {
		val messageContent = (YakinduReleaseTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionConverter.toProtobufDirection(direction)
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_RELEASE_TO
		message.yakinduReleaseTo = messageContent
		message.build.toByteArray
	}

	@Theory
	def void releaseToTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction

		// Act
		messageDispatcher.dispatchMessage(createReleaseToMessageBytes(targetID, direction))

		// Assert
		if(sectionStatemachineId == targetID) {
			Mockito.verify(sectionStatemachineSCIProtocolMock, Mockito.times(1)).raiseReleaseFrom(direction.valueInYakindu)
		} else {
			Assert.assertEquals(turnoutStatemachineId, targetID)
			Mockito.verify(turnoutStatemachineSCIProtocolMock, Mockito.times(1)).raiseReleaseFrom(direction.valueInYakindu)
		}
	}

	/**********************************************************************************
	 * canGoTo[CW|CCW|TOP|STRAIGHT|DIVERGENT] tests
	 **********************************************************************************/
	private def createCanGoToMessageBytes(int targetID, ConnectionDirection direction) {
		val messageContent = (YakinduCanGoTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionConverter.toProtobufDirection(direction)
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_CAN_GO_TO
		message.yakinduCanGoTo = messageContent
		message.build.toByteArray
	}

	@Theory
	def void canGoToTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction

		// Act
		messageDispatcher.dispatchMessage(createCanGoToMessageBytes(targetID, direction))

		// Assert
		if(sectionStatemachineId == targetID) {
			Mockito.verify(sectionStatemachineSCIProtocolMock, Mockito.times(1)).raiseCanGoFrom(direction.valueInYakindu)
		} else {
			Assert.assertEquals(turnoutStatemachineId, targetID)
			Mockito.verify(turnoutStatemachineSCIProtocolMock, Mockito.times(1)).raiseCanGoFrom(direction.valueInYakindu)
		}
	}

	/**********************************************************************************
	 * cannotGoTo[CW|CCW|TOP|STRAIGHT|DIVERGENT] tests
	 **********************************************************************************/
	private def createCannotGoToMessageBytes(int targetID, ConnectionDirection direction) {
		val messageContent = (YakinduCannotGoTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionConverter.toProtobufDirection(direction)
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_CANNOT_GO_TO
		message.yakinduCannotGoTo = messageContent
		message.build.toByteArray
	}

	@Theory
	def void cannotGoToTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction

		// Act
		messageDispatcher.dispatchMessage(createCannotGoToMessageBytes(targetID, direction))

		// Assert
		if(sectionStatemachineId == targetID) {
			Mockito.verify(sectionStatemachineSCIProtocolMock, Mockito.times(1)).raiseCannotGoFrom(direction.valueInYakindu)
		} else {
			Assert.assertEquals(turnoutStatemachineId, targetID)
			Mockito.verify(turnoutStatemachineSCIProtocolMock, Mockito.times(1)).raiseCannotGoFrom(direction.valueInYakindu)
		}
	}

}
