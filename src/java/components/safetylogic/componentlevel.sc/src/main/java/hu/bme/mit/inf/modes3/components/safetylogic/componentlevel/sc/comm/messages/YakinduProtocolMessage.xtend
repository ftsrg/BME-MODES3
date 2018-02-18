package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.messages

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.ConnectionDirection
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import org.eclipse.xtend.lib.annotations.Data

@Data
class YakinduProtocolMessage extends InternalMessage {
	int targetID
	ConnectionDirection direction
	YakinduMessageType type
}
