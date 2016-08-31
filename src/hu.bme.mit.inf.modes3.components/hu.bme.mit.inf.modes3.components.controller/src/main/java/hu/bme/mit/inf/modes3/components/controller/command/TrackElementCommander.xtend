package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.components.controller.enums.EnumTransformator
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommander

class TrackElementCommander extends ProtobufAbstractComponent implements ITrackElementCommander {

	override onInit() {
	}

	override sendSegmentCommand(int id, SegmentState state) {
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutCommand(int id, TurnoutState state){
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
}
