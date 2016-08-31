package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITurnoutStateListener

class TrackElementStateCallback extends ProtobufAbstractComponent{
	var ISegmentStateListener segmentStateListener
	var ITurnoutStateListener turnoutStateListener
	var ISegmentOccupancyListener segmentOccupancyListener

	new(ISegmentStateListener segmentStateListener, ITurnoutStateListener turnoutStateListener, ISegmentOccupancyListener segmentOccupancyListener) {
		this.segmentStateListener = segmentStateListener
		this.turnoutStateListener = turnoutStateListener
		this.segmentOccupancyListener = segmentOccupancyListener
	}

	override onInit() {
		val segmentStateClient = new SegmentStateClient(this)
		val turnoutStateClient = new TurnoutStateClient(this)
		val segmentOccupancyClient = new SegmentOccupancyClient(this)

		dispatcher.segmentStateHandler = segmentStateClient
		dispatcher.turnoutStateHandler = turnoutStateClient
		dispatcher.segmentOccupancyHandler = segmentOccupancyClient
	}
	
	def onSegmentState(int id, SegmentState state){
		segmentStateListener.onSegmentState(id, state)
	}
	
	def onTurnoutState(int id, TurnoutState state){
		turnoutStateListener.onTurnoutState(id, state)
	}
	
	def onSegmentOccupancy(int id, SegmentOccupancy state){
		segmentOccupancyListener.onSegmentOccupancy(id, state)
	}
}
