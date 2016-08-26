package hu.bme.mit.inf.modes3.messaging.mms;

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.MessageDispatcher;
import hu.bme.mit.inf.modes3.transports.common.Transport;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class MessagingService {
  private Transport transport;
  
  private MessageDispatcher dispatcher;
  
  public void start(final Transport _transport, final MessageDispatcher _dispatcher) {
    this.transport = _transport;
    this.dispatcher = _dispatcher;
    this.transport.connect();
    while ((!Thread.currentThread().isInterrupted())) {
      try {
        final byte[] rawMessage = this.transport.receiveMessage();
        this.dispatcher.dispatchMessage(rawMessage);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public void sendMessage(final Object message) throws ClassCastException {
    byte[] _convertMessageToRaw = this.dispatcher.convertMessageToRaw(message);
    this.transport.sendMessage(_convertMessageToRaw);
  }
}
