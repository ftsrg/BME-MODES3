package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

interface SegmentStateChangeListener {
	def void onSegmentStateChange(int id, SegmentStateValue state);
}