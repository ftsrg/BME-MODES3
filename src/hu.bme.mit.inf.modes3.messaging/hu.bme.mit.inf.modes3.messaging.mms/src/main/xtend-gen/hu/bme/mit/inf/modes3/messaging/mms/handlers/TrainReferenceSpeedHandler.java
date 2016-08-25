package hu.bme.mit.inf.modes3.messaging.mms.handlers;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControlOrBuilder;

@SuppressWarnings("all")
public interface TrainReferenceSpeedHandler {
  public abstract void handleTrainReferenceSpeed(final TrainReferenceSpeedControlOrBuilder event);
}
