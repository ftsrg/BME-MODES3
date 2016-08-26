package hu.bme.mit.inf.modes3.messaging.mms.handlers.control;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControlOrBuilder;

@SuppressWarnings("all")
public interface TrainFunctionControlHandler {
  public abstract void handleTrainFunctionControl(final TrainFunctionControlOrBuilder event);
}
