package hu.bme.mit.inf.modes3.messaging.mms.handlers

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

interface SegmentStateHandler {
	def void handleSegmentState(SegmentStateOrBuilder event);
}
