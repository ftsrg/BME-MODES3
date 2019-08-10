package hu.bme.mit.inf.modes3.messaging.messages.command

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import org.eclipse.xtend.lib.annotations.Data

/**
 * Operation command that should be executed by the DCC (via XPressNet) protocol.
 * 
 * @author benedekh
 */
@Data
class DccOperationsCommand extends InternalMessage{
	DccOperations dccOperations
}
