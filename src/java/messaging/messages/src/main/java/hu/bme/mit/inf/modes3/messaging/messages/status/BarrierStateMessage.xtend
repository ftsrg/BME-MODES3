package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import org.eclipse.xtend.lib.annotations.Data

/**
 * A message about the state of the barrier.
 * 
 * @author benedekh
 */
@Data
class BarrierStateMessage extends InternalMessage {
	String state
}
