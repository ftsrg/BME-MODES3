package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import org.eclipse.xtend.lib.annotations.Data

@Data
class TrainCurrentSpeedMessage extends InternalMessage {
	int trainId
	int currentSpeed
	TrainDirection direction
}
