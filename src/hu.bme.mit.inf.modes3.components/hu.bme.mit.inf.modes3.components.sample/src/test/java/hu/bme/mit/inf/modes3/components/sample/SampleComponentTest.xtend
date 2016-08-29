package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import static org.mockito.Mockito.*;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

class SampleComponentTest {

	@Mock
	private MessagingService mms;
	private SampleComponent component;

	@Before
	def void init() {
		mms = mock(MessagingService)
		
		component = new SampleComponent
		component.mms = mms
	}

	@Test
	def void testSampleComponentHandleMessage() {
		// Arrange
		val state = SegmentState.newBuilder
		state.segmentID = 12
		state.state = SegmentStateValue.DISABLED

		// Act
		component.handleMessage(state.build)

		// Assert
	}

	@Test
	def void testSampleComponentSendMessage() {
		// Arrange
		val messageBuilder = SegmentControl.newBuilder
		messageBuilder.segmentID = 12
		messageBuilder.controlState = SegmentStateValue.DISABLED

		// Act
		component.sendSegmentControlMessage();

		// Assert
		verify(mms).sendMessage(messageBuilder.build)
	}

}
