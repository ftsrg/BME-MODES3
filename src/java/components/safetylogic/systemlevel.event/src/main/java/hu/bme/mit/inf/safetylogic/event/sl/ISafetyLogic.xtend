package hu.bme.mit.inf.safetylogic.event.sl

import hu.bme.mit.inf.safetylogic.event.bridge.ISafetyLogicBridge

/**
 * The interface of the application.
 * 
 * @author benedekh
 */
interface ISafetyLogic extends Runnable{
	/**
	 * To register the bridge that connects the system-level safety logic application to the communication network.
	 * 
	 * @param safetyLogicBridge the bridge to the communication network
	 */
	def void setSafetyLogicBridge(ISafetyLogicBridge safetyLogicBridge)
}
