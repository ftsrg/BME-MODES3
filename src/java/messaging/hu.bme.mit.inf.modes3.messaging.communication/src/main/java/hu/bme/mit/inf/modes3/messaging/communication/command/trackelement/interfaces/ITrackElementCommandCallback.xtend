package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

interface ITrackElementCommandCallback {
	def void setSegmentCommandListener(ISegmentCommandListener listener)
	def void setTurnoutCommandListener(ITurnoutCommandListener listener)
}
