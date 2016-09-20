package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.slf4j.Logger

class TrackElementCommandCallback implements ITrackElementCommandCallback {
	var ISegmentCommandListener segmentCommandListener
	var ITurnoutCommandListener turnoutCommandListener
	val Logger logger

	new(ProtobufMessageDispatcher dispatcher, Logger logger) {
		val segmentCommandClient = new SegmentCommandClient(this) 
		val turnoutCommandClient = new TurnoutCommandClient(this)

		dispatcher.segmentCommandHandler = segmentCommandClient
		dispatcher.turnoutCommandHandler = turnoutCommandClient
		this.logger = logger
	}

	def onSegmentCommand(int id, SegmentState state) {
		if(segmentCommandListener == null){
			logger.trace('''SegmentCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''SegmentCommand recieved, id=«id» state=«state»''')
		}
		segmentCommandListener?.onSegmentCommand(id, state)

	}

	def onTurnoutCommand(int id, TurnoutState state) {
		if(turnoutCommandListener == null){
			logger.trace('''TurnoutCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''TurnoutCommand recieved, id=«id» state=«state»''')
		}
		turnoutCommandListener?.onTurnoutCommand(id, state)
	}
	
	override setSegmentCommandListener(ISegmentCommandListener listener) {
		segmentCommandListener = listener
		logger.trace('''segmentCommandListener changed''')
	}
	
	override setTurnoutCommandListener(ITurnoutCommandListener listener) {
		turnoutCommandListener = listener
		logger.trace('''turnoutCommandListener changed''')
	}

}
