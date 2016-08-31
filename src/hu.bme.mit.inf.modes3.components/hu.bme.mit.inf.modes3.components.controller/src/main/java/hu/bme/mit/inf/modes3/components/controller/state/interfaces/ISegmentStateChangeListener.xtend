package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState

interface ISegmentStateChangeListener {
	def void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue);
}
