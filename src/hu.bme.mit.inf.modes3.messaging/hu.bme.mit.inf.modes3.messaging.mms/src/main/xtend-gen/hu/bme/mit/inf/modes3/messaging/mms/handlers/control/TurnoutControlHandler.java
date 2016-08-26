package hu.bme.mit.inf.modes3.messaging.mms.handlers.control;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControlOrBuilder;

@SuppressWarnings("all")
public interface TurnoutControlHandler {
  public abstract void handleTurnoutControl(final TurnoutControlOrBuilder event);
}
