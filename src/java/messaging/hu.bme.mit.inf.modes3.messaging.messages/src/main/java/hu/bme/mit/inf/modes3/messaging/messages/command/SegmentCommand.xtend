package hu.bme.mit.inf.modes3.messaging.messages.command

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import org.eclipse.xtend.lib.annotations.Data

@Data
class SegmentCommand extends InternalMessage {
	int segmentId
	SegmentState state
}
