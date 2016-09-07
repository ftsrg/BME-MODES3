package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Collections
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class SectionStateNotifierTest {

	var SectionStateNotifier notifier
	@Mock
	var ExpanderSectionController controller
	@Mock
	var ITrackElementStateSender stateSender

	@Test
	def void enabledOrDisabledStatesAreSentForTwoSegments() {
		// Arrange		
		val sectionIDs = #["42", "43"]
		val sectionIDset = #{sectionIDs.get(0), sectionIDs.get(1)}
		val sectionStatuses = #{sectionIDs.get(0) -> SegmentState.ENABLED, sectionIDs.get(1) -> SegmentState.DISABLED}

		// initialize mocks
		controller = Mockito.mock(ExpanderSectionController)
		Mockito.when(controller.managedSections).thenReturn(sectionIDset)
		for (id : sectionIDs) {
			Mockito.when(controller.getSectionStatus(Integer.valueOf(id))).thenReturn(sectionStatuses.get(id))
		}
		stateSender = Mockito.mock(ITrackElementStateSender)

		// create unit under test
		notifier = new SectionStateNotifier(stateSender, controller)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		for (id : sectionIDs) {
			Mockito.verify(stateSender, Mockito.atLeastOnce).sendSegmentState(Integer.valueOf(id),
				sectionStatuses.get(id))
		}
	}

	@Test
	def void withoutSegmentsReportsNothing() {
		// Arrange
		// initialize mocks
		controller = Mockito.mock(ExpanderSectionController)
		Mockito.when(controller.managedSections).thenReturn(Collections.emptySet)
		stateSender = Mockito.mock(ITrackElementStateSender)

		// create unit under test
		notifier = new SectionStateNotifier(stateSender, controller)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		Mockito.verify(stateSender, Mockito.never).sendSegmentState(Mockito.anyInt, Mockito.any(SegmentState))
	}
}
