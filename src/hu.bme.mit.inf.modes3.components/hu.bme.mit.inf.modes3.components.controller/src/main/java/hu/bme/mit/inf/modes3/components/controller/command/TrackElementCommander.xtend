package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand

class TrackElementCommander extends ProtobufAbstractComponent {

	override onInit() {
	}

	def sendSegmentCommand(int id, SegmentStateValue state) {
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = state]).build)
	}

	def sendTurnoutCommand(int id, TurnoutStateValue state){
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = state]).build)
	}
	
}
