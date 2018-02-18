package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge.ISafetyLogicBridge

interface ISafetyLogic extends Runnable {
	def void setSafetyLogicBridge(ISafetyLogicBridge safetyLogicBridge)
}