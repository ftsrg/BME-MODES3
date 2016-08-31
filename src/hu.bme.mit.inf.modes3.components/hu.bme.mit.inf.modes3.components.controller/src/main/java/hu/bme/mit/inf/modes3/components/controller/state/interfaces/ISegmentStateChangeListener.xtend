package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

interface ISegmentStateChangeListener {
	def void onSegmentStateChange(int id, SegmentStateValue oldValue, SegmentStateValue newValue);
}
