package hu.bme.mit.inf.modes3.components.controller.command.interfaces

interface ITrackElementCommandCallback {
	def void setSegmentCommandListener(ISegmentCommandListener listener)
	def void setTurnoutCommandListener(ITurnoutCommandListener listener)
}