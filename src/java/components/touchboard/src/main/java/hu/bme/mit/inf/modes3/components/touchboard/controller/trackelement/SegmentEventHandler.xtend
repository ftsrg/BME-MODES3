package hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement

import hu.bme.mit.inf.modes3.components.touchboard.bridge.ITouchboardBridge
import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A handler for the segment events.
 * 
 * @author benedekh
 */
class SegmentEventHandler {

	static val ENABLED = "enabled"
	static val DISABLED = "disabled"
	static val OCCUPIED = "occupied"

	val Logger logger
	val ThreadSafeNode node
	val int segmentId

	val ITouchboardBridge touchboardBridge
	
	/**
	 * @param touchboardBridge the bridge between the application and the communication network
	 * @param node the UI representation of the segment
	 * @param loggerFactory the logger factory
	 */
	new(ITouchboardBridge touchboardBridge, ThreadSafeNode node, ILoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.node = node
		this.segmentId = node.nodeId
		this.touchboardBridge = touchboardBridge
	}

	/**
	 * Sets the segment disabled on the UI.
	 */
	def synchronized setDisabled() {
		node.removeCssClass(ENABLED)
		node.addCssClass(DISABLED)
	}

	/**
	 * Sets the segment enabled on the UI.
	 */
	def synchronized setEnabled() {
		node.removeCssClass(DISABLED)
		node.addCssClass(ENABLED)
	}

	/**
	 * Sets the segment occupied on the UI.
	 */
	def synchronized setOccupied() {
		node.addCssClass(OCCUPIED)
	}

	/**
	 * Sets the segment free on the UI.
	 */
	def synchronized setFree() {
		node.removeCssClass(OCCUPIED)
	}

	/**
	 * An event handler if the segment was clicked.
	 */
	def void onSegmentClicked() {
		try {
			val state = touchboardBridge.getSegmentState(segmentId)
			val newState = getSegmentOppositeState(state)
			setSegmentState(newState)
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	/**
	 * An event handler if the segment should be enabled.
	 */
	def void onEnableSegment() {
		try {
			setSegmentState(SegmentState.ENABLED)
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	/**
	 * An event handler if the segment should be disabled.
	 */
	def void onDisableSegment() {
		try {
			setSegmentState(SegmentState.DISABLED)
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	private def setSegmentState(SegmentState state) {
		touchboardBridge.sendSegmentCommand(segmentId, state)
		logger.info('''Segment «segmentId» is «state»''')
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
