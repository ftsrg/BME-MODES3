package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import static org.mockito.Mockito.*;

class SampleComponentTest {
	
	@Mock
	private MessagingService mms;
	
	private SampleComponent component;
	
	@Before
	def void init() {
		mms = mock(MessagingService)
		component = new SampleComponent(mms)
	}
	
	@Test
	def void testSampleComponent() {
		// Arrange
		val state = SegmentState.newBuilder
		state.segmentID = 12
		state.state = SegmentState.State.OCCUPIED
		
		// Act
		component.handleSegmentState(state.build)
		
		// Assert
	}
	
	
	@Test
	def void testSampleComponentSend() {
		// Arrange
		val messageBuilder = SegmentControl.newBuilder
			messageBuilder.segmentID = 12
			messageBuilder.controlState = SegmentControl.ControlState.DISABLE
		
		// Act
		component.sendSegmentControlMessage();
		
		// Assert
		verify(mms).sendMessage(messageBuilder.build)
	}
	
}
