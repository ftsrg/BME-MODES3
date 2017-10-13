package hu.bme.mit.inf.modes3.components.touchboard.controller

import hu.bme.mit.inf.modes3.components.touchboard.bridge.ITouchboardBridge
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITouchboardController extends Runnable{
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)

	def void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue)

	def void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue)

	def void setTouchboardBridge(ITouchboardBridge touchboardBridge)
}
