package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

class TrackElementCommandCallback extends AbstractComponent {
	var ISegmentCommandListener segmentCommandListener
	var ITurnoutCommandListener turnoutCommandListener

	new(ISegmentCommandListener segmentCommandListener, ITurnoutCommandListener turnoutCommandListener) {
		this.segmentCommandListener = segmentCommandListener
		this.turnoutCommandListener = turnoutCommandListener
	}

	override init() {
		val dispatcher = new ProtobufMessageDispatcher
		val segmentCommandListener = new SegmentCommandClient(this)
		val turnoutCommandListener = new TurnoutCommandClient(this)

		dispatcher.segmentCommandHandler = segmentCommandListener
		dispatcher.turnoutCommandHandler = turnoutCommandListener
		super.dispatcher = dispatcher
	}

	def onSegmentCommand(int id, SegmentStateValue state) {
		segmentCommandListener.onSegmentCommand(id, state)
	}

	def onTurnoutCommand(int id, TurnoutStateValue state) {
		turnoutCommandListener.onTurnoutCommand(id, state)
	}

}
