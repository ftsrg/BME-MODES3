package hu.bme.mit.inf.modes3.components.barrier.bridge

/**
 * The bridge between the barrier application and the communication network.
 * 
 * @author benedekh
 */
interface ITrackSupervisorBridge {
	/**
	 * Send a barrier message over the communication network.
	 * 
	 * @param barrierState the state of the barrier
	 */
	def void sendBarrierMessage(String barrierState)
}