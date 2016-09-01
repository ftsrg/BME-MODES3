package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState

interface ISegmentStateListener {
	def void onSegmentState(int id, SegmentState state);
}
