package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.components.trackelementcontroller.bridge.ITrackElementControllerBridge
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * The interface of the track element application.
 * 
 * @author benedekh
 */
interface ITrackElementController extends Runnable {
	/**
	 * To register the bridge that connects the track element controller application to the communication network.
	 * 
	 * @param trackElementControllerBridge the bridge to the communication network
	 */
	def void setTrackElementControllerBridge(ITrackElementControllerBridge trackElementControllerBridge)

	/**
	 * Callback for the SendAll event.
	 */
	def void onSendAllStatus()

	/**
	 * Callback for the segment command, that the state of the segment has to be set.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment	
	 */
	def void onSegmentCommand(int id, SegmentState state)

	/**
	 * Callback for the turnout command, that the state of the turnout has to be set.
	 * 
	 * @param id the ID of the turnout
	 * @param state the state of the turnout	
	 */
	def void onTurnoutCommand(int id, TurnoutState state)
}
