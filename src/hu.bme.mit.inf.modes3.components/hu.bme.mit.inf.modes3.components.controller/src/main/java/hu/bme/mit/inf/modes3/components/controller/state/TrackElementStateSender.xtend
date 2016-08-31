package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent

import hu.bme.mit.inf.modes3.components.controller.enums.EnumTransformator
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITrackElementStateSender

class TrackElementStateSender extends ProtobufAbstractComponent implements ITrackElementStateSender {
	
	override onInit() {
	}

	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
	override sendSegmentState(int id, SegmentState state ){
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutState(int id, TurnoutState state){
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
}