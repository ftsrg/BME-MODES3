package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

interface ISegmentStateListener {
	def void onSegmentState(int id, SegmentStateValue state);
}