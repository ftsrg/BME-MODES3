package hu.bme.mit.inf.modes3.messaging.messages.command

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import org.eclipse.xtend.lib.annotations.Data

/**
 * A command to set the speed and direction of a train. It should be executed by the DCC (via XPressNet) protocol.
 * 
 * @author benedekh
 */
@Data
class TrainReferenceSpeedCommand extends InternalMessage {
	int trainId
	int referenceSpeed
	TrainDirection direction
}
