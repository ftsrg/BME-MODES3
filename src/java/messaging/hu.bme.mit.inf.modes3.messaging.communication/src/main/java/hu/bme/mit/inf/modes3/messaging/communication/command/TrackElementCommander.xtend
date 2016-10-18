package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.common.Commander
import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand
import org.slf4j.ILoggerFactory

class TrackElementCommander extends Commander implements ITrackElementCommander {

	static val senseToTurnoutIDMap = #{14 -> 1, 28 -> 2, 25 -> 3, 32 -> 3, 3 -> 4, 9 -> 5, 21 -> 6}

	new(MessagingService mms, ILoggerFactory factory) {
		super(mms, factory)
	}

	override sendSegmentCommand(int id, SegmentState state) {
		logger.trace('''SegmentCommand message sent with id=«id» state=«state»''')
		mms.sendMessage((SegmentCommand.newBuilder => [segmentID = id; it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override sendTurnoutCommandWithTurnoutId(int id, TurnoutState state){
		logger.info('''TurnoutCommand message sent with id=«id»(=T«(id)») state=«state»''')
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = id; it.state = EnumTransformator.toSpecific(state)]).build)
		
	}

	override sendTurnoutCommand(int id, TurnoutState state) {
		logger.info('''TurnoutCommand message sent with id=«id»(=T«senseToTurnoutIDMap.get(id)») state=«state»''')
		mms.sendMessage((TurnoutCommand.newBuilder => [turnoutID = senseToTurnoutIDMap.get(id); it.state = EnumTransformator.toSpecific(state)]).build)
	}

	override setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction) {
		mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [trainID = id; referenceSpeed = speed; it.direction = EnumTransformator.toSpecific(direction)]).build)
	}

	override stopEntireRailRoad() {
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_OPERATIONS]).build)
	}

	override stopTrains() {
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_ALL_LOCOMOTIVES]).build)
	}

	override startEntireRailRoad() {
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.NORMAL_OPERATIONS]).build)
	}

}
