package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

/**
 * A listener for the {@link SegmentState}. 
 * 
 * @author benedekh
 */
interface ISegmentStateListener {
	/**
	 * Processes the segment state.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void onSegmentState(int id, SegmentState state)
}
