package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.sample.bridge.ISampleComponentBridge
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class SampleComponentTests {

	@Test
	def void testWrapperInvocation() {
		val sampleComponentMock = Mockito.mock(ISampleComponentBridge)
		val ISampleComponent sampleComponent = new SampleComponent
		sampleComponent.sampleComponentBridge = sampleComponentMock

		var previousState = SegmentOccupancy.FREE
		var recentState = SegmentOccupancy.OCCUPIED

		for (i : 1 .. 3) {
			previousState = invertSegmentOccupancy(previousState)
			recentState = invertSegmentOccupancy(recentState)
			sampleComponent.onSegmentOccupancyChange(12, previousState, recentState)
		}

		Mockito.verify(sampleComponentMock, Mockito.times(1)).disableSegment(12)
	}

	private def invertSegmentOccupancy(SegmentOccupancy state) {
		switch (state) {
			case FREE: SegmentOccupancy.OCCUPIED
			case OCCUPIED: SegmentOccupancy.FREE
		}
	}

}
