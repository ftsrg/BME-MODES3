package hu.bme.mit.inf.modes3.messaging.messages.command

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.eclipse.xtend.lib.annotations.Data

@Data
class TurnoutCommand extends InternalMessage {
	int turnoutId
	TurnoutState state
}
