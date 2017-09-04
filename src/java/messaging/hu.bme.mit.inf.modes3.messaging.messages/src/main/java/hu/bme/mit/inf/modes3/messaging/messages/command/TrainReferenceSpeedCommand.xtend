package hu.bme.mit.inf.modes3.messaging.messages.command

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import org.eclipse.xtend.lib.annotations.Data

@Data
class TrainReferenceSpeedCommand extends InternalMessage {
	int trainId
	int referenceSpeed
	TrainDirection direction
}
