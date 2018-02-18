package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Data

@Data
class ComputerVisionObjectPositionsMessage extends InternalMessage {
	Map<String, PhysicalObject> physicalObjects
	long timestamp
	long frameIndex
}

@Data
class PhysicalObject {
	String name
	Map<String, Marker> markers
}

@Data
class Marker {
	String name
	ThreeDPosition realposition
	List<TwoDPosition> screenPositions
	List<Boolean> tracked
}

@Data
class ThreeDPosition {
	double x
	double y
	double z
}

@Data
class TwoDPosition {
	double x
	double y
}
