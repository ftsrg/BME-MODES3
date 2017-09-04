package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackElementCommander implements ITrackElementCommander {

	private static val SEGMENT_ID_TO_TURNOUT_ID_MAPPING = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	var protected MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendSegmentCommand(int id, SegmentState state) {
		logger.trace('''SegmentCommand message sent with id=«id» state=«state»''')
		mms.sendMessage(new SegmentCommand(id, state))
	}

	/**
	 * Send a command to a turnout, denoted by its ID.
	 */
	override sendTurnoutCommandWithTurnoutId(int id, TurnoutState state) {
		logger.info('''TurnoutCommand message sent with id=«id»(=T«(id)») state=«state»''')
		mms.sendMessage(new TurnoutCommand(id, state))
	}

	/**
	 * Send a command to a turnout, denoted by its segment ID. (The ID of the segment which indicates the turnout's occupancy.)
	 */
	override sendTurnoutCommand(int segmentId, TurnoutState state) {
		val turnoutId = SEGMENT_ID_TO_TURNOUT_ID_MAPPING.get(segmentId)
		logger.info('''TurnoutCommand message sent with segmentId=«segmentId»(=T«turnoutId») state=«state»''')
		mms.sendMessage(new TurnoutCommand(turnoutId, state))
	}

	override sendAllStatusCommand() {
		logger.trace('''SendAllStatus message sent to everyone''')
		mms.sendMessage(new SendAllStatusCommand)
	}

	override setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction) {
		logger.info('''TrainCommand message sent with id=«id»(speed=«(speed)») direction=«direction»''')
		mms.sendMessage(new TrainReferenceSpeedCommand(id, speed, direction))
	}

	override stopEntireRailRoad() {
		logger.info('''TrainCommand stop entire railroad sent''')
		mms.sendMessage(new DccOperationsCommand(DccOperations.STOP_OPERATIONS))
	}

	override stopTrains() {
		logger.info('''TrainCommand stop trains sent''')
		mms.sendMessage(new DccOperationsCommand(DccOperations.STOP_ALL_LOCOMOTIVES))
	}

	override startEntireRailRoad() {
		logger.info('''TrainCommand start entire railroad sent''')
		mms.sendMessage(new DccOperationsCommand(DccOperations.NORMAL_OPERATIONS))
	}

}
