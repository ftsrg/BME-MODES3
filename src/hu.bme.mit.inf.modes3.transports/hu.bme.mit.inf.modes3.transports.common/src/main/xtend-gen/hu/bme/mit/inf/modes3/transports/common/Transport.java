package hu.bme.mit.inf.modes3.transports.common;

import hu.bme.mit.inf.modes3.transports.config.TransportConfigurations;

@SuppressWarnings("all")
public abstract class Transport {
  public Object Transport(final TransportConfigurations configuration) {
    return null;
  }
  
  public abstract void connect();
  
  public abstract byte[] receiveMessage();
  
  public abstract void sendMessage(final byte[] message);
}
