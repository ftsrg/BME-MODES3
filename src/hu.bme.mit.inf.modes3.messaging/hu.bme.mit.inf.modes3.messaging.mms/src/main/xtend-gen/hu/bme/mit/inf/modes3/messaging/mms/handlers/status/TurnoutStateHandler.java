package hu.bme.mit.inf.modes3.messaging.mms.handlers.status;

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder;

@SuppressWarnings("all")
public interface TurnoutStateHandler {
  public abstract void handleTurnoutState(final TurnoutStateOrBuilder event);
}
