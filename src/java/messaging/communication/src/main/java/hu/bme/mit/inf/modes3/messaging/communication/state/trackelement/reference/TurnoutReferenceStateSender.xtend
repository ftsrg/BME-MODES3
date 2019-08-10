package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutReferenceStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Sends the turnout's reference state.
 * 
 * @author benedekh
 */
class TurnoutReferenceStateSender implements ITurnoutReferenceStateSender {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	/**
	 * @param mms the messaging service to the track
	 * @param factory the logger factory
	 */
	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendTurnoutReferenceState(int id, TurnoutState state) {
		mms.sendMessage(new TurnoutReferenceStateMessage(id, state))
		logger.debug('''TurnoutReferenceState message sent with id=«id» state=«state»''')
	}

}
