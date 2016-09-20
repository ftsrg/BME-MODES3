package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Collections
import org.junit.Test
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.slf4j.helpers.NOPLoggerFactory

@RunWith(Theories)
class SectionStateChangeNotifierTest {

	var SectionStateChangeNotifier notifier
	@Mock
	var ExpanderSectionController controller
	@Mock
	var ITrackElementStateSender stateSender

	@DataPoints
	public static var initialSegmentStates = #[SegmentState.ENABLED, SegmentState.DISABLED]

	/** returns the other possible value of SegmentState */
	private def getNegatedSegmentState(SegmentState state) {
		switch (state) {
			case ENABLED: SegmentState.DISABLED
			case DISABLED: SegmentState.ENABLED
		}
	}

	@Theory
	def void reportStateChanged(SegmentState initialState) {
		/** Theory -> see http://junit.sourceforge.net/doc/ReleaseNotes4.4.html Theories section */
		// Arrange
		val sectionID = 42
		val sectionIDset = #{sectionID}
		// to simulate segment state change
		val negatedState = getNegatedSegmentState(initialState)

		// set mocks
		controller = Mockito.mock(ExpanderSectionController)
		Mockito.when(controller.managedSections).thenReturn(sectionIDset)
		Mockito.when(controller.getSectionStatus(sectionID)).then(new Answer {

			private int count = 0

			override answer(InvocationOnMock invocation) throws Throwable {
				count++

				if(count == 1) {
					initialState
				} else {
					negatedState
				}
			}
		})
		stateSender = Mockito.mock(ITrackElementStateSender)
		notifier = new SectionStateChangeNotifier(stateSender, controller, new NOPLoggerFactory)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		Mockito.verify(stateSender, Mockito.times(1)).sendSegmentState(sectionID, negatedState)
		Mockito.verify(stateSender, Mockito.never).sendSegmentState(sectionID, initialState)
	}

	@Theory
	def void noReportWhenStateIsNotChanged(SegmentState initialState) {
		// Arrange
		val sectionID = 42
		val sectionIDset = #{sectionID}

		// set mocks
		controller = Mockito.mock(ExpanderSectionController)
		Mockito.when(controller.managedSections).thenReturn(sectionIDset)
		Mockito.when(controller.getSectionStatus(sectionID)).thenReturn(initialState)
		stateSender = Mockito.mock(ITrackElementStateSender)
		notifier = new SectionStateChangeNotifier(stateSender, controller, new NOPLoggerFactory)

		// Act
		val thread = new Thread(notifier)
		thread.start
		// because of the notifier's thread.sleep inside
		Thread.sleep(150)
		thread.interrupt

		// Assert
		Mockito.verify(stateSender, Mockito.never).sendSegmentState(Mockito.anyInt, Mockito.any(SegmentState))
	}

	@Test
	def void withoutSegmentsReportsNothing() {
		// Arrange
		// initialize mocks
		controller = Mockito.mock(ExpanderSectionController)
		Mockito.when(controller.managedSections).thenReturn(Collections.emptySet)
		stateSender = Mockito.mock(ITrackElementStateSender)

		// create unit under test
		notifier = new SectionStateChangeNotifier(stateSender, controller, new NOPLoggerFactory)

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
