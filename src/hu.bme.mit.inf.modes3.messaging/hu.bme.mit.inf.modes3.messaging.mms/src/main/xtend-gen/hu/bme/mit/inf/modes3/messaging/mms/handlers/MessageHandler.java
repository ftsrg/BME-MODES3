package hu.bme.mit.inf.modes3.messaging.mms.handlers;

@SuppressWarnings("all")
public interface MessageHandler<T extends Object> {
  public abstract void handleMessage(final T message);
}
