package hu.bme.mit.inf.modes3.messaging.messages.yakindu

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection
import org.eclipse.xtend.lib.annotations.Data

/**
 * A protocol message between the state machines in Yakindu.
 * 
 * @author benedekh
 */
@Data
class YakinduProtocolMessage extends InternalMessage {
	int targetID
	ConnectionDirection direction
	YakinduMessageType type
}
