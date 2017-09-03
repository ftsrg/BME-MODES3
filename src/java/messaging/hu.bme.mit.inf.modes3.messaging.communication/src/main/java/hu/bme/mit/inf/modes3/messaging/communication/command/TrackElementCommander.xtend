package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.SendAllStatus
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackElementCommander implements ITrackElementCommander {
	
	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	var protected MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendSegmentCommand(int id, SegmentState state) {
		logger.trace('''SegmentCommand message sent with id=«id» state=«state»''')
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutCommandWithTurnoutId(int id, TurnoutState state){
		logger.info('''TurnoutCommand message sent with id=«id»(=T«(id)») state=«state»''')
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)	
	}

	override sendTurnoutCommand(int segmentId, TurnoutState state) {
		val turnoutId = LayoutConfiguration.INSTANCE.getTurnoutIdFromSegmentIdAsInteger(String.valueOf(segmentId))
		logger.info('''TurnoutCommand message sent with segmentId=«segmentId»(=T«turnoutId») state=«state»''')
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = turnoutId; it.state = EnumTransformator.toSpecific(state)]).build)
	}
	
	override sendAllStatusCommand() {
		logger.trace('''SendAllStatus message sent to everyone''')
		mms.sendMessage((SendAllStatus.newBuilder.build))
	}

	override setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction) {
		logger.info('''TrainCommand message sent with id=«id»(speed=«(speed)») direction=«direction»''')
		mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [trainID = id; referenceSpeed = speed; it.direction = EnumTransformator.toSpecific(direction)]).build)
	}

	override stopEntireRailRoad() {
		logger.info('''TrainCommand stop entire railroad sent''')
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_OPERATIONS]).build)
	}

	override stopTrains() {
		logger.info('''TrainCommand stop trains sent''')
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_ALL_LOCOMOTIVES]).build)
	}

	override startEntireRailRoad() {
		logger.info('''TrainCommand start entire railroad sent''')
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.NORMAL_OPERATIONS]).build)
	}

}
