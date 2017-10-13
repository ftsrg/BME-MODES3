package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import org.eclipse.xtend.lib.annotations.Data

@Data
class TrainFunctionStateMessage extends InternalMessage {
	int trainId
	TrainFunction trainFunction
}
