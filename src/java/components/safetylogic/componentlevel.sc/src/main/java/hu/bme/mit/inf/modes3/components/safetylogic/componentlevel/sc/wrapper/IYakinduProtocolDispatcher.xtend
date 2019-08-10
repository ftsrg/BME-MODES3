package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

/**
 * An interface to dispatch a Yakindu message to a segment that is connected from a specific direction.
 * 
 * @author benedekh
 */
interface IYakinduProtocolDispatcher {
	/**
	 * Registers a segment by its ID and port.
	 * 
	 * @param segmentID the ID of the segment
	 * @param portToBeNotified the port of the segment with the direction of the segment
	 */
	def void registerSegment(int segmentID, PortWithDirection portToBeNotified)
}