package hu.bme.mit.inf.modes3.components.sample;

import hu.bme.mit.inf.modes3.components.sample.SampleComponent;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class SampleComponentTest {
  @Mock
  private MessagingService mms;
  
  private SampleComponent component;
  
  @Before
  public void init() {
    MessagingService _mock = Mockito.<MessagingService>mock(MessagingService.class);
    this.mms = _mock;
    SampleComponent _sampleComponent = new SampleComponent();
    this.component = _sampleComponent;
    this.component.setMms(this.mms);
  }
  
  @Test
  public void testSampleComponentHandleMessage() {
    final SegmentState.Builder state = SegmentState.newBuilder();
    state.setSegmentID(12);
    state.setState(SegmentState.State.OCCUPIED);
    SegmentState _build = state.build();
    this.component.handleMessage(_build);
  }
  
  @Test
  public void testSampleComponentSendMessage() {
    final SegmentControl.Builder messageBuilder = SegmentControl.newBuilder();
    messageBuilder.setSegmentID(12);
    messageBuilder.setControlState(SegmentControl.ControlState.DISABLE);
    this.component.sendSegmentControlMessage();
    MessagingService _verify = Mockito.<MessagingService>verify(this.mms);
    SegmentControl _build = messageBuilder.build();
    _verify.sendMessage(_build);
  }
}
