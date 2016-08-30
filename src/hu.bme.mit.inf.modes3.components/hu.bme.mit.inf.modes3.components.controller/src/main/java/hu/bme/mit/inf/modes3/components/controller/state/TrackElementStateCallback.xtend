package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent

class TrackElementStateCallback extends ProtobufAbstractComponent{
	var ISegmentStateListener segmentStateListener
	var ITurnoutStateListener turnoutStateListener

	new(ISegmentStateListener segmentStateListener, ITurnoutStateListener turnoutStateListener) {
		this.segmentStateListener = segmentStateListener
		this.turnoutStateListener = turnoutStateListener
	}

	override onInit() {
		val segmentStateClient = new SegmentStateClient(this)
		val turnoutStateClient = new TurnoutStateClient(this)

		dispatcher.segmentStateHandler = segmentStateClient
		dispatcher.turnoutStateHandler = turnoutStateClient
	}
	
	def onSegmentState(int id, SegmentStateValue state){
		segmentStateListener.onSegmentState(id, state)
	}
	
	def onTurnoutState(int id, TurnoutStateValue state){
		turnoutStateListener.onTurnoutState(id, state)
	}
}
