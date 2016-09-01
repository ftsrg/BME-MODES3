package hu.bme.mit.inf.modes3.components.controller.command.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState

interface ISegmentCommandListener {
	def void onSegmentCommand(int id, SegmentState state) 
}
