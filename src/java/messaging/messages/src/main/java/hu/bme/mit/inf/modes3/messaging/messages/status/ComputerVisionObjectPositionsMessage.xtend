package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Data

/**
 * Position information about physical objects on the track. The information is originates from CV.
 * 
 * @author benedekh
 */
@Data
class ComputerVisionObjectPositionsMessage extends InternalMessage {
	Map<String, PhysicalObject> physicalObjects
	long timestamp
	long frameIndex
}

/**
 * Position information about physical object on the track.
 * 
 * @author benedekh
 */
@Data
class PhysicalObject {
	String name
	Map<String, Marker> markers
}

/**
 * Position information about a marker on the track.
 * 
 * @author benedekh
 */
@Data
class Marker {
	String name
	ThreeDPosition realposition
	List<TwoDPosition> screenPositions
	List<Boolean> tracked
}

/**
 * A three dimensional position.
 * 
 * @author benedekh
 */
@Data
class ThreeDPosition {
	double x
	double y
	double z
}

/**
 * A two dimensional position.
 * 
 * @author benedekh
 */
@Data
class TwoDPosition {
	double x
	double y
}
