package hu.bme.mit.inf.modes3.components.trackelementstatus.wrapper

import hu.bme.mit.inf.modes3.components.trackelementstatus.ITrackSupervisor
import hu.bme.mit.inf.modes3.components.trackelementstatus.comm.StatusReporter
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

class TrackSupervisorWrapper extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener, ITurnoutStateChangeListener, ITrackSupervisorWrapper {

	val StatusReporter segmentStatusReporter
	val StatusReporter turnoutStatusReporter

	val ITrackSupervisor trackSupervisor

	new(ITrackSupervisor trackSupervisor, MessagingService railwayTrackStack, MessagingService segmentStatusStack,
		MessagingService turnoutStatusStack, ILoggerFactory factory) {
		super(railwayTrackStack, factory)
		super.locator.trackElementStateRegistry.segmentOccupancyChangeListener = this
		super.locator.trackElementStateRegistry.turnoutStateChangeListener = this

		this.segmentStatusReporter = new StatusReporter(segmentStatusStack, factory)
		this.turnoutStatusReporter = new StatusReporter(turnoutStatusStack, factory)

		this.trackSupervisor = trackSupervisor
		this.trackSupervisor.supervisorWrapper = this
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		trackSupervisor.onSegmentOccupancyChange(id, oldValue, newValue)
	}

	override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		trackSupervisor.onTurnoutStateChange(id, oldValue, newValue)
	}

	override sendSegmentStatusMessage(int id, String status) {
		segmentStatusReporter.sendStatusMessage(id, status)
	}

	override sendTurnoutStatusMessage(int id, String status) {
		turnoutStatusReporter.sendStatusMessage(id, status)
	}

	override run() {
		Thread.currentThread.join
	}

}
