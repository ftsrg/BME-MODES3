package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge.ISafetyLogicBridge
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SafetyLogic implements ISafetyLogic {

	@Accessors(PUBLIC_SETTER) var ISafetyLogicBridge safetyLogicBridge
	val Logger logger

	new(int turnoutID, ILoggerFactory factory) {
		this.logger = factory.getLogger(class.name)
	}

	override run() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
