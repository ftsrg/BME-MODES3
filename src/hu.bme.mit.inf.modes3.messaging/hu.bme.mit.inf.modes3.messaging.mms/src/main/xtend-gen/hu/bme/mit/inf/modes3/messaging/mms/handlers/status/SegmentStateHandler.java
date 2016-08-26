package hu.bme.mit.inf.modes3.messaging.mms.handlers.status;

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder;

@SuppressWarnings("all")
public interface SegmentStateHandler {
  public abstract void handleSegmentState(final SegmentStateOrBuilder event);
}
