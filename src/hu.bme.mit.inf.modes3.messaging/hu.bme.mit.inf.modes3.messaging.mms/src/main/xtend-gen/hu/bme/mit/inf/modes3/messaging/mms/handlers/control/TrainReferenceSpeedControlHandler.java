package hu.bme.mit.inf.modes3.messaging.mms.handlers.control;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControlOrBuilder;

@SuppressWarnings("all")
public interface TrainReferenceSpeedControlHandler {
  public abstract void handleTrainReferenceSpeedControl(final TrainReferenceSpeedControlOrBuilder event);
}
