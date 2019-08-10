package hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces

import java.util.List
import org.eclipse.xtend.lib.annotations.Data

/**
 * Two dimensional position.
 * 
 * @author benedekh
 */
public class TwoDimensionalPosition {
	public var double x
	public var double y

	override toString() {
		'''x = «x»	y = «y»'''
	}
}

/**
 * Three dimensional position.
 * 
 * @author benedekh
 */
public class ThreeDimensionalPosition {
	public var double x
	public var double y
	public var double z

	override toString() {
		'''x = «x»	y = «y»	z = «z»'''
	}
}

/**
 * Computer Vision Information.
 * 
 * @author benedekh
 */
@Data
public class ComputerVisionInformation {
	String name
	TwoDimensionalPosition screenPosition
	ThreeDimensionalPosition realPosition
	boolean tracked
}

/**
 * A listener for the {@link ComputerVisionInformation}. 
 * 
 * @author benedekh
 */
interface IComputerVisionListener {
	/**
	 * Processes the Computer Vision Informations. 
	 * 
	 * @param information the informations from the CV
	 * @param timestamp the time when the detection happened
	 * @param frameindex the frame index when the detection happened
	 */
	def void onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp, long frameindex)
}
