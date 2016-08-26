package hu.bme.mit.inf.modes3.messaging.mms.handlers.status;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder;

@SuppressWarnings("all")
public interface TrainReferenceSpeedHandler {
  public abstract void handleTrainReferenceSpeed(final TrainReferenceSpeedOrBuilder event);
}
