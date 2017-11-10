package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.eclipse.xtend.lib.annotations.Data

@Data
class TurnoutReferenceStateMessage extends InternalMessage {
	int turnoutId
	TurnoutState state
}