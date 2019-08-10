package hu.bme.mit.inf.modes3.components.touchboard.controller

import hu.bme.mit.inf.modes3.components.touchboard.bridge.ITouchboardBridge
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * The interface of the touchboard application.
 * 
 * @author benedekh
 */
interface ITouchboardController extends Runnable {
	
	/**
	 * Processes the change of the segment's occupancy.
	 * 
	 * @param id the ID of the segment
	 * @param oldValue the old occupancy of the segment
	 * @param newValue the new occupancy of the segment
	 */
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)

	/**
	 * Processes the change of the segment's state.
	 * 
	 * @param id the ID of the segment
	 * @param oldValue the old state of the segment
	 * @param newValue the new state of the segment
	 */
	def void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue)

	/**
	 * Processes the change of the turnout's state.
	 * 
	 * @param id the ID of the turnout
	 * @param oldValue the old state of the turnout
	 * @param newValue the new state of the turnout
	 */
	def void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue)

	/**
	 * To register the bridge that connects the touchboard application to the communication network.
	 * 
	 * @param touchboardBridge the bridge to the communication network
	 */
	def void setTouchboardBridge(ITouchboardBridge touchboardBridge)
}
