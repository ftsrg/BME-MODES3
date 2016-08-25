package hu.bme.mit.inf.modes3.messaging.mms.handlers;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeedOrBuilder;

@SuppressWarnings("all")
public interface TrainCurrentSpeedHandler {
  public abstract void handleTrainCurrentSpeed(final TrainCurrentSpeedOrBuilder event);
}
