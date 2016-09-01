package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.components.controller.enums.EnumTransformator
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand

class TrackElementCommander implements ITrackElementCommander {
	var MessagingService mms 
	new(MessagingService mms){
		this.mms = mms
	}
	override sendSegmentCommand(int id, SegmentState state) {
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutCommand(int id, TurnoutState state){
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
}
