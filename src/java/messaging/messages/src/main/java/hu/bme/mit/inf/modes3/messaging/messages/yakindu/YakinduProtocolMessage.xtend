package hu.bme.mit.inf.modes3.messaging.messages.yakindu

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection
import org.eclipse.xtend.lib.annotations.Data

@Data
class YakinduProtocolMessage extends InternalMessage {
	int targetID
	ConnectionDirection direction
	YakinduMessageType type
}
