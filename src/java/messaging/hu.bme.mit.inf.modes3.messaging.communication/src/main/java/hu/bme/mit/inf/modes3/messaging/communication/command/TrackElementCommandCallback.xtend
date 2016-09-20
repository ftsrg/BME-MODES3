package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.slf4j.Logger

class TrackElementCommandCallback implements ITrackElementCommandCallback {
	var  ISegmentCommandListener segmentCommandListener
	var ITurnoutCommandListener turnoutCommandListener

	new(ProtobufMessageDispatcher dispatcher, Logger logger) {
		val segmentCommandClient = new SegmentCommandClient(this) 
		val turnoutCommandClient = new TurnoutCommandClient(this)

		dispatcher.segmentCommandHandler = segmentCommandClient
		dispatcher.turnoutCommandHandler = turnoutCommandClient
	}

	def onSegmentCommand(int id, SegmentState state) {
		segmentCommandListener?.onSegmentCommand(id, state)
	}

	def onTurnoutCommand(int id, TurnoutState state) {
		turnoutCommandListener?.onTurnoutCommand(id, state)
	}
	
	override setSegmentCommandListener(ISegmentCommandListener listener) {
		segmentCommandListener = listener
	}
	
	override setTurnoutCommandListener(ITurnoutCommandListener listener) {
		turnoutCommandListener = listener
	}

}
