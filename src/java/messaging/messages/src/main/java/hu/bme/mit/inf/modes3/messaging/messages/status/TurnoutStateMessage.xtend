package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.eclipse.xtend.lib.annotations.Data

/**
 * Status info about a turnout’s reference state, if it is straight or divergent.
 * 
 * @author benedekh
 */
@Data
class TurnoutStateMessage extends InternalMessage {
	int turnoutId
	TurnoutState state
}
