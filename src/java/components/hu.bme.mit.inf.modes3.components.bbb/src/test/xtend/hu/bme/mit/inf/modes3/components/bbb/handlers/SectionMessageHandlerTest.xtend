package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class SectionMessageHandlerTest {

	var SectionMessageHandler handler
	@Mock
	var ITrackElementCommandCallback neverUsedInTests
	@Mock
	var ExpanderSectionController expander

	@Before
	def void init() {
		neverUsedInTests = Mockito.mock(ITrackElementCommandCallback)
	}

	@Test
	def void enableHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(true)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onSegmentCommand(int id, SegmentState state))
		handler = new SectionMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onSegmentCommand(sectionId, SegmentState.ENABLED)

		// Assert
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.times(1)).enableSection(sectionId)
	}

	@Test
	def void shallNotEnableNotHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(false)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onSegmentCommand(int id, SegmentState state))
		handler = new SectionMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onSegmentCommand(sectionId, SegmentState.ENABLED)

		// Assert
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.never()).enableSection(sectionId)
	}

	@Test
	def void disableHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(true)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onSegmentCommand(int id, SegmentState state))
		handler = new SectionMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onSegmentCommand(sectionId, SegmentState.DISABLED)

		// Assert
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.times(1)).disableSection(sectionId)
	}

	@Test
	def void shallNotDisableNotHandledSection() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		Mockito.when(expander.controllerManagesSection(sectionId)).thenReturn(false)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onSegmentCommand(int id, SegmentState state))
		handler = new SectionMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onSegmentCommand(sectionId, SegmentState.DISABLED)

		// Assert
		Mockito.verify(expander, Mockito.times(1)).controllerManagesSection(sectionId)
		Mockito.verify(expander, Mockito.never()).disableSection(sectionId)
	}

	@Test
	def void shallNeitherEnableNorDisableIfCommandIsInvalid() {
		// Arrange
		val sectionId = 42
		// prepare expander mock
		expander = Mockito.mock(ExpanderSectionController)
		// the first parameter is the same dummy object, because the ITrackElementCommandCallback would call this class
		// instead of that we do the call explicitly (onSegmentCommand(int id, SegmentState state))
		handler = new SectionMessageHandler(neverUsedInTests, expander)

		// Act
		handler.onSegmentCommand(sectionId, null)

		// Assert
		Mockito.verify(expander, Mockito.never()).enableSection(sectionId)
		Mockito.verify(expander, Mockito.never()).disableSection(sectionId)
		Mockito.verify(expander, Mockito.never()).controllerManagesSection(sectionId)
	}

}
