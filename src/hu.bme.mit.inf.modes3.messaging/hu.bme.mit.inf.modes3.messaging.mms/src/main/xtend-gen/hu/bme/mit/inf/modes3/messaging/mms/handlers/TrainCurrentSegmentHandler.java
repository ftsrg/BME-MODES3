package hu.bme.mit.inf.modes3.messaging.mms.handlers;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegmentOrBuilder;

@SuppressWarnings("all")
public interface TrainCurrentSegmentHandler {
  public abstract void handleTrainCurrentSegment(final TrainCurrentSegmentOrBuilder event);
}
