package hu.bme.mit.inf.modes3.messaging.mms.dispatcher;

@SuppressWarnings("all")
public interface MessageDispatcher {
  public abstract void dispatchMessage(final byte[] rawMessage);
  
  public abstract byte[] convertMessageToRaw(final Object message) throws ClassCastException;
}
