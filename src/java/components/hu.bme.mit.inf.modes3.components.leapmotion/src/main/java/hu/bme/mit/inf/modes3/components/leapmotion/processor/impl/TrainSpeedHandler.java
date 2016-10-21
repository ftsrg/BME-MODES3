package hu.bme.mit.inf.modes3.components.leapmotion.processor.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import hu.bme.mit.inf.modes3.components.leapmotion.proto.ComplexGestures.ComplexGesture;
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection;

public class TrainSpeedHandler extends GestureBasedCommander {

	public static final int MAX_TRAIN_SPEED = 50;

	public static final int TRAIN_SPEED_INCREMENT = 3;

	protected AtomicReference<Map<Long, Integer>> trainSpeeds;

	public TrainSpeedHandler(ITrackElementCommander commander) {
		super(commander);
		trainSpeeds = new AtomicReference<Map<Long, Integer>>(new HashMap<Long, Integer>());
	}

	protected int updateTrainSpeed(long id, boolean acc) {
		if (!trainSpeeds.get().containsKey(id)) {
			trainSpeeds.get().put(id, TRAIN_SPEED_INCREMENT);
			return TRAIN_SPEED_INCREMENT;
		} else {
			int speed = acc ? trainSpeeds.get().get(id) + TRAIN_SPEED_INCREMENT
					: trainSpeeds.get().get(id) - TRAIN_SPEED_INCREMENT;
			speed = Math.abs(MAX_TRAIN_SPEED - speed) >= 0 ? speed : MAX_TRAIN_SPEED;
			trainSpeeds.get().put(id, speed);
			return speed;
		}
	}

	@Override
	public void process(ComplexGesture gesture) {
		int newSpeed = 0;
		switch (gesture.getType()) {

		case TYPE_SPEED_UP:
			newSpeed = updateTrainSpeed(gesture.getId(), true);
			break;
		case TYPE_SLOW_DOWN:
			newSpeed = updateTrainSpeed(gesture.getId(), false);
			break;
		default:
			return;
		}
		
		commander.setTrainReferenceSpeedAndDirection(gesture.getId(), newSpeed,
				newSpeed >= 0 ? TrainDirection.FORWARD : TrainDirection.BACKWARD);
	}

}
