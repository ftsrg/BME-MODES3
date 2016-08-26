package hu.bme.mit.inf.modes3.messaging.mms.handlers.control

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder

interface SegmentControlHandler {
	def void handleSegmentControl(SegmentControlOrBuilder event);
}
