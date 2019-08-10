package hu.bme.mit.inf.modes3.components.leapmotion.processor.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateListener;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.proto.messages.ComplexGestures.ComplexGesture;

/**
 * A listener for train speed change events and a commander that adjusts the trains' speed.
 * 
 * @author pappist
 */
public class TrainSpeedHandler extends GestureBasedCommander implements ITrainSpeedStateListener {

	public static final int MAX_TRAIN_SPEED = 50;

	public static final int TRAIN_SPEED_INCREMENT = 2;

	protected AtomicReference<Map<Long, Integer>> trainSpeeds;

	/**
	 * @param locator the high-level communication service of the railway track
	 */
	public TrainSpeedHandler(TrackCommunicationServiceLocator locator) {
		super(locator.getTrainCommander());
		trainSpeeds = new AtomicReference<Map<Long, Integer>>(new HashMap<Long, Integer>());
		locator.getTrainSpeedStateRegistry().addTrainSpeedStateListener(this);
	}

	/**
	 * Adjusts the speed of the train identified by ID.
	 * 
	 * @param id the identifier of the train
	 * @param accelerate if the train should accelerate
	 * @return the new speed of the train
	 */
	protected int updateTrainSpeed(long id, boolean accelerate) {
		if (!trainSpeeds.get().containsKey(id)) {
			trainSpeeds.get().put(id, TRAIN_SPEED_INCREMENT);
			return TRAIN_SPEED_INCREMENT;
		} else {
			int speed = accelerate ? trainSpeeds.get().get(id).intValue() + TRAIN_SPEED_INCREMENT
					: trainSpeeds.get().get(id).intValue() - TRAIN_SPEED_INCREMENT;
			speed = speed < MAX_TRAIN_SPEED * (-1) ? MAX_TRAIN_SPEED : speed;
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

		commander.setTrainReferenceSpeedAndDirection(gesture.getId(), Math.abs(newSpeed),
				newSpeed >= 0 ? TrainDirection.FORWARD : TrainDirection.BACKWARD);
	}

	@Override
	public void onTrainSpeedState(int id, int speed, TrainDirection direction) {
		trainSpeeds.get().put((long) id, direction == TrainDirection.FORWARD ? speed : (-1) * speed);
	}

}
