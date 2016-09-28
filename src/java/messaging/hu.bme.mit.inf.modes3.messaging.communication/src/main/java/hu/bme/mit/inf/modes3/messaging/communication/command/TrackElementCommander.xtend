package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.common.Commander
import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand
import org.slf4j.ILoggerFactory

class TrackElementCommander extends Commander implements ITrackElementCommander {

	new(MessagingService mms, ILoggerFactory factory) {
		super(mms, factory)
	}
	
	override sendSegmentCommand(int id, SegmentState state) {
		logger.trace('''SegmentCommand message sent with id=«id» state=«state»''')
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutCommand(int id, TurnoutState state) {
		logger.trace('''TurnoutCommand message sent with id=«id» state=«state»''')
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

}
