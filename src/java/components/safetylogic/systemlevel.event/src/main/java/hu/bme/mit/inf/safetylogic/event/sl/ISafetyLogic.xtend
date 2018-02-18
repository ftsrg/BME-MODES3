package hu.bme.mit.inf.safetylogic.event.sl

import hu.bme.mit.inf.safetylogic.event.bridge.ISafetyLogicBridge

interface ISafetyLogic extends Runnable{
	def void setSafetyLogicBridge(ISafetyLogicBridge safetyLogicBridge)
}
