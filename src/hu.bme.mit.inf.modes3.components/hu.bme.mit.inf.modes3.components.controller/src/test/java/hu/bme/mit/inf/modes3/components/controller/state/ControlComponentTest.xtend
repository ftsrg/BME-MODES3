package hu.bme.mit.inf.modes3.components.controller.state

import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import static org.mockito.Mockito.*

class ControlComponentTest {

	private TrackElementStateRegistry elementStateRegistry;

	@Mock
	private TrackElementStateCallback stateCallback

	@Before
	def void init() {
		elementStateRegistry = new TrackElementStateRegistry
		stateCallback = mock(TrackElementStateCallback)
		elementStateRegistry.trackElementStateCallback = stateCallback
	}

	@Test
	def void testSegmentState() {
		// Arrange
		// Act
		elementStateRegistry.getSegmentState(1)

	// Assert
	}

	@Test
	def void testTurnoutState() {
		// Arrange
		// Act
		elementStateRegistry.getTurnoutState(2)

	// Assert
	}

}
