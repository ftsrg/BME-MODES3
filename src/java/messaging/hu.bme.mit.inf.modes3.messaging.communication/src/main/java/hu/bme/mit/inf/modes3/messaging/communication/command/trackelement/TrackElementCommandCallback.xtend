package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackElementCommandCallback implements ITrackElementCommandCallback, ITurnoutCommandListener, ISegmentCommandListener {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	var ISegmentCommandListener segmentCommandListener
	var ITurnoutCommandListener turnoutCommandListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		val segmentCommandClient = new SegmentCommandClient(this)
		val turnoutCommandClient = new TurnoutCommandClient(this)

		dispatcher.segmentCommandHandler = segmentCommandClient
		dispatcher.turnoutCommandHandler = turnoutCommandClient
		this.logger = factory.getLogger(this.class.name)
	}

	override onSegmentCommand(int id, SegmentState state) {
		if (segmentCommandListener === null) {
			logger.trace('''SegmentCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''SegmentCommand recieved, id=«id» state=«state»''')
			segmentCommandListener.onSegmentCommand(id, state)
		}
	}

	override onTurnoutCommand(int id, TurnoutState state) {
		if (turnoutCommandListener === null) {
			logger.trace('''TurnoutCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''TurnoutCommand recieved, id=«id» state=«state»''')
			turnoutCommandListener.onTurnoutCommand(id, state)
		}
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
