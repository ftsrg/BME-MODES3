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

interface ISafetyLogicBridge {
	def void sendSegmentOccupation(int id, SegmentOccupancy state)

	def void sendSegmentState(int id, SegmentState state)

	def void sendTurnoutState(int id, TurnoutState state)

	def void sendSegmentCommand(int id, SegmentState state)

	/**
	 * Send a command to a turnout, denoted by its segment ID. (The ID of the segment which indicates the turnout's occupancy.)
	 */
	def void sendTurnoutCommand(int segmentId, TurnoutState state)

	def void setSendAllStatusListener(ISendAllStatusListener listener)

	def void setSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener)

	def void setTurnoutStateChangeListener(ITurnoutStateChangeListener listener)

	def void setComputerVisionListener(IComputerVisionListener listener)

	def ITrackElementCommander getTrackElementCommander()

	def ITrainCommander getTrainCommander()

	def ITrainSpeedStateRegistry getTrainSpeedStateRegistry()
}
