package hu.bme.mit.inf.modes3.components.dashboard.utils;

import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.SEGMENT_OCCUPACY;
import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.SEGMENT_STATE;
import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.TRAIN_SPEED;
import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.TURNOUT_STATE;

import org.atmosphere.cpr.MetaBroadcaster;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufEnumTransformator;

public class Utils {

	static hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentOccupancy.Builder segmentOccBuilder;
	static hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentState.Builder segmentStateBuilder;
	static hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutState.Builder turnoutStateBuilder;
	static hu.bme.mit.inf.modes3.messaging.proto.messages.TrainCurrentSpeed.Builder trainSpeedBuilder;

	public static void sendSegmentStateChange(MetaBroadcaster metaBroadcaster, int id, SegmentState state) {

		if (segmentStateBuilder == null) {
			segmentStateBuilder = hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentState.newBuilder();
		}

		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().includingDefaultValueFields().print(segmentStateBuilder.clear()
					.setSegmentID(id).setState(ProtobufEnumTransformator.toSpecific(state)).build());
			metaBroadcaster.broadcastTo("/ws/state/" + SEGMENT_STATE, stateAsJson);
		} catch (InvalidProtocolBufferException e) {
			System.err.println("Unable to convert & push segment state message " + e.getMessage());
		}
	}

	public static void sendTurnutStateChange(MetaBroadcaster metaBroadcaster, int id, TurnoutState state) {

		if (turnoutStateBuilder == null) {
			turnoutStateBuilder = hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutState.newBuilder();
		}

		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().includingDefaultValueFields().print(turnoutStateBuilder.clear()
					.setTurnoutID(id).setState(ProtobufEnumTransformator.toSpecific(state)).build());
			metaBroadcaster.broadcastTo("/ws/state/" + TURNOUT_STATE, stateAsJson);
		} catch (InvalidProtocolBufferException e) {
			System.err.println("Unable to convert & push turnout state message " + e.getMessage());
		}
	}

	public static void sendSegmentOccupancyStateChange(MetaBroadcaster metaBroadcaster, int id,
			SegmentOccupancy occupancy) {

		if (segmentOccBuilder == null) {
			segmentOccBuilder = hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentOccupancy.newBuilder();
		}

		String occupancyAsJson;
		try {
			occupancyAsJson = JsonFormat.printer().includingDefaultValueFields().print(segmentOccBuilder.clear()
					.setSegmentID(id).setState(ProtobufEnumTransformator.toSpecific(occupancy)));
			metaBroadcaster.broadcastTo("/ws/state/" + SEGMENT_OCCUPACY, occupancyAsJson);
		} catch (InvalidProtocolBufferException e) {
			System.err.println("Unable to convert & push segment occupancy message " + e.getMessage());
		}

	}

	public static void sendTrainReferenceSpeedChange(MetaBroadcaster metaBroadcaster, int id, int speed,
			TrainDirection direction) {

		// if speed is smaller than zero, than we've got a wrong data, halting
		if (speed < 0) {
			return;
		}

		if (trainSpeedBuilder == null) {
			trainSpeedBuilder = hu.bme.mit.inf.modes3.messaging.proto.messages.TrainCurrentSpeed.newBuilder();
		}

		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().includingDefaultValueFields()
					.print(trainSpeedBuilder.clear().setTrainID(id)
							.setDirection(ProtobufEnumTransformator.toSpecific(direction)).setCurrentSpeed(speed)
							.build());
			System.out.println(trainSpeedBuilder.getCurrentSpeed());
			metaBroadcaster.broadcastTo("/ws/state/" + TRAIN_SPEED, stateAsJson);
		} catch (InvalidProtocolBufferException e) {
			System.err.println("Unable to convert & push turnout state message " + e.getMessage());
		}

	}

}
