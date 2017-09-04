package hu.bme.mit.inf.modes3.messaging.communication.command.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

interface ISegmentCommandListener {
	def void onSegmentCommand(int id, SegmentState state) 
}
