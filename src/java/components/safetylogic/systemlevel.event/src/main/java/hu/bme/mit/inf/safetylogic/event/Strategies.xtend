package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import org.slf4j.Logger

/**
 * A strategy to stop a train.
 * 
 * @author baloghlaszlo
 */
public interface ITrainStopStrategy {
	/**
	 * Stops the train.
	 * 
	 * @param train the train to be stopped
	 */
	def void stopTrain(Train train)
}

/**
 * A strategy to disable a section.
 * 
 * @author baloghlaszlo
 */
interface ISegmentDisableStrategy {
	/**
	 * The section to be disabled.
	 * 
	 * @param id the ID of the section
	 */
	def void disableSection(int id);
}

/**
 * A strategy to enable a segment.
 * 
 * @author baloghlaszlo
 */
interface ISegmentEnableStrategy {
	/**
	 * The section to be enabled.
	 * 
	 * @param id the ID of the section.
	 */
	def void enableSection(int id);
}

/**
 * A strategy to disable a segment.
 * It uses the {@link ITrackElementCommander} for this purpose.
 * 
 * @author baloghlaszlo
 */
public class TrackDisableStrategy implements ISegmentDisableStrategy {
	ITrackElementCommander commander
	
	/**
	 * @param commander the commander to send commands to the track elements
	 */
	new(ITrackElementCommander commander) {
		this.commander = commander
	}

	override disableSection(int id) {
		commander.sendSegmentCommand(id, SegmentState.DISABLED)
	}

}

/**
 * A strategy to stop a train by setting the speed to 0.
 * It uses the {@link ITrainCommander} for this purpose.
 * 
 * @author baloghlaszlo
 */
public class XPressZeroSpeedDisableStrategy implements ITrainStopStrategy {
	ITrainCommander mms
	Logger logger

	/**
	 * @param mms the train commander to send commands to the trains
	 * @param logger a logger
	 */
	new(ITrainCommander mms, Logger logger) {
		this.mms = mms
		this.logger = logger
	}

	override stopTrain(Train train) {
		mms.setTrainReferenceSpeedAndDirection(train.id, 0, TrainDirection.FORWARD)
	}
}

/**
 * A strategy to stop a train by inverting the train'ss direction of movement.
 * It uses the {@link ITrainCommander} for this purpose.
 * 
 * @author baloghlaszlo
 */
public class XPressInvertDirectionStrategy implements ITrainStopStrategy {
	ITrainCommander mms
	ITrainSpeedStateRegistry speedRegistry
	Logger logger
	
	/**
	 * @param mms the train commander to control the trains
	 * @param speedRegistry an in-memory cache of the trains' speeds
	 * @param logger a logger
	 */
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

/**
 * A strategy to disable all segments and stop every trains by sending a command via DCC.
 * It uses the {@link IDccCommander} for this purpose.
 * 
 * @author baloghlaszlo
 */
public class XPressStopAllStrategy implements ISegmentDisableStrategy, ITrainStopStrategy {
	IDccCommander trc

	/**
	 * @param trc the commander to send commands via DCC
	 */
	new(IDccCommander trc) {
		this.trc = trc
	}
	
	/**
	 * Stops the whole railroad.
	 */
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

/**
 * A strategy to enable the segment.
 * It uses the {@link ITrackElementCommander} for this purpose.
 * 
 * @author benedekh
 */
public class TrackEnableStrategy implements ISegmentEnableStrategy {
	ITrackElementCommander commander

	/**
	 * @param commander the commander to send commands to the track elements
	 */
	new(ITrackElementCommander commander) {
		this.commander = commander
	}

	override enableSection(int id) {
		commander.sendSegmentCommand(id, SegmentState.ENABLED)
	}
}
