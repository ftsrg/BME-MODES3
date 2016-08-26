package hu.bme.mit.inf.modes3.transports.zeromq;

import hu.bme.mit.inf.modes3.transports.common.Transport;

@SuppressWarnings("all")
public class ZMQTransport extends Transport {
  @Override
  public byte[] receiveMessage() {
    return null;
  }
  
  @Override
  public void connect() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void sendMessage(final byte[] message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
