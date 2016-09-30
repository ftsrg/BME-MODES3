package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.communication.common.Commander
import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import org.slf4j.ILoggerFactory

class TrainReferceCommander extends Commander {

	new(MessagingService mms, ILoggerFactory factory) {
		super(mms, factory)
	}
	
	def setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction) {
		mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [trainID = id; referenceSpeed = speed; it.direction = EnumTransformator.toSpecific(direction)]).build)
	}
	
	def stopEntireRailRoad(){
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_OPERATIONS]).build)
	}
	
	def stopTrains(){
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_ALL_LOCOMOTIVES]).build)
	}
	
	def startEntireRailRoad(){
		mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.NORMAL_OPERATIONS]).build)
	}
}
