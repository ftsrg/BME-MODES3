package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import java.util.List

/**
 * An in-memory cache that notifies the listeners if the state of a track element (section or turnout = segment)
 * has changed.
 * 
 * @author benedekh
 */
interface ITrackElementStateRegistry {
/**
	 * @param id the ID of the turnout
	 * @return the recent state of the turnout
	 */
	def TurnoutState getTurnoutState(int id)
	
	/**
	 * @param id the ID of the segment
	 * @return the recent state of the segment
	 */
	def SegmentState getSegmentState(int id)
	
	/**
	 * @param id the ID of the segment
	 * @return the recent occupancy of the segment
	 */
	def SegmentOccupancy getSegmentOccupancy(int id)
	
	/**
	 * @return the IDs of the segments whose states are stored in the registry
	 */
	def List<Integer> getSegments()

	/**
	 * @return the IDs of the turnouts whose states are stored in the registry
	 */	
	def List<Integer> getTurnouts()
	
	/**
	 * Registers a turnout state change listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void registerTurnoutStateChangeListener(ITurnoutStateChangeListener listener)
	
	/**
	 * Registers a segment state change listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void registerSegmentStateChangeListener(ISegmentStateChangeListener listener)
	
	/**
	 * Registers a segment occupancy change listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void registerSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener)
}
