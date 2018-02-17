package hu.bme.mit.inf.modes3.components.touchboard.bridge

import hu.bme.mit.inf.modes3.components.touchboard.controller.ITouchboardController
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

class TouchboardBridge extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener, ISegmentStateChangeListener, ITurnoutStateChangeListener, ITouchboardBridge {

	val ITouchboardController touchboardController

	new(ITouchboardController touchboardController, MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.touchboardController = touchboardController
		this.touchboardController.touchboardBridge = this

		locator.trackElementStateRegistry.registerSegmentOccupancyChangeListener = this
		locator.trackElementStateRegistry.registerSegmentStateChangeListener = this
		locator.trackElementStateRegistry.registerTurnoutStateChangeListener = this
	}

	override run() {
		touchboardController.run
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		touchboardController.onSegmentOccupancyChange(id, oldValue, newValue)
	}

	override onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue) {
		touchboardController.onSegmentStateChange(id, oldValue, newValue)
	}

	override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		touchboardController.onTurnoutStateChange(id, oldValue, newValue)
	}

	override getTrainCommander() {
		locator.trainCommander
	}

	override sendAllStatusCommand() {
		locator.trackElementCommander.sendAllStatusCommand
	}

	override getSegmentState(int segmentId) {
		locator.trackElementStateRegistry.getSegmentState(segmentId)
	}

	override sendSegmentCommand(int segmentId, SegmentState state) {
		locator.trackElementCommander.sendSegmentCommand(segmentId, state)
	}

	override getTurnoutState(int turnoutId) {
		locator.trackElementStateRegistry.getTurnoutState(turnoutId)
	}

	override sendTurnoutCommandWithTurnoutId(int turnoutId, TurnoutState state) {
		locator.trackElementCommander.sendTurnoutCommandWithTurnoutId(turnoutId, state)
	}

}
