package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter

import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.TrackElementStatusToInternalTransmitter
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
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
import org.slf4j.helpers.NOPLoggerFactory
import org.yakindu.scr.section.ISectionStatemachine
import org.yakindu.scr.turnout.ITurnoutStatemachine

@RunWith(Theories)
class StatusMessageForwardingFromLocalTransportNetworkToInternal {

	/****************************************************************************************************
	 * fields: unit under test, mocks and classes for simulating message receive over the network
	 ****************************************************************************************************/
	var TrackElementStatusToInternalTransmitter unitUnderTest

	// network communication dispatcher (in each test a Protobuf message is received that triggers the test)
	var ITrackElementStateSender stateSender

	@Mock
	var ISectionStatemachine.SCITrain sectionStatemachineSCITrainMock
	static val sectionStatemachineId = 12

	@Mock
	var ITurnoutStatemachine.SCITrain turnoutStatemachineSCITrainMock
	var ITurnoutStatemachine.SCITurnout turnoutStatemachineSCITurnoutMock
	static val turnoutStatemachineId = 15

	/****************************************************************************************************
	 * helper class, used by the @Theory tests
	 ****************************************************************************************************/
	static class TargetSectionStatus {
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var int id
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var SegmentOccupancy occupancy
	}

	static class TargetTurnoutOccupancyStatus {
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var int id
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var SegmentOccupancy occupancy
	}

	static class TargetTurnoutDirectionStatus {
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var int id
		@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) var TurnoutState state
	}

	/****************************************************************************************************
	 * fields: data points used by the @Theory tests
	 ****************************************************************************************************/
	@DataPoints
	public static var sectionTestParams = #[
		new TargetSectionStatus => [id = sectionStatemachineId occupancy = SegmentOccupancy.FREE],
		new TargetSectionStatus => [id = sectionStatemachineId occupancy = SegmentOccupancy.OCCUPIED]
	]

	@DataPoints
	public static var turnoutOccupancyTestParams = #[
		new TargetTurnoutOccupancyStatus => [id = turnoutStatemachineId occupancy = SegmentOccupancy.FREE],
		new TargetTurnoutOccupancyStatus => [id = turnoutStatemachineId occupancy = SegmentOccupancy.OCCUPIED]
	]

	@DataPoints
	public static var turnoutDirectionTestParams = #[
		new TargetTurnoutDirectionStatus => [id = turnoutStatemachineId state = TurnoutState.STRAIGHT],
		new TargetTurnoutDirectionStatus => [id = turnoutStatemachineId state = TurnoutState.DIVERGENT]
	]

	/****************************************************************************************************
	 * methods: initializer method and tests
	 ****************************************************************************************************/
	@Before
	def void init() {
		val receiverStack = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack, (new NOPLoggerFactory).getLogger(''))
		unitUnderTest = new TrackElementStatusToInternalTransmitter(receiverStack.trackElementStateRegistry)

		val senderStack = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack, (new NOPLoggerFactory).getLogger(''))
		stateSender = senderStack.trackElementStateSender

		// create mocks
		val sectionStatemachineMock = Mockito.mock(ISectionStatemachine)
		sectionStatemachineSCITrainMock = Mockito.mock(ISectionStatemachine.SCITrain)
		val sectionStatemachineSCIProtocolMock = Mockito.mock(ISectionStatemachine.SCIProtocol)
		Mockito.when(sectionStatemachineMock.SCITrain).thenReturn(sectionStatemachineSCITrainMock)
		Mockito.when(sectionStatemachineMock.SCIProtocol).thenReturn(sectionStatemachineSCIProtocolMock)
		unitUnderTest.registerSectionStatemachine(12, sectionStatemachineMock)

		val turnoutStatemachineMock = Mockito.mock(ITurnoutStatemachine)
		turnoutStatemachineSCITrainMock = Mockito.mock(ITurnoutStatemachine.SCITrain)
		turnoutStatemachineSCITurnoutMock = Mockito.mock(ITurnoutStatemachine.SCITurnout)
		Mockito.when(turnoutStatemachineMock.SCITrain).thenReturn(turnoutStatemachineSCITrainMock)
		Mockito.when(turnoutStatemachineMock.SCITurnout).thenReturn(turnoutStatemachineSCITurnoutMock)
		unitUnderTest.registerTurnoutStatemachine(15, turnoutStatemachineMock)
	}

	@Test
	def void test() {
		Assert.assertTrue(true)
	}

	@Theory
	def void testSectionOccupancyStatus(TargetSectionStatus sectionStatus) {
		// Arrange
		val targetID = sectionStatus.id
		val occupancy = sectionStatus.occupancy

		// Act
		stateSender.sendSegmentOccupation(targetID, occupancy)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		switch (occupancy) {
			case FREE: Mockito.verify(sectionStatemachineSCITrainMock, Mockito.times(1)).raiseUnoccupy
			case OCCUPIED: Mockito.verify(sectionStatemachineSCITrainMock, Mockito.times(1)).raiseOccupy
		}
	}

	@Theory
	def void testTurnoutOccupancyStatus(TargetTurnoutOccupancyStatus turnoutStatus) {
		// Arrange
		val targetID = turnoutStatus.id
		val occupancy = turnoutStatus.occupancy

		// Act
		stateSender.sendSegmentOccupation(targetID, occupancy)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		switch (occupancy) {
			case FREE: Mockito.verify(turnoutStatemachineSCITrainMock, Mockito.times(1)).raiseUnoccupy
			case OCCUPIED: Mockito.verify(turnoutStatemachineSCITrainMock, Mockito.times(1)).raiseOccupy
		}
	}

	@Theory
	def void testTurnoutDirectionStatus(TargetTurnoutDirectionStatus turnoutStatus) {
		// Arrange
		val targetID = turnoutStatus.id
		val direction = turnoutStatus.state

		// Act
		stateSender.sendTurnoutState(targetID, direction)

		// Assert
		Thread.sleep(50) // give time to the message to get through the network
		switch (direction) {
			case STRAIGHT: Mockito.verify(turnoutStatemachineSCITurnoutMock, Mockito.times(1)).raiseTurnoutStraight
			case DIVERGENT: Mockito.verify(turnoutStatemachineSCITurnoutMock, Mockito.times(1)).raiseTurnoutDivergent
		}
	}

}
