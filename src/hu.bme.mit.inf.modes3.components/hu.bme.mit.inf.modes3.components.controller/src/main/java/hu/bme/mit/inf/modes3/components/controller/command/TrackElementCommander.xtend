package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.components.controller.enums.EnumTransformator
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand

class TrackElementCommander extends ProtobufAbstractComponent {

	override onInit() {
	}

	def sendSegmentCommand(int id, SegmentState state) {
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	def sendTurnoutCommand(int id, TurnoutState state){
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
}
