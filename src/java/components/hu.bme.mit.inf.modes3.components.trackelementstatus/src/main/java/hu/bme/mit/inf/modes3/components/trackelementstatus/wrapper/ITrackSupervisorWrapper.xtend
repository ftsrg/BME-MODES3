package hu.bme.mit.inf.modes3.components.trackelementstatus.wrapper

interface ITrackSupervisorWrapper {
	def void sendSegmentStatusMessage(int id, String status)
	def void sendTurnoutStatusMessage(int id, String status)
}