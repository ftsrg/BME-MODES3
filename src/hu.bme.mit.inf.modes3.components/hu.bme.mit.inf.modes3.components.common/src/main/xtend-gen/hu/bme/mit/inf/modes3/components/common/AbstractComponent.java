package hu.bme.mit.inf.modes3.components.common;

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.MessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher;
import hu.bme.mit.inf.modes3.transports.common.Transport;
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractComponent {
  @Accessors
  private MessagingService mms = new MessagingService();
  
  @Accessors
  private Transport transport = new ZMQTransport();
  
  @Accessors
  private MessageDispatcher dispatcher = new ProtobufMessageDispatcher();
  
  public abstract void init();
  
  public void start() {
    this.mms.start(this.transport, this.dispatcher);
  }
  
  @Pure
  public MessagingService getMms() {
    return this.mms;
  }
  
  public void setMms(final MessagingService mms) {
    this.mms = mms;
  }
  
  @Pure
  public Transport getTransport() {
    return this.transport;
  }
  
  public void setTransport(final Transport transport) {
    this.transport = transport;
  }
  
  @Pure
  public MessageDispatcher getDispatcher() {
    return this.dispatcher;
  }
  
  public void setDispatcher(final MessageDispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
}
