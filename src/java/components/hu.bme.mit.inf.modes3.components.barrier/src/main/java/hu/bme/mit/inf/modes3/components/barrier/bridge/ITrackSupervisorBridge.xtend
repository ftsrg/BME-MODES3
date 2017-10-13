package hu.bme.mit.inf.modes3.components.barrier.bridge

interface ITrackSupervisorBridge {
	def void sendBarrierMessage(String barrierState)
}