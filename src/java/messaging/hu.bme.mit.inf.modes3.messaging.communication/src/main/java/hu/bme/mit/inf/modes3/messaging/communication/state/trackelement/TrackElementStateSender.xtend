package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateSender
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
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		mms.sendMessage(new SegmentOccupancyMessage(id, state))
		logger.debug('''SegmentOccupation message sent with id=«id» state=«state»''')
	}

	override sendSegmentState(int id, SegmentState state) {
		mms.sendMessage(new SegmentStateMessage(id, state))
		logger.debug('''SegmentState message sent with id=«id» state=«state»''')
	}

	override sendTurnoutState(int id, TurnoutState state) {
		mms.sendMessage(new TurnoutStateMessage(id, state))
		logger.debug('''TurnoutState message sent with id=«id» state=«state»''')
	}

}
