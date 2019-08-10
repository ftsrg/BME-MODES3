package hu.bme.mit.inf.modes3.messaging.messages.command

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import org.eclipse.xtend.lib.annotations.Data

/**
 * Every recipient should send status information about everything it controls or knows about. 
 * 
 * @author benedekh
 */
@Data
class SendAllStatusCommand extends InternalMessage {
}
