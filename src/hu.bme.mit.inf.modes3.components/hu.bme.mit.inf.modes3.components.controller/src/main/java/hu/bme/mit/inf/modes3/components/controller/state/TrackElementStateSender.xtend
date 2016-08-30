package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState

class TrackElementStateSender extends ProtobufAbstractComponent {
	
	override onInit() {
	}

	def sendSegmentOccupation(int id, SegmentOccupancyValue state) {
		mms.sendMessage((SegmentOccupancy.newBuilder => [segmentID = id; it.state = state]).build)
	}
	
	def sendSegmentState(int id, SegmentStateValue state ){
		mms.sendMessage((SegmentState.newBuilder => [segmentID = id; it.state = state]).build)
	}

	def sendTurnoutState(int id, TurnoutStateValue state){
		mms.sendMessage((TurnoutState.newBuilder => [turnoutID = id; it.state = state]).build)
	}
	
}