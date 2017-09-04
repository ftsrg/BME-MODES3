package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import org.eclipse.xtend.lib.annotations.Data

@Data
class DccOperationsStateMessage extends InternalMessage{
	DccOperations dccOperations
}