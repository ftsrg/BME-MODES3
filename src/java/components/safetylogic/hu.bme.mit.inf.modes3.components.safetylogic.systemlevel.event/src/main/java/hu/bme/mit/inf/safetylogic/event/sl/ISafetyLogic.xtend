package hu.bme.mit.inf.safetylogic.event.sl

import hu.bme.mit.inf.safetylogic.event.wrapper.ISafetyLogicWrapper

interface ISafetyLogic extends Runnable{
	def void setSafetyLogicWrapper(ISafetyLogicWrapper safetyLogicWrapper)
}
