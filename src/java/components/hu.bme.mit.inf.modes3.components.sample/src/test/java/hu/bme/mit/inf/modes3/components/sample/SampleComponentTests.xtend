package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.sample.wrapper.ISampleComponentWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import org.junit.Test
import org.mockito.Mockito

class SampleComponentTests {

	@Test
	def void testWrapperInvocation() {
		val sampleComponentMock = Mockito.mock(ISampleComponentWrapper)
		val ISampleComponent sampleComponent = new SampleComponent
		sampleComponent.sampleComponentWrapper = sampleComponentMock

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
