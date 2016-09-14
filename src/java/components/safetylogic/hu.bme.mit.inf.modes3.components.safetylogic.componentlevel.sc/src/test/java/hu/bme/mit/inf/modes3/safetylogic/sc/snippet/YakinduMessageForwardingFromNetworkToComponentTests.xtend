package hu.bme.mit.inf.modes3.safetylogic.sc.snippet

import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.messaging.mms.messages.MessageType
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo
import hu.bme.mit.inf.modes3.safetylogic.sc.network.YakinduNetworkMessageDispatcher
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.YakinduReleaseToHandler
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.YakinduReserveResultToHandler
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.YakinduReserveToHandler
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito


@Ignore
@Deprecated
@RunWith(Theories)
class YakinduMessageForwardingFromNetworkToComponentTests {

	/****************************************************************************************************
	 * helper class, used by the @Theory tests
	 ****************************************************************************************************/
	static class TestTargetSegment {
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var int id
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var ConnectionDirection direction
		// used by the reserve result tests
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var boolean reserveResult
	}

	/****************************************************************************************************
	 * fields: data points used by the @Theory tests
	 ****************************************************************************************************/
	@DataPoints
	public static var reserveToLeftOrRightParams = #[
		new TestTargetSegment => [id = 12 direction = ConnectionDirection.LEFT reserveResult = false],
		new TestTargetSegment => [id = 15 direction = ConnectionDirection.RIGHT reserveResult = false],
		new TestTargetSegment => [id = 12 direction = ConnectionDirection.LEFT reserveResult = true],
		new TestTargetSegment => [id = 15 direction = ConnectionDirection.RIGHT reserveResult = true]
	]

	@DataPoints
	// used by the reserveResultToBottomTest(reserveResult: boolean) test
	public static var reserveResultToBottomParams = #[true, false]

	/****************************************************************************************************
	 * fields: unit under test, mocks and classes for simulating message receive over the network
	 ****************************************************************************************************/
	var Component1 unitUnderTest

	// network communication dispatchers (in each test a Protobuf message is received that triggers the test)
	var YakinduNetworkMessageDispatcher messageDispatcher
	var YakinduReleaseToHandler releaseToHandler
	var YakinduReserveResultToHandler reserveResultToHandler
	var YakinduReserveToHandler reserveToHandler

	@Mock
	var SectionComponent sectionComponentMock
	@Mock
	var TurnoutComponent turnoutComponentMock

	/****************************************************************************************************
	 * methods: initializer method and tests
	 ****************************************************************************************************/
	@Before
	def void init() {
		unitUnderTest = new Component1(null) // TODO
		// initialize network message handlers
		releaseToHandler = new YakinduReleaseToHandler(unitUnderTest)
		reserveToHandler = new YakinduReserveToHandler(unitUnderTest)
		reserveResultToHandler = new YakinduReserveResultToHandler(unitUnderTest)

		// register the network message handlers
		messageDispatcher = new YakinduNetworkMessageDispatcher
		messageDispatcher.releaseToHandler = releaseToHandler
		messageDispatcher.reserveResultToHandler = reserveResultToHandler
		messageDispatcher.reserveToHandler = reserveToHandler
	}

	/**********************************************************************************
	 * reserveTo[Left|Right|Bottom] tests
	 **********************************************************************************/
	private def createReserveToMessageBytes(int targetID, ConnectionDirection direction) {
		val messageContent = (YakinduReserveTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(direction)
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_RESERVE_TO
		message.yakinduReserveTo = messageContent
		message.build.toByteArray
	}

	@Ignore
	@Theory
	def void reserveToLeftOrRightTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction

		sectionComponentMock = Mockito.mock(SectionComponent)
		unitUnderTest.mockSectionComponent("S" + targetID, sectionComponentMock)

		// Act
		messageDispatcher.dispatchMessage(createReserveToMessageBytes(targetID, direction))

		// Assert
		switch (direction) {
			case LEFT: Mockito.verify(sectionComponentMock, Mockito.times(1)).raiseReserveFromLeft
			case RIGHT: Mockito.verify(sectionComponentMock, Mockito.times(1)).raiseReserveFromRight
			default: Assert.fail
		}
	}

	@Ignore
	@Test
	def void reserveToBottomTest() {
		// Arrange
		val targetID = 1
		val direction = ConnectionDirection.BOTTOM

		turnoutComponentMock = Mockito.mock(TurnoutComponent)
		unitUnderTest.mockTurnoutComponent("T" + targetID, turnoutComponentMock)

		// Act
		messageDispatcher.dispatchMessage(createReserveToMessageBytes(targetID, direction))

		// Assert
		Mockito.verify(turnoutComponentMock, Mockito.times(1)).raiseReserveFromBottom
	}

	/**********************************************************************************
	 * reserveResultTo[Left|Right|Bottom] tests
	 **********************************************************************************/
	private def byte[] createReserveResultToMessageBytes(int targetID, ConnectionDirection direction, boolean result) {
		val messageContent = (YakinduReserveResultTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(direction)
			it.result = result
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_RESERVE_RESULT_TO
		message.yakinduReserveResultTo = messageContent
		message.build.toByteArray
	}

	@Ignore
	@Theory
	def void reserveResultToLeftOrRightTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction
		val result = targetSegment.reserveResult

		sectionComponentMock = Mockito.mock(SectionComponent)
		unitUnderTest.mockSectionComponent("S" + targetID, sectionComponentMock)

		// Act
		messageDispatcher.dispatchMessage(createReserveResultToMessageBytes(targetID, direction, result))

		// Assert
		Mockito.verify(sectionComponentMock, Mockito.times(1)).raiseReserveResult(result)
	}

	@Ignore
	@Theory
	def void reserveResultToBottomTest(boolean reserveResult) {
		// Arrange
		val targetID = 1
		val direction = ConnectionDirection.BOTTOM
		val result = reserveResult

		turnoutComponentMock = Mockito.mock(TurnoutComponent)
		unitUnderTest.mockTurnoutComponent("T" + targetID, turnoutComponentMock)

		// Act
		messageDispatcher.dispatchMessage(createReserveResultToMessageBytes(targetID, direction, result))

		// Assert
		Mockito.verify(turnoutComponentMock, Mockito.times(1)).raiseReserveResultFromBottom(result)
	}

	/**********************************************************************************
	 * releaseTo[Left|Right|Bottom] tests
	 **********************************************************************************/
	private def byte[] createReleaseToMessageBytes(int targetID, ConnectionDirection direction) {
		val messageContent = (YakinduReleaseTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(direction)
		]).build

		val message = Message.newBuilder
		message.type = MessageType.YAKINDU_RELEASE_TO
		message.yakinduReleaseTo = messageContent
		message.build.toByteArray
	}

	@Ignore
	@Theory
	def void releaseToLeftOrRightTest(TestTargetSegment targetSegment) {
		// Arrange
		val targetID = targetSegment.id
		val direction = targetSegment.direction

		sectionComponentMock = Mockito.mock(SectionComponent)
		unitUnderTest.mockSectionComponent("S" + targetID, sectionComponentMock)

		// Act
		messageDispatcher.dispatchMessage(createReleaseToMessageBytes(targetID, direction))

		// Assert
		Mockito.verify(sectionComponentMock, Mockito.times(1)).raiseRelease
	}

	@Ignore
	@Test
	def void releaseToBottomTest() {
		// Arrange
		val targetID = 1
		val direction = ConnectionDirection.BOTTOM

		turnoutComponentMock = Mockito.mock(TurnoutComponent)
		unitUnderTest.mockTurnoutComponent("T" + targetID, turnoutComponentMock)

		// Act
		messageDispatcher.dispatchMessage(createReleaseToMessageBytes(targetID, direction))

		// Assert
		Mockito.verify(turnoutComponentMock, Mockito.times(1)).raiseReleaseFromBottom
	}

}
