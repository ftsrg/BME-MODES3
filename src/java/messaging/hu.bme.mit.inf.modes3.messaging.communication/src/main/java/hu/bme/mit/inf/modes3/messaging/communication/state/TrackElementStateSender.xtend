package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.Logger

class TrackElementStateSender implements ITrackElementStateSender {
	var MessagingService mms
	val Logger logger
	new(MessagingService mms, Logger logger){
		this.mms = mms
		this.logger = logger
	}
	
	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		logger.trace('''SegmentOccupation message sent with id=«id» state=«state»''')
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
	override sendSegmentState(int id, SegmentState state ){
		logger.trace('''SegmentState message sent with id=«id» state=«state»''')
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutState(int id, TurnoutState state){
		logger.trace('''TurnoutState message sent with id=«id» state=«state»''')
		mms.sendMessage((hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
}
						