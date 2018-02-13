package hu.bme.mit.inf.safetylogic.event.bridge

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.safetylogic.event.sl.ISafetyLogic
import org.slf4j.ILoggerFactory
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

class SafetyLogicBridge extends AbstractCommunicationComponent implements ISafetyLogicBridge {

	val ISafetyLogic safetyLogic

	new(ISafetyLogic safetyLogic, MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.safetyLogic = safetyLogic
		this.safetyLogic.safetyLogicBridge = this
	}

	override run() {
		safetyLogic.run
	}

	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		locator.trackElementStateSender.sendSegmentOccupation(id, state)
	}

	override sendSegmentState(int id, SegmentState state) {
		locator.trackElementStateSender.sendSegmentState(id, state)
	}

	override sendTurnoutState(int id, TurnoutState state) {
		locator.trackElementStateSender.sendTurnoutState(id, state)
	}

	override sendSegmentCommand(int id, SegmentState state) {
		locator.trackElementCommander.sendSegmentCommand(id, state)
	}

	override sendTurnoutCommand(int segmentId, TurnoutState state) {
		locator.trackElementCommander.sendTurnoutCommand(segmentId, state)
	}

	override setSendAllStatusListener(ISendAllStatusListener listener) {
		locator.sendAllStatusCallback.sendAllStatusListener = listener
	}

	override setSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener) {
		locator.trackElementStateRegistry.registerSegmentOccupancyChangeListener = listener
	}

	override setTurnoutStateChangeListener(ITurnoutStateChangeListener listener) {
		locator.trackElementStateRegistry.registerTurnoutStateChangeListener = listener
	}

	override setComputerVisionListener(IComputerVisionListener listener) {
		locator.computerVisionCallback.computerVisionListener = listener
	}

	override getTrackElementCommander() {
		locator.trackElementCommander
	}

	override getTrainCommander() {
		locator.trainCommander
	}

	override getTrainSpeedStateRegistry() {
		locator.trainSpeedStateRegistry
	}
	
	override sendTrainReferenceSpeed(int id, int speed, TrainDirection trainDirection) {
		locator.trainCommander.setTrainReferenceSpeedAndDirection(id, speed, trainDirection)
	}

}
