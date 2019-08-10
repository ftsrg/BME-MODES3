package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger


/**
 * A commander that sends the track element commands (section or turnout = segment) to the railway track.
 * 
 * @author benedekh
 */
class TrackElementCommander implements ITrackElementCommander {

	private static val SEGMENT_ID_TO_TURNOUT_ID_MAPPING = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var protected MessagingService mms
	
	/**
	 * @param mms the messaging service to the track
	 * @param factory the logger factory
	 */
	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendSegmentCommand(int id, SegmentState state) {
		mms.sendMessage(new SegmentCommand(id, state))
		logger.debug('''SegmentCommand message sent with id=«id» state=«state»''')
	}

	override sendTurnoutCommandWithTurnoutId(int id, TurnoutState state) {
		mms.sendMessage(new TurnoutCommand(id, state))
		logger.debug('''TurnoutCommand message sent with id=«id»(=T«(id)») state=«state»''')
	}

	override sendTurnoutCommand(int segmentId, TurnoutState state) {
		val turnoutId = SEGMENT_ID_TO_TURNOUT_ID_MAPPING.get(segmentId)
		mms.sendMessage(new TurnoutCommand(turnoutId, state))
		logger.debug('''TurnoutCommand message sent with segmentId=«segmentId»(=T«turnoutId») state=«state»''')
	}

	override sendAllStatusCommand() {
		mms.sendMessage(new SendAllStatusCommand)
		logger.debug('''SendAllStatus message sent''')
	}

}
