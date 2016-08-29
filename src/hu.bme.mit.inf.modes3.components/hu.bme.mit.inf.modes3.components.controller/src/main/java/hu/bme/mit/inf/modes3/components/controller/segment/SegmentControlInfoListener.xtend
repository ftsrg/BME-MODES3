package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

interface SegmentControlInfoListener {
	def void onSegmentControlInfo(int id, SegmentStateValue state) 
}