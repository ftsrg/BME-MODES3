package hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement

import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SegmentEventHandler {

	static val ENABLED = "enabled"
	static val DISABLED = "disabled"
	static val OCCUPIED = "occupied"

	val Logger logger
	val ThreadSafeNode node
	val int segmentId

	val ITrackElementStateRegistry trackElementStateRegistry
	val ITrackElementCommander trackElementCommander

	new(ILoggerFactory loggerFactory, ThreadSafeNode node, ITrackElementStateRegistry trackElementStateRegistry,
		ITrackElementCommander trackElementCommander) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.node = node
		this.segmentId = node.nodeId
		this.trackElementStateRegistry = trackElementStateRegistry
		this.trackElementCommander = trackElementCommander
	}

	def setDisabled() {
		node.removeCssClass(ENABLED)
		node.addCssClass(DISABLED)
	}

	def setEnabled() {
		node.removeCssClass(DISABLED)
		node.addCssClass(ENABLED)
	}

	def setOccupied() {
		node.addCssClass(OCCUPIED)
	}

	def setFree() {
		node.removeCssClass(OCCUPIED)
	}

	def void onSegmentClicked() {
		try {
			val state = trackElementStateRegistry.getSegmentState(segmentId)
			val newState = getSegmentOppositeState(state)
			setSegmentState(newState)
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	def void onEnableSegment() {
		try {
			setSegmentState(SegmentState.ENABLED)
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	def void onDisableSegment() {
		try {
			setSegmentState(SegmentState.DISABLED)
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	private def setSegmentState(SegmentState state) {
		trackElementCommander.sendSegmentCommand(segmentId, state)
		updateSectionState(state)

		logger.info('''Segment «segmentId» is «state»''')
	}

	private def void updateSectionState(SegmentState newState) {
		switch (newState) {
			case ENABLED:
				setEnabled
			case DISABLED:
				setDisabled
		}
	}

	private def getSegmentOppositeState(SegmentState state) {
		switch (state) {
			case ENABLED:
				SegmentState.DISABLED
			case DISABLED:
				SegmentState.ENABLED
		}
	}
}
