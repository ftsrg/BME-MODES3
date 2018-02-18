package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import org.slf4j.Logger

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
	ITrainCommander mms
	Logger logger

	new(ITrainCommander mms, Logger logger) {
		this.mms = mms
		this.logger = logger
	}

	override stopTrain(Train train) {
		mms.setTrainReferenceSpeedAndDirection(train.id, 0, TrainDirection.FORWARD)
	}
}

public class XPressInvertDirectionStrategy implements ITrainStopStrategy {
	ITrainCommander mms
	ITrainSpeedStateRegistry speedRegistry
	Logger logger

	new(ITrainCommander mms, ITrainSpeedStateRegistry speedRegistry, Logger logger) {
		this.mms = mms
		this.speedRegistry = speedRegistry
		this.logger = logger
	}

	override stopTrain(Train train) {
		mms.setTrainReferenceSpeedAndDirection(train.id, speedRegistry.getSpeed(train.id), if(speedRegistry.getDirection(train.id) == TrainDirection.FORWARD)
			TrainDirection.BACKWARD
		else
			TrainDirection.FORWARD)
	}

}

public class XPressStopAllStrategy implements ISegmentDisableStrategy, ITrainStopStrategy {
	IDccCommander trc

	new(IDccCommander trc) {
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

	new(ITrackElementCommander commander) {
		this.commander = commander
	}

	override enableSection(int id) {
		commander.sendSegmentCommand(id, SegmentState.ENABLED)
	}
}
