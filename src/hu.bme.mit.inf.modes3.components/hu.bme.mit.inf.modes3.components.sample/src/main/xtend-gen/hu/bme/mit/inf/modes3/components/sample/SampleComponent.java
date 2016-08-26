package hu.bme.mit.inf.modes3.components.sample;

import hu.bme.mit.inf.modes3.components.common.AbstractComponent;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class SampleComponent extends AbstractComponent implements SegmentStateHandler {
  @Override
  public void init() {
    final ProtobufMessageDispatcher dispatcher = new ProtobufMessageDispatcher();
    dispatcher.setSegmentStateHandler(this);
    super.setDispatcher(dispatcher);
    super.start();
  }
  
  public void sendSegmentControlMessage() {
    this.decision(true);
  }
  
  private void decision(final boolean sendMessage) {
    if (sendMessage) {
      final SegmentControl.Builder message = SegmentControl.newBuilder();
      message.setSegmentID(12);
      message.setControlState(SegmentControl.ControlState.DISABLE);
      MessagingService _mms = this.getMms();
      SegmentControl _build = message.build();
      _mms.sendMessage(_build);
    }
  }
  
  @Override
  public void handleMessage(final SegmentStateOrBuilder message) {
    InputOutput.<String>println("SegmentState handler called");
    InputOutput.<String>println("=================");
    InputOutput.<String>println("Protobuf message:");
    InputOutput.<String>println("-----------------");
    InputOutput.<SegmentStateOrBuilder>print(message);
    InputOutput.<String>println("=================");
  }
}
