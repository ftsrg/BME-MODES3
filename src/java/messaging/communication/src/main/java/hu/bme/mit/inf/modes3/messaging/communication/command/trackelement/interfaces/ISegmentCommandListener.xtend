package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

/**
 * A listener for the segment command. 
 * 
 * @author benedekh
 */
interface ISegmentCommandListener {
	
	/**
	 * Sets the state of the segment denoted by its ID for the required state.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void onSegmentCommand(int id, SegmentState state) 
}
