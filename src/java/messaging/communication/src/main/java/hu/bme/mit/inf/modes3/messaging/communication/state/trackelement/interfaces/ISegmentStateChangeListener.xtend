package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

/**
 * A listener for the change of {@link SegmentState}. 
 * 
 * @author benedekh
 */
interface ISegmentStateChangeListener {
	/**
	 * Processes the change of the segment's state.
	 * 
	 * @param id the ID of the segment
	 * @param oldValue the old state of the segment
	 * @param newValue the new state of the segment
	 */
	def void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue)
}
