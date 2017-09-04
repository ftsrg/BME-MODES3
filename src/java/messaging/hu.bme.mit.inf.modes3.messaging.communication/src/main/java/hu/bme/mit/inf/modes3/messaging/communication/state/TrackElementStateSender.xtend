package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackElementStateSender implements ITrackElementStateSender {
	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	var MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		logger.trace('''SegmentOccupation message sent with id=«id» state=«state»''')
		mms.sendMessage(new SegmentOccupancyMessage(id, state))
	}

	override sendSegmentState(int id, SegmentState state) {
		logger.trace('''SegmentState message sent with id=«id» state=«state»''')
		mms.sendMessage(new SegmentStateMessage(id, state))
	}

	override sendTurnoutState(int id, TurnoutState state) {
		logger.trace('''TurnoutState message sent with id=«id» state=«state»''')
		mms.sendMessage(new TurnoutStateMessage(id, state))
	}

}
