package hu.bme.mit.inf.safetylogic.event.bridge

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * The bridge between the system-level safety logic application and the communication network.
 * 
 * @author benedekh
 */
interface ISafetyLogicBridge {
	/**
	 * Sends the segment's occupancy.
	 * 
	 * @param id the ID of the segment
	 * @param state the occupancy of the segment
	 */
	def void sendSegmentOccupation(int id, SegmentOccupancy state)

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
	 * Send a segment command message over the communication network.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void sendSegmentCommand(int id, SegmentState state)
	
	/**
	 * Sends the train's speed and direction of movement.
	 * 
	 * @param trainId the ID of the train
	 * @param speed the speed of the train
	 * @param direction the direction of movement of the train
 	*/
	def void sendTrainReferenceSpeed(int id, int speed, TrainDirection trainDirection)

	/**
	 * Send a command to a turnout, denoted by its segment ID. (The ID of the segment which indicates the turnout's occupancy.)
	 */
	def void sendTurnoutCommand(int segmentId, TurnoutState state)

	/**
	 * Sets a SendAllStatus listener.
	 * 
	 * @param listener the listener to be set
	 */
	def void setSendAllStatusListener(ISendAllStatusListener listener)

	/**
	 * Sets a segment occupancy change listener.
	 * 
	 * @param listener the listener to be set
	 */
	def void setSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener)

	/**
	 * Sets a turnout state change listener.
	 * 
	 * @param listener the listener to be set
	 */
	def void setTurnoutStateChangeListener(ITurnoutStateChangeListener listener)

	/**
	 * Sets a computer vision listener.
	 * 
	 * @param listener the listener to be set
	 */
	def void setComputerVisionListener(IComputerVisionListener listener)

	/**
	 * @return the track element commander
	 */
	def ITrackElementCommander getTrackElementCommander()

	/**
	 * @return the train commander
	 */
	def ITrainCommander getTrainCommander()

	/**
	 * @return the train speed state registry
	 */
	def ITrainSpeedStateRegistry getTrainSpeedStateRegistry()
}
