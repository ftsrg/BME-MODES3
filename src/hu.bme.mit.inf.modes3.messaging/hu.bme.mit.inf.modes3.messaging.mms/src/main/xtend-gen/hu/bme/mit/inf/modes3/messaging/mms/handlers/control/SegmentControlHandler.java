package hu.bme.mit.inf.modes3.messaging.mms.handlers.control;

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder;

@SuppressWarnings("all")
public interface SegmentControlHandler {
  public abstract void handleSegmentControl(final SegmentControlOrBuilder event);
}
