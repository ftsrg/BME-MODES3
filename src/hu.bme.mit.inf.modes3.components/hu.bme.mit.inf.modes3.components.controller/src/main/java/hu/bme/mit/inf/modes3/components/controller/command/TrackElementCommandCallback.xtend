package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import org.eclipse.xtend.lib.annotations.Accessors

class TrackElementCommandCallback extends ProtobufAbstractComponent {
	@Accessors(PUBLIC_SETTER) var  ISegmentCommandListener segmentCommandListener
	@Accessors(PUBLIC_SETTER) var ITurnoutCommandListener turnoutCommandListener

	override onInit() {
		val segmentCommandListener = new SegmentCommandClient(this) 
		val turnoutCommandListener = new TurnoutCommandClient(this)

		dispatcher.segmentCommandHandler = segmentCommandListener
		dispatcher.turnoutCommandHandler = turnoutCommandListener
	}

	def onSegmentCommand(int id, SegmentStateValue state) {
		segmentCommandListener?.onSegmentCommand(id, state)
	}

	def onTurnoutCommand(int id, TurnoutStateValue state) {
		turnoutCommandListener?.onTurnoutCommand(id, state)
	}

}
