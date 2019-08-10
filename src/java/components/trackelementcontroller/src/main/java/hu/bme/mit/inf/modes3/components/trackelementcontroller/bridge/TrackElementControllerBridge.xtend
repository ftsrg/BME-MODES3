package hu.bme.mit.inf.modes3.components.trackelementcontroller.bridge

import hu.bme.mit.inf.modes3.components.trackelementcontroller.ITrackElementController
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

/**
 * The bridge between the track element controller application and the communication network.
 * 
 * @author benedekh
 */
class TrackElementControllerBridge extends AbstractCommunicationComponent implements ISendAllStatusListener, ISegmentCommandListener, ITurnoutCommandListener, ITrackElementControllerBridge {

	val ITrackElementController trackElementController

	/**
	 * @param trackElementController the track element controller application
	 * @param messagingService the messaging service to the railway track
	 * @param factory the logger factory
	 */
	new(ITrackElementController trackElementController, MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.trackElementController = trackElementController
		this.trackElementController.trackElementControllerBridge = this

		locator.sendAllStatusCallback.sendAllStatusListener = this
		locator.trackElementCommandCallback.segmentCommandListener = this
		locator.trackElementCommandCallback.turnoutCommandListener = this
	}

	override run() {
		trackElementController.run
	}

	override onSendAllStatus() {
		trackElementController.onSendAllStatus
	}

	override onSegmentCommand(int id, SegmentState state) {
		trackElementController.onSegmentCommand(id, state)
	}

	override onTurnoutCommand(int id, TurnoutState state) {
		trackElementController.onTurnoutCommand(id, state)
	}

	override sendSegmentState(int id, SegmentState state) {
		locator.trackElementStateSender.sendSegmentState(id, state)
	}

	override sendTurnoutState(int id, TurnoutState state) {
		locator.trackElementStateSender.sendTurnoutState(id, state)
	}

	override getTrackElementStateRegistry() {
		locator.trackElementStateRegistry
	}

}
