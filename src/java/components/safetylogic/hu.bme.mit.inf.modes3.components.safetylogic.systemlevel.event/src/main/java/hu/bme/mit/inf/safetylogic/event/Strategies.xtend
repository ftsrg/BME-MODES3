package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed.TrainReferenceSpeedState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed.TrainReferenceCommander

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
	TrainReferenceCommander mms
	TrainReferenceSpeedState referenceSpeedState
	Logger logger
 
	new(TrainReferenceCommander mms, TrainReferenceSpeedState referenceSpeedState, Logger logger) {
		this.mms = mms
		this.referenceSpeedState = referenceSpeedState
		this.logger = logger
	}

	override stopTrain(Train train) {
		mms.setTrainReferenceSpeedAndDirection(train.id, 0, if(referenceSpeedState.getDirection(train.id) == TrainDirection.FORWARD) TrainDirection.BACKWARD else TrainDirection.FORWARD)
	}

}

public class XPressStopAll implements ISegmentDisableStrategy, ITrainStopStrategy {
	TrainReferenceCommander trc

	new(TrainReferenceCommander trc) {
		this.trc = trc
	}

	def internalStop() {
		trc.stopEntireRailRoad
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
