package hu.bme.mit.inf.modes3.messaging.communication.state.interfaces

import java.util.List
import org.eclipse.xtend.lib.annotations.Data

public class TwoDimensionalPosition {
	public var double x
	public var double y

	override toString() {
		'''x = «x»	y = «y»'''
	}
}

public class ThreeDimensionalPosition {
	public var double x
	public var double y
	public var double z

	override toString() {
		'''x = «x»	y = «y»	z = «z»'''
	}
}

@Data
public class ComputerVisionInformation {
	String name
	TwoDimensionalPosition screenPosition
	ThreeDimensionalPosition realPosition
	boolean tracked
}

// TODO check it works??
interface IComputerVisionListener {
	def void onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp, long frameindex)
}
