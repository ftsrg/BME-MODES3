package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed.TrainReferenceSpeedState

public interface ITrainStopStrategy {
	def void stopTrain(Train train)
}

interface ISegmentDisableStrategy {
	def void disableSection(int id);
}

interface ISegmentEnableStrategy {
	def void enableSection(int id);
}

public class TrackDisableStrategy implements ISegmentDisableStrategy {
	ITrackElementCommander commander

	new(ITrackElementCommander commander) {
		this.commander = commander
	}

	override disableSection(int id) {
		commander.sendSegmentCommand(id, SegmentState.DISABLED)
	}

}

public class XPressZeroSpeedDisableStrategy implements ITrainStopStrategy {
	MessagingService mms
	Logger logger

	new(MessagingService mms, Logger logger) {
		this.mms = mms
		this.logger = logger
	}

	override stopTrain(Train train) {
		mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [trainID = train.id; referenceSpeed = 0; it.direction = TrainDirectionValue.FORWARD]).build)
	}
}

public class XPressInvertDirection implements ITrainStopStrategy {
	MessagingService mms
	TrainReferenceSpeedState referenceSpeedState
	Logger logger

	new(MessagingService mms, TrainReferenceSpeedState referenceSpeedState, Logger logger) {
		this.mms = mms
		this.referenceSpeedState = referenceSpeedState
		this.logger = logger
	}

	override stopTrain(Train train) {
		mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [
			trainID = train.id;
			referenceSpeed = 0;
			it.direction = if(referenceSpeedState.getDirection(train.id) == TrainDirectionValue.FORWARD) TrainDirectionValue.BACKWARD else TrainDirectionValue.FORWARD
		]).build)
	}

}

public class XPressStopAll implements ISegmentDisableStrategy, ITrainStopStrategy {
	MessagingService mms

	new(MessagingService mms) {
		this.mms = mms
	}

	def internalStop() {
		mms.sendMessage((DccOperationsCommand.newBuilder => [it.dccOperations = DccOperations.STOP_OPERATIONS]).build)
	}

	override stopTrain(Train train) {
		internalStop
	}

	override disableSection(int id) {
		internalStop
	}
}

public class TrackEnableStrategy implements ISegmentEnableStrategy {
	ITrackElementCommander commander
	
	new(ITrackElementCommander commander){
		this.commander = commander
	}

	override enableSection(int id) {
		commander.sendSegmentCommand(id, SegmentState.ENABLED)
	}
}
