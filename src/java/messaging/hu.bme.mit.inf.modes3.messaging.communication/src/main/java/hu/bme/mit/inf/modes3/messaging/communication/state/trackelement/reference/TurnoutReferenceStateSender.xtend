package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutReferenceStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TurnoutReferenceStateSender implements ITurnoutReferenceStateSender {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendTurnoutReferenceState(int id, TurnoutState state) {
		logger.trace('''TurnoutReferenceState message sent with id=«id» state=«state»''')
		mms.sendMessage(new TurnoutReferenceStateMessage(id, state))
	}

}
