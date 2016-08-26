package hu.bme.mit.inf.modes3.messaging.mms.handlers.control;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControlOrBuilder;

@SuppressWarnings("all")
public interface TrainDirectionControlHandler {
  public abstract void handleTrainDirectionControl(final TrainDirectionControlOrBuilder event);
}
