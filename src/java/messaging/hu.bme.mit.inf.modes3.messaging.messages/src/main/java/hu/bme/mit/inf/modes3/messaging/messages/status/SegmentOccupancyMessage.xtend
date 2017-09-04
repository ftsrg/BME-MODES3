package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import org.eclipse.xtend.lib.annotations.Data

@Data
class SegmentOccupancyMessage extends InternalMessage {
	int segmentId
	SegmentOccupancy state
}
