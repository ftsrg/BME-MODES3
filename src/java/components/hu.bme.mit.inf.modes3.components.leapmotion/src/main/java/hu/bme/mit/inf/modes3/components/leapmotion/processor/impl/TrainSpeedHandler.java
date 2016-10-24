package hu.bme.mit.inf.modes3.components.leapmotion.processor.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.ComplexGestures.ComplexGesture;

public class TrainSpeedHandler extends GestureBasedCommander {

	public static final int MAX_TRAIN_SPEED = 50;

	public static final int TRAIN_SPEED_INCREMENT = 2;

	protected AtomicReference<Map<Long, Integer>> trainSpeeds;

	public TrainSpeedHandler(ITrackElementCommander commander) {
		super(commander);
		trainSpeeds = new AtomicReference<Map<Long, Integer>>(new HashMap<Long, Integer>());
	}

	protected int updateTrainSpeed(long id, boolean accelerate) {
		if (!trainSpeeds.get().containsKey(id)) {
			trainSpeeds.get().put(id, TRAIN_SPEED_INCREMENT);
			return TRAIN_SPEED_INCREMENT;
		} else {
			int speed = accelerate ? trainSpeeds.get().get(id).intValue() + TRAIN_SPEED_INCREMENT
					: trainSpeeds.get().get(id).intValue() - TRAIN_SPEED_INCREMENT;
			speed = speed < MAX_TRAIN_SPEED*(-1) ? MAX_TRAIN_SPEED*(-1) : speed;
			speed = speed >= MAX_TRAIN_SPEED ? MAX_TRAIN_SPEED : speed;
			trainSpeeds.get().put(id, speed);
			System.out.println(String.format("Train with %d id reference speed is %d", id, speed));
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
		case TYPE_STOP:
			newSpeed = 0;
			break;
		default:
			return;
		}
		
		commander.setTrainReferenceSpeedAndDirection(gesture.getId(), newSpeed,
				newSpeed >= 0 ? TrainDirection.FORWARD : TrainDirection.BACKWARD);
	}

}
