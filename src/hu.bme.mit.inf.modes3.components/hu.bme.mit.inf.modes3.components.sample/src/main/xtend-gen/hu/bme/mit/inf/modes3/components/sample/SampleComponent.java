package hu.bme.mit.inf.modes3.components.sample;

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.SegmentStateHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class SampleComponent implements SegmentStateHandler {
  private MessagingService mms;
  
  public SampleComponent(final MessagingService _mms) {
    this.mms = _mms;
    this.mms.setSegmentStateHandler(this);
    this.mms.start();
  }
  
  @Override
  public void handleSegmentState(final SegmentStateOrBuilder event) {
    InputOutput.<String>println("SegmentStateHandler called");
    InputOutput.<SegmentStateOrBuilder>println(event);
  }
  
  public void sendSegmentControlMessage() {
    this.decision(true);
  }
  
  private void decision(final boolean sendMessage) {
    if (sendMessage) {
      final SegmentControl.Builder message = SegmentControl.newBuilder();
      message.setSegmentID(12);
      message.setControlState(SegmentControl.ControlState.DISABLE);
      SegmentControl _build = message.build();
      this.mms.sendMessage(_build);
    }
  }
}
