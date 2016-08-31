package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent

import hu.bme.mit.inf.modes3.components.controller.enums.EnumTransformator
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState

class TrackElementStateSender extends ProtobufAbstractComponent {
	
	override onInit() {
	}

	def sendSegmentOccupation(int id, SegmentOccupancy state) {
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
	def sendSegmentState(int id, SegmentState state ){
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	def sendTurnoutState(int id, TurnoutState state){
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
}