package hu.bme.mit.inf.modes3.components.trackelementcontroller.bridge

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * The bridge between the track element controller application and the communication network.
 * 
 * @author benedekh
 */
interface ITrackElementControllerBridge {
	/**
	 * Send a segment state message over the communication network.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void sendSegmentState(int id, SegmentState state)

	/**
	 * Send a turnout state message over the communication network.
	 * 
	 * @param id the ID of the turnout
	 * @param state the state of the turnout
	 */
	def void sendTurnoutState(int id, TurnoutState state)
	
	/**
	 * @return the track element state registry
	 */
	def ITrackElementStateRegistry getTrackElementStateRegistry()
}
