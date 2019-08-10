package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.eclipse.xtend.lib.annotations.Data

/**
 * Status info about a turnout’s reference state (if it is straight or divergent), set by the train controller (MultiMaus).
 * 
 * @author benedekh
 */
@Data
class TurnoutReferenceStateMessage extends InternalMessage {
	int turnoutId
	TurnoutState state
}