package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

interface ISegmentStateChangeListener {
	def void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue)
}
